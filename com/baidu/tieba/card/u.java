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
    private View cpn;
    private String cpp;
    private HeadImageView cqq;
    private TextView cqr;
    private TextView cqs;
    private TbImageView cqt;
    private TextView cqu;
    private com.baidu.tieba.card.data.o cqv;
    private int cqw;
    private String cqx;
    private String cqy;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cqw = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void y(String str, String str2, String str3) {
        this.cpp = str;
        this.cqx = str2;
        this.cqy = str3;
    }

    private void init(View view2) {
        this.mRootView = view2.findViewById(d.g.root_view);
        this.cqq = (HeadImageView) view2.findViewById(d.g.promotion_head_img);
        this.cqr = (TextView) view2.findViewById(d.g.promotion_name);
        this.cqs = (TextView) view2.findViewById(d.g.promotion_desc);
        this.cqt = (TbImageView) view2.findViewById(d.g.promotion_img);
        this.cqu = (TextView) view2.findViewById(d.g.promotion_icon);
        this.cpn = view2.findViewById(d.g.top_line);
        this.cqq.setOnClickListener(this);
        this.cqr.setOnClickListener(this);
        this.cqu.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cqq.setDefaultResource(17170445);
        this.cqq.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cqq.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cqq.setRadius(this.cqw);
        this.cqt.setDrawBorder(true);
        this.cqt.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if ((view2 == this.cqq || view2 == this.cqr || view2 == this.cqu) && !StringUtils.isNull(this.cqv.csJ)) {
            TiebaStatic.log(new al(this.cqx).ac(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cqv.csH)));
            ax.wg().c(aeY(), new String[]{this.cqv.csJ});
        } else if ((view2 == this.mRootView || view2 == this.cqs || view2 == this.cqt) && !StringUtils.isNull(this.cqv.csM)) {
            TiebaStatic.log(new al(this.cqy).ac(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cqv.csH)));
            ax.wg().c(aeY(), new String[]{this.cqv.csM});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.f.addresslist_item_bg);
            ak.i(this.cqu, d.f.label_bg_gray);
            ak.i(this.cpn, d.C0126d.cp_bg_line_b);
            ak.c(this.cqr, d.C0126d.cp_cont_b, 1);
            ak.c(this.cqu, d.C0126d.cp_cont_d, 1);
            ak.c(this.cqs, d.C0126d.cp_cont_b, 1);
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
        this.cqv = oVar;
        this.cqq.startLoad(oVar.csI, 10, false);
        this.cqr.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.csO)) {
            this.cqu.setVisibility(8);
        } else {
            this.cqu.setVisibility(0);
            this.cqu.setText(oVar.csO);
        }
        this.cqs.setText(oVar.csK);
        if (com.baidu.tbadk.core.i.pY().qe()) {
            this.cqt.setVisibility(0);
            this.cqt.startLoad(oVar.csL, 10, false);
            return;
        }
        this.cqt.setVisibility(8);
    }
}
