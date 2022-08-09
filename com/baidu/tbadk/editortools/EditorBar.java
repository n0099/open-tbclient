package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tbadk.editortools.emotiontool.EmotionNoLaunchView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h25;
import com.repackage.o25;
import com.repackage.qi;
import com.repackage.s25;
import com.repackage.t25;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class EditorBar extends RawLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<o25> i;
    public List<a> j;
    public int k;
    public Paint l;
    public Paint m;
    public int n;
    public int o;
    public int p;
    public EditorTools q;
    public boolean r;
    public boolean s;
    public boolean t;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public t25 a;
        public int b;

        public a(t25 t25Var, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t25Var, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = 0;
            this.a = t25Var;
            this.b = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, editorTools};
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
        this.k = 0;
        this.n = 0;
        this.p = 0;
        this.r = false;
        this.s = false;
        this.t = true;
        this.q = editorTools;
        t(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.l == null) {
                Paint paint = new Paint();
                this.l = paint;
                paint.setStyle(Paint.Style.FILL);
            }
            this.l.setColor(SkinManager.getColor(this.k, (int) R.color.CAM_X0207));
            if (this.t) {
                if (this.s) {
                    canvas.drawRect(0.0f, this.g[0] - this.o, getMeasuredWidth(), this.g[0], this.l);
                }
                if (this.r) {
                    int[] iArr = this.g;
                    float measuredWidth = getMeasuredWidth();
                    int[] iArr2 = this.g;
                    canvas.drawRect(0.0f, (iArr[0] + iArr[1]) - this.o, measuredWidth, iArr2[0] + iArr2[1], this.l);
                }
            }
            if (this.m == null) {
                Paint paint2 = new Paint();
                this.m = paint2;
                paint2.setStyle(Paint.Style.FILL);
            }
            int i2 = this.n;
            if (i2 > 0) {
                int i3 = this.k;
                if (i3 == 0) {
                    this.m.setColor(getContext().getResources().getColor(this.n));
                } else {
                    this.m.setColor(SkinManager.getColor(i3, i2));
                }
                if (this.r && this.t) {
                    int[] iArr3 = this.g;
                    i = (iArr3[0] + iArr3[1]) - this.o;
                } else {
                    int[] iArr4 = this.g;
                    i = iArr4[0] + iArr4[1];
                }
                canvas.drawRect(0.0f, this.g[0], getMeasuredWidth(), i, this.m);
            }
            super.dispatchDraw(canvas);
        }
    }

    public int getBarLauncherType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : invokeV.intValue;
    }

    public void i(int i, o25 o25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, o25Var) == null) {
            this.i.add(i, o25Var);
        }
    }

    public void j(o25 o25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, o25Var) == null) {
            this.i.add(o25Var);
        }
    }

    public void k(t25 t25Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{t25Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.j.add(new a(t25Var, i, z));
        }
    }

    public void l() {
        RawLayout.LayoutParams layoutParams;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!ListUtils.isEmpty(this.i) || (i = this.p) == 4 || i == 6 || i == 8) {
                m(true);
                boolean z = false;
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    o25 o25Var = this.i.get(i2);
                    if (o25Var instanceof BLauncher) {
                        BLauncher bLauncher = (BLauncher) o25Var;
                        int i3 = this.p;
                        int i4 = 2;
                        if (i3 == 2) {
                            layoutParams = new RawLayout.LayoutParams(qi.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), qi.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), 80);
                            ((LinearLayout.LayoutParams) layoutParams).leftMargin = qi.f(getContext(), R.dimen.obfuscated_res_0x7f070207);
                            ((LinearLayout.LayoutParams) layoutParams).rightMargin = qi.f(getContext(), R.dimen.obfuscated_res_0x7f070207);
                            ((LinearLayout.LayoutParams) layoutParams).topMargin = qi.f(getContext(), R.dimen.obfuscated_res_0x7f070272);
                            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = qi.f(getContext(), R.dimen.obfuscated_res_0x7f070272);
                        } else {
                            if (i3 == 3) {
                                layoutParams = new RawLayout.LayoutParams(0, qi.f(getContext(), R.dimen.tbds62), 48);
                                if (i2 == 0 && TextUtils.isEmpty(bLauncher.getContentDescription())) {
                                    z = true;
                                }
                                if (z && i2 == 1) {
                                    ((LinearLayout.LayoutParams) layoutParams).leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                                } else if (!z && i2 == 0) {
                                    ((LinearLayout.LayoutParams) layoutParams).leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                                } else {
                                    ((LinearLayout.LayoutParams) layoutParams).leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                                }
                                if (i2 == this.i.size() - 1) {
                                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                                } else {
                                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                                }
                                ((LinearLayout.LayoutParams) layoutParams).topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                                ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
                            } else if (i3 == 1) {
                                layoutParams = new RawLayout.LayoutParams(qi.f(getContext(), R.dimen.tbds62), qi.f(getContext(), R.dimen.tbds62), 48);
                                ((LinearLayout.LayoutParams) layoutParams).leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                                if (i2 == this.i.size() - 1) {
                                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                                } else {
                                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                                }
                                ((LinearLayout.LayoutParams) layoutParams).topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                            } else if (i3 == 5) {
                                layoutParams = new RawLayout.LayoutParams(qi.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), qi.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), 80);
                                ((LinearLayout.LayoutParams) layoutParams).leftMargin = qi.f(getContext(), R.dimen.tbds44);
                                ((LinearLayout.LayoutParams) layoutParams).rightMargin = qi.f(getContext(), R.dimen.tbds78);
                                ((LinearLayout.LayoutParams) layoutParams).topMargin = qi.f(getContext(), R.dimen.obfuscated_res_0x7f070272);
                                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = qi.f(getContext(), R.dimen.obfuscated_res_0x7f070272);
                            } else if (i3 == 7) {
                                int f = qi.f(getContext(), R.dimen.tbds68);
                                RawLayout.LayoutParams layoutParams2 = new RawLayout.LayoutParams(f, f, 80);
                                ((LinearLayout.LayoutParams) layoutParams2).rightMargin = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
                                ((LinearLayout.LayoutParams) layoutParams2).bottomMargin = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46);
                                ((LinearLayout.LayoutParams) layoutParams2).topMargin = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds46);
                                layoutParams = layoutParams2;
                            } else {
                                layoutParams = new RawLayout.LayoutParams(qi.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), qi.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), 80);
                                ((LinearLayout.LayoutParams) layoutParams).leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702f6);
                                ((LinearLayout.LayoutParams) layoutParams).rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702f6);
                                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07024c);
                                ((LinearLayout.LayoutParams) layoutParams).topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07024c);
                            }
                            i4 = 2;
                        }
                        layoutParams.a(i4);
                        addView(bLauncher, layoutParams);
                    }
                }
                m(false);
            }
        }
    }

    public final void m(boolean z) {
        RawLayout.LayoutParams layoutParams;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            for (a aVar : this.j) {
                View view2 = (View) aVar.a;
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams = new RawLayout.LayoutParams(-1, -2, 19);
                } else if (layoutParams2 instanceof RawLayout.LayoutParams) {
                    layoutParams = (RawLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = new RawLayout.LayoutParams(view2.getLayoutParams());
                    ((LinearLayout.LayoutParams) layoutParams).gravity = 19;
                }
                if (z && aVar.b == 1) {
                    layoutParams.a(2);
                    addView(view2, layoutParams);
                } else if (!z && (i = aVar.b) != 1) {
                    if (i == 2) {
                        layoutParams.a(2);
                    } else if (i == 3) {
                        layoutParams.a(1);
                    } else if (i == 4) {
                        layoutParams.a(3);
                    } else if (i == 5) {
                        layoutParams.a(2);
                        view2.setVisibility(8);
                    } else if (i == 8) {
                        layoutParams.a(2);
                    }
                    if (((t25) view2).getToolId() == 8) {
                        SkinManager.setBackgroundResource(this, R.color.common_color_10055);
                        view2.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                    }
                    addView(view2, layoutParams);
                }
            }
        }
    }

    public void n(s25 s25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, s25Var) == null) {
            int i = this.p;
            if (i == 1) {
                if (s25Var == null) {
                    for (o25 o25Var : this.i) {
                        if (o25Var instanceof View) {
                            ((View) o25Var).setSelected(false);
                        }
                    }
                    return;
                }
                for (o25 o25Var2 : this.i) {
                    if (o25Var2 instanceof View) {
                        View view2 = (View) o25Var2;
                        if (o25Var2.getToolId() == s25Var.c && s25Var.k) {
                            view2.setSelected(true);
                        } else {
                            view2.setSelected(false);
                        }
                        int i2 = s25Var.c;
                        if (i2 == 12 || i2 == 16) {
                            if (o25Var2.getToolId() == 2) {
                                view2.setSelected(true);
                            } else {
                                view2.setSelected(false);
                            }
                        }
                    }
                }
            } else if (i != 3 && i != 2 && i != 5) {
                if (i == 7) {
                    for (a aVar : this.j) {
                        if (aVar != null) {
                            t25 t25Var = aVar.a;
                            if (t25Var instanceof View) {
                                View view3 = (View) t25Var;
                                if (view3 instanceof EmotionNoLaunchView) {
                                    ((EmotionNoLaunchView) view3).display();
                                    return;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } else if (s25Var == null) {
                for (o25 o25Var3 : this.i) {
                    if (o25Var3 instanceof View) {
                        ((View) o25Var3).setSelected(false);
                    }
                }
            } else {
                int i3 = s25Var.c;
                if (i3 == 5 || i3 == 2 || i3 == 6) {
                    for (o25 o25Var4 : this.i) {
                        if (o25Var4 instanceof View) {
                            View view4 = (View) o25Var4;
                            if (o25Var4.getToolId() == s25Var.c && s25Var.k) {
                                view4.setSelected(true);
                            } else {
                                view4.setSelected(false);
                            }
                        }
                    }
                }
            }
        }
    }

    public void o(int i) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i == 2 && u() && (editorTools = this.q) != null) {
                editorTools.A(new h25(1, 3, null));
                return;
            }
            a r = r(i);
            if (r == null) {
                return;
            }
            if (r.b == 5) {
                for (o25 o25Var : this.i) {
                    if (o25Var.getToolId() != 2 && o25Var.getToolId() != 1) {
                        o25Var.hide();
                    } else {
                        o25Var.display();
                    }
                }
                for (a aVar : this.j) {
                    t25 t25Var = aVar.a;
                    if (t25Var != null) {
                        int i2 = aVar.b;
                        if (i2 != 5 && i2 != 8) {
                            t25Var.hide();
                        } else {
                            aVar.a.display();
                        }
                    }
                }
            } else {
                for (o25 o25Var2 : this.i) {
                    if (o25Var2.getToolId() == 1) {
                        o25Var2.hide();
                    } else {
                        if (o25Var2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) o25Var2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        o25Var2.display();
                    }
                }
                for (a aVar2 : this.j) {
                    t25 t25Var2 = aVar2.a;
                    if (t25Var2 != null) {
                        int i3 = aVar2.b;
                        if (i3 == 5) {
                            t25Var2.hide();
                        } else if (i3 != 8) {
                            t25Var2.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.editortools.RawLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        BLauncher bLauncher;
        TextView notice;
        int right;
        int d;
        int left;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                if ((childAt instanceof BLauncher) && (notice = (bLauncher = (BLauncher) childAt).getNotice()) != null && bLauncher.getDrawable() != null) {
                    int intrinsicWidth = bLauncher.getDrawable().getIntrinsicWidth();
                    int intrinsicHeight = bLauncher.getDrawable().getIntrinsicHeight();
                    int measuredWidth = (childAt.getMeasuredWidth() - intrinsicWidth) / 2;
                    int measuredHeight = (childAt.getMeasuredHeight() - intrinsicHeight) / 2;
                    int i6 = this.p;
                    if (i6 == 1 || i6 == 3 || i6 == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            left = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                            int top = (childAt.getTop() + measuredHeight) - qi.d(getContext(), 4.0f);
                            notice.layout(left, top, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top);
                        } else {
                            right = childAt.getRight() - measuredWidth;
                            d = qi.d(getContext(), 9.0f);
                            left = right - d;
                            int top2 = (childAt.getTop() + measuredHeight) - qi.d(getContext(), 4.0f);
                            notice.layout(left, top2, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top2);
                        }
                    } else if (i6 == 0) {
                        right = childAt.getRight() - measuredWidth;
                        d = qi.d(getContext(), 9.0f);
                        left = right - d;
                        int top22 = (childAt.getTop() + measuredHeight) - qi.d(getContext(), 4.0f);
                        notice.layout(left, top22, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top22);
                    } else {
                        left = 0;
                        int top222 = (childAt.getTop() + measuredHeight) - qi.d(getContext(), 4.0f);
                        notice.layout(left, top222, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top222);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.RawLayout, android.view.View
    public void onMeasure(int i, int i2) {
        TextView notice;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i, i2) == null) {
            super.onMeasure(i, i2);
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if ((childAt instanceof BLauncher) && (notice = ((BLauncher) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                    if (((RawLayout.LayoutParams) notice.getLayoutParams()) == null) {
                        generateDefaultLayoutParams();
                    }
                    measureChildWithMargins(notice, i, 0, i2, 0);
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.i.clear();
            this.j.clear();
        }
    }

    public o25 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            for (o25 o25Var : this.i) {
                if (o25Var.getToolId() == i) {
                    return o25Var;
                }
            }
            return null;
        }
        return (o25) invokeI.objValue;
    }

    public final a r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            for (a aVar : this.j) {
                t25 t25Var = aVar.a;
                if (t25Var != null && t25Var.getToolId() == i) {
                    return aVar;
                }
            }
            return null;
        }
        return (a) invokeI.objValue;
    }

    public View s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            for (o25 o25Var : this.i) {
                if (o25Var instanceof View) {
                    View view2 = (View) o25Var;
                    if (o25Var.getToolId() == i) {
                        return view2;
                    }
                }
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public void setBackgroundColorId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.n = i;
        }
    }

    public void setBarLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            for (o25 o25Var : this.i) {
                if (o25Var != null && (o25Var instanceof View)) {
                    ((View) o25Var).setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.p = i;
        }
    }

    public final void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, context) == null) {
            setClipToPadding(false);
            this.i = new LinkedList();
            this.j = new LinkedList();
            this.l = new Paint();
            this.m = new Paint();
            setPadding(getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0, getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0);
            this.l.setStyle(Paint.Style.FILL);
            this.m.setStyle(Paint.Style.FILL);
            this.o = getResources().getDimensionPixelSize(R.dimen.L_X01);
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        t25 t25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            for (a aVar : this.j) {
                if (aVar.b == 5 && (t25Var = aVar.a) != null && (t25Var instanceof View) && ((View) t25Var).getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.k = i;
            SkinManager.setBackgroundColor(this, this.n);
            for (o25 o25Var : this.i) {
                o25Var.onChangeSkinType(i);
            }
            for (a aVar : this.j) {
                t25 t25Var = aVar.a;
                if (t25Var != null) {
                    t25Var.onChangeSkinType(i);
                }
            }
            invalidate();
        }
    }

    public void w(View.OnClickListener onClickListener) {
        List<o25> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) || (list = this.i) == null || list.size() == 0) {
            return;
        }
        Iterator<o25> it = this.i.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(onClickListener);
        }
    }

    public boolean x(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            for (o25 o25Var : this.i) {
                if (o25Var instanceof View) {
                    View view2 = (View) o25Var;
                    if (o25Var.getToolId() == i) {
                        view2.setEnabled(z);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.r = z;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.s = z;
        }
    }
}
