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
    private TabItemView iNA;
    private com.baidu.tieba.frs.tab.b iNB;
    private final int iNC;
    private final int iND;
    private int iNE;
    private boolean iNF;
    private int iNG;
    private boolean iNH;
    private int iNI;
    private a iNJ;
    private b iNK;
    private e.b iNL;
    private e.a iNM;
    private ar iNN;
    private c iNO;
    public int iNw;
    private final LinearLayout iNx;
    private final e iNy;
    private List<d> iNz;
    private TbPageContext idM;
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
        void zH(int i);

        boolean zI(int i);
    }

    public void czj() {
        final bg bgVar;
        if (this.idM != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bgVar = this.mData.get(0).iNR) != null && bgVar.ity != null) {
                for (bf bfVar : bgVar.ity) {
                    if (bfVar != null) {
                        arrayList.add(bfVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.idM.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0550b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bgVar.ity.size() > i && bgVar.ity.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.zA(bgVar.ity.get(i).itu));
                        }
                    }
                });
                bVar.d(this.idM);
                bVar.bkL();
            }
        }
    }

    public d zA(int i) {
        if (!y.isEmpty(this.iNz)) {
            for (d dVar : this.iNz) {
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
            if (this.iNK != null) {
                this.iNK.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (zF(dVar.tabId)) {
                if (this.iNN != null && !TextUtils.isEmpty(dVar.url)) {
                    ba baVar2 = new ba();
                    baVar2.ext = dVar.url;
                    this.iNN.a(dVar.tabId, -1, baVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.iNN != null) {
                    this.iNN.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.iNN == null) {
                    z = true;
                } else {
                    ba baVar3 = new ba();
                    baVar3.ext = dVar.url;
                    baVar3.stType = dVar.name;
                    this.iNN.a(dVar.tabId, 0, baVar3);
                    if (baVar3.itU) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.iNx.getChildCount(); i++) {
                    View childAt = this.iNx.getChildAt(i);
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
                if (this.iNN != null && z) {
                    this.iNN.a(dVar.tabId, 0, baVar);
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
            if (zF(tabItemView.getTabId())) {
                if (this.iNN != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ba baVar2 = new ba();
                    baVar2.ext = tabItemView.getUrl();
                    this.iNN.a(tabItemView.getTabId(), -1, baVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.iNN != null) {
                    this.iNN.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.iNA = tabItemView;
                int[] iArr = new int[2];
                this.iNA.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.iNx.getChildCount(); i2++) {
                    View childAt = this.iNx.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.iNA.getTabId() && !zF(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.iNS);
                        }
                    }
                }
                if (this.iNA.getState() == TabItemView.iNS || this.iNA.getState() == TabItemView.STATE_EXPANDED) {
                    this.iNy.dismissMenu();
                    boolean z2 = this.iNA.getState() == TabItemView.iNS;
                    this.iNA.setState(TabItemView.iNT);
                    d zB = zB(this.iNA.getTabId());
                    if (zB != null) {
                        if (!TextUtils.isEmpty(zB.url)) {
                            ba baVar3 = new ba();
                            baVar3.ext = zB.url;
                            baVar3.stType = zB.name;
                            baVar = baVar3;
                        }
                        if (zB.iNR != null && zB.iNR.ity != null && zB.iNR.ity.size() > 0) {
                            for (bf bfVar : zB.iNR.ity) {
                                if (bfVar != null && bfVar.isSelected) {
                                    i = bfVar.itu;
                                }
                            }
                        }
                        if (z2 && this.iNN != null) {
                            this.iNN.a(this.iNA.getTabId(), i, baVar);
                        }
                    } else {
                        return;
                    }
                } else if (zC(this.iNA.getTabId()) && !z) {
                    if (this.iNO == null || this.iNO.zI(this.iNA.getTabId())) {
                        this.iNA.setState(TabItemView.STATE_EXPANDED);
                        this.iNy.a((Activity) getContext(), this, this.iNA, zB(this.iNA.getTabId()).iNR);
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
        this.iNw = 0;
        this.iNA = null;
        this.iNB = null;
        this.mPaint = new Paint();
        this.iNC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.iND = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.iNE = 0;
        this.iNF = true;
        this.iNG = R.color.transparent;
        this.iNI = 0;
        this.iNL = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void zG(int i) {
                if (HorizontalTabView.this.iNA != null && HorizontalTabView.this.iNN != null && HorizontalTabView.this.iNN != null) {
                    HorizontalTabView.this.iNN.a(HorizontalTabView.this.iNA.getTabId(), i, null);
                }
                if (HorizontalTabView.this.iNB != null) {
                    HorizontalTabView.this.iNB.zE(i);
                }
            }
        };
        this.iNM = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.iNH) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.iNJ != null) {
                            HorizontalTabView.this.iNJ.b(HorizontalTabView.this.zA(1));
                        }
                        HorizontalTabView.this.czj();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.iNB != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.zF(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.iNA != null) {
                            HorizontalTabView.this.iNB.zD(HorizontalTabView.this.iNA.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.iNB.zD(((TabItemView) view).getTabId());
                }
            }
        };
        this.iNx = new LinearLayout(context);
        this.iNx.setOrientation(0);
        this.iNx.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.iNy = new e(context, this.iNL, this.iNM);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.iNx, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ap.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean da(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d zB = zB(1);
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
        if (zB == null || dVar == null) {
            return false;
        }
        if (zB.iNR == null && dVar.iNR == null) {
            return false;
        }
        if ((zB.iNR != null || dVar.iNR == null) && (dVar.iNR != null || zB.iNR == null)) {
            if (zB.iNR == null || dVar.iNR == null) {
                return false;
            }
            if (zB.iNR.ity == null && dVar.iNR.ity == null) {
                return false;
            }
            if ((zB.iNR.ity != null || dVar.iNR.ity == null) && (dVar.iNR.ity != null || zB.iNR.ity == null)) {
                int size = zB.iNR.ity.size();
                if (size != dVar.iNR.ity.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bf bfVar = dVar.iNR.ity.get(i);
                    bf bfVar2 = zB.iNR.ity.get(i);
                    if (bfVar.itu != bfVar2.itu || !bfVar.name.equals(bfVar2.name)) {
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
        if (this.iNH) {
            this.iNz = new ArrayList();
            this.iNz.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bg bgVar2 = dVar.iNR;
                if (bgVar2 != null && bgVar2.ity != null) {
                    bgVar2.ity.clear();
                    bgVar = bgVar2;
                } else {
                    bg bgVar3 = new bg();
                    bgVar3.ity = new ArrayList();
                    bgVar = bgVar3;
                }
                if (y.getCount(list) > 1) {
                    bf bfVar = new bf();
                    bfVar.itu = 1;
                    bfVar.name = getContext().getString(R.string.chosen_pb_title);
                    bgVar.ity.add(bfVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bf bfVar2 = new bf();
                            bfVar2.itu = dVar2.tabId;
                            bfVar2.name = dVar2.name;
                            bgVar.ity.add(bfVar2);
                        }
                    }
                    dVar.iNR = bgVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.iNz = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.iNE > 0 && list.size() == this.iNE) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.iNE, -1);
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
            this.iNx.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.iNH);
            if (this.iNI != 0) {
                tabItemView.setSelectItemColorResId(this.iNI);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.iNx.addView(tabItemView, layoutParams);
            this.iNA = tabItemView;
            tabItemView.setState(TabItemView.iNT);
            return;
        }
        setVisibility(0);
        if (this.mData == null || da(list)) {
            this.mData = list;
            this.iNx.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.iNH);
                        if (this.iNI != 0) {
                            tabItemView2.setSelectItemColorResId(this.iNI);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (zF(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.iNx.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.iNA = tabItemView2;
                            tabItemView2.setState(TabItemView.iNT);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d zB(int i) {
        if (i < 0 || this.iNz == null || this.iNz.size() == 0) {
            return null;
        }
        for (d dVar : this.iNz) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean zC(int i) {
        d zB = zB(i);
        return (zB == null || zB.iNR == null || zB.iNR.ity == null || zB.iNR.ity.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.iNB = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iNA != null) {
            this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_c));
            if (this.iNF) {
                canvas.drawRect(this.iNx.getLeft(), getMeasuredHeight() - this.iND, this.iNx.getRight() > getRight() ? this.iNx.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.iNH) {
                if (this.iNI == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.iNI));
                }
                canvas.drawRect(this.iNA.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.iNC, (this.iNA.getRight() - getBottomLineMargin()) - this.iNA.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.iNH) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.iNA != null) {
                dimens = this.iNA.getRight() - this.iNA.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.iNA == null || this.iNw == 0) {
            return 0;
        }
        return ((this.iNA.getMeasuredWidth() - this.iNw) - this.iNA.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void zD(int i) {
        a(zA(i));
    }

    public void setDataLoadInterface(ar arVar) {
        this.iNN = arVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.iNO = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.iNO;
    }

    public void setTabBackgroudColor(int i) {
        this.iNG = i;
    }

    public void setAutoFillTabCount(int i) {
        this.iNE = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void zE(int i) {
        if (this.iNA != null && this.iNN != null) {
            this.iNN.a(this.iNA.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.iNJ = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.iNK = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.iNH = z;
    }

    public static boolean zF(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.iNF = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.iNI = i;
    }
}
