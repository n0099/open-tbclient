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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements com.baidu.tieba.frs.tab.b {
    private TbPageContext bFO;
    public int cxP;
    private final LinearLayout cxQ;
    private final e cxR;
    private List<d> cxS;
    private TabItemView cxT;
    private com.baidu.tieba.frs.tab.b cxU;
    private final int cxV;
    private final int cxW;
    private int cxX;
    private boolean cxY;
    private int cxZ;
    private boolean cya;
    private int cyb;
    private a cyc;
    private b cyd;
    private e.b cye;
    private e.a cyf;
    private ai cyg;
    private c cyh;
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
        void iU(int i);

        boolean iV(int i);
    }

    public void ajB() {
        final at atVar;
        if (this.bFO != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (atVar = this.mData.get(0).cyk) != null && atVar.cmB != null) {
                for (as asVar : atVar.cmB) {
                    if (asVar != null) {
                        arrayList.add(asVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.bFO.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (atVar.cmB.size() > i && atVar.cmB.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.ju(atVar.cmB.get(i).cmx));
                        }
                    }
                });
                bVar.d(this.bFO);
                bVar.tv();
            }
        }
    }

    public d ju(int i) {
        if (!u.v(this.cxS)) {
            for (d dVar : this.cxS) {
                if (dVar != null && dVar.cuL == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void c(d dVar) {
        boolean z;
        an anVar;
        if (dVar != null) {
            if (this.cyd != null) {
                this.cyd.b(dVar);
            }
            if (dVar.cuL == 49) {
                TiebaStatic.log("c11841");
            }
            if (jz(dVar.cuL)) {
                if (this.cyg != null && !TextUtils.isEmpty(dVar.url)) {
                    an anVar2 = new an();
                    anVar2.cmP = dVar.url;
                    this.cyg.a(dVar.cuL, -1, anVar2);
                }
            } else if (dVar.cuL == 301) {
                if (this.cyg != null) {
                    this.cyg.a(dVar.cuL, -1, null);
                }
            } else {
                if (dVar.cuL != 49 || this.cyg == null) {
                    z = true;
                } else {
                    an anVar3 = new an();
                    anVar3.cmP = dVar.url;
                    anVar3.stType = dVar.name;
                    this.cyg.a(dVar.cuL, 0, anVar3);
                    if (anVar3.cmQ) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cxQ.getChildCount(); i++) {
                    View childAt = this.cxQ.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(dVar.url)) {
                    anVar = null;
                } else {
                    anVar = new an();
                    anVar.cmP = dVar.url;
                    anVar.stType = dVar.name;
                }
                if (this.cyg != null && z) {
                    this.cyg.a(dVar.cuL, 0, anVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        an anVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (jz(tabItemView.getTabId())) {
                if (this.cyg != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    an anVar2 = new an();
                    anVar2.cmP = tabItemView.getUrl();
                    this.cyg.a(tabItemView.getTabId(), -1, anVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cyg != null) {
                    this.cyg.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cxT = tabItemView;
                int[] iArr = new int[2];
                this.cxT.getLocationOnScreen(iArr);
                int ag = k.ag(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.f.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (ag < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.f.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.cxQ.getChildCount(); i2++) {
                    View childAt = this.cxQ.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cxT.getTabId() && !jz(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cyl);
                        }
                    }
                }
                if (this.cxT.getState() == TabItemView.cyl || this.cxT.getState() == TabItemView.cyn) {
                    this.cxR.ajE();
                    boolean z2 = this.cxT.getState() == TabItemView.cyl;
                    this.cxT.setState(TabItemView.cym);
                    d jv = jv(this.cxT.getTabId());
                    if (jv != null) {
                        if (!TextUtils.isEmpty(jv.url)) {
                            an anVar3 = new an();
                            anVar3.cmP = jv.url;
                            anVar3.stType = jv.name;
                            anVar = anVar3;
                        }
                        if (jv.cyk != null && jv.cyk.cmB != null && jv.cyk.cmB.size() > 0) {
                            for (as asVar : jv.cyk.cmB) {
                                if (asVar != null && asVar.isSelected) {
                                    i = asVar.cmx;
                                }
                            }
                        }
                        if (z2 && this.cyg != null) {
                            this.cyg.a(this.cxT.getTabId(), i, anVar);
                        }
                    } else {
                        return;
                    }
                } else if (jw(this.cxT.getTabId()) && !z) {
                    if (this.cyh == null || this.cyh.iV(this.cxT.getTabId())) {
                        this.cxT.setState(TabItemView.cyn);
                        this.cxR.a((Activity) getContext(), this, this.cxT, jv(this.cxT.getTabId()).cyk);
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
        this.cxP = 0;
        this.cxT = null;
        this.cxU = null;
        this.mPaint = new Paint();
        this.cxV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cxW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cxX = 0;
        this.cxY = true;
        this.cxZ = d.e.transparent;
        this.cyb = 0;
        this.cye = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jA(int i) {
                if (HorizontalTabView.this.cxT != null && HorizontalTabView.this.cyg != null && HorizontalTabView.this.cyg != null) {
                    HorizontalTabView.this.cyg.a(HorizontalTabView.this.cxT.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cxU != null) {
                    HorizontalTabView.this.cxU.jy(i);
                }
            }
        };
        this.cyf = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.cya) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.cyc != null) {
                            HorizontalTabView.this.cyc.a(HorizontalTabView.this.ju(1));
                        }
                        HorizontalTabView.this.ajB();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.cxU != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jz(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cxT != null) {
                            HorizontalTabView.this.cxU.jx(HorizontalTabView.this.cxT.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cxU.jx(((TabItemView) view).getTabId());
                }
            }
        };
        this.bFO = tbPageContext;
        this.cxQ = new LinearLayout(tbPageContext.getPageActivity());
        this.cxQ.setOrientation(0);
        this.cxQ.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.f.ds88));
        this.cxR = new e(tbPageContext.getPageActivity(), this.cye, this.cyf);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cxP = 0;
        this.cxT = null;
        this.cxU = null;
        this.mPaint = new Paint();
        this.cxV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cxW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cxX = 0;
        this.cxY = true;
        this.cxZ = d.e.transparent;
        this.cyb = 0;
        this.cye = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jA(int i) {
                if (HorizontalTabView.this.cxT != null && HorizontalTabView.this.cyg != null && HorizontalTabView.this.cyg != null) {
                    HorizontalTabView.this.cyg.a(HorizontalTabView.this.cxT.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cxU != null) {
                    HorizontalTabView.this.cxU.jy(i);
                }
            }
        };
        this.cyf = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.cya) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.cyc != null) {
                            HorizontalTabView.this.cyc.a(HorizontalTabView.this.ju(1));
                        }
                        HorizontalTabView.this.ajB();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.cxU != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jz(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cxT != null) {
                            HorizontalTabView.this.cxU.jx(HorizontalTabView.this.cxT.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cxU.jx(((TabItemView) view).getTabId());
                }
            }
        };
        this.cxQ = new LinearLayout(context);
        this.cxQ.setOrientation(0);
        this.cxQ.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.f.ds88));
        this.cxR = new e(context, this.cye, this.cyf);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cxP = 0;
        this.cxT = null;
        this.cxU = null;
        this.mPaint = new Paint();
        this.cxV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cxW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cxX = 0;
        this.cxY = true;
        this.cxZ = d.e.transparent;
        this.cyb = 0;
        this.cye = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jA(int i2) {
                if (HorizontalTabView.this.cxT != null && HorizontalTabView.this.cyg != null && HorizontalTabView.this.cyg != null) {
                    HorizontalTabView.this.cyg.a(HorizontalTabView.this.cxT.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cxU != null) {
                    HorizontalTabView.this.cxU.jy(i2);
                }
            }
        };
        this.cyf = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.cya) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.cyc != null) {
                            HorizontalTabView.this.cyc.a(HorizontalTabView.this.ju(1));
                        }
                        HorizontalTabView.this.ajB();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.cxU != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jz(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cxT != null) {
                            HorizontalTabView.this.cxU.jx(HorizontalTabView.this.cxT.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cxU.jx(((TabItemView) view).getTabId());
                }
            }
        };
        this.cxQ = new LinearLayout(activity);
        this.cxQ.setOrientation(0);
        this.cxQ.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cxR = new e(activity, this.cye, this.cyf);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cxQ, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        com.baidu.tbadk.core.util.ai.k(this, d.e.transparent);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aR(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d jv = jv(1);
        Iterator<d> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            d next = it.next();
            if (next != null && next.cuL == 1) {
                dVar = next;
                break;
            }
        }
        if (jv == null || dVar == null) {
            return false;
        }
        if (jv.cyk == null && dVar.cyk == null) {
            return false;
        }
        if ((jv.cyk != null || dVar.cyk == null) && (dVar.cyk != null || jv.cyk == null)) {
            if (jv.cyk == null || dVar.cyk == null) {
                return false;
            }
            if (jv.cyk.cmB == null && dVar.cyk.cmB == null) {
                return false;
            }
            if ((jv.cyk.cmB != null || dVar.cyk.cmB == null) && (dVar.cyk.cmB != null || jv.cyk.cmB == null)) {
                int size = jv.cyk.cmB.size();
                if (size != dVar.cyk.cmB.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    as asVar = dVar.cyk.cmB.get(i);
                    as asVar2 = jv.cyk.cmB.get(i);
                    if (asVar.cmx != asVar2.cmx || !asVar.name.equals(asVar2.name)) {
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
        at atVar;
        if (this.cya) {
            this.cxS = new ArrayList();
            this.cxS.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.cuL == 1) {
                at atVar2 = dVar.cyk;
                if (atVar2 != null && atVar2.cmB != null) {
                    atVar2.cmB.clear();
                    atVar = atVar2;
                } else {
                    at atVar3 = new at();
                    atVar3.cmB = new ArrayList();
                    atVar = atVar3;
                }
                if (u.u(list) > 1) {
                    as asVar = new as();
                    asVar.cmx = 1;
                    asVar.name = getContext().getString(d.l.chosen_pb_title);
                    atVar.cmB.add(asVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.cuL != 1) {
                            as asVar2 = new as();
                            asVar2.cmx = dVar2.cuL;
                            asVar2.name = dVar2.name;
                            atVar.cmB.add(asVar2);
                        }
                    }
                    dVar.cyk = atVar;
                }
                list.clear();
                list.add(dVar);
            }
        } else {
            this.cxS = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cxX > 0 && list.size() == this.cxX) {
            layoutParams = new LinearLayout.LayoutParams(k.ag(getContext()) / this.cxX, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.f.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.cuL = 1;
            dVar.name = getContext().getResources().getString(d.l.chosen_pb_title);
            this.cxQ.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cya);
            if (this.cyb != 0) {
                tabItemView.setSelectItemColorResId(this.cyb);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
            this.cxQ.addView(tabItemView, layoutParams);
            this.cxT = tabItemView;
            tabItemView.setState(TabItemView.cym);
            return;
        }
        setVisibility(0);
        if (this.mData == null || aR(list)) {
            this.mData = list;
            this.cxQ.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cya);
                        if (this.cyb != 0) {
                            tabItemView2.setSelectItemColorResId(this.cyb);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (jz(dVar2.cuL)) {
                            com.baidu.tbadk.core.util.ai.i(tabItemView2, d.e.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
                        }
                        this.cxQ.addView(tabItemView2, layoutParams);
                        if (dVar2.cuL == i) {
                            this.cxT = tabItemView2;
                            tabItemView2.setState(TabItemView.cym);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d jv(int i) {
        if (i < 0 || this.cxS == null || this.cxS.size() == 0) {
            return null;
        }
        for (d dVar : this.cxS) {
            if (dVar != null && dVar.cuL == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean jw(int i) {
        d jv = jv(i);
        return (jv == null || jv.cyk == null || jv.cyk.cmB == null || jv.cyk.cmB.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cxU = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cxT != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_bg_line_b));
            if (this.cxY) {
                canvas.drawRect(this.cxQ.getLeft(), getMeasuredHeight() - this.cxW, this.cxQ.getRight() > getRight() ? this.cxQ.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cya) {
                if (this.cyb == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.ai.d((Resources) null, d.e.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.ai.d((Resources) null, this.cyb));
                }
                canvas.drawRect(this.cxT.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cxV, (this.cxT.getRight() - getBottomLineMargin()) - this.cxT.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cya) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.ai.d((Resources) null, d.e.cp_cont_b));
            int g = k.g(getContext(), d.f.ds96);
            if (this.cxT != null) {
                g = this.cxT.getRight() - this.cxT.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(k.g(getContext(), d.f.ds32), k.g(getContext(), d.f.ds72), g, k.g(getContext(), d.f.ds76)), k.g(getContext(), d.f.ds4), k.g(getContext(), d.f.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cxT == null || this.cxP == 0) {
            return 0;
        }
        return ((this.cxT.getMeasuredWidth() - this.cxP) - this.cxT.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jx(int i) {
        c(ju(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.cyg = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cyh = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cyh;
    }

    public void setTabBackgroudColor(int i) {
        this.cxZ = i;
    }

    public void xd() {
        com.baidu.tbadk.core.util.ai.k(this, this.cxZ);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cxQ.getChildCount()) {
                View childAt = this.cxQ.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (jz(((TabItemView) childAt).getTabId())) {
                        com.baidu.tbadk.core.util.ai.i(childAt, d.e.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).xd();
                    }
                }
                i = i2 + 1;
            } else {
                this.cxR.xd();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cxX = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jy(int i) {
        if (this.cxT != null && this.cyg != null) {
            this.cyg.a(this.cxT.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cyc = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cyd = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cya = z;
    }

    public static boolean jz(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cxY = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cyb = i;
    }
}
