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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes16.dex */
public class e extends b<com.baidu.tieba.e.a> {
    private LinearLayout gUC;
    private TextView gUD;
    private RelativeLayout gUE;
    private TbImageView gUF;
    private ImageView gUG;
    private TextView gUH;
    private RelativeLayout gUI;
    private ClickableHeaderImageView gUJ;
    private TextView gUK;
    private TextView gUL;
    private TextView gUM;
    private View gUN;
    private com.baidu.tieba.e.a gUO;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.gUC = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gUD = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.gUE = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.gUF = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.gUG = (ImageView) view.findViewById(R.id.img_play);
        this.gUH = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.gUI = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.gUJ = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gUK = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.gUL = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.gUM = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.gUN = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.gUF.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gUF.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gUE.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.gUE.setLayoutParams(layoutParams);
        this.gUM.setOnClickListener(this);
        this.gUJ.setDefaultResource(17170445);
        this.gUJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gUJ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gUJ.setIsRound(true);
        this.gUJ.setDrawBorder(true);
        this.gUJ.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.gUJ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.gUC != null) {
            this.gUC.setPadding(i, i2, i3, i4);
        }
    }

    public void tc(int i) {
        if (this.gUI != null) {
            this.gUI.setVisibility(i);
        }
    }

    public void td(int i) {
        if (this.gUN != null) {
            this.gUN.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ao.setBackgroundResource(this.gUN, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.NZ(this.gUO.aTN().getId())) {
                ao.setViewTextColor(this.gUD, R.color.cp_cont_c, 1);
            } else {
                ao.setViewTextColor(this.gUD, R.color.cp_cont_b, 1);
            }
            ao.setViewTextColor(this.gUK, R.color.cp_cont_d, 1);
            ao.setViewTextColor(this.gUL, R.color.cp_cont_d, 1);
            ao.setViewTextColor(this.gUM, R.color.cp_link_tip_c, 1);
            ao.setViewTextColor(this.gUH, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.aTN() != null) {
            this.gUO = aVar;
            String str = null;
            if (aVar.aTN().aUR()) {
                this.gUG.setVisibility(0);
                this.gUH.setVisibility(0);
                if (aVar.aTN().aWD() != null) {
                    this.gUH.setText(as.stringForVideoTime(aVar.aTN().aWD().video_duration.intValue() * 1000));
                    str = aVar.aTN().aWD().thumbnail_url;
                }
            } else {
                this.gUG.setVisibility(8);
                this.gUH.setVisibility(4);
                if (aVar.aTN().aWu() != null && aVar.aTN().aWu().size() >= 1) {
                    str = aVar.aTN().aWu().get(0).origin_pic;
                }
            }
            this.gUF.startLoad(str, 10, false);
            this.gUD.setText(aVar.aTN().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.NZ(aVar.aTN().getId())) {
                ao.setViewTextColor(this.gUD, R.color.cp_cont_c);
            } else {
                ao.setViewTextColor(this.gUD, R.color.cp_cont_b);
            }
            this.gUJ.setData(aVar.aTN(), false);
            h(aVar.aTN());
            this.gUL.setText(as.getFormatTimeShort(aVar.aTN().aVU()));
            if ("guide".equals(aVar.aTN().aWa())) {
                this.gUM.setVisibility(0);
            } else {
                this.gUM.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gUM) {
            TiebaStatic.log(new ap("c13047").ah("obj_locate", 4).dn("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (bRn() != null) {
            bRn().a(getView(), this.gUO);
        }
    }

    private void h(bv bvVar) {
        if (this.gUK != null && bvVar != null && !StringUtils.isNull(bvVar.aWl().getName_show())) {
            this.gUK.setText(yr(bvVar.aWl().getName_show()));
        }
    }

    protected String yr(String str) {
        return as.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
