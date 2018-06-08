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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes3.dex */
public class e extends a<com.baidu.tieba.e.a> {
    private LinearLayout cvS;
    private TextView cvT;
    private RelativeLayout cvU;
    private TbImageView cvV;
    private ImageView cvW;
    private TextView cvX;
    private RelativeLayout cvY;
    private ClickableHeaderImageView cvZ;
    private TextView cwa;
    private TextView cwb;
    private TextView cwc;
    private View cwd;
    private com.baidu.tieba.e.a cwe;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.cvS = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.cvT = (TextView) view.findViewById(d.g.card_frs_game_thread_title);
        this.cvU = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.cvV = (TbImageView) view.findViewById(d.g.card_frs_game_thread_bg);
        this.cvW = (ImageView) view.findViewById(d.g.img_play);
        this.cvX = (TextView) view.findViewById(d.g.card_frs_game_thread_video_time);
        this.cvY = (RelativeLayout) view.findViewById(d.g.card_frs_game_user_content);
        this.cvZ = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.cwa = (TextView) view.findViewById(d.g.card_frs_game_user_name);
        this.cwb = (TextView) view.findViewById(d.g.card_frs_game_thread_time);
        this.cwc = (TextView) view.findViewById(d.g.card_frs_game_thread_more_article);
        this.cwd = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.cvV.setDefaultBgResource(d.f.icon_morenpic);
        this.cvV.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.al(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(d.e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cvU.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cvU.setLayoutParams(layoutParams);
        this.cwc.setOnClickListener(this);
        this.cvZ.setDefaultResource(17170445);
        this.cvZ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cvZ.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cvZ.setIsRound(true);
        this.cvZ.setDrawBorder(true);
        this.cvZ.setBorderColor(al.getColor(d.C0141d.common_color_10043));
        this.cvZ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cvS != null) {
            this.cvS.setPadding(i, i2, i3, i4);
        }
    }

    public void iI(int i) {
        if (this.cvY != null) {
            this.cvY.setVisibility(i);
        }
    }

    public void iJ(int i) {
        if (this.cwd != null) {
            this.cwd.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.C0141d.cp_bg_line_d);
            al.i(this.cwd, d.C0141d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ua(this.cwe.Sz().getId())) {
                al.c(this.cvT, d.C0141d.cp_cont_c, 1);
            } else {
                al.c(this.cvT, d.C0141d.cp_cont_b, 1);
            }
            al.c(this.cwa, d.C0141d.cp_cont_d, 1);
            al.c(this.cwb, d.C0141d.cp_cont_d, 1);
            al.c(this.cwc, d.C0141d.cp_link_tip_c, 1);
            al.c(this.cvX, d.C0141d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.Sz() != null) {
            this.cwe = aVar;
            String str = null;
            if (aVar.Sz().vX()) {
                this.cvW.setVisibility(0);
                this.cvX.setVisibility(0);
                if (aVar.Sz().vD() != null) {
                    this.cvX.setText(ao.cX(aVar.Sz().vD().video_duration.intValue() * 1000));
                    str = aVar.Sz().vD().thumbnail_url;
                }
            } else {
                this.cvW.setVisibility(8);
                this.cvX.setVisibility(4);
                if (aVar.Sz().vw() != null && aVar.Sz().vw().size() >= 1) {
                    str = aVar.Sz().vw().get(0).origin_pic;
                }
            }
            this.cvV.startLoad(str, 10, false);
            this.cvT.setText(aVar.Sz().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ua(aVar.Sz().getId())) {
                al.h(this.cvT, d.C0141d.cp_cont_c);
            } else {
                al.h(this.cvT, d.C0141d.cp_cont_b);
            }
            this.cvZ.setData(aVar.Sz(), false);
            k(aVar.Sz());
            this.cwb.setText(ao.w(aVar.Sz().uY()));
            if ("guide".equals(aVar.Sz().vd())) {
                this.cwc.setVisibility(0);
            } else {
                this.cwc.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cwc) {
            TiebaStatic.log(new am("c13047").r("obj_locate", 4).ah(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.i(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aiI() != null) {
            aiI().a(getView(), this.cwe);
        }
    }

    private void k(bd bdVar) {
        if (this.cwa != null && bdVar != null && !StringUtils.isNull(bdVar.vm().getName_show())) {
            this.cwa.setText(fo(bdVar.vm().getName_show()));
        }
    }

    protected String fo(String str) {
        return ao.e(str, 14, "...");
    }
}
