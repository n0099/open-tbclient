package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g extends a<com.baidu.tieba.e.e> {
    private View ewa;
    private View ewb;
    private TextView ewd;
    private TextView ewe;
    private TextView ewf;
    private TextView ewg;
    private TextView ewh;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ewd = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.ewe = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.ewf = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.ewg = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.ewh = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.ewe.setOnClickListener(this);
        this.ewf.setOnClickListener(this);
        this.ewg.setOnClickListener(this);
        this.ewh.setOnClickListener(this);
        this.ewa = view.findViewById(R.id.divider_line_1);
        this.ewb = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.k(getView(), R.color.cp_bg_line_d);
        al.k(this.ewa, R.color.cp_bg_line_e);
        al.k(this.ewb, R.color.cp_bg_line_e);
        al.f(this.ewd, R.color.cp_cont_f, 1);
        al.f(this.ewe, R.color.cp_cont_b, 1);
        al.f(this.ewf, R.color.cp_cont_b, 1);
        al.f(this.ewg, R.color.cp_cont_b, 1);
        al.f(this.ewh, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bbV() != null) {
            if (!TextUtils.isEmpty(eVar.bbV().title)) {
                this.ewd.setText(eVar.bbV().title);
            }
            this.ewe.setVisibility(8);
            this.ewf.setVisibility(8);
            this.ewg.setVisibility(8);
            this.ewh.setVisibility(8);
            if (eVar.bbV().sub_nodes.size() >= 1) {
                this.ewe.setVisibility(0);
                this.ewe.setTag(eVar.bbV().sub_nodes.get(0).url);
                this.ewe.setText(eVar.bbV().sub_nodes.get(0).title);
            }
            if (eVar.bbV().sub_nodes.size() >= 2) {
                this.ewf.setVisibility(0);
                this.ewf.setTag(eVar.bbV().sub_nodes.get(1).url);
                this.ewf.setText(eVar.bbV().sub_nodes.get(1).title);
            }
            if (eVar.bbV().sub_nodes.size() >= 3) {
                this.ewg.setVisibility(0);
                this.ewg.setTag(eVar.bbV().sub_nodes.get(2).url);
                this.ewg.setText(eVar.bbV().sub_nodes.get(2).title);
            }
            if (eVar.bbV().sub_nodes.size() >= 4) {
                this.ewh.setVisibility(0);
                this.ewh.setTag(eVar.bbV().sub_nodes.get(3).url);
                this.ewh.setText(eVar.bbV().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ewe || view == this.ewf || view == this.ewg || view == this.ewh) {
            TiebaStatic.log(new am("c13047").P("obj_locate", 8).bT("fid", this.mForumId));
            ba.aiz().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
