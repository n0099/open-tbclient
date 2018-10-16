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
    private int Es;
    private List<g> aTK;
    private List<a> aTL;
    private Paint aTM;
    private Paint aTN;
    private int aTO;
    private int aTP;
    private EditorTools aTQ;
    private boolean aTR;
    private boolean aTS;
    private boolean aTT;
    private int mBgColor;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.aTP = 0;
        this.aTR = false;
        this.aTS = false;
        this.aTT = true;
        this.aTQ = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aTK = new LinkedList();
        this.aTL = new LinkedList();
        this.aTM = new Paint();
        this.aTN = new Paint();
        setPadding(getResources().getDimensionPixelSize(e.C0175e.ds20), 0, getResources().getDimensionPixelSize(e.C0175e.ds20), 0);
        this.aTM.setStyle(Paint.Style.FILL);
        this.aTN.setStyle(Paint.Style.FILL);
        this.aTO = getResources().getDimensionPixelSize(e.C0175e.ds1);
        this.Es = ((com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0175e.ds64)) - (com.baidu.adp.lib.util.l.h(context, e.C0175e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aTK.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.aTK.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.aTL.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KI() {
        RawLayout.a aVar;
        if (!v.J(this.aTK) || this.aTP == 4) {
            bX(true);
            for (int i = 0; i < this.aTK.size(); i++) {
                g gVar = this.aTK.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.aTP == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds48), com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds21);
                    } else if (this.aTP == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(e.C0175e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aTP == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(e.C0175e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(e.C0175e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(e.C0175e.ds12);
                        }
                        if (i != this.aTK.size() - 1) {
                            aVar.rightMargin = this.Es;
                        }
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0175e.ds15);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0175e.ds15);
                    } else {
                        aVar = new RawLayout.a(-2, -2, 80);
                        aVar.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0175e.ds7);
                        aVar.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0175e.ds7);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0175e.ds15);
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0175e.ds15);
                    }
                    aVar.fk(2);
                    addView(bLauncher, aVar);
                }
            }
            bX(false);
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
                    if (this.aTP == 1 || this.aTP == 3 || this.aTP == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aTP == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bX(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.aTL) {
            View view = (View) aVar2.aTV;
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
                aVar.fk(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.fk(2);
                        break;
                    case 3:
                        aVar.fk(1);
                        break;
                    case 4:
                        aVar.fk(3);
                        break;
                    case 5:
                        aVar.fk(2);
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
        if (this.aTM == null) {
            this.aTM = new Paint();
            this.aTM.setStyle(Paint.Style.FILL);
        }
        this.aTM.setColor(al.getColor(this.mSkinType, e.d.cp_bg_line_c));
        if (this.aTT) {
            if (this.aTS) {
                canvas.drawRect(0.0f, this.aUG[0] - this.aTO, getMeasuredWidth(), this.aUG[0], this.aTM);
            }
            if (this.aTR) {
                canvas.drawRect(0.0f, (this.aUG[0] + this.aUG[1]) - this.aTO, getMeasuredWidth(), this.aUG[0] + this.aUG[1], this.aTM);
            }
        }
        if (this.aTN == null) {
            this.aTN = new Paint();
            this.aTN.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.aTN.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.aTN.setColor(al.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.aTR && this.aTT) {
                i = (this.aUG[0] + this.aUG[1]) - this.aTO;
            } else {
                i = this.aUG[0] + this.aUG[1];
            }
            canvas.drawRect(0.0f, this.aUG[0], getMeasuredWidth(), i, this.aTN);
        }
        super.dispatchDraw(canvas);
    }

    public void bY(boolean z) {
        this.aTR = z;
    }

    public void bZ(boolean z) {
        this.aTS = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aTK.clear();
        this.aTL.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.aTP == 1) {
            if (kVar == null) {
                for (g gVar : this.aTK) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.aTK) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.aUJ) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aTP == 3 || this.aTP == 2) {
            if (kVar == null) {
                for (g gVar3 : this.aTK) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.aTK) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.aUJ) {
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
    public void fd(int i) {
        if (i == 2 && KJ() && this.aTQ != null) {
            this.aTQ.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a fe = fe(i);
        if (fe != null) {
            if (fe.position == 5) {
                for (g gVar : this.aTK) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.pQ();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.aTL) {
                    if (aVar.aTV != null) {
                        if (aVar.position == 5) {
                            aVar.aTV.pQ();
                        } else {
                            aVar.aTV.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.aTK) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.pQ();
                    }
                }
                for (a aVar2 : this.aTL) {
                    if (aVar2.aTV != null) {
                        if (aVar2.position == 5) {
                            aVar2.aTV.hide();
                        } else {
                            aVar2.aTV.pQ();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a fe(int i) {
        for (a aVar : this.aTL) {
            if (aVar.aTV != null && aVar.aTV.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean KJ() {
        for (a aVar : this.aTL) {
            if (aVar.position == 5 && aVar.aTV != null && (aVar.aTV instanceof View) && ((View) aVar.aTV).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g ff(int i) {
        for (g gVar : this.aTK) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.j(this, this.mBgColor);
        for (g gVar : this.aTK) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.aTL) {
            if (aVar.aTV != null) {
                aVar.aTV.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.aTK) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.aTK) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aTP = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aTU;
        protected l aTV;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.aTU = false;
            this.aTV = null;
            this.position = 0;
            this.aTV = lVar;
            this.position = i;
            this.aTU = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aTK != null && this.aTK.size() != 0) {
            Iterator<g> it = this.aTK.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View fg(int i) {
        for (g gVar : this.aTK) {
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
