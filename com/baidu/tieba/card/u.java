package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class u extends a<com.baidu.tieba.card.data.o> {
    private View cwU;
    private String cwW;
    private HeadImageView cxV;
    private TextView cxW;
    private TextView cxX;
    private TbImageView cxY;
    private TextView cxZ;
    private com.baidu.tieba.card.data.o cya;
    private int cyb;
    private String cyc;
    private String cyd;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cyb = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void u(String str, String str2, String str3) {
        this.cwW = str;
        this.cyc = str2;
        this.cyd = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.cxV = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.cxW = (TextView) view.findViewById(d.g.promotion_name);
        this.cxX = (TextView) view.findViewById(d.g.promotion_desc);
        this.cxY = (TbImageView) view.findViewById(d.g.promotion_img);
        this.cxZ = (TextView) view.findViewById(d.g.promotion_icon);
        this.cwU = view.findViewById(d.g.top_line);
        this.cxV.setOnClickListener(this);
        this.cxW.setOnClickListener(this);
        this.cxZ.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cxV.setDefaultResource(17170445);
        this.cxV.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cxV.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.cxV.setRadius(this.cyb);
        this.cxY.setDrawBorder(true);
        this.cxY.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cxV || view == this.cxW || view == this.cxZ) && !StringUtils.isNull(this.cya.cAr)) {
            TiebaStatic.log(new an(this.cyc).ah(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cya.cAp)));
            az.zV().c(ahZ(), new String[]{this.cya.cAr});
        } else if ((view == this.mRootView || view == this.cxX || view == this.cxY) && !StringUtils.isNull(this.cya.cAu)) {
            TiebaStatic.log(new an(this.cyd).ah(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cya.cAp)));
            az.zV().c(ahZ(), new String[]{this.cya.cAu});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.mRootView, d.f.addresslist_item_bg);
            am.i(this.cxZ, d.f.label_bg_gray);
            am.i(this.cwU, d.C0142d.cp_bg_line_b);
            am.c(this.cxW, d.C0142d.cp_cont_b, 1);
            am.c(this.cxZ, d.C0142d.cp_cont_d, 1);
            am.c(this.cxX, d.C0142d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_promotion_item;
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
        this.cya = oVar;
        this.cxV.startLoad(oVar.cAq, 10, false);
        this.cxW.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.cAw)) {
            this.cxZ.setVisibility(8);
        } else {
            this.cxZ.setVisibility(0);
            this.cxZ.setText(oVar.cAw);
        }
        this.cxX.setText(oVar.cAs);
        if (com.baidu.tbadk.core.i.tt().tz()) {
            this.cxY.setVisibility(0);
            this.cxY.startLoad(oVar.cAt, 10, false);
            return;
        }
        this.cxY.setVisibility(8);
    }
}
