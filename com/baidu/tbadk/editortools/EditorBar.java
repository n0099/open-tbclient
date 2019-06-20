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
    private int Cd;
    private EditorTools cqA;
    private boolean cqB;
    private boolean cqC;
    private boolean cqD;
    private List<g> cqt;
    private List<a> cqu;
    private Paint cqv;
    private Paint cqw;
    private int cqx;
    private int cqy;
    private int cqz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.cqx = 0;
        this.cqz = 0;
        this.cqB = false;
        this.cqC = false;
        this.cqD = true;
        this.cqA = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.cqt = new LinkedList();
        this.cqu = new LinkedList();
        this.cqv = new Paint();
        this.cqw = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.cqv.setStyle(Paint.Style.FILL);
        this.cqw.setStyle(Paint.Style.FILL);
        this.cqy = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.Cd = ((com.baidu.adp.lib.util.l.af(context) - com.baidu.adp.lib.util.l.g(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.g(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cqt.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.cqt.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.cqu.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqT() {
        RawLayout.a aVar;
        if (!v.aa(this.cqt) || this.cqz == 4) {
            fc(true);
            for (int i = 0; i < this.cqt.size(); i++) {
                g gVar = this.cqt.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.cqz == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                    } else if (this.cqz == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.cqz == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.cqt.size() - 1) {
                            aVar.rightMargin = this.Cd;
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
                    if (this.cqz == 1 || this.cqz == 3 || this.cqz == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.cqz == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void fc(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.cqu) {
            View view = (View) aVar2.cqF;
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
        if (this.cqv == null) {
            this.cqv = new Paint();
            this.cqv.setStyle(Paint.Style.FILL);
        }
        this.cqv.setColor(al.getColor(this.mSkinType, R.color.cp_bg_line_c));
        if (this.cqD) {
            if (this.cqC) {
                canvas.drawRect(0.0f, this.crs[0] - this.cqy, getMeasuredWidth(), this.crs[0], this.cqv);
            }
            if (this.cqB) {
                canvas.drawRect(0.0f, (this.crs[0] + this.crs[1]) - this.cqy, getMeasuredWidth(), this.crs[0] + this.crs[1], this.cqv);
            }
        }
        if (this.cqw == null) {
            this.cqw = new Paint();
            this.cqw.setStyle(Paint.Style.FILL);
        }
        if (this.cqx > 0) {
            if (this.mSkinType == 0) {
                this.cqw.setColor(getContext().getResources().getColor(this.cqx));
            } else {
                this.cqw.setColor(al.getColor(this.mSkinType, this.cqx));
            }
            if (this.cqB && this.cqD) {
                i = (this.crs[0] + this.crs[1]) - this.cqy;
            } else {
                i = this.crs[0] + this.crs[1];
            }
            canvas.drawRect(0.0f, this.crs[0], getMeasuredWidth(), i, this.cqw);
        }
        super.dispatchDraw(canvas);
    }

    public void fd(boolean z) {
        this.cqB = z;
    }

    public void fe(boolean z) {
        this.cqC = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cqt.clear();
        this.cqu.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.cqz == 1) {
            if (kVar == null) {
                for (g gVar : this.cqt) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.cqt) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.crv) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.cqz == 3 || this.cqz == 2) {
            if (kVar == null) {
                for (g gVar3 : this.cqt) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.cqt) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.crv) {
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
        if (i == 2 && aqU() && this.cqA != null) {
            this.cqA.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a kf = kf(i);
        if (kf != null) {
            if (kf.position == 5) {
                for (g gVar : this.cqt) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.pO();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.cqu) {
                    if (aVar.cqF != null) {
                        if (aVar.position == 5) {
                            aVar.cqF.pO();
                        } else {
                            aVar.cqF.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.cqt) {
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
                for (a aVar2 : this.cqu) {
                    if (aVar2.cqF != null) {
                        if (aVar2.position == 5) {
                            aVar2.cqF.hide();
                        } else {
                            aVar2.cqF.pO();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a kf(int i) {
        for (a aVar : this.cqu) {
            if (aVar.cqF != null && aVar.cqF.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean aqU() {
        for (a aVar : this.cqu) {
            if (aVar.position == 5 && aVar.cqF != null && (aVar.cqF instanceof View) && ((View) aVar.cqF).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g kg(int i) {
        for (g gVar : this.cqt) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.l(this, this.cqx);
        for (g gVar : this.cqt) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.cqu) {
            if (aVar.cqF != null) {
                aVar.cqF.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.cqx = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.cqt) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.cqt) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.cqz = i;
    }

    public int getBarLauncherType() {
        return this.cqz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean cqE;
        protected l cqF;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.cqE = false;
            this.cqF = null;
            this.position = 0;
            this.cqF = lVar;
            this.position = i;
            this.cqE = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(View.OnClickListener onClickListener) {
        if (this.cqt != null && this.cqt.size() != 0) {
            Iterator<g> it = this.cqt.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View kh(int i) {
        for (g gVar : this.cqt) {
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
