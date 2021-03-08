package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class s extends b<com.baidu.tieba.card.data.o> {
    private TextView iAA;
    private TbImageView iAB;
    private TextView iAC;
    private com.baidu.tieba.card.data.o iAD;
    private int iAE;
    private String iAF;
    private String iAG;
    private HeadImageView iAy;
    private TextView iAz;
    private View izo;
    private String izr;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iAE = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void aC(String str, String str2, String str3) {
        this.izr = str;
        this.iAF = str2;
        this.iAG = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.iAy = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.iAz = (TextView) view.findViewById(R.id.promotion_name);
        this.iAA = (TextView) view.findViewById(R.id.promotion_desc);
        this.iAB = (TbImageView) view.findViewById(R.id.promotion_img);
        this.iAC = (TextView) view.findViewById(R.id.promotion_icon);
        this.izo = view.findViewById(R.id.top_line);
        this.iAy.setOnClickListener(this);
        this.iAz.setOnClickListener(this);
        this.iAC.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.iAy.setDefaultResource(17170445);
        this.iAy.setPlaceHolder(1);
        this.iAy.setRadius(this.iAE);
        this.iAB.setDrawBorder(true);
        this.iAB.setBorderWidth(1);
        this.iAB.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iAy || view == this.iAz || view == this.iAC) && !StringUtils.isNull(this.iAD.iDC)) {
            TiebaStatic.log(new ar(this.iAF).dR("obj_id", String.valueOf(this.iAD.iDA)));
            bf.bsY().b(getTbPageContext(), new String[]{this.iAD.iDC});
        } else if ((view == this.mRootView || view == this.iAA || view == this.iAB) && !StringUtils.isNull(this.iAD.iDF)) {
            TiebaStatic.log(new ar(this.iAG).dR("obj_id", String.valueOf(this.iAD.iDA)));
            bf.bsY().b(getTbPageContext(), new String[]{this.iAD.iDF});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.iAC, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.izo, R.color.CAM_X0204);
            ap.setViewTextColor(this.iAz, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.iAC, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.iAA, R.color.CAM_X0105, 1);
            this.iAy.setPlaceHolder(1);
            this.iAB.setPlaceHolder(2);
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
        this.iAD = oVar;
        this.iAy.startLoad(oVar.iDB, 10, false);
        this.iAz.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.iDH)) {
            this.iAC.setVisibility(8);
        } else {
            this.iAC.setVisibility(0);
            this.iAC.setText(oVar.iDH);
        }
        this.iAA.setText(oVar.iDD);
        if (com.baidu.tbadk.core.k.bkV().isShowImages()) {
            this.iAB.setVisibility(0);
            this.iAB.startLoad(oVar.iDE, 10, false);
            return;
        }
        this.iAB.setVisibility(8);
    }
}
