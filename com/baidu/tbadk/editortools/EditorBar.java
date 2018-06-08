package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private int Br;
    private List<g> aKY;
    private List<a> aKZ;
    private Paint aLa;
    private Paint aLb;
    private int aLc;
    private int aLd;
    private EditorTools aLe;
    private boolean aLf;
    private boolean aLg;
    private boolean aLh;
    private int mBgColor;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.aLd = 0;
        this.aLf = false;
        this.aLg = false;
        this.aLh = true;
        this.aLe = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aKY = new LinkedList();
        this.aKZ = new LinkedList();
        this.aLa = new Paint();
        this.aLb = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.aLa.setStyle(Paint.Style.FILL);
        this.aLb.setStyle(Paint.Style.FILL);
        this.aLc = getResources().getDimensionPixelSize(d.e.ds1);
        this.Br = ((com.baidu.adp.lib.util.l.ah(context) - com.baidu.adp.lib.util.l.e(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.e(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aKY.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.aKY.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.aKZ.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hh() {
        RawLayout.a aVar;
        if (!w.z(this.aKY) || this.aLd == 4) {
            bA(true);
            for (int i = 0; i < this.aKY.size(); i++) {
                g gVar = this.aKY.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.aLd == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.e(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.e(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                    } else if (this.aLd == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aLd == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.aKY.size() - 1) {
                            aVar.rightMargin = this.Br;
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
                    aVar.eO(2);
                    addView(bLauncher, aVar);
                }
            }
            bA(false);
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
                    if (this.aLd == 1 || this.aLd == 3 || this.aLd == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aLd == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bA(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.aKZ) {
            View view = (View) aVar2.aLj;
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
                aVar.eO(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eO(2);
                        break;
                    case 3:
                        aVar.eO(1);
                        break;
                    case 4:
                        aVar.eO(3);
                        break;
                    case 5:
                        aVar.eO(2);
                        view.setVisibility(8);
                        break;
                }
                if (((l) view).getToolId() == 8) {
                    al.i(this, d.C0141d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0141d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aLa == null) {
            this.aLa = new Paint();
            this.aLa.setStyle(Paint.Style.FILL);
        }
        this.aLa.setColor(al.getColor(this.mSkinType, d.C0141d.cp_bg_line_c));
        if (this.aLh) {
            if (this.aLg) {
                canvas.drawRect(0.0f, this.aLU[0] - this.aLc, getMeasuredWidth(), this.aLU[0], this.aLa);
            }
            if (this.aLf) {
                canvas.drawRect(0.0f, (this.aLU[0] + this.aLU[1]) - this.aLc, getMeasuredWidth(), this.aLU[0] + this.aLU[1], this.aLa);
            }
        }
        if (this.aLb == null) {
            this.aLb = new Paint();
            this.aLb.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.aLb.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.aLb.setColor(al.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.aLf && this.aLh) {
                i = (this.aLU[0] + this.aLU[1]) - this.aLc;
            } else {
                i = this.aLU[0] + this.aLU[1];
            }
            canvas.drawRect(0.0f, this.aLU[0], getMeasuredWidth(), i, this.aLb);
        }
        super.dispatchDraw(canvas);
    }

    public void bB(boolean z) {
        this.aLf = z;
    }

    public void bC(boolean z) {
        this.aLg = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aKY.clear();
        this.aKZ.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.aLd == 1) {
            if (kVar == null) {
                for (g gVar : this.aKY) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.aKY) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.aLX) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aLd == 3 || this.aLd == 2) {
            if (kVar == null) {
                for (g gVar3 : this.aKY) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.aKY) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.aLX) {
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
    public void eH(int i) {
        if (i == 2 && Hi() && this.aLe != null) {
            this.aLe.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eI = eI(i);
        if (eI != null) {
            if (eI.position == 5) {
                for (g gVar : this.aKY) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.oD();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.aKZ) {
                    if (aVar.aLj != null) {
                        if (aVar.position == 5) {
                            aVar.aLj.oD();
                        } else {
                            aVar.aLj.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.aKY) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.oD();
                    }
                }
                for (a aVar2 : this.aKZ) {
                    if (aVar2.aLj != null) {
                        if (aVar2.position == 5) {
                            aVar2.aLj.hide();
                        } else {
                            aVar2.aLj.oD();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eI(int i) {
        for (a aVar : this.aKZ) {
            if (aVar.aLj != null && aVar.aLj.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Hi() {
        for (a aVar : this.aKZ) {
            if (aVar.position == 5 && aVar.aLj != null && (aVar.aLj instanceof View) && ((View) aVar.aLj).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g eJ(int i) {
        for (g gVar : this.aKY) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.j(this, this.mBgColor);
        for (g gVar : this.aKY) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.aKZ) {
            if (aVar.aLj != null) {
                aVar.aLj.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.aKY) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.aKY) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aLd = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aLi;
        protected l aLj;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.aLi = false;
            this.aLj = null;
            this.position = 0;
            this.aLj = lVar;
            this.position = i;
            this.aLi = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aKY != null && this.aKY.size() != 0) {
            Iterator<g> it = this.aKY.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View eK(int i) {
        for (g gVar : this.aKY) {
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
