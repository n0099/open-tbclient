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
    private View jpQ;
    private EMTextView jpl;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        if (this.jpQ == null) {
            this.jpQ = LayoutInflater.from(context).inflate(R.layout.forum_rules_title_area, (ViewGroup) null);
            this.jpl = (EMTextView) this.jpQ.findViewById(R.id.forum_rules_title);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jpQ != null) {
            this.jpQ.setVisibility(0);
            bdTypeRecyclerView.addHeaderView(this.jpQ);
        }
    }

    public void e(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jpQ != null) {
            this.jpQ.setVisibility(8);
            bdTypeRecyclerView.removeHeaderView(this.jpQ);
        }
    }

    public void setTitle(String str) {
        this.jpl.setText(str);
    }

    public void onChangeSkinType(int i) {
        c.bv(this.jpl).nX(R.string.F_X02).nV(R.color.CAM_X0105);
    }
}
