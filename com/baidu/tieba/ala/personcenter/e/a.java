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
    private View fsa;
    private TextView fsb;
    private HeadImageView fsc;
    private HeadImageView fsd;
    private HeadImageView fse;
    private ImageView fsf;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fsa = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.fsb = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.fsf = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.fsc = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.fsd = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.fse = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void qE(int i) {
        if (this.fsa != null) {
            this.fsa.setVisibility(i);
        }
    }

    public void qF(int i) {
        if (this.fsf != null) {
            this.fsf.setVisibility(i);
        }
    }

    public void zi(String str) {
        if (this.fsb != null) {
            this.fsb.setText(str);
        }
    }

    public TextView bpY() {
        if (this.fsb != null) {
            return this.fsb;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.fsf.setAlpha(0.7f);
        } else {
            this.fsf.setAlpha(1);
        }
        this.fsa.setBackgroundColor(am.getColor(i, R.color.cp_bg_line_c));
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fsb, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
