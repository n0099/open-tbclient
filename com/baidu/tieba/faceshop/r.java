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
/* loaded from: classes9.dex */
public class r extends ProxyAdkBaseActivity<r> {
    private FaceBuyModel iTQ;
    private t iUL;
    private FaceShopModel iUM;
    private final HashMap<String, DownloadData> map = new HashMap<>();
    private final NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.faceshop.r.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z && r.this.iUL != null) {
                r.this.iUL.cBX();
            }
        }
    };
    private final com.baidu.adp.base.e mLoadDataCallBack = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.r.4
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            r.this.hideProgressBar();
            if (obj != null && (obj instanceof FaceShopData)) {
                if (r.this.iUL != null) {
                    FaceShopData faceShopData = (FaceShopData) obj;
                    if (faceShopData.errno == 0 && faceShopData.usermsg != null) {
                        if (r.this.iUM.getHasMore()) {
                            r.this.iUL.cCa();
                        } else {
                            r.this.iUL.cBZ();
                        }
                        r.this.iUL.c(faceShopData);
                        return;
                    }
                    if (faceShopData.usermsg != null) {
                        r.this.showToast(faceShopData.usermsg);
                    } else {
                        r.this.showToast(R.string.neterror);
                    }
                    r.this.iUL.cBS();
                    return;
                }
                return;
            }
            r.this.showToast(R.string.neterror);
            r.this.iUL.cBS();
        }
    };
    private final CustomMessageListener eMe = new CustomMessageListener(0) { // from class: com.baidu.tieba.faceshop.r.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FaceShopData cBV;
            s cBW;
            if (r.this.iUM != null && r.this.iUL != null && (cBV = r.this.iUM.cBV()) != null && cBV.pack_list != null) {
                if (customResponsedMessage.getCmd() == 2001118) {
                    if (customResponsedMessage instanceof DownloadMessage) {
                        r.this.map.clear();
                        List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                        if (data != null && (cBW = r.this.iUL.cBW()) != null) {
                            for (DownloadData downloadData : data) {
                                r.this.map.put(downloadData.getId(), downloadData);
                            }
                            Iterator<FacePackageData> it = cBV.pack_list.iterator();
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
                                        cBW.onDestroy();
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
                            cBW.a(cBV);
                        }
                    }
                } else if (customResponsedMessage.getCmd() == 2001117) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    Iterator<FacePackageData> it2 = cBV.pack_list.iterator();
                    while (it2.hasNext()) {
                        FacePackageData next2 = it2.next();
                        if (next2.downloaded == 1) {
                            next2.downloaded = 0;
                        }
                        arrayList.add(String.valueOf(next2.pid));
                    }
                    r.this.iUL.at(arrayList);
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
        this.iUL.cBX();
    }

    private void initUI() {
        this.iUL = new t(getPageContext());
        this.iUL.a(new f.c() { // from class: com.baidu.tieba.faceshop.r.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                r.this.qd(false);
            }
        });
        this.iUL.a(new BdListView.e() { // from class: com.baidu.tieba.faceshop.r.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                r.this.cBT();
            }
        });
        this.iUL.a(this);
        cBq();
        registerListener(CmdConfigCustom.CMD_FILE_DOWNLOAD, this.eMe);
        registerListener(CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED, this.eMe);
        f.cAY();
    }

    private void initData(Bundle bundle) {
        String st_type;
        this.iUM = new FaceShopModel(this);
        if (bundle != null) {
            st_type = FaceShopActivityConfig.getST_TYPE(bundle);
        } else {
            st_type = FaceShopActivityConfig.getST_TYPE(getIntent());
            TiebaStatic.log(st_type);
        }
        this.iUM.Ko(st_type);
        this.iUM.setLoadDataCallBack(this.mLoadDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd(boolean z) {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (z) {
                showProgressBar();
            }
            this.iUM.loadData(1);
            return;
        }
        this.iUL.cBS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBT() {
        if (this.iUM != null && this.iUL != null && this.iUM.getHasMore()) {
            this.iUL.cBY();
            this.iUM.loadData(2);
        }
    }

    private void cBq() {
        this.iUL.c(this.gzW);
    }

    private void cBr() {
        this.iUL.d(this.gzW);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        s cBW;
        FacePackageData facePackageData;
        if (this.iUM != null && this.iUL != null && (cBW = this.iUL.cBW()) != null) {
            if (i < cBW.getCount() && i >= 0 && (facePackageData = (FacePackageData) cBW.getItem(i)) != null) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePackageData.pid), facePackageData.downloading == 1, "face_shop")));
            }
            super.onItemClick(adapterView, view, i, j);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iUL != null) {
            if (view == this.iUL.cCb()) {
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
        if (this.iUM != null) {
            this.iUM.cancelLoadData();
        }
        if (this.iUL != null) {
            this.iUL.cBW().onDestroy();
        }
        if (this.iTQ != null) {
            this.iTQ.cancelLoadData();
        }
        cBr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (this.iUL != null) {
            this.iUL.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iUL != null) {
            this.iUL.onChangeSkinType(i);
        }
    }

    public void zv(int i) {
        FacePackageData facePackageData;
        if (this.iUL != null && this.iUL.cBW() != null && (facePackageData = (FacePackageData) this.iUL.cBW().getItem(i)) != null) {
            this.iUL.cBI();
            facePackageData.buy_status = 1;
            facePackageData.can_download = 1;
            this.iUL.cBW().notifyDataSetChanged();
            this.iUL.cBW().zw(i);
        }
    }

    public void cBv() {
        this.iUL.cBH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && this.iUL != null && this.iUL.cBW() != null) {
            if (i == 10000) {
                final int intExtra = intent.getIntExtra("tag_position", -1);
                String stringExtra = intent.getStringExtra("tag_order_id");
                FacePackageData facePackageData = (FacePackageData) this.iUL.cBW().getItem(intExtra);
                if (facePackageData != null) {
                    String str = at.isEmpty(stringExtra) ? facePackageData.orderId : stringExtra;
                    this.iUL.cBG();
                    this.iTQ = new FaceBuyModel(getActivity());
                    this.iTQ.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.r.5
                        @Override // com.baidu.adp.base.e
                        public void callback(Object obj) {
                            if (obj != null && (obj instanceof FaceBuyQueryData)) {
                                FaceBuyQueryData faceBuyQueryData = (FaceBuyQueryData) obj;
                                if (faceBuyQueryData.errno == 0 && faceBuyQueryData.usermsg != null) {
                                    if (faceBuyQueryData.buy_result.status == 2) {
                                        r.this.zv(intExtra);
                                        return;
                                    } else {
                                        r.this.cBv();
                                        return;
                                    }
                                }
                                r.this.cBv();
                                return;
                            }
                            r.this.cBv();
                        }
                    });
                    this.iTQ.Ki(str);
                }
            } else if (i == 11003) {
                s cBW = this.iUL.cBW();
                int cBU = cBW.cBU();
                if (cBU >= 0) {
                    if (((FacePackageData) cBW.getItem(cBU)).can_download == 1) {
                        cBW.zw(cBU);
                    } else {
                        cBW.zy(cBU);
                    }
                }
            } else if (i == 11037) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONMANAGE, new IntentConfig(getActivity())));
            }
        }
    }
}
