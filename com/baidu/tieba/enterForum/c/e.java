package com.baidu.tieba.enterForum.c;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.bp;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private boolean akH;
    private ImageView iTp;
    private TbPageContext<?> mPageContext;
    private TextView mTitleView;
    private View mView;

    public e(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_title_item_view, (ViewGroup) null);
        this.mTitleView = (TextView) this.mView.findViewById(R.id.text_title);
        this.iTp = (ImageView) this.mView.findViewById(R.id.icon_into);
        this.iTp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.c.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.enterForum.b.d(e.this.mPageContext, null);
                ar arVar = new ar("c13645");
                arVar.v("uid", TbadkApplication.getCurrentAccountId());
                arVar.aq("obj_locate", 1);
                arVar.aq("obj_type", e.this.akH ? 5 : 1);
                arVar.aq("obj_source", 2);
                TiebaStatic.log(arVar);
            }
        });
    }

    public View getView() {
        return this.mView;
    }

    public void a(bp bpVar) {
        String title = bpVar.getTitle();
        if (!TextUtils.isEmpty(title)) {
            this.mTitleView.setText(title);
        }
        ap.setViewTextColor(this.mTitleView, R.color.CAM_X0105);
        SvgManager.bsU().a(this.iTp, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setHasLikeForum(boolean z) {
        this.akH = z;
    }
}
