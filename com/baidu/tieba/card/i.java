package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends a<com.baidu.tieba.e.g> {
    private View bkw;
    private TbImageView cxI;
    private LinearLayout cxJ;
    private TextView cxK;
    private TextView cxL;
    private TextView cxM;
    private LinearLayout cxN;
    private ImageView cxO;
    private ImageView cxP;
    private ImageView cxQ;
    private ImageView cxR;
    private ImageView cxS;
    private TextView cxT;
    private com.baidu.tieba.e.g cxU;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cxI = (TbImageView) view.findViewById(d.g.card_frs_game_score_img);
        this.cxJ = (LinearLayout) view.findViewById(d.g.card_frs_game_score_info);
        this.cxK = (TextView) view.findViewById(d.g.card_frs_game_score_title);
        this.cxL = (TextView) view.findViewById(d.g.card_frs_game_score_info_dsc);
        this.cxM = (TextView) view.findViewById(d.g.card_frs_game_score_num);
        this.cxN = (LinearLayout) view.findViewById(d.g.card_frs_game_score_star_container);
        this.cxO = (ImageView) view.findViewById(d.g.card_frs_game_score_star1);
        this.cxP = (ImageView) view.findViewById(d.g.card_frs_game_score_star2);
        this.cxQ = (ImageView) view.findViewById(d.g.card_frs_game_score_star3);
        this.cxR = (ImageView) view.findViewById(d.g.card_frs_game_score_star4);
        this.cxS = (ImageView) view.findViewById(d.g.card_frs_game_score_star5);
        this.cxT = (TextView) view.findViewById(d.g.card_frs_game_score_audience_num);
        this.cxI.setDefaultResource(17170445);
        this.cxI.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cxI.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.cxI.setDrawBorder(true);
        this.cxI.setBorderColor(am.getColor(d.C0140d.common_color_10043));
        this.cxI.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cxI.setRadius(getContext().getResources().getDimensionPixelSize(d.e.tbds26));
        getView().setOnClickListener(this);
        this.bkw = view.findViewById(d.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.C0140d.cp_bg_line_d);
            am.i(this.bkw, d.C0140d.cp_bg_line_e);
            am.c(this.cxK, d.C0140d.cp_cont_b, 1);
            am.c(this.cxL, d.C0140d.cp_cont_j, 1);
            am.c(this.cxM, d.C0140d.cp_cont_f, 1);
            am.c(this.cxT, d.C0140d.cp_cont_j, 1);
            b(this.cxU);
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
        if (gVar != null && gVar.anp() != null) {
            this.cxU = gVar;
            this.cxI.startLoad(gVar.anp().avatar, 10, false);
            this.cxK.setText(gVar.anp().game_name);
            this.cxL.setText(gVar.anp().title_small);
            this.cxM.setText(String.valueOf(gVar.anp().game_score));
            b(gVar);
            this.cxT.setText(this.mContext.getResources().getString(d.j.frs_game_score_user_score_num, ap.C(gVar.anp().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.c(this.cxO, d.f.game_comment_score_btn_small_empty_bg);
            am.c(this.cxP, d.f.game_comment_score_btn_small_empty_bg);
            am.c(this.cxQ, d.f.game_comment_score_btn_small_empty_bg);
            am.c(this.cxR, d.f.game_comment_score_btn_small_empty_bg);
            am.c(this.cxS, d.f.game_comment_score_btn_small_empty_bg);
            if (gVar.anp().game_score > 0.0d) {
                if (gVar.anp().game_score < 2.0d) {
                    am.c(this.cxO, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anp().game_score == 2.0d) {
                    am.c(this.cxO, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anp().game_score < 4.0d) {
                    am.c(this.cxO, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxP, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anp().game_score == 4.0d) {
                    am.c(this.cxO, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxP, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anp().game_score < 6.0d) {
                    am.c(this.cxO, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxP, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxQ, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anp().game_score == 6.0d) {
                    am.c(this.cxO, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxP, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxQ, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anp().game_score < 8.0d) {
                    am.c(this.cxO, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxP, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxQ, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxR, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anp().game_score == 8.0d) {
                    am.c(this.cxO, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxP, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxQ, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxR, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anp().game_score < 10.0d) {
                    am.c(this.cxO, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxP, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxQ, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxR, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxS, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anp().game_score == 10.0d) {
                    am.c(this.cxO, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxP, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxQ, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxR, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxS, d.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiz() != null) {
            aiz().a(getView(), this.cxU);
        }
    }
}
