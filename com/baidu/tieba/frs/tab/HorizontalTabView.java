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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.horizonalScrollListView.b implements com.baidu.tieba.frs.tab.b {
    public int cYZ;
    private final LinearLayout cZa;
    private final e cZb;
    private List<d> cZc;
    private TabItemView cZd;
    private com.baidu.tieba.frs.tab.b cZe;
    private final int cZf;
    private final int cZg;
    private int cZh;
    private boolean cZi;
    private int cZj;
    private boolean cZk;
    private int cZl;
    private a cZm;
    private b cZn;
    private e.b cZo;
    private e.a cZp;
    private ak cZq;
    private c cZr;
    private TbPageContext cyd;
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
        void ki(int i);

        boolean kj(int i);
    }

    public void aqx() {
        final av avVar;
        if (this.cyd != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (avVar = this.mData.get(0).cZu) != null && avVar.cKh != null) {
                for (au auVar : avVar.cKh) {
                    if (auVar != null) {
                        arrayList.add(auVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cyd.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0061b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0061b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (avVar.cKh.size() > i && avVar.cKh.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.kN(avVar.cKh.get(i).cKd));
                        }
                    }
                });
                bVar.d(this.cyd);
                bVar.tl();
            }
        }
    }

    public d kN(int i) {
        if (!v.w(this.cZc)) {
            for (d dVar : this.cZc) {
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
            if (dVar.tabId != 302 && this.cZn != null) {
                this.cZn.b(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (kS(dVar.tabId)) {
                if (this.cZq != null && !TextUtils.isEmpty(dVar.url)) {
                    ap apVar = new ap();
                    apVar.cKx = dVar.url;
                    this.cZq.a(dVar.tabId, -1, apVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.cZq != null) {
                    this.cZq.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.cZq == null) {
                    z = true;
                } else {
                    ap apVar2 = new ap();
                    apVar2.cKx = dVar.url;
                    apVar2.stType = dVar.name;
                    this.cZq.a(dVar.tabId, 0, apVar2);
                    if (apVar2.cKy) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cZa.getChildCount(); i++) {
                    View childAt = this.cZa.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                ap apVar3 = null;
                if (!TextUtils.isEmpty(dVar.url)) {
                    apVar3 = new ap();
                    apVar3.cKx = dVar.url;
                    apVar3.stType = dVar.name;
                }
                if (this.cZq != null && z) {
                    this.cZq.a(dVar.tabId, 0, apVar3);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ap apVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (kS(tabItemView.getTabId())) {
                if (this.cZq != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ap apVar2 = new ap();
                    apVar2.cKx = tabItemView.getUrl();
                    this.cZq.a(tabItemView.getTabId(), -1, apVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cZq != null) {
                    this.cZq.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cZd = tabItemView;
                int[] iArr = new int[2];
                this.cZd.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.cZa.getChildCount(); i2++) {
                    View childAt = this.cZa.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cZd.getTabId() && !kS(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cZv);
                        }
                    }
                }
                if (this.cZd.getState() == TabItemView.cZv || this.cZd.getState() == TabItemView.cZx) {
                    this.cZb.aqA();
                    boolean z2 = this.cZd.getState() == TabItemView.cZv;
                    this.cZd.setState(TabItemView.cZw);
                    d kO = kO(this.cZd.getTabId());
                    if (kO != null) {
                        if (!TextUtils.isEmpty(kO.url)) {
                            ap apVar3 = new ap();
                            apVar3.cKx = kO.url;
                            apVar3.stType = kO.name;
                            apVar = apVar3;
                        }
                        if (kO.cZu != null && kO.cZu.cKh != null && kO.cZu.cKh.size() > 0) {
                            for (au auVar : kO.cZu.cKh) {
                                if (auVar != null && auVar.isSelected) {
                                    i = auVar.cKd;
                                }
                            }
                        }
                        if (z2 && this.cZq != null) {
                            this.cZq.a(this.cZd.getTabId(), i, apVar);
                        }
                    } else {
                        return;
                    }
                } else if (kP(this.cZd.getTabId()) && !z) {
                    if (this.cZr == null || this.cZr.kj(this.cZd.getTabId())) {
                        this.cZd.setState(TabItemView.cZx);
                        this.cZb.a((Activity) getContext(), this, this.cZd, kO(this.cZd.getTabId()).cZu);
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
        this.cYZ = 0;
        this.cZd = null;
        this.cZe = null;
        this.mPaint = new Paint();
        this.cZf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cZg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cZh = 0;
        this.cZi = true;
        this.cZj = d.C0096d.transparent;
        this.cZl = 0;
        this.cZo = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kT(int i) {
                if (HorizontalTabView.this.cZd != null && HorizontalTabView.this.cZq != null && HorizontalTabView.this.cZq != null) {
                    HorizontalTabView.this.cZq.a(HorizontalTabView.this.cZd.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cZe != null) {
                    HorizontalTabView.this.cZe.kR(i);
                }
            }
        };
        this.cZp = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cZk) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cZm != null) {
                                HorizontalTabView.this.cZm.a(HorizontalTabView.this.kN(1));
                            }
                            HorizontalTabView.this.aqx();
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
                if (HorizontalTabView.this.cZe != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.kS(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cZd != null) {
                            HorizontalTabView.this.cZe.kQ(HorizontalTabView.this.cZd.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cZe.kQ(((TabItemView) view).getTabId());
                }
            }
        };
        this.cyd = tbPageContext;
        this.cZa = new LinearLayout(tbPageContext.getPageActivity());
        this.cZa.setOrientation(0);
        this.cZa.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.e.ds88));
        this.cZb = new e(tbPageContext.getPageActivity(), this.cZo, this.cZp);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cYZ = 0;
        this.cZd = null;
        this.cZe = null;
        this.mPaint = new Paint();
        this.cZf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cZg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cZh = 0;
        this.cZi = true;
        this.cZj = d.C0096d.transparent;
        this.cZl = 0;
        this.cZo = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kT(int i) {
                if (HorizontalTabView.this.cZd != null && HorizontalTabView.this.cZq != null && HorizontalTabView.this.cZq != null) {
                    HorizontalTabView.this.cZq.a(HorizontalTabView.this.cZd.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cZe != null) {
                    HorizontalTabView.this.cZe.kR(i);
                }
            }
        };
        this.cZp = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cZk) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cZm != null) {
                                HorizontalTabView.this.cZm.a(HorizontalTabView.this.kN(1));
                            }
                            HorizontalTabView.this.aqx();
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
                if (HorizontalTabView.this.cZe != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.kS(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cZd != null) {
                            HorizontalTabView.this.cZe.kQ(HorizontalTabView.this.cZd.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cZe.kQ(((TabItemView) view).getTabId());
                }
            }
        };
        this.cZa = new LinearLayout(context);
        this.cZa.setOrientation(0);
        this.cZa.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.cZb = new e(context, this.cZo, this.cZp);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cYZ = 0;
        this.cZd = null;
        this.cZe = null;
        this.mPaint = new Paint();
        this.cZf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cZg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cZh = 0;
        this.cZi = true;
        this.cZj = d.C0096d.transparent;
        this.cZl = 0;
        this.cZo = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kT(int i2) {
                if (HorizontalTabView.this.cZd != null && HorizontalTabView.this.cZq != null && HorizontalTabView.this.cZq != null) {
                    HorizontalTabView.this.cZq.a(HorizontalTabView.this.cZd.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cZe != null) {
                    HorizontalTabView.this.cZe.kR(i2);
                }
            }
        };
        this.cZp = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cZk) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cZm != null) {
                                HorizontalTabView.this.cZm.a(HorizontalTabView.this.kN(1));
                            }
                            HorizontalTabView.this.aqx();
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
                if (HorizontalTabView.this.cZe != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.kS(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cZd != null) {
                            HorizontalTabView.this.cZe.kQ(HorizontalTabView.this.cZd.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cZe.kQ(((TabItemView) view).getTabId());
                }
            }
        };
        this.cZa = new LinearLayout(activity);
        this.cZa.setOrientation(0);
        this.cZa.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cZb = new e(activity, this.cZo, this.cZp);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cZa, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        aj.k(this, d.C0096d.transparent);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean bk(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d kO = kO(1);
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
        if (kO == null || dVar == null) {
            return false;
        }
        if (kO.cZu == null && dVar.cZu == null) {
            return false;
        }
        if ((kO.cZu != null || dVar.cZu == null) && (dVar.cZu != null || kO.cZu == null)) {
            if (kO.cZu == null || dVar.cZu == null) {
                return false;
            }
            if (kO.cZu.cKh == null && dVar.cZu.cKh == null) {
                return false;
            }
            if ((kO.cZu.cKh != null || dVar.cZu.cKh == null) && (dVar.cZu.cKh != null || kO.cZu.cKh == null)) {
                int size = kO.cZu.cKh.size();
                if (size != dVar.cZu.cKh.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    au auVar = dVar.cZu.cKh.get(i);
                    au auVar2 = kO.cZu.cKh.get(i);
                    if (auVar.cKd != auVar2.cKd || !auVar.name.equals(auVar2.name)) {
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
        av avVar;
        if (this.cZk) {
            this.cZc = new ArrayList();
            this.cZc.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                av avVar2 = dVar.cZu;
                if (avVar2 != null && avVar2.cKh != null) {
                    avVar2.cKh.clear();
                    avVar = avVar2;
                } else {
                    av avVar3 = new av();
                    avVar3.cKh = new ArrayList();
                    avVar = avVar3;
                }
                d dVar2 = null;
                if (v.v(list) > 1) {
                    au auVar = new au();
                    auVar.cKd = 1;
                    auVar.name = getContext().getString(d.j.chosen_pb_title);
                    avVar.cKh.add(auVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            au auVar2 = new au();
                            auVar2.cKd = dVar3.tabId;
                            auVar2.name = dVar3.name;
                            avVar.cKh.add(auVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.cZu = avVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.cZc = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cZh > 0 && list.size() == this.cZh) {
            layoutParams = new LinearLayout.LayoutParams(l.ac(getContext()) / this.cZh, -1);
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
            this.cZa.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cZk);
            if (this.cZl != 0) {
                tabItemView.setSelectItemColorResId(this.cZl);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.cZa.addView(tabItemView, layoutParams);
            this.cZd = tabItemView;
            tabItemView.setState(TabItemView.cZw);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bk(list)) {
            this.mData = list;
            this.cZa.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cZk);
                        if (302 == dVar2.tabId) {
                            aj.c(tabItemView2, d.C0096d.cp_cont_j, 1);
                        }
                        if (this.cZl != 0) {
                            tabItemView2.setSelectItemColorResId(this.cZl);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (kS(dVar2.tabId)) {
                            aj.i(tabItemView2, d.C0096d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.cZa.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.cZd = tabItemView2;
                            tabItemView2.setState(TabItemView.cZw);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d kO(int i) {
        if (i < 0 || this.cZc == null || this.cZc.size() == 0) {
            return null;
        }
        for (d dVar : this.cZc) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean kP(int i) {
        d kO = kO(i);
        return (kO == null || kO.cZu == null || kO.cZu.cKh == null || kO.cZu.cKh.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cZe = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cZd != null) {
            this.mPaint.setColor(aj.getColor(d.C0096d.cp_bg_line_b));
            if (this.cZi) {
                canvas.drawRect(this.cZa.getLeft(), getMeasuredHeight() - this.cZg, this.cZa.getRight() > getRight() ? this.cZa.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cZk) {
                if (this.cZl == 0) {
                    this.mPaint.setColor(aj.d((Resources) null, d.C0096d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(aj.d((Resources) null, this.cZl));
                }
                canvas.drawRect(this.cZd.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cZf, (this.cZd.getRight() - getBottomLineMargin()) - this.cZd.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cZk) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(aj.d((Resources) null, d.C0096d.cp_cont_b));
            int f = l.f(getContext(), d.e.ds96);
            if (this.cZd != null) {
                f = this.cZd.getRight() - this.cZd.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.f(getContext(), d.e.tbds44), l.f(getContext(), d.e.tbds98), f, l.f(getContext(), d.e.tbds104)), l.f(getContext(), d.e.tbds6), l.f(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cZd == null || this.cYZ == 0) {
            return 0;
        }
        return ((this.cZd.getMeasuredWidth() - this.cYZ) - this.cZd.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void kQ(int i) {
        c(kN(i));
    }

    public void setDataLoadInterface(ak akVar) {
        this.cZq = akVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cZr = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cZr;
    }

    public void setTabBackgroudColor(int i) {
        this.cZj = i;
    }

    public void wC() {
        aj.k(this, this.cZj);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cZa.getChildCount()) {
                View childAt = this.cZa.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (kS(((TabItemView) childAt).getTabId())) {
                        aj.i(childAt, d.C0096d.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).wC();
                    }
                }
                i = i2 + 1;
            } else {
                this.cZb.wC();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cZh = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void kR(int i) {
        if (this.cZd != null && this.cZq != null) {
            this.cZq.a(this.cZd.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cZm = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cZn = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cZk = z;
    }

    public static boolean kS(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cZi = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cZl = i;
    }
}
