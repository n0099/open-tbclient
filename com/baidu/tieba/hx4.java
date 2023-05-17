package com.baidu.tieba;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes5.dex */
public class hx4 {
    public static /* synthetic */ Interceptable $ic;
    public static String f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Map<String, gx4> b;
    public Resources c;
    public Resources d;
    public boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947839077, "Lcom/baidu/tieba/hx4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947839077, "Lcom/baidu/tieba/hx4;");
        }
    }

    public hx4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = new HashMap();
        this.e = false;
    }

    public void c() {
        Map<String, gx4> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (map = this.b) != null) {
            map.clear();
            this.b = null;
        }
    }

    public static int h(Resources resources, Resources resources2, int i) {
        String str;
        int i2;
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, resources, resources2, i)) == null) {
            try {
                str = resources.getResourceName(i);
            } catch (Exception unused) {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                String packageName = SkinManager.getPackageName();
                f = packageName;
                if (StringUtils.isNull(packageName)) {
                    f = BdBaseApplication.getInst().getPackageName();
                }
                str = f + str.substring(str.indexOf(":"));
                i2 = resources2.getIdentifier(str + SkinManager.darkSuffix, null, null);
            } else {
                i2 = i;
            }
            if (i2 == 0) {
                BdLog.e(str + " 缺少深色资源,使用了日间资源");
                return i;
            }
            return i2;
        }
        return invokeLLI.intValue;
    }

    public final int d(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 2 && (this.e || skinType != 4)) {
                if (!z) {
                    return this.c.getColor(i);
                }
                if (i == i2) {
                    Resources resources = this.c;
                    this.d = resources;
                    i2 = h(resources, resources, i);
                }
                Resources resources2 = this.d;
                if (resources2 == null) {
                    return this.c.getColor(i);
                }
                try {
                    return resources2.getColor(i2);
                } catch (Resources.NotFoundException unused) {
                    return this.c.getColor(i);
                }
            }
            return SkinManager.getColor(i);
        }
        return invokeCommon.intValue;
    }

    public final ColorStateList e(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 2 && (this.e || skinType != 4)) {
                if (!z) {
                    return this.c.getColorStateList(i);
                }
                if (i == i2) {
                    Resources resources = this.c;
                    this.d = resources;
                    i2 = h(resources, resources, i);
                }
                Resources resources2 = this.d;
                if (resources2 == null) {
                    return this.c.getColorStateList(i);
                }
                try {
                    return resources2.getColorStateList(i2);
                } catch (Resources.NotFoundException unused) {
                    return this.c.getColorStateList(i);
                }
            }
            return SkinManager.getColorList(i);
        }
        return (ColorStateList) invokeCommon.objValue;
    }

    public final Drawable g(boolean z, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 2 && (this.e || skinType != 4)) {
                if (!z) {
                    try {
                        return this.c.getDrawable(i);
                    } catch (Throwable unused) {
                        return null;
                    }
                }
                if (i == i2) {
                    Resources resources = this.c;
                    this.d = resources;
                    i2 = h(resources, resources, i);
                }
                Resources resources2 = this.d;
                if (resources2 == null) {
                    try {
                        return this.c.getDrawable(i);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
                try {
                    try {
                        return resources2.getDrawable(i2);
                    } catch (Throwable unused3) {
                        return null;
                    }
                } catch (Resources.NotFoundException unused4) {
                    return this.c.getDrawable(i);
                } catch (ArrayIndexOutOfBoundsException unused5) {
                    return null;
                }
            }
            return SkinManager.getDrawable(i);
        }
        return (Drawable) invokeCommon.objValue;
    }

    public final void a(View view2) {
        Drawable g;
        Drawable g2;
        Drawable g3;
        int q;
        ColorStateList f2;
        ColorStateList f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            String str = "@" + view2.getId();
            Map<String, gx4> map = this.b;
            if (map != null && map.containsKey(str)) {
                gx4 gx4Var = this.b.get(str);
                if (view2 instanceof TextView) {
                    if (gx4Var.v() != 0 && (f3 = f(this.a, gx4Var.u(), gx4Var.v())) != null) {
                        ((TextView) view2).setTextColor(f3);
                    }
                    if (gx4Var.t() != 0 && (f2 = f(this.a, gx4Var.s(), gx4Var.t())) != null) {
                        ((TextView) view2).setHintTextColor(f2);
                    }
                    if (gx4Var.r() != 0) {
                        TextView textView = (TextView) view2;
                        Context context = view2.getContext();
                        if (this.a) {
                            q = gx4Var.r();
                        } else {
                            q = gx4Var.q();
                        }
                        textView.setTextAppearance(context, q);
                    }
                    if (gx4Var.k() != 0) {
                        ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, g(this.a, gx4Var.j(), gx4Var.k()), (Drawable) null, (Drawable) null);
                    }
                    if (gx4Var.g() != 0) {
                        ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds(g(this.a, gx4Var.f(), gx4Var.g()), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                    if (gx4Var.i() != 0) {
                        ((TextView) view2).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, g(this.a, gx4Var.h(), gx4Var.i()), (Drawable) null);
                    }
                } else if (view2 instanceof ImageButton) {
                    if (gx4Var.n() != 0 && (g3 = g(this.a, gx4Var.m(), gx4Var.n())) != null) {
                        ((ImageView) view2).setImageDrawable(g3);
                    }
                } else if (view2 instanceof ImageView) {
                    if (gx4Var.n() != 0 && (g2 = g(this.a, gx4Var.m(), gx4Var.n())) != null) {
                        ((ImageView) view2).setImageDrawable(g2);
                    }
                } else if ((view2 instanceof ProgressBar) && gx4Var.p() != 0 && (g = g(this.a, gx4Var.o(), gx4Var.p())) != null) {
                    ((ProgressBar) view2).setProgressDrawable(g);
                }
                if (gx4Var.c() != 0) {
                    int paddingLeft = view2.getPaddingLeft();
                    int paddingTop = view2.getPaddingTop();
                    int paddingRight = view2.getPaddingRight();
                    int paddingBottom = view2.getPaddingBottom();
                    String resourceTypeName = this.c.getResourceTypeName(gx4Var.b());
                    if (resourceTypeName != null && resourceTypeName.equals("color")) {
                        view2.setBackgroundColor(d(this.a, gx4Var.b(), gx4Var.c()));
                    } else {
                        view2.setBackgroundDrawable(g(this.a, gx4Var.b(), gx4Var.c()));
                    }
                    view2.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            }
        }
    }

    public final void b(ViewGroup viewGroup) throws Resources.NotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) {
            String str = "@" + viewGroup.getId();
            Map<String, gx4> map = this.b;
            if (map != null && map.containsKey(str)) {
                gx4 gx4Var = this.b.get(str);
                if (viewGroup instanceof AdapterView) {
                    if ((viewGroup instanceof ListView) && gx4Var.e() != 0) {
                        ListView listView = (ListView) viewGroup;
                        int dividerHeight = listView.getDividerHeight();
                        listView.setDivider(g(this.a, gx4Var.d(), gx4Var.e()));
                        listView.setDividerHeight(dividerHeight);
                    }
                    Adapter adapter = ((AdapterView) viewGroup).getAdapter();
                    if (adapter != null && (adapter instanceof BaseAdapter)) {
                        ((BaseAdapter) adapter).notifyDataSetChanged();
                    }
                }
                if (gx4Var.c() != 0) {
                    int paddingLeft = viewGroup.getPaddingLeft();
                    int paddingTop = viewGroup.getPaddingTop();
                    int paddingRight = viewGroup.getPaddingRight();
                    int paddingBottom = viewGroup.getPaddingBottom();
                    String resourceTypeName = this.c.getResourceTypeName(gx4Var.b());
                    if (resourceTypeName != null && resourceTypeName.equals("color")) {
                        viewGroup.setBackgroundColor(d(this.a, gx4Var.b(), gx4Var.c()));
                    } else {
                        viewGroup.setBackgroundDrawable(g(this.a, gx4Var.b(), gx4Var.c()));
                    }
                    viewGroup.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                }
            }
        }
    }

    public final ColorStateList f(boolean z, int i, int i2) {
        String str;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            try {
                return e(z, i, i2);
            } catch (Exception e) {
                try {
                    str = this.c.getResourceName(i);
                } catch (Exception unused) {
                    str = "";
                }
                TiebaStatic.log(new StatisticItem("getColorListCrash").param("obj_source", e.toString()).param("obj_param1", i).param(TiebaStatic.Params.OBJ_PARAM2, str));
                return null;
            }
        }
        return (ColorStateList) invokeCommon.objValue;
    }

    public final int[] i(String str) {
        InterceptResult invokeL;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (!TextUtils.isDigitsOnly(str.substring(1)) || (parseInt = Integer.parseInt(str.substring(1))) == 0) {
                return null;
            }
            return new int[]{parseInt, h(this.c, this.d, parseInt)};
        }
        return (int[]) invokeL.objValue;
    }

    public void j(String str, Context context, AttributeSet attributeSet) {
        int[] i;
        int e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, context, attributeSet) == null) {
            try {
                Resources resources = context.getResources();
                this.c = resources;
                this.d = resources;
                int attributeCount = attributeSet.getAttributeCount();
                gx4 gx4Var = new gx4();
                gx4Var.R(str);
                boolean z = false;
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    String attributeName = attributeSet.getAttributeName(i2);
                    String attributeValue = attributeSet.getAttributeValue(i2);
                    if (attributeName.equals("id")) {
                        gx4Var.G(attributeValue);
                    } else if (attributeName.equals("tb_background")) {
                        int[] i3 = i(attributeValue);
                        if (i3 != null) {
                            gx4Var.w(i3[0]);
                            gx4Var.x(i3[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_src")) {
                        int[] i4 = i(attributeValue);
                        if (i4 != null) {
                            gx4Var.H(i4[0]);
                            gx4Var.I(i4[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_textColor")) {
                        int[] i5 = i(attributeValue);
                        if (i5 != null) {
                            gx4Var.P(i5[0]);
                            gx4Var.Q(i5[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_style")) {
                        int[] i6 = i(attributeValue);
                        if (i6 != null) {
                            gx4Var.L(i6[0]);
                            gx4Var.M(i6[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_divider")) {
                        int[] i7 = i(attributeValue);
                        if (i7 != null) {
                            gx4Var.y(i7[0]);
                            gx4Var.z(i7[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableTop")) {
                        int[] i8 = i(attributeValue);
                        if (i8 != null) {
                            gx4Var.E(i8[0]);
                            gx4Var.F(i8[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableLeft")) {
                        int[] i9 = i(attributeValue);
                        if (i9 != null) {
                            gx4Var.A(i9[0]);
                            gx4Var.B(i9[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_drawableRight")) {
                        int[] i10 = i(attributeValue);
                        if (i10 != null) {
                            gx4Var.C(i10[0]);
                            gx4Var.D(i10[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_progressDrawable")) {
                        int[] i11 = i(attributeValue);
                        if (i11 != null) {
                            gx4Var.J(i11[0]);
                            gx4Var.K(i11[1]);
                            z = true;
                        }
                    } else if (attributeName.equals("tb_textColorHint") && (i = i(attributeValue)) != null) {
                        gx4Var.N(i[0]);
                        gx4Var.O(i[1]);
                        z = true;
                    }
                    if (z && TbConfig.getDebugSwitch() && (e = pg.e(attributeValue.substring(1), 0)) != 0) {
                        String resourceName = this.c.getResourceName(e);
                        gx4Var.a(attributeName + "=" + resourceName);
                    }
                }
                if (z && !TextUtils.isEmpty(gx4Var.l()) && this.b != null && !this.b.containsKey(gx4Var.l())) {
                    this.b.put(gx4Var.l(), gx4Var);
                }
            } catch (Resources.NotFoundException unused) {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void k(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, view2) != null) || view2 == null) {
            return;
        }
        Stack stack = new Stack();
        stack.push(view2);
        while (!stack.isEmpty()) {
            View view3 = (View) stack.pop();
            if (view3 instanceof ViewGroup) {
                try {
                    b((ViewGroup) view3);
                } catch (Resources.NotFoundException e) {
                    BdLog.e(e);
                }
                if (!(view3 instanceof AdapterView)) {
                    ViewGroup viewGroup = (ViewGroup) view3;
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        stack.push(viewGroup.getChildAt(i));
                    }
                }
            } else {
                a(view3);
            }
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a = z;
        }
    }

    public void m(Resources resources) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, resources) == null) {
            this.d = resources;
        }
    }
}
