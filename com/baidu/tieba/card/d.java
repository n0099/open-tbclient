package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes4.dex */
public class d extends a<com.baidu.tieba.e.a> {
    private TextView efA;
    private TextView efB;
    private TextView efC;
    private View efD;
    private com.baidu.tieba.e.a efE;
    private LinearLayout efs;
    private TextView eft;
    private RelativeLayout efu;
    private TbImageView efv;
    private ImageView efw;
    private TextView efx;
    private RelativeLayout efy;
    private ClickableHeaderImageView efz;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.efs = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.eft = (TextView) view.findViewById(d.g.card_frs_game_thread_title);
        this.efu = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.efv = (TbImageView) view.findViewById(d.g.card_frs_game_thread_bg);
        this.efw = (ImageView) view.findViewById(d.g.img_play);
        this.efx = (TextView) view.findViewById(d.g.card_frs_game_thread_video_time);
        this.efy = (RelativeLayout) view.findViewById(d.g.card_frs_game_user_content);
        this.efz = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.efA = (TextView) view.findViewById(d.g.card_frs_game_user_name);
        this.efB = (TextView) view.findViewById(d.g.card_frs_game_thread_time);
        this.efC = (TextView) view.findViewById(d.g.card_frs_game_thread_more_article);
        this.efD = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.efv.setDefaultBgResource(d.f.icon_morenpic);
        this.efv.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aS(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(d.e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.efu.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.efu.setLayoutParams(layoutParams);
        this.efC.setOnClickListener(this);
        this.efz.setDefaultResource(17170445);
        this.efz.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.efz.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.efz.setIsRound(true);
        this.efz.setDrawBorder(true);
        this.efz.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efz.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.efs != null) {
            this.efs.setPadding(i, i2, i3, i4);
        }
    }

    public void oh(int i) {
        if (this.efy != null) {
            this.efy.setVisibility(i);
        }
    }

    public void oi(int i) {
        if (this.efD != null) {
            this.efD.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.C0277d.cp_bg_line_d);
            al.k(this.efD, d.C0277d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CM(this.efE.WO().getId())) {
                al.d(this.eft, d.C0277d.cp_cont_c, 1);
            } else {
                al.d(this.eft, d.C0277d.cp_cont_b, 1);
            }
            al.d(this.efA, d.C0277d.cp_cont_d, 1);
            al.d(this.efB, d.C0277d.cp_cont_d, 1);
            al.d(this.efC, d.C0277d.cp_link_tip_c, 1);
            al.d(this.efx, d.C0277d.cp_btn_a, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.WO() != null) {
            this.efE = aVar;
            String str = null;
            if (aVar.WO().ZI()) {
                this.efw.setVisibility(0);
                this.efx.setVisibility(0);
                if (aVar.WO().Zf() != null) {
                    this.efx.setText(ap.hy(aVar.WO().Zf().video_duration.intValue() * 1000));
                    str = aVar.WO().Zf().thumbnail_url;
                }
            } else {
                this.efw.setVisibility(8);
                this.efx.setVisibility(4);
                if (aVar.WO().YY() != null && aVar.WO().YY().size() >= 1) {
                    str = aVar.WO().YY().get(0).origin_pic;
                }
            }
            this.efv.startLoad(str, 10, false);
            this.eft.setText(aVar.WO().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CM(aVar.WO().getId())) {
                al.j(this.eft, d.C0277d.cp_cont_c);
            } else {
                al.j(this.eft, d.C0277d.cp_cont_b);
            }
            this.efz.setData(aVar.WO(), false);
            f(aVar.WO());
            this.efB.setText(ap.aq(aVar.WO().Yy()));
            if ("guide".equals(aVar.WO().YD())) {
                this.efC.setVisibility(0);
            } else {
                this.efC.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.efC) {
            TiebaStatic.log(new am("c13047").T("obj_locate", 4).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.n(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aQf() != null) {
            aQf().a(getView(), this.efE);
        }
    }

    private void f(bg bgVar) {
        if (this.efA != null && bgVar != null && !StringUtils.isNull(bgVar.YO().getName_show())) {
            this.efA.setText(nt(bgVar.YO().getName_show()));
        }
    }

    protected String nt(String str) {
        return ap.g(str, 14, "...");
    }
}
