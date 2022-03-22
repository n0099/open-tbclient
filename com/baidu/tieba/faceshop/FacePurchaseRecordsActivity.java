package com.baidu.tieba.faceshop;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.e;
import c.a.o0.r.l0.f;
import c.a.p0.a1.l;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FacePurchaseRecordsActivity extends BaseActivity<FacePurchaseRecordsActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ST_TYPE = "st_type";
    public transient /* synthetic */ FieldHolder $fh;
    public e mLoadDataCallBack;
    public FacePurchaseRecordsModel mModel;
    public NoNetworkView.b mNetworkChangeListener;
    public String mStType;
    public l mView;

    /* loaded from: classes5.dex */
    public class a implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FacePurchaseRecordsActivity a;

        public a(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePurchaseRecordsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = facePurchaseRecordsActivity;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.refresh(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FacePurchaseRecordsActivity a;

        public b(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePurchaseRecordsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = facePurchaseRecordsActivity;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.hideProgressBar();
                if (obj != null && (obj instanceof FacePurchaseRecordsData)) {
                    if (this.a.mView != null) {
                        FacePurchaseRecordsData facePurchaseRecordsData = (FacePurchaseRecordsData) obj;
                        if (facePurchaseRecordsData.errno == 0) {
                            this.a.mView.f(facePurchaseRecordsData);
                            return;
                        }
                        String str = facePurchaseRecordsData.usermsg;
                        if (str != null) {
                            this.a.showToast(str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c15);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FacePurchaseRecordsActivity a;

        public c(FacePurchaseRecordsActivity facePurchaseRecordsActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {facePurchaseRecordsActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = facePurchaseRecordsActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.refresh(true);
                }
                this.a.mView.b(z);
            }
        }
    }

    public FacePurchaseRecordsActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLoadDataCallBack = new b(this);
        this.mNetworkChangeListener = new c(this);
    }

    private void addNetWorkStateChangeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mView.a(this.mNetworkChangeListener);
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bundle) == null) {
            this.mModel = new FacePurchaseRecordsModel(getActivity());
            if (bundle != null) {
                this.mStType = bundle.getString("st_type");
            } else {
                this.mStType = getIntent().getStringExtra("st_type");
            }
            this.mModel.setStType(this.mStType);
            this.mModel.setLoadDataCallBack(this.mLoadDataCallBack);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            l lVar = new l(getPageContext());
            this.mView = lVar;
            lVar.i(new a(this));
            this.mView.h(this);
            addNetWorkStateChangeListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, this, z) == null) {
            if (c.a.d.f.p.l.z()) {
                if (z) {
                    showProgressBar();
                }
                this.mModel.loadData();
                return;
            }
            this.mView.c();
        }
    }

    private void removeNetWorkStateChangeListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            this.mView.g(this.mNetworkChangeListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (lVar = this.mView) == null) {
            return;
        }
        lVar.e(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            initData(bundle);
            initUI();
            refresh(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FacePurchaseRecordsModel facePurchaseRecordsModel = this.mModel;
            if (facePurchaseRecordsModel != null) {
                facePurchaseRecordsModel.cancelLoadData();
            }
            removeNetWorkStateChangeListener();
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        l lVar;
        FacePurchasePackageData facePurchasePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || (lVar = this.mView) == null || lVar.d() == null || (facePurchasePackageData = (FacePurchasePackageData) this.mView.d().getItem(i)) == null) {
            return;
        }
        sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(getPageContext().getPageActivity(), String.valueOf(facePurchasePackageData.pid), false, "purchase_record")));
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            bundle.putString("st_type", this.mStType);
            super.onSaveInstanceState(bundle);
        }
    }
}
