package com.baidu.tieba.enterForum.c;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class e {
    private boolean agM;
    private ImageView hre;
    private TbPageContext<?> mPageContext;
    private TextView mTitleView;
    private View mView;

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_title_item_view, (ViewGroup) null);
        this.mTitleView = (TextView) this.mView.findViewById(R.id.text_title);
        this.hre = (ImageView) this.mView.findViewById(R.id.icon_into);
        this.hre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(e.this.mPageContext, null);
                ap apVar = new ap("c13645");
                apVar.t("uid", TbadkApplication.getCurrentAccountId());
                apVar.ah("obj_locate", 1);
                apVar.ah("obj_type", e.this.agM ? 5 : 1);
                apVar.ah("obj_source", 2);
                TiebaStatic.log(apVar);
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bj bjVar) {
        String title = bjVar.getTitle();
        if (!TextUtils.isEmpty(title)) {
            this.mTitleView.setText(title);
        }
        ao.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
        SvgManager.baR().a(this.hre, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setHasLikeForum(boolean z) {
        this.agM = z;
    }
}
