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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes16.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext huq;
    public int icX;
    private final LinearLayout icY;
    private final e icZ;
    private List<d> ida;
    private TabItemView idb;
    private com.baidu.tieba.frs.tab.b idc;
    private final int idd;
    private final int ide;
    private int idf;
    private boolean idg;
    private int idh;
    private boolean idi;
    private int idj;
    private a idk;
    private b idm;
    private e.b idn;
    private e.a ido;
    private ap idp;
    private c idq;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes16.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes16.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes16.dex */
    public interface c {
        void wj(int i);

        boolean wk(int i);
    }

    public void chS() {
        final be beVar;
        if (this.huq != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (beVar = this.mData.get(0).idv) != null && beVar.hJT != null) {
                for (bd bdVar : beVar.hJT) {
                    if (bdVar != null) {
                        arrayList.add(bdVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.huq.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0492b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (beVar.hJT.size() > i && beVar.hJT.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.wc(beVar.hJT.get(i).hJP));
                        }
                    }
                });
                bVar.d(this.huq);
                bVar.aYN();
            }
        }
    }

    public d wc(int i) {
        if (!x.isEmpty(this.ida)) {
            for (d dVar : this.ida) {
                if (dVar != null && dVar.tabId == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void a(d dVar) {
        boolean z;
        ay ayVar;
        if (dVar != null) {
            if (this.idm != null) {
                this.idm.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (wh(dVar.tabId)) {
                if (this.idp != null && !TextUtils.isEmpty(dVar.url)) {
                    ay ayVar2 = new ay();
                    ayVar2.ext = dVar.url;
                    this.idp.a(dVar.tabId, -1, ayVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.idp != null) {
                    this.idp.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.idp == null) {
                    z = true;
                } else {
                    ay ayVar3 = new ay();
                    ayVar3.ext = dVar.url;
                    ayVar3.stType = dVar.name;
                    this.idp.a(dVar.tabId, 0, ayVar3);
                    if (ayVar3.hKn) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.icY.getChildCount(); i++) {
                    View childAt = this.icY.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(dVar.url)) {
                    ayVar = null;
                } else {
                    ayVar = new ay();
                    ayVar.ext = dVar.url;
                    ayVar.stType = dVar.name;
                }
                if (this.idp != null && z) {
                    this.idp.a(dVar.tabId, 0, ayVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ay ayVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (wh(tabItemView.getTabId())) {
                if (this.idp != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ay ayVar2 = new ay();
                    ayVar2.ext = tabItemView.getUrl();
                    this.idp.a(tabItemView.getTabId(), -1, ayVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.idp != null) {
                    this.idp.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.idb = tabItemView;
                int[] iArr = new int[2];
                this.idb.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.icY.getChildCount(); i2++) {
                    View childAt = this.icY.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.idb.getTabId() && !wh(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.idw);
                        }
                    }
                }
                if (this.idb.getState() == TabItemView.idw || this.idb.getState() == TabItemView.STATE_EXPANDED) {
                    this.icZ.dismissMenu();
                    boolean z2 = this.idb.getState() == TabItemView.idw;
                    this.idb.setState(TabItemView.idy);
                    d wd = wd(this.idb.getTabId());
                    if (wd != null) {
                        if (!TextUtils.isEmpty(wd.url)) {
                            ay ayVar3 = new ay();
                            ayVar3.ext = wd.url;
                            ayVar3.stType = wd.name;
                            ayVar = ayVar3;
                        }
                        if (wd.idv != null && wd.idv.hJT != null && wd.idv.hJT.size() > 0) {
                            for (bd bdVar : wd.idv.hJT) {
                                if (bdVar != null && bdVar.isSelected) {
                                    i = bdVar.hJP;
                                }
                            }
                        }
                        if (z2 && this.idp != null) {
                            this.idp.a(this.idb.getTabId(), i, ayVar);
                        }
                    } else {
                        return;
                    }
                } else if (we(this.idb.getTabId()) && !z) {
                    if (this.idq == null || this.idq.wk(this.idb.getTabId())) {
                        this.idb.setState(TabItemView.STATE_EXPANDED);
                        this.icZ.a((Activity) getContext(), this, this.idb, wd(this.idb.getTabId()).idv);
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
        this.icX = 0;
        this.idb = null;
        this.idc = null;
        this.mPaint = new Paint();
        this.idd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.ide = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.idf = 0;
        this.idg = true;
        this.idh = R.color.transparent;
        this.idj = 0;
        this.idn = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void wi(int i) {
                if (HorizontalTabView.this.idb != null && HorizontalTabView.this.idp != null && HorizontalTabView.this.idp != null) {
                    HorizontalTabView.this.idp.a(HorizontalTabView.this.idb.getTabId(), i, null);
                }
                if (HorizontalTabView.this.idc != null) {
                    HorizontalTabView.this.idc.wg(i);
                }
            }
        };
        this.ido = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.idi) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.idk != null) {
                            HorizontalTabView.this.idk.b(HorizontalTabView.this.wc(1));
                        }
                        HorizontalTabView.this.chS();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.idc != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.wh(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.idb != null) {
                            HorizontalTabView.this.idc.wf(HorizontalTabView.this.idb.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.idc.wf(((TabItemView) view).getTabId());
                }
            }
        };
        this.icY = new LinearLayout(context);
        this.icY.setOrientation(0);
        this.icY.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.icZ = new e(context, this.idn, this.ido);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.icY, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ao.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cP(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d wd = wd(1);
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
        if (wd == null || dVar == null) {
            return false;
        }
        if (wd.idv == null && dVar.idv == null) {
            return false;
        }
        if ((wd.idv != null || dVar.idv == null) && (dVar.idv != null || wd.idv == null)) {
            if (wd.idv == null || dVar.idv == null) {
                return false;
            }
            if (wd.idv.hJT == null && dVar.idv.hJT == null) {
                return false;
            }
            if ((wd.idv.hJT != null || dVar.idv.hJT == null) && (dVar.idv.hJT != null || wd.idv.hJT == null)) {
                int size = wd.idv.hJT.size();
                if (size != dVar.idv.hJT.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bd bdVar = dVar.idv.hJT.get(i);
                    bd bdVar2 = wd.idv.hJT.get(i);
                    if (bdVar.hJP != bdVar2.hJP || !bdVar.name.equals(bdVar2.name)) {
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
        be beVar;
        if (this.idi) {
            this.ida = new ArrayList();
            this.ida.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                be beVar2 = dVar.idv;
                if (beVar2 != null && beVar2.hJT != null) {
                    beVar2.hJT.clear();
                    beVar = beVar2;
                } else {
                    be beVar3 = new be();
                    beVar3.hJT = new ArrayList();
                    beVar = beVar3;
                }
                if (x.getCount(list) > 1) {
                    bd bdVar = new bd();
                    bdVar.hJP = 1;
                    bdVar.name = getContext().getString(R.string.chosen_pb_title);
                    beVar.hJT.add(bdVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bd bdVar2 = new bd();
                            bdVar2.hJP = dVar2.tabId;
                            bdVar2.name = dVar2.name;
                            beVar.hJT.add(bdVar2);
                        }
                    }
                    dVar.idv = beVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.ida = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.idf > 0 && list.size() == this.idf) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.idf, -1);
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
            this.icY.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.idi);
            if (this.idj != 0) {
                tabItemView.setSelectItemColorResId(this.idj);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.icY.addView(tabItemView, layoutParams);
            this.idb = tabItemView;
            tabItemView.setState(TabItemView.idy);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cP(list)) {
            this.mData = list;
            this.icY.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.idi);
                        if (this.idj != 0) {
                            tabItemView2.setSelectItemColorResId(this.idj);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (wh(dVar2.tabId)) {
                            ao.setViewTextColor(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.icY.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.idb = tabItemView2;
                            tabItemView2.setState(TabItemView.idy);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d wd(int i) {
        if (i < 0 || this.ida == null || this.ida.size() == 0) {
            return null;
        }
        for (d dVar : this.ida) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean we(int i) {
        d wd = wd(i);
        return (wd == null || wd.idv == null || wd.idv.hJT == null || wd.idv.hJT.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.idc = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.idb != null) {
            this.mPaint.setColor(ao.getColor(R.color.cp_bg_line_c));
            if (this.idg) {
                canvas.drawRect(this.icY.getLeft(), getMeasuredHeight() - this.ide, this.icY.getRight() > getRight() ? this.icY.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.idi) {
                if (this.idj == 0) {
                    this.mPaint.setColor(ao.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ao.getSkinColor(null, this.idj));
                }
                canvas.drawRect(this.idb.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.idd, (this.idb.getRight() - getBottomLineMargin()) - this.idb.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.idi) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ao.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.idb != null) {
                dimens = this.idb.getRight() - this.idb.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.idb == null || this.icX == 0) {
            return 0;
        }
        return ((this.idb.getMeasuredWidth() - this.icX) - this.idb.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void wf(int i) {
        a(wc(i));
    }

    public void setDataLoadInterface(ap apVar) {
        this.idp = apVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.idq = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.idq;
    }

    public void setTabBackgroudColor(int i) {
        this.idh = i;
    }

    public void setAutoFillTabCount(int i) {
        this.idf = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void wg(int i) {
        if (this.idb != null && this.idp != null) {
            this.idp.a(this.idb.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.idk = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.idm = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.idi = z;
    }

    public static boolean wh(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.idg = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.idj = i;
    }
}
