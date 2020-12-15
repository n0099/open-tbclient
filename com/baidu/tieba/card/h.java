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
/* loaded from: classes22.dex */
public class h extends b<com.baidu.tieba.f.e> {
    private View iih;
    private View iii;
    private TextView iik;
    private TextView iil;
    private TextView iim;
    private TextView iin;
    private TextView iio;
    private String mForumId;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iik = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.iil = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.iim = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.iin = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.iio = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.iil.setOnClickListener(this);
        this.iim.setOnClickListener(this);
        this.iin.setOnClickListener(this);
        this.iio.setOnClickListener(this);
        this.iih = view.findViewById(R.id.divider_line_1);
        this.iii = view.findViewById(R.id.divider_line_2);
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(getView(), R.color.CAM_X0201);
        ap.setBackgroundResource(this.iih, R.color.CAM_X0205);
        ap.setBackgroundResource(this.iii, R.color.CAM_X0205);
        ap.setViewTextColor(this.iik, R.color.CAM_X0106, 1);
        ap.setViewTextColor(this.iil, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.iim, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.iin, R.color.CAM_X0105, 1);
        ap.setViewTextColor(this.iio, R.color.CAM_X0105, 1);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.f.e eVar) {
        if (eVar != null && eVar.ctE() != null) {
            if (!TextUtils.isEmpty(eVar.ctE().title)) {
                this.iik.setText(eVar.ctE().title);
            }
            this.iil.setVisibility(8);
            this.iim.setVisibility(8);
            this.iin.setVisibility(8);
            this.iio.setVisibility(8);
            if (eVar.ctE().sub_nodes.size() >= 1) {
                this.iil.setVisibility(0);
                this.iil.setTag(eVar.ctE().sub_nodes.get(0).url);
                this.iil.setText(eVar.ctE().sub_nodes.get(0).title);
            }
            if (eVar.ctE().sub_nodes.size() >= 2) {
                this.iim.setVisibility(0);
                this.iim.setTag(eVar.ctE().sub_nodes.get(1).url);
                this.iim.setText(eVar.ctE().sub_nodes.get(1).title);
            }
            if (eVar.ctE().sub_nodes.size() >= 3) {
                this.iin.setVisibility(0);
                this.iin.setTag(eVar.ctE().sub_nodes.get(2).url);
                this.iin.setText(eVar.ctE().sub_nodes.get(2).title);
            }
            if (eVar.ctE().sub_nodes.size() >= 4) {
                this.iio.setVisibility(0);
                this.iio.setTag(eVar.ctE().sub_nodes.get(3).url);
                this.iio.setText(eVar.ctE().sub_nodes.get(3).title);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iil || view == this.iim || view == this.iin || view == this.iio) {
            TiebaStatic.log(new ar("c13047").al("obj_locate", 8).dY("fid", this.mForumId));
            bf.bua().a((TbPageContext) com.baidu.adp.base.i.J(this.mTbPageContext.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }
}
