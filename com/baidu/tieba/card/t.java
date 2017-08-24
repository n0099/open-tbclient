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
    private View bIU;
    private String bIW;
    private HeadImageView bJr;
    private TextView bJs;
    private TextView bJt;
    private TbImageView bJu;
    private TextView bJv;
    private q bJw;
    private int bJx;
    private String bJy;
    private String bJz;
    private View mRootView;

    public t(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bJx = tbPageContext.getResources().getDimensionPixelSize(d.f.ds70);
        init(getView());
    }

    public void y(String str, String str2, String str3) {
        this.bIW = str;
        this.bJy = str2;
        this.bJz = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.h.root_view);
        this.bJr = (HeadImageView) view.findViewById(d.h.promotion_head_img);
        this.bJs = (TextView) view.findViewById(d.h.promotion_name);
        this.bJt = (TextView) view.findViewById(d.h.promotion_desc);
        this.bJu = (TbImageView) view.findViewById(d.h.promotion_img);
        this.bJv = (TextView) view.findViewById(d.h.promotion_icon);
        this.bIU = view.findViewById(d.h.top_line);
        this.bJr.setOnClickListener(this);
        this.bJs.setOnClickListener(this);
        this.bJv.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bJr.setDefaultResource(17170445);
        this.bJr.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bJr.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bJr.setRadius(this.bJx);
        this.bJu.setDrawBorder(true);
        this.bJu.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bJr || view == this.bJs || view == this.bJv) && !StringUtils.isNull(this.bJw.bLe)) {
            TiebaStatic.log(new aj(this.bJy).aa("obj_id", String.valueOf(this.bJw.bLc)));
            at.wg().c(Ww(), new String[]{this.bJw.bLe});
        } else if ((view == this.mRootView || view == this.bJt || view == this.bJu) && !StringUtils.isNull(this.bJw.bLh)) {
            TiebaStatic.log(new aj(this.bJz).aa("obj_id", String.valueOf(this.bJw.bLc)));
            at.wg().c(Ww(), new String[]{this.bJw.bLh});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.j(this.mRootView, d.g.addresslist_item_bg);
            ai.j(this.bJv, d.g.label_bg_gray);
            ai.j(this.bIU, d.e.cp_bg_line_b);
            ai.c(this.bJs, d.e.cp_cont_b, 1);
            ai.c(this.bJv, d.e.cp_cont_d, 1);
            ai.c(this.bJt, d.e.cp_cont_b, 1);
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
        this.bJw = qVar;
        this.bJr.c(qVar.bLd, 10, false);
        this.bJs.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.bLj)) {
            this.bJv.setVisibility(8);
        } else {
            this.bJv.setVisibility(0);
            this.bJv.setText(qVar.bLj);
        }
        this.bJt.setText(qVar.bLf);
        if (com.baidu.tbadk.core.h.oY().pe()) {
            this.bJu.setVisibility(0);
            this.bJu.c(qVar.bLg, 10, false);
            return;
        }
        this.bJu.setVisibility(8);
    }
}
