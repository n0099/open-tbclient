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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.layout.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.R;
import java.util.List;
import tbclient.OriForumInfo;
/* loaded from: classes22.dex */
public class RelationBarView extends ForbidParentSwipeBackLinearLayout {
    private a ixz;
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
        LayoutInflater.from(context).inflate(R.layout.frs_brand_relation_bar_layout, (ViewGroup) this, true);
        setOrientation(1);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.frs_brand_bar_list);
        this.ixz = new a(context);
        this.mRecyclerView.setAdapter(this.ixz);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        int dimens = l.getDimens(context, R.dimen.tbds44);
        this.mRecyclerView.addItemDecoration(new c(dimens, l.getDimens(context, R.dimen.tbds26), dimens));
        onChangeSkinType();
    }

    public void setData(List<OriForumInfo> list) {
        if (y.isEmpty(list)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ixz.setData(list);
        this.ixz.notifyDataSetChanged();
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            ap.setBackgroundColor(this, R.color.cp_bg_line_e);
            this.ixz.notifyDataSetChanged();
        }
    }
}
