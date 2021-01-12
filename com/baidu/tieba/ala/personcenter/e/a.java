package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private View hYK;
    private TextView hYL;
    private HeadImageView hYM;
    private HeadImageView hYN;
    private HeadImageView hYO;
    private ImageView hYP;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ap(getView());
    }

    private void ap(View view) {
        this.hYK = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.hYL = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.hYP = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.hYM = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.hYN = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.hYO = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void wk(int i) {
        if (this.hYK != null) {
            this.hYK.setVisibility(i);
        }
    }

    public void wl(int i) {
        if (this.hYP != null) {
            this.hYP.setVisibility(i);
        }
    }

    public void HN(String str) {
        if (this.hYL != null) {
            this.hYL.setText(str);
        }
    }

    public TextView cmq() {
        if (this.hYL != null) {
            return this.hYL;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.hYP.setAlpha(0.7f);
        } else {
            this.hYP.setAlpha(1);
        }
        this.hYK.setBackgroundColor(ao.getColor(i, R.color.CAM_X0204));
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0106);
        ao.setViewTextColor(this.hYL, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
