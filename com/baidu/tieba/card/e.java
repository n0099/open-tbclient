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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.FrsGameStrategyActivity;
/* loaded from: classes3.dex */
public class e extends a<com.baidu.tieba.e.a> {
    private LinearLayout ctY;
    private TextView ctZ;
    private RelativeLayout cua;
    private TbImageView cub;
    private ImageView cuc;
    private TextView cud;
    private RelativeLayout cue;
    private ClickableHeaderImageView cuf;
    private TextView cug;
    private TextView cuh;
    private TextView cui;
    private View cuj;
    private com.baidu.tieba.e.a cuk;
    private String mForumId;
    private String mForumName;

    public e(TbPageContext<?> tbPageContext, String str, String str2) {
        super(tbPageContext);
        this.mForumId = str;
        this.mForumName = str2;
        init(getView());
    }

    private void init(View view) {
        this.ctY = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.ctZ = (TextView) view.findViewById(d.g.card_frs_game_thread_title);
        this.cua = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.cub = (TbImageView) view.findViewById(d.g.card_frs_game_thread_bg);
        this.cuc = (ImageView) view.findViewById(d.g.img_play);
        this.cud = (TextView) view.findViewById(d.g.card_frs_game_thread_video_time);
        this.cue = (RelativeLayout) view.findViewById(d.g.card_frs_game_user_content);
        this.cuf = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.cug = (TextView) view.findViewById(d.g.card_frs_game_user_name);
        this.cuh = (TextView) view.findViewById(d.g.card_frs_game_thread_time);
        this.cui = (TextView) view.findViewById(d.g.card_frs_game_thread_more_article);
        this.cuj = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.cub.setDefaultBgResource(d.f.icon_morenpic);
        this.cub.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = com.baidu.adp.lib.util.l.al(this.mContext)[0] - (this.mContext.getResources().getDimensionPixelSize(d.e.tbds44) * 2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cua.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 21;
        this.cua.setLayoutParams(layoutParams);
        this.cui.setOnClickListener(this);
        this.cuf.setDefaultResource(17170445);
        this.cuf.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cuf.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.cuf.setIsRound(true);
        this.cuf.setDrawBorder(true);
        this.cuf.setBorderColor(am.getColor(d.C0142d.common_color_10043));
        this.cuf.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.ctY != null) {
            this.ctY.setPadding(i, i2, i3, i4);
        }
    }

    public void iF(int i) {
        if (this.cue != null) {
            this.cue.setVisibility(i);
        }
    }

    public void iG(int i) {
        if (this.cuj != null) {
            this.cuj.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.C0142d.cp_bg_line_d);
            am.i(this.cuj, d.C0142d.cp_bg_line_c);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ua(this.cuk.SV().getId())) {
                am.c(this.ctZ, d.C0142d.cp_cont_c, 1);
            } else {
                am.c(this.ctZ, d.C0142d.cp_cont_b, 1);
            }
            am.c(this.cug, d.C0142d.cp_cont_d, 1);
            am.c(this.cuh, d.C0142d.cp_cont_d, 1);
            am.c(this.cui, d.C0142d.cp_link_tip_c, 1);
            am.c(this.cud, d.C0142d.cp_cont_i, 1);
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
        if (aVar != null && aVar.SV() != null) {
            this.cuk = aVar;
            String str = null;
            if (aVar.SV().wh()) {
                this.cuc.setVisibility(0);
                this.cud.setVisibility(0);
                if (aVar.SV().vN() != null) {
                    this.cud.setText(ap.cY(aVar.SV().vN().video_duration.intValue() * 1000));
                    str = aVar.SV().vN().thumbnail_url;
                }
            } else {
                this.cuc.setVisibility(8);
                this.cud.setVisibility(4);
                if (aVar.SV().vG() != null && aVar.SV().vG().size() >= 1) {
                    str = aVar.SV().vG().get(0).origin_pic;
                }
            }
            this.cub.startLoad(str, 10, false);
            this.ctZ.setText(aVar.SV().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ua(aVar.SV().getId())) {
                am.h(this.ctZ, d.C0142d.cp_cont_c);
            } else {
                am.h(this.ctZ, d.C0142d.cp_cont_b);
            }
            this.cuf.setData(aVar.SV(), false);
            m(aVar.SV());
            this.cuh.setText(ap.x(aVar.SV().vh()));
            if ("guide".equals(aVar.SV().vm())) {
                this.cui.setVisibility(0);
            } else {
                this.cui.setVisibility(8);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cui) {
            TiebaStatic.log(new an("c13047").r("obj_locate", 4).ah(ImageViewerConfig.FORUM_ID, this.mForumId));
            FrsGameStrategyActivity.i(this.mTbPageContext.getPageActivity(), this.mForumId, this.mForumName);
        } else if (aia() != null) {
            aia().a(getView(), this.cuk);
        }
    }

    private void m(bc bcVar) {
        if (this.cug != null && bcVar != null && !StringUtils.isNull(bcVar.vw().getName_show())) {
            this.cug.setText(fs(bcVar.vw().getName_show()));
        }
    }

    protected String fs(String str) {
        return ap.e(str, 14, "...");
    }
}
