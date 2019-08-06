package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    public int fPE;
    private final LinearLayout fPF;
    private final e fPG;
    private List<d> fPH;
    private TabItemView fPI;
    private com.baidu.tieba.frs.tab.b fPJ;
    private final int fPK;
    private final int fPL;
    private int fPM;
    private boolean fPN;
    private int fPO;
    private boolean fPP;
    private int fPQ;
    private a fPR;
    private b fPS;
    private e.b fPT;
    private e.a fPU;
    private af fPV;
    private c fPW;
    private TbPageContext ffP;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes4.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void sN(int i);

        boolean sO(int i);
    }

    public void brU() {
        final as asVar;
        if (this.ffP != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).fPZ) != null && asVar.fyb != null) {
                for (ar arVar : asVar.fyb) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.ffP.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.fyb.size() > i && asVar.fyb.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.sG(asVar.fyb.get(i).fxX));
                        }
                    }
                });
                bVar.d(this.ffP);
                bVar.agN();
            }
        }
    }

    public d sG(int i) {
        if (!v.aa(this.fPH)) {
            for (d dVar : this.fPH) {
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
            if (dVar.tabId != 302 && this.fPS != null) {
                this.fPS.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (sL(dVar.tabId)) {
                if (this.fPV != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.fyx = dVar.url;
                    this.fPV.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.fPV != null) {
                    this.fPV.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.fPV == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.fyx = dVar.url;
                    amVar2.stType = dVar.name;
                    this.fPV.a(dVar.tabId, 0, amVar2);
                    if (amVar2.fyy) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.fPF.getChildCount(); i++) {
                    View childAt = this.fPF.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                am amVar3 = null;
                if (!TextUtils.isEmpty(dVar.url)) {
                    amVar3 = new am();
                    amVar3.fyx = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.fPV != null && z) {
                    this.fPV.a(dVar.tabId, 0, amVar3);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        am amVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (sL(tabItemView.getTabId())) {
                if (this.fPV != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.fyx = tabItemView.getUrl();
                    this.fPV.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.fPV != null) {
                    this.fPV.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.fPI = tabItemView;
                int[] iArr = new int[2];
                this.fPI.getLocationOnScreen(iArr);
                int af = l.af(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (af < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.fPF.getChildCount(); i2++) {
                    View childAt = this.fPF.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.fPI.getTabId() && !sL(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.fQa);
                        }
                    }
                }
                if (this.fPI.getState() == TabItemView.fQa || this.fPI.getState() == TabItemView.STATE_EXPANDED) {
                    this.fPG.brX();
                    boolean z2 = this.fPI.getState() == TabItemView.fQa;
                    this.fPI.setState(TabItemView.fQb);
                    d sH = sH(this.fPI.getTabId());
                    if (sH != null) {
                        if (!TextUtils.isEmpty(sH.url)) {
                            am amVar3 = new am();
                            amVar3.fyx = sH.url;
                            amVar3.stType = sH.name;
                            amVar = amVar3;
                        }
                        if (sH.fPZ != null && sH.fPZ.fyb != null && sH.fPZ.fyb.size() > 0) {
                            for (ar arVar : sH.fPZ.fyb) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fxX;
                                }
                            }
                        }
                        if (z2 && this.fPV != null) {
                            this.fPV.a(this.fPI.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (sI(this.fPI.getTabId()) && !z) {
                    if (this.fPW == null || this.fPW.sO(this.fPI.getTabId())) {
                        this.fPI.setState(TabItemView.STATE_EXPANDED);
                        this.fPG.a((Activity) getContext(), this, this.fPI, sH(this.fPI.getTabId()).fPZ);
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
        this.fPE = 0;
        this.fPI = null;
        this.fPJ = null;
        this.mPaint = new Paint();
        this.fPK = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.fPL = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.fPM = 0;
        this.fPN = true;
        this.fPO = R.color.transparent;
        this.fPQ = 0;
        this.fPT = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void sM(int i) {
                if (HorizontalTabView.this.fPI != null && HorizontalTabView.this.fPV != null && HorizontalTabView.this.fPV != null) {
                    HorizontalTabView.this.fPV.a(HorizontalTabView.this.fPI.getTabId(), i, null);
                }
                if (HorizontalTabView.this.fPJ != null) {
                    HorizontalTabView.this.fPJ.sK(i);
                }
            }
        };
        this.fPU = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.fPP) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.fPR != null) {
                                HorizontalTabView.this.fPR.b(HorizontalTabView.this.sG(1));
                            }
                            HorizontalTabView.this.brU();
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
                if (HorizontalTabView.this.fPJ != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.sL(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.fPI != null) {
                            HorizontalTabView.this.fPJ.sJ(HorizontalTabView.this.fPI.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.fPJ.sJ(((TabItemView) view).getTabId());
                }
            }
        };
        this.fPF = new LinearLayout(context);
        this.fPF.setOrientation(0);
        this.fPF.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.fPG = new e(context, this.fPT, this.fPU);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.fPF, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        com.baidu.tbadk.core.util.am.l(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cl(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d sH = sH(1);
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
        if (sH == null || dVar == null) {
            return false;
        }
        if (sH.fPZ == null && dVar.fPZ == null) {
            return false;
        }
        if ((sH.fPZ != null || dVar.fPZ == null) && (dVar.fPZ != null || sH.fPZ == null)) {
            if (sH.fPZ == null || dVar.fPZ == null) {
                return false;
            }
            if (sH.fPZ.fyb == null && dVar.fPZ.fyb == null) {
                return false;
            }
            if ((sH.fPZ.fyb != null || dVar.fPZ.fyb == null) && (dVar.fPZ.fyb != null || sH.fPZ.fyb == null)) {
                int size = sH.fPZ.fyb.size();
                if (size != dVar.fPZ.fyb.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.fPZ.fyb.get(i);
                    ar arVar2 = sH.fPZ.fyb.get(i);
                    if (arVar.fxX != arVar2.fxX || !arVar.name.equals(arVar2.name)) {
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
        as asVar;
        if (this.fPP) {
            this.fPH = new ArrayList();
            this.fPH.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.fPZ;
                if (asVar2 != null && asVar2.fyb != null) {
                    asVar2.fyb.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.fyb = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.Z(list) > 1) {
                    ar arVar = new ar();
                    arVar.fxX = 1;
                    arVar.name = getContext().getString(R.string.chosen_pb_title);
                    asVar.fyb.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.fxX = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.fyb.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.fPZ = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.fPH = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.fPM > 0 && list.size() == this.fPM) {
            layoutParams = new LinearLayout.LayoutParams(l.af(getContext()) / this.fPM, -1);
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
            this.fPF.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.fPP);
            if (this.fPQ != 0) {
                tabItemView.setSelectItemColorResId(this.fPQ);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.fPF.addView(tabItemView, layoutParams);
            this.fPI = tabItemView;
            tabItemView.setState(TabItemView.fQb);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cl(list)) {
            this.mData = list;
            this.fPF.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.fPP);
                        if (302 == dVar2.tabId) {
                            com.baidu.tbadk.core.util.am.f(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.fPQ != 0) {
                            tabItemView2.setSelectItemColorResId(this.fPQ);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (sL(dVar2.tabId)) {
                            com.baidu.tbadk.core.util.am.j(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.fPF.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.fPI = tabItemView2;
                            tabItemView2.setState(TabItemView.fQb);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d sH(int i) {
        if (i < 0 || this.fPH == null || this.fPH.size() == 0) {
            return null;
        }
        for (d dVar : this.fPH) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean sI(int i) {
        d sH = sH(i);
        return (sH == null || sH.fPZ == null || sH.fPZ.fyb == null || sH.fPZ.fyb.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.fPJ = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fPI != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_b));
            if (this.fPN) {
                canvas.drawRect(this.fPF.getLeft(), getMeasuredHeight() - this.fPL, this.fPF.getRight() > getRight() ? this.fPF.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.fPP) {
                if (this.fPQ == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.am.e((Resources) null, (int) R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.am.e((Resources) null, this.fPQ));
                }
                canvas.drawRect(this.fPI.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.fPK, (this.fPI.getRight() - getBottomLineMargin()) - this.fPI.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.fPP) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.am.e((Resources) null, (int) R.color.cp_cont_b));
            int g = l.g(getContext(), R.dimen.ds96);
            if (this.fPI != null) {
                g = this.fPI.getRight() - this.fPI.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.g(getContext(), R.dimen.tbds44), l.g(getContext(), R.dimen.tbds98), g, l.g(getContext(), R.dimen.tbds104)), l.g(getContext(), R.dimen.tbds6), l.g(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.fPI == null || this.fPE == 0) {
            return 0;
        }
        return ((this.fPI.getMeasuredWidth() - this.fPE) - this.fPI.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sJ(int i) {
        a(sG(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.fPV = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.fPW = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.fPW;
    }

    public void setTabBackgroudColor(int i) {
        this.fPO = i;
    }

    public void setAutoFillTabCount(int i) {
        this.fPM = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sK(int i) {
        if (this.fPI != null && this.fPV != null) {
            this.fPV.a(this.fPI.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fPR = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.fPS = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.fPP = z;
    }

    public static boolean sL(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.fPN = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.fPQ = i;
    }
}
