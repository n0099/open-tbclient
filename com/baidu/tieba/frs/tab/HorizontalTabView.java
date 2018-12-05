package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext dtE;
    private final LinearLayout ebA;
    private final e ebB;
    private List<d> ebC;
    private TabItemView ebD;
    private com.baidu.tieba.frs.tab.b ebE;
    private final int ebF;
    private final int ebG;
    private int ebH;
    private boolean ebI;
    private int ebJ;
    private boolean ebK;
    private int ebL;
    private a ebM;
    private b ebN;
    private e.b ebO;
    private e.a ebP;
    private ai ebQ;
    private c ebR;
    public int ebz;
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
        void nn(int i);

        boolean no(int i);
    }

    public void aGM() {
        final au auVar;
        if (this.dtE != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).ebU) != null && auVar.dLt != null) {
                for (at atVar : auVar.dLt) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.dtE.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.dLt.size() > i && auVar.dLt.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.ng(auVar.dLt.get(i).dLp));
                        }
                    }
                });
                bVar.d(this.dtE);
                bVar.BI();
            }
        }
    }

    public d ng(int i) {
        if (!v.I(this.ebC)) {
            for (d dVar : this.ebC) {
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
            if (dVar.tabId != 302 && this.ebN != null) {
                this.ebN.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (nl(dVar.tabId)) {
                if (this.ebQ != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dLP = dVar.url;
                    this.ebQ.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.ebQ != null) {
                    this.ebQ.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.ebQ == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dLP = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.ebQ.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dLQ) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.ebA.getChildCount(); i++) {
                    View childAt = this.ebA.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                ao aoVar3 = null;
                if (!TextUtils.isEmpty(dVar.url)) {
                    aoVar3 = new ao();
                    aoVar3.dLP = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.ebQ != null && z) {
                    this.ebQ.a(dVar.tabId, 0, aoVar3);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ao aoVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (nl(tabItemView.getTabId())) {
                if (this.ebQ != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dLP = tabItemView.getUrl();
                    this.ebQ.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.ebQ != null) {
                    this.ebQ.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.ebD = tabItemView;
                int[] iArr = new int[2];
                this.ebD.getLocationOnScreen(iArr);
                int aO = l.aO(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.C0210e.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (aO < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(e.C0210e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.ebA.getChildCount(); i2++) {
                    View childAt = this.ebA.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.ebD.getTabId() && !nl(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.ebV);
                        }
                    }
                }
                if (this.ebD.getState() == TabItemView.ebV || this.ebD.getState() == TabItemView.STATE_EXPANDED) {
                    this.ebB.dismissMenu();
                    boolean z2 = this.ebD.getState() == TabItemView.ebV;
                    this.ebD.setState(TabItemView.ebW);
                    d nh = nh(this.ebD.getTabId());
                    if (nh != null) {
                        if (!TextUtils.isEmpty(nh.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dLP = nh.url;
                            aoVar3.stType = nh.name;
                            aoVar = aoVar3;
                        }
                        if (nh.ebU != null && nh.ebU.dLt != null && nh.ebU.dLt.size() > 0) {
                            for (at atVar : nh.ebU.dLt) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dLp;
                                }
                            }
                        }
                        if (z2 && this.ebQ != null) {
                            this.ebQ.a(this.ebD.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (ni(this.ebD.getTabId()) && !z) {
                    if (this.ebR == null || this.ebR.no(this.ebD.getTabId())) {
                        this.ebD.setState(TabItemView.STATE_EXPANDED);
                        this.ebB.a((Activity) getContext(), this, this.ebD, nh(this.ebD.getTabId()).ebU);
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
        this.ebz = 0;
        this.ebD = null;
        this.ebE = null;
        this.mPaint = new Paint();
        this.ebF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds6);
        this.ebG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.ebH = 0;
        this.ebI = true;
        this.ebJ = e.d.transparent;
        this.ebL = 0;
        this.ebO = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void nm(int i) {
                if (HorizontalTabView.this.ebD != null && HorizontalTabView.this.ebQ != null && HorizontalTabView.this.ebQ != null) {
                    HorizontalTabView.this.ebQ.a(HorizontalTabView.this.ebD.getTabId(), i, null);
                }
                if (HorizontalTabView.this.ebE != null) {
                    HorizontalTabView.this.ebE.nk(i);
                }
            }
        };
        this.ebP = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.ebK) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.ebM != null) {
                                HorizontalTabView.this.ebM.b(HorizontalTabView.this.ng(1));
                            }
                            HorizontalTabView.this.aGM();
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
                if (HorizontalTabView.this.ebE != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.nl(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.ebD != null) {
                            HorizontalTabView.this.ebE.nj(HorizontalTabView.this.ebD.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.ebE.nj(((TabItemView) view).getTabId());
                }
            }
        };
        this.ebA = new LinearLayout(context);
        this.ebA.setOrientation(0);
        this.ebA.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(e.C0210e.ds88));
        this.ebB = new e(context, this.ebO, this.ebP);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.ebA, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.j(this, e.d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bQ(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d nh = nh(1);
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
        if (nh == null || dVar == null) {
            return false;
        }
        if (nh.ebU == null && dVar.ebU == null) {
            return false;
        }
        if ((nh.ebU != null || dVar.ebU == null) && (dVar.ebU != null || nh.ebU == null)) {
            if (nh.ebU == null || dVar.ebU == null) {
                return false;
            }
            if (nh.ebU.dLt == null && dVar.ebU.dLt == null) {
                return false;
            }
            if ((nh.ebU.dLt != null || dVar.ebU.dLt == null) && (dVar.ebU.dLt != null || nh.ebU.dLt == null)) {
                int size = nh.ebU.dLt.size();
                if (size != dVar.ebU.dLt.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.ebU.dLt.get(i);
                    at atVar2 = nh.ebU.dLt.get(i);
                    if (atVar.dLp != atVar2.dLp || !atVar.name.equals(atVar2.name)) {
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
        au auVar;
        if (this.ebK) {
            this.ebC = new ArrayList();
            this.ebC.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.ebU;
                if (auVar2 != null && auVar2.dLt != null) {
                    auVar2.dLt.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.dLt = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.H(list) > 1) {
                    at atVar = new at();
                    atVar.dLp = 1;
                    atVar.name = getContext().getString(e.j.chosen_pb_title);
                    auVar.dLt.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.dLp = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.dLt.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.ebU = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.ebC = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.ebH > 0 && list.size() == this.ebH) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.ebH, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.C0210e.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.tabId = 1;
            dVar.name = getContext().getResources().getString(e.j.chosen_pb_title);
            this.ebA.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.ebK);
            if (this.ebL != 0) {
                tabItemView.setSelectItemColorResId(this.ebL);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0210e.ds32);
            this.ebA.addView(tabItemView, layoutParams);
            this.ebD = tabItemView;
            tabItemView.setState(TabItemView.ebW);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bQ(list)) {
            this.mData = list;
            this.ebA.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.ebK);
                        if (302 == dVar2.tabId) {
                            al.c(tabItemView2, e.d.cp_cont_j, 1);
                        }
                        if (this.ebL != 0) {
                            tabItemView2.setSelectItemColorResId(this.ebL);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (nl(dVar2.tabId)) {
                            al.h(tabItemView2, e.d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0210e.tbds44);
                        }
                        this.ebA.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.ebD = tabItemView2;
                            tabItemView2.setState(TabItemView.ebW);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d nh(int i) {
        if (i < 0 || this.ebC == null || this.ebC.size() == 0) {
            return null;
        }
        for (d dVar : this.ebC) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean ni(int i) {
        d nh = nh(i);
        return (nh == null || nh.ebU == null || nh.ebU.dLt == null || nh.ebU.dLt.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.ebE = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ebD != null) {
            this.mPaint.setColor(al.getColor(e.d.cp_bg_line_b));
            if (this.ebI) {
                canvas.drawRect(this.ebA.getLeft(), getMeasuredHeight() - this.ebG, this.ebA.getRight() > getRight() ? this.ebA.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.ebK) {
                if (this.ebL == 0) {
                    this.mPaint.setColor(al.d((Resources) null, e.d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.ebL));
                }
                canvas.drawRect(this.ebD.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.ebF, (this.ebD.getRight() - getBottomLineMargin()) - this.ebD.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.ebK) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, e.d.cp_cont_b));
            int h = l.h(getContext(), e.C0210e.ds96);
            if (this.ebD != null) {
                h = this.ebD.getRight() - this.ebD.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), e.C0210e.tbds44), l.h(getContext(), e.C0210e.tbds98), h, l.h(getContext(), e.C0210e.tbds104)), l.h(getContext(), e.C0210e.tbds6), l.h(getContext(), e.C0210e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.ebD == null || this.ebz == 0) {
            return 0;
        }
        return ((this.ebD.getMeasuredWidth() - this.ebz) - this.ebD.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void nj(int i) {
        a(ng(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.ebQ = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.ebR = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.ebR;
    }

    public void setTabBackgroudColor(int i) {
        this.ebJ = i;
    }

    public void setAutoFillTabCount(int i) {
        this.ebH = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void nk(int i) {
        if (this.ebD != null && this.ebQ != null) {
            this.ebQ.a(this.ebD.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ebM = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.ebN = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.ebK = z;
    }

    public static boolean nl(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.ebI = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.ebL = i;
    }
}
