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
    private Paint arF;
    private List<g> dsi;
    private List<a> dsj;
    private Paint dsk;
    private int dsl;
    private int dsm;
    private EditorTools dsn;
    private boolean dso;
    private boolean dsp;
    private boolean dsq;
    private int mBgColor;
    private int mInterval;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.dsm = 0;
        this.dso = false;
        this.dsp = false;
        this.dsq = true;
        this.dsn = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.dsi = new LinkedList();
        this.dsj = new LinkedList();
        this.dsk = new Paint();
        this.arF = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.dsk.setStyle(Paint.Style.FILL);
        this.arF.setStyle(Paint.Style.FILL);
        this.dsl = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mInterval = ((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.dsi.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.dsi.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar, int i, boolean z) {
        this.dsj.add(new a(mVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        RawLayout.LayoutParams layoutParams;
        if (!v.isEmpty(this.dsi) || this.dsm == 4) {
            gt(true);
            for (int i = 0; i < this.dsi.size(); i++) {
                g gVar = this.dsi.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.dsm == 2) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else if (this.dsm == 3) {
                        layoutParams = new RawLayout.LayoutParams(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.weight = 1.0f;
                    } else if (this.dsm == 1) {
                        layoutParams = new RawLayout.LayoutParams(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.dsi.size() - 1) {
                            layoutParams.rightMargin = this.mInterval;
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    } else if (this.dsm == 5) {
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
                    layoutParams.lZ(2);
                    addView(bLauncher, layoutParams);
                }
            }
            gt(false);
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
                    if (this.dsm == 1 || this.dsm == 3 || this.dsm == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.dsm == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void gt(boolean z) {
        RawLayout.LayoutParams layoutParams;
        for (a aVar : this.dsj) {
            View view = (View) aVar.dss;
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
                layoutParams.lZ(2);
                addView(view, layoutParams);
            } else if (!z && aVar.position != 1) {
                switch (aVar.position) {
                    case 2:
                        layoutParams.lZ(2);
                        break;
                    case 3:
                        layoutParams.lZ(1);
                        break;
                    case 4:
                        layoutParams.lZ(3);
                        break;
                    case 5:
                        layoutParams.lZ(2);
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
        if (this.dsk == null) {
            this.dsk = new Paint();
            this.dsk.setStyle(Paint.Style.FILL);
        }
        this.dsk.setColor(am.getColor(this.mSkinType, R.color.cp_bg_line_h));
        if (this.dsq) {
            if (this.dsp) {
                canvas.drawRect(0.0f, this.dtd[0] - this.dsl, getMeasuredWidth(), this.dtd[0], this.dsk);
            }
            if (this.dso) {
                canvas.drawRect(0.0f, (this.dtd[0] + this.dtd[1]) - this.dsl, getMeasuredWidth(), this.dtd[0] + this.dtd[1], this.dsk);
            }
        }
        if (this.arF == null) {
            this.arF = new Paint();
            this.arF.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.arF.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.arF.setColor(am.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.dso && this.dsq) {
                i = (this.dtd[0] + this.dtd[1]) - this.dsl;
            } else {
                i = this.dtd[0] + this.dtd[1];
            }
            canvas.drawRect(0.0f, this.dtd[0], getMeasuredWidth(), i, this.arF);
        }
        super.dispatchDraw(canvas);
    }

    public void gu(boolean z) {
        this.dso = z;
    }

    public void gv(boolean z) {
        this.dsp = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.dsi.clear();
        this.dsj.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar) {
        if (this.dsm == 1) {
            if (lVar == null) {
                for (g gVar : this.dsi) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.dsi) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == lVar.id && lVar.dti) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.dsm == 3 || this.dsm == 2 || this.dsm == 5) {
            if (lVar == null) {
                for (g gVar3 : this.dsi) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (lVar.id == 5 || lVar.id == 2 || lVar.id == 6) {
                for (g gVar4 : this.dsi) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == lVar.id && lVar.dti) {
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
    public void lS(int i) {
        if (i == 2 && aLW() && this.dsn != null) {
            this.dsn.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a lT = lT(i);
        if (lT != null) {
            if (lT.position == 5) {
                for (g gVar : this.dsi) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.display();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.dsj) {
                    if (aVar.dss != null) {
                        if (aVar.position == 5) {
                            aVar.dss.display();
                        } else {
                            aVar.dss.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.dsi) {
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
                for (a aVar2 : this.dsj) {
                    if (aVar2.dss != null) {
                        if (aVar2.position == 5) {
                            aVar2.dss.hide();
                        } else {
                            aVar2.dss.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a lT(int i) {
        for (a aVar : this.dsj) {
            if (aVar.dss != null && aVar.dss.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean aLW() {
        for (a aVar : this.dsj) {
            if (aVar.position == 5 && aVar.dss != null && (aVar.dss instanceof View) && ((View) aVar.dss).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g lU(int i) {
        for (g gVar : this.dsi) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        am.setBackgroundColor(this, this.mBgColor);
        for (g gVar : this.dsi) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.dsj) {
            if (aVar.dss != null) {
                aVar.dss.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.dsi) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.dsi) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.dsm = i;
    }

    public int getBarLauncherType() {
        return this.dsm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean dsr;
        protected m dss;
        protected int position;

        protected a(m mVar, int i, boolean z) {
            this.dsr = false;
            this.dss = null;
            this.position = 0;
            this.dss = mVar;
            this.position = i;
            this.dsr = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.dsi != null && this.dsi.size() != 0) {
            Iterator<g> it = this.dsi.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View lV(int i) {
        for (g gVar : this.dsi) {
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
