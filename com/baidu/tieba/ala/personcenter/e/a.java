package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.ala.personcenter.c.a> {
    private View fvj;
    private TextView fvk;
    private HeadImageView fvl;
    private HeadImageView fvm;
    private HeadImageView fvn;
    private ImageView fvo;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fvj = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.fvk = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.fvo = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.fvl = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.fvm = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.fvn = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void qJ(int i) {
        if (this.fvj != null) {
            this.fvj.setVisibility(i);
        }
    }

    public void qK(int i) {
        if (this.fvo != null) {
            this.fvo.setVisibility(i);
        }
    }

    public void zr(String str) {
        if (this.fvk != null) {
            this.fvk.setText(str);
        }
    }

    public TextView bqZ() {
        if (this.fvk != null) {
            return this.fvk;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.fvo.setAlpha(0.7f);
        } else {
            this.fvo.setAlpha(1);
        }
        this.fvj.setBackgroundColor(am.getColor(i, R.color.cp_bg_line_c));
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fvk, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
