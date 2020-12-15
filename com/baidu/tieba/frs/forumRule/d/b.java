package com.baidu.tieba.frs.forumRule.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b {
    private View jhW;
    private EMTextView jhr;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        ev(context);
    }

    private void ev(Context context) {
        if (this.jhW == null) {
            this.jhW = LayoutInflater.from(context).inflate(R.layout.forum_rules_title_area, (ViewGroup) null);
            this.jhr = (EMTextView) this.jhW.findViewById(R.id.forum_rules_title);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jhW != null) {
            this.jhW.setVisibility(0);
            bdTypeRecyclerView.addHeaderView(this.jhW);
        }
    }

    public void e(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jhW != null) {
            this.jhW.setVisibility(8);
            bdTypeRecyclerView.removeHeaderView(this.jhW);
        }
    }

    public void setTitle(String str) {
        this.jhr.setText(str);
    }

    public void onChangeSkinType(int i) {
        c.bm(this.jhr).pu(R.string.F_X02).ps(R.color.CAM_X0105);
    }
}
