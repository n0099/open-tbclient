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
    private TbPageContext gNw;
    private a huA;
    private b huB;
    private e.b huC;
    private e.a huD;
    private ak huE;
    private c huF;
    public int hun;
    private final LinearLayout huo;
    private final e hup;
    private List<d> huq;
    private TabItemView hur;
    private com.baidu.tieba.frs.tab.b hus;
    private final int hut;
    private final int huu;
    private int huv;
    private boolean huw;
    private int hux;
    private boolean huy;
    private int huz;
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
        void uE(int i);

        boolean uF(int i);
    }

    public void bUv() {
        final ay ayVar;
        if (this.gNw != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (ayVar = this.mData.get(0).huI) != null && ayVar.hcj != null) {
                for (ax axVar : ayVar.hcj) {
                    if (axVar != null) {
                        arrayList.add(axVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gNw.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (ayVar.hcj.size() > i && ayVar.hcj.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.ux(ayVar.hcj.get(i).hcf));
                        }
                    }
                });
                bVar.d(this.gNw);
                bVar.aMT();
            }
        }
    }

    public d ux(int i) {
        if (!v.isEmpty(this.huq)) {
            for (d dVar : this.huq) {
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
            if (dVar.tabId != 302 && this.huB != null) {
                this.huB.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (uC(dVar.tabId)) {
                if (this.huE != null && !TextUtils.isEmpty(dVar.url)) {
                    as asVar = new as();
                    asVar.ext = dVar.url;
                    this.huE.a(dVar.tabId, -1, asVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.huE != null) {
                    this.huE.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.huE == null) {
                    z = true;
                } else {
                    as asVar2 = new as();
                    asVar2.ext = dVar.url;
                    asVar2.stType = dVar.name;
                    this.huE.a(dVar.tabId, 0, asVar2);
                    if (asVar2.hcz) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.huo.getChildCount(); i++) {
                    View childAt = this.huo.getChildAt(i);
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
                if (this.huE != null && z) {
                    this.huE.a(dVar.tabId, 0, asVar3);
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
            if (uC(tabItemView.getTabId())) {
                if (this.huE != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    as asVar2 = new as();
                    asVar2.ext = tabItemView.getUrl();
                    this.huE.a(tabItemView.getTabId(), -1, asVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.huE != null) {
                    this.huE.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.hur = tabItemView;
                int[] iArr = new int[2];
                this.hur.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.huo.getChildCount(); i2++) {
                    View childAt = this.huo.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.hur.getTabId() && !uC(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.huJ);
                        }
                    }
                }
                if (this.hur.getState() == TabItemView.huJ || this.hur.getState() == TabItemView.STATE_EXPANDED) {
                    this.hup.dismissMenu();
                    boolean z2 = this.hur.getState() == TabItemView.huJ;
                    this.hur.setState(TabItemView.huK);
                    d uy = uy(this.hur.getTabId());
                    if (uy != null) {
                        if (!TextUtils.isEmpty(uy.url)) {
                            as asVar3 = new as();
                            asVar3.ext = uy.url;
                            asVar3.stType = uy.name;
                            asVar = asVar3;
                        }
                        if (uy.huI != null && uy.huI.hcj != null && uy.huI.hcj.size() > 0) {
                            for (ax axVar : uy.huI.hcj) {
                                if (axVar != null && axVar.isSelected) {
                                    i = axVar.hcf;
                                }
                            }
                        }
                        if (z2 && this.huE != null) {
                            this.huE.a(this.hur.getTabId(), i, asVar);
                        }
                    } else {
                        return;
                    }
                } else if (uz(this.hur.getTabId()) && !z) {
                    if (this.huF == null || this.huF.uF(this.hur.getTabId())) {
                        this.hur.setState(TabItemView.STATE_EXPANDED);
                        this.hup.a((Activity) getContext(), this, this.hur, uy(this.hur.getTabId()).huI);
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
        this.hun = 0;
        this.hur = null;
        this.hus = null;
        this.mPaint = new Paint();
        this.hut = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.huu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.huv = 0;
        this.huw = true;
        this.hux = R.color.transparent;
        this.huz = 0;
        this.huC = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void uD(int i) {
                if (HorizontalTabView.this.hur != null && HorizontalTabView.this.huE != null && HorizontalTabView.this.huE != null) {
                    HorizontalTabView.this.huE.a(HorizontalTabView.this.hur.getTabId(), i, null);
                }
                if (HorizontalTabView.this.hus != null) {
                    HorizontalTabView.this.hus.uB(i);
                }
            }
        };
        this.huD = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.huy) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.huA != null) {
                                HorizontalTabView.this.huA.b(HorizontalTabView.this.ux(1));
                            }
                            HorizontalTabView.this.bUv();
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
                if (HorizontalTabView.this.hus != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.uC(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.hur != null) {
                            HorizontalTabView.this.hus.uA(HorizontalTabView.this.hur.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.hus.uA(((TabItemView) view).getTabId());
                }
            }
        };
        this.huo = new LinearLayout(context);
        this.huo.setOrientation(0);
        this.huo.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.hup = new e(context, this.huC, this.huD);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.huo, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        am.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cC(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d uy = uy(1);
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
        if (uy == null || dVar == null) {
            return false;
        }
        if (uy.huI == null && dVar.huI == null) {
            return false;
        }
        if ((uy.huI != null || dVar.huI == null) && (dVar.huI != null || uy.huI == null)) {
            if (uy.huI == null || dVar.huI == null) {
                return false;
            }
            if (uy.huI.hcj == null && dVar.huI.hcj == null) {
                return false;
            }
            if ((uy.huI.hcj != null || dVar.huI.hcj == null) && (dVar.huI.hcj != null || uy.huI.hcj == null)) {
                int size = uy.huI.hcj.size();
                if (size != dVar.huI.hcj.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ax axVar = dVar.huI.hcj.get(i);
                    ax axVar2 = uy.huI.hcj.get(i);
                    if (axVar.hcf != axVar2.hcf || !axVar.name.equals(axVar2.name)) {
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
        if (this.huy) {
            this.huq = new ArrayList();
            this.huq.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                ay ayVar2 = dVar.huI;
                if (ayVar2 != null && ayVar2.hcj != null) {
                    ayVar2.hcj.clear();
                    ayVar = ayVar2;
                } else {
                    ay ayVar3 = new ay();
                    ayVar3.hcj = new ArrayList();
                    ayVar = ayVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    ax axVar = new ax();
                    axVar.hcf = 1;
                    axVar.name = getContext().getString(R.string.chosen_pb_title);
                    ayVar.hcj.add(axVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ax axVar2 = new ax();
                            axVar2.hcf = dVar3.tabId;
                            axVar2.name = dVar3.name;
                            ayVar.hcj.add(axVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.huI = ayVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.huq = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.huv > 0 && list.size() == this.huv) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.huv, -1);
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
            this.huo.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.huy);
            if (this.huz != 0) {
                tabItemView.setSelectItemColorResId(this.huz);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.huo.addView(tabItemView, layoutParams);
            this.hur = tabItemView;
            tabItemView.setState(TabItemView.huK);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cC(list)) {
            this.mData = list;
            this.huo.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.huy);
                        if (302 == dVar2.tabId) {
                            am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.huz != 0) {
                            tabItemView2.setSelectItemColorResId(this.huz);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (uC(dVar2.tabId)) {
                            am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.huo.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.hur = tabItemView2;
                            tabItemView2.setState(TabItemView.huK);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d uy(int i) {
        if (i < 0 || this.huq == null || this.huq.size() == 0) {
            return null;
        }
        for (d dVar : this.huq) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean uz(int i) {
        d uy = uy(i);
        return (uy == null || uy.huI == null || uy.huI.hcj == null || uy.huI.hcj.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.hus = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hur != null) {
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
            if (this.huw) {
                canvas.drawRect(this.huo.getLeft(), getMeasuredHeight() - this.huu, this.huo.getRight() > getRight() ? this.huo.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.huy) {
                if (this.huz == 0) {
                    this.mPaint.setColor(am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.getSkinColor(null, this.huz));
                }
                canvas.drawRect(this.hur.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.hut, (this.hur.getRight() - getBottomLineMargin()) - this.hur.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.huy) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.hur != null) {
                dimens = this.hur.getRight() - this.hur.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.hur == null || this.hun == 0) {
            return 0;
        }
        return ((this.hur.getMeasuredWidth() - this.hun) - this.hur.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void uA(int i) {
        a(ux(i));
    }

    public void setDataLoadInterface(ak akVar) {
        this.huE = akVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.huF = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.huF;
    }

    public void setTabBackgroudColor(int i) {
        this.hux = i;
    }

    public void setAutoFillTabCount(int i) {
        this.huv = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void uB(int i) {
        if (this.hur != null && this.huE != null) {
            this.huE.a(this.hur.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.huA = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.huB = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.huy = z;
    }

    public static boolean uC(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.huw = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.huz = i;
    }
}
