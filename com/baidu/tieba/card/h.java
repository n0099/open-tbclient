package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class h extends b<com.baidu.tieba.e.e> {
    private TextView hpA;
    private TextView hpB;
    private TextView hpC;
    private View hpv;
    private View hpw;
    private TextView hpy;
    private TextView hpz;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hpy = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.hpz = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.hpA = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.hpB = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.hpC = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.hpz.setOnClickListener(this);
        this.hpA.setOnClickListener(this);
        this.hpB.setOnClickListener(this);
        this.hpC.setOnClickListener(this);
        this.hpv = view.findViewById(R.id.divider_line_1);
        this.hpw = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.hpv, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hpw, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.hpy, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.hpz, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hpA, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hpB, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hpC, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.cgI() != null) {
            if (!TextUtils.isEmpty(eVar.cgI().title)) {
                this.hpy.setText(eVar.cgI().title);
            }
            this.hpz.setVisibility(8);
            this.hpA.setVisibility(8);
            this.hpB.setVisibility(8);
            this.hpC.setVisibility(8);
            if (eVar.cgI().sub_nodes.size() >= 1) {
                this.hpz.setVisibility(0);
                this.hpz.setTag(eVar.cgI().sub_nodes.get(0).url);
                this.hpz.setText(eVar.cgI().sub_nodes.get(0).title);
            }
            if (eVar.cgI().sub_nodes.size() >= 2) {
                this.hpA.setVisibility(0);
                this.hpA.setTag(eVar.cgI().sub_nodes.get(1).url);
                this.hpA.setText(eVar.cgI().sub_nodes.get(1).title);
            }
            if (eVar.cgI().sub_nodes.size() >= 3) {
                this.hpB.setVisibility(0);
                this.hpB.setTag(eVar.cgI().sub_nodes.get(2).url);
                this.hpB.setText(eVar.cgI().sub_nodes.get(2).title);
            }
            if (eVar.cgI().sub_nodes.size() >= 4) {
                this.hpC.setVisibility(0);
                this.hpC.setTag(eVar.cgI().sub_nodes.get(3).url);
                this.hpC.setText(eVar.cgI().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hpz || view == this.hpA || view == this.hpB || view == this.hpC) {
            TiebaStatic.log(new aq("c13047").ai("obj_locate", 8).dF("fid", this.mForumId));
            be.bkp().a((TbPageContext) com.baidu.adp.base.i.I(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
