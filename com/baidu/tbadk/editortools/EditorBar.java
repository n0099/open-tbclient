package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.j0.w.h;
import d.a.j0.w.m;
import d.a.j0.w.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class EditorBar extends RawLayout {
    public List<h> m;
    public List<a> n;
    public int o;
    public Paint p;
    public Paint q;
    public int r;
    public int s;
    public int t;
    public EditorTools u;
    public boolean v;
    public boolean w;
    public boolean x;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public n f12829a;

        /* renamed from: b  reason: collision with root package name */
        public int f12830b;

        public a(n nVar, int i2, boolean z) {
            this.f12829a = null;
            this.f12830b = 0;
            this.f12829a = nVar;
            this.f12830b = i2;
        }
    }

    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.o = 0;
        this.r = 0;
        this.t = 0;
        this.v = false;
        this.w = false;
        this.x = true;
        this.u = editorTools;
        t(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i2;
        if (this.p == null) {
            Paint paint = new Paint();
            this.p = paint;
            paint.setStyle(Paint.Style.FILL);
        }
        this.p.setColor(SkinManager.getColor(this.o, R.color.CAM_X0207));
        if (this.x) {
            if (this.w) {
                canvas.drawRect(0.0f, this.k[0] - this.s, getMeasuredWidth(), this.k[0], this.p);
            }
            if (this.v) {
                int[] iArr = this.k;
                float measuredWidth = getMeasuredWidth();
                int[] iArr2 = this.k;
                canvas.drawRect(0.0f, (iArr[0] + iArr[1]) - this.s, measuredWidth, iArr2[0] + iArr2[1], this.p);
            }
        }
        if (this.q == null) {
            Paint paint2 = new Paint();
            this.q = paint2;
            paint2.setStyle(Paint.Style.FILL);
        }
        int i3 = this.r;
        if (i3 > 0) {
            int i4 = this.o;
            if (i4 == 0) {
                this.q.setColor(getContext().getResources().getColor(this.r));
            } else {
                this.q.setColor(SkinManager.getColor(i4, i3));
            }
            if (this.v && this.x) {
                int[] iArr3 = this.k;
                i2 = (iArr3[0] + iArr3[1]) - this.s;
            } else {
                int[] iArr4 = this.k;
                i2 = iArr4[0] + iArr4[1];
            }
            canvas.drawRect(0.0f, this.k[0], getMeasuredWidth(), i2, this.q);
        }
        super.dispatchDraw(canvas);
    }

    public int getBarLauncherType() {
        return this.t;
    }

    public void i(int i2, h hVar) {
        this.m.add(i2, hVar);
    }

    public void j(h hVar) {
        this.m.add(hVar);
    }

    public void k(n nVar, int i2, boolean z) {
        this.n.add(new a(nVar, i2, z));
    }

    public void l() {
        RawLayout.LayoutParams layoutParams;
        if (!ListUtils.isEmpty(this.m) || this.t == 4) {
            m(true);
            boolean z = false;
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                h hVar = this.m.get(i2);
                if (hVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) hVar;
                    int i3 = this.t;
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
                        if (i2 == this.m.size() - 1) {
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
                        if (i2 == this.m.size() - 1) {
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
            m(false);
        }
    }

    public final void m(boolean z) {
        RawLayout.LayoutParams layoutParams;
        int i2;
        for (a aVar : this.n) {
            View view = (View) aVar.f12829a;
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = new RawLayout.LayoutParams(-1, -2, 19);
            } else if (layoutParams2 instanceof RawLayout.LayoutParams) {
                layoutParams = (RawLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = new RawLayout.LayoutParams(view.getLayoutParams());
                ((LinearLayout.LayoutParams) layoutParams).gravity = 19;
            }
            if (z && aVar.f12830b == 1) {
                layoutParams.a(2);
                addView(view, layoutParams);
            } else if (!z && (i2 = aVar.f12830b) != 1) {
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

    public void n(m mVar) {
        int i2 = this.t;
        if (i2 == 1) {
            if (mVar == null) {
                for (h hVar : this.m) {
                    if (hVar instanceof View) {
                        ((View) hVar).setSelected(false);
                    }
                }
                return;
            }
            for (h hVar2 : this.m) {
                if (hVar2 instanceof View) {
                    View view = (View) hVar2;
                    if (hVar2.getToolId() == mVar.f50776c && mVar.f50782i) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (i2 == 3 || i2 == 2 || i2 == 5) {
            if (mVar == null) {
                for (h hVar3 : this.m) {
                    if (hVar3 instanceof View) {
                        ((View) hVar3).setSelected(false);
                    }
                }
                return;
            }
            int i3 = mVar.f50776c;
            if (i3 == 5 || i3 == 2 || i3 == 6) {
                for (h hVar4 : this.m) {
                    if (hVar4 instanceof View) {
                        View view2 = (View) hVar4;
                        if (hVar4.getToolId() == mVar.f50776c && mVar.f50782i) {
                            view2.setSelected(true);
                        } else {
                            view2.setSelected(false);
                        }
                    }
                }
            }
        }
    }

    public void o(int i2) {
        EditorTools editorTools;
        if (i2 == 2 && u() && (editorTools = this.u) != null) {
            editorTools.A(new d.a.j0.w.a(1, 3, null));
            return;
        }
        a r = r(i2);
        if (r == null) {
            return;
        }
        if (r.f12830b == 5) {
            for (h hVar : this.m) {
                if (hVar.getToolId() != 2 && hVar.getToolId() != 1) {
                    hVar.hide();
                } else {
                    hVar.b();
                }
            }
            for (a aVar : this.n) {
                n nVar = aVar.f12829a;
                if (nVar != null) {
                    if (aVar.f12830b == 5) {
                        nVar.b();
                    } else {
                        nVar.hide();
                    }
                }
            }
        } else {
            for (h hVar2 : this.m) {
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
            for (a aVar2 : this.n) {
                n nVar2 = aVar2.f12829a;
                if (nVar2 != null) {
                    if (aVar2.f12830b == 5) {
                        nVar2.hide();
                    } else {
                        nVar2.b();
                    }
                }
            }
        }
        invalidate();
    }

    @Override // com.baidu.tbadk.editortools.RawLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        BLauncher bLauncher;
        TextView notice;
        int right;
        int e2;
        int left;
        super.onLayout(z, i2, i3, i4, i5);
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if ((childAt instanceof BLauncher) && (notice = (bLauncher = (BLauncher) childAt).getNotice()) != null && bLauncher.getDrawable() != null) {
                int intrinsicWidth = bLauncher.getDrawable().getIntrinsicWidth();
                int intrinsicHeight = bLauncher.getDrawable().getIntrinsicHeight();
                int measuredWidth = (childAt.getMeasuredWidth() - intrinsicWidth) / 2;
                int measuredHeight = (childAt.getMeasuredHeight() - intrinsicHeight) / 2;
                int i7 = this.t;
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

    @Override // com.baidu.tbadk.editortools.RawLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        TextView notice;
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

    public void p() {
        this.m.clear();
        this.n.clear();
    }

    public h q(int i2) {
        for (h hVar : this.m) {
            if (hVar.getToolId() == i2) {
                return hVar;
            }
        }
        return null;
    }

    public final a r(int i2) {
        for (a aVar : this.n) {
            n nVar = aVar.f12829a;
            if (nVar != null && nVar.getToolId() == i2) {
                return aVar;
            }
        }
        return null;
    }

    public View s(int i2) {
        for (h hVar : this.m) {
            if (hVar instanceof View) {
                View view = (View) hVar;
                if (hVar.getToolId() == i2) {
                    return view;
                }
            }
        }
        return null;
    }

    public void setBackgroundColorId(int i2) {
        this.r = i2;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (h hVar : this.m) {
            if (hVar != null && (hVar instanceof View)) {
                ((View) hVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i2) {
        this.t = i2;
    }

    public final void t(Context context) {
        setClipToPadding(false);
        this.m = new LinkedList();
        this.n = new LinkedList();
        this.p = new Paint();
        this.q = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0, getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0);
        this.p.setStyle(Paint.Style.FILL);
        this.q.setStyle(Paint.Style.FILL);
        this.s = getResources().getDimensionPixelSize(R.dimen.L_X01);
    }

    public final boolean u() {
        n nVar;
        for (a aVar : this.n) {
            if (aVar.f12830b == 5 && (nVar = aVar.f12829a) != null && (nVar instanceof View) && ((View) nVar).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void v(int i2) {
        this.o = i2;
        SkinManager.setBackgroundColor(this, this.r);
        for (h hVar : this.m) {
            hVar.onChangeSkinType(i2);
        }
        for (a aVar : this.n) {
            n nVar = aVar.f12829a;
            if (nVar != null) {
                nVar.onChangeSkinType(i2);
            }
        }
        invalidate();
    }

    public void w(View.OnClickListener onClickListener) {
        List<h> list = this.m;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<h> it = this.m.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(onClickListener);
        }
    }

    public boolean x(boolean z, int i2) {
        for (h hVar : this.m) {
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

    public void y(boolean z) {
        this.v = z;
    }

    public void z(boolean z) {
        this.w = z;
    }
}
