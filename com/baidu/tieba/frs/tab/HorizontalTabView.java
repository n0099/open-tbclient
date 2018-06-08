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
import com.baidu.tbadk.core.util.w;
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
    private TbPageContext cXj;
    public int dyQ;
    private final LinearLayout dyR;
    private final e dyS;
    private List<d> dyT;
    private TabItemView dyU;
    private com.baidu.tieba.frs.tab.b dyV;
    private final int dyW;
    private final int dyX;
    private int dyY;
    private boolean dyZ;
    private int dza;
    private boolean dzb;
    private int dzc;
    private a dzd;
    private b dze;
    private e.b dzf;
    private e.a dzg;
    private ag dzh;
    private c dzi;
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
        void ln(int i);

        boolean lo(int i);
    }

    public void ayS() {
        final as asVar;
        if (this.cXj != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).dzl) != null && asVar.dkz != null) {
                for (ar arVar : asVar.dkz) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cXj.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0103b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.dkz.size() > i && asVar.dkz.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.lg(asVar.dkz.get(i).dkv));
                        }
                    }
                });
                bVar.d(this.cXj);
                bVar.xd();
            }
        }
    }

    public d lg(int i) {
        if (!w.z(this.dyT)) {
            for (d dVar : this.dyT) {
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
            if (dVar.tabId != 302 && this.dze != null) {
                this.dze.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (ll(dVar.tabId)) {
                if (this.dzh != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.dkO = dVar.url;
                    this.dzh.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.dzh != null) {
                    this.dzh.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.dzh == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.dkO = dVar.url;
                    amVar2.stType = dVar.name;
                    this.dzh.a(dVar.tabId, 0, amVar2);
                    if (amVar2.dkP) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.dyR.getChildCount(); i++) {
                    View childAt = this.dyR.getChildAt(i);
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
                    amVar3.dkO = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.dzh != null && z) {
                    this.dzh.a(dVar.tabId, 0, amVar3);
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
            if (ll(tabItemView.getTabId())) {
                if (this.dzh != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.dkO = tabItemView.getUrl();
                    this.dzh.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.dzh != null) {
                    this.dzh.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.dyU = tabItemView;
                int[] iArr = new int[2];
                this.dyU.getLocationOnScreen(iArr);
                int ah = l.ah(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds160);
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
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.dyR.getChildCount(); i2++) {
                    View childAt = this.dyR.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.dyU.getTabId() && !ll(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.dzm);
                        }
                    }
                }
                if (this.dyU.getState() == TabItemView.dzm || this.dyU.getState() == TabItemView.STATE_EXPANDED) {
                    this.dyS.ayV();
                    boolean z2 = this.dyU.getState() == TabItemView.dzm;
                    this.dyU.setState(TabItemView.dzn);
                    d lh = lh(this.dyU.getTabId());
                    if (lh != null) {
                        if (!TextUtils.isEmpty(lh.url)) {
                            am amVar3 = new am();
                            amVar3.dkO = lh.url;
                            amVar3.stType = lh.name;
                            amVar = amVar3;
                        }
                        if (lh.dzl != null && lh.dzl.dkz != null && lh.dzl.dkz.size() > 0) {
                            for (ar arVar : lh.dzl.dkz) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.dkv;
                                }
                            }
                        }
                        if (z2 && this.dzh != null) {
                            this.dzh.a(this.dyU.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (li(this.dyU.getTabId()) && !z) {
                    if (this.dzi == null || this.dzi.lo(this.dyU.getTabId())) {
                        this.dyU.setState(TabItemView.STATE_EXPANDED);
                        this.dyS.a((Activity) getContext(), this, this.dyU, lh(this.dyU.getTabId()).dzl);
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
        this.dyQ = 0;
        this.dyU = null;
        this.dyV = null;
        this.mPaint = new Paint();
        this.dyW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.dyX = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.dyY = 0;
        this.dyZ = true;
        this.dza = d.C0141d.transparent;
        this.dzc = 0;
        this.dzf = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void lm(int i) {
                if (HorizontalTabView.this.dyU != null && HorizontalTabView.this.dzh != null && HorizontalTabView.this.dzh != null) {
                    HorizontalTabView.this.dzh.a(HorizontalTabView.this.dyU.getTabId(), i, null);
                }
                if (HorizontalTabView.this.dyV != null) {
                    HorizontalTabView.this.dyV.lk(i);
                }
            }
        };
        this.dzg = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.dzb) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.dzd != null) {
                                HorizontalTabView.this.dzd.b(HorizontalTabView.this.lg(1));
                            }
                            HorizontalTabView.this.ayS();
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
                if (HorizontalTabView.this.dyV != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.ll(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.dyU != null) {
                            HorizontalTabView.this.dyV.lj(HorizontalTabView.this.dyU.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.dyV.lj(((TabItemView) view).getTabId());
                }
            }
        };
        this.dyR = new LinearLayout(context);
        this.dyR.setOrientation(0);
        this.dyR.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.dyS = new e(context, this.dzf, this.dzg);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.dyR, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.j(this, d.C0141d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bw(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d lh = lh(1);
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
        if (lh == null || dVar == null) {
            return false;
        }
        if (lh.dzl == null && dVar.dzl == null) {
            return false;
        }
        if ((lh.dzl != null || dVar.dzl == null) && (dVar.dzl != null || lh.dzl == null)) {
            if (lh.dzl == null || dVar.dzl == null) {
                return false;
            }
            if (lh.dzl.dkz == null && dVar.dzl.dkz == null) {
                return false;
            }
            if ((lh.dzl.dkz != null || dVar.dzl.dkz == null) && (dVar.dzl.dkz != null || lh.dzl.dkz == null)) {
                int size = lh.dzl.dkz.size();
                if (size != dVar.dzl.dkz.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.dzl.dkz.get(i);
                    ar arVar2 = lh.dzl.dkz.get(i);
                    if (arVar.dkv != arVar2.dkv || !arVar.name.equals(arVar2.name)) {
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
        if (this.dzb) {
            this.dyT = new ArrayList();
            this.dyT.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.dzl;
                if (asVar2 != null && asVar2.dkz != null) {
                    asVar2.dkz.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.dkz = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (w.y(list) > 1) {
                    ar arVar = new ar();
                    arVar.dkv = 1;
                    arVar.name = getContext().getString(d.k.chosen_pb_title);
                    asVar.dkz.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.dkv = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.dkz.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.dzl = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.dyT = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.dyY > 0 && list.size() == this.dyY) {
            layoutParams = new LinearLayout.LayoutParams(l.ah(getContext()) / this.dyY, -1);
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
            this.dyR.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.dzb);
            if (this.dzc != 0) {
                tabItemView.setSelectItemColorResId(this.dzc);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.dyR.addView(tabItemView, layoutParams);
            this.dyU = tabItemView;
            tabItemView.setState(TabItemView.dzn);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bw(list)) {
            this.mData = list;
            this.dyR.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.dzb);
                        if (302 == dVar2.tabId) {
                            al.c(tabItemView2, d.C0141d.cp_cont_j, 1);
                        }
                        if (this.dzc != 0) {
                            tabItemView2.setSelectItemColorResId(this.dzc);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (ll(dVar2.tabId)) {
                            al.h(tabItemView2, d.C0141d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.dyR.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.dyU = tabItemView2;
                            tabItemView2.setState(TabItemView.dzn);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d lh(int i) {
        if (i < 0 || this.dyT == null || this.dyT.size() == 0) {
            return null;
        }
        for (d dVar : this.dyT) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean li(int i) {
        d lh = lh(i);
        return (lh == null || lh.dzl == null || lh.dzl.dkz == null || lh.dzl.dkz.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.dyV = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dyU != null) {
            this.mPaint.setColor(al.getColor(d.C0141d.cp_bg_line_b));
            if (this.dyZ) {
                canvas.drawRect(this.dyR.getLeft(), getMeasuredHeight() - this.dyX, this.dyR.getRight() > getRight() ? this.dyR.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.dzb) {
                if (this.dzc == 0) {
                    this.mPaint.setColor(al.d((Resources) null, d.C0141d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.dzc));
                }
                canvas.drawRect(this.dyU.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.dyW, (this.dyU.getRight() - getBottomLineMargin()) - this.dyU.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.dzb) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, d.C0141d.cp_cont_b));
            int e = l.e(getContext(), d.e.ds96);
            if (this.dyU != null) {
                e = this.dyU.getRight() - this.dyU.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.e(getContext(), d.e.tbds44), l.e(getContext(), d.e.tbds98), e, l.e(getContext(), d.e.tbds104)), l.e(getContext(), d.e.tbds6), l.e(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.dyU == null || this.dyQ == 0) {
            return 0;
        }
        return ((this.dyU.getMeasuredWidth() - this.dyQ) - this.dyU.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void lj(int i) {
        a(lg(i));
    }

    public void setDataLoadInterface(ag agVar) {
        this.dzh = agVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.dzi = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.dzi;
    }

    public void setTabBackgroudColor(int i) {
        this.dza = i;
    }

    public void setAutoFillTabCount(int i) {
        this.dyY = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void lk(int i) {
        if (this.dyU != null && this.dzh != null) {
            this.dzh.a(this.dyU.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dzd = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.dze = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.dzb = z;
    }

    public static boolean ll(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.dyZ = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.dzc = i;
    }
}
