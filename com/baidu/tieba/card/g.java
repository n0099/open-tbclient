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
public class g extends a<com.baidu.tieba.e.e> {
    private View fIA;
    private View fIB;
    private TextView fID;
    private TextView fIE;
    private TextView fIF;
    private TextView fIG;
    private TextView fIH;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fID = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.fIE = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.fIF = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.fIG = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.fIH = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.fIE.setOnClickListener(this);
        this.fIF.setOnClickListener(this);
        this.fIG.setOnClickListener(this);
        this.fIH.setOnClickListener(this);
        this.fIA = view.findViewById(R.id.divider_line_1);
        this.fIB = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.fIA, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fIB, R.color.cp_bg_line_e);
        am.setViewTextColor(this.fID, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.fIE, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fIF, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fIG, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fIH, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bwE() != null) {
            if (!TextUtils.isEmpty(eVar.bwE().title)) {
                this.fID.setText(eVar.bwE().title);
            }
            this.fIE.setVisibility(8);
            this.fIF.setVisibility(8);
            this.fIG.setVisibility(8);
            this.fIH.setVisibility(8);
            if (eVar.bwE().sub_nodes.size() >= 1) {
                this.fIE.setVisibility(0);
                this.fIE.setTag(eVar.bwE().sub_nodes.get(0).url);
                this.fIE.setText(eVar.bwE().sub_nodes.get(0).title);
            }
            if (eVar.bwE().sub_nodes.size() >= 2) {
                this.fIF.setVisibility(0);
                this.fIF.setTag(eVar.bwE().sub_nodes.get(1).url);
                this.fIF.setText(eVar.bwE().sub_nodes.get(1).title);
            }
            if (eVar.bwE().sub_nodes.size() >= 3) {
                this.fIG.setVisibility(0);
                this.fIG.setTag(eVar.bwE().sub_nodes.get(2).url);
                this.fIG.setText(eVar.bwE().sub_nodes.get(2).title);
            }
            if (eVar.bwE().sub_nodes.size() >= 4) {
                this.fIH.setVisibility(0);
                this.fIH.setTag(eVar.bwE().sub_nodes.get(3).url);
                this.fIH.setText(eVar.bwE().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fIE || view == this.fIF || view == this.fIG || view == this.fIH) {
            TiebaStatic.log(new an("c13047").X("obj_locate", 8).cy("fid", this.mForumId));
            ba.aGG().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
