package com.baidu.tieba.faceshop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.e;
import d.a.c.e.p.j;
import d.a.r0.r.f0.f;
import d.a.s0.p0.l;
/* loaded from: classes5.dex */
public class FacePurchaseRecordsActivity extends ProxyAdkBaseActivity<FacePurchaseRecordsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public l f14934e;

    /* renamed from: f  reason: collision with root package name */
    public FacePurchaseRecordsModel f14935f;

    /* renamed from: g  reason: collision with root package name */
    public String f14936g;

    /* renamed from: h  reason: collision with root package name */
    public e f14937h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView.b f14938i;

    /* loaded from: classes5.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsActivity f14939e;

        public a(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePurchaseRecordsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14939e = facePurchaseRecordsActivity;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f14939e.k(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsActivity f14940a;

        public b(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePurchaseRecordsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14940a = facePurchaseRecordsActivity;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f14940a.hideProgressBar();
                if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
                    if (this.f14940a.f14934e != null) {
                        FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                        if (facePurchaseRecordsData.errno == 0) {
                            this.f14940a.f14934e.f(facePurchaseRecordsData);
                            return;
                        }
                        String str = facePurchaseRecordsData.usermsg;
                        if (str != null) {
                            this.f14940a.showToast(str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f14940a.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsActivity f14941e;

        public c(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePurchaseRecordsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14941e = facePurchaseRecordsActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f14941e.k(true);
                }
                this.f14941e.f14934e.b(z);
            }
        }
    }

    public FacePurchaseRecordsActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14937h = new b(this);
        this.f14938i = new c(this);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14934e.a(this.f14938i);
        }
    }

    public final void i(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.f14935f = new FacePurchaseRecordsModel(getActivity());
            if (bundle != null) {
                this.f14936g = bundle.getString("st_type");
            } else {
                this.f14936g = getIntent().getStringExtra("st_type");
            }
            this.f14935f.setStType(this.f14936g);
            this.f14935f.setLoadDataCallBack(this.f14937h);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            l lVar = new l(getPageContext());
            this.f14934e = lVar;
            lVar.i(new a(this));
            this.f14934e.h(this);
            h();
        }
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (j.z()) {
                if (z) {
                    showProgressBar();
                }
                this.f14935f.C();
                return;
            }
            this.f14934e.c();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14934e.g(this.f14938i);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (lVar = this.f14934e) == null) {
            return;
        }
        lVar.e(i2);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            i(bundle);
            j();
            k(true);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            FacePurchaseRecordsModel facePurchaseRecordsModel = this.f14935f;
            if (facePurchaseRecordsModel != null) {
                facePurchaseRecordsModel.cancelLoadData();
            }
            l();
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        l lVar;
        FacePurchasePackageData facePurchasePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (lVar = this.f14934e) == null || lVar.d() == null || (facePurchasePackageData = (FacePurchasePackageData) this.f14934e.d().getItem(i2)) == null) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePurchasePackageData.pid), false, "purchase_record")));
        super.onItemClick(adapterView, view, i2, j);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            bundle.putString("st_type", this.f14936g);
            super.onSaveInstanceState(bundle);
        }
    }
}
