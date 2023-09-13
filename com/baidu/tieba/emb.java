package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class emb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AppCompatActivity a;

        public a(AppCompatActivity appCompatActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {appCompatActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = appCompatActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onBackPressed();
            }
        }
    }

    public static void a(AppCompatActivity appCompatActivity, Toolbar toolbar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, appCompatActivity, toolbar, str) == null) {
            toolbar.setNavigationIcon((Drawable) null);
            toolbar.setTitle("");
            View inflate = LayoutInflater.from(appCompatActivity).inflate(R.layout.obfuscated_res_0x7f0d005c, (ViewGroup) toolbar, false);
            Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            inflate.setLayoutParams(layoutParams);
            toolbar.addView(inflate);
            appCompatActivity.setSupportActionBar(toolbar);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09191d)).setText(str);
            inflate.findViewById(R.id.obfuscated_res_0x7f09191c).setOnClickListener(new a(appCompatActivity));
        }
    }
}
