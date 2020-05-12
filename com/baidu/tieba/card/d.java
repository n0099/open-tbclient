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
    private LinearLayout gnb;
    private TextView gnc;
    private RelativeLayout gnd;
    private TbImageView gne;
    private ImageView gnf;
    private TextView gng;
    private RelativeLayout gnh;
    private ClickableHeaderImageView gni;
    private TextView gnj;
    private TextView gnk;
    private TextView gnl;
    private View gnm;
    private com.baidu.tieba.e.a gnn;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.gnb = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gnc = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.gnd = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.gne = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.gnf = (ImageView) view.findViewById(R.id.img_play);
        this.gng = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.gnh = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.gni = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gnj = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.gnk = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.gnl = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.gnm = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.gne.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gne.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.getScreenDimensions(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnd.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.gnd.setLayoutParams(layoutParams);
        this.gnl.setOnClickListener(this);
        this.gni.setDefaultResource(17170445);
        this.gni.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gni.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gni.setIsRound(true);
        this.gni.setDrawBorder(true);
        this.gni.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gni.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void v(int i, int i2, int i3, int i4) {
        if (this.gnb != null) {
            this.gnb.setPadding(i, i2, i3, i4);
        }
    }

    public void rG(int i) {
        if (this.gnh != null) {
            this.gnh.setVisibility(i);
        }
    }

    public void rH(int i) {
        if (this.gnm != null) {
            this.gnm.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.gnm, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Lb(this.gnn.aIu().getId())) {
                am.setViewTextColor(this.gnc, R.color.cp_cont_c, 1);
            } else {
                am.setViewTextColor(this.gnc, R.color.cp_cont_b, 1);
            }
            am.setViewTextColor(this.gnj, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gnk, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gnl, R.color.cp_link_tip_c, 1);
            am.setViewTextColor(this.gng, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.aIu() != null) {
            this.gnn = aVar;
            String str = null;
            if (aVar.aIu().aJp()) {
                this.gnf.setVisibility(0);
                this.gng.setVisibility(0);
                if (aVar.aIu().aKT() != null) {
                    this.gng.setText(aq.stringForVideoTime(aVar.aIu().aKT().video_duration.intValue() * 1000));
                    str = aVar.aIu().aKT().thumbnail_url;
                }
            } else {
                this.gnf.setVisibility(8);
                this.gng.setVisibility(4);
                if (aVar.aIu().aKM() != null && aVar.aIu().aKM().size() >= 1) {
                    str = aVar.aIu().aKM().get(0).origin_pic;
                }
            }
            this.gne.startLoad(str, 10, false);
            this.gnc.setText(aVar.aIu().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Lb(aVar.aIu().getId())) {
                am.setViewTextColor(this.gnc, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gnc, (int) R.color.cp_cont_b);
            }
            this.gni.setData(aVar.aIu(), false);
            h(aVar.aIu());
            this.gnk.setText(aq.getFormatTimeShort(aVar.aIu().aKl()));
            if ("guide".equals(aVar.aIu().aKr())) {
                this.gnl.setVisibility(0);
            } else {
                this.gnl.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gnl) {
            TiebaStatic.log(new an("c13047").af("obj_locate", 4).cI("fid", this.mForumId));
            FrsGameStrategyActivity.u(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (bEx() != null) {
            bEx().a(getView(), this.gnn);
        }
    }

    private void h(bj bjVar) {
        if (this.gnj != null && bjVar != null && !StringUtils.isNull(bjVar.aKC().getName_show())) {
            this.gnj.setText(vp(bjVar.aKC().getName_show()));
        }
    }

    protected String vp(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }
}
