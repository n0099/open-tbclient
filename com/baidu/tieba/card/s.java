package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class s extends b<com.baidu.tieba.card.data.p> {
    private View hYA;
    private String hYD;
    private HeadImageView hZE;
    private TextView hZF;
    private TextView hZG;
    private TbImageView hZH;
    private TextView hZI;
    private com.baidu.tieba.card.data.p hZJ;
    private int hZK;
    private String hZL;
    private String hZM;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.hZK = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ax(String str, String str2, String str3) {
        this.hYD = str;
        this.hZL = str2;
        this.hZM = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.hZE = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.hZF = (TextView) view.findViewById(R.id.promotion_name);
        this.hZG = (TextView) view.findViewById(R.id.promotion_desc);
        this.hZH = (TbImageView) view.findViewById(R.id.promotion_img);
        this.hZI = (TextView) view.findViewById(R.id.promotion_icon);
        this.hYA = view.findViewById(R.id.top_line);
        this.hZE.setOnClickListener(this);
        this.hZF.setOnClickListener(this);
        this.hZI.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.hZE.setDefaultResource(17170445);
        this.hZE.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hZE.setPlaceHolder(1);
        this.hZE.setRadius(this.hZK);
        this.hZH.setDrawBorder(true);
        this.hZH.setBorderWidth(1);
        this.hZH.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hZE || view == this.hZF || view == this.hZI) && !StringUtils.isNull(this.hZJ.ict)) {
            TiebaStatic.log(new aq(this.hZL).dR("obj_id", String.valueOf(this.hZJ.icr)));
            be.brr().b(getTbPageContext(), new String[]{this.hZJ.ict});
        } else if ((view == this.mRootView || view == this.hZG || view == this.hZH) && !StringUtils.isNull(this.hZJ.icw)) {
            TiebaStatic.log(new aq(this.hZM).dR("obj_id", String.valueOf(this.hZJ.icr)));
            be.brr().b(getTbPageContext(), new String[]{this.hZJ.icw});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.hZI, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.hYA, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hZF, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hZI, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hZG, R.color.cp_cont_b, 1);
            this.hZE.setPlaceHolder(1);
            this.hZH.setPlaceHolder(2);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.p pVar) {
        if (pVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.hZJ = pVar;
        this.hZE.startLoad(pVar.ics, 10, false);
        this.hZF.setText(UtilHelper.getFixedText(pVar.userName, 7, true));
        if (StringUtils.isNull(pVar.icy)) {
            this.hZI.setVisibility(8);
        } else {
            this.hZI.setVisibility(0);
            this.hZI.setText(pVar.icy);
        }
        this.hZG.setText(pVar.icu);
        if (com.baidu.tbadk.core.k.bjH().isShowImages()) {
            this.hZH.setVisibility(0);
            this.hZH.startLoad(pVar.icv, 10, false);
            return;
        }
        this.hZH.setVisibility(8);
    }
}
