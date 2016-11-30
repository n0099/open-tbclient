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
public class bw extends a<com.baidu.tieba.card.data.r> {
    private TextView beA;
    private TextView beB;
    private TbImageView beC;
    private TextView beD;
    private com.baidu.tieba.card.data.r beE;
    private int beF;
    private String beG;
    private String beH;
    private View bee;
    private String beg;
    private HeadImageView bez;
    private View mRootView;

    public bw(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.beF = tbPageContext.getResources().getDimensionPixelSize(r.e.ds70);
        W(getView());
    }

    public void t(String str, String str2, String str3) {
        this.beg = str;
        this.beG = str2;
        this.beH = str3;
    }

    private void W(View view) {
        this.mRootView = view.findViewById(r.g.root_view);
        this.bez = (HeadImageView) view.findViewById(r.g.promotion_head_img);
        this.beA = (TextView) view.findViewById(r.g.promotion_name);
        this.beB = (TextView) view.findViewById(r.g.promotion_desc);
        this.beC = (TbImageView) view.findViewById(r.g.promotion_img);
        this.beD = (TextView) view.findViewById(r.g.promotion_icon);
        this.bee = view.findViewById(r.g.top_line);
        this.bez.setOnClickListener(this);
        this.beA.setOnClickListener(this);
        this.beD.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.bez.setDefaultResource(17170445);
        this.bez.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.bez.setDefaultBgResource(r.d.cp_bg_line_e);
        this.bez.setRadius(this.beF);
        this.beC.setDrawBorder(true);
        this.beC.setBorderWidth(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.bez || view == this.beA || view == this.beD) && !StringUtils.isNull(this.beE.bfY)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av(this.beG).ab("obj_id", String.valueOf(this.beE.bfW)));
            com.baidu.tbadk.core.util.bf.vP().c(getTbPageContext(), new String[]{this.beE.bfY});
        } else if ((view == this.mRootView || view == this.beB || view == this.beC) && !StringUtils.isNull(this.beE.bgb)) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.av(this.beH).ab("obj_id", String.valueOf(this.beE.bfW)));
            com.baidu.tbadk.core.util.bf.vP().c(getTbPageContext(), new String[]{this.beE.bgb});
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(this.mRootView, r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.k(this.beD, r.f.label_bg_gray);
            com.baidu.tbadk.core.util.at.k(this.bee, r.d.cp_bg_line_b);
            com.baidu.tbadk.core.util.at.c(this.beA, r.d.cp_cont_b, 1);
            com.baidu.tbadk.core.util.at.c(this.beD, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.beB, r.d.cp_cont_b, 1);
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
        this.beE = rVar;
        this.bez.c(rVar.bfX, 10, false);
        this.beA.setText(UtilHelper.getFixedText(rVar.userName, 7, true));
        if (StringUtils.isNull(rVar.bgd)) {
            this.beD.setVisibility(8);
        } else {
            this.beD.setVisibility(0);
            this.beD.setText(rVar.bgd);
        }
        this.beB.setText(rVar.bfZ);
        if (com.baidu.tbadk.core.l.oJ().oP()) {
            this.beC.setVisibility(0);
            this.beC.c(rVar.bga, 10, false);
            return;
        }
        this.beC.setVisibility(8);
    }
}
