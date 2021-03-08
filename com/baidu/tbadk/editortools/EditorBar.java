package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private Paint bjg;
    private List<h> fCD;
    private List<a> fCE;
    private Paint fCF;
    private int fCG;
    private int fCH;
    private EditorTools fCI;
    private boolean fCJ;
    private boolean fCK;
    private boolean fCL;
    private int mBgColor;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.fCH = 0;
        this.fCJ = false;
        this.fCK = false;
        this.fCL = true;
        this.fCI = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.fCD = new LinkedList();
        this.fCE = new LinkedList();
        this.fCF = new Paint();
        this.bjg = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0, getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0);
        this.fCF.setStyle(Paint.Style.FILL);
        this.bjg.setStyle(Paint.Style.FILL);
        this.fCG = getResources().getDimensionPixelSize(R.dimen.L_X01);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.fCD.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, h hVar) {
        this.fCD.add(i, hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar, int i, boolean z) {
        this.fCE.add(new a(nVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        RawLayout.LayoutParams layoutParams;
        if (!y.isEmpty(this.fCD) || this.fCH == 4) {
            kM(true);
            boolean z = false;
            for (int i = 0; i < this.fCD.size(); i++) {
                h hVar = this.fCD.get(i);
                if (hVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) hVar;
                    if (this.fCH == 2) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else if (this.fCH == 3) {
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
                        if (i == this.fCD.size() - 1) {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                        } else {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams.weight = 1.0f;
                    } else if (this.fCH == 1) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds62), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds62), 48);
                        layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                        if (i == this.fCD.size() - 1) {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                        } else {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    } else if (this.fCH == 5) {
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
                    layoutParams.qX(2);
                    addView(bLauncher, layoutParams);
                }
            }
            kM(false);
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
                    if (this.fCH == 1 || this.fCH == 3 || this.fCH == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.fCH == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void kM(boolean z) {
        RawLayout.LayoutParams layoutParams;
        for (a aVar : this.fCE) {
            View view = (View) aVar.fCN;
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
                layoutParams.qX(2);
                addView(view, layoutParams);
            } else if (!z && aVar.position != 1) {
                switch (aVar.position) {
                    case 2:
                        layoutParams.qX(2);
                        break;
                    case 3:
                        layoutParams.qX(1);
                        break;
                    case 4:
                        layoutParams.qX(3);
                        break;
                    case 5:
                        layoutParams.qX(2);
                        view.setVisibility(8);
                        break;
                }
                if (((n) view).getToolId() == 8) {
                    ap.setBackgroundResource(this, R.color.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                }
                addView(view, layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.fCF == null) {
            this.fCF = new Paint();
            this.fCF.setStyle(Paint.Style.FILL);
        }
        this.fCF.setColor(ap.getColor(this.mSkinType, R.color.CAM_X0207));
        if (this.fCL) {
            if (this.fCK) {
                canvas.drawRect(0.0f, this.fDy[0] - this.fCG, getMeasuredWidth(), this.fDy[0], this.fCF);
            }
            if (this.fCJ) {
                canvas.drawRect(0.0f, (this.fDy[0] + this.fDy[1]) - this.fCG, getMeasuredWidth(), this.fDy[0] + this.fDy[1], this.fCF);
            }
        }
        if (this.bjg == null) {
            this.bjg = new Paint();
            this.bjg.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.bjg.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.bjg.setColor(ap.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.fCJ && this.fCL) {
                i = (this.fDy[0] + this.fDy[1]) - this.fCG;
            } else {
                i = this.fDy[0] + this.fDy[1];
            }
            canvas.drawRect(0.0f, this.fDy[0], getMeasuredWidth(), i, this.bjg);
        }
        super.dispatchDraw(canvas);
    }

    public void kN(boolean z) {
        this.fCJ = z;
    }

    public void kO(boolean z) {
        this.fCK = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.fCD.clear();
        this.fCE.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        if (this.fCH == 1) {
            if (mVar == null) {
                for (h hVar : this.fCD) {
                    if (hVar instanceof View) {
                        ((View) hVar).setSelected(false);
                    }
                }
                return;
            }
            for (h hVar2 : this.fCD) {
                if (hVar2 instanceof View) {
                    View view = (View) hVar2;
                    if (hVar2.getToolId() == mVar.id && mVar.fDF) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.fCH == 3 || this.fCH == 2 || this.fCH == 5) {
            if (mVar == null) {
                for (h hVar3 : this.fCD) {
                    if (hVar3 instanceof View) {
                        ((View) hVar3).setSelected(false);
                    }
                }
            } else if (mVar.id == 5 || mVar.id == 2 || mVar.id == 6) {
                for (h hVar4 : this.fCD) {
                    if (hVar4 instanceof View) {
                        View view2 = (View) hVar4;
                        if (hVar4.getToolId() == mVar.id && mVar.fDF) {
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
    public void qQ(int i) {
        if (i == 2 && bBl() && this.fCI != null) {
            this.fCI.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a qR = qR(i);
        if (qR != null) {
            if (qR.position == 5) {
                for (h hVar : this.fCD) {
                    if (hVar.getToolId() == 2 || hVar.getToolId() == 1) {
                        hVar.display();
                    } else {
                        hVar.hide();
                    }
                }
                for (a aVar : this.fCE) {
                    if (aVar.fCN != null) {
                        if (aVar.position == 5) {
                            aVar.fCN.display();
                        } else {
                            aVar.fCN.hide();
                        }
                    }
                }
            } else {
                for (h hVar2 : this.fCD) {
                    if (hVar2.getToolId() == 1) {
                        hVar2.hide();
                    } else {
                        if (hVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) hVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        hVar2.display();
                    }
                }
                for (a aVar2 : this.fCE) {
                    if (aVar2.fCN != null) {
                        if (aVar2.position == 5) {
                            aVar2.fCN.hide();
                        } else {
                            aVar2.fCN.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a qR(int i) {
        for (a aVar : this.fCE) {
            if (aVar.fCN != null && aVar.fCN.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean bBl() {
        for (a aVar : this.fCE) {
            if (aVar.position == 5 && aVar.fCN != null && (aVar.fCN instanceof View) && ((View) aVar.fCN).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public h qS(int i) {
        for (h hVar : this.fCD) {
            if (hVar.getToolId() == i) {
                return hVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ap.setBackgroundColor(this, this.mBgColor);
        for (h hVar : this.fCD) {
            hVar.onChangeSkinType(i);
        }
        for (a aVar : this.fCE) {
            if (aVar.fCN != null) {
                aVar.fCN.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (h hVar : this.fCD) {
            if (hVar != null && (hVar instanceof View)) {
                ((View) hVar).setEnabled(z);
            }
        }
    }

    public boolean t(boolean z, int i) {
        for (h hVar : this.fCD) {
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
        this.fCH = i;
    }

    public int getBarLauncherType() {
        return this.fCH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean fCM;
        protected n fCN;
        protected int position;

        protected a(n nVar, int i, boolean z) {
            this.fCM = false;
            this.fCN = null;
            this.position = 0;
            this.fCN = nVar;
            this.position = i;
            this.fCM = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(View.OnClickListener onClickListener) {
        if (this.fCD != null && this.fCD.size() != 0) {
            Iterator<h> it = this.fCD.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View qT(int i) {
        for (h hVar : this.fCD) {
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
