package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class h extends b<com.baidu.tieba.f.e> {
    private View hXi;
    private View hXj;
    private TextView hXl;
    private TextView hXm;
    private TextView hXn;
    private TextView hXo;
    private TextView hXp;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hXl = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.hXm = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.hXn = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.hXo = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.hXp = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.hXm.setOnClickListener(this);
        this.hXn.setOnClickListener(this);
        this.hXo.setOnClickListener(this);
        this.hXp.setOnClickListener(this);
        this.hXi = view.findViewById(R.id.divider_line_1);
        this.hXj = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setBackgroundResource(this.hXi, R.color.CAM_X0205);
        ap.setBackgroundResource(this.hXj, R.color.CAM_X0205);
        ap.setViewTextColor(this.hXl, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.hXm, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.hXn, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.hXo, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.hXp, R.color.CAM_X0105, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.f.e eVar) {
        if (eVar != null && eVar.cpp() != null) {
            if (!TextUtils.isEmpty(eVar.cpp().title)) {
                this.hXl.setText(eVar.cpp().title);
            }
            this.hXm.setVisibility(8);
            this.hXn.setVisibility(8);
            this.hXo.setVisibility(8);
            this.hXp.setVisibility(8);
            if (eVar.cpp().sub_nodes.size() >= 1) {
                this.hXm.setVisibility(0);
                this.hXm.setTag(eVar.cpp().sub_nodes.get(0).url);
                this.hXm.setText(eVar.cpp().sub_nodes.get(0).title);
            }
            if (eVar.cpp().sub_nodes.size() >= 2) {
                this.hXn.setVisibility(0);
                this.hXn.setTag(eVar.cpp().sub_nodes.get(1).url);
                this.hXn.setText(eVar.cpp().sub_nodes.get(1).title);
            }
            if (eVar.cpp().sub_nodes.size() >= 3) {
                this.hXo.setVisibility(0);
                this.hXo.setTag(eVar.cpp().sub_nodes.get(2).url);
                this.hXo.setText(eVar.cpp().sub_nodes.get(2).title);
            }
            if (eVar.cpp().sub_nodes.size() >= 4) {
                this.hXp.setVisibility(0);
                this.hXp.setTag(eVar.cpp().sub_nodes.get(3).url);
                this.hXp.setText(eVar.cpp().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hXm || view == this.hXn || view == this.hXo || view == this.hXp) {
            TiebaStatic.log(new ar("c13047").ak("obj_locate", 8).dR("fid", this.mForumId));
            bf.bqF().a((TbPageContext) com.baidu.adp.base.i.I(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
