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
    private TbPageContext efr;
    private TextView hAo;
    private TextView hAp;
    private com.baidu.tieba.enterForum.recommend.b.d hAq;
    private View hkj;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.efr = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hAo = (TextView) view.findViewById(R.id.recommend_title);
        this.hkj = view.findViewById(R.id.top_line);
        this.hAp = (TextView) view.findViewById(R.id.recommend_update);
        this.hAp.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ap.setViewTextColor(this.hAo, R.color.cp_cont_b);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void nL(boolean z) {
        this.hkj.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.hAq = dVar;
            onChangeSkinType(this.efr, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.hAo.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa<com.baidu.tieba.enterForum.recommend.b.d> cbA;
        if (view == this.hAp && (cbA = cbA()) != null && this.hAq.cgj() < this.hAq.getForumList().size()) {
            cbA.a(view, this.hAq);
        }
    }
}
