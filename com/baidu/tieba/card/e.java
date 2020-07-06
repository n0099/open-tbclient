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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes9.dex */
public class e extends b<com.baidu.tieba.e.a> {
    private LinearLayout gOW;
    private TextView gOX;
    private RelativeLayout gOY;
    private TbImageView gOZ;
    private ImageView gPa;
    private TextView gPb;
    private RelativeLayout gPc;
    private ClickableHeaderImageView gPd;
    private TextView gPe;
    private TextView gPf;
    private TextView gPg;
    private View gPh;
    private com.baidu.tieba.e.a gPi;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.gOW = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gOX = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.gOY = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.gOZ = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.gPa = (ImageView) view.findViewById(R.id.img_play);
        this.gPb = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.gPc = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.gPd = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gPe = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.gPf = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.gPg = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.gPh = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.gOZ.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gOZ.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gOY.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.gOY.setLayoutParams(layoutParams);
        this.gPg.setOnClickListener(this);
        this.gPd.setDefaultResource(17170445);
        this.gPd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gPd.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gPd.setIsRound(true);
        this.gPd.setDrawBorder(true);
        this.gPd.setBorderColor(an.getColor(R.color.common_color_10043));
        this.gPd.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.gOW != null) {
            this.gOW.setPadding(i, i2, i3, i4);
        }
    }

    public void sK(int i) {
        if (this.gPc != null) {
            this.gPc.setVisibility(i);
        }
    }

    public void sL(int i) {
        if (this.gPh != null) {
            this.gPh.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            an.setBackgroundResource(this.gPh, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Nr(this.gPi.aPS().getId())) {
                an.setViewTextColor(this.gOX, R.color.cp_cont_c, 1);
            } else {
                an.setViewTextColor(this.gOX, R.color.cp_cont_b, 1);
            }
            an.setViewTextColor(this.gPe, R.color.cp_cont_d, 1);
            an.setViewTextColor(this.gPf, R.color.cp_cont_d, 1);
            an.setViewTextColor(this.gPg, R.color.cp_link_tip_c, 1);
            an.setViewTextColor(this.gPb, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.aPS() != null) {
            this.gPi = aVar;
            String str = null;
            if (aVar.aPS().aQV()) {
                this.gPa.setVisibility(0);
                this.gPb.setVisibility(0);
                if (aVar.aPS().aSH() != null) {
                    this.gPb.setText(ar.stringForVideoTime(aVar.aPS().aSH().video_duration.intValue() * 1000));
                    str = aVar.aPS().aSH().thumbnail_url;
                }
            } else {
                this.gPa.setVisibility(8);
                this.gPb.setVisibility(4);
                if (aVar.aPS().aSy() != null && aVar.aPS().aSy().size() >= 1) {
                    str = aVar.aPS().aSy().get(0).origin_pic;
                }
            }
            this.gOZ.startLoad(str, 10, false);
            this.gOX.setText(aVar.aPS().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Nr(aVar.aPS().getId())) {
                an.setViewTextColor(this.gOX, (int) R.color.cp_cont_c);
            } else {
                an.setViewTextColor(this.gOX, (int) R.color.cp_cont_b);
            }
            this.gPd.setData(aVar.aPS(), false);
            h(aVar.aPS());
            this.gPf.setText(ar.getFormatTimeShort(aVar.aPS().aRY()));
            if ("guide".equals(aVar.aPS().aSe())) {
                this.gPg.setVisibility(0);
            } else {
                this.gPg.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gPg) {
            TiebaStatic.log(new ao("c13047").ag("obj_locate", 4).dk("fid", this.mForumId));
            FrsGameStrategyActivity.t(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (bOd() != null) {
            bOd().a(getView(), this.gPi);
        }
    }

    private void h(bu buVar) {
        if (this.gPe != null && buVar != null && !StringUtils.isNull(buVar.aSp().getName_show())) {
            this.gPe.setText(xm(buVar.aSp().getName_show()));
        }
    }

    protected String xm(String str) {
        return ar.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
