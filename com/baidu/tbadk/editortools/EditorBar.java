package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private int Bp;
    private List<g> aLQ;
    private List<a> aLR;
    private Paint aLS;
    private Paint aLT;
    private int aLU;
    private int aLV;
    private int aLW;
    private EditorTools aLX;
    private boolean aLY;
    private boolean aLZ;
    private boolean aMa;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.aLU = 0;
        this.aLW = 0;
        this.aLY = false;
        this.aLZ = false;
        this.aMa = true;
        this.aLX = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aLQ = new LinkedList();
        this.aLR = new LinkedList();
        this.aLS = new Paint();
        this.aLT = new Paint();
        setPadding(getResources().getDimensionPixelSize(f.e.ds20), 0, getResources().getDimensionPixelSize(f.e.ds20), 0);
        this.aLS.setStyle(Paint.Style.FILL);
        this.aLT.setStyle(Paint.Style.FILL);
        this.aLV = getResources().getDimensionPixelSize(f.e.ds1);
        this.Bp = ((com.baidu.adp.lib.util.l.ah(context) - com.baidu.adp.lib.util.l.f(context, f.e.ds64)) - (com.baidu.adp.lib.util.l.f(context, f.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aLQ.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.aLQ.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.aLR.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hu() {
        RawLayout.a aVar;
        if (!w.z(this.aLQ) || this.aLW == 4) {
            bC(true);
            for (int i = 0; i < this.aLQ.size(); i++) {
                g gVar = this.aLQ.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.aLW == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.f(getContext(), f.e.ds48), com.baidu.adp.lib.util.l.f(getContext(), f.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds21);
                    } else if (this.aLW == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(f.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.f(getContext(), f.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aLW == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(f.e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(f.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(f.e.ds12);
                        }
                        if (i != this.aLQ.size() - 1) {
                            aVar.rightMargin = this.Bp;
                        }
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(f.e.ds15);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(f.e.ds15);
                    } else {
                        aVar = new RawLayout.a(-2, -2, 80);
                        aVar.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(f.e.ds7);
                        aVar.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(f.e.ds7);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(f.e.ds15);
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(f.e.ds15);
                    }
                    aVar.eP(2);
                    addView(bLauncher, aVar);
                }
            }
            bC(false);
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
                    if (this.aLW == 1 || this.aLW == 3 || this.aLW == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aLW == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bC(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.aLR) {
            View view = (View) aVar2.aMc;
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
                aVar.eP(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eP(2);
                        break;
                    case 3:
                        aVar.eP(1);
                        break;
                    case 4:
                        aVar.eP(3);
                        break;
                    case 5:
                        aVar.eP(2);
                        view.setVisibility(8);
                        break;
                }
                if (((l) view).getToolId() == 8) {
                    am.i(this, f.d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(f.d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aLS == null) {
            this.aLS = new Paint();
            this.aLS.setStyle(Paint.Style.FILL);
        }
        this.aLS.setColor(am.getColor(this.mSkinType, f.d.cp_bg_line_c));
        if (this.aMa) {
            if (this.aLZ) {
                canvas.drawRect(0.0f, this.aMN[0] - this.aLV, getMeasuredWidth(), this.aMN[0], this.aLS);
            }
            if (this.aLY) {
                canvas.drawRect(0.0f, (this.aMN[0] + this.aMN[1]) - this.aLV, getMeasuredWidth(), this.aMN[0] + this.aMN[1], this.aLS);
            }
        }
        if (this.aLT == null) {
            this.aLT = new Paint();
            this.aLT.setStyle(Paint.Style.FILL);
        }
        if (this.aLU > 0) {
            if (this.mSkinType == 0) {
                this.aLT.setColor(getContext().getResources().getColor(this.aLU));
            } else {
                this.aLT.setColor(am.getColor(this.mSkinType, this.aLU));
            }
            if (this.aLY && this.aMa) {
                i = (this.aMN[0] + this.aMN[1]) - this.aLV;
            } else {
                i = this.aMN[0] + this.aMN[1];
            }
            canvas.drawRect(0.0f, this.aMN[0], getMeasuredWidth(), i, this.aLT);
        }
        super.dispatchDraw(canvas);
    }

    public void bD(boolean z) {
        this.aLY = z;
    }

    public void bE(boolean z) {
        this.aLZ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aLQ.clear();
        this.aLR.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.aLW == 1) {
            if (kVar == null) {
                for (g gVar : this.aLQ) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.aLQ) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.aMQ) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aLW == 3 || this.aLW == 2) {
            if (kVar == null) {
                for (g gVar3 : this.aLQ) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.aLQ) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.aMQ) {
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
    public void eI(int i) {
        if (i == 2 && Hv() && this.aLX != null) {
            this.aLX.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eJ = eJ(i);
        if (eJ != null) {
            if (eJ.position == 5) {
                for (g gVar : this.aLQ) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.oC();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.aLR) {
                    if (aVar.aMc != null) {
                        if (aVar.position == 5) {
                            aVar.aMc.oC();
                        } else {
                            aVar.aMc.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.aLQ) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.oC();
                    }
                }
                for (a aVar2 : this.aLR) {
                    if (aVar2.aMc != null) {
                        if (aVar2.position == 5) {
                            aVar2.aMc.hide();
                        } else {
                            aVar2.aMc.oC();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eJ(int i) {
        for (a aVar : this.aLR) {
            if (aVar.aMc != null && aVar.aMc.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Hv() {
        for (a aVar : this.aLR) {
            if (aVar.position == 5 && aVar.aMc != null && (aVar.aMc instanceof View) && ((View) aVar.aMc).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g eK(int i) {
        for (g gVar : this.aLQ) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        am.j(this, this.aLU);
        for (g gVar : this.aLQ) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.aLR) {
            if (aVar.aMc != null) {
                aVar.aMc.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aLU = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.aLQ) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.aLQ) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aLW = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aMb;
        protected l aMc;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.aMb = false;
            this.aMc = null;
            this.position = 0;
            this.aMc = lVar;
            this.position = i;
            this.aMb = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aLQ != null && this.aLQ.size() != 0) {
            Iterator<g> it = this.aLQ.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View eL(int i) {
        for (g gVar : this.aLQ) {
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
