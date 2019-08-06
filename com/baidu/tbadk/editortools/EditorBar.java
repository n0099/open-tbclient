package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EditorBar extends RawLayout {
    private int Cj;
    private List<g> crO;
    private List<a> crP;
    private Paint crQ;
    private Paint crR;
    private int crS;
    private int crT;
    private int crU;
    private EditorTools crV;
    private boolean crW;
    private boolean crX;
    private boolean crY;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.crS = 0;
        this.crU = 0;
        this.crW = false;
        this.crX = false;
        this.crY = true;
        this.crV = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.crO = new LinkedList();
        this.crP = new LinkedList();
        this.crQ = new Paint();
        this.crR = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.crQ.setStyle(Paint.Style.FILL);
        this.crR.setStyle(Paint.Style.FILL);
        this.crT = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.Cj = ((com.baidu.adp.lib.util.l.af(context) - com.baidu.adp.lib.util.l.g(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.g(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.crO.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.crO.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.crP.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asb() {
        RawLayout.a aVar;
        if (!v.aa(this.crO) || this.crU == 4) {
            fg(true);
            for (int i = 0; i < this.crO.size(); i++) {
                g gVar = this.crO.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.crU == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                    } else if (this.crU == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.crU == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.crO.size() - 1) {
                            aVar.rightMargin = this.Cj;
                        }
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    } else {
                        aVar = new RawLayout.a(-2, -2, 80);
                        aVar.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        aVar.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        aVar.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        aVar.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    }
                    aVar.ks(2);
                    addView(bLauncher, aVar);
                }
            }
            fg(false);
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
                    if (this.crU == 1 || this.crU == 3 || this.crU == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.crU == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void fg(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.crP) {
            View view = (View) aVar2.csa;
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
                aVar.ks(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.ks(2);
                        break;
                    case 3:
                        aVar.ks(1);
                        break;
                    case 4:
                        aVar.ks(3);
                        break;
                    case 5:
                        aVar.ks(2);
                        view.setVisibility(8);
                        break;
                }
                if (((l) view).getToolId() == 8) {
                    am.k(this, R.color.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.crQ == null) {
            this.crQ = new Paint();
            this.crQ.setStyle(Paint.Style.FILL);
        }
        this.crQ.setColor(am.getColor(this.mSkinType, R.color.cp_bg_line_c));
        if (this.crY) {
            if (this.crX) {
                canvas.drawRect(0.0f, this.csM[0] - this.crT, getMeasuredWidth(), this.csM[0], this.crQ);
            }
            if (this.crW) {
                canvas.drawRect(0.0f, (this.csM[0] + this.csM[1]) - this.crT, getMeasuredWidth(), this.csM[0] + this.csM[1], this.crQ);
            }
        }
        if (this.crR == null) {
            this.crR = new Paint();
            this.crR.setStyle(Paint.Style.FILL);
        }
        if (this.crS > 0) {
            if (this.mSkinType == 0) {
                this.crR.setColor(getContext().getResources().getColor(this.crS));
            } else {
                this.crR.setColor(am.getColor(this.mSkinType, this.crS));
            }
            if (this.crW && this.crY) {
                i = (this.csM[0] + this.csM[1]) - this.crT;
            } else {
                i = this.csM[0] + this.csM[1];
            }
            canvas.drawRect(0.0f, this.csM[0], getMeasuredWidth(), i, this.crR);
        }
        super.dispatchDraw(canvas);
    }

    public void fh(boolean z) {
        this.crW = z;
    }

    public void fi(boolean z) {
        this.crX = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.crO.clear();
        this.crP.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.crU == 1) {
            if (kVar == null) {
                for (g gVar : this.crO) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.crO) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.csP) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.crU == 3 || this.crU == 2) {
            if (kVar == null) {
                for (g gVar3 : this.crO) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.crO) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.csP) {
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
    public void kl(int i) {
        if (i == 2 && asc() && this.crV != null) {
            this.crV.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a km = km(i);
        if (km != null) {
            if (km.position == 5) {
                for (g gVar : this.crO) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.qk();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.crP) {
                    if (aVar.csa != null) {
                        if (aVar.position == 5) {
                            aVar.csa.qk();
                        } else {
                            aVar.csa.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.crO) {
                    if (gVar2.getToolId() == 1) {
                        gVar2.hide();
                    } else {
                        if (gVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) gVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        gVar2.qk();
                    }
                }
                for (a aVar2 : this.crP) {
                    if (aVar2.csa != null) {
                        if (aVar2.position == 5) {
                            aVar2.csa.hide();
                        } else {
                            aVar2.csa.qk();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a km(int i) {
        for (a aVar : this.crP) {
            if (aVar.csa != null && aVar.csa.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean asc() {
        for (a aVar : this.crP) {
            if (aVar.position == 5 && aVar.csa != null && (aVar.csa instanceof View) && ((View) aVar.csa).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g kn(int i) {
        for (g gVar : this.crO) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        am.l(this, this.crS);
        for (g gVar : this.crO) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.crP) {
            if (aVar.csa != null) {
                aVar.csa.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.crS = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.crO) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.crO) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.crU = i;
    }

    public int getBarLauncherType() {
        return this.crU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean crZ;
        protected l csa;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.crZ = false;
            this.csa = null;
            this.position = 0;
            this.csa = lVar;
            this.position = i;
            this.crZ = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(View.OnClickListener onClickListener) {
        if (this.crO != null && this.crO.size() != 0) {
            Iterator<g> it = this.crO.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View ko(int i) {
        for (g gVar : this.crO) {
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
