package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p71;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CheckBox a;
    public TextView b;
    public String c;
    public Context d;
    public p71 e;
    public k51 f;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a61 a;

        public a(a61 a61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a61Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                dialogInterface.dismiss();
                this.a.d(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a61 a;

        public b(a61 a61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a61Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                dialogInterface.dismiss();
                this.a.d(false);
            }
        }
    }

    public a61(Context context, String str, @NonNull k51 k51Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, k51Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = context;
        this.f = k51Var;
        this.c = str;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = View.inflate(this.d, R.layout.nad_light_browser_geolocation_dialog, null);
            this.a = (CheckBox) inflate.findViewById(R.id.obfuscated_res_0x7f091eda);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09177d);
            this.b = textView;
            textView.setTextColor(this.d.getResources().getColor(R.color.nad_box_dialog_message_text_color));
            this.b.setText(c());
            p71.a aVar = new p71.a(this.d);
            aVar.o(R.string.nad_geolocation_permissions_prompt_title);
            aVar.p(inflate);
            aVar.j(R.string.nad_geolocation_permissions_prompt_dont_share, new b(this));
            aVar.m(R.string.nad_geolocation_permissions_prompt_share, new a(this));
            this.e = aVar.a();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Uri parse = Uri.parse(this.c);
            String str = this.c;
            if ("http".equals(parse.getScheme())) {
                str = this.c.substring(7);
            }
            return String.format(this.d.getResources().getString(R.string.nad_geolocation_permissions_prompt_message), str);
        }
        return (String) invokeV.objValue;
    }

    public final void d(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            boolean isChecked = this.a.isChecked();
            if (isChecked) {
                if (z) {
                    i = R.string.nad_geolocation_permissions_prompt_toast_allowed;
                } else {
                    i = R.string.nad_geolocation_permissions_prompt_toast_disallowed;
                }
                e01.a().a(this.d.getApplicationContext(), i);
            }
            this.f.a(this.c, z, isChecked);
        }
    }

    public void e() {
        p71 p71Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (p71Var = this.e) != null) {
            u01.b(p71Var);
        }
    }
}
