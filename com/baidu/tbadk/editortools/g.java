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
import com.baidu.tieba.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends y {
    private List<s> apW;
    private List<a> apX;
    private Paint apY;
    private Paint apZ;
    private int aqa;
    private int aqb;
    private boolean aqc;
    private int aqd;
    private l aqe;
    private boolean aqf;
    private boolean aqg;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        this.aqa = 0;
        this.aqc = false;
        this.aqd = 0;
        this.aqf = false;
        this.aqg = false;
        this.aqe = lVar;
        init();
    }

    private void init() {
        this.apW = new LinkedList();
        this.apX = new LinkedList();
        this.apY = new Paint();
        this.apZ = new Paint();
        this.apY.setStyle(Paint.Style.FILL);
        this.apZ.setStyle(Paint.Style.FILL);
        this.aqb = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.apW.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, s sVar) {
        this.apW.add(i, sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar, int i, boolean z) {
        this.apX.add(new a(abVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bm() {
        y.a aVar;
        bt(true);
        Iterator<s> it = this.apW.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aqd == 1) {
                aVar = new y.a(cVar.getContext().getResources().getDimensionPixelSize(u.e.ds60), cVar.getContext().getResources().getDimensionPixelSize(u.e.ds60), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(u.e.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(u.e.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(u.e.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(u.e.ds28);
            } else {
                aVar = new y.a(cVar.getContext().getResources().getDimensionPixelSize(u.e.ds76), cVar.getContext().getResources().getDimensionPixelSize(u.e.ds76), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(u.e.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(u.e.ds10);
            }
            aVar.en(2);
            addView(cVar, aVar);
        }
        bt(false);
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
                    if (this.aqd == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aqd == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bt(boolean z) {
        y.a aVar;
        for (a aVar2 : this.apX) {
            View view = (View) aVar2.aqi;
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
                aVar.en(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.en(2);
                        break;
                    case 3:
                        aVar.en(1);
                        break;
                    case 4:
                        aVar.en(3);
                        break;
                    case 5:
                        aVar.en(2);
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
        if (this.apY == null) {
            this.apY = new Paint();
            this.apY.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.apY.setColor(getContext().getResources().getColor(u.d.cp_bg_line_b));
        } else {
            this.apY.setColor(av.getColor(u.d.cp_bg_line_b));
        }
        if (this.aqg) {
            canvas.drawRect(0.0f, this.aqZ[0] - this.aqb, getMeasuredWidth(), this.aqZ[0], this.apY);
        }
        if (this.aqf) {
            canvas.drawRect(0.0f, (this.aqZ[0] + this.aqZ[1]) - this.aqb, getMeasuredWidth(), this.aqZ[0] + this.aqZ[1], this.apY);
        }
        if (this.apZ == null) {
            this.apZ = new Paint();
            this.apZ.setStyle(Paint.Style.FILL);
        }
        if (this.aqa > 0) {
            if (this.mSkinType == 0) {
                this.apZ.setColor(getContext().getResources().getColor(this.aqa));
            } else {
                this.apZ.setColor(av.getColor(this.aqa));
            }
            if (this.aqf) {
                i = (this.aqZ[0] + this.aqZ[1]) - this.aqb;
            } else {
                i = this.aqZ[0] + this.aqZ[1];
            }
            canvas.drawRect(0.0f, this.aqZ[0], getMeasuredWidth(), i, this.apZ);
        }
        super.dispatchDraw(canvas);
    }

    public void bu(boolean z) {
        this.aqf = z;
    }

    public void bv(boolean z) {
        this.aqg = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.apW.clear();
        this.apX.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(aa aaVar) {
        if (this.aqd == 1) {
            if (aaVar == null) {
                for (s sVar : this.apW) {
                    if (sVar instanceof View) {
                        ((View) sVar).setSelected(false);
                    }
                }
                return;
            }
            for (s sVar2 : this.apW) {
                if (sVar2 instanceof View) {
                    View view = (View) sVar2;
                    if (sVar2.getToolId() == aaVar.id && aaVar.arc) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eh(int i) {
        if (i == 2 && Bn() && this.aqe != null) {
            this.aqe.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ei = ei(i);
        if (ei != null) {
            if (ei.position == 5) {
                for (s sVar : this.apW) {
                    if (sVar.getToolId() == 2 || sVar.getToolId() == 1) {
                        sVar.kF();
                    } else {
                        sVar.hide();
                    }
                }
                for (a aVar : this.apX) {
                    if (aVar.aqi != null) {
                        if (aVar.position == 5) {
                            aVar.aqi.kF();
                        } else {
                            aVar.aqi.hide();
                        }
                    }
                }
            } else {
                for (s sVar2 : this.apW) {
                    if (sVar2.getToolId() == 1) {
                        sVar2.hide();
                    } else {
                        if (sVar2 instanceof c) {
                            c cVar = (c) sVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        sVar2.kF();
                    }
                }
                for (a aVar2 : this.apX) {
                    if (aVar2.aqi != null) {
                        if (aVar2.position == 5) {
                            aVar2.aqi.hide();
                        } else {
                            aVar2.aqi.kF();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ei(int i) {
        for (a aVar : this.apX) {
            if (aVar.aqi != null && aVar.aqi.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Bn() {
        for (a aVar : this.apX) {
            if (aVar.position == 5 && aVar.aqi != null && (aVar.aqi instanceof View) && ((View) aVar.aqi).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public s ej(int i) {
        for (s sVar : this.apW) {
            if (sVar.getToolId() == i) {
                return sVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (s sVar : this.apW) {
            sVar.onChangeSkinType(i);
        }
        for (a aVar : this.apX) {
            if (aVar.aqi != null) {
                aVar.aqi.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aqa = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (s sVar : this.apW) {
            if (sVar != null && (sVar instanceof View)) {
                ((View) sVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aqd = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aqh;
        protected ab aqi;
        protected int position;

        protected a(ab abVar, int i, boolean z) {
            this.aqh = false;
            this.aqi = null;
            this.position = 0;
            this.aqi = abVar;
            this.position = i;
            this.aqh = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(View.OnClickListener onClickListener) {
        if (this.apW != null && this.apW.size() != 0) {
            Iterator<s> it = this.apW.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
