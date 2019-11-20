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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    public int fPX;
    private final LinearLayout fPY;
    private final e fPZ;
    private List<d> fQa;
    private TabItemView fQb;
    private com.baidu.tieba.frs.tab.b fQc;
    private final int fQd;
    private final int fQe;
    private int fQf;
    private boolean fQg;
    private int fQh;
    private boolean fQi;
    private int fQj;
    private a fQk;
    private b fQl;
    private e.b fQm;
    private e.a fQn;
    private af fQo;
    private c fQp;
    private TbPageContext fjz;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes4.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void rK(int i);

        boolean rL(int i);
    }

    public void bpJ() {
        final as asVar;
        if (this.fjz != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).fQs) != null && asVar.fym != null) {
                for (ar arVar : asVar.fym) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.fjz.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.fym.size() > i && asVar.fym.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.rD(asVar.fym.get(i).fyi));
                        }
                    }
                });
                bVar.d(this.fjz);
                bVar.akN();
            }
        }
    }

    public d rD(int i) {
        if (!v.isEmpty(this.fQa)) {
            for (d dVar : this.fQa) {
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
            if (dVar.tabId != 302 && this.fQl != null) {
                this.fQl.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (rI(dVar.tabId)) {
                if (this.fQo != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.ext = dVar.url;
                    this.fQo.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.fQo != null) {
                    this.fQo.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.fQo == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.ext = dVar.url;
                    amVar2.stType = dVar.name;
                    this.fQo.a(dVar.tabId, 0, amVar2);
                    if (amVar2.fyI) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.fPY.getChildCount(); i++) {
                    View childAt = this.fPY.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                am amVar3 = null;
                if (!TextUtils.isEmpty(dVar.url)) {
                    amVar3 = new am();
                    amVar3.ext = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.fQo != null && z) {
                    this.fQo.a(dVar.tabId, 0, amVar3);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        am amVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (rI(tabItemView.getTabId())) {
                if (this.fQo != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.ext = tabItemView.getUrl();
                    this.fQo.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.fQo != null) {
                    this.fQo.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.fQb = tabItemView;
                int[] iArr = new int[2];
                this.fQb.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.fPY.getChildCount(); i2++) {
                    View childAt = this.fPY.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.fQb.getTabId() && !rI(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.fQt);
                        }
                    }
                }
                if (this.fQb.getState() == TabItemView.fQt || this.fQb.getState() == TabItemView.STATE_EXPANDED) {
                    this.fPZ.bpM();
                    boolean z2 = this.fQb.getState() == TabItemView.fQt;
                    this.fQb.setState(TabItemView.fQu);
                    d rE = rE(this.fQb.getTabId());
                    if (rE != null) {
                        if (!TextUtils.isEmpty(rE.url)) {
                            am amVar3 = new am();
                            amVar3.ext = rE.url;
                            amVar3.stType = rE.name;
                            amVar = amVar3;
                        }
                        if (rE.fQs != null && rE.fQs.fym != null && rE.fQs.fym.size() > 0) {
                            for (ar arVar : rE.fQs.fym) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fyi;
                                }
                            }
                        }
                        if (z2 && this.fQo != null) {
                            this.fQo.a(this.fQb.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (rF(this.fQb.getTabId()) && !z) {
                    if (this.fQp == null || this.fQp.rL(this.fQb.getTabId())) {
                        this.fQb.setState(TabItemView.STATE_EXPANDED);
                        this.fPZ.a((Activity) getContext(), this, this.fQb, rE(this.fQb.getTabId()).fQs);
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
        this.fPX = 0;
        this.fQb = null;
        this.fQc = null;
        this.mPaint = new Paint();
        this.fQd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.fQe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.fQf = 0;
        this.fQg = true;
        this.fQh = R.color.transparent;
        this.fQj = 0;
        this.fQm = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void rJ(int i) {
                if (HorizontalTabView.this.fQb != null && HorizontalTabView.this.fQo != null && HorizontalTabView.this.fQo != null) {
                    HorizontalTabView.this.fQo.a(HorizontalTabView.this.fQb.getTabId(), i, null);
                }
                if (HorizontalTabView.this.fQc != null) {
                    HorizontalTabView.this.fQc.rH(i);
                }
            }
        };
        this.fQn = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.fQi) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.fQk != null) {
                                HorizontalTabView.this.fQk.b(HorizontalTabView.this.rD(1));
                            }
                            HorizontalTabView.this.bpJ();
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
                if (HorizontalTabView.this.fQc != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.rI(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.fQb != null) {
                            HorizontalTabView.this.fQc.rG(HorizontalTabView.this.fQb.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.fQc.rG(((TabItemView) view).getTabId());
                }
            }
        };
        this.fPY = new LinearLayout(context);
        this.fPY.setOrientation(0);
        this.fPY.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.fPZ = new e(context, this.fQm, this.fQn);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.fPY, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cy(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d rE = rE(1);
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
        if (rE == null || dVar == null) {
            return false;
        }
        if (rE.fQs == null && dVar.fQs == null) {
            return false;
        }
        if ((rE.fQs != null || dVar.fQs == null) && (dVar.fQs != null || rE.fQs == null)) {
            if (rE.fQs == null || dVar.fQs == null) {
                return false;
            }
            if (rE.fQs.fym == null && dVar.fQs.fym == null) {
                return false;
            }
            if ((rE.fQs.fym != null || dVar.fQs.fym == null) && (dVar.fQs.fym != null || rE.fQs.fym == null)) {
                int size = rE.fQs.fym.size();
                if (size != dVar.fQs.fym.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.fQs.fym.get(i);
                    ar arVar2 = rE.fQs.fym.get(i);
                    if (arVar.fyi != arVar2.fyi || !arVar.name.equals(arVar2.name)) {
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
        as asVar;
        if (this.fQi) {
            this.fQa = new ArrayList();
            this.fQa.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.fQs;
                if (asVar2 != null && asVar2.fym != null) {
                    asVar2.fym.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.fym = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    ar arVar = new ar();
                    arVar.fyi = 1;
                    arVar.name = getContext().getString(R.string.chosen_pb_title);
                    asVar.fym.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.fyi = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.fym.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.fQs = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.fQa = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.fQf > 0 && list.size() == this.fQf) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.fQf, -1);
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
            this.fPY.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.fQi);
            if (this.fQj != 0) {
                tabItemView.setSelectItemColorResId(this.fQj);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.fPY.addView(tabItemView, layoutParams);
            this.fQb = tabItemView;
            tabItemView.setState(TabItemView.fQu);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cy(list)) {
            this.mData = list;
            this.fPY.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.fQi);
                        if (302 == dVar2.tabId) {
                            com.baidu.tbadk.core.util.am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.fQj != 0) {
                            tabItemView2.setSelectItemColorResId(this.fQj);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (rI(dVar2.tabId)) {
                            com.baidu.tbadk.core.util.am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.fPY.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.fQb = tabItemView2;
                            tabItemView2.setState(TabItemView.fQu);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d rE(int i) {
        if (i < 0 || this.fQa == null || this.fQa.size() == 0) {
            return null;
        }
        for (d dVar : this.fQa) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean rF(int i) {
        d rE = rE(i);
        return (rE == null || rE.fQs == null || rE.fQs.fym == null || rE.fQs.fym.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.fQc = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fQb != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_c));
            if (this.fQg) {
                canvas.drawRect(this.fPY.getLeft(), getMeasuredHeight() - this.fQe, this.fPY.getRight() > getRight() ? this.fPY.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.fQi) {
                if (this.fQj == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.am.getSkinColor(null, this.fQj));
                }
                canvas.drawRect(this.fQb.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.fQd, (this.fQb.getRight() - getBottomLineMargin()) - this.fQb.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.fQi) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.fQb != null) {
                dimens = this.fQb.getRight() - this.fQb.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.fQb == null || this.fPX == 0) {
            return 0;
        }
        return ((this.fQb.getMeasuredWidth() - this.fPX) - this.fQb.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void rG(int i) {
        a(rD(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.fQo = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.fQp = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.fQp;
    }

    public void setTabBackgroudColor(int i) {
        this.fQh = i;
    }

    public void setAutoFillTabCount(int i) {
        this.fQf = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void rH(int i) {
        if (this.fQb != null && this.fQo != null) {
            this.fQo.a(this.fQb.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fQk = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.fQl = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.fQi = z;
    }

    public static boolean rI(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.fQg = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.fQj = i;
    }
}
