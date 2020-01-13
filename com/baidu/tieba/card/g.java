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
/* loaded from: classes7.dex */
public class g extends a<com.baidu.tieba.e.e> {
    private View fFO;
    private View fFP;
    private TextView fFR;
    private TextView fFS;
    private TextView fFT;
    private TextView fFU;
    private TextView fFV;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fFR = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.fFS = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.fFT = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.fFU = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.fFV = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.fFS.setOnClickListener(this);
        this.fFT.setOnClickListener(this);
        this.fFU.setOnClickListener(this);
        this.fFV.setOnClickListener(this);
        this.fFO = view.findViewById(R.id.divider_line_1);
        this.fFP = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.fFO, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fFP, R.color.cp_bg_line_e);
        am.setViewTextColor(this.fFR, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.fFS, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fFT, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fFU, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fFV, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.buX() != null) {
            if (!TextUtils.isEmpty(eVar.buX().title)) {
                this.fFR.setText(eVar.buX().title);
            }
            this.fFS.setVisibility(8);
            this.fFT.setVisibility(8);
            this.fFU.setVisibility(8);
            this.fFV.setVisibility(8);
            if (eVar.buX().sub_nodes.size() >= 1) {
                this.fFS.setVisibility(0);
                this.fFS.setTag(eVar.buX().sub_nodes.get(0).url);
                this.fFS.setText(eVar.buX().sub_nodes.get(0).title);
            }
            if (eVar.buX().sub_nodes.size() >= 2) {
                this.fFT.setVisibility(0);
                this.fFT.setTag(eVar.buX().sub_nodes.get(1).url);
                this.fFT.setText(eVar.buX().sub_nodes.get(1).title);
            }
            if (eVar.buX().sub_nodes.size() >= 3) {
                this.fFU.setVisibility(0);
                this.fFU.setTag(eVar.buX().sub_nodes.get(2).url);
                this.fFU.setText(eVar.buX().sub_nodes.get(2).title);
            }
            if (eVar.buX().sub_nodes.size() >= 4) {
                this.fFV.setVisibility(0);
                this.fFV.setTag(eVar.buX().sub_nodes.get(3).url);
                this.fFV.setText(eVar.buX().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fFS || view == this.fFT || view == this.fFU || view == this.fFV) {
            TiebaStatic.log(new an("c13047").Z("obj_locate", 8).cp("fid", this.mForumId));
            ba.aEt().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
