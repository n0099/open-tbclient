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
    private View hBI;
    private TextView hBJ;
    private HeadImageView hBK;
    private HeadImageView hBL;
    private HeadImageView hBM;
    private ImageView hBN;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ah(getView());
    }

    private void ah(View view) {
        this.hBI = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.hBJ = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.hBN = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.hBK = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.hBL = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.hBM = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void wn(int i) {
        if (this.hBI != null) {
            this.hBI.setVisibility(i);
        }
    }

    public void wo(int i) {
        if (this.hBN != null) {
            this.hBN.setVisibility(i);
        }
    }

    public void Iu(String str) {
        if (this.hBJ != null) {
            this.hBJ.setText(str);
        }
    }

    public TextView chz() {
        if (this.hBJ != null) {
            return this.hBJ;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.hBN.setAlpha(0.7f);
        } else {
            this.hBN.setAlpha(1);
        }
        this.hBI.setBackgroundColor(ap.getColor(i, R.color.cp_bg_line_c));
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_f);
        ap.setViewTextColor(this.hBJ, R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
