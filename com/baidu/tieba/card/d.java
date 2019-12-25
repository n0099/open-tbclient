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
/* loaded from: classes6.dex */
public class d extends a<com.baidu.tieba.e.a> {
    private LinearLayout fBK;
    private TextView fBL;
    private RelativeLayout fBM;
    private TbImageView fBN;
    private ImageView fBO;
    private TextView fBP;
    private RelativeLayout fBQ;
    private ClickableHeaderImageView fBR;
    private TextView fBS;
    private TextView fBT;
    private TextView fBU;
    private View fBV;
    private com.baidu.tieba.e.a fBW;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.fBK = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fBL = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.fBM = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fBN = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.fBO = (ImageView) view.findViewById(R.id.img_play);
        this.fBP = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.fBQ = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.fBR = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fBS = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.fBT = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.fBU = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.fBV = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fBN.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fBN.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBM.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.fBM.setLayoutParams(layoutParams);
        this.fBU.setOnClickListener(this);
        this.fBR.setDefaultResource(17170445);
        this.fBR.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fBR.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fBR.setIsRound(true);
        this.fBR.setDrawBorder(true);
        this.fBR.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fBR.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void v(int i, int i2, int i3, int i4) {
        if (this.fBK != null) {
            this.fBK.setPadding(i, i2, i3, i4);
        }
    }

    public void ra(int i) {
        if (this.fBQ != null) {
            this.fBQ.setVisibility(i);
        }
    }

    public void rb(int i) {
        if (this.fBV != null) {
            this.fBV.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fBV, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.IR(this.fBW.axx().getId())) {
                am.setViewTextColor(this.fBL, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.fBL, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.fBS, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fBT, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fBU, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.fBP, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.axx() != null) {
            this.fBW = aVar;
            String str = null;
            if (aVar.axx().aAE()) {
                this.fBO.setVisibility(0);
                this.fBP.setVisibility(0);
                if (aVar.axx().azV() != null) {
                    this.fBP.setText(aq.stringForVideoTime(aVar.axx().azV().video_duration.intValue() * 1000));
                    str = aVar.axx().azV().thumbnail_url;
                }
            } else {
                this.fBO.setVisibility(8);
                this.fBP.setVisibility(4);
                if (aVar.axx().azO() != null && aVar.axx().azO().size() >= 1) {
                    str = aVar.axx().azO().get(0).origin_pic;
                }
            }
            this.fBN.startLoad(str, 10, false);
            this.fBL.setText(aVar.axx().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.IR(aVar.axx().getId())) {
                am.setViewTextColor(this.fBL, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fBL, (int) R.color.cp_cont_b);
            }
            this.fBR.setData(aVar.axx(), false);
            h(aVar.axx());
            this.fBT.setText(aq.getFormatTimeShort(aVar.axx().azn()));
            if ("guide".equals(aVar.axx().azt())) {
                this.fBU.setVisibility(0);
            } else {
                this.fBU.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fBU) {
            TiebaStatic.log(new an("c13047").Z("obj_locate", 4).cp("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (brY() != null) {
            brY().a(getView(), this.fBW);
        }
    }

    private void h(bj bjVar) {
        if (this.fBS != null && bjVar != null && !StringUtils.isNull(bjVar.azE().getName_show())) {
            this.fBS.setText(tE(bjVar.azE().getName_show()));
        }
    }

    protected String tE(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
