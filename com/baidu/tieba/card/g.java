package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class g extends b<com.baidu.tieba.e.e> {
    private View iuC;
    private View iuD;
    private TextView iuF;
    private TextView iuG;
    private TextView iuH;
    private TextView iuI;
    private TextView iuJ;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iuF = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.iuG = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.iuH = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.iuI = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.iuJ = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.iuG.setOnClickListener(this);
        this.iuH.setOnClickListener(this);
        this.iuI.setOnClickListener(this);
        this.iuJ.setOnClickListener(this);
        this.iuC = view.findViewById(R.id.divider_line_1);
        this.iuD = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(getView(), R.color.CAM_X0201);
        ao.setBackgroundResource(this.iuC, R.color.CAM_X0205);
        ao.setBackgroundResource(this.iuD, R.color.CAM_X0205);
        ao.setViewTextColor(this.iuF, R.color.CAM_X0106, 1);
        ao.setViewTextColor(this.iuG, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.iuH, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.iuI, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.iuJ, R.color.CAM_X0105, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.cwy() != null) {
            if (!TextUtils.isEmpty(eVar.cwy().title)) {
                this.iuF.setText(eVar.cwy().title);
            }
            this.iuG.setVisibility(8);
            this.iuH.setVisibility(8);
            this.iuI.setVisibility(8);
            this.iuJ.setVisibility(8);
            if (eVar.cwy().sub_nodes.size() >= 1) {
                this.iuG.setVisibility(0);
                this.iuG.setTag(eVar.cwy().sub_nodes.get(0).url);
                this.iuG.setText(eVar.cwy().sub_nodes.get(0).title);
            }
            if (eVar.cwy().sub_nodes.size() >= 2) {
                this.iuH.setVisibility(0);
                this.iuH.setTag(eVar.cwy().sub_nodes.get(1).url);
                this.iuH.setText(eVar.cwy().sub_nodes.get(1).title);
            }
            if (eVar.cwy().sub_nodes.size() >= 3) {
                this.iuI.setVisibility(0);
                this.iuI.setTag(eVar.cwy().sub_nodes.get(2).url);
                this.iuI.setText(eVar.cwy().sub_nodes.get(2).title);
            }
            if (eVar.cwy().sub_nodes.size() >= 4) {
                this.iuJ.setVisibility(0);
                this.iuJ.setTag(eVar.cwy().sub_nodes.get(3).url);
                this.iuJ.setText(eVar.cwy().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iuG || view == this.iuH || view == this.iuI || view == this.iuJ) {
            TiebaStatic.log(new aq("c13047").an("obj_locate", 8).dX("fid", this.mForumId));
            be.bwv().a((TbPageContext) com.baidu.adp.base.j.K(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
