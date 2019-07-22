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
    private View eBa;
    private View eBb;
    private TextView eBd;
    private TextView eBe;
    private TextView eBf;
    private TextView eBg;
    private TextView eBh;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eBd = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.eBe = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.eBf = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.eBg = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.eBh = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.eBe.setOnClickListener(this);
        this.eBf.setOnClickListener(this);
        this.eBg.setOnClickListener(this);
        this.eBh.setOnClickListener(this);
        this.eBa = view.findViewById(R.id.divider_line_1);
        this.eBb = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.k(getView(), R.color.cp_bg_line_d);
        am.k(this.eBa, R.color.cp_bg_line_e);
        am.k(this.eBb, R.color.cp_bg_line_e);
        am.f(this.eBd, R.color.cp_cont_f, 1);
        am.f(this.eBe, R.color.cp_cont_b, 1);
        am.f(this.eBf, R.color.cp_cont_b, 1);
        am.f(this.eBg, R.color.cp_cont_b, 1);
        am.f(this.eBh, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bdZ() != null) {
            if (!TextUtils.isEmpty(eVar.bdZ().title)) {
                this.eBd.setText(eVar.bdZ().title);
            }
            this.eBe.setVisibility(8);
            this.eBf.setVisibility(8);
            this.eBg.setVisibility(8);
            this.eBh.setVisibility(8);
            if (eVar.bdZ().sub_nodes.size() >= 1) {
                this.eBe.setVisibility(0);
                this.eBe.setTag(eVar.bdZ().sub_nodes.get(0).url);
                this.eBe.setText(eVar.bdZ().sub_nodes.get(0).title);
            }
            if (eVar.bdZ().sub_nodes.size() >= 2) {
                this.eBf.setVisibility(0);
                this.eBf.setTag(eVar.bdZ().sub_nodes.get(1).url);
                this.eBf.setText(eVar.bdZ().sub_nodes.get(1).title);
            }
            if (eVar.bdZ().sub_nodes.size() >= 3) {
                this.eBg.setVisibility(0);
                this.eBg.setTag(eVar.bdZ().sub_nodes.get(2).url);
                this.eBg.setText(eVar.bdZ().sub_nodes.get(2).title);
            }
            if (eVar.bdZ().sub_nodes.size() >= 4) {
                this.eBh.setVisibility(0);
                this.eBh.setTag(eVar.bdZ().sub_nodes.get(3).url);
                this.eBh.setText(eVar.bdZ().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eBe || view == this.eBf || view == this.eBg || view == this.eBh) {
            TiebaStatic.log(new an("c13047").P("obj_locate", 8).bT("fid", this.mForumId));
            bb.ajC().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
