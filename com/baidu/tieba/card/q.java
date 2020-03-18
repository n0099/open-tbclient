package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class q extends a<com.baidu.tieba.card.data.o> {
    private View fLe;
    private String fLh;
    private HeadImageView fMf;
    private TextView fMg;
    private TextView fMh;
    private TbImageView fMi;
    private TextView fMj;
    private com.baidu.tieba.card.data.o fMk;
    private int fMl;
    private String fMm;
    private String fMn;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fMl = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ai(String str, String str2, String str3) {
        this.fLh = str;
        this.fMm = str2;
        this.fMn = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.fMf = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.fMg = (TextView) view.findViewById(R.id.promotion_name);
        this.fMh = (TextView) view.findViewById(R.id.promotion_desc);
        this.fMi = (TbImageView) view.findViewById(R.id.promotion_img);
        this.fMj = (TextView) view.findViewById(R.id.promotion_icon);
        this.fLe = view.findViewById(R.id.top_line);
        this.fMf.setOnClickListener(this);
        this.fMg.setOnClickListener(this);
        this.fMj.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fMf.setDefaultResource(17170445);
        this.fMf.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fMf.setPlaceHolder(1);
        this.fMf.setRadius(this.fMl);
        this.fMi.setDrawBorder(true);
        this.fMi.setBorderWidth(1);
        this.fMi.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.fMf || view == this.fMg || view == this.fMj) && !StringUtils.isNull(this.fMk.fOS)) {
            TiebaStatic.log(new an(this.fMm).cx("obj_id", String.valueOf(this.fMk.fOQ)));
            ba.aGK().b(getTbPageContext(), new String[]{this.fMk.fOS});
        } else if ((view == this.mRootView || view == this.fMh || view == this.fMi) && !StringUtils.isNull(this.fMk.fOV)) {
            TiebaStatic.log(new an(this.fMn).cx("obj_id", String.valueOf(this.fMk.fOQ)));
            ba.aGK().b(getTbPageContext(), new String[]{this.fMk.fOV});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.fMj, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.fLe, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fMg, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fMj, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fMh, R.color.cp_cont_b, 1);
            this.fMf.setPlaceHolder(1);
            this.fMi.setPlaceHolder(2);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.fMk = oVar;
        this.fMf.startLoad(oVar.fOR, 10, false);
        this.fMg.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.fOX)) {
            this.fMj.setVisibility(8);
        } else {
            this.fMj.setVisibility(0);
            this.fMj.setText(oVar.fOX);
        }
        this.fMh.setText(oVar.fOT);
        if (com.baidu.tbadk.core.i.azR().isShowImages()) {
            this.fMi.setVisibility(0);
            this.fMi.startLoad(oVar.fOU, 10, false);
            return;
        }
        this.fMi.setVisibility(8);
    }
}
