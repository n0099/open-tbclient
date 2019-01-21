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
    private TbPageContext dxc;
    public int eeX;
    private final LinearLayout eeY;
    private final e eeZ;
    private List<d> efa;
    private TabItemView efb;
    private com.baidu.tieba.frs.tab.b efc;
    private final int efd;
    private final int efe;
    private int eff;
    private boolean efg;
    private int efh;
    private boolean efi;
    private int efj;
    private a efk;
    private b efl;
    private e.b efm;
    private e.a efn;
    private ai efo;
    private c efp;
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
        if (this.dxc != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).efs) != null && auVar.dOR != null) {
                for (at atVar : auVar.dOR) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.dxc.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0158b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.dOR.size() > i && auVar.dOR.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.nu(auVar.dOR.get(i).dON));
                        }
                    }
                });
                bVar.d(this.dxc);
                bVar.BV();
            }
        }
    }

    public d nu(int i) {
        if (!v.I(this.efa)) {
            for (d dVar : this.efa) {
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
            if (dVar.tabId != 302 && this.efl != null) {
                this.efl.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (nz(dVar.tabId)) {
                if (this.efo != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dPn = dVar.url;
                    this.efo.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.efo != null) {
                    this.efo.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.efo == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dPn = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.efo.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dPo) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.eeY.getChildCount(); i++) {
                    View childAt = this.eeY.getChildAt(i);
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
                    aoVar3.dPn = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.efo != null && z) {
                    this.efo.a(dVar.tabId, 0, aoVar3);
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
                if (this.efo != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dPn = tabItemView.getUrl();
                    this.efo.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.efo != null) {
                    this.efo.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.efb = tabItemView;
                int[] iArr = new int[2];
                this.efb.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.eeY.getChildCount(); i2++) {
                    View childAt = this.eeY.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.efb.getTabId() && !nz(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.eft);
                        }
                    }
                }
                if (this.efb.getState() == TabItemView.eft || this.efb.getState() == TabItemView.STATE_EXPANDED) {
                    this.eeZ.dismissMenu();
                    boolean z2 = this.efb.getState() == TabItemView.eft;
                    this.efb.setState(TabItemView.efu);
                    d nv = nv(this.efb.getTabId());
                    if (nv != null) {
                        if (!TextUtils.isEmpty(nv.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dPn = nv.url;
                            aoVar3.stType = nv.name;
                            aoVar = aoVar3;
                        }
                        if (nv.efs != null && nv.efs.dOR != null && nv.efs.dOR.size() > 0) {
                            for (at atVar : nv.efs.dOR) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dON;
                                }
                            }
                        }
                        if (z2 && this.efo != null) {
                            this.efo.a(this.efb.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (nw(this.efb.getTabId()) && !z) {
                    if (this.efp == null || this.efp.nC(this.efb.getTabId())) {
                        this.efb.setState(TabItemView.STATE_EXPANDED);
                        this.eeZ.a((Activity) getContext(), this, this.efb, nv(this.efb.getTabId()).efs);
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
        this.eeX = 0;
        this.efb = null;
        this.efc = null;
        this.mPaint = new Paint();
        this.efd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds6);
        this.efe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.ds1);
        this.eff = 0;
        this.efg = true;
        this.efh = e.d.transparent;
        this.efj = 0;
        this.efm = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void nA(int i) {
                if (HorizontalTabView.this.efb != null && HorizontalTabView.this.efo != null && HorizontalTabView.this.efo != null) {
                    HorizontalTabView.this.efo.a(HorizontalTabView.this.efb.getTabId(), i, null);
                }
                if (HorizontalTabView.this.efc != null) {
                    HorizontalTabView.this.efc.ny(i);
                }
            }
        };
        this.efn = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.efi) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.efk != null) {
                                HorizontalTabView.this.efk.b(HorizontalTabView.this.nu(1));
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
                if (HorizontalTabView.this.efc != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.nz(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.efb != null) {
                            HorizontalTabView.this.efc.nx(HorizontalTabView.this.efb.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.efc.nx(((TabItemView) view).getTabId());
                }
            }
        };
        this.eeY = new LinearLayout(context);
        this.eeY.setOrientation(0);
        this.eeY.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(e.C0210e.ds88));
        this.eeZ = new e(context, this.efm, this.efn);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.eeY, layoutParams);
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
        if (nv.efs == null && dVar.efs == null) {
            return false;
        }
        if ((nv.efs != null || dVar.efs == null) && (dVar.efs != null || nv.efs == null)) {
            if (nv.efs == null || dVar.efs == null) {
                return false;
            }
            if (nv.efs.dOR == null && dVar.efs.dOR == null) {
                return false;
            }
            if ((nv.efs.dOR != null || dVar.efs.dOR == null) && (dVar.efs.dOR != null || nv.efs.dOR == null)) {
                int size = nv.efs.dOR.size();
                if (size != dVar.efs.dOR.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.efs.dOR.get(i);
                    at atVar2 = nv.efs.dOR.get(i);
                    if (atVar.dON != atVar2.dON || !atVar.name.equals(atVar2.name)) {
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
        if (this.efi) {
            this.efa = new ArrayList();
            this.efa.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.efs;
                if (auVar2 != null && auVar2.dOR != null) {
                    auVar2.dOR.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.dOR = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.H(list) > 1) {
                    at atVar = new at();
                    atVar.dON = 1;
                    atVar.name = getContext().getString(e.j.chosen_pb_title);
                    auVar.dOR.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.dON = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.dOR.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.efs = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.efa = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.eff > 0 && list.size() == this.eff) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.eff, -1);
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
            this.eeY.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.efi);
            if (this.efj != 0) {
                tabItemView.setSelectItemColorResId(this.efj);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0210e.ds32);
            this.eeY.addView(tabItemView, layoutParams);
            this.efb = tabItemView;
            tabItemView.setState(TabItemView.efu);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bS(list)) {
            this.mData = list;
            this.eeY.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.efi);
                        if (302 == dVar2.tabId) {
                            al.c(tabItemView2, e.d.cp_cont_j, 1);
                        }
                        if (this.efj != 0) {
                            tabItemView2.setSelectItemColorResId(this.efj);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (nz(dVar2.tabId)) {
                            al.h(tabItemView2, e.d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0210e.tbds44);
                        }
                        this.eeY.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.efb = tabItemView2;
                            tabItemView2.setState(TabItemView.efu);
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
        if (i < 0 || this.efa == null || this.efa.size() == 0) {
            return null;
        }
        for (d dVar : this.efa) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean nw(int i) {
        d nv = nv(i);
        return (nv == null || nv.efs == null || nv.efs.dOR == null || nv.efs.dOR.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.efc = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.efb != null) {
            this.mPaint.setColor(al.getColor(e.d.cp_bg_line_b));
            if (this.efg) {
                canvas.drawRect(this.eeY.getLeft(), getMeasuredHeight() - this.efe, this.eeY.getRight() > getRight() ? this.eeY.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.efi) {
                if (this.efj == 0) {
                    this.mPaint.setColor(al.d((Resources) null, e.d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.efj));
                }
                canvas.drawRect(this.efb.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.efd, (this.efb.getRight() - getBottomLineMargin()) - this.efb.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.efi) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, e.d.cp_cont_b));
            int h = l.h(getContext(), e.C0210e.ds96);
            if (this.efb != null) {
                h = this.efb.getRight() - this.efb.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), e.C0210e.tbds44), l.h(getContext(), e.C0210e.tbds98), h, l.h(getContext(), e.C0210e.tbds104)), l.h(getContext(), e.C0210e.tbds6), l.h(getContext(), e.C0210e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.efb == null || this.eeX == 0) {
            return 0;
        }
        return ((this.efb.getMeasuredWidth() - this.eeX) - this.efb.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void nx(int i) {
        a(nu(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.efo = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.efp = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.efp;
    }

    public void setTabBackgroudColor(int i) {
        this.efh = i;
    }

    public void setAutoFillTabCount(int i) {
        this.eff = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void ny(int i) {
        if (this.efb != null && this.efo != null) {
            this.efo.a(this.efb.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.efk = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.efl = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.efi = z;
    }

    public static boolean nz(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.efg = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.efj = i;
    }
}
