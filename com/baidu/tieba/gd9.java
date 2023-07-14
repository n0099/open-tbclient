package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gd9 extends dd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends OneKeyLoginCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd9 a;

        @Override // com.baidu.sapi2.callback.OneKeyLoginCallback
        public void onGuideProcess(OneKeyLoginResult oneKeyLoginResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oneKeyLoginResult) == null) {
            }
        }

        public a(gd9 gd9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gd9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gd9Var;
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
                baseActivity.showToast(String.format(baseActivity.getString(R.string.obfuscated_res_0x7f0f0ede), Integer.valueOf(oneKeyLoginResult.getResultCode()), oneKeyLoginResult.getResultMsg()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gd9(TbPageContext tbPageContext, ed9 ed9Var) {
        super(tbPageContext, ed9Var, DialogLoginHelper.FULL_SCREEN_TYPE_ONE_KEY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ed9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ed9) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.dd9
    public void j(fd9 fd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fd9Var) == null) {
            this.e = fd9Var;
        }
    }

    @Override // com.baidu.tieba.dd9
    public void n(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.n(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f09164b) {
                s();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f0919c8) {
                t();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090178) {
                r();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091d21) {
                u();
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BaseActivity baseActivity = this.b;
            nx4.v(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ed5), "https://passport.baidu.com/static/passpc-account/html/protocal.html", false);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            l();
            PassportSDK passportSDK = PassportSDK.getInstance();
            BaseActivity baseActivity = this.b;
            passportSDK.loadOneKeyLogin(baseActivity, ld9.j(baseActivity, this.e.c), new a(this));
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BaseActivity baseActivity = this.b;
            nx4.v(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ed9), "http://privacy.baidu.com/mdetail?id=288", false);
        }
    }

    public final void t() {
        fd9 fd9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (fd9Var = this.e) == null) {
            return;
        }
        int a2 = fd9Var.a();
        if (a2 != 1) {
            if (a2 != 2) {
                if (a2 == 3) {
                    BaseActivity baseActivity = this.b;
                    nx4.v(baseActivity, baseActivity.getResources().getString(R.string.obfuscated_res_0x7f0f0ed8), "https://wap.cmpassport.com/resources/html/contract.html", false);
                    return;
                }
                return;
            }
            BaseActivity baseActivity2 = this.b;
            nx4.v(baseActivity2, baseActivity2.getResources().getString(R.string.obfuscated_res_0x7f0f0ed7), "https://e.189.cn/sdk/agreement/detail.do?hidetop=true", false);
            return;
        }
        BaseActivity baseActivity3 = this.b;
        nx4.v(baseActivity3, baseActivity3.getResources().getString(R.string.obfuscated_res_0x7f0f0ed6), "https://ms.zzx9.cn/html/oauth/protocol2.html", false);
    }
}
