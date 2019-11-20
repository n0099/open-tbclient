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
    private Paint aiV;
    private List<g> cEc;
    private List<a> cEd;
    private Paint cEe;
    private int cEf;
    private int cEg;
    private int cEh;
    private EditorTools cEi;
    private boolean cEj;
    private boolean cEk;
    private boolean cEl;
    private int mInterval;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.cEf = 0;
        this.cEh = 0;
        this.cEj = false;
        this.cEk = false;
        this.cEl = true;
        this.cEi = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.cEc = new LinkedList();
        this.cEd = new LinkedList();
        this.cEe = new Paint();
        this.aiV = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.cEe.setStyle(Paint.Style.FILL);
        this.aiV.setStyle(Paint.Style.FILL);
        this.cEg = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mInterval = ((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cEc.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.cEc.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.cEd.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        RawLayout.a aVar;
        if (!v.isEmpty(this.cEc) || this.cEh == 4) {
            fd(true);
            for (int i = 0; i < this.cEc.size(); i++) {
                g gVar = this.cEc.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.cEh == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else if (this.cEh == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.cEh == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.cEc.size() - 1) {
                            aVar.rightMargin = this.mInterval;
                        }
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    } else {
                        aVar = new RawLayout.a(-2, -2, 80);
                        aVar.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        aVar.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    }
                    aVar.jM(2);
                    addView(bLauncher, aVar);
                }
            }
            fd(false);
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
                    if (this.cEh == 1 || this.cEh == 3 || this.cEh == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.cEh == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void fd(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.cEd) {
            View view = (View) aVar2.cEn;
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
                aVar.jM(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.jM(2);
                        break;
                    case 3:
                        aVar.jM(1);
                        break;
                    case 4:
                        aVar.jM(3);
                        break;
                    case 5:
                        aVar.jM(2);
                        view.setVisibility(8);
                        break;
                }
                if (((l) view).getToolId() == 8) {
                    am.setBackgroundResource(this, R.color.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.cEe == null) {
            this.cEe = new Paint();
            this.cEe.setStyle(Paint.Style.FILL);
        }
        this.cEe.setColor(am.getColor(this.mSkinType, R.color.cp_bg_line_h));
        if (this.cEl) {
            if (this.cEk) {
                canvas.drawRect(0.0f, this.cEY[0] - this.cEg, getMeasuredWidth(), this.cEY[0], this.cEe);
            }
            if (this.cEj) {
                canvas.drawRect(0.0f, (this.cEY[0] + this.cEY[1]) - this.cEg, getMeasuredWidth(), this.cEY[0] + this.cEY[1], this.cEe);
            }
        }
        if (this.aiV == null) {
            this.aiV = new Paint();
            this.aiV.setStyle(Paint.Style.FILL);
        }
        if (this.cEf > 0) {
            if (this.mSkinType == 0) {
                this.aiV.setColor(getContext().getResources().getColor(this.cEf));
            } else {
                this.aiV.setColor(am.getColor(this.mSkinType, this.cEf));
            }
            if (this.cEj && this.cEl) {
                i = (this.cEY[0] + this.cEY[1]) - this.cEg;
            } else {
                i = this.cEY[0] + this.cEY[1];
            }
            canvas.drawRect(0.0f, this.cEY[0], getMeasuredWidth(), i, this.aiV);
        }
        super.dispatchDraw(canvas);
    }

    public void fe(boolean z) {
        this.cEj = z;
    }

    public void ff(boolean z) {
        this.cEk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cEc.clear();
        this.cEd.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.cEh == 1) {
            if (kVar == null) {
                for (g gVar : this.cEc) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.cEc) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.cFd) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.cEh == 3 || this.cEh == 2) {
            if (kVar == null) {
                for (g gVar3 : this.cEc) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.cEc) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.cFd) {
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
    public void jF(int i) {
        if (i == 2 && atY() && this.cEi != null) {
            this.cEi.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a jG = jG(i);
        if (jG != null) {
            if (jG.position == 5) {
                for (g gVar : this.cEc) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.le();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.cEd) {
                    if (aVar.cEn != null) {
                        if (aVar.position == 5) {
                            aVar.cEn.le();
                        } else {
                            aVar.cEn.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.cEc) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.le();
                    }
                }
                for (a aVar2 : this.cEd) {
                    if (aVar2.cEn != null) {
                        if (aVar2.position == 5) {
                            aVar2.cEn.hide();
                        } else {
                            aVar2.cEn.le();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a jG(int i) {
        for (a aVar : this.cEd) {
            if (aVar.cEn != null && aVar.cEn.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean atY() {
        for (a aVar : this.cEd) {
            if (aVar.position == 5 && aVar.cEn != null && (aVar.cEn instanceof View) && ((View) aVar.cEn).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g jH(int i) {
        for (g gVar : this.cEc) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        am.setBackgroundColor(this, this.cEf);
        for (g gVar : this.cEc) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.cEd) {
            if (aVar.cEn != null) {
                aVar.cEn.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.cEf = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.cEc) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.cEc) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.cEh = i;
    }

    public int getBarLauncherType() {
        return this.cEh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean cEm;
        protected l cEn;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.cEm = false;
            this.cEn = null;
            this.position = 0;
            this.cEn = lVar;
            this.position = i;
            this.cEm = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(View.OnClickListener onClickListener) {
        if (this.cEc != null && this.cEc.size() != 0) {
            Iterator<g> it = this.cEc.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View jI(int i) {
        for (g gVar : this.cEc) {
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
