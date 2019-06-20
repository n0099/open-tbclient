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
    public int fJS;
    private final LinearLayout fJT;
    private final e fJU;
    private List<d> fJV;
    private TabItemView fJW;
    private com.baidu.tieba.frs.tab.b fJX;
    private final int fJY;
    private final int fJZ;
    private int fKa;
    private boolean fKb;
    private int fKc;
    private boolean fKd;
    private int fKe;
    private a fKf;
    private b fKg;
    private e.b fKh;
    private e.a fKi;
    private af fKj;
    private c fKk;
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

    public void bpG() {
        final as asVar;
        if (this.fao != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).fKn) != null && asVar.fsG != null) {
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
        if (!v.aa(this.fJV)) {
            for (d dVar : this.fJV) {
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
            if (dVar.tabId != 302 && this.fKg != null) {
                this.fKg.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (sr(dVar.tabId)) {
                if (this.fKj != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.ftc = dVar.url;
                    this.fKj.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.fKj != null) {
                    this.fKj.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.fKj == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.ftc = dVar.url;
                    amVar2.stType = dVar.name;
                    this.fKj.a(dVar.tabId, 0, amVar2);
                    if (amVar2.ftd) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.fJT.getChildCount(); i++) {
                    View childAt = this.fJT.getChildAt(i);
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
                if (this.fKj != null && z) {
                    this.fKj.a(dVar.tabId, 0, amVar3);
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
                if (this.fKj != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.ftc = tabItemView.getUrl();
                    this.fKj.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.fKj != null) {
                    this.fKj.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.fJW = tabItemView;
                int[] iArr = new int[2];
                this.fJW.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.fJT.getChildCount(); i2++) {
                    View childAt = this.fJT.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.fJW.getTabId() && !sr(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.fKo);
                        }
                    }
                }
                if (this.fJW.getState() == TabItemView.fKo || this.fJW.getState() == TabItemView.STATE_EXPANDED) {
                    this.fJU.bpJ();
                    boolean z2 = this.fJW.getState() == TabItemView.fKo;
                    this.fJW.setState(TabItemView.fKp);
                    d sn = sn(this.fJW.getTabId());
                    if (sn != null) {
                        if (!TextUtils.isEmpty(sn.url)) {
                            am amVar3 = new am();
                            amVar3.ftc = sn.url;
                            amVar3.stType = sn.name;
                            amVar = amVar3;
                        }
                        if (sn.fKn != null && sn.fKn.fsG != null && sn.fKn.fsG.size() > 0) {
                            for (ar arVar : sn.fKn.fsG) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fsC;
                                }
                            }
                        }
                        if (z2 && this.fKj != null) {
                            this.fKj.a(this.fJW.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (so(this.fJW.getTabId()) && !z) {
                    if (this.fKk == null || this.fKk.su(this.fJW.getTabId())) {
                        this.fJW.setState(TabItemView.STATE_EXPANDED);
                        this.fJU.a((Activity) getContext(), this, this.fJW, sn(this.fJW.getTabId()).fKn);
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
        this.fJS = 0;
        this.fJW = null;
        this.fJX = null;
        this.mPaint = new Paint();
        this.fJY = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.fJZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.fKa = 0;
        this.fKb = true;
        this.fKc = R.color.transparent;
        this.fKe = 0;
        this.fKh = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void ss(int i) {
                if (HorizontalTabView.this.fJW != null && HorizontalTabView.this.fKj != null && HorizontalTabView.this.fKj != null) {
                    HorizontalTabView.this.fKj.a(HorizontalTabView.this.fJW.getTabId(), i, null);
                }
                if (HorizontalTabView.this.fJX != null) {
                    HorizontalTabView.this.fJX.sq(i);
                }
            }
        };
        this.fKi = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.fKd) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.fKf != null) {
                                HorizontalTabView.this.fKf.b(HorizontalTabView.this.sm(1));
                            }
                            HorizontalTabView.this.bpG();
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
                if (HorizontalTabView.this.fJX != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.sr(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.fJW != null) {
                            HorizontalTabView.this.fJX.sp(HorizontalTabView.this.fJW.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.fJX.sp(((TabItemView) view).getTabId());
                }
            }
        };
        this.fJT = new LinearLayout(context);
        this.fJT.setOrientation(0);
        this.fJT.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.fJU = new e(context, this.fKh, this.fKi);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.fJT, layoutParams);
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
        if (sn.fKn == null && dVar.fKn == null) {
            return false;
        }
        if ((sn.fKn != null || dVar.fKn == null) && (dVar.fKn != null || sn.fKn == null)) {
            if (sn.fKn == null || dVar.fKn == null) {
                return false;
            }
            if (sn.fKn.fsG == null && dVar.fKn.fsG == null) {
                return false;
            }
            if ((sn.fKn.fsG != null || dVar.fKn.fsG == null) && (dVar.fKn.fsG != null || sn.fKn.fsG == null)) {
                int size = sn.fKn.fsG.size();
                if (size != dVar.fKn.fsG.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.fKn.fsG.get(i);
                    ar arVar2 = sn.fKn.fsG.get(i);
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
        if (this.fKd) {
            this.fJV = new ArrayList();
            this.fJV.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.fKn;
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
                    dVar.fKn = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.fJV = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.fKa > 0 && list.size() == this.fKa) {
            layoutParams = new LinearLayout.LayoutParams(l.af(getContext()) / this.fKa, -1);
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
            this.fJT.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.fKd);
            if (this.fKe != 0) {
                tabItemView.setSelectItemColorResId(this.fKe);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.fJT.addView(tabItemView, layoutParams);
            this.fJW = tabItemView;
            tabItemView.setState(TabItemView.fKp);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cl(list)) {
            this.mData = list;
            this.fJT.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.fKd);
                        if (302 == dVar2.tabId) {
                            al.f(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.fKe != 0) {
                            tabItemView2.setSelectItemColorResId(this.fKe);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (sr(dVar2.tabId)) {
                            al.j(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.fJT.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.fJW = tabItemView2;
                            tabItemView2.setState(TabItemView.fKp);
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
        if (i < 0 || this.fJV == null || this.fJV.size() == 0) {
            return null;
        }
        for (d dVar : this.fJV) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean so(int i) {
        d sn = sn(i);
        return (sn == null || sn.fKn == null || sn.fKn.fsG == null || sn.fKn.fsG.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.fJX = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fJW != null) {
            this.mPaint.setColor(al.getColor(R.color.cp_bg_line_b));
            if (this.fKb) {
                canvas.drawRect(this.fJT.getLeft(), getMeasuredHeight() - this.fJZ, this.fJT.getRight() > getRight() ? this.fJT.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.fKd) {
                if (this.fKe == 0) {
                    this.mPaint.setColor(al.e((Resources) null, (int) R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.e((Resources) null, this.fKe));
                }
                canvas.drawRect(this.fJW.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.fJY, (this.fJW.getRight() - getBottomLineMargin()) - this.fJW.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.fKd) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.e((Resources) null, (int) R.color.cp_cont_b));
            int g = l.g(getContext(), R.dimen.ds96);
            if (this.fJW != null) {
                g = this.fJW.getRight() - this.fJW.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.g(getContext(), R.dimen.tbds44), l.g(getContext(), R.dimen.tbds98), g, l.g(getContext(), R.dimen.tbds104)), l.g(getContext(), R.dimen.tbds6), l.g(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.fJW == null || this.fJS == 0) {
            return 0;
        }
        return ((this.fJW.getMeasuredWidth() - this.fJS) - this.fJW.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sp(int i) {
        a(sm(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.fKj = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.fKk = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.fKk;
    }

    public void setTabBackgroudColor(int i) {
        this.fKc = i;
    }

    public void setAutoFillTabCount(int i) {
        this.fKa = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void sq(int i) {
        if (this.fJW != null && this.fKj != null) {
            this.fKj.a(this.fJW.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fKf = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.fKg = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.fKd = z;
    }

    public static boolean sr(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.fKb = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.fKe = i;
    }
}
