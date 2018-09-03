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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.f;
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
    private TbPageContext cXW;
    public int dEM;
    private final LinearLayout dEN;
    private final e dEO;
    private List<d> dEP;
    private TabItemView dEQ;
    private com.baidu.tieba.frs.tab.b dER;
    private final int dES;
    private final int dET;
    private int dEU;
    private boolean dEV;
    private int dEW;
    private boolean dEX;
    private int dEY;
    private a dEZ;
    private b dFa;
    private e.b dFb;
    private e.a dFc;
    private ai dFd;
    private c dFe;
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
        void lF(int i);

        boolean lG(int i);
    }

    public void aAc() {
        final au auVar;
        if (this.cXW != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).dFh) != null && auVar.dpw != null) {
                for (at atVar : auVar.dpw) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cXW.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0101b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.dpw.size() > i && auVar.dpw.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.ly(auVar.dpw.get(i).dps));
                        }
                    }
                });
                bVar.d(this.cXW);
                bVar.xh();
            }
        }
    }

    public d ly(int i) {
        if (!w.z(this.dEP)) {
            for (d dVar : this.dEP) {
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
            if (dVar.tabId != 302 && this.dFa != null) {
                this.dFa.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (lD(dVar.tabId)) {
                if (this.dFd != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dpL = dVar.url;
                    this.dFd.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.dFd != null) {
                    this.dFd.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.dFd == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dpL = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.dFd.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dpM) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.dEN.getChildCount(); i++) {
                    View childAt = this.dEN.getChildAt(i);
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
                    aoVar3.dpL = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.dFd != null && z) {
                    this.dFd.a(dVar.tabId, 0, aoVar3);
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
            if (lD(tabItemView.getTabId())) {
                if (this.dFd != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dpL = tabItemView.getUrl();
                    this.dFd.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.dFd != null) {
                    this.dFd.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.dEQ = tabItemView;
                int[] iArr = new int[2];
                this.dEQ.getLocationOnScreen(iArr);
                int ah = l.ah(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(f.e.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (ah < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(f.e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.dEN.getChildCount(); i2++) {
                    View childAt = this.dEN.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.dEQ.getTabId() && !lD(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.dFi);
                        }
                    }
                }
                if (this.dEQ.getState() == TabItemView.dFi || this.dEQ.getState() == TabItemView.STATE_EXPANDED) {
                    this.dEO.aAf();
                    boolean z2 = this.dEQ.getState() == TabItemView.dFi;
                    this.dEQ.setState(TabItemView.dFj);
                    d lz = lz(this.dEQ.getTabId());
                    if (lz != null) {
                        if (!TextUtils.isEmpty(lz.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dpL = lz.url;
                            aoVar3.stType = lz.name;
                            aoVar = aoVar3;
                        }
                        if (lz.dFh != null && lz.dFh.dpw != null && lz.dFh.dpw.size() > 0) {
                            for (at atVar : lz.dFh.dpw) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dps;
                                }
                            }
                        }
                        if (z2 && this.dFd != null) {
                            this.dFd.a(this.dEQ.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (lA(this.dEQ.getTabId()) && !z) {
                    if (this.dFe == null || this.dFe.lG(this.dEQ.getTabId())) {
                        this.dEQ.setState(TabItemView.STATE_EXPANDED);
                        this.dEO.a((Activity) getContext(), this, this.dEQ, lz(this.dEQ.getTabId()).dFh);
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
        this.dEM = 0;
        this.dEQ = null;
        this.dER = null;
        this.mPaint = new Paint();
        this.dES = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds6);
        this.dET = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds1);
        this.dEU = 0;
        this.dEV = true;
        this.dEW = f.d.transparent;
        this.dEY = 0;
        this.dFb = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void lE(int i) {
                if (HorizontalTabView.this.dEQ != null && HorizontalTabView.this.dFd != null && HorizontalTabView.this.dFd != null) {
                    HorizontalTabView.this.dFd.a(HorizontalTabView.this.dEQ.getTabId(), i, null);
                }
                if (HorizontalTabView.this.dER != null) {
                    HorizontalTabView.this.dER.lC(i);
                }
            }
        };
        this.dFc = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.dEX) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.dEZ != null) {
                                HorizontalTabView.this.dEZ.b(HorizontalTabView.this.ly(1));
                            }
                            HorizontalTabView.this.aAc();
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
                if (HorizontalTabView.this.dER != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.lD(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.dEQ != null) {
                            HorizontalTabView.this.dER.lB(HorizontalTabView.this.dEQ.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.dER.lB(((TabItemView) view).getTabId());
                }
            }
        };
        this.dEN = new LinearLayout(context);
        this.dEN.setOrientation(0);
        this.dEN.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(f.e.ds88));
        this.dEO = new e(context, this.dFb, this.dFc);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.dEN, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        am.j(this, f.d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bz(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d lz = lz(1);
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
        if (lz == null || dVar == null) {
            return false;
        }
        if (lz.dFh == null && dVar.dFh == null) {
            return false;
        }
        if ((lz.dFh != null || dVar.dFh == null) && (dVar.dFh != null || lz.dFh == null)) {
            if (lz.dFh == null || dVar.dFh == null) {
                return false;
            }
            if (lz.dFh.dpw == null && dVar.dFh.dpw == null) {
                return false;
            }
            if ((lz.dFh.dpw != null || dVar.dFh.dpw == null) && (dVar.dFh.dpw != null || lz.dFh.dpw == null)) {
                int size = lz.dFh.dpw.size();
                if (size != dVar.dFh.dpw.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.dFh.dpw.get(i);
                    at atVar2 = lz.dFh.dpw.get(i);
                    if (atVar.dps != atVar2.dps || !atVar.name.equals(atVar2.name)) {
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
        if (this.dEX) {
            this.dEP = new ArrayList();
            this.dEP.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.dFh;
                if (auVar2 != null && auVar2.dpw != null) {
                    auVar2.dpw.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.dpw = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (w.y(list) > 1) {
                    at atVar = new at();
                    atVar.dps = 1;
                    atVar.name = getContext().getString(f.j.chosen_pb_title);
                    auVar.dpw.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.dps = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.dpw.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.dFh = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.dEP = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.dEU > 0 && list.size() == this.dEU) {
            layoutParams = new LinearLayout.LayoutParams(l.ah(getContext()) / this.dEU, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(f.e.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.mData = null;
            d dVar = new d();
            dVar.tabId = 1;
            dVar.name = getContext().getResources().getString(f.j.chosen_pb_title);
            this.dEN.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.dEX);
            if (this.dEY != 0) {
                tabItemView.setSelectItemColorResId(this.dEY);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(f.e.ds32);
            this.dEN.addView(tabItemView, layoutParams);
            this.dEQ = tabItemView;
            tabItemView.setState(TabItemView.dFj);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bz(list)) {
            this.mData = list;
            this.dEN.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.dEX);
                        if (302 == dVar2.tabId) {
                            am.c(tabItemView2, f.d.cp_cont_j, 1);
                        }
                        if (this.dEY != 0) {
                            tabItemView2.setSelectItemColorResId(this.dEY);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (lD(dVar2.tabId)) {
                            am.h(tabItemView2, f.d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(f.e.tbds44);
                        }
                        this.dEN.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.dEQ = tabItemView2;
                            tabItemView2.setState(TabItemView.dFj);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d lz(int i) {
        if (i < 0 || this.dEP == null || this.dEP.size() == 0) {
            return null;
        }
        for (d dVar : this.dEP) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean lA(int i) {
        d lz = lz(i);
        return (lz == null || lz.dFh == null || lz.dFh.dpw == null || lz.dFh.dpw.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.dER = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dEQ != null) {
            this.mPaint.setColor(am.getColor(f.d.cp_bg_line_b));
            if (this.dEV) {
                canvas.drawRect(this.dEN.getLeft(), getMeasuredHeight() - this.dET, this.dEN.getRight() > getRight() ? this.dEN.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.dEX) {
                if (this.dEY == 0) {
                    this.mPaint.setColor(am.d((Resources) null, f.d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.d((Resources) null, this.dEY));
                }
                canvas.drawRect(this.dEQ.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.dES, (this.dEQ.getRight() - getBottomLineMargin()) - this.dEQ.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.dEX) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.d((Resources) null, f.d.cp_cont_b));
            int f = l.f(getContext(), f.e.ds96);
            if (this.dEQ != null) {
                f = this.dEQ.getRight() - this.dEQ.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.f(getContext(), f.e.tbds44), l.f(getContext(), f.e.tbds98), f, l.f(getContext(), f.e.tbds104)), l.f(getContext(), f.e.tbds6), l.f(getContext(), f.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.dEQ == null || this.dEM == 0) {
            return 0;
        }
        return ((this.dEQ.getMeasuredWidth() - this.dEM) - this.dEQ.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void lB(int i) {
        a(ly(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.dFd = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.dFe = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.dFe;
    }

    public void setTabBackgroudColor(int i) {
        this.dEW = i;
    }

    public void setAutoFillTabCount(int i) {
        this.dEU = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void lC(int i) {
        if (this.dEQ != null && this.dFd != null) {
            this.dFd.a(this.dEQ.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dEZ = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.dFa = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.dEX = z;
    }

    public static boolean lD(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.dEV = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.dEY = i;
    }
}
