package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class u extends a<com.baidu.tieba.card.data.o> {
    private View cqx;
    private String cqz;
    private HeadImageView crA;
    private TextView crB;
    private TextView crC;
    private TbImageView crD;
    private TextView crE;
    private com.baidu.tieba.card.data.o crF;
    private int crG;
    private String crH;
    private String crI;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.crG = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void y(String str, String str2, String str3) {
        this.cqz = str;
        this.crH = str2;
        this.crI = str3;
    }

    private void init(View view2) {
        this.mRootView = view2.findViewById(d.g.root_view);
        this.crA = (HeadImageView) view2.findViewById(d.g.promotion_head_img);
        this.crB = (TextView) view2.findViewById(d.g.promotion_name);
        this.crC = (TextView) view2.findViewById(d.g.promotion_desc);
        this.crD = (TbImageView) view2.findViewById(d.g.promotion_img);
        this.crE = (TextView) view2.findViewById(d.g.promotion_icon);
        this.cqx = view2.findViewById(d.g.top_line);
        this.crA.setOnClickListener(this);
        this.crB.setOnClickListener(this);
        this.crE.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.crA.setDefaultResource(17170445);
        this.crA.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.crA.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.crA.setRadius(this.crG);
        this.crD.setDrawBorder(true);
        this.crD.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if ((view2 == this.crA || view2 == this.crB || view2 == this.crE) && !StringUtils.isNull(this.crF.ctT)) {
            TiebaStatic.log(new al(this.crH).ac(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.crF.ctR)));
            ax.wf().c(aeY(), new String[]{this.crF.ctT});
        } else if ((view2 == this.mRootView || view2 == this.crC || view2 == this.crD) && !StringUtils.isNull(this.crF.ctW)) {
            TiebaStatic.log(new al(this.crI).ac(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.crF.ctR)));
            ax.wf().c(aeY(), new String[]{this.crF.ctW});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.f.addresslist_item_bg);
            ak.i(this.crE, d.f.label_bg_gray);
            ak.i(this.cqx, d.C0126d.cp_bg_line_b);
            ak.c(this.crB, d.C0126d.cp_cont_b, 1);
            ak.c(this.crE, d.C0126d.cp_cont_d, 1);
            ak.c(this.crC, d.C0126d.cp_cont_b, 1);
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
        this.crF = oVar;
        this.crA.startLoad(oVar.ctS, 10, false);
        this.crB.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.ctY)) {
            this.crE.setVisibility(8);
        } else {
            this.crE.setVisibility(0);
            this.crE.setText(oVar.ctY);
        }
        this.crC.setText(oVar.ctU);
        if (com.baidu.tbadk.core.i.pX().qd()) {
            this.crD.setVisibility(0);
            this.crD.startLoad(oVar.ctV, 10, false);
            return;
        }
        this.crD.setVisibility(8);
    }
}
