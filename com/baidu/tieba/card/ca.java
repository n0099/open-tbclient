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
public class ca extends a<com.baidu.tieba.card.data.r> {
    private View baZ;
    private String bbA;
    private String bbB;
    private String bbb;
    private HeadImageView bbt;
    private TextView bbu;
    private TextView bbv;
    private TbImageView bbw;
    private TextView bbx;
    private com.baidu.tieba.card.data.r bby;
    private int bbz;
    private View mRootView;

    public ca(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bbz = tbPageContext.getResources().getDimensionPixelSize(r.e.ds70);
        V(getView());
    }

    public void t(String str, String str2, String str3) {
        this.bbb = str;
        this.bbA = str2;
        this.bbB = str3;
    }

    private void V(View view) {
        this.mRootView = view.findViewById(r.g.root_view);
        this.bbt = (HeadImageView) view.findViewById(r.g.promotion_head_img);
        this.bbu = (TextView) view.findViewById(r.g.promotion_name);
        this.bbv = (TextView) view.findViewById(r.g.promotion_desc);
        this.bbw = (TbImageView) view.findViewById(r.g.promotion_img);
        this.bbx = (TextView) view.findViewById(r.g.promotion_icon);
        this.baZ = view.findViewById(r.g.top_line);
        this.bbt.setOnClickListener(this);
        this.bbu.setOnClickListener(this);
        this.bbx.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bbt.setDefaultResource(17170445);
        this.bbt.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bbt.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bbt.setRadius(this.bbz);
        this.bbw.setDrawBorder(true);
        this.bbw.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bbt || view == this.bbu || view == this.bbx) && !StringUtils.isNull(this.bby.bcZ)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax(this.bbA).ab("obj_id", String.valueOf(this.bby.bcX)));
            com.baidu.tbadk.core.util.bh.vL().c(getTbPageContext(), new String[]{this.bby.bcZ});
        } else if ((view == this.mRootView || view == this.bbv || view == this.bbw) && !StringUtils.isNull(this.bby.bdc)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ax(this.bbB).ab("obj_id", String.valueOf(this.bby.bcX)));
            com.baidu.tbadk.core.util.bh.vL().c(getTbPageContext(), new String[]{this.bby.bdc});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.mRootView, r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.k(this.bbx, r.f.label_bg_gray);
            com.baidu.tbadk.core.util.av.k(this.baZ, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.av.c(this.bbu, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.av.c(this.bbx, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.av.c(this.bbv, r.d.cp_cont_b, 1);
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
        this.bby = rVar;
        this.bbt.c(rVar.bcY, 10, false);
        this.bbu.setText(UtilHelper.getFixedText(rVar.userName, 7, true));
        if (StringUtils.isNull(rVar.bde)) {
            this.bbx.setVisibility(8);
        } else {
            this.bbx.setVisibility(0);
            this.bbx.setText(rVar.bde);
        }
        this.bbv.setText(rVar.bda);
        if (com.baidu.tbadk.core.l.oH().oN()) {
            this.bbw.setVisibility(0);
            this.bbw.c(rVar.bdb, 10, false);
            return;
        }
        this.bbw.setVisibility(8);
    }
}
