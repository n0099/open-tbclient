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
    private TbPageContext bJz;
    private e.a cFA;
    private ai cFB;
    private c cFC;
    public int cFk;
    private final LinearLayout cFl;
    private final e cFm;
    private List<d> cFn;
    private TabItemView cFo;
    private com.baidu.tieba.frs.tab.b cFp;
    private final int cFq;
    private final int cFr;
    private int cFs;
    private boolean cFt;
    private int cFu;
    private boolean cFv;
    private int cFw;
    private a cFx;
    private b cFy;
    private e.b cFz;
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
        void jk(int i);

        boolean jl(int i);
    }

    public void alw() {
        final at atVar;
        if (this.bJz != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (atVar = this.mData.get(0).cFF) != null && atVar.csN != null) {
                for (as asVar : atVar.csN) {
                    if (asVar != null) {
                        arrayList.add(asVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.bJz.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0046b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0046b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (atVar.csN.size() > i && atVar.csN.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.jK(atVar.csN.get(i).csJ));
                        }
                    }
                });
                bVar.d(this.bJz);
                bVar.tr();
            }
        }
    }

    public d jK(int i) {
        if (!v.v(this.cFn)) {
            for (d dVar : this.cFn) {
                if (dVar != null && dVar.cCh == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void c(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.cCh != 302 && this.cFy != null) {
                this.cFy.b(dVar);
            }
            if (dVar.cCh == 49) {
                TiebaStatic.log("c11841");
            }
            if (jP(dVar.cCh)) {
                if (this.cFB != null && !TextUtils.isEmpty(dVar.url)) {
                    an anVar = new an();
                    anVar.ctb = dVar.url;
                    this.cFB.a(dVar.cCh, -1, anVar);
                }
            } else if (dVar.cCh == 301 || dVar.cCh == 302) {
                if (this.cFB != null) {
                    this.cFB.a(dVar.cCh, -1, null);
                }
            } else {
                if (dVar.cCh != 49 || this.cFB == null) {
                    z = true;
                } else {
                    an anVar2 = new an();
                    anVar2.ctb = dVar.url;
                    anVar2.stType = dVar.name;
                    this.cFB.a(dVar.cCh, 0, anVar2);
                    if (anVar2.ctc) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cFl.getChildCount(); i++) {
                    View childAt = this.cFl.getChildAt(i);
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
                    anVar3.ctb = dVar.url;
                    anVar3.stType = dVar.name;
                }
                if (this.cFB != null && z) {
                    this.cFB.a(dVar.cCh, 0, anVar3);
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
            if (jP(tabItemView.getTabId())) {
                if (this.cFB != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    an anVar2 = new an();
                    anVar2.ctb = tabItemView.getUrl();
                    this.cFB.a(tabItemView.getTabId(), -1, anVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cFB != null) {
                    this.cFB.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cFo = tabItemView;
                int[] iArr = new int[2];
                this.cFo.getLocationOnScreen(iArr);
                int ae = k.ae(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.f.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (ae < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.f.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.cFl.getChildCount(); i2++) {
                    View childAt = this.cFl.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cFo.getTabId() && !jP(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cFG);
                        }
                    }
                }
                if (this.cFo.getState() == TabItemView.cFG || this.cFo.getState() == TabItemView.cFI) {
                    this.cFm.alz();
                    boolean z2 = this.cFo.getState() == TabItemView.cFG;
                    this.cFo.setState(TabItemView.cFH);
                    d jL = jL(this.cFo.getTabId());
                    if (jL != null) {
                        if (!TextUtils.isEmpty(jL.url)) {
                            an anVar3 = new an();
                            anVar3.ctb = jL.url;
                            anVar3.stType = jL.name;
                            anVar = anVar3;
                        }
                        if (jL.cFF != null && jL.cFF.csN != null && jL.cFF.csN.size() > 0) {
                            for (as asVar : jL.cFF.csN) {
                                if (asVar != null && asVar.isSelected) {
                                    i = asVar.csJ;
                                }
                            }
                        }
                        if (z2 && this.cFB != null) {
                            this.cFB.a(this.cFo.getTabId(), i, anVar);
                        }
                    } else {
                        return;
                    }
                } else if (jM(this.cFo.getTabId()) && !z) {
                    if (this.cFC == null || this.cFC.jl(this.cFo.getTabId())) {
                        this.cFo.setState(TabItemView.cFI);
                        this.cFm.a((Activity) getContext(), this, this.cFo, jL(this.cFo.getTabId()).cFF);
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
        this.cFk = 0;
        this.cFo = null;
        this.cFp = null;
        this.mPaint = new Paint();
        this.cFq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cFr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cFs = 0;
        this.cFt = true;
        this.cFu = d.e.transparent;
        this.cFw = 0;
        this.cFz = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jQ(int i) {
                if (HorizontalTabView.this.cFo != null && HorizontalTabView.this.cFB != null && HorizontalTabView.this.cFB != null) {
                    HorizontalTabView.this.cFB.a(HorizontalTabView.this.cFo.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cFp != null) {
                    HorizontalTabView.this.cFp.jO(i);
                }
            }
        };
        this.cFA = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cFv) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cFx != null) {
                                HorizontalTabView.this.cFx.a(HorizontalTabView.this.jK(1));
                            }
                            HorizontalTabView.this.alw();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cCh == 302) {
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
                if (HorizontalTabView.this.cFp != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jP(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cFo != null) {
                            HorizontalTabView.this.cFp.jN(HorizontalTabView.this.cFo.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cFp.jN(((TabItemView) view).getTabId());
                }
            }
        };
        this.bJz = tbPageContext;
        this.cFl = new LinearLayout(tbPageContext.getPageActivity());
        this.cFl.setOrientation(0);
        this.cFl.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.f.ds88));
        this.cFm = new e(tbPageContext.getPageActivity(), this.cFz, this.cFA);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cFk = 0;
        this.cFo = null;
        this.cFp = null;
        this.mPaint = new Paint();
        this.cFq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cFr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cFs = 0;
        this.cFt = true;
        this.cFu = d.e.transparent;
        this.cFw = 0;
        this.cFz = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jQ(int i) {
                if (HorizontalTabView.this.cFo != null && HorizontalTabView.this.cFB != null && HorizontalTabView.this.cFB != null) {
                    HorizontalTabView.this.cFB.a(HorizontalTabView.this.cFo.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cFp != null) {
                    HorizontalTabView.this.cFp.jO(i);
                }
            }
        };
        this.cFA = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cFv) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cFx != null) {
                                HorizontalTabView.this.cFx.a(HorizontalTabView.this.jK(1));
                            }
                            HorizontalTabView.this.alw();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cCh == 302) {
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
                if (HorizontalTabView.this.cFp != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jP(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cFo != null) {
                            HorizontalTabView.this.cFp.jN(HorizontalTabView.this.cFo.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cFp.jN(((TabItemView) view).getTabId());
                }
            }
        };
        this.cFl = new LinearLayout(context);
        this.cFl.setOrientation(0);
        this.cFl.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.f.ds88));
        this.cFm = new e(context, this.cFz, this.cFA);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cFk = 0;
        this.cFo = null;
        this.cFp = null;
        this.mPaint = new Paint();
        this.cFq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cFr = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cFs = 0;
        this.cFt = true;
        this.cFu = d.e.transparent;
        this.cFw = 0;
        this.cFz = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jQ(int i2) {
                if (HorizontalTabView.this.cFo != null && HorizontalTabView.this.cFB != null && HorizontalTabView.this.cFB != null) {
                    HorizontalTabView.this.cFB.a(HorizontalTabView.this.cFo.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cFp != null) {
                    HorizontalTabView.this.cFp.jO(i2);
                }
            }
        };
        this.cFA = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cFv) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cFx != null) {
                                HorizontalTabView.this.cFx.a(HorizontalTabView.this.jK(1));
                            }
                            HorizontalTabView.this.alw();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cCh == 302) {
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
                if (HorizontalTabView.this.cFp != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jP(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cFo != null) {
                            HorizontalTabView.this.cFp.jN(HorizontalTabView.this.cFo.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cFp.jN(((TabItemView) view).getTabId());
                }
            }
        };
        this.cFl = new LinearLayout(activity);
        this.cFl.setOrientation(0);
        this.cFl.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cFm = new e(activity, this.cFz, this.cFA);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cFl, layoutParams);
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
        d jL = jL(1);
        Iterator<d> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            d next = it.next();
            if (next != null && next.cCh == 1) {
                dVar = next;
                break;
            }
        }
        if (jL == null || dVar == null) {
            return false;
        }
        if (jL.cFF == null && dVar.cFF == null) {
            return false;
        }
        if ((jL.cFF != null || dVar.cFF == null) && (dVar.cFF != null || jL.cFF == null)) {
            if (jL.cFF == null || dVar.cFF == null) {
                return false;
            }
            if (jL.cFF.csN == null && dVar.cFF.csN == null) {
                return false;
            }
            if ((jL.cFF.csN != null || dVar.cFF.csN == null) && (dVar.cFF.csN != null || jL.cFF.csN == null)) {
                int size = jL.cFF.csN.size();
                if (size != dVar.cFF.csN.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    as asVar = dVar.cFF.csN.get(i);
                    as asVar2 = jL.cFF.csN.get(i);
                    if (asVar.csJ != asVar2.csJ || !asVar.name.equals(asVar2.name)) {
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
        if (this.cFv) {
            this.cFn = new ArrayList();
            this.cFn.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.cCh == 1) {
                at atVar2 = dVar.cFF;
                if (atVar2 != null && atVar2.csN != null) {
                    atVar2.csN.clear();
                    atVar = atVar2;
                } else {
                    at atVar3 = new at();
                    atVar3.csN = new ArrayList();
                    atVar = atVar3;
                }
                d dVar2 = null;
                if (v.u(list) > 1) {
                    as asVar = new as();
                    asVar.csJ = 1;
                    asVar.name = getContext().getString(d.l.chosen_pb_title);
                    atVar.csN.add(asVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.cCh != 1 && dVar3.cCh != 302) {
                            as asVar2 = new as();
                            asVar2.csJ = dVar3.cCh;
                            asVar2.name = dVar3.name;
                            atVar.csN.add(asVar2);
                        }
                        if (dVar3 == null || dVar3.cCh != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.cFF = atVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.cFn = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cFs > 0 && list.size() == this.cFs) {
            layoutParams = new LinearLayout.LayoutParams(k.ae(getContext()) / this.cFs, -1);
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
            dVar.cCh = 1;
            dVar.name = getContext().getResources().getString(d.l.chosen_pb_title);
            this.cFl.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cFv);
            if (this.cFw != 0) {
                tabItemView.setSelectItemColorResId(this.cFw);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
            this.cFl.addView(tabItemView, layoutParams);
            this.cFo = tabItemView;
            tabItemView.setState(TabItemView.cFH);
            return;
        }
        setVisibility(0);
        if (this.mData == null || aV(list)) {
            this.mData = list;
            this.cFl.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cFv);
                        if (302 == dVar2.cCh) {
                            aj.c(tabItemView2, d.e.cp_cont_j, 1);
                        }
                        if (this.cFw != 0) {
                            tabItemView2.setSelectItemColorResId(this.cFw);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (jP(dVar2.cCh)) {
                            aj.i(tabItemView2, d.e.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
                        }
                        this.cFl.addView(tabItemView2, layoutParams);
                        if (dVar2.cCh == i) {
                            this.cFo = tabItemView2;
                            tabItemView2.setState(TabItemView.cFH);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d jL(int i) {
        if (i < 0 || this.cFn == null || this.cFn.size() == 0) {
            return null;
        }
        for (d dVar : this.cFn) {
            if (dVar != null && dVar.cCh == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean jM(int i) {
        d jL = jL(i);
        return (jL == null || jL.cFF == null || jL.cFF.csN == null || jL.cFF.csN.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cFp = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cFo != null) {
            this.mPaint.setColor(aj.getColor(d.e.cp_bg_line_b));
            if (this.cFt) {
                canvas.drawRect(this.cFl.getLeft(), getMeasuredHeight() - this.cFr, this.cFl.getRight() > getRight() ? this.cFl.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cFv) {
                if (this.cFw == 0) {
                    this.mPaint.setColor(aj.d((Resources) null, d.e.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(aj.d((Resources) null, this.cFw));
                }
                canvas.drawRect(this.cFo.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cFq, (this.cFo.getRight() - getBottomLineMargin()) - this.cFo.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cFv) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(aj.d((Resources) null, d.e.cp_cont_b));
            int f = k.f(getContext(), d.f.ds96);
            if (this.cFo != null) {
                f = this.cFo.getRight() - this.cFo.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(k.f(getContext(), d.f.ds32), k.f(getContext(), d.f.ds72), f, k.f(getContext(), d.f.ds76)), k.f(getContext(), d.f.ds4), k.f(getContext(), d.f.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cFo == null || this.cFk == 0) {
            return 0;
        }
        return ((this.cFo.getMeasuredWidth() - this.cFk) - this.cFo.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jN(int i) {
        c(jK(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.cFB = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cFC = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cFC;
    }

    public void setTabBackgroudColor(int i) {
        this.cFu = i;
    }

    public void xc() {
        aj.k(this, this.cFu);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cFl.getChildCount()) {
                View childAt = this.cFl.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (jP(((TabItemView) childAt).getTabId())) {
                        aj.i(childAt, d.e.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).xc();
                    }
                }
                i = i2 + 1;
            } else {
                this.cFm.xc();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cFs = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jO(int i) {
        if (this.cFo != null && this.cFB != null) {
            this.cFB.a(this.cFo.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cFx = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cFy = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cFv = z;
    }

    public static boolean jP(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cFt = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cFw = i;
    }
}
