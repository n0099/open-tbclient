package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext eKe;
    public int fsZ;
    private final LinearLayout fta;
    private final e ftb;
    private List<d> ftc;
    private TabItemView ftd;
    private com.baidu.tieba.frs.tab.b fte;
    private final int ftf;
    private final int ftg;
    private int fth;
    private boolean fti;
    private int ftj;
    private boolean ftk;
    private int ftl;
    private a ftm;
    private b ftn;
    private e.b fto;
    private e.a ftp;
    private af ftq;
    private c ftr;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes4.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void rl(int i);

        boolean rm(int i);
    }

    public void bil() {
        final as asVar;
        if (this.eKe != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).ftu) != null && asVar.fcr != null) {
                for (ar arVar : asVar.fcr) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eKe.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0225b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.fcr.size() > i && asVar.fcr.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.re(asVar.fcr.get(i).fcn));
                        }
                    }
                });
                bVar.d(this.eKe);
                bVar.aaZ();
            }
        }
    }

    public d re(int i) {
        if (!v.T(this.ftc)) {
            for (d dVar : this.ftc) {
                if (dVar != null && dVar.tabId == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void a(d dVar) {
        boolean z;
        if (dVar != null) {
            if (dVar.tabId != 302 && this.ftn != null) {
                this.ftn.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (rj(dVar.tabId)) {
                if (this.ftq != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.fcN = dVar.url;
                    this.ftq.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.ftq != null) {
                    this.ftq.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.ftq == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.fcN = dVar.url;
                    amVar2.stType = dVar.name;
                    this.ftq.a(dVar.tabId, 0, amVar2);
                    if (amVar2.fcO) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.fta.getChildCount(); i++) {
                    View childAt = this.fta.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                am amVar3 = null;
                if (!TextUtils.isEmpty(dVar.url)) {
                    amVar3 = new am();
                    amVar3.fcN = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.ftq != null && z) {
                    this.ftq.a(dVar.tabId, 0, amVar3);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        am amVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (rj(tabItemView.getTabId())) {
                if (this.ftq != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.fcN = tabItemView.getUrl();
                    this.ftq.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.ftq != null) {
                    this.ftq.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.ftd = tabItemView;
                int[] iArr = new int[2];
                this.ftd.getLocationOnScreen(iArr);
                int aO = l.aO(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (aO < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.fta.getChildCount(); i2++) {
                    View childAt = this.fta.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.ftd.getTabId() && !rj(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.ftv);
                        }
                    }
                }
                if (this.ftd.getState() == TabItemView.ftv || this.ftd.getState() == TabItemView.STATE_EXPANDED) {
                    this.ftb.bio();
                    boolean z2 = this.ftd.getState() == TabItemView.ftv;
                    this.ftd.setState(TabItemView.ftw);
                    d rf = rf(this.ftd.getTabId());
                    if (rf != null) {
                        if (!TextUtils.isEmpty(rf.url)) {
                            am amVar3 = new am();
                            amVar3.fcN = rf.url;
                            amVar3.stType = rf.name;
                            amVar = amVar3;
                        }
                        if (rf.ftu != null && rf.ftu.fcr != null && rf.ftu.fcr.size() > 0) {
                            for (ar arVar : rf.ftu.fcr) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fcn;
                                }
                            }
                        }
                        if (z2 && this.ftq != null) {
                            this.ftq.a(this.ftd.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (rg(this.ftd.getTabId()) && !z) {
                    if (this.ftr == null || this.ftr.rm(this.ftd.getTabId())) {
                        this.ftd.setState(TabItemView.STATE_EXPANDED);
                        this.ftb.a((Activity) getContext(), this, this.ftd, rf(this.ftd.getTabId()).ftu);
                    } else {
                        return;
                    }
                }
                invalidate();
            }
        }
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fsZ = 0;
        this.ftd = null;
        this.fte = null;
        this.mPaint = new Paint();
        this.ftf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.ftg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.fth = 0;
        this.fti = true;
        this.ftj = d.C0277d.transparent;
        this.ftl = 0;
        this.fto = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void rk(int i) {
                if (HorizontalTabView.this.ftd != null && HorizontalTabView.this.ftq != null && HorizontalTabView.this.ftq != null) {
                    HorizontalTabView.this.ftq.a(HorizontalTabView.this.ftd.getTabId(), i, null);
                }
                if (HorizontalTabView.this.fte != null) {
                    HorizontalTabView.this.fte.ri(i);
                }
            }
        };
        this.ftp = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.ftk) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.ftm != null) {
                                HorizontalTabView.this.ftm.b(HorizontalTabView.this.re(1));
                            }
                            HorizontalTabView.this.bil();
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
                            HorizontalTabView.this.a(dVar);
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
                if (HorizontalTabView.this.fte != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.rj(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.ftd != null) {
                            HorizontalTabView.this.fte.rh(HorizontalTabView.this.ftd.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.fte.rh(((TabItemView) view).getTabId());
                }
            }
        };
        this.fta = new LinearLayout(context);
        this.fta.setOrientation(0);
        this.fta.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.ftb = new e(context, this.fto, this.ftp);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.fta, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.l(this, d.C0277d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cd(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d rf = rf(1);
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
        if (rf == null || dVar == null) {
            return false;
        }
        if (rf.ftu == null && dVar.ftu == null) {
            return false;
        }
        if ((rf.ftu != null || dVar.ftu == null) && (dVar.ftu != null || rf.ftu == null)) {
            if (rf.ftu == null || dVar.ftu == null) {
                return false;
            }
            if (rf.ftu.fcr == null && dVar.ftu.fcr == null) {
                return false;
            }
            if ((rf.ftu.fcr != null || dVar.ftu.fcr == null) && (dVar.ftu.fcr != null || rf.ftu.fcr == null)) {
                int size = rf.ftu.fcr.size();
                if (size != dVar.ftu.fcr.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.ftu.fcr.get(i);
                    ar arVar2 = rf.ftu.fcr.get(i);
                    if (arVar.fcn != arVar2.fcn || !arVar.name.equals(arVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void setData(List<d> list, int i, int i2) {
        d dVar;
        as asVar;
        if (this.ftk) {
            this.ftc = new ArrayList();
            this.ftc.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.ftu;
                if (asVar2 != null && asVar2.fcr != null) {
                    asVar2.fcr.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.fcr = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.S(list) > 1) {
                    ar arVar = new ar();
                    arVar.fcn = 1;
                    arVar.name = getContext().getString(d.j.chosen_pb_title);
                    asVar.fcr.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.fcn = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.fcr.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.ftu = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.ftc = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.fth > 0 && list.size() == this.fth) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.fth, -1);
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
            this.fta.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.ftk);
            if (this.ftl != 0) {
                tabItemView.setSelectItemColorResId(this.ftl);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.fta.addView(tabItemView, layoutParams);
            this.ftd = tabItemView;
            tabItemView.setState(TabItemView.ftw);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cd(list)) {
            this.mData = list;
            this.fta.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.ftk);
                        if (302 == dVar2.tabId) {
                            al.d(tabItemView2, d.C0277d.cp_cont_j, 1);
                        }
                        if (this.ftl != 0) {
                            tabItemView2.setSelectItemColorResId(this.ftl);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (rj(dVar2.tabId)) {
                            al.j(tabItemView2, d.C0277d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.fta.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.ftd = tabItemView2;
                            tabItemView2.setState(TabItemView.ftw);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d rf(int i) {
        if (i < 0 || this.ftc == null || this.ftc.size() == 0) {
            return null;
        }
        for (d dVar : this.ftc) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean rg(int i) {
        d rf = rf(i);
        return (rf == null || rf.ftu == null || rf.ftu.fcr == null || rf.ftu.fcr.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.fte = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ftd != null) {
            this.mPaint.setColor(al.getColor(d.C0277d.cp_bg_line_b));
            if (this.fti) {
                canvas.drawRect(this.fta.getLeft(), getMeasuredHeight() - this.ftg, this.fta.getRight() > getRight() ? this.fta.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.ftk) {
                if (this.ftl == 0) {
                    this.mPaint.setColor(al.d((Resources) null, d.C0277d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.ftl));
                }
                canvas.drawRect(this.ftd.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.ftf, (this.ftd.getRight() - getBottomLineMargin()) - this.ftd.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.ftk) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, d.C0277d.cp_cont_b));
            int h = l.h(getContext(), d.e.ds96);
            if (this.ftd != null) {
                h = this.ftd.getRight() - this.ftd.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), d.e.tbds44), l.h(getContext(), d.e.tbds98), h, l.h(getContext(), d.e.tbds104)), l.h(getContext(), d.e.tbds6), l.h(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.ftd == null || this.fsZ == 0) {
            return 0;
        }
        return ((this.ftd.getMeasuredWidth() - this.fsZ) - this.ftd.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void rh(int i) {
        a(re(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.ftq = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.ftr = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.ftr;
    }

    public void setTabBackgroudColor(int i) {
        this.ftj = i;
    }

    public void setAutoFillTabCount(int i) {
        this.fth = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void ri(int i) {
        if (this.ftd != null && this.ftq != null) {
            this.ftq.a(this.ftd.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ftm = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.ftn = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.ftk = z;
    }

    public static boolean rj(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.fti = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.ftl = i;
    }
}
