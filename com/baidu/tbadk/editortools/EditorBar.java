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
import c.a.o0.w.h;
import c.a.o0.w.m;
import c.a.o0.w.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class EditorBar extends RawLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<h> i;
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

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public n a;

        /* renamed from: b  reason: collision with root package name */
        public int f30474b;

        public a(n nVar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.f30474b = 0;
            this.a = nVar;
            this.f30474b = i;
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
                    canvas.drawRect(0.0f, this.f30495g[0] - this.o, getMeasuredWidth(), this.f30495g[0], this.l);
                }
                if (this.r) {
                    int[] iArr = this.f30495g;
                    float measuredWidth = getMeasuredWidth();
                    int[] iArr2 = this.f30495g;
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
                    int[] iArr3 = this.f30495g;
                    i = (iArr3[0] + iArr3[1]) - this.o;
                } else {
                    int[] iArr4 = this.f30495g;
                    i = iArr4[0] + iArr4[1];
                }
                canvas.drawRect(0.0f, this.f30495g[0], getMeasuredWidth(), i, this.m);
            }
            super.dispatchDraw(canvas);
        }
    }

    public int getBarLauncherType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : invokeV.intValue;
    }

    public void i(int i, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, hVar) == null) {
            this.i.add(i, hVar);
        }
    }

    public void j(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hVar) == null) {
            this.i.add(hVar);
        }
    }

    public void k(n nVar, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{nVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.j.add(new a(nVar, i, z));
        }
    }

    public void l() {
        RawLayout.LayoutParams layoutParams;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!ListUtils.isEmpty(this.i) || (i = this.p) == 4 || i == 6) {
                m(true);
                boolean z = false;
                for (int i2 = 0; i2 < this.i.size(); i2++) {
                    h hVar = this.i.get(i2);
                    if (hVar instanceof BLauncher) {
                        BLauncher bLauncher = (BLauncher) hVar;
                        int i3 = this.p;
                        int i4 = 2;
                        if (i3 == 2) {
                            layoutParams = new RawLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702c4), c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702c4), 80);
                            ((LinearLayout.LayoutParams) layoutParams).leftMargin = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f070207);
                            ((LinearLayout.LayoutParams) layoutParams).rightMargin = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f070207);
                            ((LinearLayout.LayoutParams) layoutParams).topMargin = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f070269);
                            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f070269);
                        } else {
                            if (i3 == 3) {
                                layoutParams = new RawLayout.LayoutParams(0, c.a.d.f.p.n.f(getContext(), R.dimen.tbds62), 48);
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
                                layoutParams = new RawLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.tbds62), c.a.d.f.p.n.f(getContext(), R.dimen.tbds62), 48);
                                ((LinearLayout.LayoutParams) layoutParams).leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                                if (i2 == this.i.size() - 1) {
                                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                                } else {
                                    ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                                }
                                ((LinearLayout.LayoutParams) layoutParams).topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                            } else if (i3 == 5) {
                                layoutParams = new RawLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702c4), c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702c4), 80);
                                ((LinearLayout.LayoutParams) layoutParams).leftMargin = c.a.d.f.p.n.f(getContext(), R.dimen.tbds44);
                                ((LinearLayout.LayoutParams) layoutParams).rightMargin = c.a.d.f.p.n.f(getContext(), R.dimen.tbds78);
                                ((LinearLayout.LayoutParams) layoutParams).topMargin = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f070269);
                                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f070269);
                            } else {
                                layoutParams = new RawLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702c4), c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f0702c4), 80);
                                ((LinearLayout.LayoutParams) layoutParams).leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ef);
                                ((LinearLayout.LayoutParams) layoutParams).rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702ef);
                                ((LinearLayout.LayoutParams) layoutParams).bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070245);
                                ((LinearLayout.LayoutParams) layoutParams).topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070245);
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
                View view = (View) aVar.a;
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams = new RawLayout.LayoutParams(-1, -2, 19);
                } else if (layoutParams2 instanceof RawLayout.LayoutParams) {
                    layoutParams = (RawLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = new RawLayout.LayoutParams(view.getLayoutParams());
                    ((LinearLayout.LayoutParams) layoutParams).gravity = 19;
                }
                if (z && aVar.f30474b == 1) {
                    layoutParams.a(2);
                    addView(view, layoutParams);
                } else if (!z && (i = aVar.f30474b) != 1) {
                    if (i == 2) {
                        layoutParams.a(2);
                    } else if (i == 3) {
                        layoutParams.a(1);
                    } else if (i == 4) {
                        layoutParams.a(3);
                    } else if (i == 5) {
                        layoutParams.a(2);
                        view.setVisibility(8);
                    }
                    if (((n) view).getToolId() == 8) {
                        SkinManager.setBackgroundResource(this, R.color.common_color_10055);
                        view.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                    }
                    addView(view, layoutParams);
                }
            }
        }
    }

    public void n(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, mVar) == null) {
            int i = this.p;
            if (i == 1) {
                if (mVar == null) {
                    for (h hVar : this.i) {
                        if (hVar instanceof View) {
                            ((View) hVar).setSelected(false);
                        }
                    }
                    return;
                }
                for (h hVar2 : this.i) {
                    if (hVar2 instanceof View) {
                        View view = (View) hVar2;
                        if (hVar2.getToolId() == mVar.f11509c && mVar.i) {
                            view.setSelected(true);
                        } else {
                            view.setSelected(false);
                        }
                        int i2 = mVar.f11509c;
                        if (i2 == 12 || i2 == 16) {
                            if (hVar2.getToolId() == 2) {
                                view.setSelected(true);
                            } else {
                                view.setSelected(false);
                            }
                        }
                    }
                }
            } else if (i == 3 || i == 2 || i == 5) {
                if (mVar == null) {
                    for (h hVar3 : this.i) {
                        if (hVar3 instanceof View) {
                            ((View) hVar3).setSelected(false);
                        }
                    }
                    return;
                }
                int i3 = mVar.f11509c;
                if (i3 == 5 || i3 == 2 || i3 == 6) {
                    for (h hVar4 : this.i) {
                        if (hVar4 instanceof View) {
                            View view2 = (View) hVar4;
                            if (hVar4.getToolId() == mVar.f11509c && mVar.i) {
                                view2.setSelected(true);
                            } else {
                                view2.setSelected(false);
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
                editorTools.A(new c.a.o0.w.a(1, 3, null));
                return;
            }
            a r = r(i);
            if (r == null) {
                return;
            }
            if (r.f30474b == 5) {
                for (h hVar : this.i) {
                    if (hVar.getToolId() != 2 && hVar.getToolId() != 1) {
                        hVar.hide();
                    } else {
                        hVar.b();
                    }
                }
                for (a aVar : this.j) {
                    n nVar = aVar.a;
                    if (nVar != null) {
                        if (aVar.f30474b == 5) {
                            nVar.b();
                        } else {
                            nVar.hide();
                        }
                    }
                }
            } else {
                for (h hVar2 : this.i) {
                    if (hVar2.getToolId() == 1) {
                        hVar2.hide();
                    } else {
                        if (hVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) hVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        hVar2.b();
                    }
                }
                for (a aVar2 : this.j) {
                    n nVar2 = aVar2.a;
                    if (nVar2 != null) {
                        if (aVar2.f30474b == 5) {
                            nVar2.hide();
                        } else {
                            nVar2.b();
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
        int d2;
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
                            int top = (childAt.getTop() + measuredHeight) - c.a.d.f.p.n.d(getContext(), 4.0f);
                            notice.layout(left, top, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top);
                        } else {
                            right = childAt.getRight() - measuredWidth;
                            d2 = c.a.d.f.p.n.d(getContext(), 9.0f);
                            left = right - d2;
                            int top2 = (childAt.getTop() + measuredHeight) - c.a.d.f.p.n.d(getContext(), 4.0f);
                            notice.layout(left, top2, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top2);
                        }
                    } else if (i6 == 0) {
                        right = childAt.getRight() - measuredWidth;
                        d2 = c.a.d.f.p.n.d(getContext(), 9.0f);
                        left = right - d2;
                        int top22 = (childAt.getTop() + measuredHeight) - c.a.d.f.p.n.d(getContext(), 4.0f);
                        notice.layout(left, top22, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top22);
                    } else {
                        left = 0;
                        int top222 = (childAt.getTop() + measuredHeight) - c.a.d.f.p.n.d(getContext(), 4.0f);
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

    public h q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            for (h hVar : this.i) {
                if (hVar.getToolId() == i) {
                    return hVar;
                }
            }
            return null;
        }
        return (h) invokeI.objValue;
    }

    public final a r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            for (a aVar : this.j) {
                n nVar = aVar.a;
                if (nVar != null && nVar.getToolId() == i) {
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
            for (h hVar : this.i) {
                if (hVar instanceof View) {
                    View view = (View) hVar;
                    if (hVar.getToolId() == i) {
                        return view;
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
            for (h hVar : this.i) {
                if (hVar != null && (hVar instanceof View)) {
                    ((View) hVar).setEnabled(z);
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
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            for (a aVar : this.j) {
                if (aVar.f30474b == 5 && (nVar = aVar.a) != null && (nVar instanceof View) && ((View) nVar).getVisibility() == 0) {
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
            for (h hVar : this.i) {
                hVar.onChangeSkinType(i);
            }
            for (a aVar : this.j) {
                n nVar = aVar.a;
                if (nVar != null) {
                    nVar.onChangeSkinType(i);
                }
            }
            invalidate();
        }
    }

    public void w(View.OnClickListener onClickListener) {
        List<h> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) || (list = this.i) == null || list.size() == 0) {
            return;
        }
        Iterator<h> it = this.i.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(onClickListener);
        }
    }

    public boolean x(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            for (h hVar : this.i) {
                if (hVar instanceof View) {
                    View view = (View) hVar;
                    if (hVar.getToolId() == i) {
                        view.setEnabled(z);
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
