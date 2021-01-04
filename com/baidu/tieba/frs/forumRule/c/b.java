package com.baidu.tieba.frs.forumRule.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b {
    private EMTextView jtR;
    private View juw;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        eO(context);
    }

    private void eO(Context context) {
        if (this.juw == null) {
            this.juw = LayoutInflater.from(context).inflate(R.layout.forum_rules_title_area, (ViewGroup) null);
            this.jtR = (EMTextView) this.juw.findViewById(R.id.forum_rules_title);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.juw != null) {
            this.juw.setVisibility(0);
            bdTypeRecyclerView.addHeaderView(this.juw);
        }
    }

    public void e(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.juw != null) {
            this.juw.setVisibility(8);
            bdTypeRecyclerView.removeHeaderView(this.juw);
        }
    }

    public void setTitle(String str) {
        this.jtR.setText(str);
    }

    public void onChangeSkinType(int i) {
        c.bv(this.jtR).pE(R.string.F_X02).pC(R.color.CAM_X0105);
    }
}
