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
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends a<q> {
    private View bLP;
    private String bLR;
    private HeadImageView bMr;
    private TextView bMs;
    private TextView bMt;
    private TbImageView bMu;
    private TextView bMv;
    private q bMw;
    private int bMx;
    private String bMy;
    private String bMz;
    private View mRootView;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bMx = tbPageContext.getResources().getDimensionPixelSize(d.f.ds70);
        init(getView());
    }

    public void z(String str, String str2, String str3) {
        this.bLR = str;
        this.bMy = str2;
        this.bMz = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.root_view);
        this.bMr = (HeadImageView) view.findViewById(d.h.promotion_head_img);
        this.bMs = (TextView) view.findViewById(d.h.promotion_name);
        this.bMt = (TextView) view.findViewById(d.h.promotion_desc);
        this.bMu = (TbImageView) view.findViewById(d.h.promotion_img);
        this.bMv = (TextView) view.findViewById(d.h.promotion_icon);
        this.bLP = view.findViewById(d.h.top_line);
        this.bMr.setOnClickListener(this);
        this.bMs.setOnClickListener(this);
        this.bMv.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bMr.setDefaultResource(17170445);
        this.bMr.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bMr.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bMr.setRadius(this.bMx);
        this.bMu.setDrawBorder(true);
        this.bMu.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bMr || view == this.bMs || view == this.bMv) && !StringUtils.isNull(this.bMw.bOi)) {
            TiebaStatic.log(new ak(this.bMy).ac("obj_id", String.valueOf(this.bMw.bOg)));
            av.vA().c(Xm(), new String[]{this.bMw.bOi});
        } else if ((view == this.mRootView || view == this.bMt || view == this.bMu) && !StringUtils.isNull(this.bMw.bOl)) {
            TiebaStatic.log(new ak(this.bMz).ac("obj_id", String.valueOf(this.bMw.bOg)));
            av.vA().c(Xm(), new String[]{this.bMw.bOl});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.g.addresslist_item_bg);
            aj.j(this.bMv, d.g.label_bg_gray);
            aj.j(this.bLP, d.e.cp_bg_line_b);
            aj.c(this.bMs, d.e.cp_cont_b, 1);
            aj.c(this.bMv, d.e.cp_cont_d, 1);
            aj.c(this.bMt, d.e.cp_cont_b, 1);
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
        this.bMw = qVar;
        this.bMr.c(qVar.bOh, 10, false);
        this.bMs.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bOn)) {
            this.bMv.setVisibility(8);
        } else {
            this.bMv.setVisibility(0);
            this.bMv.setText(qVar.bOn);
        }
        this.bMt.setText(qVar.bOj);
        if (com.baidu.tbadk.core.h.oM().oS()) {
            this.bMu.setVisibility(0);
            this.bMu.c(qVar.bOk, 10, false);
            return;
        }
        this.bMu.setVisibility(8);
    }
}
