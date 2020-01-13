package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext cRe;
    private TextView fWw;
    private TextView fWx;
    private com.baidu.tieba.enterForum.recommend.b.d fWy;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cRe = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fWw = (TextView) view.findViewById(R.id.recommend_title);
        this.fWx = (TextView) view.findViewById(R.id.recommend_update);
        this.fWx.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.fWw, (int) R.color.cp_cont_b);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.fWy = dVar;
            onChangeSkinType(this.cRe, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.fWw.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z<com.baidu.tieba.enterForum.recommend.b.d> bta;
        if (view == this.fWx && (bta = bta()) != null && this.fWy.bxt() < this.fWy.getForumList().size()) {
            bta.a(view, this.fWy);
        }
    }
}
