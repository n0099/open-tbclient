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
/* loaded from: classes8.dex */
public class r extends ProxyAdkBaseActivity<r> {
    private FaceBuyModel iWN;
    private t iXI;
    private FaceShopModel iXJ;
    private final HashMap<String, DownloadData> map = new HashMap<>();
    private final NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.faceshop.r.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && r.this.iXI != null) {
                r.this.iXI.czD();
            }
        }
    };
    private final com.baidu.adp.base.e mLoadDataCallBack = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.r.4
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            r.this.hideProgressBar();
            if (obj != null && (obj instanceof FaceShopData)) {
                if (r.this.iXI != null) {
                    FaceShopData faceShopData = (FaceShopData) obj;
                    if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                        if (r.this.iXJ.getHasMore()) {
                            r.this.iXI.czG();
                        } else {
                            r.this.iXI.czF();
                        }
                        r.this.iXI.c(faceShopData);
                        return;
                    }
                    if (faceShopData.usermsg != null) {
                        r.this.showToast(faceShopData.usermsg);
                    } else {
                        r.this.showToast(R.string.neterror);
                    }
                    r.this.iXI.czy();
                    return;
                }
                return;
            }
            r.this.showToast(R.string.neterror);
            r.this.iXI.czy();
        }
    };
    private final CustomMessageListener eLa = new CustomMessageListener(0) { // from class: com.baidu.tieba.faceshop.r.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FaceShopData czB;
            s czC;
            if (r.this.iXJ != null && r.this.iXI != null && (czB = r.this.iXJ.czB()) != null && czB.pack_list != null) {
                if (customResponsedMessage.getCmd() == 2001118) {
                    if (customResponsedMessage instanceof DownloadMessage) {
                        r.this.map.clear();
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        if (data != null && (czC = r.this.iXI.czC()) != null) {
                            for (DownloadData downloadData : data) {
                                r.this.map.put(downloadData.getId(), downloadData);
                            }
                            Iterator<FacePackageData> it = czB.pack_list.iterator();
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
                                        czC.onDestroy();
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
                            czC.a(czB);
                        }
                    }
                } else if (customResponsedMessage.getCmd() == 2001117) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    Iterator<FacePackageData> it2 = czB.pack_list.iterator();
                    while (it2.hasNext()) {
                        FacePackageData next2 = it2.next();
                        if (next2.downloaded == 1) {
                            next2.downloaded = 0;
                        }
                        arrayList.add(String.valueOf(next2.pid));
                    }
                    r.this.iXI.an(arrayList);
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
        this.iXI.czD();
    }

    private void initUI() {
        this.iXI = new t(getPageContext());
        this.iXI.a(new f.c() { // from class: com.baidu.tieba.faceshop.r.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                r.this.qj(false);
            }
        });
        this.iXI.a(new BdListView.e() { // from class: com.baidu.tieba.faceshop.r.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                r.this.czz();
            }
        });
        this.iXI.a(this);
        cyW();
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eLa);
        registerListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED, this.eLa);
        f.cyE();
    }

    private void initData(Bundle bundle) {
        String st_type;
        this.iXJ = new FaceShopModel(this);
        if (bundle != null) {
            st_type = FaceShopActivityConfig.getST_TYPE(bundle);
        } else {
            st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
            TiebaStatic.log(st_type);
        }
        this.iXJ.JY(st_type);
        this.iXJ.setLoadDataCallBack(this.mLoadDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(boolean z) {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (z) {
                showProgressBar();
            }
            this.iXJ.loadData(1);
            return;
        }
        this.iXI.czy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czz() {
        if (this.iXJ != null && this.iXI != null && this.iXJ.getHasMore()) {
            this.iXI.czE();
            this.iXJ.loadData(2);
        }
    }

    private void cyW() {
        this.iXI.c(this.gzW);
    }

    private void cyX() {
        this.iXI.d(this.gzW);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        s czC;
        FacePackageData facePackageData;
        if (this.iXJ != null && this.iXI != null && (czC = this.iXI.czC()) != null) {
            if (i < czC.getCount() && i >= 0 && (facePackageData = (FacePackageData) czC.getItem(i)) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iXI != null) {
            if (view == this.iXI.czH()) {
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
        if (this.iXJ != null) {
            this.iXJ.cancelLoadData();
        }
        if (this.iXI != null) {
            this.iXI.czC().onDestroy();
        }
        if (this.iWN != null) {
            this.iWN.cancelLoadData();
        }
        cyX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (this.iXI != null) {
            this.iXI.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iXI != null) {
            this.iXI.onChangeSkinType(i);
        }
    }

    public void ya(int i) {
        FacePackageData facePackageData;
        if (this.iXI != null && this.iXI.czC() != null && (facePackageData = (FacePackageData) this.iXI.czC().getItem(i)) != null) {
            this.iXI.czo();
            facePackageData.buy_status = 1;
            facePackageData.can_download = 1;
            this.iXI.czC().notifyDataSetChanged();
            this.iXI.czC().yb(i);
        }
    }

    public void czb() {
        this.iXI.czn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.iXI != null && this.iXI.czC() != null) {
            if (i == 10000) {
                final int intExtra = intent.getIntExtra("tag_position", -1);
                String stringExtra = intent.getStringExtra("tag_order_id");
                FacePackageData facePackageData = (FacePackageData) this.iXI.czC().getItem(intExtra);
                if (facePackageData != null) {
                    String str = au.isEmpty(stringExtra) ? facePackageData.orderId : stringExtra;
                    this.iXI.czm();
                    this.iWN = new FaceBuyModel(getActivity());
                    this.iWN.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.r.5
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                                    if (faceBuyQueryData.buy_result.status == 2) {
                                        r.this.ya(intExtra);
                                        return;
                                    } else {
                                        r.this.czb();
                                        return;
                                    }
                                }
                                r.this.czb();
                                return;
                            }
                            r.this.czb();
                        }
                    });
                    this.iWN.JS(str);
                }
            } else if (i == 11003) {
                s czC = this.iXI.czC();
                int czA = czC.czA();
                if (czA >= 0) {
                    if (((FacePackageData) czC.getItem(czA)).can_download == 1) {
                        czC.yb(czA);
                    } else {
                        czC.yd(czA);
                    }
                }
            } else if (i == 11037) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONMANAGE, new IntentConfig(getActivity())));
            }
        }
    }
}
