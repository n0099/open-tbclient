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
    public int hJN;
    private final LinearLayout hJO;
    private final e hJP;
    private List<d> hJQ;
    private TabItemView hJR;
    private com.baidu.tieba.frs.tab.b hJS;
    private final int hJT;
    private final int hJU;
    private int hJV;
    private boolean hJW;
    private int hJX;
    private boolean hJY;
    private int hJZ;
    private a hKa;
    private b hKb;
    private e.b hKc;
    private e.a hKd;
    private ak hKe;
    private c hKf;
    private TbPageContext hct;
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
        void vm(int i);

        boolean vn(int i);
    }

    public void cba() {
        final ay ayVar;
        if (this.hct != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (ayVar = this.mData.get(0).hKi) != null && ayVar.hri != null) {
                for (ax axVar : ayVar.hri) {
                    if (axVar != null) {
                        arrayList.add(axVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hct.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (ayVar.hri.size() > i && ayVar.hri.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.vf(ayVar.hri.get(i).hre));
                        }
                    }
                });
                bVar.d(this.hct);
                bVar.aSU();
            }
        }
    }

    public d vf(int i) {
        if (!v.isEmpty(this.hJQ)) {
            for (d dVar : this.hJQ) {
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
            if (dVar.tabId != 302 && this.hKb != null) {
                this.hKb.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (vk(dVar.tabId)) {
                if (this.hKe != null && !TextUtils.isEmpty(dVar.url)) {
                    as asVar = new as();
                    asVar.ext = dVar.url;
                    this.hKe.a(dVar.tabId, -1, asVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.hKe != null) {
                    this.hKe.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.hKe == null) {
                    z = true;
                } else {
                    as asVar2 = new as();
                    asVar2.ext = dVar.url;
                    asVar2.stType = dVar.name;
                    this.hKe.a(dVar.tabId, 0, asVar2);
                    if (asVar2.hry) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.hJO.getChildCount(); i++) {
                    View childAt = this.hJO.getChildAt(i);
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
                if (this.hKe != null && z) {
                    this.hKe.a(dVar.tabId, 0, asVar3);
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
            if (vk(tabItemView.getTabId())) {
                if (this.hKe != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    as asVar2 = new as();
                    asVar2.ext = tabItemView.getUrl();
                    this.hKe.a(tabItemView.getTabId(), -1, asVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.hKe != null) {
                    this.hKe.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.hJR = tabItemView;
                int[] iArr = new int[2];
                this.hJR.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.hJO.getChildCount(); i2++) {
                    View childAt = this.hJO.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.hJR.getTabId() && !vk(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.hKj);
                        }
                    }
                }
                if (this.hJR.getState() == TabItemView.hKj || this.hJR.getState() == TabItemView.STATE_EXPANDED) {
                    this.hJP.dismissMenu();
                    boolean z2 = this.hJR.getState() == TabItemView.hKj;
                    this.hJR.setState(TabItemView.hKk);
                    d vg = vg(this.hJR.getTabId());
                    if (vg != null) {
                        if (!TextUtils.isEmpty(vg.url)) {
                            as asVar3 = new as();
                            asVar3.ext = vg.url;
                            asVar3.stType = vg.name;
                            asVar = asVar3;
                        }
                        if (vg.hKi != null && vg.hKi.hri != null && vg.hKi.hri.size() > 0) {
                            for (ax axVar : vg.hKi.hri) {
                                if (axVar != null && axVar.isSelected) {
                                    i = axVar.hre;
                                }
                            }
                        }
                        if (z2 && this.hKe != null) {
                            this.hKe.a(this.hJR.getTabId(), i, asVar);
                        }
                    } else {
                        return;
                    }
                } else if (vh(this.hJR.getTabId()) && !z) {
                    if (this.hKf == null || this.hKf.vn(this.hJR.getTabId())) {
                        this.hJR.setState(TabItemView.STATE_EXPANDED);
                        this.hJP.a((Activity) getContext(), this, this.hJR, vg(this.hJR.getTabId()).hKi);
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
        this.hJN = 0;
        this.hJR = null;
        this.hJS = null;
        this.mPaint = new Paint();
        this.hJT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.hJU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.hJV = 0;
        this.hJW = true;
        this.hJX = R.color.transparent;
        this.hJZ = 0;
        this.hKc = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void vl(int i) {
                if (HorizontalTabView.this.hJR != null && HorizontalTabView.this.hKe != null && HorizontalTabView.this.hKe != null) {
                    HorizontalTabView.this.hKe.a(HorizontalTabView.this.hJR.getTabId(), i, null);
                }
                if (HorizontalTabView.this.hJS != null) {
                    HorizontalTabView.this.hJS.vj(i);
                }
            }
        };
        this.hKd = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.hJY) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.hKa != null) {
                                HorizontalTabView.this.hKa.b(HorizontalTabView.this.vf(1));
                            }
                            HorizontalTabView.this.cba();
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
                if (HorizontalTabView.this.hJS != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.vk(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.hJR != null) {
                            HorizontalTabView.this.hJS.vi(HorizontalTabView.this.hJR.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.hJS.vi(((TabItemView) view).getTabId());
                }
            }
        };
        this.hJO = new LinearLayout(context);
        this.hJO.setOrientation(0);
        this.hJO.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.hJP = new e(context, this.hKc, this.hKd);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.hJO, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        am.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cA(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d vg = vg(1);
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
        if (vg == null || dVar == null) {
            return false;
        }
        if (vg.hKi == null && dVar.hKi == null) {
            return false;
        }
        if ((vg.hKi != null || dVar.hKi == null) && (dVar.hKi != null || vg.hKi == null)) {
            if (vg.hKi == null || dVar.hKi == null) {
                return false;
            }
            if (vg.hKi.hri == null && dVar.hKi.hri == null) {
                return false;
            }
            if ((vg.hKi.hri != null || dVar.hKi.hri == null) && (dVar.hKi.hri != null || vg.hKi.hri == null)) {
                int size = vg.hKi.hri.size();
                if (size != dVar.hKi.hri.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ax axVar = dVar.hKi.hri.get(i);
                    ax axVar2 = vg.hKi.hri.get(i);
                    if (axVar.hre != axVar2.hre || !axVar.name.equals(axVar2.name)) {
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
        if (this.hJY) {
            this.hJQ = new ArrayList();
            this.hJQ.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                ay ayVar2 = dVar.hKi;
                if (ayVar2 != null && ayVar2.hri != null) {
                    ayVar2.hri.clear();
                    ayVar = ayVar2;
                } else {
                    ay ayVar3 = new ay();
                    ayVar3.hri = new ArrayList();
                    ayVar = ayVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    ax axVar = new ax();
                    axVar.hre = 1;
                    axVar.name = getContext().getString(R.string.chosen_pb_title);
                    ayVar.hri.add(axVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ax axVar2 = new ax();
                            axVar2.hre = dVar3.tabId;
                            axVar2.name = dVar3.name;
                            ayVar.hri.add(axVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.hKi = ayVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.hJQ = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.hJV > 0 && list.size() == this.hJV) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.hJV, -1);
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
            this.hJO.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.hJY);
            if (this.hJZ != 0) {
                tabItemView.setSelectItemColorResId(this.hJZ);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.hJO.addView(tabItemView, layoutParams);
            this.hJR = tabItemView;
            tabItemView.setState(TabItemView.hKk);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cA(list)) {
            this.mData = list;
            this.hJO.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.hJY);
                        if (302 == dVar2.tabId) {
                            am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.hJZ != 0) {
                            tabItemView2.setSelectItemColorResId(this.hJZ);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (vk(dVar2.tabId)) {
                            am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.hJO.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.hJR = tabItemView2;
                            tabItemView2.setState(TabItemView.hKk);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d vg(int i) {
        if (i < 0 || this.hJQ == null || this.hJQ.size() == 0) {
            return null;
        }
        for (d dVar : this.hJQ) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean vh(int i) {
        d vg = vg(i);
        return (vg == null || vg.hKi == null || vg.hKi.hri == null || vg.hKi.hri.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.hJS = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.hJR != null) {
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
            if (this.hJW) {
                canvas.drawRect(this.hJO.getLeft(), getMeasuredHeight() - this.hJU, this.hJO.getRight() > getRight() ? this.hJO.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.hJY) {
                if (this.hJZ == 0) {
                    this.mPaint.setColor(am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.getSkinColor(null, this.hJZ));
                }
                canvas.drawRect(this.hJR.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.hJT, (this.hJR.getRight() - getBottomLineMargin()) - this.hJR.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.hJY) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.hJR != null) {
                dimens = this.hJR.getRight() - this.hJR.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.hJR == null || this.hJN == 0) {
            return 0;
        }
        return ((this.hJR.getMeasuredWidth() - this.hJN) - this.hJR.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void vi(int i) {
        a(vf(i));
    }

    public void setDataLoadInterface(ak akVar) {
        this.hKe = akVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.hKf = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.hKf;
    }

    public void setTabBackgroudColor(int i) {
        this.hJX = i;
    }

    public void setAutoFillTabCount(int i) {
        this.hJV = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void vj(int i) {
        if (this.hJR != null && this.hKe != null) {
            this.hKe.a(this.hJR.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.hKa = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.hKb = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.hJY = z;
    }

    public static boolean vk(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.hJW = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.hJZ = i;
    }
}
