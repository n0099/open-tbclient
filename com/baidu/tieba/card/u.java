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
    private View cOM;
    private String cOO;
    private HeadImageView cPN;
    private TextView cPO;
    private TextView cPP;
    private TbImageView cPQ;
    private TextView cPR;
    private com.baidu.tieba.card.data.o cPS;
    private int cPT;
    private String cPU;
    private String cPV;
    private View mRootView;

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cPT = tbPageContext.getResources().getDimensionPixelSize(e.C0200e.ds70);
        init(getView());
    }

    public void E(String str, String str2, String str3) {
        this.cOO = str;
        this.cPU = str2;
        this.cPV = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(e.g.root_view);
        this.cPN = (HeadImageView) view.findViewById(e.g.promotion_head_img);
        this.cPO = (TextView) view.findViewById(e.g.promotion_name);
        this.cPP = (TextView) view.findViewById(e.g.promotion_desc);
        this.cPQ = (TbImageView) view.findViewById(e.g.promotion_img);
        this.cPR = (TextView) view.findViewById(e.g.promotion_icon);
        this.cOM = view.findViewById(e.g.top_line);
        this.cPN.setOnClickListener(this);
        this.cPO.setOnClickListener(this);
        this.cPR.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cPN.setDefaultResource(17170445);
        this.cPN.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cPN.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cPN.setRadius(this.cPT);
        this.cPQ.setDrawBorder(true);
        this.cPQ.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cPN || view == this.cPO || view == this.cPR) && !StringUtils.isNull(this.cPS.cSj)) {
            TiebaStatic.log(new am(this.cPU).ax(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cPS.cSh)));
            ay.Db().c(getTbPageContext(), new String[]{this.cPS.cSj});
        } else if ((view == this.mRootView || view == this.cPP || view == this.cPQ) && !StringUtils.isNull(this.cPS.cSm)) {
            TiebaStatic.log(new am(this.cPV).ax(VideoPlayActivityConfig.OBJ_ID, String.valueOf(this.cPS.cSh)));
            ay.Db().c(getTbPageContext(), new String[]{this.cPS.cSm});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.mRootView, e.f.addresslist_item_bg);
            al.i(this.cPR, e.f.label_bg_gray);
            al.i(this.cOM, e.d.cp_bg_line_b);
            al.c(this.cPO, e.d.cp_cont_b, 1);
            al.c(this.cPR, e.d.cp_cont_d, 1);
            al.c(this.cPP, e.d.cp_cont_b, 1);
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
        this.cPS = oVar;
        this.cPN.startLoad(oVar.cSi, 10, false);
        this.cPO.setText(UtilHelper.getFixedText(oVar.userName, 7, true));
        if (StringUtils.isNull(oVar.cSo)) {
            this.cPR.setVisibility(8);
        } else {
            this.cPR.setVisibility(0);
            this.cPR.setText(oVar.cSo);
        }
        this.cPP.setText(oVar.cSk);
        if (com.baidu.tbadk.core.i.wA().wE()) {
            this.cPQ.setVisibility(0);
            this.cPQ.startLoad(oVar.cSl, 10, false);
            return;
        }
        this.cPQ.setVisibility(8);
    }
}
