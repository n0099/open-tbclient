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
    private List<com.baidu.tieba.enterForum.b.g> aSl;
    private View akX;
    private ViewEventCenter bEQ;
    private TextView bGU;
    private ImageView bGV;
    private View bGW;
    private View byy;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aSl = new ArrayList();
        Wu();
        addView(this.akX);
    }

    public int getItemViewCount() {
        return this.aSl.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bEQ = viewEventCenter;
    }

    public void c(List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        o(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bGW != null) {
            if (z) {
                this.bGW.setVisibility(0);
            } else {
                this.bGW.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.g> list) {
        this.aSl.clear();
        if (list != null) {
            this.aSl.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.g gVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (gVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.bEQ);
            abVar.setData(gVar);
            abVar.n(tbPageContext);
            addView(abVar);
        }
    }

    private void Wu() {
        this.akX = LayoutInflater.from(getContext()).inflate(w.j.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.akX.findViewById(w.h.iv_dismiss).setOnClickListener(new ad(this));
        this.bGW = this.akX.findViewById(w.h.enterforum_forumrecommendinfo_change);
        this.bGW.setOnClickListener(new ae(this));
        this.bGV = (ImageView) this.akX.findViewById(w.h.iv_dismiss);
        this.mEmptyView = this.akX.findViewById(w.h.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bGV.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bGV.setVisibility(8);
    }

    private void o(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aSl != null && this.aSl.size() != 0) {
            Wx();
            Ww();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aSl.size(); i++) {
                com.baidu.tieba.enterForum.b.g gVar = this.aSl.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(gVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(gVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aSl.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bGV.setVisibility(0);
                Wx();
                Ww();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bGV.setVisibility(8);
            Wy();
            Wv();
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

    private void Wv() {
        this.byy = new View(getContext());
        this.byy.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds120)));
        this.byy.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.byy);
    }

    private void Ww() {
        if (this.byy != null) {
            removeView(this.byy);
            this.byy = null;
        }
    }

    private void Wx() {
        if (this.bGU != null && indexOfChild(this.bGU) > -1) {
            removeView(this.bGU);
        }
    }

    private void Wy() {
        if (this.bGU == null) {
            this.bGU = new TextView(getContext());
            this.bGU.setText(w.l.discover_more_bar);
            this.bGU.setTextSize(0, getContext().getResources().getDimensionPixelSize(w.f.fontsize28));
            this.bGU.setGravity(17);
            aq.c(this.bGU, w.e.cp_cont_i, 1);
            this.bGU.setBackgroundDrawable(aq.getDrawable(w.g.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(w.f.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(w.f.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(w.f.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(w.f.ds50);
            this.bGU.setLayoutParams(layoutParams);
            this.bGU.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.bGU) == -1) {
            addView(this.bGU);
        }
        this.bGU.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this.akX);
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
        if (this.bGU != null) {
            aq.c(this.bGU, w.e.cp_cont_i, 1);
            this.bGU.setBackgroundDrawable(aq.getDrawable(w.g.btn_appdownload));
        }
    }
}
