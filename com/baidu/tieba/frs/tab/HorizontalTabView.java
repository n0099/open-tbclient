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
    private TbPageContext iVb;
    private final e jHA;
    private List<d> jHB;
    private TabItemView jHC;
    private com.baidu.tieba.frs.tab.b jHD;
    private final int jHE;
    private final int jHF;
    private int jHG;
    private boolean jHH;
    private int jHI;
    private boolean jHJ;
    private int jHK;
    private a jHL;
    private b jHM;
    private e.b jHN;
    private e.a jHO;
    private an jHP;
    private c jHQ;
    public int jHy;
    private final LinearLayout jHz;
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

    public void cKg() {
        final bd bdVar;
        if (this.iVb != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bdVar = this.mData.get(0).jHT) != null && bdVar.jkJ != null) {
                for (bc bcVar : bdVar.jkJ) {
                    if (bcVar != null) {
                        arrayList.add(bcVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iVb.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0558b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bdVar.jkJ.size() > i && bdVar.jkJ.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.Ai(bdVar.jkJ.get(i).jkF));
                        }
                    }
                });
                bVar.d(this.iVb);
                bVar.bqz();
            }
        }
    }

    public d Ai(int i) {
        if (!y.isEmpty(this.jHB)) {
            for (d dVar : this.jHB) {
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
            if (this.jHM != null) {
                this.jHM.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (An(dVar.tabId)) {
                if (this.jHP != null && !TextUtils.isEmpty(dVar.url)) {
                    ax axVar2 = new ax();
                    axVar2.ext = dVar.url;
                    this.jHP.a(dVar.tabId, -1, axVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.jHP != null) {
                    this.jHP.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.jHP == null) {
                    z = true;
                } else {
                    ax axVar3 = new ax();
                    axVar3.ext = dVar.url;
                    axVar3.stType = dVar.name;
                    this.jHP.a(dVar.tabId, 0, axVar3);
                    if (axVar3.jlf) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.jHz.getChildCount(); i++) {
                    View childAt = this.jHz.getChildAt(i);
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
                if (this.jHP != null && z) {
                    this.jHP.a(dVar.tabId, 0, axVar);
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
                if (this.jHP != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ax axVar2 = new ax();
                    axVar2.ext = tabItemView.getUrl();
                    this.jHP.a(tabItemView.getTabId(), -1, axVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.jHP != null) {
                    this.jHP.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.jHC = tabItemView;
                int[] iArr = new int[2];
                this.jHC.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.jHz.getChildCount(); i2++) {
                    View childAt = this.jHz.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.jHC.getTabId() && !An(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.jHU);
                        }
                    }
                }
                if (this.jHC.getState() == TabItemView.jHU || this.jHC.getState() == TabItemView.STATE_EXPANDED) {
                    this.jHA.cKj();
                    boolean z2 = this.jHC.getState() == TabItemView.jHU;
                    this.jHC.setState(TabItemView.jHV);
                    d Aj = Aj(this.jHC.getTabId());
                    if (Aj != null) {
                        if (!TextUtils.isEmpty(Aj.url)) {
                            ax axVar3 = new ax();
                            axVar3.ext = Aj.url;
                            axVar3.stType = Aj.name;
                            axVar = axVar3;
                        }
                        if (Aj.jHT != null && Aj.jHT.jkJ != null && Aj.jHT.jkJ.size() > 0) {
                            for (bc bcVar : Aj.jHT.jkJ) {
                                if (bcVar != null && bcVar.isSelected) {
                                    i = bcVar.jkF;
                                }
                            }
                        }
                        if (z2 && this.jHP != null) {
                            this.jHP.a(this.jHC.getTabId(), i, axVar);
                        }
                    } else {
                        return;
                    }
                } else if (Ak(this.jHC.getTabId()) && !z) {
                    if (this.jHQ == null || this.jHQ.Aq(this.jHC.getTabId())) {
                        this.jHC.setState(TabItemView.STATE_EXPANDED);
                        this.jHA.a((Activity) getContext(), this, this.jHC, Aj(this.jHC.getTabId()).jHT);
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
        this.jHy = 0;
        this.jHC = null;
        this.jHD = null;
        this.mPaint = new Paint();
        this.jHE = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.jHF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.jHG = 0;
        this.jHH = true;
        this.jHI = R.color.transparent;
        this.jHK = 0;
        this.jHN = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void Ao(int i) {
                if (HorizontalTabView.this.jHC != null && HorizontalTabView.this.jHP != null && HorizontalTabView.this.jHP != null) {
                    HorizontalTabView.this.jHP.a(HorizontalTabView.this.jHC.getTabId(), i, null);
                }
                if (HorizontalTabView.this.jHD != null) {
                    HorizontalTabView.this.jHD.Am(i);
                }
            }
        };
        this.jHO = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.jHJ) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.jHL != null) {
                            HorizontalTabView.this.jHL.b(HorizontalTabView.this.Ai(1));
                        }
                        HorizontalTabView.this.cKg();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.jHD != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.An(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.jHC != null) {
                            HorizontalTabView.this.jHD.Al(HorizontalTabView.this.jHC.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.jHD.Al(((TabItemView) view).getTabId());
                }
            }
        };
        this.jHz = new LinearLayout(context);
        this.jHz.setOrientation(0);
        this.jHz.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.jHA = new e(context, this.jHN, this.jHO);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.jHz, layoutParams);
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
        if (Aj.jHT == null && dVar.jHT == null) {
            return false;
        }
        if ((Aj.jHT != null || dVar.jHT == null) && (dVar.jHT != null || Aj.jHT == null)) {
            if (Aj.jHT == null || dVar.jHT == null) {
                return false;
            }
            if (Aj.jHT.jkJ == null && dVar.jHT.jkJ == null) {
                return false;
            }
            if ((Aj.jHT.jkJ != null || dVar.jHT.jkJ == null) && (dVar.jHT.jkJ != null || Aj.jHT.jkJ == null)) {
                int size = Aj.jHT.jkJ.size();
                if (size != dVar.jHT.jkJ.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bc bcVar = dVar.jHT.jkJ.get(i);
                    bc bcVar2 = Aj.jHT.jkJ.get(i);
                    if (bcVar.jkF != bcVar2.jkF || !bcVar.name.equals(bcVar2.name)) {
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
        if (this.jHJ) {
            this.jHB = new ArrayList();
            this.jHB.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bd bdVar2 = dVar.jHT;
                if (bdVar2 != null && bdVar2.jkJ != null) {
                    bdVar2.jkJ.clear();
                    bdVar = bdVar2;
                } else {
                    bd bdVar3 = new bd();
                    bdVar3.jkJ = new ArrayList();
                    bdVar = bdVar3;
                }
                if (y.getCount(list) > 1) {
                    bc bcVar = new bc();
                    bcVar.jkF = 1;
                    bcVar.name = getContext().getString(R.string.chosen_pb_title);
                    bdVar.jkJ.add(bcVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bc bcVar2 = new bc();
                            bcVar2.jkF = dVar2.tabId;
                            bcVar2.name = dVar2.name;
                            bdVar.jkJ.add(bcVar2);
                        }
                    }
                    dVar.jHT = bdVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.jHB = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.jHG > 0 && list.size() == this.jHG) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.jHG, -1);
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
            this.jHz.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.jHJ);
            if (this.jHK != 0) {
                tabItemView.setSelectItemColorResId(this.jHK);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.jHz.addView(tabItemView, layoutParams);
            this.jHC = tabItemView;
            tabItemView.setState(TabItemView.jHV);
            return;
        }
        setVisibility(0);
        if (this.mData == null || dD(list)) {
            this.mData = list;
            this.jHz.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.jHJ);
                        if (this.jHK != 0) {
                            tabItemView2.setSelectItemColorResId(this.jHK);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (An(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.CAM_X0105);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.jHz.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.jHC = tabItemView2;
                            tabItemView2.setState(TabItemView.jHV);
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
        if (i < 0 || this.jHB == null || this.jHB.size() == 0) {
            return null;
        }
        for (d dVar : this.jHB) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean Ak(int i) {
        d Aj = Aj(i);
        return (Aj == null || Aj.jHT == null || Aj.jHT.jkJ == null || Aj.jHT.jkJ.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.jHD = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jHC != null) {
            this.mPaint.setColor(ap.getColor(R.color.CAM_X0204));
            if (this.jHH) {
                canvas.drawRect(this.jHz.getLeft(), getMeasuredHeight() - this.jHF, this.jHz.getRight() > getRight() ? this.jHz.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.jHJ) {
                if (this.jHK == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0302));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.jHK));
                }
                canvas.drawRect(this.jHC.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.jHE, (this.jHC.getRight() - getBottomLineMargin()) - this.jHC.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.jHJ) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0105));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.jHC != null) {
                dimens = this.jHC.getRight() - this.jHC.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.jHC == null || this.jHy == 0) {
            return 0;
        }
        return ((this.jHC.getMeasuredWidth() - this.jHy) - this.jHC.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Al(int i) {
        a(Ai(i));
    }

    public void setDataLoadInterface(an anVar) {
        this.jHP = anVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.jHQ = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.jHQ;
    }

    public void setTabBackgroudColor(int i) {
        this.jHI = i;
    }

    public void setAutoFillTabCount(int i) {
        this.jHG = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Am(int i) {
        if (this.jHC != null && this.jHP != null) {
            this.jHP.a(this.jHC.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jHL = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.jHM = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.jHJ = z;
    }

    public static boolean An(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.jHH = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.jHK = i;
    }
}
