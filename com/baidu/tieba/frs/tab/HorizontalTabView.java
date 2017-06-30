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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.co;
import com.baidu.tieba.frs.cp;
import com.baidu.tieba.frs.tab.k;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements h {
    private List<j> aUW;
    private TbPageContext bzN;
    public int cnD;
    private final LinearLayout cnE;
    private final k cnF;
    private List<j> cnG;
    private TabItemView cnH;
    private h cnI;
    private final int cnJ;
    private final int cnK;
    private int cnL;
    private boolean cnM;
    private int cnN;
    private boolean cnO;
    private a cnP;
    private b cnQ;
    private k.b cnR;
    private k.a cnS;
    private bz cnT;
    private c cnU;
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
        void iI(int i);

        boolean iJ(int i);
    }

    public void ahq() {
        cp cpVar;
        if (this.bzN != null) {
            ArrayList arrayList = new ArrayList();
            if (this.aUW != null && this.aUW.size() > 0 && this.aUW.get(0) != null && (cpVar = this.aUW.get(0).cnZ) != null && cpVar.ceU != null) {
                for (co coVar : cpVar.ceU) {
                    if (coVar != null) {
                        arrayList.add(coVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.bzN.getPageActivity());
                cVar.a(arrayList, new d(this, cpVar));
                cVar.d(this.bzN);
                cVar.td();
            }
        }
    }

    public j jb(int i) {
        if (!z.t(this.cnG)) {
            for (j jVar : this.cnG) {
                if (jVar != null && jVar.cnY == i) {
                    return jVar;
                }
            }
        }
        return null;
    }

    public void c(j jVar) {
        cf cfVar;
        if (jVar != null) {
            if (this.cnQ != null) {
                this.cnQ.b(jVar);
            }
            if (jVar.cnY == 49) {
                TiebaStatic.log("c11841");
            }
            if (jg(jVar.cnY)) {
                if (this.cnT != null && !TextUtils.isEmpty(jVar.url)) {
                    cf cfVar2 = new cf();
                    cfVar2.cfg = jVar.url;
                    this.cnT.a(jVar.cnY, -1, cfVar2);
                }
            } else if (jVar.cnY == 301) {
                if (this.cnT != null) {
                    this.cnT.a(jVar.cnY, -1, null);
                }
            } else {
                for (int i = 0; i < this.cnE.getChildCount(); i++) {
                    View childAt = this.cnE.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(jVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(jVar.url)) {
                    cfVar = null;
                } else {
                    cfVar = new cf();
                    cfVar.cfg = jVar.url;
                    cfVar.stType = jVar.name;
                }
                if (this.cnT != null) {
                    this.cnT.a(jVar.cnY, 0, cfVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        cf cfVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (jg(tabItemView.getTabId())) {
                if (this.cnT != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    cf cfVar2 = new cf();
                    cfVar2.cfg = tabItemView.getUrl();
                    this.cnT.a(tabItemView.getTabId(), -1, cfVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cnT != null) {
                    this.cnT.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cnH = tabItemView;
                int[] iArr = new int[2];
                this.cnH.getLocationOnScreen(iArr);
                int af = com.baidu.adp.lib.util.k.af(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds160);
                if (iArr[0] < 0) {
                    post(new e(this, dimensionPixelSize));
                } else if (af < dimensionPixelSize) {
                    post(new f(this));
                }
                for (int i2 = 0; i2 < this.cnE.getChildCount(); i2++) {
                    View childAt = this.cnE.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cnH.getTabId() && !jg(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.coa);
                        }
                    }
                }
                if (this.cnH.getState() == TabItemView.coa || this.cnH.getState() == TabItemView.coc) {
                    this.cnF.aht();
                    boolean z2 = this.cnH.getState() == TabItemView.coa;
                    this.cnH.setState(TabItemView.cob);
                    j jc = jc(this.cnH.getTabId());
                    if (jc != null) {
                        if (!TextUtils.isEmpty(jc.url)) {
                            cf cfVar3 = new cf();
                            cfVar3.cfg = jc.url;
                            cfVar3.stType = jc.name;
                            cfVar = cfVar3;
                        }
                        if (jc.cnZ != null && jc.cnZ.ceU != null && jc.cnZ.ceU.size() > 0) {
                            for (co coVar : jc.cnZ.ceU) {
                                if (coVar != null && coVar.isSelected) {
                                    i = coVar.ceQ;
                                }
                            }
                        }
                        if (z2 && this.cnT != null) {
                            this.cnT.a(this.cnH.getTabId(), i, cfVar);
                        }
                    } else {
                        return;
                    }
                } else if (jd(this.cnH.getTabId()) && !z) {
                    if (this.cnU == null || this.cnU.iJ(this.cnH.getTabId())) {
                        this.cnH.setState(TabItemView.coc);
                        this.cnF.a((Activity) getContext(), this, this.cnH, jc(this.cnH.getTabId()).cnZ);
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
        this.cnD = 0;
        this.cnH = null;
        this.cnI = null;
        this.mPaint = new Paint();
        this.cnJ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.cnK = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.cnL = 0;
        this.cnM = true;
        this.cnN = w.e.transparent;
        this.cnR = new com.baidu.tieba.frs.tab.a(this);
        this.cnS = new com.baidu.tieba.frs.tab.b(this);
        this.mOnClickListener = new com.baidu.tieba.frs.tab.c(this);
        this.bzN = tbPageContext;
        this.cnE = new LinearLayout(tbPageContext.getPageActivity());
        this.cnE.setOrientation(0);
        this.cnE.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(w.f.ds88));
        this.cnF = new k(tbPageContext.getPageActivity(), this.cnR, this.cnS);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cnD = 0;
        this.cnH = null;
        this.cnI = null;
        this.mPaint = new Paint();
        this.cnJ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.cnK = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.cnL = 0;
        this.cnM = true;
        this.cnN = w.e.transparent;
        this.cnR = new com.baidu.tieba.frs.tab.a(this);
        this.cnS = new com.baidu.tieba.frs.tab.b(this);
        this.mOnClickListener = new com.baidu.tieba.frs.tab.c(this);
        this.cnE = new LinearLayout(context);
        this.cnE.setOrientation(0);
        this.cnE.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(w.f.ds88));
        this.cnF = new k(context, this.cnR, this.cnS);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cnD = 0;
        this.cnH = null;
        this.cnI = null;
        this.mPaint = new Paint();
        this.cnJ = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.cnK = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.cnL = 0;
        this.cnM = true;
        this.cnN = w.e.transparent;
        this.cnR = new com.baidu.tieba.frs.tab.a(this);
        this.cnS = new com.baidu.tieba.frs.tab.b(this);
        this.mOnClickListener = new com.baidu.tieba.frs.tab.c(this);
        this.cnE = new LinearLayout(activity);
        this.cnE.setOrientation(0);
        this.cnE.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cnF = new k(activity, this.cnR, this.cnS);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cnE, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        as.k(this, w.e.transparent);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aB(List<j> list) {
        j jVar;
        if (list == null) {
            return false;
        }
        j jc = jc(1);
        Iterator<j> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                jVar = null;
                break;
            }
            j next = it.next();
            if (next != null && next.cnY == 1) {
                jVar = next;
                break;
            }
        }
        if (jc == null || jVar == null) {
            return false;
        }
        if (jc.cnZ == null && jVar.cnZ == null) {
            return false;
        }
        if ((jc.cnZ != null || jVar.cnZ == null) && (jVar.cnZ != null || jc.cnZ == null)) {
            if (jc.cnZ == null || jVar.cnZ == null) {
                return false;
            }
            if (jc.cnZ.ceU == null && jVar.cnZ.ceU == null) {
                return false;
            }
            if ((jc.cnZ.ceU != null || jVar.cnZ.ceU == null) && (jVar.cnZ.ceU != null || jc.cnZ.ceU == null)) {
                int size = jc.cnZ.ceU.size();
                if (size != jVar.cnZ.ceU.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    co coVar = jVar.cnZ.ceU.get(i);
                    co coVar2 = jc.cnZ.ceU.get(i);
                    if (coVar.ceQ != coVar2.ceQ || !coVar.name.equals(coVar2.name)) {
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
        cp cpVar;
        if (this.cnO) {
            this.cnG = new ArrayList();
            this.cnG.addAll(list);
            if (list != null && list.size() > 0 && (jVar = list.get(0)) != null && jVar.cnY == 1) {
                cp cpVar2 = jVar.cnZ;
                if (cpVar2 != null && cpVar2.ceU != null) {
                    cpVar2.ceU.clear();
                    cpVar = cpVar2;
                } else {
                    cp cpVar3 = new cp();
                    cpVar3.ceU = new ArrayList();
                    cpVar = cpVar3;
                }
                co coVar = new co();
                coVar.ceQ = 1;
                coVar.name = getContext().getString(w.l.chosen_pb_title);
                cpVar.ceU.add(coVar);
                for (j jVar2 : list) {
                    if (jVar2 != null && jVar2.cnY != 1) {
                        co coVar2 = new co();
                        coVar2.ceQ = jVar2.cnY;
                        coVar2.name = jVar2.name;
                        cpVar.ceU.add(coVar2);
                    }
                }
                jVar.cnZ = cpVar;
                list.clear();
                list.add(jVar);
            }
        } else {
            this.cnG = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<j> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cnL > 0 && list.size() == this.cnL) {
            layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.k.af(getContext()) / this.cnL, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.aUW = null;
            j jVar = new j();
            jVar.cnY = 1;
            jVar.name = getContext().getResources().getString(w.l.chosen_pb_title);
            this.cnE.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), jVar, i2, this.cnO);
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
            this.cnE.addView(tabItemView, layoutParams);
            this.cnH = tabItemView;
            tabItemView.setState(TabItemView.cob);
            return;
        }
        setVisibility(0);
        if (this.aUW == null || aB(list)) {
            this.aUW = list;
            this.cnE.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    j jVar2 = list.get(i4);
                    if (jVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), jVar2, i2, this.cnO);
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (jg(jVar2.cnY)) {
                            as.i(tabItemView2, w.e.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
                        }
                        this.cnE.addView(tabItemView2, layoutParams);
                        if (jVar2.cnY == i) {
                            this.cnH = tabItemView2;
                            tabItemView2.setState(TabItemView.cob);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private j jc(int i) {
        if (i < 0 || this.cnG == null || this.cnG.size() == 0) {
            return null;
        }
        for (j jVar : this.cnG) {
            if (jVar != null && jVar.cnY == i) {
                return jVar;
            }
        }
        return null;
    }

    private boolean jd(int i) {
        j jc = jc(i);
        return (jc == null || jc.cnZ == null || jc.cnZ.ceU == null || jc.cnZ.ceU.size() <= 0) ? false : true;
    }

    public void setFakeTab(h hVar) {
        this.cnI = hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cnH != null) {
            this.mPaint.setColor(as.getColor(w.e.cp_bg_line_b));
            if (this.cnM) {
                canvas.drawRect(this.cnE.getLeft(), getMeasuredHeight() - this.cnK, this.cnE.getRight() > getRight() ? this.cnE.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cnO) {
                this.mPaint.setColor(as.d((Resources) null, w.e.cp_link_tip_a));
                canvas.drawRect(this.cnH.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cnJ, (this.cnH.getRight() - getBottomLineMargin()) - this.cnH.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cnO) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(as.d((Resources) null, w.e.cp_cont_b));
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds96);
            if (this.cnH != null) {
                g = this.cnH.getRight() - this.cnH.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds32), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds72), g, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds76)), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cnH == null || this.cnD == 0) {
            return 0;
        }
        return ((this.cnH.getMeasuredWidth() - this.cnD) - this.cnH.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void je(int i) {
        c(jb(i));
    }

    public void setDataLoadInterface(bz bzVar) {
        this.cnT = bzVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cnU = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cnU;
    }

    public void setTabBackgroudColor(int i) {
        this.cnN = i;
    }

    public void wK() {
        as.k(this, this.cnN);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cnE.getChildCount()) {
                View childAt = this.cnE.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (jg(((TabItemView) childAt).getTabId())) {
                        as.i(childAt, w.e.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).wK();
                    }
                }
                i = i2 + 1;
            } else {
                this.cnF.wK();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cnL = i;
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void jf(int i) {
        if (this.cnH != null && this.cnT != null) {
            this.cnT.a(this.cnH.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cnP = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cnQ = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cnO = z;
    }

    public static boolean jg(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cnM = z;
        invalidate();
    }
}
