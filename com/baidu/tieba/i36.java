package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public au4 b;
    public au4 c;
    public au4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i36 a;

        public a(i36 i36Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i36Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i36Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091a90 || id == R.id.obfuscated_res_0x7f0926d6) {
                    if (this.a.b != null && this.a.b.isShowing()) {
                        gj8.b("1");
                        this.a.b.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        gj8.a("1", "1");
                        jv4.l("logoController", false);
                    }
                    if (this.a.c != null && this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        gj8.a("2", "1");
                        jv4.l("logoController", false);
                    }
                    if (this.a.d != null && this.a.d.isShowing()) {
                        this.a.d.dismiss();
                        gj8.a("3", "1");
                        jv4.l("logoController", false);
                    }
                    bx4.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    PermissionUtil.starMainTabActivity(this.a.a, 2);
                    this.a.a.finish();
                } else if (id == R.id.obfuscated_res_0x7f091a8b) {
                    if (this.a.b.isShowing()) {
                        gj8.b("1");
                        this.a.b.dismiss();
                        gj8.a("1", "2");
                    }
                    if (this.a.c == null) {
                        i36 i36Var = this.a;
                        i36Var.c = tn5.a(i36Var.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f1f, R.string.obfuscated_res_0x7f0f10fd);
                    }
                    this.a.c.show();
                    gj8.b("2");
                } else if (id == R.id.obfuscated_res_0x7f090410) {
                    i36.h(this.a);
                    if (this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        gj8.a("2", "2");
                        if (this.a.d == null) {
                            i36 i36Var2 = this.a;
                            i36Var2.d = tn5.a(i36Var2.a.getPageContext(), this.a.f, R.string.obfuscated_res_0x7f0f0f20, R.string.obfuscated_res_0x7f0f10f2);
                            this.a.d.show();
                            gj8.b("3");
                        }
                    }
                    if (this.a.d.isShowing() && this.a.e == 2) {
                        this.a.d.dismiss();
                        gj8.a("3", "2");
                        this.a.a.finish();
                    }
                }
            }
        }
    }

    public i36(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int h(i36 i36Var) {
        int i = i36Var.e;
        i36Var.e = i + 1;
        return i;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            au4 b = tn5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
