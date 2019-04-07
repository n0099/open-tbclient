package com.baidu.tieba.frs.brand.relationbar;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.layout.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.d;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes4.dex */
public class RelationBarView extends ForbidParentSwipeBackLinearLayout {
    private a ffK;
    private RecyclerView mRecyclerView;
    private int mSkinType;

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
        LayoutInflater.from(context).inflate(d.h.frs_brand_relation_bar_layout, (ViewGroup) this, true);
        setOrientation(1);
        this.mRecyclerView = (RecyclerView) findViewById(d.g.frs_brand_bar_list);
        this.ffK = new a(context);
        this.mRecyclerView.setAdapter(this.ffK);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        int h = l.h(context, d.e.tbds44);
        this.mRecyclerView.addItemDecoration(new c(h, l.h(context, d.e.tbds26), h));
        onChangeSkinType();
    }

    public void setData(List<OriForumInfo> list) {
        if (v.T(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ffK.setData(list);
        this.ffK.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.l(this, d.C0277d.cp_bg_line_e);
            this.ffK.notifyDataSetChanged();
        }
    }
}
