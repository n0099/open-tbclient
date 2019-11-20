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
    private View eKG;
    private View eKH;
    private TextView eKJ;
    private TextView eKK;
    private TextView eKL;
    private TextView eKM;
    private TextView eKN;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eKJ = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.eKK = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.eKL = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.eKM = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.eKN = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.eKK.setOnClickListener(this);
        this.eKL.setOnClickListener(this);
        this.eKM.setOnClickListener(this);
        this.eKN.setOnClickListener(this);
        this.eKG = view.findViewById(R.id.divider_line_1);
        this.eKH = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.eKG, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.eKH, R.color.cp_bg_line_e);
        am.setViewTextColor(this.eKJ, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.eKK, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.eKL, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.eKM, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.eKN, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bcy() != null) {
            if (!TextUtils.isEmpty(eVar.bcy().title)) {
                this.eKJ.setText(eVar.bcy().title);
            }
            this.eKK.setVisibility(8);
            this.eKL.setVisibility(8);
            this.eKM.setVisibility(8);
            this.eKN.setVisibility(8);
            if (eVar.bcy().sub_nodes.size() >= 1) {
                this.eKK.setVisibility(0);
                this.eKK.setTag(eVar.bcy().sub_nodes.get(0).url);
                this.eKK.setText(eVar.bcy().sub_nodes.get(0).title);
            }
            if (eVar.bcy().sub_nodes.size() >= 2) {
                this.eKL.setVisibility(0);
                this.eKL.setTag(eVar.bcy().sub_nodes.get(1).url);
                this.eKL.setText(eVar.bcy().sub_nodes.get(1).title);
            }
            if (eVar.bcy().sub_nodes.size() >= 3) {
                this.eKM.setVisibility(0);
                this.eKM.setTag(eVar.bcy().sub_nodes.get(2).url);
                this.eKM.setText(eVar.bcy().sub_nodes.get(2).title);
            }
            if (eVar.bcy().sub_nodes.size() >= 4) {
                this.eKN.setVisibility(0);
                this.eKN.setTag(eVar.bcy().sub_nodes.get(3).url);
                this.eKN.setText(eVar.bcy().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eKK || view == this.eKL || view == this.eKM || view == this.eKN) {
            TiebaStatic.log(new an("c13047").O("obj_locate", 8).bS("fid", this.mForumId));
            ba.amO().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
