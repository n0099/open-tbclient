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
    private int akM;
    private List<l> bpF;
    private List<a> bpG;
    private Paint bpH;
    private Paint bpI;
    private int bpJ;
    private int bpK;
    private int bpL;
    private i bpM;
    private boolean bpN;
    private boolean bpO;
    private boolean bpP;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.bpJ = 0;
        this.bpL = 0;
        this.bpN = false;
        this.bpO = false;
        this.bpP = true;
        this.bpM = iVar;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.bpF = new LinkedList();
        this.bpG = new LinkedList();
        this.bpH = new Paint();
        this.bpI = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.bpH.setStyle(Paint.Style.FILL);
        this.bpI.setStyle(Paint.Style.FILL);
        this.bpK = getResources().getDimensionPixelSize(d.e.ds1);
        this.akM = ((com.baidu.adp.lib.util.l.ao(context) - com.baidu.adp.lib.util.l.s(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.s(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.bpF.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.bpF.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.bpG.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KG() {
        p.a aVar;
        if (!v.G(this.bpF)) {
            cb(true);
            for (int i = 0; i < this.bpF.size(); i++) {
                l lVar = this.bpF.get(i);
                if (lVar instanceof c) {
                    c cVar = (c) lVar;
                    if (this.bpL == 2) {
                        aVar = new p.a(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.s(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                    } else if (this.bpL == 3) {
                        aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.bpL == 1) {
                        aVar = new p.a(cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.bpF.size() - 1) {
                            aVar.rightMargin = this.akM;
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
                    aVar.hP(2);
                    addView(cVar, aVar);
                }
            }
            cb(false);
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
                    if (this.bpL == 1 || this.bpL == 3 || this.bpL == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.bpL == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void cb(boolean z) {
        p.a aVar;
        for (a aVar2 : this.bpG) {
            View view = (View) aVar2.bpR;
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
                aVar.hP(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.hP(2);
                        break;
                    case 3:
                        aVar.hP(1);
                        break;
                    case 4:
                        aVar.hP(3);
                        break;
                    case 5:
                        aVar.hP(2);
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
        if (this.bpH == null) {
            this.bpH = new Paint();
            this.bpH.setStyle(Paint.Style.FILL);
        }
        this.bpH.setColor(aj.getColor(this.mSkinType, d.C0108d.cp_bg_line_c));
        if (this.bpP) {
            if (this.bpO) {
                canvas.drawRect(0.0f, this.bqC[0] - this.bpK, getMeasuredWidth(), this.bqC[0], this.bpH);
            }
            if (this.bpN) {
                canvas.drawRect(0.0f, (this.bqC[0] + this.bqC[1]) - this.bpK, getMeasuredWidth(), this.bqC[0] + this.bqC[1], this.bpH);
            }
        }
        if (this.bpI == null) {
            this.bpI = new Paint();
            this.bpI.setStyle(Paint.Style.FILL);
        }
        if (this.bpJ > 0) {
            if (this.mSkinType == 0) {
                this.bpI.setColor(getContext().getResources().getColor(this.bpJ));
            } else {
                this.bpI.setColor(aj.getColor(this.mSkinType, this.bpJ));
            }
            if (this.bpN && this.bpP) {
                i = (this.bqC[0] + this.bqC[1]) - this.bpK;
            } else {
                i = this.bqC[0] + this.bqC[1];
            }
            canvas.drawRect(0.0f, this.bqC[0], getMeasuredWidth(), i, this.bpI);
        }
        super.dispatchDraw(canvas);
    }

    public void cc(boolean z) {
        this.bpN = z;
    }

    public void cd(boolean z) {
        this.bpO = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.bpF.clear();
        this.bpG.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.bpL == 1) {
            if (rVar == null) {
                for (l lVar : this.bpF) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.bpF) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.bqF) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.bpL == 3 || this.bpL == 2) {
            if (rVar == null) {
                for (l lVar3 : this.bpF) {
                    if (lVar3 instanceof View) {
                        ((View) lVar3).setSelected(false);
                    }
                }
            } else if (rVar.id == 5 || rVar.id == 2 || rVar.id == 6) {
                for (l lVar4 : this.bpF) {
                    if (lVar4 instanceof View) {
                        View view2 = (View) lVar4;
                        if (lVar4.getToolId() == rVar.id && rVar.bqF) {
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
    public void hJ(int i) {
        if (i == 2 && KH() && this.bpM != null) {
            this.bpM.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a hK = hK(i);
        if (hK != null) {
            if (hK.position == 5) {
                for (l lVar : this.bpF) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.th();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.bpG) {
                    if (aVar.bpR != null) {
                        if (aVar.position == 5) {
                            aVar.bpR.th();
                        } else {
                            aVar.bpR.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.bpF) {
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
                for (a aVar2 : this.bpG) {
                    if (aVar2.bpR != null) {
                        if (aVar2.position == 5) {
                            aVar2.bpR.hide();
                        } else {
                            aVar2.bpR.th();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a hK(int i) {
        for (a aVar : this.bpG) {
            if (aVar.bpR != null && aVar.bpR.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean KH() {
        for (a aVar : this.bpG) {
            if (aVar.position == 5 && aVar.bpR != null && (aVar.bpR instanceof View) && ((View) aVar.bpR).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l hL(int i) {
        for (l lVar : this.bpF) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aj.t(this, this.bpJ);
        for (l lVar : this.bpF) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.bpG) {
            if (aVar.bpR != null) {
                aVar.bpR.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.bpJ = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.bpF) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void g(boolean z, int i) {
        for (l lVar : this.bpF) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.bpL = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean bpQ;
        protected s bpR;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.bpQ = false;
            this.bpR = null;
            this.position = 0;
            this.bpR = sVar;
            this.position = i;
            this.bpQ = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.bpF != null && this.bpF.size() != 0) {
            Iterator<l> it = this.bpF.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
