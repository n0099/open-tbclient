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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes16.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext hHG;
    public int irh;
    private final LinearLayout iri;
    private final e irj;
    private List<d> irk;
    private TabItemView irl;
    private com.baidu.tieba.frs.tab.b irm;
    private final int irn;
    private final int iro;
    private int irp;
    private boolean irq;
    private int irr;
    private boolean irs;
    private int irt;
    private a iru;
    private b irv;
    private e.b irw;
    private e.a irx;
    private ar iry;
    private c irz;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes16.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes16.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes16.dex */
    public interface c {
        void yC(int i);

        boolean yD(int i);
    }

    public void csw() {
        final bg bgVar;
        if (this.hHG != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bgVar = this.mData.get(0).irC) != null && bgVar.hXr != null) {
                for (bf bfVar : bgVar.hXr) {
                    if (bfVar != null) {
                        arrayList.add(bfVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hHG.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0538b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bgVar.hXr.size() > i && bgVar.hXr.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.yv(bgVar.hXr.get(i).hXn));
                        }
                    }
                });
                bVar.d(this.hHG);
                bVar.bhi();
            }
        }
    }

    public d yv(int i) {
        if (!y.isEmpty(this.irk)) {
            for (d dVar : this.irk) {
                if (dVar != null && dVar.tabId == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void a(d dVar) {
        boolean z;
        ba baVar;
        if (dVar != null) {
            if (this.irv != null) {
                this.irv.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (yA(dVar.tabId)) {
                if (this.iry != null && !TextUtils.isEmpty(dVar.url)) {
                    ba baVar2 = new ba();
                    baVar2.ext = dVar.url;
                    this.iry.a(dVar.tabId, -1, baVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.iry != null) {
                    this.iry.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.iry == null) {
                    z = true;
                } else {
                    ba baVar3 = new ba();
                    baVar3.ext = dVar.url;
                    baVar3.stType = dVar.name;
                    this.iry.a(dVar.tabId, 0, baVar3);
                    if (baVar3.hXN) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.iri.getChildCount(); i++) {
                    View childAt = this.iri.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(dVar.url)) {
                    baVar = null;
                } else {
                    baVar = new ba();
                    baVar.ext = dVar.url;
                    baVar.stType = dVar.name;
                }
                if (this.iry != null && z) {
                    this.iry.a(dVar.tabId, 0, baVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ba baVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (yA(tabItemView.getTabId())) {
                if (this.iry != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ba baVar2 = new ba();
                    baVar2.ext = tabItemView.getUrl();
                    this.iry.a(tabItemView.getTabId(), -1, baVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.iry != null) {
                    this.iry.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.irl = tabItemView;
                int[] iArr = new int[2];
                this.irl.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.iri.getChildCount(); i2++) {
                    View childAt = this.iri.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.irl.getTabId() && !yA(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.irD);
                        }
                    }
                }
                if (this.irl.getState() == TabItemView.irD || this.irl.getState() == TabItemView.STATE_EXPANDED) {
                    this.irj.dismissMenu();
                    boolean z2 = this.irl.getState() == TabItemView.irD;
                    this.irl.setState(TabItemView.irE);
                    d yw = yw(this.irl.getTabId());
                    if (yw != null) {
                        if (!TextUtils.isEmpty(yw.url)) {
                            ba baVar3 = new ba();
                            baVar3.ext = yw.url;
                            baVar3.stType = yw.name;
                            baVar = baVar3;
                        }
                        if (yw.irC != null && yw.irC.hXr != null && yw.irC.hXr.size() > 0) {
                            for (bf bfVar : yw.irC.hXr) {
                                if (bfVar != null && bfVar.isSelected) {
                                    i = bfVar.hXn;
                                }
                            }
                        }
                        if (z2 && this.iry != null) {
                            this.iry.a(this.irl.getTabId(), i, baVar);
                        }
                    } else {
                        return;
                    }
                } else if (yx(this.irl.getTabId()) && !z) {
                    if (this.irz == null || this.irz.yD(this.irl.getTabId())) {
                        this.irl.setState(TabItemView.STATE_EXPANDED);
                        this.irj.a((Activity) getContext(), this, this.irl, yw(this.irl.getTabId()).irC);
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
        this.irh = 0;
        this.irl = null;
        this.irm = null;
        this.mPaint = new Paint();
        this.irn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.iro = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.irp = 0;
        this.irq = true;
        this.irr = R.color.transparent;
        this.irt = 0;
        this.irw = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void yB(int i) {
                if (HorizontalTabView.this.irl != null && HorizontalTabView.this.iry != null && HorizontalTabView.this.iry != null) {
                    HorizontalTabView.this.iry.a(HorizontalTabView.this.irl.getTabId(), i, null);
                }
                if (HorizontalTabView.this.irm != null) {
                    HorizontalTabView.this.irm.yz(i);
                }
            }
        };
        this.irx = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.irs) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.iru != null) {
                            HorizontalTabView.this.iru.b(HorizontalTabView.this.yv(1));
                        }
                        HorizontalTabView.this.csw();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.irm != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.yA(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.irl != null) {
                            HorizontalTabView.this.irm.yy(HorizontalTabView.this.irl.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.irm.yy(((TabItemView) view).getTabId());
                }
            }
        };
        this.iri = new LinearLayout(context);
        this.iri.setOrientation(0);
        this.iri.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.irj = new e(context, this.irw, this.irx);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.iri, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ap.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cR(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d yw = yw(1);
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
        if (yw == null || dVar == null) {
            return false;
        }
        if (yw.irC == null && dVar.irC == null) {
            return false;
        }
        if ((yw.irC != null || dVar.irC == null) && (dVar.irC != null || yw.irC == null)) {
            if (yw.irC == null || dVar.irC == null) {
                return false;
            }
            if (yw.irC.hXr == null && dVar.irC.hXr == null) {
                return false;
            }
            if ((yw.irC.hXr != null || dVar.irC.hXr == null) && (dVar.irC.hXr != null || yw.irC.hXr == null)) {
                int size = yw.irC.hXr.size();
                if (size != dVar.irC.hXr.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bf bfVar = dVar.irC.hXr.get(i);
                    bf bfVar2 = yw.irC.hXr.get(i);
                    if (bfVar.hXn != bfVar2.hXn || !bfVar.name.equals(bfVar2.name)) {
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
        bg bgVar;
        if (this.irs) {
            this.irk = new ArrayList();
            this.irk.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bg bgVar2 = dVar.irC;
                if (bgVar2 != null && bgVar2.hXr != null) {
                    bgVar2.hXr.clear();
                    bgVar = bgVar2;
                } else {
                    bg bgVar3 = new bg();
                    bgVar3.hXr = new ArrayList();
                    bgVar = bgVar3;
                }
                if (y.getCount(list) > 1) {
                    bf bfVar = new bf();
                    bfVar.hXn = 1;
                    bfVar.name = getContext().getString(R.string.chosen_pb_title);
                    bgVar.hXr.add(bfVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bf bfVar2 = new bf();
                            bfVar2.hXn = dVar2.tabId;
                            bfVar2.name = dVar2.name;
                            bgVar.hXr.add(bfVar2);
                        }
                    }
                    dVar.irC = bgVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.irk = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.irp > 0 && list.size() == this.irp) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.irp, -1);
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
            this.iri.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.irs);
            if (this.irt != 0) {
                tabItemView.setSelectItemColorResId(this.irt);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.iri.addView(tabItemView, layoutParams);
            this.irl = tabItemView;
            tabItemView.setState(TabItemView.irE);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cR(list)) {
            this.mData = list;
            this.iri.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.irs);
                        if (this.irt != 0) {
                            tabItemView2.setSelectItemColorResId(this.irt);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (yA(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.iri.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.irl = tabItemView2;
                            tabItemView2.setState(TabItemView.irE);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d yw(int i) {
        if (i < 0 || this.irk == null || this.irk.size() == 0) {
            return null;
        }
        for (d dVar : this.irk) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean yx(int i) {
        d yw = yw(i);
        return (yw == null || yw.irC == null || yw.irC.hXr == null || yw.irC.hXr.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.irm = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.irl != null) {
            this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_c));
            if (this.irq) {
                canvas.drawRect(this.iri.getLeft(), getMeasuredHeight() - this.iro, this.iri.getRight() > getRight() ? this.iri.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.irs) {
                if (this.irt == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.irt));
                }
                canvas.drawRect(this.irl.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.irn, (this.irl.getRight() - getBottomLineMargin()) - this.irl.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.irs) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.irl != null) {
                dimens = this.irl.getRight() - this.irl.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.irl == null || this.irh == 0) {
            return 0;
        }
        return ((this.irl.getMeasuredWidth() - this.irh) - this.irl.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void yy(int i) {
        a(yv(i));
    }

    public void setDataLoadInterface(ar arVar) {
        this.iry = arVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.irz = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.irz;
    }

    public void setTabBackgroudColor(int i) {
        this.irr = i;
    }

    public void setAutoFillTabCount(int i) {
        this.irp = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void yz(int i) {
        if (this.irl != null && this.iry != null) {
            this.iry.a(this.irl.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.iru = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.irv = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.irs = z;
    }

    public static boolean yA(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.irq = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.irt = i;
    }
}
