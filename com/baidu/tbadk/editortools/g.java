package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends v {
    private List<p> ayL;
    private List<a> ayM;
    private Paint ayN;
    private Paint ayO;
    private int ayP;
    private int ayQ;
    private boolean ayR;
    private int ayS;
    private j ayT;
    private boolean ayU;
    private boolean ayV;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j jVar) {
        super(context);
        this.mSkinType = 0;
        this.ayP = 0;
        this.ayR = false;
        this.ayS = 0;
        this.ayU = false;
        this.ayV = false;
        this.ayT = jVar;
        init();
    }

    private void init() {
        this.ayL = new LinkedList();
        this.ayM = new LinkedList();
        this.ayN = new Paint();
        this.ayO = new Paint();
        this.ayN.setStyle(Paint.Style.FILL);
        this.ayO.setStyle(Paint.Style.FILL);
        this.ayQ = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.ayL.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, p pVar) {
        this.ayL.add(i, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar, int i, boolean z) {
        this.ayM.add(new a(yVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Do() {
        v.a aVar;
        bC(true);
        Iterator<p> it = this.ayL.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.ayS == 1) {
                aVar = new v.a(cVar.getContext().getResources().getDimensionPixelSize(w.f.ds60), cVar.getContext().getResources().getDimensionPixelSize(w.f.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds28);
            } else {
                aVar = new v.a(cVar.getContext().getResources().getDimensionPixelSize(w.f.ds76), cVar.getContext().getResources().getDimensionPixelSize(w.f.ds76), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds10);
            }
            aVar.eD(2);
            addView(cVar, aVar);
        }
        bC(false);
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
                    if (this.ayS == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.ayS == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bC(boolean z) {
        v.a aVar;
        for (a aVar2 : this.ayM) {
            View view = (View) aVar2.ayX;
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
                aVar.eD(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eD(2);
                        break;
                    case 3:
                        aVar.eD(1);
                        break;
                    case 4:
                        aVar.eD(3);
                        break;
                    case 5:
                        aVar.eD(2);
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
        if (this.ayN == null) {
            this.ayN = new Paint();
            this.ayN.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.ayN.setColor(getContext().getResources().getColor(w.e.cp_bg_line_b));
        } else {
            this.ayN.setColor(aq.getColor(this.mSkinType, w.e.cp_bg_line_b));
        }
        if (this.ayV) {
            canvas.drawRect(0.0f, this.azF[0] - this.ayQ, getMeasuredWidth(), this.azF[0], this.ayN);
        }
        if (this.ayU) {
            canvas.drawRect(0.0f, (this.azF[0] + this.azF[1]) - this.ayQ, getMeasuredWidth(), this.azF[0] + this.azF[1], this.ayN);
        }
        if (this.ayO == null) {
            this.ayO = new Paint();
            this.ayO.setStyle(Paint.Style.FILL);
        }
        if (this.ayP > 0) {
            if (this.mSkinType == 0) {
                this.ayO.setColor(getContext().getResources().getColor(this.ayP));
            } else {
                this.ayO.setColor(aq.getColor(this.mSkinType, this.ayP));
            }
            if (this.ayU) {
                i = (this.azF[0] + this.azF[1]) - this.ayQ;
            } else {
                i = this.azF[0] + this.azF[1];
            }
            canvas.drawRect(0.0f, this.azF[0], getMeasuredWidth(), i, this.ayO);
        }
        super.dispatchDraw(canvas);
    }

    public void bD(boolean z) {
        this.ayU = z;
    }

    public void bE(boolean z) {
        this.ayV = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ayL.clear();
        this.ayM.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(x xVar) {
        if (this.ayS == 1) {
            if (xVar == null) {
                for (p pVar : this.ayL) {
                    if (pVar instanceof View) {
                        ((View) pVar).setSelected(false);
                    }
                }
                return;
            }
            for (p pVar2 : this.ayL) {
                if (pVar2 instanceof View) {
                    View view = (View) pVar2;
                    if (pVar2.getToolId() == xVar.id && xVar.azI) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ex(int i) {
        if (i == 2 && Dp() && this.ayT != null) {
            this.ayT.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ey = ey(i);
        if (ey != null) {
            if (ey.position == 5) {
                for (p pVar : this.ayL) {
                    if (pVar.getToolId() == 2 || pVar.getToolId() == 1) {
                        pVar.mp();
                    } else {
                        pVar.hide();
                    }
                }
                for (a aVar : this.ayM) {
                    if (aVar.ayX != null) {
                        if (aVar.position == 5) {
                            aVar.ayX.mp();
                        } else {
                            aVar.ayX.hide();
                        }
                    }
                }
            } else {
                for (p pVar2 : this.ayL) {
                    if (pVar2.getToolId() == 1) {
                        pVar2.hide();
                    } else {
                        if (pVar2 instanceof c) {
                            c cVar = (c) pVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        pVar2.mp();
                    }
                }
                for (a aVar2 : this.ayM) {
                    if (aVar2.ayX != null) {
                        if (aVar2.position == 5) {
                            aVar2.ayX.hide();
                        } else {
                            aVar2.ayX.mp();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ey(int i) {
        for (a aVar : this.ayM) {
            if (aVar.ayX != null && aVar.ayX.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Dp() {
        for (a aVar : this.ayM) {
            if (aVar.position == 5 && aVar.ayX != null && (aVar.ayX instanceof View) && ((View) aVar.ayX).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public p ez(int i) {
        for (p pVar : this.ayL) {
            if (pVar.getToolId() == i) {
                return pVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (p pVar : this.ayL) {
            pVar.onChangeSkinType(i);
        }
        for (a aVar : this.ayM) {
            if (aVar.ayX != null) {
                aVar.ayX.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.ayP = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (p pVar : this.ayL) {
            if (pVar != null && (pVar instanceof View)) {
                ((View) pVar).setEnabled(z);
            }
        }
    }

    public void c(boolean z, int i) {
        for (p pVar : this.ayL) {
            if (pVar instanceof View) {
                View view = (View) pVar;
                if (pVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.ayS = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean ayW;
        protected y ayX;
        protected int position;

        protected a(y yVar, int i, boolean z) {
            this.ayW = false;
            this.ayX = null;
            this.position = 0;
            this.ayX = yVar;
            this.position = i;
            this.ayW = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.ayL != null && this.ayL.size() != 0) {
            Iterator<p> it = this.ayL.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
