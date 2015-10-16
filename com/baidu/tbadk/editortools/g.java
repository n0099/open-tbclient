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
    private Paint aoA;
    private Paint aoB;
    private int aoC;
    private int aoD;
    private int aoE;
    private boolean aoF;
    private int aoG;
    private j aoH;
    private List<p> aoy;
    private List<a> aoz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j jVar) {
        super(context);
        this.mSkinType = 0;
        this.aoC = 0;
        this.aoE = 0;
        this.aoF = false;
        this.aoG = 0;
        this.aoH = jVar;
        init();
    }

    private void init() {
        this.aoy = new LinkedList();
        this.aoz = new LinkedList();
        this.aoA = new Paint();
        this.aoB = new Paint();
        this.aoA.setStyle(Paint.Style.FILL);
        this.aoB.setStyle(Paint.Style.FILL);
        this.aoD = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.aoy.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, p pVar) {
        this.aoy.add(i, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(w wVar, int i, boolean z) {
        this.aoz.add(new a(wVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ay() {
        u.a aVar;
        bd(true);
        Iterator<p> it = this.aoy.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aoG == 1) {
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
                    if (this.aoG == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aoG == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bd(boolean z) {
        u.a aVar;
        for (a aVar2 : this.aoz) {
            View view = (View) aVar2.aoJ;
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
        if (this.aoA == null) {
            this.aoA = new Paint();
            this.aoA.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aoA.setColor(getContext().getResources().getColor(i.c.cp_bg_line_b));
        } else {
            this.aoA.setColor(an.getColor(i.c.cp_bg_line_b));
        }
        if (this.aoE == 1) {
            canvas.drawRect(0.0f, this.apq[0], getMeasuredWidth(), this.aoD + this.apq[0], this.aoA);
        } else if (this.aoE == 2) {
            canvas.drawRect(0.0f, (this.apq[0] + this.apq[1]) - this.aoD, getMeasuredWidth(), this.apq[0] + this.apq[1], this.aoA);
        }
        if (this.aoB == null) {
            this.aoB = new Paint();
            this.aoB.setStyle(Paint.Style.FILL);
        }
        if (this.aoC > 0) {
            if (this.mSkinType == 0) {
                this.aoB.setColor(getContext().getResources().getColor(this.aoC));
            } else {
                this.aoB.setColor(an.getColor(this.aoC));
            }
            canvas.drawRect(0.0f, this.apq[0], getMeasuredWidth(), this.apq[0] + this.apq[1], this.aoB);
        }
        super.dispatchDraw(canvas);
    }

    public void setLinePosition(int i) {
        this.aoE = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aoy.clear();
        this.aoz.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(v vVar) {
        if (this.aoG == 1) {
            if (vVar == null) {
                for (p pVar : this.aoy) {
                    if (pVar instanceof View) {
                        ((View) pVar).setSelected(false);
                    }
                }
                return;
            }
            for (p pVar2 : this.aoy) {
                if (pVar2 instanceof View) {
                    View view = (View) pVar2;
                    if (pVar2.getToolId() == vVar.id && vVar.apt) {
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
        if (i == 2 && Az() && this.aoH != null) {
            this.aoH.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a dR = dR(i);
        if (dR != null) {
            if (dR.position == 5) {
                for (p pVar : this.aoy) {
                    if (pVar.getToolId() == 2 || pVar.getToolId() == 1) {
                        pVar.ow();
                    } else {
                        pVar.hide();
                    }
                }
                for (a aVar : this.aoz) {
                    if (aVar.aoJ != null) {
                        if (aVar.position == 5) {
                            aVar.aoJ.ow();
                        } else {
                            aVar.aoJ.hide();
                        }
                    }
                }
            } else {
                for (p pVar2 : this.aoy) {
                    if (pVar2.getToolId() == 1) {
                        pVar2.hide();
                    } else {
                        pVar2.ow();
                    }
                }
                for (a aVar2 : this.aoz) {
                    if (aVar2.aoJ != null) {
                        if (aVar2.position == 5) {
                            aVar2.aoJ.hide();
                        } else {
                            aVar2.aoJ.ow();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a dR(int i) {
        for (a aVar : this.aoz) {
            if (aVar.aoJ != null && aVar.aoJ.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Az() {
        for (a aVar : this.aoz) {
            if (aVar.position == 5 && aVar.aoJ != null && (aVar.aoJ instanceof View) && ((View) aVar.aoJ).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public p dS(int i) {
        for (p pVar : this.aoy) {
            if (pVar.getToolId() == i) {
                return pVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (p pVar : this.aoy) {
            pVar.onChangeSkinType(i);
        }
        for (a aVar : this.aoz) {
            if (aVar.aoJ != null) {
                aVar.aoJ.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aoC = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (p pVar : this.aoy) {
            if (pVar != null && (pVar instanceof View)) {
                ((View) pVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aoG = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aoI;
        protected w aoJ;
        protected int position;

        protected a(w wVar, int i, boolean z) {
            this.aoI = false;
            this.aoJ = null;
            this.position = 0;
            this.aoJ = wVar;
            this.position = i;
            this.aoI = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View.OnClickListener onClickListener) {
        if (this.aoy != null && this.aoy.size() != 0) {
            Iterator<p> it = this.aoy.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
