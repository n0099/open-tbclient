package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.editortools.RawLayout;
import com.baidu.tieba.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class EditorBar extends RawLayout {
    private Paint bdK;
    private List<h> eKn;
    private List<a> eKo;
    private Paint eKp;
    private int eKq;
    private int eKr;
    private EditorTools eKs;
    private boolean eKt;
    private boolean eKu;
    private boolean eKv;
    private int mBgColor;
    private int mInterval;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditorBar(Context context, EditorTools editorTools) {
        super(context);
        this.mSkinType = 0;
        this.mBgColor = 0;
        this.eKr = 0;
        this.eKt = false;
        this.eKu = false;
        this.eKv = true;
        this.eKs = editorTools;
        init(context);
    }

    private void init(Context context) {
        setClipToPadding(false);
        this.eKn = new LinkedList();
        this.eKo = new LinkedList();
        this.eKp = new Paint();
        this.bdK = new Paint();
        setPadding(getResources().getDimensionPixelSize(R.dimen.ds20), 0, getResources().getDimensionPixelSize(R.dimen.ds20), 0);
        this.eKp.setStyle(Paint.Style.FILL);
        this.bdK.setStyle(Paint.Style.FILL);
        this.eKq = getResources().getDimensionPixelSize(R.dimen.ds1);
        this.mInterval = ((com.baidu.adp.lib.util.l.getEquipmentWidth(context) - com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds64)) - (com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds48) * 6)) / 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar) {
        this.eKn.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, h hVar) {
        this.eKn.add(i, hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar, int i, boolean z) {
        this.eKo.add(new a(nVar, i, z));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void build() {
        RawLayout.LayoutParams layoutParams;
        if (!y.isEmpty(this.eKn) || this.eKr == 4) {
            jg(true);
            for (int i = 0; i < this.eKn.size(); i++) {
                h hVar = this.eKn.get(i);
                if (hVar instanceof BLauncher) {
                    BLauncher bLauncher = (BLauncher) hVar;
                    if (this.eKr == 2) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else if (this.eKr == 3) {
                        layoutParams = new RawLayout.LayoutParams(0, bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), 48);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds32);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.weight = 1.0f;
                    } else if (this.eKr == 1) {
                        layoutParams = new RawLayout.LayoutParams(bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds48), bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds60), 48);
                        if (i == 0) {
                            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds12);
                        }
                        if (i != this.eKn.size() - 1) {
                            layoutParams.rightMargin = this.mInterval;
                        }
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    } else if (this.eKr == 5) {
                        layoutParams = new RawLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds48), 80);
                        layoutParams.leftMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44);
                        layoutParams.rightMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds78);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                        layoutParams.bottomMargin = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds21);
                    } else {
                        layoutParams = new RawLayout.LayoutParams(-2, -2, 80);
                        layoutParams.leftMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        layoutParams.rightMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds7);
                        layoutParams.bottomMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                        layoutParams.topMargin = bLauncher.getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
                    }
                    layoutParams.qg(2);
                    addView(bLauncher, layoutParams);
                }
            }
            jg(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.RawLayout, android.view.View
    public void onMeasure(int i, int i2) {
        TextView notice;
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof BLauncher) && (notice = ((BLauncher) childAt).getNotice()) != null && notice.getVisibility() != 8) {
                if (((RawLayout.LayoutParams) notice.getLayoutParams()) == null) {
                    generateDefaultLayoutParams();
                }
                measureChildWithMargins(notice, i, 0, i2, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.editortools.RawLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int right;
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt instanceof BLauncher) {
                TextView notice = ((BLauncher) childAt).getNotice();
                BLauncher bLauncher = (BLauncher) childAt;
                if (notice != null && bLauncher.getDrawable() != null) {
                    int intrinsicWidth = bLauncher.getDrawable().getIntrinsicWidth();
                    int intrinsicHeight = bLauncher.getDrawable().getIntrinsicHeight();
                    int measuredWidth = (childAt.getMeasuredWidth() - intrinsicWidth) / 2;
                    int measuredHeight = (childAt.getMeasuredHeight() - intrinsicHeight) / 2;
                    if (this.eKr == 1 || this.eKr == 3 || this.eKr == 2) {
                        if (TextUtils.isEmpty(notice.getText())) {
                            right = childAt.getLeft() + (childAt.getMeasuredWidth() / 2) + (intrinsicWidth / 2);
                        } else {
                            right = (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f);
                        }
                    } else {
                        right = this.eKr == 0 ? (childAt.getRight() - measuredWidth) - com.baidu.adp.lib.util.l.dip2px(getContext(), 9.0f) : 0;
                    }
                    int top = (childAt.getTop() + measuredHeight) - com.baidu.adp.lib.util.l.dip2px(getContext(), 4.0f);
                    notice.layout(right, top, notice.getMeasuredWidth() + right, notice.getMeasuredHeight() + top);
                }
            }
        }
    }

    private void jg(boolean z) {
        RawLayout.LayoutParams layoutParams;
        for (a aVar : this.eKo) {
            View view = (View) aVar.eKx;
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = new RawLayout.LayoutParams(-1, -2, 19);
            } else if (layoutParams2 instanceof RawLayout.LayoutParams) {
                layoutParams = (RawLayout.LayoutParams) layoutParams2;
            } else {
                layoutParams = new RawLayout.LayoutParams(view.getLayoutParams());
                layoutParams.gravity = 19;
            }
            if (z && aVar.position == 1) {
                layoutParams.qg(2);
                addView(view, layoutParams);
            } else if (!z && aVar.position != 1) {
                switch (aVar.position) {
                    case 2:
                        layoutParams.qg(2);
                        break;
                    case 3:
                        layoutParams.qg(1);
                        break;
                    case 4:
                        layoutParams.qg(3);
                        break;
                    case 5:
                        layoutParams.qg(2);
                        view.setVisibility(8);
                        break;
                }
                if (((n) view).getToolId() == 8) {
                    ap.setBackgroundResource(this, R.color.common_color_10055);
                    view.setBackgroundColor(getResources().getColor(R.color.white_alpha0));
                }
                addView(view, layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int i;
        if (this.eKp == null) {
            this.eKp = new Paint();
            this.eKp.setStyle(Paint.Style.FILL);
        }
        this.eKp.setColor(ap.getColor(this.mSkinType, R.color.cp_bg_line_h));
        if (this.eKv) {
            if (this.eKu) {
                canvas.drawRect(0.0f, this.eLi[0] - this.eKq, getMeasuredWidth(), this.eLi[0], this.eKp);
            }
            if (this.eKt) {
                canvas.drawRect(0.0f, (this.eLi[0] + this.eLi[1]) - this.eKq, getMeasuredWidth(), this.eLi[0] + this.eLi[1], this.eKp);
            }
        }
        if (this.bdK == null) {
            this.bdK = new Paint();
            this.bdK.setStyle(Paint.Style.FILL);
        }
        if (this.mBgColor > 0) {
            if (this.mSkinType == 0) {
                this.bdK.setColor(getContext().getResources().getColor(this.mBgColor));
            } else {
                this.bdK.setColor(ap.getColor(this.mSkinType, this.mBgColor));
            }
            if (this.eKt && this.eKv) {
                i = (this.eLi[0] + this.eLi[1]) - this.eKq;
            } else {
                i = this.eLi[0] + this.eLi[1];
            }
            canvas.drawRect(0.0f, this.eLi[0], getMeasuredWidth(), i, this.bdK);
        }
        super.dispatchDraw(canvas);
    }

    public void jh(boolean z) {
        this.eKt = z;
    }

    public void ji(boolean z) {
        this.eKu = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clear() {
        this.eKn.clear();
        this.eKo.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar) {
        if (this.eKr == 1) {
            if (mVar == null) {
                for (h hVar : this.eKn) {
                    if (hVar instanceof View) {
                        ((View) hVar).setSelected(false);
                    }
                }
                return;
            }
            for (h hVar2 : this.eKn) {
                if (hVar2 instanceof View) {
                    View view = (View) hVar2;
                    if (hVar2.getToolId() == mVar.id && mVar.eLp) {
                        view.setSelected(true);
                    } else {
                        view.setSelected(false);
                    }
                }
            }
        } else if (this.eKr == 3 || this.eKr == 2 || this.eKr == 5) {
            if (mVar == null) {
                for (h hVar3 : this.eKn) {
                    if (hVar3 instanceof View) {
                        ((View) hVar3).setSelected(false);
                    }
                }
            } else if (mVar.id == 5 || mVar.id == 2 || mVar.id == 6) {
                for (h hVar4 : this.eKn) {
                    if (hVar4 instanceof View) {
                        View view2 = (View) hVar4;
                        if (hVar4.getToolId() == mVar.id && mVar.eLp) {
                            view2.setSelected(true);
                        } else {
                            view2.setSelected(false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pZ(int i) {
        if (i == 2 && brw() && this.eKs != null) {
            this.eKs.b(new com.baidu.tbadk.editortools.a(1, 3, null));
            return;
        }
        a qa = qa(i);
        if (qa != null) {
            if (qa.position == 5) {
                for (h hVar : this.eKn) {
                    if (hVar.getToolId() == 2 || hVar.getToolId() == 1) {
                        hVar.display();
                    } else {
                        hVar.hide();
                    }
                }
                for (a aVar : this.eKo) {
                    if (aVar.eKx != null) {
                        if (aVar.position == 5) {
                            aVar.eKx.display();
                        } else {
                            aVar.eKx.hide();
                        }
                    }
                }
            } else {
                for (h hVar2 : this.eKn) {
                    if (hVar2.getToolId() == 1) {
                        hVar2.hide();
                    } else {
                        if (hVar2 instanceof BLauncher) {
                            BLauncher bLauncher = (BLauncher) hVar2;
                            if (bLauncher.getVisibility() == 8 && bLauncher.getIsOutSetVisibility()) {
                                bLauncher.hide();
                            }
                        }
                        hVar2.display();
                    }
                }
                for (a aVar2 : this.eKo) {
                    if (aVar2.eKx != null) {
                        if (aVar2.position == 5) {
                            aVar2.eKx.hide();
                        } else {
                            aVar2.eKx.display();
                        }
                    }
                }
            }
            invalidate();
        }
    }

    private a qa(int i) {
        for (a aVar : this.eKo) {
            if (aVar.eKx != null && aVar.eKx.getToolId() == i) {
                return aVar;
            }
        }
        return null;
    }

    private boolean brw() {
        for (a aVar : this.eKo) {
            if (aVar.position == 5 && aVar.eKx != null && (aVar.eKx instanceof View) && ((View) aVar.eKx).getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public h qb(int i) {
        for (h hVar : this.eKn) {
            if (hVar.getToolId() == i) {
                return hVar;
            }
        }
        return null;
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ap.setBackgroundColor(this, this.mBgColor);
        for (h hVar : this.eKn) {
            hVar.onChangeSkinType(i);
        }
        for (a aVar : this.eKo) {
            if (aVar.eKx != null) {
                aVar.eKx.onChangeSkinType(i);
            }
        }
        invalidate();
    }

    public void setBackgroundColorId(int i) {
        this.mBgColor = i;
    }

    public void setBarLauncherEnabled(boolean z) {
        for (h hVar : this.eKn) {
            if (hVar != null && (hVar instanceof View)) {
                ((View) hVar).setEnabled(z);
            }
        }
    }

    public boolean t(boolean z, int i) {
        for (h hVar : this.eKn) {
            if (hVar instanceof View) {
                View view = (View) hVar;
                if (hVar.getToolId() == i) {
                    view.setEnabled(z);
                    return true;
                }
            }
        }
        return false;
    }

    public void setBarLauncherType(int i) {
        this.eKr = i;
    }

    public int getBarLauncherType() {
        return this.eKr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class a {
        protected boolean eKw;
        protected n eKx;
        protected int position;

        protected a(n nVar, int i, boolean z) {
            this.eKw = false;
            this.eKx = null;
            this.position = 0;
            this.eKx = nVar;
            this.position = i;
            this.eKw = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(View.OnClickListener onClickListener) {
        if (this.eKn != null && this.eKn.size() != 0) {
            Iterator<h> it = this.eKn.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(onClickListener);
            }
        }
    }

    public View qc(int i) {
        for (h hVar : this.eKn) {
            if (hVar instanceof View) {
                View view = (View) hVar;
                if (hVar.getToolId() == i) {
                    return view;
                }
            }
        }
        return null;
    }
}
