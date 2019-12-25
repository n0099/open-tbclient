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
/* loaded from: classes6.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext fXZ;
    private ag gEA;
    private c gEB;
    public int gEj;
    private final LinearLayout gEk;
    private final e gEl;
    private List<d> gEm;
    private TabItemView gEn;
    private com.baidu.tieba.frs.tab.b gEo;
    private final int gEp;
    private final int gEq;
    private int gEr;
    private boolean gEs;
    private int gEt;
    private boolean gEu;
    private int gEv;
    private a gEw;
    private b gEx;
    private e.b gEy;
    private e.a gEz;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes6.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void tQ(int i);

        boolean tR(int i);
    }

    public void bHf() {
        final at atVar;
        if (this.fXZ != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (atVar = this.mData.get(0).gEE) != null && atVar.gmJ != null) {
                for (as asVar : atVar.gmJ) {
                    if (asVar != null) {
                        arrayList.add(asVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.fXZ.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (atVar.gmJ.size() > i && atVar.gmJ.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.tJ(atVar.gmJ.get(i).gmF));
                        }
                    }
                });
                bVar.d(this.fXZ);
                bVar.aBX();
            }
        }
    }

    public d tJ(int i) {
        if (!v.isEmpty(this.gEm)) {
            for (d dVar : this.gEm) {
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
            if (dVar.tabId != 302 && this.gEx != null) {
                this.gEx.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (tO(dVar.tabId)) {
                if (this.gEA != null && !TextUtils.isEmpty(dVar.url)) {
                    an anVar = new an();
                    anVar.ext = dVar.url;
                    this.gEA.a(dVar.tabId, -1, anVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.gEA != null) {
                    this.gEA.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.gEA == null) {
                    z = true;
                } else {
                    an anVar2 = new an();
                    anVar2.ext = dVar.url;
                    anVar2.stType = dVar.name;
                    this.gEA.a(dVar.tabId, 0, anVar2);
                    if (anVar2.gnf) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.gEk.getChildCount(); i++) {
                    View childAt = this.gEk.getChildAt(i);
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
                if (this.gEA != null && z) {
                    this.gEA.a(dVar.tabId, 0, anVar3);
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
            if (tO(tabItemView.getTabId())) {
                if (this.gEA != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    an anVar2 = new an();
                    anVar2.ext = tabItemView.getUrl();
                    this.gEA.a(tabItemView.getTabId(), -1, anVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.gEA != null) {
                    this.gEA.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.gEn = tabItemView;
                int[] iArr = new int[2];
                this.gEn.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.gEk.getChildCount(); i2++) {
                    View childAt = this.gEk.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.gEn.getTabId() && !tO(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.gEF);
                        }
                    }
                }
                if (this.gEn.getState() == TabItemView.gEF || this.gEn.getState() == TabItemView.STATE_EXPANDED) {
                    this.gEl.dismissMenu();
                    boolean z2 = this.gEn.getState() == TabItemView.gEF;
                    this.gEn.setState(TabItemView.gEG);
                    d tK = tK(this.gEn.getTabId());
                    if (tK != null) {
                        if (!TextUtils.isEmpty(tK.url)) {
                            an anVar3 = new an();
                            anVar3.ext = tK.url;
                            anVar3.stType = tK.name;
                            anVar = anVar3;
                        }
                        if (tK.gEE != null && tK.gEE.gmJ != null && tK.gEE.gmJ.size() > 0) {
                            for (as asVar : tK.gEE.gmJ) {
                                if (asVar != null && asVar.isSelected) {
                                    i = asVar.gmF;
                                }
                            }
                        }
                        if (z2 && this.gEA != null) {
                            this.gEA.a(this.gEn.getTabId(), i, anVar);
                        }
                    } else {
                        return;
                    }
                } else if (tL(this.gEn.getTabId()) && !z) {
                    if (this.gEB == null || this.gEB.tR(this.gEn.getTabId())) {
                        this.gEn.setState(TabItemView.STATE_EXPANDED);
                        this.gEl.a((Activity) getContext(), this, this.gEn, tK(this.gEn.getTabId()).gEE);
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
        this.gEj = 0;
        this.gEn = null;
        this.gEo = null;
        this.mPaint = new Paint();
        this.gEp = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.gEq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.gEr = 0;
        this.gEs = true;
        this.gEt = R.color.transparent;
        this.gEv = 0;
        this.gEy = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void tP(int i) {
                if (HorizontalTabView.this.gEn != null && HorizontalTabView.this.gEA != null && HorizontalTabView.this.gEA != null) {
                    HorizontalTabView.this.gEA.a(HorizontalTabView.this.gEn.getTabId(), i, null);
                }
                if (HorizontalTabView.this.gEo != null) {
                    HorizontalTabView.this.gEo.tN(i);
                }
            }
        };
        this.gEz = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.gEu) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.gEw != null) {
                                HorizontalTabView.this.gEw.b(HorizontalTabView.this.tJ(1));
                            }
                            HorizontalTabView.this.bHf();
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
                if (HorizontalTabView.this.gEo != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.tO(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.gEn != null) {
                            HorizontalTabView.this.gEo.tM(HorizontalTabView.this.gEn.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.gEo.tM(((TabItemView) view).getTabId());
                }
            }
        };
        this.gEk = new LinearLayout(context);
        this.gEk.setOrientation(0);
        this.gEk.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.gEl = new e(context, this.gEy, this.gEz);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.gEk, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        am.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cu(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d tK = tK(1);
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
        if (tK == null || dVar == null) {
            return false;
        }
        if (tK.gEE == null && dVar.gEE == null) {
            return false;
        }
        if ((tK.gEE != null || dVar.gEE == null) && (dVar.gEE != null || tK.gEE == null)) {
            if (tK.gEE == null || dVar.gEE == null) {
                return false;
            }
            if (tK.gEE.gmJ == null && dVar.gEE.gmJ == null) {
                return false;
            }
            if ((tK.gEE.gmJ != null || dVar.gEE.gmJ == null) && (dVar.gEE.gmJ != null || tK.gEE.gmJ == null)) {
                int size = tK.gEE.gmJ.size();
                if (size != dVar.gEE.gmJ.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    as asVar = dVar.gEE.gmJ.get(i);
                    as asVar2 = tK.gEE.gmJ.get(i);
                    if (asVar.gmF != asVar2.gmF || !asVar.name.equals(asVar2.name)) {
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
        if (this.gEu) {
            this.gEm = new ArrayList();
            this.gEm.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                at atVar2 = dVar.gEE;
                if (atVar2 != null && atVar2.gmJ != null) {
                    atVar2.gmJ.clear();
                    atVar = atVar2;
                } else {
                    at atVar3 = new at();
                    atVar3.gmJ = new ArrayList();
                    atVar = atVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    as asVar = new as();
                    asVar.gmF = 1;
                    asVar.name = getContext().getString(R.string.chosen_pb_title);
                    atVar.gmJ.add(asVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            as asVar2 = new as();
                            asVar2.gmF = dVar3.tabId;
                            asVar2.name = dVar3.name;
                            atVar.gmJ.add(asVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.gEE = atVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.gEm = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.gEr > 0 && list.size() == this.gEr) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.gEr, -1);
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
            this.gEk.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.gEu);
            if (this.gEv != 0) {
                tabItemView.setSelectItemColorResId(this.gEv);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.gEk.addView(tabItemView, layoutParams);
            this.gEn = tabItemView;
            tabItemView.setState(TabItemView.gEG);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cu(list)) {
            this.mData = list;
            this.gEk.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.gEu);
                        if (302 == dVar2.tabId) {
                            am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.gEv != 0) {
                            tabItemView2.setSelectItemColorResId(this.gEv);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (tO(dVar2.tabId)) {
                            am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.gEk.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.gEn = tabItemView2;
                            tabItemView2.setState(TabItemView.gEG);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d tK(int i) {
        if (i < 0 || this.gEm == null || this.gEm.size() == 0) {
            return null;
        }
        for (d dVar : this.gEm) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean tL(int i) {
        d tK = tK(i);
        return (tK == null || tK.gEE == null || tK.gEE.gmJ == null || tK.gEE.gmJ.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.gEo = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gEn != null) {
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
            if (this.gEs) {
                canvas.drawRect(this.gEk.getLeft(), getMeasuredHeight() - this.gEq, this.gEk.getRight() > getRight() ? this.gEk.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.gEu) {
                if (this.gEv == 0) {
                    this.mPaint.setColor(am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.getSkinColor(null, this.gEv));
                }
                canvas.drawRect(this.gEn.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.gEp, (this.gEn.getRight() - getBottomLineMargin()) - this.gEn.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.gEu) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.gEn != null) {
                dimens = this.gEn.getRight() - this.gEn.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.gEn == null || this.gEj == 0) {
            return 0;
        }
        return ((this.gEn.getMeasuredWidth() - this.gEj) - this.gEn.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void tM(int i) {
        a(tJ(i));
    }

    public void setDataLoadInterface(ag agVar) {
        this.gEA = agVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.gEB = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.gEB;
    }

    public void setTabBackgroudColor(int i) {
        this.gEt = i;
    }

    public void setAutoFillTabCount(int i) {
        this.gEr = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void tN(int i) {
        if (this.gEn != null && this.gEA != null) {
            this.gEA.a(this.gEn.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gEw = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.gEx = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.gEu = z;
    }

    public static boolean tO(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.gEs = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.gEv = i;
    }
}
