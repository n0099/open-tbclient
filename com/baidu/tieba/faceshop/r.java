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
import com.baidu.tbadk.core.util.at;
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
    private FaceBuyModel iPj;
    private t iQe;
    private FaceShopModel iQf;
    private final HashMap<String, DownloadData> map = new HashMap<>();
    private final NoNetworkView.a gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.faceshop.r.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && r.this.iQe != null) {
                r.this.iQe.cyf();
            }
        }
    };
    private final com.baidu.adp.base.e mLoadDataCallBack = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.r.4
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            r.this.hideProgressBar();
            if (obj != null && (obj instanceof FaceShopData)) {
                if (r.this.iQe != null) {
                    FaceShopData faceShopData = (FaceShopData) obj;
                    if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                        if (r.this.iQf.getHasMore()) {
                            r.this.iQe.cyi();
                        } else {
                            r.this.iQe.cyh();
                        }
                        r.this.iQe.c(faceShopData);
                        return;
                    }
                    if (faceShopData.usermsg != null) {
                        r.this.showToast(faceShopData.usermsg);
                    } else {
                        r.this.showToast(R.string.neterror);
                    }
                    r.this.iQe.cya();
                    return;
                }
                return;
            }
            r.this.showToast(R.string.neterror);
            r.this.iQe.cya();
        }
    };
    private final CustomMessageListener eHt = new CustomMessageListener(0) { // from class: com.baidu.tieba.faceshop.r.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FaceShopData cyd;
            s cye;
            if (r.this.iQf != null && r.this.iQe != null && (cyd = r.this.iQf.cyd()) != null && cyd.pack_list != null) {
                if (customResponsedMessage.getCmd() == 2001118) {
                    if (customResponsedMessage instanceof DownloadMessage) {
                        r.this.map.clear();
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        if (data != null && (cye = r.this.iQe.cye()) != null) {
                            for (DownloadData downloadData : data) {
                                r.this.map.put(downloadData.getId(), downloadData);
                            }
                            Iterator<FacePackageData> it = cyd.pack_list.iterator();
                            while (it.hasNext()) {
                                FacePackageData next = it.next();
                                DownloadData downloadData2 = (DownloadData) r.this.map.get(String.valueOf(next.pid));
                                if (downloadData2 != null) {
                                    int status = downloadData2.getStatus();
                                    if (status == 3 || status == 0) {
                                        next.downloaded = 1;
                                        next.downloading = 0;
                                    } else if (status == 2 || status == 4) {
                                        if (!at.isEmpty(downloadData2.getStatusMsg())) {
                                            r.this.showToast(downloadData2.getStatusMsg());
                                        }
                                        cye.onDestroy();
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
                            cye.a(cyd);
                        }
                    }
                } else if (customResponsedMessage.getCmd() == 2001117) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    Iterator<FacePackageData> it2 = cyd.pack_list.iterator();
                    while (it2.hasNext()) {
                        FacePackageData next2 = it2.next();
                        if (next2.downloaded == 1) {
                            next2.downloaded = 0;
                        }
                        arrayList.add(String.valueOf(next2.pid));
                    }
                    r.this.iQe.ao(arrayList);
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
        this.iQe.cyf();
    }

    private void initUI() {
        this.iQe = new t(getPageContext());
        this.iQe.a(new f.c() { // from class: com.baidu.tieba.faceshop.r.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                r.this.pZ(false);
            }
        });
        this.iQe.a(new BdListView.e() { // from class: com.baidu.tieba.faceshop.r.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                r.this.cyb();
            }
        });
        this.iQe.a(this);
        cxy();
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eHt);
        registerListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED, this.eHt);
        f.cxg();
    }

    private void initData(Bundle bundle) {
        String st_type;
        this.iQf = new FaceShopModel(this);
        if (bundle != null) {
            st_type = FaceShopActivityConfig.getST_TYPE(bundle);
        } else {
            st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
            TiebaStatic.log(st_type);
        }
        this.iQf.Jd(st_type);
        this.iQf.setLoadDataCallBack(this.mLoadDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(boolean z) {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (z) {
                showProgressBar();
            }
            this.iQf.loadData(1);
            return;
        }
        this.iQe.cya();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyb() {
        if (this.iQf != null && this.iQe != null && this.iQf.getHasMore()) {
            this.iQe.cyg();
            this.iQf.loadData(2);
        }
    }

    private void cxy() {
        this.iQe.c(this.gvp);
    }

    private void cxz() {
        this.iQe.d(this.gvp);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        s cye;
        FacePackageData facePackageData;
        if (this.iQf != null && this.iQe != null && (cye = this.iQe.cye()) != null) {
            if (i < cye.getCount() && i >= 0 && (facePackageData = (FacePackageData) cye.getItem(i)) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iQe != null) {
            if (view == this.iQe.cyj()) {
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
        if (this.iQf != null) {
            this.iQf.cancelLoadData();
        }
        if (this.iQe != null) {
            this.iQe.cye().onDestroy();
        }
        if (this.iPj != null) {
            this.iPj.cancelLoadData();
        }
        cxz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (this.iQe != null) {
            this.iQe.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iQe != null) {
            this.iQe.onChangeSkinType(i);
        }
    }

    public void xP(int i) {
        FacePackageData facePackageData;
        if (this.iQe != null && this.iQe.cye() != null && (facePackageData = (FacePackageData) this.iQe.cye().getItem(i)) != null) {
            this.iQe.cxQ();
            facePackageData.buy_status = 1;
            facePackageData.can_download = 1;
            this.iQe.cye().notifyDataSetChanged();
            this.iQe.cye().xQ(i);
        }
    }

    public void cxD() {
        this.iQe.cxP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.iQe != null && this.iQe.cye() != null) {
            if (i == 10000) {
                final int intExtra = intent.getIntExtra("tag_position", -1);
                String stringExtra = intent.getStringExtra("tag_order_id");
                FacePackageData facePackageData = (FacePackageData) this.iQe.cye().getItem(intExtra);
                if (facePackageData != null) {
                    String str = at.isEmpty(stringExtra) ? facePackageData.orderId : stringExtra;
                    this.iQe.cxO();
                    this.iPj = new FaceBuyModel(getActivity());
                    this.iPj.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.r.5
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                                    if (faceBuyQueryData.buy_result.status == 2) {
                                        r.this.xP(intExtra);
                                        return;
                                    } else {
                                        r.this.cxD();
                                        return;
                                    }
                                }
                                r.this.cxD();
                                return;
                            }
                            r.this.cxD();
                        }
                    });
                    this.iPj.IX(str);
                }
            } else if (i == 11003) {
                s cye = this.iQe.cye();
                int cyc = cye.cyc();
                if (cyc >= 0) {
                    if (((FacePackageData) cye.getItem(cyc)).can_download == 1) {
                        cye.xQ(cyc);
                    } else {
                        cye.xS(cyc);
                    }
                }
            } else if (i == 11037) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONMANAGE, new IntentConfig(getActivity())));
            }
        }
    }
}
