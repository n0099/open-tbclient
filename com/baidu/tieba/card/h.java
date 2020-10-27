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
    private View hQL;
    private View hQM;
    private TextView hQO;
    private TextView hQP;
    private TextView hQQ;
    private TextView hQR;
    private TextView hQS;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hQO = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.hQP = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.hQQ = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.hQR = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.hQS = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.hQP.setOnClickListener(this);
        this.hQQ.setOnClickListener(this);
        this.hQR.setOnClickListener(this);
        this.hQS.setOnClickListener(this);
        this.hQL = view.findViewById(R.id.divider_line_1);
        this.hQM = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.hQL, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hQM, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.hQO, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.hQP, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hQQ, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hQR, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hQS, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.cnl() != null) {
            if (!TextUtils.isEmpty(eVar.cnl().title)) {
                this.hQO.setText(eVar.cnl().title);
            }
            this.hQP.setVisibility(8);
            this.hQQ.setVisibility(8);
            this.hQR.setVisibility(8);
            this.hQS.setVisibility(8);
            if (eVar.cnl().sub_nodes.size() >= 1) {
                this.hQP.setVisibility(0);
                this.hQP.setTag(eVar.cnl().sub_nodes.get(0).url);
                this.hQP.setText(eVar.cnl().sub_nodes.get(0).title);
            }
            if (eVar.cnl().sub_nodes.size() >= 2) {
                this.hQQ.setVisibility(0);
                this.hQQ.setTag(eVar.cnl().sub_nodes.get(1).url);
                this.hQQ.setText(eVar.cnl().sub_nodes.get(1).title);
            }
            if (eVar.cnl().sub_nodes.size() >= 3) {
                this.hQR.setVisibility(0);
                this.hQR.setTag(eVar.cnl().sub_nodes.get(2).url);
                this.hQR.setText(eVar.cnl().sub_nodes.get(2).title);
            }
            if (eVar.cnl().sub_nodes.size() >= 4) {
                this.hQS.setVisibility(0);
                this.hQS.setTag(eVar.cnl().sub_nodes.get(3).url);
                this.hQS.setText(eVar.cnl().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hQP || view == this.hQQ || view == this.hQR || view == this.hQS) {
            TiebaStatic.log(new aq("c13047").aj("obj_locate", 8).dR("fid", this.mForumId));
            be.boR().a((TbPageContext) com.baidu.adp.base.i.I(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
