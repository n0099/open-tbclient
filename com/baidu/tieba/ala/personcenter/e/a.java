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
    private View ide;
    private TextView idf;
    private HeadImageView idg;
    private HeadImageView idh;
    private HeadImageView idi;
    private ImageView idj;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        am(getView());
    }

    private void am(View view) {
        this.ide = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.idf = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.idj = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.idg = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.idh = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.idi = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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
        if (this.ide != null) {
            this.ide.setVisibility(i);
        }
    }

    public void ww(int i) {
        if (this.idj != null) {
            this.idj.setVisibility(i);
        }
    }

    public void Ir(String str) {
        if (this.idf != null) {
            this.idf.setText(str);
        }
    }

    public TextView cno() {
        if (this.idf != null) {
            return this.idf;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.idj.setAlpha(0.7f);
        } else {
            this.idj.setAlpha(1);
        }
        this.ide.setBackgroundColor(ap.getColor(i, R.color.CAM_X0204));
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0106);
        ap.setViewTextColor(this.idf, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
