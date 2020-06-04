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
    private View gCZ;
    private View gDa;
    private TextView gDc;
    private TextView gDd;
    private TextView gDe;
    private TextView gDf;
    private TextView gDg;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gDc = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.gDd = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.gDe = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.gDf = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.gDg = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.gDd.setOnClickListener(this);
        this.gDe.setOnClickListener(this);
        this.gDf.setOnClickListener(this);
        this.gDg.setOnClickListener(this);
        this.gCZ = view.findViewById(R.id.divider_line_1);
        this.gDa = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.gCZ, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.gDa, R.color.cp_bg_line_e);
        am.setViewTextColor(this.gDc, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.gDd, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gDe, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gDf, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.gDg, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bMP() != null) {
            if (!TextUtils.isEmpty(eVar.bMP().title)) {
                this.gDc.setText(eVar.bMP().title);
            }
            this.gDd.setVisibility(8);
            this.gDe.setVisibility(8);
            this.gDf.setVisibility(8);
            this.gDg.setVisibility(8);
            if (eVar.bMP().sub_nodes.size() >= 1) {
                this.gDd.setVisibility(0);
                this.gDd.setTag(eVar.bMP().sub_nodes.get(0).url);
                this.gDd.setText(eVar.bMP().sub_nodes.get(0).title);
            }
            if (eVar.bMP().sub_nodes.size() >= 2) {
                this.gDe.setVisibility(0);
                this.gDe.setTag(eVar.bMP().sub_nodes.get(1).url);
                this.gDe.setText(eVar.bMP().sub_nodes.get(1).title);
            }
            if (eVar.bMP().sub_nodes.size() >= 3) {
                this.gDf.setVisibility(0);
                this.gDf.setTag(eVar.bMP().sub_nodes.get(2).url);
                this.gDf.setText(eVar.bMP().sub_nodes.get(2).title);
            }
            if (eVar.bMP().sub_nodes.size() >= 4) {
                this.gDg.setVisibility(0);
                this.gDg.setTag(eVar.bMP().sub_nodes.get(3).url);
                this.gDg.setText(eVar.bMP().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gDd || view == this.gDe || view == this.gDf || view == this.gDg) {
            TiebaStatic.log(new an("c13047").ag("obj_locate", 8).dh("fid", this.mForumId));
            ba.aVa().a((TbPageContext) com.baidu.adp.base.i.G(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
