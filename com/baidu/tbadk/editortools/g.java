package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends y {
    private List<s> atS;
    private List<a> atT;
    private Paint atU;
    private Paint atV;
    private int atW;
    private int atX;
    private boolean atY;
    private int atZ;
    private l aua;
    private boolean aub;
    private boolean auc;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        this.atW = 0;
        this.atY = false;
        this.atZ = 0;
        this.aub = false;
        this.auc = false;
        this.aua = lVar;
        init();
    }

    private void init() {
        this.atS = new LinkedList();
        this.atT = new LinkedList();
        this.atU = new Paint();
        this.atV = new Paint();
        this.atU.setStyle(Paint.Style.FILL);
        this.atV.setStyle(Paint.Style.FILL);
        this.atX = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.atS.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, s sVar) {
        this.atS.add(i, sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar, int i, boolean z) {
        this.atT.add(new a(abVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CH() {
        y.a aVar;
        by(true);
        Iterator<s> it = this.atS.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.atZ == 1) {
                aVar = new y.a(cVar.getContext().getResources().getDimensionPixelSize(t.e.ds60), cVar.getContext().getResources().getDimensionPixelSize(t.e.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds28);
            } else {
                aVar = new y.a(cVar.getContext().getResources().getDimensionPixelSize(t.e.ds76), cVar.getContext().getResources().getDimensionPixelSize(t.e.ds76), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds10);
            }
            aVar.eB(2);
            addView(cVar, aVar);
        }
        by(false);
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
                    if (this.atZ == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.atZ == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void by(boolean z) {
        y.a aVar;
        for (a aVar2 : this.atT) {
            View view = (View) aVar2.aue;
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
                aVar.eB(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eB(2);
                        break;
                    case 3:
                        aVar.eB(1);
                        break;
                    case 4:
                        aVar.eB(3);
                        break;
                    case 5:
                        aVar.eB(2);
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
        if (this.atU == null) {
            this.atU = new Paint();
            this.atU.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.atU.setColor(getContext().getResources().getColor(t.d.cp_bg_line_b));
        } else {
            this.atU.setColor(av.getColor(this.mSkinType, t.d.cp_bg_line_b));
        }
        if (this.auc) {
            canvas.drawRect(0.0f, this.auV[0] - this.atX, getMeasuredWidth(), this.auV[0], this.atU);
        }
        if (this.aub) {
            canvas.drawRect(0.0f, (this.auV[0] + this.auV[1]) - this.atX, getMeasuredWidth(), this.auV[0] + this.auV[1], this.atU);
        }
        if (this.atV == null) {
            this.atV = new Paint();
            this.atV.setStyle(Paint.Style.FILL);
        }
        if (this.atW > 0) {
            if (this.mSkinType == 0) {
                this.atV.setColor(getContext().getResources().getColor(this.atW));
            } else {
                this.atV.setColor(av.getColor(this.mSkinType, this.atW));
            }
            if (this.aub) {
                i = (this.auV[0] + this.auV[1]) - this.atX;
            } else {
                i = this.auV[0] + this.auV[1];
            }
            canvas.drawRect(0.0f, this.auV[0], getMeasuredWidth(), i, this.atV);
        }
        super.dispatchDraw(canvas);
    }

    public void bz(boolean z) {
        this.aub = z;
    }

    public void bA(boolean z) {
        this.auc = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.atS.clear();
        this.atT.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(aa aaVar) {
        if (this.atZ == 1) {
            if (aaVar == null) {
                for (s sVar : this.atS) {
                    if (sVar instanceof View) {
                        ((View) sVar).setSelected(false);
                    }
                }
                return;
            }
            for (s sVar2 : this.atS) {
                if (sVar2 instanceof View) {
                    View view = (View) sVar2;
                    if (sVar2.getToolId() == aaVar.id && aaVar.auY) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ev(int i) {
        if (i == 2 && CI() && this.aua != null) {
            this.aua.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ew = ew(i);
        if (ew != null) {
            if (ew.position == 5) {
                for (s sVar : this.atS) {
                    if (sVar.getToolId() == 2 || sVar.getToolId() == 1) {
                        sVar.lw();
                    } else {
                        sVar.hide();
                    }
                }
                for (a aVar : this.atT) {
                    if (aVar.aue != null) {
                        if (aVar.position == 5) {
                            aVar.aue.lw();
                        } else {
                            aVar.aue.hide();
                        }
                    }
                }
            } else {
                for (s sVar2 : this.atS) {
                    if (sVar2.getToolId() == 1) {
                        sVar2.hide();
                    } else {
                        if (sVar2 instanceof c) {
                            c cVar = (c) sVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        sVar2.lw();
                    }
                }
                for (a aVar2 : this.atT) {
                    if (aVar2.aue != null) {
                        if (aVar2.position == 5) {
                            aVar2.aue.hide();
                        } else {
                            aVar2.aue.lw();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ew(int i) {
        for (a aVar : this.atT) {
            if (aVar.aue != null && aVar.aue.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CI() {
        for (a aVar : this.atT) {
            if (aVar.position == 5 && aVar.aue != null && (aVar.aue instanceof View) && ((View) aVar.aue).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public s ex(int i) {
        for (s sVar : this.atS) {
            if (sVar.getToolId() == i) {
                return sVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (s sVar : this.atS) {
            sVar.onChangeSkinType(i);
        }
        for (a aVar : this.atT) {
            if (aVar.aue != null) {
                aVar.aue.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.atW = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (s sVar : this.atS) {
            if (sVar != null && (sVar instanceof View)) {
                ((View) sVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.atZ = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aud;
        protected ab aue;
        protected int position;

        protected a(ab abVar, int i, boolean z) {
            this.aud = false;
            this.aue = null;
            this.position = 0;
            this.aue = abVar;
            this.position = i;
            this.aud = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(View.OnClickListener onClickListener) {
        if (this.atS != null && this.atS.size() != 0) {
            Iterator<s> it = this.atS.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
