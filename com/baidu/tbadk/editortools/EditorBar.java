package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private Paint aXr;
    private int etA;
    private int etB;
    private EditorTools etC;
    private boolean etD;
    private boolean etE;
    private boolean etF;
    private List<g> etx;
    private List<a> ety;
    private Paint etz;
    private int mBgColor;
    private int mInterval;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.etB = 0;
        this.etD = false;
        this.etE = false;
        this.etF = true;
        this.etC = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.etx = new LinkedList();
        this.ety = new LinkedList();
        this.etz = new Paint();
        this.aXr = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.etz.setStyle(Paint.Style.FILL);
        this.aXr.setStyle(Paint.Style.FILL);
        this.etA = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mInterval = ((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.etx.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.etx.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar, int i, boolean z) {
        this.ety.add(new a(mVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        RawLayout.LayoutParams layoutParams;
        if (!w.isEmpty(this.etx) || this.etB == 4) {
            ie(true);
            for (int i = 0; i < this.etx.size(); i++) {
                g gVar = this.etx.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.etB == 2) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else if (this.etB == 3) {
                        layoutParams = new RawLayout.LayoutParams(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.weight = 1.0f;
                    } else if (this.etB == 1) {
                        layoutParams = new RawLayout.LayoutParams(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.etx.size() - 1) {
                            layoutParams.rightMargin = this.mInterval;
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    } else if (this.etB == 5) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds78);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else {
                        layoutParams = new RawLayout.LayoutParams(-2, -2, 80);
                        layoutParams.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        layoutParams.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    }
                    layoutParams.nD(2);
                    addView(bLauncher, layoutParams);
                }
            }
            ie(false);
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
                if (((RawLayout.LayoutParams) notice.getLayoutParams()) == null) {
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
                    if (this.etB == 1 || this.etB == 3 || this.etB == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.etB == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top2 = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top2, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top2);
                }
            }
        }
    }

    private void ie(boolean z) {
        RawLayout.LayoutParams layoutParams;
        for (a aVar : this.ety) {
            View view = (View) aVar.etH;
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = new RawLayout.LayoutParams(-1, -2, 19);
            } else if (layoutParams2 instanceof RawLayout.LayoutParams) {
                layoutParams = (RawLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = new RawLayout.LayoutParams(view.getLayoutParams());
                layoutParams.gravity = 19;
            }
            if (z && aVar.position == 1) {
                layoutParams.nD(2);
                addView(view, layoutParams);
            } else if (!z && aVar.position != 1) {
                switch (aVar.position) {
                    case 2:
                        layoutParams.nD(2);
                        break;
                    case 3:
                        layoutParams.nD(1);
                        break;
                    case 4:
                        layoutParams.nD(3);
                        break;
                    case 5:
                        layoutParams.nD(2);
                        view.setVisibility(8);
                        break;
                }
                if (((m) view).getToolId() == 8) {
                    an.setBackgroundResource(this, R.color.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                }
                addView(view, layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.etz == null) {
            this.etz = new Paint();
            this.etz.setStyle(Paint.Style.FILL);
        }
        this.etz.setColor(an.getColor(this.mSkinType, R.color.cp_bg_line_h));
        if (this.etF) {
            if (this.etE) {
                canvas.drawRect(0.0f, this.eur[0] - this.etA, getMeasuredWidth(), this.eur[0], this.etz);
            }
            if (this.etD) {
                canvas.drawRect(0.0f, (this.eur[0] + this.eur[1]) - this.etA, getMeasuredWidth(), this.eur[0] + this.eur[1], this.etz);
            }
        }
        if (this.aXr == null) {
            this.aXr = new Paint();
            this.aXr.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.aXr.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.aXr.setColor(an.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.etD && this.etF) {
                i = (this.eur[0] + this.eur[1]) - this.etA;
            } else {
                i = this.eur[0] + this.eur[1];
            }
            canvas.drawRect(0.0f, this.eur[0], getMeasuredWidth(), i, this.aXr);
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: if  reason: not valid java name */
    public void m31if(boolean z) {
        this.etD = z;
    }

    public void ig(boolean z) {
        this.etE = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.etx.clear();
        this.ety.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        if (this.etB == 1) {
            if (lVar == null) {
                for (g gVar : this.etx) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.etx) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == lVar.id && lVar.eux) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.etB == 3 || this.etB == 2 || this.etB == 5) {
            if (lVar == null) {
                for (g gVar3 : this.etx) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (lVar.id == 5 || lVar.id == 2 || lVar.id == 6) {
                for (g gVar4 : this.etx) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == lVar.id && lVar.eux) {
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
    public void nw(int i) {
        if (i == 2 && bfb() && this.etC != null) {
            this.etC.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a nx = nx(i);
        if (nx != null) {
            if (nx.position == 5) {
                for (g gVar : this.etx) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.display();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.ety) {
                    if (aVar.etH != null) {
                        if (aVar.position == 5) {
                            aVar.etH.display();
                        } else {
                            aVar.etH.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.etx) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.display();
                    }
                }
                for (a aVar2 : this.ety) {
                    if (aVar2.etH != null) {
                        if (aVar2.position == 5) {
                            aVar2.etH.hide();
                        } else {
                            aVar2.etH.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a nx(int i) {
        for (a aVar : this.ety) {
            if (aVar.etH != null && aVar.etH.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean bfb() {
        for (a aVar : this.ety) {
            if (aVar.position == 5 && aVar.etH != null && (aVar.etH instanceof View) && ((View) aVar.etH).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g ny(int i) {
        for (g gVar : this.etx) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        an.setBackgroundColor(this, this.mBgColor);
        for (g gVar : this.etx) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.ety) {
            if (aVar.etH != null) {
                aVar.etH.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.etx) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public boolean t(boolean z, int i) {
        for (g gVar : this.etx) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                    return true;
                }
            }
        }
        return false;
    }

    public void setBarLauncherType(int i) {
        this.etB = i;
    }

    public int getBarLauncherType() {
        return this.etB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean etG;
        protected m etH;
        protected int position;

        protected a(m mVar, int i, boolean z) {
            this.etG = false;
            this.etH = null;
            this.position = 0;
            this.etH = mVar;
            this.position = i;
            this.etG = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.etx != null && this.etx.size() != 0) {
            Iterator<g> it = this.etx.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View nz(int i) {
        for (g gVar : this.etx) {
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
