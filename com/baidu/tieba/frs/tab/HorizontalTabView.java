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
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext dxb;
    public int eeW;
    private final LinearLayout eeX;
    private final e eeY;
    private List<d> eeZ;
    private TabItemView efa;
    private com.baidu.tieba.frs.tab.b efb;
    private final int efc;
    private final int efd;
    private int efe;
    private boolean eff;
    private int efg;
    private boolean efh;
    private int efi;
    private a efj;
    private b efk;
    private e.b efl;
    private e.a efm;
    private ai efn;
    private c efo;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes6.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void nB(int i);

        boolean nC(int i);
    }

    public void aHY() {
        final au auVar;
        if (this.dxb != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).efr) != null && auVar.dOQ != null) {
                for (at atVar : auVar.dOQ) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.dxb.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.dOQ.size() > i && auVar.dOQ.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.nu(auVar.dOQ.get(i).dOM));
                        }
                    }
                });
                bVar.d(this.dxb);
                bVar.BV();
            }
        }
    }

    public d nu(int i) {
        if (!v.I(this.eeZ)) {
            for (d dVar : this.eeZ) {
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
            if (dVar.tabId != 302 && this.efk != null) {
                this.efk.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (nz(dVar.tabId)) {
                if (this.efn != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dPm = dVar.url;
                    this.efn.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.efn != null) {
                    this.efn.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.efn == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dPm = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.efn.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dPn) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.eeX.getChildCount(); i++) {
                    View childAt = this.eeX.getChildAt(i);
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
                    aoVar3.dPm = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.efn != null && z) {
                    this.efn.a(dVar.tabId, 0, aoVar3);
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
            if (nz(tabItemView.getTabId())) {
                if (this.efn != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dPm = tabItemView.getUrl();
                    this.efn.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.efn != null) {
                    this.efn.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.efa = tabItemView;
                int[] iArr = new int[2];
                this.efa.getLocationOnScreen(iArr);
                int aO = l.aO(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.C0210e.ds160);
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
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(e.C0210e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.eeX.getChildCount(); i2++) {
                    View childAt = this.eeX.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.efa.getTabId() && !nz(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.efs);
                        }
                    }
                }
                if (this.efa.getState() == TabItemView.efs || this.efa.getState() == TabItemView.STATE_EXPANDED) {
                    this.eeY.dismissMenu();
                    boolean z2 = this.efa.getState() == TabItemView.efs;
                    this.efa.setState(TabItemView.eft);
                    d nv = nv(this.efa.getTabId());
                    if (nv != null) {
                        if (!TextUtils.isEmpty(nv.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dPm = nv.url;
                            aoVar3.stType = nv.name;
                            aoVar = aoVar3;
                        }
                        if (nv.efr != null && nv.efr.dOQ != null && nv.efr.dOQ.size() > 0) {
                            for (at atVar : nv.efr.dOQ) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dOM;
                                }
                            }
                        }
                        if (z2 && this.efn != null) {
                            this.efn.a(this.efa.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (nw(this.efa.getTabId()) && !z) {
                    if (this.efo == null || this.efo.nC(this.efa.getTabId())) {
                        this.efa.setState(TabItemView.STATE_EXPANDED);
                        this.eeY.a((Activity) getContext(), this, this.efa, nv(this.efa.getTabId()).efr);
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
        this.eeW = 0;
        this.efa = null;
        this.efb = null;
        this.mPaint = new Paint();
        this.efc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds6);
        this.efd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.efe = 0;
        this.eff = true;
        this.efg = e.d.transparent;
        this.efi = 0;
        this.efl = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void nA(int i) {
                if (HorizontalTabView.this.efa != null && HorizontalTabView.this.efn != null && HorizontalTabView.this.efn != null) {
                    HorizontalTabView.this.efn.a(HorizontalTabView.this.efa.getTabId(), i, null);
                }
                if (HorizontalTabView.this.efb != null) {
                    HorizontalTabView.this.efb.ny(i);
                }
            }
        };
        this.efm = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.efh) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.efj != null) {
                                HorizontalTabView.this.efj.b(HorizontalTabView.this.nu(1));
                            }
                            HorizontalTabView.this.aHY();
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
                if (HorizontalTabView.this.efb != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.nz(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.efa != null) {
                            HorizontalTabView.this.efb.nx(HorizontalTabView.this.efa.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.efb.nx(((TabItemView) view).getTabId());
                }
            }
        };
        this.eeX = new LinearLayout(context);
        this.eeX.setOrientation(0);
        this.eeX.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(e.C0210e.ds88));
        this.eeY = new e(context, this.efl, this.efm);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.eeX, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.j(this, e.d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bS(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d nv = nv(1);
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
        if (nv == null || dVar == null) {
            return false;
        }
        if (nv.efr == null && dVar.efr == null) {
            return false;
        }
        if ((nv.efr != null || dVar.efr == null) && (dVar.efr != null || nv.efr == null)) {
            if (nv.efr == null || dVar.efr == null) {
                return false;
            }
            if (nv.efr.dOQ == null && dVar.efr.dOQ == null) {
                return false;
            }
            if ((nv.efr.dOQ != null || dVar.efr.dOQ == null) && (dVar.efr.dOQ != null || nv.efr.dOQ == null)) {
                int size = nv.efr.dOQ.size();
                if (size != dVar.efr.dOQ.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.efr.dOQ.get(i);
                    at atVar2 = nv.efr.dOQ.get(i);
                    if (atVar.dOM != atVar2.dOM || !atVar.name.equals(atVar2.name)) {
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
        if (this.efh) {
            this.eeZ = new ArrayList();
            this.eeZ.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.efr;
                if (auVar2 != null && auVar2.dOQ != null) {
                    auVar2.dOQ.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.dOQ = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.H(list) > 1) {
                    at atVar = new at();
                    atVar.dOM = 1;
                    atVar.name = getContext().getString(e.j.chosen_pb_title);
                    auVar.dOQ.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.dOM = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.dOQ.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.efr = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.eeZ = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.efe > 0 && list.size() == this.efe) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.efe, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.C0210e.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.tabId = 1;
            dVar.name = getContext().getResources().getString(e.j.chosen_pb_title);
            this.eeX.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.efh);
            if (this.efi != 0) {
                tabItemView.setSelectItemColorResId(this.efi);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0210e.ds32);
            this.eeX.addView(tabItemView, layoutParams);
            this.efa = tabItemView;
            tabItemView.setState(TabItemView.eft);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bS(list)) {
            this.mData = list;
            this.eeX.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.efh);
                        if (302 == dVar2.tabId) {
                            al.c(tabItemView2, e.d.cp_cont_j, 1);
                        }
                        if (this.efi != 0) {
                            tabItemView2.setSelectItemColorResId(this.efi);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (nz(dVar2.tabId)) {
                            al.h(tabItemView2, e.d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0210e.tbds44);
                        }
                        this.eeX.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.efa = tabItemView2;
                            tabItemView2.setState(TabItemView.eft);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d nv(int i) {
        if (i < 0 || this.eeZ == null || this.eeZ.size() == 0) {
            return null;
        }
        for (d dVar : this.eeZ) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean nw(int i) {
        d nv = nv(i);
        return (nv == null || nv.efr == null || nv.efr.dOQ == null || nv.efr.dOQ.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.efb = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.efa != null) {
            this.mPaint.setColor(al.getColor(e.d.cp_bg_line_b));
            if (this.eff) {
                canvas.drawRect(this.eeX.getLeft(), getMeasuredHeight() - this.efd, this.eeX.getRight() > getRight() ? this.eeX.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.efh) {
                if (this.efi == 0) {
                    this.mPaint.setColor(al.d((Resources) null, e.d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.efi));
                }
                canvas.drawRect(this.efa.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.efc, (this.efa.getRight() - getBottomLineMargin()) - this.efa.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.efh) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, e.d.cp_cont_b));
            int h = l.h(getContext(), e.C0210e.ds96);
            if (this.efa != null) {
                h = this.efa.getRight() - this.efa.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), e.C0210e.tbds44), l.h(getContext(), e.C0210e.tbds98), h, l.h(getContext(), e.C0210e.tbds104)), l.h(getContext(), e.C0210e.tbds6), l.h(getContext(), e.C0210e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.efa == null || this.eeW == 0) {
            return 0;
        }
        return ((this.efa.getMeasuredWidth() - this.eeW) - this.efa.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void nx(int i) {
        a(nu(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.efn = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.efo = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.efo;
    }

    public void setTabBackgroudColor(int i) {
        this.efg = i;
    }

    public void setAutoFillTabCount(int i) {
        this.efe = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void ny(int i) {
        if (this.efa != null && this.efn != null) {
            this.efn.a(this.efa.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.efj = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.efk = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.efh = z;
    }

    public static boolean nz(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.eff = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.efi = i;
    }
}
