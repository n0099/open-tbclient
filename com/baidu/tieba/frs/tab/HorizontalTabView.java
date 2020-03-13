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
    public int gJL;
    private final LinearLayout gJM;
    private final e gJN;
    private List<d> gJO;
    private TabItemView gJP;
    private com.baidu.tieba.frs.tab.b gJQ;
    private final int gJR;
    private final int gJS;
    private int gJT;
    private boolean gJU;
    private int gJV;
    private boolean gJW;
    private int gJX;
    private a gJY;
    private b gJZ;
    private e.b gKa;
    private e.a gKb;
    private ag gKc;
    private c gKd;
    private TbPageContext gdy;
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

    public void bJM() {
        final at atVar;
        if (this.gdy != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (atVar = this.mData.get(0).gKg) != null && atVar.gsi != null) {
                for (as asVar : atVar.gsi) {
                    if (asVar != null) {
                        arrayList.add(asVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gdy.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (atVar.gsi.size() > i && atVar.gsi.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.tU(atVar.gsi.get(i).gse));
                        }
                    }
                });
                bVar.d(this.gdy);
                bVar.aED();
            }
        }
    }

    public d tU(int i) {
        if (!v.isEmpty(this.gJO)) {
            for (d dVar : this.gJO) {
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
            if (dVar.tabId != 302 && this.gJZ != null) {
                this.gJZ.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (tZ(dVar.tabId)) {
                if (this.gKc != null && !TextUtils.isEmpty(dVar.url)) {
                    an anVar = new an();
                    anVar.ext = dVar.url;
                    this.gKc.a(dVar.tabId, -1, anVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.gKc != null) {
                    this.gKc.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.gKc == null) {
                    z = true;
                } else {
                    an anVar2 = new an();
                    anVar2.ext = dVar.url;
                    anVar2.stType = dVar.name;
                    this.gKc.a(dVar.tabId, 0, anVar2);
                    if (anVar2.gsE) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.gJM.getChildCount(); i++) {
                    View childAt = this.gJM.getChildAt(i);
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
                if (this.gKc != null && z) {
                    this.gKc.a(dVar.tabId, 0, anVar3);
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
                if (this.gKc != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    an anVar2 = new an();
                    anVar2.ext = tabItemView.getUrl();
                    this.gKc.a(tabItemView.getTabId(), -1, anVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.gKc != null) {
                    this.gKc.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.gJP = tabItemView;
                int[] iArr = new int[2];
                this.gJP.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.gJM.getChildCount(); i2++) {
                    View childAt = this.gJM.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.gJP.getTabId() && !tZ(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.gKh);
                        }
                    }
                }
                if (this.gJP.getState() == TabItemView.gKh || this.gJP.getState() == TabItemView.STATE_EXPANDED) {
                    this.gJN.dismissMenu();
                    boolean z2 = this.gJP.getState() == TabItemView.gKh;
                    this.gJP.setState(TabItemView.gKi);
                    d tV = tV(this.gJP.getTabId());
                    if (tV != null) {
                        if (!TextUtils.isEmpty(tV.url)) {
                            an anVar3 = new an();
                            anVar3.ext = tV.url;
                            anVar3.stType = tV.name;
                            anVar = anVar3;
                        }
                        if (tV.gKg != null && tV.gKg.gsi != null && tV.gKg.gsi.size() > 0) {
                            for (as asVar : tV.gKg.gsi) {
                                if (asVar != null && asVar.isSelected) {
                                    i = asVar.gse;
                                }
                            }
                        }
                        if (z2 && this.gKc != null) {
                            this.gKc.a(this.gJP.getTabId(), i, anVar);
                        }
                    } else {
                        return;
                    }
                } else if (tW(this.gJP.getTabId()) && !z) {
                    if (this.gKd == null || this.gKd.uc(this.gJP.getTabId())) {
                        this.gJP.setState(TabItemView.STATE_EXPANDED);
                        this.gJN.a((Activity) getContext(), this, this.gJP, tV(this.gJP.getTabId()).gKg);
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
        this.gJL = 0;
        this.gJP = null;
        this.gJQ = null;
        this.mPaint = new Paint();
        this.gJR = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.gJS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.gJT = 0;
        this.gJU = true;
        this.gJV = R.color.transparent;
        this.gJX = 0;
        this.gKa = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void ua(int i) {
                if (HorizontalTabView.this.gJP != null && HorizontalTabView.this.gKc != null && HorizontalTabView.this.gKc != null) {
                    HorizontalTabView.this.gKc.a(HorizontalTabView.this.gJP.getTabId(), i, null);
                }
                if (HorizontalTabView.this.gJQ != null) {
                    HorizontalTabView.this.gJQ.tY(i);
                }
            }
        };
        this.gKb = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.gJW) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.gJY != null) {
                                HorizontalTabView.this.gJY.b(HorizontalTabView.this.tU(1));
                            }
                            HorizontalTabView.this.bJM();
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
                if (HorizontalTabView.this.gJQ != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.tZ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.gJP != null) {
                            HorizontalTabView.this.gJQ.tX(HorizontalTabView.this.gJP.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.gJQ.tX(((TabItemView) view).getTabId());
                }
            }
        };
        this.gJM = new LinearLayout(context);
        this.gJM.setOrientation(0);
        this.gJM.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.gJN = new e(context, this.gKa, this.gKb);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.gJM, layoutParams);
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
        if (tV.gKg == null && dVar.gKg == null) {
            return false;
        }
        if ((tV.gKg != null || dVar.gKg == null) && (dVar.gKg != null || tV.gKg == null)) {
            if (tV.gKg == null || dVar.gKg == null) {
                return false;
            }
            if (tV.gKg.gsi == null && dVar.gKg.gsi == null) {
                return false;
            }
            if ((tV.gKg.gsi != null || dVar.gKg.gsi == null) && (dVar.gKg.gsi != null || tV.gKg.gsi == null)) {
                int size = tV.gKg.gsi.size();
                if (size != dVar.gKg.gsi.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    as asVar = dVar.gKg.gsi.get(i);
                    as asVar2 = tV.gKg.gsi.get(i);
                    if (asVar.gse != asVar2.gse || !asVar.name.equals(asVar2.name)) {
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
        if (this.gJW) {
            this.gJO = new ArrayList();
            this.gJO.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                at atVar2 = dVar.gKg;
                if (atVar2 != null && atVar2.gsi != null) {
                    atVar2.gsi.clear();
                    atVar = atVar2;
                } else {
                    at atVar3 = new at();
                    atVar3.gsi = new ArrayList();
                    atVar = atVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    as asVar = new as();
                    asVar.gse = 1;
                    asVar.name = getContext().getString(R.string.chosen_pb_title);
                    atVar.gsi.add(asVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            as asVar2 = new as();
                            asVar2.gse = dVar3.tabId;
                            asVar2.name = dVar3.name;
                            atVar.gsi.add(asVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.gKg = atVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.gJO = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.gJT > 0 && list.size() == this.gJT) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.gJT, -1);
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
            this.gJM.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.gJW);
            if (this.gJX != 0) {
                tabItemView.setSelectItemColorResId(this.gJX);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.gJM.addView(tabItemView, layoutParams);
            this.gJP = tabItemView;
            tabItemView.setState(TabItemView.gKi);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cq(list)) {
            this.mData = list;
            this.gJM.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.gJW);
                        if (302 == dVar2.tabId) {
                            am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.gJX != 0) {
                            tabItemView2.setSelectItemColorResId(this.gJX);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (tZ(dVar2.tabId)) {
                            am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.gJM.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.gJP = tabItemView2;
                            tabItemView2.setState(TabItemView.gKi);
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
        if (i < 0 || this.gJO == null || this.gJO.size() == 0) {
            return null;
        }
        for (d dVar : this.gJO) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean tW(int i) {
        d tV = tV(i);
        return (tV == null || tV.gKg == null || tV.gKg.gsi == null || tV.gKg.gsi.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.gJQ = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gJP != null) {
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
            if (this.gJU) {
                canvas.drawRect(this.gJM.getLeft(), getMeasuredHeight() - this.gJS, this.gJM.getRight() > getRight() ? this.gJM.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.gJW) {
                if (this.gJX == 0) {
                    this.mPaint.setColor(am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.getSkinColor(null, this.gJX));
                }
                canvas.drawRect(this.gJP.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.gJR, (this.gJP.getRight() - getBottomLineMargin()) - this.gJP.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.gJW) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.gJP != null) {
                dimens = this.gJP.getRight() - this.gJP.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.gJP == null || this.gJL == 0) {
            return 0;
        }
        return ((this.gJP.getMeasuredWidth() - this.gJL) - this.gJP.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void tX(int i) {
        a(tU(i));
    }

    public void setDataLoadInterface(ag agVar) {
        this.gKc = agVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.gKd = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.gKd;
    }

    public void setTabBackgroudColor(int i) {
        this.gJV = i;
    }

    public void setAutoFillTabCount(int i) {
        this.gJT = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void tY(int i) {
        if (this.gJP != null && this.gKc != null) {
            this.gKc.a(this.gJP.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gJY = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.gJZ = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.gJW = z;
    }

    public static boolean tZ(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.gJU = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.gJX = i;
    }
}
