package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private HeadImageView idA;
    private ImageView idB;
    private View idv;
    private TextView idw;
    private HeadImageView idy;
    private HeadImageView idz;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        am(getView());
    }

    private void am(View view) {
        this.idv = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.idw = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.idB = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.idy = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.idz = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.idA = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void wv(int i) {
        if (this.idv != null) {
            this.idv.setVisibility(i);
        }
    }

    public void ww(int i) {
        if (this.idB != null) {
            this.idB.setVisibility(i);
        }
    }

    public void Is(String str) {
        if (this.idw != null) {
            this.idw.setText(str);
        }
    }

    public TextView cnv() {
        if (this.idw != null) {
            return this.idw;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.idB.setAlpha(0.7f);
        } else {
            this.idB.setAlpha(1);
        }
        this.idv.setBackgroundColor(ap.getColor(i, R.color.CAM_X0204));
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0106);
        ap.setViewTextColor(this.idw, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
