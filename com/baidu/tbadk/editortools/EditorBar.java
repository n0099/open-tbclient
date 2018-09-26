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
    private int DJ;
    private List<g> aPi;
    private List<a> aPj;
    private Paint aPk;
    private Paint aPl;
    private int aPm;
    private int aPn;
    private int aPo;
    private EditorTools aPp;
    private boolean aPq;
    private boolean aPr;
    private boolean aPs;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.aPm = 0;
        this.aPo = 0;
        this.aPq = false;
        this.aPr = false;
        this.aPs = true;
        this.aPp = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aPi = new LinkedList();
        this.aPj = new LinkedList();
        this.aPk = new Paint();
        this.aPl = new Paint();
        setPadding(getResources().getDimensionPixelSize(e.C0141e.ds20), 0, getResources().getDimensionPixelSize(e.C0141e.ds20), 0);
        this.aPk.setStyle(Paint.Style.FILL);
        this.aPl.setStyle(Paint.Style.FILL);
        this.aPn = getResources().getDimensionPixelSize(e.C0141e.ds1);
        this.DJ = ((com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0141e.ds64)) - (com.baidu.adp.lib.util.l.h(context, e.C0141e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aPi.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.aPi.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.aPj.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void IK() {
        RawLayout.a aVar;
        if (!v.z(this.aPi) || this.aPo == 4) {
            bO(true);
            for (int i = 0; i < this.aPi.size(); i++) {
                g gVar = this.aPi.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.aPo == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds48), com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds21);
                    } else if (this.aPo == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(e.C0141e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aPo == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(e.C0141e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(e.C0141e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(e.C0141e.ds12);
                        }
                        if (i != this.aPi.size() - 1) {
                            aVar.rightMargin = this.DJ;
                        }
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0141e.ds15);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0141e.ds15);
                    } else {
                        aVar = new RawLayout.a(-2, -2, 80);
                        aVar.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0141e.ds7);
                        aVar.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0141e.ds7);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0141e.ds15);
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0141e.ds15);
                    }
                    aVar.fb(2);
                    addView(bLauncher, aVar);
                }
            }
            bO(false);
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
                    if (this.aPo == 1 || this.aPo == 3 || this.aPo == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aPo == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bO(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.aPj) {
            View view = (View) aVar2.aPu;
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
                aVar.fb(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.fb(2);
                        break;
                    case 3:
                        aVar.fb(1);
                        break;
                    case 4:
                        aVar.fb(3);
                        break;
                    case 5:
                        aVar.fb(2);
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
        if (this.aPk == null) {
            this.aPk = new Paint();
            this.aPk.setStyle(Paint.Style.FILL);
        }
        this.aPk.setColor(al.getColor(this.mSkinType, e.d.cp_bg_line_c));
        if (this.aPs) {
            if (this.aPr) {
                canvas.drawRect(0.0f, this.aQf[0] - this.aPn, getMeasuredWidth(), this.aQf[0], this.aPk);
            }
            if (this.aPq) {
                canvas.drawRect(0.0f, (this.aQf[0] + this.aQf[1]) - this.aPn, getMeasuredWidth(), this.aQf[0] + this.aQf[1], this.aPk);
            }
        }
        if (this.aPl == null) {
            this.aPl = new Paint();
            this.aPl.setStyle(Paint.Style.FILL);
        }
        if (this.aPm > 0) {
            if (this.mSkinType == 0) {
                this.aPl.setColor(getContext().getResources().getColor(this.aPm));
            } else {
                this.aPl.setColor(al.getColor(this.mSkinType, this.aPm));
            }
            if (this.aPq && this.aPs) {
                i = (this.aQf[0] + this.aQf[1]) - this.aPn;
            } else {
                i = this.aQf[0] + this.aQf[1];
            }
            canvas.drawRect(0.0f, this.aQf[0], getMeasuredWidth(), i, this.aPl);
        }
        super.dispatchDraw(canvas);
    }

    public void bP(boolean z) {
        this.aPq = z;
    }

    public void bQ(boolean z) {
        this.aPr = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aPi.clear();
        this.aPj.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.aPo == 1) {
            if (kVar == null) {
                for (g gVar : this.aPi) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.aPi) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.aQi) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aPo == 3 || this.aPo == 2) {
            if (kVar == null) {
                for (g gVar3 : this.aPi) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.aPi) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.aQi) {
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
    public void eU(int i) {
        if (i == 2 && IL() && this.aPp != null) {
            this.aPp.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eV = eV(i);
        if (eV != null) {
            if (eV.position == 5) {
                for (g gVar : this.aPi) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.pI();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.aPj) {
                    if (aVar.aPu != null) {
                        if (aVar.position == 5) {
                            aVar.aPu.pI();
                        } else {
                            aVar.aPu.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.aPi) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.pI();
                    }
                }
                for (a aVar2 : this.aPj) {
                    if (aVar2.aPu != null) {
                        if (aVar2.position == 5) {
                            aVar2.aPu.hide();
                        } else {
                            aVar2.aPu.pI();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eV(int i) {
        for (a aVar : this.aPj) {
            if (aVar.aPu != null && aVar.aPu.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean IL() {
        for (a aVar : this.aPj) {
            if (aVar.position == 5 && aVar.aPu != null && (aVar.aPu instanceof View) && ((View) aVar.aPu).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g eW(int i) {
        for (g gVar : this.aPi) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.j(this, this.aPm);
        for (g gVar : this.aPi) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.aPj) {
            if (aVar.aPu != null) {
                aVar.aPu.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aPm = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.aPi) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.aPi) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aPo = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aPt;
        protected l aPu;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.aPt = false;
            this.aPu = null;
            this.position = 0;
            this.aPu = lVar;
            this.position = i;
            this.aPt = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aPi != null && this.aPi.size() != 0) {
            Iterator<g> it = this.aPi.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View eX(int i) {
        for (g gVar : this.aPi) {
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
