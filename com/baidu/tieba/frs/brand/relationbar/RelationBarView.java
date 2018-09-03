package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.layout.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.f;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes2.dex */
public class RelationBarView extends ForbidParentSwipeBackLinearLayout {
    private a dsv;
    private RecyclerView mRecyclerView;
    private int mSkinType;
    private TextView mTitleView;

    public RelationBarView(Context context) {
        super(context);
        this.mSkinType = 3;
        init(context);
    }

    public RelationBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        init(context);
    }

    public RelationBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(f.h.frs_brand_relation_bar_layout, (ViewGroup) this, true);
        setOrientation(1);
        this.mTitleView = (TextView) findViewById(f.g.frs_brand_bar_title);
        this.mRecyclerView = (RecyclerView) findViewById(f.g.frs_brand_bar_list);
        this.dsv = new a(context);
        this.mRecyclerView.setAdapter(this.dsv);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        this.mRecyclerView.addItemDecoration(new c(l.f(context, f.e.tbds44), l.f(context, f.e.tbds22), l.f(context, f.e.tbds44)));
        onChangeSkinType();
    }

    public void setData(List<OriForumInfo> list) {
        if (w.z(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.dsv.setData(list);
        this.dsv.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.j(this, f.d.cp_bg_line_e);
            am.h(this.mTitleView, f.d.cp_cont_f);
            this.dsv.notifyDataSetChanged();
        }
    }
}
