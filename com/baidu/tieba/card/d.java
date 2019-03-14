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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes4.dex */
public class d extends a<com.baidu.tieba.e.a> {
    private LinearLayout efG;
    private TextView efH;
    private RelativeLayout efI;
    private TbImageView efJ;
    private ImageView efK;
    private TextView efL;
    private RelativeLayout efM;
    private ClickableHeaderImageView efN;
    private TextView efO;
    private TextView efP;
    private TextView efQ;
    private View efR;
    private com.baidu.tieba.e.a efS;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.efG = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.efH = (TextView) view.findViewById(d.g.card_frs_game_thread_title);
        this.efI = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.efJ = (TbImageView) view.findViewById(d.g.card_frs_game_thread_bg);
        this.efK = (ImageView) view.findViewById(d.g.img_play);
        this.efL = (TextView) view.findViewById(d.g.card_frs_game_thread_video_time);
        this.efM = (RelativeLayout) view.findViewById(d.g.card_frs_game_user_content);
        this.efN = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.efO = (TextView) view.findViewById(d.g.card_frs_game_user_name);
        this.efP = (TextView) view.findViewById(d.g.card_frs_game_thread_time);
        this.efQ = (TextView) view.findViewById(d.g.card_frs_game_thread_more_article);
        this.efR = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.efJ.setDefaultBgResource(d.f.icon_morenpic);
        this.efJ.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aS(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(d.e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.efI.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.efI.setLayoutParams(layoutParams);
        this.efQ.setOnClickListener(this);
        this.efN.setDefaultResource(17170445);
        this.efN.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.efN.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.efN.setIsRound(true);
        this.efN.setDrawBorder(true);
        this.efN.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efN.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.efG != null) {
            this.efG.setPadding(i, i2, i3, i4);
        }
    }

    public void ol(int i) {
        if (this.efM != null) {
            this.efM.setVisibility(i);
        }
    }

    public void om(int i) {
        if (this.efR != null) {
            this.efR.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.C0277d.cp_bg_line_d);
            al.k(this.efR, d.C0277d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CN(this.efS.WR().getId())) {
                al.d(this.efH, d.C0277d.cp_cont_c, 1);
            } else {
                al.d(this.efH, d.C0277d.cp_cont_b, 1);
            }
            al.d(this.efO, d.C0277d.cp_cont_d, 1);
            al.d(this.efP, d.C0277d.cp_cont_d, 1);
            al.d(this.efQ, d.C0277d.cp_link_tip_c, 1);
            al.d(this.efL, d.C0277d.cp_btn_a, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.WR() != null) {
            this.efS = aVar;
            String str = null;
            if (aVar.WR().ZL()) {
                this.efK.setVisibility(0);
                this.efL.setVisibility(0);
                if (aVar.WR().Zi() != null) {
                    this.efL.setText(ap.hz(aVar.WR().Zi().video_duration.intValue() * 1000));
                    str = aVar.WR().Zi().thumbnail_url;
                }
            } else {
                this.efK.setVisibility(8);
                this.efL.setVisibility(4);
                if (aVar.WR().Zb() != null && aVar.WR().Zb().size() >= 1) {
                    str = aVar.WR().Zb().get(0).origin_pic;
                }
            }
            this.efJ.startLoad(str, 10, false);
            this.efH.setText(aVar.WR().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CN(aVar.WR().getId())) {
                al.j(this.efH, d.C0277d.cp_cont_c);
            } else {
                al.j(this.efH, d.C0277d.cp_cont_b);
            }
            this.efN.setData(aVar.WR(), false);
            f(aVar.WR());
            this.efP.setText(ap.aq(aVar.WR().YB()));
            if ("guide".equals(aVar.WR().YG())) {
                this.efQ.setVisibility(0);
            } else {
                this.efQ.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.efQ) {
            TiebaStatic.log(new am("c13047").T("obj_locate", 4).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.n(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aQh() != null) {
            aQh().a(getView(), this.efS);
        }
    }

    private void f(bg bgVar) {
        if (this.efO != null && bgVar != null && !StringUtils.isNull(bgVar.YR().getName_show())) {
            this.efO.setText(ns(bgVar.YR().getName_show()));
        }
    }

    protected String ns(String str) {
        return ap.g(str, 14, "...");
    }
}
