package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.q;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class t extends a<q> {
    private View bIT;
    private String bIV;
    private HeadImageView bJq;
    private TextView bJr;
    private TextView bJs;
    private TbImageView bJt;
    private TextView bJu;
    private q bJv;
    private int bJw;
    private String bJx;
    private String bJy;
    private View mRootView;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJw = tbPageContext.getResources().getDimensionPixelSize(d.f.ds70);
        S(getView());
    }

    public void y(String str, String str2, String str3) {
        this.bIV = str;
        this.bJx = str2;
        this.bJy = str3;
    }

    private void S(View view) {
        this.mRootView = view.findViewById(d.h.root_view);
        this.bJq = (HeadImageView) view.findViewById(d.h.promotion_head_img);
        this.bJr = (TextView) view.findViewById(d.h.promotion_name);
        this.bJs = (TextView) view.findViewById(d.h.promotion_desc);
        this.bJt = (TbImageView) view.findViewById(d.h.promotion_img);
        this.bJu = (TextView) view.findViewById(d.h.promotion_icon);
        this.bIT = view.findViewById(d.h.top_line);
        this.bJq.setOnClickListener(this);
        this.bJr.setOnClickListener(this);
        this.bJu.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bJq.setDefaultResource(17170445);
        this.bJq.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bJq.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bJq.setRadius(this.bJw);
        this.bJt.setDrawBorder(true);
        this.bJt.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bJq || view == this.bJr || view == this.bJu) && !StringUtils.isNull(this.bJv.bLd)) {
            TiebaStatic.log(new aj(this.bJx).aa("obj_id", String.valueOf(this.bJv.bLb)));
            at.wf().c(Wz(), new String[]{this.bJv.bLd});
        } else if ((view == this.mRootView || view == this.bJs || view == this.bJt) && !StringUtils.isNull(this.bJv.bLg)) {
            TiebaStatic.log(new aj(this.bJy).aa("obj_id", String.valueOf(this.bJv.bLb)));
            at.wf().c(Wz(), new String[]{this.bJv.bLg});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.mRootView, d.g.addresslist_item_bg);
            ai.j(this.bJu, d.g.label_bg_gray);
            ai.j(this.bIT, d.e.cp_bg_line_b);
            ai.c(this.bJr, d.e.cp_cont_b, 1);
            ai.c(this.bJu, d.e.cp_cont_d, 1);
            ai.c(this.bJs, d.e.cp_cont_b, 1);
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
        this.bJv = qVar;
        this.bJq.c(qVar.bLc, 10, false);
        this.bJr.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bLi)) {
            this.bJu.setVisibility(8);
        } else {
            this.bJu.setVisibility(0);
            this.bJu.setText(qVar.bLi);
        }
        this.bJs.setText(qVar.bLe);
        if (com.baidu.tbadk.core.h.oX().pd()) {
            this.bJt.setVisibility(0);
            this.bJt.c(qVar.bLf, 10, false);
            return;
        }
        this.bJt.setVisibility(8);
    }
}
