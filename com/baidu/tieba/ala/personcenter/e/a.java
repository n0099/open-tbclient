package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.ala.personcenter.c.a> {
    private View fxL;
    private TextView fxM;
    private HeadImageView fxN;
    private HeadImageView fxO;
    private HeadImageView fxP;
    private ImageView fxQ;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fxL = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.fxM = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.fxQ = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.fxN = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.fxO = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.fxP = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void qQ(int i) {
        if (this.fxL != null) {
            this.fxL.setVisibility(i);
        }
    }

    public void qR(int i) {
        if (this.fxQ != null) {
            this.fxQ.setVisibility(i);
        }
    }

    public void zI(String str) {
        if (this.fxM != null) {
            this.fxM.setText(str);
        }
    }

    public TextView bsF() {
        if (this.fxM != null) {
            return this.fxM;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.fxQ.setAlpha(0.7f);
        } else {
            this.fxQ.setAlpha(1);
        }
        this.fxL.setBackgroundColor(am.getColor(i, R.color.cp_bg_line_c));
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fxM, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
