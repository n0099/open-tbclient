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
    private t iVZ;
    private FaceBuyModel iVe;
    private FaceShopModel iWa;
    private final HashMap<String, DownloadData> map = new HashMap<>();
    private final NoNetworkView.a gyn = new NoNetworkView.a() { // from class: com.baidu.tieba.faceshop.r.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && r.this.iVZ != null) {
                r.this.iVZ.czx();
            }
        }
    };
    private final com.baidu.adp.base.e mLoadDataCallBack = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.r.4
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            r.this.hideProgressBar();
            if (obj != null && (obj instanceof FaceShopData)) {
                if (r.this.iVZ != null) {
                    FaceShopData faceShopData = (FaceShopData) obj;
                    if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                        if (r.this.iWa.getHasMore()) {
                            r.this.iVZ.czA();
                        } else {
                            r.this.iVZ.czz();
                        }
                        r.this.iVZ.c(faceShopData);
                        return;
                    }
                    if (faceShopData.usermsg != null) {
                        r.this.showToast(faceShopData.usermsg);
                    } else {
                        r.this.showToast(R.string.neterror);
                    }
                    r.this.iVZ.czs();
                    return;
                }
                return;
            }
            r.this.showToast(R.string.neterror);
            r.this.iVZ.czs();
        }
    };
    private final CustomMessageListener eJz = new CustomMessageListener(0) { // from class: com.baidu.tieba.faceshop.r.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FaceShopData czv;
            s czw;
            if (r.this.iWa != null && r.this.iVZ != null && (czv = r.this.iWa.czv()) != null && czv.pack_list != null) {
                if (customResponsedMessage.getCmd() == 2001118) {
                    if (customResponsedMessage instanceof DownloadMessage) {
                        r.this.map.clear();
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        if (data != null && (czw = r.this.iVZ.czw()) != null) {
                            for (DownloadData downloadData : data) {
                                r.this.map.put(downloadData.getId(), downloadData);
                            }
                            Iterator<FacePackageData> it = czv.pack_list.iterator();
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
                                        czw.onDestroy();
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
                            czw.a(czv);
                        }
                    }
                } else if (customResponsedMessage.getCmd() == 2001117) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    Iterator<FacePackageData> it2 = czv.pack_list.iterator();
                    while (it2.hasNext()) {
                        FacePackageData next2 = it2.next();
                        if (next2.downloaded == 1) {
                            next2.downloaded = 0;
                        }
                        arrayList.add(String.valueOf(next2.pid));
                    }
                    r.this.iVZ.an(arrayList);
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
        this.iVZ.czx();
    }

    private void initUI() {
        this.iVZ = new t(getPageContext());
        this.iVZ.a(new f.c() { // from class: com.baidu.tieba.faceshop.r.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                r.this.qj(false);
            }
        });
        this.iVZ.a(new BdListView.e() { // from class: com.baidu.tieba.faceshop.r.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                r.this.czt();
            }
        });
        this.iVZ.a(this);
        cyQ();
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eJz);
        registerListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED, this.eJz);
        f.cyy();
    }

    private void initData(Bundle bundle) {
        String st_type;
        this.iWa = new FaceShopModel(this);
        if (bundle != null) {
            st_type = FaceShopActivityConfig.getST_TYPE(bundle);
        } else {
            st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
            TiebaStatic.log(st_type);
        }
        this.iWa.JP(st_type);
        this.iWa.setLoadDataCallBack(this.mLoadDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(boolean z) {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (z) {
                showProgressBar();
            }
            this.iWa.loadData(1);
            return;
        }
        this.iVZ.czs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czt() {
        if (this.iWa != null && this.iVZ != null && this.iWa.getHasMore()) {
            this.iVZ.czy();
            this.iWa.loadData(2);
        }
    }

    private void cyQ() {
        this.iVZ.c(this.gyn);
    }

    private void cyR() {
        this.iVZ.d(this.gyn);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        s czw;
        FacePackageData facePackageData;
        if (this.iWa != null && this.iVZ != null && (czw = this.iVZ.czw()) != null) {
            if (i < czw.getCount() && i >= 0 && (facePackageData = (FacePackageData) czw.getItem(i)) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iVZ != null) {
            if (view == this.iVZ.czB()) {
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
        if (this.iWa != null) {
            this.iWa.cancelLoadData();
        }
        if (this.iVZ != null) {
            this.iVZ.czw().onDestroy();
        }
        if (this.iVe != null) {
            this.iVe.cancelLoadData();
        }
        cyR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (this.iVZ != null) {
            this.iVZ.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iVZ != null) {
            this.iVZ.onChangeSkinType(i);
        }
    }

    public void xZ(int i) {
        FacePackageData facePackageData;
        if (this.iVZ != null && this.iVZ.czw() != null && (facePackageData = (FacePackageData) this.iVZ.czw().getItem(i)) != null) {
            this.iVZ.czi();
            facePackageData.buy_status = 1;
            facePackageData.can_download = 1;
            this.iVZ.czw().notifyDataSetChanged();
            this.iVZ.czw().ya(i);
        }
    }

    public void cyV() {
        this.iVZ.czh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.iVZ != null && this.iVZ.czw() != null) {
            if (i == 10000) {
                final int intExtra = intent.getIntExtra("tag_position", -1);
                String stringExtra = intent.getStringExtra("tag_order_id");
                FacePackageData facePackageData = (FacePackageData) this.iVZ.czw().getItem(intExtra);
                if (facePackageData != null) {
                    String str = au.isEmpty(stringExtra) ? facePackageData.orderId : stringExtra;
                    this.iVZ.czg();
                    this.iVe = new FaceBuyModel(getActivity());
                    this.iVe.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.r.5
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                                    if (faceBuyQueryData.buy_result.status == 2) {
                                        r.this.xZ(intExtra);
                                        return;
                                    } else {
                                        r.this.cyV();
                                        return;
                                    }
                                }
                                r.this.cyV();
                                return;
                            }
                            r.this.cyV();
                        }
                    });
                    this.iVe.JJ(str);
                }
            } else if (i == 11003) {
                s czw = this.iVZ.czw();
                int czu = czw.czu();
                if (czu >= 0) {
                    if (((FacePackageData) czw.getItem(czu)).can_download == 1) {
                        czw.ya(czu);
                    } else {
                        czw.yc(czu);
                    }
                }
            } else if (i == 11037) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONMANAGE, new IntentConfig(getActivity())));
            }
        }
    }
}
