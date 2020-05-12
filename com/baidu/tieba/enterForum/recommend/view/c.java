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
    private TbPageContext duK;
    private TextView gGf;
    private TextView gGg;
    private com.baidu.tieba.enterForum.recommend.b.d gGh;
    private View gpR;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.duK = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.gGf = (TextView) view.findViewById(R.id.recommend_title);
        this.gpR = view.findViewById(R.id.top_line);
        this.gGg = (TextView) view.findViewById(R.id.recommend_update);
        this.gGg.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.gGf, (int) R.color.cp_cont_b);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void lU(boolean z) {
        this.gpR.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.gGh = dVar;
            onChangeSkinType(this.duK, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.gGf.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z<com.baidu.tieba.enterForum.recommend.b.d> bEx;
        if (view == this.gGg && (bEx = bEx()) != null && this.gGh.bJf() < this.gGh.getForumList().size()) {
            bEx.a(view, this.gGh);
        }
    }
}
