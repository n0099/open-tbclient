package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends v {
    private Paint azA;
    private Paint azB;
    private int azC;
    private int azD;
    private boolean azE;
    private int azF;
    private j azG;
    private boolean azH;
    private boolean azI;
    private boolean azJ;
    private List<p> azy;
    private List<a> azz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j jVar) {
        super(context);
        this.mSkinType = 0;
        this.azC = 0;
        this.azE = false;
        this.azF = 0;
        this.azH = false;
        this.azI = false;
        this.azJ = true;
        this.azG = jVar;
        init();
    }

    private void init() {
        this.azy = new LinkedList();
        this.azz = new LinkedList();
        this.azA = new Paint();
        this.azB = new Paint();
        this.azA.setStyle(Paint.Style.FILL);
        this.azB.setStyle(Paint.Style.FILL);
        this.azD = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.azy.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, p pVar) {
        this.azy.add(i, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar, int i, boolean z) {
        this.azz.add(new a(yVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CH() {
        v.a aVar;
        bA(true);
        Iterator<p> it = this.azy.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.azF == 1) {
                aVar = new v.a(0, cVar.getContext().getResources().getDimensionPixelSize(w.f.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds32);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds32);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds28);
                aVar.weight = 1.0f;
            } else {
                aVar = new v.a(cVar.getContext().getResources().getDimensionPixelSize(w.f.ds76), cVar.getContext().getResources().getDimensionPixelSize(w.f.ds76), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds10);
            }
            aVar.eC(2);
            addView(cVar, aVar);
        }
        bA(false);
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
                    if (this.azF == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.azF == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bA(boolean z) {
        v.a aVar;
        for (a aVar2 : this.azz) {
            View view = (View) aVar2.azL;
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
                aVar.eC(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eC(2);
                        break;
                    case 3:
                        aVar.eC(1);
                        break;
                    case 4:
                        aVar.eC(3);
                        break;
                    case 5:
                        aVar.eC(2);
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
        if (this.azA == null) {
            this.azA = new Paint();
            this.azA.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.azA.setColor(getContext().getResources().getColor(w.e.cp_bg_line_b));
        } else {
            this.azA.setColor(as.getColor(this.mSkinType, w.e.cp_bg_line_b));
        }
        if (this.azJ) {
            if (this.azI) {
                canvas.drawRect(0.0f, this.aAu[0] - this.azD, getMeasuredWidth(), this.aAu[0], this.azA);
            }
            if (this.azH) {
                canvas.drawRect(0.0f, (this.aAu[0] + this.aAu[1]) - this.azD, getMeasuredWidth(), this.aAu[0] + this.aAu[1], this.azA);
            }
        }
        if (this.azB == null) {
            this.azB = new Paint();
            this.azB.setStyle(Paint.Style.FILL);
        }
        if (this.azC > 0) {
            if (this.mSkinType == 0) {
                this.azB.setColor(getContext().getResources().getColor(this.azC));
            } else {
                this.azB.setColor(as.getColor(this.mSkinType, this.azC));
            }
            if (this.azH && this.azJ) {
                i = (this.aAu[0] + this.aAu[1]) - this.azD;
            } else {
                i = this.aAu[0] + this.aAu[1];
            }
            canvas.drawRect(0.0f, this.aAu[0], getMeasuredWidth(), i, this.azB);
        }
        super.dispatchDraw(canvas);
    }

    public void bB(boolean z) {
        this.azH = z;
    }

    public void bC(boolean z) {
        this.azI = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.azy.clear();
        this.azz.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(x xVar) {
        if (this.azF == 1) {
            if (xVar == null) {
                for (p pVar : this.azy) {
                    if (pVar instanceof View) {
                        ((View) pVar).setSelected(false);
                    }
                }
                return;
            }
            for (p pVar2 : this.azy) {
                if (pVar2 instanceof View) {
                    View view = (View) pVar2;
                    if (pVar2.getToolId() == xVar.id && xVar.aAx) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ew(int i) {
        if (i == 2 && CI() && this.azG != null) {
            this.azG.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ex = ex(i);
        if (ex != null) {
            if (ex.position == 5) {
                for (p pVar : this.azy) {
                    if (pVar.getToolId() == 2 || pVar.getToolId() == 1) {
                        pVar.lM();
                    } else {
                        pVar.hide();
                    }
                }
                for (a aVar : this.azz) {
                    if (aVar.azL != null) {
                        if (aVar.position == 5) {
                            aVar.azL.lM();
                        } else {
                            aVar.azL.hide();
                        }
                    }
                }
            } else {
                for (p pVar2 : this.azy) {
                    if (pVar2.getToolId() == 1) {
                        pVar2.hide();
                    } else {
                        if (pVar2 instanceof c) {
                            c cVar = (c) pVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        pVar2.lM();
                    }
                }
                for (a aVar2 : this.azz) {
                    if (aVar2.azL != null) {
                        if (aVar2.position == 5) {
                            aVar2.azL.hide();
                        } else {
                            aVar2.azL.lM();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ex(int i) {
        for (a aVar : this.azz) {
            if (aVar.azL != null && aVar.azL.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CI() {
        for (a aVar : this.azz) {
            if (aVar.position == 5 && aVar.azL != null && (aVar.azL instanceof View) && ((View) aVar.azL).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public p ey(int i) {
        for (p pVar : this.azy) {
            if (pVar.getToolId() == i) {
                return pVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (p pVar : this.azy) {
            pVar.onChangeSkinType(i);
        }
        for (a aVar : this.azz) {
            if (aVar.azL != null) {
                aVar.azL.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.azC = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (p pVar : this.azy) {
            if (pVar != null && (pVar instanceof View)) {
                ((View) pVar).setEnabled(z);
            }
        }
    }

    public void c(boolean z, int i) {
        for (p pVar : this.azy) {
            if (pVar instanceof View) {
                View view = (View) pVar;
                if (pVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.azF = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean azK;
        protected y azL;
        protected int position;

        protected a(y yVar, int i, boolean z) {
            this.azK = false;
            this.azL = null;
            this.position = 0;
            this.azL = yVar;
            this.position = i;
            this.azK = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.azy != null && this.azy.size() != 0) {
            Iterator<p> it = this.azy.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
