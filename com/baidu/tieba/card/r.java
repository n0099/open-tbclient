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
    private View cUY;
    private String cVa;
    private HeadImageView cWa;
    private TextView cWb;
    private TextView cWc;
    private TbImageView cWd;
    private TextView cWe;
    private com.baidu.tieba.card.data.q cWf;
    private int cWg;
    private String cWh;
    private String cWi;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cWg = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void A(String str, String str2, String str3) {
        this.cVa = str;
        this.cWh = str2;
        this.cWi = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.cWa = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.cWb = (TextView) view.findViewById(d.g.promotion_name);
        this.cWc = (TextView) view.findViewById(d.g.promotion_desc);
        this.cWd = (TbImageView) view.findViewById(d.g.promotion_img);
        this.cWe = (TextView) view.findViewById(d.g.promotion_icon);
        this.cUY = view.findViewById(d.g.top_line);
        this.cWa.setOnClickListener(this);
        this.cWb.setOnClickListener(this);
        this.cWe.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cWa.setDefaultResource(17170445);
        this.cWa.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cWa.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.cWa.setRadius(this.cWg);
        this.cWd.setDrawBorder(true);
        this.cWd.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cWa || view == this.cWb || view == this.cWe) && !StringUtils.isNull(this.cWf.cYq)) {
            TiebaStatic.log(new ak(this.cWh).aa("obj_id", String.valueOf(this.cWf.cYo)));
            av.Da().c(akf(), new String[]{this.cWf.cYq});
        } else if ((view == this.mRootView || view == this.cWc || view == this.cWd) && !StringUtils.isNull(this.cWf.cYt)) {
            TiebaStatic.log(new ak(this.cWi).aa("obj_id", String.valueOf(this.cWf.cYo)));
            av.Da().c(akf(), new String[]{this.cWf.cYt});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.f.addresslist_item_bg);
            aj.s(this.cWe, d.f.label_bg_gray);
            aj.s(this.cUY, d.C0108d.cp_bg_line_b);
            aj.e(this.cWb, d.C0108d.cp_cont_b, 1);
            aj.e(this.cWe, d.C0108d.cp_cont_d, 1);
            aj.e(this.cWc, d.C0108d.cp_cont_b, 1);
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
        this.cWf = qVar;
        this.cWa.startLoad(qVar.cYp, 10, false);
        this.cWb.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.cYv)) {
            this.cWe.setVisibility(8);
        } else {
            this.cWe.setVisibility(0);
            this.cWe.setText(qVar.cYv);
        }
        this.cWc.setText(qVar.cYr);
        if (com.baidu.tbadk.core.i.wB().wH()) {
            this.cWd.setVisibility(0);
            this.cWd.startLoad(qVar.cYs, 10, false);
            return;
        }
        this.cWd.setVisibility(8);
    }
}
