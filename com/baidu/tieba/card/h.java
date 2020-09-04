package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class h extends b<com.baidu.tieba.e.e> {
    private View his;
    private View hit;
    private TextView hiv;
    private TextView hiw;
    private TextView hix;
    private TextView hiy;
    private TextView hiz;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hiv = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.hiw = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.hix = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.hiy = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.hiz = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.hiw.setOnClickListener(this);
        this.hix.setOnClickListener(this);
        this.hiy.setOnClickListener(this);
        this.hiz.setOnClickListener(this);
        this.his = view.findViewById(R.id.divider_line_1);
        this.hit = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.his, R.color.cp_bg_line_e);
        ap.setBackgroundResource(this.hit, R.color.cp_bg_line_e);
        ap.setViewTextColor(this.hiv, R.color.cp_cont_f, 1);
        ap.setViewTextColor(this.hiw, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hix, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hiy, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.hiz, R.color.cp_cont_b, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.e eVar) {
        if (eVar != null && eVar.cdt() != null) {
            if (!TextUtils.isEmpty(eVar.cdt().title)) {
                this.hiv.setText(eVar.cdt().title);
            }
            this.hiw.setVisibility(8);
            this.hix.setVisibility(8);
            this.hiy.setVisibility(8);
            this.hiz.setVisibility(8);
            if (eVar.cdt().sub_nodes.size() >= 1) {
                this.hiw.setVisibility(0);
                this.hiw.setTag(eVar.cdt().sub_nodes.get(0).url);
                this.hiw.setText(eVar.cdt().sub_nodes.get(0).title);
            }
            if (eVar.cdt().sub_nodes.size() >= 2) {
                this.hix.setVisibility(0);
                this.hix.setTag(eVar.cdt().sub_nodes.get(1).url);
                this.hix.setText(eVar.cdt().sub_nodes.get(1).title);
            }
            if (eVar.cdt().sub_nodes.size() >= 3) {
                this.hiy.setVisibility(0);
                this.hiy.setTag(eVar.cdt().sub_nodes.get(2).url);
                this.hiy.setText(eVar.cdt().sub_nodes.get(2).title);
            }
            if (eVar.cdt().sub_nodes.size() >= 4) {
                this.hiz.setVisibility(0);
                this.hiz.setTag(eVar.cdt().sub_nodes.get(3).url);
                this.hiz.setText(eVar.cdt().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hiw || view == this.hix || view == this.hiy || view == this.hiz) {
            TiebaStatic.log(new aq("c13047").ai("obj_locate", 8).dD("fid", this.mForumId));
            be.bju().a((TbPageContext) com.baidu.adp.base.i.I(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
