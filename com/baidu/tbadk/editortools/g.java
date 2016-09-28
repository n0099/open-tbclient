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
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g extends y {
    private int atA;
    private int atB;
    private boolean atC;
    private int atD;
    private l atE;
    private boolean atF;
    private boolean atG;
    private List<s> atw;
    private List<a> atx;
    private Paint aty;
    private Paint atz;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        this.atA = 0;
        this.atC = false;
        this.atD = 0;
        this.atF = false;
        this.atG = false;
        this.atE = lVar;
        init();
    }

    private void init() {
        this.atw = new LinkedList();
        this.atx = new LinkedList();
        this.aty = new Paint();
        this.atz = new Paint();
        this.aty.setStyle(Paint.Style.FILL);
        this.atz.setStyle(Paint.Style.FILL);
        this.atB = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.atw.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, s sVar) {
        this.atw.add(i, sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar, int i, boolean z) {
        this.atx.add(new a(abVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CH() {
        y.a aVar;
        bx(true);
        Iterator<s> it = this.atw.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.atD == 1) {
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
            aVar.eA(2);
            addView(cVar, aVar);
        }
        bx(false);
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
                    if (this.atD == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.atD == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bx(boolean z) {
        y.a aVar;
        for (a aVar2 : this.atx) {
            View view = (View) aVar2.atI;
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
        if (this.aty == null) {
            this.aty = new Paint();
            this.aty.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.aty.setColor(getContext().getResources().getColor(r.d.cp_bg_line_b));
        } else {
            this.aty.setColor(av.getColor(this.mSkinType, r.d.cp_bg_line_b));
        }
        if (this.atG) {
            canvas.drawRect(0.0f, this.auy[0] - this.atB, getMeasuredWidth(), this.auy[0], this.aty);
        }
        if (this.atF) {
            canvas.drawRect(0.0f, (this.auy[0] + this.auy[1]) - this.atB, getMeasuredWidth(), this.auy[0] + this.auy[1], this.aty);
        }
        if (this.atz == null) {
            this.atz = new Paint();
            this.atz.setStyle(Paint.Style.FILL);
        }
        if (this.atA > 0) {
            if (this.mSkinType == 0) {
                this.atz.setColor(getContext().getResources().getColor(this.atA));
            } else {
                this.atz.setColor(av.getColor(this.mSkinType, this.atA));
            }
            if (this.atF) {
                i = (this.auy[0] + this.auy[1]) - this.atB;
            } else {
                i = this.auy[0] + this.auy[1];
            }
            canvas.drawRect(0.0f, this.auy[0], getMeasuredWidth(), i, this.atz);
        }
        super.dispatchDraw(canvas);
    }

    public void by(boolean z) {
        this.atF = z;
    }

    public void bz(boolean z) {
        this.atG = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.atw.clear();
        this.atx.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(aa aaVar) {
        if (this.atD == 1) {
            if (aaVar == null) {
                for (s sVar : this.atw) {
                    if (sVar instanceof View) {
                        ((View) sVar).setSelected(false);
                    }
                }
                return;
            }
            for (s sVar2 : this.atw) {
                if (sVar2 instanceof View) {
                    View view = (View) sVar2;
                    if (sVar2.getToolId() == aaVar.id && aaVar.auB) {
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
        if (i == 2 && CI() && this.atE != null) {
            this.atE.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ev = ev(i);
        if (ev != null) {
            if (ev.position == 5) {
                for (s sVar : this.atw) {
                    if (sVar.getToolId() == 2 || sVar.getToolId() == 1) {
                        sVar.lw();
                    } else {
                        sVar.hide();
                    }
                }
                for (a aVar : this.atx) {
                    if (aVar.atI != null) {
                        if (aVar.position == 5) {
                            aVar.atI.lw();
                        } else {
                            aVar.atI.hide();
                        }
                    }
                }
            } else {
                for (s sVar2 : this.atw) {
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
                for (a aVar2 : this.atx) {
                    if (aVar2.atI != null) {
                        if (aVar2.position == 5) {
                            aVar2.atI.hide();
                        } else {
                            aVar2.atI.lw();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ev(int i) {
        for (a aVar : this.atx) {
            if (aVar.atI != null && aVar.atI.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean CI() {
        for (a aVar : this.atx) {
            if (aVar.position == 5 && aVar.atI != null && (aVar.atI instanceof View) && ((View) aVar.atI).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public s ew(int i) {
        for (s sVar : this.atw) {
            if (sVar.getToolId() == i) {
                return sVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (s sVar : this.atw) {
            sVar.onChangeSkinType(i);
        }
        for (a aVar : this.atx) {
            if (aVar.atI != null) {
                aVar.atI.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.atA = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (s sVar : this.atw) {
            if (sVar != null && (sVar instanceof View)) {
                ((View) sVar).setEnabled(z);
            }
        }
    }

    public void c(boolean z, int i) {
        for (s sVar : this.atw) {
            if (sVar instanceof View) {
                View view = (View) sVar;
                if (sVar.getToolId() == i) {
                    view.setEnabled(z);
                }
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.atD = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean atH;
        protected ab atI;
        protected int position;

        protected a(ab abVar, int i, boolean z) {
            this.atH = false;
            this.atI = null;
            this.position = 0;
            this.atI = abVar;
            this.position = i;
            this.atH = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.atw != null && this.atw.size() != 0) {
            Iterator<s> it = this.atw.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
