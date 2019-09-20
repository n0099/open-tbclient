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
    private com.baidu.tieba.frs.tab.b fRA;
    private final int fRB;
    private final int fRC;
    private int fRD;
    private boolean fRE;
    private int fRF;
    private boolean fRG;
    private int fRH;
    private a fRI;
    private b fRJ;
    private e.b fRK;
    private e.a fRL;
    private af fRM;
    private c fRN;
    public int fRv;
    private final LinearLayout fRw;
    private final e fRx;
    private List<d> fRy;
    private TabItemView fRz;
    private TbPageContext fhC;
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
        void sR(int i);

        boolean sS(int i);
    }

    public void bsH() {
        final as asVar;
        if (this.fhC != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).fRQ) != null && asVar.fzO != null) {
                for (ar arVar : asVar.fzO) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.fhC.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.fzO.size() > i && asVar.fzO.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.sK(asVar.fzO.get(i).fzK));
                        }
                    }
                });
                bVar.d(this.fhC);
                bVar.agR();
            }
        }
    }

    public d sK(int i) {
        if (!v.aa(this.fRy)) {
            for (d dVar : this.fRy) {
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
            if (dVar.tabId != 302 && this.fRJ != null) {
                this.fRJ.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (sP(dVar.tabId)) {
                if (this.fRM != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.fAk = dVar.url;
                    this.fRM.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.fRM != null) {
                    this.fRM.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.fRM == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.fAk = dVar.url;
                    amVar2.stType = dVar.name;
                    this.fRM.a(dVar.tabId, 0, amVar2);
                    if (amVar2.fAl) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.fRw.getChildCount(); i++) {
                    View childAt = this.fRw.getChildAt(i);
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
                    amVar3.fAk = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.fRM != null && z) {
                    this.fRM.a(dVar.tabId, 0, amVar3);
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
            if (sP(tabItemView.getTabId())) {
                if (this.fRM != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.fAk = tabItemView.getUrl();
                    this.fRM.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.fRM != null) {
                    this.fRM.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.fRz = tabItemView;
                int[] iArr = new int[2];
                this.fRz.getLocationOnScreen(iArr);
                int af = l.af(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (af < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.fRw.getChildCount(); i2++) {
                    View childAt = this.fRw.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.fRz.getTabId() && !sP(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.fRR);
                        }
                    }
                }
                if (this.fRz.getState() == TabItemView.fRR || this.fRz.getState() == TabItemView.STATE_EXPANDED) {
                    this.fRx.bsK();
                    boolean z2 = this.fRz.getState() == TabItemView.fRR;
                    this.fRz.setState(TabItemView.fRS);
                    d sL = sL(this.fRz.getTabId());
                    if (sL != null) {
                        if (!TextUtils.isEmpty(sL.url)) {
                            am amVar3 = new am();
                            amVar3.fAk = sL.url;
                            amVar3.stType = sL.name;
                            amVar = amVar3;
                        }
                        if (sL.fRQ != null && sL.fRQ.fzO != null && sL.fRQ.fzO.size() > 0) {
                            for (ar arVar : sL.fRQ.fzO) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fzK;
                                }
                            }
                        }
                        if (z2 && this.fRM != null) {
                            this.fRM.a(this.fRz.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (sM(this.fRz.getTabId()) && !z) {
                    if (this.fRN == null || this.fRN.sS(this.fRz.getTabId())) {
                        this.fRz.setState(TabItemView.STATE_EXPANDED);
                        this.fRx.a((Activity) getContext(), this, this.fRz, sL(this.fRz.getTabId()).fRQ);
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
        this.fRv = 0;
        this.fRz = null;
        this.fRA = null;
        this.mPaint = new Paint();
        this.fRB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.fRC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.fRD = 0;
        this.fRE = true;
        this.fRF = R.color.transparent;
        this.fRH = 0;
        this.fRK = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void sQ(int i) {
                if (HorizontalTabView.this.fRz != null && HorizontalTabView.this.fRM != null && HorizontalTabView.this.fRM != null) {
                    HorizontalTabView.this.fRM.a(HorizontalTabView.this.fRz.getTabId(), i, null);
                }
                if (HorizontalTabView.this.fRA != null) {
                    HorizontalTabView.this.fRA.sO(i);
                }
            }
        };
        this.fRL = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.fRG) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.fRI != null) {
                                HorizontalTabView.this.fRI.b(HorizontalTabView.this.sK(1));
                            }
                            HorizontalTabView.this.bsH();
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
                if (HorizontalTabView.this.fRA != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.sP(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.fRz != null) {
                            HorizontalTabView.this.fRA.sN(HorizontalTabView.this.fRz.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.fRA.sN(((TabItemView) view).getTabId());
                }
            }
        };
        this.fRw = new LinearLayout(context);
        this.fRw.setOrientation(0);
        this.fRw.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.fRx = new e(context, this.fRK, this.fRL);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.fRw, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        com.baidu.tbadk.core.util.am.l(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cl(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d sL = sL(1);
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
        if (sL == null || dVar == null) {
            return false;
        }
        if (sL.fRQ == null && dVar.fRQ == null) {
            return false;
        }
        if ((sL.fRQ != null || dVar.fRQ == null) && (dVar.fRQ != null || sL.fRQ == null)) {
            if (sL.fRQ == null || dVar.fRQ == null) {
                return false;
            }
            if (sL.fRQ.fzO == null && dVar.fRQ.fzO == null) {
                return false;
            }
            if ((sL.fRQ.fzO != null || dVar.fRQ.fzO == null) && (dVar.fRQ.fzO != null || sL.fRQ.fzO == null)) {
                int size = sL.fRQ.fzO.size();
                if (size != dVar.fRQ.fzO.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.fRQ.fzO.get(i);
                    ar arVar2 = sL.fRQ.fzO.get(i);
                    if (arVar.fzK != arVar2.fzK || !arVar.name.equals(arVar2.name)) {
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
        if (this.fRG) {
            this.fRy = new ArrayList();
            this.fRy.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.fRQ;
                if (asVar2 != null && asVar2.fzO != null) {
                    asVar2.fzO.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.fzO = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.Z(list) > 1) {
                    ar arVar = new ar();
                    arVar.fzK = 1;
                    arVar.name = getContext().getString(R.string.chosen_pb_title);
                    asVar.fzO.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.fzK = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.fzO.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.fRQ = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.fRy = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.fRD > 0 && list.size() == this.fRD) {
            layoutParams = new LinearLayout.LayoutParams(l.af(getContext()) / this.fRD, -1);
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
            this.fRw.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.fRG);
            if (this.fRH != 0) {
                tabItemView.setSelectItemColorResId(this.fRH);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.fRw.addView(tabItemView, layoutParams);
            this.fRz = tabItemView;
            tabItemView.setState(TabItemView.fRS);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cl(list)) {
            this.mData = list;
            this.fRw.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.fRG);
                        if (302 == dVar2.tabId) {
                            com.baidu.tbadk.core.util.am.f(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.fRH != 0) {
                            tabItemView2.setSelectItemColorResId(this.fRH);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (sP(dVar2.tabId)) {
                            com.baidu.tbadk.core.util.am.j(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.fRw.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.fRz = tabItemView2;
                            tabItemView2.setState(TabItemView.fRS);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d sL(int i) {
        if (i < 0 || this.fRy == null || this.fRy.size() == 0) {
            return null;
        }
        for (d dVar : this.fRy) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean sM(int i) {
        d sL = sL(i);
        return (sL == null || sL.fRQ == null || sL.fRQ.fzO == null || sL.fRQ.fzO.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.fRA = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fRz != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_c));
            if (this.fRE) {
                canvas.drawRect(this.fRw.getLeft(), getMeasuredHeight() - this.fRC, this.fRw.getRight() > getRight() ? this.fRw.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.fRG) {
                if (this.fRH == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.am.f(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.am.f(null, this.fRH));
                }
                canvas.drawRect(this.fRz.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.fRB, (this.fRz.getRight() - getBottomLineMargin()) - this.fRz.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.fRG) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.am.f(null, R.color.cp_cont_b));
            int g = l.g(getContext(), R.dimen.ds96);
            if (this.fRz != null) {
                g = this.fRz.getRight() - this.fRz.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.g(getContext(), R.dimen.tbds44), l.g(getContext(), R.dimen.tbds98), g, l.g(getContext(), R.dimen.tbds104)), l.g(getContext(), R.dimen.tbds6), l.g(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.fRz == null || this.fRv == 0) {
            return 0;
        }
        return ((this.fRz.getMeasuredWidth() - this.fRv) - this.fRz.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sN(int i) {
        a(sK(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.fRM = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.fRN = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.fRN;
    }

    public void setTabBackgroudColor(int i) {
        this.fRF = i;
    }

    public void setAutoFillTabCount(int i) {
        this.fRD = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sO(int i) {
        if (this.fRz != null && this.fRM != null) {
            this.fRM.a(this.fRz.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fRI = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.fRJ = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.fRG = z;
    }

    public static boolean sP(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.fRE = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.fRH = i;
    }
}
