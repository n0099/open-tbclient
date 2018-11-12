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
import com.baidu.tieba.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private int Ew;
    private List<g> aUA;
    private List<a> aUB;
    private Paint aUC;
    private Paint aUD;
    private int aUE;
    private int aUF;
    private EditorTools aUG;
    private boolean aUH;
    private boolean aUI;
    private boolean aUJ;
    private int mBgColor;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.aUF = 0;
        this.aUH = false;
        this.aUI = false;
        this.aUJ = true;
        this.aUG = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aUA = new LinkedList();
        this.aUB = new LinkedList();
        this.aUC = new Paint();
        this.aUD = new Paint();
        setPadding(getResources().getDimensionPixelSize(e.C0200e.ds20), 0, getResources().getDimensionPixelSize(e.C0200e.ds20), 0);
        this.aUC.setStyle(Paint.Style.FILL);
        this.aUD.setStyle(Paint.Style.FILL);
        this.aUE = getResources().getDimensionPixelSize(e.C0200e.ds1);
        this.Ew = ((com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0200e.ds64)) - (com.baidu.adp.lib.util.l.h(context, e.C0200e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aUA.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.aUA.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.aUB.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void KU() {
        RawLayout.a aVar;
        if (!v.I(this.aUA) || this.aUF == 4) {
            co(true);
            for (int i = 0; i < this.aUA.size(); i++) {
                g gVar = this.aUA.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.aUF == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds48), com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds21);
                    } else if (this.aUF == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(e.C0200e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aUF == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(e.C0200e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(e.C0200e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(e.C0200e.ds12);
                        }
                        if (i != this.aUA.size() - 1) {
                            aVar.rightMargin = this.Ew;
                        }
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0200e.ds15);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0200e.ds15);
                    } else {
                        aVar = new RawLayout.a(-2, -2, 80);
                        aVar.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0200e.ds7);
                        aVar.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0200e.ds7);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0200e.ds15);
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0200e.ds15);
                    }
                    aVar.fy(2);
                    addView(bLauncher, aVar);
                }
            }
            co(false);
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
                    if (this.aUF == 1 || this.aUF == 3 || this.aUF == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aUF == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void co(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.aUB) {
            View view = (View) aVar2.aUL;
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
                aVar.fy(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.fy(2);
                        break;
                    case 3:
                        aVar.fy(1);
                        break;
                    case 4:
                        aVar.fy(3);
                        break;
                    case 5:
                        aVar.fy(2);
                        view.setVisibility(8);
                        break;
                }
                if (((l) view).getToolId() == 8) {
                    al.i(this, e.d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(e.d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aUC == null) {
            this.aUC = new Paint();
            this.aUC.setStyle(Paint.Style.FILL);
        }
        this.aUC.setColor(al.getColor(this.mSkinType, e.d.cp_bg_line_c));
        if (this.aUJ) {
            if (this.aUI) {
                canvas.drawRect(0.0f, this.aVw[0] - this.aUE, getMeasuredWidth(), this.aVw[0], this.aUC);
            }
            if (this.aUH) {
                canvas.drawRect(0.0f, (this.aVw[0] + this.aVw[1]) - this.aUE, getMeasuredWidth(), this.aVw[0] + this.aVw[1], this.aUC);
            }
        }
        if (this.aUD == null) {
            this.aUD = new Paint();
            this.aUD.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.aUD.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.aUD.setColor(al.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.aUH && this.aUJ) {
                i = (this.aVw[0] + this.aVw[1]) - this.aUE;
            } else {
                i = this.aVw[0] + this.aVw[1];
            }
            canvas.drawRect(0.0f, this.aVw[0], getMeasuredWidth(), i, this.aUD);
        }
        super.dispatchDraw(canvas);
    }

    public void cp(boolean z) {
        this.aUH = z;
    }

    public void cq(boolean z) {
        this.aUI = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aUA.clear();
        this.aUB.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.aUF == 1) {
            if (kVar == null) {
                for (g gVar : this.aUA) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.aUA) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.aVz) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aUF == 3 || this.aUF == 2) {
            if (kVar == null) {
                for (g gVar3 : this.aUA) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.aUA) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.aVz) {
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
    public void fr(int i) {
        if (i == 2 && KV() && this.aUG != null) {
            this.aUG.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a fs = fs(i);
        if (fs != null) {
            if (fs.position == 5) {
                for (g gVar : this.aUA) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.pO();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.aUB) {
                    if (aVar.aUL != null) {
                        if (aVar.position == 5) {
                            aVar.aUL.pO();
                        } else {
                            aVar.aUL.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.aUA) {
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
                for (a aVar2 : this.aUB) {
                    if (aVar2.aUL != null) {
                        if (aVar2.position == 5) {
                            aVar2.aUL.hide();
                        } else {
                            aVar2.aUL.pO();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a fs(int i) {
        for (a aVar : this.aUB) {
            if (aVar.aUL != null && aVar.aUL.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean KV() {
        for (a aVar : this.aUB) {
            if (aVar.position == 5 && aVar.aUL != null && (aVar.aUL instanceof View) && ((View) aVar.aUL).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g ft(int i) {
        for (g gVar : this.aUA) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.j(this, this.mBgColor);
        for (g gVar : this.aUA) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.aUB) {
            if (aVar.aUL != null) {
                aVar.aUL.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.aUA) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.aUA) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aUF = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aUK;
        protected l aUL;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.aUK = false;
            this.aUL = null;
            this.position = 0;
            this.aUL = lVar;
            this.position = i;
            this.aUK = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View.OnClickListener onClickListener) {
        if (this.aUA != null && this.aUA.size() != 0) {
            Iterator<g> it = this.aUA.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View fu(int i) {
        for (g gVar : this.aUA) {
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
