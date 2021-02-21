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
    private View ivN;
    private View ivO;
    private TextView ivQ;
    private TextView ivR;
    private TextView ivS;
    private TextView ivT;
    private TextView ivU;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ivQ = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.ivR = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.ivS = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.ivT = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.ivU = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.ivR.setOnClickListener(this);
        this.ivS.setOnClickListener(this);
        this.ivT.setOnClickListener(this);
        this.ivU.setOnClickListener(this);
        this.ivN = view.findViewById(R.id.divider_line_1);
        this.ivO = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setBackgroundResource(this.ivN, R.color.CAM_X0205);
        ap.setBackgroundResource(this.ivO, R.color.CAM_X0205);
        ap.setViewTextColor(this.ivQ, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.ivR, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.ivS, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.ivT, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.ivU, R.color.CAM_X0105, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.ctZ() != null) {
            if (!TextUtils.isEmpty(eVar.ctZ().title)) {
                this.ivQ.setText(eVar.ctZ().title);
            }
            this.ivR.setVisibility(8);
            this.ivS.setVisibility(8);
            this.ivT.setVisibility(8);
            this.ivU.setVisibility(8);
            if (eVar.ctZ().sub_nodes.size() >= 1) {
                this.ivR.setVisibility(0);
                this.ivR.setTag(eVar.ctZ().sub_nodes.get(0).url);
                this.ivR.setText(eVar.ctZ().sub_nodes.get(0).title);
            }
            if (eVar.ctZ().sub_nodes.size() >= 2) {
                this.ivS.setVisibility(0);
                this.ivS.setTag(eVar.ctZ().sub_nodes.get(1).url);
                this.ivS.setText(eVar.ctZ().sub_nodes.get(1).title);
            }
            if (eVar.ctZ().sub_nodes.size() >= 3) {
                this.ivT.setVisibility(0);
                this.ivT.setTag(eVar.ctZ().sub_nodes.get(2).url);
                this.ivT.setText(eVar.ctZ().sub_nodes.get(2).title);
            }
            if (eVar.ctZ().sub_nodes.size() >= 4) {
                this.ivU.setVisibility(0);
                this.ivU.setTag(eVar.ctZ().sub_nodes.get(3).url);
                this.ivU.setText(eVar.ctZ().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ivR || view == this.ivS || view == this.ivT || view == this.ivU) {
            TiebaStatic.log(new ar("c13047").ap("obj_locate", 8).dR("fid", this.mForumId));
            bf.bsV().a((TbPageContext) com.baidu.adp.base.j.K(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
