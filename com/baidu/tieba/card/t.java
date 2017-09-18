package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends a<q> {
    private View bME;
    private String bMG;
    private HeadImageView bNa;
    private TextView bNb;
    private TextView bNc;
    private TbImageView bNd;
    private TextView bNe;
    private q bNf;
    private int bNg;
    private String bNh;
    private String bNi;
    private View mRootView;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bNg = tbPageContext.getResources().getDimensionPixelSize(d.f.ds70);
        init(getView());
    }

    public void y(String str, String str2, String str3) {
        this.bMG = str;
        this.bNh = str2;
        this.bNi = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.root_view);
        this.bNa = (HeadImageView) view.findViewById(d.h.promotion_head_img);
        this.bNb = (TextView) view.findViewById(d.h.promotion_name);
        this.bNc = (TextView) view.findViewById(d.h.promotion_desc);
        this.bNd = (TbImageView) view.findViewById(d.h.promotion_img);
        this.bNe = (TextView) view.findViewById(d.h.promotion_icon);
        this.bME = view.findViewById(d.h.top_line);
        this.bNa.setOnClickListener(this);
        this.bNb.setOnClickListener(this);
        this.bNe.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bNa.setDefaultResource(17170445);
        this.bNa.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bNa.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bNa.setRadius(this.bNg);
        this.bNd.setDrawBorder(true);
        this.bNd.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bNa || view == this.bNb || view == this.bNe) && !StringUtils.isNull(this.bNf.bOO)) {
            TiebaStatic.log(new ak(this.bNh).ad("obj_id", String.valueOf(this.bNf.bOM)));
            au.wd().c(XK(), new String[]{this.bNf.bOO});
        } else if ((view == this.mRootView || view == this.bNc || view == this.bNd) && !StringUtils.isNull(this.bNf.bOR)) {
            TiebaStatic.log(new ak(this.bNi).ad("obj_id", String.valueOf(this.bNf.bOM)));
            au.wd().c(XK(), new String[]{this.bNf.bOR});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.g.addresslist_item_bg);
            aj.j(this.bNe, d.g.label_bg_gray);
            aj.j(this.bME, d.e.cp_bg_line_b);
            aj.c(this.bNb, d.e.cp_cont_b, 1);
            aj.c(this.bNe, d.e.cp_cont_d, 1);
            aj.c(this.bNc, d.e.cp_cont_b, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_promotion_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(q qVar) {
        if (qVar == null) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.bNf = qVar;
        this.bNa.c(qVar.bON, 10, false);
        this.bNb.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bOT)) {
            this.bNe.setVisibility(8);
        } else {
            this.bNe.setVisibility(0);
            this.bNe.setText(qVar.bOT);
        }
        this.bNc.setText(qVar.bOP);
        if (com.baidu.tbadk.core.h.oS().oY()) {
            this.bNd.setVisibility(0);
            this.bNd.c(qVar.bOQ, 10, false);
            return;
        }
        this.bNd.setVisibility(8);
    }
}
