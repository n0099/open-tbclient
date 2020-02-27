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
    private List<d> gJA;
    private TabItemView gJB;
    private com.baidu.tieba.frs.tab.b gJC;
    private final int gJD;
    private final int gJE;
    private int gJF;
    private boolean gJG;
    private int gJH;
    private boolean gJI;
    private int gJJ;
    private a gJK;
    private b gJL;
    private e.b gJM;
    private e.a gJN;
    private ag gJO;
    private c gJP;
    public int gJx;
    private final LinearLayout gJy;
    private final e gJz;
    private TbPageContext gdj;
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

    public void bJJ() {
        final at atVar;
        if (this.gdj != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (atVar = this.mData.get(0).gJS) != null && atVar.grT != null) {
                for (as asVar : atVar.grT) {
                    if (asVar != null) {
                        arrayList.add(asVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gdj.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (atVar.grT.size() > i && atVar.grT.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.tU(atVar.grT.get(i).grP));
                        }
                    }
                });
                bVar.d(this.gdj);
                bVar.aEB();
            }
        }
    }

    public d tU(int i) {
        if (!v.isEmpty(this.gJA)) {
            for (d dVar : this.gJA) {
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
            if (dVar.tabId != 302 && this.gJL != null) {
                this.gJL.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (tZ(dVar.tabId)) {
                if (this.gJO != null && !TextUtils.isEmpty(dVar.url)) {
                    an anVar = new an();
                    anVar.ext = dVar.url;
                    this.gJO.a(dVar.tabId, -1, anVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.gJO != null) {
                    this.gJO.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.gJO == null) {
                    z = true;
                } else {
                    an anVar2 = new an();
                    anVar2.ext = dVar.url;
                    anVar2.stType = dVar.name;
                    this.gJO.a(dVar.tabId, 0, anVar2);
                    if (anVar2.gsp) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.gJy.getChildCount(); i++) {
                    View childAt = this.gJy.getChildAt(i);
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
                if (this.gJO != null && z) {
                    this.gJO.a(dVar.tabId, 0, anVar3);
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
                if (this.gJO != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    an anVar2 = new an();
                    anVar2.ext = tabItemView.getUrl();
                    this.gJO.a(tabItemView.getTabId(), -1, anVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.gJO != null) {
                    this.gJO.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.gJB = tabItemView;
                int[] iArr = new int[2];
                this.gJB.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.gJy.getChildCount(); i2++) {
                    View childAt = this.gJy.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.gJB.getTabId() && !tZ(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.gJT);
                        }
                    }
                }
                if (this.gJB.getState() == TabItemView.gJT || this.gJB.getState() == TabItemView.STATE_EXPANDED) {
                    this.gJz.dismissMenu();
                    boolean z2 = this.gJB.getState() == TabItemView.gJT;
                    this.gJB.setState(TabItemView.gJU);
                    d tV = tV(this.gJB.getTabId());
                    if (tV != null) {
                        if (!TextUtils.isEmpty(tV.url)) {
                            an anVar3 = new an();
                            anVar3.ext = tV.url;
                            anVar3.stType = tV.name;
                            anVar = anVar3;
                        }
                        if (tV.gJS != null && tV.gJS.grT != null && tV.gJS.grT.size() > 0) {
                            for (as asVar : tV.gJS.grT) {
                                if (asVar != null && asVar.isSelected) {
                                    i = asVar.grP;
                                }
                            }
                        }
                        if (z2 && this.gJO != null) {
                            this.gJO.a(this.gJB.getTabId(), i, anVar);
                        }
                    } else {
                        return;
                    }
                } else if (tW(this.gJB.getTabId()) && !z) {
                    if (this.gJP == null || this.gJP.uc(this.gJB.getTabId())) {
                        this.gJB.setState(TabItemView.STATE_EXPANDED);
                        this.gJz.a((Activity) getContext(), this, this.gJB, tV(this.gJB.getTabId()).gJS);
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
        this.gJx = 0;
        this.gJB = null;
        this.gJC = null;
        this.mPaint = new Paint();
        this.gJD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.gJE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.gJF = 0;
        this.gJG = true;
        this.gJH = R.color.transparent;
        this.gJJ = 0;
        this.gJM = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void ua(int i) {
                if (HorizontalTabView.this.gJB != null && HorizontalTabView.this.gJO != null && HorizontalTabView.this.gJO != null) {
                    HorizontalTabView.this.gJO.a(HorizontalTabView.this.gJB.getTabId(), i, null);
                }
                if (HorizontalTabView.this.gJC != null) {
                    HorizontalTabView.this.gJC.tY(i);
                }
            }
        };
        this.gJN = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.gJI) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.gJK != null) {
                                HorizontalTabView.this.gJK.b(HorizontalTabView.this.tU(1));
                            }
                            HorizontalTabView.this.bJJ();
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
                if (HorizontalTabView.this.gJC != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.tZ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.gJB != null) {
                            HorizontalTabView.this.gJC.tX(HorizontalTabView.this.gJB.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.gJC.tX(((TabItemView) view).getTabId());
                }
            }
        };
        this.gJy = new LinearLayout(context);
        this.gJy.setOrientation(0);
        this.gJy.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.gJz = new e(context, this.gJM, this.gJN);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.gJy, layoutParams);
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
        if (tV.gJS == null && dVar.gJS == null) {
            return false;
        }
        if ((tV.gJS != null || dVar.gJS == null) && (dVar.gJS != null || tV.gJS == null)) {
            if (tV.gJS == null || dVar.gJS == null) {
                return false;
            }
            if (tV.gJS.grT == null && dVar.gJS.grT == null) {
                return false;
            }
            if ((tV.gJS.grT != null || dVar.gJS.grT == null) && (dVar.gJS.grT != null || tV.gJS.grT == null)) {
                int size = tV.gJS.grT.size();
                if (size != dVar.gJS.grT.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    as asVar = dVar.gJS.grT.get(i);
                    as asVar2 = tV.gJS.grT.get(i);
                    if (asVar.grP != asVar2.grP || !asVar.name.equals(asVar2.name)) {
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
        if (this.gJI) {
            this.gJA = new ArrayList();
            this.gJA.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                at atVar2 = dVar.gJS;
                if (atVar2 != null && atVar2.grT != null) {
                    atVar2.grT.clear();
                    atVar = atVar2;
                } else {
                    at atVar3 = new at();
                    atVar3.grT = new ArrayList();
                    atVar = atVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    as asVar = new as();
                    asVar.grP = 1;
                    asVar.name = getContext().getString(R.string.chosen_pb_title);
                    atVar.grT.add(asVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            as asVar2 = new as();
                            asVar2.grP = dVar3.tabId;
                            asVar2.name = dVar3.name;
                            atVar.grT.add(asVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.gJS = atVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.gJA = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.gJF > 0 && list.size() == this.gJF) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.gJF, -1);
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
            this.gJy.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.gJI);
            if (this.gJJ != 0) {
                tabItemView.setSelectItemColorResId(this.gJJ);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.gJy.addView(tabItemView, layoutParams);
            this.gJB = tabItemView;
            tabItemView.setState(TabItemView.gJU);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cq(list)) {
            this.mData = list;
            this.gJy.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.gJI);
                        if (302 == dVar2.tabId) {
                            am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.gJJ != 0) {
                            tabItemView2.setSelectItemColorResId(this.gJJ);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (tZ(dVar2.tabId)) {
                            am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.gJy.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.gJB = tabItemView2;
                            tabItemView2.setState(TabItemView.gJU);
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
        if (i < 0 || this.gJA == null || this.gJA.size() == 0) {
            return null;
        }
        for (d dVar : this.gJA) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean tW(int i) {
        d tV = tV(i);
        return (tV == null || tV.gJS == null || tV.gJS.grT == null || tV.gJS.grT.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.gJC = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gJB != null) {
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
            if (this.gJG) {
                canvas.drawRect(this.gJy.getLeft(), getMeasuredHeight() - this.gJE, this.gJy.getRight() > getRight() ? this.gJy.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.gJI) {
                if (this.gJJ == 0) {
                    this.mPaint.setColor(am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.getSkinColor(null, this.gJJ));
                }
                canvas.drawRect(this.gJB.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.gJD, (this.gJB.getRight() - getBottomLineMargin()) - this.gJB.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.gJI) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.gJB != null) {
                dimens = this.gJB.getRight() - this.gJB.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.gJB == null || this.gJx == 0) {
            return 0;
        }
        return ((this.gJB.getMeasuredWidth() - this.gJx) - this.gJB.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void tX(int i) {
        a(tU(i));
    }

    public void setDataLoadInterface(ag agVar) {
        this.gJO = agVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.gJP = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.gJP;
    }

    public void setTabBackgroudColor(int i) {
        this.gJH = i;
    }

    public void setAutoFillTabCount(int i) {
        this.gJF = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void tY(int i) {
        if (this.gJB != null && this.gJO != null) {
            this.gJO.a(this.gJB.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gJK = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.gJL = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.gJI = z;
    }

    public static boolean tZ(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.gJG = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.gJJ = i;
    }
}
