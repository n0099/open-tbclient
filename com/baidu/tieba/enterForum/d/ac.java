package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private ViewEventCenter aMG;
    private List<com.baidu.tieba.enterForum.b.e> aOB;
    private TextView aOC;
    private ImageView aOD;
    private View aOE;
    private View afi;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aOB = new ArrayList();
        HJ();
        addView(this.afi);
    }

    public int getItemViewCount() {
        return this.aOB.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aMG = viewEventCenter;
    }

    public void a(List<com.baidu.tieba.enterForum.b.e> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        f(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.aOE != null) {
            if (z) {
                this.aOE.setVisibility(0);
            } else {
                this.aOE.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.e> list) {
        this.aOB.clear();
        if (list != null) {
            this.aOB.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.e eVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (eVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aMG);
            abVar.setData(eVar);
            abVar.e(tbPageContext);
            addView(abVar);
        }
    }

    private void HJ() {
        this.afi = LayoutInflater.from(getContext()).inflate(i.g.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.afi.findViewById(i.f.iv_dismiss).setOnClickListener(new ad(this));
        this.aOE = this.afi.findViewById(i.f.enterforum_forumrecommendinfo_change);
        this.aOE.setOnClickListener(new ae(this));
        this.aOD = (ImageView) this.afi.findViewById(i.f.iv_dismiss);
        this.mEmptyView = this.afi.findViewById(i.f.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.aOD.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.aOD.setVisibility(8);
    }

    private void f(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aOB != null && this.aOB.size() != 0) {
            Jk();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aOB.size(); i++) {
                com.baidu.tieba.enterForum.b.e eVar = this.aOB.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(eVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(eVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aOB.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.aOD.setVisibility(0);
                Jk();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.aOD.setVisibility(8);
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                Jl();
            }
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

    private void Jk() {
        if (this.aOC != null) {
            removeView(this.aOC);
            this.aOC = null;
        }
    }

    private void Jl() {
        if (this.aOC == null) {
            this.aOC = new TextView(getContext());
            this.aOC.setText(i.h.discover_more_bar);
            this.aOC.setTextSize(0, getContext().getResources().getDimensionPixelSize(i.d.fontsize28));
            this.aOC.setGravity(17);
            al.b(this.aOC, i.c.cp_cont_i, 1);
            this.aOC.setBackgroundDrawable(al.getDrawable(i.e.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(i.d.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(i.d.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(i.d.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(i.d.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(i.d.ds50);
            this.aOC.setLayoutParams(layoutParams);
            this.aOC.setOnClickListener(new af(this));
            addView(this.aOC);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this.afi);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ab) {
                ((ab) getChildAt(i2)).e(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.aOC != null) {
            al.b(this.aOC, i.c.cp_cont_i, 1);
            this.aOC.setBackgroundDrawable(al.getDrawable(i.e.btn_appdownload));
        }
    }
}
