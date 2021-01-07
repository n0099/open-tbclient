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
    private Paint bjn;
    private int fDA;
    private int fDB;
    private EditorTools fDC;
    private boolean fDD;
    private boolean fDE;
    private boolean fDF;
    private List<h> fDx;
    private List<a> fDy;
    private Paint fDz;
    private int mBgColor;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.fDB = 0;
        this.fDD = false;
        this.fDE = false;
        this.fDF = true;
        this.fDC = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.fDx = new LinkedList();
        this.fDy = new LinkedList();
        this.fDz = new Paint();
        this.bjn = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0, getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0);
        this.fDz.setStyle(Paint.Style.FILL);
        this.bjn.setStyle(Paint.Style.FILL);
        this.fDA = getResources().getDimensionPixelSize(R.dimen.L_X01);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.fDx.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, h hVar) {
        this.fDx.add(i, hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar, int i, boolean z) {
        this.fDy.add(new a(nVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        RawLayout.LayoutParams layoutParams;
        if (!x.isEmpty(this.fDx) || this.fDB == 4) {
            kN(true);
            boolean z = false;
            for (int i = 0; i < this.fDx.size(); i++) {
                h hVar = this.fDx.get(i);
                if (hVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) hVar;
                    if (this.fDB == 2) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else if (this.fDB == 3) {
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
                        if (i == this.fDx.size() - 1) {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                        } else {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams.weight = 1.0f;
                    } else if (this.fDB == 1) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds62), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds62), 48);
                        layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                        if (i == this.fDx.size() - 1) {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                        } else {
                            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    } else if (this.fDB == 5) {
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
                    layoutParams.sx(2);
                    addView(bLauncher, layoutParams);
                }
            }
            kN(false);
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
                    if (this.fDB == 1 || this.fDB == 3 || this.fDB == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.fDB == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void kN(boolean z) {
        RawLayout.LayoutParams layoutParams;
        for (a aVar : this.fDy) {
            View view = (View) aVar.fDH;
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
                layoutParams.sx(2);
                addView(view, layoutParams);
            } else if (!z && aVar.position != 1) {
                switch (aVar.position) {
                    case 2:
                        layoutParams.sx(2);
                        break;
                    case 3:
                        layoutParams.sx(1);
                        break;
                    case 4:
                        layoutParams.sx(3);
                        break;
                    case 5:
                        layoutParams.sx(2);
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
        if (this.fDz == null) {
            this.fDz = new Paint();
            this.fDz.setStyle(Paint.Style.FILL);
        }
        this.fDz.setColor(ao.getColor(this.mSkinType, R.color.CAM_X0207));
        if (this.fDF) {
            if (this.fDE) {
                canvas.drawRect(0.0f, this.fEs[0] - this.fDA, getMeasuredWidth(), this.fEs[0], this.fDz);
            }
            if (this.fDD) {
                canvas.drawRect(0.0f, (this.fEs[0] + this.fEs[1]) - this.fDA, getMeasuredWidth(), this.fEs[0] + this.fEs[1], this.fDz);
            }
        }
        if (this.bjn == null) {
            this.bjn = new Paint();
            this.bjn.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.bjn.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.bjn.setColor(ao.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.fDD && this.fDF) {
                i = (this.fEs[0] + this.fEs[1]) - this.fDA;
            } else {
                i = this.fEs[0] + this.fEs[1];
            }
            canvas.drawRect(0.0f, this.fEs[0], getMeasuredWidth(), i, this.bjn);
        }
        super.dispatchDraw(canvas);
    }

    public void kO(boolean z) {
        this.fDD = z;
    }

    public void kP(boolean z) {
        this.fDE = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.fDx.clear();
        this.fDy.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        if (this.fDB == 1) {
            if (mVar == null) {
                for (h hVar : this.fDx) {
                    if (hVar instanceof View) {
                        ((View) hVar).setSelected(false);
                    }
                }
                return;
            }
            for (h hVar2 : this.fDx) {
                if (hVar2 instanceof View) {
                    View view = (View) hVar2;
                    if (hVar2.getToolId() == mVar.id && mVar.fEz) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.fDB == 3 || this.fDB == 2 || this.fDB == 5) {
            if (mVar == null) {
                for (h hVar3 : this.fDx) {
                    if (hVar3 instanceof View) {
                        ((View) hVar3).setSelected(false);
                    }
                }
            } else if (mVar.id == 5 || mVar.id == 2 || mVar.id == 6) {
                for (h hVar4 : this.fDx) {
                    if (hVar4 instanceof View) {
                        View view2 = (View) hVar4;
                        if (hVar4.getToolId() == mVar.id && mVar.fEz) {
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
    public void sq(int i) {
        if (i == 2 && bEK() && this.fDC != null) {
            this.fDC.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a sr = sr(i);
        if (sr != null) {
            if (sr.position == 5) {
                for (h hVar : this.fDx) {
                    if (hVar.getToolId() == 2 || hVar.getToolId() == 1) {
                        hVar.rV();
                    } else {
                        hVar.hide();
                    }
                }
                for (a aVar : this.fDy) {
                    if (aVar.fDH != null) {
                        if (aVar.position == 5) {
                            aVar.fDH.rV();
                        } else {
                            aVar.fDH.hide();
                        }
                    }
                }
            } else {
                for (h hVar2 : this.fDx) {
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
                for (a aVar2 : this.fDy) {
                    if (aVar2.fDH != null) {
                        if (aVar2.position == 5) {
                            aVar2.fDH.hide();
                        } else {
                            aVar2.fDH.rV();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a sr(int i) {
        for (a aVar : this.fDy) {
            if (aVar.fDH != null && aVar.fDH.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean bEK() {
        for (a aVar : this.fDy) {
            if (aVar.position == 5 && aVar.fDH != null && (aVar.fDH instanceof View) && ((View) aVar.fDH).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public h ss(int i) {
        for (h hVar : this.fDx) {
            if (hVar.getToolId() == i) {
                return hVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ao.setBackgroundColor(this, this.mBgColor);
        for (h hVar : this.fDx) {
            hVar.onChangeSkinType(i);
        }
        for (a aVar : this.fDy) {
            if (aVar.fDH != null) {
                aVar.fDH.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (h hVar : this.fDx) {
            if (hVar != null && (hVar instanceof View)) {
                ((View) hVar).setEnabled(z);
            }
        }
    }

    public boolean t(boolean z, int i) {
        for (h hVar : this.fDx) {
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
        this.fDB = i;
    }

    public int getBarLauncherType() {
        return this.fDB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean fDG;
        protected n fDH;
        protected int position;

        protected a(n nVar, int i, boolean z) {
            this.fDG = false;
            this.fDH = null;
            this.position = 0;
            this.fDH = nVar;
            this.position = i;
            this.fDG = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(View.OnClickListener onClickListener) {
        if (this.fDx != null && this.fDx.size() != 0) {
            Iterator<h> it = this.fDx.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View st(int i) {
        for (h hVar : this.fDx) {
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
