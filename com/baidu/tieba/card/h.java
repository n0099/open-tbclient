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
/* loaded from: classes22.dex */
public class h extends b<com.baidu.tieba.e.e> {
    private View hEp;
    private View hEq;
    private TextView hEs;
    private TextView hEt;
    private TextView hEu;
    private TextView hEv;
    private TextView hEw;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hEs = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.hEt = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.hEu = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.hEv = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.hEw = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.hEt.setOnClickListener(this);
        this.hEu.setOnClickListener(this);
        this.hEv.setOnClickListener(this);
        this.hEw.setOnClickListener(this);
        this.hEp = view.findViewById(R.id.divider_line_1);
        this.hEq = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.hEp, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hEq, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.hEs, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.hEt, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hEu, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hEv, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hEw, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.cke() != null) {
            if (!TextUtils.isEmpty(eVar.cke().title)) {
                this.hEs.setText(eVar.cke().title);
            }
            this.hEt.setVisibility(8);
            this.hEu.setVisibility(8);
            this.hEv.setVisibility(8);
            this.hEw.setVisibility(8);
            if (eVar.cke().sub_nodes.size() >= 1) {
                this.hEt.setVisibility(0);
                this.hEt.setTag(eVar.cke().sub_nodes.get(0).url);
                this.hEt.setText(eVar.cke().sub_nodes.get(0).title);
            }
            if (eVar.cke().sub_nodes.size() >= 2) {
                this.hEu.setVisibility(0);
                this.hEu.setTag(eVar.cke().sub_nodes.get(1).url);
                this.hEu.setText(eVar.cke().sub_nodes.get(1).title);
            }
            if (eVar.cke().sub_nodes.size() >= 3) {
                this.hEv.setVisibility(0);
                this.hEv.setTag(eVar.cke().sub_nodes.get(2).url);
                this.hEv.setText(eVar.cke().sub_nodes.get(2).title);
            }
            if (eVar.cke().sub_nodes.size() >= 4) {
                this.hEw.setVisibility(0);
                this.hEw.setTag(eVar.cke().sub_nodes.get(3).url);
                this.hEw.setText(eVar.cke().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hEt || view == this.hEu || view == this.hEv || view == this.hEw) {
            TiebaStatic.log(new aq("c13047").aj("obj_locate", 8).dK("fid", this.mForumId));
            be.bmY().a((TbPageContext) com.baidu.adp.base.i.I(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
