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
/* loaded from: classes2.dex */
public class g extends b<com.baidu.tieba.e.e> {
    private View ivA;
    private TextView ivC;
    private TextView ivD;
    private TextView ivE;
    private TextView ivF;
    private TextView ivG;
    private View ivz;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ivC = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.ivD = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.ivE = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.ivF = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.ivG = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.ivD.setOnClickListener(this);
        this.ivE.setOnClickListener(this);
        this.ivF.setOnClickListener(this);
        this.ivG.setOnClickListener(this);
        this.ivz = view.findViewById(R.id.divider_line_1);
        this.ivA = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setBackgroundResource(this.ivz, R.color.CAM_X0205);
        ap.setBackgroundResource(this.ivA, R.color.CAM_X0205);
        ap.setViewTextColor(this.ivC, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.ivD, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.ivE, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.ivF, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.ivG, R.color.CAM_X0105, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.ctS() != null) {
            if (!TextUtils.isEmpty(eVar.ctS().title)) {
                this.ivC.setText(eVar.ctS().title);
            }
            this.ivD.setVisibility(8);
            this.ivE.setVisibility(8);
            this.ivF.setVisibility(8);
            this.ivG.setVisibility(8);
            if (eVar.ctS().sub_nodes.size() >= 1) {
                this.ivD.setVisibility(0);
                this.ivD.setTag(eVar.ctS().sub_nodes.get(0).url);
                this.ivD.setText(eVar.ctS().sub_nodes.get(0).title);
            }
            if (eVar.ctS().sub_nodes.size() >= 2) {
                this.ivE.setVisibility(0);
                this.ivE.setTag(eVar.ctS().sub_nodes.get(1).url);
                this.ivE.setText(eVar.ctS().sub_nodes.get(1).title);
            }
            if (eVar.ctS().sub_nodes.size() >= 3) {
                this.ivF.setVisibility(0);
                this.ivF.setTag(eVar.ctS().sub_nodes.get(2).url);
                this.ivF.setText(eVar.ctS().sub_nodes.get(2).title);
            }
            if (eVar.ctS().sub_nodes.size() >= 4) {
                this.ivG.setVisibility(0);
                this.ivG.setTag(eVar.ctS().sub_nodes.get(3).url);
                this.ivG.setText(eVar.ctS().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ivD || view == this.ivE || view == this.ivF || view == this.ivG) {
            TiebaStatic.log(new ar("c13047").ap("obj_locate", 8).dR("fid", this.mForumId));
            bf.bsV().a((TbPageContext) com.baidu.adp.base.j.K(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
