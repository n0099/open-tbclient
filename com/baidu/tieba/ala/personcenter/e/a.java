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
    private View fxK;
    private TextView fxL;
    private HeadImageView fxM;
    private HeadImageView fxN;
    private HeadImageView fxO;
    private ImageView fxP;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fxK = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.fxL = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.fxP = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.fxM = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.fxN = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.fxO = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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
        if (this.fxK != null) {
            this.fxK.setVisibility(i);
        }
    }

    public void qR(int i) {
        if (this.fxP != null) {
            this.fxP.setVisibility(i);
        }
    }

    public void zI(String str) {
        if (this.fxL != null) {
            this.fxL.setText(str);
        }
    }

    public TextView bsD() {
        if (this.fxL != null) {
            return this.fxL;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.fxP.setAlpha(0.7f);
        } else {
            this.fxP.setAlpha(1);
        }
        this.fxK.setBackgroundColor(am.getColor(i, R.color.cp_bg_line_c));
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fxL, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
