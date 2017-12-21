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
    private List<l> aBK;
    private List<a> aBL;
    private Paint aBM;
    private Paint aBN;
    private int aBO;
    private int aBP;
    private int aBQ;
    private i aBR;
    private boolean aBS;
    private boolean aBT;
    private boolean aBU;
    private int mSkinType;
    private int wC;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.aBO = 0;
        this.aBQ = 0;
        this.aBS = false;
        this.aBT = false;
        this.aBU = true;
        this.aBR = iVar;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aBK = new LinkedList();
        this.aBL = new LinkedList();
        this.aBM = new Paint();
        this.aBN = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.aBM.setStyle(Paint.Style.FILL);
        this.aBN.setStyle(Paint.Style.FILL);
        this.aBP = getResources().getDimensionPixelSize(d.e.ds1);
        this.wC = ((com.baidu.adp.lib.util.l.ac(context) - com.baidu.adp.lib.util.l.f(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.f(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBK.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.aBK.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.aBL.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Df() {
        p.a aVar;
        if (!v.w(this.aBK)) {
            bx(true);
            for (int i = 0; i < this.aBK.size(); i++) {
                l lVar = this.aBK.get(i);
                if (lVar instanceof c) {
                    c cVar = (c) lVar;
                    if (this.aBQ == 2) {
                        aVar = new p.a(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                    } else if (this.aBQ == 3) {
                        aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aBQ == 1) {
                        aVar = new p.a(cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.aBK.size() - 1) {
                            aVar.rightMargin = this.wC;
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
                    if (this.aBQ == 1 || this.aBQ == 3 || this.aBQ == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aBQ == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bx(boolean z) {
        p.a aVar;
        for (a aVar2 : this.aBL) {
            View view = (View) aVar2.aBW;
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
                    aj.j(this, d.C0095d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0095d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aBM == null) {
            this.aBM = new Paint();
            this.aBM.setStyle(Paint.Style.FILL);
        }
        this.aBM.setColor(aj.getColor(this.mSkinType, d.C0095d.cp_bg_line_c));
        if (this.aBU) {
            if (this.aBT) {
                canvas.drawRect(0.0f, this.aCH[0] - this.aBP, getMeasuredWidth(), this.aCH[0], this.aBM);
            }
            if (this.aBS) {
                canvas.drawRect(0.0f, (this.aCH[0] + this.aCH[1]) - this.aBP, getMeasuredWidth(), this.aCH[0] + this.aCH[1], this.aBM);
            }
        }
        if (this.aBN == null) {
            this.aBN = new Paint();
            this.aBN.setStyle(Paint.Style.FILL);
        }
        if (this.aBO > 0) {
            if (this.mSkinType == 0) {
                this.aBN.setColor(getContext().getResources().getColor(this.aBO));
            } else {
                this.aBN.setColor(aj.getColor(this.mSkinType, this.aBO));
            }
            if (this.aBS && this.aBU) {
                i = (this.aCH[0] + this.aCH[1]) - this.aBP;
            } else {
                i = this.aCH[0] + this.aCH[1];
            }
            canvas.drawRect(0.0f, this.aCH[0], getMeasuredWidth(), i, this.aBN);
        }
        super.dispatchDraw(canvas);
    }

    public void by(boolean z) {
        this.aBS = z;
    }

    public void bz(boolean z) {
        this.aBT = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBK.clear();
        this.aBL.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.aBQ == 1) {
            if (rVar == null) {
                for (l lVar : this.aBK) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.aBK) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.aCK) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aBQ == 3 || this.aBQ == 2) {
            if (rVar == null) {
                for (l lVar3 : this.aBK) {
                    if (lVar3 instanceof View) {
                        ((View) lVar3).setSelected(false);
                    }
                }
            } else if (rVar.id == 5 || rVar.id == 2 || rVar.id == 6) {
                for (l lVar4 : this.aBK) {
                    if (lVar4 instanceof View) {
                        View view2 = (View) lVar4;
                        if (lVar4.getToolId() == rVar.id && rVar.aCK) {
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
        if (i == 2 && Dg() && this.aBR != null) {
            this.aBR.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eM = eM(i);
        if (eM != null) {
            if (eM.position == 5) {
                for (l lVar : this.aBK) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.lE();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.aBL) {
                    if (aVar.aBW != null) {
                        if (aVar.position == 5) {
                            aVar.aBW.lE();
                        } else {
                            aVar.aBW.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.aBK) {
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
                for (a aVar2 : this.aBL) {
                    if (aVar2.aBW != null) {
                        if (aVar2.position == 5) {
                            aVar2.aBW.hide();
                        } else {
                            aVar2.aBW.lE();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eM(int i) {
        for (a aVar : this.aBL) {
            if (aVar.aBW != null && aVar.aBW.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Dg() {
        for (a aVar : this.aBL) {
            if (aVar.position == 5 && aVar.aBW != null && (aVar.aBW instanceof View) && ((View) aVar.aBW).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l eN(int i) {
        for (l lVar : this.aBK) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aj.k(this, this.aBO);
        for (l lVar : this.aBK) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.aBL) {
            if (aVar.aBW != null) {
                aVar.aBW.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aBO = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.aBK) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void d(boolean z, int i) {
        for (l lVar : this.aBK) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aBQ = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aBV;
        protected s aBW;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.aBV = false;
            this.aBW = null;
            this.position = 0;
            this.aBW = sVar;
            this.position = i;
            this.aBV = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aBK != null && this.aBK.size() != 0) {
            Iterator<l> it = this.aBK.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
