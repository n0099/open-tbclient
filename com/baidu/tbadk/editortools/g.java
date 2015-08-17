package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.u;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends u {
    private List<p> aom;
    private List<a> aon;
    private Paint aoo;
    private Paint aop;
    private int aoq;
    private int aor;
    private int aos;
    private boolean aot;
    private int aou;
    private j aov;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j jVar) {
        super(context);
        this.mSkinType = 0;
        this.aoq = 0;
        this.aos = 0;
        this.aot = false;
        this.aou = 0;
        this.aov = jVar;
        init();
    }

    private void init() {
        this.aom = new LinkedList();
        this.aon = new LinkedList();
        this.aoo = new Paint();
        this.aop = new Paint();
        this.aoo.setStyle(Paint.Style.FILL);
        this.aop.setStyle(Paint.Style.FILL);
        this.aor = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.aom.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, p pVar) {
        this.aom.add(i, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(w wVar, int i, boolean z) {
        this.aon.add(new a(wVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Az() {
        u.a aVar;
        ba(true);
        Iterator<p> it = this.aom.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aou == 1) {
                aVar = new u.a(cVar.getContext().getResources().getDimensionPixelSize(i.d.ds48), cVar.getContext().getResources().getDimensionPixelSize(i.d.ds48), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds28);
            } else {
                aVar = new u.a(cVar.getContext().getResources().getDimensionPixelSize(i.d.pb_editor_button_width), cVar.getContext().getResources().getDimensionPixelSize(i.d.pb_editor_button_height), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds10);
            }
            aVar.dN(2);
            addView(cVar, aVar);
        }
        ba(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.u, android.view.View
    public void onMeasure(int i, int i2) {
        TextView notice;
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof c) && (notice = ((c) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                if (((u.a) notice.getLayoutParams()) == null) {
                    generateDefaultLayoutParams();
                }
                measureChildWithMargins(notice, i, 0, i2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.u, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int right;
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt instanceof c) {
                TextView notice = ((c) childAt).getNotice();
                c cVar = (c) childAt;
                if (notice != null && cVar.getDrawable() != null) {
                    int intrinsicWidth = cVar.getDrawable().getIntrinsicWidth();
                    int intrinsicHeight = cVar.getDrawable().getIntrinsicHeight();
                    int measuredWidth = (childAt.getMeasuredWidth() - intrinsicWidth) / 2;
                    int measuredHeight = (childAt.getMeasuredHeight() - intrinsicHeight) / 2;
                    if (this.aou == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aou == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void ba(boolean z) {
        u.a aVar;
        for (a aVar2 : this.aon) {
            View view = (View) aVar2.aox;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                aVar = new u.a(-2, -2, 19);
            } else if (layoutParams instanceof u.a) {
                aVar = (u.a) layoutParams;
            } else {
                aVar = new u.a(view.getLayoutParams());
                aVar.gravity = 19;
            }
            if (z && aVar2.position == 1) {
                aVar.dN(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.dN(2);
                        break;
                    case 3:
                        aVar.dN(1);
                        break;
                    case 4:
                        aVar.dN(3);
                        break;
                    case 5:
                        aVar.dN(2);
                        view.setVisibility(8);
                        break;
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.aoo == null) {
            this.aoo = new Paint();
            this.aoo.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aoo.setColor(getContext().getResources().getColor(i.c.cp_bg_line_b));
        } else {
            this.aoo.setColor(al.getColor(i.c.cp_bg_line_b));
        }
        if (this.aos == 1) {
            canvas.drawRect(0.0f, this.apd[0], getMeasuredWidth(), this.aor + this.apd[0], this.aoo);
        } else if (this.aos == 2) {
            canvas.drawRect(0.0f, (this.apd[0] + this.apd[1]) - this.aor, getMeasuredWidth(), this.apd[0] + this.apd[1], this.aoo);
        }
        if (this.aop == null) {
            this.aop = new Paint();
            this.aop.setStyle(Paint.Style.FILL);
        }
        if (this.aoq > 0) {
            if (this.mSkinType == 0) {
                this.aop.setColor(getContext().getResources().getColor(this.aoq));
            } else {
                this.aop.setColor(al.getColor(this.aoq));
            }
            canvas.drawRect(0.0f, this.apd[0], getMeasuredWidth(), this.apd[0] + this.apd[1], this.aop);
        }
        super.dispatchDraw(canvas);
    }

    public void setLinePosition(int i) {
        this.aos = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aom.clear();
        this.aon.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(v vVar) {
        if (this.aou == 1) {
            if (vVar == null) {
                for (p pVar : this.aom) {
                    if (pVar instanceof View) {
                        ((View) pVar).setSelected(false);
                    }
                }
                return;
            }
            for (p pVar2 : this.aom) {
                if (pVar2 instanceof View) {
                    View view = (View) pVar2;
                    if (pVar2.getToolId() == vVar.id && vVar.apg) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dH(int i) {
        if (i == 2 && AA() && this.aov != null) {
            this.aov.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a dI = dI(i);
        if (dI != null) {
            if (dI.position == 5) {
                for (p pVar : this.aom) {
                    if (pVar.getToolId() == 2 || pVar.getToolId() == 1) {
                        pVar.oy();
                    } else {
                        pVar.hide();
                    }
                }
                for (a aVar : this.aon) {
                    if (aVar.aox != null) {
                        if (aVar.position == 5) {
                            aVar.aox.oy();
                        } else {
                            aVar.aox.hide();
                        }
                    }
                }
            } else {
                for (p pVar2 : this.aom) {
                    if (pVar2.getToolId() == 1) {
                        pVar2.hide();
                    } else {
                        pVar2.oy();
                    }
                }
                for (a aVar2 : this.aon) {
                    if (aVar2.aox != null) {
                        if (aVar2.position == 5) {
                            aVar2.aox.hide();
                        } else {
                            aVar2.aox.oy();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a dI(int i) {
        for (a aVar : this.aon) {
            if (aVar.aox != null && aVar.aox.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean AA() {
        for (a aVar : this.aon) {
            if (aVar.position == 5 && aVar.aox != null && (aVar.aox instanceof View) && ((View) aVar.aox).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public p dJ(int i) {
        for (p pVar : this.aom) {
            if (pVar.getToolId() == i) {
                return pVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (p pVar : this.aom) {
            pVar.onChangeSkinType(i);
        }
        for (a aVar : this.aon) {
            if (aVar.aox != null) {
                aVar.aox.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aoq = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (p pVar : this.aom) {
            if (pVar != null && (pVar instanceof View)) {
                ((View) pVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aou = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aow;
        protected w aox;
        protected int position;

        protected a(w wVar, int i, boolean z) {
            this.aow = false;
            this.aox = null;
            this.position = 0;
            this.aox = wVar;
            this.position = i;
            this.aow = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View.OnClickListener onClickListener) {
        if (this.aom != null && this.aom.size() != 0) {
            Iterator<p> it = this.aom.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
