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
    public int dUW;
    private final LinearLayout dUX;
    private final e dUY;
    private List<d> dUZ;
    private TabItemView dVa;
    private com.baidu.tieba.frs.tab.b dVb;
    private final int dVc;
    private final int dVd;
    private int dVe;
    private boolean dVf;
    private int dVg;
    private boolean dVh;
    private int dVi;
    private a dVj;
    private b dVk;
    private e.b dVl;
    private e.a dVm;
    private ai dVn;
    private c dVo;
    private TbPageContext dnc;
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
        void mX(int i);

        boolean mY(int i);
    }

    public void aFa() {
        final au auVar;
        if (this.dnc != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).dVr) != null && auVar.dEU != null) {
                for (at atVar : auVar.dEU) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.dnc.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0148b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.dEU.size() > i && auVar.dEU.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.mQ(auVar.dEU.get(i).dEQ));
                        }
                    }
                });
                bVar.d(this.dnc);
                bVar.AE();
            }
        }
    }

    public d mQ(int i) {
        if (!v.I(this.dUZ)) {
            for (d dVar : this.dUZ) {
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
            if (dVar.tabId != 302 && this.dVk != null) {
                this.dVk.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (mV(dVar.tabId)) {
                if (this.dVn != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dFq = dVar.url;
                    this.dVn.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.dVn != null) {
                    this.dVn.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.dVn == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dFq = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.dVn.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dFr) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.dUX.getChildCount(); i++) {
                    View childAt = this.dUX.getChildAt(i);
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
                    aoVar3.dFq = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.dVn != null && z) {
                    this.dVn.a(dVar.tabId, 0, aoVar3);
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
            if (mV(tabItemView.getTabId())) {
                if (this.dVn != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dFq = tabItemView.getUrl();
                    this.dVn.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.dVn != null) {
                    this.dVn.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.dVa = tabItemView;
                int[] iArr = new int[2];
                this.dVa.getLocationOnScreen(iArr);
                int aO = l.aO(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.C0200e.ds160);
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
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(e.C0200e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.dUX.getChildCount(); i2++) {
                    View childAt = this.dUX.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.dVa.getTabId() && !mV(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.dVs);
                        }
                    }
                }
                if (this.dVa.getState() == TabItemView.dVs || this.dVa.getState() == TabItemView.STATE_EXPANDED) {
                    this.dUY.dismissMenu();
                    boolean z2 = this.dVa.getState() == TabItemView.dVs;
                    this.dVa.setState(TabItemView.dVt);
                    d mR = mR(this.dVa.getTabId());
                    if (mR != null) {
                        if (!TextUtils.isEmpty(mR.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dFq = mR.url;
                            aoVar3.stType = mR.name;
                            aoVar = aoVar3;
                        }
                        if (mR.dVr != null && mR.dVr.dEU != null && mR.dVr.dEU.size() > 0) {
                            for (at atVar : mR.dVr.dEU) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dEQ;
                                }
                            }
                        }
                        if (z2 && this.dVn != null) {
                            this.dVn.a(this.dVa.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (mS(this.dVa.getTabId()) && !z) {
                    if (this.dVo == null || this.dVo.mY(this.dVa.getTabId())) {
                        this.dVa.setState(TabItemView.STATE_EXPANDED);
                        this.dUY.a((Activity) getContext(), this, this.dVa, mR(this.dVa.getTabId()).dVr);
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
        this.dUW = 0;
        this.dVa = null;
        this.dVb = null;
        this.mPaint = new Paint();
        this.dVc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds6);
        this.dVd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.ds1);
        this.dVe = 0;
        this.dVf = true;
        this.dVg = e.d.transparent;
        this.dVi = 0;
        this.dVl = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void mW(int i) {
                if (HorizontalTabView.this.dVa != null && HorizontalTabView.this.dVn != null && HorizontalTabView.this.dVn != null) {
                    HorizontalTabView.this.dVn.a(HorizontalTabView.this.dVa.getTabId(), i, null);
                }
                if (HorizontalTabView.this.dVb != null) {
                    HorizontalTabView.this.dVb.mU(i);
                }
            }
        };
        this.dVm = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.dVh) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.dVj != null) {
                                HorizontalTabView.this.dVj.b(HorizontalTabView.this.mQ(1));
                            }
                            HorizontalTabView.this.aFa();
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
                if (HorizontalTabView.this.dVb != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.mV(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.dVa != null) {
                            HorizontalTabView.this.dVb.mT(HorizontalTabView.this.dVa.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.dVb.mT(((TabItemView) view).getTabId());
                }
            }
        };
        this.dUX = new LinearLayout(context);
        this.dUX.setOrientation(0);
        this.dUX.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(e.C0200e.ds88));
        this.dUY = new e(context, this.dVl, this.dVm);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.dUX, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.j(this, e.d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bO(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d mR = mR(1);
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
        if (mR == null || dVar == null) {
            return false;
        }
        if (mR.dVr == null && dVar.dVr == null) {
            return false;
        }
        if ((mR.dVr != null || dVar.dVr == null) && (dVar.dVr != null || mR.dVr == null)) {
            if (mR.dVr == null || dVar.dVr == null) {
                return false;
            }
            if (mR.dVr.dEU == null && dVar.dVr.dEU == null) {
                return false;
            }
            if ((mR.dVr.dEU != null || dVar.dVr.dEU == null) && (dVar.dVr.dEU != null || mR.dVr.dEU == null)) {
                int size = mR.dVr.dEU.size();
                if (size != dVar.dVr.dEU.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.dVr.dEU.get(i);
                    at atVar2 = mR.dVr.dEU.get(i);
                    if (atVar.dEQ != atVar2.dEQ || !atVar.name.equals(atVar2.name)) {
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
        if (this.dVh) {
            this.dUZ = new ArrayList();
            this.dUZ.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.dVr;
                if (auVar2 != null && auVar2.dEU != null) {
                    auVar2.dEU.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.dEU = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.H(list) > 1) {
                    at atVar = new at();
                    atVar.dEQ = 1;
                    atVar.name = getContext().getString(e.j.chosen_pb_title);
                    auVar.dEU.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.dEQ = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.dEU.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.dVr = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.dUZ = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.dVe > 0 && list.size() == this.dVe) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.dVe, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.C0200e.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.tabId = 1;
            dVar.name = getContext().getResources().getString(e.j.chosen_pb_title);
            this.dUX.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.dVh);
            if (this.dVi != 0) {
                tabItemView.setSelectItemColorResId(this.dVi);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0200e.ds32);
            this.dUX.addView(tabItemView, layoutParams);
            this.dVa = tabItemView;
            tabItemView.setState(TabItemView.dVt);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bO(list)) {
            this.mData = list;
            this.dUX.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.dVh);
                        if (302 == dVar2.tabId) {
                            al.c(tabItemView2, e.d.cp_cont_j, 1);
                        }
                        if (this.dVi != 0) {
                            tabItemView2.setSelectItemColorResId(this.dVi);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (mV(dVar2.tabId)) {
                            al.h(tabItemView2, e.d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0200e.tbds44);
                        }
                        this.dUX.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.dVa = tabItemView2;
                            tabItemView2.setState(TabItemView.dVt);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d mR(int i) {
        if (i < 0 || this.dUZ == null || this.dUZ.size() == 0) {
            return null;
        }
        for (d dVar : this.dUZ) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean mS(int i) {
        d mR = mR(i);
        return (mR == null || mR.dVr == null || mR.dVr.dEU == null || mR.dVr.dEU.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.dVb = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dVa != null) {
            this.mPaint.setColor(al.getColor(e.d.cp_bg_line_b));
            if (this.dVf) {
                canvas.drawRect(this.dUX.getLeft(), getMeasuredHeight() - this.dVd, this.dUX.getRight() > getRight() ? this.dUX.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.dVh) {
                if (this.dVi == 0) {
                    this.mPaint.setColor(al.d((Resources) null, e.d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.dVi));
                }
                canvas.drawRect(this.dVa.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.dVc, (this.dVa.getRight() - getBottomLineMargin()) - this.dVa.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.dVh) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, e.d.cp_cont_b));
            int h = l.h(getContext(), e.C0200e.ds96);
            if (this.dVa != null) {
                h = this.dVa.getRight() - this.dVa.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), e.C0200e.tbds44), l.h(getContext(), e.C0200e.tbds98), h, l.h(getContext(), e.C0200e.tbds104)), l.h(getContext(), e.C0200e.tbds6), l.h(getContext(), e.C0200e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.dVa == null || this.dUW == 0) {
            return 0;
        }
        return ((this.dVa.getMeasuredWidth() - this.dUW) - this.dVa.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void mT(int i) {
        a(mQ(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.dVn = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.dVo = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.dVo;
    }

    public void setTabBackgroudColor(int i) {
        this.dVg = i;
    }

    public void setAutoFillTabCount(int i) {
        this.dVe = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void mU(int i) {
        if (this.dVa != null && this.dVn != null) {
            this.dVn.a(this.dVa.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dVj = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.dVk = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.dVh = z;
    }

    public static boolean mV(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.dVf = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.dVi = i;
    }
}
