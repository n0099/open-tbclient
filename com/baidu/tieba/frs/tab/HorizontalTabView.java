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
/* loaded from: classes22.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    public int iZS;
    private final LinearLayout iZT;
    private final e iZU;
    private List<d> iZV;
    private TabItemView iZW;
    private com.baidu.tieba.frs.tab.b iZX;
    private final int iZY;
    private final int iZZ;
    private TbPageContext iqk;
    private int jaa;
    private boolean jab;
    private int jac;
    private boolean jad;
    private int jae;
    private a jaf;
    private b jag;
    private e.b jah;
    private e.a jai;
    private ar jaj;
    private c jak;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes22.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes22.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes22.dex */
    public interface c {
        void Aa(int i);

        boolean Ab(int i);
    }

    public void cCq() {
        final bg bgVar;
        if (this.iqk != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bgVar = this.mData.get(0).jan) != null && bgVar.iFU != null) {
                for (bf bfVar : bgVar.iFU) {
                    if (bfVar != null) {
                        arrayList.add(bfVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iqk.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0564b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bgVar.iFU.size() > i && bgVar.iFU.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.zT(bgVar.iFU.get(i).iFQ));
                        }
                    }
                });
                bVar.d(this.iqk);
                bVar.bmE();
            }
        }
    }

    public d zT(int i) {
        if (!y.isEmpty(this.iZV)) {
            for (d dVar : this.iZV) {
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
            if (this.jag != null) {
                this.jag.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (zY(dVar.tabId)) {
                if (this.jaj != null && !TextUtils.isEmpty(dVar.url)) {
                    ba baVar2 = new ba();
                    baVar2.ext = dVar.url;
                    this.jaj.a(dVar.tabId, -1, baVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.jaj != null) {
                    this.jaj.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.jaj == null) {
                    z = true;
                } else {
                    ba baVar3 = new ba();
                    baVar3.ext = dVar.url;
                    baVar3.stType = dVar.name;
                    this.jaj.a(dVar.tabId, 0, baVar3);
                    if (baVar3.iGq) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.iZT.getChildCount(); i++) {
                    View childAt = this.iZT.getChildAt(i);
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
                if (this.jaj != null && z) {
                    this.jaj.a(dVar.tabId, 0, baVar);
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
            if (zY(tabItemView.getTabId())) {
                if (this.jaj != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ba baVar2 = new ba();
                    baVar2.ext = tabItemView.getUrl();
                    this.jaj.a(tabItemView.getTabId(), -1, baVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.jaj != null) {
                    this.jaj.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.iZW = tabItemView;
                int[] iArr = new int[2];
                this.iZW.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.iZT.getChildCount(); i2++) {
                    View childAt = this.iZT.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.iZW.getTabId() && !zY(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.jao);
                        }
                    }
                }
                if (this.iZW.getState() == TabItemView.jao || this.iZW.getState() == TabItemView.STATE_EXPANDED) {
                    this.iZU.dismissMenu();
                    boolean z2 = this.iZW.getState() == TabItemView.jao;
                    this.iZW.setState(TabItemView.jap);
                    d zU = zU(this.iZW.getTabId());
                    if (zU != null) {
                        if (!TextUtils.isEmpty(zU.url)) {
                            ba baVar3 = new ba();
                            baVar3.ext = zU.url;
                            baVar3.stType = zU.name;
                            baVar = baVar3;
                        }
                        if (zU.jan != null && zU.jan.iFU != null && zU.jan.iFU.size() > 0) {
                            for (bf bfVar : zU.jan.iFU) {
                                if (bfVar != null && bfVar.isSelected) {
                                    i = bfVar.iFQ;
                                }
                            }
                        }
                        if (z2 && this.jaj != null) {
                            this.jaj.a(this.iZW.getTabId(), i, baVar);
                        }
                    } else {
                        return;
                    }
                } else if (zV(this.iZW.getTabId()) && !z) {
                    if (this.jak == null || this.jak.Ab(this.iZW.getTabId())) {
                        this.iZW.setState(TabItemView.STATE_EXPANDED);
                        this.iZU.a((Activity) getContext(), this, this.iZW, zU(this.iZW.getTabId()).jan);
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
        this.iZS = 0;
        this.iZW = null;
        this.iZX = null;
        this.mPaint = new Paint();
        this.iZY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.iZZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.jaa = 0;
        this.jab = true;
        this.jac = R.color.transparent;
        this.jae = 0;
        this.jah = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void zZ(int i) {
                if (HorizontalTabView.this.iZW != null && HorizontalTabView.this.jaj != null && HorizontalTabView.this.jaj != null) {
                    HorizontalTabView.this.jaj.a(HorizontalTabView.this.iZW.getTabId(), i, null);
                }
                if (HorizontalTabView.this.iZX != null) {
                    HorizontalTabView.this.iZX.zX(i);
                }
            }
        };
        this.jai = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.jad) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.jaf != null) {
                            HorizontalTabView.this.jaf.b(HorizontalTabView.this.zT(1));
                        }
                        HorizontalTabView.this.cCq();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.iZX != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.zY(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.iZW != null) {
                            HorizontalTabView.this.iZX.zW(HorizontalTabView.this.iZW.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.iZX.zW(((TabItemView) view).getTabId());
                }
            }
        };
        this.iZT = new LinearLayout(context);
        this.iZT.setOrientation(0);
        this.iZT.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.iZU = new e(context, this.jah, this.jai);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.iZT, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ap.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean dj(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d zU = zU(1);
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
        if (zU == null || dVar == null) {
            return false;
        }
        if (zU.jan == null && dVar.jan == null) {
            return false;
        }
        if ((zU.jan != null || dVar.jan == null) && (dVar.jan != null || zU.jan == null)) {
            if (zU.jan == null || dVar.jan == null) {
                return false;
            }
            if (zU.jan.iFU == null && dVar.jan.iFU == null) {
                return false;
            }
            if ((zU.jan.iFU != null || dVar.jan.iFU == null) && (dVar.jan.iFU != null || zU.jan.iFU == null)) {
                int size = zU.jan.iFU.size();
                if (size != dVar.jan.iFU.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bf bfVar = dVar.jan.iFU.get(i);
                    bf bfVar2 = zU.jan.iFU.get(i);
                    if (bfVar.iFQ != bfVar2.iFQ || !bfVar.name.equals(bfVar2.name)) {
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
        if (this.jad) {
            this.iZV = new ArrayList();
            this.iZV.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bg bgVar2 = dVar.jan;
                if (bgVar2 != null && bgVar2.iFU != null) {
                    bgVar2.iFU.clear();
                    bgVar = bgVar2;
                } else {
                    bg bgVar3 = new bg();
                    bgVar3.iFU = new ArrayList();
                    bgVar = bgVar3;
                }
                if (y.getCount(list) > 1) {
                    bf bfVar = new bf();
                    bfVar.iFQ = 1;
                    bfVar.name = getContext().getString(R.string.chosen_pb_title);
                    bgVar.iFU.add(bfVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bf bfVar2 = new bf();
                            bfVar2.iFQ = dVar2.tabId;
                            bfVar2.name = dVar2.name;
                            bgVar.iFU.add(bfVar2);
                        }
                    }
                    dVar.jan = bgVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.iZV = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.jaa > 0 && list.size() == this.jaa) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.jaa, -1);
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
            this.iZT.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.jad);
            if (this.jae != 0) {
                tabItemView.setSelectItemColorResId(this.jae);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.iZT.addView(tabItemView, layoutParams);
            this.iZW = tabItemView;
            tabItemView.setState(TabItemView.jap);
            return;
        }
        setVisibility(0);
        if (this.mData == null || dj(list)) {
            this.mData = list;
            this.iZT.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.jad);
                        if (this.jae != 0) {
                            tabItemView2.setSelectItemColorResId(this.jae);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (zY(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.iZT.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.iZW = tabItemView2;
                            tabItemView2.setState(TabItemView.jap);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d zU(int i) {
        if (i < 0 || this.iZV == null || this.iZV.size() == 0) {
            return null;
        }
        for (d dVar : this.iZV) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean zV(int i) {
        d zU = zU(i);
        return (zU == null || zU.jan == null || zU.jan.iFU == null || zU.jan.iFU.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.iZX = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iZW != null) {
            this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_c));
            if (this.jab) {
                canvas.drawRect(this.iZT.getLeft(), getMeasuredHeight() - this.iZZ, this.iZT.getRight() > getRight() ? this.iZT.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.jad) {
                if (this.jae == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.jae));
                }
                canvas.drawRect(this.iZW.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.iZY, (this.iZW.getRight() - getBottomLineMargin()) - this.iZW.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.jad) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.iZW != null) {
                dimens = this.iZW.getRight() - this.iZW.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.iZW == null || this.iZS == 0) {
            return 0;
        }
        return ((this.iZW.getMeasuredWidth() - this.iZS) - this.iZW.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void zW(int i) {
        a(zT(i));
    }

    public void setDataLoadInterface(ar arVar) {
        this.jaj = arVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.jak = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.jak;
    }

    public void setTabBackgroudColor(int i) {
        this.jac = i;
    }

    public void setAutoFillTabCount(int i) {
        this.jaa = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void zX(int i) {
        if (this.iZW != null && this.jaj != null) {
            this.jaj.a(this.iZW.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jaf = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.jag = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.jad = z;
    }

    public static boolean zY(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.jab = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.jae = i;
    }
}
