package com.baidu.tieba.faceshop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class o extends ProxyAdkBaseActivity<o> {
    private q iUA;
    private FacePurchaseRecordsModel iUB;
    private String mStType;
    private com.baidu.adp.base.e mLoadDataCallBack = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.faceshop.o.2
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            o.this.hideProgressBar();
            if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
                if (o.this.iUA != null) {
                    FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                    if (facePurchaseRecordsData.errno == 0) {
                        o.this.iUA.c(facePurchaseRecordsData);
                        return;
                    } else if (facePurchaseRecordsData.usermsg != null) {
                        o.this.showToast(facePurchaseRecordsData.usermsg);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            o.this.showToast(R.string.neterror);
        }
    };
    private NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.faceshop.o.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                o.this.qd(true);
            }
            o.this.iUA.qc(z);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        initUI();
        qd(true);
    }

    private void initUI() {
        this.iUA = new q(getPageContext());
        this.iUA.a(new f.c() { // from class: com.baidu.tieba.faceshop.o.1
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                o.this.qd(false);
            }
        });
        this.iUA.a(this);
        cBq();
    }

    private void initData(Bundle bundle) {
        this.iUB = new FacePurchaseRecordsModel(getActivity());
        if (bundle != null) {
            this.mStType = bundle.getString("st_type");
        } else {
            this.mStType = getIntent().getStringExtra("st_type");
        }
        this.iUB.setStType(this.mStType);
        this.iUB.setLoadDataCallBack(this.mLoadDataCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qd(boolean z) {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            if (z) {
                showProgressBar();
            }
            this.iUB.loadData();
            return;
        }
        this.iUA.cBS();
    }

    private void cBq() {
        this.iUA.c(this.gzW);
    }

    private void cBr() {
        this.iUA.d(this.gzW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("st_type", this.mStType);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        if (this.iUA != null) {
            this.iUA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        if (this.iUB != null) {
            this.iUB.cancelLoadData();
        }
        cBr();
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        FacePurchasePackageData facePurchasePackageData;
        if (this.iUA != null && this.iUA.cBR() != null && (facePurchasePackageData = (FacePurchasePackageData) this.iUA.cBR().getItem(i)) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePurchasePackageData.pid), false, "purchase_record")));
            super.onItemClick(adapterView, view, i, j);
        }
    }
}
