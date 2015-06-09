package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private View ZX;
    private ViewEventCenter aEU;
    private List<com.baidu.tieba.enterForum.b.e> aGO;
    private TextView aGP;
    private ImageView aGQ;
    private View aGR;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aGO = new ArrayList();
        He();
        addView(this.ZX);
    }

    public int getItemViewCount() {
        return this.aGO.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aEU = viewEventCenter;
    }

    public void a(List<com.baidu.tieba.enterForum.b.e> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        e(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.aGR != null) {
            if (z) {
                this.aGR.setVisibility(0);
            } else {
                this.aGR.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.e> list) {
        this.aGO.clear();
        if (list != null) {
            this.aGO.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.e eVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (eVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aEU);
            abVar.setData(eVar);
            abVar.d(tbPageContext);
            addView(abVar);
        }
    }

    private void He() {
        this.ZX = com.baidu.adp.lib.g.b.hr().inflate(getContext(), com.baidu.tieba.r.enter_forum_recommendinfo_notice, null);
        this.ZX.findViewById(com.baidu.tieba.q.iv_dismiss).setOnClickListener(new ad(this));
        this.aGR = this.ZX.findViewById(com.baidu.tieba.q.enterforum_forumrecommendinfo_change);
        this.aGR.setOnClickListener(new ae(this));
        this.aGQ = (ImageView) this.ZX.findViewById(com.baidu.tieba.q.iv_dismiss);
        this.mEmptyView = this.ZX.findViewById(com.baidu.tieba.q.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.aGQ.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.aGQ.setVisibility(8);
    }

    private void e(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aGO != null && this.aGO.size() != 0) {
            II();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aGO.size(); i++) {
                com.baidu.tieba.enterForum.b.e eVar = this.aGO.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(eVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(eVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aGO.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.aGQ.setVisibility(0);
                II();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.aGQ.setVisibility(8);
            IJ();
        }
    }

    private List<ab> getAllRecomItemView() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ab) {
                arrayList.add((ab) childAt);
            }
        }
        return arrayList;
    }

    private void II() {
        if (this.aGP != null) {
            removeView(this.aGP);
            this.aGP = null;
        }
    }

    private void IJ() {
        if (this.aGP == null) {
            this.aGP = new TextView(getContext());
            this.aGP.setText(com.baidu.tieba.t.discover_more_bar);
            this.aGP.setTextSize(0, getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.fontsize28));
            this.aGP.setGravity(17);
            ay.b(this.aGP, com.baidu.tieba.n.cp_cont_i, 1);
            this.aGP.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds50);
            this.aGP.setLayoutParams(layoutParams);
            this.aGP.setOnClickListener(new af(this));
            addView(this.aGP);
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this.ZX);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ab) {
                ((ab) getChildAt(i2)).d(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.aGP != null) {
            ay.b(this.aGP, com.baidu.tieba.n.cp_cont_i, 1);
            this.aGP.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.btn_appdownload));
        }
    }
}
