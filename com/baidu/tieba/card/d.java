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
    private LinearLayout evg;
    private TextView evh;
    private RelativeLayout evi;
    private TbImageView evj;
    private ImageView evk;
    private TextView evl;
    private RelativeLayout evm;
    private ClickableHeaderImageView evn;
    private TextView evo;
    private TextView evp;
    private TextView evq;
    private View evr;
    private com.baidu.tieba.e.a evs;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.evg = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.evh = (TextView) view.findViewById(R.id.card_frs_game_thread_title);
        this.evi = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.evj = (TbImageView) view.findViewById(R.id.card_frs_game_thread_bg);
        this.evk = (ImageView) view.findViewById(R.id.img_play);
        this.evl = (TextView) view.findViewById(R.id.card_frs_game_thread_video_time);
        this.evm = (RelativeLayout) view.findViewById(R.id.card_frs_game_user_content);
        this.evn = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.evo = (TextView) view.findViewById(R.id.card_frs_game_user_name);
        this.evp = (TextView) view.findViewById(R.id.card_frs_game_thread_time);
        this.evq = (TextView) view.findViewById(R.id.card_frs_game_thread_more_article);
        this.evr = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.evj.setDefaultBgResource(R.drawable.icon_morenpic);
        this.evj.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aj(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.evi.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.evi.setLayoutParams(layoutParams);
        this.evq.setOnClickListener(this);
        this.evn.setDefaultResource(17170445);
        this.evn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.evn.setDefaultBgResource(R.color.cp_bg_line_e);
        this.evn.setIsRound(true);
        this.evn.setDrawBorder(true);
        this.evn.setBorderColor(al.getColor(R.color.common_color_10043));
        this.evn.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.evg != null) {
            this.evg.setPadding(i, i2, i3, i4);
        }
    }

    public void pk(int i) {
        if (this.evm != null) {
            this.evm.setVisibility(i);
        }
    }

    public void pl(int i) {
        if (this.evr != null) {
            this.evr.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.color.cp_bg_line_d);
            al.k(this.evr, R.color.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ei(this.evs.abv().getId())) {
                al.f(this.evh, R.color.cp_cont_c, 1);
            } else {
                al.f(this.evh, R.color.cp_cont_b, 1);
            }
            al.f(this.evo, R.color.cp_cont_d, 1);
            al.f(this.evp, R.color.cp_cont_d, 1);
            al.f(this.evq, R.color.cp_link_tip_c, 1);
            al.f(this.evl, R.color.cp_btn_a, 1);
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
            this.evs = aVar;
            String str = null;
            if (aVar.abv().aep()) {
                this.evk.setVisibility(0);
                this.evl.setVisibility(0);
                if (aVar.abv().adM() != null) {
                    this.evl.setText(ap.im(aVar.abv().adM().video_duration.intValue() * 1000));
                    str = aVar.abv().adM().thumbnail_url;
                }
            } else {
                this.evk.setVisibility(8);
                this.evl.setVisibility(4);
                if (aVar.abv().adF() != null && aVar.abv().adF().size() >= 1) {
                    str = aVar.abv().adF().get(0).origin_pic;
                }
            }
            this.evj.startLoad(str, 10, false);
            this.evh.setText(aVar.abv().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ei(aVar.abv().getId())) {
                al.j(this.evh, R.color.cp_cont_c);
            } else {
                al.j(this.evh, R.color.cp_cont_b);
            }
            this.evn.setData(aVar.abv(), false);
            f(aVar.abv());
            this.evp.setText(ap.aE(aVar.abv().adf()));
            if ("guide".equals(aVar.abv().adk())) {
                this.evq.setVisibility(0);
            } else {
                this.evq.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.evq) {
            TiebaStatic.log(new am("c13047").P("obj_locate", 4).bT("fid", this.mForumId));
            FrsGameStrategyActivity.q(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aXo() != null) {
            aXo().a(getView(), this.evs);
        }
    }

    private void f(bg bgVar) {
        if (this.evo != null && bgVar != null && !StringUtils.isNull(bgVar.adv().getName_show())) {
            this.evo.setText(oD(bgVar.adv().getName_show()));
        }
    }

    protected String oD(String str) {
        return ap.j(str, 14, "...");
    }
}
