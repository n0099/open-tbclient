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
    private List<l> aBC;
    private List<a> aBD;
    private Paint aBE;
    private Paint aBF;
    private int aBG;
    private int aBH;
    private int aBI;
    private i aBJ;
    private boolean aBK;
    private boolean aBL;
    private boolean aBM;
    private int mSkinType;
    private int wE;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.aBG = 0;
        this.aBI = 0;
        this.aBK = false;
        this.aBL = false;
        this.aBM = true;
        this.aBJ = iVar;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aBC = new LinkedList();
        this.aBD = new LinkedList();
        this.aBE = new Paint();
        this.aBF = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.aBE.setStyle(Paint.Style.FILL);
        this.aBF.setStyle(Paint.Style.FILL);
        this.aBH = getResources().getDimensionPixelSize(d.e.ds1);
        this.wE = ((com.baidu.adp.lib.util.l.ac(context) - com.baidu.adp.lib.util.l.f(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.f(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBC.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.aBC.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.aBD.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void De() {
        p.a aVar;
        if (!v.w(this.aBC)) {
            bw(true);
            for (int i = 0; i < this.aBC.size(); i++) {
                l lVar = this.aBC.get(i);
                if (lVar instanceof c) {
                    c cVar = (c) lVar;
                    if (this.aBI == 2) {
                        aVar = new p.a(com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.f(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                    } else if (this.aBI == 3) {
                        aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.f(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aBI == 1) {
                        aVar = new p.a(cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.aBC.size() - 1) {
                            aVar.rightMargin = this.wE;
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
            bw(false);
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
                    if (this.aBI == 1 || this.aBI == 3 || this.aBI == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aBI == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bw(boolean z) {
        p.a aVar;
        for (a aVar2 : this.aBD) {
            View view = (View) aVar2.aBO;
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
                    aj.j(this, d.C0082d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0082d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aBE == null) {
            this.aBE = new Paint();
            this.aBE.setStyle(Paint.Style.FILL);
        }
        this.aBE.setColor(aj.getColor(this.mSkinType, d.C0082d.cp_bg_line_c));
        if (this.aBM) {
            if (this.aBL) {
                canvas.drawRect(0.0f, this.aCz[0] - this.aBH, getMeasuredWidth(), this.aCz[0], this.aBE);
            }
            if (this.aBK) {
                canvas.drawRect(0.0f, (this.aCz[0] + this.aCz[1]) - this.aBH, getMeasuredWidth(), this.aCz[0] + this.aCz[1], this.aBE);
            }
        }
        if (this.aBF == null) {
            this.aBF = new Paint();
            this.aBF.setStyle(Paint.Style.FILL);
        }
        if (this.aBG > 0) {
            if (this.mSkinType == 0) {
                this.aBF.setColor(getContext().getResources().getColor(this.aBG));
            } else {
                this.aBF.setColor(aj.getColor(this.mSkinType, this.aBG));
            }
            if (this.aBK && this.aBM) {
                i = (this.aCz[0] + this.aCz[1]) - this.aBH;
            } else {
                i = this.aCz[0] + this.aCz[1];
            }
            canvas.drawRect(0.0f, this.aCz[0], getMeasuredWidth(), i, this.aBF);
        }
        super.dispatchDraw(canvas);
    }

    public void bx(boolean z) {
        this.aBK = z;
    }

    public void by(boolean z) {
        this.aBL = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBC.clear();
        this.aBD.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.aBI == 1) {
            if (rVar == null) {
                for (l lVar : this.aBC) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.aBC) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.aCC) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aBI == 3 || this.aBI == 2) {
            if (rVar == null) {
                for (l lVar3 : this.aBC) {
                    if (lVar3 instanceof View) {
                        ((View) lVar3).setSelected(false);
                    }
                }
            } else if (rVar.id == 5 || rVar.id == 2 || rVar.id == 6) {
                for (l lVar4 : this.aBC) {
                    if (lVar4 instanceof View) {
                        View view2 = (View) lVar4;
                        if (lVar4.getToolId() == rVar.id && rVar.aCC) {
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
        if (i == 2 && Df() && this.aBJ != null) {
            this.aBJ.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eM = eM(i);
        if (eM != null) {
            if (eM.position == 5) {
                for (l lVar : this.aBC) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.lE();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.aBD) {
                    if (aVar.aBO != null) {
                        if (aVar.position == 5) {
                            aVar.aBO.lE();
                        } else {
                            aVar.aBO.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.aBC) {
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
                for (a aVar2 : this.aBD) {
                    if (aVar2.aBO != null) {
                        if (aVar2.position == 5) {
                            aVar2.aBO.hide();
                        } else {
                            aVar2.aBO.lE();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eM(int i) {
        for (a aVar : this.aBD) {
            if (aVar.aBO != null && aVar.aBO.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Df() {
        for (a aVar : this.aBD) {
            if (aVar.position == 5 && aVar.aBO != null && (aVar.aBO instanceof View) && ((View) aVar.aBO).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l eN(int i) {
        for (l lVar : this.aBC) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aj.k(this, this.aBG);
        for (l lVar : this.aBC) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.aBD) {
            if (aVar.aBO != null) {
                aVar.aBO.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aBG = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.aBC) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void d(boolean z, int i) {
        for (l lVar : this.aBC) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aBI = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aBN;
        protected s aBO;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.aBN = false;
            this.aBO = null;
            this.position = 0;
            this.aBO = sVar;
            this.position = i;
            this.aBN = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aBC != null && this.aBC.size() != 0) {
            Iterator<l> it = this.aBC.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
