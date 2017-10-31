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
    public int cPe;
    private final LinearLayout cPf;
    private final e cPg;
    private List<d> cPh;
    private TabItemView cPi;
    private com.baidu.tieba.frs.tab.b cPj;
    private final int cPk;
    private final int cPl;
    private int cPm;
    private boolean cPn;
    private int cPo;
    private boolean cPp;
    private int cPq;
    private a cPr;
    private b cPs;
    private e.b cPt;
    private e.a cPu;
    private aj cPv;
    private c cPw;
    private TbPageContext coQ;
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
        void jJ(int i);

        boolean jK(int i);
    }

    public void aog() {
        final au auVar;
        if (this.coQ != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).cPz) != null && auVar.cAA != null) {
                for (at atVar : auVar.cAA) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.coQ.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.cAA.size() > i && auVar.cAA.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.kn(auVar.cAA.get(i).cAw));
                        }
                    }
                });
                bVar.d(this.coQ);
                bVar.tl();
            }
        }
    }

    public d kn(int i) {
        if (!v.v(this.cPh)) {
            for (d dVar : this.cPh) {
                if (dVar != null && dVar.cKA == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void c(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.cKA != 302 && this.cPs != null) {
                this.cPs.b(dVar);
            }
            if (dVar.cKA == 49) {
                TiebaStatic.log("c11841");
            }
            if (ks(dVar.cKA)) {
                if (this.cPv != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.cAQ = dVar.url;
                    this.cPv.a(dVar.cKA, -1, aoVar);
                }
            } else if (dVar.cKA == 301 || dVar.cKA == 302) {
                if (this.cPv != null) {
                    this.cPv.a(dVar.cKA, -1, null);
                }
            } else {
                if (dVar.cKA != 49 || this.cPv == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.cAQ = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.cPv.a(dVar.cKA, 0, aoVar2);
                    if (aoVar2.cAR) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cPf.getChildCount(); i++) {
                    View childAt = this.cPf.getChildAt(i);
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
                    aoVar3.cAQ = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.cPv != null && z) {
                    this.cPv.a(dVar.cKA, 0, aoVar3);
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
                if (this.cPv != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.cAQ = tabItemView.getUrl();
                    this.cPv.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cPv != null) {
                    this.cPv.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cPi = tabItemView;
                int[] iArr = new int[2];
                this.cPi.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.cPf.getChildCount(); i2++) {
                    View childAt = this.cPf.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cPi.getTabId() && !ks(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cPA);
                        }
                    }
                }
                if (this.cPi.getState() == TabItemView.cPA || this.cPi.getState() == TabItemView.cPC) {
                    this.cPg.aoj();
                    boolean z2 = this.cPi.getState() == TabItemView.cPA;
                    this.cPi.setState(TabItemView.cPB);
                    d ko = ko(this.cPi.getTabId());
                    if (ko != null) {
                        if (!TextUtils.isEmpty(ko.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.cAQ = ko.url;
                            aoVar3.stType = ko.name;
                            aoVar = aoVar3;
                        }
                        if (ko.cPz != null && ko.cPz.cAA != null && ko.cPz.cAA.size() > 0) {
                            for (at atVar : ko.cPz.cAA) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.cAw;
                                }
                            }
                        }
                        if (z2 && this.cPv != null) {
                            this.cPv.a(this.cPi.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (kp(this.cPi.getTabId()) && !z) {
                    if (this.cPw == null || this.cPw.jK(this.cPi.getTabId())) {
                        this.cPi.setState(TabItemView.cPC);
                        this.cPg.a((Activity) getContext(), this, this.cPi, ko(this.cPi.getTabId()).cPz);
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
        this.cPe = 0;
        this.cPi = null;
        this.cPj = null;
        this.mPaint = new Paint();
        this.cPk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cPl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cPm = 0;
        this.cPn = true;
        this.cPo = d.C0080d.transparent;
        this.cPq = 0;
        this.cPt = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kt(int i) {
                if (HorizontalTabView.this.cPi != null && HorizontalTabView.this.cPv != null && HorizontalTabView.this.cPv != null) {
                    HorizontalTabView.this.cPv.a(HorizontalTabView.this.cPi.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cPj != null) {
                    HorizontalTabView.this.cPj.kr(i);
                }
            }
        };
        this.cPu = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cPp) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cPr != null) {
                                HorizontalTabView.this.cPr.a(HorizontalTabView.this.kn(1));
                            }
                            HorizontalTabView.this.aog();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cKA == 302) {
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
                if (HorizontalTabView.this.cPj != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.ks(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cPi != null) {
                            HorizontalTabView.this.cPj.kq(HorizontalTabView.this.cPi.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cPj.kq(((TabItemView) view).getTabId());
                }
            }
        };
        this.coQ = tbPageContext;
        this.cPf = new LinearLayout(tbPageContext.getPageActivity());
        this.cPf.setOrientation(0);
        this.cPf.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.e.ds88));
        this.cPg = new e(tbPageContext.getPageActivity(), this.cPt, this.cPu);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cPe = 0;
        this.cPi = null;
        this.cPj = null;
        this.mPaint = new Paint();
        this.cPk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cPl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cPm = 0;
        this.cPn = true;
        this.cPo = d.C0080d.transparent;
        this.cPq = 0;
        this.cPt = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kt(int i) {
                if (HorizontalTabView.this.cPi != null && HorizontalTabView.this.cPv != null && HorizontalTabView.this.cPv != null) {
                    HorizontalTabView.this.cPv.a(HorizontalTabView.this.cPi.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cPj != null) {
                    HorizontalTabView.this.cPj.kr(i);
                }
            }
        };
        this.cPu = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cPp) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cPr != null) {
                                HorizontalTabView.this.cPr.a(HorizontalTabView.this.kn(1));
                            }
                            HorizontalTabView.this.aog();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cKA == 302) {
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
                if (HorizontalTabView.this.cPj != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.ks(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cPi != null) {
                            HorizontalTabView.this.cPj.kq(HorizontalTabView.this.cPi.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cPj.kq(((TabItemView) view).getTabId());
                }
            }
        };
        this.cPf = new LinearLayout(context);
        this.cPf.setOrientation(0);
        this.cPf.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.cPg = new e(context, this.cPt, this.cPu);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cPe = 0;
        this.cPi = null;
        this.cPj = null;
        this.mPaint = new Paint();
        this.cPk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cPl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cPm = 0;
        this.cPn = true;
        this.cPo = d.C0080d.transparent;
        this.cPq = 0;
        this.cPt = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kt(int i2) {
                if (HorizontalTabView.this.cPi != null && HorizontalTabView.this.cPv != null && HorizontalTabView.this.cPv != null) {
                    HorizontalTabView.this.cPv.a(HorizontalTabView.this.cPi.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cPj != null) {
                    HorizontalTabView.this.cPj.kr(i2);
                }
            }
        };
        this.cPu = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cPp) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cPr != null) {
                                HorizontalTabView.this.cPr.a(HorizontalTabView.this.kn(1));
                            }
                            HorizontalTabView.this.aog();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cKA == 302) {
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
                if (HorizontalTabView.this.cPj != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.ks(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cPi != null) {
                            HorizontalTabView.this.cPj.kq(HorizontalTabView.this.cPi.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cPj.kq(((TabItemView) view).getTabId());
                }
            }
        };
        this.cPf = new LinearLayout(activity);
        this.cPf.setOrientation(0);
        this.cPf.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cPg = new e(activity, this.cPt, this.cPu);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cPf, layoutParams);
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
            if (next != null && next.cKA == 1) {
                dVar = next;
                break;
            }
        }
        if (ko == null || dVar == null) {
            return false;
        }
        if (ko.cPz == null && dVar.cPz == null) {
            return false;
        }
        if ((ko.cPz != null || dVar.cPz == null) && (dVar.cPz != null || ko.cPz == null)) {
            if (ko.cPz == null || dVar.cPz == null) {
                return false;
            }
            if (ko.cPz.cAA == null && dVar.cPz.cAA == null) {
                return false;
            }
            if ((ko.cPz.cAA != null || dVar.cPz.cAA == null) && (dVar.cPz.cAA != null || ko.cPz.cAA == null)) {
                int size = ko.cPz.cAA.size();
                if (size != dVar.cPz.cAA.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.cPz.cAA.get(i);
                    at atVar2 = ko.cPz.cAA.get(i);
                    if (atVar.cAw != atVar2.cAw || !atVar.name.equals(atVar2.name)) {
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
        if (this.cPp) {
            this.cPh = new ArrayList();
            this.cPh.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.cKA == 1) {
                au auVar2 = dVar.cPz;
                if (auVar2 != null && auVar2.cAA != null) {
                    auVar2.cAA.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.cAA = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.u(list) > 1) {
                    at atVar = new at();
                    atVar.cAw = 1;
                    atVar.name = getContext().getString(d.j.chosen_pb_title);
                    auVar.cAA.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.cKA != 1 && dVar3.cKA != 302) {
                            at atVar2 = new at();
                            atVar2.cAw = dVar3.cKA;
                            atVar2.name = dVar3.name;
                            auVar.cAA.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.cKA != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.cPz = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.cPh = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cPm > 0 && list.size() == this.cPm) {
            layoutParams = new LinearLayout.LayoutParams(l.ac(getContext()) / this.cPm, -1);
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
            dVar.cKA = 1;
            dVar.name = getContext().getResources().getString(d.j.chosen_pb_title);
            this.cPf.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cPp);
            if (this.cPq != 0) {
                tabItemView.setSelectItemColorResId(this.cPq);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.cPf.addView(tabItemView, layoutParams);
            this.cPi = tabItemView;
            tabItemView.setState(TabItemView.cPB);
            return;
        }
        setVisibility(0);
        if (this.mData == null || aY(list)) {
            this.mData = list;
            this.cPf.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cPp);
                        if (302 == dVar2.cKA) {
                            com.baidu.tbadk.core.util.aj.c(tabItemView2, d.C0080d.cp_cont_j, 1);
                        }
                        if (this.cPq != 0) {
                            tabItemView2.setSelectItemColorResId(this.cPq);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (ks(dVar2.cKA)) {
                            com.baidu.tbadk.core.util.aj.i(tabItemView2, d.C0080d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
                        }
                        this.cPf.addView(tabItemView2, layoutParams);
                        if (dVar2.cKA == i) {
                            this.cPi = tabItemView2;
                            tabItemView2.setState(TabItemView.cPB);
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
        if (i < 0 || this.cPh == null || this.cPh.size() == 0) {
            return null;
        }
        for (d dVar : this.cPh) {
            if (dVar != null && dVar.cKA == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean kp(int i) {
        d ko = ko(i);
        return (ko == null || ko.cPz == null || ko.cPz.cAA == null || ko.cPz.cAA.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cPj = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cPi != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.aj.getColor(d.C0080d.cp_bg_line_b));
            if (this.cPn) {
                canvas.drawRect(this.cPf.getLeft(), getMeasuredHeight() - this.cPl, this.cPf.getRight() > getRight() ? this.cPf.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cPp) {
                if (this.cPq == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, d.C0080d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, this.cPq));
                }
                canvas.drawRect(this.cPi.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cPk, (this.cPi.getRight() - getBottomLineMargin()) - this.cPi.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cPp) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, d.C0080d.cp_cont_b));
            int f = l.f(getContext(), d.e.ds96);
            if (this.cPi != null) {
                f = this.cPi.getRight() - this.cPi.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.f(getContext(), d.e.ds32), l.f(getContext(), d.e.ds72), f, l.f(getContext(), d.e.ds76)), l.f(getContext(), d.e.ds4), l.f(getContext(), d.e.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cPi == null || this.cPe == 0) {
            return 0;
        }
        return ((this.cPi.getMeasuredWidth() - this.cPe) - this.cPi.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void kq(int i) {
        c(kn(i));
    }

    public void setDataLoadInterface(aj ajVar) {
        this.cPv = ajVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cPw = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cPw;
    }

    public void setTabBackgroudColor(int i) {
        this.cPo = i;
    }

    public void wB() {
        com.baidu.tbadk.core.util.aj.k(this, this.cPo);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cPf.getChildCount()) {
                View childAt = this.cPf.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (ks(((TabItemView) childAt).getTabId())) {
                        com.baidu.tbadk.core.util.aj.i(childAt, d.C0080d.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).wB();
                    }
                }
                i = i2 + 1;
            } else {
                this.cPg.wB();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cPm = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void kr(int i) {
        if (this.cPi != null && this.cPv != null) {
            this.cPv.a(this.cPi.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cPr = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cPs = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cPp = z;
    }

    public static boolean ks(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cPn = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cPq = i;
    }
}
