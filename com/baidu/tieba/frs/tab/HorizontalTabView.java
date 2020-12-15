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
    private TbPageContext iHQ;
    public int juf;
    private final LinearLayout jug;
    private final e juh;
    private List<d> jui;
    private TabItemView juj;
    private com.baidu.tieba.frs.tab.b juk;
    private final int jul;
    private final int jum;
    private int jun;
    private boolean juo;
    private int jup;
    private boolean juq;
    private int jur;
    private a jus;
    private b jut;
    private e.b juu;
    private e.a juv;
    private aq juw;
    private c jux;
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

    public void cJK() {
        final bg bgVar;
        if (this.iHQ != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bgVar = this.mData.get(0).juA) != null && bgVar.iXx != null) {
                for (bf bfVar : bgVar.iXx) {
                    if (bfVar != null) {
                        arrayList.add(bfVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iHQ.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0586b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bgVar.iXx.size() > i && bgVar.iXx.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.Bs(bgVar.iXx.get(i).iXt));
                        }
                    }
                });
                bVar.d(this.iHQ);
                bVar.brx();
            }
        }
    }

    public d Bs(int i) {
        if (!y.isEmpty(this.jui)) {
            for (d dVar : this.jui) {
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
            if (this.jut != null) {
                this.jut.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (Bx(dVar.tabId)) {
                if (this.juw != null && !TextUtils.isEmpty(dVar.url)) {
                    ba baVar2 = new ba();
                    baVar2.ext = dVar.url;
                    this.juw.a(dVar.tabId, -1, baVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.juw != null) {
                    this.juw.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.juw == null) {
                    z = true;
                } else {
                    ba baVar3 = new ba();
                    baVar3.ext = dVar.url;
                    baVar3.stType = dVar.name;
                    this.juw.a(dVar.tabId, 0, baVar3);
                    if (baVar3.iXT) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.jug.getChildCount(); i++) {
                    View childAt = this.jug.getChildAt(i);
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
                if (this.juw != null && z) {
                    this.juw.a(dVar.tabId, 0, baVar);
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
                if (this.juw != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ba baVar2 = new ba();
                    baVar2.ext = tabItemView.getUrl();
                    this.juw.a(tabItemView.getTabId(), -1, baVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.juw != null) {
                    this.juw.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.juj = tabItemView;
                int[] iArr = new int[2];
                this.juj.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.jug.getChildCount(); i2++) {
                    View childAt = this.jug.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.juj.getTabId() && !Bx(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.juB);
                        }
                    }
                }
                if (this.juj.getState() == TabItemView.juB || this.juj.getState() == TabItemView.STATE_EXPANDED) {
                    this.juh.dismissMenu();
                    boolean z2 = this.juj.getState() == TabItemView.juB;
                    this.juj.setState(TabItemView.juC);
                    d Bt = Bt(this.juj.getTabId());
                    if (Bt != null) {
                        if (!TextUtils.isEmpty(Bt.url)) {
                            ba baVar3 = new ba();
                            baVar3.ext = Bt.url;
                            baVar3.stType = Bt.name;
                            baVar = baVar3;
                        }
                        if (Bt.juA != null && Bt.juA.iXx != null && Bt.juA.iXx.size() > 0) {
                            for (bf bfVar : Bt.juA.iXx) {
                                if (bfVar != null && bfVar.isSelected) {
                                    i = bfVar.iXt;
                                }
                            }
                        }
                        if (z2 && this.juw != null) {
                            this.juw.a(this.juj.getTabId(), i, baVar);
                        }
                    } else {
                        return;
                    }
                } else if (Bu(this.juj.getTabId()) && !z) {
                    if (this.jux == null || this.jux.BA(this.juj.getTabId())) {
                        this.juj.setState(TabItemView.STATE_EXPANDED);
                        this.juh.a((Activity) getContext(), this, this.juj, Bt(this.juj.getTabId()).juA);
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
        this.juf = 0;
        this.juj = null;
        this.juk = null;
        this.mPaint = new Paint();
        this.jul = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.jum = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.jun = 0;
        this.juo = true;
        this.jup = R.color.transparent;
        this.jur = 0;
        this.juu = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void By(int i) {
                if (HorizontalTabView.this.juj != null && HorizontalTabView.this.juw != null && HorizontalTabView.this.juw != null) {
                    HorizontalTabView.this.juw.a(HorizontalTabView.this.juj.getTabId(), i, null);
                }
                if (HorizontalTabView.this.juk != null) {
                    HorizontalTabView.this.juk.Bw(i);
                }
            }
        };
        this.juv = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.juq) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.jus != null) {
                            HorizontalTabView.this.jus.b(HorizontalTabView.this.Bs(1));
                        }
                        HorizontalTabView.this.cJK();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.juk != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.Bx(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.juj != null) {
                            HorizontalTabView.this.juk.Bv(HorizontalTabView.this.juj.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.juk.Bv(((TabItemView) view).getTabId());
                }
            }
        };
        this.jug = new LinearLayout(context);
        this.jug.setOrientation(0);
        this.jug.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.juh = new e(context, this.juu, this.juv);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.jug, layoutParams);
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
        if (Bt.juA == null && dVar.juA == null) {
            return false;
        }
        if ((Bt.juA != null || dVar.juA == null) && (dVar.juA != null || Bt.juA == null)) {
            if (Bt.juA == null || dVar.juA == null) {
                return false;
            }
            if (Bt.juA.iXx == null && dVar.juA.iXx == null) {
                return false;
            }
            if ((Bt.juA.iXx != null || dVar.juA.iXx == null) && (dVar.juA.iXx != null || Bt.juA.iXx == null)) {
                int size = Bt.juA.iXx.size();
                if (size != dVar.juA.iXx.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bf bfVar = dVar.juA.iXx.get(i);
                    bf bfVar2 = Bt.juA.iXx.get(i);
                    if (bfVar.iXt != bfVar2.iXt || !bfVar.name.equals(bfVar2.name)) {
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
        if (this.juq) {
            this.jui = new ArrayList();
            this.jui.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bg bgVar2 = dVar.juA;
                if (bgVar2 != null && bgVar2.iXx != null) {
                    bgVar2.iXx.clear();
                    bgVar = bgVar2;
                } else {
                    bg bgVar3 = new bg();
                    bgVar3.iXx = new ArrayList();
                    bgVar = bgVar3;
                }
                if (y.getCount(list) > 1) {
                    bf bfVar = new bf();
                    bfVar.iXt = 1;
                    bfVar.name = getContext().getString(R.string.chosen_pb_title);
                    bgVar.iXx.add(bfVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bf bfVar2 = new bf();
                            bfVar2.iXt = dVar2.tabId;
                            bfVar2.name = dVar2.name;
                            bgVar.iXx.add(bfVar2);
                        }
                    }
                    dVar.juA = bgVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.jui = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.jun > 0 && list.size() == this.jun) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.jun, -1);
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
            this.jug.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.juq);
            if (this.jur != 0) {
                tabItemView.setSelectItemColorResId(this.jur);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.jug.addView(tabItemView, layoutParams);
            this.juj = tabItemView;
            tabItemView.setState(TabItemView.juC);
            return;
        }
        setVisibility(0);
        if (this.mData == null || dA(list)) {
            this.mData = list;
            this.jug.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.juq);
                        if (this.jur != 0) {
                            tabItemView2.setSelectItemColorResId(this.jur);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (Bx(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.CAM_X0105);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.jug.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.juj = tabItemView2;
                            tabItemView2.setState(TabItemView.juC);
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
        if (i < 0 || this.jui == null || this.jui.size() == 0) {
            return null;
        }
        for (d dVar : this.jui) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean Bu(int i) {
        d Bt = Bt(i);
        return (Bt == null || Bt.juA == null || Bt.juA.iXx == null || Bt.juA.iXx.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.juk = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.juj != null) {
            this.mPaint.setColor(ap.getColor(R.color.CAM_X0204));
            if (this.juo) {
                canvas.drawRect(this.jug.getLeft(), getMeasuredHeight() - this.jum, this.jug.getRight() > getRight() ? this.jug.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.juq) {
                if (this.jur == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0302));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.jur));
                }
                canvas.drawRect(this.juj.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.jul, (this.juj.getRight() - getBottomLineMargin()) - this.juj.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.juq) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.CAM_X0105));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.juj != null) {
                dimens = this.juj.getRight() - this.juj.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.juj == null || this.juf == 0) {
            return 0;
        }
        return ((this.juj.getMeasuredWidth() - this.juf) - this.juj.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Bv(int i) {
        a(Bs(i));
    }

    public void setDataLoadInterface(aq aqVar) {
        this.juw = aqVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.jux = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.jux;
    }

    public void setTabBackgroudColor(int i) {
        this.jup = i;
    }

    public void setAutoFillTabCount(int i) {
        this.jun = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Bw(int i) {
        if (this.juj != null && this.juw != null) {
            this.juw.a(this.juj.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jus = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.jut = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.juq = z;
    }

    public static boolean Bx(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.juo = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.jur = i;
    }
}
