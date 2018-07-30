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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes3.dex */
public class e extends a<com.baidu.tieba.e.a> {
    private LinearLayout cwB;
    private TextView cwC;
    private RelativeLayout cwD;
    private TbImageView cwE;
    private ImageView cwF;
    private TextView cwG;
    private RelativeLayout cwH;
    private ClickableHeaderImageView cwI;
    private TextView cwJ;
    private TextView cwK;
    private TextView cwL;
    private View cwM;
    private com.baidu.tieba.e.a cwN;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.cwB = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.cwC = (TextView) view.findViewById(d.g.card_frs_game_thread_title);
        this.cwD = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.cwE = (TbImageView) view.findViewById(d.g.card_frs_game_thread_bg);
        this.cwF = (ImageView) view.findViewById(d.g.img_play);
        this.cwG = (TextView) view.findViewById(d.g.card_frs_game_thread_video_time);
        this.cwH = (RelativeLayout) view.findViewById(d.g.card_frs_game_user_content);
        this.cwI = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.cwJ = (TextView) view.findViewById(d.g.card_frs_game_user_name);
        this.cwK = (TextView) view.findViewById(d.g.card_frs_game_thread_time);
        this.cwL = (TextView) view.findViewById(d.g.card_frs_game_thread_more_article);
        this.cwM = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.cwE.setDefaultBgResource(d.f.icon_morenpic);
        this.cwE.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.al(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(d.e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cwD.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cwD.setLayoutParams(layoutParams);
        this.cwL.setOnClickListener(this);
        this.cwI.setDefaultResource(17170445);
        this.cwI.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cwI.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.cwI.setIsRound(true);
        this.cwI.setDrawBorder(true);
        this.cwI.setBorderColor(am.getColor(d.C0140d.common_color_10043));
        this.cwI.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void l(int i, int i2, int i3, int i4) {
        if (this.cwB != null) {
            this.cwB.setPadding(i, i2, i3, i4);
        }
    }

    public void iQ(int i) {
        if (this.cwH != null) {
            this.cwH.setVisibility(i);
        }
    }

    public void iR(int i) {
        if (this.cwM != null) {
            this.cwM.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.C0140d.cp_bg_line_d);
            am.i(this.cwM, d.C0140d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tY(this.cwN.Td().getId())) {
                am.c(this.cwC, d.C0140d.cp_cont_c, 1);
            } else {
                am.c(this.cwC, d.C0140d.cp_cont_b, 1);
            }
            am.c(this.cwJ, d.C0140d.cp_cont_d, 1);
            am.c(this.cwK, d.C0140d.cp_cont_d, 1);
            am.c(this.cwL, d.C0140d.cp_link_tip_c, 1);
            am.c(this.cwG, d.C0140d.cp_cont_i, 1);
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
        if (aVar != null && aVar.Td() != null) {
            this.cwN = aVar;
            String str = null;
            if (aVar.Td().vW()) {
                this.cwF.setVisibility(0);
                this.cwG.setVisibility(0);
                if (aVar.Td().vC() != null) {
                    this.cwG.setText(ap.da(aVar.Td().vC().video_duration.intValue() * 1000));
                    str = aVar.Td().vC().thumbnail_url;
                }
            } else {
                this.cwF.setVisibility(8);
                this.cwG.setVisibility(4);
                if (aVar.Td().vv() != null && aVar.Td().vv().size() >= 1) {
                    str = aVar.Td().vv().get(0).origin_pic;
                }
            }
            this.cwE.startLoad(str, 10, false);
            this.cwC.setText(aVar.Td().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tY(aVar.Td().getId())) {
                am.h(this.cwC, d.C0140d.cp_cont_c);
            } else {
                am.h(this.cwC, d.C0140d.cp_cont_b);
            }
            this.cwI.setData(aVar.Td(), false);
            o(aVar.Td());
            this.cwK.setText(ap.y(aVar.Td().uV()));
            if ("guide".equals(aVar.Td().va())) {
                this.cwL.setVisibility(0);
            } else {
                this.cwL.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cwL) {
            TiebaStatic.log(new an("c13047").r("obj_locate", 4).af(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.i(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aiz() != null) {
            aiz().a(getView(), this.cwN);
        }
    }

    private void o(bb bbVar) {
        if (this.cwJ != null && bbVar != null && !StringUtils.isNull(bbVar.vk().getName_show())) {
            this.cwJ.setText(fp(bbVar.vk().getName_show()));
        }
    }

    protected String fp(String str) {
        return ap.e(str, 14, "...");
    }
}
