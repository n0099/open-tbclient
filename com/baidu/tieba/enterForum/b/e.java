package com.baidu.tieba.enterForum.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.m;
/* loaded from: classes9.dex */
public class e {
    private boolean gNU;
    private ImageView gYW;
    private TbPageContext<?> mPageContext;
    private TextView mTitleView;
    private View mView;

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_title_item_view, (ViewGroup) null);
        this.mTitleView = (TextView) this.mView.findViewById(R.id.text_title);
        this.gYW = (ImageView) this.mView.findViewById(R.id.icon_into);
        this.gYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.b(e.this.mPageContext, null);
                an anVar = new an("c13645");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.ag("obj_locate", 1);
                anVar.ag("obj_type", e.this.gNU ? 5 : 1);
                anVar.ag("obj_source", 2);
                TiebaStatic.log(anVar);
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(m mVar) {
        String title = mVar.getTitle();
        if (!TextUtils.isEmpty(title)) {
            this.mTitleView.setText(title);
        }
        am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        SvgManager.aUV().a(this.gYW, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setHasLikeForum(boolean z) {
        this.gNU = z;
    }
}
