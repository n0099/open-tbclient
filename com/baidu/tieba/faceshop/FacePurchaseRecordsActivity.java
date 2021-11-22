package com.baidu.tieba.faceshop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.e;
import b.a.e.f.p.j;
import b.a.q0.s.g0.f;
import b.a.r0.s0.k;
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
/* loaded from: classes9.dex */
public class FacePurchaseRecordsActivity extends ProxyAdkBaseActivity<FacePurchaseRecordsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public k f48783e;

    /* renamed from: f  reason: collision with root package name */
    public FacePurchaseRecordsModel f48784f;

    /* renamed from: g  reason: collision with root package name */
    public String f48785g;

    /* renamed from: h  reason: collision with root package name */
    public e f48786h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView.b f48787i;

    /* loaded from: classes9.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsActivity f48788e;

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
            this.f48788e = facePurchaseRecordsActivity;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f48788e.k(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsActivity f48789a;

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
            this.f48789a = facePurchaseRecordsActivity;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f48789a.hideProgressBar();
                if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
                    if (this.f48789a.f48783e != null) {
                        FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                        if (facePurchaseRecordsData.errno == 0) {
                            this.f48789a.f48783e.f(facePurchaseRecordsData);
                            return;
                        }
                        String str = facePurchaseRecordsData.usermsg;
                        if (str != null) {
                            this.f48789a.showToast(str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f48789a.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsActivity f48790e;

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
            this.f48790e = facePurchaseRecordsActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f48790e.k(true);
                }
                this.f48790e.f48783e.b(z);
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
        this.f48786h = new b(this);
        this.f48787i = new c(this);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f48783e.a(this.f48787i);
        }
    }

    public final void i(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.f48784f = new FacePurchaseRecordsModel(getActivity());
            if (bundle != null) {
                this.f48785g = bundle.getString("st_type");
            } else {
                this.f48785g = getIntent().getStringExtra("st_type");
            }
            this.f48784f.setStType(this.f48785g);
            this.f48784f.setLoadDataCallBack(this.f48786h);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k kVar = new k(getPageContext());
            this.f48783e = kVar;
            kVar.i(new a(this));
            this.f48783e.h(this);
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
                this.f48784f.loadData();
                return;
            }
            this.f48783e.c();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f48783e.g(this.f48787i);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (kVar = this.f48783e) == null) {
            return;
        }
        kVar.e(i2);
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
            FacePurchaseRecordsModel facePurchaseRecordsModel = this.f48784f;
            if (facePurchaseRecordsModel != null) {
                facePurchaseRecordsModel.cancelLoadData();
            }
            l();
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        k kVar;
        FacePurchasePackageData facePurchasePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (kVar = this.f48783e) == null || kVar.d() == null || (facePurchasePackageData = (FacePurchasePackageData) this.f48783e.d().getItem(i2)) == null) {
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
            bundle.putString("st_type", this.f48785g);
            super.onSaveInstanceState(bundle);
        }
    }
}
