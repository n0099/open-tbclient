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
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private int Bt;
    private List<g> aLU;
    private List<a> aLV;
    private Paint aLW;
    private Paint aLX;
    private int aLY;
    private int aLZ;
    private EditorTools aMa;
    private boolean aMb;
    private boolean aMc;
    private boolean aMd;
    private int mBgColor;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.aLZ = 0;
        this.aMb = false;
        this.aMc = false;
        this.aMd = true;
        this.aMa = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aLU = new LinkedList();
        this.aLV = new LinkedList();
        this.aLW = new Paint();
        this.aLX = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.aLW.setStyle(Paint.Style.FILL);
        this.aLX.setStyle(Paint.Style.FILL);
        this.aLY = getResources().getDimensionPixelSize(d.e.ds1);
        this.Bt = ((com.baidu.adp.lib.util.l.ah(context) - com.baidu.adp.lib.util.l.e(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.e(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aLU.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.aLU.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.aLV.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Hz() {
        RawLayout.a aVar;
        if (!w.A(this.aLU) || this.aLZ == 4) {
            bD(true);
            for (int i = 0; i < this.aLU.size(); i++) {
                g gVar = this.aLU.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.aLZ == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.e(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.e(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                    } else if (this.aLZ == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aLZ == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.aLU.size() - 1) {
                            aVar.rightMargin = this.Bt;
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
                    aVar.eP(2);
                    addView(bLauncher, aVar);
                }
            }
            bD(false);
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
                    if (this.aLZ == 1 || this.aLZ == 3 || this.aLZ == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aLZ == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bD(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.aLV) {
            View view = (View) aVar2.aMf;
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
                    am.i(this, d.C0142d.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(d.C0142d.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aLW == null) {
            this.aLW = new Paint();
            this.aLW.setStyle(Paint.Style.FILL);
        }
        this.aLW.setColor(am.getColor(this.mSkinType, d.C0142d.cp_bg_line_c));
        if (this.aMd) {
            if (this.aMc) {
                canvas.drawRect(0.0f, this.aMQ[0] - this.aLY, getMeasuredWidth(), this.aMQ[0], this.aLW);
            }
            if (this.aMb) {
                canvas.drawRect(0.0f, (this.aMQ[0] + this.aMQ[1]) - this.aLY, getMeasuredWidth(), this.aMQ[0] + this.aMQ[1], this.aLW);
            }
        }
        if (this.aLX == null) {
            this.aLX = new Paint();
            this.aLX.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.aLX.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.aLX.setColor(am.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.aMb && this.aMd) {
                i = (this.aMQ[0] + this.aMQ[1]) - this.aLY;
            } else {
                i = this.aMQ[0] + this.aMQ[1];
            }
            canvas.drawRect(0.0f, this.aMQ[0], getMeasuredWidth(), i, this.aLX);
        }
        super.dispatchDraw(canvas);
    }

    public void bE(boolean z) {
        this.aMb = z;
    }

    public void bF(boolean z) {
        this.aMc = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aLU.clear();
        this.aLV.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.aLZ == 1) {
            if (kVar == null) {
                for (g gVar : this.aLU) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.aLU) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.aMT) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aLZ == 3 || this.aLZ == 2) {
            if (kVar == null) {
                for (g gVar3 : this.aLU) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.aLU) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.aMT) {
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
        if (i == 2 && HA() && this.aMa != null) {
            this.aMa.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eJ = eJ(i);
        if (eJ != null) {
            if (eJ.position == 5) {
                for (g gVar : this.aLU) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.oD();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.aLV) {
                    if (aVar.aMf != null) {
                        if (aVar.position == 5) {
                            aVar.aMf.oD();
                        } else {
                            aVar.aMf.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.aLU) {
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
                for (a aVar2 : this.aLV) {
                    if (aVar2.aMf != null) {
                        if (aVar2.position == 5) {
                            aVar2.aMf.hide();
                        } else {
                            aVar2.aMf.oD();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eJ(int i) {
        for (a aVar : this.aLV) {
            if (aVar.aMf != null && aVar.aMf.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean HA() {
        for (a aVar : this.aLV) {
            if (aVar.position == 5 && aVar.aMf != null && (aVar.aMf instanceof View) && ((View) aVar.aMf).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g eK(int i) {
        for (g gVar : this.aLU) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        am.j(this, this.mBgColor);
        for (g gVar : this.aLU) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.aLV) {
            if (aVar.aMf != null) {
                aVar.aMf.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.aLU) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.aLU) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aLZ = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aMe;
        protected l aMf;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.aMe = false;
            this.aMf = null;
            this.position = 0;
            this.aMf = lVar;
            this.position = i;
            this.aMe = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aLU != null && this.aLU.size() != 0) {
            Iterator<g> it = this.aLU.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View eL(int i) {
        for (g gVar : this.aLU) {
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
