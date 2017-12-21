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
    public int cZd;
    private final LinearLayout cZe;
    private final e cZf;
    private List<d> cZg;
    private TabItemView cZh;
    private com.baidu.tieba.frs.tab.b cZi;
    private final int cZj;
    private final int cZk;
    private int cZl;
    private boolean cZm;
    private int cZn;
    private boolean cZo;
    private int cZp;
    private a cZq;
    private b cZr;
    private e.b cZs;
    private e.a cZt;
    private ak cZu;
    private c cZv;
    private TbPageContext cyh;
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

    public void aqy() {
        final av avVar;
        if (this.cyh != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (avVar = this.mData.get(0).cZy) != null && avVar.cKl != null) {
                for (au auVar : avVar.cKl) {
                    if (auVar != null) {
                        arrayList.add(auVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cyh.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0060b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0060b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (avVar.cKl.size() > i && avVar.cKl.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.c(HorizontalTabView.this.kN(avVar.cKl.get(i).cKh));
                        }
                    }
                });
                bVar.d(this.cyh);
                bVar.tl();
            }
        }
    }

    public d kN(int i) {
        if (!v.w(this.cZg)) {
            for (d dVar : this.cZg) {
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
            if (dVar.tabId != 302 && this.cZr != null) {
                this.cZr.b(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (kS(dVar.tabId)) {
                if (this.cZu != null && !TextUtils.isEmpty(dVar.url)) {
                    ap apVar = new ap();
                    apVar.cKB = dVar.url;
                    this.cZu.a(dVar.tabId, -1, apVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.cZu != null) {
                    this.cZu.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.cZu == null) {
                    z = true;
                } else {
                    ap apVar2 = new ap();
                    apVar2.cKB = dVar.url;
                    apVar2.stType = dVar.name;
                    this.cZu.a(dVar.tabId, 0, apVar2);
                    if (apVar2.cKC) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.cZe.getChildCount(); i++) {
                    View childAt = this.cZe.getChildAt(i);
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
                    apVar3.cKB = dVar.url;
                    apVar3.stType = dVar.name;
                }
                if (this.cZu != null && z) {
                    this.cZu.a(dVar.tabId, 0, apVar3);
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
                if (this.cZu != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ap apVar2 = new ap();
                    apVar2.cKB = tabItemView.getUrl();
                    this.cZu.a(tabItemView.getTabId(), -1, apVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.cZu != null) {
                    this.cZu.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.cZh = tabItemView;
                int[] iArr = new int[2];
                this.cZh.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.cZe.getChildCount(); i2++) {
                    View childAt = this.cZe.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.cZh.getTabId() && !kS(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.cZz);
                        }
                    }
                }
                if (this.cZh.getState() == TabItemView.cZz || this.cZh.getState() == TabItemView.cZB) {
                    this.cZf.aqB();
                    boolean z2 = this.cZh.getState() == TabItemView.cZz;
                    this.cZh.setState(TabItemView.cZA);
                    d kO = kO(this.cZh.getTabId());
                    if (kO != null) {
                        if (!TextUtils.isEmpty(kO.url)) {
                            ap apVar3 = new ap();
                            apVar3.cKB = kO.url;
                            apVar3.stType = kO.name;
                            apVar = apVar3;
                        }
                        if (kO.cZy != null && kO.cZy.cKl != null && kO.cZy.cKl.size() > 0) {
                            for (au auVar : kO.cZy.cKl) {
                                if (auVar != null && auVar.isSelected) {
                                    i = auVar.cKh;
                                }
                            }
                        }
                        if (z2 && this.cZu != null) {
                            this.cZu.a(this.cZh.getTabId(), i, apVar);
                        }
                    } else {
                        return;
                    }
                } else if (kP(this.cZh.getTabId()) && !z) {
                    if (this.cZv == null || this.cZv.kj(this.cZh.getTabId())) {
                        this.cZh.setState(TabItemView.cZB);
                        this.cZf.a((Activity) getContext(), this, this.cZh, kO(this.cZh.getTabId()).cZy);
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
        this.cZd = 0;
        this.cZh = null;
        this.cZi = null;
        this.mPaint = new Paint();
        this.cZj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cZk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cZl = 0;
        this.cZm = true;
        this.cZn = d.C0095d.transparent;
        this.cZp = 0;
        this.cZs = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kT(int i) {
                if (HorizontalTabView.this.cZh != null && HorizontalTabView.this.cZu != null && HorizontalTabView.this.cZu != null) {
                    HorizontalTabView.this.cZu.a(HorizontalTabView.this.cZh.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cZi != null) {
                    HorizontalTabView.this.cZi.kR(i);
                }
            }
        };
        this.cZt = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cZo) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cZq != null) {
                                HorizontalTabView.this.cZq.a(HorizontalTabView.this.kN(1));
                            }
                            HorizontalTabView.this.aqy();
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
                if (HorizontalTabView.this.cZi != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.kS(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cZh != null) {
                            HorizontalTabView.this.cZi.kQ(HorizontalTabView.this.cZh.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cZi.kQ(((TabItemView) view).getTabId());
                }
            }
        };
        this.cyh = tbPageContext;
        this.cZe = new LinearLayout(tbPageContext.getPageActivity());
        this.cZe.setOrientation(0);
        this.cZe.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(d.e.ds88));
        this.cZf = new e(tbPageContext.getPageActivity(), this.cZs, this.cZt);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZd = 0;
        this.cZh = null;
        this.cZi = null;
        this.mPaint = new Paint();
        this.cZj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cZk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cZl = 0;
        this.cZm = true;
        this.cZn = d.C0095d.transparent;
        this.cZp = 0;
        this.cZs = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kT(int i) {
                if (HorizontalTabView.this.cZh != null && HorizontalTabView.this.cZu != null && HorizontalTabView.this.cZu != null) {
                    HorizontalTabView.this.cZu.a(HorizontalTabView.this.cZh.getTabId(), i, null);
                }
                if (HorizontalTabView.this.cZi != null) {
                    HorizontalTabView.this.cZi.kR(i);
                }
            }
        };
        this.cZt = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cZo) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cZq != null) {
                                HorizontalTabView.this.cZq.a(HorizontalTabView.this.kN(1));
                            }
                            HorizontalTabView.this.aqy();
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
                if (HorizontalTabView.this.cZi != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.kS(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cZh != null) {
                            HorizontalTabView.this.cZi.kQ(HorizontalTabView.this.cZh.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cZi.kQ(((TabItemView) view).getTabId());
                }
            }
        };
        this.cZe = new LinearLayout(context);
        this.cZe.setOrientation(0);
        this.cZe.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.cZf = new e(context, this.cZs, this.cZt);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.cZd = 0;
        this.cZh = null;
        this.cZi = null;
        this.mPaint = new Paint();
        this.cZj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.cZk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.cZl = 0;
        this.cZm = true;
        this.cZn = d.C0095d.transparent;
        this.cZp = 0;
        this.cZs = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void kT(int i2) {
                if (HorizontalTabView.this.cZh != null && HorizontalTabView.this.cZu != null && HorizontalTabView.this.cZu != null) {
                    HorizontalTabView.this.cZu.a(HorizontalTabView.this.cZh.getTabId(), i2, null);
                }
                if (HorizontalTabView.this.cZi != null) {
                    HorizontalTabView.this.cZi.kR(i2);
                }
            }
        };
        this.cZt = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.cZo) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.cZq != null) {
                                HorizontalTabView.this.cZq.a(HorizontalTabView.this.kN(1));
                            }
                            HorizontalTabView.this.aqy();
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
                if (HorizontalTabView.this.cZi != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.kS(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.cZh != null) {
                            HorizontalTabView.this.cZi.kQ(HorizontalTabView.this.cZh.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.cZi.kQ(((TabItemView) view).getTabId());
                }
            }
        };
        this.cZe = new LinearLayout(activity);
        this.cZe.setOrientation(0);
        this.cZe.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.cZf = new e(activity, this.cZs, this.cZt);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.cZe, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        aj.k(this, d.C0095d.transparent);
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
        if (kO.cZy == null && dVar.cZy == null) {
            return false;
        }
        if ((kO.cZy != null || dVar.cZy == null) && (dVar.cZy != null || kO.cZy == null)) {
            if (kO.cZy == null || dVar.cZy == null) {
                return false;
            }
            if (kO.cZy.cKl == null && dVar.cZy.cKl == null) {
                return false;
            }
            if ((kO.cZy.cKl != null || dVar.cZy.cKl == null) && (dVar.cZy.cKl != null || kO.cZy.cKl == null)) {
                int size = kO.cZy.cKl.size();
                if (size != dVar.cZy.cKl.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    au auVar = dVar.cZy.cKl.get(i);
                    au auVar2 = kO.cZy.cKl.get(i);
                    if (auVar.cKh != auVar2.cKh || !auVar.name.equals(auVar2.name)) {
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
        if (this.cZo) {
            this.cZg = new ArrayList();
            this.cZg.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                av avVar2 = dVar.cZy;
                if (avVar2 != null && avVar2.cKl != null) {
                    avVar2.cKl.clear();
                    avVar = avVar2;
                } else {
                    av avVar3 = new av();
                    avVar3.cKl = new ArrayList();
                    avVar = avVar3;
                }
                d dVar2 = null;
                if (v.v(list) > 1) {
                    au auVar = new au();
                    auVar.cKh = 1;
                    auVar.name = getContext().getString(d.j.chosen_pb_title);
                    avVar.cKl.add(auVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            au auVar2 = new au();
                            auVar2.cKh = dVar3.tabId;
                            auVar2.name = dVar3.name;
                            avVar.cKl.add(auVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.cZy = avVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.cZg = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.cZl > 0 && list.size() == this.cZl) {
            layoutParams = new LinearLayout.LayoutParams(l.ac(getContext()) / this.cZl, -1);
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
            this.cZe.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.cZo);
            if (this.cZp != 0) {
                tabItemView.setSelectItemColorResId(this.cZp);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.cZe.addView(tabItemView, layoutParams);
            this.cZh = tabItemView;
            tabItemView.setState(TabItemView.cZA);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bk(list)) {
            this.mData = list;
            this.cZe.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.cZo);
                        if (302 == dVar2.tabId) {
                            aj.c(tabItemView2, d.C0095d.cp_cont_j, 1);
                        }
                        if (this.cZp != 0) {
                            tabItemView2.setSelectItemColorResId(this.cZp);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (kS(dVar2.tabId)) {
                            aj.i(tabItemView2, d.C0095d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.cZe.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.cZh = tabItemView2;
                            tabItemView2.setState(TabItemView.cZA);
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
        if (i < 0 || this.cZg == null || this.cZg.size() == 0) {
            return null;
        }
        for (d dVar : this.cZg) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean kP(int i) {
        d kO = kO(i);
        return (kO == null || kO.cZy == null || kO.cZy.cKl == null || kO.cZy.cKl.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.cZi = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.cZh != null) {
            this.mPaint.setColor(aj.getColor(d.C0095d.cp_bg_line_b));
            if (this.cZm) {
                canvas.drawRect(this.cZe.getLeft(), getMeasuredHeight() - this.cZk, this.cZe.getRight() > getRight() ? this.cZe.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.cZo) {
                if (this.cZp == 0) {
                    this.mPaint.setColor(aj.d((Resources) null, d.C0095d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(aj.d((Resources) null, this.cZp));
                }
                canvas.drawRect(this.cZh.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.cZj, (this.cZh.getRight() - getBottomLineMargin()) - this.cZh.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.cZo) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(aj.d((Resources) null, d.C0095d.cp_cont_b));
            int f = l.f(getContext(), d.e.ds96);
            if (this.cZh != null) {
                f = this.cZh.getRight() - this.cZh.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.f(getContext(), d.e.tbds44), l.f(getContext(), d.e.tbds98), f, l.f(getContext(), d.e.tbds104)), l.f(getContext(), d.e.tbds6), l.f(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.cZh == null || this.cZd == 0) {
            return 0;
        }
        return ((this.cZh.getMeasuredWidth() - this.cZd) - this.cZh.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void kQ(int i) {
        c(kN(i));
    }

    public void setDataLoadInterface(ak akVar) {
        this.cZu = akVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.cZv = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.cZv;
    }

    public void setTabBackgroudColor(int i) {
        this.cZn = i;
    }

    public void wC() {
        aj.k(this, this.cZn);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.cZe.getChildCount()) {
                View childAt = this.cZe.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (kS(((TabItemView) childAt).getTabId())) {
                        aj.i(childAt, d.C0095d.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).wC();
                    }
                }
                i = i2 + 1;
            } else {
                this.cZf.wC();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.cZl = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void kR(int i) {
        if (this.cZh != null && this.cZu != null) {
            this.cZu.a(this.cZh.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.cZq = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.cZr = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.cZo = z;
    }

    public static boolean kS(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.cZm = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.cZp = i;
    }
}
