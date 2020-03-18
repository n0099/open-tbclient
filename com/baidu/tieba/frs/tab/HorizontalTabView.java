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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    public int gKQ;
    private final LinearLayout gKR;
    private final e gKS;
    private List<d> gKT;
    private TabItemView gKU;
    private com.baidu.tieba.frs.tab.b gKV;
    private final int gKW;
    private final int gKX;
    private int gKY;
    private boolean gKZ;
    private int gLa;
    private boolean gLb;
    private int gLc;
    private a gLd;
    private b gLe;
    private e.b gLf;
    private e.a gLg;
    private ah gLh;
    private c gLi;
    private TbPageContext geg;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes9.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes9.dex */
    public interface c {
        void uh(int i);

        boolean ui(int i);
    }

    public void bJZ() {
        final au auVar;
        if (this.geg != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).gLl) != null && auVar.gsS != null) {
                for (at atVar : auVar.gsS) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.geg.getPageActivity());
                bVar.a(arrayList, new b.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.a
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.gsS.size() > i && auVar.gsS.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.ua(auVar.gsS.get(i).gsO));
                        }
                    }
                });
                bVar.d(this.geg);
                bVar.aEH();
            }
        }
    }

    public d ua(int i) {
        if (!v.isEmpty(this.gKT)) {
            for (d dVar : this.gKT) {
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
            if (dVar.tabId != 302 && this.gLe != null) {
                this.gLe.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (uf(dVar.tabId)) {
                if (this.gLh != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.ext = dVar.url;
                    this.gLh.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.gLh != null) {
                    this.gLh.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.gLh == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.ext = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.gLh.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.gti) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.gKR.getChildCount(); i++) {
                    View childAt = this.gKR.getChildAt(i);
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
                    aoVar3.ext = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.gLh != null && z) {
                    this.gLh.a(dVar.tabId, 0, aoVar3);
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
            if (uf(tabItemView.getTabId())) {
                if (this.gLh != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.ext = tabItemView.getUrl();
                    this.gLh.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.gLh != null) {
                    this.gLh.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.gKU = tabItemView;
                int[] iArr = new int[2];
                this.gKU.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.gKR.getChildCount(); i2++) {
                    View childAt = this.gKR.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.gKU.getTabId() && !uf(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.gLm);
                        }
                    }
                }
                if (this.gKU.getState() == TabItemView.gLm || this.gKU.getState() == TabItemView.STATE_EXPANDED) {
                    this.gKS.dismissMenu();
                    boolean z2 = this.gKU.getState() == TabItemView.gLm;
                    this.gKU.setState(TabItemView.gLn);
                    d ub = ub(this.gKU.getTabId());
                    if (ub != null) {
                        if (!TextUtils.isEmpty(ub.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.ext = ub.url;
                            aoVar3.stType = ub.name;
                            aoVar = aoVar3;
                        }
                        if (ub.gLl != null && ub.gLl.gsS != null && ub.gLl.gsS.size() > 0) {
                            for (at atVar : ub.gLl.gsS) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.gsO;
                                }
                            }
                        }
                        if (z2 && this.gLh != null) {
                            this.gLh.a(this.gKU.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (uc(this.gKU.getTabId()) && !z) {
                    if (this.gLi == null || this.gLi.ui(this.gKU.getTabId())) {
                        this.gKU.setState(TabItemView.STATE_EXPANDED);
                        this.gKS.a((Activity) getContext(), this, this.gKU, ub(this.gKU.getTabId()).gLl);
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
        this.gKQ = 0;
        this.gKU = null;
        this.gKV = null;
        this.mPaint = new Paint();
        this.gKW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.gKX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.gKY = 0;
        this.gKZ = true;
        this.gLa = R.color.transparent;
        this.gLc = 0;
        this.gLf = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void ug(int i) {
                if (HorizontalTabView.this.gKU != null && HorizontalTabView.this.gLh != null && HorizontalTabView.this.gLh != null) {
                    HorizontalTabView.this.gLh.a(HorizontalTabView.this.gKU.getTabId(), i, null);
                }
                if (HorizontalTabView.this.gKV != null) {
                    HorizontalTabView.this.gKV.ue(i);
                }
            }
        };
        this.gLg = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.gLb) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.gLd != null) {
                                HorizontalTabView.this.gLd.b(HorizontalTabView.this.ua(1));
                            }
                            HorizontalTabView.this.bJZ();
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
                if (HorizontalTabView.this.gKV != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.uf(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.gKU != null) {
                            HorizontalTabView.this.gKV.ud(HorizontalTabView.this.gKU.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.gKV.ud(((TabItemView) view).getTabId());
                }
            }
        };
        this.gKR = new LinearLayout(context);
        this.gKR.setOrientation(0);
        this.gKR.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.gKS = new e(context, this.gLf, this.gLg);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.gKR, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        am.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cq(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d ub = ub(1);
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
        if (ub == null || dVar == null) {
            return false;
        }
        if (ub.gLl == null && dVar.gLl == null) {
            return false;
        }
        if ((ub.gLl != null || dVar.gLl == null) && (dVar.gLl != null || ub.gLl == null)) {
            if (ub.gLl == null || dVar.gLl == null) {
                return false;
            }
            if (ub.gLl.gsS == null && dVar.gLl.gsS == null) {
                return false;
            }
            if ((ub.gLl.gsS != null || dVar.gLl.gsS == null) && (dVar.gLl.gsS != null || ub.gLl.gsS == null)) {
                int size = ub.gLl.gsS.size();
                if (size != dVar.gLl.gsS.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.gLl.gsS.get(i);
                    at atVar2 = ub.gLl.gsS.get(i);
                    if (atVar.gsO != atVar2.gsO || !atVar.name.equals(atVar2.name)) {
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
        if (this.gLb) {
            this.gKT = new ArrayList();
            this.gKT.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.gLl;
                if (auVar2 != null && auVar2.gsS != null) {
                    auVar2.gsS.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.gsS = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (v.getCount(list) > 1) {
                    at atVar = new at();
                    atVar.gsO = 1;
                    atVar.name = getContext().getString(R.string.chosen_pb_title);
                    auVar.gsS.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.gsO = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.gsS.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.gLl = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.gKT = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.gKY > 0 && list.size() == this.gKY) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.gKY, -1);
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
            this.gKR.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.gLb);
            if (this.gLc != 0) {
                tabItemView.setSelectItemColorResId(this.gLc);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.gKR.addView(tabItemView, layoutParams);
            this.gKU = tabItemView;
            tabItemView.setState(TabItemView.gLn);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cq(list)) {
            this.mData = list;
            this.gKR.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.gLb);
                        if (302 == dVar2.tabId) {
                            am.setViewTextColor(tabItemView2, R.color.cp_cont_j, 1);
                        }
                        if (this.gLc != 0) {
                            tabItemView2.setSelectItemColorResId(this.gLc);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (uf(dVar2.tabId)) {
                            am.setViewTextColor(tabItemView2, (int) R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.gKR.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.gKU = tabItemView2;
                            tabItemView2.setState(TabItemView.gLn);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d ub(int i) {
        if (i < 0 || this.gKT == null || this.gKT.size() == 0) {
            return null;
        }
        for (d dVar : this.gKT) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean uc(int i) {
        d ub = ub(i);
        return (ub == null || ub.gLl == null || ub.gLl.gsS == null || ub.gLl.gsS.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.gKV = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.gKU != null) {
            this.mPaint.setColor(am.getColor(R.color.cp_bg_line_c));
            if (this.gKZ) {
                canvas.drawRect(this.gKR.getLeft(), getMeasuredHeight() - this.gKX, this.gKR.getRight() > getRight() ? this.gKR.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.gLb) {
                if (this.gLc == 0) {
                    this.mPaint.setColor(am.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.getSkinColor(null, this.gLc));
                }
                canvas.drawRect(this.gKU.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.gKW, (this.gKU.getRight() - getBottomLineMargin()) - this.gKU.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.gLb) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.gKU != null) {
                dimens = this.gKU.getRight() - this.gKU.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.gKU == null || this.gKQ == 0) {
            return 0;
        }
        return ((this.gKU.getMeasuredWidth() - this.gKQ) - this.gKU.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void ud(int i) {
        a(ua(i));
    }

    public void setDataLoadInterface(ah ahVar) {
        this.gLh = ahVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.gLi = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.gLi;
    }

    public void setTabBackgroudColor(int i) {
        this.gLa = i;
    }

    public void setAutoFillTabCount(int i) {
        this.gKY = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void ue(int i) {
        if (this.gKU != null && this.gLh != null) {
            this.gLh.a(this.gKU.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.gLd = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.gLe = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.gLb = z;
    }

    public static boolean uf(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.gKZ = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.gLc = i;
    }
}
