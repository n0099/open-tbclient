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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes9.dex */
public class e extends b<com.baidu.tieba.e.a> {
    private LinearLayout gBV;
    private TextView gBW;
    private RelativeLayout gBX;
    private TbImageView gBY;
    private ImageView gBZ;
    private TextView gCa;
    private RelativeLayout gCb;
    private ClickableHeaderImageView gCc;
    private TextView gCd;
    private TextView gCe;
    private TextView gCf;
    private View gCg;
    private com.baidu.tieba.e.a gCh;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.gBV = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gBW = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.gBX = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.gBY = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.gBZ = (ImageView) view.findViewById(R.id.img_play);
        this.gCa = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.gCb = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.gCc = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gCd = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.gCe = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.gCf = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.gCg = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.gBY.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gBY.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gBX.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.gBX.setLayoutParams(layoutParams);
        this.gCf.setOnClickListener(this);
        this.gCc.setDefaultResource(17170445);
        this.gCc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gCc.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gCc.setIsRound(true);
        this.gCc.setDrawBorder(true);
        this.gCc.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCc.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.gBV != null) {
            this.gBV.setPadding(i, i2, i3, i4);
        }
    }

    public void sk(int i) {
        if (this.gCb != null) {
            this.gCb.setVisibility(i);
        }
    }

    public void sl(int i) {
        if (this.gCg != null) {
            this.gCg.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.gCg, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.MO(this.gCh.aOi().getId())) {
                am.setViewTextColor(this.gBW, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.gBW, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.gCd, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gCe, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gCf, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.gCa, R.color.cp_cont_a, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.aOi() != null) {
            this.gCh = aVar;
            String str = null;
            if (aVar.aOi().aPk()) {
                this.gBZ.setVisibility(0);
                this.gCa.setVisibility(0);
                if (aVar.aOi().aQQ() != null) {
                    this.gCa.setText(aq.stringForVideoTime(aVar.aOi().aQQ().video_duration.intValue() * 1000));
                    str = aVar.aOi().aQQ().thumbnail_url;
                }
            } else {
                this.gBZ.setVisibility(8);
                this.gCa.setVisibility(4);
                if (aVar.aOi().aQH() != null && aVar.aOi().aQH().size() >= 1) {
                    str = aVar.aOi().aQH().get(0).origin_pic;
                }
            }
            this.gBY.startLoad(str, 10, false);
            this.gBW.setText(aVar.aOi().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.MO(aVar.aOi().getId())) {
                am.setViewTextColor(this.gBW, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gBW, (int) R.color.cp_cont_b);
            }
            this.gCc.setData(aVar.aOi(), false);
            h(aVar.aOi());
            this.gCe.setText(aq.getFormatTimeShort(aVar.aOi().aQg()));
            if ("guide".equals(aVar.aOi().aQm())) {
                this.gCf.setVisibility(0);
            } else {
                this.gCf.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCf) {
            TiebaStatic.log(new an("c13047").ag("obj_locate", 4).dh("fid", this.mForumId));
            FrsGameStrategyActivity.t(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (bKS() != null) {
            bKS().a(getView(), this.gCh);
        }
    }

    private void h(bk bkVar) {
        if (this.gCd != null && bkVar != null && !StringUtils.isNull(bkVar.aQx().getName_show())) {
            this.gCd.setText(wV(bkVar.aQx().getName_show()));
        }
    }

    protected String wV(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
