package com.baidu.tieba.enterForum.view;

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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private List<com.baidu.tieba.enterForum.b.g> aKa;
    private View adl;
    private ViewEventCenter bgJ;
    private View bwQ;
    private TextView bxQ;
    private ImageView bxR;
    private View bxS;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aKa = new ArrayList();
        TL();
        addView(this.adl);
    }

    public int getItemViewCount() {
        return this.aKa.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bgJ = viewEventCenter;
    }

    public void c(List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        o(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bxS != null) {
            if (z) {
                this.bxS.setVisibility(0);
            } else {
                this.bxS.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.g> list) {
        this.aKa.clear();
        if (list != null) {
            this.aKa.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.g gVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (gVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.bgJ);
            abVar.setData(gVar);
            abVar.n(tbPageContext);
            addView(abVar);
        }
    }

    private void TL() {
        this.adl = LayoutInflater.from(getContext()).inflate(u.h.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.adl.findViewById(u.g.iv_dismiss).setOnClickListener(new ad(this));
        this.bxS = this.adl.findViewById(u.g.enterforum_forumrecommendinfo_change);
        this.bxS.setOnClickListener(new ae(this));
        this.bxR = (ImageView) this.adl.findViewById(u.g.iv_dismiss);
        this.mEmptyView = this.adl.findViewById(u.g.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bxR.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bxR.setVisibility(8);
    }

    private void o(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aKa != null && this.aKa.size() != 0) {
            TO();
            TN();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aKa.size(); i++) {
                com.baidu.tieba.enterForum.b.g gVar = this.aKa.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(gVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(gVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aKa.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bxR.setVisibility(0);
                TO();
                TN();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bxR.setVisibility(8);
            TP();
            TM();
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

    private void TM() {
        this.bwQ = new View(getContext());
        this.bwQ.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(getContext(), u.e.ds120)));
        this.bwQ.setVisibility(TbadkCoreApplication.m10getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.bwQ);
    }

    private void TN() {
        if (this.bwQ != null) {
            removeView(this.bwQ);
            this.bwQ = null;
        }
    }

    private void TO() {
        if (this.bxQ != null && indexOfChild(this.bxQ) > -1) {
            removeView(this.bxQ);
        }
    }

    private void TP() {
        if (this.bxQ == null) {
            this.bxQ = new TextView(getContext());
            this.bxQ.setText(u.j.discover_more_bar);
            this.bxQ.setTextSize(0, getContext().getResources().getDimensionPixelSize(u.e.fontsize28));
            this.bxQ.setGravity(17);
            av.c(this.bxQ, u.d.cp_cont_i, 1);
            this.bxQ.setBackgroundDrawable(av.getDrawable(u.f.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(u.e.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(u.e.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(u.e.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(u.e.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(u.e.ds50);
            this.bxQ.setLayoutParams(layoutParams);
            this.bxQ.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.bxQ) == -1) {
            addView(this.bxQ);
        }
        this.bxQ.setVisibility(TbadkCoreApplication.m10getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void TQ() {
        if (indexOfChild(this.bxQ) >= 0) {
            this.bxQ.setVisibility(0);
        }
    }

    public void TR() {
        if (indexOfChild(this.bwQ) >= 0) {
            this.bwQ.setVisibility(0);
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this.adl);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ab) {
                ((ab) getChildAt(i2)).n(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.bxQ != null) {
            av.c(this.bxQ, u.d.cp_cont_i, 1);
            this.bxQ.setBackgroundDrawable(av.getDrawable(u.f.btn_appdownload));
        }
    }
}
