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
    private LinearLayout fHH;
    private TextView fHI;
    private RelativeLayout fHJ;
    private TbImageView fHK;
    private ImageView fHL;
    private TextView fHM;
    private RelativeLayout fHN;
    private ClickableHeaderImageView fHO;
    private TextView fHP;
    private TextView fHQ;
    private TextView fHR;
    private View fHS;
    private com.baidu.tieba.e.a fHT;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.fHH = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fHI = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.fHJ = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fHK = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.fHL = (ImageView) view.findViewById(R.id.img_play);
        this.fHM = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.fHN = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.fHO = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fHP = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.fHQ = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.fHR = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.fHS = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fHK.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fHK.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHJ.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.fHJ.setLayoutParams(layoutParams);
        this.fHR.setOnClickListener(this);
        this.fHO.setDefaultResource(17170445);
        this.fHO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fHO.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fHO.setIsRound(true);
        this.fHO.setDrawBorder(true);
        this.fHO.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHO.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void v(int i, int i2, int i3, int i4) {
        if (this.fHH != null) {
            this.fHH.setPadding(i, i2, i3, i4);
        }
    }

    public void rm(int i) {
        if (this.fHN != null) {
            this.fHN.setVisibility(i);
        }
    }

    public void rn(int i) {
        if (this.fHS != null) {
            this.fHS.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fHS, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jp(this.fHT.aAg().getId())) {
                am.setViewTextColor(this.fHI, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.fHI, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.fHP, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHQ, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHR, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.fHM, R.color.cp_cont_a, 1);
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
            this.fHT = aVar;
            String str = null;
            if (aVar.aAg().aBb()) {
                this.fHL.setVisibility(0);
                this.fHM.setVisibility(0);
                if (aVar.aAg().aCF() != null) {
                    this.fHM.setText(aq.stringForVideoTime(aVar.aAg().aCF().video_duration.intValue() * 1000));
                    str = aVar.aAg().aCF().thumbnail_url;
                }
            } else {
                this.fHL.setVisibility(8);
                this.fHM.setVisibility(4);
                if (aVar.aAg().aCy() != null && aVar.aAg().aCy().size() >= 1) {
                    str = aVar.aAg().aCy().get(0).origin_pic;
                }
            }
            this.fHK.startLoad(str, 10, false);
            this.fHI.setText(aVar.aAg().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jp(aVar.aAg().getId())) {
                am.setViewTextColor(this.fHI, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fHI, (int) R.color.cp_cont_b);
            }
            this.fHO.setData(aVar.aAg(), false);
            h(aVar.aAg());
            this.fHQ.setText(aq.getFormatTimeShort(aVar.aAg().aBX()));
            if ("guide".equals(aVar.aAg().aCd())) {
                this.fHR.setVisibility(0);
            } else {
                this.fHR.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fHR) {
            TiebaStatic.log(new an("c13047").X("obj_locate", 4).cy("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (buH() != null) {
            buH().a(getView(), this.fHT);
        }
    }

    private void h(bj bjVar) {
        if (this.fHP != null && bjVar != null && !StringUtils.isNull(bjVar.aCo().getName_show())) {
            this.fHP.setText(tZ(bjVar.aCo().getName_show()));
        }
    }

    protected String tZ(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
