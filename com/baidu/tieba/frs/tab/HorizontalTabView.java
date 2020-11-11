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
import com.baidu.tieba.frs.ar;
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
    private TbPageContext iwh;
    public int jfP;
    private final LinearLayout jfQ;
    private final e jfR;
    private List<d> jfS;
    private TabItemView jfT;
    private com.baidu.tieba.frs.tab.b jfU;
    private final int jfV;
    private final int jfW;
    private int jfX;
    private boolean jfY;
    private int jfZ;
    private boolean jga;
    private int jgb;
    private a jgc;
    private b jgd;
    private e.b jge;
    private e.a jgf;
    private ar jgg;
    private c jgh;
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
        void An(int i);

        boolean Ao(int i);
    }

    public void cER() {
        final bg bgVar;
        if (this.iwh != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (bgVar = this.mData.get(0).jgk) != null && bgVar.iLR != null) {
                for (bf bfVar : bgVar.iLR) {
                    if (bfVar != null) {
                        arrayList.add(bfVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iwh.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0576b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (bgVar.iLR.size() > i && bgVar.iLR.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.Ag(bgVar.iLR.get(i).iLN));
                        }
                    }
                });
                bVar.d(this.iwh);
                bVar.bpe();
            }
        }
    }

    public d Ag(int i) {
        if (!y.isEmpty(this.jfS)) {
            for (d dVar : this.jfS) {
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
            if (this.jgd != null) {
                this.jgd.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (Al(dVar.tabId)) {
                if (this.jgg != null && !TextUtils.isEmpty(dVar.url)) {
                    ba baVar2 = new ba();
                    baVar2.ext = dVar.url;
                    this.jgg.a(dVar.tabId, -1, baVar2);
                }
            } else if (dVar.tabId == 301) {
                if (this.jgg != null) {
                    this.jgg.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.jgg == null) {
                    z = true;
                } else {
                    ba baVar3 = new ba();
                    baVar3.ext = dVar.url;
                    baVar3.stType = dVar.name;
                    this.jgg.a(dVar.tabId, 0, baVar3);
                    if (baVar3.iMn) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.jfQ.getChildCount(); i++) {
                    View childAt = this.jfQ.getChildAt(i);
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
                if (this.jgg != null && z) {
                    this.jgg.a(dVar.tabId, 0, baVar);
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
            if (Al(tabItemView.getTabId())) {
                if (this.jgg != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ba baVar2 = new ba();
                    baVar2.ext = tabItemView.getUrl();
                    this.jgg.a(tabItemView.getTabId(), -1, baVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.jgg != null) {
                    this.jgg.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.jfT = tabItemView;
                int[] iArr = new int[2];
                this.jfT.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.jfQ.getChildCount(); i2++) {
                    View childAt = this.jfQ.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.jfT.getTabId() && !Al(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.jgl);
                        }
                    }
                }
                if (this.jfT.getState() == TabItemView.jgl || this.jfT.getState() == TabItemView.STATE_EXPANDED) {
                    this.jfR.dismissMenu();
                    boolean z2 = this.jfT.getState() == TabItemView.jgl;
                    this.jfT.setState(TabItemView.jgm);
                    d Ah = Ah(this.jfT.getTabId());
                    if (Ah != null) {
                        if (!TextUtils.isEmpty(Ah.url)) {
                            ba baVar3 = new ba();
                            baVar3.ext = Ah.url;
                            baVar3.stType = Ah.name;
                            baVar = baVar3;
                        }
                        if (Ah.jgk != null && Ah.jgk.iLR != null && Ah.jgk.iLR.size() > 0) {
                            for (bf bfVar : Ah.jgk.iLR) {
                                if (bfVar != null && bfVar.isSelected) {
                                    i = bfVar.iLN;
                                }
                            }
                        }
                        if (z2 && this.jgg != null) {
                            this.jgg.a(this.jfT.getTabId(), i, baVar);
                        }
                    } else {
                        return;
                    }
                } else if (Ai(this.jfT.getTabId()) && !z) {
                    if (this.jgh == null || this.jgh.Ao(this.jfT.getTabId())) {
                        this.jfT.setState(TabItemView.STATE_EXPANDED);
                        this.jfR.a((Activity) getContext(), this, this.jfT, Ah(this.jfT.getTabId()).jgk);
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
        this.jfP = 0;
        this.jfT = null;
        this.jfU = null;
        this.mPaint = new Paint();
        this.jfV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.jfW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.jfX = 0;
        this.jfY = true;
        this.jfZ = R.color.transparent;
        this.jgb = 0;
        this.jge = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void Am(int i) {
                if (HorizontalTabView.this.jfT != null && HorizontalTabView.this.jgg != null && HorizontalTabView.this.jgg != null) {
                    HorizontalTabView.this.jgg.a(HorizontalTabView.this.jfT.getTabId(), i, null);
                }
                if (HorizontalTabView.this.jfU != null) {
                    HorizontalTabView.this.jfU.Ak(i);
                }
            }
        };
        this.jgf = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HorizontalTabView.this.jga) {
                    if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                        if (HorizontalTabView.this.jgc != null) {
                            HorizontalTabView.this.jgc.b(HorizontalTabView.this.Ag(1));
                        }
                        HorizontalTabView.this.cER();
                        return;
                    }
                    return;
                }
                if (view instanceof TabItemView) {
                    HorizontalTabView.this.a((TabItemView) view, false);
                }
                if (HorizontalTabView.this.jfU != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.Al(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.jfT != null) {
                            HorizontalTabView.this.jfU.Aj(HorizontalTabView.this.jfT.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.jfU.Aj(((TabItemView) view).getTabId());
                }
            }
        };
        this.jfQ = new LinearLayout(context);
        this.jfQ.setOrientation(0);
        this.jfQ.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.jfR = new e(context, this.jge, this.jgf);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.jfQ, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ap.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    private boolean dr(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d Ah = Ah(1);
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
        if (Ah == null || dVar == null) {
            return false;
        }
        if (Ah.jgk == null && dVar.jgk == null) {
            return false;
        }
        if ((Ah.jgk != null || dVar.jgk == null) && (dVar.jgk != null || Ah.jgk == null)) {
            if (Ah.jgk == null || dVar.jgk == null) {
                return false;
            }
            if (Ah.jgk.iLR == null && dVar.jgk.iLR == null) {
                return false;
            }
            if ((Ah.jgk.iLR != null || dVar.jgk.iLR == null) && (dVar.jgk.iLR != null || Ah.jgk.iLR == null)) {
                int size = Ah.jgk.iLR.size();
                if (size != dVar.jgk.iLR.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    bf bfVar = dVar.jgk.iLR.get(i);
                    bf bfVar2 = Ah.jgk.iLR.get(i);
                    if (bfVar.iLN != bfVar2.iLN || !bfVar.name.equals(bfVar2.name)) {
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
        if (this.jga) {
            this.jfS = new ArrayList();
            this.jfS.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                bg bgVar2 = dVar.jgk;
                if (bgVar2 != null && bgVar2.iLR != null) {
                    bgVar2.iLR.clear();
                    bgVar = bgVar2;
                } else {
                    bg bgVar3 = new bg();
                    bgVar3.iLR = new ArrayList();
                    bgVar = bgVar3;
                }
                if (y.getCount(list) > 1) {
                    bf bfVar = new bf();
                    bfVar.iLN = 1;
                    bfVar.name = getContext().getString(R.string.chosen_pb_title);
                    bgVar.iLR.add(bfVar);
                    for (d dVar2 : list) {
                        if (dVar2 != null && dVar2.tabId != 1) {
                            bf bfVar2 = new bf();
                            bfVar2.iLN = dVar2.tabId;
                            bfVar2.name = dVar2.name;
                            bgVar.iLR.add(bfVar2);
                        }
                    }
                    dVar.jgk = bgVar;
                }
                list.clear();
                list.add(dVar);
                if (0 != 0) {
                    list.add(null);
                }
            }
        } else {
            this.jfS = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.jfX > 0 && list.size() == this.jfX) {
            layoutParams = new LinearLayout.LayoutParams(l.getEquipmentWidth(getContext()) / this.jfX, -1);
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
            this.jfQ.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.jga);
            if (this.jgb != 0) {
                tabItemView.setSelectItemColorResId(this.jgb);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
            this.jfQ.addView(tabItemView, layoutParams);
            this.jfT = tabItemView;
            tabItemView.setState(TabItemView.jgm);
            return;
        }
        setVisibility(0);
        if (this.mData == null || dr(list)) {
            this.mData = list;
            this.jfQ.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.jga);
                        if (this.jgb != 0) {
                            tabItemView2.setSelectItemColorResId(this.jgb);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (Al(dVar2.tabId)) {
                            ap.setViewTextColor(tabItemView2, R.color.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.jfQ.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.jfT = tabItemView2;
                            tabItemView2.setState(TabItemView.jgm);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d Ah(int i) {
        if (i < 0 || this.jfS == null || this.jfS.size() == 0) {
            return null;
        }
        for (d dVar : this.jfS) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean Ai(int i) {
        d Ah = Ah(i);
        return (Ah == null || Ah.jgk == null || Ah.jgk.iLR == null || Ah.jgk.iLR.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.jfU = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.jfT != null) {
            this.mPaint.setColor(ap.getColor(R.color.cp_bg_line_c));
            if (this.jfY) {
                canvas.drawRect(this.jfQ.getLeft(), getMeasuredHeight() - this.jfW, this.jfQ.getRight() > getRight() ? this.jfQ.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.jga) {
                if (this.jgb == 0) {
                    this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(ap.getSkinColor(null, this.jgb));
                }
                canvas.drawRect(this.jfT.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.jfV, (this.jfT.getRight() - getBottomLineMargin()) - this.jfT.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.jga) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(ap.getSkinColor(null, R.color.cp_cont_b));
            int dimens = l.getDimens(getContext(), R.dimen.ds96);
            if (this.jfT != null) {
                dimens = this.jfT.getRight() - this.jfT.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds98), dimens, l.getDimens(getContext(), R.dimen.tbds104)), l.getDimens(getContext(), R.dimen.tbds6), l.getDimens(getContext(), R.dimen.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.jfT == null || this.jfP == 0) {
            return 0;
        }
        return ((this.jfT.getMeasuredWidth() - this.jfP) - this.jfT.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Aj(int i) {
        a(Ag(i));
    }

    public void setDataLoadInterface(ar arVar) {
        this.jgg = arVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.jgh = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.jgh;
    }

    public void setTabBackgroudColor(int i) {
        this.jfZ = i;
    }

    public void setAutoFillTabCount(int i) {
        this.jfX = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void Ak(int i) {
        if (this.jfT != null && this.jgg != null) {
            this.jgg.a(this.jfT.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.jgc = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.jgd = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.jga = z;
    }

    public static boolean Al(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.jfY = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.jgb = i;
    }
}
