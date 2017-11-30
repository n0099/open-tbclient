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
    public int cYN;
    private final LinearLayout cYO;
    private final e cYP;
    private List<d> cYQ;
    private TabItemView cYR;
    private com.baidu.tieba.frs.tab.b cYS;
    private final int cYT;
    private final int cYU;
    private int cYV;
    private boolean cYW;
    private int cYX;
    private boolean cYY;
    private int cYZ;
    private a cZa;
    private b cZb;
    private e.b cZc;
    private e.a cZd;
    private aj cZe;
    private c cZf;
    private TbPageContext cxV;
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
        void kg(int i);

        boolean kh(int i);
    }

    public void aqp() {
        final au auVar;
        if (this.cxV != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).cZi) != null && auVar.cJX != null) {
                for (at atVar : auVar.cJX) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cxV.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0047b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0047b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.cJX.size() > i && auVar.cJX.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.kL(auVar.cJX.get(i).cJT));
                        }
                    }
                });
                bVar.d(this.cxV);
                bVar.to();
            }
        }
    }

    public d kL(int i) {
        if (!v.w(this.cYQ)) {
            for (d dVar : this.cYQ) {
                if (dVar != null && dVar.tabId == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void c(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.tabId != 302 && this.cZb != null) {
                this.cZb.b(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (kQ(dVar.tabId)) {
                if (this.cZe != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.cKn = dVar.url;
                    this.cZe.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.cZe != null) {
                    this.cZe.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.cZe == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.cKn = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.cZe.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.cKo) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cYO.getChildCount(); i++) {
                    View childAt = this.cYO.getChildAt(i);
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
                    aoVar3.cKn = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.cZe != null && z) {
                    this.cZe.a(dVar.tabId, 0, aoVar3);
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
            if (kQ(tabItemView.getTabId())) {
                if (this.cZe != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.cKn = tabItemView.getUrl();
                    this.cZe.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cZe != null) {
                    this.cZe.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cYR = tabItemView;
                int[] iArr = new int[2];
                this.cYR.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.cYO.getChildCount(); i2++) {
                    View childAt = this.cYO.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cYR.getTabId() && !kQ(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cZj);
                        }
                    }
                }
                if (this.cYR.getState() == TabItemView.cZj || this.cYR.getState() == TabItemView.cZl) {
                    this.cYP.aqs();
                    boolean z2 = this.cYR.getState() == TabItemView.cZj;
                    this.cYR.setState(TabItemView.cZk);
                    d kM = kM(this.cYR.getTabId());
                    if (kM != null) {
                        if (!TextUtils.isEmpty(kM.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.cKn = kM.url;
                            aoVar3.stType = kM.name;
                            aoVar = aoVar3;
                        }
                        if (kM.cZi != null && kM.cZi.cJX != null && kM.cZi.cJX.size() > 0) {
                            for (at atVar : kM.cZi.cJX) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.cJT;
                                }
                            }
                        }
                        if (z2 && this.cZe != null) {
                            this.cZe.a(this.cYR.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (kN(this.cYR.getTabId()) && !z) {
                    if (this.cZf == null || this.cZf.kh(this.cYR.getTabId())) {
                        this.cYR.setState(TabItemView.cZl);
                        this.cYP.a((Activity) getContext(), this, this.cYR, kM(this.cYR.getTabId()).cZi);
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
        this.cYN = 0;
        this.cYR = null;
        this.cYS = null;
        this.mPaint = new Paint();
        this.cYT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cYU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cYV = 0;
        this.cYW = true;
        this.cYX = d.C0082d.transparent;
        this.cYZ = 0;
        this.cZc = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kR(int i) {
                if (HorizontalTabView.this.cYR != null && HorizontalTabView.this.cZe != null && HorizontalTabView.this.cZe != null) {
                    HorizontalTabView.this.cZe.a(HorizontalTabView.this.cYR.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cYS != null) {
                    HorizontalTabView.this.cYS.kP(i);
                }
            }
        };
        this.cZd = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cYY) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cZa != null) {
                                HorizontalTabView.this.cZa.a(HorizontalTabView.this.kL(1));
                            }
                            HorizontalTabView.this.aqp();
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
                if (HorizontalTabView.this.cYS != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.kQ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cYR != null) {
                            HorizontalTabView.this.cYS.kO(HorizontalTabView.this.cYR.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cYS.kO(((TabItemView) view).getTabId());
                }
            }
        };
        this.cxV = tbPageContext;
        this.cYO = new LinearLayout(tbPageContext.getPageActivity());
        this.cYO.setOrientation(0);
        this.cYO.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.e.ds88));
        this.cYP = new e(tbPageContext.getPageActivity(), this.cZc, this.cZd);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cYN = 0;
        this.cYR = null;
        this.cYS = null;
        this.mPaint = new Paint();
        this.cYT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cYU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cYV = 0;
        this.cYW = true;
        this.cYX = d.C0082d.transparent;
        this.cYZ = 0;
        this.cZc = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kR(int i) {
                if (HorizontalTabView.this.cYR != null && HorizontalTabView.this.cZe != null && HorizontalTabView.this.cZe != null) {
                    HorizontalTabView.this.cZe.a(HorizontalTabView.this.cYR.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cYS != null) {
                    HorizontalTabView.this.cYS.kP(i);
                }
            }
        };
        this.cZd = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cYY) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cZa != null) {
                                HorizontalTabView.this.cZa.a(HorizontalTabView.this.kL(1));
                            }
                            HorizontalTabView.this.aqp();
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
                if (HorizontalTabView.this.cYS != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.kQ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cYR != null) {
                            HorizontalTabView.this.cYS.kO(HorizontalTabView.this.cYR.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cYS.kO(((TabItemView) view).getTabId());
                }
            }
        };
        this.cYO = new LinearLayout(context);
        this.cYO.setOrientation(0);
        this.cYO.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.cYP = new e(context, this.cZc, this.cZd);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cYN = 0;
        this.cYR = null;
        this.cYS = null;
        this.mPaint = new Paint();
        this.cYT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cYU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cYV = 0;
        this.cYW = true;
        this.cYX = d.C0082d.transparent;
        this.cYZ = 0;
        this.cZc = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kR(int i2) {
                if (HorizontalTabView.this.cYR != null && HorizontalTabView.this.cZe != null && HorizontalTabView.this.cZe != null) {
                    HorizontalTabView.this.cZe.a(HorizontalTabView.this.cYR.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cYS != null) {
                    HorizontalTabView.this.cYS.kP(i2);
                }
            }
        };
        this.cZd = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cYY) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cZa != null) {
                                HorizontalTabView.this.cZa.a(HorizontalTabView.this.kL(1));
                            }
                            HorizontalTabView.this.aqp();
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
                if (HorizontalTabView.this.cYS != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.kQ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cYR != null) {
                            HorizontalTabView.this.cYS.kO(HorizontalTabView.this.cYR.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cYS.kO(((TabItemView) view).getTabId());
                }
            }
        };
        this.cYO = new LinearLayout(activity);
        this.cYO.setOrientation(0);
        this.cYO.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cYP = new e(activity, this.cZc, this.cZd);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cYO, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        com.baidu.tbadk.core.util.aj.k(this, d.C0082d.transparent);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean bk(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d kM = kM(1);
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
        if (kM == null || dVar == null) {
            return false;
        }
        if (kM.cZi == null && dVar.cZi == null) {
            return false;
        }
        if ((kM.cZi != null || dVar.cZi == null) && (dVar.cZi != null || kM.cZi == null)) {
            if (kM.cZi == null || dVar.cZi == null) {
                return false;
            }
            if (kM.cZi.cJX == null && dVar.cZi.cJX == null) {
                return false;
            }
            if ((kM.cZi.cJX != null || dVar.cZi.cJX == null) && (dVar.cZi.cJX != null || kM.cZi.cJX == null)) {
                int size = kM.cZi.cJX.size();
                if (size != dVar.cZi.cJX.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.cZi.cJX.get(i);
                    at atVar2 = kM.cZi.cJX.get(i);
                    if (atVar.cJT != atVar2.cJT || !atVar.name.equals(atVar2.name)) {
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
        if (this.cYY) {
            this.cYQ = new ArrayList();
            this.cYQ.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.cZi;
                if (auVar2 != null && auVar2.cJX != null) {
                    auVar2.cJX.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.cJX = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.v(list) > 1) {
                    at atVar = new at();
                    atVar.cJT = 1;
                    atVar.name = getContext().getString(d.j.chosen_pb_title);
                    auVar.cJX.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.cJT = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.cJX.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.cZi = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.cYQ = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cYV > 0 && list.size() == this.cYV) {
            layoutParams = new LinearLayout.LayoutParams(l.ac(getContext()) / this.cYV, -1);
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
            dVar.tabId = 1;
            dVar.name = getContext().getResources().getString(d.j.chosen_pb_title);
            this.cYO.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cYY);
            if (this.cYZ != 0) {
                tabItemView.setSelectItemColorResId(this.cYZ);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.cYO.addView(tabItemView, layoutParams);
            this.cYR = tabItemView;
            tabItemView.setState(TabItemView.cZk);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bk(list)) {
            this.mData = list;
            this.cYO.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cYY);
                        if (302 == dVar2.tabId) {
                            com.baidu.tbadk.core.util.aj.c(tabItemView2, d.C0082d.cp_cont_j, 1);
                        }
                        if (this.cYZ != 0) {
                            tabItemView2.setSelectItemColorResId(this.cYZ);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (kQ(dVar2.tabId)) {
                            com.baidu.tbadk.core.util.aj.i(tabItemView2, d.C0082d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.cYO.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.cYR = tabItemView2;
                            tabItemView2.setState(TabItemView.cZk);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d kM(int i) {
        if (i < 0 || this.cYQ == null || this.cYQ.size() == 0) {
            return null;
        }
        for (d dVar : this.cYQ) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean kN(int i) {
        d kM = kM(i);
        return (kM == null || kM.cZi == null || kM.cZi.cJX == null || kM.cZi.cJX.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cYS = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cYR != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.aj.getColor(d.C0082d.cp_bg_line_b));
            if (this.cYW) {
                canvas.drawRect(this.cYO.getLeft(), getMeasuredHeight() - this.cYU, this.cYO.getRight() > getRight() ? this.cYO.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cYY) {
                if (this.cYZ == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, d.C0082d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, this.cYZ));
                }
                canvas.drawRect(this.cYR.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cYT, (this.cYR.getRight() - getBottomLineMargin()) - this.cYR.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cYY) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.aj.d((Resources) null, d.C0082d.cp_cont_b));
            int f = l.f(getContext(), d.e.ds96);
            if (this.cYR != null) {
                f = this.cYR.getRight() - this.cYR.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.f(getContext(), d.e.tbds44), l.f(getContext(), d.e.tbds98), f, l.f(getContext(), d.e.tbds104)), l.f(getContext(), d.e.tbds6), l.f(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cYR == null || this.cYN == 0) {
            return 0;
        }
        return ((this.cYR.getMeasuredWidth() - this.cYN) - this.cYR.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void kO(int i) {
        c(kL(i));
    }

    public void setDataLoadInterface(aj ajVar) {
        this.cZe = ajVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cZf = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cZf;
    }

    public void setTabBackgroudColor(int i) {
        this.cYX = i;
    }

    public void wE() {
        com.baidu.tbadk.core.util.aj.k(this, this.cYX);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cYO.getChildCount()) {
                View childAt = this.cYO.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (kQ(((TabItemView) childAt).getTabId())) {
                        com.baidu.tbadk.core.util.aj.i(childAt, d.C0082d.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).wE();
                    }
                }
                i = i2 + 1;
            } else {
                this.cYP.wE();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cYV = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void kP(int i) {
        if (this.cYR != null && this.cZe != null) {
            this.cZe.a(this.cYR.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cZa = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cZb = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cYY = z;
    }

    public static boolean kQ(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cYW = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cYZ = i;
    }
}
