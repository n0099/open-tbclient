package com.baidu.tieba.frs.forumRule.adapter;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ForumRuleDetailItemVH extends TypeAdapter.ViewHolder {
    public EMTextView juR;
    public TbRichTextView juS;
    public boolean juT;
    private Context mContext;
    private View mRootView;

    public ForumRuleDetailItemVH(Context context, View view) {
        super(view);
        this.mContext = context;
        this.mRootView = view;
        am(view);
    }

    private void am(View view) {
        this.juR = (EMTextView) view.findViewById(R.id.forum_rule_item_title);
        this.juS = (TbRichTextView) view.findViewById(R.id.forum_rule_item_content);
        this.juS.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.juS.getLayoutStrategy();
        layoutStrategy.setLineSpacing(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
        this.juS.setLayoutStrategy(layoutStrategy);
        onChangeSkinType();
    }

    public void rh(boolean z) {
        this.juT = z;
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.juT) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.juR).oa(R.string.F_X02).nY(R.color.CAM_X0301);
            this.juS.setTextColor(ap.getColor(R.color.CAM_X0301));
            return;
        }
        com.baidu.tbadk.core.elementsMaven.c.br(this.juR).oa(R.string.F_X02).nY(R.color.CAM_X0105);
        this.juS.setTextColor(ap.getColor(R.color.CAM_X0105));
    }
}
