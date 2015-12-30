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
    private List<r> arY;
    private List<a> arZ;
    private Paint asa;
    private Paint asb;
    private int asc;
    private int asd;
    private int ase;
    private boolean asf;
    private int asg;
    private k ash;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context, k kVar) {
        super(context);
        this.mSkinType = 0;
        this.asc = 0;
        this.ase = 0;
        this.asf = false;
        this.asg = 0;
        this.ash = kVar;
        init();
    }

    private void init() {
        this.arY = new LinkedList();
        this.arZ = new LinkedList();
        this.asa = new Paint();
        this.asb = new Paint();
        this.asa.setStyle(Paint.Style.FILL);
        this.asb.setStyle(Paint.Style.FILL);
        this.asd = com.baidu.adp.lib.util.k.dip2px(getContext(), 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(r rVar) {
        this.arY.add(rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, r rVar) {
        this.arY.add(i, rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(z zVar, int i, boolean z) {
        this.arZ.add(new a(zVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bk() {
        w.a aVar;
        bj(true);
        Iterator<r> it = this.arY.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (this.asg == 1) {
                aVar = new w.a(cVar.getContext().getResources().getDimensionPixelSize(n.e.ds48), cVar.getContext().getResources().getDimensionPixelSize(n.e.ds48), 48);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(n.e.ds30);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(n.e.ds30);
                aVar.topMargin = cVar.getContext().getResources().getDimensionPixelSize(n.e.ds18);
                aVar.bottomMargin = cVar.getContext().getResources().getDimensionPixelSize(n.e.ds28);
            } else {
                aVar = new w.a(cVar.getContext().getResources().getDimensionPixelSize(n.e.pb_editor_button_width), cVar.getContext().getResources().getDimensionPixelSize(n.e.pb_editor_button_height), 16);
                aVar.leftMargin = cVar.getContext().getResources().getDimensionPixelSize(n.e.ds10);
                aVar.rightMargin = cVar.getContext().getResources().getDimensionPixelSize(n.e.ds10);
            }
            aVar.ee(2);
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
                    if (this.asg == 1) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getRight();
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.asg == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.k.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.k.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void bj(boolean z) {
        w.a aVar;
        for (a aVar2 : this.arZ) {
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
                aVar.ee(2);
                addView(view, aVar);
            } else if (!z && aVar2.position != 1) {
                switch (aVar2.position) {
                    case 2:
                        aVar.ee(2);
                        break;
                    case 3:
                        aVar.ee(1);
                        break;
                    case 4:
                        aVar.ee(3);
                        break;
                    case 5:
                        aVar.ee(2);
                        view.setVisibility(8);
                        break;
                }
                addView(view, aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.asa == null) {
            this.asa = new Paint();
            this.asa.setStyle(Paint.Style.FILL);
        }
        if (this.mSkinType == 0) {
            this.asa.setColor(getContext().getResources().getColor(n.d.cp_bg_line_b));
        } else {
            this.asa.setColor(as.getColor(n.d.cp_bg_line_b));
        }
        if (this.ase == 1) {
            canvas.drawRect(0.0f, this.asX[0], getMeasuredWidth(), this.asd + this.asX[0], this.asa);
        } else if (this.ase == 2) {
            canvas.drawRect(0.0f, (this.asX[0] + this.asX[1]) - this.asd, getMeasuredWidth(), this.asX[0] + this.asX[1], this.asa);
        }
        if (this.asb == null) {
            this.asb = new Paint();
            this.asb.setStyle(Paint.Style.FILL);
        }
        if (this.asc > 0) {
            if (this.mSkinType == 0) {
                this.asb.setColor(getContext().getResources().getColor(this.asc));
            } else {
                this.asb.setColor(as.getColor(this.asc));
            }
            canvas.drawRect(0.0f, this.asX[0], getMeasuredWidth(), this.asX[0] + this.asX[1], this.asb);
        }
        super.dispatchDraw(canvas);
    }

    public void setLinePosition(int i) {
        this.ase = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.arY.clear();
        this.arZ.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(y yVar) {
        if (this.asg == 1) {
            if (yVar == null) {
                for (r rVar : this.arY) {
                    if (rVar instanceof View) {
                        ((View) rVar).setSelected(false);
                    }
                }
                return;
            }
            for (r rVar2 : this.arY) {
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
    public void dY(int i) {
        if (i == 2 && Bl() && this.ash != null) {
            this.ash.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a dZ = dZ(i);
        if (dZ != null) {
            if (dZ.position == 5) {
                for (r rVar : this.arY) {
                    if (rVar.getToolId() == 2 || rVar.getToolId() == 1) {
                        rVar.ob();
                    } else {
                        rVar.hide();
                    }
                }
                for (a aVar : this.arZ) {
                    if (aVar.toolView != null) {
                        if (aVar.position == 5) {
                            aVar.toolView.ob();
                        } else {
                            aVar.toolView.hide();
                        }
                    }
                }
            } else {
                for (r rVar2 : this.arY) {
                    if (rVar2.getToolId() == 1) {
                        rVar2.hide();
                    } else {
                        if (rVar2 instanceof c) {
                            c cVar = (c) rVar2;
                            if (cVar.getVisibility() == 8 && cVar.getIsOutSetVisibility()) {
                                cVar.hide();
                            }
                        }
                        rVar2.ob();
                    }
                }
                for (a aVar2 : this.arZ) {
                    if (aVar2.toolView != null) {
                        if (aVar2.position == 5) {
                            aVar2.toolView.hide();
                        } else {
                            aVar2.toolView.ob();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a dZ(int i) {
        for (a aVar : this.arZ) {
            if (aVar.toolView != null && aVar.toolView.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean Bl() {
        for (a aVar : this.arZ) {
            if (aVar.position == 5 && aVar.toolView != null && (aVar.toolView instanceof View) && ((View) aVar.toolView).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public r ea(int i) {
        for (r rVar : this.arY) {
            if (rVar.getToolId() == i) {
                return rVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        for (r rVar : this.arY) {
            rVar.onChangeSkinType(i);
        }
        for (a aVar : this.arZ) {
            if (aVar.toolView != null) {
                aVar.toolView.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.asc = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (r rVar : this.arY) {
            if (rVar != null && (rVar instanceof View)) {
                ((View) rVar).setEnabled(z);
            }
        }
    }

    public void setBarLauncherType(int i) {
        this.asg = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class a {
        protected boolean asi;
        protected int position;
        protected z toolView;

        protected a(z zVar, int i, boolean z) {
            this.asi = false;
            this.toolView = null;
            this.position = 0;
            this.toolView = zVar;
            this.position = i;
            this.asi = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(View.OnClickListener onClickListener) {
        if (this.arY != null && this.arY.size() != 0) {
            Iterator<r> it = this.arY.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }
}
