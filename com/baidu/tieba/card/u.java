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
    private View cpq;
    private String cps;
    private String cqA;
    private String cqB;
    private HeadImageView cqt;
    private TextView cqu;
    private TextView cqv;
    private TbImageView cqw;
    private TextView cqx;
    private com.baidu.tieba.card.data.o cqy;
    private int cqz;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cqz = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void y(String str, String str2, String str3) {
        this.cps = str;
        this.cqA = str2;
        this.cqB = str3;
    }

    private void init(View view2) {
        this.mRootView = view2.findViewById(d.g.root_view);
        this.cqt = (HeadImageView) view2.findViewById(d.g.promotion_head_img);
        this.cqu = (TextView) view2.findViewById(d.g.promotion_name);
        this.cqv = (TextView) view2.findViewById(d.g.promotion_desc);
        this.cqw = (TbImageView) view2.findViewById(d.g.promotion_img);
        this.cqx = (TextView) view2.findViewById(d.g.promotion_icon);
        this.cpq = view2.findViewById(d.g.top_line);
        this.cqt.setOnClickListener(this);
        this.cqu.setOnClickListener(this);
        this.cqx.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cqt.setDefaultResource(17170445);
        this.cqt.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cqt.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cqt.setRadius(this.cqz);
        this.cqw.setDrawBorder(true);
        this.cqw.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if ((view2 == this.cqt || view2 == this.cqu || view2 == this.cqx) && !StringUtils.isNull(this.cqy.csM)) {
            TiebaStatic.log(new al(this.cqA).ac(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cqy.csK)));
            ax.wg().c(aeY(), new String[]{this.cqy.csM});
        } else if ((view2 == this.mRootView || view2 == this.cqv || view2 == this.cqw) && !StringUtils.isNull(this.cqy.csP)) {
            TiebaStatic.log(new al(this.cqB).ac(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cqy.csK)));
            ax.wg().c(aeY(), new String[]{this.cqy.csP});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(this.mRootView, d.f.addresslist_item_bg);
            ak.i(this.cqx, d.f.label_bg_gray);
            ak.i(this.cpq, d.C0126d.cp_bg_line_b);
            ak.c(this.cqu, d.C0126d.cp_cont_b, 1);
            ak.c(this.cqx, d.C0126d.cp_cont_d, 1);
            ak.c(this.cqv, d.C0126d.cp_cont_b, 1);
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
        this.cqy = oVar;
        this.cqt.startLoad(oVar.csL, 10, false);
        this.cqu.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.csR)) {
            this.cqx.setVisibility(8);
        } else {
            this.cqx.setVisibility(0);
            this.cqx.setText(oVar.csR);
        }
        this.cqv.setText(oVar.csN);
        if (com.baidu.tbadk.core.i.pY().qe()) {
            this.cqw.setVisibility(0);
            this.cqw.startLoad(oVar.csO, 10, false);
            return;
        }
        this.cqw.setVisibility(8);
    }
}
