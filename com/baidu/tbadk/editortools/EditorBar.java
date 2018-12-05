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
    private List<g> aXX;
    private List<a> aXY;
    private Paint aXZ;
    private Paint aYa;
    private int aYb;
    private int aYc;
    private EditorTools aYd;
    private boolean aYe;
    private boolean aYf;
    private boolean aYg;
    private int mBgColor;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.aYc = 0;
        this.aYe = false;
        this.aYf = false;
        this.aYg = true;
        this.aYd = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.aXX = new LinkedList();
        this.aXY = new LinkedList();
        this.aXZ = new Paint();
        this.aYa = new Paint();
        setPadding(getResources().getDimensionPixelSize(e.C0210e.ds20), 0, getResources().getDimensionPixelSize(e.C0210e.ds20), 0);
        this.aXZ.setStyle(Paint.Style.FILL);
        this.aYa.setStyle(Paint.Style.FILL);
        this.aYb = getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.Ew = ((com.baidu.adp.lib.util.l.aO(context) - com.baidu.adp.lib.util.l.h(context, e.C0210e.ds64)) - (com.baidu.adp.lib.util.l.h(context, e.C0210e.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.aXX.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.aXX.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.aXY.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void LY() {
        RawLayout.a aVar;
        if (!v.I(this.aXX) || this.aYc == 4) {
            cp(true);
            for (int i = 0; i < this.aXX.size(); i++) {
                g gVar = this.aXX.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.aYc == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds48), com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds21);
                    } else if (this.aYc == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.aYc == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(e.C0210e.ds12);
                        }
                        if (i != this.aXX.size() - 1) {
                            aVar.rightMargin = this.Ew;
                        }
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds15);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds15);
                    } else {
                        aVar = new RawLayout.a(-2, -2, 80);
                        aVar.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds7);
                        aVar.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds7);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds15);
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(e.C0210e.ds15);
                    }
                    aVar.fM(2);
                    addView(bLauncher, aVar);
                }
            }
            cp(false);
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
                    if (this.aYc == 1 || this.aYc == 3 || this.aYc == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aYc == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void cp(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.aXY) {
            View view = (View) aVar2.aYi;
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
                aVar.fM(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.fM(2);
                        break;
                    case 3:
                        aVar.fM(1);
                        break;
                    case 4:
                        aVar.fM(3);
                        break;
                    case 5:
                        aVar.fM(2);
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
        if (this.aXZ == null) {
            this.aXZ = new Paint();
            this.aXZ.setStyle(Paint.Style.FILL);
        }
        this.aXZ.setColor(al.getColor(this.mSkinType, e.d.cp_bg_line_c));
        if (this.aYg) {
            if (this.aYf) {
                canvas.drawRect(0.0f, this.aYT[0] - this.aYb, getMeasuredWidth(), this.aYT[0], this.aXZ);
            }
            if (this.aYe) {
                canvas.drawRect(0.0f, (this.aYT[0] + this.aYT[1]) - this.aYb, getMeasuredWidth(), this.aYT[0] + this.aYT[1], this.aXZ);
            }
        }
        if (this.aYa == null) {
            this.aYa = new Paint();
            this.aYa.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.aYa.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.aYa.setColor(al.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.aYe && this.aYg) {
                i = (this.aYT[0] + this.aYT[1]) - this.aYb;
            } else {
                i = this.aYT[0] + this.aYT[1];
            }
            canvas.drawRect(0.0f, this.aYT[0], getMeasuredWidth(), i, this.aYa);
        }
        super.dispatchDraw(canvas);
    }

    public void cq(boolean z) {
        this.aYe = z;
    }

    public void cr(boolean z) {
        this.aYf = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aXX.clear();
        this.aXY.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.aYc == 1) {
            if (kVar == null) {
                for (g gVar : this.aXX) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.aXX) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.aYW) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.aYc == 3 || this.aYc == 2) {
            if (kVar == null) {
                for (g gVar3 : this.aXX) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.aXX) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.aYW) {
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
    public void fF(int i) {
        if (i == 2 && LZ() && this.aYd != null) {
            this.aYd.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a fG = fG(i);
        if (fG != null) {
            if (fG.position == 5) {
                for (g gVar : this.aXX) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.pN();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.aXY) {
                    if (aVar.aYi != null) {
                        if (aVar.position == 5) {
                            aVar.aYi.pN();
                        } else {
                            aVar.aYi.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.aXX) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.pN();
                    }
                }
                for (a aVar2 : this.aXY) {
                    if (aVar2.aYi != null) {
                        if (aVar2.position == 5) {
                            aVar2.aYi.hide();
                        } else {
                            aVar2.aYi.pN();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a fG(int i) {
        for (a aVar : this.aXY) {
            if (aVar.aYi != null && aVar.aYi.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean LZ() {
        for (a aVar : this.aXY) {
            if (aVar.position == 5 && aVar.aYi != null && (aVar.aYi instanceof View) && ((View) aVar.aYi).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g fH(int i) {
        for (g gVar : this.aXX) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.j(this, this.mBgColor);
        for (g gVar : this.aXX) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.aXY) {
            if (aVar.aYi != null) {
                aVar.aYi.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.aXX) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.aXX) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aYc = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aYh;
        protected l aYi;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.aYh = false;
            this.aYi = null;
            this.position = 0;
            this.aYi = lVar;
            this.position = i;
            this.aYh = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View.OnClickListener onClickListener) {
        if (this.aXX != null && this.aXX.size() != 0) {
            Iterator<g> it = this.aXX.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View fI(int i) {
        for (g gVar : this.aXX) {
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
