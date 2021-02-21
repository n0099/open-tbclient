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
    private View ixF;
    private String ixI;
    private HeadImageView iyP;
    private TextView iyQ;
    private TextView iyR;
    private TbImageView iyS;
    private TextView iyT;
    private com.baidu.tieba.card.data.o iyU;
    private int iyV;
    private String iyW;
    private String iyX;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iyV = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void aC(String str, String str2, String str3) {
        this.ixI = str;
        this.iyW = str2;
        this.iyX = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.iyP = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.iyQ = (TextView) view.findViewById(R.id.promotion_name);
        this.iyR = (TextView) view.findViewById(R.id.promotion_desc);
        this.iyS = (TbImageView) view.findViewById(R.id.promotion_img);
        this.iyT = (TextView) view.findViewById(R.id.promotion_icon);
        this.ixF = view.findViewById(R.id.top_line);
        this.iyP.setOnClickListener(this);
        this.iyQ.setOnClickListener(this);
        this.iyT.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.iyP.setDefaultResource(17170445);
        this.iyP.setPlaceHolder(1);
        this.iyP.setRadius(this.iyV);
        this.iyS.setDrawBorder(true);
        this.iyS.setBorderWidth(1);
        this.iyS.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iyP || view == this.iyQ || view == this.iyT) && !StringUtils.isNull(this.iyU.iBT)) {
            TiebaStatic.log(new ar(this.iyW).dR("obj_id", String.valueOf(this.iyU.iBR)));
            bf.bsV().b(getTbPageContext(), new String[]{this.iyU.iBT});
        } else if ((view == this.mRootView || view == this.iyR || view == this.iyS) && !StringUtils.isNull(this.iyU.iBW)) {
            TiebaStatic.log(new ar(this.iyX).dR("obj_id", String.valueOf(this.iyU.iBR)));
            bf.bsV().b(getTbPageContext(), new String[]{this.iyU.iBW});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.iyT, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.ixF, R.color.CAM_X0204);
            ap.setViewTextColor(this.iyQ, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.iyT, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.iyR, R.color.CAM_X0105, 1);
            this.iyP.setPlaceHolder(1);
            this.iyS.setPlaceHolder(2);
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
        this.iyU = oVar;
        this.iyP.startLoad(oVar.iBS, 10, false);
        this.iyQ.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.iBY)) {
            this.iyT.setVisibility(8);
        } else {
            this.iyT.setVisibility(0);
            this.iyT.setText(oVar.iBY);
        }
        this.iyR.setText(oVar.iBU);
        if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
            this.iyS.setVisibility(0);
            this.iyS.startLoad(oVar.iBV, 10, false);
            return;
        }
        this.iyS.setVisibility(8);
    }
}
