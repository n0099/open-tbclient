package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog a;
    public Activity b;
    public View c;
    public DialogInterface.OnDismissListener d;

    public d55(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = activity;
    }

    public void c(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            this.c = view2;
        }
    }

    public void d(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onDismissListener) == null) {
            this.d = onDismissListener;
        }
    }

    public void a() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (alertDialog = this.a) != null && alertDialog.isShowing()) {
            this.a.dismiss();
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return 5894;
            }
            return 1280;
        }
        return invokeV.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.b == null) {
            return;
        }
        if (this.a == null) {
            AlertDialog create = new AlertDialog.Builder(this.b).create();
            this.a = create;
            create.requestWindowFeature(b());
            GreyUtil.grey(this.a);
        }
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
        this.a.setCancelable(true);
        this.a.setOnDismissListener(this.d);
        this.a.show();
        Window window = this.a.getWindow();
        window.getDecorView().setSystemUiVisibility(b());
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setNavigationBarColor(0);
        window.setAttributes(attributes);
        window.setDimAmount(0.0f);
        View view2 = this.c;
        if (view2 != null) {
            this.a.setContentView(view2);
        }
    }
}
