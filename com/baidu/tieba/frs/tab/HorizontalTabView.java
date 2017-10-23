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
    public int cFR;
    private final LinearLayout cFS;
    private final e cFT;
    private List<d> cFU;
    private TabItemView cFV;
    private com.baidu.tieba.frs.tab.b cFW;
    private final int cFX;
    private final int cFY;
    private int cFZ;
    private boolean cGa;
    private int cGb;
    private boolean cGc;
    private int cGd;
    private a cGe;
    private b cGf;
    private e.b cGg;
    private e.a cGh;
    private aj cGi;
    private c cGj;
    private TbPageContext chv;
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
        void js(int i);

        boolean jt(int i);
    }

    public void alv() {
        final au auVar;
        if (this.chv != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).cGm) != null && auVar.ctd != null) {
                for (at atVar : auVar.ctd) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.chv.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.ctd.size() > i && auVar.ctd.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.jR(auVar.ctd.get(i).csZ));
                        }
                    }
                });
                bVar.d(this.chv);
                bVar.te();
            }
        }
    }

    public d jR(int i) {
        if (!v.u(this.cFU)) {
            for (d dVar : this.cFU) {
                if (dVar != null && dVar.cCO == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void c(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.cCO != 302 && this.cGf != null) {
                this.cGf.b(dVar);
            }
            if (dVar.cCO == 49) {
                TiebaStatic.log("c11841");
            }
            if (jW(dVar.cCO)) {
                if (this.cGi != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.ctu = dVar.url;
                    this.cGi.a(dVar.cCO, -1, aoVar);
                }
            } else if (dVar.cCO == 301 || dVar.cCO == 302) {
                if (this.cGi != null) {
                    this.cGi.a(dVar.cCO, -1, null);
                }
            } else {
                if (dVar.cCO != 49 || this.cGi == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.ctu = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.cGi.a(dVar.cCO, 0, aoVar2);
                    if (aoVar2.ctv) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cFS.getChildCount(); i++) {
                    View childAt = this.cFS.getChildAt(i);
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
                    aoVar3.ctu = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.cGi != null && z) {
                    this.cGi.a(dVar.cCO, 0, aoVar3);
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
            if (jW(tabItemView.getTabId())) {
                if (this.cGi != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.ctu = tabItemView.getUrl();
                    this.cGi.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cGi != null) {
                    this.cGi.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cFV = tabItemView;
                int[] iArr = new int[2];
                this.cFV.getLocationOnScreen(iArr);
                int ad = l.ad(getContext()) - iArr[0];
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
                for (int i2 = 0; i2 < this.cFS.getChildCount(); i2++) {
                    View childAt = this.cFS.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cFV.getTabId() && !jW(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cGn);
                        }
                    }
                }
                if (this.cFV.getState() == TabItemView.cGn || this.cFV.getState() == TabItemView.cGp) {
                    this.cFT.aly();
                    boolean z2 = this.cFV.getState() == TabItemView.cGn;
                    this.cFV.setState(TabItemView.cGo);
                    d jS = jS(this.cFV.getTabId());
                    if (jS != null) {
                        if (!TextUtils.isEmpty(jS.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.ctu = jS.url;
                            aoVar3.stType = jS.name;
                            aoVar = aoVar3;
                        }
                        if (jS.cGm != null && jS.cGm.ctd != null && jS.cGm.ctd.size() > 0) {
                            for (at atVar : jS.cGm.ctd) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.csZ;
                                }
                            }
                        }
                        if (z2 && this.cGi != null) {
                            this.cGi.a(this.cFV.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (jT(this.cFV.getTabId()) && !z) {
                    if (this.cGj == null || this.cGj.jt(this.cFV.getTabId())) {
                        this.cFV.setState(TabItemView.cGp);
                        this.cFT.a((Activity) getContext(), this, this.cFV, jS(this.cFV.getTabId()).cGm);
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
        this.cFR = 0;
        this.cFV = null;
        this.cFW = null;
        this.mPaint = new Paint();
        this.cFX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cFY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cFZ = 0;
        this.cGa = true;
        this.cGb = d.e.transparent;
        this.cGd = 0;
        this.cGg = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jX(int i) {
                if (HorizontalTabView.this.cFV != null && HorizontalTabView.this.cGi != null && HorizontalTabView.this.cGi != null) {
                    HorizontalTabView.this.cGi.a(HorizontalTabView.this.cFV.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cFW != null) {
                    HorizontalTabView.this.cFW.jV(i);
                }
            }
        };
        this.cGh = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cGc) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cGe != null) {
                                HorizontalTabView.this.cGe.a(HorizontalTabView.this.jR(1));
                            }
                            HorizontalTabView.this.alv();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cCO == 302) {
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
                if (HorizontalTabView.this.cFW != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jW(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cFV != null) {
                            HorizontalTabView.this.cFW.jU(HorizontalTabView.this.cFV.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cFW.jU(((TabItemView) view).getTabId());
                }
            }
        };
        this.chv = tbPageContext;
        this.cFS = new LinearLayout(tbPageContext.getPageActivity());
        this.cFS.setOrientation(0);
        this.cFS.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.f.ds88));
        this.cFT = new e(tbPageContext.getPageActivity(), this.cGg, this.cGh);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cFR = 0;
        this.cFV = null;
        this.cFW = null;
        this.mPaint = new Paint();
        this.cFX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cFY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cFZ = 0;
        this.cGa = true;
        this.cGb = d.e.transparent;
        this.cGd = 0;
        this.cGg = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jX(int i) {
                if (HorizontalTabView.this.cFV != null && HorizontalTabView.this.cGi != null && HorizontalTabView.this.cGi != null) {
                    HorizontalTabView.this.cGi.a(HorizontalTabView.this.cFV.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cFW != null) {
                    HorizontalTabView.this.cFW.jV(i);
                }
            }
        };
        this.cGh = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cGc) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cGe != null) {
                                HorizontalTabView.this.cGe.a(HorizontalTabView.this.jR(1));
                            }
                            HorizontalTabView.this.alv();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cCO == 302) {
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
                if (HorizontalTabView.this.cFW != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jW(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cFV != null) {
                            HorizontalTabView.this.cFW.jU(HorizontalTabView.this.cFV.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cFW.jU(((TabItemView) view).getTabId());
                }
            }
        };
        this.cFS = new LinearLayout(context);
        this.cFS.setOrientation(0);
        this.cFS.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.f.ds88));
        this.cFT = new e(context, this.cGg, this.cGh);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cFR = 0;
        this.cFV = null;
        this.cFW = null;
        this.mPaint = new Paint();
        this.cFX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cFY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cFZ = 0;
        this.cGa = true;
        this.cGb = d.e.transparent;
        this.cGd = 0;
        this.cGg = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jX(int i2) {
                if (HorizontalTabView.this.cFV != null && HorizontalTabView.this.cGi != null && HorizontalTabView.this.cGi != null) {
                    HorizontalTabView.this.cGi.a(HorizontalTabView.this.cFV.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cFW != null) {
                    HorizontalTabView.this.cFW.jV(i2);
                }
            }
        };
        this.cGh = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cGc) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cGe != null) {
                                HorizontalTabView.this.cGe.a(HorizontalTabView.this.jR(1));
                            }
                            HorizontalTabView.this.alv();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cCO == 302) {
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
                if (HorizontalTabView.this.cFW != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jW(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cFV != null) {
                            HorizontalTabView.this.cFW.jU(HorizontalTabView.this.cFV.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cFW.jU(((TabItemView) view).getTabId());
                }
            }
        };
        this.cFS = new LinearLayout(activity);
        this.cFS.setOrientation(0);
        this.cFS.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cFT = new e(activity, this.cGg, this.cGh);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cFS, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        com.baidu.tbadk.core.util.aj.k(this, d.e.transparent);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aV(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d jS = jS(1);
        Iterator<d> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            d next = it.next();
            if (next != null && next.cCO == 1) {
                dVar = next;
                break;
            }
        }
        if (jS == null || dVar == null) {
            return false;
        }
        if (jS.cGm == null && dVar.cGm == null) {
            return false;
        }
        if ((jS.cGm != null || dVar.cGm == null) && (dVar.cGm != null || jS.cGm == null)) {
            if (jS.cGm == null || dVar.cGm == null) {
                return false;
            }
            if (jS.cGm.ctd == null && dVar.cGm.ctd == null) {
                return false;
            }
            if ((jS.cGm.ctd != null || dVar.cGm.ctd == null) && (dVar.cGm.ctd != null || jS.cGm.ctd == null)) {
                int size = jS.cGm.ctd.size();
                if (size != dVar.cGm.ctd.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.cGm.ctd.get(i);
                    at atVar2 = jS.cGm.ctd.get(i);
                    if (atVar.csZ != atVar2.csZ || !atVar.name.equals(atVar2.name)) {
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
        if (this.cGc) {
            this.cFU = new ArrayList();
            this.cFU.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.cCO == 1) {
                au auVar2 = dVar.cGm;
                if (auVar2 != null && auVar2.ctd != null) {
                    auVar2.ctd.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.ctd = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.t(list) > 1) {
                    at atVar = new at();
                    atVar.csZ = 1;
                    atVar.name = getContext().getString(d.l.chosen_pb_title);
                    auVar.ctd.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.cCO != 1 && dVar3.cCO != 302) {
                            at atVar2 = new at();
                            atVar2.csZ = dVar3.cCO;
                            atVar2.name = dVar3.name;
                            auVar.ctd.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.cCO != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.cGm = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.cFU = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cFZ > 0 && list.size() == this.cFZ) {
            layoutParams = new LinearLayout.LayoutParams(l.ad(getContext()) / this.cFZ, -1);
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
            dVar.cCO = 1;
            dVar.name = getContext().getResources().getString(d.l.chosen_pb_title);
            this.cFS.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cGc);
            if (this.cGd != 0) {
                tabItemView.setSelectItemColorResId(this.cGd);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
            this.cFS.addView(tabItemView, layoutParams);
            this.cFV = tabItemView;
            tabItemView.setState(TabItemView.cGo);
            return;
        }
        setVisibility(0);
        if (this.mData == null || aV(list)) {
            this.mData = list;
            this.cFS.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cGc);
                        if (302 == dVar2.cCO) {
                            com.baidu.tbadk.core.util.aj.c(tabItemView2, d.e.cp_cont_j, 1);
                        }
                        if (this.cGd != 0) {
                            tabItemView2.setSelectItemColorResId(this.cGd);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (jW(dVar2.cCO)) {
                            com.baidu.tbadk.core.util.aj.i(tabItemView2, d.e.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
                        }
                        this.cFS.addView(tabItemView2, layoutParams);
                        if (dVar2.cCO == i) {
                            this.cFV = tabItemView2;
                            tabItemView2.setState(TabItemView.cGo);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d jS(int i) {
        if (i < 0 || this.cFU == null || this.cFU.size() == 0) {
            return null;
        }
        for (d dVar : this.cFU) {
            if (dVar != null && dVar.cCO == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean jT(int i) {
        d jS = jS(i);
        return (jS == null || jS.cGm == null || jS.cGm.ctd == null || jS.cGm.ctd.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cFW = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cFV != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_bg_line_b));
            if (this.cGa) {
                canvas.drawRect(this.cFS.getLeft(), getMeasuredHeight() - this.cFY, this.cFS.getRight() > getRight() ? this.cFS.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cGc) {
                if (this.cGd == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, d.e.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, this.cGd));
                }
                canvas.drawRect(this.cFV.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cFX, (this.cFV.getRight() - getBottomLineMargin()) - this.cFV.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cGc) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, d.e.cp_cont_b));
            int f = l.f(getContext(), d.f.ds96);
            if (this.cFV != null) {
                f = this.cFV.getRight() - this.cFV.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.f(getContext(), d.f.ds32), l.f(getContext(), d.f.ds72), f, l.f(getContext(), d.f.ds76)), l.f(getContext(), d.f.ds4), l.f(getContext(), d.f.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cFV == null || this.cFR == 0) {
            return 0;
        }
        return ((this.cFV.getMeasuredWidth() - this.cFR) - this.cFV.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jU(int i) {
        c(jR(i));
    }

    public void setDataLoadInterface(aj ajVar) {
        this.cGi = ajVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cGj = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cGj;
    }

    public void setTabBackgroudColor(int i) {
        this.cGb = i;
    }

    public void wu() {
        com.baidu.tbadk.core.util.aj.k(this, this.cGb);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cFS.getChildCount()) {
                View childAt = this.cFS.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (jW(((TabItemView) childAt).getTabId())) {
                        com.baidu.tbadk.core.util.aj.i(childAt, d.e.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).wu();
                    }
                }
                i = i2 + 1;
            } else {
                this.cFT.wu();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cFZ = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jV(int i) {
        if (this.cFV != null && this.cGi != null) {
            this.cGi.a(this.cFV.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cGe = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cGf = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cGc = z;
    }

    public static boolean jW(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cGa = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cGd = i;
    }
}
