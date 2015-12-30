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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private List<com.baidu.tieba.enterForum.b.f> aOe;
    private ViewEventCenter aUs;
    private TextView aWW;
    private ImageView aWX;
    private View aWY;
    private View agl;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aOe = new ArrayList();
        Jg();
        addView(this.agl);
    }

    public int getItemViewCount() {
        return this.aOe.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aUs = viewEventCenter;
    }

    public void b(List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        g(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.aWY != null) {
            if (z) {
                this.aWY.setVisibility(0);
            } else {
                this.aWY.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.f> list) {
        this.aOe.clear();
        if (list != null) {
            this.aOe.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.f fVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (fVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aUs);
            abVar.setData(fVar);
            abVar.f(tbPageContext);
            addView(abVar);
        }
    }

    private void Jg() {
        this.agl = LayoutInflater.from(getContext()).inflate(n.h.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.agl.findViewById(n.g.iv_dismiss).setOnClickListener(new ad(this));
        this.aWY = this.agl.findViewById(n.g.enterforum_forumrecommendinfo_change);
        this.aWY.setOnClickListener(new ae(this));
        this.aWX = (ImageView) this.agl.findViewById(n.g.iv_dismiss);
        this.mEmptyView = this.agl.findViewById(n.g.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.aWX.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.aWX.setVisibility(8);
    }

    private void g(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aOe != null && this.aOe.size() != 0) {
            Le();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aOe.size(); i++) {
                com.baidu.tieba.enterForum.b.f fVar = this.aOe.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(fVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(fVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aOe.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.aWX.setVisibility(0);
                Le();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.aWX.setVisibility(8);
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                Lf();
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

    private void Le() {
        if (this.aWW != null) {
            removeView(this.aWW);
            this.aWW = null;
        }
    }

    private void Lf() {
        if (this.aWW == null) {
            this.aWW = new TextView(getContext());
            this.aWW.setText(n.j.discover_more_bar);
            this.aWW.setTextSize(0, getContext().getResources().getDimensionPixelSize(n.e.fontsize28));
            this.aWW.setGravity(17);
            as.b(this.aWW, n.d.cp_cont_i, 1);
            this.aWW.setBackgroundDrawable(as.getDrawable(n.f.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(n.e.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(n.e.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(n.e.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(n.e.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(n.e.ds50);
            this.aWW.setLayoutParams(layoutParams);
            this.aWW.setOnClickListener(new af(this));
            addView(this.aWW);
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this.agl);
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
        if (this.aWW != null) {
            as.b(this.aWW, n.d.cp_cont_i, 1);
            this.aWW.setBackgroundDrawable(as.getDrawable(n.f.btn_appdownload));
        }
    }
}
