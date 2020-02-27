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
    private View fIl;
    private View fIm;
    private TextView fIo;
    private TextView fIp;
    private TextView fIq;
    private TextView fIr;
    private TextView fIs;
    private String mForumId;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fIo = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.fIp = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.fIq = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.fIr = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.fIs = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.fIp.setOnClickListener(this);
        this.fIq.setOnClickListener(this);
        this.fIr.setOnClickListener(this);
        this.fIs.setOnClickListener(this);
        this.fIl = view.findViewById(R.id.divider_line_1);
        this.fIm = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        am.setBackgroundResource(this.fIl, R.color.cp_bg_line_e);
        am.setBackgroundResource(this.fIm, R.color.cp_bg_line_e);
        am.setViewTextColor(this.fIo, R.color.cp_cont_f, 1);
        am.setViewTextColor(this.fIp, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fIq, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fIr, R.color.cp_cont_b, 1);
        am.setViewTextColor(this.fIs, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.bwB() != null) {
            if (!TextUtils.isEmpty(eVar.bwB().title)) {
                this.fIo.setText(eVar.bwB().title);
            }
            this.fIp.setVisibility(8);
            this.fIq.setVisibility(8);
            this.fIr.setVisibility(8);
            this.fIs.setVisibility(8);
            if (eVar.bwB().sub_nodes.size() >= 1) {
                this.fIp.setVisibility(0);
                this.fIp.setTag(eVar.bwB().sub_nodes.get(0).url);
                this.fIp.setText(eVar.bwB().sub_nodes.get(0).title);
            }
            if (eVar.bwB().sub_nodes.size() >= 2) {
                this.fIq.setVisibility(0);
                this.fIq.setTag(eVar.bwB().sub_nodes.get(1).url);
                this.fIq.setText(eVar.bwB().sub_nodes.get(1).title);
            }
            if (eVar.bwB().sub_nodes.size() >= 3) {
                this.fIr.setVisibility(0);
                this.fIr.setTag(eVar.bwB().sub_nodes.get(2).url);
                this.fIr.setText(eVar.bwB().sub_nodes.get(2).title);
            }
            if (eVar.bwB().sub_nodes.size() >= 4) {
                this.fIs.setVisibility(0);
                this.fIs.setTag(eVar.bwB().sub_nodes.get(3).url);
                this.fIs.setText(eVar.bwB().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fIp || view == this.fIq || view == this.fIr || view == this.fIs) {
            TiebaStatic.log(new an("c13047").X("obj_locate", 8).cy("fid", this.mForumId));
            ba.aGE().a((TbPageContext) com.baidu.adp.base.i.ab(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
