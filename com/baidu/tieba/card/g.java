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
/* loaded from: classes6.dex */
public class g extends a<com.baidu.tieba.e.e> {
    private View fCD;
    private View fCE;
    private TextView fCG;
    private TextView fCH;
    private TextView fCI;
    private TextView fCJ;
    private TextView fCK;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fCG = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.fCH = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.fCI = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.fCJ = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.fCK = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.fCH.setOnClickListener(this);
        this.fCI.setOnClickListener(this);
        this.fCJ.setOnClickListener(this);
        this.fCK.setOnClickListener(this);
        this.fCD = view.findViewById(R.id.divider_line_1);
        this.fCE = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.fCD, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fCE, R.color.cp_bg_line_e);
        am.setViewTextColor(this.fCG, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.fCH, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fCI, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fCJ, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fCK, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.btV() != null) {
            if (!TextUtils.isEmpty(eVar.btV().title)) {
                this.fCG.setText(eVar.btV().title);
            }
            this.fCH.setVisibility(8);
            this.fCI.setVisibility(8);
            this.fCJ.setVisibility(8);
            this.fCK.setVisibility(8);
            if (eVar.btV().sub_nodes.size() >= 1) {
                this.fCH.setVisibility(0);
                this.fCH.setTag(eVar.btV().sub_nodes.get(0).url);
                this.fCH.setText(eVar.btV().sub_nodes.get(0).title);
            }
            if (eVar.btV().sub_nodes.size() >= 2) {
                this.fCI.setVisibility(0);
                this.fCI.setTag(eVar.btV().sub_nodes.get(1).url);
                this.fCI.setText(eVar.btV().sub_nodes.get(1).title);
            }
            if (eVar.btV().sub_nodes.size() >= 3) {
                this.fCJ.setVisibility(0);
                this.fCJ.setTag(eVar.btV().sub_nodes.get(2).url);
                this.fCJ.setText(eVar.btV().sub_nodes.get(2).title);
            }
            if (eVar.btV().sub_nodes.size() >= 4) {
                this.fCK.setVisibility(0);
                this.fCK.setTag(eVar.btV().sub_nodes.get(3).url);
                this.fCK.setText(eVar.btV().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fCH || view == this.fCI || view == this.fCJ || view == this.fCK) {
            TiebaStatic.log(new an("c13047").Z("obj_locate", 8).cp("fid", this.mForumId));
            ba.aEa().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
