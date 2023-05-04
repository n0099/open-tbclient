package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.views.logindialog.view.AgreementView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class au8 extends xt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au8 a;

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
            }
        }

        public a(au8 au8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au8Var;
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onSuccess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oneKeyLoginResult) == null) {
                DialogLoginHelper.addLoginDialogSuccessLog(DialogLoginHelper.getOneKeyLoginActivityLocate(), DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
                this.a.f();
            }
        }

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onFail(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, oneKeyLoginResult) == null) {
                this.a.b.closeLoadingDialog();
                BaseActivity baseActivity = this.a.b;
                baseActivity.showToast(String.format(baseActivity.getString(R.string.obfuscated_res_0x7f0f0de5), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au8(TbPageContext tbPageContext, yt8 yt8Var) {
        super(tbPageContext, yt8Var, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, yt8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (yt8) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.xt8
    public void j(zt8 zt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zt8Var) == null) {
            this.e = zt8Var;
        }
    }

    @Override // com.baidu.tieba.xt8
    public void n(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.n(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f0915be) {
                s();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0918e5) {
                t();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09016b) {
                r();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091c20) {
                u();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BaseActivity baseActivity = this.b;
            pt4.v(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ddc), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
            PassportSDK passportSDK = PassportSDK.getInstance();
            BaseActivity baseActivity = this.b;
            passportSDK.loadOneKeyLogin(baseActivity, fu8.j(baseActivity, this.e.c), new a(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BaseActivity baseActivity = this.b;
            pt4.v(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0de0), "http://privacy.baidu.com/mdetail?id=288", false);
        }
    }

    public final void t() {
        zt8 zt8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (zt8Var = this.e) == null) {
            return;
        }
        int a2 = zt8Var.a();
        if (a2 != 1) {
            if (a2 != 2) {
                if (a2 == 3) {
                    BaseActivity baseActivity = this.b;
                    pt4.v(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ddf), "https://wap.cmpassport.com/resources/html/contract.html", false);
                    return;
                }
                return;
            }
            BaseActivity baseActivity2 = this.b;
            pt4.v(baseActivity2, baseActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0dde), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false);
            return;
        }
        BaseActivity baseActivity3 = this.b;
        pt4.v(baseActivity3, baseActivity3.getResources().getString(R.string.obfuscated_res_0x7f0f0ddd), AgreementView.s, false);
    }
}
