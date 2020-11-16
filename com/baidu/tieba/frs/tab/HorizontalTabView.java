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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes21.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext iwW;
    public int jgA;
    private final LinearLayout jgB;
    private final e jgC;
    private List<d> jgD;
    private TabItemView jgE;
    private com.baidu.tieba.frs.tab.b jgF;
    private final int jgG;
    private final int jgH;
    private int jgI;
    private boolean jgJ;
    private int jgK;
    private boolean jgL;
    private int jgM;
    private a jgN;
    private b jgO;
    private e.b jgP;
    private e.a jgQ;
    private ar jgR;
    private c jgS;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes21.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes21.dex */
    public interface c {
        void AL(int i);

        boolean AM(int i);
    }

    public void cEw() {
        final bg bgVar;
        if (this.iwW != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bgVar = this.mData.get(0).jgV) != null && bgVar.iME != null) {
                for (bf bfVar : bgVar.iME) {
                    if (bfVar != null) {
                        arrayList.add(bfVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iwW.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0574b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bgVar.iME.size() > i && bgVar.iME.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.AE(bgVar.iME.get(i).iMA));
                        }
                    }
                });
                bVar.d(this.iwW);
                bVar.boi();
            }
        }
    }

    public d AE(int i) {
        if (!y.isEmpty(this.jgD)) {
            for (d dVar : this.jgD) {
                if (dVar != null && dVar.tabId == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void a(d dVar) {
        boolean z;
        ba baVar;
        if (dVar != null) {
            if (this.jgO != null) {
                this.jgO.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (AJ(dVar.tabId)) {
                if (this.jgR != null && !TextUtils.isEmpty(dVar.url)) {
                    ba baVar2 = new ba();
                    baVar2.ext = dVar.url;
                    this.jgR.a(dVar.tabId, -1, baVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.jgR != null) {
                    this.jgR.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.jgR == null) {
                    z = true;
                } else {
                    ba baVar3 = new ba();
                    baVar3.ext = dVar.url;
                    baVar3.stType = dVar.name;
                    this.jgR.a(dVar.tabId, 0, baVar3);
                    if (baVar3.iNa) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.jgB.getChildCount(); i++) {
                    View childAt = this.jgB.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(dVar.url)) {
                    baVar = null;
                } else {
                    baVar = new ba();
                    baVar.ext = dVar.url;
                    baVar.stType = dVar.name;
                }
                if (this.jgR != null && z) {
                    this.jgR.a(dVar.tabId, 0, baVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ba baVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (AJ(tabItemView.getTabId())) {
                if (this.jgR != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ba baVar2 = new ba();
                    baVar2.ext = tabItemView.getUrl();
                    this.jgR.a(tabItemView.getTabId(), -1, baVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.jgR != null) {
                    this.jgR.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.jgE = tabItemView;
                int[] iArr = new int[2];
                this.jgE.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.jgB.getChildCount(); i2++) {
                    View childAt = this.jgB.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.jgE.getTabId() && !AJ(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.jgW);
                        }
                    }
                }
                if (this.jgE.getState() == TabItemView.jgW || this.jgE.getState() == TabItemView.STATE_EXPANDED) {
                    this.jgC.dismissMenu();
                    boolean z2 = this.jgE.getState() == TabItemView.jgW;
                    this.jgE.setState(TabItemView.jgX);
                    d AF = AF(this.jgE.getTabId());
                    if (AF != null) {
                        if (!TextUtils.isEmpty(AF.url)) {
                            ba baVar3 = new ba();
                            baVar3.ext = AF.url;
                            baVar3.stType = AF.name;
                            baVar = baVar3;
                        }
                        if (AF.jgV != null && AF.jgV.iME != null && AF.jgV.iME.size() > 0) {
                            for (bf bfVar : AF.jgV.iME) {
                                if (bfVar != null && bfVar.isSelected) {
                                    i = bfVar.iMA;
                                }
                            }
                        }
                        if (z2 && this.jgR != null) {
                            this.jgR.a(this.jgE.getTabId(), i, baVar);
                        }
                    } else {
                        return;
                    }
                } else if (AG(this.jgE.getTabId()) && !z) {
                    if (this.jgS == null || this.jgS.AM(this.jgE.getTabId())) {
                        this.jgE.setState(TabItemView.STATE_EXPANDED);
                        this.jgC.a((Activity) getContext(), this, this.jgE, AF(this.jgE.getTabId()).jgV);
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
        this.jgA = 0;
        this.jgE = null;
        this.jgF = null;
        this.mPaint = new Paint();
        this.jgG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.jgH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.jgI = 0;
        this.jgJ = true;
        this.jgK = R.color.transparent;
        this.jgM = 0;
        this.jgP = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void AK(int i) {
                if (HorizontalTabView.this.jgE != null && HorizontalTabView.this.jgR != null && HorizontalTabView.this.jgR != null) {
                    HorizontalTabView.this.jgR.a(HorizontalTabView.this.jgE.getTabId(), i, null);
                }
                if (HorizontalTabView.this.jgF != null) {
                    HorizontalTabView.this.jgF.AI(i);
                }
            }
        };
        this.jgQ = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.jgL) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.jgN != null) {
                            HorizontalTabView.this.jgN.b(HorizontalTabView.this.AE(1));
                        }
                        HorizontalTabView.this.cEw();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.jgF != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.AJ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.jgE != null) {
                            HorizontalTabView.this.jgF.AH(HorizontalTabView.this.jgE.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.jgF.AH(((TabItemView) view).getTabId());
                }
            }
        };
        this.jgB = new LinearLayout(context);
        this.jgB.setOrientation(0);
        this.jgB.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.jgC = new e(context, this.jgP, this.jgQ);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.jgB, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ap.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean dr(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d AF = AF(1);
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
        if (AF == null || dVar == null) {
            return false;
        }
        if (AF.jgV == null && dVar.jgV == null) {
            return false;
        }
        if ((AF.jgV != null || dVar.jgV == null) && (dVar.jgV != null || AF.jgV == null)) {
            if (AF.jgV == null || dVar.jgV == null) {
                return false;
            }
            if (AF.jgV.iME == null && dVar.jgV.iME == null) {
                return false;
            }
            if ((AF.jgV.iME != null || dVar.jgV.iME == null) && (dVar.jgV.iME != null || AF.jgV.iME == null)) {
                int size = AF.jgV.iME.size();
                if (size != dVar.jgV.iME.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bf bfVar = dVar.jgV.iME.get(i);
                    bf bfVar2 = AF.jgV.iME.get(i);
                    if (bfVar.iMA != bfVar2.iMA || !bfVar.name.equals(bfVar2.name)) {
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
        bg bgVar;
        if (this.jgL) {
            this.jgD = new ArrayList();
            this.jgD.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bg bgVar2 = dVar.jgV;
                if (bgVar2 != null && bgVar2.iME != null) {
                    bgVar2.iME.clear();
                    bgVar = bgVar2;
                } else {
                    bg bgVar3 = new bg();
                    bgVar3.iME = new ArrayList();
                    bgVar = bgVar3;
                }
                if (y.getCount(list) > 1) {
                    bf bfVar = new bf();
                    bfVar.iMA = 1;
                    bfVar.name = getContext().getString(R.string.chosen_pb_title);
                    bgVar.iME.add(bfVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bf bfVar2 = new bf();
                            bfVar2.iMA = dVar2.tabId;
                            bfVar2.name = dVar2.name;
                            bgVar.iME.add(bfVar2);
                        }
                    }
                    dVar.jgV = bgVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.jgD = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.jgI > 0 && list.size() == this.jgI) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.jgI, -1);
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
            this.jgB.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.jgL);
            if (this.jgM != 0) {
                tabItemView.setSelectItemColorResId(this.jgM);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.jgB.addView(tabItemView, layoutParams);
            this.jgE = tabItemView;
            tabItemView.setState(TabItemView.jgX);
            return;
        }
        setVisibility(0);
        if (this.mData == null || dr(list)) {
            this.mData = list;
            this.jgB.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.jgL);
                        if (this.jgM != 0) {
                            tabItemView2.setSelectItemColorResId(this.jgM);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (AJ(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.CAM_X0105);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.jgB.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.jgE = tabItemView2;
                            tabItemView2.setState(TabItemView.jgX);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d AF(int i) {
        if (i < 0 || this.jgD == null || this.jgD.size() == 0) {
            return null;
        }
        for (d dVar : this.jgD) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean AG(int i) {
        d AF = AF(i);
        return (AF == null || AF.jgV == null || AF.jgV.iME == null || AF.jgV.iME.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.jgF = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jgE != null) {
            this.mPaint.setColor(ap.getColor(R.color.CAM_X0204));
            if (this.jgJ) {
                canvas.drawRect(this.jgB.getLeft(), getMeasuredHeight() - this.jgH, this.jgB.getRight() > getRight() ? this.jgB.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.jgL) {
                if (this.jgM == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0302));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.jgM));
                }
                canvas.drawRect(this.jgE.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.jgG, (this.jgE.getRight() - getBottomLineMargin()) - this.jgE.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.jgL) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0105));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.jgE != null) {
                dimens = this.jgE.getRight() - this.jgE.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.jgE == null || this.jgA == 0) {
            return 0;
        }
        return ((this.jgE.getMeasuredWidth() - this.jgA) - this.jgE.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void AH(int i) {
        a(AE(i));
    }

    public void setDataLoadInterface(ar arVar) {
        this.jgR = arVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.jgS = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.jgS;
    }

    public void setTabBackgroudColor(int i) {
        this.jgK = i;
    }

    public void setAutoFillTabCount(int i) {
        this.jgI = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void AI(int i) {
        if (this.jgE != null && this.jgR != null) {
            this.jgR.a(this.jgE.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jgN = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.jgO = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.jgL = z;
    }

    public static boolean AJ(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.jgJ = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.jgM = i;
    }
}
