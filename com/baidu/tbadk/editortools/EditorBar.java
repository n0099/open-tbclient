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
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private int Ev;
    private List<g> cii;
    private List<a> cij;
    private Paint cik;
    private Paint cil;
    private int cim;
    private int cin;
    private int cio;
    private EditorTools cip;
    private boolean ciq;
    private boolean cir;
    private boolean cis;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.cim = 0;
        this.cio = 0;
        this.ciq = false;
        this.cir = false;
        this.cis = true;
        this.cip = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.cii = new LinkedList();
        this.cij = new LinkedList();
        this.cik = new Paint();
        this.cil = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.cik.setStyle(Paint.Style.FILL);
        this.cil.setStyle(Paint.Style.FILL);
        this.cin = getResources().getDimensionPixelSize(d.e.ds1);
        this.Ev = ((com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.h(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cii.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.cii.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.cij.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alT() {
        RawLayout.a aVar;
        if (!v.T(this.cii) || this.cio == 4) {
            eG(true);
            for (int i = 0; i < this.cii.size(); i++) {
                g gVar = this.cii.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.cio == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.h(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.h(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                    } else if (this.cio == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.cio == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.cii.size() - 1) {
                            aVar.rightMargin = this.Ev;
                        }
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds15);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds15);
                    } else {
                        aVar = new RawLayout.a(-2, -2, 80);
                        aVar.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds7);
                        aVar.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds7);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds15);
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds15);
                    }
                    aVar.jy(2);
                    addView(bLauncher, aVar);
                }
            }
            eG(false);
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
                    if (this.cio == 1 || this.cio == 3 || this.cio == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.cio == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void eG(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.cij) {
            View view = (View) aVar2.ciu;
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
                aVar.jy(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.jy(2);
                        break;
                    case 3:
                        aVar.jy(1);
                        break;
                    case 4:
                        aVar.jy(3);
                        break;
                    case 5:
                        aVar.jy(2);
                        view.setVisibility(8);
                        break;
                }
                if (((l) view).getToolId() == 8) {
                    al.k(this, d.C0277d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0277d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.cik == null) {
            this.cik = new Paint();
            this.cik.setStyle(Paint.Style.FILL);
        }
        this.cik.setColor(al.getColor(this.mSkinType, d.C0277d.cp_bg_line_c));
        if (this.cis) {
            if (this.cir) {
                canvas.drawRect(0.0f, this.cjg[0] - this.cin, getMeasuredWidth(), this.cjg[0], this.cik);
            }
            if (this.ciq) {
                canvas.drawRect(0.0f, (this.cjg[0] + this.cjg[1]) - this.cin, getMeasuredWidth(), this.cjg[0] + this.cjg[1], this.cik);
            }
        }
        if (this.cil == null) {
            this.cil = new Paint();
            this.cil.setStyle(Paint.Style.FILL);
        }
        if (this.cim > 0) {
            if (this.mSkinType == 0) {
                this.cil.setColor(getContext().getResources().getColor(this.cim));
            } else {
                this.cil.setColor(al.getColor(this.mSkinType, this.cim));
            }
            if (this.ciq && this.cis) {
                i = (this.cjg[0] + this.cjg[1]) - this.cin;
            } else {
                i = this.cjg[0] + this.cjg[1];
            }
            canvas.drawRect(0.0f, this.cjg[0], getMeasuredWidth(), i, this.cil);
        }
        super.dispatchDraw(canvas);
    }

    public void eH(boolean z) {
        this.ciq = z;
    }

    public void eI(boolean z) {
        this.cir = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cii.clear();
        this.cij.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.cio == 1) {
            if (kVar == null) {
                for (g gVar : this.cii) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.cii) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.cjj) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.cio == 3 || this.cio == 2) {
            if (kVar == null) {
                for (g gVar3 : this.cii) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.cii) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.cjj) {
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
    public void jr(int i) {
        if (i == 2 && alU() && this.cip != null) {
            this.cip.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a js = js(i);
        if (js != null) {
            if (js.position == 5) {
                for (g gVar : this.cii) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.qT();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.cij) {
                    if (aVar.ciu != null) {
                        if (aVar.position == 5) {
                            aVar.ciu.qT();
                        } else {
                            aVar.ciu.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.cii) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.qT();
                    }
                }
                for (a aVar2 : this.cij) {
                    if (aVar2.ciu != null) {
                        if (aVar2.position == 5) {
                            aVar2.ciu.hide();
                        } else {
                            aVar2.ciu.qT();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a js(int i) {
        for (a aVar : this.cij) {
            if (aVar.ciu != null && aVar.ciu.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean alU() {
        for (a aVar : this.cij) {
            if (aVar.position == 5 && aVar.ciu != null && (aVar.ciu instanceof View) && ((View) aVar.ciu).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g jt(int i) {
        for (g gVar : this.cii) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.l(this, this.cim);
        for (g gVar : this.cii) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.cij) {
            if (aVar.ciu != null) {
                aVar.ciu.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.cim = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.cii) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.cii) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.cio = i;
    }

    public int getBarLauncherType() {
        return this.cio;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean cit;
        protected l ciu;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.cit = false;
            this.ciu = null;
            this.position = 0;
            this.ciu = lVar;
            this.position = i;
            this.cit = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(View.OnClickListener onClickListener) {
        if (this.cii != null && this.cii.size() != 0) {
            Iterator<g> it = this.cii.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View ju(int i) {
        for (g gVar : this.cii) {
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
