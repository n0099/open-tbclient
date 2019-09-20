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
    private LinearLayout eBW;
    private TextView eBX;
    private RelativeLayout eBY;
    private TbImageView eBZ;
    private ImageView eCa;
    private TextView eCb;
    private RelativeLayout eCc;
    private ClickableHeaderImageView eCd;
    private TextView eCe;
    private TextView eCf;
    private TextView eCg;
    private View eCh;
    private com.baidu.tieba.e.a eCi;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.eBW = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.eBX = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.eBY = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eBZ = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.eCa = (ImageView) view.findViewById(R.id.img_play);
        this.eCb = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.eCc = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.eCd = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.eCe = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.eCf = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.eCg = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.eCh = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eBZ.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eBZ.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aj(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eBY.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.eBY.setLayoutParams(layoutParams);
        this.eCg.setOnClickListener(this);
        this.eCd.setDefaultResource(17170445);
        this.eCd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eCd.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eCd.setIsRound(true);
        this.eCd.setDrawBorder(true);
        this.eCd.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eCd.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void u(int i, int i2, int i3, int i4) {
        if (this.eBW != null) {
            this.eBW.setPadding(i, i2, i3, i4);
        }
    }

    public void pG(int i) {
        if (this.eCc != null) {
            this.eCc.setVisibility(i);
        }
    }

    public void pH(int i) {
        if (this.eCh != null) {
            this.eCh.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.color.cp_bg_line_d);
            am.k(this.eCh, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Fy(this.eCi.acC().getId())) {
                am.f(this.eBX, R.color.cp_cont_c, 1);
            } else {
                am.f(this.eBX, R.color.cp_cont_b, 1);
            }
            am.f(this.eCe, R.color.cp_cont_d, 1);
            am.f(this.eCf, R.color.cp_cont_d, 1);
            am.f(this.eCg, R.color.cp_link_tip_c, 1);
            am.f(this.eCb, R.color.cp_cont_a, 1);
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
        if (aVar != null && aVar.acC() != null) {
            this.eCi = aVar;
            String str = null;
            if (aVar.acC().afw()) {
                this.eCa.setVisibility(0);
                this.eCb.setVisibility(0);
                if (aVar.acC().aeT() != null) {
                    this.eCb.setText(aq.it(aVar.acC().aeT().video_duration.intValue() * 1000));
                    str = aVar.acC().aeT().thumbnail_url;
                }
            } else {
                this.eCa.setVisibility(8);
                this.eCb.setVisibility(4);
                if (aVar.acC().aeM() != null && aVar.acC().aeM().size() >= 1) {
                    str = aVar.acC().aeM().get(0).origin_pic;
                }
            }
            this.eBZ.startLoad(str, 10, false);
            this.eBX.setText(aVar.acC().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Fy(aVar.acC().getId())) {
                am.j(this.eBX, R.color.cp_cont_c);
            } else {
                am.j(this.eBX, R.color.cp_cont_b);
            }
            this.eCd.setData(aVar.acC(), false);
            g(aVar.acC());
            this.eCf.setText(aq.aF(aVar.acC().aem()));
            if ("guide".equals(aVar.acC().aer())) {
                this.eCg.setVisibility(0);
            } else {
                this.eCg.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eCg) {
            TiebaStatic.log(new an("c13047").P("obj_locate", 4).bT("fid", this.mForumId));
            FrsGameStrategyActivity.q(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aZU() != null) {
            aZU().a(getView(), this.eCi);
        }
    }

    private void g(bh bhVar) {
        if (this.eCe != null && bhVar != null && !StringUtils.isNull(bhVar.aeC().getName_show())) {
            this.eCe.setText(pb(bhVar.aeC().getName_show()));
        }
    }

    protected String pb(String str) {
        return aq.j(str, 14, "...");
    }
}
