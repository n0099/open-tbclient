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
    private LinearLayout eJN;
    private TextView eJO;
    private RelativeLayout eJP;
    private TbImageView eJQ;
    private ImageView eJR;
    private TextView eJS;
    private RelativeLayout eJT;
    private ClickableHeaderImageView eJU;
    private TextView eJV;
    private TextView eJW;
    private TextView eJX;
    private View eJY;
    private com.baidu.tieba.e.a eJZ;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.eJN = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.eJO = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.eJP = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eJQ = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.eJR = (ImageView) view.findViewById(R.id.img_play);
        this.eJS = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.eJT = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.eJU = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.eJV = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.eJW = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.eJX = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.eJY = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eJQ.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eJQ.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJP.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.eJP.setLayoutParams(layoutParams);
        this.eJX.setOnClickListener(this);
        this.eJU.setDefaultResource(17170445);
        this.eJU.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eJU.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eJU.setIsRound(true);
        this.eJU.setDrawBorder(true);
        this.eJU.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eJU.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.eJN != null) {
            this.eJN.setPadding(i, i2, i3, i4);
        }
    }

    public void oH(int i) {
        if (this.eJT != null) {
            this.eJT.setVisibility(i);
        }
    }

    public void oI(int i) {
        if (this.eJY != null) {
            this.eJY.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.eJY, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(this.eJZ.agG().getId())) {
                am.setViewTextColor(this.eJO, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.eJO, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.eJV, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eJW, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eJX, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.eJS, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.agG() != null) {
            this.eJZ = aVar;
            String str = null;
            if (aVar.agG().ajy()) {
                this.eJR.setVisibility(0);
                this.eJS.setVisibility(0);
                if (aVar.agG().aiV() != null) {
                    this.eJS.setText(aq.stringForVideoTime(aVar.agG().aiV().video_duration.intValue() * 1000));
                    str = aVar.agG().aiV().thumbnail_url;
                }
            } else {
                this.eJR.setVisibility(8);
                this.eJS.setVisibility(4);
                if (aVar.agG().aiO() != null && aVar.agG().aiO().size() >= 1) {
                    str = aVar.agG().aiO().get(0).origin_pic;
                }
            }
            this.eJQ.startLoad(str, 10, false);
            this.eJO.setText(aVar.agG().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(aVar.agG().getId())) {
                am.setViewTextColor(this.eJO, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.eJO, (int) R.color.cp_cont_b);
            }
            this.eJU.setData(aVar.agG(), false);
            g(aVar.agG());
            this.eJW.setText(aq.getFormatTimeShort(aVar.agG().aio()));
            if (AlaStaticKeys.ALA_STATIC_VALUE_GUIDE.equals(aVar.agG().ait())) {
                this.eJX.setVisibility(0);
            } else {
                this.eJX.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eJX) {
            TiebaStatic.log(new an("c13047").O("obj_locate", 4).bS("fid", this.mForumId));
            FrsGameStrategyActivity.r(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aZV() != null) {
            aZV().a(getView(), this.eJZ);
        }
    }

    private void g(bh bhVar) {
        if (this.eJV != null && bhVar != null && !StringUtils.isNull(bhVar.aiE().getName_show())) {
            this.eJV.setText(oA(bhVar.aiE().getName_show()));
        }
    }

    protected String oA(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
