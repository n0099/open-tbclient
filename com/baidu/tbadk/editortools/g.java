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
    private List<l> aBa;
    private List<a> aBb;
    private Paint aBc;
    private Paint aBd;
    private int aBe;
    private int aBf;
    private boolean aBg;
    private int aBh;
    private i aBi;
    private boolean aBj;
    private boolean aBk;
    private boolean aBl;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.aBe = 0;
        this.aBg = false;
        this.aBh = 0;
        this.aBj = false;
        this.aBk = false;
        this.aBl = true;
        this.aBi = iVar;
        init();
    }

    private void init() {
        this.aBa = new LinkedList();
        this.aBb = new LinkedList();
        this.aBc = new Paint();
        this.aBd = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.f.ds20), 0, getResources().getDimensionPixelSize(d.f.ds20), 0);
        this.aBc.setStyle(Paint.Style.FILL);
        this.aBd.setStyle(Paint.Style.FILL);
        this.aBf = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBa.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.aBa.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.aBb.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CW() {
        p.a aVar;
        bC(true);
        Iterator<l> it = this.aBa.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aBh == 1) {
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
            aVar.eG(2);
            addView(cVar, aVar);
        }
        bC(false);
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
                    if (this.aBh == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aBh == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bC(boolean z) {
        p.a aVar;
        for (a aVar2 : this.aBb) {
            View view = (View) aVar2.aBn;
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
        if (this.aBc == null) {
            this.aBc = new Paint();
            this.aBc.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aBc.setColor(getContext().getResources().getColor(d.e.cp_bg_line_b));
        } else {
            this.aBc.setColor(aj.getColor(this.mSkinType, d.e.cp_bg_line_b));
        }
        if (this.aBl) {
            if (this.aBk) {
                canvas.drawRect(0.0f, this.aBX[0] - this.aBf, getMeasuredWidth(), this.aBX[0], this.aBc);
            }
            if (this.aBj) {
                canvas.drawRect(0.0f, (this.aBX[0] + this.aBX[1]) - this.aBf, getMeasuredWidth(), this.aBX[0] + this.aBX[1], this.aBc);
            }
        }
        if (this.aBd == null) {
            this.aBd = new Paint();
            this.aBd.setStyle(Paint.Style.FILL);
        }
        if (this.aBe > 0) {
            if (this.mSkinType == 0) {
                this.aBd.setColor(getContext().getResources().getColor(this.aBe));
            } else {
                this.aBd.setColor(aj.getColor(this.mSkinType, this.aBe));
            }
            if (this.aBj && this.aBl) {
                i = (this.aBX[0] + this.aBX[1]) - this.aBf;
            } else {
                i = this.aBX[0] + this.aBX[1];
            }
            canvas.drawRect(0.0f, this.aBX[0], getMeasuredWidth(), i, this.aBd);
        }
        super.dispatchDraw(canvas);
    }

    public void bD(boolean z) {
        this.aBj = z;
    }

    public void bE(boolean z) {
        this.aBk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBa.clear();
        this.aBb.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.aBh == 1) {
            if (rVar == null) {
                for (l lVar : this.aBa) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.aBa) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.aCa) {
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
        if (i == 2 && CX() && this.aBi != null) {
            this.aBi.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eB = eB(i);
        if (eB != null) {
            if (eB.position == 5) {
                for (l lVar : this.aBa) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.lK();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.aBb) {
                    if (aVar.aBn != null) {
                        if (aVar.position == 5) {
                            aVar.aBn.lK();
                        } else {
                            aVar.aBn.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.aBa) {
                    if (lVar2.getToolId() == 1) {
                        lVar2.hide();
                    } else {
                        if (lVar2 instanceof c) {
                            c cVar = (c) lVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        lVar2.lK();
                    }
                }
                for (a aVar2 : this.aBb) {
                    if (aVar2.aBn != null) {
                        if (aVar2.position == 5) {
                            aVar2.aBn.hide();
                        } else {
                            aVar2.aBn.lK();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eB(int i) {
        for (a aVar : this.aBb) {
            if (aVar.aBn != null && aVar.aBn.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CX() {
        for (a aVar : this.aBb) {
            if (aVar.position == 5 && aVar.aBn != null && (aVar.aBn instanceof View) && ((View) aVar.aBn).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l eC(int i) {
        for (l lVar : this.aBa) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (l lVar : this.aBa) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.aBb) {
            if (aVar.aBn != null) {
                aVar.aBn.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aBe = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.aBa) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void d(boolean z, int i) {
        for (l lVar : this.aBa) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aBh = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aBm;
        protected s aBn;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.aBm = false;
            this.aBn = null;
            this.position = 0;
            this.aBn = sVar;
            this.position = i;
            this.aBm = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aBa != null && this.aBa.size() != 0) {
            Iterator<l> it = this.aBa.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
