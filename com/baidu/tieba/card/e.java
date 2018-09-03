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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes3.dex */
public class e extends a<com.baidu.tieba.e.a> {
    private RelativeLayout cwA;
    private TbImageView cwB;
    private ImageView cwC;
    private TextView cwD;
    private RelativeLayout cwE;
    private ClickableHeaderImageView cwF;
    private TextView cwG;
    private TextView cwH;
    private TextView cwI;
    private View cwJ;
    private com.baidu.tieba.e.a cwK;
    private LinearLayout cwy;
    private TextView cwz;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.cwy = (LinearLayout) view.findViewById(f.g.card_frs_game_thread_layout);
        this.cwz = (TextView) view.findViewById(f.g.card_frs_game_thread_title);
        this.cwA = (RelativeLayout) view.findViewById(f.g.card_frs_game_thread_content);
        this.cwB = (TbImageView) view.findViewById(f.g.card_frs_game_thread_bg);
        this.cwC = (ImageView) view.findViewById(f.g.img_play);
        this.cwD = (TextView) view.findViewById(f.g.card_frs_game_thread_video_time);
        this.cwE = (RelativeLayout) view.findViewById(f.g.card_frs_game_user_content);
        this.cwF = (ClickableHeaderImageView) view.findViewById(f.g.card_frs_game_user_icon);
        this.cwG = (TextView) view.findViewById(f.g.card_frs_game_user_name);
        this.cwH = (TextView) view.findViewById(f.g.card_frs_game_thread_time);
        this.cwI = (TextView) view.findViewById(f.g.card_frs_game_thread_more_article);
        this.cwJ = view.findViewById(f.g.card_frs_game_bottom_divider);
        this.cwB.setDefaultBgResource(f.C0146f.icon_morenpic);
        this.cwB.setDefaultErrorResource(f.C0146f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.al(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(f.e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cwA.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cwA.setLayoutParams(layoutParams);
        this.cwI.setOnClickListener(this);
        this.cwF.setDefaultResource(17170445);
        this.cwF.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.cwF.setDefaultBgResource(f.d.cp_bg_line_e);
        this.cwF.setIsRound(true);
        this.cwF.setDrawBorder(true);
        this.cwF.setBorderColor(am.getColor(f.d.common_color_10043));
        this.cwF.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(f.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void l(int i, int i2, int i3, int i4) {
        if (this.cwy != null) {
            this.cwy.setPadding(i, i2, i3, i4);
        }
    }

    public void iP(int i) {
        if (this.cwE != null) {
            this.cwE.setVisibility(i);
        }
    }

    public void iQ(int i) {
        if (this.cwJ != null) {
            this.cwJ.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.d.cp_bg_line_d);
            am.i(this.cwJ, f.d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.uc(this.cwK.Tg().getId())) {
                am.c(this.cwz, f.d.cp_cont_c, 1);
            } else {
                am.c(this.cwz, f.d.cp_cont_b, 1);
            }
            am.c(this.cwG, f.d.cp_cont_d, 1);
            am.c(this.cwH, f.d.cp_cont_d, 1);
            am.c(this.cwI, f.d.cp_link_tip_c, 1);
            am.c(this.cwD, f.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.Tg() != null) {
            this.cwK = aVar;
            String str = null;
            if (aVar.Tg().vV()) {
                this.cwC.setVisibility(0);
                this.cwD.setVisibility(0);
                if (aVar.Tg().vB() != null) {
                    this.cwD.setText(ap.da(aVar.Tg().vB().video_duration.intValue() * 1000));
                    str = aVar.Tg().vB().thumbnail_url;
                }
            } else {
                this.cwC.setVisibility(8);
                this.cwD.setVisibility(4);
                if (aVar.Tg().vu() != null && aVar.Tg().vu().size() >= 1) {
                    str = aVar.Tg().vu().get(0).origin_pic;
                }
            }
            this.cwB.startLoad(str, 10, false);
            this.cwz.setText(aVar.Tg().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.uc(aVar.Tg().getId())) {
                am.h(this.cwz, f.d.cp_cont_c);
            } else {
                am.h(this.cwz, f.d.cp_cont_b);
            }
            this.cwF.setData(aVar.Tg(), false);
            o(aVar.Tg());
            this.cwH.setText(ap.y(aVar.Tg().uU()));
            if ("guide".equals(aVar.Tg().uZ())) {
                this.cwI.setVisibility(0);
            } else {
                this.cwI.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cwI) {
            TiebaStatic.log(new an("c13047").r("obj_locate", 4).ae(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.i(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aiC() != null) {
            aiC().a(getView(), this.cwK);
        }
    }

    private void o(bb bbVar) {
        if (this.cwG != null && bbVar != null && !StringUtils.isNull(bbVar.vj().getName_show())) {
            this.cwG.setText(fp(bbVar.vj().getName_show()));
        }
    }

    protected String fp(String str) {
        return ap.d(str, 14, "...");
    }
}
