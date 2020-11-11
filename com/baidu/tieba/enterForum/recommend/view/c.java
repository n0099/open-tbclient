package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext eIc;
    private View hYA;
    private TextView ioK;
    private TextView ioL;
    private com.baidu.tieba.enterForum.recommend.b.d ioM;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eIc = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.ioK = (TextView) view.findViewById(R.id.recommend_title);
        this.hYA = view.findViewById(R.id.top_line);
        this.ioL = (TextView) view.findViewById(R.id.recommend_update);
        this.ioL.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ap.setViewTextColor(this.ioK, R.color.cp_cont_b);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void oX(boolean z) {
        this.hYA.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.ioM = dVar;
            onChangeSkinType(this.eIc, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.ioK.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab<com.baidu.tieba.enterForum.recommend.b.d> cnT;
        if (view == this.ioL && (cnT = cnT()) != null && this.ioM.csE() < this.ioM.getForumList().size()) {
            cnT.a(view, this.ioM);
        }
    }
}
