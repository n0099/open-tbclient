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
/* loaded from: classes21.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext hON;
    public int iyD;
    private final LinearLayout iyE;
    private final e iyF;
    private List<d> iyG;
    private TabItemView iyH;
    private com.baidu.tieba.frs.tab.b iyI;
    private final int iyJ;
    private final int iyK;
    private int iyL;
    private boolean iyM;
    private int iyN;
    private boolean iyO;
    private int iyP;
    private a iyQ;
    private b iyR;
    private e.b iyS;
    private e.a iyT;
    private ar iyU;
    private c iyV;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes21.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes21.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes21.dex */
    public interface c {
        void zb(int i);

        boolean zc(int i);
    }

    public void cvM() {
        final bg bgVar;
        if (this.hON != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bgVar = this.mData.get(0).iyY) != null && bgVar.ieB != null) {
                for (bf bfVar : bgVar.ieB) {
                    if (bfVar != null) {
                        arrayList.add(bfVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hON.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0533b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bgVar.ieB.size() > i && bgVar.ieB.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.yU(bgVar.ieB.get(i).iex));
                        }
                    }
                });
                bVar.d(this.hON);
                bVar.bic();
            }
        }
    }

    public d yU(int i) {
        if (!y.isEmpty(this.iyG)) {
            for (d dVar : this.iyG) {
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
            if (this.iyR != null) {
                this.iyR.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (yZ(dVar.tabId)) {
                if (this.iyU != null && !TextUtils.isEmpty(dVar.url)) {
                    ba baVar2 = new ba();
                    baVar2.ext = dVar.url;
                    this.iyU.a(dVar.tabId, -1, baVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.iyU != null) {
                    this.iyU.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.iyU == null) {
                    z = true;
                } else {
                    ba baVar3 = new ba();
                    baVar3.ext = dVar.url;
                    baVar3.stType = dVar.name;
                    this.iyU.a(dVar.tabId, 0, baVar3);
                    if (baVar3.ieX) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.iyE.getChildCount(); i++) {
                    View childAt = this.iyE.getChildAt(i);
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
                if (this.iyU != null && z) {
                    this.iyU.a(dVar.tabId, 0, baVar);
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
            if (yZ(tabItemView.getTabId())) {
                if (this.iyU != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ba baVar2 = new ba();
                    baVar2.ext = tabItemView.getUrl();
                    this.iyU.a(tabItemView.getTabId(), -1, baVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.iyU != null) {
                    this.iyU.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.iyH = tabItemView;
                int[] iArr = new int[2];
                this.iyH.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.iyE.getChildCount(); i2++) {
                    View childAt = this.iyE.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.iyH.getTabId() && !yZ(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.iyZ);
                        }
                    }
                }
                if (this.iyH.getState() == TabItemView.iyZ || this.iyH.getState() == TabItemView.STATE_EXPANDED) {
                    this.iyF.dismissMenu();
                    boolean z2 = this.iyH.getState() == TabItemView.iyZ;
                    this.iyH.setState(TabItemView.iza);
                    d yV = yV(this.iyH.getTabId());
                    if (yV != null) {
                        if (!TextUtils.isEmpty(yV.url)) {
                            ba baVar3 = new ba();
                            baVar3.ext = yV.url;
                            baVar3.stType = yV.name;
                            baVar = baVar3;
                        }
                        if (yV.iyY != null && yV.iyY.ieB != null && yV.iyY.ieB.size() > 0) {
                            for (bf bfVar : yV.iyY.ieB) {
                                if (bfVar != null && bfVar.isSelected) {
                                    i = bfVar.iex;
                                }
                            }
                        }
                        if (z2 && this.iyU != null) {
                            this.iyU.a(this.iyH.getTabId(), i, baVar);
                        }
                    } else {
                        return;
                    }
                } else if (yW(this.iyH.getTabId()) && !z) {
                    if (this.iyV == null || this.iyV.zc(this.iyH.getTabId())) {
                        this.iyH.setState(TabItemView.STATE_EXPANDED);
                        this.iyF.a((Activity) getContext(), this, this.iyH, yV(this.iyH.getTabId()).iyY);
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
        this.iyD = 0;
        this.iyH = null;
        this.iyI = null;
        this.mPaint = new Paint();
        this.iyJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.iyK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.iyL = 0;
        this.iyM = true;
        this.iyN = R.color.transparent;
        this.iyP = 0;
        this.iyS = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void za(int i) {
                if (HorizontalTabView.this.iyH != null && HorizontalTabView.this.iyU != null && HorizontalTabView.this.iyU != null) {
                    HorizontalTabView.this.iyU.a(HorizontalTabView.this.iyH.getTabId(), i, null);
                }
                if (HorizontalTabView.this.iyI != null) {
                    HorizontalTabView.this.iyI.yY(i);
                }
            }
        };
        this.iyT = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.iyO) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.iyQ != null) {
                            HorizontalTabView.this.iyQ.b(HorizontalTabView.this.yU(1));
                        }
                        HorizontalTabView.this.cvM();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.iyI != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.yZ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.iyH != null) {
                            HorizontalTabView.this.iyI.yX(HorizontalTabView.this.iyH.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.iyI.yX(((TabItemView) view).getTabId());
                }
            }
        };
        this.iyE = new LinearLayout(context);
        this.iyE.setOrientation(0);
        this.iyE.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.iyF = new e(context, this.iyS, this.iyT);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.iyE, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ap.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cX(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d yV = yV(1);
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
        if (yV == null || dVar == null) {
            return false;
        }
        if (yV.iyY == null && dVar.iyY == null) {
            return false;
        }
        if ((yV.iyY != null || dVar.iyY == null) && (dVar.iyY != null || yV.iyY == null)) {
            if (yV.iyY == null || dVar.iyY == null) {
                return false;
            }
            if (yV.iyY.ieB == null && dVar.iyY.ieB == null) {
                return false;
            }
            if ((yV.iyY.ieB != null || dVar.iyY.ieB == null) && (dVar.iyY.ieB != null || yV.iyY.ieB == null)) {
                int size = yV.iyY.ieB.size();
                if (size != dVar.iyY.ieB.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bf bfVar = dVar.iyY.ieB.get(i);
                    bf bfVar2 = yV.iyY.ieB.get(i);
                    if (bfVar.iex != bfVar2.iex || !bfVar.name.equals(bfVar2.name)) {
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
        if (this.iyO) {
            this.iyG = new ArrayList();
            this.iyG.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bg bgVar2 = dVar.iyY;
                if (bgVar2 != null && bgVar2.ieB != null) {
                    bgVar2.ieB.clear();
                    bgVar = bgVar2;
                } else {
                    bg bgVar3 = new bg();
                    bgVar3.ieB = new ArrayList();
                    bgVar = bgVar3;
                }
                if (y.getCount(list) > 1) {
                    bf bfVar = new bf();
                    bfVar.iex = 1;
                    bfVar.name = getContext().getString(R.string.chosen_pb_title);
                    bgVar.ieB.add(bfVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bf bfVar2 = new bf();
                            bfVar2.iex = dVar2.tabId;
                            bfVar2.name = dVar2.name;
                            bgVar.ieB.add(bfVar2);
                        }
                    }
                    dVar.iyY = bgVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.iyG = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.iyL > 0 && list.size() == this.iyL) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.iyL, -1);
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
            this.iyE.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.iyO);
            if (this.iyP != 0) {
                tabItemView.setSelectItemColorResId(this.iyP);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.iyE.addView(tabItemView, layoutParams);
            this.iyH = tabItemView;
            tabItemView.setState(TabItemView.iza);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cX(list)) {
            this.mData = list;
            this.iyE.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.iyO);
                        if (this.iyP != 0) {
                            tabItemView2.setSelectItemColorResId(this.iyP);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (yZ(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.iyE.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.iyH = tabItemView2;
                            tabItemView2.setState(TabItemView.iza);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d yV(int i) {
        if (i < 0 || this.iyG == null || this.iyG.size() == 0) {
            return null;
        }
        for (d dVar : this.iyG) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean yW(int i) {
        d yV = yV(i);
        return (yV == null || yV.iyY == null || yV.iyY.ieB == null || yV.iyY.ieB.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.iyI = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.iyH != null) {
            this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_c));
            if (this.iyM) {
                canvas.drawRect(this.iyE.getLeft(), getMeasuredHeight() - this.iyK, this.iyE.getRight() > getRight() ? this.iyE.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.iyO) {
                if (this.iyP == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.iyP));
                }
                canvas.drawRect(this.iyH.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.iyJ, (this.iyH.getRight() - getBottomLineMargin()) - this.iyH.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.iyO) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.iyH != null) {
                dimens = this.iyH.getRight() - this.iyH.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.iyH == null || this.iyD == 0) {
            return 0;
        }
        return ((this.iyH.getMeasuredWidth() - this.iyD) - this.iyH.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void yX(int i) {
        a(yU(i));
    }

    public void setDataLoadInterface(ar arVar) {
        this.iyU = arVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.iyV = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.iyV;
    }

    public void setTabBackgroudColor(int i) {
        this.iyN = i;
    }

    public void setAutoFillTabCount(int i) {
        this.iyL = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void yY(int i) {
        if (this.iyH != null && this.iyU != null) {
            this.iyU.a(this.iyH.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.iyQ = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.iyR = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.iyO = z;
    }

    public static boolean yZ(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.iyM = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.iyP = i;
    }
}
