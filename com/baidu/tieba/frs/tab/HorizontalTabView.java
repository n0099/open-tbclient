package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    public int hWZ;
    private final LinearLayout hXa;
    private final e hXb;
    private List<d> hXc;
    private TabItemView hXd;
    private com.baidu.tieba.frs.tab.b hXe;
    private final int hXf;
    private final int hXg;
    private int hXh;
    private boolean hXi;
    private int hXj;
    private boolean hXk;
    private int hXl;
    private a hXm;
    private b hXn;
    private e.b hXo;
    private e.a hXp;
    private ap hXq;
    private c hXr;
    private TbPageContext hoE;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes9.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes9.dex */
    public interface c {
        void vR(int i);

        boolean vS(int i);
    }

    public void cet() {
        final be beVar;
        if (this.hoE != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (beVar = this.mData.get(0).hXu) != null && beVar.hDV != null) {
                for (bd bdVar : beVar.hDV) {
                    if (bdVar != null) {
                        arrayList.add(bdVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hoE.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (beVar.hDV.size() > i && beVar.hDV.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.vK(beVar.hDV.get(i).hDR));
                        }
                    }
                });
                bVar.d(this.hoE);
                bVar.aUO();
            }
        }
    }

    public d vK(int i) {
        if (!w.isEmpty(this.hXc)) {
            for (d dVar : this.hXc) {
                if (dVar != null && dVar.tabId == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void a(d dVar) {
        boolean z;
        ay ayVar;
        if (dVar != null) {
            if (this.hXn != null) {
                this.hXn.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (vP(dVar.tabId)) {
                if (this.hXq != null && !TextUtils.isEmpty(dVar.url)) {
                    ay ayVar2 = new ay();
                    ayVar2.ext = dVar.url;
                    this.hXq.a(dVar.tabId, -1, ayVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.hXq != null) {
                    this.hXq.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.hXq == null) {
                    z = true;
                } else {
                    ay ayVar3 = new ay();
                    ayVar3.ext = dVar.url;
                    ayVar3.stType = dVar.name;
                    this.hXq.a(dVar.tabId, 0, ayVar3);
                    if (ayVar3.hEp) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.hXa.getChildCount(); i++) {
                    View childAt = this.hXa.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(dVar.url)) {
                    ayVar = null;
                } else {
                    ayVar = new ay();
                    ayVar.ext = dVar.url;
                    ayVar.stType = dVar.name;
                }
                if (this.hXq != null && z) {
                    this.hXq.a(dVar.tabId, 0, ayVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ay ayVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (vP(tabItemView.getTabId())) {
                if (this.hXq != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ay ayVar2 = new ay();
                    ayVar2.ext = tabItemView.getUrl();
                    this.hXq.a(tabItemView.getTabId(), -1, ayVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.hXq != null) {
                    this.hXq.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.hXd = tabItemView;
                int[] iArr = new int[2];
                this.hXd.getLocationOnScreen(iArr);
                int equipmentWidth = l.getEquipmentWidth(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (equipmentWidth < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.hXa.getChildCount(); i2++) {
                    View childAt = this.hXa.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.hXd.getTabId() && !vP(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.hXv);
                        }
                    }
                }
                if (this.hXd.getState() == TabItemView.hXv || this.hXd.getState() == TabItemView.STATE_EXPANDED) {
                    this.hXb.dismissMenu();
                    boolean z2 = this.hXd.getState() == TabItemView.hXv;
                    this.hXd.setState(TabItemView.hXw);
                    d vL = vL(this.hXd.getTabId());
                    if (vL != null) {
                        if (!TextUtils.isEmpty(vL.url)) {
                            ay ayVar3 = new ay();
                            ayVar3.ext = vL.url;
                            ayVar3.stType = vL.name;
                            ayVar = ayVar3;
                        }
                        if (vL.hXu != null && vL.hXu.hDV != null && vL.hXu.hDV.size() > 0) {
                            for (bd bdVar : vL.hXu.hDV) {
                                if (bdVar != null && bdVar.isSelected) {
                                    i = bdVar.hDR;
                                }
                            }
                        }
                        if (z2 && this.hXq != null) {
                            this.hXq.a(this.hXd.getTabId(), i, ayVar);
                        }
                    } else {
                        return;
                    }
                } else if (vM(this.hXd.getTabId()) && !z) {
                    if (this.hXr == null || this.hXr.vS(this.hXd.getTabId())) {
                        this.hXd.setState(TabItemView.STATE_EXPANDED);
                        this.hXb.a((Activity) getContext(), this, this.hXd, vL(this.hXd.getTabId()).hXu);
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
        this.hWZ = 0;
        this.hXd = null;
        this.hXe = null;
        this.mPaint = new Paint();
        this.hXf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.hXg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.hXh = 0;
        this.hXi = true;
        this.hXj = R.color.transparent;
        this.hXl = 0;
        this.hXo = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void vQ(int i) {
                if (HorizontalTabView.this.hXd != null && HorizontalTabView.this.hXq != null && HorizontalTabView.this.hXq != null) {
                    HorizontalTabView.this.hXq.a(HorizontalTabView.this.hXd.getTabId(), i, null);
                }
                if (HorizontalTabView.this.hXe != null) {
                    HorizontalTabView.this.hXe.vO(i);
                }
            }
        };
        this.hXp = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.hXk) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.hXm != null) {
                            HorizontalTabView.this.hXm.b(HorizontalTabView.this.vK(1));
                        }
                        HorizontalTabView.this.cet();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.hXe != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.vP(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.hXd != null) {
                            HorizontalTabView.this.hXe.vN(HorizontalTabView.this.hXd.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.hXe.vN(((TabItemView) view).getTabId());
                }
            }
        };
        this.hXa = new LinearLayout(context);
        this.hXa.setOrientation(0);
        this.hXa.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.hXb = new e(context, this.hXo, this.hXp);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.hXa, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        an.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cK(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d vL = vL(1);
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
        if (vL == null || dVar == null) {
            return false;
        }
        if (vL.hXu == null && dVar.hXu == null) {
            return false;
        }
        if ((vL.hXu != null || dVar.hXu == null) && (dVar.hXu != null || vL.hXu == null)) {
            if (vL.hXu == null || dVar.hXu == null) {
                return false;
            }
            if (vL.hXu.hDV == null && dVar.hXu.hDV == null) {
                return false;
            }
            if ((vL.hXu.hDV != null || dVar.hXu.hDV == null) && (dVar.hXu.hDV != null || vL.hXu.hDV == null)) {
                int size = vL.hXu.hDV.size();
                if (size != dVar.hXu.hDV.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bd bdVar = dVar.hXu.hDV.get(i);
                    bd bdVar2 = vL.hXu.hDV.get(i);
                    if (bdVar.hDR != bdVar2.hDR || !bdVar.name.equals(bdVar2.name)) {
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
        be beVar;
        if (this.hXk) {
            this.hXc = new ArrayList();
            this.hXc.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                be beVar2 = dVar.hXu;
                if (beVar2 != null && beVar2.hDV != null) {
                    beVar2.hDV.clear();
                    beVar = beVar2;
                } else {
                    be beVar3 = new be();
                    beVar3.hDV = new ArrayList();
                    beVar = beVar3;
                }
                if (w.getCount(list) > 1) {
                    bd bdVar = new bd();
                    bdVar.hDR = 1;
                    bdVar.name = getContext().getString(R.string.chosen_pb_title);
                    beVar.hDV.add(bdVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bd bdVar2 = new bd();
                            bdVar2.hDR = dVar2.tabId;
                            bdVar2.name = dVar2.name;
                            beVar.hDV.add(bdVar2);
                        }
                    }
                    dVar.hXu = beVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.hXc = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.hXh > 0 && list.size() == this.hXh) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.hXh, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.tabId = 1;
            dVar.name = getContext().getResources().getString(R.string.chosen_pb_title);
            this.hXa.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.hXk);
            if (this.hXl != 0) {
                tabItemView.setSelectItemColorResId(this.hXl);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.hXa.addView(tabItemView, layoutParams);
            this.hXd = tabItemView;
            tabItemView.setState(TabItemView.hXw);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cK(list)) {
            this.mData = list;
            this.hXa.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.hXk);
                        if (this.hXl != 0) {
                            tabItemView2.setSelectItemColorResId(this.hXl);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (vP(dVar2.tabId)) {
                            an.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.hXa.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.hXd = tabItemView2;
                            tabItemView2.setState(TabItemView.hXw);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d vL(int i) {
        if (i < 0 || this.hXc == null || this.hXc.size() == 0) {
            return null;
        }
        for (d dVar : this.hXc) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean vM(int i) {
        d vL = vL(i);
        return (vL == null || vL.hXu == null || vL.hXu.hDV == null || vL.hXu.hDV.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.hXe = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hXd != null) {
            this.mPaint.setColor(an.getColor(R.color.cp_bg_line_c));
            if (this.hXi) {
                canvas.drawRect(this.hXa.getLeft(), getMeasuredHeight() - this.hXg, this.hXa.getRight() > getRight() ? this.hXa.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.hXk) {
                if (this.hXl == 0) {
                    this.mPaint.setColor(an.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(an.getSkinColor(null, this.hXl));
                }
                canvas.drawRect(this.hXd.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.hXf, (this.hXd.getRight() - getBottomLineMargin()) - this.hXd.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.hXk) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(an.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.hXd != null) {
                dimens = this.hXd.getRight() - this.hXd.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.hXd == null || this.hWZ == 0) {
            return 0;
        }
        return ((this.hXd.getMeasuredWidth() - this.hWZ) - this.hXd.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void vN(int i) {
        a(vK(i));
    }

    public void setDataLoadInterface(ap apVar) {
        this.hXq = apVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.hXr = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.hXr;
    }

    public void setTabBackgroudColor(int i) {
        this.hXj = i;
    }

    public void setAutoFillTabCount(int i) {
        this.hXh = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void vO(int i) {
        if (this.hXd != null && this.hXq != null) {
            this.hXq.a(this.hXd.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.hXm = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.hXn = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.hXk = z;
    }

    public static boolean vP(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.hXi = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.hXl = i;
    }
}
