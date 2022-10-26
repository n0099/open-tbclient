package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
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
/* loaded from: classes3.dex */
public class dv4 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public final class a implements View.OnClickListener {
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

    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-848770711, "Lcom/baidu/tieba/dv4$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-848770711, "Lcom/baidu/tieba/dv4$b;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947717991, "Lcom/baidu/tieba/dv4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947717991, "Lcom/baidu/tieba/dv4;");
                return;
            }
        }
        a = fj.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds96);
    }

    public static TextView a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            TextView textView = new TextView(context);
            nv4 d = nv4.d(textView);
            d.z(R.dimen.T_X07);
            d.x(R.color.CAM_X0301);
            d.A(R.string.F_X01);
            d.l(R.dimen.L_X02);
            d.k(R.color.CAM_X0301);
            d.n(R.string.J_X07);
            d.h(17170445);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            TextView textView = new TextView(context);
            nv4 d = nv4.d(textView);
            d.z(R.dimen.T_X07);
            d.x(R.color.CAM_X0101);
            d.A(R.string.F_X01);
            d.n(R.string.J_X07);
            d.h(R.color.CAM_X0303);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            TextView textView = new TextView(context);
            nv4 d = nv4.d(textView);
            d.z(R.dimen.T_X07);
            d.x(R.color.CAM_X0304);
            d.A(R.string.F_X01);
            d.l(R.dimen.L_X02);
            d.k(R.color.CAM_X0304);
            d.j(R.string.A_X07);
            d.n(R.string.J_X07);
            d.h(17170445);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            TextView textView = new TextView(context);
            nv4 d = nv4.d(textView);
            d.z(R.dimen.T_X07);
            d.x(R.color.CAM_X0105);
            d.A(R.string.F_X01);
            d.l(R.dimen.L_X02);
            d.k(R.color.CAM_X0902);
            d.n(R.string.J_X07);
            d.h(17170445);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setGravity(17);
            return textView;
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

    public static TextView c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            nv4 d = nv4.d(eMTextView);
            d.z(R.dimen.T_X07);
            d.w(R.dimen.M_T_X002);
            d.v(R.color.CAM_X0107);
            d.A(R.string.F_X01);
            return eMTextView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            nv4 d = nv4.d(eMTextView);
            d.z(R.dimen.T_X07);
            d.w(R.dimen.M_T_X002);
            d.v(R.color.CAM_X0108);
            d.A(R.string.F_X01);
            return eMTextView;
        }
        return (TextView) invokeL.objValue;
    }

    public static TextView k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            EMTextView eMTextView = new EMTextView(context);
            nv4 d = nv4.d(eMTextView);
            d.z(R.dimen.T_X05);
            d.v(R.color.CAM_X0105);
            d.A(R.string.F_X02);
            eMTextView.setMaxLines(1);
            eMTextView.setSingleLine();
            eMTextView.setGravity(17);
            return eMTextView;
        }
        return (TextView) invokeL.objValue;
    }

    public static View g(Context context, TBAlertConfig.a aVar, View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, aVar, onClickListener)) == null) {
            return h(context, aVar, onClickListener, false);
        }
        return (View) invokeLLL.objValue;
    }

    public static View h(Context context, TBAlertConfig.a aVar, View.OnClickListener onClickListener, boolean z) {
        InterceptResult invokeCommon;
        TextView f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{context, aVar, onClickListener, Boolean.valueOf(z)})) == null) {
            int i = b.b[aVar.c.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            f = null;
                        } else {
                            f = j(context);
                        }
                    } else {
                        f = e(context);
                    }
                } else {
                    f = a(context);
                }
            } else {
                f = f(context);
            }
            f.setText(aVar.a);
            int i2 = aVar.b;
            if (i2 != 0) {
                f.setTextColor(i2);
            }
            if (z) {
                nv4.d(f).z(R.dimen.T_X08);
            }
            f.setOnClickListener(new a(aVar, onClickListener));
            return f;
        }
        return (View) invokeCommon.objValue;
    }

    public static View i(Context context, TBAlertConfig.b bVar, View.OnClickListener onClickListener) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, context, bVar, onClickListener)) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setPadding(0, fj.f(context, R.dimen.M_H_X008), 0, fj.f(context, R.dimen.M_H_X008));
            linearLayout.setGravity(17);
            int i = b.a[bVar.a.ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        linearLayout.setOrientation(1);
                        View g = g(context, bVar.b, onClickListener);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a);
                        layoutParams.setMargins(fj.f(context, R.dimen.M_W_X012), 0, fj.f(context, R.dimen.M_W_X012), fj.f(context, R.dimen.M_H_X005));
                        linearLayout.addView(g, layoutParams);
                        View g2 = g(context, bVar.c, onClickListener);
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, a);
                        layoutParams2.setMargins(fj.f(context, R.dimen.M_W_X012), 0, fj.f(context, R.dimen.M_W_X012), fj.f(context, R.dimen.M_H_X005));
                        linearLayout.addView(g2, layoutParams2);
                        View g3 = g(context, bVar.d, onClickListener);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, a);
                        layoutParams3.setMargins(fj.f(context, R.dimen.M_W_X012), 0, fj.f(context, R.dimen.M_W_X012), 0);
                        linearLayout.addView(g3, layoutParams3);
                    }
                } else {
                    linearLayout.setOrientation(0);
                    if (bVar.b.a.length() <= 6 && bVar.c.a.length() <= 6) {
                        z = false;
                    }
                    View h = h(context, bVar.b, onClickListener, z);
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, a);
                    layoutParams4.setMargins(fj.f(context, R.dimen.M_W_X012), 0, fj.f(context, R.dimen.M_W_X006) / 2, 0);
                    layoutParams4.weight = 1.0f;
                    linearLayout.addView(h, layoutParams4);
                    View h2 = h(context, bVar.c, onClickListener, z);
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, a);
                    layoutParams5.setMargins(fj.f(context, R.dimen.M_W_X006) / 2, 0, fj.f(context, R.dimen.M_W_X012), 0);
                    layoutParams5.weight = 1.0f;
                    linearLayout.addView(h2, layoutParams5);
                }
            } else {
                linearLayout.setOrientation(0);
                linearLayout.setWeightSum(837.0f);
                View g4 = g(context, bVar.b, onClickListener);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, a);
                layoutParams6.weight = 494.0f;
                linearLayout.addView(g4, layoutParams6);
            }
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            return linearLayout;
        }
        return (View) invokeLLL.objValue;
    }
}
