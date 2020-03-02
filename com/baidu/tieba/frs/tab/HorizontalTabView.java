package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private final LinearLayout gJA;
    private final e gJB;
    private List<d> gJC;
    private TabItemView gJD;
    private com.baidu.tieba.frs.tab.b gJE;
    private final int gJF;
    private final int gJG;
    private int gJH;
    private boolean gJI;
    private int gJJ;
    private boolean gJK;
    private int gJL;
    private a gJM;
    private b gJN;
    private e.b gJO;
    private e.a gJP;
    private ag gJQ;
    private c gJR;
    public int gJz;
    private TbPageContext gdl;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes9.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes9.dex */
    public interface c {
        void ub(int i);

        boolean uc(int i);
    }

    public void bJL() {
        final at atVar;
        if (this.gdl != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (atVar = this.mData.get(0).gJU) != null && atVar.grV != null) {
                for (as asVar : atVar.grV) {
                    if (asVar != null) {
                        arrayList.add(asVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gdl.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (atVar.grV.size() > i && atVar.grV.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.tU(atVar.grV.get(i).grR));
                        }
                    }
                });
                bVar.d(this.gdl);
                bVar.aED();
            }
        }
    }

    public d tU(int i) {
        if (!v.isEmpty(this.gJC)) {
            for (d dVar : this.gJC) {
                if (dVar != null && dVar.tabId == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void a(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.tabId != 302 && this.gJN != null) {
                this.gJN.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (tZ(dVar.tabId)) {
                if (this.gJQ != null && !TextUtils.isEmpty(dVar.url)) {
                    an anVar = new an();
                    anVar.ext = dVar.url;
                    this.gJQ.a(dVar.tabId, -1, anVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.gJQ != null) {
                    this.gJQ.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.gJQ == null) {
                    z = true;
                } else {
                    an anVar2 = new an();
                    anVar2.ext = dVar.url;
                    anVar2.stType = dVar.name;
                    this.gJQ.a(dVar.tabId, 0, anVar2);
                    if (anVar2.gsr) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.gJA.getChildCount(); i++) {
                    View childAt = this.gJA.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                an anVar3 = null;
                if (!TextUtils.isEmpty(dVar.url)) {
                    anVar3 = new an();
                    anVar3.ext = dVar.url;
                    anVar3.stType = dVar.name;
                }
                if (this.gJQ != null && z) {
                    this.gJQ.a(dVar.tabId, 0, anVar3);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        an anVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (tZ(tabItemView.getTabId())) {
                if (this.gJQ != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    an anVar2 = new an();
                    anVar2.ext = tabItemView.getUrl();
                    this.gJQ.a(tabItemView.getTabId(), -1, anVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.gJQ != null) {
                    this.gJQ.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.gJD = tabItemView;
                int[] iArr = new int[2];
                this.gJD.getLocationOnScreen(iArr);
                int equipmentWidth = l.getEquipmentWidth(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (equipmentWidth < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.gJA.getChildCount(); i2++) {
                    View childAt = this.gJA.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.gJD.getTabId() && !tZ(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.gJV);
                        }
                    }
                }
                if (this.gJD.getState() == TabItemView.gJV || this.gJD.getState() == TabItemView.STATE_EXPANDED) {
                    this.gJB.dismissMenu();
                    boolean z2 = this.gJD.getState() == TabItemView.gJV;
                    this.gJD.setState(TabItemView.gJW);
                    d tV = tV(this.gJD.getTabId());
                    if (tV != null) {
                        if (!TextUtils.isEmpty(tV.url)) {
                            an anVar3 = new an();
                            anVar3.ext = tV.url;
                            anVar3.stType = tV.name;
                            anVar = anVar3;
                        }
                        if (tV.gJU != null && tV.gJU.grV != null && tV.gJU.grV.size() > 0) {
                            for (as asVar : tV.gJU.grV) {
                                if (asVar != null && asVar.isSelected) {
                                    i = asVar.grR;
                                }
                            }
                        }
                        if (z2 && this.gJQ != null) {
                            this.gJQ.a(this.gJD.getTabId(), i, anVar);
                        }
                    } else {
                        return;
                    }
                } else if (tW(this.gJD.getTabId()) && !z) {
                    if (this.gJR == null || this.gJR.uc(this.gJD.getTabId())) {
                        this.gJD.setState(TabItemView.STATE_EXPANDED);
                        this.gJB.a((Activity) getContext(), this, this.gJD, tV(this.gJD.getTabId()).gJU);
                    } else {
                        return;
                    }
                }
                invalidate();
            }
        }
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gJz = 0;
        this.gJD = null;
        this.gJE = null;
        this.mPaint = new Paint();
        this.gJF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.gJG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.gJH = 0;
        this.gJI = true;
        this.gJJ = R.color.transparent;
        this.gJL = 0;
        this.gJO = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void ua(int i) {
                if (HorizontalTabView.this.gJD != null && HorizontalTabView.this.gJQ != null && HorizontalTabView.this.gJQ != null) {
                    HorizontalTabView.this.gJQ.a(HorizontalTabView.this.gJD.getTabId(), i, null);
                }
                if (HorizontalTabView.this.gJE != null) {
                    HorizontalTabView.this.gJE.tY(i);
                }
            }
        };
        this.gJP = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.gJK) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.gJM != null) {
                                HorizontalTabView.this.gJM.b(HorizontalTabView.this.tU(1));
                            }
                            HorizontalTabView.this.bJL();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.tabId == 302) {
                                    break;
                                }
                            }
                            HorizontalTabView.this.a(dVar);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.gJE != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.tZ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.gJD != null) {
                            HorizontalTabView.this.gJE.tX(HorizontalTabView.this.gJD.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.gJE.tX(((TabItemView) view).getTabId());
                }
            }
        };
        this.gJA = new LinearLayout(context);
        this.gJA.setOrientation(0);
        this.gJA.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.gJB = new e(context, this.gJO, this.gJP);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.gJA, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        am.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cq(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d tV = tV(1);
        Iterator<d> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            d next = it.next();
            if (next != null && next.tabId == 1) {
                dVar = next;
                break;
            }
        }
        if (tV == null || dVar == null) {
            return false;
        }
        if (tV.gJU == null && dVar.gJU == null) {
            return false;
        }
        if ((tV.gJU != null || dVar.gJU == null) && (dVar.gJU != null || tV.gJU == null)) {
            if (tV.gJU == null || dVar.gJU == null) {
                return false;
            }
            if (tV.gJU.grV == null && dVar.gJU.grV == null) {
                return false;
            }
            if ((tV.gJU.grV != null || dVar.gJU.grV == null) && (dVar.gJU.grV != null || tV.gJU.grV == null)) {
                int size = tV.gJU.grV.size();
                if (size != dVar.gJU.grV.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    as asVar = dVar.gJU.grV.get(i);
                    as asVar2 = tV.gJU.grV.get(i);
                    if (asVar.grR != asVar2.grR || !asVar.name.equals(asVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void setData(List<d> list, int i, int i2) {
        d dVar;
        at atVar;
        if (this.gJK) {
            this.gJC = new ArrayList();
            this.gJC.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                at atVar2 = dVar.gJU;
                if (atVar2 != null && atVar2.grV != null) {
                    atVar2.grV.clear();
                    atVar = atVar2;
                } else {
                    at atVar3 = new at();
                    atVar3.grV = new ArrayList();
                    atVar = atVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    as asVar = new as();
                    asVar.grR = 1;
                    asVar.name = getContext().getString(R.string.chosen_pb_title);
                    atVar.grV.add(asVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            as asVar2 = new as();
                            asVar2.grR = dVar3.tabId;
                            asVar2.name = dVar3.name;
                            atVar.grV.add(asVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.gJU = atVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.gJC = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.gJH > 0 && list.size() == this.gJH) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.gJH, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.tabId = 1;
            dVar.name = getContext().getResources().getString(R.string.chosen_pb_title);
            this.gJA.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.gJK);
            if (this.gJL != 0) {
                tabItemView.setSelectItemColorResId(this.gJL);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.gJA.addView(tabItemView, layoutParams);
            this.gJD = tabItemView;
            tabItemView.setState(TabItemView.gJW);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cq(list)) {
            this.mData = list;
            this.gJA.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.gJK);
                        if (302 == dVar2.tabId) {
                            am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.gJL != 0) {
                            tabItemView2.setSelectItemColorResId(this.gJL);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (tZ(dVar2.tabId)) {
                            am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.gJA.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.gJD = tabItemView2;
                            tabItemView2.setState(TabItemView.gJW);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d tV(int i) {
        if (i < 0 || this.gJC == null || this.gJC.size() == 0) {
            return null;
        }
        for (d dVar : this.gJC) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean tW(int i) {
        d tV = tV(i);
        return (tV == null || tV.gJU == null || tV.gJU.grV == null || tV.gJU.grV.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.gJE = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gJD != null) {
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
            if (this.gJI) {
                canvas.drawRect(this.gJA.getLeft(), getMeasuredHeight() - this.gJG, this.gJA.getRight() > getRight() ? this.gJA.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.gJK) {
                if (this.gJL == 0) {
                    this.mPaint.setColor(am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.getSkinColor(null, this.gJL));
                }
                canvas.drawRect(this.gJD.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.gJF, (this.gJD.getRight() - getBottomLineMargin()) - this.gJD.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.gJK) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.gJD != null) {
                dimens = this.gJD.getRight() - this.gJD.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.gJD == null || this.gJz == 0) {
            return 0;
        }
        return ((this.gJD.getMeasuredWidth() - this.gJz) - this.gJD.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void tX(int i) {
        a(tU(i));
    }

    public void setDataLoadInterface(ag agVar) {
        this.gJQ = agVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.gJR = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.gJR;
    }

    public void setTabBackgroudColor(int i) {
        this.gJJ = i;
    }

    public void setAutoFillTabCount(int i) {
        this.gJH = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void tY(int i) {
        if (this.gJD != null && this.gJQ != null) {
            this.gJQ.a(this.gJD.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gJM = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.gJN = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.gJK = z;
    }

    public static boolean tZ(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.gJI = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.gJL = i;
    }
}
