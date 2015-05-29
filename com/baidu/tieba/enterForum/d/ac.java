package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends NoPressedLinearLayout {
    private View ZX;
    private ViewEventCenter aET;
    private List<com.baidu.tieba.enterForum.b.e> aGN;
    private TextView aGO;
    private ImageView aGP;
    private View aGQ;
    private View mEmptyView;

    public ac(Context context) {
        this(context, null);
    }

    public ac(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.aGN = new ArrayList();
        Hd();
        addView(this.ZX);
    }

    public int getItemViewCount() {
        return this.aGN.size();
    }

    public void setEventCenter(ViewEventCenter viewEventCenter) {
        this.aET = viewEventCenter;
    }

    public void a(List<com.baidu.tieba.enterForum.b.e> list, TbPageContext<BaseFragmentActivity> tbPageContext) {
        setData(list);
        e(tbPageContext);
    }

    public void setChangeViewVisibility(boolean z) {
        if (this.aGQ != null) {
            if (z) {
                this.aGQ.setVisibility(0);
            } else {
                this.aGQ.setVisibility(8);
            }
        }
    }

    private void setData(List<com.baidu.tieba.enterForum.b.e> list) {
        this.aGN.clear();
        if (list != null) {
            this.aGN.addAll(list);
        }
    }

    private void a(com.baidu.tieba.enterForum.b.e eVar, TbPageContext<BaseFragmentActivity> tbPageContext) {
        if (eVar != null) {
            ab abVar = new ab(getContext());
            abVar.setEventCenter(this.aET);
            abVar.setData(eVar);
            abVar.d(tbPageContext);
            addView(abVar);
        }
    }

    private void Hd() {
        this.ZX = com.baidu.adp.lib.g.b.hr().inflate(getContext(), com.baidu.tieba.r.enter_forum_recommendinfo_notice, null);
        this.ZX.findViewById(com.baidu.tieba.q.iv_dismiss).setOnClickListener(new ad(this));
        this.aGQ = this.ZX.findViewById(com.baidu.tieba.q.enterforum_forumrecommendinfo_change);
        this.aGQ.setOnClickListener(new ae(this));
        this.aGP = (ImageView) this.ZX.findViewById(com.baidu.tieba.q.iv_dismiss);
        this.mEmptyView = this.ZX.findViewById(com.baidu.tieba.q.enterforum_guide_top_divider);
        if (TbadkCoreApplication.isLogin()) {
            this.mEmptyView.setVisibility(0);
            this.aGP.setVisibility(0);
            return;
        }
        this.mEmptyView.setVisibility(8);
        this.aGP.setVisibility(8);
    }

    private void e(TbPageContext<BaseFragmentActivity> tbPageContext) {
        int size;
        if (this.aGN != null && this.aGN.size() != 0) {
            IH();
            List<ab> allRecomItemView = getAllRecomItemView();
            for (int i = 0; i < this.aGN.size(); i++) {
                com.baidu.tieba.enterForum.b.e eVar = this.aGN.get(i);
                if (allRecomItemView == null || i >= allRecomItemView.size()) {
                    a(eVar, tbPageContext);
                } else if (i < allRecomItemView.size()) {
                    allRecomItemView.get(i).setData(eVar);
                }
            }
            if (allRecomItemView != null) {
                int size2 = allRecomItemView.size() - this.aGN.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    removeView(allRecomItemView.get((size - i2) - 1));
                }
            }
            if (TbadkCoreApplication.isLogin()) {
                this.mEmptyView.setVisibility(0);
                this.aGP.setVisibility(0);
                IH();
                return;
            }
            this.mEmptyView.setVisibility(8);
            this.aGP.setVisibility(8);
            II();
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

    private void IH() {
        if (this.aGO != null) {
            removeView(this.aGO);
            this.aGO = null;
        }
    }

    private void II() {
        if (this.aGO == null) {
            this.aGO = new TextView(getContext());
            this.aGO.setText(com.baidu.tieba.t.discover_more_bar);
            this.aGO.setTextSize(0, getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.fontsize28));
            this.aGO.setGravity(17);
            ay.b(this.aGO, com.baidu.tieba.n.cp_cont_i, 1);
            this.aGO.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.btn_appdownload));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds90));
            layoutParams.topMargin = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds50);
            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds100);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds100);
            layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(com.baidu.tieba.o.ds50);
            this.aGO.setLayoutParams(layoutParams);
            this.aGO.setOnClickListener(new af(this));
            addView(this.aGO);
        }
    }

    public void d(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.f.a.a(tbPageContext, this.ZX);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                break;
            }
            if (getChildAt(i2) instanceof ab) {
                ((ab) getChildAt(i2)).d(tbPageContext);
            }
            i = i2 + 1;
        }
        if (this.aGO != null) {
            ay.b(this.aGO, com.baidu.tieba.n.cp_cont_i, 1);
            this.aGO.setBackgroundDrawable(ay.getDrawable(com.baidu.tieba.p.btn_appdownload));
        }
    }
}
