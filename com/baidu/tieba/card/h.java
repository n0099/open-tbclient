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
public class h extends b<com.baidu.tieba.e.e> {
    private View gCO;
    private View gCP;
    private TextView gCR;
    private TextView gCS;
    private TextView gCT;
    private TextView gCU;
    private TextView gCV;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gCR = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.gCS = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.gCT = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.gCU = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.gCV = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.gCS.setOnClickListener(this);
        this.gCT.setOnClickListener(this);
        this.gCU.setOnClickListener(this);
        this.gCV.setOnClickListener(this);
        this.gCO = view.findViewById(R.id.divider_line_1);
        this.gCP = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.gCO, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.gCP, R.color.cp_bg_line_e);
        am.setViewTextColor(this.gCR, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.gCS, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gCT, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gCU, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gCV, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bMN() != null) {
            if (!TextUtils.isEmpty(eVar.bMN().title)) {
                this.gCR.setText(eVar.bMN().title);
            }
            this.gCS.setVisibility(8);
            this.gCT.setVisibility(8);
            this.gCU.setVisibility(8);
            this.gCV.setVisibility(8);
            if (eVar.bMN().sub_nodes.size() >= 1) {
                this.gCS.setVisibility(0);
                this.gCS.setTag(eVar.bMN().sub_nodes.get(0).url);
                this.gCS.setText(eVar.bMN().sub_nodes.get(0).title);
            }
            if (eVar.bMN().sub_nodes.size() >= 2) {
                this.gCT.setVisibility(0);
                this.gCT.setTag(eVar.bMN().sub_nodes.get(1).url);
                this.gCT.setText(eVar.bMN().sub_nodes.get(1).title);
            }
            if (eVar.bMN().sub_nodes.size() >= 3) {
                this.gCU.setVisibility(0);
                this.gCU.setTag(eVar.bMN().sub_nodes.get(2).url);
                this.gCU.setText(eVar.bMN().sub_nodes.get(2).title);
            }
            if (eVar.bMN().sub_nodes.size() >= 4) {
                this.gCV.setVisibility(0);
                this.gCV.setTag(eVar.bMN().sub_nodes.get(3).url);
                this.gCV.setText(eVar.bMN().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCS || view == this.gCT || view == this.gCU || view == this.gCV) {
            TiebaStatic.log(new an("c13047").ag("obj_locate", 8).dh("fid", this.mForumId));
            ba.aUZ().a((TbPageContext) com.baidu.adp.base.i.G(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
