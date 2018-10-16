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
    public int dTP;
    private final LinearLayout dTQ;
    private final e dTR;
    private List<d> dTS;
    private TabItemView dTT;
    private com.baidu.tieba.frs.tab.b dTU;
    private final int dTV;
    private final int dTW;
    private int dTX;
    private boolean dTY;
    private int dTZ;
    private boolean dUa;
    private int dUb;
    private a dUc;
    private b dUd;
    private e.b dUe;
    private e.a dUf;
    private ai dUg;
    private c dUh;
    private TbPageContext dlY;
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
        void mF(int i);

        boolean mG(int i);
    }

    public void aFE() {
        final au auVar;
        if (this.dlY != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).dUk) != null && auVar.dDE != null) {
                for (at atVar : auVar.dDE) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.dlY.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0124b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.dDE.size() > i && auVar.dDE.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.my(auVar.dDE.get(i).dDA));
                        }
                    }
                });
                bVar.d(this.dlY);
                bVar.Ax();
            }
        }
    }

    public d my(int i) {
        if (!v.J(this.dTS)) {
            for (d dVar : this.dTS) {
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
            if (dVar.tabId != 302 && this.dUd != null) {
                this.dUd.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (mD(dVar.tabId)) {
                if (this.dUg != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dEa = dVar.url;
                    this.dUg.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.dUg != null) {
                    this.dUg.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.dUg == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dEa = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.dUg.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dEb) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.dTQ.getChildCount(); i++) {
                    View childAt = this.dTQ.getChildAt(i);
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
                    aoVar3.dEa = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.dUg != null && z) {
                    this.dUg.a(dVar.tabId, 0, aoVar3);
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
            if (mD(tabItemView.getTabId())) {
                if (this.dUg != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dEa = tabItemView.getUrl();
                    this.dUg.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.dUg != null) {
                    this.dUg.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.dTT = tabItemView;
                int[] iArr = new int[2];
                this.dTT.getLocationOnScreen(iArr);
                int aO = l.aO(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.C0175e.ds160);
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
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(e.C0175e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.dTQ.getChildCount(); i2++) {
                    View childAt = this.dTQ.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.dTT.getTabId() && !mD(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.dUl);
                        }
                    }
                }
                if (this.dTT.getState() == TabItemView.dUl || this.dTT.getState() == TabItemView.STATE_EXPANDED) {
                    this.dTR.dismissMenu();
                    boolean z2 = this.dTT.getState() == TabItemView.dUl;
                    this.dTT.setState(TabItemView.dUm);
                    d mz = mz(this.dTT.getTabId());
                    if (mz != null) {
                        if (!TextUtils.isEmpty(mz.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dEa = mz.url;
                            aoVar3.stType = mz.name;
                            aoVar = aoVar3;
                        }
                        if (mz.dUk != null && mz.dUk.dDE != null && mz.dUk.dDE.size() > 0) {
                            for (at atVar : mz.dUk.dDE) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dDA;
                                }
                            }
                        }
                        if (z2 && this.dUg != null) {
                            this.dUg.a(this.dTT.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (mA(this.dTT.getTabId()) && !z) {
                    if (this.dUh == null || this.dUh.mG(this.dTT.getTabId())) {
                        this.dTT.setState(TabItemView.STATE_EXPANDED);
                        this.dTR.a((Activity) getContext(), this, this.dTT, mz(this.dTT.getTabId()).dUk);
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
        this.dTP = 0;
        this.dTT = null;
        this.dTU = null;
        this.mPaint = new Paint();
        this.dTV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds6);
        this.dTW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds1);
        this.dTX = 0;
        this.dTY = true;
        this.dTZ = e.d.transparent;
        this.dUb = 0;
        this.dUe = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void mE(int i) {
                if (HorizontalTabView.this.dTT != null && HorizontalTabView.this.dUg != null && HorizontalTabView.this.dUg != null) {
                    HorizontalTabView.this.dUg.a(HorizontalTabView.this.dTT.getTabId(), i, null);
                }
                if (HorizontalTabView.this.dTU != null) {
                    HorizontalTabView.this.dTU.mC(i);
                }
            }
        };
        this.dUf = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.dUa) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.dUc != null) {
                                HorizontalTabView.this.dUc.b(HorizontalTabView.this.my(1));
                            }
                            HorizontalTabView.this.aFE();
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
                if (HorizontalTabView.this.dTU != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.mD(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.dTT != null) {
                            HorizontalTabView.this.dTU.mB(HorizontalTabView.this.dTT.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.dTU.mB(((TabItemView) view).getTabId());
                }
            }
        };
        this.dTQ = new LinearLayout(context);
        this.dTQ.setOrientation(0);
        this.dTQ.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(e.C0175e.ds88));
        this.dTR = new e(context, this.dUe, this.dUf);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.dTQ, layoutParams);
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
        d mz = mz(1);
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
        if (mz == null || dVar == null) {
            return false;
        }
        if (mz.dUk == null && dVar.dUk == null) {
            return false;
        }
        if ((mz.dUk != null || dVar.dUk == null) && (dVar.dUk != null || mz.dUk == null)) {
            if (mz.dUk == null || dVar.dUk == null) {
                return false;
            }
            if (mz.dUk.dDE == null && dVar.dUk.dDE == null) {
                return false;
            }
            if ((mz.dUk.dDE != null || dVar.dUk.dDE == null) && (dVar.dUk.dDE != null || mz.dUk.dDE == null)) {
                int size = mz.dUk.dDE.size();
                if (size != dVar.dUk.dDE.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.dUk.dDE.get(i);
                    at atVar2 = mz.dUk.dDE.get(i);
                    if (atVar.dDA != atVar2.dDA || !atVar.name.equals(atVar2.name)) {
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
        if (this.dUa) {
            this.dTS = new ArrayList();
            this.dTS.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.dUk;
                if (auVar2 != null && auVar2.dDE != null) {
                    auVar2.dDE.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.dDE = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.I(list) > 1) {
                    at atVar = new at();
                    atVar.dDA = 1;
                    atVar.name = getContext().getString(e.j.chosen_pb_title);
                    auVar.dDE.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.dDA = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.dDE.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.dUk = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.dTS = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.dTX > 0 && list.size() == this.dTX) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.dTX, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.C0175e.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.tabId = 1;
            dVar.name = getContext().getResources().getString(e.j.chosen_pb_title);
            this.dTQ.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.dUa);
            if (this.dUb != 0) {
                tabItemView.setSelectItemColorResId(this.dUb);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0175e.ds32);
            this.dTQ.addView(tabItemView, layoutParams);
            this.dTT = tabItemView;
            tabItemView.setState(TabItemView.dUm);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bQ(list)) {
            this.mData = list;
            this.dTQ.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.dUa);
                        if (302 == dVar2.tabId) {
                            al.c(tabItemView2, e.d.cp_cont_j, 1);
                        }
                        if (this.dUb != 0) {
                            tabItemView2.setSelectItemColorResId(this.dUb);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (mD(dVar2.tabId)) {
                            al.h(tabItemView2, e.d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0175e.tbds44);
                        }
                        this.dTQ.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.dTT = tabItemView2;
                            tabItemView2.setState(TabItemView.dUm);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d mz(int i) {
        if (i < 0 || this.dTS == null || this.dTS.size() == 0) {
            return null;
        }
        for (d dVar : this.dTS) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean mA(int i) {
        d mz = mz(i);
        return (mz == null || mz.dUk == null || mz.dUk.dDE == null || mz.dUk.dDE.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.dTU = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dTT != null) {
            this.mPaint.setColor(al.getColor(e.d.cp_bg_line_b));
            if (this.dTY) {
                canvas.drawRect(this.dTQ.getLeft(), getMeasuredHeight() - this.dTW, this.dTQ.getRight() > getRight() ? this.dTQ.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.dUa) {
                if (this.dUb == 0) {
                    this.mPaint.setColor(al.d((Resources) null, e.d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.dUb));
                }
                canvas.drawRect(this.dTT.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.dTV, (this.dTT.getRight() - getBottomLineMargin()) - this.dTT.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.dUa) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, e.d.cp_cont_b));
            int h = l.h(getContext(), e.C0175e.ds96);
            if (this.dTT != null) {
                h = this.dTT.getRight() - this.dTT.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), e.C0175e.tbds44), l.h(getContext(), e.C0175e.tbds98), h, l.h(getContext(), e.C0175e.tbds104)), l.h(getContext(), e.C0175e.tbds6), l.h(getContext(), e.C0175e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.dTT == null || this.dTP == 0) {
            return 0;
        }
        return ((this.dTT.getMeasuredWidth() - this.dTP) - this.dTT.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void mB(int i) {
        a(my(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.dUg = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.dUh = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.dUh;
    }

    public void setTabBackgroudColor(int i) {
        this.dTZ = i;
    }

    public void setAutoFillTabCount(int i) {
        this.dTX = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void mC(int i) {
        if (this.dTT != null && this.dUg != null) {
            this.dUg.a(this.dTT.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dUc = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.dUd = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.dUa = z;
    }

    public static boolean mD(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.dTY = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.dUb = i;
    }
}
