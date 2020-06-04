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
    private View gso;
    private TextView gsp;
    private HeadImageView gsq;
    private HeadImageView gsr;
    private HeadImageView gss;
    private ImageView gst;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gso = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.gsp = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.gst = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.gsq = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.gsr = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.gss = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void rQ(int i) {
        if (this.gso != null) {
            this.gso.setVisibility(i);
        }
    }

    public void rR(int i) {
        if (this.gst != null) {
            this.gst.setVisibility(i);
        }
    }

    public void Dc(String str) {
        if (this.gsp != null) {
            this.gsp.setText(str);
        }
    }

    public TextView bIO() {
        if (this.gsp != null) {
            return this.gsp;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.gst.setAlpha(0.7f);
        } else {
            this.gst.setAlpha(1);
        }
        this.gso.setBackgroundColor(am.getColor(i, R.color.cp_bg_line_c));
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gsp, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
