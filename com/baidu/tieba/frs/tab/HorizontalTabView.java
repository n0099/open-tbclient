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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.bg;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes22.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext iHO;
    public int jud;
    private final LinearLayout jue;
    private final e juf;
    private List<d> jug;
    private TabItemView juh;
    private com.baidu.tieba.frs.tab.b jui;
    private final int juj;
    private final int juk;
    private int jul;
    private boolean jum;
    private int jun;
    private boolean juo;
    private int jup;
    private a juq;
    private b jur;
    private e.b jus;
    private e.a jut;
    private aq juu;
    private c juv;
    private List<d> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes22.dex */
    public interface a {
        void b(d dVar);
    }

    /* loaded from: classes22.dex */
    public interface b {
        void c(d dVar);
    }

    /* loaded from: classes22.dex */
    public interface c {
        boolean BA(int i);

        void Bz(int i);
    }

    public void cJJ() {
        final bg bgVar;
        if (this.iHO != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bgVar = this.mData.get(0).juy) != null && bgVar.iXv != null) {
                for (bf bfVar : bgVar.iXv) {
                    if (bfVar != null) {
                        arrayList.add(bfVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iHO.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0586b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bgVar.iXv.size() > i && bgVar.iXv.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.Bs(bgVar.iXv.get(i).iXr));
                        }
                    }
                });
                bVar.d(this.iHO);
                bVar.brx();
            }
        }
    }

    public d Bs(int i) {
        if (!y.isEmpty(this.jug)) {
            for (d dVar : this.jug) {
                if (dVar != null && dVar.tabId == i) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public void a(d dVar) {
        boolean z;
        ba baVar;
        if (dVar != null) {
            if (this.jur != null) {
                this.jur.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (Bx(dVar.tabId)) {
                if (this.juu != null && !TextUtils.isEmpty(dVar.url)) {
                    ba baVar2 = new ba();
                    baVar2.ext = dVar.url;
                    this.juu.a(dVar.tabId, -1, baVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.juu != null) {
                    this.juu.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.juu == null) {
                    z = true;
                } else {
                    ba baVar3 = new ba();
                    baVar3.ext = dVar.url;
                    baVar3.stType = dVar.name;
                    this.juu.a(dVar.tabId, 0, baVar3);
                    if (baVar3.iXR) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.jue.getChildCount(); i++) {
                    View childAt = this.jue.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(dVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(dVar.url)) {
                    baVar = null;
                } else {
                    baVar = new ba();
                    baVar.ext = dVar.url;
                    baVar.stType = dVar.name;
                }
                if (this.juu != null && z) {
                    this.juu.a(dVar.tabId, 0, baVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        ba baVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (Bx(tabItemView.getTabId())) {
                if (this.juu != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ba baVar2 = new ba();
                    baVar2.ext = tabItemView.getUrl();
                    this.juu.a(tabItemView.getTabId(), -1, baVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.juu != null) {
                    this.juu.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.juh = tabItemView;
                int[] iArr = new int[2];
                this.juh.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.jue.getChildCount(); i2++) {
                    View childAt = this.jue.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.juh.getTabId() && !Bx(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.juz);
                        }
                    }
                }
                if (this.juh.getState() == TabItemView.juz || this.juh.getState() == TabItemView.STATE_EXPANDED) {
                    this.juf.dismissMenu();
                    boolean z2 = this.juh.getState() == TabItemView.juz;
                    this.juh.setState(TabItemView.juA);
                    d Bt = Bt(this.juh.getTabId());
                    if (Bt != null) {
                        if (!TextUtils.isEmpty(Bt.url)) {
                            ba baVar3 = new ba();
                            baVar3.ext = Bt.url;
                            baVar3.stType = Bt.name;
                            baVar = baVar3;
                        }
                        if (Bt.juy != null && Bt.juy.iXv != null && Bt.juy.iXv.size() > 0) {
                            for (bf bfVar : Bt.juy.iXv) {
                                if (bfVar != null && bfVar.isSelected) {
                                    i = bfVar.iXr;
                                }
                            }
                        }
                        if (z2 && this.juu != null) {
                            this.juu.a(this.juh.getTabId(), i, baVar);
                        }
                    } else {
                        return;
                    }
                } else if (Bu(this.juh.getTabId()) && !z) {
                    if (this.juv == null || this.juv.BA(this.juh.getTabId())) {
                        this.juh.setState(TabItemView.STATE_EXPANDED);
                        this.juf.a((Activity) getContext(), this, this.juh, Bt(this.juh.getTabId()).juy);
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
        this.jud = 0;
        this.juh = null;
        this.jui = null;
        this.mPaint = new Paint();
        this.juj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.juk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.jul = 0;
        this.jum = true;
        this.jun = R.color.transparent;
        this.jup = 0;
        this.jus = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void By(int i) {
                if (HorizontalTabView.this.juh != null && HorizontalTabView.this.juu != null && HorizontalTabView.this.juu != null) {
                    HorizontalTabView.this.juu.a(HorizontalTabView.this.juh.getTabId(), i, null);
                }
                if (HorizontalTabView.this.jui != null) {
                    HorizontalTabView.this.jui.Bw(i);
                }
            }
        };
        this.jut = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.juo) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.juq != null) {
                            HorizontalTabView.this.juq.b(HorizontalTabView.this.Bs(1));
                        }
                        HorizontalTabView.this.cJJ();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.jui != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.Bx(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.juh != null) {
                            HorizontalTabView.this.jui.Bv(HorizontalTabView.this.juh.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.jui.Bv(((TabItemView) view).getTabId());
                }
            }
        };
        this.jue = new LinearLayout(context);
        this.jue.setOrientation(0);
        this.jue.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.juf = new e(context, this.jus, this.jut);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.jue, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ap.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean dA(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d Bt = Bt(1);
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
        if (Bt == null || dVar == null) {
            return false;
        }
        if (Bt.juy == null && dVar.juy == null) {
            return false;
        }
        if ((Bt.juy != null || dVar.juy == null) && (dVar.juy != null || Bt.juy == null)) {
            if (Bt.juy == null || dVar.juy == null) {
                return false;
            }
            if (Bt.juy.iXv == null && dVar.juy.iXv == null) {
                return false;
            }
            if ((Bt.juy.iXv != null || dVar.juy.iXv == null) && (dVar.juy.iXv != null || Bt.juy.iXv == null)) {
                int size = Bt.juy.iXv.size();
                if (size != dVar.juy.iXv.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bf bfVar = dVar.juy.iXv.get(i);
                    bf bfVar2 = Bt.juy.iXv.get(i);
                    if (bfVar.iXr != bfVar2.iXr || !bfVar.name.equals(bfVar2.name)) {
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
        bg bgVar;
        if (this.juo) {
            this.jug = new ArrayList();
            this.jug.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bg bgVar2 = dVar.juy;
                if (bgVar2 != null && bgVar2.iXv != null) {
                    bgVar2.iXv.clear();
                    bgVar = bgVar2;
                } else {
                    bg bgVar3 = new bg();
                    bgVar3.iXv = new ArrayList();
                    bgVar = bgVar3;
                }
                if (y.getCount(list) > 1) {
                    bf bfVar = new bf();
                    bfVar.iXr = 1;
                    bfVar.name = getContext().getString(R.string.chosen_pb_title);
                    bgVar.iXv.add(bfVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bf bfVar2 = new bf();
                            bfVar2.iXr = dVar2.tabId;
                            bfVar2.name = dVar2.name;
                            bgVar.iXv.add(bfVar2);
                        }
                    }
                    dVar.juy = bgVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.jug = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.jul > 0 && list.size() == this.jul) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.jul, -1);
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
            this.jue.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.juo);
            if (this.jup != 0) {
                tabItemView.setSelectItemColorResId(this.jup);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.jue.addView(tabItemView, layoutParams);
            this.juh = tabItemView;
            tabItemView.setState(TabItemView.juA);
            return;
        }
        setVisibility(0);
        if (this.mData == null || dA(list)) {
            this.mData = list;
            this.jue.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.juo);
                        if (this.jup != 0) {
                            tabItemView2.setSelectItemColorResId(this.jup);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (Bx(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.CAM_X0105);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.jue.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.juh = tabItemView2;
                            tabItemView2.setState(TabItemView.juA);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d Bt(int i) {
        if (i < 0 || this.jug == null || this.jug.size() == 0) {
            return null;
        }
        for (d dVar : this.jug) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean Bu(int i) {
        d Bt = Bt(i);
        return (Bt == null || Bt.juy == null || Bt.juy.iXv == null || Bt.juy.iXv.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.jui = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.juh != null) {
            this.mPaint.setColor(ap.getColor(R.color.CAM_X0204));
            if (this.jum) {
                canvas.drawRect(this.jue.getLeft(), getMeasuredHeight() - this.juk, this.jue.getRight() > getRight() ? this.jue.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.juo) {
                if (this.jup == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0302));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.jup));
                }
                canvas.drawRect(this.juh.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.juj, (this.juh.getRight() - getBottomLineMargin()) - this.juh.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.juo) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0105));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.juh != null) {
                dimens = this.juh.getRight() - this.juh.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.juh == null || this.jud == 0) {
            return 0;
        }
        return ((this.juh.getMeasuredWidth() - this.jud) - this.juh.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Bv(int i) {
        a(Bs(i));
    }

    public void setDataLoadInterface(aq aqVar) {
        this.juu = aqVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.juv = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.juv;
    }

    public void setTabBackgroudColor(int i) {
        this.jun = i;
    }

    public void setAutoFillTabCount(int i) {
        this.jul = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Bw(int i) {
        if (this.juh != null && this.juu != null) {
            this.juu.a(this.juh.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.juq = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.jur = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.juo = z;
    }

    public static boolean Bx(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.jum = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.jup = i;
    }
}
