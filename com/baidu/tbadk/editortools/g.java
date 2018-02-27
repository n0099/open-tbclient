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
    private int akI;
    private List<l> brX;
    private List<a> brY;
    private Paint brZ;
    private Paint bsa;
    private int bsb;
    private int bsc;
    private int bsd;
    private i bse;
    private boolean bsf;
    private boolean bsg;
    private boolean bsh;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.bsb = 0;
        this.bsd = 0;
        this.bsf = false;
        this.bsg = false;
        this.bsh = true;
        this.bse = iVar;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.brX = new LinkedList();
        this.brY = new LinkedList();
        this.brZ = new Paint();
        this.bsa = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.brZ.setStyle(Paint.Style.FILL);
        this.bsa.setStyle(Paint.Style.FILL);
        this.bsc = getResources().getDimensionPixelSize(d.e.ds1);
        this.akI = ((com.baidu.adp.lib.util.l.ao(context) - com.baidu.adp.lib.util.l.t(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.t(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.brX.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.brX.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.brY.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Lc() {
        p.a aVar;
        if (!v.E(this.brX)) {
            ce(true);
            for (int i = 0; i < this.brX.size(); i++) {
                l lVar = this.brX.get(i);
                if (lVar instanceof c) {
                    c cVar = (c) lVar;
                    if (this.bsd == 2) {
                        aVar = new p.a(com.baidu.adp.lib.util.l.t(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.t(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds21);
                    } else if (this.bsd == 3) {
                        aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.t(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.bsd == 1) {
                        aVar = new p.a(cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.brX.size() - 1) {
                            aVar.rightMargin = this.akI;
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
                    if (this.bsd == 1 || this.bsd == 3 || this.bsd == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.bsd == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void ce(boolean z) {
        p.a aVar;
        for (a aVar2 : this.brY) {
            View view = (View) aVar2.bsj;
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
                    aj.s(this, d.C0141d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0141d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.brZ == null) {
            this.brZ = new Paint();
            this.brZ.setStyle(Paint.Style.FILL);
        }
        this.brZ.setColor(aj.getColor(this.mSkinType, d.C0141d.cp_bg_line_c));
        if (this.bsh) {
            if (this.bsg) {
                canvas.drawRect(0.0f, this.bsU[0] - this.bsc, getMeasuredWidth(), this.bsU[0], this.brZ);
            }
            if (this.bsf) {
                canvas.drawRect(0.0f, (this.bsU[0] + this.bsU[1]) - this.bsc, getMeasuredWidth(), this.bsU[0] + this.bsU[1], this.brZ);
            }
        }
        if (this.bsa == null) {
            this.bsa = new Paint();
            this.bsa.setStyle(Paint.Style.FILL);
        }
        if (this.bsb > 0) {
            if (this.mSkinType == 0) {
                this.bsa.setColor(getContext().getResources().getColor(this.bsb));
            } else {
                this.bsa.setColor(aj.getColor(this.mSkinType, this.bsb));
            }
            if (this.bsf && this.bsh) {
                i = (this.bsU[0] + this.bsU[1]) - this.bsc;
            } else {
                i = this.bsU[0] + this.bsU[1];
            }
            canvas.drawRect(0.0f, this.bsU[0], getMeasuredWidth(), i, this.bsa);
        }
        super.dispatchDraw(canvas);
    }

    public void cf(boolean z) {
        this.bsf = z;
    }

    public void cg(boolean z) {
        this.bsg = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.brX.clear();
        this.brY.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.bsd == 1) {
            if (rVar == null) {
                for (l lVar : this.brX) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.brX) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.bsX) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.bsd == 3 || this.bsd == 2) {
            if (rVar == null) {
                for (l lVar3 : this.brX) {
                    if (lVar3 instanceof View) {
                        ((View) lVar3).setSelected(false);
                    }
                }
            } else if (rVar.id == 5 || rVar.id == 2 || rVar.id == 6) {
                for (l lVar4 : this.brX) {
                    if (lVar4 instanceof View) {
                        View view2 = (View) lVar4;
                        if (lVar4.getToolId() == rVar.id && rVar.bsX) {
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
        if (i == 2 && Ld() && this.bse != null) {
            this.bse.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a hF = hF(i);
        if (hF != null) {
            if (hF.position == 5) {
                for (l lVar : this.brX) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.th();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.brY) {
                    if (aVar.bsj != null) {
                        if (aVar.position == 5) {
                            aVar.bsj.th();
                        } else {
                            aVar.bsj.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.brX) {
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
                for (a aVar2 : this.brY) {
                    if (aVar2.bsj != null) {
                        if (aVar2.position == 5) {
                            aVar2.bsj.hide();
                        } else {
                            aVar2.bsj.th();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a hF(int i) {
        for (a aVar : this.brY) {
            if (aVar.bsj != null && aVar.bsj.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Ld() {
        for (a aVar : this.brY) {
            if (aVar.position == 5 && aVar.bsj != null && (aVar.bsj instanceof View) && ((View) aVar.bsj).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l hG(int i) {
        for (l lVar : this.brX) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aj.t(this, this.bsb);
        for (l lVar : this.brX) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.brY) {
            if (aVar.bsj != null) {
                aVar.bsj.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.bsb = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.brX) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void g(boolean z, int i) {
        for (l lVar : this.brX) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.bsd = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean bsi;
        protected s bsj;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.bsi = false;
            this.bsj = null;
            this.position = 0;
            this.bsj = sVar;
            this.position = i;
            this.bsi = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.brX != null && this.brX.size() != 0) {
            Iterator<l> it = this.brX.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
