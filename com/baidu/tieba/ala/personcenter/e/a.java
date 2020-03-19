package com.baidu.tieba.ala.personcenter.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.ala.personcenter.c.a> {
    private View fyE;
    private TextView fyF;
    private HeadImageView fyG;
    private HeadImageView fyH;
    private HeadImageView fyI;
    private ImageView fyJ;
    private TextView mTitle;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fyE = view.findViewById(R.id.ala_person_center_list_item_sep);
        this.mTitle = (TextView) view.findViewById(R.id.ala_person_center_list_item_title_txt);
        this.fyF = (TextView) view.findViewById(R.id.ala_person_center_list_item_desc_txt);
        this.fyJ = (ImageView) view.findViewById(R.id.ala_person_center_list_item_arrow_img);
        this.fyG = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img1);
        this.fyH = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img2);
        this.fyI = (HeadImageView) view.findViewById(R.id.ala_person_center_list_item_contribution_img3);
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

    public void qS(int i) {
        if (this.fyE != null) {
            this.fyE.setVisibility(i);
        }
    }

    public void qT(int i) {
        if (this.fyJ != null) {
            this.fyJ.setVisibility(i);
        }
    }

    public void zL(String str) {
        if (this.fyF != null) {
            this.fyF.setText(str);
        }
    }

    public TextView bsM() {
        if (this.fyF != null) {
            return this.fyF;
        }
        return null;
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i == 1) {
            this.fyJ.setAlpha(0.7f);
        } else {
            this.fyJ.setAlpha(1);
        }
        this.fyE.setBackgroundColor(am.getColor(i, R.color.cp_bg_line_c));
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fyF, (int) R.color.cp_cont_d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
