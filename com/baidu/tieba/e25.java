package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e25 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static TextView b;
    public static TextView c;
    public static TextView d;
    public static TextView e;
    public static TextView f;
    public static TextView g;
    public static TextView h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertConfig.a a;
        public final /* synthetic */ View.OnClickListener b;

        public a(TBAlertConfig.a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                View.OnClickListener onClickListener = this.a.d;
                if (onClickListener != null) {
                    onClickListener.onClick(view2);
                }
                View.OnClickListener onClickListener2 = this.b;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-882911197, "Lcom/baidu/tieba/e25$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-882911197, "Lcom/baidu/tieba/e25$b;");
                    return;
                }
            }
            int[] iArr = new int[TBAlertConfig.OperateBtnStyle.values().length];
            b = iArr;
            try {
                iArr[TBAlertConfig.OperateBtnStyle.MAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[TBAlertConfig.OperateBtnStyle.ALERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[TBAlertConfig.OperateBtnStyle.FORCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[TBAlertConfig.OperateBtnStyle.SECONDARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[TBAlertConfig.OperateType.values().length];
            a = iArr2;
            try {
                iArr2[TBAlertConfig.OperateType.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[TBAlertConfig.OperateType.TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[TBAlertConfig.OperateType.THREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947682465, "Lcom/baidu/tieba/e25;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947682465, "Lcom/baidu/tieba/e25;");
                return;
            }
        }
        a = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds96);
    }

    public static TextView a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            TextView textView = new TextView(context);
            g = textView;
            b35 d2 = b35.d(textView);
            d2.z(R.dimen.T_X07);
            d2.x(R.color.CAM_X0301);
            d2.A(R.string.F_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0301);
            d2.n(R.string.J_X07);
            d2.h(17170445);
            g.setMaxLines(1);
            g.setSingleLine();
            g.setGravity(17);
            return g;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            TextView textView = new TextView(context);
            f = textView;
            b35 d2 = b35.d(textView);
            d2.z(R.dimen.T_X07);
            d2.x(R.color.CAM_X0101);
            d2.A(R.string.F_X01);
            d2.n(R.string.J_X07);
            d2.h(R.color.CAM_X0303);
            f.setMaxLines(1);
            f.setSingleLine();
            f.setGravity(17);
            return f;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            TextView textView = new TextView(context);
            e = textView;
            b35 d2 = b35.d(textView);
            d2.z(R.dimen.T_X07);
            d2.x(R.color.CAM_X0304);
            d2.A(R.string.F_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0304);
            d2.j(R.string.A_X07);
            d2.n(R.string.J_X07);
            d2.h(17170445);
            e.setMaxLines(1);
            e.setSingleLine();
            e.setGravity(17);
            return e;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView k(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            TextView textView = new TextView(context);
            h = textView;
            b35 d2 = b35.d(textView);
            d2.z(R.dimen.T_X07);
            d2.x(R.color.CAM_X0105);
            d2.A(R.string.F_X01);
            d2.l(R.dimen.L_X02);
            d2.k(R.color.CAM_X0902);
            d2.n(R.string.J_X07);
            d2.h(17170445);
            h.setMaxLines(1);
            h.setSingleLine();
            h.setGravity(17);
            return h;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView l(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            b = eMTextView;
            b35 d2 = b35.d(eMTextView);
            d2.z(R.dimen.T_X05);
            d2.v(R.color.CAM_X0105);
            d2.A(R.string.F_X02);
            b.setMaxLines(1);
            b.setSingleLine();
            b.setGravity(17);
            return b;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView b(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, activity, z)) == null) {
            if (z) {
                return c(activity);
            }
            return d(activity);
        }
        return (TextView) invokeLZ.objValue;
    }

    public static TextView c(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            c = eMTextView;
            b35 d2 = b35.d(eMTextView);
            d2.z(R.dimen.T_X07);
            d2.w(R.dimen.M_T_X002);
            d2.v(R.color.CAM_X0108);
            d2.A(R.string.F_X01);
            return c;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            d = eMTextView;
            b35 d2 = b35.d(eMTextView);
            d2.z(R.dimen.T_X07);
            d2.w(R.dimen.M_T_X002);
            d2.v(R.color.CAM_X0108);
            d2.A(R.string.F_X01);
            return d;
        }
        return (TextView) invokeL.objValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            TextView textView = g;
            if (textView != null) {
                b35 d2 = b35.d(textView);
                d2.z(R.dimen.T_X07);
                d2.x(R.color.CAM_X0301);
                d2.A(R.string.F_X01);
                d2.l(R.dimen.L_X02);
                d2.k(R.color.CAM_X0301);
                d2.n(R.string.J_X07);
                d2.h(17170445);
            }
            TextView textView2 = h;
            if (textView2 != null) {
                b35 d3 = b35.d(textView2);
                d3.z(R.dimen.T_X07);
                d3.x(R.color.CAM_X0105);
                d3.A(R.string.F_X01);
                d3.l(R.dimen.L_X02);
                d3.k(R.color.CAM_X0902);
                d3.n(R.string.J_X07);
                d3.h(17170445);
            }
            TextView textView3 = f;
            if (textView3 != null) {
                b35 d4 = b35.d(textView3);
                d4.z(R.dimen.T_X07);
                d4.x(R.color.CAM_X0101);
                d4.A(R.string.F_X01);
                d4.n(R.string.J_X07);
                d4.h(R.color.CAM_X0303);
            }
            TextView textView4 = e;
            if (textView4 != null) {
                b35 d5 = b35.d(textView4);
                d5.z(R.dimen.T_X07);
                d5.x(R.color.CAM_X0304);
                d5.A(R.string.F_X01);
                d5.l(R.dimen.L_X02);
                d5.k(R.color.CAM_X0304);
                d5.j(R.string.A_X07);
                d5.n(R.string.J_X07);
                d5.h(17170445);
            }
            TextView textView5 = b;
            if (textView5 != null) {
                b35 d6 = b35.d(textView5);
                d6.z(R.dimen.T_X05);
                d6.v(R.color.CAM_X0105);
                d6.A(R.string.F_X02);
            }
            TextView textView6 = c;
            if (textView6 != null) {
                b35 d7 = b35.d(textView6);
                d7.z(R.dimen.T_X07);
                d7.w(R.dimen.M_T_X002);
                d7.v(R.color.CAM_X0108);
                d7.A(R.string.F_X01);
            }
            TextView textView7 = d;
            if (textView7 != null) {
                b35 d8 = b35.d(textView7);
                d8.z(R.dimen.T_X07);
                d8.w(R.dimen.M_T_X002);
                d8.v(R.color.CAM_X0108);
                d8.A(R.string.F_X01);
            }
        }
    }

    public static View h(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, aVar, onClickListener)) == null) {
            return i(context, aVar, onClickListener, false);
        }
        return (View) invokeLLL.objValue;
    }

    public static View i(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener, boolean z) {
        InterceptResult invokeCommon;
        TextView f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, aVar, onClickListener, Boolean.valueOf(z)})) == null) {
            int i = b.b[aVar.c.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            f2 = null;
                        } else {
                            f2 = k(context);
                        }
                    } else {
                        f2 = e(context);
                    }
                } else {
                    f2 = a(context);
                }
            } else {
                f2 = f(context);
            }
            f2.setText(aVar.a);
            int i2 = aVar.b;
            if (i2 != 0) {
                f2.setTextColor(i2);
            }
            if (z) {
                b35.d(f2).z(R.dimen.T_X08);
            }
            f2.setOnClickListener(new a(aVar, onClickListener));
            return f2;
        }
        return (View) invokeCommon.objValue;
    }

    public static View j(@NonNull Context context, @NonNull TBAlertConfig.b bVar, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, bVar, onClickListener)) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setPadding(0, ej.g(context, R.dimen.M_H_X008), 0, ej.g(context, R.dimen.M_H_X008));
            linearLayout.setGravity(17);
            int i = b.a[bVar.a.ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        linearLayout.setOrientation(1);
                        View h2 = h(context, bVar.b, onClickListener);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a);
                        layoutParams.setMargins(ej.g(context, R.dimen.M_W_X012), 0, ej.g(context, R.dimen.M_W_X012), ej.g(context, R.dimen.M_H_X005));
                        linearLayout.addView(h2, layoutParams);
                        View h3 = h(context, bVar.c, onClickListener);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, a);
                        layoutParams2.setMargins(ej.g(context, R.dimen.M_W_X012), 0, ej.g(context, R.dimen.M_W_X012), ej.g(context, R.dimen.M_H_X005));
                        linearLayout.addView(h3, layoutParams2);
                        View h4 = h(context, bVar.d, onClickListener);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, a);
                        layoutParams3.setMargins(ej.g(context, R.dimen.M_W_X012), 0, ej.g(context, R.dimen.M_W_X012), 0);
                        linearLayout.addView(h4, layoutParams3);
                    }
                } else {
                    linearLayout.setOrientation(0);
                    if (bVar.b.a.length() <= 6 && bVar.c.a.length() <= 6) {
                        z = false;
                    }
                    View i2 = i(context, bVar.b, onClickListener, z);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, a);
                    layoutParams4.setMargins(ej.g(context, R.dimen.M_W_X012), 0, ej.g(context, R.dimen.M_W_X006) / 2, 0);
                    layoutParams4.weight = 1.0f;
                    linearLayout.addView(i2, layoutParams4);
                    View i3 = i(context, bVar.c, onClickListener, z);
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, a);
                    layoutParams5.setMargins(ej.g(context, R.dimen.M_W_X006) / 2, 0, ej.g(context, R.dimen.M_W_X012), 0);
                    layoutParams5.weight = 1.0f;
                    linearLayout.addView(i3, layoutParams5);
                }
            } else {
                linearLayout.setOrientation(0);
                linearLayout.setWeightSum(837.0f);
                View h5 = h(context, bVar.b, onClickListener);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, a);
                layoutParams6.weight = 494.0f;
                linearLayout.addView(h5, layoutParams6);
            }
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return linearLayout;
        }
        return (View) invokeLLL.objValue;
    }
}
