package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class r extends b<com.baidu.tieba.card.data.o> {
    private View iwu;
    private String iwx;
    private TextView ixA;
    private TbImageView ixB;
    private TextView ixC;
    private com.baidu.tieba.card.data.o ixD;
    private int ixE;
    private String ixF;
    private String ixG;
    private HeadImageView ixy;
    private TextView ixz;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ixE = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void aC(String str, String str2, String str3) {
        this.iwx = str;
        this.ixF = str2;
        this.ixG = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.ixy = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.ixz = (TextView) view.findViewById(R.id.promotion_name);
        this.ixA = (TextView) view.findViewById(R.id.promotion_desc);
        this.ixB = (TbImageView) view.findViewById(R.id.promotion_img);
        this.ixC = (TextView) view.findViewById(R.id.promotion_icon);
        this.iwu = view.findViewById(R.id.top_line);
        this.ixy.setOnClickListener(this);
        this.ixz.setOnClickListener(this);
        this.ixC.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ixy.setDefaultResource(17170445);
        this.ixy.setPlaceHolder(1);
        this.ixy.setRadius(this.ixE);
        this.ixB.setDrawBorder(true);
        this.ixB.setBorderWidth(1);
        this.ixB.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ixy || view == this.ixz || view == this.ixC) && !StringUtils.isNull(this.ixD.iAC)) {
            TiebaStatic.log(new aq(this.ixF).dX("obj_id", String.valueOf(this.ixD.iAA)));
            be.bwu().b(getTbPageContext(), new String[]{this.ixD.iAC});
        } else if ((view == this.mRootView || view == this.ixA || view == this.ixB) && !StringUtils.isNull(this.ixD.iAF)) {
            TiebaStatic.log(new aq(this.ixG).dX("obj_id", String.valueOf(this.ixD.iAA)));
            be.bwu().b(getTbPageContext(), new String[]{this.ixD.iAF});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ao.setBackgroundResource(this.ixC, R.drawable.label_bg_gray);
            ao.setBackgroundResource(this.iwu, R.color.CAM_X0204);
            ao.setViewTextColor(this.ixz, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.ixC, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.ixA, R.color.CAM_X0105, 1);
            this.ixy.setPlaceHolder(1);
            this.ixB.setPlaceHolder(2);
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
        this.ixD = oVar;
        this.ixy.startLoad(oVar.iAB, 10, false);
        this.ixz.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.iAH)) {
            this.ixC.setVisibility(8);
        } else {
            this.ixC.setVisibility(0);
            this.ixC.setText(oVar.iAH);
        }
        this.ixA.setText(oVar.iAD);
        if (com.baidu.tbadk.core.k.bou().isShowImages()) {
            this.ixB.setVisibility(0);
            this.ixB.startLoad(oVar.iAE, 10, false);
            return;
        }
        this.ixB.setVisibility(8);
    }
}
