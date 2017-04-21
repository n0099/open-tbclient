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
    private List<p> ayN;
    private List<a> ayO;
    private Paint ayP;
    private Paint ayQ;
    private int ayR;
    private int ayS;
    private boolean ayT;
    private int ayU;
    private j ayV;
    private boolean ayW;
    private boolean ayX;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j jVar) {
        super(context);
        this.mSkinType = 0;
        this.ayR = 0;
        this.ayT = false;
        this.ayU = 0;
        this.ayW = false;
        this.ayX = false;
        this.ayV = jVar;
        init();
    }

    private void init() {
        this.ayN = new LinkedList();
        this.ayO = new LinkedList();
        this.ayP = new Paint();
        this.ayQ = new Paint();
        this.ayP.setStyle(Paint.Style.FILL);
        this.ayQ.setStyle(Paint.Style.FILL);
        this.ayS = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.ayN.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, p pVar) {
        this.ayN.add(i, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar, int i, boolean z) {
        this.ayO.add(new a(yVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Do() {
        v.a aVar;
        bC(true);
        Iterator<p> it = this.ayN.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.ayU == 1) {
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
                    if (this.ayU == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.ayU == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bC(boolean z) {
        v.a aVar;
        for (a aVar2 : this.ayO) {
            View view = (View) aVar2.ayZ;
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
        if (this.ayP == null) {
            this.ayP = new Paint();
            this.ayP.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.ayP.setColor(getContext().getResources().getColor(w.e.cp_bg_line_b));
        } else {
            this.ayP.setColor(aq.getColor(this.mSkinType, w.e.cp_bg_line_b));
        }
        if (this.ayX) {
            canvas.drawRect(0.0f, this.azH[0] - this.ayS, getMeasuredWidth(), this.azH[0], this.ayP);
        }
        if (this.ayW) {
            canvas.drawRect(0.0f, (this.azH[0] + this.azH[1]) - this.ayS, getMeasuredWidth(), this.azH[0] + this.azH[1], this.ayP);
        }
        if (this.ayQ == null) {
            this.ayQ = new Paint();
            this.ayQ.setStyle(Paint.Style.FILL);
        }
        if (this.ayR > 0) {
            if (this.mSkinType == 0) {
                this.ayQ.setColor(getContext().getResources().getColor(this.ayR));
            } else {
                this.ayQ.setColor(aq.getColor(this.mSkinType, this.ayR));
            }
            if (this.ayW) {
                i = (this.azH[0] + this.azH[1]) - this.ayS;
            } else {
                i = this.azH[0] + this.azH[1];
            }
            canvas.drawRect(0.0f, this.azH[0], getMeasuredWidth(), i, this.ayQ);
        }
        super.dispatchDraw(canvas);
    }

    public void bD(boolean z) {
        this.ayW = z;
    }

    public void bE(boolean z) {
        this.ayX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ayN.clear();
        this.ayO.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(x xVar) {
        if (this.ayU == 1) {
            if (xVar == null) {
                for (p pVar : this.ayN) {
                    if (pVar instanceof View) {
                        ((View) pVar).setSelected(false);
                    }
                }
                return;
            }
            for (p pVar2 : this.ayN) {
                if (pVar2 instanceof View) {
                    View view = (View) pVar2;
                    if (pVar2.getToolId() == xVar.id && xVar.azK) {
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
        if (i == 2 && Dp() && this.ayV != null) {
            this.ayV.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ey = ey(i);
        if (ey != null) {
            if (ey.position == 5) {
                for (p pVar : this.ayN) {
                    if (pVar.getToolId() == 2 || pVar.getToolId() == 1) {
                        pVar.mp();
                    } else {
                        pVar.hide();
                    }
                }
                for (a aVar : this.ayO) {
                    if (aVar.ayZ != null) {
                        if (aVar.position == 5) {
                            aVar.ayZ.mp();
                        } else {
                            aVar.ayZ.hide();
                        }
                    }
                }
            } else {
                for (p pVar2 : this.ayN) {
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
                for (a aVar2 : this.ayO) {
                    if (aVar2.ayZ != null) {
                        if (aVar2.position == 5) {
                            aVar2.ayZ.hide();
                        } else {
                            aVar2.ayZ.mp();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ey(int i) {
        for (a aVar : this.ayO) {
            if (aVar.ayZ != null && aVar.ayZ.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Dp() {
        for (a aVar : this.ayO) {
            if (aVar.position == 5 && aVar.ayZ != null && (aVar.ayZ instanceof View) && ((View) aVar.ayZ).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public p ez(int i) {
        for (p pVar : this.ayN) {
            if (pVar.getToolId() == i) {
                return pVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (p pVar : this.ayN) {
            pVar.onChangeSkinType(i);
        }
        for (a aVar : this.ayO) {
            if (aVar.ayZ != null) {
                aVar.ayZ.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.ayR = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (p pVar : this.ayN) {
            if (pVar != null && (pVar instanceof View)) {
                ((View) pVar).setEnabled(z);
            }
        }
    }

    public void c(boolean z, int i) {
        for (p pVar : this.ayN) {
            if (pVar instanceof View) {
                View view = (View) pVar;
                if (pVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.ayU = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean ayY;
        protected y ayZ;
        protected int position;

        protected a(y yVar, int i, boolean z) {
            this.ayY = false;
            this.ayZ = null;
            this.position = 0;
            this.ayZ = yVar;
            this.position = i;
            this.ayY = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.ayN != null && this.ayN.size() != 0) {
            Iterator<p> it = this.ayN.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
