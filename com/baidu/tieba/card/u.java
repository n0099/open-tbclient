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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class u extends a<com.baidu.tieba.card.data.o> {
    private HeadImageView cAc;
    private TextView cAd;
    private TextView cAe;
    private TbImageView cAf;
    private TextView cAg;
    private com.baidu.tieba.card.data.o cAh;
    private int cAi;
    private String cAj;
    private String cAk;
    private View cza;
    private String czc;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cAi = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void y(String str, String str2, String str3) {
        this.czc = str;
        this.cAj = str2;
        this.cAk = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.cAc = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.cAd = (TextView) view.findViewById(d.g.promotion_name);
        this.cAe = (TextView) view.findViewById(d.g.promotion_desc);
        this.cAf = (TbImageView) view.findViewById(d.g.promotion_img);
        this.cAg = (TextView) view.findViewById(d.g.promotion_icon);
        this.cza = view.findViewById(d.g.top_line);
        this.cAc.setOnClickListener(this);
        this.cAd.setOnClickListener(this);
        this.cAg.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cAc.setDefaultResource(17170445);
        this.cAc.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cAc.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cAc.setRadius(this.cAi);
        this.cAf.setDrawBorder(true);
        this.cAf.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cAc || view == this.cAd || view == this.cAg) && !StringUtils.isNull(this.cAh.cCx)) {
            TiebaStatic.log(new am(this.cAj).ah(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cAh.cCv)));
            ay.zG().c(aiH(), new String[]{this.cAh.cCx});
        } else if ((view == this.mRootView || view == this.cAe || view == this.cAf) && !StringUtils.isNull(this.cAh.cCA)) {
            TiebaStatic.log(new am(this.cAk).ah(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cAh.cCv)));
            ay.zG().c(aiH(), new String[]{this.cAh.cCA});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, d.f.addresslist_item_bg);
            al.i(this.cAg, d.f.label_bg_gray);
            al.i(this.cza, d.C0141d.cp_bg_line_b);
            al.c(this.cAd, d.C0141d.cp_cont_b, 1);
            al.c(this.cAg, d.C0141d.cp_cont_d, 1);
            al.c(this.cAe, d.C0141d.cp_cont_b, 1);
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
        this.cAh = oVar;
        this.cAc.startLoad(oVar.cCw, 10, false);
        this.cAd.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.cCC)) {
            this.cAg.setVisibility(8);
        } else {
            this.cAg.setVisibility(0);
            this.cAg.setText(oVar.cCC);
        }
        this.cAe.setText(oVar.cCy);
        if (com.baidu.tbadk.core.i.tt().tz()) {
            this.cAf.setVisibility(0);
            this.cAf.startLoad(oVar.cCz, 10, false);
            return;
        }
        this.cAf.setVisibility(8);
    }
}
