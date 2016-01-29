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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private List<com.baidu.tieba.enterForum.b.f> aQh;
    private ViewEventCenter aWA;
    private TextView aZk;
    private ImageView aZl;
    private View aZm;
    private View agZ;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aQh = new ArrayList();
        MW();
        addView(this.agZ);
    }

    public int getItemViewCount() {
        return this.aQh.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aWA = viewEventCenter;
    }

    public void b(List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        g(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.aZm != null) {
            if (z) {
                this.aZm.setVisibility(0);
            } else {
                this.aZm.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.f> list) {
        this.aQh.clear();
        if (list != null) {
            this.aQh.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.f fVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (fVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aWA);
            abVar.setData(fVar);
            abVar.f(tbPageContext);
            addView(abVar);
        }
    }

    private void MW() {
        this.agZ = LayoutInflater.from(getContext()).inflate(t.h.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.agZ.findViewById(t.g.iv_dismiss).setOnClickListener(new ad(this));
        this.aZm = this.agZ.findViewById(t.g.enterforum_forumrecommendinfo_change);
        this.aZm.setOnClickListener(new ae(this));
        this.aZl = (ImageView) this.agZ.findViewById(t.g.iv_dismiss);
        this.mEmptyView = this.agZ.findViewById(t.g.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.aZl.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.aZl.setVisibility(8);
    }

    private void g(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aQh != null && this.aQh.size() != 0) {
            MX();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aQh.size(); i++) {
                com.baidu.tieba.enterForum.b.f fVar = this.aQh.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(fVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(fVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aQh.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.aZl.setVisibility(0);
                MX();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.aZl.setVisibility(8);
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                MY();
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

    private void MX() {
        if (this.aZk != null) {
            removeView(this.aZk);
            this.aZk = null;
        }
    }

    private void MY() {
        if (this.aZk == null) {
            this.aZk = new TextView(getContext());
            this.aZk.setText(t.j.discover_more_bar);
            this.aZk.setTextSize(0, getContext().getResources().getDimensionPixelSize(t.e.fontsize28));
            this.aZk.setGravity(17);
            ar.b(this.aZk, t.d.cp_cont_i, 1);
            this.aZk.setBackgroundDrawable(ar.getDrawable(t.f.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(t.e.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(t.e.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(t.e.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(t.e.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(t.e.ds50);
            this.aZk.setLayoutParams(layoutParams);
            this.aZk.setOnClickListener(new af(this));
            addView(this.aZk);
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this.agZ);
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
        if (this.aZk != null) {
            ar.b(this.aZk, t.d.cp_cont_i, 1);
            this.aZk.setBackgroundDrawable(ar.getDrawable(t.f.btn_appdownload));
        }
    }
}
