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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private List<com.baidu.tieba.enterForum.b.g> aMy;
    private View afF;
    private View brw;
    private ViewEventCenter bxK;
    private TextView bzO;
    private ImageView bzP;
    private View bzQ;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aMy = new ArrayList();
        Vw();
        addView(this.afF);
    }

    public int getItemViewCount() {
        return this.aMy.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bxK = viewEventCenter;
    }

    public void c(List<com.baidu.tieba.enterForum.b.g> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        o(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bzQ != null) {
            if (z) {
                this.bzQ.setVisibility(0);
            } else {
                this.bzQ.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.g> list) {
        this.aMy.clear();
        if (list != null) {
            this.aMy.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.g gVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (gVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.bxK);
            abVar.setData(gVar);
            abVar.n(tbPageContext);
            addView(abVar);
        }
    }

    private void Vw() {
        this.afF = LayoutInflater.from(getContext()).inflate(r.j.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.afF.findViewById(r.h.iv_dismiss).setOnClickListener(new ad(this));
        this.bzQ = this.afF.findViewById(r.h.enterforum_forumrecommendinfo_change);
        this.bzQ.setOnClickListener(new ae(this));
        this.bzP = (ImageView) this.afF.findViewById(r.h.iv_dismiss);
        this.mEmptyView = this.afF.findViewById(r.h.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bzP.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bzP.setVisibility(8);
    }

    private void o(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aMy != null && this.aMy.size() != 0) {
            Vz();
            Vy();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aMy.size(); i++) {
                com.baidu.tieba.enterForum.b.g gVar = this.aMy.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(gVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(gVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aMy.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bzP.setVisibility(0);
                Vz();
                Vy();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bzP.setVisibility(8);
            VA();
            Vx();
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

    private void Vx() {
        this.brw = new View(getContext());
        this.brw.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(getContext(), r.f.ds120)));
        this.brw.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
        addView(this.brw);
    }

    private void Vy() {
        if (this.brw != null) {
            removeView(this.brw);
            this.brw = null;
        }
    }

    private void Vz() {
        if (this.bzO != null && indexOfChild(this.bzO) > -1) {
            removeView(this.bzO);
        }
    }

    private void VA() {
        if (this.bzO == null) {
            this.bzO = new TextView(getContext());
            this.bzO.setText(r.l.discover_more_bar);
            this.bzO.setTextSize(0, getContext().getResources().getDimensionPixelSize(r.f.fontsize28));
            this.bzO.setGravity(17);
            ap.c(this.bzO, r.e.cp_cont_i, 1);
            this.bzO.setBackgroundDrawable(ap.getDrawable(r.g.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(r.f.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(r.f.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(r.f.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(r.f.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(r.f.ds50);
            this.bzO.setLayoutParams(layoutParams);
            this.bzO.setOnClickListener(new af(this));
        }
        if (indexOfChild(this.bzO) == -1) {
            addView(this.bzO);
        }
        this.bzO.setVisibility(TbadkCoreApplication.m9getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE) ? 0 : 8);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this.afF);
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
        if (this.bzO != null) {
            ap.c(this.bzO, r.e.cp_cont_i, 1);
            this.bzO.setBackgroundDrawable(ap.getDrawable(r.g.btn_appdownload));
        }
    }
}
