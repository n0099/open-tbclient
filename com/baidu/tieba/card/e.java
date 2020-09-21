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
/* loaded from: classes21.dex */
public class e extends b<com.baidu.tieba.e.a> {
    private LinearLayout hoC;
    private TextView hoD;
    private RelativeLayout hoE;
    private TbImageView hoF;
    private ImageView hoG;
    private TextView hoH;
    private RelativeLayout hoI;
    private ClickableHeaderImageView hoJ;
    private TextView hoK;
    private TextView hoL;
    private TextView hoM;
    private View hoN;
    private com.baidu.tieba.e.a hoO;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.hoC = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hoD = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.hoE = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hoF = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.hoG = (ImageView) view.findViewById(R.id.img_play);
        this.hoH = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.hoI = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.hoJ = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hoK = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.hoL = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.hoM = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.hoN = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hoF.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hoF.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hoE.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.hoE.setLayoutParams(layoutParams);
        this.hoM.setOnClickListener(this);
        this.hoJ.setDefaultResource(17170445);
        this.hoJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hoJ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hoJ.setIsRound(true);
        this.hoJ.setDrawBorder(true);
        this.hoJ.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hoJ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.hoC != null) {
            this.hoC.setPadding(i, i2, i3, i4);
        }
    }

    public void vQ(int i) {
        if (this.hoI != null) {
            this.hoI.setVisibility(i);
        }
    }

    public void vR(int i) {
        if (this.hoN != null) {
            this.hoN.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hoN, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Rx(this.hoO.bcY().getId())) {
                ap.setViewTextColor(this.hoD, R.color.cp_cont_c, 1);
            } else {
                ap.setViewTextColor(this.hoD, R.color.cp_cont_b, 1);
            }
            ap.setViewTextColor(this.hoK, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hoL, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hoM, R.color.cp_link_tip_c, 1);
            ap.setViewTextColor(this.hoH, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.bcY() != null) {
            this.hoO = aVar;
            String str = null;
            if (aVar.bcY().bee()) {
                this.hoG.setVisibility(0);
                this.hoH.setVisibility(0);
                if (aVar.bcY().bfQ() != null) {
                    this.hoH.setText(at.stringForVideoTime(aVar.bcY().bfQ().video_duration.intValue() * 1000));
                    str = aVar.bcY().bfQ().thumbnail_url;
                }
            } else {
                this.hoG.setVisibility(8);
                this.hoH.setVisibility(4);
                if (aVar.bcY().bfH() != null && aVar.bcY().bfH().size() >= 1) {
                    str = aVar.bcY().bfH().get(0).origin_pic;
                }
            }
            this.hoF.startLoad(str, 10, false);
            this.hoD.setText(aVar.bcY().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Rx(aVar.bcY().getId())) {
                ap.setViewTextColor(this.hoD, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hoD, (int) R.color.cp_cont_b);
            }
            this.hoJ.setData(aVar.bcY(), false);
            i(aVar.bcY());
            this.hoL.setText(at.getFormatTimeShort(aVar.bcY().bfh()));
            if ("guide".equals(aVar.bcY().bfn())) {
                this.hoM.setVisibility(0);
            } else {
                this.hoM.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hoM) {
            TiebaStatic.log(new aq("c13047").ai("obj_locate", 4).dF("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (ceP() != null) {
            ceP().a(getView(), this.hoO);
        }
    }

    private void i(bw bwVar) {
        if (this.hoK != null && bwVar != null && !StringUtils.isNull(bwVar.bfy().getName_show())) {
            this.hoK.setText(Bc(bwVar.bfy().getName_show()));
        }
    }

    protected String Bc(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
