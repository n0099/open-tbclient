package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private List<com.baidu.tieba.enterForum.b.f> aTc;
    private View agA;
    private ViewEventCenter bbj;
    private TextView bdU;
    private ImageView bdV;
    private View bdW;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aTc = new ArrayList();
        OK();
        addView(this.agA);
    }

    public int getItemViewCount() {
        return this.aTc.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.bbj = viewEventCenter;
    }

    public void b(List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        g(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.bdW != null) {
            if (z) {
                this.bdW.setVisibility(0);
            } else {
                this.bdW.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.f> list) {
        this.aTc.clear();
        if (list != null) {
            this.aTc.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.f fVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (fVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.bbj);
            abVar.setData(fVar);
            abVar.f(tbPageContext);
            addView(abVar);
        }
    }

    private void OK() {
        this.agA = LayoutInflater.from(getContext()).inflate(t.h.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.agA.findViewById(t.g.iv_dismiss).setOnClickListener(new ad(this));
        this.bdW = this.agA.findViewById(t.g.enterforum_forumrecommendinfo_change);
        this.bdW.setOnClickListener(new ae(this));
        this.bdV = (ImageView) this.agA.findViewById(t.g.iv_dismiss);
        this.mEmptyView = this.agA.findViewById(t.g.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.bdV.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.bdV.setVisibility(8);
    }

    private void g(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aTc != null && this.aTc.size() != 0) {
            OL();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aTc.size(); i++) {
                com.baidu.tieba.enterForum.b.f fVar = this.aTc.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(fVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(fVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aTc.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.bdV.setVisibility(0);
                OL();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.bdV.setVisibility(8);
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                OM();
            }
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

    private void OL() {
        if (this.bdU != null) {
            removeView(this.bdU);
            this.bdU = null;
        }
    }

    private void OM() {
        if (this.bdU == null) {
            this.bdU = new TextView(getContext());
            this.bdU.setText(t.j.discover_more_bar);
            this.bdU.setTextSize(0, getContext().getResources().getDimensionPixelSize(t.e.fontsize28));
            this.bdU.setGravity(17);
            at.b(this.bdU, t.d.cp_cont_i, 1);
            this.bdU.setBackgroundDrawable(at.getDrawable(t.f.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(t.e.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(t.e.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(t.e.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(t.e.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(t.e.ds50);
            this.bdU.setLayoutParams(layoutParams);
            this.bdU.setOnClickListener(new af(this));
            addView(this.bdU);
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this.agA);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ab) {
                ((ab) getChildAt(i2)).f(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.bdU != null) {
            at.b(this.bdU, t.d.cp_cont_i, 1);
            this.bdU.setBackgroundDrawable(at.getDrawable(t.f.btn_appdownload));
        }
    }
}
