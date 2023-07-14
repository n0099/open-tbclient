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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d65 {
    public static /* synthetic */ Interceptable $ic;
    public static final int i;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBAlertConfig.a a;
        public final /* synthetic */ View.OnClickListener b;

        public a(d65 d65Var, TBAlertConfig.a aVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d65Var, aVar, onClickListener};
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
                View.OnClickListener onClickListener = this.a.f;
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

    /* loaded from: classes5.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-907846264, "Lcom/baidu/tieba/d65$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-907846264, "Lcom/baidu/tieba/d65$b;");
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
            try {
                b[TBAlertConfig.OperateBtnStyle.BG_GRADIENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[TBAlertConfig.OperateType.values().length];
            a = iArr2;
            try {
                iArr2[TBAlertConfig.OperateType.ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[TBAlertConfig.OperateType.TWO.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[TBAlertConfig.OperateType.THREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947656518, "Lcom/baidu/tieba/d65;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947656518, "Lcom/baidu/tieba/d65;");
                return;
            }
        }
        i = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds96);
    }

    public d65() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final TextView a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            TextView textView = new TextView(context);
            this.f = textView;
            d85 d = d85.d(textView);
            d.C(R.dimen.T_X07);
            d.A(R.color.CAM_X0301);
            d.D(R.string.F_X01);
            d.m(R.dimen.L_X02);
            d.l(R.color.CAM_X0301);
            d.o(R.string.J_X07);
            d.i(17170445);
            this.f.setMaxLines(1);
            this.f.setSingleLine();
            this.f.setGravity(17);
            return this.f;
        }
        return (TextView) invokeL.objValue;
    }

    public final TextView f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            TextView textView = new TextView(context);
            this.e = textView;
            d85 d = d85.d(textView);
            d.C(R.dimen.T_X07);
            d.A(R.color.CAM_X0101);
            d.D(R.string.F_X01);
            d.o(R.string.J_X07);
            d.i(R.color.CAM_X0303);
            this.e.setMaxLines(1);
            this.e.setSingleLine();
            this.e.setGravity(17);
            return this.e;
        }
        return (TextView) invokeL.objValue;
    }

    public final TextView g(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            TextView textView = new TextView(context);
            this.d = textView;
            d85 d = d85.d(textView);
            d.C(R.dimen.T_X07);
            d.A(R.color.CAM_X0304);
            d.D(R.string.F_X01);
            d.m(R.dimen.L_X02);
            d.l(R.color.CAM_X0304);
            d.k(R.string.A_X07);
            d.o(R.string.J_X07);
            d.i(17170445);
            this.d.setMaxLines(1);
            this.d.setSingleLine();
            this.d.setGravity(17);
            return this.d;
        }
        return (TextView) invokeL.objValue;
    }

    public final TextView l(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            TextView textView = new TextView(context);
            this.g = textView;
            d85 d = d85.d(textView);
            d.C(R.dimen.T_X07);
            d.A(R.color.CAM_X0105);
            d.D(R.string.F_X01);
            d.m(R.dimen.L_X02);
            d.l(R.color.CAM_X0902);
            d.o(R.string.J_X07);
            d.i(17170445);
            this.g.setMaxLines(1);
            this.g.setSingleLine();
            this.g.setGravity(17);
            return this.g;
        }
        return (TextView) invokeL.objValue;
    }

    public final TextView b(@NonNull Context context, @NonNull TBAlertConfig.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar)) == null) {
            this.h = new TextView(context);
            TBSelector.makeDrawableSelector().setShape(0).radius((float) R.string.J_X07).gradientLinear(aVar.d, aVar.c).into(this.h);
            this.h.setTextSize(0, UtilHelper.getDimenPixelSize(R.dimen.T_X07));
            this.h.setMaxLines(1);
            this.h.setSingleLine();
            this.h.setGravity(17);
            return this.h;
        }
        return (TextView) invokeLL.objValue;
    }

    public TextView c(Activity activity, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, activity, z)) == null) {
            if (z) {
                return d(activity);
            }
            return e(activity);
        }
        return (TextView) invokeLZ.objValue;
    }

    public TextView d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            this.b = eMTextView;
            d85 d = d85.d(eMTextView);
            d.C(R.dimen.T_X07);
            d.z(R.dimen.M_T_X002);
            d.x(R.color.CAM_X0108);
            d.D(R.string.F_X01);
            return this.b;
        }
        return (TextView) invokeL.objValue;
    }

    public TextView e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            this.c = eMTextView;
            d85 d = d85.d(eMTextView);
            d.C(R.dimen.T_X07);
            d.z(R.dimen.M_T_X002);
            d.x(R.color.CAM_X0108);
            d.D(R.string.F_X01);
            return this.c;
        }
        return (TextView) invokeL.objValue;
    }

    public TextView m(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            this.a = eMTextView;
            d85 d = d85.d(eMTextView);
            d.C(R.dimen.T_X05);
            d.x(R.color.CAM_X0105);
            d.D(R.string.F_X02);
            this.a.setMaxLines(1);
            this.a.setSingleLine();
            this.a.setGravity(17);
            return this.a;
        }
        return (TextView) invokeL.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TextView textView = this.f;
            if (textView != null) {
                d85 d = d85.d(textView);
                d.C(R.dimen.T_X07);
                d.A(R.color.CAM_X0301);
                d.D(R.string.F_X01);
                d.m(R.dimen.L_X02);
                d.l(R.color.CAM_X0301);
                d.o(R.string.J_X07);
                d.i(17170445);
            }
            TextView textView2 = this.g;
            if (textView2 != null) {
                d85 d2 = d85.d(textView2);
                d2.C(R.dimen.T_X07);
                d2.A(R.color.CAM_X0105);
                d2.D(R.string.F_X01);
                d2.m(R.dimen.L_X02);
                d2.l(R.color.CAM_X0902);
                d2.o(R.string.J_X07);
                d2.i(17170445);
            }
            TextView textView3 = this.e;
            if (textView3 != null) {
                d85 d3 = d85.d(textView3);
                d3.C(R.dimen.T_X07);
                d3.A(R.color.CAM_X0101);
                d3.D(R.string.F_X01);
                d3.o(R.string.J_X07);
                d3.i(R.color.CAM_X0303);
            }
            TextView textView4 = this.d;
            if (textView4 != null) {
                d85 d4 = d85.d(textView4);
                d4.C(R.dimen.T_X07);
                d4.A(R.color.CAM_X0304);
                d4.D(R.string.F_X01);
                d4.m(R.dimen.L_X02);
                d4.l(R.color.CAM_X0304);
                d4.k(R.string.A_X07);
                d4.o(R.string.J_X07);
                d4.i(17170445);
            }
            TextView textView5 = this.a;
            if (textView5 != null) {
                d85 d5 = d85.d(textView5);
                d5.C(R.dimen.T_X05);
                d5.x(R.color.CAM_X0105);
                d5.D(R.string.F_X02);
            }
            TextView textView6 = this.b;
            if (textView6 != null) {
                d85 d6 = d85.d(textView6);
                d6.C(R.dimen.T_X07);
                d6.z(R.dimen.M_T_X002);
                d6.x(R.color.CAM_X0108);
                d6.D(R.string.F_X01);
            }
            TextView textView7 = this.c;
            if (textView7 != null) {
                d85 d7 = d85.d(textView7);
                d7.C(R.dimen.T_X07);
                d7.z(R.dimen.M_T_X002);
                d7.x(R.color.CAM_X0108);
                d7.D(R.string.F_X01);
            }
        }
    }

    public final View i(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, aVar, onClickListener)) == null) {
            return j(context, aVar, onClickListener, false);
        }
        return (View) invokeLLL.objValue;
    }

    public final View j(@NonNull Context context, @NonNull TBAlertConfig.a aVar, @Nullable View.OnClickListener onClickListener, boolean z) {
        InterceptResult invokeCommon;
        TextView g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{context, aVar, onClickListener, Boolean.valueOf(z)})) == null) {
            int i2 = b.b[aVar.e.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                g = null;
                            } else {
                                g = b(context, aVar);
                            }
                        } else {
                            g = l(context);
                        }
                    } else {
                        g = f(context);
                    }
                } else {
                    g = a(context);
                }
            } else {
                g = g(context);
            }
            g.setText(aVar.a);
            int i3 = aVar.b;
            if (i3 != 0) {
                g.setTextColor(i3);
            }
            if (z) {
                d85.d(g).C(R.dimen.T_X08);
            }
            g.setOnClickListener(new a(this, aVar, onClickListener));
            return g;
        }
        return (View) invokeCommon.objValue;
    }

    public View k(@NonNull Context context, @NonNull TBAlertConfig.b bVar, @Nullable View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, bVar, onClickListener)) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setPadding(0, yi.g(context, R.dimen.M_H_X008), 0, yi.g(context, R.dimen.M_H_X008));
            linearLayout.setGravity(17);
            int i2 = b.a[bVar.a.ordinal()];
            boolean z = true;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        linearLayout.setOrientation(1);
                        View i3 = i(context, bVar.b, onClickListener);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i);
                        layoutParams.setMargins(yi.g(context, R.dimen.M_W_X012), 0, yi.g(context, R.dimen.M_W_X012), yi.g(context, R.dimen.M_H_X005));
                        linearLayout.addView(i3, layoutParams);
                        View i4 = i(context, bVar.c, onClickListener);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i);
                        layoutParams2.setMargins(yi.g(context, R.dimen.M_W_X012), 0, yi.g(context, R.dimen.M_W_X012), yi.g(context, R.dimen.M_H_X005));
                        linearLayout.addView(i4, layoutParams2);
                        View i5 = i(context, bVar.d, onClickListener);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, i);
                        layoutParams3.setMargins(yi.g(context, R.dimen.M_W_X012), 0, yi.g(context, R.dimen.M_W_X012), 0);
                        linearLayout.addView(i5, layoutParams3);
                    }
                } else {
                    linearLayout.setOrientation(0);
                    if (bVar.b.a.length() <= 6 && bVar.c.a.length() <= 6) {
                        z = false;
                    }
                    View j = j(context, bVar.b, onClickListener, z);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, i);
                    layoutParams4.setMargins(yi.g(context, R.dimen.M_W_X012), 0, yi.g(context, R.dimen.M_W_X006) / 2, 0);
                    layoutParams4.weight = 1.0f;
                    linearLayout.addView(j, layoutParams4);
                    View j2 = j(context, bVar.c, onClickListener, z);
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, i);
                    layoutParams5.setMargins(yi.g(context, R.dimen.M_W_X006) / 2, 0, yi.g(context, R.dimen.M_W_X012), 0);
                    layoutParams5.weight = 1.0f;
                    linearLayout.addView(j2, layoutParams5);
                }
            } else {
                linearLayout.setOrientation(0);
                linearLayout.setWeightSum(837.0f);
                View i6 = i(context, bVar.b, onClickListener);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, i);
                layoutParams6.weight = 494.0f;
                linearLayout.addView(i6, layoutParams6);
            }
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return linearLayout;
        }
        return (View) invokeLLL.objValue;
    }
}
