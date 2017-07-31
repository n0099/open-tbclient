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
    private TbPageContext bFe;
    public int cvM;
    private final LinearLayout cvN;
    private final e cvO;
    private List<d> cvP;
    private TabItemView cvQ;
    private com.baidu.tieba.frs.tab.b cvR;
    private final int cvS;
    private final int cvT;
    private int cvU;
    private boolean cvV;
    private int cvW;
    private boolean cvX;
    private int cvY;
    private a cvZ;
    private b cwa;
    private e.b cwb;
    private e.a cwc;
    private ai cwd;
    private c cwe;
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

    public void aja() {
        final at atVar;
        if (this.bFe != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (atVar = this.mData.get(0).cwj) != null && atVar.clO != null) {
                for (as asVar : atVar.clO) {
                    if (asVar != null) {
                        arrayList.add(asVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.bFe.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0043b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0043b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (atVar.clO.size() > i && atVar.clO.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.jk(atVar.clO.get(i).clK));
                        }
                    }
                });
                bVar.d(this.bFe);
                bVar.tu();
            }
        }
    }

    public d jk(int i) {
        if (!u.v(this.cvP)) {
            for (d dVar : this.cvP) {
                if (dVar != null && dVar.cwi == i) {
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
            if (this.cwa != null) {
                this.cwa.b(dVar);
            }
            if (dVar.cwi == 49) {
                TiebaStatic.log("c11841");
            }
            if (jp(dVar.cwi)) {
                if (this.cwd != null && !TextUtils.isEmpty(dVar.url)) {
                    an anVar2 = new an();
                    anVar2.cmc = dVar.url;
                    this.cwd.a(dVar.cwi, -1, anVar2);
                }
            } else if (dVar.cwi == 301) {
                if (this.cwd != null) {
                    this.cwd.a(dVar.cwi, -1, null);
                }
            } else {
                if (dVar.cwi != 49 || this.cwd == null) {
                    z = true;
                } else {
                    an anVar3 = new an();
                    anVar3.cmc = dVar.url;
                    anVar3.stType = dVar.name;
                    this.cwd.a(dVar.cwi, 0, anVar3);
                    if (anVar3.cme) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cvN.getChildCount(); i++) {
                    View childAt = this.cvN.getChildAt(i);
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
                    anVar.cmc = dVar.url;
                    anVar.stType = dVar.name;
                }
                if (this.cwd != null && z) {
                    this.cwd.a(dVar.cwi, 0, anVar);
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
                if (this.cwd != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    an anVar2 = new an();
                    anVar2.cmc = tabItemView.getUrl();
                    this.cwd.a(tabItemView.getTabId(), -1, anVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cwd != null) {
                    this.cwd.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cvQ = tabItemView;
                int[] iArr = new int[2];
                this.cvQ.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.cvN.getChildCount(); i2++) {
                    View childAt = this.cvN.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cvQ.getTabId() && !jp(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cwk);
                        }
                    }
                }
                if (this.cvQ.getState() == TabItemView.cwk || this.cvQ.getState() == TabItemView.cwm) {
                    this.cvO.ajd();
                    boolean z2 = this.cvQ.getState() == TabItemView.cwk;
                    this.cvQ.setState(TabItemView.cwl);
                    d jl = jl(this.cvQ.getTabId());
                    if (jl != null) {
                        if (!TextUtils.isEmpty(jl.url)) {
                            an anVar3 = new an();
                            anVar3.cmc = jl.url;
                            anVar3.stType = jl.name;
                            anVar = anVar3;
                        }
                        if (jl.cwj != null && jl.cwj.clO != null && jl.cwj.clO.size() > 0) {
                            for (as asVar : jl.cwj.clO) {
                                if (asVar != null && asVar.isSelected) {
                                    i = asVar.clK;
                                }
                            }
                        }
                        if (z2 && this.cwd != null) {
                            this.cwd.a(this.cvQ.getTabId(), i, anVar);
                        }
                    } else {
                        return;
                    }
                } else if (jm(this.cvQ.getTabId()) && !z) {
                    if (this.cwe == null || this.cwe.iT(this.cvQ.getTabId())) {
                        this.cvQ.setState(TabItemView.cwm);
                        this.cvO.a((Activity) getContext(), this, this.cvQ, jl(this.cvQ.getTabId()).cwj);
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
        this.cvM = 0;
        this.cvQ = null;
        this.cvR = null;
        this.mPaint = new Paint();
        this.cvS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cvT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cvU = 0;
        this.cvV = true;
        this.cvW = d.e.transparent;
        this.cvY = 0;
        this.cwb = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jq(int i) {
                if (HorizontalTabView.this.cvQ != null && HorizontalTabView.this.cwd != null && HorizontalTabView.this.cwd != null) {
                    HorizontalTabView.this.cwd.a(HorizontalTabView.this.cvQ.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cvR != null) {
                    HorizontalTabView.this.cvR.jo(i);
                }
            }
        };
        this.cwc = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.cvX) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.cvZ != null) {
                            HorizontalTabView.this.cvZ.a(HorizontalTabView.this.jk(1));
                        }
                        HorizontalTabView.this.aja();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.cvR != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jp(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cvQ != null) {
                            HorizontalTabView.this.cvR.jn(HorizontalTabView.this.cvQ.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cvR.jn(((TabItemView) view).getTabId());
                }
            }
        };
        this.bFe = tbPageContext;
        this.cvN = new LinearLayout(tbPageContext.getPageActivity());
        this.cvN.setOrientation(0);
        this.cvN.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.f.ds88));
        this.cvO = new e(tbPageContext.getPageActivity(), this.cwb, this.cwc);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cvM = 0;
        this.cvQ = null;
        this.cvR = null;
        this.mPaint = new Paint();
        this.cvS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cvT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cvU = 0;
        this.cvV = true;
        this.cvW = d.e.transparent;
        this.cvY = 0;
        this.cwb = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jq(int i) {
                if (HorizontalTabView.this.cvQ != null && HorizontalTabView.this.cwd != null && HorizontalTabView.this.cwd != null) {
                    HorizontalTabView.this.cwd.a(HorizontalTabView.this.cvQ.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cvR != null) {
                    HorizontalTabView.this.cvR.jo(i);
                }
            }
        };
        this.cwc = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.cvX) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.cvZ != null) {
                            HorizontalTabView.this.cvZ.a(HorizontalTabView.this.jk(1));
                        }
                        HorizontalTabView.this.aja();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.cvR != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jp(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cvQ != null) {
                            HorizontalTabView.this.cvR.jn(HorizontalTabView.this.cvQ.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cvR.jn(((TabItemView) view).getTabId());
                }
            }
        };
        this.cvN = new LinearLayout(context);
        this.cvN.setOrientation(0);
        this.cvN.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.f.ds88));
        this.cvO = new e(context, this.cwb, this.cwc);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cvM = 0;
        this.cvQ = null;
        this.cvR = null;
        this.mPaint = new Paint();
        this.cvS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cvT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cvU = 0;
        this.cvV = true;
        this.cvW = d.e.transparent;
        this.cvY = 0;
        this.cwb = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jq(int i2) {
                if (HorizontalTabView.this.cvQ != null && HorizontalTabView.this.cwd != null && HorizontalTabView.this.cwd != null) {
                    HorizontalTabView.this.cwd.a(HorizontalTabView.this.cvQ.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cvR != null) {
                    HorizontalTabView.this.cvR.jo(i2);
                }
            }
        };
        this.cwc = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.cvX) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.cvZ != null) {
                            HorizontalTabView.this.cvZ.a(HorizontalTabView.this.jk(1));
                        }
                        HorizontalTabView.this.aja();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.cvR != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jp(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cvQ != null) {
                            HorizontalTabView.this.cvR.jn(HorizontalTabView.this.cvQ.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cvR.jn(((TabItemView) view).getTabId());
                }
            }
        };
        this.cvN = new LinearLayout(activity);
        this.cvN.setOrientation(0);
        this.cvN.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cvO = new e(activity, this.cwb, this.cwc);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cvN, layoutParams);
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
            if (next != null && next.cwi == 1) {
                dVar = next;
                break;
            }
        }
        if (jl == null || dVar == null) {
            return false;
        }
        if (jl.cwj == null && dVar.cwj == null) {
            return false;
        }
        if ((jl.cwj != null || dVar.cwj == null) && (dVar.cwj != null || jl.cwj == null)) {
            if (jl.cwj == null || dVar.cwj == null) {
                return false;
            }
            if (jl.cwj.clO == null && dVar.cwj.clO == null) {
                return false;
            }
            if ((jl.cwj.clO != null || dVar.cwj.clO == null) && (dVar.cwj.clO != null || jl.cwj.clO == null)) {
                int size = jl.cwj.clO.size();
                if (size != dVar.cwj.clO.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    as asVar = dVar.cwj.clO.get(i);
                    as asVar2 = jl.cwj.clO.get(i);
                    if (asVar.clK != asVar2.clK || !asVar.name.equals(asVar2.name)) {
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
        if (this.cvX) {
            this.cvP = new ArrayList();
            this.cvP.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.cwi == 1) {
                at atVar2 = dVar.cwj;
                if (atVar2 != null && atVar2.clO != null) {
                    atVar2.clO.clear();
                    atVar = atVar2;
                } else {
                    at atVar3 = new at();
                    atVar3.clO = new ArrayList();
                    atVar = atVar3;
                }
                if (u.u(list) > 1) {
                    as asVar = new as();
                    asVar.clK = 1;
                    asVar.name = getContext().getString(d.l.chosen_pb_title);
                    atVar.clO.add(asVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.cwi != 1) {
                            as asVar2 = new as();
                            asVar2.clK = dVar2.cwi;
                            asVar2.name = dVar2.name;
                            atVar.clO.add(asVar2);
                        }
                    }
                    dVar.cwj = atVar;
                }
                list.clear();
                list.add(dVar);
            }
        } else {
            this.cvP = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cvU > 0 && list.size() == this.cvU) {
            layoutParams = new LinearLayout.LayoutParams(k.ag(getContext()) / this.cvU, -1);
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
            dVar.cwi = 1;
            dVar.name = getContext().getResources().getString(d.l.chosen_pb_title);
            this.cvN.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cvX);
            if (this.cvY != 0) {
                tabItemView.setSelectItemColorResId(this.cvY);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
            this.cvN.addView(tabItemView, layoutParams);
            this.cvQ = tabItemView;
            tabItemView.setState(TabItemView.cwl);
            return;
        }
        setVisibility(0);
        if (this.mData == null || aO(list)) {
            this.mData = list;
            this.cvN.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cvX);
                        if (this.cvY != 0) {
                            tabItemView2.setSelectItemColorResId(this.cvY);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (jp(dVar2.cwi)) {
                            com.baidu.tbadk.core.util.ai.i(tabItemView2, d.e.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
                        }
                        this.cvN.addView(tabItemView2, layoutParams);
                        if (dVar2.cwi == i) {
                            this.cvQ = tabItemView2;
                            tabItemView2.setState(TabItemView.cwl);
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
        if (i < 0 || this.cvP == null || this.cvP.size() == 0) {
            return null;
        }
        for (d dVar : this.cvP) {
            if (dVar != null && dVar.cwi == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean jm(int i) {
        d jl = jl(i);
        return (jl == null || jl.cwj == null || jl.cwj.clO == null || jl.cwj.clO.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cvR = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cvQ != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.ai.getColor(d.e.cp_bg_line_b));
            if (this.cvV) {
                canvas.drawRect(this.cvN.getLeft(), getMeasuredHeight() - this.cvT, this.cvN.getRight() > getRight() ? this.cvN.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cvX) {
                if (this.cvY == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.ai.d((Resources) null, d.e.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.ai.d((Resources) null, this.cvY));
                }
                canvas.drawRect(this.cvQ.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cvS, (this.cvQ.getRight() - getBottomLineMargin()) - this.cvQ.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cvX) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.ai.d((Resources) null, d.e.cp_cont_b));
            int g = k.g(getContext(), d.f.ds96);
            if (this.cvQ != null) {
                g = this.cvQ.getRight() - this.cvQ.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(k.g(getContext(), d.f.ds32), k.g(getContext(), d.f.ds72), g, k.g(getContext(), d.f.ds76)), k.g(getContext(), d.f.ds4), k.g(getContext(), d.f.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cvQ == null || this.cvM == 0) {
            return 0;
        }
        return ((this.cvQ.getMeasuredWidth() - this.cvM) - this.cvQ.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jn(int i) {
        c(jk(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.cwd = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cwe = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cwe;
    }

    public void setTabBackgroudColor(int i) {
        this.cvW = i;
    }

    public void xd() {
        com.baidu.tbadk.core.util.ai.k(this, this.cvW);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cvN.getChildCount()) {
                View childAt = this.cvN.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (jp(((TabItemView) childAt).getTabId())) {
                        com.baidu.tbadk.core.util.ai.i(childAt, d.e.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).xd();
                    }
                }
                i = i2 + 1;
            } else {
                this.cvO.xd();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cvU = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jo(int i) {
        if (this.cvQ != null && this.cwd != null) {
            this.cwd.a(this.cvQ.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cvZ = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cwa = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cvX = z;
    }

    public static boolean jp(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cvV = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cvY = i;
    }
}
