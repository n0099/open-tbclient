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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext cNa;
    private final LinearLayout doA;
    private final e doB;
    private List<d> doC;
    private TabItemView doD;
    private com.baidu.tieba.frs.tab.b doE;
    private final int doF;
    private final int doG;
    private int doH;
    private boolean doI;
    private int doJ;
    private boolean doK;
    private int doL;
    private a doM;
    private b doN;
    private e.b doO;
    private e.a doP;
    private ag doQ;
    private c doR;
    public int doz;
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
        void lh(int i);

        boolean li(int i);
    }

    public void auJ() {
        final as asVar;
        if (this.cNa != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).doU) != null && asVar.dad != null) {
                for (ar arVar : asVar.dad) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cNa.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0086b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                        if (asVar.dad.size() > i && asVar.dad.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.la(asVar.dad.get(i).cZZ));
                        }
                    }
                });
                bVar.d(this.cNa);
                bVar.tG();
            }
        }
    }

    public d la(int i) {
        if (!v.w(this.doC)) {
            for (d dVar : this.doC) {
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
            if (dVar.tabId != 302 && this.doN != null) {
                this.doN.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (lf(dVar.tabId)) {
                if (this.doQ != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.das = dVar.url;
                    this.doQ.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.doQ != null) {
                    this.doQ.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.doQ == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.das = dVar.url;
                    amVar2.stType = dVar.name;
                    this.doQ.a(dVar.tabId, 0, amVar2);
                    if (amVar2.dau) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.doA.getChildCount(); i++) {
                    View childAt = this.doA.getChildAt(i);
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
                    amVar3.das = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.doQ != null && z) {
                    this.doQ.a(dVar.tabId, 0, amVar3);
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
            if (lf(tabItemView.getTabId())) {
                if (this.doQ != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.das = tabItemView.getUrl();
                    this.doQ.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.doQ != null) {
                    this.doQ.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.doD = tabItemView;
                int[] iArr = new int[2];
                this.doD.getLocationOnScreen(iArr);
                int af = l.af(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds160);
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
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.doA.getChildCount(); i2++) {
                    View childAt = this.doA.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.doD.getTabId() && !lf(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.doV);
                        }
                    }
                }
                if (this.doD.getState() == TabItemView.doV || this.doD.getState() == TabItemView.STATE_EXPANDED) {
                    this.doB.auM();
                    boolean z2 = this.doD.getState() == TabItemView.doV;
                    this.doD.setState(TabItemView.doW);
                    d lb = lb(this.doD.getTabId());
                    if (lb != null) {
                        if (!TextUtils.isEmpty(lb.url)) {
                            am amVar3 = new am();
                            amVar3.das = lb.url;
                            amVar3.stType = lb.name;
                            amVar = amVar3;
                        }
                        if (lb.doU != null && lb.doU.dad != null && lb.doU.dad.size() > 0) {
                            for (ar arVar : lb.doU.dad) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.cZZ;
                                }
                            }
                        }
                        if (z2 && this.doQ != null) {
                            this.doQ.a(this.doD.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (lc(this.doD.getTabId()) && !z) {
                    if (this.doR == null || this.doR.li(this.doD.getTabId())) {
                        this.doD.setState(TabItemView.STATE_EXPANDED);
                        this.doB.a((Activity) getContext(), this, this.doD, lb(this.doD.getTabId()).doU);
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
        this.doz = 0;
        this.doD = null;
        this.doE = null;
        this.mPaint = new Paint();
        this.doF = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.doG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.doH = 0;
        this.doI = true;
        this.doJ = d.C0126d.transparent;
        this.doL = 0;
        this.doO = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void lg(int i) {
                if (HorizontalTabView.this.doD != null && HorizontalTabView.this.doQ != null && HorizontalTabView.this.doQ != null) {
                    HorizontalTabView.this.doQ.a(HorizontalTabView.this.doD.getTabId(), i, null);
                }
                if (HorizontalTabView.this.doE != null) {
                    HorizontalTabView.this.doE.le(i);
                }
            }
        };
        this.doP = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d dVar;
                if (HorizontalTabView.this.doK) {
                    if (view2 instanceof TabItemView) {
                        if (((TabItemView) view2).getTabId() == 1) {
                            if (HorizontalTabView.this.doM != null) {
                                HorizontalTabView.this.doM.b(HorizontalTabView.this.la(1));
                            }
                            HorizontalTabView.this.auJ();
                            return;
                        } else if (((TabItemView) view2).getTabId() == 302) {
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
                if (view2 instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view2, false);
                }
                if (HorizontalTabView.this.doE != null) {
                    if (!(view2 instanceof TabItemView) || !HorizontalTabView.lf(((TabItemView) view2).getTabId())) {
                        if (HorizontalTabView.this.doD != null) {
                            HorizontalTabView.this.doE.ld(HorizontalTabView.this.doD.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.doE.ld(((TabItemView) view2).getTabId());
                }
            }
        };
        this.doA = new LinearLayout(context);
        this.doA.setOrientation(0);
        this.doA.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.doB = new e(context, this.doO, this.doP);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.doA, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ak.j(this, d.C0126d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bq(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d lb = lb(1);
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
        if (lb == null || dVar == null) {
            return false;
        }
        if (lb.doU == null && dVar.doU == null) {
            return false;
        }
        if ((lb.doU != null || dVar.doU == null) && (dVar.doU != null || lb.doU == null)) {
            if (lb.doU == null || dVar.doU == null) {
                return false;
            }
            if (lb.doU.dad == null && dVar.doU.dad == null) {
                return false;
            }
            if ((lb.doU.dad != null || dVar.doU.dad == null) && (dVar.doU.dad != null || lb.doU.dad == null)) {
                int size = lb.doU.dad.size();
                if (size != dVar.doU.dad.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.doU.dad.get(i);
                    ar arVar2 = lb.doU.dad.get(i);
                    if (arVar.cZZ != arVar2.cZZ || !arVar.name.equals(arVar2.name)) {
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
        if (this.doK) {
            this.doC = new ArrayList();
            this.doC.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.doU;
                if (asVar2 != null && asVar2.dad != null) {
                    asVar2.dad.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.dad = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.v(list) > 1) {
                    ar arVar = new ar();
                    arVar.cZZ = 1;
                    arVar.name = getContext().getString(d.k.chosen_pb_title);
                    asVar.dad.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.cZZ = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.dad.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.doU = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.doC = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.doH > 0 && list.size() == this.doH) {
            layoutParams = new LinearLayout.LayoutParams(l.af(getContext()) / this.doH, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.tabId = 1;
            dVar.name = getContext().getResources().getString(d.k.chosen_pb_title);
            this.doA.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.doK);
            if (this.doL != 0) {
                tabItemView.setSelectItemColorResId(this.doL);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.doA.addView(tabItemView, layoutParams);
            this.doD = tabItemView;
            tabItemView.setState(TabItemView.doW);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bq(list)) {
            this.mData = list;
            this.doA.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.doK);
                        if (302 == dVar2.tabId) {
                            ak.c(tabItemView2, d.C0126d.cp_cont_j, 1);
                        }
                        if (this.doL != 0) {
                            tabItemView2.setSelectItemColorResId(this.doL);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (lf(dVar2.tabId)) {
                            ak.h(tabItemView2, d.C0126d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.doA.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.doD = tabItemView2;
                            tabItemView2.setState(TabItemView.doW);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d lb(int i) {
        if (i < 0 || this.doC == null || this.doC.size() == 0) {
            return null;
        }
        for (d dVar : this.doC) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean lc(int i) {
        d lb = lb(i);
        return (lb == null || lb.doU == null || lb.doU.dad == null || lb.doU.dad.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.doE = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.doD != null) {
            this.mPaint.setColor(ak.getColor(d.C0126d.cp_bg_line_b));
            if (this.doI) {
                canvas.drawRect(this.doA.getLeft(), getMeasuredHeight() - this.doG, this.doA.getRight() > getRight() ? this.doA.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.doK) {
                if (this.doL == 0) {
                    this.mPaint.setColor(ak.d((Resources) null, d.C0126d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ak.d((Resources) null, this.doL));
                }
                canvas.drawRect(this.doD.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.doF, (this.doD.getRight() - getBottomLineMargin()) - this.doD.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.doK) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ak.d((Resources) null, d.C0126d.cp_cont_b));
            int e = l.e(getContext(), d.e.ds96);
            if (this.doD != null) {
                e = this.doD.getRight() - this.doD.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.e(getContext(), d.e.tbds44), l.e(getContext(), d.e.tbds98), e, l.e(getContext(), d.e.tbds104)), l.e(getContext(), d.e.tbds6), l.e(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.doD == null || this.doz == 0) {
            return 0;
        }
        return ((this.doD.getMeasuredWidth() - this.doz) - this.doD.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void ld(int i) {
        a(la(i));
    }

    public void setDataLoadInterface(ag agVar) {
        this.doQ = agVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.doR = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.doR;
    }

    public void setTabBackgroudColor(int i) {
        this.doJ = i;
    }

    public void setAutoFillTabCount(int i) {
        this.doH = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void le(int i) {
        if (this.doD != null && this.doQ != null) {
            this.doQ.a(this.doD.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.doM = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.doN = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.doK = z;
    }

    public static boolean lf(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.doI = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.doL = i;
    }
}
