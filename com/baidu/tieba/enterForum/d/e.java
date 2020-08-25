package com.baidu.tieba.enterForum.d;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class e {
    private boolean ahV;
    private ImageView hDV;
    private TbPageContext<?> mPageContext;
    private TextView mTitleView;
    private View mView;

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_title_item_view, (ViewGroup) null);
        this.mTitleView = (TextView) this.mView.findViewById(R.id.text_title);
        this.hDV = (ImageView) this.mView.findViewById(R.id.icon_into);
        this.hDV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.d.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(e.this.mPageContext, null);
                aq aqVar = new aq("c13645");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.ai("obj_locate", 1);
                aqVar.ai("obj_type", e.this.ahV ? 5 : 1);
                aqVar.ai("obj_source", 2);
                TiebaStatic.log(aqVar);
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bk bkVar) {
        String title = bkVar.getTitle();
        if (!TextUtils.isEmpty(title)) {
            this.mTitleView.setText(title);
        }
        ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        SvgManager.bjq().a(this.hDV, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setHasLikeForum(boolean z) {
        this.ahV = z;
    }
}
