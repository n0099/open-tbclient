package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class by extends a<com.baidu.tieba.card.data.r> {
    private HeadImageView bdQ;
    private TextView bdR;
    private TextView bdS;
    private TbImageView bdT;
    private TextView bdU;
    private com.baidu.tieba.card.data.r bdV;
    private int bdW;
    private String bdX;
    private String bdY;
    private View bdw;
    private String bdy;
    private View mRootView;

    public by(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bdW = tbPageContext.getResources().getDimensionPixelSize(r.e.ds70);
        W(getView());
    }

    public void t(String str, String str2, String str3) {
        this.bdy = str;
        this.bdX = str2;
        this.bdY = str3;
    }

    private void W(View view) {
        this.mRootView = view.findViewById(r.g.root_view);
        this.bdQ = (HeadImageView) view.findViewById(r.g.promotion_head_img);
        this.bdR = (TextView) view.findViewById(r.g.promotion_name);
        this.bdS = (TextView) view.findViewById(r.g.promotion_desc);
        this.bdT = (TbImageView) view.findViewById(r.g.promotion_img);
        this.bdU = (TextView) view.findViewById(r.g.promotion_icon);
        this.bdw = view.findViewById(r.g.top_line);
        this.bdQ.setOnClickListener(this);
        this.bdR.setOnClickListener(this);
        this.bdU.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bdQ.setDefaultResource(17170445);
        this.bdQ.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bdQ.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bdQ.setRadius(this.bdW);
        this.bdT.setDrawBorder(true);
        this.bdT.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bdQ || view == this.bdR || view == this.bdU) && !StringUtils.isNull(this.bdV.bfn)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.at(this.bdX).ab("obj_id", String.valueOf(this.bdV.bfl)));
            com.baidu.tbadk.core.util.bc.vz().c(getTbPageContext(), new String[]{this.bdV.bfn});
        } else if ((view == this.mRootView || view == this.bdS || view == this.bdT) && !StringUtils.isNull(this.bdV.bfq)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.at(this.bdY).ab("obj_id", String.valueOf(this.bdV.bfl)));
            com.baidu.tbadk.core.util.bc.vz().c(getTbPageContext(), new String[]{this.bdV.bfq});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.k(this.mRootView, r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.ar.k(this.bdU, r.f.label_bg_gray);
            com.baidu.tbadk.core.util.ar.k(this.bdw, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.ar.c(this.bdR, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ar.c(this.bdU, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ar.c(this.bdS, r.d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.r rVar) {
        if (rVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bdV = rVar;
        this.bdQ.c(rVar.bfm, 10, false);
        this.bdR.setText(UtilHelper.getFixedText(rVar.userName, 7, true));
        if (StringUtils.isNull(rVar.bfs)) {
            this.bdU.setVisibility(8);
        } else {
            this.bdU.setVisibility(0);
            this.bdU.setText(rVar.bfs);
        }
        this.bdS.setText(rVar.bfo);
        if (com.baidu.tbadk.core.l.oJ().oP()) {
            this.bdT.setVisibility(0);
            this.bdT.c(rVar.bfp, 10, false);
            return;
        }
        this.bdT.setVisibility(8);
    }
}
