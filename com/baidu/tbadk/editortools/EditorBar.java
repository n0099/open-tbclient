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
    private List<g> cil;
    private List<a> cim;
    private Paint cin;
    private Paint cio;
    private int cip;
    private int ciq;
    private int cir;
    private EditorTools cis;
    private boolean cit;
    private boolean ciu;
    private boolean civ;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.cip = 0;
        this.cir = 0;
        this.cit = false;
        this.ciu = false;
        this.civ = true;
        this.cis = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.cil = new LinkedList();
        this.cim = new LinkedList();
        this.cin = new Paint();
        this.cio = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.cin.setStyle(Paint.Style.FILL);
        this.cio.setStyle(Paint.Style.FILL);
        this.ciq = getResources().getDimensionPixelSize(d.e.ds1);
        this.Ev = ((com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.h(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.cil.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.cil.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.cim.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alQ() {
        RawLayout.a aVar;
        if (!v.T(this.cil) || this.cir == 4) {
            eG(true);
            for (int i = 0; i < this.cil.size(); i++) {
                g gVar = this.cil.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.cir == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.h(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.h(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                    } else if (this.cir == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.cir == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.cil.size() - 1) {
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
                    if (this.cir == 1 || this.cir == 3 || this.cir == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.cir == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void eG(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.cim) {
            View view = (View) aVar2.cix;
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
        if (this.cin == null) {
            this.cin = new Paint();
            this.cin.setStyle(Paint.Style.FILL);
        }
        this.cin.setColor(al.getColor(this.mSkinType, d.C0277d.cp_bg_line_c));
        if (this.civ) {
            if (this.ciu) {
                canvas.drawRect(0.0f, this.cjj[0] - this.ciq, getMeasuredWidth(), this.cjj[0], this.cin);
            }
            if (this.cit) {
                canvas.drawRect(0.0f, (this.cjj[0] + this.cjj[1]) - this.ciq, getMeasuredWidth(), this.cjj[0] + this.cjj[1], this.cin);
            }
        }
        if (this.cio == null) {
            this.cio = new Paint();
            this.cio.setStyle(Paint.Style.FILL);
        }
        if (this.cip > 0) {
            if (this.mSkinType == 0) {
                this.cio.setColor(getContext().getResources().getColor(this.cip));
            } else {
                this.cio.setColor(al.getColor(this.mSkinType, this.cip));
            }
            if (this.cit && this.civ) {
                i = (this.cjj[0] + this.cjj[1]) - this.ciq;
            } else {
                i = this.cjj[0] + this.cjj[1];
            }
            canvas.drawRect(0.0f, this.cjj[0], getMeasuredWidth(), i, this.cio);
        }
        super.dispatchDraw(canvas);
    }

    public void eH(boolean z) {
        this.cit = z;
    }

    public void eI(boolean z) {
        this.ciu = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.cil.clear();
        this.cim.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.cir == 1) {
            if (kVar == null) {
                for (g gVar : this.cil) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.cil) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.cjm) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.cir == 3 || this.cir == 2) {
            if (kVar == null) {
                for (g gVar3 : this.cil) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.cil) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.cjm) {
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
        if (i == 2 && alR() && this.cis != null) {
            this.cis.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a jr = jr(i);
        if (jr != null) {
            if (jr.position == 5) {
                for (g gVar : this.cil) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.qT();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.cim) {
                    if (aVar.cix != null) {
                        if (aVar.position == 5) {
                            aVar.cix.qT();
                        } else {
                            aVar.cix.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.cil) {
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
                for (a aVar2 : this.cim) {
                    if (aVar2.cix != null) {
                        if (aVar2.position == 5) {
                            aVar2.cix.hide();
                        } else {
                            aVar2.cix.qT();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a jr(int i) {
        for (a aVar : this.cim) {
            if (aVar.cix != null && aVar.cix.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean alR() {
        for (a aVar : this.cim) {
            if (aVar.position == 5 && aVar.cix != null && (aVar.cix instanceof View) && ((View) aVar.cix).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g js(int i) {
        for (g gVar : this.cil) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.l(this, this.cip);
        for (g gVar : this.cil) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.cim) {
            if (aVar.cix != null) {
                aVar.cix.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.cip = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.cil) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.cil) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.cir = i;
    }

    public int getBarLauncherType() {
        return this.cir;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean ciw;
        protected l cix;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.ciw = false;
            this.cix = null;
            this.position = 0;
            this.cix = lVar;
            this.position = i;
            this.ciw = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(View.OnClickListener onClickListener) {
        if (this.cil != null && this.cil.size() != 0) {
            Iterator<g> it = this.cil.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View jt(int i) {
        for (g gVar : this.cil) {
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
