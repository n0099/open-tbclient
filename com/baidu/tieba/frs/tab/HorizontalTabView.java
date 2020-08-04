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
    public int icZ;
    private final LinearLayout ida;
    private final e idb;
    private List<d> idc;
    private TabItemView idd;
    private com.baidu.tieba.frs.tab.b ide;
    private final int idf;
    private final int idg;
    private int idh;
    private boolean idi;
    private int idj;
    private boolean idk;
    private int idm;
    private a idn;
    private b ido;
    private e.b idp;
    private e.a idq;
    private ap idr;
    private c idu;
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
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (beVar = this.mData.get(0).idy) != null && beVar.hJT != null) {
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
        if (!x.isEmpty(this.idc)) {
            for (d dVar : this.idc) {
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
            if (this.ido != null) {
                this.ido.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (wh(dVar.tabId)) {
                if (this.idr != null && !TextUtils.isEmpty(dVar.url)) {
                    ay ayVar2 = new ay();
                    ayVar2.ext = dVar.url;
                    this.idr.a(dVar.tabId, -1, ayVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.idr != null) {
                    this.idr.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.idr == null) {
                    z = true;
                } else {
                    ay ayVar3 = new ay();
                    ayVar3.ext = dVar.url;
                    ayVar3.stType = dVar.name;
                    this.idr.a(dVar.tabId, 0, ayVar3);
                    if (ayVar3.hKn) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.ida.getChildCount(); i++) {
                    View childAt = this.ida.getChildAt(i);
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
                if (this.idr != null && z) {
                    this.idr.a(dVar.tabId, 0, ayVar);
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
                if (this.idr != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ay ayVar2 = new ay();
                    ayVar2.ext = tabItemView.getUrl();
                    this.idr.a(tabItemView.getTabId(), -1, ayVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.idr != null) {
                    this.idr.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.idd = tabItemView;
                int[] iArr = new int[2];
                this.idd.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.ida.getChildCount(); i2++) {
                    View childAt = this.ida.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.idd.getTabId() && !wh(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.idz);
                        }
                    }
                }
                if (this.idd.getState() == TabItemView.idz || this.idd.getState() == TabItemView.STATE_EXPANDED) {
                    this.idb.dismissMenu();
                    boolean z2 = this.idd.getState() == TabItemView.idz;
                    this.idd.setState(TabItemView.idA);
                    d wd = wd(this.idd.getTabId());
                    if (wd != null) {
                        if (!TextUtils.isEmpty(wd.url)) {
                            ay ayVar3 = new ay();
                            ayVar3.ext = wd.url;
                            ayVar3.stType = wd.name;
                            ayVar = ayVar3;
                        }
                        if (wd.idy != null && wd.idy.hJT != null && wd.idy.hJT.size() > 0) {
                            for (bd bdVar : wd.idy.hJT) {
                                if (bdVar != null && bdVar.isSelected) {
                                    i = bdVar.hJP;
                                }
                            }
                        }
                        if (z2 && this.idr != null) {
                            this.idr.a(this.idd.getTabId(), i, ayVar);
                        }
                    } else {
                        return;
                    }
                } else if (we(this.idd.getTabId()) && !z) {
                    if (this.idu == null || this.idu.wk(this.idd.getTabId())) {
                        this.idd.setState(TabItemView.STATE_EXPANDED);
                        this.idb.a((Activity) getContext(), this, this.idd, wd(this.idd.getTabId()).idy);
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
        this.icZ = 0;
        this.idd = null;
        this.ide = null;
        this.mPaint = new Paint();
        this.idf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.idg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.idh = 0;
        this.idi = true;
        this.idj = R.color.transparent;
        this.idm = 0;
        this.idp = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void wi(int i) {
                if (HorizontalTabView.this.idd != null && HorizontalTabView.this.idr != null && HorizontalTabView.this.idr != null) {
                    HorizontalTabView.this.idr.a(HorizontalTabView.this.idd.getTabId(), i, null);
                }
                if (HorizontalTabView.this.ide != null) {
                    HorizontalTabView.this.ide.wg(i);
                }
            }
        };
        this.idq = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.idk) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.idn != null) {
                            HorizontalTabView.this.idn.b(HorizontalTabView.this.wc(1));
                        }
                        HorizontalTabView.this.chS();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.ide != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.wh(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.idd != null) {
                            HorizontalTabView.this.ide.wf(HorizontalTabView.this.idd.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.ide.wf(((TabItemView) view).getTabId());
                }
            }
        };
        this.ida = new LinearLayout(context);
        this.ida.setOrientation(0);
        this.ida.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.idb = new e(context, this.idp, this.idq);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.ida, layoutParams);
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
        if (wd.idy == null && dVar.idy == null) {
            return false;
        }
        if ((wd.idy != null || dVar.idy == null) && (dVar.idy != null || wd.idy == null)) {
            if (wd.idy == null || dVar.idy == null) {
                return false;
            }
            if (wd.idy.hJT == null && dVar.idy.hJT == null) {
                return false;
            }
            if ((wd.idy.hJT != null || dVar.idy.hJT == null) && (dVar.idy.hJT != null || wd.idy.hJT == null)) {
                int size = wd.idy.hJT.size();
                if (size != dVar.idy.hJT.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bd bdVar = dVar.idy.hJT.get(i);
                    bd bdVar2 = wd.idy.hJT.get(i);
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
        if (this.idk) {
            this.idc = new ArrayList();
            this.idc.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                be beVar2 = dVar.idy;
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
                    dVar.idy = beVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.idc = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.idh > 0 && list.size() == this.idh) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.idh, -1);
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
            this.ida.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.idk);
            if (this.idm != 0) {
                tabItemView.setSelectItemColorResId(this.idm);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.ida.addView(tabItemView, layoutParams);
            this.idd = tabItemView;
            tabItemView.setState(TabItemView.idA);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cP(list)) {
            this.mData = list;
            this.ida.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.idk);
                        if (this.idm != 0) {
                            tabItemView2.setSelectItemColorResId(this.idm);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (wh(dVar2.tabId)) {
                            ao.setViewTextColor(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.ida.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.idd = tabItemView2;
                            tabItemView2.setState(TabItemView.idA);
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
        if (i < 0 || this.idc == null || this.idc.size() == 0) {
            return null;
        }
        for (d dVar : this.idc) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean we(int i) {
        d wd = wd(i);
        return (wd == null || wd.idy == null || wd.idy.hJT == null || wd.idy.hJT.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.ide = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.idd != null) {
            this.mPaint.setColor(ao.getColor(R.color.cp_bg_line_c));
            if (this.idi) {
                canvas.drawRect(this.ida.getLeft(), getMeasuredHeight() - this.idg, this.ida.getRight() > getRight() ? this.ida.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.idk) {
                if (this.idm == 0) {
                    this.mPaint.setColor(ao.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ao.getSkinColor(null, this.idm));
                }
                canvas.drawRect(this.idd.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.idf, (this.idd.getRight() - getBottomLineMargin()) - this.idd.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.idk) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ao.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.idd != null) {
                dimens = this.idd.getRight() - this.idd.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.idd == null || this.icZ == 0) {
            return 0;
        }
        return ((this.idd.getMeasuredWidth() - this.icZ) - this.idd.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void wf(int i) {
        a(wc(i));
    }

    public void setDataLoadInterface(ap apVar) {
        this.idr = apVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.idu = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.idu;
    }

    public void setTabBackgroudColor(int i) {
        this.idj = i;
    }

    public void setAutoFillTabCount(int i) {
        this.idh = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void wg(int i) {
        if (this.idd != null && this.idr != null) {
            this.idr.a(this.idd.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.idn = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.ido = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.idk = z;
    }

    public static boolean wh(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.idi = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.idm = i;
    }
}
