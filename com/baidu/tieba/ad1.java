package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.LoadingProgressBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ad1 extends Dialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public LoadingProgressBar c;
    public TextView d;
    public String e;
    public boolean f;
    public boolean g;
    public boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad1(@NonNull Context context) {
        super(context, R.style.obfuscated_res_0x7f100140);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = "";
        this.g = false;
        this.h = false;
        this.a = context;
        this.f = a(context);
    }

    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (context instanceof Activity) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public ad1 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.g = z;
            return this;
        }
        return (ad1) invokeZ.objValue;
    }

    public ad1 d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.h = z;
            return this;
        }
        return (ad1) invokeZ.objValue;
    }

    public ad1 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.e = str;
            return this;
        }
        return (ad1) invokeL.objValue;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.nad_call_action_loading_dialog);
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = findViewById(R.id.obfuscated_res_0x7f091f2a);
            this.c = (LoadingProgressBar) findViewById(R.id.obfuscated_res_0x7f09160a);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09171b);
            this.d = textView;
            textView.setText(this.e);
            setCancelable(this.g);
            setCanceledOnTouchOutside(this.h);
            f();
        }
    }

    public final void f() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (context = this.a) == null) {
            return;
        }
        Resources resources = context.getResources();
        View view2 = this.b;
        if (view2 != null) {
            view2.setBackground(resources.getDrawable(R.drawable.nad_icon_loading_dialog_bg));
        }
        LoadingProgressBar loadingProgressBar = this.c;
        if (loadingProgressBar != null) {
            loadingProgressBar.setIndeterminateDrawable(resources.getDrawable(R.drawable.nad_loading_animation));
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(resources.getColor(R.color.nad_color_white));
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !this.f) {
            return;
        }
        try {
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
