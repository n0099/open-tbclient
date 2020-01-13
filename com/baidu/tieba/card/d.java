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
/* loaded from: classes7.dex */
public class d extends a<com.baidu.tieba.e.a> {
    private LinearLayout fEV;
    private TextView fEW;
    private RelativeLayout fEX;
    private TbImageView fEY;
    private ImageView fEZ;
    private TextView fFa;
    private RelativeLayout fFb;
    private ClickableHeaderImageView fFc;
    private TextView fFd;
    private TextView fFe;
    private TextView fFf;
    private View fFg;
    private com.baidu.tieba.e.a fFh;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.fEV = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fEW = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.fEX = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fEY = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.fEZ = (ImageView) view.findViewById(R.id.img_play);
        this.fFa = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.fFb = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.fFc = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fFd = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.fFe = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.fFf = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.fFg = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fEY.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fEY.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fEX.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.fEX.setLayoutParams(layoutParams);
        this.fFf.setOnClickListener(this);
        this.fFc.setDefaultResource(17170445);
        this.fFc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fFc.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fFc.setIsRound(true);
        this.fFc.setDrawBorder(true);
        this.fFc.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fFc.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void v(int i, int i2, int i3, int i4) {
        if (this.fEV != null) {
            this.fEV.setPadding(i, i2, i3, i4);
        }
    }

    public void rf(int i) {
        if (this.fFb != null) {
            this.fFb.setVisibility(i);
        }
    }

    public void rg(int i) {
        if (this.fFg != null) {
            this.fFg.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fFg, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jb(this.fFh.axQ().getId())) {
                am.setViewTextColor(this.fEW, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.fEW, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.fFd, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fFe, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fFf, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.fFa, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.axQ() != null) {
            this.fFh = aVar;
            String str = null;
            if (aVar.axQ().aAX()) {
                this.fEZ.setVisibility(0);
                this.fFa.setVisibility(0);
                if (aVar.axQ().aAo() != null) {
                    this.fFa.setText(aq.stringForVideoTime(aVar.axQ().aAo().video_duration.intValue() * 1000));
                    str = aVar.axQ().aAo().thumbnail_url;
                }
            } else {
                this.fEZ.setVisibility(8);
                this.fFa.setVisibility(4);
                if (aVar.axQ().aAh() != null && aVar.axQ().aAh().size() >= 1) {
                    str = aVar.axQ().aAh().get(0).origin_pic;
                }
            }
            this.fEY.startLoad(str, 10, false);
            this.fEW.setText(aVar.axQ().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jb(aVar.axQ().getId())) {
                am.setViewTextColor(this.fEW, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fEW, (int) R.color.cp_cont_b);
            }
            this.fFc.setData(aVar.axQ(), false);
            h(aVar.axQ());
            this.fFe.setText(aq.getFormatTimeShort(aVar.axQ().azG()));
            if ("guide".equals(aVar.axQ().azM())) {
                this.fFf.setVisibility(0);
            } else {
                this.fFf.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fFf) {
            TiebaStatic.log(new an("c13047").Z("obj_locate", 4).cp("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (bta() != null) {
            bta().a(getView(), this.fFh);
        }
    }

    private void h(bj bjVar) {
        if (this.fFd != null && bjVar != null && !StringUtils.isNull(bjVar.azX().getName_show())) {
            this.fFd.setText(tI(bjVar.azX().getName_show()));
        }
    }

    protected String tI(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
