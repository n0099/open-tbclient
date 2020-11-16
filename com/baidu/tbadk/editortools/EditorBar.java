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
    private Paint blw;
    private List<h> fmm;
    private List<a> fmn;
    private Paint fmo;
    private int fmq;
    private int fmr;
    private EditorTools fms;
    private boolean fmt;
    private boolean fmu;
    private boolean fmv;
    private int mBgColor;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.fmr = 0;
        this.fmt = false;
        this.fmu = false;
        this.fmv = true;
        this.fms = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.fmm = new LinkedList();
        this.fmn = new LinkedList();
        this.fmo = new Paint();
        this.blw = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0, getResources().getDimensionPixelSize(R.dimen.M_W_X007), 0);
        this.fmo.setStyle(Paint.Style.FILL);
        this.blw.setStyle(Paint.Style.FILL);
        this.fmq = getResources().getDimensionPixelSize(R.dimen.L_X01);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.fmm.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, h hVar) {
        this.fmm.add(i, hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar, int i, boolean z) {
        this.fmn.add(new a(nVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        boolean z;
        RawLayout.LayoutParams layoutParams;
        if (!y.isEmpty(this.fmm) || this.fmr == 4) {
            kb(true);
            boolean z2 = false;
            for (int i = 0; i < this.fmm.size(); i++) {
                h hVar = this.fmm.get(i);
                if (hVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) hVar;
                    if (this.fmr == 2) {
                        RawLayout.LayoutParams layoutParams2 = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams2.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        z = z2;
                        layoutParams = layoutParams2;
                    } else if (this.fmr == 3) {
                        RawLayout.LayoutParams layoutParams3 = new RawLayout.LayoutParams(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds62), 48);
                        if (i == 0 && TextUtils.isEmpty(bLauncher.getContentDescription())) {
                            z2 = true;
                        }
                        if (z2 && i == 1) {
                            layoutParams3.leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                        } else if (!z2 && i == 0) {
                            layoutParams3.leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                        } else {
                            layoutParams3.leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                        }
                        if (i == this.fmm.size() - 1) {
                            layoutParams3.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X007);
                        } else {
                            layoutParams3.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                        }
                        layoutParams3.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams3.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams3.weight = 1.0f;
                        z = z2;
                        layoutParams = layoutParams3;
                    } else if (this.fmr == 1) {
                        RawLayout.LayoutParams layoutParams4 = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds62), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds62), 48);
                        layoutParams4.leftMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                        if (i == this.fmm.size() - 1) {
                            layoutParams4.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009);
                        } else {
                            layoutParams4.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X009) + getResources().getDimensionPixelSize(R.dimen.M_W_X004);
                        }
                        layoutParams4.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        layoutParams4.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                        z = z2;
                        layoutParams = layoutParams4;
                    } else if (this.fmr == 5) {
                        RawLayout.LayoutParams layoutParams5 = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams5.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44);
                        layoutParams5.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds78);
                        layoutParams5.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams5.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        z = z2;
                        layoutParams = layoutParams5;
                    } else {
                        RawLayout.LayoutParams layoutParams6 = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams6.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        layoutParams6.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        layoutParams6.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        layoutParams6.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        z = z2;
                        layoutParams = layoutParams6;
                    }
                    layoutParams.rK(2);
                    addView(bLauncher, layoutParams);
                    z2 = z;
                }
            }
            kb(false);
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
                    if (this.fmr == 1 || this.fmr == 3 || this.fmr == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.fmr == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void kb(boolean z) {
        RawLayout.LayoutParams layoutParams;
        for (a aVar : this.fmn) {
            View view = (View) aVar.fmx;
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
                layoutParams.rK(2);
                addView(view, layoutParams);
            } else if (!z && aVar.position != 1) {
                switch (aVar.position) {
                    case 2:
                        layoutParams.rK(2);
                        break;
                    case 3:
                        layoutParams.rK(1);
                        break;
                    case 4:
                        layoutParams.rK(3);
                        break;
                    case 5:
                        layoutParams.rK(2);
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
        if (this.fmo == null) {
            this.fmo = new Paint();
            this.fmo.setStyle(Paint.Style.FILL);
        }
        this.fmo.setColor(ap.getColor(this.mSkinType, R.color.CAM_X0207));
        if (this.fmv) {
            if (this.fmu) {
                canvas.drawRect(0.0f, this.fni[0] - this.fmq, getMeasuredWidth(), this.fni[0], this.fmo);
            }
            if (this.fmt) {
                canvas.drawRect(0.0f, (this.fni[0] + this.fni[1]) - this.fmq, getMeasuredWidth(), this.fni[0] + this.fni[1], this.fmo);
            }
        }
        if (this.blw == null) {
            this.blw = new Paint();
            this.blw.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.blw.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.blw.setColor(ap.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.fmt && this.fmv) {
                i = (this.fni[0] + this.fni[1]) - this.fmq;
            } else {
                i = this.fni[0] + this.fni[1];
            }
            canvas.drawRect(0.0f, this.fni[0], getMeasuredWidth(), i, this.blw);
        }
        super.dispatchDraw(canvas);
    }

    public void kc(boolean z) {
        this.fmt = z;
    }

    public void kd(boolean z) {
        this.fmu = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.fmm.clear();
        this.fmn.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        if (this.fmr == 1) {
            if (mVar == null) {
                for (h hVar : this.fmm) {
                    if (hVar instanceof View) {
                        ((View) hVar).setSelected(false);
                    }
                }
                return;
            }
            for (h hVar2 : this.fmm) {
                if (hVar2 instanceof View) {
                    View view = (View) hVar2;
                    if (hVar2.getToolId() == mVar.id && mVar.fnp) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.fmr == 3 || this.fmr == 2 || this.fmr == 5) {
            if (mVar == null) {
                for (h hVar3 : this.fmm) {
                    if (hVar3 instanceof View) {
                        ((View) hVar3).setSelected(false);
                    }
                }
            } else if (mVar.id == 5 || mVar.id == 2 || mVar.id == 6) {
                for (h hVar4 : this.fmm) {
                    if (hVar4 instanceof View) {
                        View view2 = (View) hVar4;
                        if (hVar4.getToolId() == mVar.id && mVar.fnp) {
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
    public void rD(int i) {
        if (i == 2 && byO() && this.fms != null) {
            this.fms.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a rE = rE(i);
        if (rE != null) {
            if (rE.position == 5) {
                for (h hVar : this.fmm) {
                    if (hVar.getToolId() == 2 || hVar.getToolId() == 1) {
                        hVar.display();
                    } else {
                        hVar.hide();
                    }
                }
                for (a aVar : this.fmn) {
                    if (aVar.fmx != null) {
                        if (aVar.position == 5) {
                            aVar.fmx.display();
                        } else {
                            aVar.fmx.hide();
                        }
                    }
                }
            } else {
                for (h hVar2 : this.fmm) {
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
                for (a aVar2 : this.fmn) {
                    if (aVar2.fmx != null) {
                        if (aVar2.position == 5) {
                            aVar2.fmx.hide();
                        } else {
                            aVar2.fmx.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a rE(int i) {
        for (a aVar : this.fmn) {
            if (aVar.fmx != null && aVar.fmx.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean byO() {
        for (a aVar : this.fmn) {
            if (aVar.position == 5 && aVar.fmx != null && (aVar.fmx instanceof View) && ((View) aVar.fmx).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public h rF(int i) {
        for (h hVar : this.fmm) {
            if (hVar.getToolId() == i) {
                return hVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ap.setBackgroundColor(this, this.mBgColor);
        for (h hVar : this.fmm) {
            hVar.onChangeSkinType(i);
        }
        for (a aVar : this.fmn) {
            if (aVar.fmx != null) {
                aVar.fmx.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (h hVar : this.fmm) {
            if (hVar != null && (hVar instanceof View)) {
                ((View) hVar).setEnabled(z);
            }
        }
    }

    public boolean u(boolean z, int i) {
        for (h hVar : this.fmm) {
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
        this.fmr = i;
    }

    public int getBarLauncherType() {
        return this.fmr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean fmw;
        protected n fmx;
        protected int position;

        protected a(n nVar, int i, boolean z) {
            this.fmw = false;
            this.fmx = null;
            this.position = 0;
            this.fmx = nVar;
            this.position = i;
            this.fmw = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(View.OnClickListener onClickListener) {
        if (this.fmm != null && this.fmm.size() != 0) {
            Iterator<h> it = this.fmm.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View rG(int i) {
        for (h hVar : this.fmm) {
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
