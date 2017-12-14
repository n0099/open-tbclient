package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.p;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends p {
    private List<l> aBH;
    private List<a> aBI;
    private Paint aBJ;
    private Paint aBK;
    private int aBL;
    private int aBM;
    private int aBN;
    private i aBO;
    private boolean aBP;
    private boolean aBQ;
    private boolean aBR;
    private int mSkinType;
    private int wB;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.aBL = 0;
        this.aBN = 0;
        this.aBP = false;
        this.aBQ = false;
        this.aBR = true;
        this.aBO = iVar;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aBH = new LinkedList();
        this.aBI = new LinkedList();
        this.aBJ = new Paint();
        this.aBK = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.aBJ.setStyle(Paint.Style.FILL);
        this.aBK.setStyle(Paint.Style.FILL);
        this.aBM = getResources().getDimensionPixelSize(d.e.ds1);
        this.wB = ((com.baidu.adp.lib.util.l.ac(context) - com.baidu.adp.lib.util.l.f(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.f(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBH.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.aBH.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.aBI.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Df() {
        p.a aVar;
        if (!v.w(this.aBH)) {
            bx(true);
            for (int i = 0; i < this.aBH.size(); i++) {
                l lVar = this.aBH.get(i);
                if (lVar instanceof c) {
                    c cVar = (c) lVar;
                    if (this.aBN == 2) {
                        aVar = new p.a(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                    } else if (this.aBN == 3) {
                        aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aBN == 1) {
                        aVar = new p.a(cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.aBH.size() - 1) {
                            aVar.rightMargin = this.wB;
                        }
                        aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(d.e.ds15);
                        aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(d.e.ds15);
                    } else {
                        aVar = new p.a(-2, -2, 80);
                        aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(d.e.ds7);
                        aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(d.e.ds7);
                        aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(d.e.ds15);
                        aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(d.e.ds15);
                    }
                    aVar.eR(2);
                    addView(cVar, aVar);
                }
            }
            bx(false);
        }
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
                    if (this.aBN == 1 || this.aBN == 3 || this.aBN == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aBN == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bx(boolean z) {
        p.a aVar;
        for (a aVar2 : this.aBI) {
            View view = (View) aVar2.aBT;
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
                    aj.j(this, d.C0096d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0096d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aBJ == null) {
            this.aBJ = new Paint();
            this.aBJ.setStyle(Paint.Style.FILL);
        }
        this.aBJ.setColor(aj.getColor(this.mSkinType, d.C0096d.cp_bg_line_c));
        if (this.aBR) {
            if (this.aBQ) {
                canvas.drawRect(0.0f, this.aCE[0] - this.aBM, getMeasuredWidth(), this.aCE[0], this.aBJ);
            }
            if (this.aBP) {
                canvas.drawRect(0.0f, (this.aCE[0] + this.aCE[1]) - this.aBM, getMeasuredWidth(), this.aCE[0] + this.aCE[1], this.aBJ);
            }
        }
        if (this.aBK == null) {
            this.aBK = new Paint();
            this.aBK.setStyle(Paint.Style.FILL);
        }
        if (this.aBL > 0) {
            if (this.mSkinType == 0) {
                this.aBK.setColor(getContext().getResources().getColor(this.aBL));
            } else {
                this.aBK.setColor(aj.getColor(this.mSkinType, this.aBL));
            }
            if (this.aBP && this.aBR) {
                i = (this.aCE[0] + this.aCE[1]) - this.aBM;
            } else {
                i = this.aCE[0] + this.aCE[1];
            }
            canvas.drawRect(0.0f, this.aCE[0], getMeasuredWidth(), i, this.aBK);
        }
        super.dispatchDraw(canvas);
    }

    public void by(boolean z) {
        this.aBP = z;
    }

    public void bz(boolean z) {
        this.aBQ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBH.clear();
        this.aBI.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.aBN == 1) {
            if (rVar == null) {
                for (l lVar : this.aBH) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.aBH) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.aCH) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aBN == 3 || this.aBN == 2) {
            if (rVar == null) {
                for (l lVar3 : this.aBH) {
                    if (lVar3 instanceof View) {
                        ((View) lVar3).setSelected(false);
                    }
                }
            } else if (rVar.id == 5 || rVar.id == 2 || rVar.id == 6) {
                for (l lVar4 : this.aBH) {
                    if (lVar4 instanceof View) {
                        View view2 = (View) lVar4;
                        if (lVar4.getToolId() == rVar.id && rVar.aCH) {
                            view2.setSelected(true);
                        } else {
                            view2.setSelected(false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eL(int i) {
        if (i == 2 && Dg() && this.aBO != null) {
            this.aBO.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eM = eM(i);
        if (eM != null) {
            if (eM.position == 5) {
                for (l lVar : this.aBH) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.lE();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.aBI) {
                    if (aVar.aBT != null) {
                        if (aVar.position == 5) {
                            aVar.aBT.lE();
                        } else {
                            aVar.aBT.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.aBH) {
                    if (lVar2.getToolId() == 1) {
                        lVar2.hide();
                    } else {
                        if (lVar2 instanceof c) {
                            c cVar = (c) lVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        lVar2.lE();
                    }
                }
                for (a aVar2 : this.aBI) {
                    if (aVar2.aBT != null) {
                        if (aVar2.position == 5) {
                            aVar2.aBT.hide();
                        } else {
                            aVar2.aBT.lE();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eM(int i) {
        for (a aVar : this.aBI) {
            if (aVar.aBT != null && aVar.aBT.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Dg() {
        for (a aVar : this.aBI) {
            if (aVar.position == 5 && aVar.aBT != null && (aVar.aBT instanceof View) && ((View) aVar.aBT).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l eN(int i) {
        for (l lVar : this.aBH) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aj.k(this, this.aBL);
        for (l lVar : this.aBH) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.aBI) {
            if (aVar.aBT != null) {
                aVar.aBT.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aBL = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.aBH) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void d(boolean z, int i) {
        for (l lVar : this.aBH) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aBN = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aBS;
        protected s aBT;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.aBS = false;
            this.aBT = null;
            this.position = 0;
            this.aBT = sVar;
            this.position = i;
            this.aBS = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aBH != null && this.aBH.size() != 0) {
            Iterator<l> it = this.aBH.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
