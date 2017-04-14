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
    private List<com.baidu.tieba.enterForum.b.g> aSB;
    private View alm;
    private ViewEventCenter bEJ;
    private TextView bGN;
    private ImageView bGO;
    private View bGP;
    private View byr;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aSB = new ArrayList();
        WS();
        addView(this.alm);
    }

    public int getItemViewCount() {
        return this.aSB.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bEJ = viewEventCenter;
    }

    public void c(List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        o(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bGP != null) {
            if (z) {
                this.bGP.setVisibility(0);
            } else {
                this.bGP.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.g> list) {
        this.aSB.clear();
        if (list != null) {
            this.aSB.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.g gVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (gVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.bEJ);
            abVar.setData(gVar);
            abVar.n(tbPageContext);
            addView(abVar);
        }
    }

    private void WS() {
        this.alm = LayoutInflater.from(getContext()).inflate(w.j.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.alm.findViewById(w.h.iv_dismiss).setOnClickListener(new ad(this));
        this.bGP = this.alm.findViewById(w.h.enterforum_forumrecommendinfo_change);
        this.bGP.setOnClickListener(new ae(this));
        this.bGO = (ImageView) this.alm.findViewById(w.h.iv_dismiss);
        this.mEmptyView = this.alm.findViewById(w.h.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bGO.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bGO.setVisibility(8);
    }

    private void o(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aSB != null && this.aSB.size() != 0) {
            WV();
            WU();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aSB.size(); i++) {
                com.baidu.tieba.enterForum.b.g gVar = this.aSB.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(gVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(gVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aSB.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bGO.setVisibility(0);
                WV();
                WU();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bGO.setVisibility(8);
            WW();
            WT();
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

    private void WT() {
        this.byr = new View(getContext());
        this.byr.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds120)));
        this.byr.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.byr);
    }

    private void WU() {
        if (this.byr != null) {
            removeView(this.byr);
            this.byr = null;
        }
    }

    private void WV() {
        if (this.bGN != null && indexOfChild(this.bGN) > -1) {
            removeView(this.bGN);
        }
    }

    private void WW() {
        if (this.bGN == null) {
            this.bGN = new TextView(getContext());
            this.bGN.setText(w.l.discover_more_bar);
            this.bGN.setTextSize(0, getContext().getResources().getDimensionPixelSize(w.f.fontsize28));
            this.bGN.setGravity(17);
            aq.c(this.bGN, w.e.cp_cont_i, 1);
            this.bGN.setBackgroundDrawable(aq.getDrawable(w.g.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(w.f.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(w.f.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(w.f.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(w.f.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(w.f.ds50);
            this.bGN.setLayoutParams(layoutParams);
            this.bGN.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.bGN) == -1) {
            addView(this.bGN);
        }
        this.bGN.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.m.a.a(tbPageContext, this.alm);
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
        if (this.bGN != null) {
            aq.c(this.bGN, w.e.cp_cont_i, 1);
            this.bGN.setBackgroundDrawable(aq.getDrawable(w.g.btn_appdownload));
        }
    }
}
