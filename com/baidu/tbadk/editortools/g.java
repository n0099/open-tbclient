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
    private int akP;
    private List<l> bpX;
    private List<a> bpY;
    private Paint bpZ;
    private Paint bqa;
    private int bqb;
    private int bqc;
    private int bqd;
    private i bqe;
    private boolean bqf;
    private boolean bqg;
    private boolean bqh;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.bqb = 0;
        this.bqd = 0;
        this.bqf = false;
        this.bqg = false;
        this.bqh = true;
        this.bqe = iVar;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.bpX = new LinkedList();
        this.bpY = new LinkedList();
        this.bpZ = new Paint();
        this.bqa = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.bpZ.setStyle(Paint.Style.FILL);
        this.bqa.setStyle(Paint.Style.FILL);
        this.bqc = getResources().getDimensionPixelSize(d.e.ds1);
        this.akP = ((com.baidu.adp.lib.util.l.ao(context) - com.baidu.adp.lib.util.l.s(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.s(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.bpX.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.bpX.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.bpY.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kx() {
        p.a aVar;
        if (!v.E(this.bpX)) {
            ca(true);
            for (int i = 0; i < this.bpX.size(); i++) {
                l lVar = this.bpX.get(i);
                if (lVar instanceof c) {
                    c cVar = (c) lVar;
                    if (this.bqd == 2) {
                        aVar = new p.a(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.s(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                    } else if (this.bqd == 3) {
                        aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.bqd == 1) {
                        aVar = new p.a(cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.bpX.size() - 1) {
                            aVar.rightMargin = this.akP;
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
                    aVar.hL(2);
                    addView(cVar, aVar);
                }
            }
            ca(false);
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
                    if (this.bqd == 1 || this.bqd == 3 || this.bqd == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.bqd == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void ca(boolean z) {
        p.a aVar;
        for (a aVar2 : this.bpY) {
            View view = (View) aVar2.bqj;
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
                aVar.hL(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.hL(2);
                        break;
                    case 3:
                        aVar.hL(1);
                        break;
                    case 4:
                        aVar.hL(3);
                        break;
                    case 5:
                        aVar.hL(2);
                        view.setVisibility(8);
                        break;
                }
                if (((s) view).getToolId() == 8) {
                    aj.s(this, d.C0108d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0108d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.bpZ == null) {
            this.bpZ = new Paint();
            this.bpZ.setStyle(Paint.Style.FILL);
        }
        this.bpZ.setColor(aj.getColor(this.mSkinType, d.C0108d.cp_bg_line_c));
        if (this.bqh) {
            if (this.bqg) {
                canvas.drawRect(0.0f, this.bqU[0] - this.bqc, getMeasuredWidth(), this.bqU[0], this.bpZ);
            }
            if (this.bqf) {
                canvas.drawRect(0.0f, (this.bqU[0] + this.bqU[1]) - this.bqc, getMeasuredWidth(), this.bqU[0] + this.bqU[1], this.bpZ);
            }
        }
        if (this.bqa == null) {
            this.bqa = new Paint();
            this.bqa.setStyle(Paint.Style.FILL);
        }
        if (this.bqb > 0) {
            if (this.mSkinType == 0) {
                this.bqa.setColor(getContext().getResources().getColor(this.bqb));
            } else {
                this.bqa.setColor(aj.getColor(this.mSkinType, this.bqb));
            }
            if (this.bqf && this.bqh) {
                i = (this.bqU[0] + this.bqU[1]) - this.bqc;
            } else {
                i = this.bqU[0] + this.bqU[1];
            }
            canvas.drawRect(0.0f, this.bqU[0], getMeasuredWidth(), i, this.bqa);
        }
        super.dispatchDraw(canvas);
    }

    public void cb(boolean z) {
        this.bqf = z;
    }

    public void cc(boolean z) {
        this.bqg = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.bpX.clear();
        this.bpY.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.bqd == 1) {
            if (rVar == null) {
                for (l lVar : this.bpX) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.bpX) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.bqX) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.bqd == 3 || this.bqd == 2) {
            if (rVar == null) {
                for (l lVar3 : this.bpX) {
                    if (lVar3 instanceof View) {
                        ((View) lVar3).setSelected(false);
                    }
                }
            } else if (rVar.id == 5 || rVar.id == 2 || rVar.id == 6) {
                for (l lVar4 : this.bpX) {
                    if (lVar4 instanceof View) {
                        View view2 = (View) lVar4;
                        if (lVar4.getToolId() == rVar.id && rVar.bqX) {
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
    public void hF(int i) {
        if (i == 2 && Ky() && this.bqe != null) {
            this.bqe.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a hG = hG(i);
        if (hG != null) {
            if (hG.position == 5) {
                for (l lVar : this.bpX) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.ti();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.bpY) {
                    if (aVar.bqj != null) {
                        if (aVar.position == 5) {
                            aVar.bqj.ti();
                        } else {
                            aVar.bqj.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.bpX) {
                    if (lVar2.getToolId() == 1) {
                        lVar2.hide();
                    } else {
                        if (lVar2 instanceof c) {
                            c cVar = (c) lVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        lVar2.ti();
                    }
                }
                for (a aVar2 : this.bpY) {
                    if (aVar2.bqj != null) {
                        if (aVar2.position == 5) {
                            aVar2.bqj.hide();
                        } else {
                            aVar2.bqj.ti();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a hG(int i) {
        for (a aVar : this.bpY) {
            if (aVar.bqj != null && aVar.bqj.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Ky() {
        for (a aVar : this.bpY) {
            if (aVar.position == 5 && aVar.bqj != null && (aVar.bqj instanceof View) && ((View) aVar.bqj).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l hH(int i) {
        for (l lVar : this.bpX) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aj.t(this, this.bqb);
        for (l lVar : this.bpX) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.bpY) {
            if (aVar.bqj != null) {
                aVar.bqj.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.bqb = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.bpX) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void g(boolean z, int i) {
        for (l lVar : this.bpX) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.bqd = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean bqi;
        protected s bqj;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.bqi = false;
            this.bqj = null;
            this.position = 0;
            this.bqj = sVar;
            this.position = i;
            this.bqi = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.bpX != null && this.bpX.size() != 0) {
            Iterator<l> it = this.bpX.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
