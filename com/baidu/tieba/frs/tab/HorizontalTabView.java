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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements g {
    private List<i> aUV;
    private a chA;
    public int chn;
    private final LinearLayout cho;
    private final j chp;
    private TabItemView chq;
    private g chr;
    private final int chs;
    private final int cht;
    private int chu;
    private boolean chv;
    private int chw;
    private j.b chx;
    private j.a chy;
    private ce chz;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void ig(int i);

        boolean ih(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        cm cmVar;
        int i = 0;
        if (iE(tabItemView.getTabId())) {
            if (this.chz != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                cm cmVar2 = new cm();
                cmVar2.bVI = tabItemView.getUrl();
                this.chz.a(tabItemView.getTabId(), -1, cmVar2);
                return;
            }
            return;
        }
        this.chq = tabItemView;
        int[] iArr = new int[2];
        this.chq.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(r.e.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.cho.getChildCount(); i2++) {
            View childAt = this.cho.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.chq.getTabId() && !iE(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.chF);
                }
            }
        }
        if (this.chq.getState() == TabItemView.chF || this.chq.getState() == TabItemView.chH) {
            this.chp.agZ();
            boolean z2 = this.chq.getState() == TabItemView.chF;
            this.chq.setState(TabItemView.chG);
            i iA = iA(this.chq.getTabId());
            if (TextUtils.isEmpty(iA.url)) {
                cmVar = null;
            } else {
                cm cmVar3 = new cm();
                cmVar3.bVI = iA.url;
                cmVar3.stType = iA.name;
                cmVar = cmVar3;
            }
            if (iA.chE != null && iA.chE.bVs != null && iA.chE.bVs.size() > 0) {
                for (cx cxVar : iA.chE.bVs) {
                    if (cxVar != null && cxVar.isSelected) {
                        i = cxVar.bVo;
                    }
                }
            }
            if (z2 && this.chz != null) {
                this.chz.a(this.chq.getTabId(), i, cmVar);
            }
        } else if (iB(this.chq.getTabId()) && !z) {
            if (this.chA == null || this.chA.ih(this.chq.getTabId())) {
                this.chq.setState(TabItemView.chH);
                this.chp.a((Activity) getContext(), this, this.chq, iA(this.chq.getTabId()).chE);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.chn = 0;
        this.chq = null;
        this.chr = null;
        this.mPaint = new Paint();
        this.chs = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
        this.cht = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
        this.chu = 0;
        this.chv = true;
        this.chw = r.d.common_color_10059;
        this.chx = new com.baidu.tieba.frs.tab.a(this);
        this.chy = new b(this);
        this.mOnClickListener = new c(this);
        this.cho = new LinearLayout(activity);
        this.cho.setOrientation(0);
        this.cho.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(r.e.ds80));
        this.chp = new j(activity, this.chx, this.chy);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.chn = 0;
        this.chq = null;
        this.chr = null;
        this.mPaint = new Paint();
        this.chs = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
        this.cht = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
        this.chu = 0;
        this.chv = true;
        this.chw = r.d.common_color_10059;
        this.chx = new com.baidu.tieba.frs.tab.a(this);
        this.chy = new b(this);
        this.mOnClickListener = new c(this);
        this.cho = new LinearLayout(context);
        this.cho.setOrientation(0);
        this.cho.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(r.e.ds80));
        this.chp = new j(context, this.chx, this.chy);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.chn = 0;
        this.chq = null;
        this.chr = null;
        this.mPaint = new Paint();
        this.chs = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
        this.cht = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
        this.chu = 0;
        this.chv = true;
        this.chw = r.d.common_color_10059;
        this.chx = new com.baidu.tieba.frs.tab.a(this);
        this.chy = new b(this);
        this.mOnClickListener = new c(this);
        this.cho = new LinearLayout(activity);
        this.cho.setOrientation(0);
        this.cho.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.chp = new j(activity, this.chx, this.chy);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cho, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        at.l(this, r.d.common_color_10059);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aD(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i iA = iA(1);
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            i next = it.next();
            if (next != null && next.chD == 1) {
                iVar = next;
                break;
            }
        }
        if (iA == null || iVar == null) {
            return false;
        }
        if (iA.chE == null && iVar.chE == null) {
            return false;
        }
        if ((iA.chE != null || iVar.chE == null) && (iVar.chE != null || iA.chE == null)) {
            if (iA.chE == null || iVar.chE == null) {
                return false;
            }
            if (iA.chE.bVs == null && iVar.chE.bVs == null) {
                return false;
            }
            if ((iA.chE.bVs != null || iVar.chE.bVs == null) && (iVar.chE.bVs != null || iA.chE.bVs == null)) {
                int size = iA.chE.bVs.size();
                if (size != iVar.chE.bVs.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    cx cxVar = iVar.chE.bVs.get(i);
                    cx cxVar2 = iA.chE.bVs.get(i);
                    if (cxVar.bVo != cxVar2.bVo || !cxVar.name.equals(cxVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void e(List<i> list, int i, int i2) {
        a(list, i, i2, false);
    }

    private void a(List<i> list, int i, int i2, boolean z) {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(r.e.ds160);
        if (this.chu > 0 && list.size() == this.chu) {
            dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.chu;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
        if (list == null || list.size() == 0) {
            this.aUV = null;
            i iVar = new i();
            iVar.chD = 1;
            iVar.name = getContext().getResources().getString(r.j.frs_tab_all_thread);
            this.cho.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
            tabItemView.setOnClickListener(this.mOnClickListener);
            this.cho.addView(tabItemView, layoutParams);
            this.chq = tabItemView;
            tabItemView.setState(TabItemView.chG);
            return;
        }
        setVisibility(0);
        if (this.aUV == null || aD(list)) {
            this.aUV = list;
            this.cho.removeAllViews();
            for (i iVar2 : list) {
                if (iVar2 != null) {
                    TabItemView tabItemView2 = new TabItemView(getContext(), iVar2, i2);
                    tabItemView2.setOnClickListener(this.mOnClickListener);
                    if (iE(iVar2.chD)) {
                        at.j((View) tabItemView2, r.d.cp_other_b);
                    }
                    this.cho.addView(tabItemView2, layoutParams);
                    if (iVar2.chD == i) {
                        this.chq = tabItemView2;
                        tabItemView2.setState(TabItemView.chG);
                    }
                }
            }
        }
    }

    private i iA(int i) {
        if (i < 0 || this.aUV == null || this.aUV.size() == 0) {
            return null;
        }
        for (i iVar : this.aUV) {
            if (iVar != null && iVar.chD == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean iB(int i) {
        i iA = iA(i);
        return (iA == null || iA.chE == null || iA.chE.bVs == null || iA.chE.bVs.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.chr = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.chq != null) {
            this.mPaint.setColor(at.getColor(r.d.cp_bg_line_b));
            if (this.chv) {
                canvas.drawRect(this.cho.getLeft(), getMeasuredHeight() - this.cht, this.cho.getRight() > getRight() ? this.cho.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(at.d((Resources) null, r.d.cp_link_tip_a));
            canvas.drawRect(this.chq.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.chs, (this.chq.getRight() - getBottomLineMargin()) - this.chq.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.chq == null || this.chn == 0) {
            return 0;
        }
        return ((this.chq.getMeasuredWidth() - this.chn) - this.chq.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void iC(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cho.getChildCount()) {
                View childAt = this.cho.getChildAt(i3);
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

    public void setDataLoadInterface(ce ceVar) {
        this.chz = ceVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.chA = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.chA;
    }

    public void setTabBackgroudColor(int i) {
        this.chw = i;
    }

    public void wM() {
        at.l(this, this.chw);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cho.getChildCount()) {
                View childAt = this.cho.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (iE(((TabItemView) childAt).getTabId())) {
                        at.j(childAt, r.d.cp_other_b);
                    } else {
                        ((TabItemView) childAt).wM();
                    }
                }
                i = i2 + 1;
            } else {
                this.chp.wM();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.chu = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void iD(int i) {
        if (this.chq != null && this.chz != null) {
            this.chz.a(this.chq.getTabId(), i, null);
        }
    }

    public static boolean iE(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.chv = z;
        invalidate();
    }
}
