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
    private TextView ixA;
    private TextView ixB;
    private TextView ixC;
    private TextView ixD;
    private View ixw;
    private View ixx;
    private TextView ixz;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ixz = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.ixA = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.ixB = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.ixC = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.ixD = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.ixA.setOnClickListener(this);
        this.ixB.setOnClickListener(this);
        this.ixC.setOnClickListener(this);
        this.ixD.setOnClickListener(this);
        this.ixw = view.findViewById(R.id.divider_line_1);
        this.ixx = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setBackgroundResource(this.ixw, R.color.CAM_X0205);
        ap.setBackgroundResource(this.ixx, R.color.CAM_X0205);
        ap.setViewTextColor(this.ixz, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.ixA, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.ixB, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.ixC, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.ixD, R.color.CAM_X0105, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.cuf() != null) {
            if (!TextUtils.isEmpty(eVar.cuf().title)) {
                this.ixz.setText(eVar.cuf().title);
            }
            this.ixA.setVisibility(8);
            this.ixB.setVisibility(8);
            this.ixC.setVisibility(8);
            this.ixD.setVisibility(8);
            if (eVar.cuf().sub_nodes.size() >= 1) {
                this.ixA.setVisibility(0);
                this.ixA.setTag(eVar.cuf().sub_nodes.get(0).url);
                this.ixA.setText(eVar.cuf().sub_nodes.get(0).title);
            }
            if (eVar.cuf().sub_nodes.size() >= 2) {
                this.ixB.setVisibility(0);
                this.ixB.setTag(eVar.cuf().sub_nodes.get(1).url);
                this.ixB.setText(eVar.cuf().sub_nodes.get(1).title);
            }
            if (eVar.cuf().sub_nodes.size() >= 3) {
                this.ixC.setVisibility(0);
                this.ixC.setTag(eVar.cuf().sub_nodes.get(2).url);
                this.ixC.setText(eVar.cuf().sub_nodes.get(2).title);
            }
            if (eVar.cuf().sub_nodes.size() >= 4) {
                this.ixD.setVisibility(0);
                this.ixD.setTag(eVar.cuf().sub_nodes.get(3).url);
                this.ixD.setText(eVar.cuf().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ixA || view == this.ixB || view == this.ixC || view == this.ixD) {
            TiebaStatic.log(new ar("c13047").aq("obj_locate", 8).dR("fid", this.mForumId));
            bf.bsY().a((TbPageContext) com.baidu.adp.base.j.J(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
