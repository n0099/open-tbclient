package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.frsgamelive.b.a> {
    private TextView gxV;
    private TextView gxW;
    private int mSkinType;
    private TbPageContext mTbPageContext;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.gxV = (TextView) view.findViewById(R.id.frs_game_live_recommand1);
        this.gxW = (TextView) view.findViewById(R.id.frs_game_live_recommand2);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.gxV, R.color.cp_cont_d);
            ap.setViewTextColor(this.gxW, R.color.cp_cont_d);
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
    /* loaded from: classes4.dex */
    public static class C0631a extends af.a {
        public a gxX;

        public C0631a(a aVar) {
            super(aVar.getView());
            this.gxX = aVar;
        }
    }
}
