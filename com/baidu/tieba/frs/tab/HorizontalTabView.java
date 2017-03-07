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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cj;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements g {
    private List<i> aVq;
    private g caA;
    private final int caB;
    private final int caC;
    private int caD;
    private boolean caE;
    private int caF;
    private j.b caG;
    private j.a caH;
    private cb caI;
    private a caJ;
    public int caw;
    private final LinearLayout cax;
    private final j cay;
    private TabItemView caz;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void hZ(int i);

        boolean ia(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        cj cjVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (ix(tabItemView.getTabId())) {
                if (this.caI != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    cj cjVar2 = new cj();
                    cjVar2.bQr = tabItemView.getUrl();
                    this.caI.a(tabItemView.getTabId(), -1, cjVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.caI != null) {
                    this.caI.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.caz = tabItemView;
                int[] iArr = new int[2];
                this.caz.getLocationOnScreen(iArr);
                int ag = com.baidu.adp.lib.util.k.ag(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds160);
                if (iArr[0] < 0) {
                    post(new d(this, dimensionPixelSize));
                } else if (ag < dimensionPixelSize) {
                    post(new e(this));
                }
                for (int i2 = 0; i2 < this.cax.getChildCount(); i2++) {
                    View childAt = this.cax.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.caz.getTabId() && !ix(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.caO);
                        }
                    }
                }
                if (this.caz.getState() == TabItemView.caO || this.caz.getState() == TabItemView.caQ) {
                    this.cay.adz();
                    boolean z2 = this.caz.getState() == TabItemView.caO;
                    this.caz.setState(TabItemView.caP);
                    i it = it(this.caz.getTabId());
                    if (!TextUtils.isEmpty(it.url)) {
                        cj cjVar3 = new cj();
                        cjVar3.bQr = it.url;
                        cjVar3.stType = it.name;
                        cjVar = cjVar3;
                    }
                    if (it.caN != null && it.caN.bQd != null && it.caN.bQd.size() > 0) {
                        for (ct ctVar : it.caN.bQd) {
                            if (ctVar != null && ctVar.isSelected) {
                                i = ctVar.bPZ;
                            }
                        }
                    }
                    if (z2 && this.caI != null) {
                        this.caI.a(this.caz.getTabId(), i, cjVar);
                    }
                } else if (iu(this.caz.getTabId()) && !z) {
                    if (this.caJ == null || this.caJ.ia(this.caz.getTabId())) {
                        this.caz.setState(TabItemView.caQ);
                        this.cay.a((Activity) getContext(), this, this.caz, it(this.caz.getTabId()).caN);
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
        this.caw = 0;
        this.caz = null;
        this.caA = null;
        this.mPaint = new Paint();
        this.caB = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.caC = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.caD = 0;
        this.caE = true;
        this.caF = w.e.common_color_10059;
        this.caG = new com.baidu.tieba.frs.tab.a(this);
        this.caH = new b(this);
        this.mOnClickListener = new c(this);
        this.cax = new LinearLayout(activity);
        this.cax.setOrientation(0);
        this.cax.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(w.f.ds80));
        this.cay = new j(activity, this.caG, this.caH);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.caw = 0;
        this.caz = null;
        this.caA = null;
        this.mPaint = new Paint();
        this.caB = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.caC = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.caD = 0;
        this.caE = true;
        this.caF = w.e.common_color_10059;
        this.caG = new com.baidu.tieba.frs.tab.a(this);
        this.caH = new b(this);
        this.mOnClickListener = new c(this);
        this.cax = new LinearLayout(context);
        this.cax.setOrientation(0);
        this.cax.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(w.f.ds80));
        this.cay = new j(context, this.caG, this.caH);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.caw = 0;
        this.caz = null;
        this.caA = null;
        this.mPaint = new Paint();
        this.caB = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.caC = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.caD = 0;
        this.caE = true;
        this.caF = w.e.common_color_10059;
        this.caG = new com.baidu.tieba.frs.tab.a(this);
        this.caH = new b(this);
        this.mOnClickListener = new c(this);
        this.cax = new LinearLayout(activity);
        this.cax.setOrientation(0);
        this.cax.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cay = new j(activity, this.caG, this.caH);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cax, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        aq.k(this, w.e.common_color_10059);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aw(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i it = it(1);
        Iterator<i> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                iVar = null;
                break;
            }
            i next = it2.next();
            if (next != null && next.caM == 1) {
                iVar = next;
                break;
            }
        }
        if (it == null || iVar == null) {
            return false;
        }
        if (it.caN == null && iVar.caN == null) {
            return false;
        }
        if ((it.caN != null || iVar.caN == null) && (iVar.caN != null || it.caN == null)) {
            if (it.caN == null || iVar.caN == null) {
                return false;
            }
            if (it.caN.bQd == null && iVar.caN.bQd == null) {
                return false;
            }
            if ((it.caN.bQd != null || iVar.caN.bQd == null) && (iVar.caN.bQd != null || it.caN.bQd == null)) {
                int size = it.caN.bQd.size();
                if (size != iVar.caN.bQd.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ct ctVar = iVar.caN.bQd.get(i);
                    ct ctVar2 = it.caN.bQd.get(i);
                    if (ctVar.bPZ != ctVar2.bPZ || !ctVar.name.equals(ctVar2.name)) {
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
        if (this.caD > 0 && list.size() == this.caD) {
            layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.k.ag(getContext()) / this.caD, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.aVq = null;
            i iVar = new i();
            iVar.caM = 1;
            iVar.name = getContext().getResources().getString(w.l.chosen_pb_title);
            this.cax.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
            this.cax.addView(tabItemView, layoutParams);
            this.caz = tabItemView;
            tabItemView.setState(TabItemView.caP);
            return;
        }
        setVisibility(0);
        if (this.aVq == null || aw(list)) {
            this.aVq = list;
            this.cax.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    i iVar2 = list.get(i4);
                    if (iVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), iVar2, i2);
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (ix(iVar2.caM)) {
                            aq.i((View) tabItemView2, w.e.cp_other_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
                        }
                        this.cax.addView(tabItemView2, layoutParams);
                        if (iVar2.caM == i) {
                            this.caz = tabItemView2;
                            tabItemView2.setState(TabItemView.caP);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private i it(int i) {
        if (i < 0 || this.aVq == null || this.aVq.size() == 0) {
            return null;
        }
        for (i iVar : this.aVq) {
            if (iVar != null && iVar.caM == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean iu(int i) {
        i it = it(i);
        return (it == null || it.caN == null || it.caN.bQd == null || it.caN.bQd.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.caA = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.caz != null) {
            this.mPaint.setColor(aq.getColor(w.e.cp_bg_line_b));
            if (this.caE) {
                canvas.drawRect(this.cax.getLeft(), getMeasuredHeight() - this.caC, this.cax.getRight() > getRight() ? this.cax.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
            canvas.drawRect(this.caz.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.caB, (this.caz.getRight() - getBottomLineMargin()) - this.caz.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.caz == null || this.caw == 0) {
            return 0;
        }
        return ((this.caz.getMeasuredWidth() - this.caw) - this.caz.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void iv(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.cax.getChildCount()) {
                View childAt = this.cax.getChildAt(i3);
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
        this.caI = cbVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.caJ = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.caJ;
    }

    public void setTabBackgroudColor(int i) {
        this.caF = i;
    }

    public void wP() {
        aq.k(this, this.caF);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cax.getChildCount()) {
                View childAt = this.cax.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (ix(((TabItemView) childAt).getTabId())) {
                        aq.i(childAt, w.e.cp_other_b);
                    } else {
                        ((TabItemView) childAt).wP();
                    }
                }
                i = i2 + 1;
            } else {
                this.cay.wP();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.caD = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void iw(int i) {
        if (this.caz != null && this.caI != null) {
            this.caI.a(this.caz.getTabId(), i, null);
        }
    }

    public static boolean ix(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.caE = z;
        invalidate();
    }
}
