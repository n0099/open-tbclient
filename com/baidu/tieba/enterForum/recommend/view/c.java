package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext efn;
    private TextView hAi;
    private TextView hAj;
    private com.baidu.tieba.enterForum.recommend.b.d hAk;
    private View hkf;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.efn = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hAi = (TextView) view.findViewById(R.id.recommend_title);
        this.hkf = view.findViewById(R.id.top_line);
        this.hAj = (TextView) view.findViewById(R.id.recommend_update);
        this.hAj.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ap.setViewTextColor(this.hAi, R.color.cp_cont_b);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void nJ(boolean z) {
        this.hkf.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.hAk = dVar;
            onChangeSkinType(this.efn, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.hAi.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa<com.baidu.tieba.enterForum.recommend.b.d> cbz;
        if (view == this.hAj && (cbz = cbz()) != null && this.hAk.cgi() < this.hAk.getForumList().size()) {
            cbz.a(view, this.hAk);
        }
    }
}
