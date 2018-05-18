package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private List<g> aCC;
    private List<a> aCD;
    private Paint aCE;
    private Paint aCF;
    private int aCG;
    private int aCH;
    private EditorTools aCI;
    private boolean aCJ;
    private boolean aCK;
    private boolean aCL;
    private int mBgColor;
    private int mSkinType;
    private int vl;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.aCH = 0;
        this.aCJ = false;
        this.aCK = false;
        this.aCL = true;
        this.aCI = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aCC = new LinkedList();
        this.aCD = new LinkedList();
        this.aCE = new Paint();
        this.aCF = new Paint();
        setPadding(getResources().getDimensionPixelSize(d.e.ds20), 0, getResources().getDimensionPixelSize(d.e.ds20), 0);
        this.aCE.setStyle(Paint.Style.FILL);
        this.aCF.setStyle(Paint.Style.FILL);
        this.aCG = getResources().getDimensionPixelSize(d.e.ds1);
        this.vl = ((com.baidu.adp.lib.util.l.af(context) - com.baidu.adp.lib.util.l.e(context, d.e.ds64)) - (com.baidu.adp.lib.util.l.e(context, d.e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aCC.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.aCC.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.aCD.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DE() {
        RawLayout.a aVar;
        if (!v.w(this.aCC) || this.aCH == 4) {
            bw(true);
            for (int i = 0; i < this.aCC.size(); i++) {
                g gVar = this.aCC.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.aCH == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.e(getContext(), d.e.ds48), com.baidu.adp.lib.util.l.e(getContext(), d.e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                    } else if (this.aCH == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.e(getContext(), d.e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aCH == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(d.e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(d.e.ds12);
                        }
                        if (i != this.aCC.size() - 1) {
                            aVar.rightMargin = this.vl;
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
                    aVar.eK(2);
                    addView(bLauncher, aVar);
                }
            }
            bw(false);
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
                    if (this.aCH == 1 || this.aCH == 3 || this.aCH == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aCH == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bw(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.aCD) {
            View view2 = (View) aVar2.aCN;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                aVar = new RawLayout.a(-2, -2, 19);
            } else if (layoutParams instanceof RawLayout.a) {
                aVar = (RawLayout.a) layoutParams;
            } else {
                aVar = new RawLayout.a(view2.getLayoutParams());
                aVar.gravity = 19;
            }
            if (z && aVar2.position == 1) {
                aVar.eK(2);
                addView(view2, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eK(2);
                        break;
                    case 3:
                        aVar.eK(1);
                        break;
                    case 4:
                        aVar.eK(3);
                        break;
                    case 5:
                        aVar.eK(2);
                        view2.setVisibility(8);
                        break;
                }
                if (((l) view2).getToolId() == 8) {
                    ak.i(this, d.C0126d.common_color_10055);
                    view2.setBackgroundColor(getResources().getColor(d.C0126d.white_alpha0));
                }
                addView(view2, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.aCE == null) {
            this.aCE = new Paint();
            this.aCE.setStyle(Paint.Style.FILL);
        }
        this.aCE.setColor(ak.getColor(this.mSkinType, d.C0126d.cp_bg_line_c));
        if (this.aCL) {
            if (this.aCK) {
                canvas.drawRect(0.0f, this.aDy[0] - this.aCG, getMeasuredWidth(), this.aDy[0], this.aCE);
            }
            if (this.aCJ) {
                canvas.drawRect(0.0f, (this.aDy[0] + this.aDy[1]) - this.aCG, getMeasuredWidth(), this.aDy[0] + this.aDy[1], this.aCE);
            }
        }
        if (this.aCF == null) {
            this.aCF = new Paint();
            this.aCF.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.aCF.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.aCF.setColor(ak.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.aCJ && this.aCL) {
                i = (this.aDy[0] + this.aDy[1]) - this.aCG;
            } else {
                i = this.aDy[0] + this.aDy[1];
            }
            canvas.drawRect(0.0f, this.aDy[0], getMeasuredWidth(), i, this.aCF);
        }
        super.dispatchDraw(canvas);
    }

    public void bx(boolean z) {
        this.aCJ = z;
    }

    public void by(boolean z) {
        this.aCK = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aCC.clear();
        this.aCD.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.aCH == 1) {
            if (kVar == null) {
                for (g gVar : this.aCC) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.aCC) {
                if (gVar2 instanceof View) {
                    View view2 = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.aDB) {
                        view2.setSelected(true);
                    } else {
                        view2.setSelected(false);
                    }
                }
            }
        } else if (this.aCH == 3 || this.aCH == 2) {
            if (kVar == null) {
                for (g gVar3 : this.aCC) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.aCC) {
                    if (gVar4 instanceof View) {
                        View view3 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.aDB) {
                            view3.setSelected(true);
                        } else {
                            view3.setSelected(false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eD(int i) {
        if (i == 2 && DF() && this.aCI != null) {
            this.aCI.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eE = eE(i);
        if (eE != null) {
            if (eE.position == 5) {
                for (g gVar : this.aCC) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.lM();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.aCD) {
                    if (aVar.aCN != null) {
                        if (aVar.position == 5) {
                            aVar.aCN.lM();
                        } else {
                            aVar.aCN.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.aCC) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.lM();
                    }
                }
                for (a aVar2 : this.aCD) {
                    if (aVar2.aCN != null) {
                        if (aVar2.position == 5) {
                            aVar2.aCN.hide();
                        } else {
                            aVar2.aCN.lM();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eE(int i) {
        for (a aVar : this.aCD) {
            if (aVar.aCN != null && aVar.aCN.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean DF() {
        for (a aVar : this.aCD) {
            if (aVar.position == 5 && aVar.aCN != null && (aVar.aCN instanceof View) && ((View) aVar.aCN).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g eF(int i) {
        for (g gVar : this.aCC) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ak.j(this, this.mBgColor);
        for (g gVar : this.aCC) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.aCD) {
            if (aVar.aCN != null) {
                aVar.aCN.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.aCC) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.aCC) {
            if (gVar instanceof View) {
                View view2 = (View) gVar;
                if (gVar.getToolId() == i) {
                    view2.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aCH = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aCM;
        protected l aCN;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.aCM = false;
            this.aCN = null;
            this.position = 0;
            this.aCN = lVar;
            this.position = i;
            this.aCM = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(View.OnClickListener onClickListener) {
        if (this.aCC != null && this.aCC.size() != 0) {
            Iterator<g> it = this.aCC.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View eG(int i) {
        for (g gVar : this.aCC) {
            if (gVar instanceof View) {
                View view2 = (View) gVar;
                if (gVar.getToolId() == i) {
                    return view2;
                }
            }
        }
        return null;
    }
}
