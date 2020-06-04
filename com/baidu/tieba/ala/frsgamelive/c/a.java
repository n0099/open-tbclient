package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.a> {
    private TextView fvE;
    private TextView fvF;
    private int mSkinType;
    private TbPageContext mTbPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.fvE = (TextView) view.findViewById(R.id.frs_game_live_recommand1);
        this.fvF = (TextView) view.findViewById(R.id.frs_game_live_recommand2);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.fvE, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.fvF, (int) R.color.cp_cont_d);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_frs_game_live_no_data_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.frsgamelive.b.a aVar) {
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* renamed from: com.baidu.tieba.ala.frsgamelive.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0537a extends aa.a {
        public a fvG;

        public C0537a(a aVar) {
            super(aVar.getView());
            this.fvG = aVar;
        }
    }
}
