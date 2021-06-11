package com.baidu.tieba.faceshop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import d.a.c.a.e;
import d.a.c.e.p.j;
import d.a.m0.r.f0.f;
import d.a.n0.m0.l;
/* loaded from: classes4.dex */
public class FacePurchaseRecordsActivity extends ProxyAdkBaseActivity<FacePurchaseRecordsActivity> {

    /* renamed from: e  reason: collision with root package name */
    public l f14761e;

    /* renamed from: f  reason: collision with root package name */
    public FacePurchaseRecordsModel f14762f;

    /* renamed from: g  reason: collision with root package name */
    public String f14763g;

    /* renamed from: h  reason: collision with root package name */
    public e f14764h = new b();

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView.b f14765i = new c();

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            FacePurchaseRecordsActivity.this.k(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends e {
        public b() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            FacePurchaseRecordsActivity.this.hideProgressBar();
            if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
                if (FacePurchaseRecordsActivity.this.f14761e != null) {
                    FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                    if (facePurchaseRecordsData.errno == 0) {
                        FacePurchaseRecordsActivity.this.f14761e.f(facePurchaseRecordsData);
                        return;
                    }
                    String str = facePurchaseRecordsData.usermsg;
                    if (str != null) {
                        FacePurchaseRecordsActivity.this.showToast(str);
                        return;
                    }
                    return;
                }
                return;
            }
            FacePurchaseRecordsActivity.this.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements NoNetworkView.b {
        public c() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                FacePurchaseRecordsActivity.this.k(true);
            }
            FacePurchaseRecordsActivity.this.f14761e.b(z);
        }
    }

    public final void h() {
        this.f14761e.a(this.f14765i);
    }

    public final void i(Bundle bundle) {
        this.f14762f = new FacePurchaseRecordsModel(getActivity());
        if (bundle != null) {
            this.f14763g = bundle.getString("st_type");
        } else {
            this.f14763g = getIntent().getStringExtra("st_type");
        }
        this.f14762f.setStType(this.f14763g);
        this.f14762f.setLoadDataCallBack(this.f14764h);
    }

    public final void j() {
        l lVar = new l(getPageContext());
        this.f14761e = lVar;
        lVar.i(new a());
        this.f14761e.h(this);
        h();
    }

    public final void k(boolean z) {
        if (j.z()) {
            if (z) {
                showProgressBar();
            }
            this.f14762f.C();
            return;
        }
        this.f14761e.c();
    }

    public final void l() {
        this.f14761e.g(this.f14765i);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        l lVar = this.f14761e;
        if (lVar != null) {
            lVar.e(i2);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i(bundle);
        j();
        k(true);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        FacePurchaseRecordsModel facePurchaseRecordsModel = this.f14762f;
        if (facePurchaseRecordsModel != null) {
            facePurchaseRecordsModel.cancelLoadData();
        }
        l();
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        FacePurchasePackageData facePurchasePackageData;
        l lVar = this.f14761e;
        if (lVar == null || lVar.d() == null || (facePurchasePackageData = (FacePurchasePackageData) this.f14761e.d().getItem(i2)) == null) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePurchasePackageData.pid), false, "purchase_record")));
        super.onItemClick(adapterView, view, i2, j);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("st_type", this.f14763g);
        super.onSaveInstanceState(bundle);
    }
}
