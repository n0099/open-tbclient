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
    private ClickableHeaderImageView hhB;
    private TextView hhC;
    private TextView hhD;
    private TextView hhE;
    private View hhF;
    private com.baidu.tieba.e.a hhG;
    private LinearLayout hhu;
    private TextView hhv;
    private RelativeLayout hhw;
    private TbImageView hhx;
    private ImageView hhy;
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
        this.hhu = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hhv = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.hhw = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hhx = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.hhy = (ImageView) view.findViewById(R.id.img_play);
        this.hhz = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.hhA = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.hhB = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hhC = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.hhD = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.hhE = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.hhF = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hhx.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hhx.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hhw.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.hhw.setLayoutParams(layoutParams);
        this.hhE.setOnClickListener(this);
        this.hhB.setDefaultResource(17170445);
        this.hhB.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hhB.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hhB.setIsRound(true);
        this.hhB.setDrawBorder(true);
        this.hhB.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hhB.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.hhu != null) {
            this.hhu.setPadding(i, i2, i3, i4);
        }
    }

    public void vr(int i) {
        if (this.hhA != null) {
            this.hhA.setVisibility(i);
        }
    }

    public void vs(int i) {
        if (this.hhF != null) {
            this.hhF.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hhF, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.QX(this.hhG.bce().getId())) {
                ap.setViewTextColor(this.hhv, R.color.cp_cont_c, 1);
            } else {
                ap.setViewTextColor(this.hhv, R.color.cp_cont_b, 1);
            }
            ap.setViewTextColor(this.hhC, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hhD, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hhE, R.color.cp_link_tip_c, 1);
            ap.setViewTextColor(this.hhz, R.color.cp_cont_a, 1);
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
            this.hhG = aVar;
            String str = null;
            if (aVar.bce().bdk()) {
                this.hhy.setVisibility(0);
                this.hhz.setVisibility(0);
                if (aVar.bce().beW() != null) {
                    this.hhz.setText(at.stringForVideoTime(aVar.bce().beW().video_duration.intValue() * 1000));
                    str = aVar.bce().beW().thumbnail_url;
                }
            } else {
                this.hhy.setVisibility(8);
                this.hhz.setVisibility(4);
                if (aVar.bce().beN() != null && aVar.bce().beN().size() >= 1) {
                    str = aVar.bce().beN().get(0).origin_pic;
                }
            }
            this.hhx.startLoad(str, 10, false);
            this.hhv.setText(aVar.bce().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.QX(aVar.bce().getId())) {
                ap.setViewTextColor(this.hhv, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hhv, (int) R.color.cp_cont_b);
            }
            this.hhB.setData(aVar.bce(), false);
            h(aVar.bce());
            this.hhD.setText(at.getFormatTimeShort(aVar.bce().ben()));
            if ("guide".equals(aVar.bce().bet())) {
                this.hhE.setVisibility(0);
            } else {
                this.hhE.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hhE) {
            TiebaStatic.log(new aq("c13047").ai("obj_locate", 4).dD("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (cbz() != null) {
            cbz().a(getView(), this.hhG);
        }
    }

    private void h(bw bwVar) {
        if (this.hhC != null && bwVar != null && !StringUtils.isNull(bwVar.beE().getName_show())) {
            this.hhC.setText(AF(bwVar.beE().getName_show()));
        }
    }

    protected String AF(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
