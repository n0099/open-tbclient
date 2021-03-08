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
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext iWY;
    private com.baidu.tieba.frs.tab.b jJA;
    private final int jJB;
    private final int jJC;
    private int jJD;
    private boolean jJE;
    private int jJF;
    private boolean jJG;
    private int jJH;
    private a jJI;
    private b jJJ;
    private e.b jJK;
    private e.a jJL;
    private an jJM;
    private c jJN;
    public int jJv;
    private final LinearLayout jJw;
    private final e jJx;
    private List<d> jJy;
    private TabItemView jJz;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes2.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void Aq(int i);

        boolean Ar(int i);
    }

    public void cKt() {
        final bd bdVar;
        if (this.iWY != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bdVar = this.mData.get(0).jJQ) != null && bdVar.jmH != null) {
                for (bc bcVar : bdVar.jmH) {
                    if (bcVar != null) {
                        arrayList.add(bcVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iWY.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0564b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bdVar.jmH.size() > i && bdVar.jmH.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.Aj(bdVar.jmH.get(i).jmD));
                        }
                    }
                });
                bVar.d(this.iWY);
                bVar.bqB();
            }
        }
    }

    public d Aj(int i) {
        if (!y.isEmpty(this.jJy)) {
            for (d dVar : this.jJy) {
                if (dVar != null && dVar.tabId == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void a(d dVar) {
        boolean z;
        ax axVar;
        if (dVar != null) {
            if (this.jJJ != null) {
                this.jJJ.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (Ao(dVar.tabId)) {
                if (this.jJM != null && !TextUtils.isEmpty(dVar.url)) {
                    ax axVar2 = new ax();
                    axVar2.ext = dVar.url;
                    this.jJM.a(dVar.tabId, -1, axVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.jJM != null) {
                    this.jJM.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.jJM == null) {
                    z = true;
                } else {
                    ax axVar3 = new ax();
                    axVar3.ext = dVar.url;
                    axVar3.stType = dVar.name;
                    this.jJM.a(dVar.tabId, 0, axVar3);
                    if (axVar3.jnd) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.jJw.getChildCount(); i++) {
                    View childAt = this.jJw.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(dVar.url)) {
                    axVar = null;
                } else {
                    axVar = new ax();
                    axVar.ext = dVar.url;
                    axVar.stType = dVar.name;
                }
                if (this.jJM != null && z) {
                    this.jJM.a(dVar.tabId, 0, axVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ax axVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (Ao(tabItemView.getTabId())) {
                if (this.jJM != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ax axVar2 = new ax();
                    axVar2.ext = tabItemView.getUrl();
                    this.jJM.a(tabItemView.getTabId(), -1, axVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.jJM != null) {
                    this.jJM.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.jJz = tabItemView;
                int[] iArr = new int[2];
                this.jJz.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.jJw.getChildCount(); i2++) {
                    View childAt = this.jJw.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.jJz.getTabId() && !Ao(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.jJR);
                        }
                    }
                }
                if (this.jJz.getState() == TabItemView.jJR || this.jJz.getState() == TabItemView.STATE_EXPANDED) {
                    this.jJx.cKw();
                    boolean z2 = this.jJz.getState() == TabItemView.jJR;
                    this.jJz.setState(TabItemView.jJS);
                    d Ak = Ak(this.jJz.getTabId());
                    if (Ak != null) {
                        if (!TextUtils.isEmpty(Ak.url)) {
                            ax axVar3 = new ax();
                            axVar3.ext = Ak.url;
                            axVar3.stType = Ak.name;
                            axVar = axVar3;
                        }
                        if (Ak.jJQ != null && Ak.jJQ.jmH != null && Ak.jJQ.jmH.size() > 0) {
                            for (bc bcVar : Ak.jJQ.jmH) {
                                if (bcVar != null && bcVar.isSelected) {
                                    i = bcVar.jmD;
                                }
                            }
                        }
                        if (z2 && this.jJM != null) {
                            this.jJM.a(this.jJz.getTabId(), i, axVar);
                        }
                    } else {
                        return;
                    }
                } else if (Al(this.jJz.getTabId()) && !z) {
                    if (this.jJN == null || this.jJN.Ar(this.jJz.getTabId())) {
                        this.jJz.setState(TabItemView.STATE_EXPANDED);
                        this.jJx.a((Activity) getContext(), this, this.jJz, Ak(this.jJz.getTabId()).jJQ);
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
        this.jJv = 0;
        this.jJz = null;
        this.jJA = null;
        this.mPaint = new Paint();
        this.jJB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.jJC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.jJD = 0;
        this.jJE = true;
        this.jJF = R.color.transparent;
        this.jJH = 0;
        this.jJK = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void Ap(int i) {
                if (HorizontalTabView.this.jJz != null && HorizontalTabView.this.jJM != null && HorizontalTabView.this.jJM != null) {
                    HorizontalTabView.this.jJM.a(HorizontalTabView.this.jJz.getTabId(), i, null);
                }
                if (HorizontalTabView.this.jJA != null) {
                    HorizontalTabView.this.jJA.An(i);
                }
            }
        };
        this.jJL = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.jJG) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.jJI != null) {
                            HorizontalTabView.this.jJI.b(HorizontalTabView.this.Aj(1));
                        }
                        HorizontalTabView.this.cKt();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.jJA != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.Ao(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.jJz != null) {
                            HorizontalTabView.this.jJA.Am(HorizontalTabView.this.jJz.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.jJA.Am(((TabItemView) view).getTabId());
                }
            }
        };
        this.jJw = new LinearLayout(context);
        this.jJw.setOrientation(0);
        this.jJw.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.jJx = new e(context, this.jJK, this.jJL);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.jJw, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ap.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean dD(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d Ak = Ak(1);
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
        if (Ak == null || dVar == null) {
            return false;
        }
        if (Ak.jJQ == null && dVar.jJQ == null) {
            return false;
        }
        if ((Ak.jJQ != null || dVar.jJQ == null) && (dVar.jJQ != null || Ak.jJQ == null)) {
            if (Ak.jJQ == null || dVar.jJQ == null) {
                return false;
            }
            if (Ak.jJQ.jmH == null && dVar.jJQ.jmH == null) {
                return false;
            }
            if ((Ak.jJQ.jmH != null || dVar.jJQ.jmH == null) && (dVar.jJQ.jmH != null || Ak.jJQ.jmH == null)) {
                int size = Ak.jJQ.jmH.size();
                if (size != dVar.jJQ.jmH.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bc bcVar = dVar.jJQ.jmH.get(i);
                    bc bcVar2 = Ak.jJQ.jmH.get(i);
                    if (bcVar.jmD != bcVar2.jmD || !bcVar.name.equals(bcVar2.name)) {
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
        bd bdVar;
        if (this.jJG) {
            this.jJy = new ArrayList();
            this.jJy.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bd bdVar2 = dVar.jJQ;
                if (bdVar2 != null && bdVar2.jmH != null) {
                    bdVar2.jmH.clear();
                    bdVar = bdVar2;
                } else {
                    bd bdVar3 = new bd();
                    bdVar3.jmH = new ArrayList();
                    bdVar = bdVar3;
                }
                if (y.getCount(list) > 1) {
                    bc bcVar = new bc();
                    bcVar.jmD = 1;
                    bcVar.name = getContext().getString(R.string.chosen_pb_title);
                    bdVar.jmH.add(bcVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bc bcVar2 = new bc();
                            bcVar2.jmD = dVar2.tabId;
                            bcVar2.name = dVar2.name;
                            bdVar.jmH.add(bcVar2);
                        }
                    }
                    dVar.jJQ = bdVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.jJy = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.jJD > 0 && list.size() == this.jJD) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.jJD, -1);
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
            this.jJw.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.jJG);
            if (this.jJH != 0) {
                tabItemView.setSelectItemColorResId(this.jJH);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.jJw.addView(tabItemView, layoutParams);
            this.jJz = tabItemView;
            tabItemView.setState(TabItemView.jJS);
            return;
        }
        setVisibility(0);
        if (this.mData == null || dD(list)) {
            this.mData = list;
            this.jJw.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.jJG);
                        if (this.jJH != 0) {
                            tabItemView2.setSelectItemColorResId(this.jJH);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (Ao(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.CAM_X0105);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.jJw.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.jJz = tabItemView2;
                            tabItemView2.setState(TabItemView.jJS);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d Ak(int i) {
        if (i < 0 || this.jJy == null || this.jJy.size() == 0) {
            return null;
        }
        for (d dVar : this.jJy) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean Al(int i) {
        d Ak = Ak(i);
        return (Ak == null || Ak.jJQ == null || Ak.jJQ.jmH == null || Ak.jJQ.jmH.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.jJA = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jJz != null) {
            this.mPaint.setColor(ap.getColor(R.color.CAM_X0204));
            if (this.jJE) {
                canvas.drawRect(this.jJw.getLeft(), getMeasuredHeight() - this.jJC, this.jJw.getRight() > getRight() ? this.jJw.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.jJG) {
                if (this.jJH == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0302));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.jJH));
                }
                canvas.drawRect(this.jJz.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.jJB, (this.jJz.getRight() - getBottomLineMargin()) - this.jJz.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.jJG) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0105));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.jJz != null) {
                dimens = this.jJz.getRight() - this.jJz.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.jJz == null || this.jJv == 0) {
            return 0;
        }
        return ((this.jJz.getMeasuredWidth() - this.jJv) - this.jJz.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Am(int i) {
        a(Aj(i));
    }

    public void setDataLoadInterface(an anVar) {
        this.jJM = anVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.jJN = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.jJN;
    }

    public void setTabBackgroudColor(int i) {
        this.jJF = i;
    }

    public void setAutoFillTabCount(int i) {
        this.jJD = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void An(int i) {
        if (this.jJz != null && this.jJM != null) {
            this.jJM.a(this.jJz.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jJI = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.jJJ = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.jJG = z;
    }

    public static boolean Ao(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.jJE = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.jJH = i;
    }
}
