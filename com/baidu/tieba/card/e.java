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
    private LinearLayout gCg;
    private TextView gCh;
    private RelativeLayout gCi;
    private TbImageView gCj;
    private ImageView gCk;
    private TextView gCl;
    private RelativeLayout gCm;
    private ClickableHeaderImageView gCn;
    private TextView gCo;
    private TextView gCp;
    private TextView gCq;
    private View gCr;
    private com.baidu.tieba.e.a gCs;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.gCg = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gCh = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.gCi = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.gCj = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.gCk = (ImageView) view.findViewById(R.id.img_play);
        this.gCl = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.gCm = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.gCn = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gCo = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.gCp = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.gCq = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.gCr = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.gCj.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gCj.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gCi.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.gCi.setLayoutParams(layoutParams);
        this.gCq.setOnClickListener(this);
        this.gCn.setDefaultResource(17170445);
        this.gCn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gCn.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gCn.setIsRound(true);
        this.gCn.setDrawBorder(true);
        this.gCn.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCn.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.gCg != null) {
            this.gCg.setPadding(i, i2, i3, i4);
        }
    }

    public void sm(int i) {
        if (this.gCm != null) {
            this.gCm.setVisibility(i);
        }
    }

    public void sn(int i) {
        if (this.gCr != null) {
            this.gCr.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.gCr, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.MP(this.gCs.aOi().getId())) {
                am.setViewTextColor(this.gCh, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.gCh, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.gCo, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gCp, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gCq, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.gCl, R.color.cp_cont_a, 1);
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
            this.gCs = aVar;
            String str = null;
            if (aVar.aOi().aPk()) {
                this.gCk.setVisibility(0);
                this.gCl.setVisibility(0);
                if (aVar.aOi().aQQ() != null) {
                    this.gCl.setText(aq.stringForVideoTime(aVar.aOi().aQQ().video_duration.intValue() * 1000));
                    str = aVar.aOi().aQQ().thumbnail_url;
                }
            } else {
                this.gCk.setVisibility(8);
                this.gCl.setVisibility(4);
                if (aVar.aOi().aQH() != null && aVar.aOi().aQH().size() >= 1) {
                    str = aVar.aOi().aQH().get(0).origin_pic;
                }
            }
            this.gCj.startLoad(str, 10, false);
            this.gCh.setText(aVar.aOi().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.MP(aVar.aOi().getId())) {
                am.setViewTextColor(this.gCh, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gCh, (int) R.color.cp_cont_b);
            }
            this.gCn.setData(aVar.aOi(), false);
            h(aVar.aOi());
            this.gCp.setText(aq.getFormatTimeShort(aVar.aOi().aQg()));
            if ("guide".equals(aVar.aOi().aQm())) {
                this.gCq.setVisibility(0);
            } else {
                this.gCq.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCq) {
            TiebaStatic.log(new an("c13047").ag("obj_locate", 4).dh("fid", this.mForumId));
            FrsGameStrategyActivity.t(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (bKU() != null) {
            bKU().a(getView(), this.gCs);
        }
    }

    private void h(bk bkVar) {
        if (this.gCo != null && bkVar != null && !StringUtils.isNull(bkVar.aQx().getName_show())) {
            this.gCo.setText(wV(bkVar.aQx().getName_show()));
        }
    }

    protected String wV(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
