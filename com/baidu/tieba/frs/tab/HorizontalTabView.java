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
    private TbPageContext cMX;
    private TabItemView doA;
    private com.baidu.tieba.frs.tab.b doB;
    private final int doC;
    private final int doD;
    private int doE;
    private boolean doF;
    private int doG;
    private boolean doH;
    private int doI;
    private a doJ;
    private b doK;
    private e.b doL;
    private e.a doM;
    private ag doN;
    private c doO;
    public int dow;
    private final LinearLayout dox;
    private final e doy;
    private List<d> doz;
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
        if (this.cMX != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).doR) != null && asVar.daa != null) {
                for (ar arVar : asVar.daa) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cMX.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0086b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                        if (asVar.daa.size() > i && asVar.daa.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.la(asVar.daa.get(i).cZW));
                        }
                    }
                });
                bVar.d(this.cMX);
                bVar.tG();
            }
        }
    }

    public d la(int i) {
        if (!v.w(this.doz)) {
            for (d dVar : this.doz) {
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
            if (dVar.tabId != 302 && this.doK != null) {
                this.doK.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (lf(dVar.tabId)) {
                if (this.doN != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.dap = dVar.url;
                    this.doN.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.doN != null) {
                    this.doN.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.doN == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.dap = dVar.url;
                    amVar2.stType = dVar.name;
                    this.doN.a(dVar.tabId, 0, amVar2);
                    if (amVar2.daq) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.dox.getChildCount(); i++) {
                    View childAt = this.dox.getChildAt(i);
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
                    amVar3.dap = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.doN != null && z) {
                    this.doN.a(dVar.tabId, 0, amVar3);
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
                if (this.doN != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.dap = tabItemView.getUrl();
                    this.doN.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.doN != null) {
                    this.doN.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.doA = tabItemView;
                int[] iArr = new int[2];
                this.doA.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.dox.getChildCount(); i2++) {
                    View childAt = this.dox.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.doA.getTabId() && !lf(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.doS);
                        }
                    }
                }
                if (this.doA.getState() == TabItemView.doS || this.doA.getState() == TabItemView.STATE_EXPANDED) {
                    this.doy.auM();
                    boolean z2 = this.doA.getState() == TabItemView.doS;
                    this.doA.setState(TabItemView.doT);
                    d lb = lb(this.doA.getTabId());
                    if (lb != null) {
                        if (!TextUtils.isEmpty(lb.url)) {
                            am amVar3 = new am();
                            amVar3.dap = lb.url;
                            amVar3.stType = lb.name;
                            amVar = amVar3;
                        }
                        if (lb.doR != null && lb.doR.daa != null && lb.doR.daa.size() > 0) {
                            for (ar arVar : lb.doR.daa) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.cZW;
                                }
                            }
                        }
                        if (z2 && this.doN != null) {
                            this.doN.a(this.doA.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (lc(this.doA.getTabId()) && !z) {
                    if (this.doO == null || this.doO.li(this.doA.getTabId())) {
                        this.doA.setState(TabItemView.STATE_EXPANDED);
                        this.doy.a((Activity) getContext(), this, this.doA, lb(this.doA.getTabId()).doR);
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
        this.dow = 0;
        this.doA = null;
        this.doB = null;
        this.mPaint = new Paint();
        this.doC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.doD = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.doE = 0;
        this.doF = true;
        this.doG = d.C0126d.transparent;
        this.doI = 0;
        this.doL = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void lg(int i) {
                if (HorizontalTabView.this.doA != null && HorizontalTabView.this.doN != null && HorizontalTabView.this.doN != null) {
                    HorizontalTabView.this.doN.a(HorizontalTabView.this.doA.getTabId(), i, null);
                }
                if (HorizontalTabView.this.doB != null) {
                    HorizontalTabView.this.doB.le(i);
                }
            }
        };
        this.doM = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                d dVar;
                if (HorizontalTabView.this.doH) {
                    if (view2 instanceof TabItemView) {
                        if (((TabItemView) view2).getTabId() == 1) {
                            if (HorizontalTabView.this.doJ != null) {
                                HorizontalTabView.this.doJ.b(HorizontalTabView.this.la(1));
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
                if (HorizontalTabView.this.doB != null) {
                    if (!(view2 instanceof TabItemView) || !HorizontalTabView.lf(((TabItemView) view2).getTabId())) {
                        if (HorizontalTabView.this.doA != null) {
                            HorizontalTabView.this.doB.ld(HorizontalTabView.this.doA.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.doB.ld(((TabItemView) view2).getTabId());
                }
            }
        };
        this.dox = new LinearLayout(context);
        this.dox.setOrientation(0);
        this.dox.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.doy = new e(context, this.doL, this.doM);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.dox, layoutParams);
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
        if (lb.doR == null && dVar.doR == null) {
            return false;
        }
        if ((lb.doR != null || dVar.doR == null) && (dVar.doR != null || lb.doR == null)) {
            if (lb.doR == null || dVar.doR == null) {
                return false;
            }
            if (lb.doR.daa == null && dVar.doR.daa == null) {
                return false;
            }
            if ((lb.doR.daa != null || dVar.doR.daa == null) && (dVar.doR.daa != null || lb.doR.daa == null)) {
                int size = lb.doR.daa.size();
                if (size != dVar.doR.daa.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.doR.daa.get(i);
                    ar arVar2 = lb.doR.daa.get(i);
                    if (arVar.cZW != arVar2.cZW || !arVar.name.equals(arVar2.name)) {
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
        if (this.doH) {
            this.doz = new ArrayList();
            this.doz.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.doR;
                if (asVar2 != null && asVar2.daa != null) {
                    asVar2.daa.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.daa = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.v(list) > 1) {
                    ar arVar = new ar();
                    arVar.cZW = 1;
                    arVar.name = getContext().getString(d.k.chosen_pb_title);
                    asVar.daa.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.cZW = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.daa.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.doR = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.doz = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.doE > 0 && list.size() == this.doE) {
            layoutParams = new LinearLayout.LayoutParams(l.af(getContext()) / this.doE, -1);
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
            this.dox.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.doH);
            if (this.doI != 0) {
                tabItemView.setSelectItemColorResId(this.doI);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.dox.addView(tabItemView, layoutParams);
            this.doA = tabItemView;
            tabItemView.setState(TabItemView.doT);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bq(list)) {
            this.mData = list;
            this.dox.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.doH);
                        if (302 == dVar2.tabId) {
                            ak.c(tabItemView2, d.C0126d.cp_cont_j, 1);
                        }
                        if (this.doI != 0) {
                            tabItemView2.setSelectItemColorResId(this.doI);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (lf(dVar2.tabId)) {
                            ak.h(tabItemView2, d.C0126d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.dox.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.doA = tabItemView2;
                            tabItemView2.setState(TabItemView.doT);
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
        if (i < 0 || this.doz == null || this.doz.size() == 0) {
            return null;
        }
        for (d dVar : this.doz) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean lc(int i) {
        d lb = lb(i);
        return (lb == null || lb.doR == null || lb.doR.daa == null || lb.doR.daa.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.doB = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.doA != null) {
            this.mPaint.setColor(ak.getColor(d.C0126d.cp_bg_line_b));
            if (this.doF) {
                canvas.drawRect(this.dox.getLeft(), getMeasuredHeight() - this.doD, this.dox.getRight() > getRight() ? this.dox.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.doH) {
                if (this.doI == 0) {
                    this.mPaint.setColor(ak.d((Resources) null, d.C0126d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ak.d((Resources) null, this.doI));
                }
                canvas.drawRect(this.doA.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.doC, (this.doA.getRight() - getBottomLineMargin()) - this.doA.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.doH) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ak.d((Resources) null, d.C0126d.cp_cont_b));
            int e = l.e(getContext(), d.e.ds96);
            if (this.doA != null) {
                e = this.doA.getRight() - this.doA.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.e(getContext(), d.e.tbds44), l.e(getContext(), d.e.tbds98), e, l.e(getContext(), d.e.tbds104)), l.e(getContext(), d.e.tbds6), l.e(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.doA == null || this.dow == 0) {
            return 0;
        }
        return ((this.doA.getMeasuredWidth() - this.dow) - this.doA.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void ld(int i) {
        a(la(i));
    }

    public void setDataLoadInterface(ag agVar) {
        this.doN = agVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.doO = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.doO;
    }

    public void setTabBackgroudColor(int i) {
        this.doG = i;
    }

    public void setAutoFillTabCount(int i) {
        this.doE = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void le(int i) {
        if (this.doA != null && this.doN != null) {
            this.doN.a(this.doA.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.doJ = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.doK = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.doH = z;
    }

    public static boolean lf(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.doF = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.doI = i;
    }
}
