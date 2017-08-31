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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
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
    private TbPageContext bII;
    private int cEA;
    private boolean cEB;
    private int cEC;
    private boolean cED;
    private int cEE;
    private a cEF;
    private b cEG;
    private e.b cEH;
    private e.a cEI;
    private ai cEJ;
    private c cEK;
    public int cEs;
    private final LinearLayout cEt;
    private final e cEu;
    private List<d> cEv;
    private TabItemView cEw;
    private com.baidu.tieba.frs.tab.b cEx;
    private final int cEy;
    private final int cEz;
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
        void ji(int i);

        boolean jj(int i);
    }

    public void all() {
        final at atVar;
        if (this.bII != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (atVar = this.mData.get(0).cEN) != null && atVar.crV != null) {
                for (as asVar : atVar.crV) {
                    if (asVar != null) {
                        arrayList.add(asVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.bII.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (atVar.crV.size() > i && atVar.crV.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.jI(atVar.crV.get(i).crR));
                        }
                    }
                });
                bVar.d(this.bII);
                bVar.tr();
            }
        }
    }

    public d jI(int i) {
        if (!v.v(this.cEv)) {
            for (d dVar : this.cEv) {
                if (dVar != null && dVar.cBp == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void c(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.cBp != 302 && this.cEG != null) {
                this.cEG.b(dVar);
            }
            if (dVar.cBp == 49) {
                TiebaStatic.log("c11841");
            }
            if (jN(dVar.cBp)) {
                if (this.cEJ != null && !TextUtils.isEmpty(dVar.url)) {
                    an anVar = new an();
                    anVar.csj = dVar.url;
                    this.cEJ.a(dVar.cBp, -1, anVar);
                }
            } else if (dVar.cBp == 301 || dVar.cBp == 302) {
                if (this.cEJ != null) {
                    this.cEJ.a(dVar.cBp, -1, null);
                }
            } else {
                if (dVar.cBp != 49 || this.cEJ == null) {
                    z = true;
                } else {
                    an anVar2 = new an();
                    anVar2.csj = dVar.url;
                    anVar2.stType = dVar.name;
                    this.cEJ.a(dVar.cBp, 0, anVar2);
                    if (anVar2.csk) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cEt.getChildCount(); i++) {
                    View childAt = this.cEt.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                an anVar3 = null;
                if (!TextUtils.isEmpty(dVar.url)) {
                    anVar3 = new an();
                    anVar3.csj = dVar.url;
                    anVar3.stType = dVar.name;
                }
                if (this.cEJ != null && z) {
                    this.cEJ.a(dVar.cBp, 0, anVar3);
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
            if (jN(tabItemView.getTabId())) {
                if (this.cEJ != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    an anVar2 = new an();
                    anVar2.csj = tabItemView.getUrl();
                    this.cEJ.a(tabItemView.getTabId(), -1, anVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cEJ != null) {
                    this.cEJ.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cEw = tabItemView;
                int[] iArr = new int[2];
                this.cEw.getLocationOnScreen(iArr);
                int ad = k.ad(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.f.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (ad < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.f.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.cEt.getChildCount(); i2++) {
                    View childAt = this.cEt.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cEw.getTabId() && !jN(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cEO);
                        }
                    }
                }
                if (this.cEw.getState() == TabItemView.cEO || this.cEw.getState() == TabItemView.cEQ) {
                    this.cEu.alo();
                    boolean z2 = this.cEw.getState() == TabItemView.cEO;
                    this.cEw.setState(TabItemView.cEP);
                    d jJ = jJ(this.cEw.getTabId());
                    if (jJ != null) {
                        if (!TextUtils.isEmpty(jJ.url)) {
                            an anVar3 = new an();
                            anVar3.csj = jJ.url;
                            anVar3.stType = jJ.name;
                            anVar = anVar3;
                        }
                        if (jJ.cEN != null && jJ.cEN.crV != null && jJ.cEN.crV.size() > 0) {
                            for (as asVar : jJ.cEN.crV) {
                                if (asVar != null && asVar.isSelected) {
                                    i = asVar.crR;
                                }
                            }
                        }
                        if (z2 && this.cEJ != null) {
                            this.cEJ.a(this.cEw.getTabId(), i, anVar);
                        }
                    } else {
                        return;
                    }
                } else if (jK(this.cEw.getTabId()) && !z) {
                    if (this.cEK == null || this.cEK.jj(this.cEw.getTabId())) {
                        this.cEw.setState(TabItemView.cEQ);
                        this.cEu.a((Activity) getContext(), this, this.cEw, jJ(this.cEw.getTabId()).cEN);
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
        this.cEs = 0;
        this.cEw = null;
        this.cEx = null;
        this.mPaint = new Paint();
        this.cEy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cEz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cEA = 0;
        this.cEB = true;
        this.cEC = d.e.transparent;
        this.cEE = 0;
        this.cEH = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jO(int i) {
                if (HorizontalTabView.this.cEw != null && HorizontalTabView.this.cEJ != null && HorizontalTabView.this.cEJ != null) {
                    HorizontalTabView.this.cEJ.a(HorizontalTabView.this.cEw.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cEx != null) {
                    HorizontalTabView.this.cEx.jM(i);
                }
            }
        };
        this.cEI = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cED) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cEF != null) {
                                HorizontalTabView.this.cEF.a(HorizontalTabView.this.jI(1));
                            }
                            HorizontalTabView.this.all();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cBp == 302) {
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
                if (HorizontalTabView.this.cEx != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jN(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cEw != null) {
                            HorizontalTabView.this.cEx.jL(HorizontalTabView.this.cEw.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cEx.jL(((TabItemView) view).getTabId());
                }
            }
        };
        this.bII = tbPageContext;
        this.cEt = new LinearLayout(tbPageContext.getPageActivity());
        this.cEt.setOrientation(0);
        this.cEt.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.f.ds88));
        this.cEu = new e(tbPageContext.getPageActivity(), this.cEH, this.cEI);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cEs = 0;
        this.cEw = null;
        this.cEx = null;
        this.mPaint = new Paint();
        this.cEy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cEz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cEA = 0;
        this.cEB = true;
        this.cEC = d.e.transparent;
        this.cEE = 0;
        this.cEH = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jO(int i) {
                if (HorizontalTabView.this.cEw != null && HorizontalTabView.this.cEJ != null && HorizontalTabView.this.cEJ != null) {
                    HorizontalTabView.this.cEJ.a(HorizontalTabView.this.cEw.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cEx != null) {
                    HorizontalTabView.this.cEx.jM(i);
                }
            }
        };
        this.cEI = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cED) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cEF != null) {
                                HorizontalTabView.this.cEF.a(HorizontalTabView.this.jI(1));
                            }
                            HorizontalTabView.this.all();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cBp == 302) {
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
                if (HorizontalTabView.this.cEx != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jN(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cEw != null) {
                            HorizontalTabView.this.cEx.jL(HorizontalTabView.this.cEw.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cEx.jL(((TabItemView) view).getTabId());
                }
            }
        };
        this.cEt = new LinearLayout(context);
        this.cEt.setOrientation(0);
        this.cEt.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.f.ds88));
        this.cEu = new e(context, this.cEH, this.cEI);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cEs = 0;
        this.cEw = null;
        this.cEx = null;
        this.mPaint = new Paint();
        this.cEy = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cEz = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cEA = 0;
        this.cEB = true;
        this.cEC = d.e.transparent;
        this.cEE = 0;
        this.cEH = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jO(int i2) {
                if (HorizontalTabView.this.cEw != null && HorizontalTabView.this.cEJ != null && HorizontalTabView.this.cEJ != null) {
                    HorizontalTabView.this.cEJ.a(HorizontalTabView.this.cEw.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cEx != null) {
                    HorizontalTabView.this.cEx.jM(i2);
                }
            }
        };
        this.cEI = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cED) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cEF != null) {
                                HorizontalTabView.this.cEF.a(HorizontalTabView.this.jI(1));
                            }
                            HorizontalTabView.this.all();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cBp == 302) {
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
                if (HorizontalTabView.this.cEx != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jN(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cEw != null) {
                            HorizontalTabView.this.cEx.jL(HorizontalTabView.this.cEw.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cEx.jL(((TabItemView) view).getTabId());
                }
            }
        };
        this.cEt = new LinearLayout(activity);
        this.cEt.setOrientation(0);
        this.cEt.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cEu = new e(activity, this.cEH, this.cEI);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cEt, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        aj.k(this, d.e.transparent);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aV(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d jJ = jJ(1);
        Iterator<d> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            d next = it.next();
            if (next != null && next.cBp == 1) {
                dVar = next;
                break;
            }
        }
        if (jJ == null || dVar == null) {
            return false;
        }
        if (jJ.cEN == null && dVar.cEN == null) {
            return false;
        }
        if ((jJ.cEN != null || dVar.cEN == null) && (dVar.cEN != null || jJ.cEN == null)) {
            if (jJ.cEN == null || dVar.cEN == null) {
                return false;
            }
            if (jJ.cEN.crV == null && dVar.cEN.crV == null) {
                return false;
            }
            if ((jJ.cEN.crV != null || dVar.cEN.crV == null) && (dVar.cEN.crV != null || jJ.cEN.crV == null)) {
                int size = jJ.cEN.crV.size();
                if (size != dVar.cEN.crV.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    as asVar = dVar.cEN.crV.get(i);
                    as asVar2 = jJ.cEN.crV.get(i);
                    if (asVar.crR != asVar2.crR || !asVar.name.equals(asVar2.name)) {
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
        if (this.cED) {
            this.cEv = new ArrayList();
            this.cEv.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.cBp == 1) {
                at atVar2 = dVar.cEN;
                if (atVar2 != null && atVar2.crV != null) {
                    atVar2.crV.clear();
                    atVar = atVar2;
                } else {
                    at atVar3 = new at();
                    atVar3.crV = new ArrayList();
                    atVar = atVar3;
                }
                d dVar2 = null;
                if (v.u(list) > 1) {
                    as asVar = new as();
                    asVar.crR = 1;
                    asVar.name = getContext().getString(d.l.chosen_pb_title);
                    atVar.crV.add(asVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.cBp != 1 && dVar3.cBp != 302) {
                            as asVar2 = new as();
                            asVar2.crR = dVar3.cBp;
                            asVar2.name = dVar3.name;
                            atVar.crV.add(asVar2);
                        }
                        if (dVar3 == null || dVar3.cBp != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.cEN = atVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.cEv = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cEA > 0 && list.size() == this.cEA) {
            layoutParams = new LinearLayout.LayoutParams(k.ad(getContext()) / this.cEA, -1);
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
            dVar.cBp = 1;
            dVar.name = getContext().getResources().getString(d.l.chosen_pb_title);
            this.cEt.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cED);
            if (this.cEE != 0) {
                tabItemView.setSelectItemColorResId(this.cEE);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
            this.cEt.addView(tabItemView, layoutParams);
            this.cEw = tabItemView;
            tabItemView.setState(TabItemView.cEP);
            return;
        }
        setVisibility(0);
        if (this.mData == null || aV(list)) {
            this.mData = list;
            this.cEt.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cED);
                        if (302 == dVar2.cBp) {
                            aj.c(tabItemView2, d.e.cp_cont_j, 1);
                        }
                        if (this.cEE != 0) {
                            tabItemView2.setSelectItemColorResId(this.cEE);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (jN(dVar2.cBp)) {
                            aj.i(tabItemView2, d.e.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
                        }
                        this.cEt.addView(tabItemView2, layoutParams);
                        if (dVar2.cBp == i) {
                            this.cEw = tabItemView2;
                            tabItemView2.setState(TabItemView.cEP);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d jJ(int i) {
        if (i < 0 || this.cEv == null || this.cEv.size() == 0) {
            return null;
        }
        for (d dVar : this.cEv) {
            if (dVar != null && dVar.cBp == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean jK(int i) {
        d jJ = jJ(i);
        return (jJ == null || jJ.cEN == null || jJ.cEN.crV == null || jJ.cEN.crV.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cEx = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cEw != null) {
            this.mPaint.setColor(aj.getColor(d.e.cp_bg_line_b));
            if (this.cEB) {
                canvas.drawRect(this.cEt.getLeft(), getMeasuredHeight() - this.cEz, this.cEt.getRight() > getRight() ? this.cEt.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cED) {
                if (this.cEE == 0) {
                    this.mPaint.setColor(aj.d((Resources) null, d.e.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(aj.d((Resources) null, this.cEE));
                }
                canvas.drawRect(this.cEw.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cEy, (this.cEw.getRight() - getBottomLineMargin()) - this.cEw.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cED) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(aj.d((Resources) null, d.e.cp_cont_b));
            int g = k.g(getContext(), d.f.ds96);
            if (this.cEw != null) {
                g = this.cEw.getRight() - this.cEw.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(k.g(getContext(), d.f.ds32), k.g(getContext(), d.f.ds72), g, k.g(getContext(), d.f.ds76)), k.g(getContext(), d.f.ds4), k.g(getContext(), d.f.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cEw == null || this.cEs == 0) {
            return 0;
        }
        return ((this.cEw.getMeasuredWidth() - this.cEs) - this.cEw.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jL(int i) {
        c(jI(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.cEJ = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cEK = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cEK;
    }

    public void setTabBackgroudColor(int i) {
        this.cEC = i;
    }

    public void xc() {
        aj.k(this, this.cEC);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cEt.getChildCount()) {
                View childAt = this.cEt.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (jN(((TabItemView) childAt).getTabId())) {
                        aj.i(childAt, d.e.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).xc();
                    }
                }
                i = i2 + 1;
            } else {
                this.cEu.xc();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cEA = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jM(int i) {
        if (this.cEw != null && this.cEJ != null) {
            this.cEJ.a(this.cEw.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cEF = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cEG = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cED = z;
    }

    public static boolean jN(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cEB = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cEE = i;
    }
}
