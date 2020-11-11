package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private View hHF;
    private TextView hHG;
    private HeadImageView hHH;
    private HeadImageView hHI;
    private HeadImageView hHJ;
    private ImageView hHK;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        al(getView());
    }

    private void al(View view) {
        this.hHF = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.hHG = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.hHK = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.hHH = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.hHI = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.hHJ = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void wA(int i) {
        if (this.hHF != null) {
            this.hHF.setVisibility(i);
        }
    }

    public void wB(int i) {
        if (this.hHK != null) {
            this.hHK.setVisibility(i);
        }
    }

    public void IL(String str) {
        if (this.hHG != null) {
            this.hHG.setText(str);
        }
    }

    public TextView ckb() {
        if (this.hHG != null) {
            return this.hHG;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.hHK.setAlpha(0.7f);
        } else {
            this.hHK.setAlpha(1);
        }
        this.hHF.setBackgroundColor(ap.getColor(i, R.color.cp_bg_line_c));
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.hHG, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
