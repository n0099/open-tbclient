package com.baidu.tieba.frs.forumRule.adapter;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ForumRuleDetailItemVH extends TypeAdapter.ViewHolder {
    public EMTextView jpl;
    public TbRichTextView jpm;
    public boolean jpn;
    private Context mContext;
    private View mRootView;

    public ForumRuleDetailItemVH(Context context, View view) {
        super(view);
        this.mContext = context;
        this.mRootView = view;
        ap(view);
    }

    private void ap(View view) {
        this.jpl = (EMTextView) view.findViewById(R.id.forum_rule_item_title);
        this.jpm = (TbRichTextView) view.findViewById(R.id.forum_rule_item_content);
        this.jpm.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jpm.getLayoutStrategy();
        layoutStrategy.setLineSpacing(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
        this.jpm.setLayoutStrategy(layoutStrategy);
        onChangeSkinType();
    }

    public void qX(boolean z) {
        this.jpn = z;
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.jpn) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jpl).nX(R.string.F_X02).nV(R.color.CAM_X0301);
            this.jpm.setTextColor(ao.getColor(R.color.CAM_X0301));
            return;
        }
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jpl).nX(R.string.F_X02).nV(R.color.CAM_X0105);
        this.jpm.setTextColor(ao.getColor(R.color.CAM_X0105));
    }
}
