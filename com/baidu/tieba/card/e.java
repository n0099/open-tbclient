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
/* loaded from: classes16.dex */
public class e extends b<com.baidu.tieba.e.a> {
    private RelativeLayout hhA;
    private TbImageView hhB;
    private ImageView hhC;
    private TextView hhD;
    private RelativeLayout hhE;
    private ClickableHeaderImageView hhF;
    private TextView hhG;
    private TextView hhH;
    private TextView hhI;
    private View hhJ;
    private com.baidu.tieba.e.a hhK;
    private LinearLayout hhy;
    private TextView hhz;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.hhy = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hhz = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.hhA = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hhB = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.hhC = (ImageView) view.findViewById(R.id.img_play);
        this.hhD = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.hhE = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.hhF = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hhG = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.hhH = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.hhI = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.hhJ = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hhB.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hhB.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hhA.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.hhA.setLayoutParams(layoutParams);
        this.hhI.setOnClickListener(this);
        this.hhF.setDefaultResource(17170445);
        this.hhF.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hhF.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hhF.setIsRound(true);
        this.hhF.setDrawBorder(true);
        this.hhF.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hhF.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.hhy != null) {
            this.hhy.setPadding(i, i2, i3, i4);
        }
    }

    public void vr(int i) {
        if (this.hhE != null) {
            this.hhE.setVisibility(i);
        }
    }

    public void vs(int i) {
        if (this.hhJ != null) {
            this.hhJ.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hhJ, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.QX(this.hhK.bce().getId())) {
                ap.setViewTextColor(this.hhz, R.color.cp_cont_c, 1);
            } else {
                ap.setViewTextColor(this.hhz, R.color.cp_cont_b, 1);
            }
            ap.setViewTextColor(this.hhG, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hhH, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hhI, R.color.cp_link_tip_c, 1);
            ap.setViewTextColor(this.hhD, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.bce() != null) {
            this.hhK = aVar;
            String str = null;
            if (aVar.bce().bdk()) {
                this.hhC.setVisibility(0);
                this.hhD.setVisibility(0);
                if (aVar.bce().beW() != null) {
                    this.hhD.setText(at.stringForVideoTime(aVar.bce().beW().video_duration.intValue() * 1000));
                    str = aVar.bce().beW().thumbnail_url;
                }
            } else {
                this.hhC.setVisibility(8);
                this.hhD.setVisibility(4);
                if (aVar.bce().beN() != null && aVar.bce().beN().size() >= 1) {
                    str = aVar.bce().beN().get(0).origin_pic;
                }
            }
            this.hhB.startLoad(str, 10, false);
            this.hhz.setText(aVar.bce().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.QX(aVar.bce().getId())) {
                ap.setViewTextColor(this.hhz, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hhz, (int) R.color.cp_cont_b);
            }
            this.hhF.setData(aVar.bce(), false);
            h(aVar.bce());
            this.hhH.setText(at.getFormatTimeShort(aVar.bce().ben()));
            if ("guide".equals(aVar.bce().bet())) {
                this.hhI.setVisibility(0);
            } else {
                this.hhI.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hhI) {
            TiebaStatic.log(new aq("c13047").ai("obj_locate", 4).dD("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (cbA() != null) {
            cbA().a(getView(), this.hhK);
        }
    }

    private void h(bw bwVar) {
        if (this.hhG != null && bwVar != null && !StringUtils.isNull(bwVar.beE().getName_show())) {
            this.hhG.setText(AG(bwVar.beE().getName_show()));
        }
    }

    protected String AG(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
