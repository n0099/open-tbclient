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
import c.a.e.e.p.l;
import c.a.q0.x.h;
import c.a.q0.x.m;
import c.a.q0.x.n;
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
/* loaded from: classes6.dex */
public class EditorBar extends RawLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<h> l;
    public List<a> m;
    public int n;
    public Paint o;
    public Paint p;
    public int q;
    public int r;
    public int s;
    public EditorTools t;
    public boolean u;
    public boolean v;
    public boolean w;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public n f48294a;

        /* renamed from: b  reason: collision with root package name */
        public int f48295b;

        public a(n nVar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48294a = null;
            this.f48295b = 0;
            this.f48294a = nVar;
            this.f48295b = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 0;
        this.q = 0;
        this.s = 0;
        this.u = false;
        this.v = false;
        this.w = true;
        this.t = editorTools;
        j(context);
    }

    public void addLauncher(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            this.l.add(hVar);
        }
    }

    public void addToolView(n nVar, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{nVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.m.add(new a(nVar, i2, z));
        }
    }

    public void build() {
        RawLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (!ListUtils.isEmpty(this.l) || this.s == 4) {
                h(true);
                boolean z = false;
                for (int i2 = 0; i2 < this.l.size(); i2++) {
                    h hVar = this.l.get(i2);
                    if (hVar instanceof BLauncher) {
                        BLauncher bLauncher = (BLauncher) hVar;
                        int i3 = this.s;
                        if (i3 == 2) {
                            layoutParams = new RawLayout.LayoutParams(l.g(getContext(), R.dimen.ds48), l.g(getContext(), R.dimen.ds48), 80);
                            ((LinearLayout.LayoutParams) layoutParams).leftMargin = l.g(getContext(), R.dimen.ds32);
                            ((LinearLayout.LayoutParams) layoutParams).rightMargin = l.g(getContext(), R.dimen.ds32);
                            ((LinearLayout.LayoutParams) layoutParams).topMargin = l.g(getContext(), R.dimen.ds21);
                            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = l.g(getContext(), R.dimen.ds21);
                        } else if (i3 == 3) {
                            layoutParams = new RawLayout.LayoutParams(0, l.g(getContext(), R.dimen.tbds62), 48);
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
                            if (i2 == this.l.size() - 1) {
                                ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                            } else {
                                ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                            }
                            ((LinearLayout.LayoutParams) layoutParams).topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                            ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
                        } else if (i3 == 1) {
                            layoutParams = new RawLayout.LayoutParams(l.g(getContext(), R.dimen.tbds62), l.g(getContext(), R.dimen.tbds62), 48);
                            ((LinearLayout.LayoutParams) layoutParams).leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                            if (i2 == this.l.size() - 1) {
                                ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                            } else {
                                ((LinearLayout.LayoutParams) layoutParams).rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                            }
                            ((LinearLayout.LayoutParams) layoutParams).topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        } else if (i3 == 5) {
                            layoutParams = new RawLayout.LayoutParams(l.g(getContext(), R.dimen.ds48), l.g(getContext(), R.dimen.ds48), 80);
                            ((LinearLayout.LayoutParams) layoutParams).leftMargin = l.g(getContext(), R.dimen.tbds44);
                            ((LinearLayout.LayoutParams) layoutParams).rightMargin = l.g(getContext(), R.dimen.tbds78);
                            ((LinearLayout.LayoutParams) layoutParams).topMargin = l.g(getContext(), R.dimen.ds21);
                            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = l.g(getContext(), R.dimen.ds21);
                        } else {
                            layoutParams = new RawLayout.LayoutParams(l.g(getContext(), R.dimen.ds48), l.g(getContext(), R.dimen.ds48), 80);
                            ((LinearLayout.LayoutParams) layoutParams).leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                            ((LinearLayout.LayoutParams) layoutParams).rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                            ((LinearLayout.LayoutParams) layoutParams).bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                            ((LinearLayout.LayoutParams) layoutParams).topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        }
                        layoutParams.a(2);
                        addView(bLauncher, layoutParams);
                    }
                }
                h(false);
            }
        }
    }

    public void changeToLauncher(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mVar) == null) {
            int i2 = this.s;
            if (i2 == 1) {
                if (mVar == null) {
                    for (h hVar : this.l) {
                        if (hVar instanceof View) {
                            ((View) hVar).setSelected(false);
                        }
                    }
                    return;
                }
                for (h hVar2 : this.l) {
                    if (hVar2 instanceof View) {
                        View view = (View) hVar2;
                        if (hVar2.getToolId() == mVar.f15125c && mVar.f15131i) {
                            view.setSelected(true);
                        } else {
                            view.setSelected(false);
                        }
                        int i3 = mVar.f15125c;
                        if (i3 == 12 || i3 == 16) {
                            if (hVar2.getToolId() == 2) {
                                view.setSelected(true);
                            } else {
                                view.setSelected(false);
                            }
                        }
                    }
                }
            } else if (i2 == 3 || i2 == 2 || i2 == 5) {
                if (mVar == null) {
                    for (h hVar3 : this.l) {
                        if (hVar3 instanceof View) {
                            ((View) hVar3).setSelected(false);
                        }
                    }
                    return;
                }
                int i4 = mVar.f15125c;
                if (i4 == 5 || i4 == 2 || i4 == 6) {
                    for (h hVar4 : this.l) {
                        if (hVar4 instanceof View) {
                            View view2 = (View) hVar4;
                            if (hVar4.getToolId() == mVar.f15125c && mVar.f15131i) {
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

    public void changeToTool(int i2) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 == 2 && k() && (editorTools = this.t) != null) {
                editorTools.sendAction(new c.a.q0.x.a(1, 3, null));
                return;
            }
            a i3 = i(i2);
            if (i3 == null) {
                return;
            }
            if (i3.f48295b == 5) {
                for (h hVar : this.l) {
                    if (hVar.getToolId() != 2 && hVar.getToolId() != 1) {
                        hVar.hide();
                    } else {
                        hVar.display();
                    }
                }
                for (a aVar : this.m) {
                    n nVar = aVar.f48294a;
                    if (nVar != null) {
                        if (aVar.f48295b == 5) {
                            nVar.display();
                        } else {
                            nVar.hide();
                        }
                    }
                }
            } else {
                for (h hVar2 : this.l) {
                    if (hVar2.getToolId() == 1) {
                        hVar2.hide();
                    } else {
                        if (hVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) hVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        hVar2.display();
                    }
                }
                for (a aVar2 : this.m) {
                    n nVar2 = aVar2.f48294a;
                    if (nVar2 != null) {
                        if (aVar2.f48295b == 5) {
                            nVar2.hide();
                        } else {
                            nVar2.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l.clear();
            this.m.clear();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            if (this.o == null) {
                Paint paint = new Paint();
                this.o = paint;
                paint.setStyle(Paint.Style.FILL);
            }
            this.o.setColor(SkinManager.getColor(this.n, R.color.CAM_X0207));
            if (this.w) {
                if (this.v) {
                    canvas.drawRect(0.0f, this.mRawHeight[0] - this.r, getMeasuredWidth(), this.mRawHeight[0], this.o);
                }
                if (this.u) {
                    int[] iArr = this.mRawHeight;
                    float measuredWidth = getMeasuredWidth();
                    int[] iArr2 = this.mRawHeight;
                    canvas.drawRect(0.0f, (iArr[0] + iArr[1]) - this.r, measuredWidth, iArr2[0] + iArr2[1], this.o);
                }
            }
            if (this.p == null) {
                Paint paint2 = new Paint();
                this.p = paint2;
                paint2.setStyle(Paint.Style.FILL);
            }
            int i3 = this.q;
            if (i3 > 0) {
                int i4 = this.n;
                if (i4 == 0) {
                    this.p.setColor(getContext().getResources().getColor(this.q));
                } else {
                    this.p.setColor(SkinManager.getColor(i4, i3));
                }
                if (this.u && this.w) {
                    int[] iArr3 = this.mRawHeight;
                    i2 = (iArr3[0] + iArr3[1]) - this.r;
                } else {
                    int[] iArr4 = this.mRawHeight;
                    i2 = iArr4[0] + iArr4[1];
                }
                canvas.drawRect(0.0f, this.mRawHeight[0], getMeasuredWidth(), i2, this.p);
            }
            super.dispatchDraw(canvas);
        }
    }

    public h findLauncherById(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            for (h hVar : this.l) {
                if (hVar.getToolId() == i2) {
                    return hVar;
                }
            }
            return null;
        }
        return (h) invokeI.objValue;
    }

    public int getBarLauncherType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.s : invokeV.intValue;
    }

    public View getLauncherForId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            for (h hVar : this.l) {
                if (hVar instanceof View) {
                    View view = (View) hVar;
                    if (hVar.getToolId() == i2) {
                        return view;
                    }
                }
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public final void h(boolean z) {
        RawLayout.LayoutParams layoutParams;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            for (a aVar : this.m) {
                View view = (View) aVar.f48294a;
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams = new RawLayout.LayoutParams(-1, -2, 19);
                } else if (layoutParams2 instanceof RawLayout.LayoutParams) {
                    layoutParams = (RawLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = new RawLayout.LayoutParams(view.getLayoutParams());
                    ((LinearLayout.LayoutParams) layoutParams).gravity = 19;
                }
                if (z && aVar.f48295b == 1) {
                    layoutParams.a(2);
                    addView(view, layoutParams);
                } else if (!z && (i2 = aVar.f48295b) != 1) {
                    if (i2 == 2) {
                        layoutParams.a(2);
                    } else if (i2 == 3) {
                        layoutParams.a(1);
                    } else if (i2 == 4) {
                        layoutParams.a(3);
                    } else if (i2 == 5) {
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

    public boolean hasTheLauncher(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            for (h hVar : this.l) {
                if (hVar.getToolId() == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final a i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            for (a aVar : this.m) {
                n nVar = aVar.f48294a;
                if (nVar != null && nVar.getToolId() == i2) {
                    return aVar;
                }
            }
            return null;
        }
        return (a) invokeI.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            setClipToPadding(false);
            this.l = new LinkedList();
            this.m = new LinkedList();
            this.o = new Paint();
            this.p = new Paint();
            setPadding(getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0, getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0);
            this.o.setStyle(Paint.Style.FILL);
            this.p.setStyle(Paint.Style.FILL);
            this.r = getResources().getDimensionPixelSize(R.dimen.L_X01);
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            for (a aVar : this.m) {
                if (aVar.f48295b == 5 && (nVar = aVar.f48294a) != null && (nVar instanceof View) && ((View) nVar).getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.n = i2;
            SkinManager.setBackgroundColor(this, this.q);
            for (h hVar : this.l) {
                hVar.onChangeSkinType(i2);
            }
            for (a aVar : this.m) {
                n nVar = aVar.f48294a;
                if (nVar != null) {
                    nVar.onChangeSkinType(i2);
                }
            }
            invalidate();
        }
    }

    @Override // com.baidu.tbadk.editortools.RawLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        BLauncher bLauncher;
        TextView notice;
        int right;
        int e2;
        int left;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                if ((childAt instanceof BLauncher) && (notice = (bLauncher = (BLauncher) childAt).getNotice()) != null && bLauncher.getDrawable() != null) {
                    int intrinsicWidth = bLauncher.getDrawable().getIntrinsicWidth();
                    int intrinsicHeight = bLauncher.getDrawable().getIntrinsicHeight();
                    int measuredWidth = (childAt.getMeasuredWidth() - intrinsicWidth) / 2;
                    int measuredHeight = (childAt.getMeasuredHeight() - intrinsicHeight) / 2;
                    int i7 = this.s;
                    if (i7 == 1 || i7 == 3 || i7 == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            left = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                            int top = (childAt.getTop() + measuredHeight) - l.e(getContext(), 4.0f);
                            notice.layout(left, top, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top);
                        } else {
                            right = childAt.getRight() - measuredWidth;
                            e2 = l.e(getContext(), 9.0f);
                            left = right - e2;
                            int top2 = (childAt.getTop() + measuredHeight) - l.e(getContext(), 4.0f);
                            notice.layout(left, top2, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top2);
                        }
                    } else if (i7 == 0) {
                        right = childAt.getRight() - measuredWidth;
                        e2 = l.e(getContext(), 9.0f);
                        left = right - e2;
                        int top22 = (childAt.getTop() + measuredHeight) - l.e(getContext(), 4.0f);
                        notice.layout(left, top22, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top22);
                    } else {
                        left = 0;
                        int top222 = (childAt.getTop() + measuredHeight) - l.e(getContext(), 4.0f);
                        notice.layout(left, top222, notice.getMeasuredWidth() + left, notice.getMeasuredHeight() + top222);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.RawLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        TextView notice;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if ((childAt instanceof BLauncher) && (notice = ((BLauncher) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                    if (((RawLayout.LayoutParams) notice.getLayoutParams()) == null) {
                        generateDefaultLayoutParams();
                    }
                    measureChildWithMargins(notice, i2, 0, i3, 0);
                }
            }
        }
    }

    public void resetLaunchers(View.OnClickListener onClickListener) {
        List<h> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) || (list = this.l) == null || list.size() == 0) {
            return;
        }
        Iterator<h> it = this.l.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(onClickListener);
        }
    }

    public void setBackgroundColorId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setBarLauncherEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            for (h hVar : this.l) {
                if (hVar != null && (hVar instanceof View)) {
                    ((View) hVar).setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.s = i2;
        }
    }

    public void showLinePositionBottom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.u = z;
        }
    }

    public void showLinePositionTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.v = z;
        }
    }

    public void showNoLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.w = z;
        }
    }

    public void addLauncher(int i2, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hVar) == null) {
            this.l.add(i2, hVar);
        }
    }

    public boolean setBarLauncherEnabled(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            for (h hVar : this.l) {
                if (hVar instanceof View) {
                    View view = (View) hVar;
                    if (hVar.getToolId() == i2) {
                        view.setEnabled(z);
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
