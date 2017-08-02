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
    private TbPageContext bDU;
    private final int cuA;
    private final int cuB;
    private int cuC;
    private boolean cuD;
    private int cuE;
    private boolean cuF;
    private int cuG;
    private a cuH;
    private b cuI;
    private e.b cuJ;
    private e.a cuK;
    private ai cuL;
    private c cuM;
    public int cuu;
    private final LinearLayout cuv;
    private final e cuw;
    private List<d> cux;
    private TabItemView cuy;
    private com.baidu.tieba.frs.tab.b cuz;
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
        void iS(int i);

        boolean iT(int i);
    }

    public void aiO() {
        final at atVar;
        if (this.bDU != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (atVar = this.mData.get(0).cuR) != null && atVar.ckG != null) {
                for (as asVar : atVar.ckG) {
                    if (asVar != null) {
                        arrayList.add(asVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.bDU.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (atVar.ckG.size() > i && atVar.ckG.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.jk(atVar.ckG.get(i).ckC));
                        }
                    }
                });
                bVar.d(this.bDU);
                bVar.tk();
            }
        }
    }

    public d jk(int i) {
        if (!u.v(this.cux)) {
            for (d dVar : this.cux) {
                if (dVar != null && dVar.cuQ == i) {
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
            if (this.cuI != null) {
                this.cuI.b(dVar);
            }
            if (dVar.cuQ == 49) {
                TiebaStatic.log("c11841");
            }
            if (jp(dVar.cuQ)) {
                if (this.cuL != null && !TextUtils.isEmpty(dVar.url)) {
                    an anVar2 = new an();
                    anVar2.ckU = dVar.url;
                    this.cuL.a(dVar.cuQ, -1, anVar2);
                }
            } else if (dVar.cuQ == 301) {
                if (this.cuL != null) {
                    this.cuL.a(dVar.cuQ, -1, null);
                }
            } else {
                if (dVar.cuQ != 49 || this.cuL == null) {
                    z = true;
                } else {
                    an anVar3 = new an();
                    anVar3.ckU = dVar.url;
                    anVar3.stType = dVar.name;
                    this.cuL.a(dVar.cuQ, 0, anVar3);
                    if (anVar3.ckV) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cuv.getChildCount(); i++) {
                    View childAt = this.cuv.getChildAt(i);
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
                    anVar.ckU = dVar.url;
                    anVar.stType = dVar.name;
                }
                if (this.cuL != null && z) {
                    this.cuL.a(dVar.cuQ, 0, anVar);
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
            if (jp(tabItemView.getTabId())) {
                if (this.cuL != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    an anVar2 = new an();
                    anVar2.ckU = tabItemView.getUrl();
                    this.cuL.a(tabItemView.getTabId(), -1, anVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cuL != null) {
                    this.cuL.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cuy = tabItemView;
                int[] iArr = new int[2];
                this.cuy.getLocationOnScreen(iArr);
                int af = k.af(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.f.ds160);
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
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.f.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.cuv.getChildCount(); i2++) {
                    View childAt = this.cuv.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cuy.getTabId() && !jp(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cuS);
                        }
                    }
                }
                if (this.cuy.getState() == TabItemView.cuS || this.cuy.getState() == TabItemView.cuU) {
                    this.cuw.aiR();
                    boolean z2 = this.cuy.getState() == TabItemView.cuS;
                    this.cuy.setState(TabItemView.cuT);
                    d jl = jl(this.cuy.getTabId());
                    if (jl != null) {
                        if (!TextUtils.isEmpty(jl.url)) {
                            an anVar3 = new an();
                            anVar3.ckU = jl.url;
                            anVar3.stType = jl.name;
                            anVar = anVar3;
                        }
                        if (jl.cuR != null && jl.cuR.ckG != null && jl.cuR.ckG.size() > 0) {
                            for (as asVar : jl.cuR.ckG) {
                                if (asVar != null && asVar.isSelected) {
                                    i = asVar.ckC;
                                }
                            }
                        }
                        if (z2 && this.cuL != null) {
                            this.cuL.a(this.cuy.getTabId(), i, anVar);
                        }
                    } else {
                        return;
                    }
                } else if (jm(this.cuy.getTabId()) && !z) {
                    if (this.cuM == null || this.cuM.iT(this.cuy.getTabId())) {
                        this.cuy.setState(TabItemView.cuU);
                        this.cuw.a((Activity) getContext(), this, this.cuy, jl(this.cuy.getTabId()).cuR);
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
        this.cuu = 0;
        this.cuy = null;
        this.cuz = null;
        this.mPaint = new Paint();
        this.cuA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cuB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cuC = 0;
        this.cuD = true;
        this.cuE = d.e.transparent;
        this.cuG = 0;
        this.cuJ = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jq(int i) {
                if (HorizontalTabView.this.cuy != null && HorizontalTabView.this.cuL != null && HorizontalTabView.this.cuL != null) {
                    HorizontalTabView.this.cuL.a(HorizontalTabView.this.cuy.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cuz != null) {
                    HorizontalTabView.this.cuz.jo(i);
                }
            }
        };
        this.cuK = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.cuF) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.cuH != null) {
                            HorizontalTabView.this.cuH.a(HorizontalTabView.this.jk(1));
                        }
                        HorizontalTabView.this.aiO();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.cuz != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jp(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cuy != null) {
                            HorizontalTabView.this.cuz.jn(HorizontalTabView.this.cuy.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cuz.jn(((TabItemView) view).getTabId());
                }
            }
        };
        this.bDU = tbPageContext;
        this.cuv = new LinearLayout(tbPageContext.getPageActivity());
        this.cuv.setOrientation(0);
        this.cuv.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.f.ds88));
        this.cuw = new e(tbPageContext.getPageActivity(), this.cuJ, this.cuK);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cuu = 0;
        this.cuy = null;
        this.cuz = null;
        this.mPaint = new Paint();
        this.cuA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cuB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cuC = 0;
        this.cuD = true;
        this.cuE = d.e.transparent;
        this.cuG = 0;
        this.cuJ = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jq(int i) {
                if (HorizontalTabView.this.cuy != null && HorizontalTabView.this.cuL != null && HorizontalTabView.this.cuL != null) {
                    HorizontalTabView.this.cuL.a(HorizontalTabView.this.cuy.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cuz != null) {
                    HorizontalTabView.this.cuz.jo(i);
                }
            }
        };
        this.cuK = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.cuF) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.cuH != null) {
                            HorizontalTabView.this.cuH.a(HorizontalTabView.this.jk(1));
                        }
                        HorizontalTabView.this.aiO();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.cuz != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jp(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cuy != null) {
                            HorizontalTabView.this.cuz.jn(HorizontalTabView.this.cuy.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cuz.jn(((TabItemView) view).getTabId());
                }
            }
        };
        this.cuv = new LinearLayout(context);
        this.cuv.setOrientation(0);
        this.cuv.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.f.ds88));
        this.cuw = new e(context, this.cuJ, this.cuK);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cuu = 0;
        this.cuy = null;
        this.cuz = null;
        this.mPaint = new Paint();
        this.cuA = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cuB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cuC = 0;
        this.cuD = true;
        this.cuE = d.e.transparent;
        this.cuG = 0;
        this.cuJ = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jq(int i2) {
                if (HorizontalTabView.this.cuy != null && HorizontalTabView.this.cuL != null && HorizontalTabView.this.cuL != null) {
                    HorizontalTabView.this.cuL.a(HorizontalTabView.this.cuy.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cuz != null) {
                    HorizontalTabView.this.cuz.jo(i2);
                }
            }
        };
        this.cuK = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.cuF) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.cuH != null) {
                            HorizontalTabView.this.cuH.a(HorizontalTabView.this.jk(1));
                        }
                        HorizontalTabView.this.aiO();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.cuz != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jp(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cuy != null) {
                            HorizontalTabView.this.cuz.jn(HorizontalTabView.this.cuy.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cuz.jn(((TabItemView) view).getTabId());
                }
            }
        };
        this.cuv = new LinearLayout(activity);
        this.cuv.setOrientation(0);
        this.cuv.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cuw = new e(activity, this.cuJ, this.cuK);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cuv, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        com.baidu.tbadk.core.util.ai.k(this, d.e.transparent);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aO(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d jl = jl(1);
        Iterator<d> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            d next = it.next();
            if (next != null && next.cuQ == 1) {
                dVar = next;
                break;
            }
        }
        if (jl == null || dVar == null) {
            return false;
        }
        if (jl.cuR == null && dVar.cuR == null) {
            return false;
        }
        if ((jl.cuR != null || dVar.cuR == null) && (dVar.cuR != null || jl.cuR == null)) {
            if (jl.cuR == null || dVar.cuR == null) {
                return false;
            }
            if (jl.cuR.ckG == null && dVar.cuR.ckG == null) {
                return false;
            }
            if ((jl.cuR.ckG != null || dVar.cuR.ckG == null) && (dVar.cuR.ckG != null || jl.cuR.ckG == null)) {
                int size = jl.cuR.ckG.size();
                if (size != dVar.cuR.ckG.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    as asVar = dVar.cuR.ckG.get(i);
                    as asVar2 = jl.cuR.ckG.get(i);
                    if (asVar.ckC != asVar2.ckC || !asVar.name.equals(asVar2.name)) {
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
        if (this.cuF) {
            this.cux = new ArrayList();
            this.cux.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.cuQ == 1) {
                at atVar2 = dVar.cuR;
                if (atVar2 != null && atVar2.ckG != null) {
                    atVar2.ckG.clear();
                    atVar = atVar2;
                } else {
                    at atVar3 = new at();
                    atVar3.ckG = new ArrayList();
                    atVar = atVar3;
                }
                if (u.u(list) > 1) {
                    as asVar = new as();
                    asVar.ckC = 1;
                    asVar.name = getContext().getString(d.l.chosen_pb_title);
                    atVar.ckG.add(asVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.cuQ != 1) {
                            as asVar2 = new as();
                            asVar2.ckC = dVar2.cuQ;
                            asVar2.name = dVar2.name;
                            atVar.ckG.add(asVar2);
                        }
                    }
                    dVar.cuR = atVar;
                }
                list.clear();
                list.add(dVar);
            }
        } else {
            this.cux = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cuC > 0 && list.size() == this.cuC) {
            layoutParams = new LinearLayout.LayoutParams(k.af(getContext()) / this.cuC, -1);
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
            dVar.cuQ = 1;
            dVar.name = getContext().getResources().getString(d.l.chosen_pb_title);
            this.cuv.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cuF);
            if (this.cuG != 0) {
                tabItemView.setSelectItemColorResId(this.cuG);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
            this.cuv.addView(tabItemView, layoutParams);
            this.cuy = tabItemView;
            tabItemView.setState(TabItemView.cuT);
            return;
        }
        setVisibility(0);
        if (this.mData == null || aO(list)) {
            this.mData = list;
            this.cuv.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cuF);
                        if (this.cuG != 0) {
                            tabItemView2.setSelectItemColorResId(this.cuG);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (jp(dVar2.cuQ)) {
                            com.baidu.tbadk.core.util.ai.i(tabItemView2, d.e.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
                        }
                        this.cuv.addView(tabItemView2, layoutParams);
                        if (dVar2.cuQ == i) {
                            this.cuy = tabItemView2;
                            tabItemView2.setState(TabItemView.cuT);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d jl(int i) {
        if (i < 0 || this.cux == null || this.cux.size() == 0) {
            return null;
        }
        for (d dVar : this.cux) {
            if (dVar != null && dVar.cuQ == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean jm(int i) {
        d jl = jl(i);
        return (jl == null || jl.cuR == null || jl.cuR.ckG == null || jl.cuR.ckG.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cuz = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cuy != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_bg_line_b));
            if (this.cuD) {
                canvas.drawRect(this.cuv.getLeft(), getMeasuredHeight() - this.cuB, this.cuv.getRight() > getRight() ? this.cuv.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cuF) {
                if (this.cuG == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.ai.d((Resources) null, d.e.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.ai.d((Resources) null, this.cuG));
                }
                canvas.drawRect(this.cuy.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cuA, (this.cuy.getRight() - getBottomLineMargin()) - this.cuy.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cuF) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.ai.d((Resources) null, d.e.cp_cont_b));
            int g = k.g(getContext(), d.f.ds96);
            if (this.cuy != null) {
                g = this.cuy.getRight() - this.cuy.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(k.g(getContext(), d.f.ds32), k.g(getContext(), d.f.ds72), g, k.g(getContext(), d.f.ds76)), k.g(getContext(), d.f.ds4), k.g(getContext(), d.f.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cuy == null || this.cuu == 0) {
            return 0;
        }
        return ((this.cuy.getMeasuredWidth() - this.cuu) - this.cuy.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jn(int i) {
        c(jk(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.cuL = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cuM = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cuM;
    }

    public void setTabBackgroudColor(int i) {
        this.cuE = i;
    }

    public void wV() {
        com.baidu.tbadk.core.util.ai.k(this, this.cuE);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cuv.getChildCount()) {
                View childAt = this.cuv.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (jp(((TabItemView) childAt).getTabId())) {
                        com.baidu.tbadk.core.util.ai.i(childAt, d.e.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).wV();
                    }
                }
                i = i2 + 1;
            } else {
                this.cuw.wV();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cuC = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jo(int i) {
        if (this.cuy != null && this.cuL != null) {
            this.cuL.a(this.cuy.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cuH = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cuI = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cuF = z;
    }

    public static boolean jp(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cuD = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cuG = i;
    }
}
