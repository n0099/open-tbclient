package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.v;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends v {
    private List<p> ata;
    private List<a> atb;
    private Paint atc;
    private Paint atd;
    private int ate;
    private int atf;
    private boolean atg;
    private int ath;
    private j ati;
    private boolean atj;
    private boolean atk;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j jVar) {
        super(context);
        this.mSkinType = 0;
        this.ate = 0;
        this.atg = false;
        this.ath = 0;
        this.atj = false;
        this.atk = false;
        this.ati = jVar;
        init();
    }

    private void init() {
        this.ata = new LinkedList();
        this.atb = new LinkedList();
        this.atc = new Paint();
        this.atd = new Paint();
        this.atc.setStyle(Paint.Style.FILL);
        this.atd.setStyle(Paint.Style.FILL);
        this.atf = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.ata.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, p pVar) {
        this.ata.add(i, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar, int i, boolean z) {
        this.atb.add(new a(yVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cx() {
        v.a aVar;
        bB(true);
        Iterator<p> it = this.ata.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.ath == 1) {
                aVar = new v.a(cVar.getContext().getResources().getDimensionPixelSize(r.f.ds60), cVar.getContext().getResources().getDimensionPixelSize(r.f.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(r.f.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(r.f.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(r.f.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(r.f.ds28);
            } else {
                aVar = new v.a(cVar.getContext().getResources().getDimensionPixelSize(r.f.ds76), cVar.getContext().getResources().getDimensionPixelSize(r.f.ds76), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(r.f.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(r.f.ds10);
            }
            aVar.eF(2);
            addView(cVar, aVar);
        }
        bB(false);
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
                    if (this.ath == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.ath == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bB(boolean z) {
        v.a aVar;
        for (a aVar2 : this.atb) {
            View view = (View) aVar2.atm;
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
                aVar.eF(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eF(2);
                        break;
                    case 3:
                        aVar.eF(1);
                        break;
                    case 4:
                        aVar.eF(3);
                        break;
                    case 5:
                        aVar.eF(2);
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
        if (this.atc == null) {
            this.atc = new Paint();
            this.atc.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.atc.setColor(getContext().getResources().getColor(r.e.cp_bg_line_b));
        } else {
            this.atc.setColor(ap.getColor(this.mSkinType, r.e.cp_bg_line_b));
        }
        if (this.atk) {
            canvas.drawRect(0.0f, this.atU[0] - this.atf, getMeasuredWidth(), this.atU[0], this.atc);
        }
        if (this.atj) {
            canvas.drawRect(0.0f, (this.atU[0] + this.atU[1]) - this.atf, getMeasuredWidth(), this.atU[0] + this.atU[1], this.atc);
        }
        if (this.atd == null) {
            this.atd = new Paint();
            this.atd.setStyle(Paint.Style.FILL);
        }
        if (this.ate > 0) {
            if (this.mSkinType == 0) {
                this.atd.setColor(getContext().getResources().getColor(this.ate));
            } else {
                this.atd.setColor(ap.getColor(this.mSkinType, this.ate));
            }
            if (this.atj) {
                i = (this.atU[0] + this.atU[1]) - this.atf;
            } else {
                i = this.atU[0] + this.atU[1];
            }
            canvas.drawRect(0.0f, this.atU[0], getMeasuredWidth(), i, this.atd);
        }
        super.dispatchDraw(canvas);
    }

    public void bC(boolean z) {
        this.atj = z;
    }

    public void bD(boolean z) {
        this.atk = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.ata.clear();
        this.atb.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(x xVar) {
        if (this.ath == 1) {
            if (xVar == null) {
                for (p pVar : this.ata) {
                    if (pVar instanceof View) {
                        ((View) pVar).setSelected(false);
                    }
                }
                return;
            }
            for (p pVar2 : this.ata) {
                if (pVar2 instanceof View) {
                    View view = (View) pVar2;
                    if (pVar2.getToolId() == xVar.id && xVar.atX) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ez(int i) {
        if (i == 2 && Cy() && this.ati != null) {
            this.ati.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eA = eA(i);
        if (eA != null) {
            if (eA.position == 5) {
                for (p pVar : this.ata) {
                    if (pVar.getToolId() == 2 || pVar.getToolId() == 1) {
                        pVar.lr();
                    } else {
                        pVar.hide();
                    }
                }
                for (a aVar : this.atb) {
                    if (aVar.atm != null) {
                        if (aVar.position == 5) {
                            aVar.atm.lr();
                        } else {
                            aVar.atm.hide();
                        }
                    }
                }
            } else {
                for (p pVar2 : this.ata) {
                    if (pVar2.getToolId() == 1) {
                        pVar2.hide();
                    } else {
                        if (pVar2 instanceof c) {
                            c cVar = (c) pVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        pVar2.lr();
                    }
                }
                for (a aVar2 : this.atb) {
                    if (aVar2.atm != null) {
                        if (aVar2.position == 5) {
                            aVar2.atm.hide();
                        } else {
                            aVar2.atm.lr();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eA(int i) {
        for (a aVar : this.atb) {
            if (aVar.atm != null && aVar.atm.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Cy() {
        for (a aVar : this.atb) {
            if (aVar.position == 5 && aVar.atm != null && (aVar.atm instanceof View) && ((View) aVar.atm).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public p eB(int i) {
        for (p pVar : this.ata) {
            if (pVar.getToolId() == i) {
                return pVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (p pVar : this.ata) {
            pVar.onChangeSkinType(i);
        }
        for (a aVar : this.atb) {
            if (aVar.atm != null) {
                aVar.atm.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.ate = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (p pVar : this.ata) {
            if (pVar != null && (pVar instanceof View)) {
                ((View) pVar).setEnabled(z);
            }
        }
    }

    public void c(boolean z, int i) {
        for (p pVar : this.ata) {
            if (pVar instanceof View) {
                View view = (View) pVar;
                if (pVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.ath = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean atl;
        protected y atm;
        protected int position;

        protected a(y yVar, int i, boolean z) {
            this.atl = false;
            this.atm = null;
            this.position = 0;
            this.atm = yVar;
            this.position = i;
            this.atl = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.ata != null && this.ata.size() != 0) {
            Iterator<p> it = this.ata.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
