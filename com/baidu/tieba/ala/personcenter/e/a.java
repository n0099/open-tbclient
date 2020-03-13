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
    private View fxY;
    private TextView fxZ;
    private HeadImageView fya;
    private HeadImageView fyb;
    private HeadImageView fyc;
    private ImageView fyd;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fxY = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.fxZ = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.fyd = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.fya = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.fyb = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.fyc = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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
        if (this.fxY != null) {
            this.fxY.setVisibility(i);
        }
    }

    public void qR(int i) {
        if (this.fyd != null) {
            this.fyd.setVisibility(i);
        }
    }

    public void zJ(String str) {
        if (this.fxZ != null) {
            this.fxZ.setText(str);
        }
    }

    public TextView bsG() {
        if (this.fxZ != null) {
            return this.fxZ;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.fyd.setAlpha(0.7f);
        } else {
            this.fyd.setAlpha(1);
        }
        this.fxY.setBackgroundColor(am.getColor(i, R.color.cp_bg_line_c));
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fxZ, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
