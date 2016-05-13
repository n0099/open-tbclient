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
import com.baidu.tieba.frs.fg;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.ft;
import com.baidu.tieba.frs.tab.j;
import com.baidu.tieba.t;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTabView extends com.baidu.tbadk.widget.a.b implements g {
    private List<i> aIe;
    public int bsG;
    private final LinearLayout bsH;
    private final j bsI;
    private TabItemView bsJ;
    private g bsK;
    private final int bsL;
    private final int bsM;
    private int bsN;
    private boolean bsO;
    private int bsP;
    private j.b bsQ;
    private j.a bsR;
    private fg bsS;
    private a bsT;
    private View.OnClickListener mOnClickListener;
    private final Paint mPaint;

    /* loaded from: classes.dex */
    public interface a {
        void gy(int i);

        boolean gz(int i);
    }

    public void a(TabItemView tabItemView, boolean z) {
        fo foVar;
        int i = 0;
        if (gL(tabItemView.getTabId())) {
            if (this.bsS != null && !TextUtils.isEmpty(tabItemView.getUrl())) {
                fo foVar2 = new fo();
                foVar2.bmS = tabItemView.getUrl();
                this.bsS.a(tabItemView.getTabId(), -1, foVar2);
                return;
            }
            return;
        }
        this.bsJ = tabItemView;
        int[] iArr = new int[2];
        this.bsJ.getLocationOnScreen(iArr);
        int B = com.baidu.adp.lib.util.k.B(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(t.e.ds160);
        if (iArr[0] < 0) {
            post(new d(this, dimensionPixelSize));
        } else if (B < dimensionPixelSize) {
            post(new e(this));
        }
        for (int i2 = 0; i2 < this.bsH.getChildCount(); i2++) {
            View childAt = this.bsH.getChildAt(i2);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.bsJ.getTabId() && !gL(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.bsX);
                }
            }
        }
        if (this.bsJ.getState() == TabItemView.bsX || this.bsJ.getState() == TabItemView.bsZ) {
            this.bsI.Tz();
            boolean z2 = this.bsJ.getState() == TabItemView.bsX;
            this.bsJ.setState(TabItemView.bsY);
            i gH = gH(this.bsJ.getTabId());
            if (TextUtils.isEmpty(gH.url)) {
                foVar = null;
            } else {
                fo foVar3 = new fo();
                foVar3.bmS = gH.url;
                foVar3.stType = gH.name;
                foVar = foVar3;
            }
            if (gH.bsW != null && gH.bsW.bmd != null && gH.bsW.bmd.size() > 0) {
                for (ft ftVar : gH.bsW.bmd) {
                    if (ftVar != null && ftVar.isSelected) {
                        i = ftVar.blZ;
                    }
                }
            }
            if (z2 && this.bsS != null) {
                this.bsS.a(this.bsJ.getTabId(), i, foVar);
            }
        } else if (gI(this.bsJ.getTabId()) && !z) {
            if (this.bsT == null || this.bsT.gz(this.bsJ.getTabId())) {
                this.bsJ.setState(TabItemView.bsZ);
                this.bsI.a((Activity) getContext(), this, this.bsJ, gH(this.bsJ.getTabId()).bsW);
            } else {
                return;
            }
        }
        invalidate();
    }

    public HorizontalTabView(Activity activity) {
        super(activity);
        this.bsG = 0;
        this.bsJ = null;
        this.bsK = null;
        this.mPaint = new Paint();
        this.bsL = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.bsM = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.bsN = 0;
        this.bsO = true;
        this.bsP = t.d.frs_tab_bg;
        this.bsQ = new com.baidu.tieba.frs.tab.a(this);
        this.bsR = new b(this);
        this.mOnClickListener = new c(this);
        this.bsH = new LinearLayout(activity);
        this.bsH.setOrientation(0);
        this.bsH.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, activity.getResources().getDimensionPixelSize(t.e.ds80));
        this.bsI = new j(activity, this.bsQ, this.bsR);
        a(layoutParams);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsG = 0;
        this.bsJ = null;
        this.bsK = null;
        this.mPaint = new Paint();
        this.bsL = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.bsM = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.bsN = 0;
        this.bsO = true;
        this.bsP = t.d.frs_tab_bg;
        this.bsQ = new com.baidu.tieba.frs.tab.a(this);
        this.bsR = new b(this);
        this.mOnClickListener = new c(this);
        this.bsH = new LinearLayout(context);
        this.bsH.setOrientation(0);
        this.bsH.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(t.e.ds80));
        this.bsI = new j(context, this.bsQ, this.bsR);
        a(layoutParams);
    }

    public HorizontalTabView(Activity activity, int i) {
        super(activity);
        this.bsG = 0;
        this.bsJ = null;
        this.bsK = null;
        this.mPaint = new Paint();
        this.bsL = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds6);
        this.bsM = TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds1);
        this.bsN = 0;
        this.bsO = true;
        this.bsP = t.d.frs_tab_bg;
        this.bsQ = new com.baidu.tieba.frs.tab.a(this);
        this.bsR = new b(this);
        this.mOnClickListener = new c(this);
        this.bsH = new LinearLayout(activity);
        this.bsH.setOrientation(0);
        this.bsH.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, i);
        this.bsI = new j(activity, this.bsQ, this.bsR);
        a(layoutParams);
    }

    private void a(AbsListView.LayoutParams layoutParams) {
        addView(this.bsH, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        at.l(this, t.d.frs_tab_bg);
        setDescendantFocusability(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    private boolean aj(List<i> list) {
        i iVar;
        if (list == null) {
            return false;
        }
        i gH = gH(1);
        Iterator<i> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                iVar = null;
                break;
            }
            i next = it.next();
            if (next != null && next.aYo == 1) {
                iVar = next;
                break;
            }
        }
        if (gH == null || iVar == null) {
            return false;
        }
        if (gH.bsW == null && iVar.bsW == null) {
            return false;
        }
        if ((gH.bsW != null || iVar.bsW == null) && (iVar.bsW != null || gH.bsW == null)) {
            if (gH.bsW.bmd == null && iVar.bsW.bmd == null) {
                return false;
            }
            if ((gH.bsW.bmd != null || iVar.bsW.bmd == null) && (iVar.bsW.bmd != null || gH.bsW.bmd == null)) {
                int size = gH.bsW.bmd.size();
                if (size != iVar.bsW.bmd.size()) {
                    return true;
                }
                for (int i = 0; i < size; i++) {
                    ft ftVar = iVar.bsW.bmd.get(i);
                    ft ftVar2 = gH.bsW.bmd.get(i);
                    if (ftVar.blZ != ftVar2.blZ || !ftVar.name.equals(ftVar2.name)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public void setData(List<i> list) {
        a(list, 1, 4, false);
    }

    public void c(List<i> list, int i, int i2) {
        a(list, i, i2, false);
    }

    private void a(List<i> list, int i, int i2, boolean z) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
        } else if (this.aIe == null || aj(list)) {
            this.aIe = list;
            this.bsH.removeAllViews();
            boolean z2 = this.bsN > 0 && list.size() == this.bsN;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(t.e.ds160);
            if (z2) {
                dimensionPixelSize = com.baidu.adp.lib.util.k.B(getContext()) / this.bsN;
            }
            for (i iVar : list) {
                if (iVar != null) {
                    TabItemView tabItemView = new TabItemView(getContext(), iVar, i2);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, -1);
                    tabItemView.setOnClickListener(this.mOnClickListener);
                    if (gL(iVar.aYo)) {
                        at.j((View) tabItemView, t.d.cp_other_b);
                    }
                    this.bsH.addView(tabItemView, layoutParams);
                    if (iVar.aYo == i) {
                        this.bsJ = tabItemView;
                        tabItemView.setState(TabItemView.bsY);
                    }
                }
            }
        }
    }

    private i gH(int i) {
        if (i < 0 || this.aIe == null || this.aIe.size() == 0) {
            return null;
        }
        for (i iVar : this.aIe) {
            if (iVar != null && iVar.aYo == i) {
                return iVar;
            }
        }
        return null;
    }

    private boolean gI(int i) {
        i gH = gH(i);
        return (gH == null || gH.bsW == null || gH.bsW.bmd == null || gH.bsW.bmd.size() <= 0) ? false : true;
    }

    public void setFakeTab(g gVar) {
        this.bsK = gVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.bsJ != null) {
            this.mPaint.setColor(at.getColor(t.d.cp_bg_line_b));
            if (this.bsO) {
                canvas.drawRect(this.bsH.getLeft(), getMeasuredHeight() - this.bsM, this.bsH.getRight() > getRight() ? this.bsH.getRight() : getRight(), getMeasuredHeight(), this.mPaint);
            }
            this.mPaint.setColor(at.d((Resources) null, t.d.s_actionbar_text_line_color_s));
            canvas.drawRect(this.bsJ.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.bsL, (this.bsJ.getRight() - getBottomLineMargin()) - this.bsJ.getDrawableWidth(), getMeasuredHeight(), this.mPaint);
        }
    }

    private int getBottomLineMargin() {
        if (this.bsJ == null || this.bsG == 0) {
            return 0;
        }
        return ((this.bsJ.getMeasuredWidth() - this.bsG) - this.bsJ.getDrawableWidth()) / 2;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void gJ(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.bsH.getChildCount()) {
                View childAt = this.bsH.getChildAt(i3);
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

    public void setDataLoadInterface(fg fgVar) {
        this.bsS = fgVar;
    }

    public void setmShowMenuCallBack(a aVar) {
        this.bsT = aVar;
    }

    public a getmShowMenuCallBack() {
        return this.bsT;
    }

    public void setTabBackgroudColor(int i) {
        this.bsP = i;
    }

    public void vm() {
        at.l(this, this.bsP);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bsH.getChildCount()) {
                View childAt = this.bsH.getChildAt(i2);
                if (childAt instanceof TabItemView) {
                    if (gL(((TabItemView) childAt).getTabId())) {
                        at.j(childAt, t.d.cp_other_b);
                    } else {
                        ((TabItemView) childAt).vm();
                    }
                }
                i = i2 + 1;
            } else {
                this.bsI.vm();
                return;
            }
        }
    }

    public void setAutoFillTabCount(int i) {
        this.bsN = i;
    }

    @Override // com.baidu.tieba.frs.tab.g
    public void gK(int i) {
        if (this.bsJ != null && this.bsS != null) {
            this.bsS.a(this.bsJ.getTabId(), i, null);
        }
    }

    public static boolean gL(int i) {
        return i > 200 && i <= 300;
    }

    public void setNeedBottomLine(boolean z) {
        this.bsO = z;
        invalidate();
    }
}
