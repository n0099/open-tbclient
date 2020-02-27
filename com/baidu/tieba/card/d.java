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
    private TextView fHA;
    private TextView fHB;
    private TextView fHC;
    private View fHD;
    private com.baidu.tieba.e.a fHE;
    private LinearLayout fHs;
    private TextView fHt;
    private RelativeLayout fHu;
    private TbImageView fHv;
    private ImageView fHw;
    private TextView fHx;
    private RelativeLayout fHy;
    private ClickableHeaderImageView fHz;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.fHs = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fHt = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.fHu = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fHv = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.fHw = (ImageView) view.findViewById(R.id.img_play);
        this.fHx = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.fHy = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.fHz = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fHA = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.fHB = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.fHC = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.fHD = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fHv.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fHv.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHu.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.fHu.setLayoutParams(layoutParams);
        this.fHC.setOnClickListener(this);
        this.fHz.setDefaultResource(17170445);
        this.fHz.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fHz.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fHz.setIsRound(true);
        this.fHz.setDrawBorder(true);
        this.fHz.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHz.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void v(int i, int i2, int i3, int i4) {
        if (this.fHs != null) {
            this.fHs.setPadding(i, i2, i3, i4);
        }
    }

    public void rm(int i) {
        if (this.fHy != null) {
            this.fHy.setVisibility(i);
        }
    }

    public void rn(int i) {
        if (this.fHD != null) {
            this.fHD.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fHD, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(this.fHE.aAe().getId())) {
                am.setViewTextColor(this.fHt, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.fHt, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.fHA, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHB, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHC, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.fHx, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.aAe() != null) {
            this.fHE = aVar;
            String str = null;
            if (aVar.aAe().aAZ()) {
                this.fHw.setVisibility(0);
                this.fHx.setVisibility(0);
                if (aVar.aAe().aCD() != null) {
                    this.fHx.setText(aq.stringForVideoTime(aVar.aAe().aCD().video_duration.intValue() * 1000));
                    str = aVar.aAe().aCD().thumbnail_url;
                }
            } else {
                this.fHw.setVisibility(8);
                this.fHx.setVisibility(4);
                if (aVar.aAe().aCw() != null && aVar.aAe().aCw().size() >= 1) {
                    str = aVar.aAe().aCw().get(0).origin_pic;
                }
            }
            this.fHv.startLoad(str, 10, false);
            this.fHt.setText(aVar.aAe().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(aVar.aAe().getId())) {
                am.setViewTextColor(this.fHt, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fHt, (int) R.color.cp_cont_b);
            }
            this.fHz.setData(aVar.aAe(), false);
            h(aVar.aAe());
            this.fHB.setText(aq.getFormatTimeShort(aVar.aAe().aBV()));
            if ("guide".equals(aVar.aAe().aCb())) {
                this.fHC.setVisibility(0);
            } else {
                this.fHC.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fHC) {
            TiebaStatic.log(new an("c13047").X("obj_locate", 4).cy("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (buE() != null) {
            buE().a(getView(), this.fHE);
        }
    }

    private void h(bj bjVar) {
        if (this.fHA != null && bjVar != null && !StringUtils.isNull(bjVar.aCm().getName_show())) {
            this.fHA.setText(tY(bjVar.aCm().getName_show()));
        }
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
