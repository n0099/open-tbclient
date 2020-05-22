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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    public int hJa;
    private final LinearLayout hJb;
    private final e hJc;
    private List<d> hJd;
    private TabItemView hJe;
    private com.baidu.tieba.frs.tab.b hJf;
    private final int hJg;
    private final int hJh;
    private int hJi;
    private boolean hJj;
    private int hJk;
    private boolean hJl;
    private int hJm;
    private a hJn;
    private b hJo;
    private e.b hJp;
    private e.a hJq;
    private ak hJr;
    private c hJs;
    private TbPageContext hci;
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
        void vk(int i);

        boolean vl(int i);
    }

    public void caS() {
        final ay ayVar;
        if (this.hci != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (ayVar = this.mData.get(0).hJv) != null && ayVar.hqX != null) {
                for (ax axVar : ayVar.hqX) {
                    if (axVar != null) {
                        arrayList.add(axVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hci.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (ayVar.hqX.size() > i && ayVar.hqX.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.vd(ayVar.hqX.get(i).hqT));
                        }
                    }
                });
                bVar.d(this.hci);
                bVar.aSU();
            }
        }
    }

    public d vd(int i) {
        if (!v.isEmpty(this.hJd)) {
            for (d dVar : this.hJd) {
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
            if (dVar.tabId != 302 && this.hJo != null) {
                this.hJo.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (vi(dVar.tabId)) {
                if (this.hJr != null && !TextUtils.isEmpty(dVar.url)) {
                    as asVar = new as();
                    asVar.ext = dVar.url;
                    this.hJr.a(dVar.tabId, -1, asVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.hJr != null) {
                    this.hJr.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.hJr == null) {
                    z = true;
                } else {
                    as asVar2 = new as();
                    asVar2.ext = dVar.url;
                    asVar2.stType = dVar.name;
                    this.hJr.a(dVar.tabId, 0, asVar2);
                    if (asVar2.hrn) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.hJb.getChildCount(); i++) {
                    View childAt = this.hJb.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                as asVar3 = null;
                if (!TextUtils.isEmpty(dVar.url)) {
                    asVar3 = new as();
                    asVar3.ext = dVar.url;
                    asVar3.stType = dVar.name;
                }
                if (this.hJr != null && z) {
                    this.hJr.a(dVar.tabId, 0, asVar3);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        as asVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (vi(tabItemView.getTabId())) {
                if (this.hJr != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    as asVar2 = new as();
                    asVar2.ext = tabItemView.getUrl();
                    this.hJr.a(tabItemView.getTabId(), -1, asVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.hJr != null) {
                    this.hJr.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.hJe = tabItemView;
                int[] iArr = new int[2];
                this.hJe.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.hJb.getChildCount(); i2++) {
                    View childAt = this.hJb.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.hJe.getTabId() && !vi(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.hJw);
                        }
                    }
                }
                if (this.hJe.getState() == TabItemView.hJw || this.hJe.getState() == TabItemView.STATE_EXPANDED) {
                    this.hJc.dismissMenu();
                    boolean z2 = this.hJe.getState() == TabItemView.hJw;
                    this.hJe.setState(TabItemView.hJx);
                    d ve = ve(this.hJe.getTabId());
                    if (ve != null) {
                        if (!TextUtils.isEmpty(ve.url)) {
                            as asVar3 = new as();
                            asVar3.ext = ve.url;
                            asVar3.stType = ve.name;
                            asVar = asVar3;
                        }
                        if (ve.hJv != null && ve.hJv.hqX != null && ve.hJv.hqX.size() > 0) {
                            for (ax axVar : ve.hJv.hqX) {
                                if (axVar != null && axVar.isSelected) {
                                    i = axVar.hqT;
                                }
                            }
                        }
                        if (z2 && this.hJr != null) {
                            this.hJr.a(this.hJe.getTabId(), i, asVar);
                        }
                    } else {
                        return;
                    }
                } else if (vf(this.hJe.getTabId()) && !z) {
                    if (this.hJs == null || this.hJs.vl(this.hJe.getTabId())) {
                        this.hJe.setState(TabItemView.STATE_EXPANDED);
                        this.hJc.a((Activity) getContext(), this, this.hJe, ve(this.hJe.getTabId()).hJv);
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
        this.hJa = 0;
        this.hJe = null;
        this.hJf = null;
        this.mPaint = new Paint();
        this.hJg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.hJh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.hJi = 0;
        this.hJj = true;
        this.hJk = R.color.transparent;
        this.hJm = 0;
        this.hJp = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void vj(int i) {
                if (HorizontalTabView.this.hJe != null && HorizontalTabView.this.hJr != null && HorizontalTabView.this.hJr != null) {
                    HorizontalTabView.this.hJr.a(HorizontalTabView.this.hJe.getTabId(), i, null);
                }
                if (HorizontalTabView.this.hJf != null) {
                    HorizontalTabView.this.hJf.vh(i);
                }
            }
        };
        this.hJq = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.hJl) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.hJn != null) {
                                HorizontalTabView.this.hJn.b(HorizontalTabView.this.vd(1));
                            }
                            HorizontalTabView.this.caS();
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
                if (HorizontalTabView.this.hJf != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.vi(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.hJe != null) {
                            HorizontalTabView.this.hJf.vg(HorizontalTabView.this.hJe.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.hJf.vg(((TabItemView) view).getTabId());
                }
            }
        };
        this.hJb = new LinearLayout(context);
        this.hJb.setOrientation(0);
        this.hJb.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.hJc = new e(context, this.hJp, this.hJq);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.hJb, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        am.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cz(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d ve = ve(1);
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
        if (ve == null || dVar == null) {
            return false;
        }
        if (ve.hJv == null && dVar.hJv == null) {
            return false;
        }
        if ((ve.hJv != null || dVar.hJv == null) && (dVar.hJv != null || ve.hJv == null)) {
            if (ve.hJv == null || dVar.hJv == null) {
                return false;
            }
            if (ve.hJv.hqX == null && dVar.hJv.hqX == null) {
                return false;
            }
            if ((ve.hJv.hqX != null || dVar.hJv.hqX == null) && (dVar.hJv.hqX != null || ve.hJv.hqX == null)) {
                int size = ve.hJv.hqX.size();
                if (size != dVar.hJv.hqX.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ax axVar = dVar.hJv.hqX.get(i);
                    ax axVar2 = ve.hJv.hqX.get(i);
                    if (axVar.hqT != axVar2.hqT || !axVar.name.equals(axVar2.name)) {
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
        ay ayVar;
        if (this.hJl) {
            this.hJd = new ArrayList();
            this.hJd.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                ay ayVar2 = dVar.hJv;
                if (ayVar2 != null && ayVar2.hqX != null) {
                    ayVar2.hqX.clear();
                    ayVar = ayVar2;
                } else {
                    ay ayVar3 = new ay();
                    ayVar3.hqX = new ArrayList();
                    ayVar = ayVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    ax axVar = new ax();
                    axVar.hqT = 1;
                    axVar.name = getContext().getString(R.string.chosen_pb_title);
                    ayVar.hqX.add(axVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ax axVar2 = new ax();
                            axVar2.hqT = dVar3.tabId;
                            axVar2.name = dVar3.name;
                            ayVar.hqX.add(axVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.hJv = ayVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.hJd = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.hJi > 0 && list.size() == this.hJi) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.hJi, -1);
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
            this.hJb.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.hJl);
            if (this.hJm != 0) {
                tabItemView.setSelectItemColorResId(this.hJm);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.hJb.addView(tabItemView, layoutParams);
            this.hJe = tabItemView;
            tabItemView.setState(TabItemView.hJx);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cz(list)) {
            this.mData = list;
            this.hJb.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.hJl);
                        if (302 == dVar2.tabId) {
                            am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.hJm != 0) {
                            tabItemView2.setSelectItemColorResId(this.hJm);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (vi(dVar2.tabId)) {
                            am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.hJb.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.hJe = tabItemView2;
                            tabItemView2.setState(TabItemView.hJx);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d ve(int i) {
        if (i < 0 || this.hJd == null || this.hJd.size() == 0) {
            return null;
        }
        for (d dVar : this.hJd) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean vf(int i) {
        d ve = ve(i);
        return (ve == null || ve.hJv == null || ve.hJv.hqX == null || ve.hJv.hqX.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.hJf = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hJe != null) {
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
            if (this.hJj) {
                canvas.drawRect(this.hJb.getLeft(), getMeasuredHeight() - this.hJh, this.hJb.getRight() > getRight() ? this.hJb.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.hJl) {
                if (this.hJm == 0) {
                    this.mPaint.setColor(am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.getSkinColor(null, this.hJm));
                }
                canvas.drawRect(this.hJe.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.hJg, (this.hJe.getRight() - getBottomLineMargin()) - this.hJe.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.hJl) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.hJe != null) {
                dimens = this.hJe.getRight() - this.hJe.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.hJe == null || this.hJa == 0) {
            return 0;
        }
        return ((this.hJe.getMeasuredWidth() - this.hJa) - this.hJe.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void vg(int i) {
        a(vd(i));
    }

    public void setDataLoadInterface(ak akVar) {
        this.hJr = akVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.hJs = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.hJs;
    }

    public void setTabBackgroudColor(int i) {
        this.hJk = i;
    }

    public void setAutoFillTabCount(int i) {
        this.hJi = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void vh(int i) {
        if (this.hJe != null && this.hJr != null) {
            this.hJr.a(this.hJe.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.hJn = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.hJo = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.hJl = z;
    }

    public static boolean vi(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.hJj = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.hJm = i;
    }
}
