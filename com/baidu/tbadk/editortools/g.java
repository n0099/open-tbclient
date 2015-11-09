package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.editortools.u;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends u {
    private List<p> aoE;
    private List<a> aoF;
    private Paint aoG;
    private Paint aoH;
    private int aoI;
    private int aoJ;
    private int aoK;
    private boolean aoL;
    private int aoM;
    private j aoN;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j jVar) {
        super(context);
        this.mSkinType = 0;
        this.aoI = 0;
        this.aoK = 0;
        this.aoL = false;
        this.aoM = 0;
        this.aoN = jVar;
        init();
    }

    private void init() {
        this.aoE = new LinkedList();
        this.aoF = new LinkedList();
        this.aoG = new Paint();
        this.aoH = new Paint();
        this.aoG.setStyle(Paint.Style.FILL);
        this.aoH.setStyle(Paint.Style.FILL);
        this.aoJ = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.aoE.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, p pVar) {
        this.aoE.add(i, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(x xVar, int i, boolean z) {
        this.aoF.add(new a(xVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AA() {
        u.a aVar;
        bd(true);
        Iterator<p> it = this.aoE.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aoM == 1) {
                aVar = new u.a(cVar.getContext().getResources().getDimensionPixelSize(i.d.ds48), cVar.getContext().getResources().getDimensionPixelSize(i.d.ds48), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds28);
            } else {
                aVar = new u.a(cVar.getContext().getResources().getDimensionPixelSize(i.d.pb_editor_button_width), cVar.getContext().getResources().getDimensionPixelSize(i.d.pb_editor_button_height), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(i.d.ds10);
            }
            aVar.dW(2);
            addView(cVar, aVar);
        }
        bd(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.u, android.view.View
    public void onMeasure(int i, int i2) {
        TextView notice;
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof c) && (notice = ((c) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                if (((u.a) notice.getLayoutParams()) == null) {
                    generateDefaultLayoutParams();
                }
                measureChildWithMargins(notice, i, 0, i2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.u, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int right;
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt instanceof c) {
                TextView notice = ((c) childAt).getNotice();
                c cVar = (c) childAt;
                if (notice != null && cVar.getDrawable() != null) {
                    int intrinsicWidth = cVar.getDrawable().getIntrinsicWidth();
                    int intrinsicHeight = cVar.getDrawable().getIntrinsicHeight();
                    int measuredWidth = (childAt.getMeasuredWidth() - intrinsicWidth) / 2;
                    int measuredHeight = (childAt.getMeasuredHeight() - intrinsicHeight) / 2;
                    if (this.aoM == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aoM == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bd(boolean z) {
        u.a aVar;
        for (a aVar2 : this.aoF) {
            View view = (View) aVar2.toolView;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                aVar = new u.a(-2, -2, 19);
            } else if (layoutParams instanceof u.a) {
                aVar = (u.a) layoutParams;
            } else {
                aVar = new u.a(view.getLayoutParams());
                aVar.gravity = 19;
            }
            if (z && aVar2.position == 1) {
                aVar.dW(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.dW(2);
                        break;
                    case 3:
                        aVar.dW(1);
                        break;
                    case 4:
                        aVar.dW(3);
                        break;
                    case 5:
                        aVar.dW(2);
                        view.setVisibility(8);
                        break;
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.aoG == null) {
            this.aoG = new Paint();
            this.aoG.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aoG.setColor(getContext().getResources().getColor(i.c.cp_bg_line_b));
        } else {
            this.aoG.setColor(an.getColor(i.c.cp_bg_line_b));
        }
        if (this.aoK == 1) {
            canvas.drawRect(0.0f, this.apw[0], getMeasuredWidth(), this.aoJ + this.apw[0], this.aoG);
        } else if (this.aoK == 2) {
            canvas.drawRect(0.0f, (this.apw[0] + this.apw[1]) - this.aoJ, getMeasuredWidth(), this.apw[0] + this.apw[1], this.aoG);
        }
        if (this.aoH == null) {
            this.aoH = new Paint();
            this.aoH.setStyle(Paint.Style.FILL);
        }
        if (this.aoI > 0) {
            if (this.mSkinType == 0) {
                this.aoH.setColor(getContext().getResources().getColor(this.aoI));
            } else {
                this.aoH.setColor(an.getColor(this.aoI));
            }
            canvas.drawRect(0.0f, this.apw[0], getMeasuredWidth(), this.apw[0] + this.apw[1], this.aoH);
        }
        super.dispatchDraw(canvas);
    }

    public void setLinePosition(int i) {
        this.aoK = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aoE.clear();
        this.aoF.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(w wVar) {
        if (this.aoM == 1) {
            if (wVar == null) {
                for (p pVar : this.aoE) {
                    if (pVar instanceof View) {
                        ((View) pVar).setSelected(false);
                    }
                }
                return;
            }
            for (p pVar2 : this.aoE) {
                if (pVar2 instanceof View) {
                    View view = (View) pVar2;
                    if (pVar2.getToolId() == wVar.id && wVar.isLauncherCanSelect) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dQ(int i) {
        if (i == 2 && AB() && this.aoN != null) {
            this.aoN.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a dR = dR(i);
        if (dR != null) {
            if (dR.position == 5) {
                for (p pVar : this.aoE) {
                    if (pVar.getToolId() == 2 || pVar.getToolId() == 1) {
                        pVar.ox();
                    } else {
                        pVar.hide();
                    }
                }
                for (a aVar : this.aoF) {
                    if (aVar.toolView != null) {
                        if (aVar.position == 5) {
                            aVar.toolView.ox();
                        } else {
                            aVar.toolView.hide();
                        }
                    }
                }
            } else {
                for (p pVar2 : this.aoE) {
                    if (pVar2.getToolId() == 1) {
                        pVar2.hide();
                    } else {
                        if (pVar2 instanceof c) {
                            c cVar = (c) pVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        pVar2.ox();
                    }
                }
                for (a aVar2 : this.aoF) {
                    if (aVar2.toolView != null) {
                        if (aVar2.position == 5) {
                            aVar2.toolView.hide();
                        } else {
                            aVar2.toolView.ox();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a dR(int i) {
        for (a aVar : this.aoF) {
            if (aVar.toolView != null && aVar.toolView.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean AB() {
        for (a aVar : this.aoF) {
            if (aVar.position == 5 && aVar.toolView != null && (aVar.toolView instanceof View) && ((View) aVar.toolView).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public p dS(int i) {
        for (p pVar : this.aoE) {
            if (pVar.getToolId() == i) {
                return pVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (p pVar : this.aoE) {
            pVar.onChangeSkinType(i);
        }
        for (a aVar : this.aoF) {
            if (aVar.toolView != null) {
                aVar.toolView.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aoI = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (p pVar : this.aoE) {
            if (pVar != null && (pVar instanceof View)) {
                ((View) pVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aoM = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aoO;
        protected int position;
        protected x toolView;

        protected a(x xVar, int i, boolean z) {
            this.aoO = false;
            this.toolView = null;
            this.position = 0;
            this.toolView = xVar;
            this.position = i;
            this.aoO = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View.OnClickListener onClickListener) {
        if (this.aoE != null && this.aoE.size() != 0) {
            Iterator<p> it = this.aoE.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
