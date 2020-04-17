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
/* loaded from: classes9.dex */
public class d extends a<com.baidu.tieba.e.a> {
    private LinearLayout gmV;
    private TextView gmW;
    private RelativeLayout gmX;
    private TbImageView gmY;
    private ImageView gmZ;
    private TextView gna;
    private RelativeLayout gnb;
    private ClickableHeaderImageView gnc;
    private TextView gnd;
    private TextView gne;
    private TextView gnf;
    private View gng;
    private com.baidu.tieba.e.a gnh;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.gmV = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gmW = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.gmX = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.gmY = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.gmZ = (ImageView) view.findViewById(R.id.img_play);
        this.gna = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.gnb = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.gnc = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gnd = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.gne = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.gnf = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.gng = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.gmY.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gmY.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmX.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.gmX.setLayoutParams(layoutParams);
        this.gnf.setOnClickListener(this);
        this.gnc.setDefaultResource(17170445);
        this.gnc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gnc.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gnc.setIsRound(true);
        this.gnc.setDrawBorder(true);
        this.gnc.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gnc.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void v(int i, int i2, int i3, int i4) {
        if (this.gmV != null) {
            this.gmV.setPadding(i, i2, i3, i4);
        }
    }

    public void rG(int i) {
        if (this.gnb != null) {
            this.gnb.setVisibility(i);
        }
    }

    public void rH(int i) {
        if (this.gng != null) {
            this.gng.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.gng, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.KY(this.gnh.aIw().getId())) {
                am.setViewTextColor(this.gmW, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.gmW, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.gnd, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gne, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gnf, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.gna, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.aIw() != null) {
            this.gnh = aVar;
            String str = null;
            if (aVar.aIw().aJr()) {
                this.gmZ.setVisibility(0);
                this.gna.setVisibility(0);
                if (aVar.aIw().aKV() != null) {
                    this.gna.setText(aq.stringForVideoTime(aVar.aIw().aKV().video_duration.intValue() * 1000));
                    str = aVar.aIw().aKV().thumbnail_url;
                }
            } else {
                this.gmZ.setVisibility(8);
                this.gna.setVisibility(4);
                if (aVar.aIw().aKO() != null && aVar.aIw().aKO().size() >= 1) {
                    str = aVar.aIw().aKO().get(0).origin_pic;
                }
            }
            this.gmY.startLoad(str, 10, false);
            this.gmW.setText(aVar.aIw().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.KY(aVar.aIw().getId())) {
                am.setViewTextColor(this.gmW, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gmW, (int) R.color.cp_cont_b);
            }
            this.gnc.setData(aVar.aIw(), false);
            h(aVar.aIw());
            this.gne.setText(aq.getFormatTimeShort(aVar.aIw().aKn()));
            if ("guide".equals(aVar.aIw().aKt())) {
                this.gnf.setVisibility(0);
            } else {
                this.gnf.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gnf) {
            TiebaStatic.log(new an("c13047").af("obj_locate", 4).cI("fid", this.mForumId));
            FrsGameStrategyActivity.s(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (bEy() != null) {
            bEy().a(getView(), this.gnh);
        }
    }

    private void h(bj bjVar) {
        if (this.gnd != null && bjVar != null && !StringUtils.isNull(bjVar.aKE().getName_show())) {
            this.gnd.setText(vm(bjVar.aKE().getName_show()));
        }
    }

    protected String vm(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
