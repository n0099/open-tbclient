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
    private EMTextView juR;
    private View jvw;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        if (this.jvw == null) {
            this.jvw = LayoutInflater.from(context).inflate(R.layout.forum_rules_title_area, (ViewGroup) null);
            this.juR = (EMTextView) this.jvw.findViewById(R.id.forum_rules_title);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void d(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jvw != null) {
            this.jvw.setVisibility(0);
            bdTypeRecyclerView.addHeaderView(this.jvw);
        }
    }

    public void e(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && this.jvw != null) {
            this.jvw.setVisibility(8);
            bdTypeRecyclerView.removeHeaderView(this.jvw);
        }
    }

    public void setTitle(String str) {
        this.juR.setText(str);
    }

    public void onChangeSkinType(int i) {
        c.br(this.juR).oa(R.string.F_X02).nY(R.color.CAM_X0105);
    }
}
