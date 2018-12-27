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
    private TbPageContext dws;
    private int eeA;
    private boolean eeB;
    private int eeC;
    private a eeD;
    private b eeE;
    private e.b eeF;
    private e.a eeG;
    private ai eeH;
    private c eeI;
    public int eeq;
    private final LinearLayout eer;
    private final e ees;
    private List<d> eet;
    private TabItemView eeu;
    private com.baidu.tieba.frs.tab.b eev;
    private final int eew;
    private final int eex;
    private int eey;
    private boolean eez;
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
        void nA(int i);

        boolean nB(int i);
    }

    public void aHB() {
        final au auVar;
        if (this.dws != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).eeL) != null && auVar.dOh != null) {
                for (at atVar : auVar.dOh) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.dws.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.dOh.size() > i && auVar.dOh.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.nt(auVar.dOh.get(i).dOd));
                        }
                    }
                });
                bVar.d(this.dws);
                bVar.BI();
            }
        }
    }

    public d nt(int i) {
        if (!v.I(this.eet)) {
            for (d dVar : this.eet) {
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
            if (dVar.tabId != 302 && this.eeE != null) {
                this.eeE.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (ny(dVar.tabId)) {
                if (this.eeH != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dOD = dVar.url;
                    this.eeH.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.eeH != null) {
                    this.eeH.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.eeH == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dOD = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.eeH.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dOE) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.eer.getChildCount(); i++) {
                    View childAt = this.eer.getChildAt(i);
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
                    aoVar3.dOD = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.eeH != null && z) {
                    this.eeH.a(dVar.tabId, 0, aoVar3);
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
            if (ny(tabItemView.getTabId())) {
                if (this.eeH != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dOD = tabItemView.getUrl();
                    this.eeH.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.eeH != null) {
                    this.eeH.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.eeu = tabItemView;
                int[] iArr = new int[2];
                this.eeu.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.eer.getChildCount(); i2++) {
                    View childAt = this.eer.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.eeu.getTabId() && !ny(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.eeM);
                        }
                    }
                }
                if (this.eeu.getState() == TabItemView.eeM || this.eeu.getState() == TabItemView.STATE_EXPANDED) {
                    this.ees.dismissMenu();
                    boolean z2 = this.eeu.getState() == TabItemView.eeM;
                    this.eeu.setState(TabItemView.eeN);
                    d nu = nu(this.eeu.getTabId());
                    if (nu != null) {
                        if (!TextUtils.isEmpty(nu.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dOD = nu.url;
                            aoVar3.stType = nu.name;
                            aoVar = aoVar3;
                        }
                        if (nu.eeL != null && nu.eeL.dOh != null && nu.eeL.dOh.size() > 0) {
                            for (at atVar : nu.eeL.dOh) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dOd;
                                }
                            }
                        }
                        if (z2 && this.eeH != null) {
                            this.eeH.a(this.eeu.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (nv(this.eeu.getTabId()) && !z) {
                    if (this.eeI == null || this.eeI.nB(this.eeu.getTabId())) {
                        this.eeu.setState(TabItemView.STATE_EXPANDED);
                        this.ees.a((Activity) getContext(), this, this.eeu, nu(this.eeu.getTabId()).eeL);
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
        this.eeq = 0;
        this.eeu = null;
        this.eev = null;
        this.mPaint = new Paint();
        this.eew = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds6);
        this.eex = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.eey = 0;
        this.eez = true;
        this.eeA = e.d.transparent;
        this.eeC = 0;
        this.eeF = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void nz(int i) {
                if (HorizontalTabView.this.eeu != null && HorizontalTabView.this.eeH != null && HorizontalTabView.this.eeH != null) {
                    HorizontalTabView.this.eeH.a(HorizontalTabView.this.eeu.getTabId(), i, null);
                }
                if (HorizontalTabView.this.eev != null) {
                    HorizontalTabView.this.eev.nx(i);
                }
            }
        };
        this.eeG = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.eeB) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.eeD != null) {
                                HorizontalTabView.this.eeD.b(HorizontalTabView.this.nt(1));
                            }
                            HorizontalTabView.this.aHB();
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
                if (HorizontalTabView.this.eev != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.ny(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.eeu != null) {
                            HorizontalTabView.this.eev.nw(HorizontalTabView.this.eeu.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.eev.nw(((TabItemView) view).getTabId());
                }
            }
        };
        this.eer = new LinearLayout(context);
        this.eer.setOrientation(0);
        this.eer.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(e.C0210e.ds88));
        this.ees = new e(context, this.eeF, this.eeG);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.eer, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.j(this, e.d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bR(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d nu = nu(1);
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
        if (nu == null || dVar == null) {
            return false;
        }
        if (nu.eeL == null && dVar.eeL == null) {
            return false;
        }
        if ((nu.eeL != null || dVar.eeL == null) && (dVar.eeL != null || nu.eeL == null)) {
            if (nu.eeL == null || dVar.eeL == null) {
                return false;
            }
            if (nu.eeL.dOh == null && dVar.eeL.dOh == null) {
                return false;
            }
            if ((nu.eeL.dOh != null || dVar.eeL.dOh == null) && (dVar.eeL.dOh != null || nu.eeL.dOh == null)) {
                int size = nu.eeL.dOh.size();
                if (size != dVar.eeL.dOh.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.eeL.dOh.get(i);
                    at atVar2 = nu.eeL.dOh.get(i);
                    if (atVar.dOd != atVar2.dOd || !atVar.name.equals(atVar2.name)) {
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
        if (this.eeB) {
            this.eet = new ArrayList();
            this.eet.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.eeL;
                if (auVar2 != null && auVar2.dOh != null) {
                    auVar2.dOh.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.dOh = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.H(list) > 1) {
                    at atVar = new at();
                    atVar.dOd = 1;
                    atVar.name = getContext().getString(e.j.chosen_pb_title);
                    auVar.dOh.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.dOd = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.dOh.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.eeL = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.eet = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.eey > 0 && list.size() == this.eey) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.eey, -1);
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
            this.eer.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.eeB);
            if (this.eeC != 0) {
                tabItemView.setSelectItemColorResId(this.eeC);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0210e.ds32);
            this.eer.addView(tabItemView, layoutParams);
            this.eeu = tabItemView;
            tabItemView.setState(TabItemView.eeN);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bR(list)) {
            this.mData = list;
            this.eer.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.eeB);
                        if (302 == dVar2.tabId) {
                            al.c(tabItemView2, e.d.cp_cont_j, 1);
                        }
                        if (this.eeC != 0) {
                            tabItemView2.setSelectItemColorResId(this.eeC);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (ny(dVar2.tabId)) {
                            al.h(tabItemView2, e.d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0210e.tbds44);
                        }
                        this.eer.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.eeu = tabItemView2;
                            tabItemView2.setState(TabItemView.eeN);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d nu(int i) {
        if (i < 0 || this.eet == null || this.eet.size() == 0) {
            return null;
        }
        for (d dVar : this.eet) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean nv(int i) {
        d nu = nu(i);
        return (nu == null || nu.eeL == null || nu.eeL.dOh == null || nu.eeL.dOh.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.eev = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.eeu != null) {
            this.mPaint.setColor(al.getColor(e.d.cp_bg_line_b));
            if (this.eez) {
                canvas.drawRect(this.eer.getLeft(), getMeasuredHeight() - this.eex, this.eer.getRight() > getRight() ? this.eer.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.eeB) {
                if (this.eeC == 0) {
                    this.mPaint.setColor(al.d((Resources) null, e.d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.eeC));
                }
                canvas.drawRect(this.eeu.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.eew, (this.eeu.getRight() - getBottomLineMargin()) - this.eeu.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.eeB) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, e.d.cp_cont_b));
            int h = l.h(getContext(), e.C0210e.ds96);
            if (this.eeu != null) {
                h = this.eeu.getRight() - this.eeu.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), e.C0210e.tbds44), l.h(getContext(), e.C0210e.tbds98), h, l.h(getContext(), e.C0210e.tbds104)), l.h(getContext(), e.C0210e.tbds6), l.h(getContext(), e.C0210e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.eeu == null || this.eeq == 0) {
            return 0;
        }
        return ((this.eeu.getMeasuredWidth() - this.eeq) - this.eeu.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void nw(int i) {
        a(nt(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.eeH = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.eeI = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.eeI;
    }

    public void setTabBackgroudColor(int i) {
        this.eeA = i;
    }

    public void setAutoFillTabCount(int i) {
        this.eey = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void nx(int i) {
        if (this.eeu != null && this.eeH != null) {
            this.eeH.a(this.eeu.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.eeD = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.eeE = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.eeB = z;
    }

    public static boolean ny(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.eez = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.eeC = i;
    }
}
