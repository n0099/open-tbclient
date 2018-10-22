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
    public int dTQ;
    private final LinearLayout dTR;
    private final e dTS;
    private List<d> dTT;
    private TabItemView dTU;
    private com.baidu.tieba.frs.tab.b dTV;
    private final int dTW;
    private final int dTX;
    private int dTY;
    private boolean dTZ;
    private int dUa;
    private boolean dUb;
    private int dUc;
    private a dUd;
    private b dUe;
    private e.b dUf;
    private e.a dUg;
    private ai dUh;
    private c dUi;
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
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).dUl) != null && auVar.dDE != null) {
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
        if (!v.J(this.dTT)) {
            for (d dVar : this.dTT) {
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
            if (dVar.tabId != 302 && this.dUe != null) {
                this.dUe.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (mD(dVar.tabId)) {
                if (this.dUh != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dEa = dVar.url;
                    this.dUh.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.dUh != null) {
                    this.dUh.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.dUh == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dEa = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.dUh.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dEb) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.dTR.getChildCount(); i++) {
                    View childAt = this.dTR.getChildAt(i);
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
                if (this.dUh != null && z) {
                    this.dUh.a(dVar.tabId, 0, aoVar3);
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
                if (this.dUh != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dEa = tabItemView.getUrl();
                    this.dUh.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.dUh != null) {
                    this.dUh.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.dTU = tabItemView;
                int[] iArr = new int[2];
                this.dTU.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.dTR.getChildCount(); i2++) {
                    View childAt = this.dTR.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.dTU.getTabId() && !mD(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.dUm);
                        }
                    }
                }
                if (this.dTU.getState() == TabItemView.dUm || this.dTU.getState() == TabItemView.STATE_EXPANDED) {
                    this.dTS.dismissMenu();
                    boolean z2 = this.dTU.getState() == TabItemView.dUm;
                    this.dTU.setState(TabItemView.dUn);
                    d mz = mz(this.dTU.getTabId());
                    if (mz != null) {
                        if (!TextUtils.isEmpty(mz.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dEa = mz.url;
                            aoVar3.stType = mz.name;
                            aoVar = aoVar3;
                        }
                        if (mz.dUl != null && mz.dUl.dDE != null && mz.dUl.dDE.size() > 0) {
                            for (at atVar : mz.dUl.dDE) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dDA;
                                }
                            }
                        }
                        if (z2 && this.dUh != null) {
                            this.dUh.a(this.dTU.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (mA(this.dTU.getTabId()) && !z) {
                    if (this.dUi == null || this.dUi.mG(this.dTU.getTabId())) {
                        this.dTU.setState(TabItemView.STATE_EXPANDED);
                        this.dTS.a((Activity) getContext(), this, this.dTU, mz(this.dTU.getTabId()).dUl);
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
        this.dTQ = 0;
        this.dTU = null;
        this.dTV = null;
        this.mPaint = new Paint();
        this.dTW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds6);
        this.dTX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.ds1);
        this.dTY = 0;
        this.dTZ = true;
        this.dUa = e.d.transparent;
        this.dUc = 0;
        this.dUf = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void mE(int i) {
                if (HorizontalTabView.this.dTU != null && HorizontalTabView.this.dUh != null && HorizontalTabView.this.dUh != null) {
                    HorizontalTabView.this.dUh.a(HorizontalTabView.this.dTU.getTabId(), i, null);
                }
                if (HorizontalTabView.this.dTV != null) {
                    HorizontalTabView.this.dTV.mC(i);
                }
            }
        };
        this.dUg = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.dUb) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.dUd != null) {
                                HorizontalTabView.this.dUd.b(HorizontalTabView.this.my(1));
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
                if (HorizontalTabView.this.dTV != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.mD(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.dTU != null) {
                            HorizontalTabView.this.dTV.mB(HorizontalTabView.this.dTU.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.dTV.mB(((TabItemView) view).getTabId());
                }
            }
        };
        this.dTR = new LinearLayout(context);
        this.dTR.setOrientation(0);
        this.dTR.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(e.C0175e.ds88));
        this.dTS = new e(context, this.dUf, this.dUg);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.dTR, layoutParams);
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
        if (mz.dUl == null && dVar.dUl == null) {
            return false;
        }
        if ((mz.dUl != null || dVar.dUl == null) && (dVar.dUl != null || mz.dUl == null)) {
            if (mz.dUl == null || dVar.dUl == null) {
                return false;
            }
            if (mz.dUl.dDE == null && dVar.dUl.dDE == null) {
                return false;
            }
            if ((mz.dUl.dDE != null || dVar.dUl.dDE == null) && (dVar.dUl.dDE != null || mz.dUl.dDE == null)) {
                int size = mz.dUl.dDE.size();
                if (size != dVar.dUl.dDE.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.dUl.dDE.get(i);
                    at atVar2 = mz.dUl.dDE.get(i);
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
        if (this.dUb) {
            this.dTT = new ArrayList();
            this.dTT.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.dUl;
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
                    dVar.dUl = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.dTT = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.dTY > 0 && list.size() == this.dTY) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.dTY, -1);
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
            this.dTR.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.dUb);
            if (this.dUc != 0) {
                tabItemView.setSelectItemColorResId(this.dUc);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0175e.ds32);
            this.dTR.addView(tabItemView, layoutParams);
            this.dTU = tabItemView;
            tabItemView.setState(TabItemView.dUn);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bQ(list)) {
            this.mData = list;
            this.dTR.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.dUb);
                        if (302 == dVar2.tabId) {
                            al.c(tabItemView2, e.d.cp_cont_j, 1);
                        }
                        if (this.dUc != 0) {
                            tabItemView2.setSelectItemColorResId(this.dUc);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (mD(dVar2.tabId)) {
                            al.h(tabItemView2, e.d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0175e.tbds44);
                        }
                        this.dTR.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.dTU = tabItemView2;
                            tabItemView2.setState(TabItemView.dUn);
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
        if (i < 0 || this.dTT == null || this.dTT.size() == 0) {
            return null;
        }
        for (d dVar : this.dTT) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean mA(int i) {
        d mz = mz(i);
        return (mz == null || mz.dUl == null || mz.dUl.dDE == null || mz.dUl.dDE.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.dTV = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dTU != null) {
            this.mPaint.setColor(al.getColor(e.d.cp_bg_line_b));
            if (this.dTZ) {
                canvas.drawRect(this.dTR.getLeft(), getMeasuredHeight() - this.dTX, this.dTR.getRight() > getRight() ? this.dTR.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.dUb) {
                if (this.dUc == 0) {
                    this.mPaint.setColor(al.d((Resources) null, e.d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.dUc));
                }
                canvas.drawRect(this.dTU.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.dTW, (this.dTU.getRight() - getBottomLineMargin()) - this.dTU.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.dUb) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, e.d.cp_cont_b));
            int h = l.h(getContext(), e.C0175e.ds96);
            if (this.dTU != null) {
                h = this.dTU.getRight() - this.dTU.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), e.C0175e.tbds44), l.h(getContext(), e.C0175e.tbds98), h, l.h(getContext(), e.C0175e.tbds104)), l.h(getContext(), e.C0175e.tbds6), l.h(getContext(), e.C0175e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.dTU == null || this.dTQ == 0) {
            return 0;
        }
        return ((this.dTU.getMeasuredWidth() - this.dTQ) - this.dTU.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void mB(int i) {
        a(my(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.dUh = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.dUi = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.dUi;
    }

    public void setTabBackgroudColor(int i) {
        this.dUa = i;
    }

    public void setAutoFillTabCount(int i) {
        this.dTY = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void mC(int i) {
        if (this.dTU != null && this.dUh != null) {
            this.dUh.a(this.dTU.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dUd = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.dUe = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.dUb = z;
    }

    public static boolean mD(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.dTZ = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.dUc = i;
    }
}
