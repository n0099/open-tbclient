package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends v {
    private int ayA;
    private int ayB;
    private boolean ayC;
    private int ayD;
    private j ayE;
    private boolean ayF;
    private boolean ayG;
    private boolean ayH;
    private List<p> ayw;
    private List<a> ayx;
    private Paint ayy;
    private Paint ayz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j jVar) {
        super(context);
        this.mSkinType = 0;
        this.ayA = 0;
        this.ayC = false;
        this.ayD = 0;
        this.ayF = false;
        this.ayG = false;
        this.ayH = true;
        this.ayE = jVar;
        init();
    }

    private void init() {
        this.ayw = new LinkedList();
        this.ayx = new LinkedList();
        this.ayy = new Paint();
        this.ayz = new Paint();
        this.ayy.setStyle(Paint.Style.FILL);
        this.ayz.setStyle(Paint.Style.FILL);
        this.ayB = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.ayw.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, p pVar) {
        this.ayw.add(i, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar, int i, boolean z) {
        this.ayx.add(new a(yVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cn() {
        v.a aVar;
        bz(true);
        Iterator<p> it = this.ayw.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.ayD == 1) {
                aVar = new v.a(0, cVar.getContext().getResources().getDimensionPixelSize(w.f.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds32);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds32);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds28);
                aVar.weight = 1.0f;
            } else {
                aVar = new v.a(cVar.getContext().getResources().getDimensionPixelSize(w.f.ds76), cVar.getContext().getResources().getDimensionPixelSize(w.f.ds76), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(w.f.ds10);
            }
            aVar.eA(2);
            addView(cVar, aVar);
        }
        bz(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.v, android.view.View
    public void onMeasure(int i, int i2) {
        TextView notice;
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof c) && (notice = ((c) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                if (((v.a) notice.getLayoutParams()) == null) {
                    generateDefaultLayoutParams();
                }
                measureChildWithMargins(notice, i, 0, i2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.v, android.view.ViewGroup, android.view.View
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
                    if (this.ayD == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.ayD == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bz(boolean z) {
        v.a aVar;
        for (a aVar2 : this.ayx) {
            View view = (View) aVar2.ayJ;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                aVar = new v.a(-2, -2, 19);
            } else if (layoutParams instanceof v.a) {
                aVar = (v.a) layoutParams;
            } else {
                aVar = new v.a(view.getLayoutParams());
                aVar.gravity = 19;
            }
            if (z && aVar2.position == 1) {
                aVar.eA(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eA(2);
                        break;
                    case 3:
                        aVar.eA(1);
                        break;
                    case 4:
                        aVar.eA(3);
                        break;
                    case 5:
                        aVar.eA(2);
                        view.setVisibility(8);
                        break;
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.ayy == null) {
            this.ayy = new Paint();
            this.ayy.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.ayy.setColor(getContext().getResources().getColor(w.e.cp_bg_line_b));
        } else {
            this.ayy.setColor(aq.getColor(this.mSkinType, w.e.cp_bg_line_b));
        }
        if (this.ayH) {
            if (this.ayG) {
                canvas.drawRect(0.0f, this.azr[0] - this.ayB, getMeasuredWidth(), this.azr[0], this.ayy);
            }
            if (this.ayF) {
                canvas.drawRect(0.0f, (this.azr[0] + this.azr[1]) - this.ayB, getMeasuredWidth(), this.azr[0] + this.azr[1], this.ayy);
            }
        }
        if (this.ayz == null) {
            this.ayz = new Paint();
            this.ayz.setStyle(Paint.Style.FILL);
        }
        if (this.ayA > 0) {
            if (this.mSkinType == 0) {
                this.ayz.setColor(getContext().getResources().getColor(this.ayA));
            } else {
                this.ayz.setColor(aq.getColor(this.mSkinType, this.ayA));
            }
            if (this.ayF && this.ayH) {
                i = (this.azr[0] + this.azr[1]) - this.ayB;
            } else {
                i = this.azr[0] + this.azr[1];
            }
            canvas.drawRect(0.0f, this.azr[0], getMeasuredWidth(), i, this.ayz);
        }
        super.dispatchDraw(canvas);
    }

    public void bA(boolean z) {
        this.ayF = z;
    }

    public void bB(boolean z) {
        this.ayG = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ayw.clear();
        this.ayx.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(x xVar) {
        if (this.ayD == 1) {
            if (xVar == null) {
                for (p pVar : this.ayw) {
                    if (pVar instanceof View) {
                        ((View) pVar).setSelected(false);
                    }
                }
                return;
            }
            for (p pVar2 : this.ayw) {
                if (pVar2 instanceof View) {
                    View view = (View) pVar2;
                    if (pVar2.getToolId() == xVar.id && xVar.azu) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eu(int i) {
        if (i == 2 && Co() && this.ayE != null) {
            this.ayE.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ev = ev(i);
        if (ev != null) {
            if (ev.position == 5) {
                for (p pVar : this.ayw) {
                    if (pVar.getToolId() == 2 || pVar.getToolId() == 1) {
                        pVar.lO();
                    } else {
                        pVar.hide();
                    }
                }
                for (a aVar : this.ayx) {
                    if (aVar.ayJ != null) {
                        if (aVar.position == 5) {
                            aVar.ayJ.lO();
                        } else {
                            aVar.ayJ.hide();
                        }
                    }
                }
            } else {
                for (p pVar2 : this.ayw) {
                    if (pVar2.getToolId() == 1) {
                        pVar2.hide();
                    } else {
                        if (pVar2 instanceof c) {
                            c cVar = (c) pVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        pVar2.lO();
                    }
                }
                for (a aVar2 : this.ayx) {
                    if (aVar2.ayJ != null) {
                        if (aVar2.position == 5) {
                            aVar2.ayJ.hide();
                        } else {
                            aVar2.ayJ.lO();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ev(int i) {
        for (a aVar : this.ayx) {
            if (aVar.ayJ != null && aVar.ayJ.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Co() {
        for (a aVar : this.ayx) {
            if (aVar.position == 5 && aVar.ayJ != null && (aVar.ayJ instanceof View) && ((View) aVar.ayJ).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public p ew(int i) {
        for (p pVar : this.ayw) {
            if (pVar.getToolId() == i) {
                return pVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (p pVar : this.ayw) {
            pVar.onChangeSkinType(i);
        }
        for (a aVar : this.ayx) {
            if (aVar.ayJ != null) {
                aVar.ayJ.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.ayA = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (p pVar : this.ayw) {
            if (pVar != null && (pVar instanceof View)) {
                ((View) pVar).setEnabled(z);
            }
        }
    }

    public void c(boolean z, int i) {
        for (p pVar : this.ayw) {
            if (pVar instanceof View) {
                View view = (View) pVar;
                if (pVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.ayD = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean ayI;
        protected y ayJ;
        protected int position;

        protected a(y yVar, int i, boolean z) {
            this.ayI = false;
            this.ayJ = null;
            this.position = 0;
            this.ayJ = yVar;
            this.position = i;
            this.ayI = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.ayw != null && this.ayw.size() != 0) {
            Iterator<p> it = this.ayw.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
