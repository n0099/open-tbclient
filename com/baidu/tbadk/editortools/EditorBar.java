package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private Paint aYt;
    private List<g> ezP;
    private List<a> ezQ;
    private Paint ezR;
    private int ezS;
    private int ezT;
    private EditorTools ezU;
    private boolean ezV;
    private boolean ezW;
    private boolean ezX;
    private int mBgColor;
    private int mInterval;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.ezT = 0;
        this.ezV = false;
        this.ezW = false;
        this.ezX = true;
        this.ezU = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.ezP = new LinkedList();
        this.ezQ = new LinkedList();
        this.ezR = new Paint();
        this.aYt = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.ezR.setStyle(Paint.Style.FILL);
        this.aYt.setStyle(Paint.Style.FILL);
        this.ezS = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mInterval = ((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.ezP.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.ezP.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar, int i, boolean z) {
        this.ezQ.add(new a(mVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        RawLayout.LayoutParams layoutParams;
        if (!x.isEmpty(this.ezP) || this.ezT == 4) {
            iI(true);
            for (int i = 0; i < this.ezP.size(); i++) {
                g gVar = this.ezP.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.ezT == 2) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else if (this.ezT == 3) {
                        layoutParams = new RawLayout.LayoutParams(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.weight = 1.0f;
                    } else if (this.ezT == 1) {
                        layoutParams = new RawLayout.LayoutParams(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.ezP.size() - 1) {
                            layoutParams.rightMargin = this.mInterval;
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    } else if (this.ezT == 5) {
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
                    layoutParams.nV(2);
                    addView(bLauncher, layoutParams);
                }
            }
            iI(false);
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
                    if (this.ezT == 1 || this.ezT == 3 || this.ezT == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.ezT == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void iI(boolean z) {
        RawLayout.LayoutParams layoutParams;
        for (a aVar : this.ezQ) {
            View view = (View) aVar.ezZ;
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
                layoutParams.nV(2);
                addView(view, layoutParams);
            } else if (!z && aVar.position != 1) {
                switch (aVar.position) {
                    case 2:
                        layoutParams.nV(2);
                        break;
                    case 3:
                        layoutParams.nV(1);
                        break;
                    case 4:
                        layoutParams.nV(3);
                        break;
                    case 5:
                        layoutParams.nV(2);
                        view.setVisibility(8);
                        break;
                }
                if (((m) view).getToolId() == 8) {
                    ao.setBackgroundResource(this, R.color.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                }
                addView(view, layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.ezR == null) {
            this.ezR = new Paint();
            this.ezR.setStyle(Paint.Style.FILL);
        }
        this.ezR.setColor(ao.getColor(this.mSkinType, R.color.cp_bg_line_h));
        if (this.ezX) {
            if (this.ezW) {
                canvas.drawRect(0.0f, this.eAK[0] - this.ezS, getMeasuredWidth(), this.eAK[0], this.ezR);
            }
            if (this.ezV) {
                canvas.drawRect(0.0f, (this.eAK[0] + this.eAK[1]) - this.ezS, getMeasuredWidth(), this.eAK[0] + this.eAK[1], this.ezR);
            }
        }
        if (this.aYt == null) {
            this.aYt = new Paint();
            this.aYt.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.aYt.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.aYt.setColor(ao.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.ezV && this.ezX) {
                i = (this.eAK[0] + this.eAK[1]) - this.ezS;
            } else {
                i = this.eAK[0] + this.eAK[1];
            }
            canvas.drawRect(0.0f, this.eAK[0], getMeasuredWidth(), i, this.aYt);
        }
        super.dispatchDraw(canvas);
    }

    public void iJ(boolean z) {
        this.ezV = z;
    }

    public void iK(boolean z) {
        this.ezW = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ezP.clear();
        this.ezQ.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        if (this.ezT == 1) {
            if (lVar == null) {
                for (g gVar : this.ezP) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.ezP) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == lVar.id && lVar.eAQ) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.ezT == 3 || this.ezT == 2 || this.ezT == 5) {
            if (lVar == null) {
                for (g gVar3 : this.ezP) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (lVar.id == 5 || lVar.id == 2 || lVar.id == 6) {
                for (g gVar4 : this.ezP) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == lVar.id && lVar.eAQ) {
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
    public void nO(int i) {
        if (i == 2 && biK() && this.ezU != null) {
            this.ezU.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a nP = nP(i);
        if (nP != null) {
            if (nP.position == 5) {
                for (g gVar : this.ezP) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.display();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.ezQ) {
                    if (aVar.ezZ != null) {
                        if (aVar.position == 5) {
                            aVar.ezZ.display();
                        } else {
                            aVar.ezZ.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.ezP) {
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
                for (a aVar2 : this.ezQ) {
                    if (aVar2.ezZ != null) {
                        if (aVar2.position == 5) {
                            aVar2.ezZ.hide();
                        } else {
                            aVar2.ezZ.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a nP(int i) {
        for (a aVar : this.ezQ) {
            if (aVar.ezZ != null && aVar.ezZ.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean biK() {
        for (a aVar : this.ezQ) {
            if (aVar.position == 5 && aVar.ezZ != null && (aVar.ezZ instanceof View) && ((View) aVar.ezZ).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g nQ(int i) {
        for (g gVar : this.ezP) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ao.setBackgroundColor(this, this.mBgColor);
        for (g gVar : this.ezP) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.ezQ) {
            if (aVar.ezZ != null) {
                aVar.ezZ.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.ezP) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public boolean t(boolean z, int i) {
        for (g gVar : this.ezP) {
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
        this.ezT = i;
    }

    public int getBarLauncherType() {
        return this.ezT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean ezY;
        protected m ezZ;
        protected int position;

        protected a(m mVar, int i, boolean z) {
            this.ezY = false;
            this.ezZ = null;
            this.position = 0;
            this.ezZ = mVar;
            this.position = i;
            this.ezY = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.ezP != null && this.ezP.size() != 0) {
            Iterator<g> it = this.ezP.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View nR(int i) {
        for (g gVar : this.ezP) {
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
