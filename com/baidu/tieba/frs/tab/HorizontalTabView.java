package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.horizonalScrollListView.b implements com.baidu.tieba.frs.tab.b {
    private final e cPA;
    private List<d> cPB;
    private TabItemView cPC;
    private com.baidu.tieba.frs.tab.b cPD;
    private final int cPE;
    private final int cPF;
    private int cPG;
    private boolean cPH;
    private int cPI;
    private boolean cPJ;
    private int cPK;
    private a cPL;
    private b cPM;
    private e.b cPN;
    private e.a cPO;
    private aj cPP;
    private c cPQ;
    public int cPy;
    private final LinearLayout cPz;
    private TbPageContext cpj;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void a(d dVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(d dVar);
    }

    /* loaded from: classes.dex */
    public interface c {
        void jI(int i);

        boolean jJ(int i);
    }

    public void aov() {
        final au auVar;
        if (this.cpj != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).cPT) != null && auVar.cAT != null) {
                for (at atVar : auVar.cAT) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cpj.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.cAT.size() > i && auVar.cAT.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.kn(auVar.cAT.get(i).cAP));
                        }
                    }
                });
                bVar.d(this.cpj);
                bVar.tl();
            }
        }
    }

    public d kn(int i) {
        if (!v.v(this.cPB)) {
            for (d dVar : this.cPB) {
                if (dVar != null && dVar.cKT == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void c(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.cKT != 302 && this.cPM != null) {
                this.cPM.b(dVar);
            }
            if (dVar.cKT == 49) {
                TiebaStatic.log("c11841");
            }
            if (ks(dVar.cKT)) {
                if (this.cPP != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.cBj = dVar.url;
                    this.cPP.a(dVar.cKT, -1, aoVar);
                }
            } else if (dVar.cKT == 301 || dVar.cKT == 302) {
                if (this.cPP != null) {
                    this.cPP.a(dVar.cKT, -1, null);
                }
            } else {
                if (dVar.cKT != 49 || this.cPP == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.cBj = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.cPP.a(dVar.cKT, 0, aoVar2);
                    if (aoVar2.cBk) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cPz.getChildCount(); i++) {
                    View childAt = this.cPz.getChildAt(i);
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
                    aoVar3.cBj = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.cPP != null && z) {
                    this.cPP.a(dVar.cKT, 0, aoVar3);
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
            if (ks(tabItemView.getTabId())) {
                if (this.cPP != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.cBj = tabItemView.getUrl();
                    this.cPP.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cPP != null) {
                    this.cPP.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cPC = tabItemView;
                int[] iArr = new int[2];
                this.cPC.getLocationOnScreen(iArr);
                int ac = l.ac(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (ac < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.cPz.getChildCount(); i2++) {
                    View childAt = this.cPz.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cPC.getTabId() && !ks(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cPU);
                        }
                    }
                }
                if (this.cPC.getState() == TabItemView.cPU || this.cPC.getState() == TabItemView.cPW) {
                    this.cPA.aoy();
                    boolean z2 = this.cPC.getState() == TabItemView.cPU;
                    this.cPC.setState(TabItemView.cPV);
                    d ko = ko(this.cPC.getTabId());
                    if (ko != null) {
                        if (!TextUtils.isEmpty(ko.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.cBj = ko.url;
                            aoVar3.stType = ko.name;
                            aoVar = aoVar3;
                        }
                        if (ko.cPT != null && ko.cPT.cAT != null && ko.cPT.cAT.size() > 0) {
                            for (at atVar : ko.cPT.cAT) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.cAP;
                                }
                            }
                        }
                        if (z2 && this.cPP != null) {
                            this.cPP.a(this.cPC.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (kp(this.cPC.getTabId()) && !z) {
                    if (this.cPQ == null || this.cPQ.jJ(this.cPC.getTabId())) {
                        this.cPC.setState(TabItemView.cPW);
                        this.cPA.a((Activity) getContext(), this, this.cPC, ko(this.cPC.getTabId()).cPT);
                    } else {
                        return;
                    }
                }
                invalidate();
            }
        }
    }

    public HorizontalTabView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.cPy = 0;
        this.cPC = null;
        this.cPD = null;
        this.mPaint = new Paint();
        this.cPE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cPF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cPG = 0;
        this.cPH = true;
        this.cPI = d.C0080d.transparent;
        this.cPK = 0;
        this.cPN = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kt(int i) {
                if (HorizontalTabView.this.cPC != null && HorizontalTabView.this.cPP != null && HorizontalTabView.this.cPP != null) {
                    HorizontalTabView.this.cPP.a(HorizontalTabView.this.cPC.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cPD != null) {
                    HorizontalTabView.this.cPD.kr(i);
                }
            }
        };
        this.cPO = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cPJ) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cPL != null) {
                                HorizontalTabView.this.cPL.a(HorizontalTabView.this.kn(1));
                            }
                            HorizontalTabView.this.aov();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cKT == 302) {
                                    break;
                                }
                            }
                            HorizontalTabView.this.c(dVar);
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
                if (HorizontalTabView.this.cPD != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.ks(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cPC != null) {
                            HorizontalTabView.this.cPD.kq(HorizontalTabView.this.cPC.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cPD.kq(((TabItemView) view).getTabId());
                }
            }
        };
        this.cpj = tbPageContext;
        this.cPz = new LinearLayout(tbPageContext.getPageActivity());
        this.cPz.setOrientation(0);
        this.cPz.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.e.ds88));
        this.cPA = new e(tbPageContext.getPageActivity(), this.cPN, this.cPO);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cPy = 0;
        this.cPC = null;
        this.cPD = null;
        this.mPaint = new Paint();
        this.cPE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cPF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cPG = 0;
        this.cPH = true;
        this.cPI = d.C0080d.transparent;
        this.cPK = 0;
        this.cPN = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kt(int i) {
                if (HorizontalTabView.this.cPC != null && HorizontalTabView.this.cPP != null && HorizontalTabView.this.cPP != null) {
                    HorizontalTabView.this.cPP.a(HorizontalTabView.this.cPC.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cPD != null) {
                    HorizontalTabView.this.cPD.kr(i);
                }
            }
        };
        this.cPO = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cPJ) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cPL != null) {
                                HorizontalTabView.this.cPL.a(HorizontalTabView.this.kn(1));
                            }
                            HorizontalTabView.this.aov();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cKT == 302) {
                                    break;
                                }
                            }
                            HorizontalTabView.this.c(dVar);
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
                if (HorizontalTabView.this.cPD != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.ks(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cPC != null) {
                            HorizontalTabView.this.cPD.kq(HorizontalTabView.this.cPC.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cPD.kq(((TabItemView) view).getTabId());
                }
            }
        };
        this.cPz = new LinearLayout(context);
        this.cPz.setOrientation(0);
        this.cPz.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.cPA = new e(context, this.cPN, this.cPO);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cPy = 0;
        this.cPC = null;
        this.cPD = null;
        this.mPaint = new Paint();
        this.cPE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cPF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cPG = 0;
        this.cPH = true;
        this.cPI = d.C0080d.transparent;
        this.cPK = 0;
        this.cPN = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kt(int i2) {
                if (HorizontalTabView.this.cPC != null && HorizontalTabView.this.cPP != null && HorizontalTabView.this.cPP != null) {
                    HorizontalTabView.this.cPP.a(HorizontalTabView.this.cPC.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cPD != null) {
                    HorizontalTabView.this.cPD.kr(i2);
                }
            }
        };
        this.cPO = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cPJ) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cPL != null) {
                                HorizontalTabView.this.cPL.a(HorizontalTabView.this.kn(1));
                            }
                            HorizontalTabView.this.aov();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cKT == 302) {
                                    break;
                                }
                            }
                            HorizontalTabView.this.c(dVar);
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
                if (HorizontalTabView.this.cPD != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.ks(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cPC != null) {
                            HorizontalTabView.this.cPD.kq(HorizontalTabView.this.cPC.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cPD.kq(((TabItemView) view).getTabId());
                }
            }
        };
        this.cPz = new LinearLayout(activity);
        this.cPz.setOrientation(0);
        this.cPz.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cPA = new e(activity, this.cPN, this.cPO);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cPz, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        com.baidu.tbadk.core.util.aj.k(this, d.C0080d.transparent);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aY(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d ko = ko(1);
        Iterator<d> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            d next = it.next();
            if (next != null && next.cKT == 1) {
                dVar = next;
                break;
            }
        }
        if (ko == null || dVar == null) {
            return false;
        }
        if (ko.cPT == null && dVar.cPT == null) {
            return false;
        }
        if ((ko.cPT != null || dVar.cPT == null) && (dVar.cPT != null || ko.cPT == null)) {
            if (ko.cPT == null || dVar.cPT == null) {
                return false;
            }
            if (ko.cPT.cAT == null && dVar.cPT.cAT == null) {
                return false;
            }
            if ((ko.cPT.cAT != null || dVar.cPT.cAT == null) && (dVar.cPT.cAT != null || ko.cPT.cAT == null)) {
                int size = ko.cPT.cAT.size();
                if (size != dVar.cPT.cAT.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.cPT.cAT.get(i);
                    at atVar2 = ko.cPT.cAT.get(i);
                    if (atVar.cAP != atVar2.cAP || !atVar.name.equals(atVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void d(List<d> list, int i, int i2) {
        d dVar;
        au auVar;
        if (this.cPJ) {
            this.cPB = new ArrayList();
            this.cPB.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.cKT == 1) {
                au auVar2 = dVar.cPT;
                if (auVar2 != null && auVar2.cAT != null) {
                    auVar2.cAT.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.cAT = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.u(list) > 1) {
                    at atVar = new at();
                    atVar.cAP = 1;
                    atVar.name = getContext().getString(d.j.chosen_pb_title);
                    auVar.cAT.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.cKT != 1 && dVar3.cKT != 302) {
                            at atVar2 = new at();
                            atVar2.cAP = dVar3.cKT;
                            atVar2.name = dVar3.name;
                            auVar.cAT.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.cKT != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.cPT = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.cPB = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cPG > 0 && list.size() == this.cPG) {
            layoutParams = new LinearLayout.LayoutParams(l.ac(getContext()) / this.cPG, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.cKT = 1;
            dVar.name = getContext().getResources().getString(d.j.chosen_pb_title);
            this.cPz.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cPJ);
            if (this.cPK != 0) {
                tabItemView.setSelectItemColorResId(this.cPK);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.cPz.addView(tabItemView, layoutParams);
            this.cPC = tabItemView;
            tabItemView.setState(TabItemView.cPV);
            return;
        }
        setVisibility(0);
        if (this.mData == null || aY(list)) {
            this.mData = list;
            this.cPz.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cPJ);
                        if (302 == dVar2.cKT) {
                            com.baidu.tbadk.core.util.aj.c(tabItemView2, d.C0080d.cp_cont_j, 1);
                        }
                        if (this.cPK != 0) {
                            tabItemView2.setSelectItemColorResId(this.cPK);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (ks(dVar2.cKT)) {
                            com.baidu.tbadk.core.util.aj.i(tabItemView2, d.C0080d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
                        }
                        this.cPz.addView(tabItemView2, layoutParams);
                        if (dVar2.cKT == i) {
                            this.cPC = tabItemView2;
                            tabItemView2.setState(TabItemView.cPV);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d ko(int i) {
        if (i < 0 || this.cPB == null || this.cPB.size() == 0) {
            return null;
        }
        for (d dVar : this.cPB) {
            if (dVar != null && dVar.cKT == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean kp(int i) {
        d ko = ko(i);
        return (ko == null || ko.cPT == null || ko.cPT.cAT == null || ko.cPT.cAT.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cPD = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cPC != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_bg_line_b));
            if (this.cPH) {
                canvas.drawRect(this.cPz.getLeft(), getMeasuredHeight() - this.cPF, this.cPz.getRight() > getRight() ? this.cPz.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cPJ) {
                if (this.cPK == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, d.C0080d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, this.cPK));
                }
                canvas.drawRect(this.cPC.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cPE, (this.cPC.getRight() - getBottomLineMargin()) - this.cPC.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cPJ) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, d.C0080d.cp_cont_b));
            int f = l.f(getContext(), d.e.ds96);
            if (this.cPC != null) {
                f = this.cPC.getRight() - this.cPC.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.f(getContext(), d.e.ds32), l.f(getContext(), d.e.ds72), f, l.f(getContext(), d.e.ds76)), l.f(getContext(), d.e.ds4), l.f(getContext(), d.e.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cPC == null || this.cPy == 0) {
            return 0;
        }
        return ((this.cPC.getMeasuredWidth() - this.cPy) - this.cPC.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void kq(int i) {
        c(kn(i));
    }

    public void setDataLoadInterface(aj ajVar) {
        this.cPP = ajVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cPQ = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cPQ;
    }

    public void setTabBackgroudColor(int i) {
        this.cPI = i;
    }

    public void wB() {
        com.baidu.tbadk.core.util.aj.k(this, this.cPI);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cPz.getChildCount()) {
                View childAt = this.cPz.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (ks(((TabItemView) childAt).getTabId())) {
                        com.baidu.tbadk.core.util.aj.i(childAt, d.C0080d.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).wB();
                    }
                }
                i = i2 + 1;
            } else {
                this.cPA.wB();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cPG = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void kr(int i) {
        if (this.cPC != null && this.cPP != null) {
            this.cPP.a(this.cPC.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cPL = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cPM = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cPJ = z;
    }

    public static boolean ks(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cPH = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cPK = i;
    }
}
