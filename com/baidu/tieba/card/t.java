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
    private View bLN;
    private String bLP;
    private HeadImageView bMj;
    private TextView bMk;
    private TextView bMl;
    private TbImageView bMm;
    private TextView bMn;
    private q bMo;
    private int bMp;
    private String bMq;
    private String bMr;
    private View mRootView;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bMp = tbPageContext.getResources().getDimensionPixelSize(d.f.ds70);
        init(getView());
    }

    public void y(String str, String str2, String str3) {
        this.bLP = str;
        this.bMq = str2;
        this.bMr = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.root_view);
        this.bMj = (HeadImageView) view.findViewById(d.h.promotion_head_img);
        this.bMk = (TextView) view.findViewById(d.h.promotion_name);
        this.bMl = (TextView) view.findViewById(d.h.promotion_desc);
        this.bMm = (TbImageView) view.findViewById(d.h.promotion_img);
        this.bMn = (TextView) view.findViewById(d.h.promotion_icon);
        this.bLN = view.findViewById(d.h.top_line);
        this.bMj.setOnClickListener(this);
        this.bMk.setOnClickListener(this);
        this.bMn.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bMj.setDefaultResource(17170445);
        this.bMj.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bMj.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bMj.setRadius(this.bMp);
        this.bMm.setDrawBorder(true);
        this.bMm.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bMj || view == this.bMk || view == this.bMn) && !StringUtils.isNull(this.bMo.bNX)) {
            TiebaStatic.log(new ak(this.bMq).ad("obj_id", String.valueOf(this.bMo.bNV)));
            au.wd().c(Xz(), new String[]{this.bMo.bNX});
        } else if ((view == this.mRootView || view == this.bMl || view == this.bMm) && !StringUtils.isNull(this.bMo.bOa)) {
            TiebaStatic.log(new ak(this.bMr).ad("obj_id", String.valueOf(this.bMo.bNV)));
            au.wd().c(Xz(), new String[]{this.bMo.bOa});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.mRootView, d.g.addresslist_item_bg);
            aj.j(this.bMn, d.g.label_bg_gray);
            aj.j(this.bLN, d.e.cp_bg_line_b);
            aj.c(this.bMk, d.e.cp_cont_b, 1);
            aj.c(this.bMn, d.e.cp_cont_d, 1);
            aj.c(this.bMl, d.e.cp_cont_b, 1);
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
        this.bMo = qVar;
        this.bMj.c(qVar.bNW, 10, false);
        this.bMk.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bOc)) {
            this.bMn.setVisibility(8);
        } else {
            this.bMn.setVisibility(0);
            this.bMn.setText(qVar.bOc);
        }
        this.bMl.setText(qVar.bNY);
        if (com.baidu.tbadk.core.h.oS().oY()) {
            this.bMm.setVisibility(0);
            this.bMm.c(qVar.bNZ, 10, false);
            return;
        }
        this.bMm.setVisibility(8);
    }
}
