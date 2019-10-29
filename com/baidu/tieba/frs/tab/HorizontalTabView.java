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
    public int fQO;
    private final LinearLayout fQP;
    private final e fQQ;
    private List<d> fQR;
    private TabItemView fQS;
    private com.baidu.tieba.frs.tab.b fQT;
    private final int fQU;
    private final int fQV;
    private int fQW;
    private boolean fQX;
    private int fQY;
    private boolean fQZ;
    private int fRa;
    private a fRb;
    private b fRc;
    private e.b fRd;
    private e.a fRe;
    private af fRf;
    private c fRg;
    private TbPageContext fkq;
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
        void rL(int i);

        boolean rM(int i);
    }

    public void bpL() {
        final as asVar;
        if (this.fkq != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).fRj) != null && asVar.fzd != null) {
                for (ar arVar : asVar.fzd) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.fkq.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.fzd.size() > i && asVar.fzd.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.rE(asVar.fzd.get(i).fyZ));
                        }
                    }
                });
                bVar.d(this.fkq);
                bVar.akP();
            }
        }
    }

    public d rE(int i) {
        if (!v.isEmpty(this.fQR)) {
            for (d dVar : this.fQR) {
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
            if (dVar.tabId != 302 && this.fRc != null) {
                this.fRc.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (rJ(dVar.tabId)) {
                if (this.fRf != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.ext = dVar.url;
                    this.fRf.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.fRf != null) {
                    this.fRf.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.fRf == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.ext = dVar.url;
                    amVar2.stType = dVar.name;
                    this.fRf.a(dVar.tabId, 0, amVar2);
                    if (amVar2.fzz) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.fQP.getChildCount(); i++) {
                    View childAt = this.fQP.getChildAt(i);
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
                    amVar3.ext = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.fRf != null && z) {
                    this.fRf.a(dVar.tabId, 0, amVar3);
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
            if (rJ(tabItemView.getTabId())) {
                if (this.fRf != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.ext = tabItemView.getUrl();
                    this.fRf.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.fRf != null) {
                    this.fRf.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.fQS = tabItemView;
                int[] iArr = new int[2];
                this.fQS.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.fQP.getChildCount(); i2++) {
                    View childAt = this.fQP.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.fQS.getTabId() && !rJ(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.fRk);
                        }
                    }
                }
                if (this.fQS.getState() == TabItemView.fRk || this.fQS.getState() == TabItemView.STATE_EXPANDED) {
                    this.fQQ.bpO();
                    boolean z2 = this.fQS.getState() == TabItemView.fRk;
                    this.fQS.setState(TabItemView.fRl);
                    d rF = rF(this.fQS.getTabId());
                    if (rF != null) {
                        if (!TextUtils.isEmpty(rF.url)) {
                            am amVar3 = new am();
                            amVar3.ext = rF.url;
                            amVar3.stType = rF.name;
                            amVar = amVar3;
                        }
                        if (rF.fRj != null && rF.fRj.fzd != null && rF.fRj.fzd.size() > 0) {
                            for (ar arVar : rF.fRj.fzd) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fyZ;
                                }
                            }
                        }
                        if (z2 && this.fRf != null) {
                            this.fRf.a(this.fQS.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (rG(this.fQS.getTabId()) && !z) {
                    if (this.fRg == null || this.fRg.rM(this.fQS.getTabId())) {
                        this.fQS.setState(TabItemView.STATE_EXPANDED);
                        this.fQQ.a((Activity) getContext(), this, this.fQS, rF(this.fQS.getTabId()).fRj);
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
        this.fQO = 0;
        this.fQS = null;
        this.fQT = null;
        this.mPaint = new Paint();
        this.fQU = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.fQV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.fQW = 0;
        this.fQX = true;
        this.fQY = R.color.transparent;
        this.fRa = 0;
        this.fRd = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void rK(int i) {
                if (HorizontalTabView.this.fQS != null && HorizontalTabView.this.fRf != null && HorizontalTabView.this.fRf != null) {
                    HorizontalTabView.this.fRf.a(HorizontalTabView.this.fQS.getTabId(), i, null);
                }
                if (HorizontalTabView.this.fQT != null) {
                    HorizontalTabView.this.fQT.rI(i);
                }
            }
        };
        this.fRe = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.fQZ) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.fRb != null) {
                                HorizontalTabView.this.fRb.b(HorizontalTabView.this.rE(1));
                            }
                            HorizontalTabView.this.bpL();
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
                if (HorizontalTabView.this.fQT != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.rJ(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.fQS != null) {
                            HorizontalTabView.this.fQT.rH(HorizontalTabView.this.fQS.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.fQT.rH(((TabItemView) view).getTabId());
                }
            }
        };
        this.fQP = new LinearLayout(context);
        this.fQP.setOrientation(0);
        this.fQP.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.fQQ = new e(context, this.fRd, this.fRe);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.fQP, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        com.baidu.tbadk.core.util.am.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cy(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d rF = rF(1);
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
        if (rF == null || dVar == null) {
            return false;
        }
        if (rF.fRj == null && dVar.fRj == null) {
            return false;
        }
        if ((rF.fRj != null || dVar.fRj == null) && (dVar.fRj != null || rF.fRj == null)) {
            if (rF.fRj == null || dVar.fRj == null) {
                return false;
            }
            if (rF.fRj.fzd == null && dVar.fRj.fzd == null) {
                return false;
            }
            if ((rF.fRj.fzd != null || dVar.fRj.fzd == null) && (dVar.fRj.fzd != null || rF.fRj.fzd == null)) {
                int size = rF.fRj.fzd.size();
                if (size != dVar.fRj.fzd.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.fRj.fzd.get(i);
                    ar arVar2 = rF.fRj.fzd.get(i);
                    if (arVar.fyZ != arVar2.fyZ || !arVar.name.equals(arVar2.name)) {
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
        if (this.fQZ) {
            this.fQR = new ArrayList();
            this.fQR.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.fRj;
                if (asVar2 != null && asVar2.fzd != null) {
                    asVar2.fzd.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.fzd = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    ar arVar = new ar();
                    arVar.fyZ = 1;
                    arVar.name = getContext().getString(R.string.chosen_pb_title);
                    asVar.fzd.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.fyZ = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.fzd.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.fRj = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.fQR = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.fQW > 0 && list.size() == this.fQW) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.fQW, -1);
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
            this.fQP.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.fQZ);
            if (this.fRa != 0) {
                tabItemView.setSelectItemColorResId(this.fRa);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.fQP.addView(tabItemView, layoutParams);
            this.fQS = tabItemView;
            tabItemView.setState(TabItemView.fRl);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cy(list)) {
            this.mData = list;
            this.fQP.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.fQZ);
                        if (302 == dVar2.tabId) {
                            com.baidu.tbadk.core.util.am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.fRa != 0) {
                            tabItemView2.setSelectItemColorResId(this.fRa);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (rJ(dVar2.tabId)) {
                            com.baidu.tbadk.core.util.am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.fQP.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.fQS = tabItemView2;
                            tabItemView2.setState(TabItemView.fRl);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d rF(int i) {
        if (i < 0 || this.fQR == null || this.fQR.size() == 0) {
            return null;
        }
        for (d dVar : this.fQR) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean rG(int i) {
        d rF = rF(i);
        return (rF == null || rF.fRj == null || rF.fRj.fzd == null || rF.fRj.fzd.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.fQT = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fQS != null) {
            this.mPaint.setColor(com.baidu.tbadk.core.util.am.getColor(R.color.cp_bg_line_c));
            if (this.fQX) {
                canvas.drawRect(this.fQP.getLeft(), getMeasuredHeight() - this.fQV, this.fQP.getRight() > getRight() ? this.fQP.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.fQZ) {
                if (this.fRa == 0) {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(com.baidu.tbadk.core.util.am.getSkinColor(null, this.fRa));
                }
                canvas.drawRect(this.fQS.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.fQU, (this.fQS.getRight() - getBottomLineMargin()) - this.fQS.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.fQZ) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(com.baidu.tbadk.core.util.am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.fQS != null) {
                dimens = this.fQS.getRight() - this.fQS.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.fQS == null || this.fQO == 0) {
            return 0;
        }
        return ((this.fQS.getMeasuredWidth() - this.fQO) - this.fQS.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void rH(int i) {
        a(rE(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.fRf = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.fRg = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.fRg;
    }

    public void setTabBackgroudColor(int i) {
        this.fQY = i;
    }

    public void setAutoFillTabCount(int i) {
        this.fQW = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void rI(int i) {
        if (this.fQS != null && this.fRf != null) {
            this.fRf.a(this.fQS.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.fRb = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.fRc = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.fQZ = z;
    }

    public static boolean rJ(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.fQX = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.fRa = i;
    }
}
