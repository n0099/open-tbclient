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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cj;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements g {
    private List<i> aPE;
    public int bTk;
    private final LinearLayout bTl;
    private final j bTm;
    private TabItemView bTn;
    private g bTo;
    private final int bTp;
    private final int bTq;
    private int bTr;
    private boolean bTs;
    private int bTt;
    private j.b bTu;
    private j.a bTv;
    private cb bTw;
    private a bTx;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void id(int i);

        boolean ie(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        cj cjVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (iB(tabItemView.getTabId())) {
                if (this.bTw != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    cj cjVar2 = new cj();
                    cjVar2.bJi = tabItemView.getUrl();
                    this.bTw.a(tabItemView.getTabId(), -1, cjVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.bTw != null) {
                    this.bTw.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.bTn = tabItemView;
                int[] iArr = new int[2];
                this.bTn.getLocationOnScreen(iArr);
                int I = com.baidu.adp.lib.util.k.I(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(r.f.ds160);
                if (iArr[0] < 0) {
                    post(new d(this, dimensionPixelSize));
                } else if (I < dimensionPixelSize) {
                    post(new e(this));
                }
                for (int i2 = 0; i2 < this.bTl.getChildCount(); i2++) {
                    View childAt = this.bTl.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.bTn.getTabId() && !iB(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.bTC);
                        }
                    }
                }
                if (this.bTn.getState() == TabItemView.bTC || this.bTn.getState() == TabItemView.bTE) {
                    this.bTm.acB();
                    boolean z2 = this.bTn.getState() == TabItemView.bTC;
                    this.bTn.setState(TabItemView.bTD);
                    i ix = ix(this.bTn.getTabId());
                    if (!TextUtils.isEmpty(ix.url)) {
                        cj cjVar3 = new cj();
                        cjVar3.bJi = ix.url;
                        cjVar3.stType = ix.name;
                        cjVar = cjVar3;
                    }
                    if (ix.bTB != null && ix.bTB.bIU != null && ix.bTB.bIU.size() > 0) {
                        for (ct ctVar : ix.bTB.bIU) {
                            if (ctVar != null && ctVar.isSelected) {
                                i = ctVar.bIQ;
                            }
                        }
                    }
                    if (z2 && this.bTw != null) {
                        this.bTw.a(this.bTn.getTabId(), i, cjVar);
                    }
                } else if (iy(this.bTn.getTabId()) && !z) {
                    if (this.bTx == null || this.bTx.ie(this.bTn.getTabId())) {
                        this.bTn.setState(TabItemView.bTE);
                        this.bTm.a((Activity) getContext(), this, this.bTn, ix(this.bTn.getTabId()).bTB);
                    } else {
                        return;
                    }
                }
                invalidate();
            }
        }
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.bTk = 0;
        this.bTn = null;
        this.bTo = null;
        this.mPaint = new Paint();
        this.bTp = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds6);
        this.bTq = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds1);
        this.bTr = 0;
        this.bTs = true;
        this.bTt = r.e.common_color_10059;
        this.bTu = new com.baidu.tieba.frs.tab.a(this);
        this.bTv = new b(this);
        this.mOnClickListener = new c(this);
        this.bTl = new LinearLayout(activity);
        this.bTl.setOrientation(0);
        this.bTl.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(r.f.ds80));
        this.bTm = new j(activity, this.bTu, this.bTv);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bTk = 0;
        this.bTn = null;
        this.bTo = null;
        this.mPaint = new Paint();
        this.bTp = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds6);
        this.bTq = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds1);
        this.bTr = 0;
        this.bTs = true;
        this.bTt = r.e.common_color_10059;
        this.bTu = new com.baidu.tieba.frs.tab.a(this);
        this.bTv = new b(this);
        this.mOnClickListener = new c(this);
        this.bTl = new LinearLayout(context);
        this.bTl.setOrientation(0);
        this.bTl.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(r.f.ds80));
        this.bTm = new j(context, this.bTu, this.bTv);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bTk = 0;
        this.bTn = null;
        this.bTo = null;
        this.mPaint = new Paint();
        this.bTp = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds6);
        this.bTq = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds1);
        this.bTr = 0;
        this.bTs = true;
        this.bTt = r.e.common_color_10059;
        this.bTu = new com.baidu.tieba.frs.tab.a(this);
        this.bTv = new b(this);
        this.mOnClickListener = new c(this);
        this.bTl = new LinearLayout(activity);
        this.bTl.setOrientation(0);
        this.bTl.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bTm = new j(activity, this.bTu, this.bTv);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bTl, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ap.k(this, r.e.common_color_10059);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean az(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i ix = ix(1);
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            i next = it.next();
            if (next != null && next.bTA == 1) {
                iVar = next;
                break;
            }
        }
        if (ix == null || iVar == null) {
            return false;
        }
        if (ix.bTB == null && iVar.bTB == null) {
            return false;
        }
        if ((ix.bTB != null || iVar.bTB == null) && (iVar.bTB != null || ix.bTB == null)) {
            if (ix.bTB == null || iVar.bTB == null) {
                return false;
            }
            if (ix.bTB.bIU == null && iVar.bTB.bIU == null) {
                return false;
            }
            if ((ix.bTB.bIU != null || iVar.bTB.bIU == null) && (iVar.bTB.bIU != null || ix.bTB.bIU == null)) {
                int size = ix.bTB.bIU.size();
                if (size != iVar.bTB.bIU.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ct ctVar = iVar.bTB.bIU.get(i);
                    ct ctVar2 = ix.bTB.bIU.get(i);
                    if (ctVar.bIQ != ctVar2.bIQ || !ctVar.name.equals(ctVar2.name)) {
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
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.bTr > 0 && list.size() == this.bTr) {
            layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.k.I(getContext()) / this.bTr, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(r.f.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.aPE = null;
            i iVar = new i();
            iVar.bTA = 1;
            iVar.name = getContext().getResources().getString(r.l.chosen_pb_title);
            this.bTl.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(r.f.ds32);
            this.bTl.addView(tabItemView, layoutParams);
            this.bTn = tabItemView;
            tabItemView.setState(TabItemView.bTD);
            return;
        }
        setVisibility(0);
        if (this.aPE == null || az(list)) {
            this.aPE = list;
            this.bTl.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    i iVar2 = list.get(i4);
                    if (iVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), iVar2, i2);
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (iB(iVar2.bTA)) {
                            ap.i((View) tabItemView2, r.e.cp_other_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(r.f.ds32);
                        }
                        this.bTl.addView(tabItemView2, layoutParams);
                        if (iVar2.bTA == i) {
                            this.bTn = tabItemView2;
                            tabItemView2.setState(TabItemView.bTD);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private i ix(int i) {
        if (i < 0 || this.aPE == null || this.aPE.size() == 0) {
            return null;
        }
        for (i iVar : this.aPE) {
            if (iVar != null && iVar.bTA == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean iy(int i) {
        i ix = ix(i);
        return (ix == null || ix.bTB == null || ix.bTB.bIU == null || ix.bTB.bIU.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.bTo = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bTn != null) {
            this.mPaint.setColor(ap.getColor(r.e.cp_bg_line_b));
            if (this.bTs) {
                canvas.drawRect(this.bTl.getLeft(), getMeasuredHeight() - this.bTq, this.bTl.getRight() > getRight() ? this.bTl.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(ap.d((Resources) null, r.e.cp_link_tip_a));
            canvas.drawRect(this.bTn.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.bTp, (this.bTn.getRight() - getBottomLineMargin()) - this.bTn.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.bTn == null || this.bTk == 0) {
            return 0;
        }
        return ((this.bTn.getMeasuredWidth() - this.bTk) - this.bTn.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void iz(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bTl.getChildCount()) {
                View childAt = this.bTl.getChildAt(i3);
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

    public void setDataLoadInterface(cb cbVar) {
        this.bTw = cbVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.bTx = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.bTx;
    }

    public void setTabBackgroudColor(int i) {
        this.bTt = i;
    }

    public void ws() {
        ap.k(this, this.bTt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bTl.getChildCount()) {
                View childAt = this.bTl.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (iB(((TabItemView) childAt).getTabId())) {
                        ap.i(childAt, r.e.cp_other_b);
                    } else {
                        ((TabItemView) childAt).ws();
                    }
                }
                i = i2 + 1;
            } else {
                this.bTm.ws();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bTr = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void iA(int i) {
        if (this.bTn != null && this.bTw != null) {
            this.bTw.a(this.bTn.getTabId(), i, null);
        }
    }

    public static boolean iB(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.bTs = z;
        invalidate();
    }
}
