package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j71;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CheckBox a;
    public TextView b;
    public String c;
    public Context d;
    public j71 e;
    public w51 f;

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b61 a;

        public a(b61 b61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b61Var;
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

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b61 a;

        public b(b61 b61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b61Var;
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

    public b61(Context context, String str, @NonNull w51 w51Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, w51Var};
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
        this.f = w51Var;
        this.c = str;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = View.inflate(this.d, R.layout.obfuscated_res_0x7f0d05f9, null);
            this.a = (CheckBox) inflate.findViewById(R.id.obfuscated_res_0x7f091bce);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091528);
            this.b = textView;
            textView.setTextColor(this.d.getResources().getColor(R.color.obfuscated_res_0x7f060823));
            this.b.setText(c());
            j71.a aVar = new j71.a(this.d);
            aVar.q(R.string.obfuscated_res_0x7f0f0bcb);
            aVar.s(inflate);
            aVar.l(R.string.obfuscated_res_0x7f0f0bc7, new b(this));
            aVar.o(R.string.obfuscated_res_0x7f0f0bca, new a(this));
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
            return String.format(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f0bc8), str);
        }
        return (String) invokeV.objValue;
    }

    public final void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            boolean isChecked = this.a.isChecked();
            if (isChecked) {
                a21.a().a(this.d.getApplicationContext(), z ? R.string.obfuscated_res_0x7f0f0bcc : R.string.obfuscated_res_0x7f0f0bcd);
            }
            this.f.a(this.c, z, isChecked);
        }
    }

    public void e() {
        j71 j71Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (j71Var = this.e) == null) {
            return;
        }
        n21.b(j71Var);
    }
}
