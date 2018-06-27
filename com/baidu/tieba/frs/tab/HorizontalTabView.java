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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext cVl;
    public int dCd;
    private final LinearLayout dCe;
    private final e dCf;
    private List<d> dCg;
    private TabItemView dCh;
    private com.baidu.tieba.frs.tab.b dCi;
    private final int dCj;
    private final int dCk;
    private int dCl;
    private boolean dCm;
    private int dCn;
    private boolean dCo;
    private int dCp;
    private a dCq;
    private b dCr;
    private e.b dCs;
    private e.a dCt;
    private ai dCu;
    private c dCv;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes2.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void lu(int i);

        boolean lv(int i);
    }

    public void azy() {
        final au auVar;
        if (this.cVl != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).dCy) != null && auVar.dmG != null) {
                for (at atVar : auVar.dmG) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cVl.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0104b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.dmG.size() > i && auVar.dmG.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.ln(auVar.dmG.get(i).dmC));
                        }
                    }
                });
                bVar.d(this.cVl);
                bVar.xq();
            }
        }
    }

    public d ln(int i) {
        if (!w.A(this.dCg)) {
            for (d dVar : this.dCg) {
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
            if (dVar.tabId != 302 && this.dCr != null) {
                this.dCr.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (ls(dVar.tabId)) {
                if (this.dCu != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dmV = dVar.url;
                    this.dCu.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.dCu != null) {
                    this.dCu.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.dCu == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dmV = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.dCu.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dmW) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.dCe.getChildCount(); i++) {
                    View childAt = this.dCe.getChildAt(i);
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
                    aoVar3.dmV = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.dCu != null && z) {
                    this.dCu.a(dVar.tabId, 0, aoVar3);
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
            if (ls(tabItemView.getTabId())) {
                if (this.dCu != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dmV = tabItemView.getUrl();
                    this.dCu.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.dCu != null) {
                    this.dCu.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.dCh = tabItemView;
                int[] iArr = new int[2];
                this.dCh.getLocationOnScreen(iArr);
                int ah = l.ah(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (ah < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.dCe.getChildCount(); i2++) {
                    View childAt = this.dCe.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.dCh.getTabId() && !ls(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.dCz);
                        }
                    }
                }
                if (this.dCh.getState() == TabItemView.dCz || this.dCh.getState() == TabItemView.STATE_EXPANDED) {
                    this.dCf.azB();
                    boolean z2 = this.dCh.getState() == TabItemView.dCz;
                    this.dCh.setState(TabItemView.dCA);
                    d lo = lo(this.dCh.getTabId());
                    if (lo != null) {
                        if (!TextUtils.isEmpty(lo.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dmV = lo.url;
                            aoVar3.stType = lo.name;
                            aoVar = aoVar3;
                        }
                        if (lo.dCy != null && lo.dCy.dmG != null && lo.dCy.dmG.size() > 0) {
                            for (at atVar : lo.dCy.dmG) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dmC;
                                }
                            }
                        }
                        if (z2 && this.dCu != null) {
                            this.dCu.a(this.dCh.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (lp(this.dCh.getTabId()) && !z) {
                    if (this.dCv == null || this.dCv.lv(this.dCh.getTabId())) {
                        this.dCh.setState(TabItemView.STATE_EXPANDED);
                        this.dCf.a((Activity) getContext(), this, this.dCh, lo(this.dCh.getTabId()).dCy);
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
        this.dCd = 0;
        this.dCh = null;
        this.dCi = null;
        this.mPaint = new Paint();
        this.dCj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.dCk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.dCl = 0;
        this.dCm = true;
        this.dCn = d.C0142d.transparent;
        this.dCp = 0;
        this.dCs = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void lt(int i) {
                if (HorizontalTabView.this.dCh != null && HorizontalTabView.this.dCu != null && HorizontalTabView.this.dCu != null) {
                    HorizontalTabView.this.dCu.a(HorizontalTabView.this.dCh.getTabId(), i, null);
                }
                if (HorizontalTabView.this.dCi != null) {
                    HorizontalTabView.this.dCi.lr(i);
                }
            }
        };
        this.dCt = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.dCo) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.dCq != null) {
                                HorizontalTabView.this.dCq.b(HorizontalTabView.this.ln(1));
                            }
                            HorizontalTabView.this.azy();
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
                if (HorizontalTabView.this.dCi != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.ls(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.dCh != null) {
                            HorizontalTabView.this.dCi.lq(HorizontalTabView.this.dCh.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.dCi.lq(((TabItemView) view).getTabId());
                }
            }
        };
        this.dCe = new LinearLayout(context);
        this.dCe.setOrientation(0);
        this.dCe.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.dCf = new e(context, this.dCs, this.dCt);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.dCe, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        am.j(this, d.C0142d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bA(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d lo = lo(1);
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
        if (lo == null || dVar == null) {
            return false;
        }
        if (lo.dCy == null && dVar.dCy == null) {
            return false;
        }
        if ((lo.dCy != null || dVar.dCy == null) && (dVar.dCy != null || lo.dCy == null)) {
            if (lo.dCy == null || dVar.dCy == null) {
                return false;
            }
            if (lo.dCy.dmG == null && dVar.dCy.dmG == null) {
                return false;
            }
            if ((lo.dCy.dmG != null || dVar.dCy.dmG == null) && (dVar.dCy.dmG != null || lo.dCy.dmG == null)) {
                int size = lo.dCy.dmG.size();
                if (size != dVar.dCy.dmG.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.dCy.dmG.get(i);
                    at atVar2 = lo.dCy.dmG.get(i);
                    if (atVar.dmC != atVar2.dmC || !atVar.name.equals(atVar2.name)) {
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
        au auVar;
        if (this.dCo) {
            this.dCg = new ArrayList();
            this.dCg.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.dCy;
                if (auVar2 != null && auVar2.dmG != null) {
                    auVar2.dmG.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.dmG = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (w.z(list) > 1) {
                    at atVar = new at();
                    atVar.dmC = 1;
                    atVar.name = getContext().getString(d.k.chosen_pb_title);
                    auVar.dmG.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.dmC = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.dmG.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.dCy = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.dCg = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.dCl > 0 && list.size() == this.dCl) {
            layoutParams = new LinearLayout.LayoutParams(l.ah(getContext()) / this.dCl, -1);
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
            dVar.name = getContext().getResources().getString(d.k.chosen_pb_title);
            this.dCe.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.dCo);
            if (this.dCp != 0) {
                tabItemView.setSelectItemColorResId(this.dCp);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.dCe.addView(tabItemView, layoutParams);
            this.dCh = tabItemView;
            tabItemView.setState(TabItemView.dCA);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bA(list)) {
            this.mData = list;
            this.dCe.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.dCo);
                        if (302 == dVar2.tabId) {
                            am.c(tabItemView2, d.C0142d.cp_cont_j, 1);
                        }
                        if (this.dCp != 0) {
                            tabItemView2.setSelectItemColorResId(this.dCp);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (ls(dVar2.tabId)) {
                            am.h(tabItemView2, d.C0142d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.dCe.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.dCh = tabItemView2;
                            tabItemView2.setState(TabItemView.dCA);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d lo(int i) {
        if (i < 0 || this.dCg == null || this.dCg.size() == 0) {
            return null;
        }
        for (d dVar : this.dCg) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean lp(int i) {
        d lo = lo(i);
        return (lo == null || lo.dCy == null || lo.dCy.dmG == null || lo.dCy.dmG.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.dCi = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dCh != null) {
            this.mPaint.setColor(am.getColor(d.C0142d.cp_bg_line_b));
            if (this.dCm) {
                canvas.drawRect(this.dCe.getLeft(), getMeasuredHeight() - this.dCk, this.dCe.getRight() > getRight() ? this.dCe.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.dCo) {
                if (this.dCp == 0) {
                    this.mPaint.setColor(am.d((Resources) null, d.C0142d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.d((Resources) null, this.dCp));
                }
                canvas.drawRect(this.dCh.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.dCj, (this.dCh.getRight() - getBottomLineMargin()) - this.dCh.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.dCo) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.d((Resources) null, d.C0142d.cp_cont_b));
            int e = l.e(getContext(), d.e.ds96);
            if (this.dCh != null) {
                e = this.dCh.getRight() - this.dCh.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.e(getContext(), d.e.tbds44), l.e(getContext(), d.e.tbds98), e, l.e(getContext(), d.e.tbds104)), l.e(getContext(), d.e.tbds6), l.e(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.dCh == null || this.dCd == 0) {
            return 0;
        }
        return ((this.dCh.getMeasuredWidth() - this.dCd) - this.dCh.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void lq(int i) {
        a(ln(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.dCu = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.dCv = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.dCv;
    }

    public void setTabBackgroudColor(int i) {
        this.dCn = i;
    }

    public void setAutoFillTabCount(int i) {
        this.dCl = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void lr(int i) {
        if (this.dCh != null && this.dCu != null) {
            this.dCu.a(this.dCh.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dCq = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.dCr = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.dCo = z;
    }

    public static boolean ls(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.dCm = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.dCp = i;
    }
}
