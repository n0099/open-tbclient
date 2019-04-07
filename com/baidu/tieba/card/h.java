package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class h extends a<com.baidu.tieba.e.g> {
    private View dividerLine;
    private LinearLayout egA;
    private TextView egB;
    private TextView egC;
    private TextView egD;
    private LinearLayout egE;
    private ImageView egF;
    private ImageView egG;
    private ImageView egH;
    private ImageView egI;
    private ImageView egJ;
    private TextView egK;
    private com.baidu.tieba.e.g egL;
    private TbImageView egz;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.egz = (TbImageView) view.findViewById(d.g.card_frs_game_score_img);
        this.egA = (LinearLayout) view.findViewById(d.g.card_frs_game_score_info);
        this.egB = (TextView) view.findViewById(d.g.card_frs_game_score_title);
        this.egC = (TextView) view.findViewById(d.g.card_frs_game_score_info_dsc);
        this.egD = (TextView) view.findViewById(d.g.card_frs_game_score_num);
        this.egE = (LinearLayout) view.findViewById(d.g.card_frs_game_score_star_container);
        this.egF = (ImageView) view.findViewById(d.g.card_frs_game_score_star1);
        this.egG = (ImageView) view.findViewById(d.g.card_frs_game_score_star2);
        this.egH = (ImageView) view.findViewById(d.g.card_frs_game_score_star3);
        this.egI = (ImageView) view.findViewById(d.g.card_frs_game_score_star4);
        this.egJ = (ImageView) view.findViewById(d.g.card_frs_game_score_star5);
        this.egK = (TextView) view.findViewById(d.g.card_frs_game_score_audience_num);
        this.egz.setDefaultResource(17170445);
        this.egz.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.egz.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.egz.setDrawBorder(true);
        this.egz.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.egz.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.egz.setRadius(getContext().getResources().getDimensionPixelSize(d.e.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(d.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.C0277d.cp_bg_line_d);
            al.k(this.dividerLine, d.C0277d.cp_bg_line_e);
            al.d(this.egB, d.C0277d.cp_cont_b, 1);
            al.d(this.egC, d.C0277d.cp_cont_j, 1);
            al.d(this.egD, d.C0277d.cp_cont_f, 1);
            al.d(this.egK, d.C0277d.cp_cont_j, 1);
            b(this.egL);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_score_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.g gVar) {
        if (gVar != null && gVar.aUP() != null) {
            this.egL = gVar;
            this.egz.startLoad(gVar.aUP().avatar, 10, false);
            this.egB.setText(gVar.aUP().game_name);
            this.egC.setText(gVar.aUP().title_small);
            this.egD.setText(String.valueOf(gVar.aUP().game_score));
            b(gVar);
            this.egK.setText(this.mContext.getResources().getString(d.j.frs_game_score_user_score_num, ap.at(gVar.aUP().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.egF, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.egG, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.egH, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.egI, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.egJ, d.f.game_comment_score_btn_small_empty_bg);
            if (gVar.aUP().game_score > 0.0d) {
                if (gVar.aUP().game_score < 2.0d) {
                    al.c(this.egF, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.aUP().game_score == 2.0d) {
                    al.c(this.egF, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.aUP().game_score < 4.0d) {
                    al.c(this.egF, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egG, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.aUP().game_score == 4.0d) {
                    al.c(this.egF, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egG, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.aUP().game_score < 6.0d) {
                    al.c(this.egF, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egG, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egH, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.aUP().game_score == 6.0d) {
                    al.c(this.egF, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egG, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egH, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.aUP().game_score < 8.0d) {
                    al.c(this.egF, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egG, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egH, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egI, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.aUP().game_score == 8.0d) {
                    al.c(this.egF, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egG, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egH, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egI, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.aUP().game_score < 10.0d) {
                    al.c(this.egF, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egG, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egH, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egI, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egJ, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.aUP().game_score == 10.0d) {
                    al.c(this.egF, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egG, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egH, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egI, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egJ, d.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQf() != null) {
            aQf().a(getView(), this.egL);
        }
    }
}
