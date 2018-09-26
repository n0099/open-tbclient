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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    public int dLU;
    private final LinearLayout dLV;
    private final e dLW;
    private List<d> dLX;
    private TabItemView dLY;
    private com.baidu.tieba.frs.tab.b dLZ;
    private final int dMa;
    private final int dMb;
    private int dMc;
    private boolean dMd;
    private int dMe;
    private boolean dMf;
    private int dMg;
    private a dMh;
    private b dMi;
    private e.b dMj;
    private e.a dMk;
    private ai dMl;
    private c dMm;
    private TbPageContext ddS;
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
        void mh(int i);

        boolean mi(int i);
    }

    public void aCl() {
        final au auVar;
        if (this.ddS != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).dMp) != null && auVar.dvD != null) {
                for (at atVar : auVar.dvD) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.ddS.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0100b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.dvD.size() > i && auVar.dvD.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.ma(auVar.dvD.get(i).dvz));
                        }
                    }
                });
                bVar.d(this.ddS);
                bVar.yo();
            }
        }
    }

    public d ma(int i) {
        if (!v.z(this.dLX)) {
            for (d dVar : this.dLX) {
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
            if (dVar.tabId != 302 && this.dMi != null) {
                this.dMi.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (mf(dVar.tabId)) {
                if (this.dMl != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dvZ = dVar.url;
                    this.dMl.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.dMl != null) {
                    this.dMl.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.dMl == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dvZ = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.dMl.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dwa) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.dLV.getChildCount(); i++) {
                    View childAt = this.dLV.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                ao aoVar3 = null;
                if (!TextUtils.isEmpty(dVar.url)) {
                    aoVar3 = new ao();
                    aoVar3.dvZ = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.dMl != null && z) {
                    this.dMl.a(dVar.tabId, 0, aoVar3);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ao aoVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (mf(tabItemView.getTabId())) {
                if (this.dMl != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dvZ = tabItemView.getUrl();
                    this.dMl.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.dMl != null) {
                    this.dMl.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.dLY = tabItemView;
                int[] iArr = new int[2];
                this.dLY.getLocationOnScreen(iArr);
                int aO = l.aO(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.C0141e.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (aO < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(e.C0141e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.dLV.getChildCount(); i2++) {
                    View childAt = this.dLV.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.dLY.getTabId() && !mf(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.dMq);
                        }
                    }
                }
                if (this.dLY.getState() == TabItemView.dMq || this.dLY.getState() == TabItemView.STATE_EXPANDED) {
                    this.dLW.aCo();
                    boolean z2 = this.dLY.getState() == TabItemView.dMq;
                    this.dLY.setState(TabItemView.dMr);
                    d mb = mb(this.dLY.getTabId());
                    if (mb != null) {
                        if (!TextUtils.isEmpty(mb.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dvZ = mb.url;
                            aoVar3.stType = mb.name;
                            aoVar = aoVar3;
                        }
                        if (mb.dMp != null && mb.dMp.dvD != null && mb.dMp.dvD.size() > 0) {
                            for (at atVar : mb.dMp.dvD) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dvz;
                                }
                            }
                        }
                        if (z2 && this.dMl != null) {
                            this.dMl.a(this.dLY.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (mc(this.dLY.getTabId()) && !z) {
                    if (this.dMm == null || this.dMm.mi(this.dLY.getTabId())) {
                        this.dLY.setState(TabItemView.STATE_EXPANDED);
                        this.dLW.a((Activity) getContext(), this, this.dLY, mb(this.dLY.getTabId()).dMp);
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
        this.dLU = 0;
        this.dLY = null;
        this.dLZ = null;
        this.mPaint = new Paint();
        this.dMa = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds6);
        this.dMb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.ds1);
        this.dMc = 0;
        this.dMd = true;
        this.dMe = e.d.transparent;
        this.dMg = 0;
        this.dMj = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void mg(int i) {
                if (HorizontalTabView.this.dLY != null && HorizontalTabView.this.dMl != null && HorizontalTabView.this.dMl != null) {
                    HorizontalTabView.this.dMl.a(HorizontalTabView.this.dLY.getTabId(), i, null);
                }
                if (HorizontalTabView.this.dLZ != null) {
                    HorizontalTabView.this.dLZ.me(i);
                }
            }
        };
        this.dMk = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.dMf) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.dMh != null) {
                                HorizontalTabView.this.dMh.b(HorizontalTabView.this.ma(1));
                            }
                            HorizontalTabView.this.aCl();
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
                if (HorizontalTabView.this.dLZ != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.mf(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.dLY != null) {
                            HorizontalTabView.this.dLZ.md(HorizontalTabView.this.dLY.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.dLZ.md(((TabItemView) view).getTabId());
                }
            }
        };
        this.dLV = new LinearLayout(context);
        this.dLV.setOrientation(0);
        this.dLV.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(e.C0141e.ds88));
        this.dLW = new e(context, this.dMj, this.dMk);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.dLV, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.j(this, e.d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bA(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d mb = mb(1);
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
        if (mb == null || dVar == null) {
            return false;
        }
        if (mb.dMp == null && dVar.dMp == null) {
            return false;
        }
        if ((mb.dMp != null || dVar.dMp == null) && (dVar.dMp != null || mb.dMp == null)) {
            if (mb.dMp == null || dVar.dMp == null) {
                return false;
            }
            if (mb.dMp.dvD == null && dVar.dMp.dvD == null) {
                return false;
            }
            if ((mb.dMp.dvD != null || dVar.dMp.dvD == null) && (dVar.dMp.dvD != null || mb.dMp.dvD == null)) {
                int size = mb.dMp.dvD.size();
                if (size != dVar.dMp.dvD.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.dMp.dvD.get(i);
                    at atVar2 = mb.dMp.dvD.get(i);
                    if (atVar.dvz != atVar2.dvz || !atVar.name.equals(atVar2.name)) {
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
        au auVar;
        if (this.dMf) {
            this.dLX = new ArrayList();
            this.dLX.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.dMp;
                if (auVar2 != null && auVar2.dvD != null) {
                    auVar2.dvD.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.dvD = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.y(list) > 1) {
                    at atVar = new at();
                    atVar.dvz = 1;
                    atVar.name = getContext().getString(e.j.chosen_pb_title);
                    auVar.dvD.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.dvz = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.dvD.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.dMp = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.dLX = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.dMc > 0 && list.size() == this.dMc) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.dMc, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(e.C0141e.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.tabId = 1;
            dVar.name = getContext().getResources().getString(e.j.chosen_pb_title);
            this.dLV.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.dMf);
            if (this.dMg != 0) {
                tabItemView.setSelectItemColorResId(this.dMg);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0141e.ds32);
            this.dLV.addView(tabItemView, layoutParams);
            this.dLY = tabItemView;
            tabItemView.setState(TabItemView.dMr);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bA(list)) {
            this.mData = list;
            this.dLV.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.dMf);
                        if (302 == dVar2.tabId) {
                            al.c(tabItemView2, e.d.cp_cont_j, 1);
                        }
                        if (this.dMg != 0) {
                            tabItemView2.setSelectItemColorResId(this.dMg);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (mf(dVar2.tabId)) {
                            al.h(tabItemView2, e.d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(e.C0141e.tbds44);
                        }
                        this.dLV.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.dLY = tabItemView2;
                            tabItemView2.setState(TabItemView.dMr);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d mb(int i) {
        if (i < 0 || this.dLX == null || this.dLX.size() == 0) {
            return null;
        }
        for (d dVar : this.dLX) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean mc(int i) {
        d mb = mb(i);
        return (mb == null || mb.dMp == null || mb.dMp.dvD == null || mb.dMp.dvD.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.dLZ = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dLY != null) {
            this.mPaint.setColor(al.getColor(e.d.cp_bg_line_b));
            if (this.dMd) {
                canvas.drawRect(this.dLV.getLeft(), getMeasuredHeight() - this.dMb, this.dLV.getRight() > getRight() ? this.dLV.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.dMf) {
                if (this.dMg == 0) {
                    this.mPaint.setColor(al.d((Resources) null, e.d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.dMg));
                }
                canvas.drawRect(this.dLY.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.dMa, (this.dLY.getRight() - getBottomLineMargin()) - this.dLY.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.dMf) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, e.d.cp_cont_b));
            int h = l.h(getContext(), e.C0141e.ds96);
            if (this.dLY != null) {
                h = this.dLY.getRight() - this.dLY.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), e.C0141e.tbds44), l.h(getContext(), e.C0141e.tbds98), h, l.h(getContext(), e.C0141e.tbds104)), l.h(getContext(), e.C0141e.tbds6), l.h(getContext(), e.C0141e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.dLY == null || this.dLU == 0) {
            return 0;
        }
        return ((this.dLY.getMeasuredWidth() - this.dLU) - this.dLY.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void md(int i) {
        a(ma(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.dMl = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.dMm = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.dMm;
    }

    public void setTabBackgroudColor(int i) {
        this.dMe = i;
    }

    public void setAutoFillTabCount(int i) {
        this.dMc = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void me(int i) {
        if (this.dLY != null && this.dMl != null) {
            this.dMl.a(this.dLY.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dMh = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.dMi = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.dMf = z;
    }

    public static boolean mf(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.dMd = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.dMg = i;
    }
}
