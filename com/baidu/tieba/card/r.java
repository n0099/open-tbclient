package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class r extends a<com.baidu.tieba.card.data.q> {
    private View cbn;
    private String cbp;
    private HeadImageView ccr;
    private TextView ccs;
    private TextView cct;
    private TbImageView ccu;
    private TextView ccv;
    private com.baidu.tieba.card.data.q ccw;
    private int ccx;
    private String ccy;
    private String ccz;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ccx = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void u(String str, String str2, String str3) {
        this.cbp = str;
        this.ccy = str2;
        this.ccz = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.ccr = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.ccs = (TextView) view.findViewById(d.g.promotion_name);
        this.cct = (TextView) view.findViewById(d.g.promotion_desc);
        this.ccu = (TbImageView) view.findViewById(d.g.promotion_img);
        this.ccv = (TextView) view.findViewById(d.g.promotion_icon);
        this.cbn = view.findViewById(d.g.top_line);
        this.ccr.setOnClickListener(this);
        this.ccs.setOnClickListener(this);
        this.ccv.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.ccr.setDefaultResource(17170445);
        this.ccr.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.ccr.setDefaultBgResource(d.C0082d.cp_bg_line_e);
        this.ccr.setRadius(this.ccx);
        this.ccu.setDrawBorder(true);
        this.ccu.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.ccr || view == this.ccs || view == this.ccv) && !StringUtils.isNull(this.ccw.cex)) {
            TiebaStatic.log(new ak(this.ccy).ac("obj_id", String.valueOf(this.ccw.cev)));
            av.vL().c(abr(), new String[]{this.ccw.cex});
        } else if ((view == this.mRootView || view == this.cct || view == this.ccu) && !StringUtils.isNull(this.ccw.ceA)) {
            TiebaStatic.log(new ak(this.ccz).ac("obj_id", String.valueOf(this.ccw.cev)));
            av.vL().c(abr(), new String[]{this.ccw.ceA});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.f.addresslist_item_bg);
            aj.j(this.ccv, d.f.label_bg_gray);
            aj.j(this.cbn, d.C0082d.cp_bg_line_b);
            aj.c(this.ccs, d.C0082d.cp_cont_b, 1);
            aj.c(this.ccv, d.C0082d.cp_cont_d, 1);
            aj.c(this.cct, d.C0082d.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.card.data.q qVar) {
        if (qVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.ccw = qVar;
        this.ccr.startLoad(qVar.cew, 10, false);
        this.ccs.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.ceC)) {
            this.ccv.setVisibility(8);
        } else {
            this.ccv.setVisibility(0);
            this.ccv.setText(qVar.ceC);
        }
        this.cct.setText(qVar.cey);
        if (com.baidu.tbadk.core.h.pa().pg()) {
            this.ccu.setVisibility(0);
            this.ccu.startLoad(qVar.cez, 10, false);
            return;
        }
        this.ccu.setVisibility(8);
    }
}
