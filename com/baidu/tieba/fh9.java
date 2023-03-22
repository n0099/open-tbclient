package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.LoginDialogData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.util.DialogLoginHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.p05;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fh9 extends s05 {
    public static /* synthetic */ Interceptable $ic;
    public static final String i;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity f;
    public final se9 g;
    public la5 h;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fh9 a;

        public a(fh9 fh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fh9Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                w05.r("operateNew");
                this.a.c();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlertDialog a;
        public final /* synthetic */ fh9 b;

        public b(fh9 fh9Var, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh9Var, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fh9Var;
            this.a = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2.getContext() != null) {
                this.a.dismiss();
                LoginDialogData loginDialogData = new LoginDialogData(view2.getContext(), LoginDialogData.HOME_OPERATE_DIALOG);
                String b = this.b.h.b();
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    str = "skin=dark";
                } else {
                    str = "skin=default";
                }
                if (b.contains("?")) {
                    str2 = b + "&customfullscreen=1&nonavigationbar=1&" + str;
                } else {
                    str2 = b + "?customfullscreen=1&nonavigationbar=1&" + str;
                }
                loginDialogData.setJumpUrl(str2);
                if (DialogLoginHelper.checkUpIsLogin(loginDialogData)) {
                    gt4.v(view2.getContext(), null, str2, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertBuilder a;
        public final /* synthetic */ AlertDialog b;
        public final /* synthetic */ fh9 c;

        public c(fh9 fh9Var, TBAlertBuilder tBAlertBuilder, AlertDialog alertDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fh9Var, tBAlertBuilder, alertDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fh9Var;
            this.a = tBAlertBuilder;
            this.b = alertDialog;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                if (!z) {
                    this.c.c();
                } else {
                    this.a.A(this.b);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947764274, "Lcom/baidu/tieba/fh9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947764274, "Lcom/baidu/tieba/fh9;");
                return;
            }
        }
        i = "key_home_operate_dialog_" + TbConfig.getBigAppVersion();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fh9(@NonNull MainTabActivity mainTabActivity, @NonNull se9 se9Var) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, se9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = se9Var;
        this.f = mainTabActivity;
    }

    @Override // com.baidu.tieba.p05
    public void d(@NonNull p05.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            boolean z = false;
            if (w05.i()) {
                aVar.a(false);
            } else if (!m35.m().i(i, true)) {
                aVar.a(false);
            } else {
                la5 homeOperateData = TbSingleton.getInstance().getHomeOperateData();
                this.h = homeOperateData;
                if (homeOperateData == null) {
                    aVar.a(false);
                } else if (!homeOperateData.c()) {
                    aVar.a(false);
                } else {
                    if (!TextUtils.isEmpty(this.h.a()) && this.h.a().contains("not_show")) {
                        m35.m().w(i, false);
                    } else if (this.g.y() != null && this.g.y().getCurrentTabType() == 2) {
                        z = true;
                    }
                    aVar.a(z);
                }
            }
        }
    }

    @Override // com.baidu.tieba.s05
    public void g(TBAlertBuilder tBAlertBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tBAlertBuilder) == null) {
            m35.m().w(i, false);
            int h = TBAlertBuilder.h(TbadkCoreApplication.getInst());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h, (h * 4) / 3);
            TbImageView tbImageView = new TbImageView(this.b);
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tBAlertBuilder.k(tbImageView);
            tBAlertBuilder.r(true);
            tBAlertBuilder.v(true);
            tBAlertBuilder.j(false);
            tBAlertBuilder.s(new a(this));
            AlertDialog d = tBAlertBuilder.d();
            tbImageView.setOnClickListener(new b(this, d));
            tbImageView.setEvent(new c(this, tBAlertBuilder, d));
            tbImageView.M(this.h.a(), 10, false);
        }
    }

    @Override // com.baidu.tieba.s05
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            w05.l("operateNew");
        }
    }
}
