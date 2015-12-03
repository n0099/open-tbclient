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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.frs.tab.i;
import com.baidu.tieba.n;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.horizonalScrollListView.g implements g {
    private View.OnTouchListener bde;
    private final LinearLayout bif;
    private final i bih;
    private TabItemView bii;
    private g bij;
    private final int bik;
    private final int bil;
    private int bim;
    private i.a bin;
    private et bio;
    private a bip;
    private List<h> mData;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void gx(int i);

        boolean gy(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        ew ewVar;
        int i = 0;
        this.bii = tabItemView;
        int[] iArr = new int[2];
        this.bii.getLocationOnScreen(iArr);
        int K = com.baidu.adp.lib.util.k.K(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(n.d.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (K < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.bif.getChildCount(); i2++) {
            View childAt = this.bif.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.bii.getTabId()) {
                    tabItemView2.setState(TabItemView.biu);
                }
            }
        }
        if (this.bii.getState() == TabItemView.biu || this.bii.getState() == TabItemView.biw) {
            boolean z2 = this.bii.getState() == TabItemView.biu;
            this.bii.setState(TabItemView.biv);
            h gs = gs(this.bii.getTabId());
            if (TextUtils.isEmpty(gs.url)) {
                ewVar = null;
            } else {
                ew ewVar2 = new ew();
                ewVar2.bfp = gs.url;
                ewVar2.stType = gs.name;
                ewVar = ewVar2;
            }
            if (gs.bit != null && gs.bit.beJ != null && gs.bit.beJ.size() > 0) {
                for (fc fcVar : gs.bit.beJ) {
                    if (fcVar != null && fcVar.isSelected) {
                        i = fcVar.beF;
                    }
                }
            }
            if (z2 && this.bio != null) {
                this.bio.a(this.bii.getTabId(), i, ewVar);
            }
        } else if (gt(this.bii.getTabId()) && !z) {
            if (this.bip == null || this.bip.gy(this.bii.getTabId())) {
                this.bii.setState(TabItemView.biw);
                this.bih.a((Activity) getContext(), this, this.bii, gs(this.bii.getTabId()).bit);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.bii = null;
        this.bij = null;
        this.mPaint = new Paint();
        this.bik = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds6);
        this.bil = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds1);
        this.bim = 0;
        this.bin = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.bde = new c(this);
        this.bif = new LinearLayout(activity);
        this.bif.setOrientation(0);
        this.bif.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(n.d.ds80));
        this.bih = new i(activity, this.bin);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bii = null;
        this.bij = null;
        this.mPaint = new Paint();
        this.bik = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds6);
        this.bil = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds1);
        this.bim = 0;
        this.bin = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.bde = new c(this);
        this.bif = new LinearLayout(context);
        this.bif.setOrientation(0);
        this.bif.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(n.d.ds80));
        this.bih = new i(context, this.bin);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bii = null;
        this.bij = null;
        this.mPaint = new Paint();
        this.bik = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds6);
        this.bil = TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds1);
        this.bim = 0;
        this.bin = new com.baidu.tieba.frs.tab.a(this);
        this.mOnClickListener = new b(this);
        this.bde = new c(this);
        this.bif = new LinearLayout(activity);
        this.bif.setOrientation(0);
        this.bif.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bih = new i(activity, this.bin);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bif, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        as.j(this, n.c.frs_tab_bg);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public void setData(List<h> list, int i) {
        a(list, i, false);
    }

    public void a(List<h> list, int i, boolean z) {
        boolean z2 = true;
        if (list == null || list.size() == 0) {
            setVisibility(8);
        } else if (this.mData == null || aj(list)) {
            this.mData = list;
            this.bif.removeAllViews();
            boolean z3 = this.bim > 0 && list.size() == this.bim;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(n.d.ds160);
            if (z3) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.K(getContext()) / this.bim;
            }
            for (h hVar : list) {
                if (hVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), hVar, i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
                    if (z) {
                        tabItemView.setOnTouchListener(this.bde);
                    } else {
                        tabItemView.setOnClickListener(this.mOnClickListener);
                    }
                    this.bif.addView(tabItemView, layoutParams);
                    if (z2) {
                        this.bii = tabItemView;
                        tabItemView.setState(TabItemView.biv);
                        z2 = false;
                    }
                }
            }
        }
    }

    private boolean aj(List<h> list) {
        h hVar;
        h gs = gs(1);
        Iterator<h> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                hVar = null;
                break;
            }
            h next = it.next();
            if (next.bis == 1) {
                hVar = next;
                break;
            }
        }
        if (gs == null || hVar == null) {
            return false;
        }
        if (gs.bit == null && hVar.bit == null) {
            return false;
        }
        if ((gs.bit != null || hVar.bit == null) && (hVar.bit != null || gs.bit == null)) {
            if (gs.bit.beJ == null && hVar.bit.beJ == null) {
                return false;
            }
            if ((gs.bit.beJ != null || hVar.bit.beJ == null) && (hVar.bit.beJ != null || gs.bit.beJ == null)) {
                int size = gs.bit.beJ.size();
                if (size != hVar.bit.beJ.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    fc fcVar = hVar.bit.beJ.get(i);
                    fc fcVar2 = gs.bit.beJ.get(i);
                    if (fcVar.beF != fcVar2.beF || !fcVar.name.equals(fcVar2.name)) {
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

    private h gs(int i) {
        if (i < 0 || this.mData == null || this.mData.size() == 0) {
            return null;
        }
        for (h hVar : this.mData) {
            if (hVar != null && hVar.bis == i) {
                return hVar;
            }
        }
        return null;
    }

    private boolean gt(int i) {
        h gs = gs(i);
        return (gs == null || gs.bit == null || gs.bit.beJ == null || gs.bit.beJ.size() <= 0) ? false : true;
    }

    public boolean Ph() {
        return (this.mData == null || this.mData.size() == 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.bij = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bii != null) {
            this.mPaint.setColor(as.getColor(n.c.cp_bg_line_b));
            canvas.drawRect(this.bif.getLeft(), getMeasuredHeight() - this.bil, this.bif.getRight() > getRight() ? this.bif.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            this.mPaint.setColor(as.d((Resources) null, n.c.s_actionbar_text_line_color_s));
            canvas.drawRect(this.bii.getLeft(), getMeasuredHeight() - this.bik, this.bii.getRight(), getMeasuredHeight(), this.mPaint);
        }
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void gu(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bif.getChildCount()) {
                View childAt = this.bif.getChildAt(i3);
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

    public void setDataLoadInterface(et etVar) {
        this.bio = etVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.bip = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.bip;
    }

    public void wh() {
        as.j(this, n.c.frs_tab_bg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bif.getChildCount()) {
                View childAt = this.bif.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    ((TabItemView) childAt).wh();
                }
                i = i2 + 1;
            } else {
                this.bih.wh();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bim = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void gv(int i) {
        if (this.bii != null && this.bio != null) {
            this.bio.a(this.bii.getTabId(), i, null);
        }
    }
}
