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
/* loaded from: classes4.dex */
public class g extends a<com.baidu.tieba.e.e> {
    private TextView eLA;
    private TextView eLB;
    private TextView eLC;
    private TextView eLD;
    private TextView eLE;
    private View eLx;
    private View eLy;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eLA = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.eLB = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.eLC = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.eLD = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.eLE = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.eLB.setOnClickListener(this);
        this.eLC.setOnClickListener(this);
        this.eLD.setOnClickListener(this);
        this.eLE.setOnClickListener(this);
        this.eLx = view.findViewById(R.id.divider_line_1);
        this.eLy = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.eLx, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.eLy, R.color.cp_bg_line_e);
        am.setViewTextColor(this.eLA, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.eLB, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.eLC, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.eLD, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.eLE, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bcA() != null) {
            if (!TextUtils.isEmpty(eVar.bcA().title)) {
                this.eLA.setText(eVar.bcA().title);
            }
            this.eLB.setVisibility(8);
            this.eLC.setVisibility(8);
            this.eLD.setVisibility(8);
            this.eLE.setVisibility(8);
            if (eVar.bcA().sub_nodes.size() >= 1) {
                this.eLB.setVisibility(0);
                this.eLB.setTag(eVar.bcA().sub_nodes.get(0).url);
                this.eLB.setText(eVar.bcA().sub_nodes.get(0).title);
            }
            if (eVar.bcA().sub_nodes.size() >= 2) {
                this.eLC.setVisibility(0);
                this.eLC.setTag(eVar.bcA().sub_nodes.get(1).url);
                this.eLC.setText(eVar.bcA().sub_nodes.get(1).title);
            }
            if (eVar.bcA().sub_nodes.size() >= 3) {
                this.eLD.setVisibility(0);
                this.eLD.setTag(eVar.bcA().sub_nodes.get(2).url);
                this.eLD.setText(eVar.bcA().sub_nodes.get(2).title);
            }
            if (eVar.bcA().sub_nodes.size() >= 4) {
                this.eLE.setVisibility(0);
                this.eLE.setTag(eVar.bcA().sub_nodes.get(3).url);
                this.eLE.setText(eVar.bcA().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eLB || view == this.eLC || view == this.eLD || view == this.eLE) {
            TiebaStatic.log(new an("c13047").O("obj_locate", 8).bS("fid", this.mForumId));
            ba.amQ().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
