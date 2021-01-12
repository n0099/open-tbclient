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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private TbPageContext iPu;
    public int jBU;
    private final LinearLayout jBV;
    private final e jBW;
    private List<d> jBX;
    private TabItemView jBY;
    private com.baidu.tieba.frs.tab.b jBZ;
    private final int jCa;
    private final int jCb;
    private int jCc;
    private boolean jCd;
    private int jCe;
    private boolean jCf;
    private int jCg;
    private a jCh;
    private b jCi;
    private e.b jCj;
    private e.a jCk;
    private an jCl;
    private c jCm;
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
        void Af(int i);

        boolean Ag(int i);
    }

    public void cIT() {
        final bd bdVar;
        if (this.iPu != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bdVar = this.mData.get(0).jCp) != null && bdVar.jfc != null) {
                for (bc bcVar : bdVar.jfc) {
                    if (bcVar != null) {
                        arrayList.add(bcVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iPu.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0561b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bdVar.jfc.size() > i && bdVar.jfc.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.zY(bdVar.jfc.get(i).jeY));
                        }
                    }
                });
                bVar.d(this.iPu);
                bVar.bqg();
            }
        }
    }

    public d zY(int i) {
        if (!x.isEmpty(this.jBX)) {
            for (d dVar : this.jBX) {
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
            if (this.jCi != null) {
                this.jCi.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (Ad(dVar.tabId)) {
                if (this.jCl != null && !TextUtils.isEmpty(dVar.url)) {
                    ax axVar2 = new ax();
                    axVar2.ext = dVar.url;
                    this.jCl.a(dVar.tabId, -1, axVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.jCl != null) {
                    this.jCl.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.jCl == null) {
                    z = true;
                } else {
                    ax axVar3 = new ax();
                    axVar3.ext = dVar.url;
                    axVar3.stType = dVar.name;
                    this.jCl.a(dVar.tabId, 0, axVar3);
                    if (axVar3.jfy) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.jBV.getChildCount(); i++) {
                    View childAt = this.jBV.getChildAt(i);
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
                if (this.jCl != null && z) {
                    this.jCl.a(dVar.tabId, 0, axVar);
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
            if (Ad(tabItemView.getTabId())) {
                if (this.jCl != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ax axVar2 = new ax();
                    axVar2.ext = tabItemView.getUrl();
                    this.jCl.a(tabItemView.getTabId(), -1, axVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.jCl != null) {
                    this.jCl.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.jBY = tabItemView;
                int[] iArr = new int[2];
                this.jBY.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.jBV.getChildCount(); i2++) {
                    View childAt = this.jBV.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.jBY.getTabId() && !Ad(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.jCq);
                        }
                    }
                }
                if (this.jBY.getState() == TabItemView.jCq || this.jBY.getState() == TabItemView.STATE_EXPANDED) {
                    this.jBW.cIW();
                    boolean z2 = this.jBY.getState() == TabItemView.jCq;
                    this.jBY.setState(TabItemView.jCr);
                    d zZ = zZ(this.jBY.getTabId());
                    if (zZ != null) {
                        if (!TextUtils.isEmpty(zZ.url)) {
                            ax axVar3 = new ax();
                            axVar3.ext = zZ.url;
                            axVar3.stType = zZ.name;
                            axVar = axVar3;
                        }
                        if (zZ.jCp != null && zZ.jCp.jfc != null && zZ.jCp.jfc.size() > 0) {
                            for (bc bcVar : zZ.jCp.jfc) {
                                if (bcVar != null && bcVar.isSelected) {
                                    i = bcVar.jeY;
                                }
                            }
                        }
                        if (z2 && this.jCl != null) {
                            this.jCl.a(this.jBY.getTabId(), i, axVar);
                        }
                    } else {
                        return;
                    }
                } else if (Aa(this.jBY.getTabId()) && !z) {
                    if (this.jCm == null || this.jCm.Ag(this.jBY.getTabId())) {
                        this.jBY.setState(TabItemView.STATE_EXPANDED);
                        this.jBW.a((Activity) getContext(), this, this.jBY, zZ(this.jBY.getTabId()).jCp);
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
        this.jBU = 0;
        this.jBY = null;
        this.jBZ = null;
        this.mPaint = new Paint();
        this.jCa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.jCb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.jCc = 0;
        this.jCd = true;
        this.jCe = R.color.transparent;
        this.jCg = 0;
        this.jCj = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void Ae(int i) {
                if (HorizontalTabView.this.jBY != null && HorizontalTabView.this.jCl != null && HorizontalTabView.this.jCl != null) {
                    HorizontalTabView.this.jCl.a(HorizontalTabView.this.jBY.getTabId(), i, null);
                }
                if (HorizontalTabView.this.jBZ != null) {
                    HorizontalTabView.this.jBZ.Ac(i);
                }
            }
        };
        this.jCk = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.jCf) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.jCh != null) {
                            HorizontalTabView.this.jCh.b(HorizontalTabView.this.zY(1));
                        }
                        HorizontalTabView.this.cIT();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.jBZ != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.Ad(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.jBY != null) {
                            HorizontalTabView.this.jBZ.Ab(HorizontalTabView.this.jBY.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.jBZ.Ab(((TabItemView) view).getTabId());
                }
            }
        };
        this.jBV = new LinearLayout(context);
        this.jBV.setOrientation(0);
        this.jBV.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.jBW = new e(context, this.jCj, this.jCk);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.jBV, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ao.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean dI(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d zZ = zZ(1);
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
        if (zZ == null || dVar == null) {
            return false;
        }
        if (zZ.jCp == null && dVar.jCp == null) {
            return false;
        }
        if ((zZ.jCp != null || dVar.jCp == null) && (dVar.jCp != null || zZ.jCp == null)) {
            if (zZ.jCp == null || dVar.jCp == null) {
                return false;
            }
            if (zZ.jCp.jfc == null && dVar.jCp.jfc == null) {
                return false;
            }
            if ((zZ.jCp.jfc != null || dVar.jCp.jfc == null) && (dVar.jCp.jfc != null || zZ.jCp.jfc == null)) {
                int size = zZ.jCp.jfc.size();
                if (size != dVar.jCp.jfc.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bc bcVar = dVar.jCp.jfc.get(i);
                    bc bcVar2 = zZ.jCp.jfc.get(i);
                    if (bcVar.jeY != bcVar2.jeY || !bcVar.name.equals(bcVar2.name)) {
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
        if (this.jCf) {
            this.jBX = new ArrayList();
            this.jBX.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bd bdVar2 = dVar.jCp;
                if (bdVar2 != null && bdVar2.jfc != null) {
                    bdVar2.jfc.clear();
                    bdVar = bdVar2;
                } else {
                    bd bdVar3 = new bd();
                    bdVar3.jfc = new ArrayList();
                    bdVar = bdVar3;
                }
                if (x.getCount(list) > 1) {
                    bc bcVar = new bc();
                    bcVar.jeY = 1;
                    bcVar.name = getContext().getString(R.string.chosen_pb_title);
                    bdVar.jfc.add(bcVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bc bcVar2 = new bc();
                            bcVar2.jeY = dVar2.tabId;
                            bcVar2.name = dVar2.name;
                            bdVar.jfc.add(bcVar2);
                        }
                    }
                    dVar.jCp = bdVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.jBX = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.jCc > 0 && list.size() == this.jCc) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.jCc, -1);
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
            this.jBV.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.jCf);
            if (this.jCg != 0) {
                tabItemView.setSelectItemColorResId(this.jCg);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.jBV.addView(tabItemView, layoutParams);
            this.jBY = tabItemView;
            tabItemView.setState(TabItemView.jCr);
            return;
        }
        setVisibility(0);
        if (this.mData == null || dI(list)) {
            this.mData = list;
            this.jBV.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.jCf);
                        if (this.jCg != 0) {
                            tabItemView2.setSelectItemColorResId(this.jCg);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (Ad(dVar2.tabId)) {
                            ao.setViewTextColor(tabItemView2, R.color.CAM_X0105);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.jBV.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.jBY = tabItemView2;
                            tabItemView2.setState(TabItemView.jCr);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d zZ(int i) {
        if (i < 0 || this.jBX == null || this.jBX.size() == 0) {
            return null;
        }
        for (d dVar : this.jBX) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean Aa(int i) {
        d zZ = zZ(i);
        return (zZ == null || zZ.jCp == null || zZ.jCp.jfc == null || zZ.jCp.jfc.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.jBZ = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jBY != null) {
            this.mPaint.setColor(ao.getColor(R.color.CAM_X0204));
            if (this.jCd) {
                canvas.drawRect(this.jBV.getLeft(), getMeasuredHeight() - this.jCb, this.jBV.getRight() > getRight() ? this.jBV.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.jCf) {
                if (this.jCg == 0) {
                    this.mPaint.setColor(ao.getSkinColor(null, R.color.CAM_X0302));
                } else {
                    this.mPaint.setColor(ao.getSkinColor(null, this.jCg));
                }
                canvas.drawRect(this.jBY.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.jCa, (this.jBY.getRight() - getBottomLineMargin()) - this.jBY.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.jCf) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ao.getSkinColor(null, R.color.CAM_X0105));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.jBY != null) {
                dimens = this.jBY.getRight() - this.jBY.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.jBY == null || this.jBU == 0) {
            return 0;
        }
        return ((this.jBY.getMeasuredWidth() - this.jBU) - this.jBY.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Ab(int i) {
        a(zY(i));
    }

    public void setDataLoadInterface(an anVar) {
        this.jCl = anVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.jCm = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.jCm;
    }

    public void setTabBackgroudColor(int i) {
        this.jCe = i;
    }

    public void setAutoFillTabCount(int i) {
        this.jCc = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Ac(int i) {
        if (this.jBY != null && this.jCl != null) {
            this.jCl.a(this.jBY.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jCh = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.jCi = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.jCf = z;
    }

    public static boolean Ad(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.jCd = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.jCg = i;
    }
}
