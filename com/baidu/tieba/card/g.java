package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g extends a<com.baidu.tieba.e.e> {
    private View eCQ;
    private View eCR;
    private TextView eCT;
    private TextView eCU;
    private TextView eCV;
    private TextView eCW;
    private TextView eCX;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eCT = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.eCU = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.eCV = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.eCW = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.eCX = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.eCU.setOnClickListener(this);
        this.eCV.setOnClickListener(this);
        this.eCW.setOnClickListener(this);
        this.eCX.setOnClickListener(this);
        this.eCQ = view.findViewById(R.id.divider_line_1);
        this.eCR = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.k(getView(), R.color.cp_bg_line_d);
        am.k(this.eCQ, R.color.cp_bg_line_e);
        am.k(this.eCR, R.color.cp_bg_line_e);
        am.f(this.eCT, R.color.cp_cont_f, 1);
        am.f(this.eCU, R.color.cp_cont_b, 1);
        am.f(this.eCV, R.color.cp_cont_b, 1);
        am.f(this.eCW, R.color.cp_cont_b, 1);
        am.f(this.eCX, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.beF() != null) {
            if (!TextUtils.isEmpty(eVar.beF().title)) {
                this.eCT.setText(eVar.beF().title);
            }
            this.eCU.setVisibility(8);
            this.eCV.setVisibility(8);
            this.eCW.setVisibility(8);
            this.eCX.setVisibility(8);
            if (eVar.beF().sub_nodes.size() >= 1) {
                this.eCU.setVisibility(0);
                this.eCU.setTag(eVar.beF().sub_nodes.get(0).url);
                this.eCU.setText(eVar.beF().sub_nodes.get(0).title);
            }
            if (eVar.beF().sub_nodes.size() >= 2) {
                this.eCV.setVisibility(0);
                this.eCV.setTag(eVar.beF().sub_nodes.get(1).url);
                this.eCV.setText(eVar.beF().sub_nodes.get(1).title);
            }
            if (eVar.beF().sub_nodes.size() >= 3) {
                this.eCW.setVisibility(0);
                this.eCW.setTag(eVar.beF().sub_nodes.get(2).url);
                this.eCW.setText(eVar.beF().sub_nodes.get(2).title);
            }
            if (eVar.beF().sub_nodes.size() >= 4) {
                this.eCX.setVisibility(0);
                this.eCX.setTag(eVar.beF().sub_nodes.get(3).url);
                this.eCX.setText(eVar.beF().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eCU || view == this.eCV || view == this.eCW || view == this.eCX) {
            TiebaStatic.log(new an("c13047").P("obj_locate", 8).bT("fid", this.mForumId));
            ba.ajK().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
