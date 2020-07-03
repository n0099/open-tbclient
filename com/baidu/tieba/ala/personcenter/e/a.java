package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private View gFc;
    private TextView gFd;
    private HeadImageView gFe;
    private HeadImageView gFf;
    private HeadImageView gFg;
    private ImageView gFh;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gFc = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.gFd = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.gFh = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.gFe = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.gFf = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.gFg = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void so(int i) {
        if (this.gFc != null) {
            this.gFc.setVisibility(i);
        }
    }

    public void sp(int i) {
        if (this.gFh != null) {
            this.gFh.setVisibility(i);
        }
    }

    public void DD(String str) {
        if (this.gFd != null) {
            this.gFd.setText(str);
        }
    }

    public TextView bLT() {
        if (this.gFd != null) {
            return this.gFd;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.gFh.setAlpha(0.7f);
        } else {
            this.gFh.setAlpha(1);
        }
        this.gFc.setBackgroundColor(an.getColor(i, R.color.cp_bg_line_c));
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        an.setViewTextColor(this.gFd, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
