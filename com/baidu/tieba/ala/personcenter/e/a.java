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
    private View gXf;
    private TextView gXg;
    private HeadImageView gXh;
    private HeadImageView gXi;
    private HeadImageView gXj;
    private ImageView gXk;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ak(getView());
    }

    private void ak(View view) {
        this.gXf = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.gXg = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.gXk = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.gXh = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.gXi = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.gXj = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void uU(int i) {
        if (this.gXf != null) {
            this.gXf.setVisibility(i);
        }
    }

    public void uV(int i) {
        if (this.gXk != null) {
            this.gXk.setVisibility(i);
        }
    }

    public void GO(String str) {
        if (this.gXg != null) {
            this.gXg.setText(str);
        }
    }

    public TextView bZd() {
        if (this.gXg != null) {
            return this.gXg;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.gXk.setAlpha(0.7f);
        } else {
            this.gXk.setAlpha(1);
        }
        this.gXf.setBackgroundColor(ap.getColor(i, R.color.cp_bg_line_c));
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.gXg, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
