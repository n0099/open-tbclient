package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes3.dex */
public class e extends a<com.baidu.tieba.e.a> {
    private LinearLayout cVX;
    private TextView cVY;
    private RelativeLayout cVZ;
    private TbImageView cWa;
    private ImageView cWb;
    private TextView cWc;
    private RelativeLayout cWd;
    private ClickableHeaderImageView cWe;
    private TextView cWf;
    private TextView cWg;
    private TextView cWh;
    private View cWi;
    private com.baidu.tieba.e.a cWj;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.cVX = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cVY = (TextView) view.findViewById(e.g.card_frs_game_thread_title);
        this.cVZ = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.cWa = (TbImageView) view.findViewById(e.g.card_frs_game_thread_bg);
        this.cWb = (ImageView) view.findViewById(e.g.img_play);
        this.cWc = (TextView) view.findViewById(e.g.card_frs_game_thread_video_time);
        this.cWd = (RelativeLayout) view.findViewById(e.g.card_frs_game_user_content);
        this.cWe = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cWf = (TextView) view.findViewById(e.g.card_frs_game_user_name);
        this.cWg = (TextView) view.findViewById(e.g.card_frs_game_thread_time);
        this.cWh = (TextView) view.findViewById(e.g.card_frs_game_thread_more_article);
        this.cWi = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.cWa.setDefaultBgResource(e.f.icon_morenpic);
        this.cWa.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aS(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVZ.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cVZ.setLayoutParams(layoutParams);
        this.cWh.setOnClickListener(this);
        this.cWe.setDefaultResource(17170445);
        this.cWe.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWe.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWe.setIsRound(true);
        this.cWe.setDrawBorder(true);
        this.cWe.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWe.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cVX != null) {
            this.cVX.setPadding(i, i2, i3, i4);
        }
    }

    public void kI(int i) {
        if (this.cWd != null) {
            this.cWd.setVisibility(i);
        }
    }

    public void kJ(int i) {
        if (this.cWi != null) {
            this.cWi.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cWi, e.d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.wk(this.cWj.aaq().getId())) {
                al.c(this.cVY, e.d.cp_cont_c, 1);
            } else {
                al.c(this.cVY, e.d.cp_cont_b, 1);
            }
            al.c(this.cWf, e.d.cp_cont_d, 1);
            al.c(this.cWg, e.d.cp_cont_d, 1);
            al.c(this.cWh, e.d.cp_link_tip_c, 1);
            al.c(this.cWc, e.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.aaq() != null) {
            this.cWj = aVar;
            String str = null;
            if (aVar.aaq().AH()) {
                this.cWb.setVisibility(0);
                this.cWc.setVisibility(0);
                if (aVar.aaq().Al() != null) {
                    this.cWc.setText(ao.dV(aVar.aaq().Al().video_duration.intValue() * 1000));
                    str = aVar.aaq().Al().thumbnail_url;
                }
            } else {
                this.cWb.setVisibility(8);
                this.cWc.setVisibility(4);
                if (aVar.aaq().Ae() != null && aVar.aaq().Ae().size() >= 1) {
                    str = aVar.aaq().Ae().get(0).origin_pic;
                }
            }
            this.cWa.startLoad(str, 10, false);
            this.cVY.setText(aVar.aaq().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.wk(aVar.aaq().getId())) {
                al.h(this.cVY, e.d.cp_cont_c);
            } else {
                al.h(this.cVY, e.d.cp_cont_b);
            }
            this.cWe.setData(aVar.aaq(), false);
            p(aVar.aaq());
            this.cWg.setText(ao.O(aVar.aaq().zE()));
            if ("guide".equals(aVar.aaq().zJ())) {
                this.cWh.setVisibility(0);
            } else {
                this.cWh.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cWh) {
            TiebaStatic.log(new am("c13047").y("obj_locate", 4).aB(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.m(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aqp() != null) {
            aqp().a(getView(), this.cWj);
        }
    }

    private void p(bb bbVar) {
        if (this.cWf != null && bbVar != null && !StringUtils.isNull(bbVar.zT().getName_show())) {
            this.cWf.setText(gG(bbVar.zT().getName_show()));
        }
    }

    protected String gG(String str) {
        return ao.d(str, 14, "...");
    }
}
