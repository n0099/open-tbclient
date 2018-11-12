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
    private LinearLayout cLP;
    private TextView cLQ;
    private RelativeLayout cLR;
    private TbImageView cLS;
    private ImageView cLT;
    private TextView cLU;
    private RelativeLayout cLV;
    private ClickableHeaderImageView cLW;
    private TextView cLX;
    private TextView cLY;
    private TextView cLZ;
    private View cMa;
    private com.baidu.tieba.e.a cMb;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.cLP = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cLQ = (TextView) view.findViewById(e.g.card_frs_game_thread_title);
        this.cLR = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.cLS = (TbImageView) view.findViewById(e.g.card_frs_game_thread_bg);
        this.cLT = (ImageView) view.findViewById(e.g.img_play);
        this.cLU = (TextView) view.findViewById(e.g.card_frs_game_thread_video_time);
        this.cLV = (RelativeLayout) view.findViewById(e.g.card_frs_game_user_content);
        this.cLW = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cLX = (TextView) view.findViewById(e.g.card_frs_game_user_name);
        this.cLY = (TextView) view.findViewById(e.g.card_frs_game_thread_time);
        this.cLZ = (TextView) view.findViewById(e.g.card_frs_game_thread_more_article);
        this.cMa = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.cLS.setDefaultBgResource(e.f.icon_morenpic);
        this.cLS.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aS(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cLR.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cLR.setLayoutParams(layoutParams);
        this.cLZ.setOnClickListener(this);
        this.cLW.setDefaultResource(17170445);
        this.cLW.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cLW.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cLW.setIsRound(true);
        this.cLW.setDrawBorder(true);
        this.cLW.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cLW.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cLP != null) {
            this.cLP.setPadding(i, i2, i3, i4);
        }
    }

    public void kg(int i) {
        if (this.cLV != null) {
            this.cLV.setVisibility(i);
        }
    }

    public void kh(int i) {
        if (this.cMa != null) {
            this.cMa.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cMa, e.d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vq(this.cMb.YL().getId())) {
                al.c(this.cLQ, e.d.cp_cont_c, 1);
            } else {
                al.c(this.cLQ, e.d.cp_cont_b, 1);
            }
            al.c(this.cLX, e.d.cp_cont_d, 1);
            al.c(this.cLY, e.d.cp_cont_d, 1);
            al.c(this.cLZ, e.d.cp_link_tip_c, 1);
            al.c(this.cLU, e.d.cp_cont_i, 1);
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
        if (aVar != null && aVar.YL() != null) {
            this.cMb = aVar;
            String str = null;
            if (aVar.YL().zq()) {
                this.cLT.setVisibility(0);
                this.cLU.setVisibility(0);
                if (aVar.YL().yU() != null) {
                    this.cLU.setText(ao.dH(aVar.YL().yU().video_duration.intValue() * 1000));
                    str = aVar.YL().yU().thumbnail_url;
                }
            } else {
                this.cLT.setVisibility(8);
                this.cLU.setVisibility(4);
                if (aVar.YL().yN() != null && aVar.YL().yN().size() >= 1) {
                    str = aVar.YL().yN().get(0).origin_pic;
                }
            }
            this.cLS.startLoad(str, 10, false);
            this.cLQ.setText(aVar.YL().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vq(aVar.YL().getId())) {
                al.h(this.cLQ, e.d.cp_cont_c);
            } else {
                al.h(this.cLQ, e.d.cp_cont_b);
            }
            this.cLW.setData(aVar.YL(), false);
            p(aVar.YL());
            this.cLY.setText(ao.G(aVar.YL().yn()));
            if ("guide".equals(aVar.YL().ys())) {
                this.cLZ.setVisibility(0);
            } else {
                this.cLZ.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cLZ) {
            TiebaStatic.log(new am("c13047").x("obj_locate", 4).ax(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.k(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (anq() != null) {
            anq().a(getView(), this.cMb);
        }
    }

    private void p(bb bbVar) {
        if (this.cLX != null && bbVar != null && !StringUtils.isNull(bbVar.yC().getName_show())) {
            this.cLX.setText(fZ(bbVar.yC().getName_show()));
        }
    }

    protected String fZ(String str) {
        return ao.d(str, 14, "...");
    }
}
