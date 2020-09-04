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
    private TbPageContext hHM;
    private a irA;
    private b irB;
    private e.b irC;
    private e.a irD;
    private ar irE;
    private c irF;
    public int irn;
    private final LinearLayout iro;
    private final e irp;
    private List<d> irq;
    private TabItemView irr;
    private com.baidu.tieba.frs.tab.b irs;
    private final int irt;
    private final int iru;
    private int irv;
    private boolean irw;
    private int irx;
    private boolean iry;
    private int irz;
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

    public void csx() {
        final bg bgVar;
        if (this.hHM != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bgVar = this.mData.get(0).irI) != null && bgVar.hXx != null) {
                for (bf bfVar : bgVar.hXx) {
                    if (bfVar != null) {
                        arrayList.add(bfVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hHM.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0538b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bgVar.hXx.size() > i && bgVar.hXx.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.yv(bgVar.hXx.get(i).hXt));
                        }
                    }
                });
                bVar.d(this.hHM);
                bVar.bhi();
            }
        }
    }

    public d yv(int i) {
        if (!y.isEmpty(this.irq)) {
            for (d dVar : this.irq) {
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
            if (this.irB != null) {
                this.irB.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (yA(dVar.tabId)) {
                if (this.irE != null && !TextUtils.isEmpty(dVar.url)) {
                    ba baVar2 = new ba();
                    baVar2.ext = dVar.url;
                    this.irE.a(dVar.tabId, -1, baVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.irE != null) {
                    this.irE.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.irE == null) {
                    z = true;
                } else {
                    ba baVar3 = new ba();
                    baVar3.ext = dVar.url;
                    baVar3.stType = dVar.name;
                    this.irE.a(dVar.tabId, 0, baVar3);
                    if (baVar3.hXT) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.iro.getChildCount(); i++) {
                    View childAt = this.iro.getChildAt(i);
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
                if (this.irE != null && z) {
                    this.irE.a(dVar.tabId, 0, baVar);
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
                if (this.irE != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ba baVar2 = new ba();
                    baVar2.ext = tabItemView.getUrl();
                    this.irE.a(tabItemView.getTabId(), -1, baVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.irE != null) {
                    this.irE.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.irr = tabItemView;
                int[] iArr = new int[2];
                this.irr.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.iro.getChildCount(); i2++) {
                    View childAt = this.iro.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.irr.getTabId() && !yA(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.irJ);
                        }
                    }
                }
                if (this.irr.getState() == TabItemView.irJ || this.irr.getState() == TabItemView.STATE_EXPANDED) {
                    this.irp.dismissMenu();
                    boolean z2 = this.irr.getState() == TabItemView.irJ;
                    this.irr.setState(TabItemView.irK);
                    d yw = yw(this.irr.getTabId());
                    if (yw != null) {
                        if (!TextUtils.isEmpty(yw.url)) {
                            ba baVar3 = new ba();
                            baVar3.ext = yw.url;
                            baVar3.stType = yw.name;
                            baVar = baVar3;
                        }
                        if (yw.irI != null && yw.irI.hXx != null && yw.irI.hXx.size() > 0) {
                            for (bf bfVar : yw.irI.hXx) {
                                if (bfVar != null && bfVar.isSelected) {
                                    i = bfVar.hXt;
                                }
                            }
                        }
                        if (z2 && this.irE != null) {
                            this.irE.a(this.irr.getTabId(), i, baVar);
                        }
                    } else {
                        return;
                    }
                } else if (yx(this.irr.getTabId()) && !z) {
                    if (this.irF == null || this.irF.yD(this.irr.getTabId())) {
                        this.irr.setState(TabItemView.STATE_EXPANDED);
                        this.irp.a((Activity) getContext(), this, this.irr, yw(this.irr.getTabId()).irI);
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
        this.irn = 0;
        this.irr = null;
        this.irs = null;
        this.mPaint = new Paint();
        this.irt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.iru = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.irv = 0;
        this.irw = true;
        this.irx = R.color.transparent;
        this.irz = 0;
        this.irC = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void yB(int i) {
                if (HorizontalTabView.this.irr != null && HorizontalTabView.this.irE != null && HorizontalTabView.this.irE != null) {
                    HorizontalTabView.this.irE.a(HorizontalTabView.this.irr.getTabId(), i, null);
                }
                if (HorizontalTabView.this.irs != null) {
                    HorizontalTabView.this.irs.yz(i);
                }
            }
        };
        this.irD = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.iry) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.irA != null) {
                            HorizontalTabView.this.irA.b(HorizontalTabView.this.yv(1));
                        }
                        HorizontalTabView.this.csx();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.irs != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.yA(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.irr != null) {
                            HorizontalTabView.this.irs.yy(HorizontalTabView.this.irr.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.irs.yy(((TabItemView) view).getTabId());
                }
            }
        };
        this.iro = new LinearLayout(context);
        this.iro.setOrientation(0);
        this.iro.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.irp = new e(context, this.irC, this.irD);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.iro, layoutParams);
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
        if (yw.irI == null && dVar.irI == null) {
            return false;
        }
        if ((yw.irI != null || dVar.irI == null) && (dVar.irI != null || yw.irI == null)) {
            if (yw.irI == null || dVar.irI == null) {
                return false;
            }
            if (yw.irI.hXx == null && dVar.irI.hXx == null) {
                return false;
            }
            if ((yw.irI.hXx != null || dVar.irI.hXx == null) && (dVar.irI.hXx != null || yw.irI.hXx == null)) {
                int size = yw.irI.hXx.size();
                if (size != dVar.irI.hXx.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bf bfVar = dVar.irI.hXx.get(i);
                    bf bfVar2 = yw.irI.hXx.get(i);
                    if (bfVar.hXt != bfVar2.hXt || !bfVar.name.equals(bfVar2.name)) {
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
        if (this.iry) {
            this.irq = new ArrayList();
            this.irq.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bg bgVar2 = dVar.irI;
                if (bgVar2 != null && bgVar2.hXx != null) {
                    bgVar2.hXx.clear();
                    bgVar = bgVar2;
                } else {
                    bg bgVar3 = new bg();
                    bgVar3.hXx = new ArrayList();
                    bgVar = bgVar3;
                }
                if (y.getCount(list) > 1) {
                    bf bfVar = new bf();
                    bfVar.hXt = 1;
                    bfVar.name = getContext().getString(R.string.chosen_pb_title);
                    bgVar.hXx.add(bfVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bf bfVar2 = new bf();
                            bfVar2.hXt = dVar2.tabId;
                            bfVar2.name = dVar2.name;
                            bgVar.hXx.add(bfVar2);
                        }
                    }
                    dVar.irI = bgVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.irq = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.irv > 0 && list.size() == this.irv) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.irv, -1);
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
            this.iro.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.iry);
            if (this.irz != 0) {
                tabItemView.setSelectItemColorResId(this.irz);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.iro.addView(tabItemView, layoutParams);
            this.irr = tabItemView;
            tabItemView.setState(TabItemView.irK);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cR(list)) {
            this.mData = list;
            this.iro.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.iry);
                        if (this.irz != 0) {
                            tabItemView2.setSelectItemColorResId(this.irz);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (yA(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.iro.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.irr = tabItemView2;
                            tabItemView2.setState(TabItemView.irK);
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
        if (i < 0 || this.irq == null || this.irq.size() == 0) {
            return null;
        }
        for (d dVar : this.irq) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean yx(int i) {
        d yw = yw(i);
        return (yw == null || yw.irI == null || yw.irI.hXx == null || yw.irI.hXx.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.irs = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.irr != null) {
            this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_c));
            if (this.irw) {
                canvas.drawRect(this.iro.getLeft(), getMeasuredHeight() - this.iru, this.iro.getRight() > getRight() ? this.iro.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.iry) {
                if (this.irz == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.irz));
                }
                canvas.drawRect(this.irr.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.irt, (this.irr.getRight() - getBottomLineMargin()) - this.irr.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.iry) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.irr != null) {
                dimens = this.irr.getRight() - this.irr.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.irr == null || this.irn == 0) {
            return 0;
        }
        return ((this.irr.getMeasuredWidth() - this.irn) - this.irr.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void yy(int i) {
        a(yv(i));
    }

    public void setDataLoadInterface(ar arVar) {
        this.irE = arVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.irF = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.irF;
    }

    public void setTabBackgroudColor(int i) {
        this.irx = i;
    }

    public void setAutoFillTabCount(int i) {
        this.irv = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void yz(int i) {
        if (this.irr != null && this.irE != null) {
            this.irE.a(this.irr.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.irA = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.irB = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.iry = z;
    }

    public static boolean yA(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.irw = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.irz = i;
    }
}
