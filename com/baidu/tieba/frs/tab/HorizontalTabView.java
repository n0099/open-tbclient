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
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.w;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements g {
    private List<i> aVD;
    public int bYX;
    private final LinearLayout bYY;
    private final j bYZ;
    private TabItemView bZa;
    private g bZb;
    private final int bZc;
    private final int bZd;
    private int bZe;
    private boolean bZf;
    private int bZg;
    private j.b bZh;
    private j.a bZi;
    private cd bZj;
    private a bZk;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void ic(int i);

        boolean id(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        cl clVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (iy(tabItemView.getTabId())) {
                if (this.bZj != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    cl clVar2 = new cl();
                    clVar2.bQg = tabItemView.getUrl();
                    this.bZj.a(tabItemView.getTabId(), -1, clVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.bZj != null) {
                    this.bZj.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.bZa = tabItemView;
                int[] iArr = new int[2];
                this.bZa.getLocationOnScreen(iArr);
                int af = com.baidu.adp.lib.util.k.af(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds160);
                if (iArr[0] < 0) {
                    post(new d(this, dimensionPixelSize));
                } else if (af < dimensionPixelSize) {
                    post(new e(this));
                }
                for (int i2 = 0; i2 < this.bYY.getChildCount(); i2++) {
                    View childAt = this.bYY.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.bZa.getTabId() && !iy(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.bZp);
                        }
                    }
                }
                if (this.bZa.getState() == TabItemView.bZp || this.bZa.getState() == TabItemView.bZr) {
                    this.bYZ.adt();
                    boolean z2 = this.bZa.getState() == TabItemView.bZp;
                    this.bZa.setState(TabItemView.bZq);
                    i iu = iu(this.bZa.getTabId());
                    if (!TextUtils.isEmpty(iu.url)) {
                        cl clVar3 = new cl();
                        clVar3.bQg = iu.url;
                        clVar3.stType = iu.name;
                        clVar = clVar3;
                    }
                    if (iu.bZo != null && iu.bZo.bPS != null && iu.bZo.bPS.size() > 0) {
                        for (cv cvVar : iu.bZo.bPS) {
                            if (cvVar != null && cvVar.isSelected) {
                                i = cvVar.bPO;
                            }
                        }
                    }
                    if (z2 && this.bZj != null) {
                        this.bZj.a(this.bZa.getTabId(), i, clVar);
                    }
                } else if (iv(this.bZa.getTabId()) && !z) {
                    if (this.bZk == null || this.bZk.id(this.bZa.getTabId())) {
                        this.bZa.setState(TabItemView.bZr);
                        this.bYZ.a((Activity) getContext(), this, this.bZa, iu(this.bZa.getTabId()).bZo);
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
        this.bYX = 0;
        this.bZa = null;
        this.bZb = null;
        this.mPaint = new Paint();
        this.bZc = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.bZd = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.bZe = 0;
        this.bZf = true;
        this.bZg = w.e.common_color_10059;
        this.bZh = new com.baidu.tieba.frs.tab.a(this);
        this.bZi = new b(this);
        this.mOnClickListener = new c(this);
        this.bYY = new LinearLayout(activity);
        this.bYY.setOrientation(0);
        this.bYY.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(w.f.ds80));
        this.bYZ = new j(activity, this.bZh, this.bZi);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYX = 0;
        this.bZa = null;
        this.bZb = null;
        this.mPaint = new Paint();
        this.bZc = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.bZd = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.bZe = 0;
        this.bZf = true;
        this.bZg = w.e.common_color_10059;
        this.bZh = new com.baidu.tieba.frs.tab.a(this);
        this.bZi = new b(this);
        this.mOnClickListener = new c(this);
        this.bYY = new LinearLayout(context);
        this.bYY.setOrientation(0);
        this.bYY.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(w.f.ds80));
        this.bYZ = new j(context, this.bZh, this.bZi);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bYX = 0;
        this.bZa = null;
        this.bZb = null;
        this.mPaint = new Paint();
        this.bZc = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.bZd = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.bZe = 0;
        this.bZf = true;
        this.bZg = w.e.common_color_10059;
        this.bZh = new com.baidu.tieba.frs.tab.a(this);
        this.bZi = new b(this);
        this.mOnClickListener = new c(this);
        this.bYY = new LinearLayout(activity);
        this.bYY.setOrientation(0);
        this.bYY.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bYZ = new j(activity, this.bZh, this.bZi);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bYY, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        aq.k(this, w.e.common_color_10059);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean av(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i iu = iu(1);
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            i next = it.next();
            if (next != null && next.bZn == 1) {
                iVar = next;
                break;
            }
        }
        if (iu == null || iVar == null) {
            return false;
        }
        if (iu.bZo == null && iVar.bZo == null) {
            return false;
        }
        if ((iu.bZo != null || iVar.bZo == null) && (iVar.bZo != null || iu.bZo == null)) {
            if (iu.bZo == null || iVar.bZo == null) {
                return false;
            }
            if (iu.bZo.bPS == null && iVar.bZo.bPS == null) {
                return false;
            }
            if ((iu.bZo.bPS != null || iVar.bZo.bPS == null) && (iVar.bZo.bPS != null || iu.bZo.bPS == null)) {
                int size = iu.bZo.bPS.size();
                if (size != iVar.bZo.bPS.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    cv cvVar = iVar.bZo.bPS.get(i);
                    cv cvVar2 = iu.bZo.bPS.get(i);
                    if (cvVar.bPO != cvVar2.bPO || !cvVar.name.equals(cvVar2.name)) {
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
        if (this.bZe > 0 && list.size() == this.bZe) {
            layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.k.af(getContext()) / this.bZe, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.aVD = null;
            i iVar = new i();
            iVar.bZn = 1;
            iVar.name = getContext().getResources().getString(w.l.chosen_pb_title);
            this.bYY.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
            this.bYY.addView(tabItemView, layoutParams);
            this.bZa = tabItemView;
            tabItemView.setState(TabItemView.bZq);
            return;
        }
        setVisibility(0);
        if (this.aVD == null || av(list)) {
            this.aVD = list;
            this.bYY.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    i iVar2 = list.get(i4);
                    if (iVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), iVar2, i2);
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (iy(iVar2.bZn)) {
                            aq.i(tabItemView2, w.e.cp_other_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
                        }
                        this.bYY.addView(tabItemView2, layoutParams);
                        if (iVar2.bZn == i) {
                            this.bZa = tabItemView2;
                            tabItemView2.setState(TabItemView.bZq);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private i iu(int i) {
        if (i < 0 || this.aVD == null || this.aVD.size() == 0) {
            return null;
        }
        for (i iVar : this.aVD) {
            if (iVar != null && iVar.bZn == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean iv(int i) {
        i iu = iu(i);
        return (iu == null || iu.bZo == null || iu.bZo.bPS == null || iu.bZo.bPS.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.bZb = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bZa != null) {
            this.mPaint.setColor(aq.getColor(w.e.cp_bg_line_b));
            if (this.bZf) {
                canvas.drawRect(this.bYY.getLeft(), getMeasuredHeight() - this.bZd, this.bYY.getRight() > getRight() ? this.bYY.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
            canvas.drawRect(this.bZa.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.bZc, (this.bZa.getRight() - getBottomLineMargin()) - this.bZa.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.bZa == null || this.bYX == 0) {
            return 0;
        }
        return ((this.bZa.getMeasuredWidth() - this.bYX) - this.bZa.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void iw(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bYY.getChildCount()) {
                View childAt = this.bYY.getChildAt(i3);
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
        this.bZj = cdVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.bZk = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.bZk;
    }

    public void setTabBackgroudColor(int i) {
        this.bZg = i;
    }

    public void xl() {
        aq.k(this, this.bZg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bYY.getChildCount()) {
                View childAt = this.bYY.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (iy(((TabItemView) childAt).getTabId())) {
                        aq.i(childAt, w.e.cp_other_b);
                    } else {
                        ((TabItemView) childAt).xl();
                    }
                }
                i = i2 + 1;
            } else {
                this.bYZ.xl();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bZe = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void ix(int i) {
        if (this.bZa != null && this.bZj != null) {
            this.bZj.a(this.bZa.getTabId(), i, null);
        }
    }

    public static boolean iy(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.bZf = z;
        invalidate();
    }
}
