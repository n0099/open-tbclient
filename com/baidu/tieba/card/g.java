package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g extends a<com.baidu.tieba.e.e> {
    private View eBh;
    private View eBi;
    private TextView eBk;
    private TextView eBl;
    private TextView eBm;
    private TextView eBn;
    private TextView eBo;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eBk = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.eBl = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.eBm = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.eBn = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.eBo = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.eBl.setOnClickListener(this);
        this.eBm.setOnClickListener(this);
        this.eBn.setOnClickListener(this);
        this.eBo.setOnClickListener(this);
        this.eBh = view.findViewById(R.id.divider_line_1);
        this.eBi = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.k(getView(), R.color.cp_bg_line_d);
        am.k(this.eBh, R.color.cp_bg_line_e);
        am.k(this.eBi, R.color.cp_bg_line_e);
        am.f(this.eBk, R.color.cp_cont_f, 1);
        am.f(this.eBl, R.color.cp_cont_b, 1);
        am.f(this.eBm, R.color.cp_cont_b, 1);
        am.f(this.eBn, R.color.cp_cont_b, 1);
        am.f(this.eBo, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.beb() != null) {
            if (!TextUtils.isEmpty(eVar.beb().title)) {
                this.eBk.setText(eVar.beb().title);
            }
            this.eBl.setVisibility(8);
            this.eBm.setVisibility(8);
            this.eBn.setVisibility(8);
            this.eBo.setVisibility(8);
            if (eVar.beb().sub_nodes.size() >= 1) {
                this.eBl.setVisibility(0);
                this.eBl.setTag(eVar.beb().sub_nodes.get(0).url);
                this.eBl.setText(eVar.beb().sub_nodes.get(0).title);
            }
            if (eVar.beb().sub_nodes.size() >= 2) {
                this.eBm.setVisibility(0);
                this.eBm.setTag(eVar.beb().sub_nodes.get(1).url);
                this.eBm.setText(eVar.beb().sub_nodes.get(1).title);
            }
            if (eVar.beb().sub_nodes.size() >= 3) {
                this.eBn.setVisibility(0);
                this.eBn.setTag(eVar.beb().sub_nodes.get(2).url);
                this.eBn.setText(eVar.beb().sub_nodes.get(2).title);
            }
            if (eVar.beb().sub_nodes.size() >= 4) {
                this.eBo.setVisibility(0);
                this.eBo.setTag(eVar.beb().sub_nodes.get(3).url);
                this.eBo.setText(eVar.beb().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eBl || view == this.eBm || view == this.eBn || view == this.eBo) {
            TiebaStatic.log(new an("c13047").P("obj_locate", 8).bT("fid", this.mForumId));
            bb.ajE().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
