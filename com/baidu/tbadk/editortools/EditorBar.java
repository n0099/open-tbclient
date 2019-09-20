package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private int Cj;
    private List<g> csJ;
    private List<a> csK;
    private Paint csL;
    private Paint csM;
    private int csN;
    private int csO;
    private int csP;
    private EditorTools csQ;
    private boolean csR;
    private boolean csS;
    private boolean csT;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.csN = 0;
        this.csP = 0;
        this.csR = false;
        this.csS = false;
        this.csT = true;
        this.csQ = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.csJ = new LinkedList();
        this.csK = new LinkedList();
        this.csL = new Paint();
        this.csM = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.csL.setStyle(Paint.Style.FILL);
        this.csM.setStyle(Paint.Style.FILL);
        this.csO = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.Cj = ((com.baidu.adp.lib.util.l.af(context) - com.baidu.adp.lib.util.l.g(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.g(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.csJ.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.csJ.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.csK.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asn() {
        RawLayout.a aVar;
        if (!v.aa(this.csJ) || this.csP == 4) {
            fj(true);
            for (int i = 0; i < this.csJ.size(); i++) {
                g gVar = this.csJ.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.csP == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                    } else if (this.csP == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.csP == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.csJ.size() - 1) {
                            aVar.rightMargin = this.Cj;
                        }
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    } else {
                        aVar = new RawLayout.a(-2, -2, 80);
                        aVar.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        aVar.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    }
                    aVar.kv(2);
                    addView(bLauncher, aVar);
                }
            }
            fj(false);
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
                    if (this.csP == 1 || this.csP == 3 || this.csP == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.csP == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void fj(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.csK) {
            View view = (View) aVar2.csV;
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
                aVar.kv(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.kv(2);
                        break;
                    case 3:
                        aVar.kv(1);
                        break;
                    case 4:
                        aVar.kv(3);
                        break;
                    case 5:
                        aVar.kv(2);
                        view.setVisibility(8);
                        break;
                }
                if (((l) view).getToolId() == 8) {
                    am.k(this, R.color.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.csL == null) {
            this.csL = new Paint();
            this.csL.setStyle(Paint.Style.FILL);
        }
        this.csL.setColor(am.getColor(this.mSkinType, R.color.cp_bg_line_h));
        if (this.csT) {
            if (this.csS) {
                canvas.drawRect(0.0f, this.ctG[0] - this.csO, getMeasuredWidth(), this.ctG[0], this.csL);
            }
            if (this.csR) {
                canvas.drawRect(0.0f, (this.ctG[0] + this.ctG[1]) - this.csO, getMeasuredWidth(), this.ctG[0] + this.ctG[1], this.csL);
            }
        }
        if (this.csM == null) {
            this.csM = new Paint();
            this.csM.setStyle(Paint.Style.FILL);
        }
        if (this.csN > 0) {
            if (this.mSkinType == 0) {
                this.csM.setColor(getContext().getResources().getColor(this.csN));
            } else {
                this.csM.setColor(am.getColor(this.mSkinType, this.csN));
            }
            if (this.csR && this.csT) {
                i = (this.ctG[0] + this.ctG[1]) - this.csO;
            } else {
                i = this.ctG[0] + this.ctG[1];
            }
            canvas.drawRect(0.0f, this.ctG[0], getMeasuredWidth(), i, this.csM);
        }
        super.dispatchDraw(canvas);
    }

    public void fk(boolean z) {
        this.csR = z;
    }

    public void fl(boolean z) {
        this.csS = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.csJ.clear();
        this.csK.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.csP == 1) {
            if (kVar == null) {
                for (g gVar : this.csJ) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.csJ) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.ctL) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.csP == 3 || this.csP == 2) {
            if (kVar == null) {
                for (g gVar3 : this.csJ) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.csJ) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.ctL) {
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
    public void ko(int i) {
        if (i == 2 && aso() && this.csQ != null) {
            this.csQ.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a kp = kp(i);
        if (kp != null) {
            if (kp.position == 5) {
                for (g gVar : this.csJ) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.ql();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.csK) {
                    if (aVar.csV != null) {
                        if (aVar.position == 5) {
                            aVar.csV.ql();
                        } else {
                            aVar.csV.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.csJ) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.ql();
                    }
                }
                for (a aVar2 : this.csK) {
                    if (aVar2.csV != null) {
                        if (aVar2.position == 5) {
                            aVar2.csV.hide();
                        } else {
                            aVar2.csV.ql();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a kp(int i) {
        for (a aVar : this.csK) {
            if (aVar.csV != null && aVar.csV.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean aso() {
        for (a aVar : this.csK) {
            if (aVar.position == 5 && aVar.csV != null && (aVar.csV instanceof View) && ((View) aVar.csV).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g kq(int i) {
        for (g gVar : this.csJ) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        am.l(this, this.csN);
        for (g gVar : this.csJ) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.csK) {
            if (aVar.csV != null) {
                aVar.csV.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.csN = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.csJ) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.csJ) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.csP = i;
    }

    public int getBarLauncherType() {
        return this.csP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean csU;
        protected l csV;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.csU = false;
            this.csV = null;
            this.position = 0;
            this.csV = lVar;
            this.position = i;
            this.csU = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(View.OnClickListener onClickListener) {
        if (this.csJ != null && this.csJ.size() != 0) {
            Iterator<g> it = this.csJ.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View kr(int i) {
        for (g gVar : this.csJ) {
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
