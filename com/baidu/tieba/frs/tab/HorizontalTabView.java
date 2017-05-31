package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.frs.tab.k;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements h {
    private List<j> aTD;
    private TbPageContext byP;
    private b cfA;
    private k.b cfB;
    private k.a cfC;
    private by cfD;
    private c cfE;
    public int cfn;
    private final LinearLayout cfo;
    private final k cfp;
    private List<j> cfq;
    private TabItemView cfr;
    private h cfs;
    private final int cft;
    private final int cfu;
    private int cfv;
    private boolean cfw;
    private int cfx;
    private boolean cfy;
    private a cfz;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void a(j jVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(j jVar);
    }

    /* loaded from: classes.dex */
    public interface c {
        void iw(int i);

        boolean ix(int i);
    }

    public void ady() {
        co coVar;
        if (this.byP != null) {
            ArrayList arrayList = new ArrayList();
            if (this.aTD != null && this.aTD.size() > 0 && this.aTD.get(0) != null && (coVar = this.aTD.get(0).cfJ) != null && coVar.bWM != null) {
                for (cn cnVar : coVar.bWM) {
                    if (cnVar != null) {
                        arrayList.add(cnVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.byP.getPageActivity());
                cVar.a(arrayList, new d(this, coVar));
                cVar.d(this.byP);
                cVar.tf();
            }
        }
    }

    public j iP(int i) {
        if (!x.r(this.cfq)) {
            for (j jVar : this.cfq) {
                if (jVar != null && jVar.cfI == i) {
                    return jVar;
                }
            }
        }
        return null;
    }

    public void c(j jVar) {
        ce ceVar;
        if (jVar != null) {
            if (this.cfA != null) {
                this.cfA.b(jVar);
            }
            if (jVar.cfI == 49) {
                TiebaStatic.log("c11841");
            }
            if (iU(jVar.cfI)) {
                if (this.cfD != null && !TextUtils.isEmpty(jVar.url)) {
                    ce ceVar2 = new ce();
                    ceVar2.bWX = jVar.url;
                    this.cfD.a(jVar.cfI, -1, ceVar2);
                }
            } else if (jVar.cfI == 301) {
                if (this.cfD != null) {
                    this.cfD.a(jVar.cfI, -1, null);
                }
            } else {
                for (int i = 0; i < this.cfo.getChildCount(); i++) {
                    View childAt = this.cfo.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(jVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(jVar.url)) {
                    ceVar = null;
                } else {
                    ceVar = new ce();
                    ceVar.bWX = jVar.url;
                    ceVar.stType = jVar.name;
                }
                if (this.cfD != null) {
                    this.cfD.a(jVar.cfI, 0, ceVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ce ceVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (iU(tabItemView.getTabId())) {
                if (this.cfD != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ce ceVar2 = new ce();
                    ceVar2.bWX = tabItemView.getUrl();
                    this.cfD.a(tabItemView.getTabId(), -1, ceVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cfD != null) {
                    this.cfD.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cfr = tabItemView;
                int[] iArr = new int[2];
                this.cfr.getLocationOnScreen(iArr);
                int af = com.baidu.adp.lib.util.k.af(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds160);
                if (iArr[0] < 0) {
                    post(new e(this, dimensionPixelSize));
                } else if (af < dimensionPixelSize) {
                    post(new f(this));
                }
                for (int i2 = 0; i2 < this.cfo.getChildCount(); i2++) {
                    View childAt = this.cfo.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cfr.getTabId() && !iU(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cfK);
                        }
                    }
                }
                if (this.cfr.getState() == TabItemView.cfK || this.cfr.getState() == TabItemView.cfM) {
                    this.cfp.adA();
                    boolean z2 = this.cfr.getState() == TabItemView.cfK;
                    this.cfr.setState(TabItemView.cfL);
                    j iQ = iQ(this.cfr.getTabId());
                    if (iQ != null) {
                        if (!TextUtils.isEmpty(iQ.url)) {
                            ce ceVar3 = new ce();
                            ceVar3.bWX = iQ.url;
                            ceVar3.stType = iQ.name;
                            ceVar = ceVar3;
                        }
                        if (iQ.cfJ != null && iQ.cfJ.bWM != null && iQ.cfJ.bWM.size() > 0) {
                            for (cn cnVar : iQ.cfJ.bWM) {
                                if (cnVar != null && cnVar.isSelected) {
                                    i = cnVar.bWI;
                                }
                            }
                        }
                        if (z2 && this.cfD != null) {
                            this.cfD.a(this.cfr.getTabId(), i, ceVar);
                        }
                    } else {
                        return;
                    }
                } else if (iR(this.cfr.getTabId()) && !z) {
                    if (this.cfE == null || this.cfE.ix(this.cfr.getTabId())) {
                        this.cfr.setState(TabItemView.cfM);
                        this.cfp.a((Activity) getContext(), this, this.cfr, iQ(this.cfr.getTabId()).cfJ);
                    } else {
                        return;
                    }
                }
                invalidate();
            }
        }
    }

    public HorizontalTabView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cfn = 0;
        this.cfr = null;
        this.cfs = null;
        this.mPaint = new Paint();
        this.cft = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.cfu = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.cfv = 0;
        this.cfw = true;
        this.cfx = w.e.transparent;
        this.cfB = new com.baidu.tieba.frs.tab.a(this);
        this.cfC = new com.baidu.tieba.frs.tab.b(this);
        this.mOnClickListener = new com.baidu.tieba.frs.tab.c(this);
        this.byP = tbPageContext;
        this.cfo = new LinearLayout(tbPageContext.getPageActivity());
        this.cfo.setOrientation(0);
        this.cfo.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(w.f.ds88));
        this.cfp = new k(tbPageContext.getPageActivity(), this.cfB, this.cfC);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cfn = 0;
        this.cfr = null;
        this.cfs = null;
        this.mPaint = new Paint();
        this.cft = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.cfu = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.cfv = 0;
        this.cfw = true;
        this.cfx = w.e.transparent;
        this.cfB = new com.baidu.tieba.frs.tab.a(this);
        this.cfC = new com.baidu.tieba.frs.tab.b(this);
        this.mOnClickListener = new com.baidu.tieba.frs.tab.c(this);
        this.cfo = new LinearLayout(context);
        this.cfo.setOrientation(0);
        this.cfo.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(w.f.ds88));
        this.cfp = new k(context, this.cfB, this.cfC);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cfn = 0;
        this.cfr = null;
        this.cfs = null;
        this.mPaint = new Paint();
        this.cft = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.cfu = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.cfv = 0;
        this.cfw = true;
        this.cfx = w.e.transparent;
        this.cfB = new com.baidu.tieba.frs.tab.a(this);
        this.cfC = new com.baidu.tieba.frs.tab.b(this);
        this.mOnClickListener = new com.baidu.tieba.frs.tab.c(this);
        this.cfo = new LinearLayout(activity);
        this.cfo.setOrientation(0);
        this.cfo.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cfp = new k(activity, this.cfB, this.cfC);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cfo, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        aq.k(this, w.e.transparent);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean as(List<j> list) {
        j jVar;
        if (list == null) {
            return false;
        }
        j iQ = iQ(1);
        Iterator<j> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                jVar = null;
                break;
            }
            j next = it.next();
            if (next != null && next.cfI == 1) {
                jVar = next;
                break;
            }
        }
        if (iQ == null || jVar == null) {
            return false;
        }
        if (iQ.cfJ == null && jVar.cfJ == null) {
            return false;
        }
        if ((iQ.cfJ != null || jVar.cfJ == null) && (jVar.cfJ != null || iQ.cfJ == null)) {
            if (iQ.cfJ == null || jVar.cfJ == null) {
                return false;
            }
            if (iQ.cfJ.bWM == null && jVar.cfJ.bWM == null) {
                return false;
            }
            if ((iQ.cfJ.bWM != null || jVar.cfJ.bWM == null) && (jVar.cfJ.bWM != null || iQ.cfJ.bWM == null)) {
                int size = iQ.cfJ.bWM.size();
                if (size != jVar.cfJ.bWM.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    cn cnVar = jVar.cfJ.bWM.get(i);
                    cn cnVar2 = iQ.cfJ.bWM.get(i);
                    if (cnVar.bWI != cnVar2.bWI || !cnVar.name.equals(cnVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void d(List<j> list, int i, int i2) {
        j jVar;
        co coVar;
        if (this.cfy) {
            this.cfq = new ArrayList();
            this.cfq.addAll(list);
            if (list != null && list.size() > 0 && (jVar = list.get(0)) != null && jVar.cfI == 1) {
                co coVar2 = jVar.cfJ;
                if (coVar2 != null && coVar2.bWM != null) {
                    coVar2.bWM.clear();
                    coVar = coVar2;
                } else {
                    co coVar3 = new co();
                    coVar3.bWM = new ArrayList();
                    coVar = coVar3;
                }
                cn cnVar = new cn();
                cnVar.bWI = 1;
                cnVar.name = getContext().getString(w.l.chosen_pb_title);
                coVar.bWM.add(cnVar);
                for (j jVar2 : list) {
                    if (jVar2 != null && jVar2.cfI != 1) {
                        cn cnVar2 = new cn();
                        cnVar2.bWI = jVar2.cfI;
                        cnVar2.name = jVar2.name;
                        coVar.bWM.add(cnVar2);
                    }
                }
                jVar.cfJ = coVar;
                list.clear();
                list.add(jVar);
            }
        } else {
            this.cfq = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<j> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cfv > 0 && list.size() == this.cfv) {
            layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.k.af(getContext()) / this.cfv, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.aTD = null;
            j jVar = new j();
            jVar.cfI = 1;
            jVar.name = getContext().getResources().getString(w.l.chosen_pb_title);
            this.cfo.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), jVar, i2, this.cfy);
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
            this.cfo.addView(tabItemView, layoutParams);
            this.cfr = tabItemView;
            tabItemView.setState(TabItemView.cfL);
            return;
        }
        setVisibility(0);
        if (this.aTD == null || as(list)) {
            this.aTD = list;
            this.cfo.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    j jVar2 = list.get(i4);
                    if (jVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), jVar2, i2, this.cfy);
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (iU(jVar2.cfI)) {
                            aq.i(tabItemView2, w.e.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
                        }
                        this.cfo.addView(tabItemView2, layoutParams);
                        if (jVar2.cfI == i) {
                            this.cfr = tabItemView2;
                            tabItemView2.setState(TabItemView.cfL);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private j iQ(int i) {
        if (i < 0 || this.cfq == null || this.cfq.size() == 0) {
            return null;
        }
        for (j jVar : this.cfq) {
            if (jVar != null && jVar.cfI == i) {
                return jVar;
            }
        }
        return null;
    }

    private boolean iR(int i) {
        j iQ = iQ(i);
        return (iQ == null || iQ.cfJ == null || iQ.cfJ.bWM == null || iQ.cfJ.bWM.size() <= 0) ? false : true;
    }

    public void setFakeTab(h hVar) {
        this.cfs = hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cfr != null) {
            this.mPaint.setColor(aq.getColor(w.e.cp_bg_line_b));
            if (this.cfw) {
                canvas.drawRect(this.cfo.getLeft(), getMeasuredHeight() - this.cfu, this.cfo.getRight() > getRight() ? this.cfo.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cfy) {
                this.mPaint.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
                canvas.drawRect(this.cfr.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cft, (this.cfr.getRight() - getBottomLineMargin()) - this.cfr.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cfy) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(aq.d((Resources) null, w.e.cp_cont_b));
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds96);
            if (this.cfr != null) {
                g = this.cfr.getRight() - this.cfr.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds32), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds72), g, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds76)), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cfr == null || this.cfn == 0) {
            return 0;
        }
        return ((this.cfr.getMeasuredWidth() - this.cfn) - this.cfr.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void iS(int i) {
        c(iP(i));
    }

    public void setDataLoadInterface(by byVar) {
        this.cfD = byVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cfE = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cfE;
    }

    public void setTabBackgroudColor(int i) {
        this.cfx = i;
    }

    public void ws() {
        aq.k(this, this.cfx);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cfo.getChildCount()) {
                View childAt = this.cfo.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (iU(((TabItemView) childAt).getTabId())) {
                        aq.i(childAt, w.e.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).ws();
                    }
                }
                i = i2 + 1;
            } else {
                this.cfp.ws();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cfv = i;
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void iT(int i) {
        if (this.cfr != null && this.cfD != null) {
            this.cfD.a(this.cfr.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cfz = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cfA = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cfy = z;
    }

    public static boolean iU(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cfw = z;
        invalidate();
    }
}
