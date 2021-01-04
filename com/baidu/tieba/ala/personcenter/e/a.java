package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private ImageView idA;
    private View idu;
    private TextView idv;
    private HeadImageView idw;
    private HeadImageView idy;
    private HeadImageView idz;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ap(getView());
    }

    private void ap(View view) {
        this.idu = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.idv = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.idA = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.idw = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.idy = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.idz = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void xQ(int i) {
        if (this.idu != null) {
            this.idu.setVisibility(i);
        }
    }

    public void xR(int i) {
        if (this.idA != null) {
            this.idA.setVisibility(i);
        }
    }

    public void IZ(String str) {
        if (this.idv != null) {
            this.idv.setText(str);
        }
    }

    public TextView cqh() {
        if (this.idv != null) {
            return this.idv;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.idA.setAlpha(0.7f);
        } else {
            this.idA.setAlpha(1);
        }
        this.idu.setBackgroundColor(ao.getColor(i, R.color.CAM_X0204));
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0106);
        ao.setViewTextColor(this.idv, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
