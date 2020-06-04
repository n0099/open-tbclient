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
public class r extends b<com.baidu.tieba.card.data.o> {
    private View gER;
    private String gEU;
    private HeadImageView gFS;
    private TextView gFT;
    private TextView gFU;
    private TbImageView gFV;
    private TextView gFW;
    private com.baidu.tieba.card.data.o gFX;
    private int gFY;
    private String gFZ;
    private String gGa;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.gFY = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds70);
        init(getView());
    }

    public void al(String str, String str2, String str3) {
        this.gEU = str;
        this.gFZ = str2;
        this.gGa = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.root_view);
        this.gFS = (HeadImageView) view.findViewById(R.id.promotion_head_img);
        this.gFT = (TextView) view.findViewById(R.id.promotion_name);
        this.gFU = (TextView) view.findViewById(R.id.promotion_desc);
        this.gFV = (TbImageView) view.findViewById(R.id.promotion_img);
        this.gFW = (TextView) view.findViewById(R.id.promotion_icon);
        this.gER = view.findViewById(R.id.top_line);
        this.gFS.setOnClickListener(this);
        this.gFT.setOnClickListener(this);
        this.gFW.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gFS.setDefaultResource(17170445);
        this.gFS.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gFS.setPlaceHolder(1);
        this.gFS.setRadius(this.gFY);
        this.gFV.setDrawBorder(true);
        this.gFV.setBorderWidth(1);
        this.gFV.setPlaceHolder(2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.gFS || view == this.gFT || view == this.gFW) && !StringUtils.isNull(this.gFX.gIB)) {
            TiebaStatic.log(new an(this.gFZ).dh("obj_id", String.valueOf(this.gFX.gIz)));
            ba.aVa().b(getTbPageContext(), new String[]{this.gFX.gIB});
        } else if ((view == this.mRootView || view == this.gFU || view == this.gFV) && !StringUtils.isNull(this.gFX.gIE)) {
            TiebaStatic.log(new an(this.gGa).dh("obj_id", String.valueOf(this.gFX.gIz)));
            ba.aVa().b(getTbPageContext(), new String[]{this.gFX.gIE});
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
            am.setBackgroundResource(this.gFW, R.drawable.label_bg_gray);
            am.setBackgroundResource(this.gER, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gFT, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gFW, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gFU, R.color.cp_cont_b, 1);
            this.gFS.setPlaceHolder(1);
            this.gFV.setPlaceHolder(2);
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
        this.gFX = oVar;
        this.gFS.startLoad(oVar.gIA, 10, false);
        this.gFT.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.gIG)) {
            this.gFW.setVisibility(8);
        } else {
            this.gFW.setVisibility(0);
            this.gFW.setText(oVar.gIG);
        }
        this.gFU.setText(oVar.gIC);
        if (com.baidu.tbadk.core.k.aNQ().isShowImages()) {
            this.gFV.setVisibility(0);
            this.gFV.startLoad(oVar.gID, 10, false);
            return;
        }
        this.gFV.setVisibility(8);
    }
}
