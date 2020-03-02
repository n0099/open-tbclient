package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes9.dex */
public class d extends a<com.baidu.tieba.e.a> {
    private RelativeLayout fHA;
    private ClickableHeaderImageView fHB;
    private TextView fHC;
    private TextView fHD;
    private TextView fHE;
    private View fHF;
    private com.baidu.tieba.e.a fHG;
    private LinearLayout fHu;
    private TextView fHv;
    private RelativeLayout fHw;
    private TbImageView fHx;
    private ImageView fHy;
    private TextView fHz;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.fHu = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fHv = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.fHw = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fHx = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.fHy = (ImageView) view.findViewById(R.id.img_play);
        this.fHz = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.fHA = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.fHB = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fHC = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.fHD = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.fHE = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.fHF = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fHx.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fHx.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHw.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.fHw.setLayoutParams(layoutParams);
        this.fHE.setOnClickListener(this);
        this.fHB.setDefaultResource(17170445);
        this.fHB.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fHB.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fHB.setIsRound(true);
        this.fHB.setDrawBorder(true);
        this.fHB.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHB.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void v(int i, int i2, int i3, int i4) {
        if (this.fHu != null) {
            this.fHu.setPadding(i, i2, i3, i4);
        }
    }

    public void rm(int i) {
        if (this.fHA != null) {
            this.fHA.setVisibility(i);
        }
    }

    public void rn(int i) {
        if (this.fHF != null) {
            this.fHF.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fHF, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(this.fHG.aAg().getId())) {
                am.setViewTextColor(this.fHv, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.fHv, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.fHC, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHD, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHE, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.fHz, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.aAg() != null) {
            this.fHG = aVar;
            String str = null;
            if (aVar.aAg().aBb()) {
                this.fHy.setVisibility(0);
                this.fHz.setVisibility(0);
                if (aVar.aAg().aCF() != null) {
                    this.fHz.setText(aq.stringForVideoTime(aVar.aAg().aCF().video_duration.intValue() * 1000));
                    str = aVar.aAg().aCF().thumbnail_url;
                }
            } else {
                this.fHy.setVisibility(8);
                this.fHz.setVisibility(4);
                if (aVar.aAg().aCy() != null && aVar.aAg().aCy().size() >= 1) {
                    str = aVar.aAg().aCy().get(0).origin_pic;
                }
            }
            this.fHx.startLoad(str, 10, false);
            this.fHv.setText(aVar.aAg().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(aVar.aAg().getId())) {
                am.setViewTextColor(this.fHv, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fHv, (int) R.color.cp_cont_b);
            }
            this.fHB.setData(aVar.aAg(), false);
            h(aVar.aAg());
            this.fHD.setText(aq.getFormatTimeShort(aVar.aAg().aBX()));
            if ("guide".equals(aVar.aAg().aCd())) {
                this.fHE.setVisibility(0);
            } else {
                this.fHE.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fHE) {
            TiebaStatic.log(new an("c13047").X("obj_locate", 4).cy("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (buG() != null) {
            buG().a(getView(), this.fHG);
        }
    }

    private void h(bj bjVar) {
        if (this.fHC != null && bjVar != null && !StringUtils.isNull(bjVar.aCo().getName_show())) {
            this.fHC.setText(tY(bjVar.aCo().getName_show()));
        }
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
