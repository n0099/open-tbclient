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
    private List<com.baidu.tieba.enterForum.b.f> aMt;
    private ViewEventCenter aQB;
    private TextView aSU;
    private ImageView aSV;
    private View aSW;
    private View afy;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aMt = new ArrayList();
        IP();
        addView(this.afy);
    }

    public int getItemViewCount() {
        return this.aMt.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aQB = viewEventCenter;
    }

    public void b(List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        g(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.aSW != null) {
            if (z) {
                this.aSW.setVisibility(0);
            } else {
                this.aSW.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.f> list) {
        this.aMt.clear();
        if (list != null) {
            this.aMt.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.f fVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (fVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aQB);
            abVar.setData(fVar);
            abVar.f(tbPageContext);
            addView(abVar);
        }
    }

    private void IP() {
        this.afy = LayoutInflater.from(getContext()).inflate(n.g.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.afy.findViewById(n.f.iv_dismiss).setOnClickListener(new ad(this));
        this.aSW = this.afy.findViewById(n.f.enterforum_forumrecommendinfo_change);
        this.aSW.setOnClickListener(new ae(this));
        this.aSV = (ImageView) this.afy.findViewById(n.f.iv_dismiss);
        this.mEmptyView = this.afy.findViewById(n.f.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.aSV.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.aSV.setVisibility(8);
    }

    private void g(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aMt != null && this.aMt.size() != 0) {
            KL();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aMt.size(); i++) {
                com.baidu.tieba.enterForum.b.f fVar = this.aMt.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(fVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(fVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aMt.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.aSV.setVisibility(0);
                KL();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.aSV.setVisibility(8);
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                KM();
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

    private void KL() {
        if (this.aSU != null) {
            removeView(this.aSU);
            this.aSU = null;
        }
    }

    private void KM() {
        if (this.aSU == null) {
            this.aSU = new TextView(getContext());
            this.aSU.setText(n.i.discover_more_bar);
            this.aSU.setTextSize(0, getContext().getResources().getDimensionPixelSize(n.d.fontsize28));
            this.aSU.setGravity(17);
            as.b(this.aSU, n.c.cp_cont_i, 1);
            this.aSU.setBackgroundDrawable(as.getDrawable(n.e.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(n.d.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(n.d.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(n.d.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(n.d.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(n.d.ds50);
            this.aSU.setLayoutParams(layoutParams);
            this.aSU.setOnClickListener(new af(this));
            addView(this.aSU);
        }
    }

    public void f(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.i.a.a(tbPageContext, this.afy);
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
        if (this.aSU != null) {
            as.b(this.aSU, n.c.cp_cont_i, 1);
            this.aSU.setBackgroundDrawable(as.getDrawable(n.e.btn_appdownload));
        }
    }
}
