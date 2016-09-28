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
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements g {
    private List<i> aSU;
    public int cdm;
    private final LinearLayout cdn;
    private final j cdo;
    private TabItemView cdp;
    private g cdq;
    private final int cdr;
    private final int cds;
    private int cdt;
    private boolean cdu;
    private int cdv;
    private j.b cdw;
    private j.a cdx;
    private dg cdy;
    private a cdz;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void ig(int i);

        boolean ih(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        dn dnVar;
        int i = 0;
        if (iz(tabItemView.getTabId())) {
            if (this.cdy != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                dn dnVar2 = new dn();
                dnVar2.bTy = tabItemView.getUrl();
                this.cdy.a(tabItemView.getTabId(), -1, dnVar2);
                return;
            }
            return;
        }
        this.cdp = tabItemView;
        int[] iArr = new int[2];
        this.cdp.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(r.e.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.cdn.getChildCount(); i2++) {
            View childAt = this.cdn.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.cdp.getTabId() && !iz(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.cdE);
                }
            }
        }
        if (this.cdp.getState() == TabItemView.cdE || this.cdp.getState() == TabItemView.cdG) {
            this.cdo.afp();
            boolean z2 = this.cdp.getState() == TabItemView.cdE;
            this.cdp.setState(TabItemView.cdF);
            i iv = iv(this.cdp.getTabId());
            if (TextUtils.isEmpty(iv.url)) {
                dnVar = null;
            } else {
                dn dnVar3 = new dn();
                dnVar3.bTy = iv.url;
                dnVar3.stType = iv.name;
                dnVar = dnVar3;
            }
            if (iv.cdD != null && iv.cdD.bTm != null && iv.cdD.bTm.size() > 0) {
                for (dt dtVar : iv.cdD.bTm) {
                    if (dtVar != null && dtVar.isSelected) {
                        i = dtVar.bTi;
                    }
                }
            }
            if (z2 && this.cdy != null) {
                this.cdy.a(this.cdp.getTabId(), i, dnVar);
            }
        } else if (iw(this.cdp.getTabId()) && !z) {
            if (this.cdz == null || this.cdz.ih(this.cdp.getTabId())) {
                this.cdp.setState(TabItemView.cdG);
                this.cdo.a((Activity) getContext(), this, this.cdp, iv(this.cdp.getTabId()).cdD);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.cdm = 0;
        this.cdp = null;
        this.cdq = null;
        this.mPaint = new Paint();
        this.cdr = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
        this.cds = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
        this.cdt = 0;
        this.cdu = true;
        this.cdv = r.d.common_color_10059;
        this.cdw = new com.baidu.tieba.frs.tab.a(this);
        this.cdx = new b(this);
        this.mOnClickListener = new c(this);
        this.cdn = new LinearLayout(activity);
        this.cdn.setOrientation(0);
        this.cdn.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(r.e.ds80));
        this.cdo = new j(activity, this.cdw, this.cdx);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdm = 0;
        this.cdp = null;
        this.cdq = null;
        this.mPaint = new Paint();
        this.cdr = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
        this.cds = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
        this.cdt = 0;
        this.cdu = true;
        this.cdv = r.d.common_color_10059;
        this.cdw = new com.baidu.tieba.frs.tab.a(this);
        this.cdx = new b(this);
        this.mOnClickListener = new c(this);
        this.cdn = new LinearLayout(context);
        this.cdn.setOrientation(0);
        this.cdn.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(r.e.ds80));
        this.cdo = new j(context, this.cdw, this.cdx);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cdm = 0;
        this.cdp = null;
        this.cdq = null;
        this.mPaint = new Paint();
        this.cdr = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
        this.cds = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
        this.cdt = 0;
        this.cdu = true;
        this.cdv = r.d.common_color_10059;
        this.cdw = new com.baidu.tieba.frs.tab.a(this);
        this.cdx = new b(this);
        this.mOnClickListener = new c(this);
        this.cdn = new LinearLayout(activity);
        this.cdn.setOrientation(0);
        this.cdn.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cdo = new j(activity, this.cdw, this.cdx);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cdn, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        av.l(this, r.d.common_color_10059);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aB(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i iv = iv(1);
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            i next = it.next();
            if (next != null && next.cdC == 1) {
                iVar = next;
                break;
            }
        }
        if (iv == null || iVar == null) {
            return false;
        }
        if (iv.cdD == null && iVar.cdD == null) {
            return false;
        }
        if ((iv.cdD != null || iVar.cdD == null) && (iVar.cdD != null || iv.cdD == null)) {
            if (iv.cdD == null || iVar.cdD == null) {
                return false;
            }
            if (iv.cdD.bTm == null && iVar.cdD.bTm == null) {
                return false;
            }
            if ((iv.cdD.bTm != null || iVar.cdD.bTm == null) && (iVar.cdD.bTm != null || iv.cdD.bTm == null)) {
                int size = iv.cdD.bTm.size();
                if (size != iVar.cdD.bTm.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    dt dtVar = iVar.cdD.bTm.get(i);
                    dt dtVar2 = iv.cdD.bTm.get(i);
                    if (dtVar.bTi != dtVar2.bTi || !dtVar.name.equals(dtVar2.name)) {
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
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(r.e.ds160);
        if (this.cdt > 0 && list.size() == this.cdt) {
            dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.cdt;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        if (list == null || list.size() == 0) {
            this.aSU = null;
            i iVar = new i();
            iVar.cdC = 1;
            iVar.name = getContext().getResources().getString(r.j.frs_tab_all_thread);
            this.cdn.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
            tabItemView.setOnClickListener(this.mOnClickListener);
            this.cdn.addView(tabItemView, layoutParams);
            this.cdp = tabItemView;
            tabItemView.setState(TabItemView.cdF);
            return;
        }
        setVisibility(0);
        if (this.aSU == null || aB(list)) {
            this.aSU = list;
            this.cdn.removeAllViews();
            for (i iVar2 : list) {
                if (iVar2 != null) {
                    TabItemView tabItemView2 = new TabItemView(getContext(), iVar2, i2);
                    tabItemView2.setOnClickListener(this.mOnClickListener);
                    if (iz(iVar2.cdC)) {
                        av.j((View) tabItemView2, r.d.cp_other_b);
                    }
                    this.cdn.addView(tabItemView2, layoutParams);
                    if (iVar2.cdC == i) {
                        this.cdp = tabItemView2;
                        tabItemView2.setState(TabItemView.cdF);
                    }
                }
            }
        }
    }

    private i iv(int i) {
        if (i < 0 || this.aSU == null || this.aSU.size() == 0) {
            return null;
        }
        for (i iVar : this.aSU) {
            if (iVar != null && iVar.cdC == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean iw(int i) {
        i iv = iv(i);
        return (iv == null || iv.cdD == null || iv.cdD.bTm == null || iv.cdD.bTm.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.cdq = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cdp != null) {
            this.mPaint.setColor(av.getColor(r.d.cp_bg_line_b));
            if (this.cdu) {
                canvas.drawRect(this.cdn.getLeft(), getMeasuredHeight() - this.cds, this.cdn.getRight() > getRight() ? this.cdn.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(av.d((Resources) null, r.d.cp_link_tip_a));
            canvas.drawRect(this.cdp.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cdr, (this.cdp.getRight() - getBottomLineMargin()) - this.cdp.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cdp == null || this.cdm == 0) {
            return 0;
        }
        return ((this.cdp.getMeasuredWidth() - this.cdm) - this.cdp.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void ix(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cdn.getChildCount()) {
                View childAt = this.cdn.getChildAt(i3);
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
        this.cdy = dgVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.cdz = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.cdz;
    }

    public void setTabBackgroudColor(int i) {
        this.cdv = i;
    }

    public void wH() {
        av.l(this, this.cdv);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cdn.getChildCount()) {
                View childAt = this.cdn.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (iz(((TabItemView) childAt).getTabId())) {
                        av.j(childAt, r.d.cp_other_b);
                    } else {
                        ((TabItemView) childAt).wH();
                    }
                }
                i = i2 + 1;
            } else {
                this.cdo.wH();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cdt = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void iy(int i) {
        if (this.cdp != null && this.cdy != null) {
            this.cdy.a(this.cdp.getTabId(), i, null);
        }
    }

    public static boolean iz(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cdu = z;
        invalidate();
    }
}
