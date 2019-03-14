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
    private TbPageContext eKr;
    private a ftA;
    private b ftB;
    private e.b ftC;
    private e.a ftD;
    private af ftE;
    private c ftF;
    public int ftn;
    private final LinearLayout fto;
    private final e ftp;
    private List<d> ftq;
    private TabItemView ftr;
    private com.baidu.tieba.frs.tab.b fts;
    private final int ftt;
    private final int ftu;
    private int ftv;
    private boolean ftw;
    private int ftx;
    private boolean fty;
    private int ftz;
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
        void rp(int i);

        boolean rq(int i);
    }

    public void bin() {
        final as asVar;
        if (this.eKr != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).ftI) != null && asVar.fcE != null) {
                for (ar arVar : asVar.fcE) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eKr.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0225b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.fcE.size() > i && asVar.fcE.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.ri(asVar.fcE.get(i).fcA));
                        }
                    }
                });
                bVar.d(this.eKr);
                bVar.abc();
            }
        }
    }

    public d ri(int i) {
        if (!v.T(this.ftq)) {
            for (d dVar : this.ftq) {
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
            if (dVar.tabId != 302 && this.ftB != null) {
                this.ftB.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (rn(dVar.tabId)) {
                if (this.ftE != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.fda = dVar.url;
                    this.ftE.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.ftE != null) {
                    this.ftE.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.ftE == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.fda = dVar.url;
                    amVar2.stType = dVar.name;
                    this.ftE.a(dVar.tabId, 0, amVar2);
                    if (amVar2.fdb) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.fto.getChildCount(); i++) {
                    View childAt = this.fto.getChildAt(i);
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
                    amVar3.fda = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.ftE != null && z) {
                    this.ftE.a(dVar.tabId, 0, amVar3);
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
            if (rn(tabItemView.getTabId())) {
                if (this.ftE != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.fda = tabItemView.getUrl();
                    this.ftE.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.ftE != null) {
                    this.ftE.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.ftr = tabItemView;
                int[] iArr = new int[2];
                this.ftr.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.fto.getChildCount(); i2++) {
                    View childAt = this.fto.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.ftr.getTabId() && !rn(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.ftJ);
                        }
                    }
                }
                if (this.ftr.getState() == TabItemView.ftJ || this.ftr.getState() == TabItemView.STATE_EXPANDED) {
                    this.ftp.biq();
                    boolean z2 = this.ftr.getState() == TabItemView.ftJ;
                    this.ftr.setState(TabItemView.ftK);
                    d rj = rj(this.ftr.getTabId());
                    if (rj != null) {
                        if (!TextUtils.isEmpty(rj.url)) {
                            am amVar3 = new am();
                            amVar3.fda = rj.url;
                            amVar3.stType = rj.name;
                            amVar = amVar3;
                        }
                        if (rj.ftI != null && rj.ftI.fcE != null && rj.ftI.fcE.size() > 0) {
                            for (ar arVar : rj.ftI.fcE) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fcA;
                                }
                            }
                        }
                        if (z2 && this.ftE != null) {
                            this.ftE.a(this.ftr.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (rk(this.ftr.getTabId()) && !z) {
                    if (this.ftF == null || this.ftF.rq(this.ftr.getTabId())) {
                        this.ftr.setState(TabItemView.STATE_EXPANDED);
                        this.ftp.a((Activity) getContext(), this, this.ftr, rj(this.ftr.getTabId()).ftI);
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
        this.ftn = 0;
        this.ftr = null;
        this.fts = null;
        this.mPaint = new Paint();
        this.ftt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.ftu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.ftv = 0;
        this.ftw = true;
        this.ftx = d.C0277d.transparent;
        this.ftz = 0;
        this.ftC = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void ro(int i) {
                if (HorizontalTabView.this.ftr != null && HorizontalTabView.this.ftE != null && HorizontalTabView.this.ftE != null) {
                    HorizontalTabView.this.ftE.a(HorizontalTabView.this.ftr.getTabId(), i, null);
                }
                if (HorizontalTabView.this.fts != null) {
                    HorizontalTabView.this.fts.rm(i);
                }
            }
        };
        this.ftD = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.fty) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.ftA != null) {
                                HorizontalTabView.this.ftA.b(HorizontalTabView.this.ri(1));
                            }
                            HorizontalTabView.this.bin();
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
                if (HorizontalTabView.this.fts != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.rn(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.ftr != null) {
                            HorizontalTabView.this.fts.rl(HorizontalTabView.this.ftr.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.fts.rl(((TabItemView) view).getTabId());
                }
            }
        };
        this.fto = new LinearLayout(context);
        this.fto.setOrientation(0);
        this.fto.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.ftp = new e(context, this.ftC, this.ftD);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.fto, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.l(this, d.C0277d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cg(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d rj = rj(1);
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
        if (rj == null || dVar == null) {
            return false;
        }
        if (rj.ftI == null && dVar.ftI == null) {
            return false;
        }
        if ((rj.ftI != null || dVar.ftI == null) && (dVar.ftI != null || rj.ftI == null)) {
            if (rj.ftI == null || dVar.ftI == null) {
                return false;
            }
            if (rj.ftI.fcE == null && dVar.ftI.fcE == null) {
                return false;
            }
            if ((rj.ftI.fcE != null || dVar.ftI.fcE == null) && (dVar.ftI.fcE != null || rj.ftI.fcE == null)) {
                int size = rj.ftI.fcE.size();
                if (size != dVar.ftI.fcE.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.ftI.fcE.get(i);
                    ar arVar2 = rj.ftI.fcE.get(i);
                    if (arVar.fcA != arVar2.fcA || !arVar.name.equals(arVar2.name)) {
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
        if (this.fty) {
            this.ftq = new ArrayList();
            this.ftq.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.ftI;
                if (asVar2 != null && asVar2.fcE != null) {
                    asVar2.fcE.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.fcE = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.S(list) > 1) {
                    ar arVar = new ar();
                    arVar.fcA = 1;
                    arVar.name = getContext().getString(d.j.chosen_pb_title);
                    asVar.fcE.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.fcA = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.fcE.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.ftI = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.ftq = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.ftv > 0 && list.size() == this.ftv) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.ftv, -1);
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
            this.fto.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.fty);
            if (this.ftz != 0) {
                tabItemView.setSelectItemColorResId(this.ftz);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.fto.addView(tabItemView, layoutParams);
            this.ftr = tabItemView;
            tabItemView.setState(TabItemView.ftK);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cg(list)) {
            this.mData = list;
            this.fto.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.fty);
                        if (302 == dVar2.tabId) {
                            al.d(tabItemView2, d.C0277d.cp_cont_j, 1);
                        }
                        if (this.ftz != 0) {
                            tabItemView2.setSelectItemColorResId(this.ftz);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (rn(dVar2.tabId)) {
                            al.j(tabItemView2, d.C0277d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.fto.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.ftr = tabItemView2;
                            tabItemView2.setState(TabItemView.ftK);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d rj(int i) {
        if (i < 0 || this.ftq == null || this.ftq.size() == 0) {
            return null;
        }
        for (d dVar : this.ftq) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean rk(int i) {
        d rj = rj(i);
        return (rj == null || rj.ftI == null || rj.ftI.fcE == null || rj.ftI.fcE.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.fts = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.ftr != null) {
            this.mPaint.setColor(al.getColor(d.C0277d.cp_bg_line_b));
            if (this.ftw) {
                canvas.drawRect(this.fto.getLeft(), getMeasuredHeight() - this.ftu, this.fto.getRight() > getRight() ? this.fto.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.fty) {
                if (this.ftz == 0) {
                    this.mPaint.setColor(al.d((Resources) null, d.C0277d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.ftz));
                }
                canvas.drawRect(this.ftr.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.ftt, (this.ftr.getRight() - getBottomLineMargin()) - this.ftr.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.fty) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, d.C0277d.cp_cont_b));
            int h = l.h(getContext(), d.e.ds96);
            if (this.ftr != null) {
                h = this.ftr.getRight() - this.ftr.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), d.e.tbds44), l.h(getContext(), d.e.tbds98), h, l.h(getContext(), d.e.tbds104)), l.h(getContext(), d.e.tbds6), l.h(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.ftr == null || this.ftn == 0) {
            return 0;
        }
        return ((this.ftr.getMeasuredWidth() - this.ftn) - this.ftr.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void rl(int i) {
        a(ri(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.ftE = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.ftF = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.ftF;
    }

    public void setTabBackgroudColor(int i) {
        this.ftx = i;
    }

    public void setAutoFillTabCount(int i) {
        this.ftv = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void rm(int i) {
        if (this.ftr != null && this.ftE != null) {
            this.ftE.a(this.ftr.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ftA = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.ftB = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.fty = z;
    }

    public static boolean rn(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.ftw = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.ftz = i;
    }
}
