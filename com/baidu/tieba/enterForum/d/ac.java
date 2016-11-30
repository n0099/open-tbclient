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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private List<com.baidu.tieba.enterForum.b.g> aOf;
    private ViewEventCenter aRS;
    private View aha;
    private View bKZ;
    private TextView bLZ;
    private ImageView bMa;
    private View bMb;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aOf = new ArrayList();
        ZO();
        addView(this.aha);
    }

    public int getItemViewCount() {
        return this.aOf.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aRS = viewEventCenter;
    }

    public void c(List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        s(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bMb != null) {
            if (z) {
                this.bMb.setVisibility(0);
            } else {
                this.bMb.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.g> list) {
        this.aOf.clear();
        if (list != null) {
            this.aOf.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.g gVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (gVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aRS);
            abVar.setData(gVar);
            abVar.r(tbPageContext);
            addView(abVar);
        }
    }

    private void ZO() {
        this.aha = LayoutInflater.from(getContext()).inflate(r.h.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.aha.findViewById(r.g.iv_dismiss).setOnClickListener(new ad(this));
        this.bMb = this.aha.findViewById(r.g.enterforum_forumrecommendinfo_change);
        this.bMb.setOnClickListener(new ae(this));
        this.bMa = (ImageView) this.aha.findViewById(r.g.iv_dismiss);
        this.mEmptyView = this.aha.findViewById(r.g.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bMa.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bMa.setVisibility(8);
    }

    private void s(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aOf != null && this.aOf.size() != 0) {
            ZR();
            ZQ();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aOf.size(); i++) {
                com.baidu.tieba.enterForum.b.g gVar = this.aOf.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(gVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(gVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aOf.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bMa.setVisibility(0);
                ZR();
                ZQ();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bMa.setVisibility(8);
            ZS();
            ZP();
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

    private void ZP() {
        this.bKZ = new View(getContext());
        this.bKZ.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(getContext(), r.e.ds120)));
        this.bKZ.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.bKZ);
    }

    private void ZQ() {
        if (this.bKZ != null) {
            removeView(this.bKZ);
            this.bKZ = null;
        }
    }

    private void ZR() {
        if (this.bLZ != null && indexOfChild(this.bLZ) > -1) {
            removeView(this.bLZ);
        }
    }

    private void ZS() {
        if (this.bLZ == null) {
            this.bLZ = new TextView(getContext());
            this.bLZ.setText(r.j.discover_more_bar);
            this.bLZ.setTextSize(0, getContext().getResources().getDimensionPixelSize(r.e.fontsize28));
            this.bLZ.setGravity(17);
            at.c(this.bLZ, r.d.cp_cont_i, 1);
            this.bLZ.setBackgroundDrawable(at.getDrawable(r.f.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(r.e.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(r.e.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(r.e.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(r.e.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(r.e.ds50);
            this.bLZ.setLayoutParams(layoutParams);
            this.bLZ.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.bLZ) == -1) {
            addView(this.bLZ);
        }
        this.bLZ.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void r(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this.aha);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ab) {
                ((ab) getChildAt(i2)).r(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.bLZ != null) {
            at.c(this.bLZ, r.d.cp_cont_i, 1);
            this.bLZ.setBackgroundDrawable(at.getDrawable(r.f.btn_appdownload));
        }
    }
}
