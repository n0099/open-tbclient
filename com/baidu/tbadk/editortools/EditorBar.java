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
import com.baidu.tieba.fj;
import com.baidu.tieba.l55;
import com.baidu.tieba.s55;
import com.baidu.tieba.w55;
import com.baidu.tieba.x55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class EditorBar extends RawLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List i;
    public List j;
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
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public x55 a;
        public int b;

        public a(x55 x55Var, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x55Var, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.a = x55Var;
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

    public boolean x(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            for (s55 s55Var : this.i) {
                if (s55Var instanceof View) {
                    View view2 = (View) s55Var;
                    if (s55Var.getToolId() == i) {
                        view2.setEnabled(z);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
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

    public void n(w55 w55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, w55Var) == null) {
            int i = this.p;
            if (i == 1) {
                if (w55Var == null) {
                    for (s55 s55Var : this.i) {
                        if (s55Var instanceof View) {
                            ((View) s55Var).setSelected(false);
                        }
                    }
                    return;
                }
                for (s55 s55Var2 : this.i) {
                    if (s55Var2 instanceof View) {
                        View view2 = (View) s55Var2;
                        if (s55Var2.getToolId() == w55Var.c && w55Var.k) {
                            view2.setSelected(true);
                        } else {
                            view2.setSelected(false);
                        }
                        int i2 = w55Var.c;
                        if (i2 == 12 || i2 == 16) {
                            if (s55Var2.getToolId() == 2) {
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
                            x55 x55Var = aVar.a;
                            if (x55Var instanceof View) {
                                View view3 = (View) x55Var;
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
            } else if (w55Var == null) {
                for (s55 s55Var3 : this.i) {
                    if (s55Var3 instanceof View) {
                        ((View) s55Var3).setSelected(false);
                    }
                }
            } else {
                int i3 = w55Var.c;
                if (i3 == 5 || i3 == 2 || i3 == 6) {
                    for (s55 s55Var4 : this.i) {
                        if (s55Var4 instanceof View) {
                            View view4 = (View) s55Var4;
                            if (s55Var4.getToolId() == w55Var.c && w55Var.k) {
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
                editorTools.A(new l55(1, 3, null));
                return;
            }
            a r = r(i);
            if (r == null) {
                return;
            }
            if (r.b == 5) {
                for (s55 s55Var : this.i) {
                    if (s55Var.getToolId() != 2 && s55Var.getToolId() != 1) {
                        s55Var.hide();
                    } else {
                        s55Var.display();
                    }
                }
                for (a aVar : this.j) {
                    x55 x55Var = aVar.a;
                    if (x55Var != null) {
                        int i2 = aVar.b;
                        if (i2 != 5 && i2 != 8) {
                            x55Var.hide();
                        } else {
                            aVar.a.display();
                        }
                    }
                }
            } else {
                for (s55 s55Var2 : this.i) {
                    if (s55Var2.getToolId() == 1) {
                        s55Var2.hide();
                    } else {
                        if (s55Var2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) s55Var2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        s55Var2.display();
                    }
                }
                for (a aVar2 : this.j) {
                    x55 x55Var2 = aVar2.a;
                    if (x55Var2 != null) {
                        int i3 = aVar2.b;
                        if (i3 == 5) {
                            x55Var2.hide();
                        } else if (i3 != 8) {
                            x55Var2.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    public int getBarLauncherType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.i.clear();
            this.j.clear();
        }
    }

    public void i(int i, s55 s55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, s55Var) == null) {
            this.i.add(i, s55Var);
        }
    }

    public void j(s55 s55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, s55Var) == null) {
            this.i.add(s55Var);
        }
    }

    public s55 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            for (s55 s55Var : this.i) {
                if (s55Var.getToolId() == i) {
                    return s55Var;
                }
            }
            return null;
        }
        return (s55) invokeI.objValue;
    }

    public final a r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            for (a aVar : this.j) {
                x55 x55Var = aVar.a;
                if (x55Var != null && x55Var.getToolId() == i) {
                    return aVar;
                }
            }
            return null;
        }
        return (a) invokeI.objValue;
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
            for (s55 s55Var : this.i) {
                if (s55Var != null && (s55Var instanceof View)) {
                    ((View) s55Var).setEnabled(z);
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

    public void k(x55 x55Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{x55Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.j.add(new a(x55Var, i, z));
        }
    }

    public void l() {
        RawLayout.LayoutParams layoutParams;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (ListUtils.isEmpty(this.i) && (i = this.p) != 4 && i != 6 && i != 8) {
                return;
            }
            m(true);
            boolean z = false;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                s55 s55Var = (s55) this.i.get(i2);
                if (s55Var instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) s55Var;
                    int i3 = this.p;
                    int i4 = 2;
                    if (i3 == 2) {
                        layoutParams = new RawLayout.LayoutParams(fj.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), fj.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), 80);
                        ((LinearLayout.LayoutParams) layoutParams).leftMargin = fj.f(getContext(), R.dimen.obfuscated_res_0x7f070207);
                        ((LinearLayout.LayoutParams) layoutParams).rightMargin = fj.f(getContext(), R.dimen.obfuscated_res_0x7f070207);
                        ((LinearLayout.LayoutParams) layoutParams).topMargin = fj.f(getContext(), R.dimen.obfuscated_res_0x7f070272);
                        ((LinearLayout.LayoutParams) layoutParams).bottomMargin = fj.f(getContext(), R.dimen.obfuscated_res_0x7f070272);
                    } else {
                        if (i3 == 3) {
                            layoutParams = new RawLayout.LayoutParams(0, fj.f(getContext(), R.dimen.tbds62), 48);
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
                            layoutParams = new RawLayout.LayoutParams(fj.f(getContext(), R.dimen.tbds62), fj.f(getContext(), R.dimen.tbds62), 48);
                            ((LinearLayout.LayoutParams) layoutParams).leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                            if (i2 == this.i.size() - 1) {
                                ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                            } else {
                                ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                            }
                            ((LinearLayout.LayoutParams) layoutParams).topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        } else if (i3 == 5) {
                            layoutParams = new RawLayout.LayoutParams(fj.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), fj.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), 80);
                            ((LinearLayout.LayoutParams) layoutParams).leftMargin = fj.f(getContext(), R.dimen.tbds44);
                            ((LinearLayout.LayoutParams) layoutParams).rightMargin = fj.f(getContext(), R.dimen.tbds78);
                            ((LinearLayout.LayoutParams) layoutParams).topMargin = fj.f(getContext(), R.dimen.obfuscated_res_0x7f070272);
                            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = fj.f(getContext(), R.dimen.obfuscated_res_0x7f070272);
                        } else if (i3 == 7) {
                            int f = fj.f(getContext(), R.dimen.tbds68);
                            RawLayout.LayoutParams layoutParams2 = new RawLayout.LayoutParams(f, f, 80);
                            ((LinearLayout.LayoutParams) layoutParams2).rightMargin = fj.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
                            ((LinearLayout.LayoutParams) layoutParams2).bottomMargin = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds46);
                            ((LinearLayout.LayoutParams) layoutParams2).topMargin = fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds46);
                            layoutParams = layoutParams2;
                        } else {
                            layoutParams = new RawLayout.LayoutParams(fj.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), fj.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), 80);
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
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i == 8) {
                                        layoutParams.a(2);
                                    }
                                } else {
                                    layoutParams.a(2);
                                    view2.setVisibility(8);
                                }
                            } else {
                                layoutParams.a(3);
                            }
                        } else {
                            layoutParams.a(1);
                        }
                    } else {
                        layoutParams.a(2);
                    }
                    if (((x55) view2).getToolId() == 8) {
                        SkinManager.setBackgroundResource(this, R.color.common_color_10055);
                        view2.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                    }
                    addView(view2, layoutParams);
                }
            }
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
                    if (i6 != 1 && i6 != 3 && i6 != 2) {
                        if (i6 == 0) {
                            right = childAt.getRight() - measuredWidth;
                            d = fj.d(getContext(), 9.0f);
                            left = right - d;
                            int top = (childAt.getTop() + measuredHeight) - fj.d(getContext(), 4.0f);
                            notice.layout(left, top, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top);
                        } else {
                            left = 0;
                            int top2 = (childAt.getTop() + measuredHeight) - fj.d(getContext(), 4.0f);
                            notice.layout(left, top2, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top2);
                        }
                    } else if (TextUtils.isEmpty(notice.getText())) {
                        left = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        int top22 = (childAt.getTop() + measuredHeight) - fj.d(getContext(), 4.0f);
                        notice.layout(left, top22, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top22);
                    } else {
                        right = childAt.getRight() - measuredWidth;
                        d = fj.d(getContext(), 9.0f);
                        left = right - d;
                        int top222 = (childAt.getTop() + measuredHeight) - fj.d(getContext(), 4.0f);
                        notice.layout(left, top222, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top222);
                    }
                }
            }
        }
    }

    public View s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            for (s55 s55Var : this.i) {
                if (s55Var instanceof View) {
                    View view2 = (View) s55Var;
                    if (s55Var.getToolId() == i) {
                        return view2;
                    }
                }
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public void w(View.OnClickListener onClickListener) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) && (list = this.i) != null && list.size() != 0) {
            for (s55 s55Var : this.i) {
                ((View) s55Var).setOnClickListener(onClickListener);
            }
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

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.k = i;
            SkinManager.setBackgroundColor(this, this.n);
            for (s55 s55Var : this.i) {
                s55Var.onChangeSkinType(i);
            }
            for (a aVar : this.j) {
                x55 x55Var = aVar.a;
                if (x55Var != null) {
                    x55Var.onChangeSkinType(i);
                }
            }
            invalidate();
        }
    }

    public final boolean u() {
        InterceptResult invokeV;
        x55 x55Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            for (a aVar : this.j) {
                if (aVar.b == 5 && (x55Var = aVar.a) != null && (x55Var instanceof View) && ((View) x55Var).getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
