package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private List<com.baidu.tieba.enterForum.b.g> aNw;
    private ViewEventCenter aRj;
    private View agt;
    private View brd;
    private TextView bsd;
    private ImageView bse;
    private View bsf;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aNw = new ArrayList();
        Ub();
        addView(this.agt);
    }

    public int getItemViewCount() {
        return this.aNw.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aRj = viewEventCenter;
    }

    public void c(List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        t(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bsf != null) {
            if (z) {
                this.bsf.setVisibility(0);
            } else {
                this.bsf.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.g> list) {
        this.aNw.clear();
        if (list != null) {
            this.aNw.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.g gVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (gVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aRj);
            abVar.setData(gVar);
            abVar.s(tbPageContext);
            addView(abVar);
        }
    }

    private void Ub() {
        this.agt = LayoutInflater.from(getContext()).inflate(r.h.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.agt.findViewById(r.g.iv_dismiss).setOnClickListener(new ad(this));
        this.bsf = this.agt.findViewById(r.g.enterforum_forumrecommendinfo_change);
        this.bsf.setOnClickListener(new ae(this));
        this.bse = (ImageView) this.agt.findViewById(r.g.iv_dismiss);
        this.mEmptyView = this.agt.findViewById(r.g.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bse.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bse.setVisibility(8);
    }

    private void t(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aNw != null && this.aNw.size() != 0) {
            Ue();
            Ud();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aNw.size(); i++) {
                com.baidu.tieba.enterForum.b.g gVar = this.aNw.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(gVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(gVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aNw.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bse.setVisibility(0);
                Ue();
                Ud();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bse.setVisibility(8);
            Uf();
            Uc();
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

    private void Uc() {
        this.brd = new View(getContext());
        this.brd.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(getContext(), r.e.ds120)));
        this.brd.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.brd);
    }

    private void Ud() {
        if (this.brd != null) {
            removeView(this.brd);
            this.brd = null;
        }
    }

    private void Ue() {
        if (this.bsd != null && indexOfChild(this.bsd) > -1) {
            removeView(this.bsd);
        }
    }

    private void Uf() {
        if (this.bsd == null) {
            this.bsd = new TextView(getContext());
            this.bsd.setText(r.j.discover_more_bar);
            this.bsd.setTextSize(0, getContext().getResources().getDimensionPixelSize(r.e.fontsize28));
            this.bsd.setGravity(17);
            ar.c(this.bsd, r.d.cp_cont_i, 1);
            this.bsd.setBackgroundDrawable(ar.getDrawable(r.f.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(r.e.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(r.e.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(r.e.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(r.e.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(r.e.ds50);
            this.bsd.setLayoutParams(layoutParams);
            this.bsd.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.bsd) == -1) {
            addView(this.bsd);
        }
        this.bsd.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void s(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this.agt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ab) {
                ((ab) getChildAt(i2)).s(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.bsd != null) {
            ar.c(this.bsd, r.d.cp_cont_i, 1);
            this.bsd.setBackgroundDrawable(ar.getDrawable(r.f.btn_appdownload));
        }
    }
}
