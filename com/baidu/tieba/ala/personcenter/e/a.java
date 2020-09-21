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
    private View haM;
    private TextView haN;
    private HeadImageView haO;
    private HeadImageView haP;
    private HeadImageView haQ;
    private ImageView haR;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        am(getView());
    }

    private void am(View view) {
        this.haM = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.haN = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.haR = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.haO = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.haP = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.haQ = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void vn(int i) {
        if (this.haM != null) {
            this.haM.setVisibility(i);
        }
    }

    public void vo(int i) {
        if (this.haR != null) {
            this.haR.setVisibility(i);
        }
    }

    public void Hh(String str) {
        if (this.haN != null) {
            this.haN.setText(str);
        }
    }

    public TextView caZ() {
        if (this.haN != null) {
            return this.haN;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.haR.setAlpha(0.7f);
        } else {
            this.haR.setAlpha(1);
        }
        this.haM.setBackgroundColor(ap.getColor(i, R.color.cp_bg_line_c));
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_f);
        ap.setViewTextColor(this.haN, R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
