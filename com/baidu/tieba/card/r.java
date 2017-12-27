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
    private View cQb;
    private String cQd;
    private HeadImageView cRd;
    private TextView cRe;
    private TextView cRf;
    private TbImageView cRg;
    private TextView cRh;
    private com.baidu.tieba.card.data.q cRi;
    private int cRj;
    private String cRk;
    private String cRl;
    private View mRootView;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.cRj = tbPageContext.getResources().getDimensionPixelSize(d.e.ds70);
        init(getView());
    }

    public void y(String str, String str2, String str3) {
        this.cQd = str;
        this.cRk = str2;
        this.cRl = str3;
    }

    private void init(View view) {
        this.mRootView = view.findViewById(d.g.root_view);
        this.cRd = (HeadImageView) view.findViewById(d.g.promotion_head_img);
        this.cRe = (TextView) view.findViewById(d.g.promotion_name);
        this.cRf = (TextView) view.findViewById(d.g.promotion_desc);
        this.cRg = (TbImageView) view.findViewById(d.g.promotion_img);
        this.cRh = (TextView) view.findViewById(d.g.promotion_icon);
        this.cQb = view.findViewById(d.g.top_line);
        this.cRd.setOnClickListener(this);
        this.cRe.setOnClickListener(this);
        this.cRh.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.cRd.setDefaultResource(17170445);
        this.cRd.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cRd.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.cRd.setRadius(this.cRj);
        this.cRg.setDrawBorder(true);
        this.cRg.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.cRd || view == this.cRe || view == this.cRh) && !StringUtils.isNull(this.cRi.cTt)) {
            TiebaStatic.log(new ak(this.cRk).ab("obj_id", String.valueOf(this.cRi.cTr)));
            av.Di().c(aiX(), new String[]{this.cRi.cTt});
        } else if ((view == this.mRootView || view == this.cRf || view == this.cRg) && !StringUtils.isNull(this.cRi.cTw)) {
            TiebaStatic.log(new ak(this.cRl).ab("obj_id", String.valueOf(this.cRi.cTr)));
            av.Di().c(aiX(), new String[]{this.cRi.cTw});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.s(this.mRootView, d.f.addresslist_item_bg);
            aj.s(this.cRh, d.f.label_bg_gray);
            aj.s(this.cQb, d.C0108d.cp_bg_line_b);
            aj.e(this.cRe, d.C0108d.cp_cont_b, 1);
            aj.e(this.cRh, d.C0108d.cp_cont_d, 1);
            aj.e(this.cRf, d.C0108d.cp_cont_b, 1);
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
        this.cRi = qVar;
        this.cRd.startLoad(qVar.cTs, 10, false);
        this.cRe.setText(UtilHelper.getFixedText(qVar.userName, 7, true));
        if (StringUtils.isNull(qVar.cTy)) {
            this.cRh.setVisibility(8);
        } else {
            this.cRh.setVisibility(0);
            this.cRh.setText(qVar.cTy);
        }
        this.cRf.setText(qVar.cTu);
        if (com.baidu.tbadk.core.i.wB().wH()) {
            this.cRg.setVisibility(0);
            this.cRg.startLoad(qVar.cTv, 10, false);
            return;
        }
        this.cRg.setVisibility(8);
    }
}
