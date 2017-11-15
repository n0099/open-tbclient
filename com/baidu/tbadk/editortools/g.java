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
    private List<l> aBb;
    private List<a> aBc;
    private Paint aBd;
    private Paint aBe;
    private int aBf;
    private int aBg;
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
        this.aBf = 0;
        this.aBh = 0;
        this.aBj = false;
        this.aBk = false;
        this.aBl = true;
        this.aBi = iVar;
        init();
    }

    private void init() {
        this.aBb = new LinkedList();
        this.aBc = new LinkedList();
        this.aBd = new Paint();
        this.aBe = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.aBd.setStyle(Paint.Style.FILL);
        this.aBe.setStyle(Paint.Style.FILL);
        this.aBg = com.baidu.adp.lib.util.l.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBb.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.aBb.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.aBc.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CV() {
        p.a aVar;
        bw(true);
        Iterator<l> it = this.aBb.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aBh == 1) {
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
            aVar.eQ(2);
            addView(cVar, aVar);
        }
        bw(false);
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
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aBh == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bw(boolean z) {
        p.a aVar;
        for (a aVar2 : this.aBc) {
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
                aVar.eQ(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eQ(2);
                        break;
                    case 3:
                        aVar.eQ(1);
                        break;
                    case 4:
                        aVar.eQ(3);
                        break;
                    case 5:
                        aVar.eQ(2);
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
        if (this.aBd == null) {
            this.aBd = new Paint();
            this.aBd.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aBd.setColor(getContext().getResources().getColor(d.C0080d.cp_bg_line_b));
        } else {
            this.aBd.setColor(aj.getColor(this.mSkinType, d.C0080d.cp_bg_line_b));
        }
        if (this.aBl) {
            if (this.aBk) {
                canvas.drawRect(0.0f, this.aBW[0] - this.aBg, getMeasuredWidth(), this.aBW[0], this.aBd);
            }
            if (this.aBj) {
                canvas.drawRect(0.0f, (this.aBW[0] + this.aBW[1]) - this.aBg, getMeasuredWidth(), this.aBW[0] + this.aBW[1], this.aBd);
            }
        }
        if (this.aBe == null) {
            this.aBe = new Paint();
            this.aBe.setStyle(Paint.Style.FILL);
        }
        if (this.aBf > 0) {
            if (this.mSkinType == 0) {
                this.aBe.setColor(getContext().getResources().getColor(this.aBf));
            } else {
                this.aBe.setColor(aj.getColor(this.mSkinType, this.aBf));
            }
            if (this.aBj && this.aBl) {
                i = (this.aBW[0] + this.aBW[1]) - this.aBg;
            } else {
                i = this.aBW[0] + this.aBW[1];
            }
            canvas.drawRect(0.0f, this.aBW[0], getMeasuredWidth(), i, this.aBe);
        }
        super.dispatchDraw(canvas);
    }

    public void bx(boolean z) {
        this.aBj = z;
    }

    public void by(boolean z) {
        this.aBk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBb.clear();
        this.aBc.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.aBh == 1) {
            if (rVar == null) {
                for (l lVar : this.aBb) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.aBb) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.aBZ) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eK(int i) {
        if (i == 2 && CW() && this.aBi != null) {
            this.aBi.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eL = eL(i);
        if (eL != null) {
            if (eL.position == 5) {
                for (l lVar : this.aBb) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.lG();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.aBc) {
                    if (aVar.aBn != null) {
                        if (aVar.position == 5) {
                            aVar.aBn.lG();
                        } else {
                            aVar.aBn.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.aBb) {
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
                for (a aVar2 : this.aBc) {
                    if (aVar2.aBn != null) {
                        if (aVar2.position == 5) {
                            aVar2.aBn.hide();
                        } else {
                            aVar2.aBn.lG();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eL(int i) {
        for (a aVar : this.aBc) {
            if (aVar.aBn != null && aVar.aBn.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CW() {
        for (a aVar : this.aBc) {
            if (aVar.position == 5 && aVar.aBn != null && (aVar.aBn instanceof View) && ((View) aVar.aBn).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l eM(int i) {
        for (l lVar : this.aBb) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aj.k(this, this.aBf);
        for (l lVar : this.aBb) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.aBc) {
            if (aVar.aBn != null) {
                aVar.aBn.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aBf = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.aBb) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void d(boolean z, int i) {
        for (l lVar : this.aBb) {
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
        if (this.aBb != null && this.aBb.size() != 0) {
            Iterator<l> it = this.aBb.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
