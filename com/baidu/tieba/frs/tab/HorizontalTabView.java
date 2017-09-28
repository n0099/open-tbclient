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
    public int cGd;
    private final LinearLayout cGe;
    private final e cGf;
    private List<d> cGg;
    private TabItemView cGh;
    private com.baidu.tieba.frs.tab.b cGi;
    private final int cGj;
    private final int cGk;
    private int cGl;
    private boolean cGm;
    private int cGn;
    private boolean cGo;
    private int cGp;
    private a cGq;
    private b cGr;
    private e.b cGs;
    private e.a cGt;
    private aj cGu;
    private c cGv;
    private TbPageContext chH;
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
        void jt(int i);

        boolean ju(int i);
    }

    public void alA() {
        final au auVar;
        if (this.chH != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).cGy) != null && auVar.ctp != null) {
                for (at atVar : auVar.ctp) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.chH.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.ctp.size() > i && auVar.ctp.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.jS(auVar.ctp.get(i).ctl));
                        }
                    }
                });
                bVar.d(this.chH);
                bVar.tl();
            }
        }
    }

    public d jS(int i) {
        if (!v.u(this.cGg)) {
            for (d dVar : this.cGg) {
                if (dVar != null && dVar.cDa == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void c(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.cDa != 302 && this.cGr != null) {
                this.cGr.b(dVar);
            }
            if (dVar.cDa == 49) {
                TiebaStatic.log("c11841");
            }
            if (jX(dVar.cDa)) {
                if (this.cGu != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.ctH = dVar.url;
                    this.cGu.a(dVar.cDa, -1, aoVar);
                }
            } else if (dVar.cDa == 301 || dVar.cDa == 302) {
                if (this.cGu != null) {
                    this.cGu.a(dVar.cDa, -1, null);
                }
            } else {
                if (dVar.cDa != 49 || this.cGu == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.ctH = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.cGu.a(dVar.cDa, 0, aoVar2);
                    if (aoVar2.ctI) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cGe.getChildCount(); i++) {
                    View childAt = this.cGe.getChildAt(i);
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
                    aoVar3.ctH = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.cGu != null && z) {
                    this.cGu.a(dVar.cDa, 0, aoVar3);
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
            if (jX(tabItemView.getTabId())) {
                if (this.cGu != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.ctH = tabItemView.getUrl();
                    this.cGu.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cGu != null) {
                    this.cGu.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cGh = tabItemView;
                int[] iArr = new int[2];
                this.cGh.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.cGe.getChildCount(); i2++) {
                    View childAt = this.cGe.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cGh.getTabId() && !jX(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cGz);
                        }
                    }
                }
                if (this.cGh.getState() == TabItemView.cGz || this.cGh.getState() == TabItemView.cGB) {
                    this.cGf.alD();
                    boolean z2 = this.cGh.getState() == TabItemView.cGz;
                    this.cGh.setState(TabItemView.cGA);
                    d jT = jT(this.cGh.getTabId());
                    if (jT != null) {
                        if (!TextUtils.isEmpty(jT.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.ctH = jT.url;
                            aoVar3.stType = jT.name;
                            aoVar = aoVar3;
                        }
                        if (jT.cGy != null && jT.cGy.ctp != null && jT.cGy.ctp.size() > 0) {
                            for (at atVar : jT.cGy.ctp) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.ctl;
                                }
                            }
                        }
                        if (z2 && this.cGu != null) {
                            this.cGu.a(this.cGh.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (jU(this.cGh.getTabId()) && !z) {
                    if (this.cGv == null || this.cGv.ju(this.cGh.getTabId())) {
                        this.cGh.setState(TabItemView.cGB);
                        this.cGf.a((Activity) getContext(), this, this.cGh, jT(this.cGh.getTabId()).cGy);
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
        this.cGd = 0;
        this.cGh = null;
        this.cGi = null;
        this.mPaint = new Paint();
        this.cGj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cGk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cGl = 0;
        this.cGm = true;
        this.cGn = d.e.transparent;
        this.cGp = 0;
        this.cGs = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jY(int i) {
                if (HorizontalTabView.this.cGh != null && HorizontalTabView.this.cGu != null && HorizontalTabView.this.cGu != null) {
                    HorizontalTabView.this.cGu.a(HorizontalTabView.this.cGh.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cGi != null) {
                    HorizontalTabView.this.cGi.jW(i);
                }
            }
        };
        this.cGt = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cGo) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cGq != null) {
                                HorizontalTabView.this.cGq.a(HorizontalTabView.this.jS(1));
                            }
                            HorizontalTabView.this.alA();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cDa == 302) {
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
                if (HorizontalTabView.this.cGi != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jX(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cGh != null) {
                            HorizontalTabView.this.cGi.jV(HorizontalTabView.this.cGh.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cGi.jV(((TabItemView) view).getTabId());
                }
            }
        };
        this.chH = tbPageContext;
        this.cGe = new LinearLayout(tbPageContext.getPageActivity());
        this.cGe.setOrientation(0);
        this.cGe.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.f.ds88));
        this.cGf = new e(tbPageContext.getPageActivity(), this.cGs, this.cGt);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGd = 0;
        this.cGh = null;
        this.cGi = null;
        this.mPaint = new Paint();
        this.cGj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cGk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cGl = 0;
        this.cGm = true;
        this.cGn = d.e.transparent;
        this.cGp = 0;
        this.cGs = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jY(int i) {
                if (HorizontalTabView.this.cGh != null && HorizontalTabView.this.cGu != null && HorizontalTabView.this.cGu != null) {
                    HorizontalTabView.this.cGu.a(HorizontalTabView.this.cGh.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cGi != null) {
                    HorizontalTabView.this.cGi.jW(i);
                }
            }
        };
        this.cGt = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cGo) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cGq != null) {
                                HorizontalTabView.this.cGq.a(HorizontalTabView.this.jS(1));
                            }
                            HorizontalTabView.this.alA();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cDa == 302) {
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
                if (HorizontalTabView.this.cGi != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jX(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cGh != null) {
                            HorizontalTabView.this.cGi.jV(HorizontalTabView.this.cGh.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cGi.jV(((TabItemView) view).getTabId());
                }
            }
        };
        this.cGe = new LinearLayout(context);
        this.cGe.setOrientation(0);
        this.cGe.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.f.ds88));
        this.cGf = new e(context, this.cGs, this.cGt);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cGd = 0;
        this.cGh = null;
        this.cGi = null;
        this.mPaint = new Paint();
        this.cGj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds6);
        this.cGk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds1);
        this.cGl = 0;
        this.cGm = true;
        this.cGn = d.e.transparent;
        this.cGp = 0;
        this.cGs = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void jY(int i2) {
                if (HorizontalTabView.this.cGh != null && HorizontalTabView.this.cGu != null && HorizontalTabView.this.cGu != null) {
                    HorizontalTabView.this.cGu.a(HorizontalTabView.this.cGh.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cGi != null) {
                    HorizontalTabView.this.cGi.jW(i2);
                }
            }
        };
        this.cGt = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cGo) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cGq != null) {
                                HorizontalTabView.this.cGq.a(HorizontalTabView.this.jS(1));
                            }
                            HorizontalTabView.this.alA();
                            return;
                        } else if (((TabItemView) view).getTabId() == 302) {
                            Iterator it = HorizontalTabView.this.mData.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it.next();
                                if (dVar.cDa == 302) {
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
                if (HorizontalTabView.this.cGi != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.jX(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cGh != null) {
                            HorizontalTabView.this.cGi.jV(HorizontalTabView.this.cGh.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cGi.jV(((TabItemView) view).getTabId());
                }
            }
        };
        this.cGe = new LinearLayout(activity);
        this.cGe.setOrientation(0);
        this.cGe.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cGf = new e(activity, this.cGs, this.cGt);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cGe, layoutParams);
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
        d jT = jT(1);
        Iterator<d> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            d next = it.next();
            if (next != null && next.cDa == 1) {
                dVar = next;
                break;
            }
        }
        if (jT == null || dVar == null) {
            return false;
        }
        if (jT.cGy == null && dVar.cGy == null) {
            return false;
        }
        if ((jT.cGy != null || dVar.cGy == null) && (dVar.cGy != null || jT.cGy == null)) {
            if (jT.cGy == null || dVar.cGy == null) {
                return false;
            }
            if (jT.cGy.ctp == null && dVar.cGy.ctp == null) {
                return false;
            }
            if ((jT.cGy.ctp != null || dVar.cGy.ctp == null) && (dVar.cGy.ctp != null || jT.cGy.ctp == null)) {
                int size = jT.cGy.ctp.size();
                if (size != dVar.cGy.ctp.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.cGy.ctp.get(i);
                    at atVar2 = jT.cGy.ctp.get(i);
                    if (atVar.ctl != atVar2.ctl || !atVar.name.equals(atVar2.name)) {
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
        if (this.cGo) {
            this.cGg = new ArrayList();
            this.cGg.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.cDa == 1) {
                au auVar2 = dVar.cGy;
                if (auVar2 != null && auVar2.ctp != null) {
                    auVar2.ctp.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.ctp = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.t(list) > 1) {
                    at atVar = new at();
                    atVar.ctl = 1;
                    atVar.name = getContext().getString(d.l.chosen_pb_title);
                    auVar.ctp.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.cDa != 1 && dVar3.cDa != 302) {
                            at atVar2 = new at();
                            atVar2.ctl = dVar3.cDa;
                            atVar2.name = dVar3.name;
                            auVar.ctp.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.cDa != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.cGy = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.cGg = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cGl > 0 && list.size() == this.cGl) {
            layoutParams = new LinearLayout.LayoutParams(l.ad(getContext()) / this.cGl, -1);
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
            dVar.cDa = 1;
            dVar.name = getContext().getResources().getString(d.l.chosen_pb_title);
            this.cGe.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cGo);
            if (this.cGp != 0) {
                tabItemView.setSelectItemColorResId(this.cGp);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
            this.cGe.addView(tabItemView, layoutParams);
            this.cGh = tabItemView;
            tabItemView.setState(TabItemView.cGA);
            return;
        }
        setVisibility(0);
        if (this.mData == null || aV(list)) {
            this.mData = list;
            this.cGe.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cGo);
                        if (302 == dVar2.cDa) {
                            com.baidu.tbadk.core.util.aj.c(tabItemView2, d.e.cp_cont_j, 1);
                        }
                        if (this.cGp != 0) {
                            tabItemView2.setSelectItemColorResId(this.cGp);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (jX(dVar2.cDa)) {
                            com.baidu.tbadk.core.util.aj.i(tabItemView2, d.e.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.f.ds32);
                        }
                        this.cGe.addView(tabItemView2, layoutParams);
                        if (dVar2.cDa == i) {
                            this.cGh = tabItemView2;
                            tabItemView2.setState(TabItemView.cGA);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d jT(int i) {
        if (i < 0 || this.cGg == null || this.cGg.size() == 0) {
            return null;
        }
        for (d dVar : this.cGg) {
            if (dVar != null && dVar.cDa == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean jU(int i) {
        d jT = jT(i);
        return (jT == null || jT.cGy == null || jT.cGy.ctp == null || jT.cGy.ctp.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cGi = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cGh != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.aj.getColor(d.e.cp_bg_line_b));
            if (this.cGm) {
                canvas.drawRect(this.cGe.getLeft(), getMeasuredHeight() - this.cGk, this.cGe.getRight() > getRight() ? this.cGe.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cGo) {
                if (this.cGp == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, d.e.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, this.cGp));
                }
                canvas.drawRect(this.cGh.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cGj, (this.cGh.getRight() - getBottomLineMargin()) - this.cGh.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cGo) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, d.e.cp_cont_b));
            int f = l.f(getContext(), d.f.ds96);
            if (this.cGh != null) {
                f = this.cGh.getRight() - this.cGh.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.f(getContext(), d.f.ds32), l.f(getContext(), d.f.ds72), f, l.f(getContext(), d.f.ds76)), l.f(getContext(), d.f.ds4), l.f(getContext(), d.f.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cGh == null || this.cGd == 0) {
            return 0;
        }
        return ((this.cGh.getMeasuredWidth() - this.cGd) - this.cGh.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jV(int i) {
        c(jS(i));
    }

    public void setDataLoadInterface(aj ajVar) {
        this.cGu = ajVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cGv = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cGv;
    }

    public void setTabBackgroudColor(int i) {
        this.cGn = i;
    }

    public void wB() {
        com.baidu.tbadk.core.util.aj.k(this, this.cGn);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cGe.getChildCount()) {
                View childAt = this.cGe.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (jX(((TabItemView) childAt).getTabId())) {
                        com.baidu.tbadk.core.util.aj.i(childAt, d.e.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).wB();
                    }
                }
                i = i2 + 1;
            } else {
                this.cGf.wB();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cGl = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void jW(int i) {
        if (this.cGh != null && this.cGu != null) {
            this.cGu.a(this.cGh.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cGq = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cGr = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cGo = z;
    }

    public static boolean jX(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cGm = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cGp = i;
    }
}
