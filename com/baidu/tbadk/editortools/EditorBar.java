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
    private List<g> crH;
    private List<a> crI;
    private Paint crJ;
    private Paint crK;
    private int crL;
    private int crM;
    private int crN;
    private EditorTools crO;
    private boolean crP;
    private boolean crQ;
    private boolean crR;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.crL = 0;
        this.crN = 0;
        this.crP = false;
        this.crQ = false;
        this.crR = true;
        this.crO = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.crH = new LinkedList();
        this.crI = new LinkedList();
        this.crJ = new Paint();
        this.crK = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.crJ.setStyle(Paint.Style.FILL);
        this.crK.setStyle(Paint.Style.FILL);
        this.crM = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.Cj = ((com.baidu.adp.lib.util.l.af(context) - com.baidu.adp.lib.util.l.g(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.g(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(g gVar) {
        this.crH.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, g gVar) {
        this.crH.add(i, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, int i, boolean z) {
        this.crI.add(new a(lVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arZ() {
        RawLayout.a aVar;
        if (!v.aa(this.crH) || this.crN == 4) {
            fg(true);
            for (int i = 0; i < this.crH.size(); i++) {
                g gVar = this.crH.get(i);
                if (gVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) gVar;
                    if (this.crN == 2) {
                        aVar = new RawLayout.a(com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds48), 80);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                    } else if (this.crN == 3) {
                        aVar = new RawLayout.a(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        aVar.leftMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.rightMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds32);
                        aVar.topMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.bottomMargin = com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds21);
                        aVar.weight = 1.0f;
                    } else if (this.crN == 1) {
                        aVar = new RawLayout.a(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            aVar.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.crH.size() - 1) {
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
                    aVar.kr(2);
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
                    if (this.crN == 1 || this.crN == 3 || this.crN == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.crN == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void fg(boolean z) {
        RawLayout.a aVar;
        for (a aVar2 : this.crI) {
            View view = (View) aVar2.crT;
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
                aVar.kr(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.kr(2);
                        break;
                    case 3:
                        aVar.kr(1);
                        break;
                    case 4:
                        aVar.kr(3);
                        break;
                    case 5:
                        aVar.kr(2);
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
        if (this.crJ == null) {
            this.crJ = new Paint();
            this.crJ.setStyle(Paint.Style.FILL);
        }
        this.crJ.setColor(am.getColor(this.mSkinType, R.color.cp_bg_line_c));
        if (this.crR) {
            if (this.crQ) {
                canvas.drawRect(0.0f, this.csF[0] - this.crM, getMeasuredWidth(), this.csF[0], this.crJ);
            }
            if (this.crP) {
                canvas.drawRect(0.0f, (this.csF[0] + this.csF[1]) - this.crM, getMeasuredWidth(), this.csF[0] + this.csF[1], this.crJ);
            }
        }
        if (this.crK == null) {
            this.crK = new Paint();
            this.crK.setStyle(Paint.Style.FILL);
        }
        if (this.crL > 0) {
            if (this.mSkinType == 0) {
                this.crK.setColor(getContext().getResources().getColor(this.crL));
            } else {
                this.crK.setColor(am.getColor(this.mSkinType, this.crL));
            }
            if (this.crP && this.crR) {
                i = (this.csF[0] + this.csF[1]) - this.crM;
            } else {
                i = this.csF[0] + this.csF[1];
            }
            canvas.drawRect(0.0f, this.csF[0], getMeasuredWidth(), i, this.crK);
        }
        super.dispatchDraw(canvas);
    }

    public void fh(boolean z) {
        this.crP = z;
    }

    public void fi(boolean z) {
        this.crQ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.crH.clear();
        this.crI.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(k kVar) {
        if (this.crN == 1) {
            if (kVar == null) {
                for (g gVar : this.crH) {
                    if (gVar instanceof View) {
                        ((View) gVar).setSelected(false);
                    }
                }
                return;
            }
            for (g gVar2 : this.crH) {
                if (gVar2 instanceof View) {
                    View view = (View) gVar2;
                    if (gVar2.getToolId() == kVar.id && kVar.csI) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.crN == 3 || this.crN == 2) {
            if (kVar == null) {
                for (g gVar3 : this.crH) {
                    if (gVar3 instanceof View) {
                        ((View) gVar3).setSelected(false);
                    }
                }
            } else if (kVar.id == 5 || kVar.id == 2 || kVar.id == 6) {
                for (g gVar4 : this.crH) {
                    if (gVar4 instanceof View) {
                        View view2 = (View) gVar4;
                        if (gVar4.getToolId() == kVar.id && kVar.csI) {
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
    public void kk(int i) {
        if (i == 2 && asa() && this.crO != null) {
            this.crO.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a kl = kl(i);
        if (kl != null) {
            if (kl.position == 5) {
                for (g gVar : this.crH) {
                    if (gVar.getToolId() == 2 || gVar.getToolId() == 1) {
                        gVar.qk();
                    } else {
                        gVar.hide();
                    }
                }
                for (a aVar : this.crI) {
                    if (aVar.crT != null) {
                        if (aVar.position == 5) {
                            aVar.crT.qk();
                        } else {
                            aVar.crT.hide();
                        }
                    }
                }
            } else {
                for (g gVar2 : this.crH) {
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
                for (a aVar2 : this.crI) {
                    if (aVar2.crT != null) {
                        if (aVar2.position == 5) {
                            aVar2.crT.hide();
                        } else {
                            aVar2.crT.qk();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a kl(int i) {
        for (a aVar : this.crI) {
            if (aVar.crT != null && aVar.crT.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean asa() {
        for (a aVar : this.crI) {
            if (aVar.position == 5 && aVar.crT != null && (aVar.crT instanceof View) && ((View) aVar.crT).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public g km(int i) {
        for (g gVar : this.crH) {
            if (gVar.getToolId() == i) {
                return gVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        am.l(this, this.crL);
        for (g gVar : this.crH) {
            gVar.onChangeSkinType(i);
        }
        for (a aVar : this.crI) {
            if (aVar.crT != null) {
                aVar.crT.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.crL = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (g gVar : this.crH) {
            if (gVar != null && (gVar instanceof View)) {
                ((View) gVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherEnabled(boolean z, int i) {
        for (g gVar : this.crH) {
            if (gVar instanceof View) {
                View view = (View) gVar;
                if (gVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.crN = i;
    }

    public int getBarLauncherType() {
        return this.crN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean crS;
        protected l crT;
        protected int position;

        protected a(l lVar, int i, boolean z) {
            this.crS = false;
            this.crT = null;
            this.position = 0;
            this.crT = lVar;
            this.position = i;
            this.crS = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(View.OnClickListener onClickListener) {
        if (this.crH != null && this.crH.size() != 0) {
            Iterator<g> it = this.crH.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View kn(int i) {
        for (g gVar : this.crH) {
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
