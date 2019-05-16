package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private int Ce;
    private boolean cqA;
    private boolean cqB;
    private boolean cqC;
    private List<g> cqs;
    private List<a> cqt;
    private Paint cqu;
    private Paint cqv;
    private int cqw;
    private int cqx;
    private int cqy;
    private EditorTools cqz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.cqw = 0;
        this.cqy = 0;
        this.cqA = false;
        this.cqB = false;
        this.cqC = true;
        this.cqz = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.cqs = new LinkedList();
        this.cqt = new LinkedList();
        this.cqu = new Paint();
        this.cqv = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.cqu.setStyle(Paint.Style.FILL);
        this.cqv.setStyle(Paint.Style.FILL);
        this.cqx = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.Ce = ((com.baidu.adp.lib.util.l.af(context) - com.baidu.adp.lib.util.l.g(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.g(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cqs.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.cqs.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.cqt.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqT() {
        RawLayout.a aVar;
        if (!v.aa(this.cqs) || this.cqy == 4) {
            fc(true);
            for (int i = 0; i < this.cqs.size(); i++) {
                g gVar = this.cqs.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.cqy == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                    } else if (this.cqy == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.cqy == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.cqs.size() - 1) {
                            aVar.rightMargin = this.Ce;
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
                    aVar.kl(2);
                    addView(bLauncher, aVar);
                }
            }
            fc(false);
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
                    if (this.cqy == 1 || this.cqy == 3 || this.cqy == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.cqy == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void fc(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.cqt) {
            View view = (View) aVar2.cqE;
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
                aVar.kl(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.kl(2);
                        break;
                    case 3:
                        aVar.kl(1);
                        break;
                    case 4:
                        aVar.kl(3);
                        break;
                    case 5:
                        aVar.kl(2);
                        view.setVisibility(8);
                        break;
                }
                if (((l) view).getToolId() == 8) {
                    al.k(this, R.color.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.cqu == null) {
            this.cqu = new Paint();
            this.cqu.setStyle(Paint.Style.FILL);
        }
        this.cqu.setColor(al.getColor(this.mSkinType, R.color.cp_bg_line_c));
        if (this.cqC) {
            if (this.cqB) {
                canvas.drawRect(0.0f, this.crr[0] - this.cqx, getMeasuredWidth(), this.crr[0], this.cqu);
            }
            if (this.cqA) {
                canvas.drawRect(0.0f, (this.crr[0] + this.crr[1]) - this.cqx, getMeasuredWidth(), this.crr[0] + this.crr[1], this.cqu);
            }
        }
        if (this.cqv == null) {
            this.cqv = new Paint();
            this.cqv.setStyle(Paint.Style.FILL);
        }
        if (this.cqw > 0) {
            if (this.mSkinType == 0) {
                this.cqv.setColor(getContext().getResources().getColor(this.cqw));
            } else {
                this.cqv.setColor(al.getColor(this.mSkinType, this.cqw));
            }
            if (this.cqA && this.cqC) {
                i = (this.crr[0] + this.crr[1]) - this.cqx;
            } else {
                i = this.crr[0] + this.crr[1];
            }
            canvas.drawRect(0.0f, this.crr[0], getMeasuredWidth(), i, this.cqv);
        }
        super.dispatchDraw(canvas);
    }

    public void fd(boolean z) {
        this.cqA = z;
    }

    public void fe(boolean z) {
        this.cqB = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cqs.clear();
        this.cqt.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.cqy == 1) {
            if (kVar == null) {
                for (g gVar : this.cqs) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.cqs) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.cru) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.cqy == 3 || this.cqy == 2) {
            if (kVar == null) {
                for (g gVar3 : this.cqs) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.cqs) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.cru) {
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
    public void ke(int i) {
        if (i == 2 && aqU() && this.cqz != null) {
            this.cqz.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a kf = kf(i);
        if (kf != null) {
            if (kf.position == 5) {
                for (g gVar : this.cqs) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.pO();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.cqt) {
                    if (aVar.cqE != null) {
                        if (aVar.position == 5) {
                            aVar.cqE.pO();
                        } else {
                            aVar.cqE.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.cqs) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.pO();
                    }
                }
                for (a aVar2 : this.cqt) {
                    if (aVar2.cqE != null) {
                        if (aVar2.position == 5) {
                            aVar2.cqE.hide();
                        } else {
                            aVar2.cqE.pO();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a kf(int i) {
        for (a aVar : this.cqt) {
            if (aVar.cqE != null && aVar.cqE.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean aqU() {
        for (a aVar : this.cqt) {
            if (aVar.position == 5 && aVar.cqE != null && (aVar.cqE instanceof View) && ((View) aVar.cqE).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g kg(int i) {
        for (g gVar : this.cqs) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.l(this, this.cqw);
        for (g gVar : this.cqs) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.cqt) {
            if (aVar.cqE != null) {
                aVar.cqE.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.cqw = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.cqs) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.cqs) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.cqy = i;
    }

    public int getBarLauncherType() {
        return this.cqy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean cqD;
        protected l cqE;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.cqD = false;
            this.cqE = null;
            this.position = 0;
            this.cqE = lVar;
            this.position = i;
            this.cqD = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(View.OnClickListener onClickListener) {
        if (this.cqs != null && this.cqs.size() != 0) {
            Iterator<g> it = this.cqs.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View kh(int i) {
        for (g gVar : this.cqs) {
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
