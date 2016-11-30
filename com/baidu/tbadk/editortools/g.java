package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends y {
    private boolean auA;
    private List<s> auq;
    private List<a> aur;
    private Paint aus;
    private Paint aut;
    private int auu;
    private int auv;
    private boolean auw;
    private int aux;
    private l auy;
    private boolean auz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        this.auu = 0;
        this.auw = false;
        this.aux = 0;
        this.auz = false;
        this.auA = false;
        this.auy = lVar;
        init();
    }

    private void init() {
        this.auq = new LinkedList();
        this.aur = new LinkedList();
        this.aus = new Paint();
        this.aut = new Paint();
        this.aus.setStyle(Paint.Style.FILL);
        this.aut.setStyle(Paint.Style.FILL);
        this.auv = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.auq.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, s sVar) {
        this.auq.add(i, sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar, int i, boolean z) {
        this.aur.add(new a(abVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CP() {
        y.a aVar;
        bB(true);
        Iterator<s> it = this.auq.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aux == 1) {
                aVar = new y.a(cVar.getContext().getResources().getDimensionPixelSize(r.e.ds60), cVar.getContext().getResources().getDimensionPixelSize(r.e.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds28);
            } else {
                aVar = new y.a(cVar.getContext().getResources().getDimensionPixelSize(r.e.ds76), cVar.getContext().getResources().getDimensionPixelSize(r.e.ds76), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(r.e.ds10);
            }
            aVar.eD(2);
            addView(cVar, aVar);
        }
        bB(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.y, android.view.View
    public void onMeasure(int i, int i2) {
        TextView notice;
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof c) && (notice = ((c) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                if (((y.a) notice.getLayoutParams()) == null) {
                    generateDefaultLayoutParams();
                }
                measureChildWithMargins(notice, i, 0, i2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.y, android.view.ViewGroup, android.view.View
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
                    if (this.aux == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aux == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bB(boolean z) {
        y.a aVar;
        for (a aVar2 : this.aur) {
            View view = (View) aVar2.auC;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                aVar = new y.a(-2, -2, 19);
            } else if (layoutParams instanceof y.a) {
                aVar = (y.a) layoutParams;
            } else {
                aVar = new y.a(view.getLayoutParams());
                aVar.gravity = 19;
            }
            if (z && aVar2.position == 1) {
                aVar.eD(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eD(2);
                        break;
                    case 3:
                        aVar.eD(1);
                        break;
                    case 4:
                        aVar.eD(3);
                        break;
                    case 5:
                        aVar.eD(2);
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
        if (this.aus == null) {
            this.aus = new Paint();
            this.aus.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aus.setColor(getContext().getResources().getColor(r.d.cp_bg_line_b));
        } else {
            this.aus.setColor(at.getColor(this.mSkinType, r.d.cp_bg_line_b));
        }
        if (this.auA) {
            canvas.drawRect(0.0f, this.avs[0] - this.auv, getMeasuredWidth(), this.avs[0], this.aus);
        }
        if (this.auz) {
            canvas.drawRect(0.0f, (this.avs[0] + this.avs[1]) - this.auv, getMeasuredWidth(), this.avs[0] + this.avs[1], this.aus);
        }
        if (this.aut == null) {
            this.aut = new Paint();
            this.aut.setStyle(Paint.Style.FILL);
        }
        if (this.auu > 0) {
            if (this.mSkinType == 0) {
                this.aut.setColor(getContext().getResources().getColor(this.auu));
            } else {
                this.aut.setColor(at.getColor(this.mSkinType, this.auu));
            }
            if (this.auz) {
                i = (this.avs[0] + this.avs[1]) - this.auv;
            } else {
                i = this.avs[0] + this.avs[1];
            }
            canvas.drawRect(0.0f, this.avs[0], getMeasuredWidth(), i, this.aut);
        }
        super.dispatchDraw(canvas);
    }

    public void bC(boolean z) {
        this.auz = z;
    }

    public void bD(boolean z) {
        this.auA = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.auq.clear();
        this.aur.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(aa aaVar) {
        if (this.aux == 1) {
            if (aaVar == null) {
                for (s sVar : this.auq) {
                    if (sVar instanceof View) {
                        ((View) sVar).setSelected(false);
                    }
                }
                return;
            }
            for (s sVar2 : this.auq) {
                if (sVar2 instanceof View) {
                    View view = (View) sVar2;
                    if (sVar2.getToolId() == aaVar.id && aaVar.avv) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ex(int i) {
        if (i == 2 && CQ() && this.auy != null) {
            this.auy.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ey = ey(i);
        if (ey != null) {
            if (ey.position == 5) {
                for (s sVar : this.auq) {
                    if (sVar.getToolId() == 2 || sVar.getToolId() == 1) {
                        sVar.lz();
                    } else {
                        sVar.hide();
                    }
                }
                for (a aVar : this.aur) {
                    if (aVar.auC != null) {
                        if (aVar.position == 5) {
                            aVar.auC.lz();
                        } else {
                            aVar.auC.hide();
                        }
                    }
                }
            } else {
                for (s sVar2 : this.auq) {
                    if (sVar2.getToolId() == 1) {
                        sVar2.hide();
                    } else {
                        if (sVar2 instanceof c) {
                            c cVar = (c) sVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        sVar2.lz();
                    }
                }
                for (a aVar2 : this.aur) {
                    if (aVar2.auC != null) {
                        if (aVar2.position == 5) {
                            aVar2.auC.hide();
                        } else {
                            aVar2.auC.lz();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ey(int i) {
        for (a aVar : this.aur) {
            if (aVar.auC != null && aVar.auC.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CQ() {
        for (a aVar : this.aur) {
            if (aVar.position == 5 && aVar.auC != null && (aVar.auC instanceof View) && ((View) aVar.auC).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public s ez(int i) {
        for (s sVar : this.auq) {
            if (sVar.getToolId() == i) {
                return sVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (s sVar : this.auq) {
            sVar.onChangeSkinType(i);
        }
        for (a aVar : this.aur) {
            if (aVar.auC != null) {
                aVar.auC.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.auu = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (s sVar : this.auq) {
            if (sVar != null && (sVar instanceof View)) {
                ((View) sVar).setEnabled(z);
            }
        }
    }

    public void c(boolean z, int i) {
        for (s sVar : this.auq) {
            if (sVar instanceof View) {
                View view = (View) sVar;
                if (sVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aux = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean auB;
        protected ab auC;
        protected int position;

        protected a(ab abVar, int i, boolean z) {
            this.auB = false;
            this.auC = null;
            this.position = 0;
            this.auC = abVar;
            this.position = i;
            this.auB = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(View.OnClickListener onClickListener) {
        if (this.auq != null && this.auq.size() != 0) {
            Iterator<s> it = this.auq.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
