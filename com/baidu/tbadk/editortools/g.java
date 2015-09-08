package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.u;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends u {
    private List<p> apX;
    private List<a> apY;
    private Paint apZ;
    private Paint aqa;
    private int aqb;
    private int aqc;
    private int aqd;
    private boolean aqe;
    private int aqf;
    private j aqg;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, j jVar) {
        super(context);
        this.mSkinType = 0;
        this.aqb = 0;
        this.aqd = 0;
        this.aqe = false;
        this.aqf = 0;
        this.aqg = jVar;
        init();
    }

    private void init() {
        this.apX = new LinkedList();
        this.apY = new LinkedList();
        this.apZ = new Paint();
        this.aqa = new Paint();
        this.apZ.setStyle(Paint.Style.FILL);
        this.aqa.setStyle(Paint.Style.FILL);
        this.aqc = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar) {
        this.apX.add(pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, p pVar) {
        this.apX.add(i, pVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(w wVar, int i, boolean z) {
        this.apY.add(new a(wVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void AM() {
        u.a aVar;
        bh(true);
        Iterator<p> it = this.apX.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aqf == 1) {
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
            aVar.dV(2);
            addView(cVar, aVar);
        }
        bh(false);
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
                    if (this.aqf == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aqf == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bh(boolean z) {
        u.a aVar;
        for (a aVar2 : this.apY) {
            View view = (View) aVar2.aqi;
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
                aVar.dV(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.dV(2);
                        break;
                    case 3:
                        aVar.dV(1);
                        break;
                    case 4:
                        aVar.dV(3);
                        break;
                    case 5:
                        aVar.dV(2);
                        view.setVisibility(8);
                        break;
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.apZ == null) {
            this.apZ = new Paint();
            this.apZ.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.apZ.setColor(getContext().getResources().getColor(i.c.cp_bg_line_b));
        } else {
            this.apZ.setColor(al.getColor(i.c.cp_bg_line_b));
        }
        if (this.aqd == 1) {
            canvas.drawRect(0.0f, this.aqO[0], getMeasuredWidth(), this.aqc + this.aqO[0], this.apZ);
        } else if (this.aqd == 2) {
            canvas.drawRect(0.0f, (this.aqO[0] + this.aqO[1]) - this.aqc, getMeasuredWidth(), this.aqO[0] + this.aqO[1], this.apZ);
        }
        if (this.aqa == null) {
            this.aqa = new Paint();
            this.aqa.setStyle(Paint.Style.FILL);
        }
        if (this.aqb > 0) {
            if (this.mSkinType == 0) {
                this.aqa.setColor(getContext().getResources().getColor(this.aqb));
            } else {
                this.aqa.setColor(al.getColor(this.aqb));
            }
            canvas.drawRect(0.0f, this.aqO[0], getMeasuredWidth(), this.aqO[0] + this.aqO[1], this.aqa);
        }
        super.dispatchDraw(canvas);
    }

    public void setLinePosition(int i) {
        this.aqd = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.apX.clear();
        this.apY.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(v vVar) {
        if (this.aqf == 1) {
            if (vVar == null) {
                for (p pVar : this.apX) {
                    if (pVar instanceof View) {
                        ((View) pVar).setSelected(false);
                    }
                }
                return;
            }
            for (p pVar2 : this.apX) {
                if (pVar2 instanceof View) {
                    View view = (View) pVar2;
                    if (pVar2.getToolId() == vVar.id && vVar.aqR) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dP(int i) {
        if (i == 2 && AN() && this.aqg != null) {
            this.aqg.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a dQ = dQ(i);
        if (dQ != null) {
            if (dQ.position == 5) {
                for (p pVar : this.apX) {
                    if (pVar.getToolId() == 2 || pVar.getToolId() == 1) {
                        pVar.ov();
                    } else {
                        pVar.hide();
                    }
                }
                for (a aVar : this.apY) {
                    if (aVar.aqi != null) {
                        if (aVar.position == 5) {
                            aVar.aqi.ov();
                        } else {
                            aVar.aqi.hide();
                        }
                    }
                }
            } else {
                for (p pVar2 : this.apX) {
                    if (pVar2.getToolId() == 1) {
                        pVar2.hide();
                    } else {
                        pVar2.ov();
                    }
                }
                for (a aVar2 : this.apY) {
                    if (aVar2.aqi != null) {
                        if (aVar2.position == 5) {
                            aVar2.aqi.hide();
                        } else {
                            aVar2.aqi.ov();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a dQ(int i) {
        for (a aVar : this.apY) {
            if (aVar.aqi != null && aVar.aqi.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean AN() {
        for (a aVar : this.apY) {
            if (aVar.position == 5 && aVar.aqi != null && (aVar.aqi instanceof View) && ((View) aVar.aqi).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public p dR(int i) {
        for (p pVar : this.apX) {
            if (pVar.getToolId() == i) {
                return pVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (p pVar : this.apX) {
            pVar.onChangeSkinType(i);
        }
        for (a aVar : this.apY) {
            if (aVar.aqi != null) {
                aVar.aqi.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aqb = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (p pVar : this.apX) {
            if (pVar != null && (pVar instanceof View)) {
                ((View) pVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aqf = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aqh;
        protected w aqi;
        protected int position;

        protected a(w wVar, int i, boolean z) {
            this.aqh = false;
            this.aqi = null;
            this.position = 0;
            this.aqi = wVar;
            this.position = i;
            this.aqh = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View.OnClickListener onClickListener) {
        if (this.apX != null && this.apX.size() != 0) {
            Iterator<p> it = this.apX.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
