package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes4.dex */
public class d extends a<com.baidu.tieba.e.a> {
    private LinearLayout eKE;
    private TextView eKF;
    private RelativeLayout eKG;
    private TbImageView eKH;
    private ImageView eKI;
    private TextView eKJ;
    private RelativeLayout eKK;
    private ClickableHeaderImageView eKL;
    private TextView eKM;
    private TextView eKN;
    private TextView eKO;
    private View eKP;
    private com.baidu.tieba.e.a eKQ;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.eKE = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.eKF = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.eKG = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eKH = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.eKI = (ImageView) view.findViewById(R.id.img_play);
        this.eKJ = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.eKK = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.eKL = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.eKM = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.eKN = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.eKO = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.eKP = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eKH.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eKH.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eKG.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.eKG.setLayoutParams(layoutParams);
        this.eKO.setOnClickListener(this);
        this.eKL.setDefaultResource(17170445);
        this.eKL.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eKL.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eKL.setIsRound(true);
        this.eKL.setDrawBorder(true);
        this.eKL.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eKL.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.eKE != null) {
            this.eKE.setPadding(i, i2, i3, i4);
        }
    }

    public void oI(int i) {
        if (this.eKK != null) {
            this.eKK.setVisibility(i);
        }
    }

    public void oJ(int i) {
        if (this.eKP != null) {
            this.eKP.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.eKP, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(this.eKQ.agI().getId())) {
                am.setViewTextColor(this.eKF, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.eKF, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.eKM, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eKN, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eKO, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.eKJ, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.agI() != null) {
            this.eKQ = aVar;
            String str = null;
            if (aVar.agI().ajA()) {
                this.eKI.setVisibility(0);
                this.eKJ.setVisibility(0);
                if (aVar.agI().aiX() != null) {
                    this.eKJ.setText(aq.stringForVideoTime(aVar.agI().aiX().video_duration.intValue() * 1000));
                    str = aVar.agI().aiX().thumbnail_url;
                }
            } else {
                this.eKI.setVisibility(8);
                this.eKJ.setVisibility(4);
                if (aVar.agI().aiQ() != null && aVar.agI().aiQ().size() >= 1) {
                    str = aVar.agI().aiQ().get(0).origin_pic;
                }
            }
            this.eKH.startLoad(str, 10, false);
            this.eKF.setText(aVar.agI().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(aVar.agI().getId())) {
                am.setViewTextColor(this.eKF, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.eKF, (int) R.color.cp_cont_b);
            }
            this.eKL.setData(aVar.agI(), false);
            g(aVar.agI());
            this.eKN.setText(aq.getFormatTimeShort(aVar.agI().aiq()));
            if (AlaStaticKeys.ALA_STATIC_VALUE_GUIDE.equals(aVar.agI().aiv())) {
                this.eKO.setVisibility(0);
            } else {
                this.eKO.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eKO) {
            TiebaStatic.log(new an("c13047").O("obj_locate", 4).bS("fid", this.mForumId));
            FrsGameStrategyActivity.r(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aZX() != null) {
            aZX().a(getView(), this.eKQ);
        }
    }

    private void g(bh bhVar) {
        if (this.eKM != null && bhVar != null && !StringUtils.isNull(bhVar.aiG().getName_show())) {
            this.eKM.setText(oA(bhVar.aiG().getName_show()));
        }
    }

    protected String oA(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
