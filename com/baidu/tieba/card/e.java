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
    private com.baidu.tieba.e.a cCA;
    private LinearLayout cCo;
    private TextView cCp;
    private RelativeLayout cCq;
    private TbImageView cCr;
    private ImageView cCs;
    private TextView cCt;
    private RelativeLayout cCu;
    private ClickableHeaderImageView cCv;
    private TextView cCw;
    private TextView cCx;
    private TextView cCy;
    private View cCz;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.cCo = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cCp = (TextView) view.findViewById(e.g.card_frs_game_thread_title);
        this.cCq = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.cCr = (TbImageView) view.findViewById(e.g.card_frs_game_thread_bg);
        this.cCs = (ImageView) view.findViewById(e.g.img_play);
        this.cCt = (TextView) view.findViewById(e.g.card_frs_game_thread_video_time);
        this.cCu = (RelativeLayout) view.findViewById(e.g.card_frs_game_user_content);
        this.cCv = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cCw = (TextView) view.findViewById(e.g.card_frs_game_user_name);
        this.cCx = (TextView) view.findViewById(e.g.card_frs_game_thread_time);
        this.cCy = (TextView) view.findViewById(e.g.card_frs_game_thread_more_article);
        this.cCz = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.cCr.setDefaultBgResource(e.f.icon_morenpic);
        this.cCr.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.aS(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cCq.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cCq.setLayoutParams(layoutParams);
        this.cCy.setOnClickListener(this);
        this.cCv.setDefaultResource(17170445);
        this.cCv.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cCv.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cCv.setIsRound(true);
        this.cCv.setDrawBorder(true);
        this.cCv.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cCv.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cCo != null) {
            this.cCo.setPadding(i, i2, i3, i4);
        }
    }

    public void jo(int i) {
        if (this.cCu != null) {
            this.cCu.setVisibility(i);
        }
    }

    public void jp(int i) {
        if (this.cCz != null) {
            this.cCz.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cCz, e.d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.uJ(this.cCA.UT().getId())) {
                al.c(this.cCp, e.d.cp_cont_c, 1);
            } else {
                al.c(this.cCp, e.d.cp_cont_b, 1);
            }
            al.c(this.cCw, e.d.cp_cont_d, 1);
            al.c(this.cCx, e.d.cp_cont_d, 1);
            al.c(this.cCy, e.d.cp_link_tip_c, 1);
            al.c(this.cCt, e.d.cp_cont_i, 1);
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
        if (aVar != null && aVar.UT() != null) {
            this.cCA = aVar;
            String str = null;
            if (aVar.UT().xa()) {
                this.cCs.setVisibility(0);
                this.cCt.setVisibility(0);
                if (aVar.UT().wE() != null) {
                    this.cCt.setText(ao.dj(aVar.UT().wE().video_duration.intValue() * 1000));
                    str = aVar.UT().wE().thumbnail_url;
                }
            } else {
                this.cCs.setVisibility(8);
                this.cCt.setVisibility(4);
                if (aVar.UT().wx() != null && aVar.UT().wx().size() >= 1) {
                    str = aVar.UT().wx().get(0).origin_pic;
                }
            }
            this.cCr.startLoad(str, 10, false);
            this.cCp.setText(aVar.UT().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.uJ(aVar.UT().getId())) {
                al.h(this.cCp, e.d.cp_cont_c);
            } else {
                al.h(this.cCp, e.d.cp_cont_b);
            }
            this.cCv.setData(aVar.UT(), false);
            p(aVar.UT());
            this.cCx.setText(ao.C(aVar.UT().vX()));
            if ("guide".equals(aVar.UT().wc())) {
                this.cCy.setVisibility(0);
            } else {
                this.cCy.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cCy) {
            TiebaStatic.log(new am("c13047").w("obj_locate", 4).al(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.j(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (akm() != null) {
            akm().a(getView(), this.cCA);
        }
    }

    private void p(bb bbVar) {
        if (this.cCw != null && bbVar != null && !StringUtils.isNull(bbVar.wm().getName_show())) {
            this.cCw.setText(fK(bbVar.wm().getName_show()));
        }
    }

    protected String fK(String str) {
        return ao.d(str, 14, "...");
    }
}
