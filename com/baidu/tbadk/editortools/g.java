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
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends y {
    private List<s> atq;
    private List<a> atr;
    private Paint ats;
    private Paint att;
    private int atu;
    private int atv;
    private int atw;
    private boolean atx;
    private int aty;
    private l atz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        this.atu = 0;
        this.atw = 0;
        this.atx = false;
        this.aty = 0;
        this.atz = lVar;
        init();
    }

    private void init() {
        this.atq = new LinkedList();
        this.atr = new LinkedList();
        this.ats = new Paint();
        this.att = new Paint();
        this.ats.setStyle(Paint.Style.FILL);
        this.att.setStyle(Paint.Style.FILL);
        this.atv = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.atq.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, s sVar) {
        this.atq.add(i, sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar, int i, boolean z) {
        this.atr.add(new a(abVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Di() {
        y.a aVar;
        bq(true);
        Iterator<s> it = this.atq.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aty == 1) {
                aVar = new y.a(cVar.getContext().getResources().getDimensionPixelSize(t.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(t.e.ds48), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds28);
            } else {
                aVar = new y.a(cVar.getContext().getResources().getDimensionPixelSize(t.e.pb_editor_button_width), cVar.getContext().getResources().getDimensionPixelSize(t.e.pb_editor_button_height), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds10);
            }
            aVar.eE(2);
            addView(cVar, aVar);
        }
        bq(false);
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
                    if (this.aty == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aty == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bq(boolean z) {
        y.a aVar;
        for (a aVar2 : this.atr) {
            View view = (View) aVar2.toolView;
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
                aVar.eE(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.eE(2);
                        break;
                    case 3:
                        aVar.eE(1);
                        break;
                    case 4:
                        aVar.eE(3);
                        break;
                    case 5:
                        aVar.eE(2);
                        view.setVisibility(8);
                        break;
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ats == null) {
            this.ats = new Paint();
            this.ats.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.ats.setColor(getContext().getResources().getColor(t.d.cp_bg_line_b));
        } else {
            this.ats.setColor(at.getColor(t.d.cp_bg_line_b));
        }
        if (this.atw == 1) {
            canvas.drawRect(0.0f, this.auq[0], getMeasuredWidth(), this.atv + this.auq[0], this.ats);
        } else if (this.atw == 2) {
            canvas.drawRect(0.0f, (this.auq[0] + this.auq[1]) - this.atv, getMeasuredWidth(), this.auq[0] + this.auq[1], this.ats);
        }
        if (this.att == null) {
            this.att = new Paint();
            this.att.setStyle(Paint.Style.FILL);
        }
        if (this.atu > 0) {
            if (this.mSkinType == 0) {
                this.att.setColor(getContext().getResources().getColor(this.atu));
            } else {
                this.att.setColor(at.getColor(this.atu));
            }
            canvas.drawRect(0.0f, this.auq[0], getMeasuredWidth(), this.auq[0] + this.auq[1], this.att);
        }
        super.dispatchDraw(canvas);
    }

    public void setLinePosition(int i) {
        this.atw = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.atq.clear();
        this.atr.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(aa aaVar) {
        if (this.aty == 1) {
            if (aaVar == null) {
                for (s sVar : this.atq) {
                    if (sVar instanceof View) {
                        ((View) sVar).setSelected(false);
                    }
                }
                return;
            }
            for (s sVar2 : this.atq) {
                if (sVar2 instanceof View) {
                    View view = (View) sVar2;
                    if (sVar2.getToolId() == aaVar.id && aaVar.isLauncherCanSelect) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ey(int i) {
        if (i == 2 && Dj() && this.atz != null) {
            this.atz.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ez = ez(i);
        if (ez != null) {
            if (ez.position == 5) {
                for (s sVar : this.atq) {
                    if (sVar.getToolId() == 2 || sVar.getToolId() == 1) {
                        sVar.op();
                    } else {
                        sVar.hide();
                    }
                }
                for (a aVar : this.atr) {
                    if (aVar.toolView != null) {
                        if (aVar.position == 5) {
                            aVar.toolView.op();
                        } else {
                            aVar.toolView.hide();
                        }
                    }
                }
            } else {
                for (s sVar2 : this.atq) {
                    if (sVar2.getToolId() == 1) {
                        sVar2.hide();
                    } else {
                        if (sVar2 instanceof c) {
                            c cVar = (c) sVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        sVar2.op();
                    }
                }
                for (a aVar2 : this.atr) {
                    if (aVar2.toolView != null) {
                        if (aVar2.position == 5) {
                            aVar2.toolView.hide();
                        } else {
                            aVar2.toolView.op();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ez(int i) {
        for (a aVar : this.atr) {
            if (aVar.toolView != null && aVar.toolView.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Dj() {
        for (a aVar : this.atr) {
            if (aVar.position == 5 && aVar.toolView != null && (aVar.toolView instanceof View) && ((View) aVar.toolView).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public s eA(int i) {
        for (s sVar : this.atq) {
            if (sVar.getToolId() == i) {
                return sVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (s sVar : this.atq) {
            sVar.onChangeSkinType(i);
        }
        for (a aVar : this.atr) {
            if (aVar.toolView != null) {
                aVar.toolView.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.atu = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (s sVar : this.atq) {
            if (sVar != null && (sVar instanceof View)) {
                ((View) sVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aty = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean atA;
        protected int position;
        protected ab toolView;

        protected a(ab abVar, int i, boolean z) {
            this.atA = false;
            this.toolView = null;
            this.position = 0;
            this.toolView = abVar;
            this.position = i;
            this.atA = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(View.OnClickListener onClickListener) {
        if (this.atq != null && this.atq.size() != 0) {
            Iterator<s> it = this.atq.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
