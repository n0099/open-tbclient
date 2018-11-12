package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class i extends a<com.baidu.tieba.e.g> {
    private TbImageView cMW;
    private LinearLayout cMX;
    private TextView cMY;
    private TextView cMZ;
    private TextView cNa;
    private LinearLayout cNb;
    private ImageView cNc;
    private ImageView cNd;
    private ImageView cNe;
    private ImageView cNf;
    private ImageView cNg;
    private TextView cNh;
    private com.baidu.tieba.e.g cNi;
    private View dividerLine;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cMW = (TbImageView) view.findViewById(e.g.card_frs_game_score_img);
        this.cMX = (LinearLayout) view.findViewById(e.g.card_frs_game_score_info);
        this.cMY = (TextView) view.findViewById(e.g.card_frs_game_score_title);
        this.cMZ = (TextView) view.findViewById(e.g.card_frs_game_score_info_dsc);
        this.cNa = (TextView) view.findViewById(e.g.card_frs_game_score_num);
        this.cNb = (LinearLayout) view.findViewById(e.g.card_frs_game_score_star_container);
        this.cNc = (ImageView) view.findViewById(e.g.card_frs_game_score_star1);
        this.cNd = (ImageView) view.findViewById(e.g.card_frs_game_score_star2);
        this.cNe = (ImageView) view.findViewById(e.g.card_frs_game_score_star3);
        this.cNf = (ImageView) view.findViewById(e.g.card_frs_game_score_star4);
        this.cNg = (ImageView) view.findViewById(e.g.card_frs_game_score_star5);
        this.cNh = (TextView) view.findViewById(e.g.card_frs_game_score_audience_num);
        this.cMW.setDefaultResource(17170445);
        this.cMW.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cMW.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cMW.setDrawBorder(true);
        this.cMW.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cMW.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds1));
        this.cMW.setRadius(getContext().getResources().getDimensionPixelSize(e.C0200e.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.dividerLine, e.d.cp_bg_line_e);
            al.c(this.cMY, e.d.cp_cont_b, 1);
            al.c(this.cMZ, e.d.cp_cont_j, 1);
            al.c(this.cNa, e.d.cp_cont_f, 1);
            al.c(this.cNh, e.d.cp_cont_j, 1);
            b(this.cNi);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_score_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.g gVar) {
        if (gVar != null && gVar.asb() != null) {
            this.cNi = gVar;
            this.cMW.startLoad(gVar.asb().avatar, 10, false);
            this.cMY.setText(gVar.asb().game_name);
            this.cMZ.setText(gVar.asb().title_small);
            this.cNa.setText(String.valueOf(gVar.asb().game_score));
            b(gVar);
            this.cNh.setText(this.mContext.getResources().getString(e.j.frs_game_score_user_score_num, ao.K(gVar.asb().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.cNc, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cNd, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cNe, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cNf, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cNg, e.f.game_comment_score_btn_small_empty_bg);
            if (gVar.asb().game_score > 0.0d) {
                if (gVar.asb().game_score < 2.0d) {
                    al.c(this.cNc, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.asb().game_score == 2.0d) {
                    al.c(this.cNc, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.asb().game_score < 4.0d) {
                    al.c(this.cNc, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNd, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.asb().game_score == 4.0d) {
                    al.c(this.cNc, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNd, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.asb().game_score < 6.0d) {
                    al.c(this.cNc, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNd, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNe, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.asb().game_score == 6.0d) {
                    al.c(this.cNc, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNd, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNe, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.asb().game_score < 8.0d) {
                    al.c(this.cNc, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNd, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNe, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNf, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.asb().game_score == 8.0d) {
                    al.c(this.cNc, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNd, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNe, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNf, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.asb().game_score < 10.0d) {
                    al.c(this.cNc, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNd, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNe, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNf, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNg, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.asb().game_score == 10.0d) {
                    al.c(this.cNc, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNd, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNe, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNf, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cNg, e.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anq() != null) {
            anq().a(getView(), this.cNi);
        }
    }
}
