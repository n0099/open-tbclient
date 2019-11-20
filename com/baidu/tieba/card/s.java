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
import com.baidu.tieba.card.data.o;
/* loaded from: classes4.dex */
public class s extends a<o> {
    private View eMM;
    private String eMP;
    private HeadImageView eNO;
    private TextView eNP;
    private TextView eNQ;
    private TbImageView eNR;
    private TextView eNS;
    private o eNT;
    private int eNU;
    private String eNV;
    private String eNW;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eNU = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void T(String str, String str2, String str3) {
        this.eMP = str;
        this.eNV = str2;
        this.eNW = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.eNO = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.eNP = (TextView) view.findViewById(R.id.promotion_name);
        this.eNQ = (TextView) view.findViewById(R.id.promotion_desc);
        this.eNR = (TbImageView) view.findViewById(R.id.promotion_img);
        this.eNS = (TextView) view.findViewById(R.id.promotion_icon);
        this.eMM = view.findViewById(R.id.top_line);
        this.eNO.setOnClickListener(this);
        this.eNP.setOnClickListener(this);
        this.eNS.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.eNO.setDefaultResource(17170445);
        this.eNO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eNO.setRadius(this.eNU);
        this.eNR.setDrawBorder(true);
        this.eNR.setBorderWidth(1);
        this.eNR.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.eNO || view == this.eNP || view == this.eNS) && !StringUtils.isNull(this.eNT.eQt)) {
            TiebaStatic.log(new an(this.eNV).bS("obj_id", String.valueOf(this.eNT.eQr)));
            ba.amO().b(getTbPageContext(), new String[]{this.eNT.eQt});
        } else if ((view == this.mRootView || view == this.eNQ || view == this.eNR) && !StringUtils.isNull(this.eNT.eQw)) {
            TiebaStatic.log(new an(this.eNW).bS("obj_id", String.valueOf(this.eNT.eQr)));
            ba.amO().b(getTbPageContext(), new String[]{this.eNT.eQw});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.eNS, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.eMM, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eNP, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eNS, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eNQ, R.color.cp_cont_b, 1);
            this.eNO.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
            this.eNR.setDefaultBgResource(com.baidu.tbadk.util.e.Vj());
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.eNT = oVar;
        this.eNO.startLoad(oVar.eQs, 10, false);
        this.eNP.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.eQy)) {
            this.eNS.setVisibility(8);
        } else {
            this.eNS.setVisibility(0);
            this.eNS.setText(oVar.eQy);
        }
        this.eNQ.setText(oVar.eQu);
        if (com.baidu.tbadk.core.i.ago().isShowImages()) {
            this.eNR.setVisibility(0);
            this.eNR.startLoad(oVar.eQv, 10, false);
            return;
        }
        this.eNR.setVisibility(8);
    }
}
