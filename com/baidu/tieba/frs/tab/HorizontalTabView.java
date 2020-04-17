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
    private TbPageContext gNq;
    public int huh;
    private final LinearLayout hui;
    private final e huj;
    private List<d> huk;
    private TabItemView hul;
    private com.baidu.tieba.frs.tab.b hum;
    private final int hun;
    private final int huo;
    private int hup;
    private boolean huq;
    private int hur;
    private boolean hus;
    private int hut;
    private a huu;
    private b huv;
    private e.b huw;
    private e.a hux;
    private ak huy;
    private c huz;
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

    public void bUw() {
        final ay ayVar;
        if (this.gNq != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (ayVar = this.mData.get(0).huC) != null && ayVar.hcd != null) {
                for (ax axVar : ayVar.hcd) {
                    if (axVar != null) {
                        arrayList.add(axVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gNq.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (ayVar.hcd.size() > i && ayVar.hcd.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.ux(ayVar.hcd.get(i).hbZ));
                        }
                    }
                });
                bVar.d(this.gNq);
                bVar.aMV();
            }
        }
    }

    public d ux(int i) {
        if (!v.isEmpty(this.huk)) {
            for (d dVar : this.huk) {
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
            if (dVar.tabId != 302 && this.huv != null) {
                this.huv.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (uC(dVar.tabId)) {
                if (this.huy != null && !TextUtils.isEmpty(dVar.url)) {
                    as asVar = new as();
                    asVar.ext = dVar.url;
                    this.huy.a(dVar.tabId, -1, asVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.huy != null) {
                    this.huy.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.huy == null) {
                    z = true;
                } else {
                    as asVar2 = new as();
                    asVar2.ext = dVar.url;
                    asVar2.stType = dVar.name;
                    this.huy.a(dVar.tabId, 0, asVar2);
                    if (asVar2.hct) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.hui.getChildCount(); i++) {
                    View childAt = this.hui.getChildAt(i);
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
                if (this.huy != null && z) {
                    this.huy.a(dVar.tabId, 0, asVar3);
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
                if (this.huy != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    as asVar2 = new as();
                    asVar2.ext = tabItemView.getUrl();
                    this.huy.a(tabItemView.getTabId(), -1, asVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.huy != null) {
                    this.huy.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.hul = tabItemView;
                int[] iArr = new int[2];
                this.hul.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.hui.getChildCount(); i2++) {
                    View childAt = this.hui.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.hul.getTabId() && !uC(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.huD);
                        }
                    }
                }
                if (this.hul.getState() == TabItemView.huD || this.hul.getState() == TabItemView.STATE_EXPANDED) {
                    this.huj.dismissMenu();
                    boolean z2 = this.hul.getState() == TabItemView.huD;
                    this.hul.setState(TabItemView.huE);
                    d uy = uy(this.hul.getTabId());
                    if (uy != null) {
                        if (!TextUtils.isEmpty(uy.url)) {
                            as asVar3 = new as();
                            asVar3.ext = uy.url;
                            asVar3.stType = uy.name;
                            asVar = asVar3;
                        }
                        if (uy.huC != null && uy.huC.hcd != null && uy.huC.hcd.size() > 0) {
                            for (ax axVar : uy.huC.hcd) {
                                if (axVar != null && axVar.isSelected) {
                                    i = axVar.hbZ;
                                }
                            }
                        }
                        if (z2 && this.huy != null) {
                            this.huy.a(this.hul.getTabId(), i, asVar);
                        }
                    } else {
                        return;
                    }
                } else if (uz(this.hul.getTabId()) && !z) {
                    if (this.huz == null || this.huz.uF(this.hul.getTabId())) {
                        this.hul.setState(TabItemView.STATE_EXPANDED);
                        this.huj.a((Activity) getContext(), this, this.hul, uy(this.hul.getTabId()).huC);
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
        this.huh = 0;
        this.hul = null;
        this.hum = null;
        this.mPaint = new Paint();
        this.hun = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.huo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.hup = 0;
        this.huq = true;
        this.hur = R.color.transparent;
        this.hut = 0;
        this.huw = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void uD(int i) {
                if (HorizontalTabView.this.hul != null && HorizontalTabView.this.huy != null && HorizontalTabView.this.huy != null) {
                    HorizontalTabView.this.huy.a(HorizontalTabView.this.hul.getTabId(), i, null);
                }
                if (HorizontalTabView.this.hum != null) {
                    HorizontalTabView.this.hum.uB(i);
                }
            }
        };
        this.hux = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.hus) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.huu != null) {
                                HorizontalTabView.this.huu.b(HorizontalTabView.this.ux(1));
                            }
                            HorizontalTabView.this.bUw();
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
                if (HorizontalTabView.this.hum != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.uC(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.hul != null) {
                            HorizontalTabView.this.hum.uA(HorizontalTabView.this.hul.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.hum.uA(((TabItemView) view).getTabId());
                }
            }
        };
        this.hui = new LinearLayout(context);
        this.hui.setOrientation(0);
        this.hui.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.huj = new e(context, this.huw, this.hux);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.hui, layoutParams);
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
        if (uy.huC == null && dVar.huC == null) {
            return false;
        }
        if ((uy.huC != null || dVar.huC == null) && (dVar.huC != null || uy.huC == null)) {
            if (uy.huC == null || dVar.huC == null) {
                return false;
            }
            if (uy.huC.hcd == null && dVar.huC.hcd == null) {
                return false;
            }
            if ((uy.huC.hcd != null || dVar.huC.hcd == null) && (dVar.huC.hcd != null || uy.huC.hcd == null)) {
                int size = uy.huC.hcd.size();
                if (size != dVar.huC.hcd.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ax axVar = dVar.huC.hcd.get(i);
                    ax axVar2 = uy.huC.hcd.get(i);
                    if (axVar.hbZ != axVar2.hbZ || !axVar.name.equals(axVar2.name)) {
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
        if (this.hus) {
            this.huk = new ArrayList();
            this.huk.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                ay ayVar2 = dVar.huC;
                if (ayVar2 != null && ayVar2.hcd != null) {
                    ayVar2.hcd.clear();
                    ayVar = ayVar2;
                } else {
                    ay ayVar3 = new ay();
                    ayVar3.hcd = new ArrayList();
                    ayVar = ayVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    ax axVar = new ax();
                    axVar.hbZ = 1;
                    axVar.name = getContext().getString(R.string.chosen_pb_title);
                    ayVar.hcd.add(axVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ax axVar2 = new ax();
                            axVar2.hbZ = dVar3.tabId;
                            axVar2.name = dVar3.name;
                            ayVar.hcd.add(axVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.huC = ayVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.huk = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.hup > 0 && list.size() == this.hup) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.hup, -1);
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
            this.hui.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.hus);
            if (this.hut != 0) {
                tabItemView.setSelectItemColorResId(this.hut);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.hui.addView(tabItemView, layoutParams);
            this.hul = tabItemView;
            tabItemView.setState(TabItemView.huE);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cC(list)) {
            this.mData = list;
            this.hui.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.hus);
                        if (302 == dVar2.tabId) {
                            am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.hut != 0) {
                            tabItemView2.setSelectItemColorResId(this.hut);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (uC(dVar2.tabId)) {
                            am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.hui.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.hul = tabItemView2;
                            tabItemView2.setState(TabItemView.huE);
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
        if (i < 0 || this.huk == null || this.huk.size() == 0) {
            return null;
        }
        for (d dVar : this.huk) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean uz(int i) {
        d uy = uy(i);
        return (uy == null || uy.huC == null || uy.huC.hcd == null || uy.huC.hcd.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.hum = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hul != null) {
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
            if (this.huq) {
                canvas.drawRect(this.hui.getLeft(), getMeasuredHeight() - this.huo, this.hui.getRight() > getRight() ? this.hui.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.hus) {
                if (this.hut == 0) {
                    this.mPaint.setColor(am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.getSkinColor(null, this.hut));
                }
                canvas.drawRect(this.hul.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.hun, (this.hul.getRight() - getBottomLineMargin()) - this.hul.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.hus) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.hul != null) {
                dimens = this.hul.getRight() - this.hul.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.hul == null || this.huh == 0) {
            return 0;
        }
        return ((this.hul.getMeasuredWidth() - this.huh) - this.hul.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void uA(int i) {
        a(ux(i));
    }

    public void setDataLoadInterface(ak akVar) {
        this.huy = akVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.huz = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.huz;
    }

    public void setTabBackgroudColor(int i) {
        this.hur = i;
    }

    public void setAutoFillTabCount(int i) {
        this.hup = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void uB(int i) {
        if (this.hul != null && this.huy != null) {
            this.huy.a(this.hul.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.huu = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.huv = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.hus = z;
    }

    public static boolean uC(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.huq = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.hut = i;
    }
}
