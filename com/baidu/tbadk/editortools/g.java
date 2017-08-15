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
    private List<l> aBQ;
    private List<a> aBR;
    private Paint aBS;
    private Paint aBT;
    private int aBU;
    private int aBV;
    private boolean aBW;
    private int aBX;
    private i aBY;
    private boolean aBZ;
    private boolean aCa;
    private boolean aCb;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.aBU = 0;
        this.aBW = false;
        this.aBX = 0;
        this.aBZ = false;
        this.aCa = false;
        this.aCb = true;
        this.aBY = iVar;
        init();
    }

    private void init() {
        this.aBQ = new LinkedList();
        this.aBR = new LinkedList();
        this.aBS = new Paint();
        this.aBT = new Paint();
        this.aBS.setStyle(Paint.Style.FILL);
        this.aBT.setStyle(Paint.Style.FILL);
        this.aBV = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBQ.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.aBQ.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.aBR.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Db() {
        p.a aVar;
        bD(true);
        Iterator<l> it = this.aBQ.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aBX == 1) {
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
            aVar.eG(2);
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
                    if (this.aBX == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aBX == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bD(boolean z) {
        p.a aVar;
        for (a aVar2 : this.aBR) {
            View view = (View) aVar2.aCd;
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
                aVar.eG(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eG(2);
                        break;
                    case 3:
                        aVar.eG(1);
                        break;
                    case 4:
                        aVar.eG(3);
                        break;
                    case 5:
                        aVar.eG(2);
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
        if (this.aBS == null) {
            this.aBS = new Paint();
            this.aBS.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aBS.setColor(getContext().getResources().getColor(d.e.cp_bg_line_b));
        } else {
            this.aBS.setColor(ai.getColor(this.mSkinType, d.e.cp_bg_line_b));
        }
        if (this.aCb) {
            if (this.aCa) {
                canvas.drawRect(0.0f, this.aCM[0] - this.aBV, getMeasuredWidth(), this.aCM[0], this.aBS);
            }
            if (this.aBZ) {
                canvas.drawRect(0.0f, (this.aCM[0] + this.aCM[1]) - this.aBV, getMeasuredWidth(), this.aCM[0] + this.aCM[1], this.aBS);
            }
        }
        if (this.aBT == null) {
            this.aBT = new Paint();
            this.aBT.setStyle(Paint.Style.FILL);
        }
        if (this.aBU > 0) {
            if (this.mSkinType == 0) {
                this.aBT.setColor(getContext().getResources().getColor(this.aBU));
            } else {
                this.aBT.setColor(ai.getColor(this.mSkinType, this.aBU));
            }
            if (this.aBZ && this.aCb) {
                i = (this.aCM[0] + this.aCM[1]) - this.aBV;
            } else {
                i = this.aCM[0] + this.aCM[1];
            }
            canvas.drawRect(0.0f, this.aCM[0], getMeasuredWidth(), i, this.aBT);
        }
        super.dispatchDraw(canvas);
    }

    public void bE(boolean z) {
        this.aBZ = z;
    }

    public void bF(boolean z) {
        this.aCa = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBQ.clear();
        this.aBR.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.aBX == 1) {
            if (rVar == null) {
                for (l lVar : this.aBQ) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.aBQ) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.aCP) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eA(int i) {
        if (i == 2 && Dc() && this.aBY != null) {
            this.aBY.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eB = eB(i);
        if (eB != null) {
            if (eB.position == 5) {
                for (l lVar : this.aBQ) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.lT();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.aBR) {
                    if (aVar.aCd != null) {
                        if (aVar.position == 5) {
                            aVar.aCd.lT();
                        } else {
                            aVar.aCd.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.aBQ) {
                    if (lVar2.getToolId() == 1) {
                        lVar2.hide();
                    } else {
                        if (lVar2 instanceof c) {
                            c cVar = (c) lVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        lVar2.lT();
                    }
                }
                for (a aVar2 : this.aBR) {
                    if (aVar2.aCd != null) {
                        if (aVar2.position == 5) {
                            aVar2.aCd.hide();
                        } else {
                            aVar2.aCd.lT();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eB(int i) {
        for (a aVar : this.aBR) {
            if (aVar.aCd != null && aVar.aCd.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Dc() {
        for (a aVar : this.aBR) {
            if (aVar.position == 5 && aVar.aCd != null && (aVar.aCd instanceof View) && ((View) aVar.aCd).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l eC(int i) {
        for (l lVar : this.aBQ) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (l lVar : this.aBQ) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.aBR) {
            if (aVar.aCd != null) {
                aVar.aCd.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aBU = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.aBQ) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void c(boolean z, int i) {
        for (l lVar : this.aBQ) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aBX = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aCc;
        protected s aCd;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.aCc = false;
            this.aCd = null;
            this.position = 0;
            this.aCd = sVar;
            this.position = i;
            this.aCc = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.aBQ != null && this.aBQ.size() != 0) {
            Iterator<l> it = this.aBQ.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
