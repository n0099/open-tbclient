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
    private List<i> aMv;
    public int bSi;
    private final LinearLayout bSj;
    private final j bSk;
    private TabItemView bSl;
    private g bSm;
    private final int bSn;
    private final int bSo;
    private int bSp;
    private boolean bSq;
    private int bSr;
    private j.b bSs;
    private j.a bSt;
    private dl bSu;
    private a bSv;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        boolean hA(int i);

        void hz(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        ds dsVar;
        int i = 0;
        if (hR(tabItemView.getTabId())) {
            if (this.bSu != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                ds dsVar2 = new ds();
                dsVar2.bID = tabItemView.getUrl();
                this.bSu.a(tabItemView.getTabId(), -1, dsVar2);
                return;
            }
            return;
        }
        this.bSl = tabItemView;
        int[] iArr = new int[2];
        this.bSl.getLocationOnScreen(iArr);
        int A = com.baidu.adp.lib.util.k.A(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(u.e.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (A < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.bSj.getChildCount(); i2++) {
            View childAt = this.bSj.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.bSl.getTabId() && !hR(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.bSz);
                }
            }
        }
        if (this.bSl.getState() == TabItemView.bSz || this.bSl.getState() == TabItemView.bSB) {
            this.bSk.aaq();
            boolean z2 = this.bSl.getState() == TabItemView.bSz;
            this.bSl.setState(TabItemView.bSA);
            i hN = hN(this.bSl.getTabId());
            if (TextUtils.isEmpty(hN.url)) {
                dsVar = null;
            } else {
                ds dsVar3 = new ds();
                dsVar3.bID = hN.url;
                dsVar3.stType = hN.name;
                dsVar = dsVar3;
            }
            if (hN.bSy != null && hN.bSy.bIn != null && hN.bSy.bIn.size() > 0) {
                for (dy dyVar : hN.bSy.bIn) {
                    if (dyVar != null && dyVar.isSelected) {
                        i = dyVar.bIj;
                    }
                }
            }
            if (z2 && this.bSu != null) {
                this.bSu.a(this.bSl.getTabId(), i, dsVar);
            }
        } else if (hO(this.bSl.getTabId()) && !z) {
            if (this.bSv == null || this.bSv.hA(this.bSl.getTabId())) {
                this.bSl.setState(TabItemView.bSB);
                this.bSk.a((Activity) getContext(), this, this.bSl, hN(this.bSl.getTabId()).bSy);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.bSi = 0;
        this.bSl = null;
        this.bSm = null;
        this.mPaint = new Paint();
        this.bSn = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds6);
        this.bSo = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds1);
        this.bSp = 0;
        this.bSq = true;
        this.bSr = u.d.common_color_10059;
        this.bSs = new com.baidu.tieba.frs.tab.a(this);
        this.bSt = new b(this);
        this.mOnClickListener = new c(this);
        this.bSj = new LinearLayout(activity);
        this.bSj.setOrientation(0);
        this.bSj.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(u.e.ds80));
        this.bSk = new j(activity, this.bSs, this.bSt);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bSi = 0;
        this.bSl = null;
        this.bSm = null;
        this.mPaint = new Paint();
        this.bSn = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds6);
        this.bSo = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds1);
        this.bSp = 0;
        this.bSq = true;
        this.bSr = u.d.common_color_10059;
        this.bSs = new com.baidu.tieba.frs.tab.a(this);
        this.bSt = new b(this);
        this.mOnClickListener = new c(this);
        this.bSj = new LinearLayout(context);
        this.bSj.setOrientation(0);
        this.bSj.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(u.e.ds80));
        this.bSk = new j(context, this.bSs, this.bSt);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bSi = 0;
        this.bSl = null;
        this.bSm = null;
        this.mPaint = new Paint();
        this.bSn = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds6);
        this.bSo = TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds1);
        this.bSp = 0;
        this.bSq = true;
        this.bSr = u.d.common_color_10059;
        this.bSs = new com.baidu.tieba.frs.tab.a(this);
        this.bSt = new b(this);
        this.mOnClickListener = new c(this);
        this.bSj = new LinearLayout(activity);
        this.bSj.setOrientation(0);
        this.bSj.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bSk = new j(activity, this.bSs, this.bSt);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bSj, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        av.l(this, u.d.common_color_10059);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean az(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i hN = hN(1);
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            i next = it.next();
            if (next != null && next.bwu == 1) {
                iVar = next;
                break;
            }
        }
        if (hN == null || iVar == null) {
            return false;
        }
        if (hN.bSy == null && iVar.bSy == null) {
            return false;
        }
        if ((hN.bSy != null || iVar.bSy == null) && (iVar.bSy != null || hN.bSy == null)) {
            if (hN.bSy == null || iVar.bSy == null) {
                return false;
            }
            if (hN.bSy.bIn == null && iVar.bSy.bIn == null) {
                return false;
            }
            if ((hN.bSy.bIn != null || iVar.bSy.bIn == null) && (iVar.bSy.bIn != null || hN.bSy.bIn == null)) {
                int size = hN.bSy.bIn.size();
                if (size != iVar.bSy.bIn.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    dy dyVar = iVar.bSy.bIn.get(i);
                    dy dyVar2 = hN.bSy.bIn.get(i);
                    if (dyVar.bIj != dyVar2.bIj || !dyVar.name.equals(dyVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void d(List<i> list, int i, int i2) {
        a(list, i, i2, false);
    }

    private void a(List<i> list, int i, int i2, boolean z) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(u.e.ds160);
        if (this.bSp > 0 && list.size() == this.bSp) {
            dimensionPixelSize = com.baidu.adp.lib.util.k.A(getContext()) / this.bSp;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        if (list == null || list.size() == 0) {
            this.aMv = null;
            i iVar = new i();
            iVar.bwu = 1;
            iVar.name = getContext().getResources().getString(u.j.frs_tab_all_thread);
            this.bSj.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
            tabItemView.setOnClickListener(this.mOnClickListener);
            this.bSj.addView(tabItemView, layoutParams);
            this.bSl = tabItemView;
            tabItemView.setState(TabItemView.bSA);
            return;
        }
        setVisibility(0);
        if (this.aMv == null || az(list)) {
            this.aMv = list;
            this.bSj.removeAllViews();
            for (i iVar2 : list) {
                if (iVar2 != null) {
                    TabItemView tabItemView2 = new TabItemView(getContext(), iVar2, i2);
                    tabItemView2.setOnClickListener(this.mOnClickListener);
                    if (hR(iVar2.bwu)) {
                        av.j((View) tabItemView2, u.d.cp_other_b);
                    }
                    this.bSj.addView(tabItemView2, layoutParams);
                    if (iVar2.bwu == i) {
                        this.bSl = tabItemView2;
                        tabItemView2.setState(TabItemView.bSA);
                    }
                }
            }
        }
    }

    private i hN(int i) {
        if (i < 0 || this.aMv == null || this.aMv.size() == 0) {
            return null;
        }
        for (i iVar : this.aMv) {
            if (iVar != null && iVar.bwu == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean hO(int i) {
        i hN = hN(i);
        return (hN == null || hN.bSy == null || hN.bSy.bIn == null || hN.bSy.bIn.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.bSm = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bSl != null) {
            this.mPaint.setColor(av.getColor(u.d.cp_bg_line_b));
            if (this.bSq) {
                canvas.drawRect(this.bSj.getLeft(), getMeasuredHeight() - this.bSo, this.bSj.getRight() > getRight() ? this.bSj.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(av.d((Resources) null, u.d.cp_link_tip_a));
            canvas.drawRect(this.bSl.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.bSn, (this.bSl.getRight() - getBottomLineMargin()) - this.bSl.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.bSl == null || this.bSi == 0) {
            return 0;
        }
        return ((this.bSl.getMeasuredWidth() - this.bSi) - this.bSl.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void hP(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bSj.getChildCount()) {
                View childAt = this.bSj.getChildAt(i3);
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
        this.bSu = dlVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.bSv = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.bSv;
    }

    public void setTabBackgroudColor(int i) {
        this.bSr = i;
    }

    public void vm() {
        av.l(this, this.bSr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bSj.getChildCount()) {
                View childAt = this.bSj.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (hR(((TabItemView) childAt).getTabId())) {
                        av.j(childAt, u.d.cp_other_b);
                    } else {
                        ((TabItemView) childAt).vm();
                    }
                }
                i = i2 + 1;
            } else {
                this.bSk.vm();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bSp = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void hQ(int i) {
        if (this.bSl != null && this.bSu != null) {
            this.bSu.a(this.bSl.getTabId(), i, null);
        }
    }

    public static boolean hR(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.bSq = z;
        invalidate();
    }
}
