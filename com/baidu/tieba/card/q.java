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
    private View gpR;
    private String gpU;
    private HeadImageView gqS;
    private TextView gqT;
    private TextView gqU;
    private TbImageView gqV;
    private TextView gqW;
    private com.baidu.tieba.card.data.o gqX;
    private int gqY;
    private String gqZ;
    private String gra;
    private View mRootView;

    public q(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gqY = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void ah(String str, String str2, String str3) {
        this.gpU = str;
        this.gqZ = str2;
        this.gra = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.gqS = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.gqT = (TextView) view.findViewById(R.id.promotion_name);
        this.gqU = (TextView) view.findViewById(R.id.promotion_desc);
        this.gqV = (TbImageView) view.findViewById(R.id.promotion_img);
        this.gqW = (TextView) view.findViewById(R.id.promotion_icon);
        this.gpR = view.findViewById(R.id.top_line);
        this.gqS.setOnClickListener(this);
        this.gqT.setOnClickListener(this);
        this.gqW.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gqS.setDefaultResource(17170445);
        this.gqS.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gqS.setPlaceHolder(1);
        this.gqS.setRadius(this.gqY);
        this.gqV.setDrawBorder(true);
        this.gqV.setBorderWidth(1);
        this.gqV.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.gqS || view == this.gqT || view == this.gqW) && !StringUtils.isNull(this.gqX.gtF)) {
            TiebaStatic.log(new an(this.gqZ).cI("obj_id", String.valueOf(this.gqX.gtD)));
            ba.aOV().b(getTbPageContext(), new String[]{this.gqX.gtF});
        } else if ((view == this.mRootView || view == this.gqU || view == this.gqV) && !StringUtils.isNull(this.gqX.gtI)) {
            TiebaStatic.log(new an(this.gra).cI("obj_id", String.valueOf(this.gqX.gtD)));
            ba.aOV().b(getTbPageContext(), new String[]{this.gqX.gtI});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.gqW, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.gpR, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gqT, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gqW, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gqU, R.color.cp_cont_b, 1);
            this.gqS.setPlaceHolder(1);
            this.gqV.setPlaceHolder(2);
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
        this.gqX = oVar;
        this.gqS.startLoad(oVar.gtE, 10, false);
        this.gqT.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.gtK)) {
            this.gqW.setVisibility(8);
        } else {
            this.gqW.setVisibility(0);
            this.gqW.setText(oVar.gtK);
        }
        this.gqU.setText(oVar.gtG);
        if (com.baidu.tbadk.core.i.aIc().isShowImages()) {
            this.gqV.setVisibility(0);
            this.gqV.startLoad(oVar.gtH, 10, false);
            return;
        }
        this.gqV.setVisibility(8);
    }
}
