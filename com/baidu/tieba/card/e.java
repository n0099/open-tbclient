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
    private LinearLayout cVY;
    private TextView cVZ;
    private RelativeLayout cWa;
    private TbImageView cWb;
    private ImageView cWc;
    private TextView cWd;
    private RelativeLayout cWe;
    private ClickableHeaderImageView cWf;
    private TextView cWg;
    private TextView cWh;
    private TextView cWi;
    private View cWj;
    private com.baidu.tieba.e.a cWk;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.cVY = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cVZ = (TextView) view.findViewById(e.g.card_frs_game_thread_title);
        this.cWa = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.cWb = (TbImageView) view.findViewById(e.g.card_frs_game_thread_bg);
        this.cWc = (ImageView) view.findViewById(e.g.img_play);
        this.cWd = (TextView) view.findViewById(e.g.card_frs_game_thread_video_time);
        this.cWe = (RelativeLayout) view.findViewById(e.g.card_frs_game_user_content);
        this.cWf = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cWg = (TextView) view.findViewById(e.g.card_frs_game_user_name);
        this.cWh = (TextView) view.findViewById(e.g.card_frs_game_thread_time);
        this.cWi = (TextView) view.findViewById(e.g.card_frs_game_thread_more_article);
        this.cWj = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.cWb.setDefaultBgResource(e.f.icon_morenpic);
        this.cWb.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aS(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWa.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cWa.setLayoutParams(layoutParams);
        this.cWi.setOnClickListener(this);
        this.cWf.setDefaultResource(17170445);
        this.cWf.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWf.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWf.setIsRound(true);
        this.cWf.setDrawBorder(true);
        this.cWf.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWf.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cVY != null) {
            this.cVY.setPadding(i, i2, i3, i4);
        }
    }

    public void kI(int i) {
        if (this.cWe != null) {
            this.cWe.setVisibility(i);
        }
    }

    public void kJ(int i) {
        if (this.cWj != null) {
            this.cWj.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cWj, e.d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.wk(this.cWk.aaq().getId())) {
                al.c(this.cVZ, e.d.cp_cont_c, 1);
            } else {
                al.c(this.cVZ, e.d.cp_cont_b, 1);
            }
            al.c(this.cWg, e.d.cp_cont_d, 1);
            al.c(this.cWh, e.d.cp_cont_d, 1);
            al.c(this.cWi, e.d.cp_link_tip_c, 1);
            al.c(this.cWd, e.d.cp_cont_i, 1);
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
            this.cWk = aVar;
            String str = null;
            if (aVar.aaq().AH()) {
                this.cWc.setVisibility(0);
                this.cWd.setVisibility(0);
                if (aVar.aaq().Al() != null) {
                    this.cWd.setText(ao.dV(aVar.aaq().Al().video_duration.intValue() * 1000));
                    str = aVar.aaq().Al().thumbnail_url;
                }
            } else {
                this.cWc.setVisibility(8);
                this.cWd.setVisibility(4);
                if (aVar.aaq().Ae() != null && aVar.aaq().Ae().size() >= 1) {
                    str = aVar.aaq().Ae().get(0).origin_pic;
                }
            }
            this.cWb.startLoad(str, 10, false);
            this.cVZ.setText(aVar.aaq().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.wk(aVar.aaq().getId())) {
                al.h(this.cVZ, e.d.cp_cont_c);
            } else {
                al.h(this.cVZ, e.d.cp_cont_b);
            }
            this.cWf.setData(aVar.aaq(), false);
            p(aVar.aaq());
            this.cWh.setText(ao.O(aVar.aaq().zE()));
            if ("guide".equals(aVar.aaq().zJ())) {
                this.cWi.setVisibility(0);
            } else {
                this.cWi.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cWi) {
            TiebaStatic.log(new am("c13047").y("obj_locate", 4).aB(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.m(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aqp() != null) {
            aqp().a(getView(), this.cWk);
        }
    }

    private void p(bb bbVar) {
        if (this.cWg != null && bbVar != null && !StringUtils.isNull(bbVar.zT().getName_show())) {
            this.cWg.setText(gG(bbVar.zT().getName_show()));
        }
    }

    protected String gG(String str) {
        return ao.d(str, 14, "...");
    }
}
