package com.baidu.tieba.ala.personcenter.d;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.ala.personcenter.c.a> {
    private TextView eAA;
    private HeadImageView eAB;
    private HeadImageView eAC;
    private HeadImageView eAD;
    private ImageView eAE;
    private View eAz;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        W(getView());
    }

    private void W(View view) {
        this.eAz = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.eAA = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.eAE = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.eAB = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.eAC = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.eAD = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_person_center_list_normal_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.personcenter.c.a aVar) {
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void ol(int i) {
        if (this.eAz != null) {
            this.eAz.setVisibility(i);
        }
    }

    public TextView aYc() {
        if (this.eAA != null) {
            return this.eAA;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.eAE.setAlpha(0.7f);
        } else {
            this.eAE.setAlpha(1);
        }
        this.eAz.setBackgroundColor(am.getColor(i, R.color.cp_bg_line_c));
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.eAA, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
