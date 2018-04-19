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
    private LinearLayout cmh;
    private TextView cmi;
    private RelativeLayout cmj;
    private TbImageView cmk;
    private ImageView cml;
    private TextView cmm;
    private RelativeLayout cmn;
    private ClickableHeaderImageView cmo;
    private TextView cmp;
    private TextView cmq;
    private TextView cmr;
    private View cms;
    private com.baidu.tieba.e.a cmt;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view2) {
        this.cmh = (LinearLayout) view2.findViewById(d.g.card_frs_game_thread_layout);
        this.cmi = (TextView) view2.findViewById(d.g.card_frs_game_thread_title);
        this.cmj = (RelativeLayout) view2.findViewById(d.g.card_frs_game_thread_content);
        this.cmk = (TbImageView) view2.findViewById(d.g.card_frs_game_thread_bg);
        this.cml = (ImageView) view2.findViewById(d.g.img_play);
        this.cmm = (TextView) view2.findViewById(d.g.card_frs_game_thread_video_time);
        this.cmn = (RelativeLayout) view2.findViewById(d.g.card_frs_game_user_content);
        this.cmo = (ClickableHeaderImageView) view2.findViewById(d.g.card_frs_game_user_icon);
        this.cmp = (TextView) view2.findViewById(d.g.card_frs_game_user_name);
        this.cmq = (TextView) view2.findViewById(d.g.card_frs_game_thread_time);
        this.cmr = (TextView) view2.findViewById(d.g.card_frs_game_thread_more_article);
        this.cms = view2.findViewById(d.g.card_frs_game_bottom_divider);
        this.cmk.setDefaultBgResource(d.f.icon_morenpic);
        this.cmk.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aj(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(d.e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmj.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cmj.setLayoutParams(layoutParams);
        this.cmr.setOnClickListener(this);
        this.cmo.setDefaultResource(17170445);
        this.cmo.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cmo.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cmo.setIsRound(true);
        this.cmo.setDrawBorder(true);
        this.cmo.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cmo.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cmh != null) {
            this.cmh.setPadding(i, i2, i3, i4);
        }
    }

    public void iI(int i) {
        if (this.cmn != null) {
            this.cmn.setVisibility(i);
        }
    }

    public void iJ(int i) {
        if (this.cms != null) {
            this.cms.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.C0126d.cp_bg_line_d);
            ak.i(this.cms, d.C0126d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.td(this.cmt.Pe().getId())) {
                ak.c(this.cmi, d.C0126d.cp_cont_c, 1);
            } else {
                ak.c(this.cmi, d.C0126d.cp_cont_b, 1);
            }
            ak.c(this.cmp, d.C0126d.cp_cont_d, 1);
            ak.c(this.cmq, d.C0126d.cp_cont_d, 1);
            ak.c(this.cmr, d.C0126d.cp_link_tip_c, 1);
            ak.c(this.cmm, d.C0126d.cp_cont_i, 1);
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
        if (aVar != null && aVar.Pe() != null) {
            this.cmt = aVar;
            String str = null;
            if (aVar.Pe().sB()) {
                this.cml.setVisibility(0);
                this.cmm.setVisibility(0);
                if (aVar.Pe().sh() != null) {
                    this.cmm.setText(an.cU(aVar.Pe().sh().video_duration.intValue() * 1000));
                    str = aVar.Pe().sh().thumbnail_url;
                }
            } else {
                this.cml.setVisibility(8);
                this.cmm.setVisibility(4);
                if (aVar.Pe().sa() != null && aVar.Pe().sa().size() >= 1) {
                    str = aVar.Pe().sa().get(0).origin_pic;
                }
            }
            this.cmk.startLoad(str, 10, false);
            this.cmi.setText(aVar.Pe().getTitle());
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.td(aVar.Pe().getId())) {
                ak.h(this.cmi, d.C0126d.cp_cont_c);
            } else {
                ak.h(this.cmi, d.C0126d.cp_cont_b);
            }
            this.cmo.setData(aVar.Pe(), false);
            k(aVar.Pe());
            this.cmq.setText(an.t(aVar.Pe().rD()));
            if ("news".equals(aVar.Pe().rH())) {
                this.cmr.setVisibility(0);
            } else {
                this.cmr.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.cmr) {
            TiebaStatic.log(new al("c13047").r("obj_locate", 4).ac(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.j(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aeZ() != null) {
            aeZ().a(getView(), this.cmt);
        }
    }

    private void k(bd bdVar) {
        if (this.cmp != null && bdVar != null && !StringUtils.isNull(bdVar.rQ().getName_show())) {
            this.cmp.setText(eP(bdVar.rQ().getName_show()));
        }
    }

    protected String eP(String str) {
        return an.e(str, 14, "...");
    }
}
