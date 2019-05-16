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
    public int fJP;
    private final LinearLayout fJQ;
    private final e fJR;
    private List<d> fJS;
    private TabItemView fJT;
    private com.baidu.tieba.frs.tab.b fJU;
    private final int fJV;
    private final int fJW;
    private int fJX;
    private boolean fJY;
    private int fJZ;
    private boolean fKa;
    private int fKb;
    private a fKc;
    private b fKd;
    private e.b fKe;
    private e.a fKf;
    private af fKg;
    private c fKh;
    private TbPageContext fan;
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
        void st(int i);

        boolean su(int i);
    }

    public void bpB() {
        final as asVar;
        if (this.fan != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).fKk) != null && asVar.fsF != null) {
                for (ar arVar : asVar.fsF) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.fan.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.fsF.size() > i && asVar.fsF.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.sm(asVar.fsF.get(i).fsB));
                        }
                    }
                });
                bVar.d(this.fan);
                bVar.afJ();
            }
        }
    }

    public d sm(int i) {
        if (!v.aa(this.fJS)) {
            for (d dVar : this.fJS) {
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
            if (dVar.tabId != 302 && this.fKd != null) {
                this.fKd.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (sr(dVar.tabId)) {
                if (this.fKg != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.ftb = dVar.url;
                    this.fKg.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.fKg != null) {
                    this.fKg.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.fKg == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.ftb = dVar.url;
                    amVar2.stType = dVar.name;
                    this.fKg.a(dVar.tabId, 0, amVar2);
                    if (amVar2.ftc) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.fJQ.getChildCount(); i++) {
                    View childAt = this.fJQ.getChildAt(i);
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
                    amVar3.ftb = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.fKg != null && z) {
                    this.fKg.a(dVar.tabId, 0, amVar3);
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
            if (sr(tabItemView.getTabId())) {
                if (this.fKg != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.ftb = tabItemView.getUrl();
                    this.fKg.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.fKg != null) {
                    this.fKg.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.fJT = tabItemView;
                int[] iArr = new int[2];
                this.fJT.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.fJQ.getChildCount(); i2++) {
                    View childAt = this.fJQ.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.fJT.getTabId() && !sr(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.fKl);
                        }
                    }
                }
                if (this.fJT.getState() == TabItemView.fKl || this.fJT.getState() == TabItemView.STATE_EXPANDED) {
                    this.fJR.bpE();
                    boolean z2 = this.fJT.getState() == TabItemView.fKl;
                    this.fJT.setState(TabItemView.fKm);
                    d sn = sn(this.fJT.getTabId());
                    if (sn != null) {
                        if (!TextUtils.isEmpty(sn.url)) {
                            am amVar3 = new am();
                            amVar3.ftb = sn.url;
                            amVar3.stType = sn.name;
                            amVar = amVar3;
                        }
                        if (sn.fKk != null && sn.fKk.fsF != null && sn.fKk.fsF.size() > 0) {
                            for (ar arVar : sn.fKk.fsF) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fsB;
                                }
                            }
                        }
                        if (z2 && this.fKg != null) {
                            this.fKg.a(this.fJT.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (so(this.fJT.getTabId()) && !z) {
                    if (this.fKh == null || this.fKh.su(this.fJT.getTabId())) {
                        this.fJT.setState(TabItemView.STATE_EXPANDED);
                        this.fJR.a((Activity) getContext(), this, this.fJT, sn(this.fJT.getTabId()).fKk);
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
        this.fJP = 0;
        this.fJT = null;
        this.fJU = null;
        this.mPaint = new Paint();
        this.fJV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.fJW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.fJX = 0;
        this.fJY = true;
        this.fJZ = R.color.transparent;
        this.fKb = 0;
        this.fKe = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void ss(int i) {
                if (HorizontalTabView.this.fJT != null && HorizontalTabView.this.fKg != null && HorizontalTabView.this.fKg != null) {
                    HorizontalTabView.this.fKg.a(HorizontalTabView.this.fJT.getTabId(), i, null);
                }
                if (HorizontalTabView.this.fJU != null) {
                    HorizontalTabView.this.fJU.sq(i);
                }
            }
        };
        this.fKf = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.fKa) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.fKc != null) {
                                HorizontalTabView.this.fKc.b(HorizontalTabView.this.sm(1));
                            }
                            HorizontalTabView.this.bpB();
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
                if (HorizontalTabView.this.fJU != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.sr(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.fJT != null) {
                            HorizontalTabView.this.fJU.sp(HorizontalTabView.this.fJT.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.fJU.sp(((TabItemView) view).getTabId());
                }
            }
        };
        this.fJQ = new LinearLayout(context);
        this.fJQ.setOrientation(0);
        this.fJQ.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.fJR = new e(context, this.fKe, this.fKf);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.fJQ, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.l(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cl(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d sn = sn(1);
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
        if (sn == null || dVar == null) {
            return false;
        }
        if (sn.fKk == null && dVar.fKk == null) {
            return false;
        }
        if ((sn.fKk != null || dVar.fKk == null) && (dVar.fKk != null || sn.fKk == null)) {
            if (sn.fKk == null || dVar.fKk == null) {
                return false;
            }
            if (sn.fKk.fsF == null && dVar.fKk.fsF == null) {
                return false;
            }
            if ((sn.fKk.fsF != null || dVar.fKk.fsF == null) && (dVar.fKk.fsF != null || sn.fKk.fsF == null)) {
                int size = sn.fKk.fsF.size();
                if (size != dVar.fKk.fsF.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.fKk.fsF.get(i);
                    ar arVar2 = sn.fKk.fsF.get(i);
                    if (arVar.fsB != arVar2.fsB || !arVar.name.equals(arVar2.name)) {
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
        if (this.fKa) {
            this.fJS = new ArrayList();
            this.fJS.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.fKk;
                if (asVar2 != null && asVar2.fsF != null) {
                    asVar2.fsF.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.fsF = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.Z(list) > 1) {
                    ar arVar = new ar();
                    arVar.fsB = 1;
                    arVar.name = getContext().getString(R.string.chosen_pb_title);
                    asVar.fsF.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.fsB = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.fsF.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.fKk = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.fJS = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.fJX > 0 && list.size() == this.fJX) {
            layoutParams = new LinearLayout.LayoutParams(l.af(getContext()) / this.fJX, -1);
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
            this.fJQ.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.fKa);
            if (this.fKb != 0) {
                tabItemView.setSelectItemColorResId(this.fKb);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.fJQ.addView(tabItemView, layoutParams);
            this.fJT = tabItemView;
            tabItemView.setState(TabItemView.fKm);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cl(list)) {
            this.mData = list;
            this.fJQ.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.fKa);
                        if (302 == dVar2.tabId) {
                            al.f(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.fKb != 0) {
                            tabItemView2.setSelectItemColorResId(this.fKb);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (sr(dVar2.tabId)) {
                            al.j(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.fJQ.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.fJT = tabItemView2;
                            tabItemView2.setState(TabItemView.fKm);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d sn(int i) {
        if (i < 0 || this.fJS == null || this.fJS.size() == 0) {
            return null;
        }
        for (d dVar : this.fJS) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean so(int i) {
        d sn = sn(i);
        return (sn == null || sn.fKk == null || sn.fKk.fsF == null || sn.fKk.fsF.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.fJU = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fJT != null) {
            this.mPaint.setColor(al.getColor(R.color.cp_bg_line_b));
            if (this.fJY) {
                canvas.drawRect(this.fJQ.getLeft(), getMeasuredHeight() - this.fJW, this.fJQ.getRight() > getRight() ? this.fJQ.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.fKa) {
                if (this.fKb == 0) {
                    this.mPaint.setColor(al.e((Resources) null, (int) R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.e((Resources) null, this.fKb));
                }
                canvas.drawRect(this.fJT.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.fJV, (this.fJT.getRight() - getBottomLineMargin()) - this.fJT.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.fKa) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.e((Resources) null, (int) R.color.cp_cont_b));
            int g = l.g(getContext(), R.dimen.ds96);
            if (this.fJT != null) {
                g = this.fJT.getRight() - this.fJT.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.g(getContext(), R.dimen.tbds44), l.g(getContext(), R.dimen.tbds98), g, l.g(getContext(), R.dimen.tbds104)), l.g(getContext(), R.dimen.tbds6), l.g(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.fJT == null || this.fJP == 0) {
            return 0;
        }
        return ((this.fJT.getMeasuredWidth() - this.fJP) - this.fJT.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sp(int i) {
        a(sm(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.fKg = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.fKh = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.fKh;
    }

    public void setTabBackgroudColor(int i) {
        this.fJZ = i;
    }

    public void setAutoFillTabCount(int i) {
        this.fJX = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sq(int i) {
        if (this.fJT != null && this.fKg != null) {
            this.fKg.a(this.fJT.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fKc = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.fKd = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.fKa = z;
    }

    public static boolean sr(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.fJY = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.fKb = i;
    }
}
