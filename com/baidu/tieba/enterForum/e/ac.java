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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private ViewEventCenter aXs;
    private View aYK;
    private List<com.baidu.tieba.enterForum.b.f> aZH;
    private TextView aZI;
    private ImageView aZJ;
    private View aZK;
    private View acg;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aZH = new ArrayList();
        NB();
        addView(this.acg);
    }

    public int getItemViewCount() {
        return this.aZH.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aXs = viewEventCenter;
    }

    public void a(List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        h(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.aZK != null) {
            if (z) {
                this.aZK.setVisibility(0);
            } else {
                this.aZK.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.f> list) {
        this.aZH.clear();
        if (list != null) {
            this.aZH.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.f fVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (fVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aXs);
            abVar.setData(fVar);
            abVar.g(tbPageContext);
            addView(abVar);
        }
    }

    private void NB() {
        this.acg = LayoutInflater.from(getContext()).inflate(t.h.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.acg.findViewById(t.g.iv_dismiss).setOnClickListener(new ad(this));
        this.aZK = this.acg.findViewById(t.g.enterforum_forumrecommendinfo_change);
        this.aZK.setOnClickListener(new ae(this));
        this.aZJ = (ImageView) this.acg.findViewById(t.g.iv_dismiss);
        this.mEmptyView = this.acg.findViewById(t.g.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.aZJ.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.aZJ.setVisibility(8);
    }

    private void h(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aZH != null && this.aZH.size() != 0) {
            NE();
            ND();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aZH.size(); i++) {
                com.baidu.tieba.enterForum.b.f fVar = this.aZH.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(fVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(fVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aZH.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.aZJ.setVisibility(0);
                NE();
                ND();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.aZJ.setVisibility(8);
            NF();
            NC();
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

    private void NC() {
        this.aYK = new View(getContext());
        this.aYK.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(getContext(), t.e.ds120)));
        this.aYK.setVisibility(TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.aYK);
    }

    private void ND() {
        if (this.aYK != null) {
            removeView(this.aYK);
            this.aYK = null;
        }
    }

    private void NE() {
        if (this.aZI != null && indexOfChild(this.aZI) > -1) {
            removeView(this.aZI);
        }
    }

    private void NF() {
        if (this.aZI == null) {
            this.aZI = new TextView(getContext());
            this.aZI.setText(t.j.discover_more_bar);
            this.aZI.setTextSize(0, getContext().getResources().getDimensionPixelSize(t.e.fontsize28));
            this.aZI.setGravity(17);
            at.c(this.aZI, t.d.cp_cont_i, 1);
            this.aZI.setBackgroundDrawable(at.getDrawable(t.f.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(t.e.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(t.e.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(t.e.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(t.e.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(t.e.ds50);
            this.aZI.setLayoutParams(layoutParams);
            this.aZI.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.aZI) == -1) {
            addView(this.aZI);
        }
        this.aZI.setVisibility(TbadkCoreApplication.m11getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void NG() {
        if (indexOfChild(this.aZI) >= 0) {
            this.aZI.setVisibility(0);
        }
    }

    public void NH() {
        if (indexOfChild(this.aYK) >= 0) {
            this.aYK.setVisibility(0);
        }
    }

    public void g(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this.acg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ab) {
                ((ab) getChildAt(i2)).g(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.aZI != null) {
            at.c(this.aZI, t.d.cp_cont_i, 1);
            this.aZI.setBackgroundDrawable(at.getDrawable(t.f.btn_appdownload));
        }
    }
}
