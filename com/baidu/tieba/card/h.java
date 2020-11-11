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
    private View hWI;
    private View hWJ;
    private TextView hWL;
    private TextView hWM;
    private TextView hWN;
    private TextView hWO;
    private TextView hWP;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hWL = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.hWM = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.hWN = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.hWO = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.hWP = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.hWM.setOnClickListener(this);
        this.hWN.setOnClickListener(this);
        this.hWO.setOnClickListener(this);
        this.hWP.setOnClickListener(this);
        this.hWI = view.findViewById(R.id.divider_line_1);
        this.hWJ = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.hWI, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hWJ, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.hWL, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.hWM, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hWN, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hWO, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hWP, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.cpM() != null) {
            if (!TextUtils.isEmpty(eVar.cpM().title)) {
                this.hWL.setText(eVar.cpM().title);
            }
            this.hWM.setVisibility(8);
            this.hWN.setVisibility(8);
            this.hWO.setVisibility(8);
            this.hWP.setVisibility(8);
            if (eVar.cpM().sub_nodes.size() >= 1) {
                this.hWM.setVisibility(0);
                this.hWM.setTag(eVar.cpM().sub_nodes.get(0).url);
                this.hWM.setText(eVar.cpM().sub_nodes.get(0).title);
            }
            if (eVar.cpM().sub_nodes.size() >= 2) {
                this.hWN.setVisibility(0);
                this.hWN.setTag(eVar.cpM().sub_nodes.get(1).url);
                this.hWN.setText(eVar.cpM().sub_nodes.get(1).title);
            }
            if (eVar.cpM().sub_nodes.size() >= 3) {
                this.hWO.setVisibility(0);
                this.hWO.setTag(eVar.cpM().sub_nodes.get(2).url);
                this.hWO.setText(eVar.cpM().sub_nodes.get(2).title);
            }
            if (eVar.cpM().sub_nodes.size() >= 4) {
                this.hWP.setVisibility(0);
                this.hWP.setTag(eVar.cpM().sub_nodes.get(3).url);
                this.hWP.setText(eVar.cpM().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hWM || view == this.hWN || view == this.hWO || view == this.hWP) {
            TiebaStatic.log(new aq("c13047").al("obj_locate", 8).dR("fid", this.mForumId));
            be.brr().a((TbPageContext) com.baidu.adp.base.i.I(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
