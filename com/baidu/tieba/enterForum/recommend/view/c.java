package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.d> {
    private TextView fbk;
    private TextView fbl;
    private com.baidu.tieba.enterForum.recommend.b.d fbm;
    private TbPageContext mContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fbk = (TextView) view.findViewById(R.id.recommend_title);
        this.fbl = (TextView) view.findViewById(R.id.recommend_update);
        this.fbl.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.j(this.fbk, R.color.cp_cont_j);
        am.l(getView(), R.color.cp_bg_line_c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.fbm = dVar;
            onChangeSkinType(this.mContext, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.fbk.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab<com.baidu.tieba.enterForum.recommend.b.d> aZq;
        if (view == this.fbl && (aZq = aZq()) != null && this.fbm.bgz() < this.fbm.getForumList().size()) {
            aZq.a(view, this.fbm);
        }
    }
}
