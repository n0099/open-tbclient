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
    private View ixr;
    private String ixu;
    private HeadImageView iyB;
    private TextView iyC;
    private TextView iyD;
    private TbImageView iyE;
    private TextView iyF;
    private com.baidu.tieba.card.data.o iyG;
    private int iyH;
    private String iyI;
    private String iyJ;
    private View mRootView;

    public s(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.iyH = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void aC(String str, String str2, String str3) {
        this.ixu = str;
        this.iyI = str2;
        this.iyJ = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.iyB = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.iyC = (TextView) view.findViewById(R.id.promotion_name);
        this.iyD = (TextView) view.findViewById(R.id.promotion_desc);
        this.iyE = (TbImageView) view.findViewById(R.id.promotion_img);
        this.iyF = (TextView) view.findViewById(R.id.promotion_icon);
        this.ixr = view.findViewById(R.id.top_line);
        this.iyB.setOnClickListener(this);
        this.iyC.setOnClickListener(this);
        this.iyF.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.iyB.setDefaultResource(17170445);
        this.iyB.setPlaceHolder(1);
        this.iyB.setRadius(this.iyH);
        this.iyE.setDrawBorder(true);
        this.iyE.setBorderWidth(1);
        this.iyE.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iyB || view == this.iyC || view == this.iyF) && !StringUtils.isNull(this.iyG.iBF)) {
            TiebaStatic.log(new ar(this.iyI).dR("obj_id", String.valueOf(this.iyG.iBD)));
            bf.bsV().b(getTbPageContext(), new String[]{this.iyG.iBF});
        } else if ((view == this.mRootView || view == this.iyD || view == this.iyE) && !StringUtils.isNull(this.iyG.iBI)) {
            TiebaStatic.log(new ar(this.iyJ).dR("obj_id", String.valueOf(this.iyG.iBD)));
            bf.bsV().b(getTbPageContext(), new String[]{this.iyG.iBI});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(this.iyF, R.drawable.label_bg_gray);
            ap.setBackgroundResource(this.ixr, R.color.CAM_X0204);
            ap.setViewTextColor(this.iyC, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.iyF, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.iyD, R.color.CAM_X0105, 1);
            this.iyB.setPlaceHolder(1);
            this.iyE.setPlaceHolder(2);
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
        this.iyG = oVar;
        this.iyB.startLoad(oVar.iBE, 10, false);
        this.iyC.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.iBK)) {
            this.iyF.setVisibility(8);
        } else {
            this.iyF.setVisibility(0);
            this.iyF.setText(oVar.iBK);
        }
        this.iyD.setText(oVar.iBG);
        if (com.baidu.tbadk.core.k.bkT().isShowImages()) {
            this.iyE.setVisibility(0);
            this.iyE.startLoad(oVar.iBH, 10, false);
            return;
        }
        this.iyE.setVisibility(8);
    }
}
