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
    private TbPageContext iVp;
    public int jHM;
    private final LinearLayout jHN;
    private final e jHO;
    private List<d> jHP;
    private TabItemView jHQ;
    private com.baidu.tieba.frs.tab.b jHR;
    private final int jHS;
    private final int jHT;
    private int jHU;
    private boolean jHV;
    private int jHW;
    private boolean jHX;
    private int jHY;
    private a jHZ;
    private b jIa;
    private e.b jIb;
    private e.a jIc;
    private an jId;
    private c jIe;
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
        void Ap(int i);

        boolean Aq(int i);
    }

    public void cKn() {
        final bd bdVar;
        if (this.iVp != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bdVar = this.mData.get(0).jIh) != null && bdVar.jkX != null) {
                for (bc bcVar : bdVar.jkX) {
                    if (bcVar != null) {
                        arrayList.add(bcVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iVp.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0558b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bdVar.jkX.size() > i && bdVar.jkX.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.Ai(bdVar.jkX.get(i).jkT));
                        }
                    }
                });
                bVar.d(this.iVp);
                bVar.bqz();
            }
        }
    }

    public d Ai(int i) {
        if (!y.isEmpty(this.jHP)) {
            for (d dVar : this.jHP) {
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
            if (this.jIa != null) {
                this.jIa.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (An(dVar.tabId)) {
                if (this.jId != null && !TextUtils.isEmpty(dVar.url)) {
                    ax axVar2 = new ax();
                    axVar2.ext = dVar.url;
                    this.jId.a(dVar.tabId, -1, axVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.jId != null) {
                    this.jId.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.jId == null) {
                    z = true;
                } else {
                    ax axVar3 = new ax();
                    axVar3.ext = dVar.url;
                    axVar3.stType = dVar.name;
                    this.jId.a(dVar.tabId, 0, axVar3);
                    if (axVar3.jlt) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.jHN.getChildCount(); i++) {
                    View childAt = this.jHN.getChildAt(i);
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
                if (this.jId != null && z) {
                    this.jId.a(dVar.tabId, 0, axVar);
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
            if (An(tabItemView.getTabId())) {
                if (this.jId != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ax axVar2 = new ax();
                    axVar2.ext = tabItemView.getUrl();
                    this.jId.a(tabItemView.getTabId(), -1, axVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.jId != null) {
                    this.jId.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.jHQ = tabItemView;
                int[] iArr = new int[2];
                this.jHQ.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.jHN.getChildCount(); i2++) {
                    View childAt = this.jHN.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.jHQ.getTabId() && !An(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.jIi);
                        }
                    }
                }
                if (this.jHQ.getState() == TabItemView.jIi || this.jHQ.getState() == TabItemView.STATE_EXPANDED) {
                    this.jHO.cKq();
                    boolean z2 = this.jHQ.getState() == TabItemView.jIi;
                    this.jHQ.setState(TabItemView.jIj);
                    d Aj = Aj(this.jHQ.getTabId());
                    if (Aj != null) {
                        if (!TextUtils.isEmpty(Aj.url)) {
                            ax axVar3 = new ax();
                            axVar3.ext = Aj.url;
                            axVar3.stType = Aj.name;
                            axVar = axVar3;
                        }
                        if (Aj.jIh != null && Aj.jIh.jkX != null && Aj.jIh.jkX.size() > 0) {
                            for (bc bcVar : Aj.jIh.jkX) {
                                if (bcVar != null && bcVar.isSelected) {
                                    i = bcVar.jkT;
                                }
                            }
                        }
                        if (z2 && this.jId != null) {
                            this.jId.a(this.jHQ.getTabId(), i, axVar);
                        }
                    } else {
                        return;
                    }
                } else if (Ak(this.jHQ.getTabId()) && !z) {
                    if (this.jIe == null || this.jIe.Aq(this.jHQ.getTabId())) {
                        this.jHQ.setState(TabItemView.STATE_EXPANDED);
                        this.jHO.a((Activity) getContext(), this, this.jHQ, Aj(this.jHQ.getTabId()).jIh);
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
        this.jHM = 0;
        this.jHQ = null;
        this.jHR = null;
        this.mPaint = new Paint();
        this.jHS = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.jHT = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.jHU = 0;
        this.jHV = true;
        this.jHW = R.color.transparent;
        this.jHY = 0;
        this.jIb = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void Ao(int i) {
                if (HorizontalTabView.this.jHQ != null && HorizontalTabView.this.jId != null && HorizontalTabView.this.jId != null) {
                    HorizontalTabView.this.jId.a(HorizontalTabView.this.jHQ.getTabId(), i, null);
                }
                if (HorizontalTabView.this.jHR != null) {
                    HorizontalTabView.this.jHR.Am(i);
                }
            }
        };
        this.jIc = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.jHX) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.jHZ != null) {
                            HorizontalTabView.this.jHZ.b(HorizontalTabView.this.Ai(1));
                        }
                        HorizontalTabView.this.cKn();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.jHR != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.An(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.jHQ != null) {
                            HorizontalTabView.this.jHR.Al(HorizontalTabView.this.jHQ.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.jHR.Al(((TabItemView) view).getTabId());
                }
            }
        };
        this.jHN = new LinearLayout(context);
        this.jHN.setOrientation(0);
        this.jHN.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.jHO = new e(context, this.jIb, this.jIc);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.jHN, layoutParams);
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
        d Aj = Aj(1);
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
        if (Aj == null || dVar == null) {
            return false;
        }
        if (Aj.jIh == null && dVar.jIh == null) {
            return false;
        }
        if ((Aj.jIh != null || dVar.jIh == null) && (dVar.jIh != null || Aj.jIh == null)) {
            if (Aj.jIh == null || dVar.jIh == null) {
                return false;
            }
            if (Aj.jIh.jkX == null && dVar.jIh.jkX == null) {
                return false;
            }
            if ((Aj.jIh.jkX != null || dVar.jIh.jkX == null) && (dVar.jIh.jkX != null || Aj.jIh.jkX == null)) {
                int size = Aj.jIh.jkX.size();
                if (size != dVar.jIh.jkX.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bc bcVar = dVar.jIh.jkX.get(i);
                    bc bcVar2 = Aj.jIh.jkX.get(i);
                    if (bcVar.jkT != bcVar2.jkT || !bcVar.name.equals(bcVar2.name)) {
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
        if (this.jHX) {
            this.jHP = new ArrayList();
            this.jHP.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bd bdVar2 = dVar.jIh;
                if (bdVar2 != null && bdVar2.jkX != null) {
                    bdVar2.jkX.clear();
                    bdVar = bdVar2;
                } else {
                    bd bdVar3 = new bd();
                    bdVar3.jkX = new ArrayList();
                    bdVar = bdVar3;
                }
                if (y.getCount(list) > 1) {
                    bc bcVar = new bc();
                    bcVar.jkT = 1;
                    bcVar.name = getContext().getString(R.string.chosen_pb_title);
                    bdVar.jkX.add(bcVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bc bcVar2 = new bc();
                            bcVar2.jkT = dVar2.tabId;
                            bcVar2.name = dVar2.name;
                            bdVar.jkX.add(bcVar2);
                        }
                    }
                    dVar.jIh = bdVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.jHP = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.jHU > 0 && list.size() == this.jHU) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.jHU, -1);
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
            this.jHN.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.jHX);
            if (this.jHY != 0) {
                tabItemView.setSelectItemColorResId(this.jHY);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.jHN.addView(tabItemView, layoutParams);
            this.jHQ = tabItemView;
            tabItemView.setState(TabItemView.jIj);
            return;
        }
        setVisibility(0);
        if (this.mData == null || dD(list)) {
            this.mData = list;
            this.jHN.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.jHX);
                        if (this.jHY != 0) {
                            tabItemView2.setSelectItemColorResId(this.jHY);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (An(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.CAM_X0105);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.jHN.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.jHQ = tabItemView2;
                            tabItemView2.setState(TabItemView.jIj);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d Aj(int i) {
        if (i < 0 || this.jHP == null || this.jHP.size() == 0) {
            return null;
        }
        for (d dVar : this.jHP) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean Ak(int i) {
        d Aj = Aj(i);
        return (Aj == null || Aj.jIh == null || Aj.jIh.jkX == null || Aj.jIh.jkX.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.jHR = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jHQ != null) {
            this.mPaint.setColor(ap.getColor(R.color.CAM_X0204));
            if (this.jHV) {
                canvas.drawRect(this.jHN.getLeft(), getMeasuredHeight() - this.jHT, this.jHN.getRight() > getRight() ? this.jHN.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.jHX) {
                if (this.jHY == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0302));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.jHY));
                }
                canvas.drawRect(this.jHQ.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.jHS, (this.jHQ.getRight() - getBottomLineMargin()) - this.jHQ.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.jHX) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0105));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.jHQ != null) {
                dimens = this.jHQ.getRight() - this.jHQ.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.jHQ == null || this.jHM == 0) {
            return 0;
        }
        return ((this.jHQ.getMeasuredWidth() - this.jHM) - this.jHQ.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Al(int i) {
        a(Ai(i));
    }

    public void setDataLoadInterface(an anVar) {
        this.jId = anVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.jIe = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.jIe;
    }

    public void setTabBackgroudColor(int i) {
        this.jHW = i;
    }

    public void setAutoFillTabCount(int i) {
        this.jHU = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Am(int i) {
        if (this.jHQ != null && this.jId != null) {
            this.jId.a(this.jHQ.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jHZ = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.jIa = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.jHX = z;
    }

    public static boolean An(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.jHV = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.jHY = i;
    }
}
