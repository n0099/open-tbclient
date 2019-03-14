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
    private TbImageView egN;
    private LinearLayout egO;
    private TextView egP;
    private TextView egQ;
    private TextView egR;
    private LinearLayout egS;
    private ImageView egT;
    private ImageView egU;
    private ImageView egV;
    private ImageView egW;
    private ImageView egX;
    private TextView egY;
    private com.baidu.tieba.e.g egZ;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.egN = (TbImageView) view.findViewById(d.g.card_frs_game_score_img);
        this.egO = (LinearLayout) view.findViewById(d.g.card_frs_game_score_info);
        this.egP = (TextView) view.findViewById(d.g.card_frs_game_score_title);
        this.egQ = (TextView) view.findViewById(d.g.card_frs_game_score_info_dsc);
        this.egR = (TextView) view.findViewById(d.g.card_frs_game_score_num);
        this.egS = (LinearLayout) view.findViewById(d.g.card_frs_game_score_star_container);
        this.egT = (ImageView) view.findViewById(d.g.card_frs_game_score_star1);
        this.egU = (ImageView) view.findViewById(d.g.card_frs_game_score_star2);
        this.egV = (ImageView) view.findViewById(d.g.card_frs_game_score_star3);
        this.egW = (ImageView) view.findViewById(d.g.card_frs_game_score_star4);
        this.egX = (ImageView) view.findViewById(d.g.card_frs_game_score_star5);
        this.egY = (TextView) view.findViewById(d.g.card_frs_game_score_audience_num);
        this.egN.setDefaultResource(17170445);
        this.egN.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.egN.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.egN.setDrawBorder(true);
        this.egN.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.egN.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.egN.setRadius(getContext().getResources().getDimensionPixelSize(d.e.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(d.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.C0277d.cp_bg_line_d);
            al.k(this.dividerLine, d.C0277d.cp_bg_line_e);
            al.d(this.egP, d.C0277d.cp_cont_b, 1);
            al.d(this.egQ, d.C0277d.cp_cont_j, 1);
            al.d(this.egR, d.C0277d.cp_cont_f, 1);
            al.d(this.egY, d.C0277d.cp_cont_j, 1);
            b(this.egZ);
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
        if (gVar != null && gVar.aUR() != null) {
            this.egZ = gVar;
            this.egN.startLoad(gVar.aUR().avatar, 10, false);
            this.egP.setText(gVar.aUR().game_name);
            this.egQ.setText(gVar.aUR().title_small);
            this.egR.setText(String.valueOf(gVar.aUR().game_score));
            b(gVar);
            this.egY.setText(this.mContext.getResources().getString(d.j.frs_game_score_user_score_num, ap.at(gVar.aUR().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.egT, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.egU, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.egV, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.egW, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.egX, d.f.game_comment_score_btn_small_empty_bg);
            if (gVar.aUR().game_score > 0.0d) {
                if (gVar.aUR().game_score < 2.0d) {
                    al.c(this.egT, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.aUR().game_score == 2.0d) {
                    al.c(this.egT, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.aUR().game_score < 4.0d) {
                    al.c(this.egT, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egU, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.aUR().game_score == 4.0d) {
                    al.c(this.egT, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egU, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.aUR().game_score < 6.0d) {
                    al.c(this.egT, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egU, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egV, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.aUR().game_score == 6.0d) {
                    al.c(this.egT, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egU, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egV, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.aUR().game_score < 8.0d) {
                    al.c(this.egT, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egU, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egV, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egW, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.aUR().game_score == 8.0d) {
                    al.c(this.egT, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egU, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egV, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egW, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.aUR().game_score < 10.0d) {
                    al.c(this.egT, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egU, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egV, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egW, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egX, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.aUR().game_score == 10.0d) {
                    al.c(this.egT, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egU, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egV, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egW, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.egX, d.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQh() != null) {
            aQh().a(getView(), this.egZ);
        }
    }
}
