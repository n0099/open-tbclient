package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class r extends b<com.baidu.tieba.card.data.o> {
    private View gRH;
    private String gRK;
    private HeadImageView gSL;
    private TextView gSM;
    private TextView gSN;
    private TbImageView gSO;
    private TextView gSP;
    private com.baidu.tieba.card.data.o gSQ;
    private int gSR;
    private String gSS;
    private String gST;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gSR = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void am(String str, String str2, String str3) {
        this.gRK = str;
        this.gSS = str2;
        this.gST = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.gSL = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.gSM = (TextView) view.findViewById(R.id.promotion_name);
        this.gSN = (TextView) view.findViewById(R.id.promotion_desc);
        this.gSO = (TbImageView) view.findViewById(R.id.promotion_img);
        this.gSP = (TextView) view.findViewById(R.id.promotion_icon);
        this.gRH = view.findViewById(R.id.top_line);
        this.gSL.setOnClickListener(this);
        this.gSM.setOnClickListener(this);
        this.gSP.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gSL.setDefaultResource(17170445);
        this.gSL.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gSL.setPlaceHolder(1);
        this.gSL.setRadius(this.gSR);
        this.gSO.setDrawBorder(true);
        this.gSO.setBorderWidth(1);
        this.gSO.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.gSL || view == this.gSM || view == this.gSP) && !StringUtils.isNull(this.gSQ.gVB)) {
            TiebaStatic.log(new ao(this.gSS).dk("obj_id", String.valueOf(this.gSQ.gVz)));
            bc.aWU().b(getTbPageContext(), new String[]{this.gSQ.gVB});
        } else if ((view == this.mRootView || view == this.gSN || view == this.gSO) && !StringUtils.isNull(this.gSQ.gVE)) {
            TiebaStatic.log(new ao(this.gST).dk("obj_id", String.valueOf(this.gSQ.gVz)));
            bc.aWU().b(getTbPageContext(), new String[]{this.gSQ.gVE});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            an.setBackgroundResource(this.gSP, R.drawable.label_bg_gray);
            an.setBackgroundResource(this.gRH, R.color.cp_bg_line_c);
            an.setViewTextColor(this.gSM, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.gSP, R.color.cp_cont_d, 1);
            an.setViewTextColor(this.gSN, R.color.cp_cont_b, 1);
            this.gSL.setPlaceHolder(1);
            this.gSO.setPlaceHolder(2);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.gSQ = oVar;
        this.gSL.startLoad(oVar.gVA, 10, false);
        this.gSM.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.gVG)) {
            this.gSP.setVisibility(8);
        } else {
            this.gSP.setVisibility(0);
            this.gSP.setText(oVar.gVG);
        }
        this.gSN.setText(oVar.gVC);
        if (com.baidu.tbadk.core.k.aPA().isShowImages()) {
            this.gSO.setVisibility(0);
            this.gSO.startLoad(oVar.gVD, 10, false);
            return;
        }
        this.gSO.setVisibility(8);
    }
}
