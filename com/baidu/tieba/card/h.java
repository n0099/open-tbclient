package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class h extends b<com.baidu.tieba.e.e> {
    private View gPP;
    private View gPQ;
    private TextView gPS;
    private TextView gPT;
    private TextView gPU;
    private TextView gPV;
    private TextView gPW;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gPS = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.gPT = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.gPU = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.gPV = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.gPW = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.gPT.setOnClickListener(this);
        this.gPU.setOnClickListener(this);
        this.gPV.setOnClickListener(this);
        this.gPW.setOnClickListener(this);
        this.gPP = view.findViewById(R.id.divider_line_1);
        this.gPQ = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        an.setBackgroundResource(this.gPP, R.color.cp_bg_line_e);
        an.setBackgroundResource(this.gPQ, R.color.cp_bg_line_e);
        an.setViewTextColor(this.gPS, R.color.cp_cont_f, 1);
        an.setViewTextColor(this.gPT, R.color.cp_cont_b, 1);
        an.setViewTextColor(this.gPU, R.color.cp_cont_b, 1);
        an.setViewTextColor(this.gPV, R.color.cp_cont_b, 1);
        an.setViewTextColor(this.gPW, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bPU() != null) {
            if (!TextUtils.isEmpty(eVar.bPU().title)) {
                this.gPS.setText(eVar.bPU().title);
            }
            this.gPT.setVisibility(8);
            this.gPU.setVisibility(8);
            this.gPV.setVisibility(8);
            this.gPW.setVisibility(8);
            if (eVar.bPU().sub_nodes.size() >= 1) {
                this.gPT.setVisibility(0);
                this.gPT.setTag(eVar.bPU().sub_nodes.get(0).url);
                this.gPT.setText(eVar.bPU().sub_nodes.get(0).title);
            }
            if (eVar.bPU().sub_nodes.size() >= 2) {
                this.gPU.setVisibility(0);
                this.gPU.setTag(eVar.bPU().sub_nodes.get(1).url);
                this.gPU.setText(eVar.bPU().sub_nodes.get(1).title);
            }
            if (eVar.bPU().sub_nodes.size() >= 3) {
                this.gPV.setVisibility(0);
                this.gPV.setTag(eVar.bPU().sub_nodes.get(2).url);
                this.gPV.setText(eVar.bPU().sub_nodes.get(2).title);
            }
            if (eVar.bPU().sub_nodes.size() >= 4) {
                this.gPW.setVisibility(0);
                this.gPW.setTag(eVar.bPU().sub_nodes.get(3).url);
                this.gPW.setText(eVar.bPU().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gPT || view == this.gPU || view == this.gPV || view == this.gPW) {
            TiebaStatic.log(new ao("c13047").ag("obj_locate", 8).dk("fid", this.mForumId));
            bc.aWU().a((TbPageContext) com.baidu.adp.base.i.G(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
