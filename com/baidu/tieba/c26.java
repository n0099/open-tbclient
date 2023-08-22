package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes5.dex */
public class c26 extends b26 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e26 q;

    /* loaded from: classes5.dex */
    public class a implements u16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c26 a;

        public a(c26 c26Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c26Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c26Var;
        }

        @Override // com.baidu.tieba.u16
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.e.b.a(e26.y.parse(this.a.q.o()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c26(s16 s16Var) {
        super(s16Var.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s16Var};
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
        this.e = s16Var;
        A(s16Var.A);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if (((String) view2.getTag()).equals("submit")) {
                C();
            }
            f();
        }
    }

    public final void A(Context context) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            r();
            n();
            m();
            t16 t16Var = this.e.c;
            if (t16Var == null) {
                LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.b);
                TextView textView = (TextView) i(R.id.obfuscated_res_0x7f0926ea);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.rv_topbar);
                Button button = (Button) i(R.id.obfuscated_res_0x7f0904a6);
                Button button2 = (Button) i(R.id.obfuscated_res_0x7f0904a1);
                button.setTag("submit");
                button2.setTag("cancel");
                button.setOnClickListener(this);
                button2.setOnClickListener(this);
                if (TextUtils.isEmpty(this.e.B)) {
                    str = context.getResources().getString(R.string.pickerview_submit);
                } else {
                    str = this.e.B;
                }
                button.setText(str);
                if (TextUtils.isEmpty(this.e.C)) {
                    str2 = context.getResources().getString(R.string.pickerview_cancel);
                } else {
                    str2 = this.e.C;
                }
                button2.setText(str2);
                if (TextUtils.isEmpty(this.e.D)) {
                    str3 = "";
                } else {
                    str3 = this.e.D;
                }
                textView.setText(str3);
                button.setTextColor(this.e.E);
                button2.setTextColor(this.e.F);
                textView.setTextColor(this.e.G);
                relativeLayout.setBackgroundColor(this.e.I);
                button.setTextSize(this.e.J);
                button2.setTextSize(this.e.J);
                textView.setTextSize(this.e.K);
            } else {
                t16Var.a(LayoutInflater.from(context).inflate(this.e.x, this.b));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.obfuscated_res_0x7f092560);
            linearLayout.setBackgroundColor(this.e.H);
            B(linearLayout);
        }
    }

    public final void B(LinearLayout linearLayout) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linearLayout) == null) {
            s16 s16Var = this.e;
            e26 e26Var = new e26(linearLayout, s16Var.d, s16Var.z, s16Var.L);
            this.q = e26Var;
            if (this.e.b != null) {
                e26Var.G(new a(this));
            }
            this.q.C(this.e.k);
            s16 s16Var2 = this.e;
            int i2 = s16Var2.h;
            if (i2 != 0 && (i = s16Var2.i) != 0 && i2 <= i) {
                E();
            }
            s16 s16Var3 = this.e;
            Calendar calendar = s16Var3.f;
            if (calendar != null && s16Var3.g != null) {
                if (calendar.getTimeInMillis() <= this.e.g.getTimeInMillis()) {
                    D();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                s16 s16Var4 = this.e;
                Calendar calendar2 = s16Var4.f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        D();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = s16Var4.g;
                    if (calendar3 != null) {
                        if (calendar3.get(1) <= 2100) {
                            D();
                        } else {
                            throw new IllegalArgumentException("The endDate should not be later than 2100");
                        }
                    } else {
                        D();
                    }
                }
            }
            F();
            e26 e26Var2 = this.q;
            s16 s16Var5 = this.e;
            e26Var2.y(s16Var5.l, s16Var5.m, s16Var5.n, s16Var5.o, s16Var5.p, s16Var5.q);
            e26 e26Var3 = this.q;
            s16 s16Var6 = this.e;
            e26Var3.N(s16Var6.r, s16Var6.s, s16Var6.t, s16Var6.u, s16Var6.v, s16Var6.w);
            t(this.e.S);
            this.q.s(this.e.j);
            this.q.u(this.e.O);
            this.q.w(this.e.U);
            this.q.A(this.e.Q);
            this.q.M(this.e.M);
            this.q.K(this.e.N);
            this.q.p(this.e.f1167T);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.e.a != null) {
            try {
                Date parse = e26.y.parse(this.q.o());
                this.e.a.onTimeSelect(parse, this.m);
                ke5.d().c0(parse.getHours(), parse.getMinutes());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e26 e26Var = this.q;
            s16 s16Var = this.e;
            e26Var.E(s16Var.f, s16Var.g);
            z();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.q.I(this.e.h);
            this.q.x(this.e.i);
        }
    }

    @Override // com.baidu.tieba.b26
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e.R;
        }
        return invokeV.booleanValue;
    }

    public final void F() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = this.e.e;
            if (calendar2 == null) {
                calendar.setTimeInMillis(System.currentTimeMillis());
                i = calendar.get(1);
                i2 = calendar.get(2);
                i3 = calendar.get(5);
                i4 = calendar.get(11);
                i5 = calendar.get(12);
                i6 = calendar.get(13);
            } else {
                i = calendar2.get(1);
                i2 = this.e.e.get(2);
                i3 = this.e.e.get(5);
                i4 = this.e.e.get(11);
                i5 = this.e.e.get(12);
                i6 = this.e.e.get(13);
            }
            int i7 = i4;
            int i8 = i3;
            int i9 = i2;
            e26 e26Var = this.q;
            e26Var.D(i, i9, i8, i7, i5, i6);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            s16 s16Var = this.e;
            if (s16Var.f != null && s16Var.g != null) {
                Calendar calendar = s16Var.e;
                if (calendar == null || calendar.getTimeInMillis() < this.e.f.getTimeInMillis() || this.e.e.getTimeInMillis() > this.e.g.getTimeInMillis()) {
                    s16 s16Var2 = this.e;
                    s16Var2.e = s16Var2.f;
                    return;
                }
                return;
            }
            s16 s16Var3 = this.e;
            Calendar calendar2 = s16Var3.f;
            if (calendar2 != null) {
                s16Var3.e = calendar2;
                return;
            }
            Calendar calendar3 = s16Var3.g;
            if (calendar3 != null) {
                s16Var3.e = calendar3;
            }
        }
    }
}
