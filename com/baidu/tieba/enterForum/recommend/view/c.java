package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext dPv;
    private View gRH;
    private TextView hhH;
    private TextView hhI;
    private com.baidu.tieba.enterForum.recommend.b.d hhJ;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dPv = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hhH = (TextView) view.findViewById(R.id.recommend_title);
        this.gRH = view.findViewById(R.id.top_line);
        this.hhI = (TextView) view.findViewById(R.id.recommend_update);
        this.hhI.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        an.setViewTextColor(this.hhH, (int) R.color.cp_cont_b);
        an.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void mA(boolean z) {
        this.gRH.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.hhJ = dVar;
            onChangeSkinType(this.dPv, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.hhH.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa<com.baidu.tieba.enterForum.recommend.b.d> bOc;
        if (view == this.hhI && (bOc = bOc()) != null && this.hhJ.bSD() < this.hhJ.getForumList().size()) {
            bOc.a(view, this.hhJ);
        }
    }
}
