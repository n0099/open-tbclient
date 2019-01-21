package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private int Ew;
    private List<g> aYL;
    private List<a> aYM;
    private Paint aYN;
    private Paint aYO;
    private int aYP;
    private int aYQ;
    private EditorTools aYR;
    private boolean aYS;
    private boolean aYT;
    private boolean aYU;
    private int mBgColor;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.aYQ = 0;
        this.aYS = false;
        this.aYT = false;
        this.aYU = true;
        this.aYR = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aYL = new LinkedList();
        this.aYM = new LinkedList();
        this.aYN = new Paint();
        this.aYO = new Paint();
        setPadding(getResources().getDimensionPixelSize(e.C0210e.ds20), 0, getResources().getDimensionPixelSize(e.C0210e.ds20), 0);
        this.aYN.setStyle(Paint.Style.FILL);
        this.aYO.setStyle(Paint.Style.FILL);
        this.aYP = getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.Ew = ((com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0210e.ds64)) - (com.baidu.adp.lib.util.l.h(context, e.C0210e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aYL.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.aYL.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.aYM.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mq() {
        RawLayout.a aVar;
        if (!v.I(this.aYL) || this.aYQ == 4) {
            cs(true);
            for (int i = 0; i < this.aYL.size(); i++) {
                g gVar = this.aYL.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.aYQ == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds48), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds21);
                    } else if (this.aYQ == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aYQ == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(e.C0210e.ds12);
                        }
                        if (i != this.aYL.size() - 1) {
                            aVar.rightMargin = this.Ew;
                        }
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds15);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds15);
                    } else {
                        aVar = new RawLayout.a(-2, -2, 80);
                        aVar.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds7);
                        aVar.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds7);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds15);
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds15);
                    }
                    aVar.fN(2);
                    addView(bLauncher, aVar);
                }
            }
            cs(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.RawLayout, android.view.View
    public void onMeasure(int i, int i2) {
        TextView notice;
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof BLauncher) && (notice = ((BLauncher) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                if (((RawLayout.a) notice.getLayoutParams()) == null) {
                    generateDefaultLayoutParams();
                }
                measureChildWithMargins(notice, i, 0, i2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.RawLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int right;
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt instanceof BLauncher) {
                TextView notice = ((BLauncher) childAt).getNotice();
                BLauncher bLauncher = (BLauncher) childAt;
                if (notice != null && bLauncher.getDrawable() != null) {
                    int intrinsicWidth = bLauncher.getDrawable().getIntrinsicWidth();
                    int intrinsicHeight = bLauncher.getDrawable().getIntrinsicHeight();
                    int measuredWidth = (childAt.getMeasuredWidth() - intrinsicWidth) / 2;
                    int measuredHeight = (childAt.getMeasuredHeight() - intrinsicHeight) / 2;
                    if (this.aYQ == 1 || this.aYQ == 3 || this.aYQ == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aYQ == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void cs(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.aYM) {
            View view = (View) aVar2.aYW;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                aVar = new RawLayout.a(-2, -2, 19);
            } else if (layoutParams instanceof RawLayout.a) {
                aVar = (RawLayout.a) layoutParams;
            } else {
                aVar = new RawLayout.a(view.getLayoutParams());
                aVar.gravity = 19;
            }
            if (z && aVar2.position == 1) {
                aVar.fN(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.fN(2);
                        break;
                    case 3:
                        aVar.fN(1);
                        break;
                    case 4:
                        aVar.fN(3);
                        break;
                    case 5:
                        aVar.fN(2);
                        view.setVisibility(8);
                        break;
                }
                if (((l) view).getToolId() == 8) {
                    al.i(this, e.d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(e.d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aYN == null) {
            this.aYN = new Paint();
            this.aYN.setStyle(Paint.Style.FILL);
        }
        this.aYN.setColor(al.getColor(this.mSkinType, e.d.cp_bg_line_c));
        if (this.aYU) {
            if (this.aYT) {
                canvas.drawRect(0.0f, this.aZH[0] - this.aYP, getMeasuredWidth(), this.aZH[0], this.aYN);
            }
            if (this.aYS) {
                canvas.drawRect(0.0f, (this.aZH[0] + this.aZH[1]) - this.aYP, getMeasuredWidth(), this.aZH[0] + this.aZH[1], this.aYN);
            }
        }
        if (this.aYO == null) {
            this.aYO = new Paint();
            this.aYO.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.aYO.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.aYO.setColor(al.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.aYS && this.aYU) {
                i = (this.aZH[0] + this.aZH[1]) - this.aYP;
            } else {
                i = this.aZH[0] + this.aZH[1];
            }
            canvas.drawRect(0.0f, this.aZH[0], getMeasuredWidth(), i, this.aYO);
        }
        super.dispatchDraw(canvas);
    }

    public void ct(boolean z) {
        this.aYS = z;
    }

    public void cu(boolean z) {
        this.aYT = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aYL.clear();
        this.aYM.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.aYQ == 1) {
            if (kVar == null) {
                for (g gVar : this.aYL) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.aYL) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.aZK) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aYQ == 3 || this.aYQ == 2) {
            if (kVar == null) {
                for (g gVar3 : this.aYL) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.aYL) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.aZK) {
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
    public void fG(int i) {
        if (i == 2 && Mr() && this.aYR != null) {
            this.aYR.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a fH = fH(i);
        if (fH != null) {
            if (fH.position == 5) {
                for (g gVar : this.aYL) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.pR();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.aYM) {
                    if (aVar.aYW != null) {
                        if (aVar.position == 5) {
                            aVar.aYW.pR();
                        } else {
                            aVar.aYW.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.aYL) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.pR();
                    }
                }
                for (a aVar2 : this.aYM) {
                    if (aVar2.aYW != null) {
                        if (aVar2.position == 5) {
                            aVar2.aYW.hide();
                        } else {
                            aVar2.aYW.pR();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a fH(int i) {
        for (a aVar : this.aYM) {
            if (aVar.aYW != null && aVar.aYW.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Mr() {
        for (a aVar : this.aYM) {
            if (aVar.position == 5 && aVar.aYW != null && (aVar.aYW instanceof View) && ((View) aVar.aYW).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g fI(int i) {
        for (g gVar : this.aYL) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.j(this, this.mBgColor);
        for (g gVar : this.aYL) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.aYM) {
            if (aVar.aYW != null) {
                aVar.aYW.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.aYL) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.aYL) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aYQ = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aYV;
        protected l aYW;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.aYV = false;
            this.aYW = null;
            this.position = 0;
            this.aYW = lVar;
            this.position = i;
            this.aYV = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View.OnClickListener onClickListener) {
        if (this.aYL != null && this.aYL.size() != 0) {
            Iterator<g> it = this.aYL.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View fJ(int i) {
        for (g gVar : this.aYL) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    return view;
                }
            }
        }
        return null;
    }
}
