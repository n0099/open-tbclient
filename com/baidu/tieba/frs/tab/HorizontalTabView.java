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
import com.baidu.tieba.d;
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
    private TbPageContext eKv;
    private int ftA;
    private a ftB;
    private b ftC;
    private e.b ftD;
    private e.a ftE;
    private af ftF;
    private c ftG;
    public int fto;
    private final LinearLayout ftp;
    private final e ftq;
    private List<d> ftr;
    private TabItemView fts;
    private com.baidu.tieba.frs.tab.b ftt;
    private final int ftu;
    private final int ftv;
    private int ftw;
    private boolean ftx;
    private int fty;
    private boolean ftz;
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
        void rp(int i);

        boolean rq(int i);
    }

    public void bio() {
        final as asVar;
        if (this.eKv != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (asVar = this.mData.get(0).ftJ) != null && asVar.fcF != null) {
                for (ar arVar : asVar.fcF) {
                    if (arVar != null) {
                        arrayList.add(arVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eKv.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0191b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0191b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (asVar.fcF.size() > i && asVar.fcF.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.ri(asVar.fcF.get(i).fcB));
                        }
                    }
                });
                bVar.d(this.eKv);
                bVar.abc();
            }
        }
    }

    public d ri(int i) {
        if (!v.T(this.ftr)) {
            for (d dVar : this.ftr) {
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
            if (dVar.tabId != 302 && this.ftC != null) {
                this.ftC.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (rn(dVar.tabId)) {
                if (this.ftF != null && !TextUtils.isEmpty(dVar.url)) {
                    am amVar = new am();
                    amVar.fdb = dVar.url;
                    this.ftF.a(dVar.tabId, -1, amVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.ftF != null) {
                    this.ftF.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.ftF == null) {
                    z = true;
                } else {
                    am amVar2 = new am();
                    amVar2.fdb = dVar.url;
                    amVar2.stType = dVar.name;
                    this.ftF.a(dVar.tabId, 0, amVar2);
                    if (amVar2.fdc) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.ftp.getChildCount(); i++) {
                    View childAt = this.ftp.getChildAt(i);
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
                    amVar3.fdb = dVar.url;
                    amVar3.stType = dVar.name;
                }
                if (this.ftF != null && z) {
                    this.ftF.a(dVar.tabId, 0, amVar3);
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
            if (rn(tabItemView.getTabId())) {
                if (this.ftF != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    am amVar2 = new am();
                    amVar2.fdb = tabItemView.getUrl();
                    this.ftF.a(tabItemView.getTabId(), -1, amVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.ftF != null) {
                    this.ftF.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.fts = tabItemView;
                int[] iArr = new int[2];
                this.fts.getLocationOnScreen(iArr);
                int aO = l.aO(getContext()) - iArr[0];
                final int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(d.e.ds160);
                if (iArr[0] < 0) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.5
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(0 - dimensionPixelSize, 0);
                        }
                    });
                } else if (aO < dimensionPixelSize) {
                    post(new Runnable() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.6
                        @Override // java.lang.Runnable
                        public void run() {
                            HorizontalTabView.this.scrollBy(HorizontalTabView.this.getContext().getResources().getDimensionPixelSize(d.e.ds160), 0);
                        }
                    });
                }
                for (int i2 = 0; i2 < this.ftp.getChildCount(); i2++) {
                    View childAt = this.ftp.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.fts.getTabId() && !rn(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.ftK);
                        }
                    }
                }
                if (this.fts.getState() == TabItemView.ftK || this.fts.getState() == TabItemView.STATE_EXPANDED) {
                    this.ftq.bir();
                    boolean z2 = this.fts.getState() == TabItemView.ftK;
                    this.fts.setState(TabItemView.ftL);
                    d rj = rj(this.fts.getTabId());
                    if (rj != null) {
                        if (!TextUtils.isEmpty(rj.url)) {
                            am amVar3 = new am();
                            amVar3.fdb = rj.url;
                            amVar3.stType = rj.name;
                            amVar = amVar3;
                        }
                        if (rj.ftJ != null && rj.ftJ.fcF != null && rj.ftJ.fcF.size() > 0) {
                            for (ar arVar : rj.ftJ.fcF) {
                                if (arVar != null && arVar.isSelected) {
                                    i = arVar.fcB;
                                }
                            }
                        }
                        if (z2 && this.ftF != null) {
                            this.ftF.a(this.fts.getTabId(), i, amVar);
                        }
                    } else {
                        return;
                    }
                } else if (rk(this.fts.getTabId()) && !z) {
                    if (this.ftG == null || this.ftG.rq(this.fts.getTabId())) {
                        this.fts.setState(TabItemView.STATE_EXPANDED);
                        this.ftq.a((Activity) getContext(), this, this.fts, rj(this.fts.getTabId()).ftJ);
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
        this.fto = 0;
        this.fts = null;
        this.ftt = null;
        this.mPaint = new Paint();
        this.ftu = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.ftv = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.ftw = 0;
        this.ftx = true;
        this.fty = d.C0236d.transparent;
        this.ftA = 0;
        this.ftD = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void ro(int i) {
                if (HorizontalTabView.this.fts != null && HorizontalTabView.this.ftF != null && HorizontalTabView.this.ftF != null) {
                    HorizontalTabView.this.ftF.a(HorizontalTabView.this.fts.getTabId(), i, null);
                }
                if (HorizontalTabView.this.ftt != null) {
                    HorizontalTabView.this.ftt.rm(i);
                }
            }
        };
        this.ftE = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.ftz) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.ftB != null) {
                                HorizontalTabView.this.ftB.b(HorizontalTabView.this.ri(1));
                            }
                            HorizontalTabView.this.bio();
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
                if (HorizontalTabView.this.ftt != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.rn(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.fts != null) {
                            HorizontalTabView.this.ftt.rl(HorizontalTabView.this.fts.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.ftt.rl(((TabItemView) view).getTabId());
                }
            }
        };
        this.ftp = new LinearLayout(context);
        this.ftp.setOrientation(0);
        this.ftp.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.ftq = new e(context, this.ftD, this.ftE);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.ftp, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        al.l(this, d.C0236d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean cg(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d rj = rj(1);
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
        if (rj == null || dVar == null) {
            return false;
        }
        if (rj.ftJ == null && dVar.ftJ == null) {
            return false;
        }
        if ((rj.ftJ != null || dVar.ftJ == null) && (dVar.ftJ != null || rj.ftJ == null)) {
            if (rj.ftJ == null || dVar.ftJ == null) {
                return false;
            }
            if (rj.ftJ.fcF == null && dVar.ftJ.fcF == null) {
                return false;
            }
            if ((rj.ftJ.fcF != null || dVar.ftJ.fcF == null) && (dVar.ftJ.fcF != null || rj.ftJ.fcF == null)) {
                int size = rj.ftJ.fcF.size();
                if (size != dVar.ftJ.fcF.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ar arVar = dVar.ftJ.fcF.get(i);
                    ar arVar2 = rj.ftJ.fcF.get(i);
                    if (arVar.fcB != arVar2.fcB || !arVar.name.equals(arVar2.name)) {
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
        if (this.ftz) {
            this.ftr = new ArrayList();
            this.ftr.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                as asVar2 = dVar.ftJ;
                if (asVar2 != null && asVar2.fcF != null) {
                    asVar2.fcF.clear();
                    asVar = asVar2;
                } else {
                    as asVar3 = new as();
                    asVar3.fcF = new ArrayList();
                    asVar = asVar3;
                }
                d dVar2 = null;
                if (v.S(list) > 1) {
                    ar arVar = new ar();
                    arVar.fcB = 1;
                    arVar.name = getContext().getString(d.j.chosen_pb_title);
                    asVar.fcF.add(arVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            ar arVar2 = new ar();
                            arVar2.fcB = dVar3.tabId;
                            arVar2.name = dVar3.name;
                            asVar.fcF.add(arVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.ftJ = asVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.ftr = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.ftw > 0 && list.size() == this.ftw) {
            layoutParams = new LinearLayout.LayoutParams(l.aO(getContext()) / this.ftw, -1);
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
            dVar.name = getContext().getResources().getString(d.j.chosen_pb_title);
            this.ftp.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.ftz);
            if (this.ftA != 0) {
                tabItemView.setSelectItemColorResId(this.ftA);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.ftp.addView(tabItemView, layoutParams);
            this.fts = tabItemView;
            tabItemView.setState(TabItemView.ftL);
            return;
        }
        setVisibility(0);
        if (this.mData == null || cg(list)) {
            this.mData = list;
            this.ftp.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.ftz);
                        if (302 == dVar2.tabId) {
                            al.d(tabItemView2, d.C0236d.cp_cont_j, 1);
                        }
                        if (this.ftA != 0) {
                            tabItemView2.setSelectItemColorResId(this.ftA);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (rn(dVar2.tabId)) {
                            al.j(tabItemView2, d.C0236d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.ftp.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.fts = tabItemView2;
                            tabItemView2.setState(TabItemView.ftL);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d rj(int i) {
        if (i < 0 || this.ftr == null || this.ftr.size() == 0) {
            return null;
        }
        for (d dVar : this.ftr) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean rk(int i) {
        d rj = rj(i);
        return (rj == null || rj.ftJ == null || rj.ftJ.fcF == null || rj.ftJ.fcF.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.ftt = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.fts != null) {
            this.mPaint.setColor(al.getColor(d.C0236d.cp_bg_line_b));
            if (this.ftx) {
                canvas.drawRect(this.ftp.getLeft(), getMeasuredHeight() - this.ftv, this.ftp.getRight() > getRight() ? this.ftp.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.ftz) {
                if (this.ftA == 0) {
                    this.mPaint.setColor(al.d((Resources) null, d.C0236d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(al.d((Resources) null, this.ftA));
                }
                canvas.drawRect(this.fts.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.ftu, (this.fts.getRight() - getBottomLineMargin()) - this.fts.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.ftz) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(al.d((Resources) null, d.C0236d.cp_cont_b));
            int h = l.h(getContext(), d.e.ds96);
            if (this.fts != null) {
                h = this.fts.getRight() - this.fts.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.h(getContext(), d.e.tbds44), l.h(getContext(), d.e.tbds98), h, l.h(getContext(), d.e.tbds104)), l.h(getContext(), d.e.tbds6), l.h(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.fts == null || this.fto == 0) {
            return 0;
        }
        return ((this.fts.getMeasuredWidth() - this.fto) - this.fts.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void rl(int i) {
        a(ri(i));
    }

    public void setDataLoadInterface(af afVar) {
        this.ftF = afVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.ftG = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.ftG;
    }

    public void setTabBackgroudColor(int i) {
        this.fty = i;
    }

    public void setAutoFillTabCount(int i) {
        this.ftw = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void rm(int i) {
        if (this.fts != null && this.ftF != null) {
            this.ftF.a(this.fts.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.ftB = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.ftC = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.ftz = z;
    }

    public static boolean rn(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.ftx = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.ftA = i;
    }
}
