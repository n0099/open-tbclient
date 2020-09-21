package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.b> {
    private View gbC;
    private TextView gbD;
    private View gbE;
    private int mSkinType;
    private TbPageContext mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gbC = view.findViewById(R.id.frs_game_live_recommand_line1);
        this.gbD = (TextView) view.findViewById(R.id.frs_game_live_recommand3);
        this.gbE = view.findViewById(R.id.frs_game_live_recommand_line2);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gbC, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.gbD, R.color.cp_cont_d);
            ap.setBackgroundResource(this.gbE, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_frs_game_live_recommend_title_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.b bVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public b gbF;

        public a(b bVar) {
            super(bVar.getView());
            this.gbF = bVar;
        }
    }
}
