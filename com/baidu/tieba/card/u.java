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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class u extends a<com.baidu.tieba.card.data.o> {
    private TextView cAA;
    private TbImageView cAB;
    private TextView cAC;
    private com.baidu.tieba.card.data.o cAD;
    private int cAE;
    private String cAF;
    private String cAG;
    private HeadImageView cAy;
    private TextView cAz;
    private View czx;
    private String czz;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cAE = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void x(String str, String str2, String str3) {
        this.czz = str;
        this.cAF = str2;
        this.cAG = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.cAy = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.cAz = (TextView) view.findViewById(d.g.promotion_name);
        this.cAA = (TextView) view.findViewById(d.g.promotion_desc);
        this.cAB = (TbImageView) view.findViewById(d.g.promotion_img);
        this.cAC = (TextView) view.findViewById(d.g.promotion_icon);
        this.czx = view.findViewById(d.g.top_line);
        this.cAy.setOnClickListener(this);
        this.cAz.setOnClickListener(this);
        this.cAC.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cAy.setDefaultResource(17170445);
        this.cAy.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cAy.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.cAy.setRadius(this.cAE);
        this.cAB.setDrawBorder(true);
        this.cAB.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cAy || view == this.cAz || view == this.cAC) && !StringUtils.isNull(this.cAD.cCW)) {
            TiebaStatic.log(new an(this.cAF).af(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cAD.cCU)));
            ay.zK().c(aiy(), new String[]{this.cAD.cCW});
        } else if ((view == this.mRootView || view == this.cAA || view == this.cAB) && !StringUtils.isNull(this.cAD.cCZ)) {
            TiebaStatic.log(new an(this.cAG).af(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cAD.cCU)));
            ay.zK().c(aiy(), new String[]{this.cAD.cCZ});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.mRootView, d.f.addresslist_item_bg);
            am.i(this.cAC, d.f.label_bg_gray);
            am.i(this.czx, d.C0140d.cp_bg_line_b);
            am.c(this.cAz, d.C0140d.cp_cont_b, 1);
            am.c(this.cAC, d.C0140d.cp_cont_d, 1);
            am.c(this.cAA, d.C0140d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_promotion_item;
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
        this.cAD = oVar;
        this.cAy.startLoad(oVar.cCV, 10, false);
        this.cAz.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.cDb)) {
            this.cAC.setVisibility(8);
        } else {
            this.cAC.setVisibility(0);
            this.cAC.setText(oVar.cDb);
        }
        this.cAA.setText(oVar.cCX);
        if (com.baidu.tbadk.core.i.te().tk()) {
            this.cAB.setVisibility(0);
            this.cAB.startLoad(oVar.cCY, 10, false);
            return;
        }
        this.cAB.setVisibility(8);
    }
}
