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
    private ClickableHeaderImageView efA;
    private TextView efB;
    private TextView efC;
    private TextView efD;
    private View efE;
    private com.baidu.tieba.e.a efF;
    private LinearLayout eft;
    private TextView efu;
    private RelativeLayout efv;
    private TbImageView efw;
    private ImageView efx;
    private TextView efy;
    private RelativeLayout efz;
    private String mForumId;
    private String mForumName;

    public d(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.eft = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.efu = (TextView) view.findViewById(d.g.card_frs_game_thread_title);
        this.efv = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.efw = (TbImageView) view.findViewById(d.g.card_frs_game_thread_bg);
        this.efx = (ImageView) view.findViewById(d.g.img_play);
        this.efy = (TextView) view.findViewById(d.g.card_frs_game_thread_video_time);
        this.efz = (RelativeLayout) view.findViewById(d.g.card_frs_game_user_content);
        this.efA = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.efB = (TextView) view.findViewById(d.g.card_frs_game_user_name);
        this.efC = (TextView) view.findViewById(d.g.card_frs_game_thread_time);
        this.efD = (TextView) view.findViewById(d.g.card_frs_game_thread_more_article);
        this.efE = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.efw.setDefaultBgResource(d.f.icon_morenpic);
        this.efw.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aS(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(d.e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.efv.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.efv.setLayoutParams(layoutParams);
        this.efD.setOnClickListener(this);
        this.efA.setDefaultResource(17170445);
        this.efA.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.efA.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.efA.setIsRound(true);
        this.efA.setDrawBorder(true);
        this.efA.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efA.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.eft != null) {
            this.eft.setPadding(i, i2, i3, i4);
        }
    }

    public void oh(int i) {
        if (this.efz != null) {
            this.efz.setVisibility(i);
        }
    }

    public void oi(int i) {
        if (this.efE != null) {
            this.efE.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.C0277d.cp_bg_line_d);
            al.k(this.efE, d.C0277d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CM(this.efF.WO().getId())) {
                al.d(this.efu, d.C0277d.cp_cont_c, 1);
            } else {
                al.d(this.efu, d.C0277d.cp_cont_b, 1);
            }
            al.d(this.efB, d.C0277d.cp_cont_d, 1);
            al.d(this.efC, d.C0277d.cp_cont_d, 1);
            al.d(this.efD, d.C0277d.cp_link_tip_c, 1);
            al.d(this.efy, d.C0277d.cp_btn_a, 1);
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
            this.efF = aVar;
            String str = null;
            if (aVar.WO().ZI()) {
                this.efx.setVisibility(0);
                this.efy.setVisibility(0);
                if (aVar.WO().Zf() != null) {
                    this.efy.setText(ap.hy(aVar.WO().Zf().video_duration.intValue() * 1000));
                    str = aVar.WO().Zf().thumbnail_url;
                }
            } else {
                this.efx.setVisibility(8);
                this.efy.setVisibility(4);
                if (aVar.WO().YY() != null && aVar.WO().YY().size() >= 1) {
                    str = aVar.WO().YY().get(0).origin_pic;
                }
            }
            this.efw.startLoad(str, 10, false);
            this.efu.setText(aVar.WO().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CM(aVar.WO().getId())) {
                al.j(this.efu, d.C0277d.cp_cont_c);
            } else {
                al.j(this.efu, d.C0277d.cp_cont_b);
            }
            this.efA.setData(aVar.WO(), false);
            f(aVar.WO());
            this.efC.setText(ap.aq(aVar.WO().Yy()));
            if ("guide".equals(aVar.WO().YD())) {
                this.efD.setVisibility(0);
            } else {
                this.efD.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.efD) {
            TiebaStatic.log(new am("c13047").T("obj_locate", 4).bJ(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.n(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aQf() != null) {
            aQf().a(getView(), this.efF);
        }
    }

    private void f(bg bgVar) {
        if (this.efB != null && bgVar != null && !StringUtils.isNull(bgVar.YO().getName_show())) {
            this.efB.setText(nt(bgVar.YO().getName_show()));
        }
    }

    protected String nt(String str) {
        return ap.g(str, 14, "...");
    }
}
