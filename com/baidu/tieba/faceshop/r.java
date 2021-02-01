package com.baidu.tieba.faceshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FaceShopActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class r extends ProxyAdkBaseActivity<r> {
    private FaceBuyModel iUQ;
    private t iVL;
    private FaceShopModel iVM;
    private final HashMap<String, DownloadData> map = new HashMap<>();
    private final NoNetworkView.a gxZ = new NoNetworkView.a() { // from class: com.baidu.tieba.faceshop.r.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && r.this.iVL != null) {
                r.this.iVL.czq();
            }
        }
    };
    private final com.baidu.adp.base.e mLoadDataCallBack = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.r.4
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            r.this.hideProgressBar();
            if (obj != null && (obj instanceof FaceShopData)) {
                if (r.this.iVL != null) {
                    FaceShopData faceShopData = (FaceShopData) obj;
                    if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                        if (r.this.iVM.getHasMore()) {
                            r.this.iVL.czt();
                        } else {
                            r.this.iVL.czs();
                        }
                        r.this.iVL.c(faceShopData);
                        return;
                    }
                    if (faceShopData.usermsg != null) {
                        r.this.showToast(faceShopData.usermsg);
                    } else {
                        r.this.showToast(R.string.neterror);
                    }
                    r.this.iVL.czl();
                    return;
                }
                return;
            }
            r.this.showToast(R.string.neterror);
            r.this.iVL.czl();
        }
    };
    private final CustomMessageListener eJz = new CustomMessageListener(0) { // from class: com.baidu.tieba.faceshop.r.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FaceShopData czo;
            s czp;
            if (r.this.iVM != null && r.this.iVL != null && (czo = r.this.iVM.czo()) != null && czo.pack_list != null) {
                if (customResponsedMessage.getCmd() == 2001118) {
                    if (customResponsedMessage instanceof DownloadMessage) {
                        r.this.map.clear();
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        if (data != null && (czp = r.this.iVL.czp()) != null) {
                            for (DownloadData downloadData : data) {
                                r.this.map.put(downloadData.getId(), downloadData);
                            }
                            Iterator<FacePackageData> it = czo.pack_list.iterator();
                            while (it.hasNext()) {
                                FacePackageData next = it.next();
                                DownloadData downloadData2 = (DownloadData) r.this.map.get(String.valueOf(next.pid));
                                if (downloadData2 != null) {
                                    int status = downloadData2.getStatus();
                                    if (status == 3 || status == 0) {
                                        next.downloaded = 1;
                                        next.downloading = 0;
                                    } else if (status == 2 || status == 4) {
                                        if (!au.isEmpty(downloadData2.getStatusMsg())) {
                                            r.this.showToast(downloadData2.getStatusMsg());
                                        }
                                        czp.onDestroy();
                                        next.downloaded = 0;
                                        next.downloading = 0;
                                    } else if (status == 1) {
                                        next.downloading = 1;
                                        next.downloaded = 0;
                                        next.downloadTotal = downloadData2.getSize();
                                        next.downloadNow = downloadData2.getLength();
                                    }
                                }
                            }
                            czp.a(czo);
                        }
                    }
                } else if (customResponsedMessage.getCmd() == 2001117) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    Iterator<FacePackageData> it2 = czo.pack_list.iterator();
                    while (it2.hasNext()) {
                        FacePackageData next2 = it2.next();
                        if (next2.downloaded == 1) {
                            next2.downloaded = 0;
                        }
                        arrayList.add(String.valueOf(next2.pid));
                    }
                    r.this.iVL.an(arrayList);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
        initData(bundle);
        this.iVL.czq();
    }

    private void initUI() {
        this.iVL = new t(getPageContext());
        this.iVL.a(new f.c() { // from class: com.baidu.tieba.faceshop.r.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                r.this.qj(false);
            }
        });
        this.iVL.a(new BdListView.e() { // from class: com.baidu.tieba.faceshop.r.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                r.this.czm();
            }
        });
        this.iVL.a(this);
        cyJ();
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eJz);
        registerListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED, this.eJz);
        f.cyr();
    }

    private void initData(Bundle bundle) {
        String st_type;
        this.iVM = new FaceShopModel(this);
        if (bundle != null) {
            st_type = FaceShopActivityConfig.getST_TYPE(bundle);
        } else {
            st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
            TiebaStatic.log(st_type);
        }
        this.iVM.JO(st_type);
        this.iVM.setLoadDataCallBack(this.mLoadDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(boolean z) {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (z) {
                showProgressBar();
            }
            this.iVM.loadData(1);
            return;
        }
        this.iVL.czl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czm() {
        if (this.iVM != null && this.iVL != null && this.iVM.getHasMore()) {
            this.iVL.czr();
            this.iVM.loadData(2);
        }
    }

    private void cyJ() {
        this.iVL.c(this.gxZ);
    }

    private void cyK() {
        this.iVL.d(this.gxZ);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        s czp;
        FacePackageData facePackageData;
        if (this.iVM != null && this.iVL != null && (czp = this.iVL.czp()) != null) {
            if (i < czp.getCount() && i >= 0 && (facePackageData = (FacePackageData) czp.getItem(i)) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iVL != null) {
            if (view == this.iVL.czu()) {
                if (!TbadkApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getActivity(), true, RequestResponseCode.REQUEST_LOGIN_EMOTION_MANAGER)));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONMANAGE, new IntentConfig(getActivity())));
            }
            super.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        if (this.iVM != null) {
            this.iVM.cancelLoadData();
        }
        if (this.iVL != null) {
            this.iVL.czp().onDestroy();
        }
        if (this.iUQ != null) {
            this.iUQ.cancelLoadData();
        }
        cyK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (this.iVL != null) {
            this.iVL.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iVL != null) {
            this.iVL.onChangeSkinType(i);
        }
    }

    public void xZ(int i) {
        FacePackageData facePackageData;
        if (this.iVL != null && this.iVL.czp() != null && (facePackageData = (FacePackageData) this.iVL.czp().getItem(i)) != null) {
            this.iVL.czb();
            facePackageData.buy_status = 1;
            facePackageData.can_download = 1;
            this.iVL.czp().notifyDataSetChanged();
            this.iVL.czp().ya(i);
        }
    }

    public void cyO() {
        this.iVL.cza();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.iVL != null && this.iVL.czp() != null) {
            if (i == 10000) {
                final int intExtra = intent.getIntExtra("tag_position", -1);
                String stringExtra = intent.getStringExtra("tag_order_id");
                FacePackageData facePackageData = (FacePackageData) this.iVL.czp().getItem(intExtra);
                if (facePackageData != null) {
                    String str = au.isEmpty(stringExtra) ? facePackageData.orderId : stringExtra;
                    this.iVL.cyZ();
                    this.iUQ = new FaceBuyModel(getActivity());
                    this.iUQ.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.r.5
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                                    if (faceBuyQueryData.buy_result.status == 2) {
                                        r.this.xZ(intExtra);
                                        return;
                                    } else {
                                        r.this.cyO();
                                        return;
                                    }
                                }
                                r.this.cyO();
                                return;
                            }
                            r.this.cyO();
                        }
                    });
                    this.iUQ.JI(str);
                }
            } else if (i == 11003) {
                s czp = this.iVL.czp();
                int czn = czp.czn();
                if (czn >= 0) {
                    if (((FacePackageData) czp.getItem(czn)).can_download == 1) {
                        czp.ya(czn);
                    } else {
                        czp.yc(czn);
                    }
                }
            } else if (i == 11037) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONMANAGE, new IntentConfig(getActivity())));
            }
        }
    }
}
