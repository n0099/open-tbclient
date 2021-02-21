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
    public EMTextView jvf;
    public TbRichTextView jvg;
    public boolean jvh;
    private Context mContext;
    private View mRootView;

    public ForumRuleDetailItemVH(Context context, View view) {
        super(view);
        this.mContext = context;
        this.mRootView = view;
        am(view);
    }

    private void am(View view) {
        this.jvf = (EMTextView) view.findViewById(R.id.forum_rule_item_title);
        this.jvg = (TbRichTextView) view.findViewById(R.id.forum_rule_item_content);
        this.jvg.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jvg.getLayoutStrategy();
        layoutStrategy.setLineSpacing(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
        this.jvg.setLayoutStrategy(layoutStrategy);
        onChangeSkinType();
    }

    public void rh(boolean z) {
        this.jvh = z;
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.jvh) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.jvf).oa(R.string.F_X02).nY(R.color.CAM_X0301);
            this.jvg.setTextColor(ap.getColor(R.color.CAM_X0301));
            return;
        }
        com.baidu.tbadk.core.elementsMaven.c.br(this.jvf).oa(R.string.F_X02).nY(R.color.CAM_X0105);
        this.jvg.setTextColor(ap.getColor(R.color.CAM_X0105));
    }
}
