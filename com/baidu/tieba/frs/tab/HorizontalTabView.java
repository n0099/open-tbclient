package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.fh;
import com.baidu.tieba.frs.fm;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.h implements g {
    private List<h> aIY;
    private View.OnTouchListener bjS;
    private final LinearLayout boL;
    private final i boM;
    private TabItemView boN;
    private g boO;
    private final int boP;
    private final int boQ;
    private int boR;
    private i.a boS;
    private fe boT;
    private a boU;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void gN(int i);

        boolean gO(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        fh fhVar;
        int i = 0;
        this.boN = tabItemView;
        int[] iArr = new int[2];
        this.boN.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(t.e.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.boL.getChildCount(); i2++) {
            View childAt = this.boL.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.boN.getTabId()) {
                    tabItemView2.setState(TabItemView.boZ);
                }
            }
        }
        if (this.boN.getState() == TabItemView.boZ || this.boN.getState() == TabItemView.bpb) {
            boolean z2 = this.boN.getState() == TabItemView.boZ;
            this.boN.setState(TabItemView.bpa);
            h gI = gI(this.boN.getTabId());
            if (TextUtils.isEmpty(gI.url)) {
                fhVar = null;
            } else {
                fh fhVar2 = new fh();
                fhVar2.bmd = gI.url;
                fhVar2.stType = gI.name;
                fhVar = fhVar2;
            }
            if (gI.boY != null && gI.boY.bly != null && gI.boY.bly.size() > 0) {
                for (fm fmVar : gI.boY.bly) {
                    if (fmVar != null && fmVar.isSelected) {
                        i = fmVar.blu;
                    }
                }
            }
            if (z2 && this.boT != null) {
                this.boT.a(this.boN.getTabId(), i, fhVar);
            }
        } else if (gJ(this.boN.getTabId()) && !z) {
            if (this.boU == null || this.boU.gO(this.boN.getTabId())) {
                this.boN.setState(TabItemView.bpb);
                this.boM.a((Activity) getContext(), this, this.boN, gI(this.boN.getTabId()).boY);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.boN = null;
        this.boO = null;
        this.mPaint = new Paint();
        this.boP = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.boQ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.boR = 0;
        this.boS = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.bjS = new c(this);
        this.boL = new LinearLayout(activity);
        this.boL.setOrientation(0);
        this.boL.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(t.e.ds80));
        this.boM = new i(activity, this.boS);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.boN = null;
        this.boO = null;
        this.mPaint = new Paint();
        this.boP = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.boQ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.boR = 0;
        this.boS = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.bjS = new c(this);
        this.boL = new LinearLayout(context);
        this.boL.setOrientation(0);
        this.boL.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(t.e.ds80));
        this.boM = new i(context, this.boS);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.boN = null;
        this.boO = null;
        this.mPaint = new Paint();
        this.boP = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.boQ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.boR = 0;
        this.boS = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.bjS = new c(this);
        this.boL = new LinearLayout(activity);
        this.boL.setOrientation(0);
        this.boL.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.boM = new i(activity, this.boS);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.boL, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        ar.l(this, t.d.frs_tab_bg);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public void d(List<h> list, int i) {
        a(list, i, false);
    }

    public void a(List<h> list, int i, boolean z) {
        boolean z2 = true;
        if (list == null || list.size() == 0) {
            setVisibility(8);
        } else if (this.aIY == null || ah(list)) {
            this.aIY = list;
            this.boL.removeAllViews();
            boolean z3 = this.boR > 0 && list.size() == this.boR;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(t.e.ds160);
            if (z3) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.boR;
            }
            for (h hVar : list) {
                if (hVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), hVar, i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
                    if (z) {
                        tabItemView.setOnTouchListener(this.bjS);
                    } else {
                        tabItemView.setOnClickListener(this.mOnClickListener);
                    }
                    this.boL.addView(tabItemView, layoutParams);
                    if (z2) {
                        this.boN = tabItemView;
                        tabItemView.setState(TabItemView.bpa);
                        z2 = false;
                    }
                }
            }
        }
    }

    private boolean ah(List<h> list) {
        h hVar;
        h gI = gI(1);
        Iterator<h> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                hVar = null;
                break;
            }
            h next = it.next();
            if (next.boX == 1) {
                hVar = next;
                break;
            }
        }
        if (gI == null || hVar == null) {
            return false;
        }
        if (gI.boY == null && hVar.boY == null) {
            return false;
        }
        if ((gI.boY != null || hVar.boY == null) && (hVar.boY != null || gI.boY == null)) {
            if (gI.boY.bly == null && hVar.boY.bly == null) {
                return false;
            }
            if ((gI.boY.bly != null || hVar.boY.bly == null) && (hVar.boY.bly != null || gI.boY.bly == null)) {
                int size = gI.boY.bly.size();
                if (size != hVar.boY.bly.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    fm fmVar = hVar.boY.bly.get(i);
                    fm fmVar2 = gI.boY.bly.get(i);
                    if (fmVar.blu != fmVar2.blu || !fmVar.name.equals(fmVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void setData(List<h> list) {
        a(list, 4, false);
    }

    private h gI(int i) {
        if (i < 0 || this.aIY == null || this.aIY.size() == 0) {
            return null;
        }
        for (h hVar : this.aIY) {
            if (hVar != null && hVar.boX == i) {
                return hVar;
            }
        }
        return null;
    }

    private boolean gJ(int i) {
        h gI = gI(i);
        return (gI == null || gI.boY == null || gI.boY.bly == null || gI.boY.bly.size() <= 0) ? false : true;
    }

    public boolean RD() {
        return (this.aIY == null || this.aIY.size() == 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.boO = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.boN != null) {
            this.mPaint.setColor(ar.getColor(t.d.cp_bg_line_b));
            canvas.drawRect(this.boL.getLeft(), getMeasuredHeight() - this.boQ, this.boL.getRight() > getRight() ? this.boL.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            this.mPaint.setColor(ar.d((Resources) null, t.d.s_actionbar_text_line_color_s));
            canvas.drawRect(this.boN.getLeft(), getMeasuredHeight() - this.boP, this.boN.getRight(), getMeasuredHeight(), this.mPaint);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void gK(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.boL.getChildCount()) {
                View childAt = this.boL.getChildAt(i3);
                if (childAt instanceof TabItemView) {
                    TabItemView tabItemView = (TabItemView) childAt;
                    if (tabItemView.getTabId() == i) {
                        a(tabItemView, true);
                    }
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public void setDataLoadInterface(fe feVar) {
        this.boT = feVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.boU = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.boU;
    }

    public void xf() {
        ar.l(this, t.d.frs_tab_bg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.boL.getChildCount()) {
                View childAt = this.boL.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    ((TabItemView) childAt).xf();
                }
                i = i2 + 1;
            } else {
                this.boM.xf();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.boR = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void gL(int i) {
        if (this.boN != null && this.boT != null) {
            this.boT.a(this.boN.getTabId(), i, null);
        }
    }
}
