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
/* loaded from: classes9.dex */
public class g extends a<com.baidu.tieba.e.e> {
    private View gnO;
    private View gnP;
    private TextView gnR;
    private TextView gnS;
    private TextView gnT;
    private TextView gnU;
    private TextView gnV;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gnR = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.gnS = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.gnT = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.gnU = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.gnV = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.gnS.setOnClickListener(this);
        this.gnT.setOnClickListener(this);
        this.gnU.setOnClickListener(this);
        this.gnV.setOnClickListener(this);
        this.gnO = view.findViewById(R.id.divider_line_1);
        this.gnP = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.gnO, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.gnP, R.color.cp_bg_line_e);
        am.setViewTextColor(this.gnR, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.gnS, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gnT, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gnU, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gnV, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bGv() != null) {
            if (!TextUtils.isEmpty(eVar.bGv().title)) {
                this.gnR.setText(eVar.bGv().title);
            }
            this.gnS.setVisibility(8);
            this.gnT.setVisibility(8);
            this.gnU.setVisibility(8);
            this.gnV.setVisibility(8);
            if (eVar.bGv().sub_nodes.size() >= 1) {
                this.gnS.setVisibility(0);
                this.gnS.setTag(eVar.bGv().sub_nodes.get(0).url);
                this.gnS.setText(eVar.bGv().sub_nodes.get(0).title);
            }
            if (eVar.bGv().sub_nodes.size() >= 2) {
                this.gnT.setVisibility(0);
                this.gnT.setTag(eVar.bGv().sub_nodes.get(1).url);
                this.gnT.setText(eVar.bGv().sub_nodes.get(1).title);
            }
            if (eVar.bGv().sub_nodes.size() >= 3) {
                this.gnU.setVisibility(0);
                this.gnU.setTag(eVar.bGv().sub_nodes.get(2).url);
                this.gnU.setText(eVar.bGv().sub_nodes.get(2).title);
            }
            if (eVar.bGv().sub_nodes.size() >= 4) {
                this.gnV.setVisibility(0);
                this.gnV.setTag(eVar.bGv().sub_nodes.get(3).url);
                this.gnV.setText(eVar.bGv().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gnS || view == this.gnT || view == this.gnU || view == this.gnV) {
            TiebaStatic.log(new an("c13047").af("obj_locate", 8).cI("fid", this.mForumId));
            ba.aOY().a((TbPageContext) com.baidu.adp.base.i.T(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
