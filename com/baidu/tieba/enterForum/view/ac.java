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
    private List<com.baidu.tieba.enterForum.b.g> aJj;
    private View acA;
    private ViewEventCenter bfx;
    private View buC;
    private TextView bvC;
    private ImageView bvD;
    private View bvE;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aJj = new ArrayList();
        Td();
        addView(this.acA);
    }

    public int getItemViewCount() {
        return this.aJj.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bfx = viewEventCenter;
    }

    public void c(List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        o(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bvE != null) {
            if (z) {
                this.bvE.setVisibility(0);
            } else {
                this.bvE.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.g> list) {
        this.aJj.clear();
        if (list != null) {
            this.aJj.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.g gVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (gVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.bfx);
            abVar.setData(gVar);
            abVar.n(tbPageContext);
            addView(abVar);
        }
    }

    private void Td() {
        this.acA = LayoutInflater.from(getContext()).inflate(u.h.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.acA.findViewById(u.g.iv_dismiss).setOnClickListener(new ad(this));
        this.bvE = this.acA.findViewById(u.g.enterforum_forumrecommendinfo_change);
        this.bvE.setOnClickListener(new ae(this));
        this.bvD = (ImageView) this.acA.findViewById(u.g.iv_dismiss);
        this.mEmptyView = this.acA.findViewById(u.g.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bvD.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bvD.setVisibility(8);
    }

    private void o(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aJj != null && this.aJj.size() != 0) {
            Tg();
            Tf();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aJj.size(); i++) {
                com.baidu.tieba.enterForum.b.g gVar = this.aJj.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(gVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(gVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aJj.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bvD.setVisibility(0);
                Tg();
                Tf();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bvD.setVisibility(8);
            Th();
            Te();
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

    private void Te() {
        this.buC = new View(getContext());
        this.buC.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(getContext(), u.e.ds120)));
        this.buC.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.buC);
    }

    private void Tf() {
        if (this.buC != null) {
            removeView(this.buC);
            this.buC = null;
        }
    }

    private void Tg() {
        if (this.bvC != null && indexOfChild(this.bvC) > -1) {
            removeView(this.bvC);
        }
    }

    private void Th() {
        if (this.bvC == null) {
            this.bvC = new TextView(getContext());
            this.bvC.setText(u.j.discover_more_bar);
            this.bvC.setTextSize(0, getContext().getResources().getDimensionPixelSize(u.e.fontsize28));
            this.bvC.setGravity(17);
            av.c(this.bvC, u.d.cp_cont_i, 1);
            this.bvC.setBackgroundDrawable(av.getDrawable(u.f.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(u.e.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(u.e.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(u.e.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(u.e.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(u.e.ds50);
            this.bvC.setLayoutParams(layoutParams);
            this.bvC.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.bvC) == -1) {
            addView(this.bvC);
        }
        this.bvC.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void Ti() {
        if (indexOfChild(this.bvC) >= 0) {
            this.bvC.setVisibility(0);
        }
    }

    public void Tj() {
        if (indexOfChild(this.buC) >= 0) {
            this.buC.setVisibility(0);
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this.acA);
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
        if (this.bvC != null) {
            av.c(this.bvC, u.d.cp_cont_i, 1);
            this.bvC.setBackgroundDrawable(av.getDrawable(u.f.btn_appdownload));
        }
    }
}
