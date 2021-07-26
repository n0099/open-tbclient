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
import d.a.d.a.e;
import d.a.d.e.p.j;
import d.a.p0.s.f0.f;
import d.a.q0.p0.l;
/* loaded from: classes4.dex */
public class FacePurchaseRecordsActivity extends ProxyAdkBaseActivity<FacePurchaseRecordsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public l f15021e;

    /* renamed from: f  reason: collision with root package name */
    public FacePurchaseRecordsModel f15022f;

    /* renamed from: g  reason: collision with root package name */
    public String f15023g;

    /* renamed from: h  reason: collision with root package name */
    public e f15024h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView.b f15025i;

    /* loaded from: classes4.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsActivity f15026e;

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
            this.f15026e = facePurchaseRecordsActivity;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f15026e.k(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsActivity f15027a;

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
            this.f15027a = facePurchaseRecordsActivity;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f15027a.hideProgressBar();
                if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
                    if (this.f15027a.f15021e != null) {
                        FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                        if (facePurchaseRecordsData.errno == 0) {
                            this.f15027a.f15021e.f(facePurchaseRecordsData);
                            return;
                        }
                        String str = facePurchaseRecordsData.usermsg;
                        if (str != null) {
                            this.f15027a.showToast(str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.f15027a.showToast(R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FacePurchaseRecordsActivity f15028e;

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
            this.f15028e = facePurchaseRecordsActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.f15028e.k(true);
                }
                this.f15028e.f15021e.b(z);
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
        this.f15024h = new b(this);
        this.f15025i = new c(this);
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f15021e.a(this.f15025i);
        }
    }

    public final void i(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            this.f15022f = new FacePurchaseRecordsModel(getActivity());
            if (bundle != null) {
                this.f15023g = bundle.getString("st_type");
            } else {
                this.f15023g = getIntent().getStringExtra("st_type");
            }
            this.f15022f.setStType(this.f15023g);
            this.f15022f.setLoadDataCallBack(this.f15024h);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            l lVar = new l(getPageContext());
            this.f15021e = lVar;
            lVar.i(new a(this));
            this.f15021e.h(this);
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
                this.f15022f.C();
                return;
            }
            this.f15021e.c();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f15021e.g(this.f15025i);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (lVar = this.f15021e) == null) {
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
            FacePurchaseRecordsModel facePurchaseRecordsModel = this.f15022f;
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
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (lVar = this.f15021e) == null || lVar.d() == null || (facePurchasePackageData = (FacePurchasePackageData) this.f15021e.d().getItem(i2)) == null) {
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
            bundle.putString("st_type", this.f15023g);
            super.onSaveInstanceState(bundle);
        }
    }
}
