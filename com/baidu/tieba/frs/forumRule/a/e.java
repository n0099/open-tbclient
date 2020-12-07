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
    public EMTextView jhp;
    public TbRichTextView jhq;
    public boolean jhr;
    private Context mContext;
    private View mRootView;

    public e(Context context, View view) {
        super(view);
        this.mContext = context;
        this.mRootView = view;
        an(view);
    }

    private void an(View view) {
        this.jhp = (EMTextView) view.findViewById(R.id.forum_rule_item_title);
        this.jhq = (TbRichTextView) view.findViewById(R.id.forum_rule_item_content);
        this.jhq.setTextSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X07));
        com.baidu.tbadk.widget.richText.a layoutStrategy = this.jhq.getLayoutStrategy();
        layoutStrategy.setLineSpacing(TbadkApplication.getInst().getResources().getDimension(R.dimen.tbds28), 1.0f);
        this.jhq.setLayoutStrategy(layoutStrategy);
        onChangeSkinType();
    }

    public void qD(boolean z) {
        this.jhr = z;
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        if (this.jhr) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jhp).pu(R.string.F_X02).ps(R.color.CAM_X0301);
            this.jhq.setTextColor(ap.getColor(R.color.CAM_X0301));
            return;
        }
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jhp).pu(R.string.F_X02).ps(R.color.CAM_X0105);
        this.jhq.setTextColor(ap.getColor(R.color.CAM_X0105));
    }
}
