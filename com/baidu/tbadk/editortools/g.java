package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.editortools.p;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends p {
    private Paint aAA;
    private Paint aAB;
    private int aAC;
    private int aAD;
    private boolean aAE;
    private int aAF;
    private i aAG;
    private boolean aAH;
    private boolean aAI;
    private boolean aAJ;
    private List<l> aAy;
    private List<a> aAz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.aAC = 0;
        this.aAE = false;
        this.aAF = 0;
        this.aAH = false;
        this.aAI = false;
        this.aAJ = true;
        this.aAG = iVar;
        init();
    }

    private void init() {
        this.aAy = new LinkedList();
        this.aAz = new LinkedList();
        this.aAA = new Paint();
        this.aAB = new Paint();
        this.aAA.setStyle(Paint.Style.FILL);
        this.aAB.setStyle(Paint.Style.FILL);
        this.aAD = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aAy.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.aAy.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.aAz.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CT() {
        p.a aVar;
        bD(true);
        Iterator<l> it = this.aAy.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aAF == 1) {
                aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.f.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds32);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds32);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds28);
                aVar.weight = 1.0f;
            } else {
                aVar = new p.a(cVar.getContext().getResources().getDimensionPixelSize(d.f.ds76), cVar.getContext().getResources().getDimensionPixelSize(d.f.ds76), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds10);
            }
            aVar.eE(2);
            addView(cVar, aVar);
        }
        bD(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.p, android.view.View
    public void onMeasure(int i, int i2) {
        TextView notice;
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof c) && (notice = ((c) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                if (((p.a) notice.getLayoutParams()) == null) {
                    generateDefaultLayoutParams();
                }
                measureChildWithMargins(notice, i, 0, i2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.p, android.view.ViewGroup, android.view.View
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
                    if (this.aAF == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aAF == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bD(boolean z) {
        p.a aVar;
        for (a aVar2 : this.aAz) {
            View view = (View) aVar2.aAL;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                aVar = new p.a(-2, -2, 19);
            } else if (layoutParams instanceof p.a) {
                aVar = (p.a) layoutParams;
            } else {
                aVar = new p.a(view.getLayoutParams());
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
        if (this.aAA == null) {
            this.aAA = new Paint();
            this.aAA.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aAA.setColor(getContext().getResources().getColor(d.e.cp_bg_line_b));
        } else {
            this.aAA.setColor(ai.getColor(this.mSkinType, d.e.cp_bg_line_b));
        }
        if (this.aAJ) {
            if (this.aAI) {
                canvas.drawRect(0.0f, this.aBu[0] - this.aAD, getMeasuredWidth(), this.aBu[0], this.aAA);
            }
            if (this.aAH) {
                canvas.drawRect(0.0f, (this.aBu[0] + this.aBu[1]) - this.aAD, getMeasuredWidth(), this.aBu[0] + this.aBu[1], this.aAA);
            }
        }
        if (this.aAB == null) {
            this.aAB = new Paint();
            this.aAB.setStyle(Paint.Style.FILL);
        }
        if (this.aAC > 0) {
            if (this.mSkinType == 0) {
                this.aAB.setColor(getContext().getResources().getColor(this.aAC));
            } else {
                this.aAB.setColor(ai.getColor(this.mSkinType, this.aAC));
            }
            if (this.aAH && this.aAJ) {
                i = (this.aBu[0] + this.aBu[1]) - this.aAD;
            } else {
                i = this.aBu[0] + this.aBu[1];
            }
            canvas.drawRect(0.0f, this.aBu[0], getMeasuredWidth(), i, this.aAB);
        }
        super.dispatchDraw(canvas);
    }

    public void bE(boolean z) {
        this.aAH = z;
    }

    public void bF(boolean z) {
        this.aAI = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aAy.clear();
        this.aAz.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.aAF == 1) {
            if (rVar == null) {
                for (l lVar : this.aAy) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.aAy) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.aBx) {
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
        if (i == 2 && CU() && this.aAG != null) {
            this.aAG.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ez = ez(i);
        if (ez != null) {
            if (ez.position == 5) {
                for (l lVar : this.aAy) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.lJ();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.aAz) {
                    if (aVar.aAL != null) {
                        if (aVar.position == 5) {
                            aVar.aAL.lJ();
                        } else {
                            aVar.aAL.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.aAy) {
                    if (lVar2.getToolId() == 1) {
                        lVar2.hide();
                    } else {
                        if (lVar2 instanceof c) {
                            c cVar = (c) lVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        lVar2.lJ();
                    }
                }
                for (a aVar2 : this.aAz) {
                    if (aVar2.aAL != null) {
                        if (aVar2.position == 5) {
                            aVar2.aAL.hide();
                        } else {
                            aVar2.aAL.lJ();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ez(int i) {
        for (a aVar : this.aAz) {
            if (aVar.aAL != null && aVar.aAL.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CU() {
        for (a aVar : this.aAz) {
            if (aVar.position == 5 && aVar.aAL != null && (aVar.aAL instanceof View) && ((View) aVar.aAL).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l eA(int i) {
        for (l lVar : this.aAy) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (l lVar : this.aAy) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.aAz) {
            if (aVar.aAL != null) {
                aVar.aAL.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aAC = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.aAy) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void c(boolean z, int i) {
        for (l lVar : this.aAy) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aAF = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aAK;
        protected s aAL;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.aAK = false;
            this.aAL = null;
            this.position = 0;
            this.aAL = sVar;
            this.position = i;
            this.aAK = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.aAy != null && this.aAy.size() != 0) {
            Iterator<l> it = this.aAy.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
