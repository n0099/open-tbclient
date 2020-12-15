package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private View hQV;
    private TextView hQW;
    private HeadImageView hQX;
    private HeadImageView hQY;
    private HeadImageView hQZ;
    private ImageView hRa;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        an(getView());
    }

    private void an(View view) {
        this.hQV = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.hQW = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.hRa = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.hQX = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.hQY = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.hQZ = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void xD(int i) {
        if (this.hQV != null) {
            this.hQV.setVisibility(i);
        }
    }

    public void xE(int i) {
        if (this.hRa != null) {
            this.hRa.setVisibility(i);
        }
    }

    public void Jb(String str) {
        if (this.hQW != null) {
            this.hQW.setText(str);
        }
    }

    public TextView cnp() {
        if (this.hQW != null) {
            return this.hQW;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.hRa.setAlpha(0.7f);
        } else {
            this.hRa.setAlpha(1);
        }
        this.hQV.setBackgroundColor(ap.getColor(i, R.color.CAM_X0204));
        ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0106);
        ap.setViewTextColor(this.hQW, (int) R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
