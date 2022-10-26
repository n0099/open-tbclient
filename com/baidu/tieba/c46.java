package com.baidu.tieba;

import android.view.View;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public pu4 b;
    public pu4 c;
    public pu4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c46 a;

        public a(c46 c46Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c46Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c46Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id != R.id.obfuscated_res_0x7f091a8f && id != R.id.obfuscated_res_0x7f0926bd) {
                    if (id == R.id.obfuscated_res_0x7f091a8a) {
                        if (this.a.b.isShowing()) {
                            fk8.b("1");
                            this.a.b.dismiss();
                            fk8.a("1", "2");
                        }
                        if (this.a.c == null) {
                            c46 c46Var = this.a;
                            c46Var.c = no5.a(c46Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f32, R.string.obfuscated_res_0x7f0f1110);
                        }
                        this.a.c.show();
                        fk8.b("2");
                        return;
                    } else if (id == R.id.obfuscated_res_0x7f090419) {
                        c46.h(this.a);
                        if (this.a.c.isShowing()) {
                            this.a.c.dismiss();
                            fk8.a("2", "2");
                            if (this.a.d == null) {
                                c46 c46Var2 = this.a;
                                c46Var2.d = no5.a(c46Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f33, R.string.obfuscated_res_0x7f0f1105);
                                this.a.d.show();
                                fk8.b("3");
                            }
                        }
                        if (this.a.d.isShowing() && this.a.e == 2) {
                            this.a.d.dismiss();
                            fk8.a("3", "2");
                            this.a.a.finish();
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                if (this.a.b != null && this.a.b.isShowing()) {
                    fk8.b("1");
                    this.a.b.dismiss();
                    SmartLaunchStats.onConfirmPrivacy();
                    fk8.a("1", "1");
                    cw4.l("logoController", false);
                }
                if (this.a.c != null && this.a.c.isShowing()) {
                    this.a.c.dismiss();
                    fk8.a("2", "1");
                    cw4.l("logoController", false);
                }
                if (this.a.d != null && this.a.d.isShowing()) {
                    this.a.d.dismiss();
                    fk8.a("3", "1");
                    cw4.l("logoController", false);
                }
                ux4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                PermissionUtil.setIsAgreePrivacyPolicy(true);
                PermissionUtil.starMainTabActivity(this.a.a, 2);
                this.a.a.finish();
            }
        }
    }

    public c46(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.f = new a(this);
        this.a = baseFragmentActivity;
    }

    public static /* synthetic */ int h(c46 c46Var) {
        int i = c46Var.e;
        c46Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            pu4 b = no5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
