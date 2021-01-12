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
    private View irN;
    private String irQ;
    private HeadImageView isR;
    private TextView isS;
    private TextView isT;
    private TbImageView isU;
    private TextView isV;
    private com.baidu.tieba.card.data.o isW;
    private int isX;
    private String isY;
    private String isZ;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.isX = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void aB(String str, String str2, String str3) {
        this.irQ = str;
        this.isY = str2;
        this.isZ = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.isR = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.isS = (TextView) view.findViewById(R.id.promotion_name);
        this.isT = (TextView) view.findViewById(R.id.promotion_desc);
        this.isU = (TbImageView) view.findViewById(R.id.promotion_img);
        this.isV = (TextView) view.findViewById(R.id.promotion_icon);
        this.irN = view.findViewById(R.id.top_line);
        this.isR.setOnClickListener(this);
        this.isS.setOnClickListener(this);
        this.isV.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.isR.setDefaultResource(17170445);
        this.isR.setPlaceHolder(1);
        this.isR.setRadius(this.isX);
        this.isU.setDrawBorder(true);
        this.isU.setBorderWidth(1);
        this.isU.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.isR || view == this.isS || view == this.isV) && !StringUtils.isNull(this.isW.ivV)) {
            TiebaStatic.log(new aq(this.isY).dW("obj_id", String.valueOf(this.isW.ivT)));
            be.bsB().b(getTbPageContext(), new String[]{this.isW.ivV});
        } else if ((view == this.mRootView || view == this.isT || view == this.isU) && !StringUtils.isNull(this.isW.ivY)) {
            TiebaStatic.log(new aq(this.isZ).dW("obj_id", String.valueOf(this.isW.ivT)));
            be.bsB().b(getTbPageContext(), new String[]{this.isW.ivY});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ao.setBackgroundResource(this.isV, R.drawable.label_bg_gray);
            ao.setBackgroundResource(this.irN, R.color.CAM_X0204);
            ao.setViewTextColor(this.isS, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.isV, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.isT, R.color.CAM_X0105, 1);
            this.isR.setPlaceHolder(1);
            this.isU.setPlaceHolder(2);
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
        this.isW = oVar;
        this.isR.startLoad(oVar.ivU, 10, false);
        this.isS.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.iwa)) {
            this.isV.setVisibility(8);
        } else {
            this.isV.setVisibility(0);
            this.isV.setText(oVar.iwa);
        }
        this.isT.setText(oVar.ivW);
        if (com.baidu.tbadk.core.k.bkB().isShowImages()) {
            this.isU.setVisibility(0);
            this.isU.startLoad(oVar.ivX, 10, false);
            return;
        }
        this.isU.setVisibility(8);
    }
}
