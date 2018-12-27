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
    private View cYj;
    private String cYl;
    private HeadImageView cZk;
    private TextView cZl;
    private TextView cZm;
    private TbImageView cZn;
    private TextView cZo;
    private com.baidu.tieba.card.data.o cZp;
    private int cZq;
    private String cZr;
    private String cZs;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cZq = tbPageContext.getResources().getDimensionPixelSize(e.C0210e.ds70);
        init(getView());
    }

    public void F(String str, String str2, String str3) {
        this.cYl = str;
        this.cZr = str2;
        this.cZs = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.root_view);
        this.cZk = (HeadImageView) view.findViewById(e.g.promotion_head_img);
        this.cZl = (TextView) view.findViewById(e.g.promotion_name);
        this.cZm = (TextView) view.findViewById(e.g.promotion_desc);
        this.cZn = (TbImageView) view.findViewById(e.g.promotion_img);
        this.cZo = (TextView) view.findViewById(e.g.promotion_icon);
        this.cYj = view.findViewById(e.g.top_line);
        this.cZk.setOnClickListener(this);
        this.cZl.setOnClickListener(this);
        this.cZo.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cZk.setDefaultResource(17170445);
        this.cZk.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cZk.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cZk.setRadius(this.cZq);
        this.cZn.setDrawBorder(true);
        this.cZn.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cZk || view == this.cZl || view == this.cZo) && !StringUtils.isNull(this.cZp.dbI)) {
            TiebaStatic.log(new am(this.cZr).aA(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cZp.dbG)));
            ay.Ef().c(getTbPageContext(), new String[]{this.cZp.dbI});
        } else if ((view == this.mRootView || view == this.cZm || view == this.cZn) && !StringUtils.isNull(this.cZp.dbL)) {
            TiebaStatic.log(new am(this.cZs).aA(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cZp.dbG)));
            ay.Ef().c(getTbPageContext(), new String[]{this.cZp.dbL});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.i(this.cZo, e.f.label_bg_gray);
            al.i(this.cYj, e.d.cp_bg_line_b);
            al.c(this.cZl, e.d.cp_cont_b, 1);
            al.c(this.cZo, e.d.cp_cont_d, 1);
            al.c(this.cZm, e.d.cp_cont_b, 1);
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
        this.cZp = oVar;
        this.cZk.startLoad(oVar.dbH, 10, false);
        this.cZl.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.dbN)) {
            this.cZo.setVisibility(8);
        } else {
            this.cZo.setVisibility(0);
            this.cZo.setText(oVar.dbN);
        }
        this.cZm.setText(oVar.dbJ);
        if (com.baidu.tbadk.core.i.xE().xI()) {
            this.cZn.setVisibility(0);
            this.cZn.startLoad(oVar.dbK, 10, false);
            return;
        }
        this.cZn.setVisibility(8);
    }
}
