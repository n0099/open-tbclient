package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.dl;
import com.baidu.tieba.frs.ds;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.u;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements g {
    private List<i> aLB;
    public int bQk;
    private final LinearLayout bQl;
    private final j bQm;
    private TabItemView bQn;
    private g bQo;
    private final int bQp;
    private final int bQq;
    private int bQr;
    private boolean bQs;
    private int bQt;
    private j.b bQu;
    private j.a bQv;
    private dl bQw;
    private a bQx;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void hA(int i);

        boolean hB(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        ds dsVar;
        int i = 0;
        if (hQ(tabItemView.getTabId())) {
            if (this.bQw != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                ds dsVar2 = new ds();
                dsVar2.bHh = tabItemView.getUrl();
                this.bQw.a(tabItemView.getTabId(), -1, dsVar2);
                return;
            }
            return;
        }
        this.bQn = tabItemView;
        int[] iArr = new int[2];
        this.bQn.getLocationOnScreen(iArr);
        int A = com.baidu.adp.lib.util.k.A(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(u.e.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (A < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.bQl.getChildCount(); i2++) {
            View childAt = this.bQl.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.bQn.getTabId() && !hQ(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.bQB);
                }
            }
        }
        if (this.bQn.getState() == TabItemView.bQB || this.bQn.getState() == TabItemView.bQD) {
            this.bQm.ZO();
            boolean z2 = this.bQn.getState() == TabItemView.bQB;
            this.bQn.setState(TabItemView.bQC);
            i hM = hM(this.bQn.getTabId());
            if (TextUtils.isEmpty(hM.url)) {
                dsVar = null;
            } else {
                ds dsVar3 = new ds();
                dsVar3.bHh = hM.url;
                dsVar3.stType = hM.name;
                dsVar = dsVar3;
            }
            if (hM.bQA != null && hM.bQA.bGR != null && hM.bQA.bGR.size() > 0) {
                for (dy dyVar : hM.bQA.bGR) {
                    if (dyVar != null && dyVar.isSelected) {
                        i = dyVar.bGN;
                    }
                }
            }
            if (z2 && this.bQw != null) {
                this.bQw.a(this.bQn.getTabId(), i, dsVar);
            }
        } else if (hN(this.bQn.getTabId()) && !z) {
            if (this.bQx == null || this.bQx.hB(this.bQn.getTabId())) {
                this.bQn.setState(TabItemView.bQD);
                this.bQm.a((Activity) getContext(), this, this.bQn, hM(this.bQn.getTabId()).bQA);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.bQk = 0;
        this.bQn = null;
        this.bQo = null;
        this.mPaint = new Paint();
        this.bQp = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds6);
        this.bQq = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds1);
        this.bQr = 0;
        this.bQs = true;
        this.bQt = u.d.common_color_10059;
        this.bQu = new com.baidu.tieba.frs.tab.a(this);
        this.bQv = new b(this);
        this.mOnClickListener = new c(this);
        this.bQl = new LinearLayout(activity);
        this.bQl.setOrientation(0);
        this.bQl.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(u.e.ds80));
        this.bQm = new j(activity, this.bQu, this.bQv);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQk = 0;
        this.bQn = null;
        this.bQo = null;
        this.mPaint = new Paint();
        this.bQp = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds6);
        this.bQq = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds1);
        this.bQr = 0;
        this.bQs = true;
        this.bQt = u.d.common_color_10059;
        this.bQu = new com.baidu.tieba.frs.tab.a(this);
        this.bQv = new b(this);
        this.mOnClickListener = new c(this);
        this.bQl = new LinearLayout(context);
        this.bQl.setOrientation(0);
        this.bQl.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(u.e.ds80));
        this.bQm = new j(context, this.bQu, this.bQv);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bQk = 0;
        this.bQn = null;
        this.bQo = null;
        this.mPaint = new Paint();
        this.bQp = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds6);
        this.bQq = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds1);
        this.bQr = 0;
        this.bQs = true;
        this.bQt = u.d.common_color_10059;
        this.bQu = new com.baidu.tieba.frs.tab.a(this);
        this.bQv = new b(this);
        this.mOnClickListener = new c(this);
        this.bQl = new LinearLayout(activity);
        this.bQl.setOrientation(0);
        this.bQl.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bQm = new j(activity, this.bQu, this.bQv);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bQl, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        av.l(this, u.d.common_color_10059);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean av(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i hM = hM(1);
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            i next = it.next();
            if (next != null && next.bug == 1) {
                iVar = next;
                break;
            }
        }
        if (hM == null || iVar == null) {
            return false;
        }
        if (hM.bQA == null && iVar.bQA == null) {
            return false;
        }
        if ((hM.bQA != null || iVar.bQA == null) && (iVar.bQA != null || hM.bQA == null)) {
            if (hM.bQA == null || iVar.bQA == null) {
                return false;
            }
            if (hM.bQA.bGR == null && iVar.bQA.bGR == null) {
                return false;
            }
            if ((hM.bQA.bGR != null || iVar.bQA.bGR == null) && (iVar.bQA.bGR != null || hM.bQA.bGR == null)) {
                int size = hM.bQA.bGR.size();
                if (size != iVar.bQA.bGR.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    dy dyVar = iVar.bQA.bGR.get(i);
                    dy dyVar2 = hM.bQA.bGR.get(i);
                    if (dyVar.bGN != dyVar2.bGN || !dyVar.name.equals(dyVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void setData(List<i> list) {
        a(list, 1, 4, false);
    }

    public void d(List<i> list, int i, int i2) {
        a(list, i, i2, false);
    }

    private void a(List<i> list, int i, int i2, boolean z) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
        } else if (this.aLB == null || av(list)) {
            this.aLB = list;
            this.bQl.removeAllViews();
            boolean z2 = this.bQr > 0 && list.size() == this.bQr;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(u.e.ds160);
            if (z2) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.A(getContext()) / this.bQr;
            }
            for (i iVar : list) {
                if (iVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
                    tabItemView.setOnClickListener(this.mOnClickListener);
                    if (hQ(iVar.bug)) {
                        av.j((View) tabItemView, u.d.cp_other_b);
                    }
                    this.bQl.addView(tabItemView, layoutParams);
                    if (iVar.bug == i) {
                        this.bQn = tabItemView;
                        tabItemView.setState(TabItemView.bQC);
                    }
                }
            }
        }
    }

    private i hM(int i) {
        if (i < 0 || this.aLB == null || this.aLB.size() == 0) {
            return null;
        }
        for (i iVar : this.aLB) {
            if (iVar != null && iVar.bug == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean hN(int i) {
        i hM = hM(i);
        return (hM == null || hM.bQA == null || hM.bQA.bGR == null || hM.bQA.bGR.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.bQo = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bQn != null) {
            this.mPaint.setColor(av.getColor(u.d.cp_bg_line_b));
            if (this.bQs) {
                canvas.drawRect(this.bQl.getLeft(), getMeasuredHeight() - this.bQq, this.bQl.getRight() > getRight() ? this.bQl.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(av.d((Resources) null, u.d.cp_link_tip_a));
            canvas.drawRect(this.bQn.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.bQp, (this.bQn.getRight() - getBottomLineMargin()) - this.bQn.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.bQn == null || this.bQk == 0) {
            return 0;
        }
        return ((this.bQn.getMeasuredWidth() - this.bQk) - this.bQn.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void hO(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bQl.getChildCount()) {
                View childAt = this.bQl.getChildAt(i3);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    if (tabItemView.getTabId() == i) {
                        a(tabItemView, true);
                    }
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void setDataLoadInterface(dl dlVar) {
        this.bQw = dlVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.bQx = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.bQx;
    }

    public void setTabBackgroudColor(int i) {
        this.bQt = i;
    }

    public void vm() {
        av.l(this, this.bQt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bQl.getChildCount()) {
                View childAt = this.bQl.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (hQ(((TabItemView) childAt).getTabId())) {
                        av.j(childAt, u.d.cp_other_b);
                    } else {
                        ((TabItemView) childAt).vm();
                    }
                }
                i = i2 + 1;
            } else {
                this.bQm.vm();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bQr = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void hP(int i) {
        if (this.bQn != null && this.bQw != null) {
            this.bQw.a(this.bQn.getTabId(), i, null);
        }
    }

    public static boolean hQ(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.bQs = z;
        invalidate();
    }
}
