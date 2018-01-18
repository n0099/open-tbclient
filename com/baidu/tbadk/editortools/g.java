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
    private List<l> bpO;
    private List<a> bpP;
    private Paint bpQ;
    private Paint bpR;
    private int bpS;
    private int bpT;
    private int bpU;
    private i bpV;
    private boolean bpW;
    private boolean bpX;
    private boolean bpY;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, i iVar) {
        super(context);
        this.mSkinType = 0;
        this.bpS = 0;
        this.bpU = 0;
        this.bpW = false;
        this.bpX = false;
        this.bpY = true;
        this.bpV = iVar;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.bpO = new LinkedList();
        this.bpP = new LinkedList();
        this.bpQ = new Paint();
        this.bpR = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.bpQ.setStyle(Paint.Style.FILL);
        this.bpR.setStyle(Paint.Style.FILL);
        this.bpT = getResources().getDimensionPixelSize(d.e.ds1);
        this.akM = ((com.baidu.adp.lib.util.l.ao(context) - com.baidu.adp.lib.util.l.s(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.s(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        this.bpO.add(lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, l lVar) {
        this.bpO.add(i, lVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar, int i, boolean z) {
        this.bpP.add(new a(sVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Kv() {
        p.a aVar;
        if (!v.E(this.bpO)) {
            bZ(true);
            for (int i = 0; i < this.bpO.size(); i++) {
                l lVar = this.bpO.get(i);
                if (lVar instanceof c) {
                    c cVar = (c) lVar;
                    if (this.bpU == 2) {
                        aVar = new p.a(com.baidu.adp.lib.util.l.s(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.s(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                    } else if (this.bpU == 3) {
                        aVar = new p.a(0, cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.s(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.bpU == 1) {
                        aVar = new p.a(cVar.getContext().getResources().getDimensionPixelSize(d.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.bpO.size() - 1) {
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
                    aVar.hL(2);
                    addView(cVar, aVar);
                }
            }
            bZ(false);
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
                    if (this.bpU == 1 || this.bpU == 3 || this.bpU == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.bpU == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bZ(boolean z) {
        p.a aVar;
        for (a aVar2 : this.bpP) {
            View view = (View) aVar2.bqa;
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
                    aj.s(this, d.C0107d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0107d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.bpQ == null) {
            this.bpQ = new Paint();
            this.bpQ.setStyle(Paint.Style.FILL);
        }
        this.bpQ.setColor(aj.getColor(this.mSkinType, d.C0107d.cp_bg_line_c));
        if (this.bpY) {
            if (this.bpX) {
                canvas.drawRect(0.0f, this.bqL[0] - this.bpT, getMeasuredWidth(), this.bqL[0], this.bpQ);
            }
            if (this.bpW) {
                canvas.drawRect(0.0f, (this.bqL[0] + this.bqL[1]) - this.bpT, getMeasuredWidth(), this.bqL[0] + this.bqL[1], this.bpQ);
            }
        }
        if (this.bpR == null) {
            this.bpR = new Paint();
            this.bpR.setStyle(Paint.Style.FILL);
        }
        if (this.bpS > 0) {
            if (this.mSkinType == 0) {
                this.bpR.setColor(getContext().getResources().getColor(this.bpS));
            } else {
                this.bpR.setColor(aj.getColor(this.mSkinType, this.bpS));
            }
            if (this.bpW && this.bpY) {
                i = (this.bqL[0] + this.bqL[1]) - this.bpT;
            } else {
                i = this.bqL[0] + this.bqL[1];
            }
            canvas.drawRect(0.0f, this.bqL[0], getMeasuredWidth(), i, this.bpR);
        }
        super.dispatchDraw(canvas);
    }

    public void ca(boolean z) {
        this.bpW = z;
    }

    public void cb(boolean z) {
        this.bpX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.bpO.clear();
        this.bpP.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        if (this.bpU == 1) {
            if (rVar == null) {
                for (l lVar : this.bpO) {
                    if (lVar instanceof View) {
                        ((View) lVar).setSelected(false);
                    }
                }
                return;
            }
            for (l lVar2 : this.bpO) {
                if (lVar2 instanceof View) {
                    View view = (View) lVar2;
                    if (lVar2.getToolId() == rVar.id && rVar.bqO) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.bpU == 3 || this.bpU == 2) {
            if (rVar == null) {
                for (l lVar3 : this.bpO) {
                    if (lVar3 instanceof View) {
                        ((View) lVar3).setSelected(false);
                    }
                }
            } else if (rVar.id == 5 || rVar.id == 2 || rVar.id == 6) {
                for (l lVar4 : this.bpO) {
                    if (lVar4 instanceof View) {
                        View view2 = (View) lVar4;
                        if (lVar4.getToolId() == rVar.id && rVar.bqO) {
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
        if (i == 2 && Kw() && this.bpV != null) {
            this.bpV.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a hG = hG(i);
        if (hG != null) {
            if (hG.position == 5) {
                for (l lVar : this.bpO) {
                    if (lVar.getToolId() == 2 || lVar.getToolId() == 1) {
                        lVar.th();
                    } else {
                        lVar.hide();
                    }
                }
                for (a aVar : this.bpP) {
                    if (aVar.bqa != null) {
                        if (aVar.position == 5) {
                            aVar.bqa.th();
                        } else {
                            aVar.bqa.hide();
                        }
                    }
                }
            } else {
                for (l lVar2 : this.bpO) {
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
                for (a aVar2 : this.bpP) {
                    if (aVar2.bqa != null) {
                        if (aVar2.position == 5) {
                            aVar2.bqa.hide();
                        } else {
                            aVar2.bqa.th();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a hG(int i) {
        for (a aVar : this.bpP) {
            if (aVar.bqa != null && aVar.bqa.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Kw() {
        for (a aVar : this.bpP) {
            if (aVar.position == 5 && aVar.bqa != null && (aVar.bqa instanceof View) && ((View) aVar.bqa).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public l hH(int i) {
        for (l lVar : this.bpO) {
            if (lVar.getToolId() == i) {
                return lVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aj.t(this, this.bpS);
        for (l lVar : this.bpO) {
            lVar.onChangeSkinType(i);
        }
        for (a aVar : this.bpP) {
            if (aVar.bqa != null) {
                aVar.bqa.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.bpS = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (l lVar : this.bpO) {
            if (lVar != null && (lVar instanceof View)) {
                ((View) lVar).setEnabled(z);
            }
        }
    }

    public void g(boolean z, int i) {
        for (l lVar : this.bpO) {
            if (lVar instanceof View) {
                View view = (View) lVar;
                if (lVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.bpU = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean bpZ;
        protected s bqa;
        protected int position;

        protected a(s sVar, int i, boolean z) {
            this.bpZ = false;
            this.bqa = null;
            this.position = 0;
            this.bqa = sVar;
            this.position = i;
            this.bpZ = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.bpO != null && this.bpO.size() != 0) {
            Iterator<l> it = this.bpO.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
