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
    private List<l> aAT;
    private List<a> aAU;
    private Paint aAV;
    private Paint aAW;
    private int aAX;
    private int aAY;
    private int aAZ;
    private i aBa;
    private boolean aBb;
    private boolean aBc;
    private boolean aBd;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.aAX = 0;
        this.aAZ = 0;
        this.aBb = false;
        this.aBc = false;
        this.aBd = true;
        this.aBa = iVar;
        init();
    }

    private void init() {
        this.aAT = new LinkedList();
        this.aAU = new LinkedList();
        this.aAV = new Paint();
        this.aAW = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.aAV.setStyle(Paint.Style.FILL);
        this.aAW.setStyle(Paint.Style.FILL);
        this.aAY = com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aAT.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.aAT.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.aAU.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CJ() {
        p.a aVar;
        bv(true);
        Iterator<l> it = this.aAT.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aAZ == 1) {
                aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(d.e.ds32);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(d.e.ds32);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(d.e.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(d.e.ds28);
                aVar.weight = 1.0f;
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
        bv(false);
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
                    if (this.aAZ == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aAZ == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bv(boolean z) {
        p.a aVar;
        for (a aVar2 : this.aAU) {
            View view = (View) aVar2.aBf;
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
                    aj.j(this, d.C0080d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0080d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aAV == null) {
            this.aAV = new Paint();
            this.aAV.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aAV.setColor(getContext().getResources().getColor(d.C0080d.cp_bg_line_b));
        } else {
            this.aAV.setColor(aj.getColor(this.mSkinType, d.C0080d.cp_bg_line_b));
        }
        if (this.aBd) {
            if (this.aBc) {
                canvas.drawRect(0.0f, this.aBO[0] - this.aAY, getMeasuredWidth(), this.aBO[0], this.aAV);
            }
            if (this.aBb) {
                canvas.drawRect(0.0f, (this.aBO[0] + this.aBO[1]) - this.aAY, getMeasuredWidth(), this.aBO[0] + this.aBO[1], this.aAV);
            }
        }
        if (this.aAW == null) {
            this.aAW = new Paint();
            this.aAW.setStyle(Paint.Style.FILL);
        }
        if (this.aAX > 0) {
            if (this.mSkinType == 0) {
                this.aAW.setColor(getContext().getResources().getColor(this.aAX));
            } else {
                this.aAW.setColor(aj.getColor(this.mSkinType, this.aAX));
            }
            if (this.aBb && this.aBd) {
                i = (this.aBO[0] + this.aBO[1]) - this.aAY;
            } else {
                i = this.aBO[0] + this.aBO[1];
            }
            canvas.drawRect(0.0f, this.aBO[0], getMeasuredWidth(), i, this.aAW);
        }
        super.dispatchDraw(canvas);
    }

    public void bw(boolean z) {
        this.aBb = z;
    }

    public void bx(boolean z) {
        this.aBc = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aAT.clear();
        this.aAU.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.aAZ == 1) {
            if (rVar == null) {
                for (l lVar : this.aAT) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.aAT) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.aBR) {
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
        if (i == 2 && CK() && this.aBa != null) {
            this.aBa.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eM = eM(i);
        if (eM != null) {
            if (eM.position == 5) {
                for (l lVar : this.aAT) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.lG();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.aAU) {
                    if (aVar.aBf != null) {
                        if (aVar.position == 5) {
                            aVar.aBf.lG();
                        } else {
                            aVar.aBf.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.aAT) {
                    if (lVar2.getToolId() == 1) {
                        lVar2.hide();
                    } else {
                        if (lVar2 instanceof c) {
                            c cVar = (c) lVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        lVar2.lG();
                    }
                }
                for (a aVar2 : this.aAU) {
                    if (aVar2.aBf != null) {
                        if (aVar2.position == 5) {
                            aVar2.aBf.hide();
                        } else {
                            aVar2.aBf.lG();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eM(int i) {
        for (a aVar : this.aAU) {
            if (aVar.aBf != null && aVar.aBf.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CK() {
        for (a aVar : this.aAU) {
            if (aVar.position == 5 && aVar.aBf != null && (aVar.aBf instanceof View) && ((View) aVar.aBf).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l eN(int i) {
        for (l lVar : this.aAT) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aj.k(this, this.aAX);
        for (l lVar : this.aAT) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.aAU) {
            if (aVar.aBf != null) {
                aVar.aBf.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aAX = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.aAT) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void d(boolean z, int i) {
        for (l lVar : this.aAT) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aAZ = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aBe;
        protected s aBf;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.aBe = false;
            this.aBf = null;
            this.position = 0;
            this.aBf = sVar;
            this.position = i;
            this.aBe = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aAT != null && this.aAT.size() != 0) {
            Iterator<l> it = this.aAT.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
