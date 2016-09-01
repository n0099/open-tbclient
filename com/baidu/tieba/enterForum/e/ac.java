package com.baidu.tieba.enterForum.e;

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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private List<com.baidu.tieba.enterForum.b.g> aOE;
    private ViewEventCenter aOw;
    private View aga;
    private View bIe;
    private TextView bJf;
    private ImageView bJg;
    private View bJh;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aOE = new ArrayList();
        Yv();
        addView(this.aga);
    }

    public int getItemViewCount() {
        return this.aOE.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aOw = viewEventCenter;
    }

    public void c(List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        o(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bJh != null) {
            if (z) {
                this.bJh.setVisibility(0);
            } else {
                this.bJh.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.g> list) {
        this.aOE.clear();
        if (list != null) {
            this.aOE.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.g gVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (gVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aOw);
            abVar.setData(gVar);
            abVar.n(tbPageContext);
            addView(abVar);
        }
    }

    private void Yv() {
        this.aga = LayoutInflater.from(getContext()).inflate(t.h.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.aga.findViewById(t.g.iv_dismiss).setOnClickListener(new ad(this));
        this.bJh = this.aga.findViewById(t.g.enterforum_forumrecommendinfo_change);
        this.bJh.setOnClickListener(new ae(this));
        this.bJg = (ImageView) this.aga.findViewById(t.g.iv_dismiss);
        this.mEmptyView = this.aga.findViewById(t.g.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bJg.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bJg.setVisibility(8);
    }

    private void o(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aOE != null && this.aOE.size() != 0) {
            Yy();
            Yx();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aOE.size(); i++) {
                com.baidu.tieba.enterForum.b.g gVar = this.aOE.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(gVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(gVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aOE.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bJg.setVisibility(0);
                Yy();
                Yx();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bJg.setVisibility(8);
            Yz();
            Yw();
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

    private void Yw() {
        this.bIe = new View(getContext());
        this.bIe.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(getContext(), t.e.ds120)));
        this.bIe.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.bIe);
    }

    private void Yx() {
        if (this.bIe != null) {
            removeView(this.bIe);
            this.bIe = null;
        }
    }

    private void Yy() {
        if (this.bJf != null && indexOfChild(this.bJf) > -1) {
            removeView(this.bJf);
        }
    }

    private void Yz() {
        if (this.bJf == null) {
            this.bJf = new TextView(getContext());
            this.bJf.setText(t.j.discover_more_bar);
            this.bJf.setTextSize(0, getContext().getResources().getDimensionPixelSize(t.e.fontsize28));
            this.bJf.setGravity(17);
            av.c(this.bJf, t.d.cp_cont_i, 1);
            this.bJf.setBackgroundDrawable(av.getDrawable(t.f.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(t.e.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(t.e.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(t.e.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(t.e.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(t.e.ds50);
            this.bJf.setLayoutParams(layoutParams);
            this.bJf.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.bJf) == -1) {
            addView(this.bJf);
        }
        this.bJf.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void YA() {
        if (indexOfChild(this.bJf) >= 0) {
            this.bJf.setVisibility(0);
        }
    }

    public void YB() {
        if (indexOfChild(this.bIe) >= 0) {
            this.bIe.setVisibility(0);
        }
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this.aga);
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
        if (this.bJf != null) {
            av.c(this.bJf, t.d.cp_cont_i, 1);
            this.bJf.setBackgroundDrawable(av.getDrawable(t.f.btn_appdownload));
        }
    }
}
