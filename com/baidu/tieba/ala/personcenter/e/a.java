package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.ala.personcenter.c.b> {
    private View gde;
    private TextView gdf;
    private HeadImageView gdg;
    private HeadImageView gdh;
    private HeadImageView gdi;
    private ImageView gdj;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gde = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.gdf = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.gdj = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.gdg = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.gdh = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.gdi = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_person_center_list_normal_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void rl(int i) {
        if (this.gde != null) {
            this.gde.setVisibility(i);
        }
    }

    public void rm(int i) {
        if (this.gdj != null) {
            this.gdj.setVisibility(i);
        }
    }

    public void Bq(String str) {
        if (this.gdf != null) {
            this.gdf.setText(str);
        }
    }

    public TextView bCu() {
        if (this.gdf != null) {
            return this.gdf;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.gdj.setAlpha(0.7f);
        } else {
            this.gdj.setAlpha(1);
        }
        this.gde.setBackgroundColor(am.getColor(i, R.color.cp_bg_line_c));
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gdf, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
