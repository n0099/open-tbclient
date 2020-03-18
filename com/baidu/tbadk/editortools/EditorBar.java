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
    private Paint auU;
    private List<g> dwQ;
    private List<a> dwR;
    private Paint dwS;
    private int dwT;
    private int dwU;
    private EditorTools dwV;
    private boolean dwW;
    private boolean dwX;
    private boolean dwY;
    private int mBgColor;
    private int mInterval;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.dwU = 0;
        this.dwW = false;
        this.dwX = false;
        this.dwY = true;
        this.dwV = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.dwQ = new LinkedList();
        this.dwR = new LinkedList();
        this.dwS = new Paint();
        this.auU = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.dwS.setStyle(Paint.Style.FILL);
        this.auU.setStyle(Paint.Style.FILL);
        this.dwT = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mInterval = ((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.dwQ.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.dwQ.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar, int i, boolean z) {
        this.dwR.add(new a(mVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        RawLayout.LayoutParams layoutParams;
        if (!v.isEmpty(this.dwQ) || this.dwU == 4) {
            gB(true);
            for (int i = 0; i < this.dwQ.size(); i++) {
                g gVar = this.dwQ.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.dwU == 2) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else if (this.dwU == 3) {
                        layoutParams = new RawLayout.LayoutParams(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.weight = 1.0f;
                    } else if (this.dwU == 1) {
                        layoutParams = new RawLayout.LayoutParams(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.dwQ.size() - 1) {
                            layoutParams.rightMargin = this.mInterval;
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    } else if (this.dwU == 5) {
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
                    layoutParams.mt(2);
                    addView(bLauncher, layoutParams);
                }
            }
            gB(false);
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
                    if (this.dwU == 1 || this.dwU == 3 || this.dwU == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.dwU == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top2 = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top2, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top2);
                }
            }
        }
    }

    private void gB(boolean z) {
        RawLayout.LayoutParams layoutParams;
        for (a aVar : this.dwR) {
            View view = (View) aVar.dxa;
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = new RawLayout.LayoutParams(-2, -2, 19);
            } else if (layoutParams2 instanceof RawLayout.LayoutParams) {
                layoutParams = (RawLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = new RawLayout.LayoutParams(view.getLayoutParams());
                layoutParams.gravity = 19;
            }
            if (z && aVar.position == 1) {
                layoutParams.mt(2);
                addView(view, layoutParams);
            } else if (!z && aVar.position != 1) {
                switch (aVar.position) {
                    case 2:
                        layoutParams.mt(2);
                        break;
                    case 3:
                        layoutParams.mt(1);
                        break;
                    case 4:
                        layoutParams.mt(3);
                        break;
                    case 5:
                        layoutParams.mt(2);
                        view.setVisibility(8);
                        break;
                }
                if (((m) view).getToolId() == 8) {
                    am.setBackgroundResource(this, R.color.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                }
                addView(view, layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.dwS == null) {
            this.dwS = new Paint();
            this.dwS.setStyle(Paint.Style.FILL);
        }
        this.dwS.setColor(am.getColor(this.mSkinType, R.color.cp_bg_line_h));
        if (this.dwY) {
            if (this.dwX) {
                canvas.drawRect(0.0f, this.dxK[0] - this.dwT, getMeasuredWidth(), this.dxK[0], this.dwS);
            }
            if (this.dwW) {
                canvas.drawRect(0.0f, (this.dxK[0] + this.dxK[1]) - this.dwT, getMeasuredWidth(), this.dxK[0] + this.dxK[1], this.dwS);
            }
        }
        if (this.auU == null) {
            this.auU = new Paint();
            this.auU.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.auU.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.auU.setColor(am.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.dwW && this.dwY) {
                i = (this.dxK[0] + this.dxK[1]) - this.dwT;
            } else {
                i = this.dxK[0] + this.dxK[1];
            }
            canvas.drawRect(0.0f, this.dxK[0], getMeasuredWidth(), i, this.auU);
        }
        super.dispatchDraw(canvas);
    }

    public void gC(boolean z) {
        this.dwW = z;
    }

    public void gD(boolean z) {
        this.dwX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.dwQ.clear();
        this.dwR.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        if (this.dwU == 1) {
            if (lVar == null) {
                for (g gVar : this.dwQ) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.dwQ) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == lVar.id && lVar.dxP) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.dwU == 3 || this.dwU == 2 || this.dwU == 5) {
            if (lVar == null) {
                for (g gVar3 : this.dwQ) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (lVar.id == 5 || lVar.id == 2 || lVar.id == 6) {
                for (g gVar4 : this.dwQ) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == lVar.id && lVar.dxP) {
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
    public void mm(int i) {
        if (i == 2 && aOz() && this.dwV != null) {
            this.dwV.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a mn = mn(i);
        if (mn != null) {
            if (mn.position == 5) {
                for (g gVar : this.dwQ) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.display();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.dwR) {
                    if (aVar.dxa != null) {
                        if (aVar.position == 5) {
                            aVar.dxa.display();
                        } else {
                            aVar.dxa.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.dwQ) {
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
                for (a aVar2 : this.dwR) {
                    if (aVar2.dxa != null) {
                        if (aVar2.position == 5) {
                            aVar2.dxa.hide();
                        } else {
                            aVar2.dxa.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a mn(int i) {
        for (a aVar : this.dwR) {
            if (aVar.dxa != null && aVar.dxa.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean aOz() {
        for (a aVar : this.dwR) {
            if (aVar.position == 5 && aVar.dxa != null && (aVar.dxa instanceof View) && ((View) aVar.dxa).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g mo(int i) {
        for (g gVar : this.dwQ) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        am.setBackgroundColor(this, this.mBgColor);
        for (g gVar : this.dwQ) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.dwR) {
            if (aVar.dxa != null) {
                aVar.dxa.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.dwQ) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.dwQ) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.dwU = i;
    }

    public int getBarLauncherType() {
        return this.dwU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean dwZ;
        protected m dxa;
        protected int position;

        protected a(m mVar, int i, boolean z) {
            this.dwZ = false;
            this.dxa = null;
            this.position = 0;
            this.dxa = mVar;
            this.position = i;
            this.dwZ = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.dwQ != null && this.dwQ.size() != 0) {
            Iterator<g> it = this.dwQ.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View mp(int i) {
        for (g gVar : this.dwQ) {
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
