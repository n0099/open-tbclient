package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private TextView gKA;
    private HeadImageView gKB;
    private HeadImageView gKC;
    private HeadImageView gKD;
    private ImageView gKE;
    private View gKz;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        aj(getView());
    }

    private void aj(View view) {
        this.gKz = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.gKA = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.gKE = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.gKB = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.gKC = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.gKD = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_normal_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.personcenter.c.b bVar) {
    }

    public void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void sG(int i) {
        if (this.gKz != null) {
            this.gKz.setVisibility(i);
        }
    }

    public void sH(int i) {
        if (this.gKE != null) {
            this.gKE.setVisibility(i);
        }
    }

    public void Eo(String str) {
        if (this.gKA != null) {
            this.gKA.setText(str);
        }
    }

    public TextView bPc() {
        if (this.gKA != null) {
            return this.gKA;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.gKE.setAlpha(0.7f);
        } else {
            this.gKE.setAlpha(1);
        }
        this.gKz.setBackgroundColor(ao.getColor(i, R.color.cp_bg_line_c));
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_f);
        ao.setViewTextColor(this.gKA, R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
