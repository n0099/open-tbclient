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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes3.dex */
public class e extends a<com.baidu.tieba.e.a> {
    private com.baidu.tieba.e.a cnA;
    private LinearLayout cnn;
    private TextView cno;
    private RelativeLayout cnp;
    private TbImageView cnq;
    private ImageView cnr;
    private TextView cns;
    private RelativeLayout cnu;
    private ClickableHeaderImageView cnv;
    private TextView cnw;
    private TextView cnx;
    private TextView cny;
    private View cnz;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view2) {
        this.cnn = (LinearLayout) view2.findViewById(d.g.card_frs_game_thread_layout);
        this.cno = (TextView) view2.findViewById(d.g.card_frs_game_thread_title);
        this.cnp = (RelativeLayout) view2.findViewById(d.g.card_frs_game_thread_content);
        this.cnq = (TbImageView) view2.findViewById(d.g.card_frs_game_thread_bg);
        this.cnr = (ImageView) view2.findViewById(d.g.img_play);
        this.cns = (TextView) view2.findViewById(d.g.card_frs_game_thread_video_time);
        this.cnu = (RelativeLayout) view2.findViewById(d.g.card_frs_game_user_content);
        this.cnv = (ClickableHeaderImageView) view2.findViewById(d.g.card_frs_game_user_icon);
        this.cnw = (TextView) view2.findViewById(d.g.card_frs_game_user_name);
        this.cnx = (TextView) view2.findViewById(d.g.card_frs_game_thread_time);
        this.cny = (TextView) view2.findViewById(d.g.card_frs_game_thread_more_article);
        this.cnz = view2.findViewById(d.g.card_frs_game_bottom_divider);
        this.cnq.setDefaultBgResource(d.f.icon_morenpic);
        this.cnq.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aj(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(d.e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cnp.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cnp.setLayoutParams(layoutParams);
        this.cny.setOnClickListener(this);
        this.cnv.setDefaultResource(17170445);
        this.cnv.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cnv.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cnv.setIsRound(true);
        this.cnv.setDrawBorder(true);
        this.cnv.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cnv.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cnn != null) {
            this.cnn.setPadding(i, i2, i3, i4);
        }
    }

    public void iH(int i) {
        if (this.cnu != null) {
            this.cnu.setVisibility(i);
        }
    }

    public void iI(int i) {
        if (this.cnz != null) {
            this.cnz.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.C0126d.cp_bg_line_d);
            ak.i(this.cnz, d.C0126d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tg(this.cnA.Pb().getId())) {
                ak.c(this.cno, d.C0126d.cp_cont_c, 1);
            } else {
                ak.c(this.cno, d.C0126d.cp_cont_b, 1);
            }
            ak.c(this.cnw, d.C0126d.cp_cont_d, 1);
            ak.c(this.cnx, d.C0126d.cp_cont_d, 1);
            ak.c(this.cny, d.C0126d.cp_link_tip_c, 1);
            ak.c(this.cns, d.C0126d.cp_cont_i, 1);
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
        if (aVar != null && aVar.Pb() != null) {
            this.cnA = aVar;
            String str = null;
            if (aVar.Pb().sA()) {
                this.cnr.setVisibility(0);
                this.cns.setVisibility(0);
                if (aVar.Pb().sg() != null) {
                    this.cns.setText(an.cV(aVar.Pb().sg().video_duration.intValue() * 1000));
                    str = aVar.Pb().sg().thumbnail_url;
                }
            } else {
                this.cnr.setVisibility(8);
                this.cns.setVisibility(4);
                if (aVar.Pb().rZ() != null && aVar.Pb().rZ().size() >= 1) {
                    str = aVar.Pb().rZ().get(0).origin_pic;
                }
            }
            this.cnq.startLoad(str, 10, false);
            this.cno.setText(aVar.Pb().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tg(aVar.Pb().getId())) {
                ak.h(this.cno, d.C0126d.cp_cont_c);
            } else {
                ak.h(this.cno, d.C0126d.cp_cont_b);
            }
            this.cnv.setData(aVar.Pb(), false);
            k(aVar.Pb());
            this.cnx.setText(an.t(aVar.Pb().rC()));
            if ("news".equals(aVar.Pb().rG())) {
                this.cny.setVisibility(0);
            } else {
                this.cny.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cny) {
            TiebaStatic.log(new al("c13047").r("obj_locate", 4).ac(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.j(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aeZ() != null) {
            aeZ().a(getView(), this.cnA);
        }
    }

    private void k(bd bdVar) {
        if (this.cnw != null && bdVar != null && !StringUtils.isNull(bdVar.rP().getName_show())) {
            this.cnw.setText(eP(bdVar.rP().getName_show()));
        }
    }

    protected String eP(String str) {
        return an.e(str, 14, "...");
    }
}
