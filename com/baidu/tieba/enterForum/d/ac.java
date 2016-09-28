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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private List<com.baidu.tieba.enterForum.b.g> aMf;
    private ViewEventCenter aPL;
    private View agA;
    private View bIg;
    private TextView bJg;
    private ImageView bJh;
    private View bJi;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aMf = new ArrayList();
        YM();
        addView(this.agA);
    }

    public int getItemViewCount() {
        return this.aMf.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aPL = viewEventCenter;
    }

    public void c(List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        r(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bJi != null) {
            if (z) {
                this.bJi.setVisibility(0);
            } else {
                this.bJi.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.g> list) {
        this.aMf.clear();
        if (list != null) {
            this.aMf.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.g gVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (gVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aPL);
            abVar.setData(gVar);
            abVar.q(tbPageContext);
            addView(abVar);
        }
    }

    private void YM() {
        this.agA = LayoutInflater.from(getContext()).inflate(r.h.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.agA.findViewById(r.g.iv_dismiss).setOnClickListener(new ad(this));
        this.bJi = this.agA.findViewById(r.g.enterforum_forumrecommendinfo_change);
        this.bJi.setOnClickListener(new ae(this));
        this.bJh = (ImageView) this.agA.findViewById(r.g.iv_dismiss);
        this.mEmptyView = this.agA.findViewById(r.g.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bJh.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bJh.setVisibility(8);
    }

    private void r(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aMf != null && this.aMf.size() != 0) {
            YP();
            YO();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aMf.size(); i++) {
                com.baidu.tieba.enterForum.b.g gVar = this.aMf.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(gVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(gVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aMf.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bJh.setVisibility(0);
                YP();
                YO();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bJh.setVisibility(8);
            YQ();
            YN();
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

    private void YN() {
        this.bIg = new View(getContext());
        this.bIg.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(getContext(), r.e.ds120)));
        this.bIg.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.bIg);
    }

    private void YO() {
        if (this.bIg != null) {
            removeView(this.bIg);
            this.bIg = null;
        }
    }

    private void YP() {
        if (this.bJg != null && indexOfChild(this.bJg) > -1) {
            removeView(this.bJg);
        }
    }

    private void YQ() {
        if (this.bJg == null) {
            this.bJg = new TextView(getContext());
            this.bJg.setText(r.j.discover_more_bar);
            this.bJg.setTextSize(0, getContext().getResources().getDimensionPixelSize(r.e.fontsize28));
            this.bJg.setGravity(17);
            av.c(this.bJg, r.d.cp_cont_i, 1);
            this.bJg.setBackgroundDrawable(av.getDrawable(r.f.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(r.e.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(r.e.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(r.e.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(r.e.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(r.e.ds50);
            this.bJg.setLayoutParams(layoutParams);
            this.bJg.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.bJg) == -1) {
            addView(this.bJg);
        }
        this.bJg.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void q(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this.agA);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ab) {
                ((ab) getChildAt(i2)).q(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.bJg != null) {
            av.c(this.bJg, r.d.cp_cont_i, 1);
            this.bJg.setBackgroundDrawable(av.getDrawable(r.f.btn_appdownload));
        }
    }
}
