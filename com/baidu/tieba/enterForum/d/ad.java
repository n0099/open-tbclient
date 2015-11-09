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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ad extends NoPressedLinearLayout {
    private ViewEventCenter aLU;
    private List<com.baidu.tieba.enterForum.b.f> aNQ;
    private TextView aNR;
    private ImageView aNS;
    private View aNT;
    private View aeB;
    private View mEmptyView;

    public ad(Context context) {
        this(context, null);
    }

    public ad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aNQ = new ArrayList();
        Hw();
        addView(this.aeB);
    }

    public int getItemViewCount() {
        return this.aNQ.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aLU = viewEventCenter;
    }

    public void a(List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        f(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.aNT != null) {
            if (z) {
                this.aNT.setVisibility(0);
            } else {
                this.aNT.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.f> list) {
        this.aNQ.clear();
        if (list != null) {
            this.aNQ.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.f fVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (fVar != null) {
            ac acVar = new ac(getContext());
            acVar.setEventCenter(this.aLU);
            acVar.setData(fVar);
            acVar.e(tbPageContext);
            addView(acVar);
        }
    }

    private void Hw() {
        this.aeB = LayoutInflater.from(getContext()).inflate(i.g.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.aeB.findViewById(i.f.iv_dismiss).setOnClickListener(new ae(this));
        this.aNT = this.aeB.findViewById(i.f.enterforum_forumrecommendinfo_change);
        this.aNT.setOnClickListener(new af(this));
        this.aNS = (ImageView) this.aeB.findViewById(i.f.iv_dismiss);
        this.mEmptyView = this.aeB.findViewById(i.f.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.aNS.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.aNS.setVisibility(8);
    }

    private void f(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aNQ != null && this.aNQ.size() != 0) {
            Jr();
            List<ac> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aNQ.size(); i++) {
                com.baidu.tieba.enterForum.b.f fVar = this.aNQ.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(fVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(fVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aNQ.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.aNS.setVisibility(0);
                Jr();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.aNS.setVisibility(8);
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                Js();
            }
        }
    }

    private List<ac> getAllRecomItemView() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ac) {
                arrayList.add((ac) childAt);
            }
        }
        return arrayList;
    }

    private void Jr() {
        if (this.aNR != null) {
            removeView(this.aNR);
            this.aNR = null;
        }
    }

    private void Js() {
        if (this.aNR == null) {
            this.aNR = new TextView(getContext());
            this.aNR.setText(i.h.discover_more_bar);
            this.aNR.setTextSize(0, getContext().getResources().getDimensionPixelSize(i.d.fontsize28));
            this.aNR.setGravity(17);
            an.b(this.aNR, i.c.cp_cont_i, 1);
            this.aNR.setBackgroundDrawable(an.getDrawable(i.e.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(i.d.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(i.d.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(i.d.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(i.d.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(i.d.ds50);
            this.aNR.setLayoutParams(layoutParams);
            this.aNR.setOnClickListener(new ag(this));
            addView(this.aNR);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this.aeB);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ac) {
                ((ac) getChildAt(i2)).e(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.aNR != null) {
            an.b(this.aNR, i.c.cp_cont_i, 1);
            this.aNR.setBackgroundDrawable(an.getDrawable(i.e.btn_appdownload));
        }
    }
}
