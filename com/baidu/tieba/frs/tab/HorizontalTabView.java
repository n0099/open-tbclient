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
    public int fOQ;
    private final LinearLayout fOR;
    private final e fOS;
    private List<d> fOT;
    private TabItemView fOU;
    private com.baidu.tieba.frs.tab.b fOV;
    private final int fOW;
    private final int fOX;
    private int fOY;
    private boolean fOZ;
    private int fPa;
    private boolean fPb;
    private int fPc;
    private a fPd;
    private b fPe;
    private e.b fPf;
    private e.a fPg;
    private af fPh;
    private c fPi;
    private TbPageContext ffp;
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
        void sL(int i);

        boolean sM(int i);
    }

    public void brH() {
        final as asVar;
        if (this.ffp != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).fPl) != null && asVar.fxC != null) {
                for (ar arVar : asVar.fxC) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.ffp.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.fxC.size() > i && asVar.fxC.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.sE(asVar.fxC.get(i).fxy));
                        }
                    }
                });
                bVar.d(this.ffp);
                bVar.agL();
            }
        }
    }

    public d sE(int i) {
        if (!v.aa(this.fOT)) {
            for (d dVar : this.fOT) {
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
            if (dVar.tabId != 302 && this.fPe != null) {
                this.fPe.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (sJ(dVar.tabId)) {
                if (this.fPh != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.fxY = dVar.url;
                    this.fPh.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.fPh != null) {
                    this.fPh.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.fPh == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.fxY = dVar.url;
                    amVar2.stType = dVar.name;
                    this.fPh.a(dVar.tabId, 0, amVar2);
                    if (amVar2.fxZ) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.fOR.getChildCount(); i++) {
                    View childAt = this.fOR.getChildAt(i);
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
                    amVar3.fxY = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.fPh != null && z) {
                    this.fPh.a(dVar.tabId, 0, amVar3);
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
            if (sJ(tabItemView.getTabId())) {
                if (this.fPh != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.fxY = tabItemView.getUrl();
                    this.fPh.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.fPh != null) {
                    this.fPh.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.fOU = tabItemView;
                int[] iArr = new int[2];
                this.fOU.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.fOR.getChildCount(); i2++) {
                    View childAt = this.fOR.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.fOU.getTabId() && !sJ(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.fPm);
                        }
                    }
                }
                if (this.fOU.getState() == TabItemView.fPm || this.fOU.getState() == TabItemView.STATE_EXPANDED) {
                    this.fOS.brK();
                    boolean z2 = this.fOU.getState() == TabItemView.fPm;
                    this.fOU.setState(TabItemView.fPn);
                    d sF = sF(this.fOU.getTabId());
                    if (sF != null) {
                        if (!TextUtils.isEmpty(sF.url)) {
                            am amVar3 = new am();
                            amVar3.fxY = sF.url;
                            amVar3.stType = sF.name;
                            amVar = amVar3;
                        }
                        if (sF.fPl != null && sF.fPl.fxC != null && sF.fPl.fxC.size() > 0) {
                            for (ar arVar : sF.fPl.fxC) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fxy;
                                }
                            }
                        }
                        if (z2 && this.fPh != null) {
                            this.fPh.a(this.fOU.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (sG(this.fOU.getTabId()) && !z) {
                    if (this.fPi == null || this.fPi.sM(this.fOU.getTabId())) {
                        this.fOU.setState(TabItemView.STATE_EXPANDED);
                        this.fOS.a((Activity) getContext(), this, this.fOU, sF(this.fOU.getTabId()).fPl);
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
        this.fOQ = 0;
        this.fOU = null;
        this.fOV = null;
        this.mPaint = new Paint();
        this.fOW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.fOX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.fOY = 0;
        this.fOZ = true;
        this.fPa = R.color.transparent;
        this.fPc = 0;
        this.fPf = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void sK(int i) {
                if (HorizontalTabView.this.fOU != null && HorizontalTabView.this.fPh != null && HorizontalTabView.this.fPh != null) {
                    HorizontalTabView.this.fPh.a(HorizontalTabView.this.fOU.getTabId(), i, null);
                }
                if (HorizontalTabView.this.fOV != null) {
                    HorizontalTabView.this.fOV.sI(i);
                }
            }
        };
        this.fPg = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.fPb) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.fPd != null) {
                                HorizontalTabView.this.fPd.b(HorizontalTabView.this.sE(1));
                            }
                            HorizontalTabView.this.brH();
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
                if (HorizontalTabView.this.fOV != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.sJ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.fOU != null) {
                            HorizontalTabView.this.fOV.sH(HorizontalTabView.this.fOU.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.fOV.sH(((TabItemView) view).getTabId());
                }
            }
        };
        this.fOR = new LinearLayout(context);
        this.fOR.setOrientation(0);
        this.fOR.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.fOS = new e(context, this.fPf, this.fPg);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.fOR, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        com.baidu.tbadk.core.util.am.l(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cm(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d sF = sF(1);
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
        if (sF == null || dVar == null) {
            return false;
        }
        if (sF.fPl == null && dVar.fPl == null) {
            return false;
        }
        if ((sF.fPl != null || dVar.fPl == null) && (dVar.fPl != null || sF.fPl == null)) {
            if (sF.fPl == null || dVar.fPl == null) {
                return false;
            }
            if (sF.fPl.fxC == null && dVar.fPl.fxC == null) {
                return false;
            }
            if ((sF.fPl.fxC != null || dVar.fPl.fxC == null) && (dVar.fPl.fxC != null || sF.fPl.fxC == null)) {
                int size = sF.fPl.fxC.size();
                if (size != dVar.fPl.fxC.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.fPl.fxC.get(i);
                    ar arVar2 = sF.fPl.fxC.get(i);
                    if (arVar.fxy != arVar2.fxy || !arVar.name.equals(arVar2.name)) {
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
        if (this.fPb) {
            this.fOT = new ArrayList();
            this.fOT.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.fPl;
                if (asVar2 != null && asVar2.fxC != null) {
                    asVar2.fxC.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.fxC = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.Z(list) > 1) {
                    ar arVar = new ar();
                    arVar.fxy = 1;
                    arVar.name = getContext().getString(R.string.chosen_pb_title);
                    asVar.fxC.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.fxy = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.fxC.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.fPl = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.fOT = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.fOY > 0 && list.size() == this.fOY) {
            layoutParams = new LinearLayout.LayoutParams(l.af(getContext()) / this.fOY, -1);
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
            this.fOR.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.fPb);
            if (this.fPc != 0) {
                tabItemView.setSelectItemColorResId(this.fPc);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.fOR.addView(tabItemView, layoutParams);
            this.fOU = tabItemView;
            tabItemView.setState(TabItemView.fPn);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cm(list)) {
            this.mData = list;
            this.fOR.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.fPb);
                        if (302 == dVar2.tabId) {
                            com.baidu.tbadk.core.util.am.f(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.fPc != 0) {
                            tabItemView2.setSelectItemColorResId(this.fPc);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (sJ(dVar2.tabId)) {
                            com.baidu.tbadk.core.util.am.j(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.fOR.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.fOU = tabItemView2;
                            tabItemView2.setState(TabItemView.fPn);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d sF(int i) {
        if (i < 0 || this.fOT == null || this.fOT.size() == 0) {
            return null;
        }
        for (d dVar : this.fOT) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean sG(int i) {
        d sF = sF(i);
        return (sF == null || sF.fPl == null || sF.fPl.fxC == null || sF.fPl.fxC.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.fOV = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fOU != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_b));
            if (this.fOZ) {
                canvas.drawRect(this.fOR.getLeft(), getMeasuredHeight() - this.fOX, this.fOR.getRight() > getRight() ? this.fOR.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.fPb) {
                if (this.fPc == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.am.e((Resources) null, (int) R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.am.e((Resources) null, this.fPc));
                }
                canvas.drawRect(this.fOU.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.fOW, (this.fOU.getRight() - getBottomLineMargin()) - this.fOU.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.fPb) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.am.e((Resources) null, (int) R.color.cp_cont_b));
            int g = l.g(getContext(), R.dimen.ds96);
            if (this.fOU != null) {
                g = this.fOU.getRight() - this.fOU.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.g(getContext(), R.dimen.tbds44), l.g(getContext(), R.dimen.tbds98), g, l.g(getContext(), R.dimen.tbds104)), l.g(getContext(), R.dimen.tbds6), l.g(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.fOU == null || this.fOQ == 0) {
            return 0;
        }
        return ((this.fOU.getMeasuredWidth() - this.fOQ) - this.fOU.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sH(int i) {
        a(sE(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.fPh = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.fPi = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.fPi;
    }

    public void setTabBackgroudColor(int i) {
        this.fPa = i;
    }

    public void setAutoFillTabCount(int i) {
        this.fOY = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sI(int i) {
        if (this.fOU != null && this.fPh != null) {
            this.fPh.a(this.fOU.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fPd = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.fPe = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.fPb = z;
    }

    public static boolean sJ(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.fOZ = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.fPc = i;
    }
}
