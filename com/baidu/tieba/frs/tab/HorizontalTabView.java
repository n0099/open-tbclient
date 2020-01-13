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
/* loaded from: classes7.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private final e gHA;
    private List<d> gHB;
    private TabItemView gHC;
    private com.baidu.tieba.frs.tab.b gHD;
    private final int gHE;
    private final int gHF;
    private int gHG;
    private boolean gHH;
    private int gHI;
    private boolean gHJ;
    private int gHK;
    private a gHL;
    private b gHM;
    private e.b gHN;
    private e.a gHO;
    private ag gHP;
    private c gHQ;
    public int gHy;
    private final LinearLayout gHz;
    private TbPageContext gbi;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes7.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void tV(int i);

        boolean tW(int i);
    }

    public void bIh() {
        final at atVar;
        if (this.gbi != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (atVar = this.mData.get(0).gHT) != null && atVar.gpS != null) {
                for (as asVar : atVar.gpS) {
                    if (asVar != null) {
                        arrayList.add(asVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gbi.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (atVar.gpS.size() > i && atVar.gpS.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.tO(atVar.gpS.get(i).gpO));
                        }
                    }
                });
                bVar.d(this.gbi);
                bVar.aCq();
            }
        }
    }

    public d tO(int i) {
        if (!v.isEmpty(this.gHB)) {
            for (d dVar : this.gHB) {
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
            if (dVar.tabId != 302 && this.gHM != null) {
                this.gHM.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (tT(dVar.tabId)) {
                if (this.gHP != null && !TextUtils.isEmpty(dVar.url)) {
                    an anVar = new an();
                    anVar.ext = dVar.url;
                    this.gHP.a(dVar.tabId, -1, anVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.gHP != null) {
                    this.gHP.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.gHP == null) {
                    z = true;
                } else {
                    an anVar2 = new an();
                    anVar2.ext = dVar.url;
                    anVar2.stType = dVar.name;
                    this.gHP.a(dVar.tabId, 0, anVar2);
                    if (anVar2.gqo) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.gHz.getChildCount(); i++) {
                    View childAt = this.gHz.getChildAt(i);
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
                if (this.gHP != null && z) {
                    this.gHP.a(dVar.tabId, 0, anVar3);
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
            if (tT(tabItemView.getTabId())) {
                if (this.gHP != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    an anVar2 = new an();
                    anVar2.ext = tabItemView.getUrl();
                    this.gHP.a(tabItemView.getTabId(), -1, anVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.gHP != null) {
                    this.gHP.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.gHC = tabItemView;
                int[] iArr = new int[2];
                this.gHC.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.gHz.getChildCount(); i2++) {
                    View childAt = this.gHz.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.gHC.getTabId() && !tT(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.gHU);
                        }
                    }
                }
                if (this.gHC.getState() == TabItemView.gHU || this.gHC.getState() == TabItemView.STATE_EXPANDED) {
                    this.gHA.dismissMenu();
                    boolean z2 = this.gHC.getState() == TabItemView.gHU;
                    this.gHC.setState(TabItemView.gHV);
                    d tP = tP(this.gHC.getTabId());
                    if (tP != null) {
                        if (!TextUtils.isEmpty(tP.url)) {
                            an anVar3 = new an();
                            anVar3.ext = tP.url;
                            anVar3.stType = tP.name;
                            anVar = anVar3;
                        }
                        if (tP.gHT != null && tP.gHT.gpS != null && tP.gHT.gpS.size() > 0) {
                            for (as asVar : tP.gHT.gpS) {
                                if (asVar != null && asVar.isSelected) {
                                    i = asVar.gpO;
                                }
                            }
                        }
                        if (z2 && this.gHP != null) {
                            this.gHP.a(this.gHC.getTabId(), i, anVar);
                        }
                    } else {
                        return;
                    }
                } else if (tQ(this.gHC.getTabId()) && !z) {
                    if (this.gHQ == null || this.gHQ.tW(this.gHC.getTabId())) {
                        this.gHC.setState(TabItemView.STATE_EXPANDED);
                        this.gHA.a((Activity) getContext(), this, this.gHC, tP(this.gHC.getTabId()).gHT);
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
        this.gHy = 0;
        this.gHC = null;
        this.gHD = null;
        this.mPaint = new Paint();
        this.gHE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.gHF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.gHG = 0;
        this.gHH = true;
        this.gHI = R.color.transparent;
        this.gHK = 0;
        this.gHN = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void tU(int i) {
                if (HorizontalTabView.this.gHC != null && HorizontalTabView.this.gHP != null && HorizontalTabView.this.gHP != null) {
                    HorizontalTabView.this.gHP.a(HorizontalTabView.this.gHC.getTabId(), i, null);
                }
                if (HorizontalTabView.this.gHD != null) {
                    HorizontalTabView.this.gHD.tS(i);
                }
            }
        };
        this.gHO = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.gHJ) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.gHL != null) {
                                HorizontalTabView.this.gHL.b(HorizontalTabView.this.tO(1));
                            }
                            HorizontalTabView.this.bIh();
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
                if (HorizontalTabView.this.gHD != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.tT(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.gHC != null) {
                            HorizontalTabView.this.gHD.tR(HorizontalTabView.this.gHC.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.gHD.tR(((TabItemView) view).getTabId());
                }
            }
        };
        this.gHz = new LinearLayout(context);
        this.gHz.setOrientation(0);
        this.gHz.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.gHA = new e(context, this.gHN, this.gHO);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.gHz, layoutParams);
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
        d tP = tP(1);
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
        if (tP == null || dVar == null) {
            return false;
        }
        if (tP.gHT == null && dVar.gHT == null) {
            return false;
        }
        if ((tP.gHT != null || dVar.gHT == null) && (dVar.gHT != null || tP.gHT == null)) {
            if (tP.gHT == null || dVar.gHT == null) {
                return false;
            }
            if (tP.gHT.gpS == null && dVar.gHT.gpS == null) {
                return false;
            }
            if ((tP.gHT.gpS != null || dVar.gHT.gpS == null) && (dVar.gHT.gpS != null || tP.gHT.gpS == null)) {
                int size = tP.gHT.gpS.size();
                if (size != dVar.gHT.gpS.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    as asVar = dVar.gHT.gpS.get(i);
                    as asVar2 = tP.gHT.gpS.get(i);
                    if (asVar.gpO != asVar2.gpO || !asVar.name.equals(asVar2.name)) {
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
        if (this.gHJ) {
            this.gHB = new ArrayList();
            this.gHB.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                at atVar2 = dVar.gHT;
                if (atVar2 != null && atVar2.gpS != null) {
                    atVar2.gpS.clear();
                    atVar = atVar2;
                } else {
                    at atVar3 = new at();
                    atVar3.gpS = new ArrayList();
                    atVar = atVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    as asVar = new as();
                    asVar.gpO = 1;
                    asVar.name = getContext().getString(R.string.chosen_pb_title);
                    atVar.gpS.add(asVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            as asVar2 = new as();
                            asVar2.gpO = dVar3.tabId;
                            asVar2.name = dVar3.name;
                            atVar.gpS.add(asVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.gHT = atVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.gHB = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.gHG > 0 && list.size() == this.gHG) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.gHG, -1);
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
            this.gHz.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.gHJ);
            if (this.gHK != 0) {
                tabItemView.setSelectItemColorResId(this.gHK);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.gHz.addView(tabItemView, layoutParams);
            this.gHC = tabItemView;
            tabItemView.setState(TabItemView.gHV);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cu(list)) {
            this.mData = list;
            this.gHz.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.gHJ);
                        if (302 == dVar2.tabId) {
                            am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.gHK != 0) {
                            tabItemView2.setSelectItemColorResId(this.gHK);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (tT(dVar2.tabId)) {
                            am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.gHz.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.gHC = tabItemView2;
                            tabItemView2.setState(TabItemView.gHV);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d tP(int i) {
        if (i < 0 || this.gHB == null || this.gHB.size() == 0) {
            return null;
        }
        for (d dVar : this.gHB) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean tQ(int i) {
        d tP = tP(i);
        return (tP == null || tP.gHT == null || tP.gHT.gpS == null || tP.gHT.gpS.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.gHD = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gHC != null) {
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
            if (this.gHH) {
                canvas.drawRect(this.gHz.getLeft(), getMeasuredHeight() - this.gHF, this.gHz.getRight() > getRight() ? this.gHz.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.gHJ) {
                if (this.gHK == 0) {
                    this.mPaint.setColor(am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.getSkinColor(null, this.gHK));
                }
                canvas.drawRect(this.gHC.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.gHE, (this.gHC.getRight() - getBottomLineMargin()) - this.gHC.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.gHJ) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.gHC != null) {
                dimens = this.gHC.getRight() - this.gHC.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.gHC == null || this.gHy == 0) {
            return 0;
        }
        return ((this.gHC.getMeasuredWidth() - this.gHy) - this.gHC.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void tR(int i) {
        a(tO(i));
    }

    public void setDataLoadInterface(ag agVar) {
        this.gHP = agVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.gHQ = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.gHQ;
    }

    public void setTabBackgroudColor(int i) {
        this.gHI = i;
    }

    public void setAutoFillTabCount(int i) {
        this.gHG = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void tS(int i) {
        if (this.gHC != null && this.gHP != null) {
            this.gHP.a(this.gHC.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gHL = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.gHM = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.gHJ = z;
    }

    public static boolean tT(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.gHH = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.gHK = i;
    }
}
