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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ad extends NoPressedLinearLayout {
    private ViewEventCenter aLB;
    private View aNA;
    private List<com.baidu.tieba.enterForum.b.f> aNx;
    private TextView aNy;
    private ImageView aNz;
    private View aev;
    private View mEmptyView;

    public ad(Context context) {
        this(context, null);
    }

    public ad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aNx = new ArrayList();
        HD();
        addView(this.aev);
    }

    public int getItemViewCount() {
        return this.aNx.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aLB = viewEventCenter;
    }

    public void a(List<com.baidu.tieba.enterForum.b.f> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        f(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.aNA != null) {
            if (z) {
                this.aNA.setVisibility(0);
            } else {
                this.aNA.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.f> list) {
        this.aNx.clear();
        if (list != null) {
            this.aNx.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.f fVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (fVar != null) {
            ac acVar = new ac(getContext());
            acVar.setEventCenter(this.aLB);
            acVar.setData(fVar);
            acVar.e(tbPageContext);
            addView(acVar);
        }
    }

    private void HD() {
        this.aev = LayoutInflater.from(getContext()).inflate(i.g.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.aev.findViewById(i.f.iv_dismiss).setOnClickListener(new ae(this));
        this.aNA = this.aev.findViewById(i.f.enterforum_forumrecommendinfo_change);
        this.aNA.setOnClickListener(new af(this));
        this.aNz = (ImageView) this.aev.findViewById(i.f.iv_dismiss);
        this.mEmptyView = this.aev.findViewById(i.f.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.aNz.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.aNz.setVisibility(8);
    }

    private void f(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aNx != null && this.aNx.size() != 0) {
            Jf();
            List<ac> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aNx.size(); i++) {
                com.baidu.tieba.enterForum.b.f fVar = this.aNx.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(fVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(fVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aNx.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.aNz.setVisibility(0);
                Jf();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.aNz.setVisibility(8);
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                Jg();
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

    private void Jf() {
        if (this.aNy != null) {
            removeView(this.aNy);
            this.aNy = null;
        }
    }

    private void Jg() {
        if (this.aNy == null) {
            this.aNy = new TextView(getContext());
            this.aNy.setText(i.h.discover_more_bar);
            this.aNy.setTextSize(0, getContext().getResources().getDimensionPixelSize(i.d.fontsize28));
            this.aNy.setGravity(17);
            am.b(this.aNy, i.c.cp_cont_i, 1);
            this.aNy.setBackgroundDrawable(am.getDrawable(i.e.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(i.d.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(i.d.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(i.d.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(i.d.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(i.d.ds50);
            this.aNy.setLayoutParams(layoutParams);
            this.aNy.setOnClickListener(new ag(this));
            addView(this.aNy);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.h.a.a(tbPageContext, this.aev);
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
        if (this.aNy != null) {
            am.b(this.aNy, i.c.cp_cont_i, 1);
            this.aNy.setBackgroundDrawable(am.getDrawable(i.e.btn_appdownload));
        }
    }
}
