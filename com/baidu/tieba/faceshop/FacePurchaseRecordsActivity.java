package com.baidu.tieba.faceshop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import d.b.c.a.e;
import d.b.c.e.p.j;
import d.b.i0.r.f0.f;
import d.b.j0.l0.l;
/* loaded from: classes4.dex */
public class FacePurchaseRecordsActivity extends ProxyAdkBaseActivity<FacePurchaseRecordsActivity> {

    /* renamed from: e  reason: collision with root package name */
    public l f15340e;

    /* renamed from: f  reason: collision with root package name */
    public FacePurchaseRecordsModel f15341f;

    /* renamed from: g  reason: collision with root package name */
    public String f15342g;

    /* renamed from: h  reason: collision with root package name */
    public e f15343h = new b();
    public NoNetworkView.b i = new c();

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public a() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            FacePurchaseRecordsActivity.this.k(false);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends e {
        public b() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            FacePurchaseRecordsActivity.this.hideProgressBar();
            if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
                if (FacePurchaseRecordsActivity.this.f15340e != null) {
                    FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                    if (facePurchaseRecordsData.errno == 0) {
                        FacePurchaseRecordsActivity.this.f15340e.f(facePurchaseRecordsData);
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
            FacePurchaseRecordsActivity.this.f15340e.b(z);
        }
    }

    public final void h() {
        this.f15340e.a(this.i);
    }

    public final void i(Bundle bundle) {
        this.f15341f = new FacePurchaseRecordsModel(getActivity());
        if (bundle != null) {
            this.f15342g = bundle.getString("st_type");
        } else {
            this.f15342g = getIntent().getStringExtra("st_type");
        }
        this.f15341f.setStType(this.f15342g);
        this.f15341f.setLoadDataCallBack(this.f15343h);
    }

    public final void j() {
        l lVar = new l(getPageContext());
        this.f15340e = lVar;
        lVar.i(new a());
        this.f15340e.h(this);
        h();
    }

    public final void k(boolean z) {
        if (j.z()) {
            if (z) {
                showProgressBar();
            }
            this.f15341f.y();
            return;
        }
        this.f15340e.c();
    }

    public final void l() {
        this.f15340e.g(this.i);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        l lVar = this.f15340e;
        if (lVar != null) {
            lVar.e(i);
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
        FacePurchaseRecordsModel facePurchaseRecordsModel = this.f15341f;
        if (facePurchaseRecordsModel != null) {
            facePurchaseRecordsModel.cancelLoadData();
        }
        l();
        super.onDestroy();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        FacePurchasePackageData facePurchasePackageData;
        l lVar = this.f15340e;
        if (lVar == null || lVar.d() == null || (facePurchasePackageData = (FacePurchasePackageData) this.f15340e.d().getItem(i)) == null) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePurchasePackageData.pid), false, "purchase_record")));
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("st_type", this.f15342g);
        super.onSaveInstanceState(bundle);
    }
}
