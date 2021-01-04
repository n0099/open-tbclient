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
    public EMTextView jtR;
    public TbRichTextView jtS;
    public boolean jtT;
    private Context mContext;
    private View mRootView;

    public ForumRuleDetailItemVH(Context context, View view) {
        super(view);
        this.mContext = context;
        this.mRootView = view;
        ap(view);
    }

    private void ap(View view) {
        this.jtR = (EMTextView) view.findViewById(R.id.forum_rule_item_title);
        this.jtS = (TbRichTextView) view.findViewById(R.id.forum_rule_item_content);
        this.jtS.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jtS.getLayoutStrategy();
        layoutStrategy.setLineSpacing(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
        this.jtS.setLayoutStrategy(layoutStrategy);
        onChangeSkinType();
    }

    public void rb(boolean z) {
        this.jtT = z;
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.jtT) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jtR).pE(R.string.F_X02).pC(R.color.CAM_X0301);
            this.jtS.setTextColor(ao.getColor(R.color.CAM_X0301));
            return;
        }
        com.baidu.tbadk.core.elementsMaven.c.bv(this.jtR).pE(R.string.F_X02).pC(R.color.CAM_X0105);
        this.jtS.setTextColor(ao.getColor(R.color.CAM_X0105));
    }
}
