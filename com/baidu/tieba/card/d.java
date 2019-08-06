package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
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
    private LinearLayout eAn;
    private TextView eAo;
    private RelativeLayout eAp;
    private TbImageView eAq;
    private ImageView eAr;
    private TextView eAs;
    private RelativeLayout eAt;
    private ClickableHeaderImageView eAu;
    private TextView eAv;
    private TextView eAw;
    private TextView eAx;
    private View eAy;
    private com.baidu.tieba.e.a eAz;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.eAn = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.eAo = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.eAp = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eAq = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.eAr = (ImageView) view.findViewById(R.id.img_play);
        this.eAs = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.eAt = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.eAu = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.eAv = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.eAw = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.eAx = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.eAy = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eAq.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eAq.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aj(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eAp.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.eAp.setLayoutParams(layoutParams);
        this.eAx.setOnClickListener(this);
        this.eAu.setDefaultResource(17170445);
        this.eAu.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eAu.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eAu.setIsRound(true);
        this.eAu.setDrawBorder(true);
        this.eAu.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eAu.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.eAn != null) {
            this.eAn.setPadding(i, i2, i3, i4);
        }
    }

    public void pC(int i) {
        if (this.eAt != null) {
            this.eAt.setVisibility(i);
        }
    }

    public void pD(int i) {
        if (this.eAy != null) {
            this.eAy.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.color.cp_bg_line_d);
            am.k(this.eAy, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.EY(this.eAz.acy().getId())) {
                am.f(this.eAo, R.color.cp_cont_c, 1);
            } else {
                am.f(this.eAo, R.color.cp_cont_b, 1);
            }
            am.f(this.eAv, R.color.cp_cont_d, 1);
            am.f(this.eAw, R.color.cp_cont_d, 1);
            am.f(this.eAx, R.color.cp_link_tip_c, 1);
            am.f(this.eAs, R.color.cp_btn_a, 1);
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
        if (aVar != null && aVar.acy() != null) {
            this.eAz = aVar;
            String str = null;
            if (aVar.acy().afs()) {
                this.eAr.setVisibility(0);
                this.eAs.setVisibility(0);
                if (aVar.acy().aeP() != null) {
                    this.eAs.setText(aq.is(aVar.acy().aeP().video_duration.intValue() * 1000));
                    str = aVar.acy().aeP().thumbnail_url;
                }
            } else {
                this.eAr.setVisibility(8);
                this.eAs.setVisibility(4);
                if (aVar.acy().aeI() != null && aVar.acy().aeI().size() >= 1) {
                    str = aVar.acy().aeI().get(0).origin_pic;
                }
            }
            this.eAq.startLoad(str, 10, false);
            this.eAo.setText(aVar.acy().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.EY(aVar.acy().getId())) {
                am.j(this.eAo, R.color.cp_cont_c);
            } else {
                am.j(this.eAo, R.color.cp_cont_b);
            }
            this.eAu.setData(aVar.acy(), false);
            f(aVar.acy());
            this.eAw.setText(aq.aF(aVar.acy().aei()));
            if ("guide".equals(aVar.acy().aen())) {
                this.eAx.setVisibility(0);
            } else {
                this.eAx.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eAx) {
            TiebaStatic.log(new an("c13047").P("obj_locate", 4).bT("fid", this.mForumId));
            FrsGameStrategyActivity.q(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aZq() != null) {
            aZq().a(getView(), this.eAz);
        }
    }

    private void f(bh bhVar) {
        if (this.eAv != null && bhVar != null && !StringUtils.isNull(bhVar.aey().getName_show())) {
            this.eAv.setText(oT(bhVar.aey().getName_show()));
        }
    }

    protected String oT(String str) {
        return aq.j(str, 14, "...");
    }
}
