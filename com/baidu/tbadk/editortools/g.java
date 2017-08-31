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
    private List<l> aBd;
    private List<a> aBe;
    private Paint aBf;
    private Paint aBg;
    private int aBh;
    private int aBi;
    private boolean aBj;
    private int aBk;
    private i aBl;
    private boolean aBm;
    private boolean aBn;
    private boolean aBo;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.aBh = 0;
        this.aBj = false;
        this.aBk = 0;
        this.aBm = false;
        this.aBn = false;
        this.aBo = true;
        this.aBl = iVar;
        init();
    }

    private void init() {
        this.aBd = new LinkedList();
        this.aBe = new LinkedList();
        this.aBf = new Paint();
        this.aBg = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.f.ds20), 0, getResources().getDimensionPixelSize(d.f.ds20), 0);
        this.aBf.setStyle(Paint.Style.FILL);
        this.aBg.setStyle(Paint.Style.FILL);
        this.aBi = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.aBd.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.aBd.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.aBe.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CW() {
        p.a aVar;
        bC(true);
        Iterator<l> it = this.aBd.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aBk == 1) {
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
                    if (this.aBk == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aBk == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bC(boolean z) {
        p.a aVar;
        for (a aVar2 : this.aBe) {
            View view = (View) aVar2.aBq;
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
        if (this.aBf == null) {
            this.aBf = new Paint();
            this.aBf.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aBf.setColor(getContext().getResources().getColor(d.e.cp_bg_line_b));
        } else {
            this.aBf.setColor(aj.getColor(this.mSkinType, d.e.cp_bg_line_b));
        }
        if (this.aBo) {
            if (this.aBn) {
                canvas.drawRect(0.0f, this.aCa[0] - this.aBi, getMeasuredWidth(), this.aCa[0], this.aBf);
            }
            if (this.aBm) {
                canvas.drawRect(0.0f, (this.aCa[0] + this.aCa[1]) - this.aBi, getMeasuredWidth(), this.aCa[0] + this.aCa[1], this.aBf);
            }
        }
        if (this.aBg == null) {
            this.aBg = new Paint();
            this.aBg.setStyle(Paint.Style.FILL);
        }
        if (this.aBh > 0) {
            if (this.mSkinType == 0) {
                this.aBg.setColor(getContext().getResources().getColor(this.aBh));
            } else {
                this.aBg.setColor(aj.getColor(this.mSkinType, this.aBh));
            }
            if (this.aBm && this.aBo) {
                i = (this.aCa[0] + this.aCa[1]) - this.aBi;
            } else {
                i = this.aCa[0] + this.aCa[1];
            }
            canvas.drawRect(0.0f, this.aCa[0], getMeasuredWidth(), i, this.aBg);
        }
        super.dispatchDraw(canvas);
    }

    public void bD(boolean z) {
        this.aBm = z;
    }

    public void bE(boolean z) {
        this.aBn = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aBd.clear();
        this.aBe.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.aBk == 1) {
            if (rVar == null) {
                for (l lVar : this.aBd) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.aBd) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.aCd) {
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
        if (i == 2 && CX() && this.aBl != null) {
            this.aBl.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eB = eB(i);
        if (eB != null) {
            if (eB.position == 5) {
                for (l lVar : this.aBd) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.lK();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.aBe) {
                    if (aVar.aBq != null) {
                        if (aVar.position == 5) {
                            aVar.aBq.lK();
                        } else {
                            aVar.aBq.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.aBd) {
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
                for (a aVar2 : this.aBe) {
                    if (aVar2.aBq != null) {
                        if (aVar2.position == 5) {
                            aVar2.aBq.hide();
                        } else {
                            aVar2.aBq.lK();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eB(int i) {
        for (a aVar : this.aBe) {
            if (aVar.aBq != null && aVar.aBq.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CX() {
        for (a aVar : this.aBe) {
            if (aVar.position == 5 && aVar.aBq != null && (aVar.aBq instanceof View) && ((View) aVar.aBq).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l eC(int i) {
        for (l lVar : this.aBd) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (l lVar : this.aBd) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.aBe) {
            if (aVar.aBq != null) {
                aVar.aBq.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aBh = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.aBd) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void d(boolean z, int i) {
        for (l lVar : this.aBd) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aBk = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aBp;
        protected s aBq;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.aBp = false;
            this.aBq = null;
            this.position = 0;
            this.aBq = sVar;
            this.position = i;
            this.aBp = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aBd != null && this.aBd.size() != 0) {
            Iterator<l> it = this.aBd.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
