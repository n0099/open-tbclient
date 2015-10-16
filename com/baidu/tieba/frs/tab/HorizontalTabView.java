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
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.i;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends HorizontalScrollView implements f {
    private View.OnTouchListener aXb;
    private final LinearLayout bbf;
    private final i bbg;
    private TabItemView bbh;
    private f bbi;
    private final int bbj;
    private final int bbk;
    private final int bbl;
    private int bbm;
    private i.a bbn;
    private ea bbo;
    private List<g> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    public void a(TabItemView tabItemView, boolean z) {
        ec ecVar;
        int i = 0;
        this.bbh = tabItemView;
        int[] iArr = new int[2];
        this.bbh.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i.d.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.bbf.getChildCount(); i2++) {
            View childAt = this.bbf.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.bbh.getTabId()) {
                    tabItemView2.setState(TabItemView.bbt);
                }
            }
        }
        if (this.bbh.getState() == TabItemView.bbt || this.bbh.getState() == TabItemView.bbv) {
            boolean z2 = this.bbh.getState() == TabItemView.bbt;
            this.bbh.setState(TabItemView.bbu);
            g fN = fN(this.bbh.getTabId());
            if (TextUtils.isEmpty(fN.url)) {
                ecVar = null;
            } else {
                ec ecVar2 = new ec();
                ecVar2.aYY = fN.url;
                ecVar2.stType = fN.name;
                ecVar = ecVar2;
            }
            if (fN.bbs != null && fN.bbs.size() > 0) {
                Iterator<h> it = fN.bbs.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h next = it.next();
                    if (next.isSelected) {
                        i = next.bbx;
                        break;
                    }
                }
            }
            if (z2 && this.bbo != null) {
                this.bbo.a(this.bbh.getTabId(), i, ecVar);
            }
        } else if (fO(this.bbh.getTabId()) && !z) {
            this.bbh.setState(TabItemView.bbv);
            this.bbg.a((Activity) getContext(), this, this.bbh, fN(this.bbh.getTabId()).bbs);
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.bbh = null;
        this.bbi = null;
        this.mPaint = new Paint();
        this.bbj = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.bbk = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bbl = 4;
        this.bbm = 0;
        this.bbn = new a(this);
        this.mOnClickListener = new b(this);
        this.aXb = new c(this);
        this.bbf = new LinearLayout(activity);
        this.bbf.setOrientation(0);
        this.bbf.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(i.d.ds80));
        this.bbg = new i(activity, this.bbn);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bbh = null;
        this.bbi = null;
        this.mPaint = new Paint();
        this.bbj = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.bbk = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bbl = 4;
        this.bbm = 0;
        this.bbn = new a(this);
        this.mOnClickListener = new b(this);
        this.aXb = new c(this);
        this.bbf = new LinearLayout(context);
        this.bbf.setOrientation(0);
        this.bbf.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(i.d.ds80));
        this.bbg = new i(context, this.bbn);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bbh = null;
        this.bbi = null;
        this.mPaint = new Paint();
        this.bbj = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds6);
        this.bbk = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds1);
        this.bbl = 4;
        this.bbm = 0;
        this.bbn = new a(this);
        this.mOnClickListener = new b(this);
        this.aXb = new c(this);
        this.bbf = new LinearLayout(activity);
        this.bbf.setOrientation(0);
        this.bbf.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bbg = new i(activity, this.bbn);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bbf, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        an.j(this, i.c.frs_tab_bg);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public void setData(List<g> list, int i) {
        a(list, i, false);
    }

    public void a(List<g> list, int i, boolean z) {
        boolean z2 = true;
        if (list == null || list.size() == 0) {
            setVisibility(8);
        } else if (this.mData == null) {
            this.mData = list;
            this.bbf.removeAllViews();
            boolean z3 = this.bbm > 0 && list.size() == this.bbm;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(i.d.ds160);
            if (z3) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.bbm;
            }
            for (g gVar : list) {
                if (gVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), gVar, i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
                    if (z) {
                        tabItemView.setOnTouchListener(this.aXb);
                    } else {
                        tabItemView.setOnClickListener(this.mOnClickListener);
                    }
                    this.bbf.addView(tabItemView, layoutParams);
                    if (z2) {
                        this.bbh = tabItemView;
                        tabItemView.setState(TabItemView.bbu);
                        z2 = false;
                    }
                }
            }
        }
    }

    public void setData(List<g> list) {
        a(list, 4, false);
    }

    public void setData(List<g> list, boolean z) {
        a(list, 4, z);
    }

    private g fN(int i) {
        if (i < 0 || this.mData == null || this.mData.size() == 0) {
            return null;
        }
        for (g gVar : this.mData) {
            if (gVar != null && gVar.bbr == i) {
                return gVar;
            }
        }
        return null;
    }

    private boolean fO(int i) {
        g fN = fN(i);
        return (fN == null || fN.bbs == null || fN.bbs.size() <= 0) ? false : true;
    }

    public boolean Nl() {
        return (this.mData == null || this.mData.size() == 0) ? false : true;
    }

    public void setFakeTab(f fVar) {
        this.bbi = fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bbh != null) {
            this.mPaint.setColor(an.getColor(i.c.cp_bg_line_b));
            canvas.drawRect(this.bbf.getLeft(), getMeasuredHeight() - this.bbk, this.bbf.getRight() > getRight() ? this.bbf.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            this.mPaint.setColor(an.d((Resources) null, i.c.s_actionbar_text_line_color_s));
            canvas.drawRect(this.bbh.getLeft(), getMeasuredHeight() - this.bbj, this.bbh.getRight(), getMeasuredHeight(), this.mPaint);
        }
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void fP(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bbf.getChildCount()) {
                View childAt = this.bbf.getChildAt(i3);
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

    public void setDataLoadInterface(ea eaVar) {
        this.bbo = eaVar;
    }

    public void vA() {
        an.j(this, i.c.frs_tab_bg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bbf.getChildCount()) {
                View childAt = this.bbf.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    ((TabItemView) childAt).vA();
                }
                i = i2 + 1;
            } else {
                this.bbg.vA();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bbm = i;
    }

    @Override // com.baidu.tieba.frs.tab.f
    public void fQ(int i) {
        if (this.bbh != null && this.bbo != null) {
            this.bbo.a(this.bbh.getTabId(), i, null);
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
