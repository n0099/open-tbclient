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
    private List<g> cik;
    private List<a> cil;
    private Paint cim;
    private Paint cin;
    private int cio;
    private int cip;
    private int ciq;
    private EditorTools cir;
    private boolean cis;
    private boolean cit;
    private boolean ciu;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.cio = 0;
        this.ciq = 0;
        this.cis = false;
        this.cit = false;
        this.ciu = true;
        this.cir = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.cik = new LinkedList();
        this.cil = new LinkedList();
        this.cim = new Paint();
        this.cin = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.cim.setStyle(Paint.Style.FILL);
        this.cin.setStyle(Paint.Style.FILL);
        this.cip = getResources().getDimensionPixelSize(d.e.ds1);
        this.Ev = ((com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.h(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cik.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.cik.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.cil.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alQ() {
        RawLayout.a aVar;
        if (!v.T(this.cik) || this.ciq == 4) {
            eG(true);
            for (int i = 0; i < this.cik.size(); i++) {
                g gVar = this.cik.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.ciq == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.h(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.h(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                    } else if (this.ciq == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.ciq == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.cik.size() - 1) {
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
                    aVar.jx(2);
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
                    if (this.ciq == 1 || this.ciq == 3 || this.ciq == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.ciq == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void eG(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.cil) {
            View view = (View) aVar2.ciw;
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
                aVar.jx(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.jx(2);
                        break;
                    case 3:
                        aVar.jx(1);
                        break;
                    case 4:
                        aVar.jx(3);
                        break;
                    case 5:
                        aVar.jx(2);
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
        if (this.cim == null) {
            this.cim = new Paint();
            this.cim.setStyle(Paint.Style.FILL);
        }
        this.cim.setColor(al.getColor(this.mSkinType, d.C0277d.cp_bg_line_c));
        if (this.ciu) {
            if (this.cit) {
                canvas.drawRect(0.0f, this.cji[0] - this.cip, getMeasuredWidth(), this.cji[0], this.cim);
            }
            if (this.cis) {
                canvas.drawRect(0.0f, (this.cji[0] + this.cji[1]) - this.cip, getMeasuredWidth(), this.cji[0] + this.cji[1], this.cim);
            }
        }
        if (this.cin == null) {
            this.cin = new Paint();
            this.cin.setStyle(Paint.Style.FILL);
        }
        if (this.cio > 0) {
            if (this.mSkinType == 0) {
                this.cin.setColor(getContext().getResources().getColor(this.cio));
            } else {
                this.cin.setColor(al.getColor(this.mSkinType, this.cio));
            }
            if (this.cis && this.ciu) {
                i = (this.cji[0] + this.cji[1]) - this.cip;
            } else {
                i = this.cji[0] + this.cji[1];
            }
            canvas.drawRect(0.0f, this.cji[0], getMeasuredWidth(), i, this.cin);
        }
        super.dispatchDraw(canvas);
    }

    public void eH(boolean z) {
        this.cis = z;
    }

    public void eI(boolean z) {
        this.cit = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cik.clear();
        this.cil.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.ciq == 1) {
            if (kVar == null) {
                for (g gVar : this.cik) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.cik) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.cjl) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.ciq == 3 || this.ciq == 2) {
            if (kVar == null) {
                for (g gVar3 : this.cik) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.cik) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.cjl) {
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
    public void jq(int i) {
        if (i == 2 && alR() && this.cir != null) {
            this.cir.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a jr = jr(i);
        if (jr != null) {
            if (jr.position == 5) {
                for (g gVar : this.cik) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.qT();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.cil) {
                    if (aVar.ciw != null) {
                        if (aVar.position == 5) {
                            aVar.ciw.qT();
                        } else {
                            aVar.ciw.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.cik) {
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
                for (a aVar2 : this.cil) {
                    if (aVar2.ciw != null) {
                        if (aVar2.position == 5) {
                            aVar2.ciw.hide();
                        } else {
                            aVar2.ciw.qT();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a jr(int i) {
        for (a aVar : this.cil) {
            if (aVar.ciw != null && aVar.ciw.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean alR() {
        for (a aVar : this.cil) {
            if (aVar.position == 5 && aVar.ciw != null && (aVar.ciw instanceof View) && ((View) aVar.ciw).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g js(int i) {
        for (g gVar : this.cik) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.l(this, this.cio);
        for (g gVar : this.cik) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.cil) {
            if (aVar.ciw != null) {
                aVar.ciw.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.cio = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.cik) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.cik) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.ciq = i;
    }

    public int getBarLauncherType() {
        return this.ciq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean civ;
        protected l ciw;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.civ = false;
            this.ciw = null;
            this.position = 0;
            this.ciw = lVar;
            this.position = i;
            this.civ = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(View.OnClickListener onClickListener) {
        if (this.cik != null && this.cik.size() != 0) {
            Iterator<g> it = this.cik.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View jt(int i) {
        for (g gVar : this.cik) {
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
