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
    private View cNG;
    private String cNI;
    private HeadImageView cOH;
    private TextView cOI;
    private TextView cOJ;
    private TbImageView cOK;
    private TextView cOL;
    private com.baidu.tieba.card.data.o cOM;
    private int cON;
    private String cOO;
    private String cOP;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cON = tbPageContext.getResources().getDimensionPixelSize(e.C0175e.ds70);
        init(getView());
    }

    public void E(String str, String str2, String str3) {
        this.cNI = str;
        this.cOO = str2;
        this.cOP = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.root_view);
        this.cOH = (HeadImageView) view.findViewById(e.g.promotion_head_img);
        this.cOI = (TextView) view.findViewById(e.g.promotion_name);
        this.cOJ = (TextView) view.findViewById(e.g.promotion_desc);
        this.cOK = (TbImageView) view.findViewById(e.g.promotion_img);
        this.cOL = (TextView) view.findViewById(e.g.promotion_icon);
        this.cNG = view.findViewById(e.g.top_line);
        this.cOH.setOnClickListener(this);
        this.cOI.setOnClickListener(this);
        this.cOL.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cOH.setDefaultResource(17170445);
        this.cOH.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cOH.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cOH.setRadius(this.cON);
        this.cOK.setDrawBorder(true);
        this.cOK.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cOH || view == this.cOI || view == this.cOL) && !StringUtils.isNull(this.cOM.cRd)) {
            TiebaStatic.log(new am(this.cOO).ax(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cOM.cRb)));
            ay.CU().c(getTbPageContext(), new String[]{this.cOM.cRd});
        } else if ((view == this.mRootView || view == this.cOJ || view == this.cOK) && !StringUtils.isNull(this.cOM.cRg)) {
            TiebaStatic.log(new am(this.cOP).ax(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cOM.cRb)));
            ay.CU().c(getTbPageContext(), new String[]{this.cOM.cRg});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.i(this.cOL, e.f.label_bg_gray);
            al.i(this.cNG, e.d.cp_bg_line_b);
            al.c(this.cOI, e.d.cp_cont_b, 1);
            al.c(this.cOL, e.d.cp_cont_d, 1);
            al.c(this.cOJ, e.d.cp_cont_b, 1);
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
        this.cOM = oVar;
        this.cOH.startLoad(oVar.cRc, 10, false);
        this.cOI.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.cRi)) {
            this.cOL.setVisibility(8);
        } else {
            this.cOL.setVisibility(0);
            this.cOL.setText(oVar.cRi);
        }
        this.cOJ.setText(oVar.cRe);
        if (com.baidu.tbadk.core.i.ws().ww()) {
            this.cOK.setVisibility(0);
            this.cOK.startLoad(oVar.cRf, 10, false);
            return;
        }
        this.cOK.setVisibility(8);
    }
}
