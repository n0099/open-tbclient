package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends v {
    private List<p> atV;
    private List<a> atW;
    private Paint atX;
    private Paint atY;
    private int atZ;
    private int aua;
    private boolean aub;
    private int auc;
    private j aud;
    private boolean aue;
    private boolean auf;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j jVar) {
        super(context);
        this.mSkinType = 0;
        this.atZ = 0;
        this.aub = false;
        this.auc = 0;
        this.aue = false;
        this.auf = false;
        this.aud = jVar;
        init();
    }

    private void init() {
        this.atV = new LinkedList();
        this.atW = new LinkedList();
        this.atX = new Paint();
        this.atY = new Paint();
        this.atX.setStyle(Paint.Style.FILL);
        this.atY.setStyle(Paint.Style.FILL);
        this.aua = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.atV.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, p pVar) {
        this.atV.add(i, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar, int i, boolean z) {
        this.atW.add(new a(yVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CC() {
        v.a aVar;
        bB(true);
        Iterator<p> it = this.atV.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.auc == 1) {
                aVar = new v.a(cVar.getContext().getResources().getDimensionPixelSize(r.e.ds60), cVar.getContext().getResources().getDimensionPixelSize(r.e.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds28);
            } else {
                aVar = new v.a(cVar.getContext().getResources().getDimensionPixelSize(r.e.ds76), cVar.getContext().getResources().getDimensionPixelSize(r.e.ds76), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds10);
            }
            aVar.eE(2);
            addView(cVar, aVar);
        }
        bB(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.v, android.view.View
    public void onMeasure(int i, int i2) {
        TextView notice;
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof c) && (notice = ((c) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                if (((v.a) notice.getLayoutParams()) == null) {
                    generateDefaultLayoutParams();
                }
                measureChildWithMargins(notice, i, 0, i2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.v, android.view.ViewGroup, android.view.View
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
                    if (this.auc == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.auc == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bB(boolean z) {
        v.a aVar;
        for (a aVar2 : this.atW) {
            View view = (View) aVar2.auh;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                aVar = new v.a(-2, -2, 19);
            } else if (layoutParams instanceof v.a) {
                aVar = (v.a) layoutParams;
            } else {
                aVar = new v.a(view.getLayoutParams());
                aVar.gravity = 19;
            }
            if (z && aVar2.position == 1) {
                aVar.eE(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eE(2);
                        break;
                    case 3:
                        aVar.eE(1);
                        break;
                    case 4:
                        aVar.eE(3);
                        break;
                    case 5:
                        aVar.eE(2);
                        view.setVisibility(8);
                        break;
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.atX == null) {
            this.atX = new Paint();
            this.atX.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.atX.setColor(getContext().getResources().getColor(r.d.cp_bg_line_b));
        } else {
            this.atX.setColor(ar.getColor(this.mSkinType, r.d.cp_bg_line_b));
        }
        if (this.auf) {
            canvas.drawRect(0.0f, this.auP[0] - this.aua, getMeasuredWidth(), this.auP[0], this.atX);
        }
        if (this.aue) {
            canvas.drawRect(0.0f, (this.auP[0] + this.auP[1]) - this.aua, getMeasuredWidth(), this.auP[0] + this.auP[1], this.atX);
        }
        if (this.atY == null) {
            this.atY = new Paint();
            this.atY.setStyle(Paint.Style.FILL);
        }
        if (this.atZ > 0) {
            if (this.mSkinType == 0) {
                this.atY.setColor(getContext().getResources().getColor(this.atZ));
            } else {
                this.atY.setColor(ar.getColor(this.mSkinType, this.atZ));
            }
            if (this.aue) {
                i = (this.auP[0] + this.auP[1]) - this.aua;
            } else {
                i = this.auP[0] + this.auP[1];
            }
            canvas.drawRect(0.0f, this.auP[0], getMeasuredWidth(), i, this.atY);
        }
        super.dispatchDraw(canvas);
    }

    public void bC(boolean z) {
        this.aue = z;
    }

    public void bD(boolean z) {
        this.auf = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.atV.clear();
        this.atW.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(x xVar) {
        if (this.auc == 1) {
            if (xVar == null) {
                for (p pVar : this.atV) {
                    if (pVar instanceof View) {
                        ((View) pVar).setSelected(false);
                    }
                }
                return;
            }
            for (p pVar2 : this.atV) {
                if (pVar2 instanceof View) {
                    View view = (View) pVar2;
                    if (pVar2.getToolId() == xVar.id && xVar.auS) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ey(int i) {
        if (i == 2 && CD() && this.aud != null) {
            this.aud.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ez = ez(i);
        if (ez != null) {
            if (ez.position == 5) {
                for (p pVar : this.atV) {
                    if (pVar.getToolId() == 2 || pVar.getToolId() == 1) {
                        pVar.lz();
                    } else {
                        pVar.hide();
                    }
                }
                for (a aVar : this.atW) {
                    if (aVar.auh != null) {
                        if (aVar.position == 5) {
                            aVar.auh.lz();
                        } else {
                            aVar.auh.hide();
                        }
                    }
                }
            } else {
                for (p pVar2 : this.atV) {
                    if (pVar2.getToolId() == 1) {
                        pVar2.hide();
                    } else {
                        if (pVar2 instanceof c) {
                            c cVar = (c) pVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        pVar2.lz();
                    }
                }
                for (a aVar2 : this.atW) {
                    if (aVar2.auh != null) {
                        if (aVar2.position == 5) {
                            aVar2.auh.hide();
                        } else {
                            aVar2.auh.lz();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ez(int i) {
        for (a aVar : this.atW) {
            if (aVar.auh != null && aVar.auh.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CD() {
        for (a aVar : this.atW) {
            if (aVar.position == 5 && aVar.auh != null && (aVar.auh instanceof View) && ((View) aVar.auh).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public p eA(int i) {
        for (p pVar : this.atV) {
            if (pVar.getToolId() == i) {
                return pVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (p pVar : this.atV) {
            pVar.onChangeSkinType(i);
        }
        for (a aVar : this.atW) {
            if (aVar.auh != null) {
                aVar.auh.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.atZ = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (p pVar : this.atV) {
            if (pVar != null && (pVar instanceof View)) {
                ((View) pVar).setEnabled(z);
            }
        }
    }

    public void c(boolean z, int i) {
        for (p pVar : this.atV) {
            if (pVar instanceof View) {
                View view = (View) pVar;
                if (pVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.auc = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aug;
        protected y auh;
        protected int position;

        protected a(y yVar, int i, boolean z) {
            this.aug = false;
            this.auh = null;
            this.position = 0;
            this.auh = yVar;
            this.position = i;
            this.aug = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.atV != null && this.atV.size() != 0) {
            Iterator<p> it = this.atV.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
