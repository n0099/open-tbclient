package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.ala.frsgamelive.b.b> {
    private View eCF;
    private TextView eCG;
    private View eCH;
    private int mSkinType;
    private TbPageContext mTbPageContext;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.eCF = view.findViewById(R.id.frs_game_live_recommand_line1);
        this.eCG = (TextView) view.findViewById(R.id.frs_game_live_recommand3);
        this.eCH = view.findViewById(R.id.frs_game_live_recommand_line2);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eCF, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eCG, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.eCH, R.color.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_frs_game_live_recommend_title_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.frsgamelive.b.b bVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public b eCI;

        public a(b bVar) {
            super(bVar.getView());
            this.eCI = bVar;
        }
    }
}
