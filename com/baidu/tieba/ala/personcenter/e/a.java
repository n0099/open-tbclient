package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private View gsd;
    private TextView gse;
    private HeadImageView gsf;
    private HeadImageView gsg;
    private HeadImageView gsh;
    private ImageView gsi;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gsd = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.gse = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.gsi = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.gsf = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.gsg = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.gsh = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void rO(int i) {
        if (this.gsd != null) {
            this.gsd.setVisibility(i);
        }
    }

    public void rP(int i) {
        if (this.gsi != null) {
            this.gsi.setVisibility(i);
        }
    }

    public void Dc(String str) {
        if (this.gse != null) {
            this.gse.setText(str);
        }
    }

    public TextView bIM() {
        if (this.gse != null) {
            return this.gse;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.gsi.setAlpha(0.7f);
        } else {
            this.gsi.setAlpha(1);
        }
        this.gsd.setBackgroundColor(am.getColor(i, R.color.cp_bg_line_c));
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gse, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
