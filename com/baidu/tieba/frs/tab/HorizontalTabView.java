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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext cOe;
    public int dpE;
    private final LinearLayout dpF;
    private final e dpG;
    private List<d> dpH;
    private TabItemView dpI;
    private com.baidu.tieba.frs.tab.b dpJ;
    private final int dpK;
    private final int dpL;
    private int dpM;
    private boolean dpN;
    private int dpO;
    private boolean dpP;
    private int dpQ;
    private a dpR;
    private b dpS;
    private e.b dpT;
    private e.a dpU;
    private ag dpV;
    private c dpW;
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
        void lg(int i);

        boolean lh(int i);
    }

    public void auI() {
        final as asVar;
        if (this.cOe != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).dpZ) != null && asVar.dbj != null) {
                for (ar arVar : asVar.dbj) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cOe.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0086b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                        if (asVar.dbj.size() > i && asVar.dbj.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.kZ(asVar.dbj.get(i).dbf));
                        }
                    }
                });
                bVar.d(this.cOe);
                bVar.tF();
            }
        }
    }

    public d kZ(int i) {
        if (!v.w(this.dpH)) {
            for (d dVar : this.dpH) {
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
            if (dVar.tabId != 302 && this.dpS != null) {
                this.dpS.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (le(dVar.tabId)) {
                if (this.dpV != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.dby = dVar.url;
                    this.dpV.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.dpV != null) {
                    this.dpV.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.dpV == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.dby = dVar.url;
                    amVar2.stType = dVar.name;
                    this.dpV.a(dVar.tabId, 0, amVar2);
                    if (amVar2.dbz) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.dpF.getChildCount(); i++) {
                    View childAt = this.dpF.getChildAt(i);
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
                    amVar3.dby = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.dpV != null && z) {
                    this.dpV.a(dVar.tabId, 0, amVar3);
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
            if (le(tabItemView.getTabId())) {
                if (this.dpV != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.dby = tabItemView.getUrl();
                    this.dpV.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.dpV != null) {
                    this.dpV.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.dpI = tabItemView;
                int[] iArr = new int[2];
                this.dpI.getLocationOnScreen(iArr);
                int af = l.af(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (af < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.dpF.getChildCount(); i2++) {
                    View childAt = this.dpF.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.dpI.getTabId() && !le(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.dqa);
                        }
                    }
                }
                if (this.dpI.getState() == TabItemView.dqa || this.dpI.getState() == TabItemView.STATE_EXPANDED) {
                    this.dpG.auL();
                    boolean z2 = this.dpI.getState() == TabItemView.dqa;
                    this.dpI.setState(TabItemView.dqb);
                    d la = la(this.dpI.getTabId());
                    if (la != null) {
                        if (!TextUtils.isEmpty(la.url)) {
                            am amVar3 = new am();
                            amVar3.dby = la.url;
                            amVar3.stType = la.name;
                            amVar = amVar3;
                        }
                        if (la.dpZ != null && la.dpZ.dbj != null && la.dpZ.dbj.size() > 0) {
                            for (ar arVar : la.dpZ.dbj) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.dbf;
                                }
                            }
                        }
                        if (z2 && this.dpV != null) {
                            this.dpV.a(this.dpI.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (lb(this.dpI.getTabId()) && !z) {
                    if (this.dpW == null || this.dpW.lh(this.dpI.getTabId())) {
                        this.dpI.setState(TabItemView.STATE_EXPANDED);
                        this.dpG.a((Activity) getContext(), this, this.dpI, la(this.dpI.getTabId()).dpZ);
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
        this.dpE = 0;
        this.dpI = null;
        this.dpJ = null;
        this.mPaint = new Paint();
        this.dpK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.dpL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.dpM = 0;
        this.dpN = true;
        this.dpO = d.C0126d.transparent;
        this.dpQ = 0;
        this.dpT = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void lf(int i) {
                if (HorizontalTabView.this.dpI != null && HorizontalTabView.this.dpV != null && HorizontalTabView.this.dpV != null) {
                    HorizontalTabView.this.dpV.a(HorizontalTabView.this.dpI.getTabId(), i, null);
                }
                if (HorizontalTabView.this.dpJ != null) {
                    HorizontalTabView.this.dpJ.ld(i);
                }
            }
        };
        this.dpU = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d dVar;
                if (HorizontalTabView.this.dpP) {
                    if (view2 instanceof TabItemView) {
                        if (((TabItemView) view2).getTabId() == 1) {
                            if (HorizontalTabView.this.dpR != null) {
                                HorizontalTabView.this.dpR.b(HorizontalTabView.this.kZ(1));
                            }
                            HorizontalTabView.this.auI();
                            return;
                        } else if (((TabItemView) view2).getTabId() == 302) {
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
                if (view2 instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view2, false);
                }
                if (HorizontalTabView.this.dpJ != null) {
                    if (!(view2 instanceof TabItemView) || !HorizontalTabView.le(((TabItemView) view2).getTabId())) {
                        if (HorizontalTabView.this.dpI != null) {
                            HorizontalTabView.this.dpJ.lc(HorizontalTabView.this.dpI.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.dpJ.lc(((TabItemView) view2).getTabId());
                }
            }
        };
        this.dpF = new LinearLayout(context);
        this.dpF.setOrientation(0);
        this.dpF.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.dpG = new e(context, this.dpT, this.dpU);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.dpF, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ak.j(this, d.C0126d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bt(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d la = la(1);
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
        if (la == null || dVar == null) {
            return false;
        }
        if (la.dpZ == null && dVar.dpZ == null) {
            return false;
        }
        if ((la.dpZ != null || dVar.dpZ == null) && (dVar.dpZ != null || la.dpZ == null)) {
            if (la.dpZ == null || dVar.dpZ == null) {
                return false;
            }
            if (la.dpZ.dbj == null && dVar.dpZ.dbj == null) {
                return false;
            }
            if ((la.dpZ.dbj != null || dVar.dpZ.dbj == null) && (dVar.dpZ.dbj != null || la.dpZ.dbj == null)) {
                int size = la.dpZ.dbj.size();
                if (size != dVar.dpZ.dbj.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.dpZ.dbj.get(i);
                    ar arVar2 = la.dpZ.dbj.get(i);
                    if (arVar.dbf != arVar2.dbf || !arVar.name.equals(arVar2.name)) {
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
        if (this.dpP) {
            this.dpH = new ArrayList();
            this.dpH.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.dpZ;
                if (asVar2 != null && asVar2.dbj != null) {
                    asVar2.dbj.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.dbj = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.v(list) > 1) {
                    ar arVar = new ar();
                    arVar.dbf = 1;
                    arVar.name = getContext().getString(d.k.chosen_pb_title);
                    asVar.dbj.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.dbf = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.dbj.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.dpZ = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.dpH = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.dpM > 0 && list.size() == this.dpM) {
            layoutParams = new LinearLayout.LayoutParams(l.af(getContext()) / this.dpM, -1);
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
            this.dpF.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.dpP);
            if (this.dpQ != 0) {
                tabItemView.setSelectItemColorResId(this.dpQ);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.dpF.addView(tabItemView, layoutParams);
            this.dpI = tabItemView;
            tabItemView.setState(TabItemView.dqb);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bt(list)) {
            this.mData = list;
            this.dpF.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.dpP);
                        if (302 == dVar2.tabId) {
                            ak.c(tabItemView2, d.C0126d.cp_cont_j, 1);
                        }
                        if (this.dpQ != 0) {
                            tabItemView2.setSelectItemColorResId(this.dpQ);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (le(dVar2.tabId)) {
                            ak.h(tabItemView2, d.C0126d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.dpF.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.dpI = tabItemView2;
                            tabItemView2.setState(TabItemView.dqb);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d la(int i) {
        if (i < 0 || this.dpH == null || this.dpH.size() == 0) {
            return null;
        }
        for (d dVar : this.dpH) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean lb(int i) {
        d la = la(i);
        return (la == null || la.dpZ == null || la.dpZ.dbj == null || la.dpZ.dbj.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.dpJ = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dpI != null) {
            this.mPaint.setColor(ak.getColor(d.C0126d.cp_bg_line_b));
            if (this.dpN) {
                canvas.drawRect(this.dpF.getLeft(), getMeasuredHeight() - this.dpL, this.dpF.getRight() > getRight() ? this.dpF.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.dpP) {
                if (this.dpQ == 0) {
                    this.mPaint.setColor(ak.d((Resources) null, d.C0126d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ak.d((Resources) null, this.dpQ));
                }
                canvas.drawRect(this.dpI.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.dpK, (this.dpI.getRight() - getBottomLineMargin()) - this.dpI.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.dpP) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ak.d((Resources) null, d.C0126d.cp_cont_b));
            int e = l.e(getContext(), d.e.ds96);
            if (this.dpI != null) {
                e = this.dpI.getRight() - this.dpI.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.e(getContext(), d.e.tbds44), l.e(getContext(), d.e.tbds98), e, l.e(getContext(), d.e.tbds104)), l.e(getContext(), d.e.tbds6), l.e(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.dpI == null || this.dpE == 0) {
            return 0;
        }
        return ((this.dpI.getMeasuredWidth() - this.dpE) - this.dpI.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void lc(int i) {
        a(kZ(i));
    }

    public void setDataLoadInterface(ag agVar) {
        this.dpV = agVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.dpW = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.dpW;
    }

    public void setTabBackgroudColor(int i) {
        this.dpO = i;
    }

    public void setAutoFillTabCount(int i) {
        this.dpM = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void ld(int i) {
        if (this.dpI != null && this.dpV != null) {
            this.dpV.a(this.dpI.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dpR = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.dpS = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.dpP = z;
    }

    public static boolean le(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.dpN = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.dpQ = i;
    }
}
