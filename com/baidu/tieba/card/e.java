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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes22.dex */
public class e extends b<com.baidu.tieba.e.a> {
    private LinearLayout hPS;
    private TextView hPT;
    private RelativeLayout hPU;
    private TbImageView hPV;
    private ImageView hPW;
    private TextView hPX;
    private RelativeLayout hPY;
    private ClickableHeaderImageView hPZ;
    private TextView hQa;
    private TextView hQb;
    private TextView hQc;
    private View hQd;
    private com.baidu.tieba.e.a hQe;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.hPS = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hPT = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.hPU = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hPV = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.hPW = (ImageView) view.findViewById(R.id.img_play);
        this.hPX = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.hPY = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.hPZ = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hQa = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.hQb = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.hQc = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.hQd = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hPV.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hPV.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hPU.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.hPU.setLayoutParams(layoutParams);
        this.hQc.setOnClickListener(this);
        this.hPZ.setDefaultResource(17170445);
        this.hPZ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hPZ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hPZ.setIsRound(true);
        this.hPZ.setDrawBorder(true);
        this.hPZ.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hPZ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.hPS != null) {
            this.hPS.setPadding(i, i2, i3, i4);
        }
    }

    public void wP(int i) {
        if (this.hPY != null) {
            this.hPY.setVisibility(i);
        }
    }

    public void wQ(int i) {
        if (this.hQd != null) {
            this.hQd.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hQd, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SK(this.hQe.bhz().getId())) {
                ap.setViewTextColor(this.hPT, R.color.cp_cont_c, 1);
            } else {
                ap.setViewTextColor(this.hPT, R.color.cp_cont_b, 1);
            }
            ap.setViewTextColor(this.hQa, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hQb, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hQc, R.color.cp_link_tip_c, 1);
            ap.setViewTextColor(this.hPX, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.bhz() != null) {
            this.hQe = aVar;
            String str = null;
            if (aVar.bhz().biG()) {
                this.hPW.setVisibility(0);
                this.hPX.setVisibility(0);
                if (aVar.bhz().bks() != null) {
                    this.hPX.setText(at.stringForVideoTime(aVar.bhz().bks().video_duration.intValue() * 1000));
                    str = aVar.bhz().bks().thumbnail_url;
                }
            } else {
                this.hPW.setVisibility(8);
                this.hPX.setVisibility(4);
                if (aVar.bhz().bkj() != null && aVar.bhz().bkj().size() >= 1) {
                    str = aVar.bhz().bkj().get(0).origin_pic;
                }
            }
            this.hPV.startLoad(str, 10, false);
            this.hPT.setText(aVar.bhz().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SK(aVar.bhz().getId())) {
                ap.setViewTextColor(this.hPT, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hPT, (int) R.color.cp_cont_b);
            }
            this.hPZ.setData(aVar.bhz(), false);
            i(aVar.bhz());
            this.hQb.setText(at.getFormatTimeShort(aVar.bhz().bjJ()));
            if ("guide".equals(aVar.bhz().bjP())) {
                this.hQc.setVisibility(0);
            } else {
                this.hQc.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hQc) {
            TiebaStatic.log(new aq("c13047").aj("obj_locate", 4).dR("fid", this.mForumId));
            FrsGameStrategyActivity.v(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (cls() != null) {
            cls().a(getView(), this.hQe);
        }
    }

    private void i(bw bwVar) {
        if (this.hQa != null && bwVar != null && !StringUtils.isNull(bwVar.bka().getName_show())) {
            this.hQa.setText(Ch(bwVar.bka().getName_show()));
        }
    }

    protected String Ch(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
