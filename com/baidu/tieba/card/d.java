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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes4.dex */
public class d extends a<com.baidu.tieba.e.a> {
    private LinearLayout evh;
    private TextView evi;
    private RelativeLayout evj;
    private TbImageView evk;
    private ImageView evl;
    private TextView evm;
    private RelativeLayout evn;
    private ClickableHeaderImageView evo;
    private TextView evp;
    private TextView evq;
    private TextView evr;
    private View evs;
    private com.baidu.tieba.e.a evt;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.evh = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.evi = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.evj = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.evk = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.evl = (ImageView) view.findViewById(R.id.img_play);
        this.evm = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.evn = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.evo = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.evp = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.evq = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.evr = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.evs = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.evk.setDefaultBgResource(R.drawable.icon_morenpic);
        this.evk.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aj(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evj.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.evj.setLayoutParams(layoutParams);
        this.evr.setOnClickListener(this);
        this.evo.setDefaultResource(17170445);
        this.evo.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.evo.setDefaultBgResource(R.color.cp_bg_line_e);
        this.evo.setIsRound(true);
        this.evo.setDrawBorder(true);
        this.evo.setBorderColor(al.getColor(R.color.common_color_10043));
        this.evo.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.evh != null) {
            this.evh.setPadding(i, i2, i3, i4);
        }
    }

    public void pk(int i) {
        if (this.evn != null) {
            this.evn.setVisibility(i);
        }
    }

    public void pl(int i) {
        if (this.evs != null) {
            this.evs.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.color.cp_bg_line_d);
            al.k(this.evs, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ei(this.evt.abv().getId())) {
                al.f(this.evi, R.color.cp_cont_c, 1);
            } else {
                al.f(this.evi, R.color.cp_cont_b, 1);
            }
            al.f(this.evp, R.color.cp_cont_d, 1);
            al.f(this.evq, R.color.cp_cont_d, 1);
            al.f(this.evr, R.color.cp_link_tip_c, 1);
            al.f(this.evm, R.color.cp_btn_a, 1);
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
        if (aVar != null && aVar.abv() != null) {
            this.evt = aVar;
            String str = null;
            if (aVar.abv().aep()) {
                this.evl.setVisibility(0);
                this.evm.setVisibility(0);
                if (aVar.abv().adM() != null) {
                    this.evm.setText(ap.im(aVar.abv().adM().video_duration.intValue() * 1000));
                    str = aVar.abv().adM().thumbnail_url;
                }
            } else {
                this.evl.setVisibility(8);
                this.evm.setVisibility(4);
                if (aVar.abv().adF() != null && aVar.abv().adF().size() >= 1) {
                    str = aVar.abv().adF().get(0).origin_pic;
                }
            }
            this.evk.startLoad(str, 10, false);
            this.evi.setText(aVar.abv().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ei(aVar.abv().getId())) {
                al.j(this.evi, R.color.cp_cont_c);
            } else {
                al.j(this.evi, R.color.cp_cont_b);
            }
            this.evo.setData(aVar.abv(), false);
            f(aVar.abv());
            this.evq.setText(ap.aE(aVar.abv().adf()));
            if ("guide".equals(aVar.abv().adk())) {
                this.evr.setVisibility(0);
            } else {
                this.evr.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.evr) {
            TiebaStatic.log(new am("c13047").P("obj_locate", 4).bT("fid", this.mForumId));
            FrsGameStrategyActivity.q(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aXr() != null) {
            aXr().a(getView(), this.evt);
        }
    }

    private void f(bg bgVar) {
        if (this.evp != null && bgVar != null && !StringUtils.isNull(bgVar.adv().getName_show())) {
            this.evp.setText(oD(bgVar.adv().getName_show()));
        }
    }

    protected String oD(String str) {
        return ap.j(str, 14, "...");
    }
}
