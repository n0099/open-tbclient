package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.bx;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.tab.k;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements h {
    private List<j> aWb;
    private TbPageContext bJY;
    public int bZc;
    private final LinearLayout bZd;
    private final k bZe;
    private List<j> bZf;
    private TabItemView bZg;
    private h bZh;
    private final int bZi;
    private final int bZj;
    private int bZk;
    private boolean bZl;
    private int bZm;
    private boolean bZn;
    private a bZo;
    private k.b bZp;
    private k.a bZq;
    private bx bZr;
    private b bZs;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void a(j jVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        void hY(int i);

        boolean hZ(int i);
    }

    public void acu() {
        cn cnVar;
        if (this.bJY != null) {
            ArrayList arrayList = new ArrayList();
            if (this.aWb != null && this.aWb.size() > 0 && this.aWb.get(0) != null && (cnVar = this.aWb.get(0).bZx) != null && cnVar.bQV != null) {
                for (cm cmVar : cnVar.bQV) {
                    if (cmVar != null) {
                        arrayList.add(cmVar.name);
                    }
                }
                com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(this.bJY.getPageActivity());
                cVar.a(arrayList, new d(this, cnVar));
                cVar.d(this.bJY);
                cVar.tg();
            }
        }
    }

    public j ir(int i) {
        if (!x.r(this.bZf)) {
            for (j jVar : this.bZf) {
                if (jVar != null && jVar.bZw == i) {
                    return jVar;
                }
            }
        }
        return null;
    }

    public void b(j jVar) {
        cd cdVar;
        if (jVar != null) {
            if (jVar.bZw == 49) {
                TiebaStatic.log("c11841");
            }
            if (iw(jVar.bZw)) {
                if (this.bZr != null && !TextUtils.isEmpty(jVar.url)) {
                    cd cdVar2 = new cd();
                    cdVar2.bRh = jVar.url;
                    this.bZr.a(jVar.bZw, -1, cdVar2);
                }
            } else if (jVar.bZw == 301) {
                if (this.bZr != null) {
                    this.bZr.a(jVar.bZw, -1, null);
                }
            } else {
                for (int i = 0; i < this.bZd.getChildCount(); i++) {
                    View childAt = this.bZd.getChildAt(i);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView = (TabItemView) childAt;
                        if (tabItemView.getTabId() == 1) {
                            tabItemView.setText(jVar.name);
                        }
                    }
                }
                if (TextUtils.isEmpty(jVar.url)) {
                    cdVar = null;
                } else {
                    cdVar = new cd();
                    cdVar.bRh = jVar.url;
                    cdVar.stType = jVar.name;
                }
                if (this.bZr != null) {
                    this.bZr.a(jVar.bZw, 0, cdVar);
                }
            }
        }
    }

    public void a(TabItemView tabItemView, boolean z) {
        cd cdVar = null;
        int i = 0;
        if (tabItemView != null) {
            if (tabItemView.getTabId() == 49) {
                TiebaStatic.log("c11841");
            }
            if (iw(tabItemView.getTabId())) {
                if (this.bZr != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                    cd cdVar2 = new cd();
                    cdVar2.bRh = tabItemView.getUrl();
                    this.bZr.a(tabItemView.getTabId(), -1, cdVar2);
                }
            } else if (tabItemView.getTabId() == 301) {
                if (this.bZr != null) {
                    this.bZr.a(tabItemView.getTabId(), -1, null);
                }
            } else {
                this.bZg = tabItemView;
                int[] iArr = new int[2];
                this.bZg.getLocationOnScreen(iArr);
                int af = com.baidu.adp.lib.util.k.af(getContext()) - iArr[0];
                int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds160);
                if (iArr[0] < 0) {
                    post(new e(this, dimensionPixelSize));
                } else if (af < dimensionPixelSize) {
                    post(new f(this));
                }
                for (int i2 = 0; i2 < this.bZd.getChildCount(); i2++) {
                    View childAt = this.bZd.getChildAt(i2);
                    if (childAt instanceof TabItemView) {
                        TabItemView tabItemView2 = (TabItemView) childAt;
                        if (tabItemView2.getTabId() != this.bZg.getTabId() && !iw(tabItemView2.getTabId())) {
                            tabItemView2.setState(TabItemView.bZy);
                        }
                    }
                }
                if (this.bZg.getState() == TabItemView.bZy || this.bZg.getState() == TabItemView.bZA) {
                    this.bZe.acx();
                    boolean z2 = this.bZg.getState() == TabItemView.bZy;
                    this.bZg.setState(TabItemView.bZz);
                    j is = is(this.bZg.getTabId());
                    if (is != null) {
                        if (!TextUtils.isEmpty(is.url)) {
                            cd cdVar3 = new cd();
                            cdVar3.bRh = is.url;
                            cdVar3.stType = is.name;
                            cdVar = cdVar3;
                        }
                        if (is.bZx != null && is.bZx.bQV != null && is.bZx.bQV.size() > 0) {
                            for (cm cmVar : is.bZx.bQV) {
                                if (cmVar != null && cmVar.isSelected) {
                                    i = cmVar.bQR;
                                }
                            }
                        }
                        if (z2 && this.bZr != null) {
                            this.bZr.a(this.bZg.getTabId(), i, cdVar);
                        }
                    } else {
                        return;
                    }
                } else if (it(this.bZg.getTabId()) && !z) {
                    if (this.bZs == null || this.bZs.hZ(this.bZg.getTabId())) {
                        this.bZg.setState(TabItemView.bZA);
                        this.bZe.a((Activity) getContext(), this, this.bZg, is(this.bZg.getTabId()).bZx);
                    } else {
                        return;
                    }
                }
                invalidate();
            }
        }
    }

    public HorizontalTabView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.bZc = 0;
        this.bZg = null;
        this.bZh = null;
        this.mPaint = new Paint();
        this.bZi = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.bZj = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.bZk = 0;
        this.bZl = true;
        this.bZm = w.e.transparent;
        this.bZp = new com.baidu.tieba.frs.tab.a(this);
        this.bZq = new com.baidu.tieba.frs.tab.b(this);
        this.mOnClickListener = new c(this);
        this.bJY = tbPageContext;
        this.bZd = new LinearLayout(tbPageContext.getPageActivity());
        this.bZd.setOrientation(0);
        this.bZd.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, tbPageContext.getResources().getDimensionPixelSize(w.f.ds88));
        this.bZe = new k(tbPageContext.getPageActivity(), this.bZp, this.bZq);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZc = 0;
        this.bZg = null;
        this.bZh = null;
        this.mPaint = new Paint();
        this.bZi = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.bZj = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.bZk = 0;
        this.bZl = true;
        this.bZm = w.e.transparent;
        this.bZp = new com.baidu.tieba.frs.tab.a(this);
        this.bZq = new com.baidu.tieba.frs.tab.b(this);
        this.mOnClickListener = new c(this);
        this.bZd = new LinearLayout(context);
        this.bZd.setOrientation(0);
        this.bZd.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(w.f.ds88));
        this.bZe = new k(context, this.bZp, this.bZq);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bZc = 0;
        this.bZg = null;
        this.bZh = null;
        this.mPaint = new Paint();
        this.bZi = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds6);
        this.bZj = TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds1);
        this.bZk = 0;
        this.bZl = true;
        this.bZm = w.e.transparent;
        this.bZp = new com.baidu.tieba.frs.tab.a(this);
        this.bZq = new com.baidu.tieba.frs.tab.b(this);
        this.mOnClickListener = new c(this);
        this.bZd = new LinearLayout(activity);
        this.bZd.setOrientation(0);
        this.bZd.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bZe = new k(activity, this.bZp, this.bZq);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bZd, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        aq.k(this, w.e.transparent);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean as(List<j> list) {
        j jVar;
        if (list == null) {
            return false;
        }
        j is = is(1);
        Iterator<j> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                jVar = null;
                break;
            }
            j next = it.next();
            if (next != null && next.bZw == 1) {
                jVar = next;
                break;
            }
        }
        if (is == null || jVar == null) {
            return false;
        }
        if (is.bZx == null && jVar.bZx == null) {
            return false;
        }
        if ((is.bZx != null || jVar.bZx == null) && (jVar.bZx != null || is.bZx == null)) {
            if (is.bZx == null || jVar.bZx == null) {
                return false;
            }
            if (is.bZx.bQV == null && jVar.bZx.bQV == null) {
                return false;
            }
            if ((is.bZx.bQV != null || jVar.bZx.bQV == null) && (jVar.bZx.bQV != null || is.bZx.bQV == null)) {
                int size = is.bZx.bQV.size();
                if (size != jVar.bZx.bQV.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    cm cmVar = jVar.bZx.bQV.get(i);
                    cm cmVar2 = is.bZx.bQV.get(i);
                    if (cmVar.bQR != cmVar2.bQR || !cmVar.name.equals(cmVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void d(List<j> list, int i, int i2) {
        j jVar;
        cn cnVar;
        if (this.bZn) {
            this.bZf = new ArrayList();
            this.bZf.addAll(list);
            if (list != null && list.size() > 0 && (jVar = list.get(0)) != null && jVar.bZw == 1) {
                cn cnVar2 = jVar.bZx;
                if (cnVar2 != null && cnVar2.bQV != null) {
                    cnVar2.bQV.clear();
                    cnVar = cnVar2;
                } else {
                    cn cnVar3 = new cn();
                    cnVar3.bQV = new ArrayList();
                    cnVar = cnVar3;
                }
                cm cmVar = new cm();
                cmVar.bQR = 1;
                cmVar.name = getContext().getString(w.l.chosen_pb_title);
                cnVar.bQV.add(cmVar);
                for (j jVar2 : list) {
                    if (jVar2 != null && jVar2.bZw != 1) {
                        cm cmVar2 = new cm();
                        cmVar2.bQR = jVar2.bZw;
                        cmVar2.name = jVar2.name;
                        cnVar.bQV.add(cmVar2);
                    }
                }
                jVar.bZx = cnVar;
                list.clear();
                list.add(jVar);
            }
        } else {
            this.bZf = list;
        }
        a(list, i, i2, false);
    }

    private void a(List<j> list, int i, int i2, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        int i3 = 0;
        if (this.bZk > 0 && list.size() == this.bZk) {
            layoutParams = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.k.af(getContext()) / this.bZk, -1);
        } else {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(w.f.ds15);
            layoutParams2.leftMargin = dimensionPixelSize;
            layoutParams2.rightMargin = dimensionPixelSize;
            layoutParams = layoutParams2;
        }
        if (list == null || list.size() == 0) {
            this.aWb = null;
            j jVar = new j();
            jVar.bZw = 1;
            jVar.name = getContext().getResources().getString(w.l.chosen_pb_title);
            this.bZd.removeAllViews();
            TabItemView tabItemView = new TabItemView(getContext(), jVar, i2, this.bZn);
            tabItemView.setOnClickListener(this.mOnClickListener);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
            this.bZd.addView(tabItemView, layoutParams);
            this.bZg = tabItemView;
            tabItemView.setState(TabItemView.bZz);
            return;
        }
        setVisibility(0);
        if (this.aWb == null || as(list)) {
            this.aWb = list;
            this.bZd.removeAllViews();
            while (true) {
                int i4 = i3;
                if (i4 < list.size()) {
                    j jVar2 = list.get(i4);
                    if (jVar2 != null) {
                        TabItemView tabItemView2 = new TabItemView(getContext(), jVar2, i2, this.bZn);
                        tabItemView2.setOnClickListener(this.mOnClickListener);
                        if (iw(jVar2.bZw)) {
                            aq.i(tabItemView2, w.e.cp_cont_b);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds32);
                        }
                        this.bZd.addView(tabItemView2, layoutParams);
                        if (jVar2.bZw == i) {
                            this.bZg = tabItemView2;
                            tabItemView2.setState(TabItemView.bZz);
                        }
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private j is(int i) {
        if (i < 0 || this.bZf == null || this.bZf.size() == 0) {
            return null;
        }
        for (j jVar : this.bZf) {
            if (jVar != null && jVar.bZw == i) {
                return jVar;
            }
        }
        return null;
    }

    private boolean it(int i) {
        j is = is(i);
        return (is == null || is.bZx == null || is.bZx.bQV == null || is.bZx.bQV.size() <= 0) ? false : true;
    }

    public void setFakeTab(h hVar) {
        this.bZh = hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bZg != null) {
            this.mPaint.setColor(aq.getColor(w.e.cp_bg_line_b));
            if (this.bZl) {
                canvas.drawRect(this.bZd.getLeft(), getMeasuredHeight() - this.bZj, this.bZd.getRight() > getRight() ? this.bZd.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            if (!this.bZn) {
                this.mPaint.setColor(aq.d((Resources) null, w.e.cp_link_tip_a));
                canvas.drawRect(this.bZg.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.bZi, (this.bZg.getRight() - getBottomLineMargin()) - this.bZg.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
            }
        }
        if (this.bZn) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(aq.d((Resources) null, w.e.cp_cont_b));
            int g = com.baidu.adp.lib.util.k.g(getContext(), w.f.ds96);
            if (this.bZg != null) {
                g = this.bZg.getRight() - this.bZg.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(com.baidu.adp.lib.util.k.g(getContext(), w.f.ds32), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds72), g, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds76)), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), com.baidu.adp.lib.util.k.g(getContext(), w.f.ds4), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.bZg == null || this.bZc == 0) {
            return 0;
        }
        return ((this.bZg.getMeasuredWidth() - this.bZc) - this.bZg.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void iu(int i) {
        b(ir(i));
    }

    public void setDataLoadInterface(bx bxVar) {
        this.bZr = bxVar;
    }

    public void setmShowMenuCallBack(b bVar) {
        this.bZs = bVar;
    }

    public b getmShowMenuCallBack() {
        return this.bZs;
    }

    public void setTabBackgroudColor(int i) {
        this.bZm = i;
    }

    public void ww() {
        aq.k(this, this.bZm);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bZd.getChildCount()) {
                View childAt = this.bZd.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (iw(((TabItemView) childAt).getTabId())) {
                        aq.i(childAt, w.e.cp_cont_b);
                    } else {
                        ((TabItemView) childAt).ww();
                    }
                }
                i = i2 + 1;
            } else {
                this.bZe.ww();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bZk = i;
    }

    @Override // com.baidu.tieba.frs.tab.h
    public void iv(int i) {
        if (this.bZg != null && this.bZr != null) {
            this.bZr.a(this.bZg.getTabId(), i, null);
        }
    }

    public void setOnTabItemClickListener(a aVar) {
        this.bZo = aVar;
    }

    public void setForNewFrame(boolean z) {
        this.bZn = z;
    }

    public static boolean iw(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.bZl = z;
        invalidate();
    }
}
