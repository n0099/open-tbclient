package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends a<com.baidu.tieba.e.g> {
    private View baf;
    private LinearLayout coA;
    private ImageView coB;
    private ImageView coC;
    private ImageView coD;
    private ImageView coE;
    private ImageView coF;
    private TextView coG;
    private com.baidu.tieba.e.g coH;
    private TbImageView cov;
    private LinearLayout cow;
    private TextView cox;
    private TextView coy;
    private TextView coz;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.cov = (TbImageView) view2.findViewById(d.g.card_frs_game_score_img);
        this.cow = (LinearLayout) view2.findViewById(d.g.card_frs_game_score_info);
        this.cox = (TextView) view2.findViewById(d.g.card_frs_game_score_title);
        this.coy = (TextView) view2.findViewById(d.g.card_frs_game_score_info_dsc);
        this.coz = (TextView) view2.findViewById(d.g.card_frs_game_score_num);
        this.coA = (LinearLayout) view2.findViewById(d.g.card_frs_game_score_star_container);
        this.coB = (ImageView) view2.findViewById(d.g.card_frs_game_score_star1);
        this.coC = (ImageView) view2.findViewById(d.g.card_frs_game_score_star2);
        this.coD = (ImageView) view2.findViewById(d.g.card_frs_game_score_star3);
        this.coE = (ImageView) view2.findViewById(d.g.card_frs_game_score_star4);
        this.coF = (ImageView) view2.findViewById(d.g.card_frs_game_score_star5);
        this.coG = (TextView) view2.findViewById(d.g.card_frs_game_score_audience_num);
        this.cov.setDefaultResource(17170445);
        this.cov.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cov.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cov.setDrawBorder(true);
        this.cov.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cov.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cov.setRadius(getContext().getResources().getDimensionPixelSize(d.e.tbds26));
        getView().setOnClickListener(this);
        this.baf = view2.findViewById(d.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.C0126d.cp_bg_line_d);
            ak.i(this.baf, d.C0126d.cp_bg_line_e);
            ak.c(this.cox, d.C0126d.cp_cont_b, 1);
            ak.c(this.coy, d.C0126d.cp_cont_j, 1);
            ak.c(this.coz, d.C0126d.cp_cont_f, 1);
            ak.c(this.coG, d.C0126d.cp_cont_j, 1);
            b(this.coH);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_game_score_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.g gVar) {
        if (gVar != null && gVar.ajz() != null) {
            this.coH = gVar;
            this.cov.startLoad(gVar.ajz().avatar, 10, false);
            this.cox.setText(gVar.ajz().game_name);
            this.coy.setText(gVar.ajz().title_small);
            this.coz.setText(String.valueOf(gVar.ajz().game_score));
            b(gVar);
            this.coG.setText(this.mContext.getResources().getString(d.k.frs_game_score_user_score_num, an.x(gVar.ajz().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ak.c(this.coB, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.coC, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.coD, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.coE, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.coF, d.f.game_comment_score_btn_small_empty_bg);
            if (gVar.ajz().game_score > 0.0d) {
                if (gVar.ajz().game_score < 2.0d) {
                    ak.c(this.coB, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 2.0d) {
                    ak.c(this.coB, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 4.0d) {
                    ak.c(this.coB, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coC, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 4.0d) {
                    ak.c(this.coB, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coC, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 6.0d) {
                    ak.c(this.coB, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coC, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coD, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 6.0d) {
                    ak.c(this.coB, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coC, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coD, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 8.0d) {
                    ak.c(this.coB, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coC, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coD, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coE, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 8.0d) {
                    ak.c(this.coB, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coC, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coD, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coE, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 10.0d) {
                    ak.c(this.coB, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coC, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coD, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coE, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coF, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 10.0d) {
                    ak.c(this.coB, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coC, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coD, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coE, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.coF, d.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(getView(), this.coH);
        }
    }
}
