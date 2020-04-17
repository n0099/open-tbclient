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
    private View gpL;
    private String gpO;
    private HeadImageView gqM;
    private TextView gqN;
    private TextView gqO;
    private TbImageView gqP;
    private TextView gqQ;
    private com.baidu.tieba.card.data.o gqR;
    private int gqS;
    private String gqT;
    private String gqU;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gqS = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ah(String str, String str2, String str3) {
        this.gpO = str;
        this.gqT = str2;
        this.gqU = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.gqM = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.gqN = (TextView) view.findViewById(R.id.promotion_name);
        this.gqO = (TextView) view.findViewById(R.id.promotion_desc);
        this.gqP = (TbImageView) view.findViewById(R.id.promotion_img);
        this.gqQ = (TextView) view.findViewById(R.id.promotion_icon);
        this.gpL = view.findViewById(R.id.top_line);
        this.gqM.setOnClickListener(this);
        this.gqN.setOnClickListener(this);
        this.gqQ.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gqM.setDefaultResource(17170445);
        this.gqM.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gqM.setPlaceHolder(1);
        this.gqM.setRadius(this.gqS);
        this.gqP.setDrawBorder(true);
        this.gqP.setBorderWidth(1);
        this.gqP.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.gqM || view == this.gqN || view == this.gqQ) && !StringUtils.isNull(this.gqR.gtz)) {
            TiebaStatic.log(new an(this.gqT).cI("obj_id", String.valueOf(this.gqR.gtx)));
            ba.aOY().b(getTbPageContext(), new String[]{this.gqR.gtz});
        } else if ((view == this.mRootView || view == this.gqO || view == this.gqP) && !StringUtils.isNull(this.gqR.gtC)) {
            TiebaStatic.log(new an(this.gqU).cI("obj_id", String.valueOf(this.gqR.gtx)));
            ba.aOY().b(getTbPageContext(), new String[]{this.gqR.gtC});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.gqQ, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.gpL, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gqN, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gqQ, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gqO, R.color.cp_cont_b, 1);
            this.gqM.setPlaceHolder(1);
            this.gqP.setPlaceHolder(2);
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
        this.gqR = oVar;
        this.gqM.startLoad(oVar.gty, 10, false);
        this.gqN.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.gtE)) {
            this.gqQ.setVisibility(8);
        } else {
            this.gqQ.setVisibility(0);
            this.gqQ.setText(oVar.gtE);
        }
        this.gqO.setText(oVar.gtA);
        if (com.baidu.tbadk.core.i.aIe().isShowImages()) {
            this.gqP.setVisibility(0);
            this.gqP.startLoad(oVar.gtB, 10, false);
            return;
        }
        this.gqP.setVisibility(8);
    }
}
