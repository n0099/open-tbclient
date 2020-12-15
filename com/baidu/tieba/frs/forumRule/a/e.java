package com.baidu.tieba.frs.forumRule.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class e extends af.a {
    public EMTextView jhr;
    public TbRichTextView jhs;
    public boolean jht;
    private Context mContext;
    private View mRootView;

    public e(Context context, View view) {
        super(view);
        this.mContext = context;
        this.mRootView = view;
        an(view);
    }

    private void an(View view) {
        this.jhr = (EMTextView) view.findViewById(R.id.forum_rule_item_title);
        this.jhs = (TbRichTextView) view.findViewById(R.id.forum_rule_item_content);
        this.jhs.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jhs.getLayoutStrategy();
        layoutStrategy.setLineSpacing(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
        this.jhs.setLayoutStrategy(layoutStrategy);
        onChangeSkinType();
    }

    public void qD(boolean z) {
        this.jht = z;
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.jht) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jhr).pu(R.string.F_X02).ps(R.color.CAM_X0301);
            this.jhs.setTextColor(ap.getColor(R.color.CAM_X0301));
            return;
        }
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jhr).pu(R.string.F_X02).ps(R.color.CAM_X0105);
        this.jhs.setTextColor(ap.getColor(R.color.CAM_X0105));
    }
}
