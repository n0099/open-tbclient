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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.tab.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements com.baidu.tieba.frs.tab.b {
    private TbPageContext cYa;
    public int dEP;
    private final LinearLayout dEQ;
    private final e dER;
    private List<d> dES;
    private TabItemView dET;
    private com.baidu.tieba.frs.tab.b dEU;
    private final int dEV;
    private final int dEW;
    private int dEX;
    private boolean dEY;
    private int dEZ;
    private boolean dFa;
    private int dFb;
    private a dFc;
    private b dFd;
    private e.b dFe;
    private e.a dFf;
    private ai dFg;
    private c dFh;
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
        void lF(int i);

        boolean lG(int i);
    }

    public void aAf() {
        final au auVar;
        if (this.cYa != null) {
            ArrayList arrayList = new ArrayList();
            if (this.mData != null && this.mData.size() > 0 && this.mData.get(0) != null && (auVar = this.mData.get(0).dFk) != null && auVar.dpy != null) {
                for (at atVar : auVar.dpy) {
                    if (atVar != null) {
                        arrayList.add(atVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.cYa.getPageActivity());
                bVar.a(arrayList, new b.InterfaceC0101b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.4
                    @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                    public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                        if (auVar.dpy.size() > i && auVar.dpy.get(i) != null) {
                            bVar2.dismiss();
                            HorizontalTabView.this.a(HorizontalTabView.this.ly(auVar.dpy.get(i).dpu));
                        }
                    }
                });
                bVar.d(this.cYa);
                bVar.xi();
            }
        }
    }

    public d ly(int i) {
        if (!w.z(this.dES)) {
            for (d dVar : this.dES) {
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
            if (dVar.tabId != 302 && this.dFd != null) {
                this.dFd.c(dVar);
            }
            if (dVar.tabId == 49) {
                TiebaStatic.log("c11841");
            }
            if (lD(dVar.tabId)) {
                if (this.dFg != null && !TextUtils.isEmpty(dVar.url)) {
                    ao aoVar = new ao();
                    aoVar.dpN = dVar.url;
                    this.dFg.a(dVar.tabId, -1, aoVar);
                }
            } else if (dVar.tabId == 301 || dVar.tabId == 302) {
                if (this.dFg != null) {
                    this.dFg.a(dVar.tabId, -1, null);
                }
            } else {
                if (dVar.tabId != 49 || this.dFg == null) {
                    z = true;
                } else {
                    ao aoVar2 = new ao();
                    aoVar2.dpN = dVar.url;
                    aoVar2.stType = dVar.name;
                    this.dFg.a(dVar.tabId, 0, aoVar2);
                    if (aoVar2.dpO) {
                        return;
                    }
                    z = false;
                }
                for (int i = 0; i < this.dEQ.getChildCount(); i++) {
                    View childAt = this.dEQ.getChildAt(i);
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
                    aoVar3.dpN = dVar.url;
                    aoVar3.stType = dVar.name;
                }
                if (this.dFg != null && z) {
                    this.dFg.a(dVar.tabId, 0, aoVar3);
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
            if (lD(tabItemView.getTabId())) {
                if (this.dFg != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    ao aoVar2 = new ao();
                    aoVar2.dpN = tabItemView.getUrl();
                    this.dFg.a(tabItemView.getTabId(), -1, aoVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.dFg != null) {
                    this.dFg.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.dET = tabItemView;
                int[] iArr = new int[2];
                this.dET.getLocationOnScreen(iArr);
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
                for (int i2 = 0; i2 < this.dEQ.getChildCount(); i2++) {
                    View childAt = this.dEQ.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.dET.getTabId() && !lD(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.dFl);
                        }
                    }
                }
                if (this.dET.getState() == TabItemView.dFl || this.dET.getState() == TabItemView.STATE_EXPANDED) {
                    this.dER.aAi();
                    boolean z2 = this.dET.getState() == TabItemView.dFl;
                    this.dET.setState(TabItemView.dFm);
                    d lz = lz(this.dET.getTabId());
                    if (lz != null) {
                        if (!TextUtils.isEmpty(lz.url)) {
                            ao aoVar3 = new ao();
                            aoVar3.dpN = lz.url;
                            aoVar3.stType = lz.name;
                            aoVar = aoVar3;
                        }
                        if (lz.dFk != null && lz.dFk.dpy != null && lz.dFk.dpy.size() > 0) {
                            for (at atVar : lz.dFk.dpy) {
                                if (atVar != null && atVar.isSelected) {
                                    i = atVar.dpu;
                                }
                            }
                        }
                        if (z2 && this.dFg != null) {
                            this.dFg.a(this.dET.getTabId(), i, aoVar);
                        }
                    } else {
                        return;
                    }
                } else if (lA(this.dET.getTabId()) && !z) {
                    if (this.dFh == null || this.dFh.lG(this.dET.getTabId())) {
                        this.dET.setState(TabItemView.STATE_EXPANDED);
                        this.dER.a((Activity) getContext(), this, this.dET, lz(this.dET.getTabId()).dFk);
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
        this.dEP = 0;
        this.dET = null;
        this.dEU = null;
        this.mPaint = new Paint();
        this.dEV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds6);
        this.dEW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds1);
        this.dEX = 0;
        this.dEY = true;
        this.dEZ = d.C0140d.transparent;
        this.dFb = 0;
        this.dFe = new e.b() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.1
            @Override // com.baidu.tieba.frs.tab.e.b
            public void lE(int i) {
                if (HorizontalTabView.this.dET != null && HorizontalTabView.this.dFg != null && HorizontalTabView.this.dFg != null) {
                    HorizontalTabView.this.dFg.a(HorizontalTabView.this.dET.getTabId(), i, null);
                }
                if (HorizontalTabView.this.dEU != null) {
                    HorizontalTabView.this.dEU.lC(i);
                }
            }
        };
        this.dFf = new e.a() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.2
            @Override // com.baidu.tieba.frs.tab.e.a
            public void a(TabItemView tabItemView) {
                HorizontalTabView.this.a(tabItemView, false);
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.tab.HorizontalTabView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d dVar;
                if (HorizontalTabView.this.dFa) {
                    if (view instanceof TabItemView) {
                        if (((TabItemView) view).getTabId() == 1) {
                            if (HorizontalTabView.this.dFc != null) {
                                HorizontalTabView.this.dFc.b(HorizontalTabView.this.ly(1));
                            }
                            HorizontalTabView.this.aAf();
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
                if (HorizontalTabView.this.dEU != null) {
                    if (!(view instanceof TabItemView) || !HorizontalTabView.lD(((TabItemView) view).getTabId())) {
                        if (HorizontalTabView.this.dET != null) {
                            HorizontalTabView.this.dEU.lB(HorizontalTabView.this.dET.getTabId());
                            return;
                        }
                        return;
                    }
                    HorizontalTabView.this.dEU.lB(((TabItemView) view).getTabId());
                }
            }
        };
        this.dEQ = new LinearLayout(context);
        this.dEQ.setOrientation(0);
        this.dEQ.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds88));
        this.dER = new e(context, this.dFe, this.dFf);
        a(layoutParams);
    }

    @SuppressLint({"ResourceAsColor"})
    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.dEQ, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        am.j(this, d.C0140d.transparent);
        setDescendantFocusability(262144);
    }

    private boolean bz(List<d> list) {
        d dVar;
        if (list == null) {
            return false;
        }
        d lz = lz(1);
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
        if (lz == null || dVar == null) {
            return false;
        }
        if (lz.dFk == null && dVar.dFk == null) {
            return false;
        }
        if ((lz.dFk != null || dVar.dFk == null) && (dVar.dFk != null || lz.dFk == null)) {
            if (lz.dFk == null || dVar.dFk == null) {
                return false;
            }
            if (lz.dFk.dpy == null && dVar.dFk.dpy == null) {
                return false;
            }
            if ((lz.dFk.dpy != null || dVar.dFk.dpy == null) && (dVar.dFk.dpy != null || lz.dFk.dpy == null)) {
                int size = lz.dFk.dpy.size();
                if (size != dVar.dFk.dpy.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    at atVar = dVar.dFk.dpy.get(i);
                    at atVar2 = lz.dFk.dpy.get(i);
                    if (atVar.dpu != atVar2.dpu || !atVar.name.equals(atVar2.name)) {
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
        if (this.dFa) {
            this.dES = new ArrayList();
            this.dES.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.tabId == 1) {
                au auVar2 = dVar.dFk;
                if (auVar2 != null && auVar2.dpy != null) {
                    auVar2.dpy.clear();
                    auVar = auVar2;
                } else {
                    au auVar3 = new au();
                    auVar3.dpy = new ArrayList();
                    auVar = auVar3;
                }
                d dVar2 = null;
                if (w.y(list) > 1) {
                    at atVar = new at();
                    atVar.dpu = 1;
                    atVar.name = getContext().getString(d.j.chosen_pb_title);
                    auVar.dpy.add(atVar);
                    for (d dVar3 : list) {
                        if (dVar3 != null && dVar3.tabId != 1 && dVar3.tabId != 302) {
                            at atVar2 = new at();
                            atVar2.dpu = dVar3.tabId;
                            atVar2.name = dVar3.name;
                            auVar.dpy.add(atVar2);
                        }
                        if (dVar3 == null || dVar3.tabId != 302) {
                            dVar3 = dVar2;
                        }
                        dVar2 = dVar3;
                    }
                    dVar.dFk = auVar;
                }
                list.clear();
                list.add(dVar);
                if (dVar2 != null) {
                    list.add(dVar2);
                }
            }
        } else {
            this.dES = list;
        }
        b(list, i, i2, false);
    }

    private void b(List<d> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.dEX > 0 && list.size() == this.dEX) {
            layoutParams = new LinearLayout.LayoutParams(l.ah(getContext()) / this.dEX, -1);
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
            this.dEQ.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), dVar, i2, this.dFa);
            if (this.dFb != 0) {
                tabItemView.setSelectItemColorResId(this.dFb);
            }
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.ds32);
            this.dEQ.addView(tabItemView, layoutParams);
            this.dET = tabItemView;
            tabItemView.setState(TabItemView.dFm);
            return;
        }
        setVisibility(0);
        if (this.mData == null || bz(list)) {
            this.mData = list;
            this.dEQ.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    d dVar2 = list.get(i4);
                    if (dVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i2, this.dFa);
                        if (302 == dVar2.tabId) {
                            am.c(tabItemView2, d.C0140d.cp_cont_j, 1);
                        }
                        if (this.dFb != 0) {
                            tabItemView2.setSelectItemColorResId(this.dFb);
                        }
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (lD(dVar2.tabId)) {
                            am.h(tabItemView2, d.C0140d.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(d.e.tbds44);
                        }
                        this.dEQ.addView(tabItemView2, layoutParams);
                        if (dVar2.tabId == i) {
                            this.dET = tabItemView2;
                            tabItemView2.setState(TabItemView.dFm);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private d lz(int i) {
        if (i < 0 || this.dES == null || this.dES.size() == 0) {
            return null;
        }
        for (d dVar : this.dES) {
            if (dVar != null && dVar.tabId == i) {
                return dVar;
            }
        }
        return null;
    }

    private boolean lA(int i) {
        d lz = lz(i);
        return (lz == null || lz.dFk == null || lz.dFk.dpy == null || lz.dFk.dpy.size() <= 0) ? false : true;
    }

    public void setFakeTab(com.baidu.tieba.frs.tab.b bVar) {
        this.dEU = bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.dET != null) {
            this.mPaint.setColor(am.getColor(d.C0140d.cp_bg_line_b));
            if (this.dEY) {
                canvas.drawRect(this.dEQ.getLeft(), getMeasuredHeight() - this.dEW, this.dEQ.getRight() > getRight() ? this.dEQ.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.dFa) {
                if (this.dFb == 0) {
                    this.mPaint.setColor(am.d((Resources) null, d.C0140d.cp_link_tip_a));
                } else {
                    this.mPaint.setColor(am.d((Resources) null, this.dFb));
                }
                canvas.drawRect(this.dET.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.dEV, (this.dET.getRight() - getBottomLineMargin()) - this.dET.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.dFa) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(am.d((Resources) null, d.C0140d.cp_cont_b));
            int f = l.f(getContext(), d.e.ds96);
            if (this.dET != null) {
                f = this.dET.getRight() - this.dET.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.f(getContext(), d.e.tbds44), l.f(getContext(), d.e.tbds98), f, l.f(getContext(), d.e.tbds104)), l.f(getContext(), d.e.tbds6), l.f(getContext(), d.e.tbds6), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.dET == null || this.dEP == 0) {
            return 0;
        }
        return ((this.dET.getMeasuredWidth() - this.dEP) - this.dET.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void lB(int i) {
        a(ly(i));
    }

    public void setDataLoadInterface(ai aiVar) {
        this.dFg = aiVar;
    }

    public void setmShowMenuCallBack(c cVar) {
        this.dFh = cVar;
    }

    public c getmShowMenuCallBack() {
        return this.dFh;
    }

    public void setTabBackgroudColor(int i) {
        this.dEZ = i;
    }

    public void setAutoFillTabCount(int i) {
        this.dEX = i;
    }

    @Override // com.baidu.tieba.frs.tab.b
    public void lC(int i) {
        if (this.dET != null && this.dFg != null) {
            this.dFg.a(this.dET.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.dFc = aVar;
    }

    public void setOnTabItemSelectListener(b bVar) {
        this.dFd = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.dFa = z;
    }

    public static boolean lD(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.dEY = z;
        invalidate();
    }

    public void setSelectedItemColorResourceId(int i) {
        this.dFb = i;
    }
}
