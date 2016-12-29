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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.r;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements g {
    private List<i> aUm;
    public int bMW;
    private final LinearLayout bMX;
    private final j bMY;
    private TabItemView bMZ;
    private g bNa;
    private final int bNb;
    private final int bNc;
    private int bNd;
    private boolean bNe;
    private int bNf;
    private j.b bNg;
    private j.a bNh;
    private cd bNi;
    private a bNj;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void hq(int i);

        boolean hr(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        cl clVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (hO(tabItemView.getTabId())) {
                if (this.bNi != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    cl clVar2 = new cl();
                    clVar2.bBQ = tabItemView.getUrl();
                    this.bNi.a(tabItemView.getTabId(), -1, clVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.bNi != null) {
                    this.bNi.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.bMZ = tabItemView;
                int[] iArr = new int[2];
                this.bMZ.getLocationOnScreen(iArr);
                int I = com.baidu.adp.lib.util.k.I(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(r.e.ds160);
                if (iArr[0] < 0) {
                    post(new d(this, dimensionPixelSize));
                } else if (I < dimensionPixelSize) {
                    post(new e(this));
                }
                for (int i2 = 0; i2 < this.bMX.getChildCount(); i2++) {
                    View childAt = this.bMX.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.bMZ.getTabId() && !hO(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.bNo);
                        }
                    }
                }
                if (this.bMZ.getState() == TabItemView.bNo || this.bMZ.getState() == TabItemView.bNq) {
                    this.bMY.abu();
                    boolean z2 = this.bMZ.getState() == TabItemView.bNo;
                    this.bMZ.setState(TabItemView.bNp);
                    i hK = hK(this.bMZ.getTabId());
                    if (!TextUtils.isEmpty(hK.url)) {
                        cl clVar3 = new cl();
                        clVar3.bBQ = hK.url;
                        clVar3.stType = hK.name;
                        clVar = clVar3;
                    }
                    if (hK.bNn != null && hK.bNn.bBA != null && hK.bNn.bBA.size() > 0) {
                        for (cx cxVar : hK.bNn.bBA) {
                            if (cxVar != null && cxVar.isSelected) {
                                i = cxVar.bBw;
                            }
                        }
                    }
                    if (z2 && this.bNi != null) {
                        this.bNi.a(this.bMZ.getTabId(), i, clVar);
                    }
                } else if (hL(this.bMZ.getTabId()) && !z) {
                    if (this.bNj == null || this.bNj.hr(this.bMZ.getTabId())) {
                        this.bMZ.setState(TabItemView.bNq);
                        this.bMY.a((Activity) getContext(), this, this.bMZ, hK(this.bMZ.getTabId()).bNn);
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
        this.bMW = 0;
        this.bMZ = null;
        this.bNa = null;
        this.mPaint = new Paint();
        this.bNb = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
        this.bNc = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
        this.bNd = 0;
        this.bNe = true;
        this.bNf = r.d.common_color_10059;
        this.bNg = new com.baidu.tieba.frs.tab.a(this);
        this.bNh = new b(this);
        this.mOnClickListener = new c(this);
        this.bMX = new LinearLayout(activity);
        this.bMX.setOrientation(0);
        this.bMX.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(r.e.ds80));
        this.bMY = new j(activity, this.bNg, this.bNh);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bMW = 0;
        this.bMZ = null;
        this.bNa = null;
        this.mPaint = new Paint();
        this.bNb = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
        this.bNc = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
        this.bNd = 0;
        this.bNe = true;
        this.bNf = r.d.common_color_10059;
        this.bNg = new com.baidu.tieba.frs.tab.a(this);
        this.bNh = new b(this);
        this.mOnClickListener = new c(this);
        this.bMX = new LinearLayout(context);
        this.bMX.setOrientation(0);
        this.bMX.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(r.e.ds80));
        this.bMY = new j(context, this.bNg, this.bNh);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bMW = 0;
        this.bMZ = null;
        this.bNa = null;
        this.mPaint = new Paint();
        this.bNb = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds6);
        this.bNc = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds1);
        this.bNd = 0;
        this.bNe = true;
        this.bNf = r.d.common_color_10059;
        this.bNg = new com.baidu.tieba.frs.tab.a(this);
        this.bNh = new b(this);
        this.mOnClickListener = new c(this);
        this.bMX = new LinearLayout(activity);
        this.bMX.setOrientation(0);
        this.bMX.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bMY = new j(activity, this.bNg, this.bNh);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bMX, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ar.l(this, r.d.common_color_10059);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean av(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i hK = hK(1);
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            i next = it.next();
            if (next != null && next.bNm == 1) {
                iVar = next;
                break;
            }
        }
        if (hK == null || iVar == null) {
            return false;
        }
        if (hK.bNn == null && iVar.bNn == null) {
            return false;
        }
        if ((hK.bNn != null || iVar.bNn == null) && (iVar.bNn != null || hK.bNn == null)) {
            if (hK.bNn == null || iVar.bNn == null) {
                return false;
            }
            if (hK.bNn.bBA == null && iVar.bNn.bBA == null) {
                return false;
            }
            if ((hK.bNn.bBA != null || iVar.bNn.bBA == null) && (iVar.bNn.bBA != null || hK.bNn.bBA == null)) {
                int size = hK.bNn.bBA.size();
                if (size != iVar.bNn.bBA.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    cx cxVar = iVar.bNn.bBA.get(i);
                    cx cxVar2 = hK.bNn.bBA.get(i);
                    if (cxVar.bBw != cxVar2.bBw || !cxVar.name.equals(cxVar2.name)) {
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
        if (this.bNd > 0 && list.size() == this.bNd) {
            layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.k.I(getContext()) / this.bNd, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(r.e.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.aUm = null;
            i iVar = new i();
            iVar.bNm = 1;
            iVar.name = getContext().getResources().getString(r.j.frs_tab_all_thread);
            this.bMX.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(r.e.ds32);
            this.bMX.addView(tabItemView, layoutParams);
            this.bMZ = tabItemView;
            tabItemView.setState(TabItemView.bNp);
            return;
        }
        setVisibility(0);
        if (this.aUm == null || av(list)) {
            this.aUm = list;
            this.bMX.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    i iVar2 = list.get(i4);
                    if (iVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), iVar2, i2);
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (hO(iVar2.bNm)) {
                            ar.j((View) tabItemView2, r.d.cp_other_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(r.e.ds32);
                        }
                        this.bMX.addView(tabItemView2, layoutParams);
                        if (iVar2.bNm == i) {
                            this.bMZ = tabItemView2;
                            tabItemView2.setState(TabItemView.bNp);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private i hK(int i) {
        if (i < 0 || this.aUm == null || this.aUm.size() == 0) {
            return null;
        }
        for (i iVar : this.aUm) {
            if (iVar != null && iVar.bNm == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean hL(int i) {
        i hK = hK(i);
        return (hK == null || hK.bNn == null || hK.bNn.bBA == null || hK.bNn.bBA.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.bNa = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bMZ != null) {
            this.mPaint.setColor(ar.getColor(r.d.cp_bg_line_b));
            if (this.bNe) {
                canvas.drawRect(this.bMX.getLeft(), getMeasuredHeight() - this.bNc, this.bMX.getRight() > getRight() ? this.bMX.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(ar.d((Resources) null, r.d.cp_link_tip_a));
            canvas.drawRect(this.bMZ.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.bNb, (this.bMZ.getRight() - getBottomLineMargin()) - this.bMZ.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.bMZ == null || this.bMW == 0) {
            return 0;
        }
        return ((this.bMZ.getMeasuredWidth() - this.bMW) - this.bMZ.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void hM(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bMX.getChildCount()) {
                View childAt = this.bMX.getChildAt(i3);
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

    public void setDataLoadInterface(cd cdVar) {
        this.bNi = cdVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.bNj = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.bNj;
    }

    public void setTabBackgroudColor(int i) {
        this.bNf = i;
    }

    public void wx() {
        ar.l(this, this.bNf);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bMX.getChildCount()) {
                View childAt = this.bMX.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (hO(((TabItemView) childAt).getTabId())) {
                        ar.j(childAt, r.d.cp_other_b);
                    } else {
                        ((TabItemView) childAt).wx();
                    }
                }
                i = i2 + 1;
            } else {
                this.bMY.wx();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bNd = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void hN(int i) {
        if (this.bMZ != null && this.bNi != null) {
            this.bNi.a(this.bMZ.getTabId(), i, null);
        }
    }

    public static boolean hO(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.bNe = z;
        invalidate();
    }
}
