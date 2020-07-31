package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class h extends b<com.baidu.tieba.e.e> {
    private TextView gVA;
    private TextView gVB;
    private TextView gVC;
    private View gVv;
    private View gVw;
    private TextView gVy;
    private TextView gVz;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gVy = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.gVz = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.gVA = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.gVB = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.gVC = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.gVz.setOnClickListener(this);
        this.gVA.setOnClickListener(this);
        this.gVB.setOnClickListener(this);
        this.gVC.setOnClickListener(this);
        this.gVv = view.findViewById(R.id.divider_line_1);
        this.gVw = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ao.setBackgroundResource(this.gVv, R.color.cp_bg_line_e);
        ao.setBackgroundResource(this.gVw, R.color.cp_bg_line_e);
        ao.setViewTextColor(this.gVy, R.color.cp_cont_f, 1);
        ao.setViewTextColor(this.gVz, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.gVA, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.gVB, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.gVC, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bTg() != null) {
            if (!TextUtils.isEmpty(eVar.bTg().title)) {
                this.gVy.setText(eVar.bTg().title);
            }
            this.gVz.setVisibility(8);
            this.gVA.setVisibility(8);
            this.gVB.setVisibility(8);
            this.gVC.setVisibility(8);
            if (eVar.bTg().sub_nodes.size() >= 1) {
                this.gVz.setVisibility(0);
                this.gVz.setTag(eVar.bTg().sub_nodes.get(0).url);
                this.gVz.setText(eVar.bTg().sub_nodes.get(0).title);
            }
            if (eVar.bTg().sub_nodes.size() >= 2) {
                this.gVA.setVisibility(0);
                this.gVA.setTag(eVar.bTg().sub_nodes.get(1).url);
                this.gVA.setText(eVar.bTg().sub_nodes.get(1).title);
            }
            if (eVar.bTg().sub_nodes.size() >= 3) {
                this.gVB.setVisibility(0);
                this.gVB.setTag(eVar.bTg().sub_nodes.get(2).url);
                this.gVB.setText(eVar.bTg().sub_nodes.get(2).title);
            }
            if (eVar.bTg().sub_nodes.size() >= 4) {
                this.gVC.setVisibility(0);
                this.gVC.setTag(eVar.bTg().sub_nodes.get(3).url);
                this.gVC.setText(eVar.bTg().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gVz || view == this.gVA || view == this.gVB || view == this.gVC) {
            TiebaStatic.log(new ap("c13047").ah("obj_locate", 8).dn("fid", this.mForumId));
            bd.baV().a((TbPageContext) com.baidu.adp.base.i.G(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
