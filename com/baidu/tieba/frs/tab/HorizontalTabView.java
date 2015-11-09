package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.frs.ek;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends HorizontalScrollView implements g {
    private View.OnTouchListener aXk;
    private final LinearLayout bbB;
    private final i bbC;
    private TabItemView bbD;
    private g bbE;
    private final int bbF;
    private final int bbG;
    private int bbH;
    private i.a bbI;
    private ec bbJ;
    private a bbK;
    private List<h> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void gb(int i);

        boolean gc(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        ee eeVar;
        int i = 0;
        this.bbD = tabItemView;
        int[] iArr = new int[2];
        this.bbD.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i.d.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.bbB.getChildCount(); i2++) {
            View childAt = this.bbB.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.bbD.getTabId()) {
                    tabItemView2.setState(TabItemView.bbP);
                }
            }
        }
        if (this.bbD.getState() == TabItemView.bbP || this.bbD.getState() == TabItemView.bbR) {
            boolean z2 = this.bbD.getState() == TabItemView.bbP;
            this.bbD.setState(TabItemView.bbQ);
            h fW = fW(this.bbD.getTabId());
            if (TextUtils.isEmpty(fW.url)) {
                eeVar = null;
            } else {
                ee eeVar2 = new ee();
                eeVar2.aZk = fW.url;
                eeVar2.stType = fW.name;
                eeVar = eeVar2;
            }
            if (fW.bbO != null && fW.bbO.aYK != null && fW.bbO.aYK.size() > 0) {
                for (ek ekVar : fW.bbO.aYK) {
                    if (ekVar != null && ekVar.isSelected) {
                        i = ekVar.aYG;
                    }
                }
            }
            if (z2 && this.bbJ != null) {
                this.bbJ.a(this.bbD.getTabId(), i, eeVar);
            }
        } else if (fX(this.bbD.getTabId()) && !z) {
            if (this.bbK == null || this.bbK.gc(this.bbD.getTabId())) {
                this.bbD.setState(TabItemView.bbR);
                this.bbC.a((Activity) getContext(), this, this.bbD, fW(this.bbD.getTabId()).bbO);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.bbD = null;
        this.bbE = null;
        this.mPaint = new Paint();
        this.bbF = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.bbG = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bbH = 0;
        this.bbI = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.aXk = new c(this);
        this.bbB = new LinearLayout(activity);
        this.bbB.setOrientation(0);
        this.bbB.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(i.d.ds80));
        this.bbC = new i(activity, this.bbI);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbD = null;
        this.bbE = null;
        this.mPaint = new Paint();
        this.bbF = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.bbG = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bbH = 0;
        this.bbI = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.aXk = new c(this);
        this.bbB = new LinearLayout(context);
        this.bbB.setOrientation(0);
        this.bbB.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(i.d.ds80));
        this.bbC = new i(context, this.bbI);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bbD = null;
        this.bbE = null;
        this.mPaint = new Paint();
        this.bbF = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.bbG = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bbH = 0;
        this.bbI = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.aXk = new c(this);
        this.bbB = new LinearLayout(activity);
        this.bbB.setOrientation(0);
        this.bbB.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bbC = new i(activity, this.bbI);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bbB, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        an.j(this, i.c.frs_tab_bg);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public void setData(List<h> list, int i) {
        a(list, i, false);
    }

    public void a(List<h> list, int i, boolean z) {
        boolean z2 = true;
        if (list == null || list.size() == 0) {
            setVisibility(8);
        } else if (this.mData == null || ad(list)) {
            this.mData = list;
            this.bbB.removeAllViews();
            boolean z3 = this.bbH > 0 && list.size() == this.bbH;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i.d.ds160);
            if (z3) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.bbH;
            }
            for (h hVar : list) {
                if (hVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), hVar, i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
                    if (z) {
                        tabItemView.setOnTouchListener(this.aXk);
                    } else {
                        tabItemView.setOnClickListener(this.mOnClickListener);
                    }
                    this.bbB.addView(tabItemView, layoutParams);
                    if (z2) {
                        this.bbD = tabItemView;
                        tabItemView.setState(TabItemView.bbQ);
                        z2 = false;
                    }
                }
            }
        }
    }

    private boolean ad(List<h> list) {
        h hVar;
        h fW = fW(1);
        Iterator<h> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                hVar = null;
                break;
            }
            h next = it.next();
            if (next.bbN == 1) {
                hVar = next;
                break;
            }
        }
        if (fW == null || hVar == null) {
            return false;
        }
        if (fW.bbO == null && hVar.bbO == null) {
            return false;
        }
        if ((fW.bbO != null || hVar.bbO == null) && (hVar.bbO != null || fW.bbO == null)) {
            if (fW.bbO.aYK == null && hVar.bbO.aYK == null) {
                return false;
            }
            if ((fW.bbO.aYK != null || hVar.bbO.aYK == null) && (hVar.bbO.aYK != null || fW.bbO.aYK == null)) {
                int size = fW.bbO.aYK.size();
                if (size != hVar.bbO.aYK.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ek ekVar = hVar.bbO.aYK.get(i);
                    ek ekVar2 = fW.bbO.aYK.get(i);
                    if (ekVar.aYG != ekVar2.aYG || !ekVar.name.equals(ekVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void setData(List<h> list) {
        a(list, 4, false);
    }

    public void setData(List<h> list, boolean z) {
        a(list, 4, z);
    }

    private h fW(int i) {
        if (i < 0 || this.mData == null || this.mData.size() == 0) {
            return null;
        }
        for (h hVar : this.mData) {
            if (hVar != null && hVar.bbN == i) {
                return hVar;
            }
        }
        return null;
    }

    private boolean fX(int i) {
        h fW = fW(i);
        return (fW == null || fW.bbO == null || fW.bbO.aYK == null || fW.bbO.aYK.size() <= 0) ? false : true;
    }

    public boolean NB() {
        return (this.mData == null || this.mData.size() == 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.bbE = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bbD != null) {
            this.mPaint.setColor(an.getColor(i.c.cp_bg_line_b));
            canvas.drawRect(this.bbB.getLeft(), getMeasuredHeight() - this.bbG, this.bbB.getRight() > getRight() ? this.bbB.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            this.mPaint.setColor(an.d((Resources) null, i.c.s_actionbar_text_line_color_s));
            canvas.drawRect(this.bbD.getLeft(), getMeasuredHeight() - this.bbF, this.bbD.getRight(), getMeasuredHeight(), this.mPaint);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void fY(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bbB.getChildCount()) {
                View childAt = this.bbB.getChildAt(i3);
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

    public void setDataLoadInterface(ec ecVar) {
        this.bbJ = ecVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.bbK = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.bbK;
    }

    public void vB() {
        an.j(this, i.c.frs_tab_bg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bbB.getChildCount()) {
                View childAt = this.bbB.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    ((TabItemView) childAt).vB();
                }
                i = i2 + 1;
            } else {
                this.bbC.vB();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bbH = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void fZ(int i) {
        if (this.bbD != null && this.bbJ != null) {
            this.bbJ.a(this.bbD.getTabId(), i, null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
