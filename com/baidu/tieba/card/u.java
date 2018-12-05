package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class u extends a<com.baidu.tieba.card.data.o> {
    private View cVt;
    private String cVv;
    private int cWA;
    private String cWB;
    private String cWC;
    private HeadImageView cWu;
    private TextView cWv;
    private TextView cWw;
    private TbImageView cWx;
    private TextView cWy;
    private com.baidu.tieba.card.data.o cWz;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cWA = tbPageContext.getResources().getDimensionPixelSize(e.C0210e.ds70);
        init(getView());
    }

    public void F(String str, String str2, String str3) {
        this.cVv = str;
        this.cWB = str2;
        this.cWC = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.root_view);
        this.cWu = (HeadImageView) view.findViewById(e.g.promotion_head_img);
        this.cWv = (TextView) view.findViewById(e.g.promotion_name);
        this.cWw = (TextView) view.findViewById(e.g.promotion_desc);
        this.cWx = (TbImageView) view.findViewById(e.g.promotion_img);
        this.cWy = (TextView) view.findViewById(e.g.promotion_icon);
        this.cVt = view.findViewById(e.g.top_line);
        this.cWu.setOnClickListener(this);
        this.cWv.setOnClickListener(this);
        this.cWy.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cWu.setDefaultResource(17170445);
        this.cWu.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWu.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWu.setRadius(this.cWA);
        this.cWx.setDrawBorder(true);
        this.cWx.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cWu || view == this.cWv || view == this.cWy) && !StringUtils.isNull(this.cWz.cYQ)) {
            TiebaStatic.log(new am(this.cWB).aA(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cWz.cYO)));
            ay.Ef().c(getTbPageContext(), new String[]{this.cWz.cYQ});
        } else if ((view == this.mRootView || view == this.cWw || view == this.cWx) && !StringUtils.isNull(this.cWz.cYT)) {
            TiebaStatic.log(new am(this.cWC).aA(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cWz.cYO)));
            ay.Ef().c(getTbPageContext(), new String[]{this.cWz.cYT});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.i(this.cWy, e.f.label_bg_gray);
            al.i(this.cVt, e.d.cp_bg_line_b);
            al.c(this.cWv, e.d.cp_cont_b, 1);
            al.c(this.cWy, e.d.cp_cont_d, 1);
            al.c(this.cWw, e.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_promotion_item;
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
        this.cWz = oVar;
        this.cWu.startLoad(oVar.cYP, 10, false);
        this.cWv.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.cYV)) {
            this.cWy.setVisibility(8);
        } else {
            this.cWy.setVisibility(0);
            this.cWy.setText(oVar.cYV);
        }
        this.cWw.setText(oVar.cYR);
        if (com.baidu.tbadk.core.i.xE().xI()) {
            this.cWx.setVisibility(0);
            this.cWx.startLoad(oVar.cYS, 10, false);
            return;
        }
        this.cWx.setVisibility(8);
    }
}
