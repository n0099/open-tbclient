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
    private View hHm;
    private TextView hHn;
    private HeadImageView hHo;
    private HeadImageView hHp;
    private HeadImageView hHq;
    private ImageView hHr;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        al(getView());
    }

    private void al(View view) {
        this.hHm = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.hHn = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.hHr = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.hHo = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.hHp = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.hHq = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void wY(int i) {
        if (this.hHm != null) {
            this.hHm.setVisibility(i);
        }
    }

    public void wZ(int i) {
        if (this.hHr != null) {
            this.hHr.setVisibility(i);
        }
    }

    public void Im(String str) {
        if (this.hHn != null) {
            this.hHn.setText(str);
        }
    }

    public TextView cju() {
        if (this.hHn != null) {
            return this.hHn;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.hHr.setAlpha(0.7f);
        } else {
            this.hHr.setAlpha(1);
        }
        this.hHm.setBackgroundColor(ap.getColor(i, R.color.CAM_X0204));
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0106);
        ap.setViewTextColor(this.hHn, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
