package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends w {
    private int aqA;
    private boolean aqB;
    private int aqC;
    private k aqD;
    private List<r> aqu;
    private List<a> aqv;
    private Paint aqw;
    private Paint aqx;
    private int aqy;
    private int aqz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, k kVar) {
        super(context);
        this.mSkinType = 0;
        this.aqy = 0;
        this.aqA = 0;
        this.aqB = false;
        this.aqC = 0;
        this.aqD = kVar;
        init();
    }

    private void init() {
        this.aqu = new LinkedList();
        this.aqv = new LinkedList();
        this.aqw = new Paint();
        this.aqx = new Paint();
        this.aqw.setStyle(Paint.Style.FILL);
        this.aqx.setStyle(Paint.Style.FILL);
        this.aqz = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        this.aqu.add(rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, r rVar) {
        this.aqu.add(i, rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(z zVar, int i, boolean z) {
        this.aqv.add(new a(zVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bv() {
        w.a aVar;
        bj(true);
        Iterator<r> it = this.aqu.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.aqC == 1) {
                aVar = new w.a(cVar.getContext().getResources().getDimensionPixelSize(n.d.ds48), cVar.getContext().getResources().getDimensionPixelSize(n.d.ds48), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(n.d.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(n.d.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(n.d.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(n.d.ds28);
            } else {
                aVar = new w.a(cVar.getContext().getResources().getDimensionPixelSize(n.d.pb_editor_button_width), cVar.getContext().getResources().getDimensionPixelSize(n.d.pb_editor_button_height), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(n.d.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(n.d.ds10);
            }
            aVar.ek(2);
            addView(cVar, aVar);
        }
        bj(false);
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
                    if (this.aqC == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.aqC == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bj(boolean z) {
        w.a aVar;
        for (a aVar2 : this.aqv) {
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
                aVar.ek(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.ek(2);
                        break;
                    case 3:
                        aVar.ek(1);
                        break;
                    case 4:
                        aVar.ek(3);
                        break;
                    case 5:
                        aVar.ek(2);
                        view.setVisibility(8);
                        break;
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.aqw == null) {
            this.aqw = new Paint();
            this.aqw.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aqw.setColor(getContext().getResources().getColor(n.c.cp_bg_line_b));
        } else {
            this.aqw.setColor(as.getColor(n.c.cp_bg_line_b));
        }
        if (this.aqA == 1) {
            canvas.drawRect(0.0f, this.art[0], getMeasuredWidth(), this.aqz + this.art[0], this.aqw);
        } else if (this.aqA == 2) {
            canvas.drawRect(0.0f, (this.art[0] + this.art[1]) - this.aqz, getMeasuredWidth(), this.art[0] + this.art[1], this.aqw);
        }
        if (this.aqx == null) {
            this.aqx = new Paint();
            this.aqx.setStyle(Paint.Style.FILL);
        }
        if (this.aqy > 0) {
            if (this.mSkinType == 0) {
                this.aqx.setColor(getContext().getResources().getColor(this.aqy));
            } else {
                this.aqx.setColor(as.getColor(this.aqy));
            }
            canvas.drawRect(0.0f, this.art[0], getMeasuredWidth(), this.art[0] + this.art[1], this.aqx);
        }
        super.dispatchDraw(canvas);
    }

    public void setLinePosition(int i) {
        this.aqA = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.aqu.clear();
        this.aqv.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar) {
        if (this.aqC == 1) {
            if (yVar == null) {
                for (r rVar : this.aqu) {
                    if (rVar instanceof View) {
                        ((View) rVar).setSelected(false);
                    }
                }
                return;
            }
            for (r rVar2 : this.aqu) {
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
    public void ee(int i) {
        if (i == 2 && Bw() && this.aqD != null) {
            this.aqD.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ef = ef(i);
        if (ef != null) {
            if (ef.position == 5) {
                for (r rVar : this.aqu) {
                    if (rVar.getToolId() == 2 || rVar.getToolId() == 1) {
                        rVar.oD();
                    } else {
                        rVar.hide();
                    }
                }
                for (a aVar : this.aqv) {
                    if (aVar.toolView != null) {
                        if (aVar.position == 5) {
                            aVar.toolView.oD();
                        } else {
                            aVar.toolView.hide();
                        }
                    }
                }
            } else {
                for (r rVar2 : this.aqu) {
                    if (rVar2.getToolId() == 1) {
                        rVar2.hide();
                    } else {
                        if (rVar2 instanceof c) {
                            c cVar = (c) rVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        rVar2.oD();
                    }
                }
                for (a aVar2 : this.aqv) {
                    if (aVar2.toolView != null) {
                        if (aVar2.position == 5) {
                            aVar2.toolView.hide();
                        } else {
                            aVar2.toolView.oD();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ef(int i) {
        for (a aVar : this.aqv) {
            if (aVar.toolView != null && aVar.toolView.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Bw() {
        for (a aVar : this.aqv) {
            if (aVar.position == 5 && aVar.toolView != null && (aVar.toolView instanceof View) && ((View) aVar.toolView).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public r eg(int i) {
        for (r rVar : this.aqu) {
            if (rVar.getToolId() == i) {
                return rVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (r rVar : this.aqu) {
            rVar.onChangeSkinType(i);
        }
        for (a aVar : this.aqv) {
            if (aVar.toolView != null) {
                aVar.toolView.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.aqy = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (r rVar : this.aqu) {
            if (rVar != null && (rVar instanceof View)) {
                ((View) rVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.aqC = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean aqE;
        protected int position;
        protected z toolView;

        protected a(z zVar, int i, boolean z) {
            this.aqE = false;
            this.toolView = null;
            this.position = 0;
            this.toolView = zVar;
            this.position = i;
            this.aqE = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View.OnClickListener onClickListener) {
        if (this.aqu != null && this.aqu.size() != 0) {
            Iterator<r> it = this.aqu.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
