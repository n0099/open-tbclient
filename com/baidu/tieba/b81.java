package com.baidu.tieba;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.tieba.np0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b81 extends Dialog implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b81 a;

        public a(b81 b81Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b81Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b81Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.a.a(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b81(Context context, AdBaseModel adBaseModel, b bVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adBaseModel, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c(adBaseModel);
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091604) {
                this.a.a(false);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f091602) {
                this.a.a(true);
            }
        }
    }

    public final void b(AdBaseModel adBaseModel) {
        np0.b bVar;
        String string;
        String string2;
        String string3;
        np0 np0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adBaseModel) == null) {
            if (adBaseModel != null && (np0Var = adBaseModel.p) != null) {
                bVar = np0Var.f;
            } else {
                bVar = null;
            }
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0611, (ViewGroup) null);
            if (bVar != null && !TextUtils.isEmpty(bVar.a)) {
                string = bVar.a;
            } else {
                string = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c09);
            }
            if (bVar != null && !TextUtils.isEmpty(bVar.b)) {
                string2 = bVar.b;
            } else {
                string2 = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c08);
            }
            if (bVar != null && !TextUtils.isEmpty(bVar.c)) {
                string3 = bVar.c;
            } else {
                string3 = getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c07);
            }
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091603)).setText(string);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091604);
            textView.setText(string2);
            textView.setOnClickListener(this);
            TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091602);
            textView2.setText(string3);
            textView2.setOnClickListener(this);
            setContentView(inflate);
            setOnDismissListener(new a(this));
        }
    }

    public final void c(AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel) == null) {
            Window window = getWindow();
            window.requestFeature(1);
            b(adBaseModel);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.windowAnimations = R.style.obfuscated_res_0x7f1003c3;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(17170445);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Window window = getWindow();
            if (window == null) {
                super.show();
                return;
            }
            window.setFlags(8, 8);
            super.show();
            l31.a(window);
            window.clearFlags(8);
        }
    }
}
