package com.baidu.tieba.enterForum.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class e {
    private boolean agV;
    private ImageView hls;
    private TbPageContext<?> mPageContext;
    private TextView mTitleView;
    private View mView;

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_title_item_view, (ViewGroup) null);
        this.mTitleView = (TextView) this.mView.findViewById(R.id.text_title);
        this.hls = (ImageView) this.mView.findViewById(R.id.icon_into);
        this.hls.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.b.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.b(e.this.mPageContext, null);
                ao aoVar = new ao("c13645");
                aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar.ag("obj_locate", 1);
                aoVar.ag("obj_type", e.this.agV ? 5 : 1);
                aoVar.ag("obj_source", 2);
                TiebaStatic.log(aoVar);
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bi biVar) {
        String title = biVar.getTitle();
        if (!TextUtils.isEmpty(title)) {
            this.mTitleView.setText(title);
        }
        an.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
        SvgManager.aWQ().a(this.hls, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setHasLikeForum(boolean z) {
        this.agV = z;
    }
}
