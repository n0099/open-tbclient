package com.baidu.tieba.enterForum.c;

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private List<com.baidu.tieba.enterForum.b.g> aSD;
    private View aln;
    private View bAI;
    private ViewEventCenter bHa;
    private TextView bJe;
    private ImageView bJf;
    private View bJg;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aSD = new ArrayList();
        XT();
        addView(this.aln);
    }

    public int getItemViewCount() {
        return this.aSD.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bHa = viewEventCenter;
    }

    public void c(List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        o(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bJg != null) {
            if (z) {
                this.bJg.setVisibility(0);
            } else {
                this.bJg.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.g> list) {
        this.aSD.clear();
        if (list != null) {
            this.aSD.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.g gVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (gVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.bHa);
            abVar.setData(gVar);
            abVar.n(tbPageContext);
            addView(abVar);
        }
    }

    private void XT() {
        this.aln = LayoutInflater.from(getContext()).inflate(w.j.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.aln.findViewById(w.h.iv_dismiss).setOnClickListener(new ad(this));
        this.bJg = this.aln.findViewById(w.h.enterforum_forumrecommendinfo_change);
        this.bJg.setOnClickListener(new ae(this));
        this.bJf = (ImageView) this.aln.findViewById(w.h.iv_dismiss);
        this.mEmptyView = this.aln.findViewById(w.h.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bJf.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bJf.setVisibility(8);
    }

    private void o(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aSD != null && this.aSD.size() != 0) {
            XW();
            XV();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aSD.size(); i++) {
                com.baidu.tieba.enterForum.b.g gVar = this.aSD.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(gVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(gVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aSD.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bJf.setVisibility(0);
                XW();
                XV();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bJf.setVisibility(8);
            XX();
            XU();
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

    private void XU() {
        this.bAI = new View(getContext());
        this.bAI.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds120)));
        this.bAI.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.bAI);
    }

    private void XV() {
        if (this.bAI != null) {
            removeView(this.bAI);
            this.bAI = null;
        }
    }

    private void XW() {
        if (this.bJe != null && indexOfChild(this.bJe) > -1) {
            removeView(this.bJe);
        }
    }

    private void XX() {
        if (this.bJe == null) {
            this.bJe = new TextView(getContext());
            this.bJe.setText(w.l.discover_more_bar);
            this.bJe.setTextSize(0, getContext().getResources().getDimensionPixelSize(w.f.fontsize28));
            this.bJe.setGravity(17);
            aq.c(this.bJe, w.e.cp_cont_i, 1);
            this.bJe.setBackgroundDrawable(aq.getDrawable(w.g.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(w.f.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(w.f.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(w.f.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(w.f.ds50);
            this.bJe.setLayoutParams(layoutParams);
            this.bJe.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.bJe) == -1) {
            addView(this.bJe);
        }
        this.bJe.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this.aln);
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
        if (this.bJe != null) {
            aq.c(this.bJe, w.e.cp_cont_i, 1);
            this.bJe.setBackgroundDrawable(aq.getDrawable(w.g.btn_appdownload));
        }
    }
}
