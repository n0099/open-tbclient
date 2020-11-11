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
    private LinearLayout hVP;
    private TextView hVQ;
    private RelativeLayout hVR;
    private TbImageView hVS;
    private ImageView hVT;
    private TextView hVU;
    private RelativeLayout hVV;
    private ClickableHeaderImageView hVW;
    private TextView hVX;
    private TextView hVY;
    private TextView hVZ;
    private View hWa;
    private com.baidu.tieba.e.a hWb;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.hVP = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hVQ = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.hVR = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hVS = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.hVT = (ImageView) view.findViewById(R.id.img_play);
        this.hVU = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.hVV = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.hVW = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hVX = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.hVY = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.hVZ = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.hWa = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hVS.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hVS.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hVR.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.hVR.setLayoutParams(layoutParams);
        this.hVZ.setOnClickListener(this);
        this.hVW.setDefaultResource(17170445);
        this.hVW.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hVW.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hVW.setIsRound(true);
        this.hVW.setDrawBorder(true);
        this.hVW.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hVW.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.hVP != null) {
            this.hVP.setPadding(i, i2, i3, i4);
        }
    }

    public void xc(int i) {
        if (this.hVV != null) {
            this.hVV.setVisibility(i);
        }
    }

    public void xd(int i) {
        if (this.hWa != null) {
            this.hWa.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hWa, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Tb(this.hWb.bjZ().getId())) {
                ap.setViewTextColor(this.hVQ, R.color.cp_cont_c, 1);
            } else {
                ap.setViewTextColor(this.hVQ, R.color.cp_cont_b, 1);
            }
            ap.setViewTextColor(this.hVX, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hVY, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hVZ, R.color.cp_link_tip_c, 1);
            ap.setViewTextColor(this.hVU, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.bjZ() != null) {
            this.hWb = aVar;
            String str = null;
            if (aVar.bjZ().blg()) {
                this.hVT.setVisibility(0);
                this.hVU.setVisibility(0);
                if (aVar.bjZ().bmS() != null) {
                    this.hVU.setText(at.stringForVideoTime(aVar.bjZ().bmS().video_duration.intValue() * 1000));
                    str = aVar.bjZ().bmS().thumbnail_url;
                }
            } else {
                this.hVT.setVisibility(8);
                this.hVU.setVisibility(4);
                if (aVar.bjZ().bmJ() != null && aVar.bjZ().bmJ().size() >= 1) {
                    str = aVar.bjZ().bmJ().get(0).origin_pic;
                }
            }
            this.hVS.startLoad(str, 10, false);
            this.hVQ.setText(aVar.bjZ().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Tb(aVar.bjZ().getId())) {
                ap.setViewTextColor(this.hVQ, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hVQ, (int) R.color.cp_cont_b);
            }
            this.hVW.setData(aVar.bjZ(), false);
            i(aVar.bjZ());
            this.hVY.setText(at.getFormatTimeShort(aVar.bjZ().bmj()));
            if ("guide".equals(aVar.bjZ().bmp())) {
                this.hVZ.setVisibility(0);
            } else {
                this.hVZ.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hVZ) {
            TiebaStatic.log(new aq("c13047").al("obj_locate", 4).dR("fid", this.mForumId));
            FrsGameStrategyActivity.v(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (cnT() != null) {
            cnT().a(getView(), this.hWb);
        }
    }

    private void i(bw bwVar) {
        if (this.hVX != null && bwVar != null && !StringUtils.isNull(bwVar.bmA().getName_show())) {
            this.hVX.setText(Cv(bwVar.bmA().getName_show()));
        }
    }

    protected String Cv(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
