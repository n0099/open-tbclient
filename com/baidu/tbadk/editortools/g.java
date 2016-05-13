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
    private List<s> apg;
    private List<a> aph;
    private Paint api;
    private Paint apj;
    private int apk;
    private int apl;
    private int apm;
    private boolean apn;
    private int apo;
    private l apq;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        this.apk = 0;
        this.apm = 0;
        this.apn = false;
        this.apo = 0;
        this.apq = lVar;
        init();
    }

    private void init() {
        this.apg = new LinkedList();
        this.aph = new LinkedList();
        this.api = new Paint();
        this.apj = new Paint();
        this.api.setStyle(Paint.Style.FILL);
        this.apj.setStyle(Paint.Style.FILL);
        this.apl = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(s sVar) {
        this.apg.add(sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, s sVar) {
        this.apg.add(i, sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ab abVar, int i, boolean z) {
        this.aph.add(new a(abVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bd() {
        y.a aVar;
        bw(true);
        Iterator<s> it = this.apg.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.apo == 1) {
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
            aVar.ej(2);
            addView(cVar, aVar);
        }
        bw(false);
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
                    if (this.apo == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.apo == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bw(boolean z) {
        y.a aVar;
        for (a aVar2 : this.aph) {
            View view = (View) aVar2.aps;
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
                aVar.ej(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.ej(2);
                        break;
                    case 3:
                        aVar.ej(1);
                        break;
                    case 4:
                        aVar.ej(3);
                        break;
                    case 5:
                        aVar.ej(2);
                        view.setVisibility(8);
                        break;
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.api == null) {
            this.api = new Paint();
            this.api.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.api.setColor(getContext().getResources().getColor(t.d.cp_bg_line_b));
        } else {
            this.api.setColor(at.getColor(t.d.cp_bg_line_b));
        }
        if (this.apm == 1) {
            canvas.drawRect(0.0f, this.aqj[0], getMeasuredWidth(), this.apl + this.aqj[0], this.api);
        } else if (this.apm == 2) {
            canvas.drawRect(0.0f, (this.aqj[0] + this.aqj[1]) - this.apl, getMeasuredWidth(), this.aqj[0] + this.aqj[1], this.api);
        }
        if (this.apj == null) {
            this.apj = new Paint();
            this.apj.setStyle(Paint.Style.FILL);
        }
        if (this.apk > 0) {
            if (this.mSkinType == 0) {
                this.apj.setColor(getContext().getResources().getColor(this.apk));
            } else {
                this.apj.setColor(at.getColor(this.apk));
            }
            canvas.drawRect(0.0f, this.aqj[0], getMeasuredWidth(), this.aqj[0] + this.aqj[1], this.apj);
        }
        super.dispatchDraw(canvas);
    }

    public void setLinePosition(int i) {
        this.apm = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.apg.clear();
        this.aph.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(aa aaVar) {
        if (this.apo == 1) {
            if (aaVar == null) {
                for (s sVar : this.apg) {
                    if (sVar instanceof View) {
                        ((View) sVar).setSelected(false);
                    }
                }
                return;
            }
            for (s sVar2 : this.apg) {
                if (sVar2 instanceof View) {
                    View view = (View) sVar2;
                    if (sVar2.getToolId() == aaVar.id && aaVar.aqm) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ed(int i) {
        if (i == 2 && Be() && this.apq != null) {
            this.apq.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a ee = ee(i);
        if (ee != null) {
            if (ee.position == 5) {
                for (s sVar : this.apg) {
                    if (sVar.getToolId() == 2 || sVar.getToolId() == 1) {
                        sVar.kC();
                    } else {
                        sVar.hide();
                    }
                }
                for (a aVar : this.aph) {
                    if (aVar.aps != null) {
                        if (aVar.position == 5) {
                            aVar.aps.kC();
                        } else {
                            aVar.aps.hide();
                        }
                    }
                }
            } else {
                for (s sVar2 : this.apg) {
                    if (sVar2.getToolId() == 1) {
                        sVar2.hide();
                    } else {
                        if (sVar2 instanceof c) {
                            c cVar = (c) sVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        sVar2.kC();
                    }
                }
                for (a aVar2 : this.aph) {
                    if (aVar2.aps != null) {
                        if (aVar2.position == 5) {
                            aVar2.aps.hide();
                        } else {
                            aVar2.aps.kC();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a ee(int i) {
        for (a aVar : this.aph) {
            if (aVar.aps != null && aVar.aps.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Be() {
        for (a aVar : this.aph) {
            if (aVar.position == 5 && aVar.aps != null && (aVar.aps instanceof View) && ((View) aVar.aps).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public s ef(int i) {
        for (s sVar : this.apg) {
            if (sVar.getToolId() == i) {
                return sVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (s sVar : this.apg) {
            sVar.onChangeSkinType(i);
        }
        for (a aVar : this.aph) {
            if (aVar.aps != null) {
                aVar.aps.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.apk = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (s sVar : this.apg) {
            if (sVar != null && (sVar instanceof View)) {
                ((View) sVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.apo = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean apr;
        protected ab aps;
        protected int position;

        protected a(ab abVar, int i, boolean z) {
            this.apr = false;
            this.aps = null;
            this.position = 0;
            this.aps = abVar;
            this.position = i;
            this.apr = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(View.OnClickListener onClickListener) {
        if (this.apg != null && this.apg.size() != 0) {
            Iterator<s> it = this.apg.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
