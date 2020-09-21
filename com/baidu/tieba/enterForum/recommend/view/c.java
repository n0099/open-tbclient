package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext ehG;
    private TextView hHq;
    private TextView hHr;
    private com.baidu.tieba.enterForum.recommend.b.d hHs;
    private View hrm;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ehG = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hHq = (TextView) view.findViewById(R.id.recommend_title);
        this.hrm = view.findViewById(R.id.top_line);
        this.hHr = (TextView) view.findViewById(R.id.recommend_update);
        this.hHr.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ap.setViewTextColor(this.hHq, R.color.cp_cont_b);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void nR(boolean z) {
        this.hrm.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.hHs = dVar;
            onChangeSkinType(this.ehG, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.hHq.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa<com.baidu.tieba.enterForum.recommend.b.d> ceP;
        if (view == this.hHr && (ceP = ceP()) != null && this.hHs.cjA() < this.hHs.getForumList().size()) {
            ceP.a(view, this.hHs);
        }
    }
}
