package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatusbarColorUtils;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.dza;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.data.CreateTagResponseData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.bottomsheet.BottomSheetDialog;
/* loaded from: classes5.dex */
public class cza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public ra5 b;
    public BottomSheetDialog c;
    public BdTopToast d;
    public ViewGroup e;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public LinearLayout j;
    public EditText k;
    public ImageView l;
    public int m;
    public String n;
    public String o;
    public dza p;
    public zya q;
    public final Runnable r;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cza a;

        public a(cza czaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {czaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = czaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.k != null) {
                yi.P(this.a.a, this.a.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cza a;

        public b(cza czaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {czaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = czaVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.o();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements dza.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cza a;

        public c(cza czaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {czaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = czaVar;
        }

        @Override // com.baidu.tieba.dza.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || this.a.a == null) {
                return;
            }
            this.a.n();
            this.a.w(str);
        }

        @Override // com.baidu.tieba.dza.b
        public void a(CreateTagResponseData createTagResponseData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, createTagResponseData) == null) {
                this.a.n();
                if (createTagResponseData != null && createTagResponseData.tagInfo != null && this.a.q != null) {
                    this.a.q.a(createTagResponseData.tagInfo);
                }
                if (this.a.c != null) {
                    this.a.c.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cza a;

        public d(cza czaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {czaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = czaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String trim = this.a.k.getText().toString().trim();
                if (!TextUtils.isEmpty(trim) && trim.equals(this.a.o)) {
                    if (this.a.c != null) {
                        this.a.c.dismiss();
                    }
                } else if (this.a.p != null) {
                    this.a.p.c(this.a.k.getText().toString().trim(), this.a.n);
                    this.a.o();
                    this.a.v();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cza a;

        public e(cza czaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {czaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = czaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.c != null) {
                this.a.c.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cza a;

        public f(cza czaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {czaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = czaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k.setText((CharSequence) null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cza a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public g(cza czaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {czaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = czaVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, editable) != null) {
                return;
            }
            this.a.t(editable);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cza a;

        public h(cza czaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {czaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = czaVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                zg.a().removeCallbacks(this.a.r);
            }
        }
    }

    public cza() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
    }

    public final void n() {
        ra5 ra5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ra5Var = this.b) != null) {
            ra5Var.b();
        }
    }

    public final void o() {
        BdTopToast bdTopToast;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (bdTopToast = this.d) == null) {
            return;
        }
        bdTopToast.b();
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            dza dzaVar = new dza();
            this.p = dzaVar;
            dzaVar.e();
            this.p.f(new c(this));
        }
    }

    public void s() {
        dza dzaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (dzaVar = this.p) != null) {
            dzaVar.g();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.b == null) {
                ra5 ra5Var = new ra5(this.a);
                ra5Var.c(false);
                ra5Var.d(this.a.getString(R.string.obfuscated_res_0x7f0f0513));
                this.b = ra5Var;
            }
            this.b.e();
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.d == null) {
                this.d = new BdTopToast(this.a);
            }
            this.d.g(str);
            this.d.i(this.e);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c = new BottomSheetDialog(this.a, R.style.obfuscated_res_0x7f1000fc);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0265, (ViewGroup) null);
            this.f = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09080e);
            this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09052c);
            this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090785);
            this.j = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09013b);
            this.k = (EditText) this.f.findViewById(R.id.obfuscated_res_0x7f090a59);
            this.l = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0911f2);
            this.i.setOnClickListener(new d(this));
            this.h.setOnClickListener(new e(this));
            this.l.setOnClickListener(new f(this));
            this.k.addTextChangedListener(new g(this));
            this.c.setContentView(this.f);
            if (this.c.getWindow() != null && this.c.getWindow().getAttributes() != null) {
                this.m = this.c.getWindow().getAttributes().windowAnimations;
            }
            this.c.setOnDismissListener(new h(this));
            r();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            d85 d2 = d85.d(this.f);
            d2.n(1);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0211);
            d85 d3 = d85.d(this.j);
            d3.o(R.string.J_X07);
            d3.f(R.color.CAM_X0209);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
            TextView textView = this.i;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_search_empty16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            EditText editText = this.k;
            if (editText != null) {
                editText.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            }
        }
    }

    public final void t(Editable editable) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, editable) == null) {
            int i = 0;
            if (editable != null && editable.toString().trim().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            this.i.setEnabled(z);
            ImageView imageView = this.l;
            if (!z) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void u(@NonNull Activity activity, @Nullable String str, @NonNull String str2, @Nullable zya zyaVar) {
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048583, this, activity, str, str2, zyaVar) == null) {
            this.a = activity;
            this.n = str2;
            this.o = str;
            this.q = zyaVar;
            if (this.p == null) {
                p();
            }
            if (this.c == null) {
                q();
            }
            this.c.setOnDismissListener(new b(this));
            if (this.c.getWindow() != null && this.m > 0) {
                this.c.getWindow().setWindowAnimations(this.m);
            }
            this.c.show();
            if (this.c.getWindow() != null) {
                this.c.getWindow().setWindowAnimations(-1);
                this.e = (ViewGroup) this.c.getWindow().getDecorView();
                StatusbarColorUtils.setStatusBarDarkIcon(this.c.getWindow(), true);
            }
            EditText editText = this.k;
            if (editText != null) {
                editText.setText(str);
                EditText editText2 = this.k;
                if (editText2.getText() == null) {
                    length = 0;
                } else {
                    length = this.k.getText().length();
                }
                editText2.setSelection(length);
                t(this.k.getText());
                this.k.requestFocus();
                zg.a().postDelayed(this.r, 150L);
            }
        }
    }
}
