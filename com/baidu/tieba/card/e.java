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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes3.dex */
public class e extends a<com.baidu.tieba.e.a> {
    private LinearLayout cKJ;
    private TextView cKK;
    private RelativeLayout cKL;
    private TbImageView cKM;
    private ImageView cKN;
    private TextView cKO;
    private RelativeLayout cKP;
    private ClickableHeaderImageView cKQ;
    private TextView cKR;
    private TextView cKS;
    private TextView cKT;
    private View cKU;
    private com.baidu.tieba.e.a cKV;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.cKJ = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cKK = (TextView) view.findViewById(e.g.card_frs_game_thread_title);
        this.cKL = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.cKM = (TbImageView) view.findViewById(e.g.card_frs_game_thread_bg);
        this.cKN = (ImageView) view.findViewById(e.g.img_play);
        this.cKO = (TextView) view.findViewById(e.g.card_frs_game_thread_video_time);
        this.cKP = (RelativeLayout) view.findViewById(e.g.card_frs_game_user_content);
        this.cKQ = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cKR = (TextView) view.findViewById(e.g.card_frs_game_user_name);
        this.cKS = (TextView) view.findViewById(e.g.card_frs_game_thread_time);
        this.cKT = (TextView) view.findViewById(e.g.card_frs_game_thread_more_article);
        this.cKU = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.cKM.setDefaultBgResource(e.f.icon_morenpic);
        this.cKM.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aS(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cKL.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cKL.setLayoutParams(layoutParams);
        this.cKT.setOnClickListener(this);
        this.cKQ.setDefaultResource(17170445);
        this.cKQ.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cKQ.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cKQ.setIsRound(true);
        this.cKQ.setDrawBorder(true);
        this.cKQ.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cKQ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cKJ != null) {
            this.cKJ.setPadding(i, i2, i3, i4);
        }
    }

    public void jN(int i) {
        if (this.cKP != null) {
            this.cKP.setVisibility(i);
        }
    }

    public void jO(int i) {
        if (this.cKU != null) {
            this.cKU.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cKU, e.d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vl(this.cKV.YB().getId())) {
                al.c(this.cKK, e.d.cp_cont_c, 1);
            } else {
                al.c(this.cKK, e.d.cp_cont_b, 1);
            }
            al.c(this.cKR, e.d.cp_cont_d, 1);
            al.c(this.cKS, e.d.cp_cont_d, 1);
            al.c(this.cKT, e.d.cp_link_tip_c, 1);
            al.c(this.cKO, e.d.cp_cont_i, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_common_big_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.a aVar) {
        if (aVar != null && aVar.YB() != null) {
            this.cKV = aVar;
            String str = null;
            if (aVar.YB().zj()) {
                this.cKN.setVisibility(0);
                this.cKO.setVisibility(0);
                if (aVar.YB().yN() != null) {
                    this.cKO.setText(ao.dt(aVar.YB().yN().video_duration.intValue() * 1000));
                    str = aVar.YB().yN().thumbnail_url;
                }
            } else {
                this.cKN.setVisibility(8);
                this.cKO.setVisibility(4);
                if (aVar.YB().yG() != null && aVar.YB().yG().size() >= 1) {
                    str = aVar.YB().yG().get(0).origin_pic;
                }
            }
            this.cKM.startLoad(str, 10, false);
            this.cKK.setText(aVar.YB().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vl(aVar.YB().getId())) {
                al.h(this.cKK, e.d.cp_cont_c);
            } else {
                al.h(this.cKK, e.d.cp_cont_b);
            }
            this.cKQ.setData(aVar.YB(), false);
            p(aVar.YB());
            this.cKS.setText(ao.E(aVar.YB().yg()));
            if ("guide".equals(aVar.YB().yl())) {
                this.cKT.setVisibility(0);
            } else {
                this.cKT.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cKT) {
            TiebaStatic.log(new am("c13047").x("obj_locate", 4).ax(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.k(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (anP() != null) {
            anP().a(getView(), this.cKV);
        }
    }

    private void p(bb bbVar) {
        if (this.cKR != null && bbVar != null && !StringUtils.isNull(bbVar.yv().getName_show())) {
            this.cKR.setText(fY(bbVar.yv().getName_show()));
        }
    }

    protected String fY(String str) {
        return ao.d(str, 14, "...");
    }
}
