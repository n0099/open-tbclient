package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.passaccount.app.LoginDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
/* loaded from: classes5.dex */
public class c29 implements a29, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LoginDialogActivity a;
    public View b;
    public View c;
    public View d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public View h;
    public TbImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public final ShareStorage.StorageModel r;

    @Override // com.baidu.tieba.a29
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (Intent) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c29 a;

        public a(c29 c29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c29Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f1354), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.a.a.R1();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
                this.a.a.S1();
                this.a.a.J1(DialogLoginHelper.DIALOG_TYPE_SHARE);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends WebAuthListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialType a;
        public final /* synthetic */ c29 b;

        public b(c29 c29Var, SocialType socialType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c29Var, socialType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c29Var;
            this.a = socialType;
        }

        @Override // com.baidu.sapi2.shell.listener.WebAuthListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, sapiAccount) == null) {
                this.b.a.U1();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, webAuthResult) == null) {
                this.b.a.closeLoadingDialog();
                this.b.a.showToast(String.format(this.b.a.getString(R.string.obfuscated_res_0x7f0f15f1), Integer.valueOf(webAuthResult.getResultCode()), webAuthResult.getResultMsg()));
                this.b.a.R1();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(WebAuthResult webAuthResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, webAuthResult) == null) {
                this.b.a.S1();
                this.b.a.J1(this.a.name().toLowerCase());
            }
        }
    }

    public c29(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = (ShareStorage.StorageModel) new Gson().fromJson(str, (Class<Object>) ShareStorage.StorageModel.class);
    }

    public final void h(SocialType socialType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, socialType) == null) {
            PassportSDK.getInstance().loadThirdPartyLogin(new b(this, socialType), socialType);
        }
    }

    @Override // com.baidu.tieba.a29
    public void a(LoginDialogActivity loginDialogActivity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, loginDialogActivity, viewGroup) == null) {
            this.a = loginDialogActivity;
            View inflate = LayoutInflater.from(loginDialogActivity).inflate(R.layout.obfuscated_res_0x7f0d0874, viewGroup, true);
            this.b = inflate.findViewById(R.id.obfuscated_res_0x7f090889);
            this.c = inflate.findViewById(R.id.obfuscated_res_0x7f0908a3);
            this.d = inflate.findViewById(R.id.obfuscated_res_0x7f090722);
            this.e = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090723);
            this.f = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0908b0);
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0908ae);
            this.h = inflate.findViewById(R.id.obfuscated_res_0x7f092762);
            this.i = (TbImageView) inflate.findViewById(R.id.user_avatar);
            this.j = (TextView) inflate.findViewById(R.id.user_name);
            this.k = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09278c);
            this.l = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091621);
            this.m = inflate.findViewById(R.id.obfuscated_res_0x7f091d42);
            this.n = inflate.findViewById(R.id.obfuscated_res_0x7f092939);
            this.o = inflate.findViewById(R.id.obfuscated_res_0x7f09293c);
            this.p = inflate.findViewById(R.id.obfuscated_res_0x7f0929bd);
            this.q = inflate.findViewById(R.id.obfuscated_res_0x7f091757);
            this.b.setOnClickListener(this);
            this.d.setOnClickListener(this);
            this.e.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.i.setIsRound(true);
            this.i.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.q.setOnClickListener(this);
            d();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.Q1();
            this.a.finish();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.r != null) {
            PassportSDK.getInstance().invokeV2ShareLogin(this.a, new a(this), this.r);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h(SocialType.QQ_SSO);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            h(SocialType.WEIXIN);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h(SocialType.SINA_WEIBO_SSO);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h(SocialType.YY);
        }
    }

    public final void d() {
        ShareStorage.StorageModel storageModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (storageModel = this.r) == null) {
            return;
        }
        this.i.N(storageModel.url, 10, false);
        this.j.setText(this.r.displayname);
        this.k.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1353, this.r.app));
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.finish();
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) this.a, true);
            loginActivityConfig.setLoginListener(this.a.N1());
            loginActivityConfig.setFrom(this.a.getPreExtraPageKey());
            loginActivityConfig.setFromDialog("share_more");
            loginActivityConfig.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            int id = view2.getId();
            if (id != R.id.obfuscated_res_0x7f090889 && id != R.id.obfuscated_res_0x7f090722 && id != R.id.obfuscated_res_0x7f090723) {
                if (id == R.id.obfuscated_res_0x7f091621) {
                    e();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f091d42) {
                    g();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f092939) {
                    i();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f09293c) {
                    j();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f0929bd) {
                    k();
                    return;
                } else if (id == R.id.obfuscated_res_0x7f091757) {
                    f();
                    return;
                } else {
                    return;
                }
            }
            c();
        }
    }

    @Override // com.baidu.tieba.a29
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            o75 d = o75.d(this.c);
            d.n(1);
            d.o(R.string.J_X14);
            d.f(R.color.CAM_X0207);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_close12_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            o75 d2 = o75.d(this.f);
            d2.w(R.color.CAM_X0105);
            d2.B(R.dimen.T_X05);
            d2.C(R.string.F_X02);
            o75 d3 = o75.d(this.g);
            d3.w(R.color.CAM_X0108);
            d3.B(R.dimen.T_X08);
            d3.C(R.string.F_X01);
            o75 d4 = o75.d(this.h);
            d4.o(R.string.J_X05);
            d4.f(R.color.CAM_X0204);
            o75 d5 = o75.d(this.j);
            d5.w(R.color.CAM_X0105);
            d5.B(R.dimen.T_X05);
            d5.C(R.string.F_X02);
            o75 d6 = o75.d(this.k);
            d6.w(R.color.CAM_X0108);
            d6.B(R.dimen.T_X08);
            d6.C(R.string.F_X01);
            o75 d7 = o75.d(this.l);
            d7.w(R.color.CAM_X0101);
            d7.B(R.dimen.T_X05);
            d7.C(R.string.F_X01);
            d7.o(R.string.J_X01);
            d7.f(R.color.CAM_X0302);
        }
    }
}
