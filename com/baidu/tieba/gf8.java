package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class gf8 extends j9<BaseFragmentActivity> implements ef8, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int C;
    public transient /* synthetic */ FieldHolder $fh;
    public TBAlertBuilder A;
    public boolean B;
    public final WeakReference<Activity> a;
    @Nullable
    public AlertDialog b;
    public View c;
    public LinearLayout d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public FlowLayout h;
    public EMTextView i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public EMTextView p;
    public LinearLayout q;
    public HeadImageView r;
    public TextView s;
    public View t;
    public List<View> u;
    public EMTextView v;
    public View w;
    @Nullable
    public cf8 x;
    public Runnable y;
    public Runnable z;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf8 a;

        public a(gf8 gf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf8Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
                this.a.I();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf8 a;

        public b(gf8 gf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.U();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf8 a;

        public c(gf8 gf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ah.a(this.a.b, this.a.mContext.getPageActivity());
                this.a.I();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf8 a;

        public d(gf8 gf8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.x != null) {
                this.a.x.a(25, null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947792112, "Lcom/baidu/tieba/gf8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947792112, "Lcom/baidu/tieba/gf8;");
                return;
            }
        }
        C = UtilHelper.getDimenPixelSize(R.dimen.tbds78);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            C(0L);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlertDialog create = new AlertDialog.Builder(this.mContext.getPageActivity(), R.style.obfuscated_res_0x7f10010c).create();
            this.b = create;
            create.setCanceledOnTouchOutside(true);
            this.b.setOnDismissListener(new a(this));
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
            return;
        }
        while (true) {
            List<View> list = this.u;
            if (list != null && list.size() > 0) {
                this.h.removeView(this.u.get(0));
                this.u.remove(0);
            } else {
                return;
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.q != null) {
            s75 d2 = s75.d(this.s);
            d2.x(R.color.CAM_X0107);
            d2.C(R.dimen.T_X09);
        }
    }

    @Override // com.baidu.tieba.ef8
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            T(0L);
        }
    }

    @Override // com.baidu.tieba.ef8
    public void p() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (linearLayout = this.q) != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gf8(@NonNull l9<BaseFragmentActivity> l9Var) {
        super(l9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new ArrayList();
        this.B = false;
        this.a = new WeakReference<>(l9Var.getPageActivity());
        D();
        E();
    }

    public void C(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            if (this.y == null) {
                this.y = new c(this);
            }
            yg.a().postDelayed(this.y, j);
        }
    }

    public final void K(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            EMTextView eMTextView = this.p;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void M(@Nullable Map<String, Object> map) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, map) == null) {
            if (map != null && map.containsKey("is_show_copy")) {
                z = ((Boolean) map.get("is_show_copy")).booleanValue();
            } else {
                z = true;
            }
            EMTextView eMTextView = this.i;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void N(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            EMTextView eMTextView = this.l;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void O(@Nullable Map<String, Object> map) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, map) == null) {
            int i = 0;
            if (map != null && map.containsKey("is_show_reply")) {
                z = ((Boolean) map.get("is_show_reply")).booleanValue();
            } else {
                z = false;
            }
            EMTextView eMTextView = this.j;
            if (!z) {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void P(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            EMTextView eMTextView = this.m;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void Q(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            EMTextView eMTextView = this.k;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void T(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            if (this.z == null) {
                this.z = new b(this);
            }
            yg.a().postDelayed(this.z, j);
        }
    }

    public final void W(@Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, map) == null) {
            M(map);
            O(map);
            P(false);
            N(false);
            Q(true);
        }
    }

    public void X(@Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && !StringUtils.isNull(str)) {
            this.r.N(str, 12, false);
        }
    }

    @Override // com.baidu.tieba.ef8
    public void n(@NonNull cf8 cf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cf8Var) == null) {
            this.x = cf8Var;
        }
    }

    @SuppressLint({"InflateParams"})
    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d086d, (ViewGroup) null);
            this.c = inflate;
            this.d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090e89);
            this.e = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090e82);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e86);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e85);
            this.g = textView;
            textView.setMaxLines(1);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.h = (FlowLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090e68);
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e7b);
            this.i = eMTextView;
            eMTextView.setOnClickListener(this);
            EMTextView eMTextView2 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e80);
            this.k = eMTextView2;
            eMTextView2.setOnClickListener(this);
            EMTextView eMTextView3 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e7d);
            this.l = eMTextView3;
            eMTextView3.setOnClickListener(this);
            EMTextView eMTextView4 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e7f);
            this.m = eMTextView4;
            eMTextView4.setOnClickListener(this);
            EMTextView eMTextView5 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e66);
            this.v = eMTextView5;
            eMTextView5.setOnClickListener(this);
            EMTextView eMTextView6 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e7e);
            this.j = eMTextView6;
            eMTextView6.setOnClickListener(this);
            EMTextView eMTextView7 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e7a);
            this.o = eMTextView7;
            eMTextView7.setOnClickListener(this);
            EMTextView eMTextView8 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e7c);
            this.n = eMTextView8;
            eMTextView8.setOnClickListener(this);
            EMTextView eMTextView9 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090e79);
            this.p = eMTextView9;
            eMTextView9.setOnClickListener(this);
            this.w = this.c.findViewById(R.id.obfuscated_res_0x7f090414);
            if (!F()) {
                J();
            }
        }
    }

    @Override // com.baidu.tieba.ef8
    public void a() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            s75 d2 = s75.d(this.d);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0213);
            s75 d3 = s75.d(this.e);
            d3.o(R.string.J_X14);
            d3.f(R.color.CAM_X0209);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.w, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.v, R.color.CAM_X0213);
            s75 d4 = s75.d(this.f);
            d4.x(R.color.CAM_X0109);
            d4.C(R.dimen.T_X08);
            d4.D(R.string.F_X01);
            s75 d5 = s75.d(this.g);
            d5.x(R.color.CAM_X0107);
            d5.C(R.dimen.T_X08);
            S();
            SkinManager.setViewTextColorSelector(this.v, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.mContext.getPageActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (F()) {
                i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i = (width - 1005) / 4;
            }
            this.h.setHorizontalSpacing(i);
            R(this.p, R.drawable.obfuscated_res_0x7f0800e2);
            R(this.i, R.drawable.obfuscated_res_0x7f0804d2);
            R(this.k, R.drawable.obfuscated_res_0x7f0804d6);
            R(this.l, R.drawable.obfuscated_res_0x7f0804d3);
            R(this.m, R.drawable.obfuscated_res_0x7f0804d5);
            R(this.j, R.drawable.obfuscated_res_0x7f0804d4);
            R(this.o, R.drawable.obfuscated_res_0x7f080b87);
            EMTextView eMTextView = this.n;
            if (this.B) {
                i2 = R.drawable.obfuscated_res_0x7f0804d7;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f0804d8;
            }
            R(eMTextView, i2);
            TBAlertBuilder tBAlertBuilder = this.A;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.g();
            }
        }
    }

    public final boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.mContext.getPageActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            if (i % 160 != 0 && (i * 1.0f) / 160.0f != 1.5d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ef8
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.b != null) {
                this.b = null;
            }
            if (this.z != null) {
                yg.a().removeCallbacks(this.z);
                this.z = null;
            }
            if (this.y != null) {
                yg.a().removeCallbacks(this.y);
                this.y = null;
            }
        }
    }

    public final void G(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, map) == null) {
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3) {
                    if (i == 64) {
                        M(map);
                        O(map);
                        P(true);
                        N(false);
                        Q(true);
                        return;
                    }
                    return;
                }
                M(map);
                O(map);
                P(true);
                N(false);
                Q(false);
                return;
            }
            M(map);
            O(map);
            P(true);
            N(true);
            Q(true);
        }
    }

    public final void H(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, map) == null) {
            if (i == 0 || i == 1 || i == 2 || i == 64) {
                M(map);
                O(map);
                P(true);
                N(false);
                Q(false);
            }
        }
    }

    public final void R(TextView textView, int i) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048591, this, textView, i) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = C;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    @Override // com.baidu.tieba.ef8
    @SuppressLint({"SetTextI18n"})
    public void m(@NonNull String str, @NonNull CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, charSequence) == null) {
            TextView textView = this.f;
            textView.setText(str + ZeusCrashHandler.NAME_SEPERATOR);
            this.g.setText(charSequence);
        }
    }

    @Override // com.baidu.tieba.ef8
    public void r(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, str, str2) == null) {
            this.s.setText(str);
            X(str2);
            this.q.setVisibility(0);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.p.getLayoutParams().width = 201;
            this.i.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.n.getLayoutParams().width = 201;
            LinearLayout linearLayout = this.q;
            if (linearLayout != null) {
                linearLayout.getLayoutParams().width = 201;
            }
        }
    }

    public final boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            AlertDialog alertDialog = this.b;
            if (alertDialog == null) {
                return false;
            }
            boolean i = ah.i(alertDialog, this.mContext.getPageActivity());
            Window window = this.b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = xi.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100419);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.c);
            window.setDimAmount(0.33f);
            return i;
        }
        return invokeV.booleanValue;
    }

    public final void V(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048595, this, i, map) == null) {
            if (i != 0) {
                if (i == 1 || i == 2 || i == 64) {
                    M(map);
                    P(true);
                    O(map);
                    N(false);
                    Q(true);
                    return;
                }
                return;
            }
            M(map);
            P(true);
            O(map);
            N(true);
            Q(true);
        }
    }

    @Override // com.baidu.tieba.ef8
    public void c(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            BdTopToast bdTopToast = new BdTopToast(this.mContext.getContext());
            bdTopToast.h(true);
            bdTopToast.g(str);
            bdTopToast.i((ViewGroup) this.mContext.getPageActivity().findViewById(16908290));
        }
    }

    @Override // com.baidu.tieba.ef8
    public void l(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            if (this.A == null) {
                this.A = new TBAlertBuilder(this.a.get());
            }
            this.A.w(R.string.obfuscated_res_0x7f0f0932);
            this.A.q(str);
            this.A.o(true);
            this.A.u(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0588, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0932, TBAlertConfig.OperateBtnStyle.MAIN, new d(this)));
            this.A.i();
            this.A.j(false);
            this.A.z();
        }
    }

    @Override // com.baidu.tieba.ef8
    public void o(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, obj) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0191, (ViewGroup) null);
            this.t = inflate;
            this.q = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091f0b);
            this.r = (HeadImageView) this.t.findViewById(R.id.obfuscated_res_0x7f091f0f);
            this.s = (TextView) this.t.findViewById(R.id.obfuscated_res_0x7f091f20);
            S();
            this.r.setIsRound(true);
            this.r.setDrawBorder(false);
            this.r.setPlaceHolder(1);
            this.q.setOnClickListener(this);
            this.q.setTag(obj);
            this.h.addView(this.t);
            this.u.add(this.t);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        cf8 cf8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090e7b) {
                cf8 cf8Var2 = this.x;
                if (cf8Var2 != null) {
                    cf8Var2.a(19, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e80) {
                cf8 cf8Var3 = this.x;
                if (cf8Var3 != null) {
                    cf8Var3.a(18, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e7d) {
                cf8 cf8Var4 = this.x;
                if (cf8Var4 != null) {
                    cf8Var4.a(17, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e7f) {
                cf8 cf8Var5 = this.x;
                if (cf8Var5 != null) {
                    cf8Var5.a(20, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e7e) {
                cf8 cf8Var6 = this.x;
                if (cf8Var6 != null) {
                    cf8Var6.a(21, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e66) {
                cf8 cf8Var7 = this.x;
                if (cf8Var7 != null) {
                    cf8Var7.a(22, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e7a) {
                cf8 cf8Var8 = this.x;
                if (cf8Var8 != null) {
                    cf8Var8.a(23, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f091f0b) {
                if (this.x != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("robot_tag", view2.getTag());
                    this.x.a(24, hashMap);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e7c) {
                cf8 cf8Var9 = this.x;
                if (cf8Var9 != null) {
                    cf8Var9.a(33, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090e79 && (cf8Var = this.x) != null) {
                cf8Var.a(32, null);
            }
            B();
        }
    }

    @Override // com.baidu.tieba.ef8
    public void q(boolean z, int i, int i2, @Nullable Map<String, Object> map, boolean z2, long j, long j2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), map, Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                W(map);
            } else if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        V(i, map);
                    }
                } else {
                    G(i, map);
                }
            } else {
                H(i, map);
            }
            int i4 = 0;
            if (map != null && map.containsKey("is_show_bubble")) {
                boolean booleanValue = ((Boolean) map.get("is_show_bubble")).booleanValue();
                EMTextView eMTextView = this.o;
                if (booleanValue) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                eMTextView.setVisibility(i3);
            } else {
                this.o.setVisibility(8);
            }
            if (z2) {
                K(true);
                e78.a(1, 1, j, j2);
            } else {
                K(false);
            }
            if (map != null && map.containsKey("is_show_excellent_btn")) {
                boolean booleanValue2 = ((Boolean) map.get("is_show_excellent_btn")).booleanValue();
                EMTextView eMTextView2 = this.n;
                if (!booleanValue2) {
                    i4 = 8;
                }
                eMTextView2.setVisibility(i4);
            } else {
                this.n.setVisibility(8);
            }
            int i5 = R.string.obfuscated_res_0x7f0f0413;
            int i6 = R.drawable.obfuscated_res_0x7f0804d8;
            if (map != null && map.containsKey("is_excellent_msg")) {
                boolean booleanValue3 = ((Boolean) map.get("is_excellent_msg")).booleanValue();
                this.B = booleanValue3;
                EMTextView eMTextView3 = this.n;
                if (booleanValue3) {
                    i6 = R.drawable.obfuscated_res_0x7f0804d7;
                }
                R(eMTextView3, i6);
                EMTextView eMTextView4 = this.n;
                if (this.B) {
                    i5 = R.string.obfuscated_res_0x7f0f0412;
                }
                eMTextView4.setText(i5);
                return;
            }
            R(this.n, R.drawable.obfuscated_res_0x7f0804d8);
            this.n.setText(R.string.obfuscated_res_0x7f0f0413);
        }
    }

    @Override // com.baidu.tieba.ef8
    public void s(int i, int i2, @Nullable String str) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048610, this, i, i2, str) == null) {
            if (i != 1) {
                if (i == 3 && i2 == 1) {
                    boolean z = !this.B;
                    this.B = z;
                    EMTextView eMTextView = this.n;
                    if (z) {
                        i3 = R.drawable.obfuscated_res_0x7f0804d7;
                    } else {
                        i3 = R.drawable.obfuscated_res_0x7f0804d8;
                    }
                    R(eMTextView, i3);
                    c(str);
                }
            } else if (i2 == 1) {
                c(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0936));
            }
        }
    }
}
