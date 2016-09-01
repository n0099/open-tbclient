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
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements g {
    private List<i> aRP;
    private dg cdA;
    private a cdB;
    public int cdo;
    private final LinearLayout cdp;
    private final j cdq;
    private TabItemView cdr;
    private g cds;
    private final int cdt;
    private final int cdu;
    private int cdv;
    private boolean cdw;
    private int cdx;
    private j.b cdy;
    private j.a cdz;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void ic(int i);

        boolean id(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        dn dnVar;
        int i = 0;
        if (iu(tabItemView.getTabId())) {
            if (this.cdA != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                dn dnVar2 = new dn();
                dnVar2.bTF = tabItemView.getUrl();
                this.cdA.a(tabItemView.getTabId(), -1, dnVar2);
                return;
            }
            return;
        }
        this.cdr = tabItemView;
        int[] iArr = new int[2];
        this.cdr.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(t.e.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.cdp.getChildCount(); i2++) {
            View childAt = this.cdp.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.cdr.getTabId() && !iu(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.cdF);
                }
            }
        }
        if (this.cdr.getState() == TabItemView.cdF || this.cdr.getState() == TabItemView.cdH) {
            this.cdq.afb();
            boolean z2 = this.cdr.getState() == TabItemView.cdF;
            this.cdr.setState(TabItemView.cdG);
            i iq = iq(this.cdr.getTabId());
            if (TextUtils.isEmpty(iq.url)) {
                dnVar = null;
            } else {
                dn dnVar3 = new dn();
                dnVar3.bTF = iq.url;
                dnVar3.stType = iq.name;
                dnVar = dnVar3;
            }
            if (iq.cdE != null && iq.cdE.bTt != null && iq.cdE.bTt.size() > 0) {
                for (dt dtVar : iq.cdE.bTt) {
                    if (dtVar != null && dtVar.isSelected) {
                        i = dtVar.bTp;
                    }
                }
            }
            if (z2 && this.cdA != null) {
                this.cdA.a(this.cdr.getTabId(), i, dnVar);
            }
        } else if (ir(this.cdr.getTabId()) && !z) {
            if (this.cdB == null || this.cdB.id(this.cdr.getTabId())) {
                this.cdr.setState(TabItemView.cdH);
                this.cdq.a((Activity) getContext(), this, this.cdr, iq(this.cdr.getTabId()).cdE);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.cdo = 0;
        this.cdr = null;
        this.cds = null;
        this.mPaint = new Paint();
        this.cdt = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.cdu = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.cdv = 0;
        this.cdw = true;
        this.cdx = t.d.common_color_10059;
        this.cdy = new com.baidu.tieba.frs.tab.a(this);
        this.cdz = new b(this);
        this.mOnClickListener = new c(this);
        this.cdp = new LinearLayout(activity);
        this.cdp.setOrientation(0);
        this.cdp.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(t.e.ds80));
        this.cdq = new j(activity, this.cdy, this.cdz);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdo = 0;
        this.cdr = null;
        this.cds = null;
        this.mPaint = new Paint();
        this.cdt = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.cdu = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.cdv = 0;
        this.cdw = true;
        this.cdx = t.d.common_color_10059;
        this.cdy = new com.baidu.tieba.frs.tab.a(this);
        this.cdz = new b(this);
        this.mOnClickListener = new c(this);
        this.cdp = new LinearLayout(context);
        this.cdp.setOrientation(0);
        this.cdp.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(t.e.ds80));
        this.cdq = new j(context, this.cdy, this.cdz);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cdo = 0;
        this.cdr = null;
        this.cds = null;
        this.mPaint = new Paint();
        this.cdt = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.cdu = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.cdv = 0;
        this.cdw = true;
        this.cdx = t.d.common_color_10059;
        this.cdy = new com.baidu.tieba.frs.tab.a(this);
        this.cdz = new b(this);
        this.mOnClickListener = new c(this);
        this.cdp = new LinearLayout(activity);
        this.cdp.setOrientation(0);
        this.cdp.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cdq = new j(activity, this.cdy, this.cdz);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cdp, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        av.l(this, t.d.common_color_10059);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aB(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i iq = iq(1);
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            i next = it.next();
            if (next != null && next.bHI == 1) {
                iVar = next;
                break;
            }
        }
        if (iq == null || iVar == null) {
            return false;
        }
        if (iq.cdE == null && iVar.cdE == null) {
            return false;
        }
        if ((iq.cdE != null || iVar.cdE == null) && (iVar.cdE != null || iq.cdE == null)) {
            if (iq.cdE == null || iVar.cdE == null) {
                return false;
            }
            if (iq.cdE.bTt == null && iVar.cdE.bTt == null) {
                return false;
            }
            if ((iq.cdE.bTt != null || iVar.cdE.bTt == null) && (iVar.cdE.bTt != null || iq.cdE.bTt == null)) {
                int size = iq.cdE.bTt.size();
                if (size != iVar.cdE.bTt.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    dt dtVar = iVar.cdE.bTt.get(i);
                    dt dtVar2 = iq.cdE.bTt.get(i);
                    if (dtVar.bTp != dtVar2.bTp || !dtVar.name.equals(dtVar2.name)) {
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
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(t.e.ds160);
        if (this.cdv > 0 && list.size() == this.cdv) {
            dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.cdv;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        if (list == null || list.size() == 0) {
            this.aRP = null;
            i iVar = new i();
            iVar.bHI = 1;
            iVar.name = getContext().getResources().getString(t.j.frs_tab_all_thread);
            this.cdp.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
            tabItemView.setOnClickListener(this.mOnClickListener);
            this.cdp.addView(tabItemView, layoutParams);
            this.cdr = tabItemView;
            tabItemView.setState(TabItemView.cdG);
            return;
        }
        setVisibility(0);
        if (this.aRP == null || aB(list)) {
            this.aRP = list;
            this.cdp.removeAllViews();
            for (i iVar2 : list) {
                if (iVar2 != null) {
                    TabItemView tabItemView2 = new TabItemView(getContext(), iVar2, i2);
                    tabItemView2.setOnClickListener(this.mOnClickListener);
                    if (iu(iVar2.bHI)) {
                        av.j((View) tabItemView2, t.d.cp_other_b);
                    }
                    this.cdp.addView(tabItemView2, layoutParams);
                    if (iVar2.bHI == i) {
                        this.cdr = tabItemView2;
                        tabItemView2.setState(TabItemView.cdG);
                    }
                }
            }
        }
    }

    private i iq(int i) {
        if (i < 0 || this.aRP == null || this.aRP.size() == 0) {
            return null;
        }
        for (i iVar : this.aRP) {
            if (iVar != null && iVar.bHI == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean ir(int i) {
        i iq = iq(i);
        return (iq == null || iq.cdE == null || iq.cdE.bTt == null || iq.cdE.bTt.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.cds = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cdr != null) {
            this.mPaint.setColor(av.getColor(t.d.cp_bg_line_b));
            if (this.cdw) {
                canvas.drawRect(this.cdp.getLeft(), getMeasuredHeight() - this.cdu, this.cdp.getRight() > getRight() ? this.cdp.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(av.d((Resources) null, t.d.cp_link_tip_a));
            canvas.drawRect(this.cdr.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cdt, (this.cdr.getRight() - getBottomLineMargin()) - this.cdr.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cdr == null || this.cdo == 0) {
            return 0;
        }
        return ((this.cdr.getMeasuredWidth() - this.cdo) - this.cdr.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void is(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cdp.getChildCount()) {
                View childAt = this.cdp.getChildAt(i3);
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

    public void setDataLoadInterface(dg dgVar) {
        this.cdA = dgVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.cdB = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.cdB;
    }

    public void setTabBackgroudColor(int i) {
        this.cdx = i;
    }

    public void wq() {
        av.l(this, this.cdx);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cdp.getChildCount()) {
                View childAt = this.cdp.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (iu(((TabItemView) childAt).getTabId())) {
                        av.j(childAt, t.d.cp_other_b);
                    } else {
                        ((TabItemView) childAt).wq();
                    }
                }
                i = i2 + 1;
            } else {
                this.cdq.wq();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cdv = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void it(int i) {
        if (this.cdr != null && this.cdA != null) {
            this.cdA.a(this.cdr.getTabId(), i, null);
        }
    }

    public static boolean iu(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cdw = z;
        invalidate();
    }
}
