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
    private int akO;
    private List<l> bsk;
    private List<a> bsl;
    private Paint bsm;
    private Paint bsn;
    private int bso;
    private int bsp;
    private int bsq;
    private i bsr;
    private boolean bss;
    private boolean bst;
    private boolean bsu;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.bso = 0;
        this.bsq = 0;
        this.bss = false;
        this.bst = false;
        this.bsu = true;
        this.bsr = iVar;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.bsk = new LinkedList();
        this.bsl = new LinkedList();
        this.bsm = new Paint();
        this.bsn = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.bsm.setStyle(Paint.Style.FILL);
        this.bsn.setStyle(Paint.Style.FILL);
        this.bsp = getResources().getDimensionPixelSize(d.e.ds1);
        this.akO = ((com.baidu.adp.lib.util.l.ao(context) - com.baidu.adp.lib.util.l.t(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.t(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.bsk.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.bsk.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.bsl.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ld() {
        p.a aVar;
        if (!v.E(this.bsk)) {
            ce(true);
            for (int i = 0; i < this.bsk.size(); i++) {
                l lVar = this.bsk.get(i);
                if (lVar instanceof c) {
                    c cVar = (c) lVar;
                    if (this.bsq == 2) {
                        aVar = new p.a(com.baidu.adp.lib.util.l.t(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.t(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds21);
                    } else if (this.bsq == 3) {
                        aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.bsq == 1) {
                        aVar = new p.a(cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.bsk.size() - 1) {
                            aVar.rightMargin = this.akO;
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
                    aVar.hK(2);
                    addView(cVar, aVar);
                }
            }
            ce(false);
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
                    if (this.bsq == 1 || this.bsq == 3 || this.bsq == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.bsq == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void ce(boolean z) {
        p.a aVar;
        for (a aVar2 : this.bsl) {
            View view = (View) aVar2.bsw;
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
                aVar.hK(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.hK(2);
                        break;
                    case 3:
                        aVar.hK(1);
                        break;
                    case 4:
                        aVar.hK(3);
                        break;
                    case 5:
                        aVar.hK(2);
                        view.setVisibility(8);
                        break;
                }
                if (((s) view).getToolId() == 8) {
                    aj.s(this, d.C0140d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0140d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.bsm == null) {
            this.bsm = new Paint();
            this.bsm.setStyle(Paint.Style.FILL);
        }
        this.bsm.setColor(aj.getColor(this.mSkinType, d.C0140d.cp_bg_line_c));
        if (this.bsu) {
            if (this.bst) {
                canvas.drawRect(0.0f, this.bth[0] - this.bsp, getMeasuredWidth(), this.bth[0], this.bsm);
            }
            if (this.bss) {
                canvas.drawRect(0.0f, (this.bth[0] + this.bth[1]) - this.bsp, getMeasuredWidth(), this.bth[0] + this.bth[1], this.bsm);
            }
        }
        if (this.bsn == null) {
            this.bsn = new Paint();
            this.bsn.setStyle(Paint.Style.FILL);
        }
        if (this.bso > 0) {
            if (this.mSkinType == 0) {
                this.bsn.setColor(getContext().getResources().getColor(this.bso));
            } else {
                this.bsn.setColor(aj.getColor(this.mSkinType, this.bso));
            }
            if (this.bss && this.bsu) {
                i = (this.bth[0] + this.bth[1]) - this.bsp;
            } else {
                i = this.bth[0] + this.bth[1];
            }
            canvas.drawRect(0.0f, this.bth[0], getMeasuredWidth(), i, this.bsn);
        }
        super.dispatchDraw(canvas);
    }

    public void cf(boolean z) {
        this.bss = z;
    }

    public void cg(boolean z) {
        this.bst = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.bsk.clear();
        this.bsl.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.bsq == 1) {
            if (rVar == null) {
                for (l lVar : this.bsk) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.bsk) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.btk) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.bsq == 3 || this.bsq == 2) {
            if (rVar == null) {
                for (l lVar3 : this.bsk) {
                    if (lVar3 instanceof View) {
                        ((View) lVar3).setSelected(false);
                    }
                }
            } else if (rVar.id == 5 || rVar.id == 2 || rVar.id == 6) {
                for (l lVar4 : this.bsk) {
                    if (lVar4 instanceof View) {
                        View view2 = (View) lVar4;
                        if (lVar4.getToolId() == rVar.id && rVar.btk) {
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
    public void hE(int i) {
        if (i == 2 && Le() && this.bsr != null) {
            this.bsr.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a hF = hF(i);
        if (hF != null) {
            if (hF.position == 5) {
                for (l lVar : this.bsk) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.th();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.bsl) {
                    if (aVar.bsw != null) {
                        if (aVar.position == 5) {
                            aVar.bsw.th();
                        } else {
                            aVar.bsw.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.bsk) {
                    if (lVar2.getToolId() == 1) {
                        lVar2.hide();
                    } else {
                        if (lVar2 instanceof c) {
                            c cVar = (c) lVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        lVar2.th();
                    }
                }
                for (a aVar2 : this.bsl) {
                    if (aVar2.bsw != null) {
                        if (aVar2.position == 5) {
                            aVar2.bsw.hide();
                        } else {
                            aVar2.bsw.th();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a hF(int i) {
        for (a aVar : this.bsl) {
            if (aVar.bsw != null && aVar.bsw.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Le() {
        for (a aVar : this.bsl) {
            if (aVar.position == 5 && aVar.bsw != null && (aVar.bsw instanceof View) && ((View) aVar.bsw).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l hG(int i) {
        for (l lVar : this.bsk) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aj.t(this, this.bso);
        for (l lVar : this.bsk) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.bsl) {
            if (aVar.bsw != null) {
                aVar.bsw.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.bso = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.bsk) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void g(boolean z, int i) {
        for (l lVar : this.bsk) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.bsq = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean bsv;
        protected s bsw;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.bsv = false;
            this.bsw = null;
            this.position = 0;
            this.bsw = sVar;
            this.position = i;
            this.bsv = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.bsk != null && this.bsk.size() != 0) {
            Iterator<l> it = this.bsk.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
