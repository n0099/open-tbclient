package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class cb extends a<com.baidu.tieba.card.data.s> {
    private View btY;
    private String buA;
    private String bua;
    private HeadImageView bur;
    private TextView bus;
    private TextView but;
    private TbImageView buu;
    private TextView buv;
    private com.baidu.tieba.card.data.s buw;
    private int bux;
    private String buz;
    private View mRootView;

    public cb(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bux = tbPageContext.getResources().getDimensionPixelSize(w.f.ds70);
        W(getView());
    }

    public void q(String str, String str2, String str3) {
        this.bua = str;
        this.buz = str2;
        this.buA = str3;
    }

    private void W(View view) {
        this.mRootView = view.findViewById(w.h.root_view);
        this.bur = (HeadImageView) view.findViewById(w.h.promotion_head_img);
        this.bus = (TextView) view.findViewById(w.h.promotion_name);
        this.but = (TextView) view.findViewById(w.h.promotion_desc);
        this.buu = (TbImageView) view.findViewById(w.h.promotion_img);
        this.buv = (TextView) view.findViewById(w.h.promotion_icon);
        this.btY = view.findViewById(w.h.top_line);
        this.bur.setOnClickListener(this);
        this.bus.setOnClickListener(this);
        this.buv.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bur.setDefaultResource(17170445);
        this.bur.setDefaultErrorResource(w.g.icon_default_avatar100);
        this.bur.setDefaultBgResource(w.e.cp_bg_line_e);
        this.bur.setRadius(this.bux);
        this.buu.setDrawBorder(true);
        this.buu.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bur || view == this.bus || view == this.buv) && !StringUtils.isNull(this.buw.bvU)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as(this.buz).aa("obj_id", String.valueOf(this.buw.bvS)));
            com.baidu.tbadk.core.util.bb.wn().c(getTbPageContext(), new String[]{this.buw.bvU});
        } else if ((view == this.mRootView || view == this.but || view == this.buu) && !StringUtils.isNull(this.buw.bvX)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as(this.buA).aa("obj_id", String.valueOf(this.buw.bvS)));
            com.baidu.tbadk.core.util.bb.wn().c(getTbPageContext(), new String[]{this.buw.bvX});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.j(this.mRootView, w.g.addresslist_item_bg);
            com.baidu.tbadk.core.util.aq.j(this.buv, w.g.label_bg_gray);
            com.baidu.tbadk.core.util.aq.j(this.btY, w.e.cp_bg_line_b);
            com.baidu.tbadk.core.util.aq.c(this.bus, w.e.cp_cont_b, 1);
            com.baidu.tbadk.core.util.aq.c(this.buv, w.e.cp_cont_d, 1);
            com.baidu.tbadk.core.util.aq.c(this.but, w.e.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.s sVar) {
        if (sVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.buw = sVar;
        this.bur.c(sVar.bvT, 10, false);
        this.bus.setText(UtilHelper.getFixedText(sVar.userName, 7, true));
        if (StringUtils.isNull(sVar.bvZ)) {
            this.buv.setVisibility(8);
        } else {
            this.buv.setVisibility(0);
            this.buv.setText(sVar.bvZ);
        }
        this.but.setText(sVar.bvV);
        if (com.baidu.tbadk.core.q.po().pu()) {
            this.buu.setVisibility(0);
            this.buu.c(sVar.bvW, 10, false);
            return;
        }
        this.buu.setVisibility(8);
    }
}
