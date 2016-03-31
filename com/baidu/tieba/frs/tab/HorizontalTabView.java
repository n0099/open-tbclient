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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fq;
import com.baidu.tieba.frs.fu;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.h implements g {
    private List<h> aLU;
    private final LinearLayout btM;
    private final i btN;
    private TabItemView btO;
    private g btP;
    private final int btQ;
    private final int btR;
    private int btS;
    private i.b btT;
    private i.a btU;
    private fo btV;
    private a btW;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void hf(int i);

        boolean hg(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        fq fqVar;
        int i = 0;
        if (hd(tabItemView.getTabId())) {
            if (this.btV != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                fq fqVar2 = new fq();
                fqVar2.brs = tabItemView.getUrl();
                this.btV.a(tabItemView.getTabId(), -1, fqVar2);
                return;
            }
            return;
        }
        this.btO = tabItemView;
        int[] iArr = new int[2];
        this.btO.getLocationOnScreen(iArr);
        int B = com.baidu.adp.lib.util.k.B(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(t.e.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (B < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.btM.getChildCount(); i2++) {
            View childAt = this.btM.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.btO.getTabId() && !hd(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.bub);
                }
            }
        }
        if (this.btO.getState() == TabItemView.bub || this.btO.getState() == TabItemView.bud) {
            this.btN.Tt();
            boolean z2 = this.btO.getState() == TabItemView.bub;
            this.btO.setState(TabItemView.buc);
            h gZ = gZ(this.btO.getTabId());
            if (TextUtils.isEmpty(gZ.url)) {
                fqVar = null;
            } else {
                fq fqVar3 = new fq();
                fqVar3.brs = gZ.url;
                fqVar3.stType = gZ.name;
                fqVar = fqVar3;
            }
            if (gZ.bua != null && gZ.bua.bqQ != null && gZ.bua.bqQ.size() > 0) {
                for (fu fuVar : gZ.bua.bqQ) {
                    if (fuVar != null && fuVar.isSelected) {
                        i = fuVar.bqM;
                    }
                }
            }
            if (z2 && this.btV != null) {
                this.btV.a(this.btO.getTabId(), i, fqVar);
            }
        } else if (ha(this.btO.getTabId()) && !z) {
            if (this.btW == null || this.btW.hg(this.btO.getTabId())) {
                this.btO.setState(TabItemView.bud);
                this.btN.a((Activity) getContext(), this, this.btO, gZ(this.btO.getTabId()).bua);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.btO = null;
        this.btP = null;
        this.mPaint = new Paint();
        this.btQ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.btR = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.btS = 0;
        this.btT = new com.baidu.tieba.frs.tab.a(this);
        this.btU = new b(this);
        this.mOnClickListener = new c(this);
        this.btM = new LinearLayout(activity);
        this.btM.setOrientation(0);
        this.btM.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(t.e.ds80));
        this.btN = new i(activity, this.btT, this.btU);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btO = null;
        this.btP = null;
        this.mPaint = new Paint();
        this.btQ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.btR = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.btS = 0;
        this.btT = new com.baidu.tieba.frs.tab.a(this);
        this.btU = new b(this);
        this.mOnClickListener = new c(this);
        this.btM = new LinearLayout(context);
        this.btM.setOrientation(0);
        this.btM.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(t.e.ds80));
        this.btN = new i(context, this.btT, this.btU);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.btO = null;
        this.btP = null;
        this.mPaint = new Paint();
        this.btQ = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.btR = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.btS = 0;
        this.btT = new com.baidu.tieba.frs.tab.a(this);
        this.btU = new b(this);
        this.mOnClickListener = new c(this);
        this.btM = new LinearLayout(activity);
        this.btM.setOrientation(0);
        this.btM.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.btN = new i(activity, this.btT, this.btU);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.btM, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        at.l(this, t.d.frs_tab_bg);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public void c(List<h> list, int i, int i2) {
        a(list, i, i2, false);
    }

    public void a(List<h> list, int i, int i2, boolean z) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
        } else if (this.aLU == null || al(list)) {
            this.aLU = list;
            this.btM.removeAllViews();
            boolean z2 = this.btS > 0 && list.size() == this.btS;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(t.e.ds160);
            if (z2) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.B(getContext()) / this.btS;
            }
            for (h hVar : list) {
                if (hVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), hVar, i2);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
                    tabItemView.setOnClickListener(this.mOnClickListener);
                    if (hd(hVar.btZ)) {
                        at.j((View) tabItemView, t.d.cp_other_b);
                    }
                    this.btM.addView(tabItemView, layoutParams);
                    if (hVar.btZ == i) {
                        this.btO = tabItemView;
                        tabItemView.setState(TabItemView.buc);
                    }
                }
            }
        }
    }

    private boolean al(List<h> list) {
        h hVar;
        if (list == null) {
            return false;
        }
        h gZ = gZ(1);
        Iterator<h> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                hVar = null;
                break;
            }
            h next = it.next();
            if (next.btZ == 1) {
                hVar = next;
                break;
            }
        }
        if (gZ == null || hVar == null) {
            return false;
        }
        if (gZ.bua == null && hVar.bua == null) {
            return false;
        }
        if ((gZ.bua != null || hVar.bua == null) && (hVar.bua != null || gZ.bua == null)) {
            if (gZ.bua.bqQ == null && hVar.bua.bqQ == null) {
                return false;
            }
            if ((gZ.bua.bqQ != null || hVar.bua.bqQ == null) && (hVar.bua.bqQ != null || gZ.bua.bqQ == null)) {
                int size = gZ.bua.bqQ.size();
                if (size != hVar.bua.bqQ.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    fu fuVar = hVar.bua.bqQ.get(i);
                    fu fuVar2 = gZ.bua.bqQ.get(i);
                    if (fuVar.bqM != fuVar2.bqM || !fuVar.name.equals(fuVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void g(List<h> list, int i) {
        a(list, i, 4, false);
    }

    private h gZ(int i) {
        if (i < 0 || this.aLU == null || this.aLU.size() == 0) {
            return null;
        }
        for (h hVar : this.aLU) {
            if (hVar != null && hVar.btZ == i) {
                return hVar;
            }
        }
        return null;
    }

    private boolean ha(int i) {
        h gZ = gZ(i);
        return (gZ == null || gZ.bua == null || gZ.bua.bqQ == null || gZ.bua.bqQ.size() <= 0) ? false : true;
    }

    public boolean Tr() {
        return (this.aLU == null || this.aLU.size() == 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.btP = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.btO != null) {
            this.mPaint.setColor(at.getColor(t.d.cp_bg_line_b));
            canvas.drawRect(this.btM.getLeft(), getMeasuredHeight() - this.btR, this.btM.getRight() > getRight() ? this.btM.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            this.mPaint.setColor(at.d((Resources) null, t.d.s_actionbar_text_line_color_s));
            canvas.drawRect(this.btO.getLeft(), getMeasuredHeight() - this.btQ, this.btO.getRight(), getMeasuredHeight(), this.mPaint);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void hb(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.btM.getChildCount()) {
                View childAt = this.btM.getChildAt(i3);
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

    public void setDataLoadInterface(fo foVar) {
        this.btV = foVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.btW = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.btW;
    }

    public void xy() {
        at.l(this, t.d.frs_tab_bg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.btM.getChildCount()) {
                View childAt = this.btM.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (hd(((TabItemView) childAt).getTabId())) {
                        at.j(childAt, t.d.cp_other_b);
                    } else {
                        ((TabItemView) childAt).xy();
                    }
                }
                i = i2 + 1;
            } else {
                this.btN.xy();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.btS = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void hc(int i) {
        if (this.btO != null && this.btV != null) {
            this.btV.a(this.btO.getTabId(), i, null);
        }
    }

    public static boolean hd(int i) {
        return i > 200 && i <= 300;
    }
}
