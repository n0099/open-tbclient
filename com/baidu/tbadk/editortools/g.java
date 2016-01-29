package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends w {
    private List<r> asR;
    private List<a> asS;
    private Paint asT;
    private Paint asU;
    private int asV;
    private int asW;
    private int asX;
    private boolean asY;
    private int asZ;
    private k ata;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, k kVar) {
        super(context);
        this.mSkinType = 0;
        this.asV = 0;
        this.asX = 0;
        this.asY = false;
        this.asZ = 0;
        this.ata = kVar;
        init();
    }

    private void init() {
        this.asR = new LinkedList();
        this.asS = new LinkedList();
        this.asT = new Paint();
        this.asU = new Paint();
        this.asT.setStyle(Paint.Style.FILL);
        this.asU.setStyle(Paint.Style.FILL);
        this.asW = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        this.asR.add(rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, r rVar) {
        this.asR.add(i, rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(z zVar, int i, boolean z) {
        this.asS.add(new a(zVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CA() {
        w.a aVar;
        bl(true);
        Iterator<r> it = this.asR.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.asZ == 1) {
                aVar = new w.a(cVar.getContext().getResources().getDimensionPixelSize(t.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(t.e.ds48), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds28);
            } else {
                aVar = new w.a(cVar.getContext().getResources().getDimensionPixelSize(t.e.pb_editor_button_width), cVar.getContext().getResources().getDimensionPixelSize(t.e.pb_editor_button_height), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(t.e.ds10);
            }
            aVar.ez(2);
            addView(cVar, aVar);
        }
        bl(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.w, android.view.View
    public void onMeasure(int i, int i2) {
        TextView notice;
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof c) && (notice = ((c) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                if (((w.a) notice.getLayoutParams()) == null) {
                    generateDefaultLayoutParams();
                }
                measureChildWithMargins(notice, i, 0, i2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.w, android.view.ViewGroup, android.view.View
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
                    if (this.asZ == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.asZ == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bl(boolean z) {
        w.a aVar;
        for (a aVar2 : this.asS) {
            View view = (View) aVar2.toolView;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                aVar = new w.a(-2, -2, 19);
            } else if (layoutParams instanceof w.a) {
                aVar = (w.a) layoutParams;
            } else {
                aVar = new w.a(view.getLayoutParams());
                aVar.gravity = 19;
            }
            if (z && aVar2.position == 1) {
                aVar.ez(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.ez(2);
                        break;
                    case 3:
                        aVar.ez(1);
                        break;
                    case 4:
                        aVar.ez(3);
                        break;
                    case 5:
                        aVar.ez(2);
                        view.setVisibility(8);
                        break;
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.asT == null) {
            this.asT = new Paint();
            this.asT.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.asT.setColor(getContext().getResources().getColor(t.d.cp_bg_line_b));
        } else {
            this.asT.setColor(ar.getColor(t.d.cp_bg_line_b));
        }
        if (this.asX == 1) {
            canvas.drawRect(0.0f, this.atQ[0], getMeasuredWidth(), this.asW + this.atQ[0], this.asT);
        } else if (this.asX == 2) {
            canvas.drawRect(0.0f, (this.atQ[0] + this.atQ[1]) - this.asW, getMeasuredWidth(), this.atQ[0] + this.atQ[1], this.asT);
        }
        if (this.asU == null) {
            this.asU = new Paint();
            this.asU.setStyle(Paint.Style.FILL);
        }
        if (this.asV > 0) {
            if (this.mSkinType == 0) {
                this.asU.setColor(getContext().getResources().getColor(this.asV));
            } else {
                this.asU.setColor(ar.getColor(this.asV));
            }
            canvas.drawRect(0.0f, this.atQ[0], getMeasuredWidth(), this.atQ[0] + this.atQ[1], this.asU);
        }
        super.dispatchDraw(canvas);
    }

    public void setLinePosition(int i) {
        this.asX = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.asR.clear();
        this.asS.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar) {
        if (this.asZ == 1) {
            if (yVar == null) {
                for (r rVar : this.asR) {
                    if (rVar instanceof View) {
                        ((View) rVar).setSelected(false);
                    }
                }
                return;
            }
            for (r rVar2 : this.asR) {
                if (rVar2 instanceof View) {
                    View view = (View) rVar2;
                    if (rVar2.getToolId() == yVar.id && yVar.isLauncherCanSelect) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void et(int i) {
        if (i == 2 && CB() && this.ata != null) {
            this.ata.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a eu = eu(i);
        if (eu != null) {
            if (eu.position == 5) {
                for (r rVar : this.asR) {
                    if (rVar.getToolId() == 2 || rVar.getToolId() == 1) {
                        rVar.ow();
                    } else {
                        rVar.hide();
                    }
                }
                for (a aVar : this.asS) {
                    if (aVar.toolView != null) {
                        if (aVar.position == 5) {
                            aVar.toolView.ow();
                        } else {
                            aVar.toolView.hide();
                        }
                    }
                }
            } else {
                for (r rVar2 : this.asR) {
                    if (rVar2.getToolId() == 1) {
                        rVar2.hide();
                    } else {
                        if (rVar2 instanceof c) {
                            c cVar = (c) rVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        rVar2.ow();
                    }
                }
                for (a aVar2 : this.asS) {
                    if (aVar2.toolView != null) {
                        if (aVar2.position == 5) {
                            aVar2.toolView.hide();
                        } else {
                            aVar2.toolView.ow();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a eu(int i) {
        for (a aVar : this.asS) {
            if (aVar.toolView != null && aVar.toolView.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CB() {
        for (a aVar : this.asS) {
            if (aVar.position == 5 && aVar.toolView != null && (aVar.toolView instanceof View) && ((View) aVar.toolView).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public r ev(int i) {
        for (r rVar : this.asR) {
            if (rVar.getToolId() == i) {
                return rVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (r rVar : this.asR) {
            rVar.onChangeSkinType(i);
        }
        for (a aVar : this.asS) {
            if (aVar.toolView != null) {
                aVar.toolView.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.asV = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (r rVar : this.asR) {
            if (rVar != null && (rVar instanceof View)) {
                ((View) rVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.asZ = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean atb;
        protected int position;
        protected z toolView;

        protected a(z zVar, int i, boolean z) {
            this.atb = false;
            this.toolView = null;
            this.position = 0;
            this.toolView = zVar;
            this.position = i;
            this.atb = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(View.OnClickListener onClickListener) {
        if (this.asR != null && this.asR.size() != 0) {
            Iterator<r> it = this.asR.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
