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
    private ImageView cSA;
    private TextView cSB;
    private RelativeLayout cSC;
    private ClickableHeaderImageView cSD;
    private TextView cSE;
    private TextView cSF;
    private TextView cSG;
    private View cSH;
    private com.baidu.tieba.e.a cSI;
    private LinearLayout cSw;
    private TextView cSx;
    private RelativeLayout cSy;
    private TbImageView cSz;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.cSw = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cSx = (TextView) view.findViewById(e.g.card_frs_game_thread_title);
        this.cSy = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.cSz = (TbImageView) view.findViewById(e.g.card_frs_game_thread_bg);
        this.cSA = (ImageView) view.findViewById(e.g.img_play);
        this.cSB = (TextView) view.findViewById(e.g.card_frs_game_thread_video_time);
        this.cSC = (RelativeLayout) view.findViewById(e.g.card_frs_game_user_content);
        this.cSD = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cSE = (TextView) view.findViewById(e.g.card_frs_game_user_name);
        this.cSF = (TextView) view.findViewById(e.g.card_frs_game_thread_time);
        this.cSG = (TextView) view.findViewById(e.g.card_frs_game_thread_more_article);
        this.cSH = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.cSz.setDefaultBgResource(e.f.icon_morenpic);
        this.cSz.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aS(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cSy.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cSy.setLayoutParams(layoutParams);
        this.cSG.setOnClickListener(this);
        this.cSD.setDefaultResource(17170445);
        this.cSD.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cSD.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cSD.setIsRound(true);
        this.cSD.setDrawBorder(true);
        this.cSD.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cSD.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cSw != null) {
            this.cSw.setPadding(i, i2, i3, i4);
        }
    }

    public void kw(int i) {
        if (this.cSC != null) {
            this.cSC.setVisibility(i);
        }
    }

    public void kx(int i) {
        if (this.cSH != null) {
            this.cSH.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cSH, e.d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vR(this.cSI.ZR().getId())) {
                al.c(this.cSx, e.d.cp_cont_c, 1);
            } else {
                al.c(this.cSx, e.d.cp_cont_b, 1);
            }
            al.c(this.cSE, e.d.cp_cont_d, 1);
            al.c(this.cSF, e.d.cp_cont_d, 1);
            al.c(this.cSG, e.d.cp_link_tip_c, 1);
            al.c(this.cSB, e.d.cp_cont_i, 1);
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
        if (aVar != null && aVar.ZR() != null) {
            this.cSI = aVar;
            String str = null;
            if (aVar.ZR().Au()) {
                this.cSA.setVisibility(0);
                this.cSB.setVisibility(0);
                if (aVar.ZR().zY() != null) {
                    this.cSB.setText(ao.dV(aVar.ZR().zY().video_duration.intValue() * 1000));
                    str = aVar.ZR().zY().thumbnail_url;
                }
            } else {
                this.cSA.setVisibility(8);
                this.cSB.setVisibility(4);
                if (aVar.ZR().zR() != null && aVar.ZR().zR().size() >= 1) {
                    str = aVar.ZR().zR().get(0).origin_pic;
                }
            }
            this.cSz.startLoad(str, 10, false);
            this.cSx.setText(aVar.ZR().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vR(aVar.ZR().getId())) {
                al.h(this.cSx, e.d.cp_cont_c);
            } else {
                al.h(this.cSx, e.d.cp_cont_b);
            }
            this.cSD.setData(aVar.ZR(), false);
            p(aVar.ZR());
            this.cSF.setText(ao.N(aVar.ZR().zr()));
            if ("guide".equals(aVar.ZR().zw())) {
                this.cSG.setVisibility(0);
            } else {
                this.cSG.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cSG) {
            TiebaStatic.log(new am("c13047").x("obj_locate", 4).aA(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.k(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (apc() != null) {
            apc().a(getView(), this.cSI);
        }
    }

    private void p(bb bbVar) {
        if (this.cSE != null && bbVar != null && !StringUtils.isNull(bbVar.zG().getName_show())) {
            this.cSE.setText(gr(bbVar.zG().getName_show()));
        }
    }

    protected String gr(String str) {
        return ao.d(str, 14, "...");
    }
}
