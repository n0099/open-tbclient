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
    private View ipV;
    private View ipW;
    private TextView ipY;
    private TextView ipZ;
    private TextView iqa;
    private TextView iqb;
    private TextView iqc;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ipY = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.ipZ = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.iqa = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.iqb = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.iqc = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.ipZ.setOnClickListener(this);
        this.iqa.setOnClickListener(this);
        this.iqb.setOnClickListener(this);
        this.iqc.setOnClickListener(this);
        this.ipV = view.findViewById(R.id.divider_line_1);
        this.ipW = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(getView(), R.color.CAM_X0201);
        ao.setBackgroundResource(this.ipV, R.color.CAM_X0205);
        ao.setBackgroundResource(this.ipW, R.color.CAM_X0205);
        ao.setViewTextColor(this.ipY, R.color.CAM_X0106, 1);
        ao.setViewTextColor(this.ipZ, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.iqa, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.iqb, R.color.CAM_X0105, 1);
        ao.setViewTextColor(this.iqc, R.color.CAM_X0105, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.csG() != null) {
            if (!TextUtils.isEmpty(eVar.csG().title)) {
                this.ipY.setText(eVar.csG().title);
            }
            this.ipZ.setVisibility(8);
            this.iqa.setVisibility(8);
            this.iqb.setVisibility(8);
            this.iqc.setVisibility(8);
            if (eVar.csG().sub_nodes.size() >= 1) {
                this.ipZ.setVisibility(0);
                this.ipZ.setTag(eVar.csG().sub_nodes.get(0).url);
                this.ipZ.setText(eVar.csG().sub_nodes.get(0).title);
            }
            if (eVar.csG().sub_nodes.size() >= 2) {
                this.iqa.setVisibility(0);
                this.iqa.setTag(eVar.csG().sub_nodes.get(1).url);
                this.iqa.setText(eVar.csG().sub_nodes.get(1).title);
            }
            if (eVar.csG().sub_nodes.size() >= 3) {
                this.iqb.setVisibility(0);
                this.iqb.setTag(eVar.csG().sub_nodes.get(2).url);
                this.iqb.setText(eVar.csG().sub_nodes.get(2).title);
            }
            if (eVar.csG().sub_nodes.size() >= 4) {
                this.iqc.setVisibility(0);
                this.iqc.setTag(eVar.csG().sub_nodes.get(3).url);
                this.iqc.setText(eVar.csG().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ipZ || view == this.iqa || view == this.iqb || view == this.iqc) {
            TiebaStatic.log(new aq("c13047").an("obj_locate", 8).dW("fid", this.mForumId));
            be.bsB().a((TbPageContext) com.baidu.adp.base.j.K(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
