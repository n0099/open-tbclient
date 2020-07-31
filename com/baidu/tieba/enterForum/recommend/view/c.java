package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext dVN;
    private View gXm;
    private TextView hnr;
    private TextView hns;
    private com.baidu.tieba.enterForum.recommend.b.d hnt;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dVN = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hnr = (TextView) view.findViewById(R.id.recommend_title);
        this.gXm = view.findViewById(R.id.top_line);
        this.hns = (TextView) view.findViewById(R.id.recommend_update);
        this.hns.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ao.setViewTextColor(this.hnr, R.color.cp_cont_b);
        ao.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void nf(boolean z) {
        this.gXm.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.hnt = dVar;
            onChangeSkinType(this.dVN, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.hnr.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa<com.baidu.tieba.enterForum.recommend.b.d> bRn;
        if (view == this.hns && (bRn = bRn()) != null && this.hnt.bVV() < this.hnt.getForumList().size()) {
            bRn.a(view, this.hnt);
        }
    }
}
