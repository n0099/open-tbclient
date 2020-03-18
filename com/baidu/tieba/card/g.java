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
    private View fJi;
    private View fJj;
    private TextView fJl;
    private TextView fJm;
    private TextView fJn;
    private TextView fJo;
    private TextView fJp;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fJl = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.fJm = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.fJn = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.fJo = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.fJp = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.fJm.setOnClickListener(this);
        this.fJn.setOnClickListener(this);
        this.fJo.setOnClickListener(this);
        this.fJp.setOnClickListener(this);
        this.fJi = view.findViewById(R.id.divider_line_1);
        this.fJj = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.fJi, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fJj, R.color.cp_bg_line_e);
        am.setViewTextColor(this.fJl, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.fJm, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fJn, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fJo, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fJp, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bwJ() != null) {
            if (!TextUtils.isEmpty(eVar.bwJ().title)) {
                this.fJl.setText(eVar.bwJ().title);
            }
            this.fJm.setVisibility(8);
            this.fJn.setVisibility(8);
            this.fJo.setVisibility(8);
            this.fJp.setVisibility(8);
            if (eVar.bwJ().sub_nodes.size() >= 1) {
                this.fJm.setVisibility(0);
                this.fJm.setTag(eVar.bwJ().sub_nodes.get(0).url);
                this.fJm.setText(eVar.bwJ().sub_nodes.get(0).title);
            }
            if (eVar.bwJ().sub_nodes.size() >= 2) {
                this.fJn.setVisibility(0);
                this.fJn.setTag(eVar.bwJ().sub_nodes.get(1).url);
                this.fJn.setText(eVar.bwJ().sub_nodes.get(1).title);
            }
            if (eVar.bwJ().sub_nodes.size() >= 3) {
                this.fJo.setVisibility(0);
                this.fJo.setTag(eVar.bwJ().sub_nodes.get(2).url);
                this.fJo.setText(eVar.bwJ().sub_nodes.get(2).title);
            }
            if (eVar.bwJ().sub_nodes.size() >= 4) {
                this.fJp.setVisibility(0);
                this.fJp.setTag(eVar.bwJ().sub_nodes.get(3).url);
                this.fJp.setText(eVar.bwJ().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fJm || view == this.fJn || view == this.fJo || view == this.fJp) {
            TiebaStatic.log(new an("c13047").X("obj_locate", 8).cx("fid", this.mForumId));
            ba.aGK().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
