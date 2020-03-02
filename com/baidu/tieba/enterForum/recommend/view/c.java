package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext cVh;
    private View fKj;
    private TextView fYA;
    private com.baidu.tieba.enterForum.recommend.b.d fYB;
    private TextView fYz;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cVh = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fYz = (TextView) view.findViewById(R.id.recommend_title);
        this.fKj = view.findViewById(R.id.top_line);
        this.fYA = (TextView) view.findViewById(R.id.recommend_update);
        this.fYA.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.fYz, (int) R.color.cp_cont_b);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void kM(boolean z) {
        this.fKj.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.fYB = dVar;
            onChangeSkinType(this.cVh, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.fYz.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z<com.baidu.tieba.enterForum.recommend.b.d> buG;
        if (view == this.fYA && (buG = buG()) != null && this.fYB.byX() < this.fYB.getForumList().size()) {
            buG.a(view, this.fYB);
        }
    }
}
