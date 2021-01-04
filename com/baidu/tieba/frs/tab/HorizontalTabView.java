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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext iUb;
    public int jGA;
    private final LinearLayout jGB;
    private final e jGC;
    private List<d> jGD;
    private TabItemView jGE;
    private com.baidu.tieba.frs.tab.b jGF;
    private final int jGG;
    private final int jGH;
    private int jGI;
    private boolean jGJ;
    private int jGK;
    private boolean jGL;
    private int jGM;
    private a jGN;
    private b jGO;
    private e.b jGP;
    private e.a jGQ;
    private an jGR;
    private c jGS;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes2.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void BL(int i);

        boolean BM(int i);
    }

    public void cMK() {
        final bd bdVar;
        if (this.iUb != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bdVar = this.mData.get(0).jGV) != null && bdVar.jjK != null) {
                for (bc bcVar : bdVar.jjK) {
                    if (bcVar != null) {
                        arrayList.add(bcVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iUb.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0578b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bdVar.jjK.size() > i && bdVar.jjK.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.BE(bdVar.jjK.get(i).jjG));
                        }
                    }
                });
                bVar.d(this.iUb);
                bVar.btZ();
            }
        }
    }

    public d BE(int i) {
        if (!x.isEmpty(this.jGD)) {
            for (d dVar : this.jGD) {
                if (dVar != null && dVar.tabId == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void a(d dVar) {
        boolean z;
        ax axVar;
        if (dVar != null) {
            if (this.jGO != null) {
                this.jGO.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (BJ(dVar.tabId)) {
                if (this.jGR != null && !TextUtils.isEmpty(dVar.url)) {
                    ax axVar2 = new ax();
                    axVar2.ext = dVar.url;
                    this.jGR.a(dVar.tabId, -1, axVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.jGR != null) {
                    this.jGR.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.jGR == null) {
                    z = true;
                } else {
                    ax axVar3 = new ax();
                    axVar3.ext = dVar.url;
                    axVar3.stType = dVar.name;
                    this.jGR.a(dVar.tabId, 0, axVar3);
                    if (axVar3.jkg) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.jGB.getChildCount(); i++) {
                    View childAt = this.jGB.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(dVar.url)) {
                    axVar = null;
                } else {
                    axVar = new ax();
                    axVar.ext = dVar.url;
                    axVar.stType = dVar.name;
                }
                if (this.jGR != null && z) {
                    this.jGR.a(dVar.tabId, 0, axVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ax axVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (BJ(tabItemView.getTabId())) {
                if (this.jGR != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ax axVar2 = new ax();
                    axVar2.ext = tabItemView.getUrl();
                    this.jGR.a(tabItemView.getTabId(), -1, axVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.jGR != null) {
                    this.jGR.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.jGE = tabItemView;
                int[] iArr = new int[2];
                this.jGE.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.jGB.getChildCount(); i2++) {
                    View childAt = this.jGB.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.jGE.getTabId() && !BJ(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.jGW);
                        }
                    }
                }
                if (this.jGE.getState() == TabItemView.jGW || this.jGE.getState() == TabItemView.STATE_EXPANDED) {
                    this.jGC.cMN();
                    boolean z2 = this.jGE.getState() == TabItemView.jGW;
                    this.jGE.setState(TabItemView.jGX);
                    d BF = BF(this.jGE.getTabId());
                    if (BF != null) {
                        if (!TextUtils.isEmpty(BF.url)) {
                            ax axVar3 = new ax();
                            axVar3.ext = BF.url;
                            axVar3.stType = BF.name;
                            axVar = axVar3;
                        }
                        if (BF.jGV != null && BF.jGV.jjK != null && BF.jGV.jjK.size() > 0) {
                            for (bc bcVar : BF.jGV.jjK) {
                                if (bcVar != null && bcVar.isSelected) {
                                    i = bcVar.jjG;
                                }
                            }
                        }
                        if (z2 && this.jGR != null) {
                            this.jGR.a(this.jGE.getTabId(), i, axVar);
                        }
                    } else {
                        return;
                    }
                } else if (BG(this.jGE.getTabId()) && !z) {
                    if (this.jGS == null || this.jGS.BM(this.jGE.getTabId())) {
                        this.jGE.setState(TabItemView.STATE_EXPANDED);
                        this.jGC.a((Activity) getContext(), this, this.jGE, BF(this.jGE.getTabId()).jGV);
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
        this.jGA = 0;
        this.jGE = null;
        this.jGF = null;
        this.mPaint = new Paint();
        this.jGG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.jGH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.jGI = 0;
        this.jGJ = true;
        this.jGK = R.color.transparent;
        this.jGM = 0;
        this.jGP = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void BK(int i) {
                if (HorizontalTabView.this.jGE != null && HorizontalTabView.this.jGR != null && HorizontalTabView.this.jGR != null) {
                    HorizontalTabView.this.jGR.a(HorizontalTabView.this.jGE.getTabId(), i, null);
                }
                if (HorizontalTabView.this.jGF != null) {
                    HorizontalTabView.this.jGF.BI(i);
                }
            }
        };
        this.jGQ = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.jGL) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.jGN != null) {
                            HorizontalTabView.this.jGN.b(HorizontalTabView.this.BE(1));
                        }
                        HorizontalTabView.this.cMK();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.jGF != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.BJ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.jGE != null) {
                            HorizontalTabView.this.jGF.BH(HorizontalTabView.this.jGE.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.jGF.BH(((TabItemView) view).getTabId());
                }
            }
        };
        this.jGB = new LinearLayout(context);
        this.jGB.setOrientation(0);
        this.jGB.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.jGC = new e(context, this.jGP, this.jGQ);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.jGB, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ao.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean dI(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d BF = BF(1);
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
        if (BF == null || dVar == null) {
            return false;
        }
        if (BF.jGV == null && dVar.jGV == null) {
            return false;
        }
        if ((BF.jGV != null || dVar.jGV == null) && (dVar.jGV != null || BF.jGV == null)) {
            if (BF.jGV == null || dVar.jGV == null) {
                return false;
            }
            if (BF.jGV.jjK == null && dVar.jGV.jjK == null) {
                return false;
            }
            if ((BF.jGV.jjK != null || dVar.jGV.jjK == null) && (dVar.jGV.jjK != null || BF.jGV.jjK == null)) {
                int size = BF.jGV.jjK.size();
                if (size != dVar.jGV.jjK.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bc bcVar = dVar.jGV.jjK.get(i);
                    bc bcVar2 = BF.jGV.jjK.get(i);
                    if (bcVar.jjG != bcVar2.jjG || !bcVar.name.equals(bcVar2.name)) {
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
        bd bdVar;
        if (this.jGL) {
            this.jGD = new ArrayList();
            this.jGD.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bd bdVar2 = dVar.jGV;
                if (bdVar2 != null && bdVar2.jjK != null) {
                    bdVar2.jjK.clear();
                    bdVar = bdVar2;
                } else {
                    bd bdVar3 = new bd();
                    bdVar3.jjK = new ArrayList();
                    bdVar = bdVar3;
                }
                if (x.getCount(list) > 1) {
                    bc bcVar = new bc();
                    bcVar.jjG = 1;
                    bcVar.name = getContext().getString(R.string.chosen_pb_title);
                    bdVar.jjK.add(bcVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bc bcVar2 = new bc();
                            bcVar2.jjG = dVar2.tabId;
                            bcVar2.name = dVar2.name;
                            bdVar.jjK.add(bcVar2);
                        }
                    }
                    dVar.jGV = bdVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.jGD = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.jGI > 0 && list.size() == this.jGI) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.jGI, -1);
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
            this.jGB.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.jGL);
            if (this.jGM != 0) {
                tabItemView.setSelectItemColorResId(this.jGM);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.jGB.addView(tabItemView, layoutParams);
            this.jGE = tabItemView;
            tabItemView.setState(TabItemView.jGX);
            return;
        }
        setVisibility(0);
        if (this.mData == null || dI(list)) {
            this.mData = list;
            this.jGB.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.jGL);
                        if (this.jGM != 0) {
                            tabItemView2.setSelectItemColorResId(this.jGM);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (BJ(dVar2.tabId)) {
                            ao.setViewTextColor(tabItemView2, R.color.CAM_X0105);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.jGB.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.jGE = tabItemView2;
                            tabItemView2.setState(TabItemView.jGX);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d BF(int i) {
        if (i < 0 || this.jGD == null || this.jGD.size() == 0) {
            return null;
        }
        for (d dVar : this.jGD) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean BG(int i) {
        d BF = BF(i);
        return (BF == null || BF.jGV == null || BF.jGV.jjK == null || BF.jGV.jjK.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.jGF = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jGE != null) {
            this.mPaint.setColor(ao.getColor(R.color.CAM_X0204));
            if (this.jGJ) {
                canvas.drawRect(this.jGB.getLeft(), getMeasuredHeight() - this.jGH, this.jGB.getRight() > getRight() ? this.jGB.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.jGL) {
                if (this.jGM == 0) {
                    this.mPaint.setColor(ao.getSkinColor(null, R.color.CAM_X0302));
                } else {
                    this.mPaint.setColor(ao.getSkinColor(null, this.jGM));
                }
                canvas.drawRect(this.jGE.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.jGG, (this.jGE.getRight() - getBottomLineMargin()) - this.jGE.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.jGL) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ao.getSkinColor(null, R.color.CAM_X0105));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.jGE != null) {
                dimens = this.jGE.getRight() - this.jGE.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.jGE == null || this.jGA == 0) {
            return 0;
        }
        return ((this.jGE.getMeasuredWidth() - this.jGA) - this.jGE.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void BH(int i) {
        a(BE(i));
    }

    public void setDataLoadInterface(an anVar) {
        this.jGR = anVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.jGS = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.jGS;
    }

    public void setTabBackgroudColor(int i) {
        this.jGK = i;
    }

    public void setAutoFillTabCount(int i) {
        this.jGI = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void BI(int i) {
        if (this.jGE != null && this.jGR != null) {
            this.jGR.a(this.jGE.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jGN = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.jGO = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.jGL = z;
    }

    public static boolean BJ(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.jGJ = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.jGM = i;
    }
}
