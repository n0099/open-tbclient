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
    private View jhU;
    private EMTextView jhp;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        ev(context);
    }

    private void ev(Context context) {
        if (this.jhU == null) {
            this.jhU = LayoutInflater.from(context).inflate(R.layout.forum_rules_title_area, (ViewGroup) null);
            this.jhp = (EMTextView) this.jhU.findViewById(R.id.forum_rules_title);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jhU != null) {
            this.jhU.setVisibility(0);
            bdTypeRecyclerView.addHeaderView(this.jhU);
        }
    }

    public void e(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jhU != null) {
            this.jhU.setVisibility(8);
            bdTypeRecyclerView.removeHeaderView(this.jhU);
        }
    }

    public void setTitle(String str) {
        this.jhp.setText(str);
    }

    public void onChangeSkinType(int i) {
        c.bm(this.jhp).pu(R.string.F_X02).ps(R.color.CAM_X0105);
    }
}
