package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.ala.personcenter.c.b> {
    private View iff;
    private TextView ifg;
    private HeadImageView ifh;
    private HeadImageView ifi;
    private HeadImageView ifj;
    private ImageView ifk;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        am(getView());
    }

    private void am(View view) {
        this.iff = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.ifg = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.ifk = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.ifh = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.ifi = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.ifj = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void ww(int i) {
        if (this.iff != null) {
            this.iff.setVisibility(i);
        }
    }

    public void wx(int i) {
        if (this.ifk != null) {
            this.ifk.setVisibility(i);
        }
    }

    public void IB(String str) {
        if (this.ifg != null) {
            this.ifg.setText(str);
        }
    }

    public TextView cnB() {
        if (this.ifg != null) {
            return this.ifg;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.ifk.setAlpha(0.7f);
        } else {
            this.ifk.setAlpha(1);
        }
        this.iff.setBackgroundColor(ap.getColor(i, R.color.CAM_X0204));
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0106);
        ap.setViewTextColor(this.ifg, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
