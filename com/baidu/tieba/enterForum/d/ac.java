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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private ViewEventCenter aMt;
    private List<com.baidu.tieba.enterForum.b.e> aOo;
    private TextView aOp;
    private ImageView aOq;
    private View aOr;
    private View aeY;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aOo = new ArrayList();
        HV();
        addView(this.aeY);
    }

    public int getItemViewCount() {
        return this.aOo.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aMt = viewEventCenter;
    }

    public void a(List<com.baidu.tieba.enterForum.b.e> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        f(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.aOr != null) {
            if (z) {
                this.aOr.setVisibility(0);
            } else {
                this.aOr.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.e> list) {
        this.aOo.clear();
        if (list != null) {
            this.aOo.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.e eVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (eVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aMt);
            abVar.setData(eVar);
            abVar.e(tbPageContext);
            addView(abVar);
        }
    }

    private void HV() {
        this.aeY = LayoutInflater.from(getContext()).inflate(i.g.enter_forum_recommendinfo_notice, (ViewGroup) null);
        this.aeY.findViewById(i.f.iv_dismiss).setOnClickListener(new ad(this));
        this.aOr = this.aeY.findViewById(i.f.enterforum_forumrecommendinfo_change);
        this.aOr.setOnClickListener(new ae(this));
        this.aOq = (ImageView) this.aeY.findViewById(i.f.iv_dismiss);
        this.mEmptyView = this.aeY.findViewById(i.f.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.aOq.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.aOq.setVisibility(8);
    }

    private void f(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aOo != null && this.aOo.size() != 0) {
            Jw();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aOo.size(); i++) {
                com.baidu.tieba.enterForum.b.e eVar = this.aOo.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(eVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(eVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aOo.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.aOq.setVisibility(0);
                Jw();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.aOq.setVisibility(8);
            if (TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.CMD_SQUARE_FORUM_SQUARE)) {
                Jx();
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

    private void Jw() {
        if (this.aOp != null) {
            removeView(this.aOp);
            this.aOp = null;
        }
    }

    private void Jx() {
        if (this.aOp == null) {
            this.aOp = new TextView(getContext());
            this.aOp.setText(i.C0057i.discover_more_bar);
            this.aOp.setTextSize(0, getContext().getResources().getDimensionPixelSize(i.d.fontsize28));
            this.aOp.setGravity(17);
            al.b(this.aOp, i.c.cp_cont_i, 1);
            this.aOp.setBackgroundDrawable(al.getDrawable(i.e.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(i.d.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(i.d.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(i.d.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(i.d.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(i.d.ds50);
            this.aOp.setLayoutParams(layoutParams);
            this.aOp.setOnClickListener(new af(this));
            addView(this.aOp);
        }
    }

    public void e(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this.aeY);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ab) {
                ((ab) getChildAt(i2)).e(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.aOp != null) {
            al.b(this.aOp, i.c.cp_cont_i, 1);
            this.aOp.setBackgroundDrawable(al.getDrawable(i.e.btn_appdownload));
        }
    }
}
