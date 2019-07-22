package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
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
    private LinearLayout eAg;
    private TextView eAh;
    private RelativeLayout eAi;
    private TbImageView eAj;
    private ImageView eAk;
    private TextView eAl;
    private RelativeLayout eAm;
    private ClickableHeaderImageView eAn;
    private TextView eAo;
    private TextView eAp;
    private TextView eAq;
    private View eAr;
    private com.baidu.tieba.e.a eAs;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.eAg = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.eAh = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.eAi = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eAj = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.eAk = (ImageView) view.findViewById(R.id.img_play);
        this.eAl = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.eAm = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.eAn = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.eAo = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.eAp = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.eAq = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.eAr = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eAj.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eAj.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aj(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eAi.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.eAi.setLayoutParams(layoutParams);
        this.eAq.setOnClickListener(this);
        this.eAn.setDefaultResource(17170445);
        this.eAn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eAn.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eAn.setIsRound(true);
        this.eAn.setDrawBorder(true);
        this.eAn.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eAn.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.eAg != null) {
            this.eAg.setPadding(i, i2, i3, i4);
        }
    }

    public void pB(int i) {
        if (this.eAm != null) {
            this.eAm.setVisibility(i);
        }
    }

    public void pC(int i) {
        if (this.eAr != null) {
            this.eAr.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.color.cp_bg_line_d);
            am.k(this.eAr, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.EX(this.eAs.acx().getId())) {
                am.f(this.eAh, R.color.cp_cont_c, 1);
            } else {
                am.f(this.eAh, R.color.cp_cont_b, 1);
            }
            am.f(this.eAo, R.color.cp_cont_d, 1);
            am.f(this.eAp, R.color.cp_cont_d, 1);
            am.f(this.eAq, R.color.cp_link_tip_c, 1);
            am.f(this.eAl, R.color.cp_btn_a, 1);
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
        if (aVar != null && aVar.acx() != null) {
            this.eAs = aVar;
            String str = null;
            if (aVar.acx().afr()) {
                this.eAk.setVisibility(0);
                this.eAl.setVisibility(0);
                if (aVar.acx().aeO() != null) {
                    this.eAl.setText(aq.is(aVar.acx().aeO().video_duration.intValue() * 1000));
                    str = aVar.acx().aeO().thumbnail_url;
                }
            } else {
                this.eAk.setVisibility(8);
                this.eAl.setVisibility(4);
                if (aVar.acx().aeH() != null && aVar.acx().aeH().size() >= 1) {
                    str = aVar.acx().aeH().get(0).origin_pic;
                }
            }
            this.eAj.startLoad(str, 10, false);
            this.eAh.setText(aVar.acx().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.EX(aVar.acx().getId())) {
                am.j(this.eAh, R.color.cp_cont_c);
            } else {
                am.j(this.eAh, R.color.cp_cont_b);
            }
            this.eAn.setData(aVar.acx(), false);
            f(aVar.acx());
            this.eAp.setText(aq.aF(aVar.acx().aeh()));
            if ("guide".equals(aVar.acx().aem())) {
                this.eAq.setVisibility(0);
            } else {
                this.eAq.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eAq) {
            TiebaStatic.log(new an("c13047").P("obj_locate", 4).bT("fid", this.mForumId));
            FrsGameStrategyActivity.q(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aZo() != null) {
            aZo().a(getView(), this.eAs);
        }
    }

    private void f(bg bgVar) {
        if (this.eAo != null && bgVar != null && !StringUtils.isNull(bgVar.aex().getName_show())) {
            this.eAo.setText(oT(bgVar.aex().getName_show()));
        }
    }

    protected String oT(String str) {
        return aq.j(str, 14, "...");
    }
}
