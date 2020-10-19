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
    private View hpN;
    private TextView hpO;
    private HeadImageView hpP;
    private HeadImageView hpQ;
    private HeadImageView hpR;
    private ImageView hpS;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        an(getView());
    }

    private void an(View view) {
        this.hpN = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.hpO = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.hpS = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.hpP = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.hpQ = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.hpR = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void vT(int i) {
        if (this.hpN != null) {
            this.hpN.setVisibility(i);
        }
    }

    public void vU(int i) {
        if (this.hpS != null) {
            this.hpS.setVisibility(i);
        }
    }

    public void HV(String str) {
        if (this.hpO != null) {
            this.hpO.setText(str);
        }
    }

    public TextView cex() {
        if (this.hpO != null) {
            return this.hpO;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.hpS.setAlpha(0.7f);
        } else {
            this.hpS.setAlpha(1);
        }
        this.hpN.setBackgroundColor(ap.getColor(i, R.color.cp_bg_line_c));
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_f);
        ap.setViewTextColor(this.hpO, R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
