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
    private Paint blN;
    private List<h> fhl;
    private List<a> fhm;
    private Paint fhn;
    private int fho;
    private int fhp;
    private EditorTools fhq;
    private boolean fhr;
    private boolean fhs;
    private boolean fht;
    private int mBgColor;
    private int mInterval;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.fhp = 0;
        this.fhr = false;
        this.fhs = false;
        this.fht = true;
        this.fhq = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.fhl = new LinkedList();
        this.fhm = new LinkedList();
        this.fhn = new Paint();
        this.blN = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.fhn.setStyle(Paint.Style.FILL);
        this.blN.setStyle(Paint.Style.FILL);
        this.fho = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mInterval = ((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.fhl.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, h hVar) {
        this.fhl.add(i, hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar, int i, boolean z) {
        this.fhm.add(new a(nVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        RawLayout.LayoutParams layoutParams;
        if (!y.isEmpty(this.fhl) || this.fhp == 4) {
            jR(true);
            for (int i = 0; i < this.fhl.size(); i++) {
                h hVar = this.fhl.get(i);
                if (hVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) hVar;
                    if (this.fhp == 2) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else if (this.fhp == 3) {
                        layoutParams = new RawLayout.LayoutParams(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.weight = 1.0f;
                    } else if (this.fhp == 1) {
                        layoutParams = new RawLayout.LayoutParams(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.fhl.size() - 1) {
                            layoutParams.rightMargin = this.mInterval;
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    } else if (this.fhp == 5) {
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
                    layoutParams.rc(2);
                    addView(bLauncher, layoutParams);
                }
            }
            jR(false);
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
                    if (this.fhp == 1 || this.fhp == 3 || this.fhp == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.fhp == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void jR(boolean z) {
        RawLayout.LayoutParams layoutParams;
        for (a aVar : this.fhm) {
            View view = (View) aVar.fhv;
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
                layoutParams.rc(2);
                addView(view, layoutParams);
            } else if (!z && aVar.position != 1) {
                switch (aVar.position) {
                    case 2:
                        layoutParams.rc(2);
                        break;
                    case 3:
                        layoutParams.rc(1);
                        break;
                    case 4:
                        layoutParams.rc(3);
                        break;
                    case 5:
                        layoutParams.rc(2);
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
        if (this.fhn == null) {
            this.fhn = new Paint();
            this.fhn.setStyle(Paint.Style.FILL);
        }
        this.fhn.setColor(ap.getColor(this.mSkinType, R.color.cp_bg_line_h));
        if (this.fht) {
            if (this.fhs) {
                canvas.drawRect(0.0f, this.fih[0] - this.fho, getMeasuredWidth(), this.fih[0], this.fhn);
            }
            if (this.fhr) {
                canvas.drawRect(0.0f, (this.fih[0] + this.fih[1]) - this.fho, getMeasuredWidth(), this.fih[0] + this.fih[1], this.fhn);
            }
        }
        if (this.blN == null) {
            this.blN = new Paint();
            this.blN.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.blN.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.blN.setColor(ap.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.fhr && this.fht) {
                i = (this.fih[0] + this.fih[1]) - this.fho;
            } else {
                i = this.fih[0] + this.fih[1];
            }
            canvas.drawRect(0.0f, this.fih[0], getMeasuredWidth(), i, this.blN);
        }
        super.dispatchDraw(canvas);
    }

    public void jS(boolean z) {
        this.fhr = z;
    }

    public void jT(boolean z) {
        this.fhs = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.fhl.clear();
        this.fhm.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        if (this.fhp == 1) {
            if (mVar == null) {
                for (h hVar : this.fhl) {
                    if (hVar instanceof View) {
                        ((View) hVar).setSelected(false);
                    }
                }
                return;
            }
            for (h hVar2 : this.fhl) {
                if (hVar2 instanceof View) {
                    View view = (View) hVar2;
                    if (hVar2.getToolId() == mVar.id && mVar.fio) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.fhp == 3 || this.fhp == 2 || this.fhp == 5) {
            if (mVar == null) {
                for (h hVar3 : this.fhl) {
                    if (hVar3 instanceof View) {
                        ((View) hVar3).setSelected(false);
                    }
                }
            } else if (mVar.id == 5 || mVar.id == 2 || mVar.id == 6) {
                for (h hVar4 : this.fhl) {
                    if (hVar4 instanceof View) {
                        View view2 = (View) hVar4;
                        if (hVar4.getToolId() == mVar.id && mVar.fio) {
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
    public void qV(int i) {
        if (i == 2 && bwZ() && this.fhq != null) {
            this.fhq.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a qW = qW(i);
        if (qW != null) {
            if (qW.position == 5) {
                for (h hVar : this.fhl) {
                    if (hVar.getToolId() == 2 || hVar.getToolId() == 1) {
                        hVar.display();
                    } else {
                        hVar.hide();
                    }
                }
                for (a aVar : this.fhm) {
                    if (aVar.fhv != null) {
                        if (aVar.position == 5) {
                            aVar.fhv.display();
                        } else {
                            aVar.fhv.hide();
                        }
                    }
                }
            } else {
                for (h hVar2 : this.fhl) {
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
                for (a aVar2 : this.fhm) {
                    if (aVar2.fhv != null) {
                        if (aVar2.position == 5) {
                            aVar2.fhv.hide();
                        } else {
                            aVar2.fhv.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a qW(int i) {
        for (a aVar : this.fhm) {
            if (aVar.fhv != null && aVar.fhv.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean bwZ() {
        for (a aVar : this.fhm) {
            if (aVar.position == 5 && aVar.fhv != null && (aVar.fhv instanceof View) && ((View) aVar.fhv).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public h qX(int i) {
        for (h hVar : this.fhl) {
            if (hVar.getToolId() == i) {
                return hVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ap.setBackgroundColor(this, this.mBgColor);
        for (h hVar : this.fhl) {
            hVar.onChangeSkinType(i);
        }
        for (a aVar : this.fhm) {
            if (aVar.fhv != null) {
                aVar.fhv.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (h hVar : this.fhl) {
            if (hVar != null && (hVar instanceof View)) {
                ((View) hVar).setEnabled(z);
            }
        }
    }

    public boolean u(boolean z, int i) {
        for (h hVar : this.fhl) {
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
        this.fhp = i;
    }

    public int getBarLauncherType() {
        return this.fhp;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean fhu;
        protected n fhv;
        protected int position;

        protected a(n nVar, int i, boolean z) {
            this.fhu = false;
            this.fhv = null;
            this.position = 0;
            this.fhv = nVar;
            this.position = i;
            this.fhu = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.fhl != null && this.fhl.size() != 0) {
            Iterator<h> it = this.fhl.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View qY(int i) {
        for (h hVar : this.fhl) {
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
