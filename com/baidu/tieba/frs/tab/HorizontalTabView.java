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
    public int fJQ;
    private final LinearLayout fJR;
    private final e fJS;
    private List<d> fJT;
    private TabItemView fJU;
    private com.baidu.tieba.frs.tab.b fJV;
    private final int fJW;
    private final int fJX;
    private int fJY;
    private boolean fJZ;
    private int fKa;
    private boolean fKb;
    private int fKc;
    private a fKd;
    private b fKe;
    private e.b fKf;
    private e.a fKg;
    private af fKh;
    private c fKi;
    private TbPageContext fao;
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

    public void bpE() {
        final as asVar;
        if (this.fao != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).fKl) != null && asVar.fsG != null) {
                for (ar arVar : asVar.fsG) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.fao.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.fsG.size() > i && asVar.fsG.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.sm(asVar.fsG.get(i).fsC));
                        }
                    }
                });
                bVar.d(this.fao);
                bVar.afJ();
            }
        }
    }

    public d sm(int i) {
        if (!v.aa(this.fJT)) {
            for (d dVar : this.fJT) {
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
            if (dVar.tabId != 302 && this.fKe != null) {
                this.fKe.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (sr(dVar.tabId)) {
                if (this.fKh != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.ftc = dVar.url;
                    this.fKh.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.fKh != null) {
                    this.fKh.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.fKh == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.ftc = dVar.url;
                    amVar2.stType = dVar.name;
                    this.fKh.a(dVar.tabId, 0, amVar2);
                    if (amVar2.ftd) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.fJR.getChildCount(); i++) {
                    View childAt = this.fJR.getChildAt(i);
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
                    amVar3.ftc = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.fKh != null && z) {
                    this.fKh.a(dVar.tabId, 0, amVar3);
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
                if (this.fKh != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.ftc = tabItemView.getUrl();
                    this.fKh.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.fKh != null) {
                    this.fKh.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.fJU = tabItemView;
                int[] iArr = new int[2];
                this.fJU.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.fJR.getChildCount(); i2++) {
                    View childAt = this.fJR.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.fJU.getTabId() && !sr(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.fKm);
                        }
                    }
                }
                if (this.fJU.getState() == TabItemView.fKm || this.fJU.getState() == TabItemView.STATE_EXPANDED) {
                    this.fJS.bpH();
                    boolean z2 = this.fJU.getState() == TabItemView.fKm;
                    this.fJU.setState(TabItemView.fKn);
                    d sn = sn(this.fJU.getTabId());
                    if (sn != null) {
                        if (!TextUtils.isEmpty(sn.url)) {
                            am amVar3 = new am();
                            amVar3.ftc = sn.url;
                            amVar3.stType = sn.name;
                            amVar = amVar3;
                        }
                        if (sn.fKl != null && sn.fKl.fsG != null && sn.fKl.fsG.size() > 0) {
                            for (ar arVar : sn.fKl.fsG) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fsC;
                                }
                            }
                        }
                        if (z2 && this.fKh != null) {
                            this.fKh.a(this.fJU.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (so(this.fJU.getTabId()) && !z) {
                    if (this.fKi == null || this.fKi.su(this.fJU.getTabId())) {
                        this.fJU.setState(TabItemView.STATE_EXPANDED);
                        this.fJS.a((Activity) getContext(), this, this.fJU, sn(this.fJU.getTabId()).fKl);
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
        this.fJQ = 0;
        this.fJU = null;
        this.fJV = null;
        this.mPaint = new Paint();
        this.fJW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.fJX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.fJY = 0;
        this.fJZ = true;
        this.fKa = R.color.transparent;
        this.fKc = 0;
        this.fKf = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void ss(int i) {
                if (HorizontalTabView.this.fJU != null && HorizontalTabView.this.fKh != null && HorizontalTabView.this.fKh != null) {
                    HorizontalTabView.this.fKh.a(HorizontalTabView.this.fJU.getTabId(), i, null);
                }
                if (HorizontalTabView.this.fJV != null) {
                    HorizontalTabView.this.fJV.sq(i);
                }
            }
        };
        this.fKg = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.fKb) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.fKd != null) {
                                HorizontalTabView.this.fKd.b(HorizontalTabView.this.sm(1));
                            }
                            HorizontalTabView.this.bpE();
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
                if (HorizontalTabView.this.fJV != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.sr(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.fJU != null) {
                            HorizontalTabView.this.fJV.sp(HorizontalTabView.this.fJU.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.fJV.sp(((TabItemView) view).getTabId());
                }
            }
        };
        this.fJR = new LinearLayout(context);
        this.fJR.setOrientation(0);
        this.fJR.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.fJS = new e(context, this.fKf, this.fKg);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.fJR, layoutParams);
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
        if (sn.fKl == null && dVar.fKl == null) {
            return false;
        }
        if ((sn.fKl != null || dVar.fKl == null) && (dVar.fKl != null || sn.fKl == null)) {
            if (sn.fKl == null || dVar.fKl == null) {
                return false;
            }
            if (sn.fKl.fsG == null && dVar.fKl.fsG == null) {
                return false;
            }
            if ((sn.fKl.fsG != null || dVar.fKl.fsG == null) && (dVar.fKl.fsG != null || sn.fKl.fsG == null)) {
                int size = sn.fKl.fsG.size();
                if (size != dVar.fKl.fsG.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.fKl.fsG.get(i);
                    ar arVar2 = sn.fKl.fsG.get(i);
                    if (arVar.fsC != arVar2.fsC || !arVar.name.equals(arVar2.name)) {
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
        if (this.fKb) {
            this.fJT = new ArrayList();
            this.fJT.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.fKl;
                if (asVar2 != null && asVar2.fsG != null) {
                    asVar2.fsG.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.fsG = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.Z(list) > 1) {
                    ar arVar = new ar();
                    arVar.fsC = 1;
                    arVar.name = getContext().getString(R.string.chosen_pb_title);
                    asVar.fsG.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.fsC = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.fsG.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.fKl = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.fJT = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.fJY > 0 && list.size() == this.fJY) {
            layoutParams = new LinearLayout.LayoutParams(l.af(getContext()) / this.fJY, -1);
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
            this.fJR.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.fKb);
            if (this.fKc != 0) {
                tabItemView.setSelectItemColorResId(this.fKc);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.fJR.addView(tabItemView, layoutParams);
            this.fJU = tabItemView;
            tabItemView.setState(TabItemView.fKn);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cl(list)) {
            this.mData = list;
            this.fJR.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.fKb);
                        if (302 == dVar2.tabId) {
                            al.f(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.fKc != 0) {
                            tabItemView2.setSelectItemColorResId(this.fKc);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (sr(dVar2.tabId)) {
                            al.j(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.fJR.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.fJU = tabItemView2;
                            tabItemView2.setState(TabItemView.fKn);
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
        if (i < 0 || this.fJT == null || this.fJT.size() == 0) {
            return null;
        }
        for (d dVar : this.fJT) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean so(int i) {
        d sn = sn(i);
        return (sn == null || sn.fKl == null || sn.fKl.fsG == null || sn.fKl.fsG.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.fJV = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fJU != null) {
            this.mPaint.setColor(al.getColor(R.color.cp_bg_line_b));
            if (this.fJZ) {
                canvas.drawRect(this.fJR.getLeft(), getMeasuredHeight() - this.fJX, this.fJR.getRight() > getRight() ? this.fJR.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.fKb) {
                if (this.fKc == 0) {
                    this.mPaint.setColor(al.e((Resources) null, (int) R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.e((Resources) null, this.fKc));
                }
                canvas.drawRect(this.fJU.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.fJW, (this.fJU.getRight() - getBottomLineMargin()) - this.fJU.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.fKb) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.e((Resources) null, (int) R.color.cp_cont_b));
            int g = l.g(getContext(), R.dimen.ds96);
            if (this.fJU != null) {
                g = this.fJU.getRight() - this.fJU.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.g(getContext(), R.dimen.tbds44), l.g(getContext(), R.dimen.tbds98), g, l.g(getContext(), R.dimen.tbds104)), l.g(getContext(), R.dimen.tbds6), l.g(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.fJU == null || this.fJQ == 0) {
            return 0;
        }
        return ((this.fJU.getMeasuredWidth() - this.fJQ) - this.fJU.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sp(int i) {
        a(sm(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.fKh = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.fKi = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.fKi;
    }

    public void setTabBackgroudColor(int i) {
        this.fKa = i;
    }

    public void setAutoFillTabCount(int i) {
        this.fJY = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sq(int i) {
        if (this.fJU != null && this.fKh != null) {
            this.fKh.a(this.fJU.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fKd = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.fKe = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.fKb = z;
    }

    public static boolean sr(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.fJZ = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.fKc = i;
    }
}
