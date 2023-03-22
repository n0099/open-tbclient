package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.switchs.TbBrowseModeSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ah6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public zz4 b;
    public zz4 c;
    public zz4 d;
    public int e;
    public View.OnClickListener f;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah6 a;

        public a(ah6 ah6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ah6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.private_yes || id == R.id.obfuscated_res_0x7f0928ee) {
                    this.a.j();
                } else if (id == R.id.private_no) {
                    if (this.a.b.isShowing()) {
                        this.a.b.dismiss();
                        r79.a("1", "2");
                    }
                    if (this.a.c == null) {
                        ah6 ah6Var = this.a;
                        ah6Var.c = ww5.a(ah6Var.a.getPageContext(), this.a.f, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.a.c.show();
                    r79.b("2");
                } else if (id == R.id.obfuscated_res_0x7f09046b) {
                    ah6.g(this.a);
                    if (this.a.c.isShowing()) {
                        this.a.c.dismiss();
                        r79.a("2", "2");
                        if (this.a.d == null) {
                            ah6 ah6Var2 = this.a;
                            TbPageContext<BaseFragmentActivity> pageContext = ah6Var2.a.getPageContext();
                            View.OnClickListener onClickListener = this.a.f;
                            if (TbBrowseModeSwitch.isOn()) {
                                i = R.string.secret_hint_browser;
                            } else {
                                i = R.string.secret_hint_browser_exit;
                            }
                            ah6Var2.d = ww5.a(pageContext, onClickListener, R.string.privacy_policy_guide_two, i);
                            this.a.d.show();
                            r79.b("3");
                        }
                    }
                    if (this.a.d.isShowing() && this.a.e == 2) {
                        this.a.d.dismiss();
                        r79.a("3", "2");
                        if (TbBrowseModeSwitch.isOn()) {
                            PermissionUtil.doBrowseModeInit();
                            PermissionUtil.starMainTabActivity(this.a.a, 2);
                        }
                        this.a.a.finish();
                    }
                }
            }
        }
    }

    public ah6(@NonNull BaseFragmentActivity baseFragmentActivity) {
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

    public static /* synthetic */ int g(ah6 ah6Var) {
        int i = ah6Var.e;
        ah6Var.e = i + 1;
        return i;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            zz4 zz4Var = this.b;
            if (zz4Var != null && zz4Var.isShowing()) {
                this.b.dismiss();
                SmartLaunchStats.onConfirmPrivacy();
                r79.a("1", "1");
                b25.k("logoController", false);
            }
            zz4 zz4Var2 = this.c;
            if (zz4Var2 != null && zz4Var2.isShowing()) {
                this.c.dismiss();
                r79.a("2", "1");
                b25.k("logoController", false);
            }
            zz4 zz4Var3 = this.d;
            if (zz4Var3 != null && zz4Var3.isShowing()) {
                this.d.dismiss();
                r79.a("3", "1");
                b25.k("logoController", false);
            }
            m35.m().A("key_first_enter_app_timestamp", System.currentTimeMillis());
            PermissionUtil.doAgreePrivacyInit();
            PermissionUtil.starMainTabActivity(this.a, 2);
            this.a.finish();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            zz4 b = ww5.b(this.a.getPageContext(), this.f);
            this.b = b;
            b.show();
            r79.b("1");
            TbSingleton.setExceptInsertAdDiaShow(true);
            SmartLaunchStats.onPrivacyDialogShow();
        }
    }
}
