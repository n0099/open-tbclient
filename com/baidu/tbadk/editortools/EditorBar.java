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
    private Paint bew;
    private List<h> fyP;
    private List<a> fyQ;
    private Paint fyR;
    private int fyS;
    private int fyT;
    private EditorTools fyU;
    private boolean fyV;
    private boolean fyW;
    private boolean fyX;
    private int mBgColor;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.fyT = 0;
        this.fyV = false;
        this.fyW = false;
        this.fyX = true;
        this.fyU = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.fyP = new LinkedList();
        this.fyQ = new LinkedList();
        this.fyR = new Paint();
        this.bew = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0, getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0);
        this.fyR.setStyle(Paint.Style.FILL);
        this.bew.setStyle(Paint.Style.FILL);
        this.fyS = getResources().getDimensionPixelSize(R.dimen.L_X01);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.fyP.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, h hVar) {
        this.fyP.add(i, hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar, int i, boolean z) {
        this.fyQ.add(new a(nVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        RawLayout.LayoutParams layoutParams;
        if (!x.isEmpty(this.fyP) || this.fyT == 4) {
            kJ(true);
            boolean z = false;
            for (int i = 0; i < this.fyP.size(); i++) {
                h hVar = this.fyP.get(i);
                if (hVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) hVar;
                    if (this.fyT == 2) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else if (this.fyT == 3) {
                        layoutParams = new RawLayout.LayoutParams(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds62), 48);
                        if (i == 0 && TextUtils.isEmpty(bLauncher.getContentDescription())) {
                            z = true;
                        }
                        if (z && i == 1) {
                            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                        } else if (!z && i == 0) {
                            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                        } else {
                            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                        }
                        if (i == this.fyP.size() - 1) {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                        } else {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams.weight = 1.0f;
                    } else if (this.fyT == 1) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds62), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds62), 48);
                        layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                        if (i == this.fyP.size() - 1) {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                        } else {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    } else if (this.fyT == 5) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds78);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        layoutParams.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    }
                    layoutParams.qR(2);
                    addView(bLauncher, layoutParams);
                }
            }
            kJ(false);
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
                    if (this.fyT == 1 || this.fyT == 3 || this.fyT == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.fyT == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void kJ(boolean z) {
        RawLayout.LayoutParams layoutParams;
        for (a aVar : this.fyQ) {
            View view = (View) aVar.fyZ;
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
                layoutParams.qR(2);
                addView(view, layoutParams);
            } else if (!z && aVar.position != 1) {
                switch (aVar.position) {
                    case 2:
                        layoutParams.qR(2);
                        break;
                    case 3:
                        layoutParams.qR(1);
                        break;
                    case 4:
                        layoutParams.qR(3);
                        break;
                    case 5:
                        layoutParams.qR(2);
                        view.setVisibility(8);
                        break;
                }
                if (((n) view).getToolId() == 8) {
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
        if (this.fyR == null) {
            this.fyR = new Paint();
            this.fyR.setStyle(Paint.Style.FILL);
        }
        this.fyR.setColor(ao.getColor(this.mSkinType, R.color.CAM_X0207));
        if (this.fyX) {
            if (this.fyW) {
                canvas.drawRect(0.0f, this.fzK[0] - this.fyS, getMeasuredWidth(), this.fzK[0], this.fyR);
            }
            if (this.fyV) {
                canvas.drawRect(0.0f, (this.fzK[0] + this.fzK[1]) - this.fyS, getMeasuredWidth(), this.fzK[0] + this.fzK[1], this.fyR);
            }
        }
        if (this.bew == null) {
            this.bew = new Paint();
            this.bew.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.bew.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.bew.setColor(ao.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.fyV && this.fyX) {
                i = (this.fzK[0] + this.fzK[1]) - this.fyS;
            } else {
                i = this.fzK[0] + this.fzK[1];
            }
            canvas.drawRect(0.0f, this.fzK[0], getMeasuredWidth(), i, this.bew);
        }
        super.dispatchDraw(canvas);
    }

    public void kK(boolean z) {
        this.fyV = z;
    }

    public void kL(boolean z) {
        this.fyW = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.fyP.clear();
        this.fyQ.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        if (this.fyT == 1) {
            if (mVar == null) {
                for (h hVar : this.fyP) {
                    if (hVar instanceof View) {
                        ((View) hVar).setSelected(false);
                    }
                }
                return;
            }
            for (h hVar2 : this.fyP) {
                if (hVar2 instanceof View) {
                    View view = (View) hVar2;
                    if (hVar2.getToolId() == mVar.id && mVar.fzR) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.fyT == 3 || this.fyT == 2 || this.fyT == 5) {
            if (mVar == null) {
                for (h hVar3 : this.fyP) {
                    if (hVar3 instanceof View) {
                        ((View) hVar3).setSelected(false);
                    }
                }
            } else if (mVar.id == 5 || mVar.id == 2 || mVar.id == 6) {
                for (h hVar4 : this.fyP) {
                    if (hVar4 instanceof View) {
                        View view2 = (View) hVar4;
                        if (hVar4.getToolId() == mVar.id && mVar.fzR) {
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
    public void qK(int i) {
        if (i == 2 && bAQ() && this.fyU != null) {
            this.fyU.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a qL = qL(i);
        if (qL != null) {
            if (qL.position == 5) {
                for (h hVar : this.fyP) {
                    if (hVar.getToolId() == 2 || hVar.getToolId() == 1) {
                        hVar.rV();
                    } else {
                        hVar.hide();
                    }
                }
                for (a aVar : this.fyQ) {
                    if (aVar.fyZ != null) {
                        if (aVar.position == 5) {
                            aVar.fyZ.rV();
                        } else {
                            aVar.fyZ.hide();
                        }
                    }
                }
            } else {
                for (h hVar2 : this.fyP) {
                    if (hVar2.getToolId() == 1) {
                        hVar2.hide();
                    } else {
                        if (hVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) hVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        hVar2.rV();
                    }
                }
                for (a aVar2 : this.fyQ) {
                    if (aVar2.fyZ != null) {
                        if (aVar2.position == 5) {
                            aVar2.fyZ.hide();
                        } else {
                            aVar2.fyZ.rV();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a qL(int i) {
        for (a aVar : this.fyQ) {
            if (aVar.fyZ != null && aVar.fyZ.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean bAQ() {
        for (a aVar : this.fyQ) {
            if (aVar.position == 5 && aVar.fyZ != null && (aVar.fyZ instanceof View) && ((View) aVar.fyZ).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public h qM(int i) {
        for (h hVar : this.fyP) {
            if (hVar.getToolId() == i) {
                return hVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ao.setBackgroundColor(this, this.mBgColor);
        for (h hVar : this.fyP) {
            hVar.onChangeSkinType(i);
        }
        for (a aVar : this.fyQ) {
            if (aVar.fyZ != null) {
                aVar.fyZ.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (h hVar : this.fyP) {
            if (hVar != null && (hVar instanceof View)) {
                ((View) hVar).setEnabled(z);
            }
        }
    }

    public boolean t(boolean z, int i) {
        for (h hVar : this.fyP) {
            if (hVar instanceof View) {
                View view = (View) hVar;
                if (hVar.getToolId() == i) {
                    view.setEnabled(z);
                    return true;
                }
            }
        }
        return false;
    }

    public void setBarLauncherType(int i) {
        this.fyT = i;
    }

    public int getBarLauncherType() {
        return this.fyT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean fyY;
        protected n fyZ;
        protected int position;

        protected a(n nVar, int i, boolean z) {
            this.fyY = false;
            this.fyZ = null;
            this.position = 0;
            this.fyZ = nVar;
            this.position = i;
            this.fyY = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(View.OnClickListener onClickListener) {
        if (this.fyP != null && this.fyP.size() != 0) {
            Iterator<h> it = this.fyP.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View qN(int i) {
        for (h hVar : this.fyP) {
            if (hVar instanceof View) {
                View view = (View) hVar;
                if (hVar.getToolId() == i) {
                    return view;
                }
            }
        }
        return null;
    }
}
