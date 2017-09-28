package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.p;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends p {
    private boolean aAA;
    private int aAB;
    private i aAC;
    private boolean aAD;
    private boolean aAE;
    private boolean aAF;
    private List<l> aAu;
    private List<a> aAv;
    private Paint aAw;
    private Paint aAx;
    private int aAy;
    private int aAz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.aAy = 0;
        this.aAA = false;
        this.aAB = 0;
        this.aAD = false;
        this.aAE = false;
        this.aAF = true;
        this.aAC = iVar;
        init();
    }

    private void init() {
        this.aAu = new LinkedList();
        this.aAv = new LinkedList();
        this.aAw = new Paint();
        this.aAx = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.f.ds20), 0, getResources().getDimensionPixelSize(d.f.ds20), 0);
        this.aAw.setStyle(Paint.Style.FILL);
        this.aAx.setStyle(Paint.Style.FILL);
        this.aAz = com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aAu.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.aAu.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.aAv.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CA() {
        p.a aVar;
        bB(true);
        Iterator<l> it = this.aAu.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aAB == 1) {
                aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.f.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds32);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds32);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds28);
                aVar.weight = 1.0f;
            } else {
                aVar = new p.a(-2, -2, 80);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds7);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds7);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds15);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(d.f.ds15);
            }
            aVar.eR(2);
            addView(cVar, aVar);
        }
        bB(false);
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
                    if (this.aAB == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aAB == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bB(boolean z) {
        p.a aVar;
        for (a aVar2 : this.aAv) {
            View view = (View) aVar2.aAH;
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
                aVar.eR(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eR(2);
                        break;
                    case 3:
                        aVar.eR(1);
                        break;
                    case 4:
                        aVar.eR(3);
                        break;
                    case 5:
                        aVar.eR(2);
                        view.setVisibility(8);
                        break;
                }
                if (((s) view).getToolId() == 8) {
                    aj.j(this, d.e.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.e.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aAw == null) {
            this.aAw = new Paint();
            this.aAw.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aAw.setColor(getContext().getResources().getColor(d.e.cp_bg_line_b));
        } else {
            this.aAw.setColor(aj.getColor(this.mSkinType, d.e.cp_bg_line_b));
        }
        if (this.aAF) {
            if (this.aAE) {
                canvas.drawRect(0.0f, this.aBr[0] - this.aAz, getMeasuredWidth(), this.aBr[0], this.aAw);
            }
            if (this.aAD) {
                canvas.drawRect(0.0f, (this.aBr[0] + this.aBr[1]) - this.aAz, getMeasuredWidth(), this.aBr[0] + this.aBr[1], this.aAw);
            }
        }
        if (this.aAx == null) {
            this.aAx = new Paint();
            this.aAx.setStyle(Paint.Style.FILL);
        }
        if (this.aAy > 0) {
            if (this.mSkinType == 0) {
                this.aAx.setColor(getContext().getResources().getColor(this.aAy));
            } else {
                this.aAx.setColor(aj.getColor(this.mSkinType, this.aAy));
            }
            if (this.aAD && this.aAF) {
                i = (this.aBr[0] + this.aBr[1]) - this.aAz;
            } else {
                i = this.aBr[0] + this.aBr[1];
            }
            canvas.drawRect(0.0f, this.aBr[0], getMeasuredWidth(), i, this.aAx);
        }
        super.dispatchDraw(canvas);
    }

    public void bC(boolean z) {
        this.aAD = z;
    }

    public void bD(boolean z) {
        this.aAE = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aAu.clear();
        this.aAv.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.aAB == 1) {
            if (rVar == null) {
                for (l lVar : this.aAu) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.aAu) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.aBu) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eL(int i) {
        if (i == 2 && CB() && this.aAC != null) {
            this.aAC.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eM = eM(i);
        if (eM != null) {
            if (eM.position == 5) {
                for (l lVar : this.aAu) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.lM();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.aAv) {
                    if (aVar.aAH != null) {
                        if (aVar.position == 5) {
                            aVar.aAH.lM();
                        } else {
                            aVar.aAH.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.aAu) {
                    if (lVar2.getToolId() == 1) {
                        lVar2.hide();
                    } else {
                        if (lVar2 instanceof c) {
                            c cVar = (c) lVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        lVar2.lM();
                    }
                }
                for (a aVar2 : this.aAv) {
                    if (aVar2.aAH != null) {
                        if (aVar2.position == 5) {
                            aVar2.aAH.hide();
                        } else {
                            aVar2.aAH.lM();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eM(int i) {
        for (a aVar : this.aAv) {
            if (aVar.aAH != null && aVar.aAH.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CB() {
        for (a aVar : this.aAv) {
            if (aVar.position == 5 && aVar.aAH != null && (aVar.aAH instanceof View) && ((View) aVar.aAH).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l eN(int i) {
        for (l lVar : this.aAu) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (l lVar : this.aAu) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.aAv) {
            if (aVar.aAH != null) {
                aVar.aAH.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aAy = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.aAu) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void d(boolean z, int i) {
        for (l lVar : this.aAu) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aAB = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aAG;
        protected s aAH;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.aAG = false;
            this.aAH = null;
            this.position = 0;
            this.aAH = sVar;
            this.position = i;
            this.aAG = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aAu != null && this.aAu.size() != 0) {
            Iterator<l> it = this.aAu.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
