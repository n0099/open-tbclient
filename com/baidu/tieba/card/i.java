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
    private TbImageView cXe;
    private LinearLayout cXf;
    private TextView cXg;
    private TextView cXh;
    private TextView cXi;
    private LinearLayout cXj;
    private ImageView cXk;
    private ImageView cXl;
    private ImageView cXm;
    private ImageView cXn;
    private ImageView cXo;
    private TextView cXp;
    private com.baidu.tieba.e.g cXq;
    private View dividerLine;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cXe = (TbImageView) view.findViewById(e.g.card_frs_game_score_img);
        this.cXf = (LinearLayout) view.findViewById(e.g.card_frs_game_score_info);
        this.cXg = (TextView) view.findViewById(e.g.card_frs_game_score_title);
        this.cXh = (TextView) view.findViewById(e.g.card_frs_game_score_info_dsc);
        this.cXi = (TextView) view.findViewById(e.g.card_frs_game_score_num);
        this.cXj = (LinearLayout) view.findViewById(e.g.card_frs_game_score_star_container);
        this.cXk = (ImageView) view.findViewById(e.g.card_frs_game_score_star1);
        this.cXl = (ImageView) view.findViewById(e.g.card_frs_game_score_star2);
        this.cXm = (ImageView) view.findViewById(e.g.card_frs_game_score_star3);
        this.cXn = (ImageView) view.findViewById(e.g.card_frs_game_score_star4);
        this.cXo = (ImageView) view.findViewById(e.g.card_frs_game_score_star5);
        this.cXp = (TextView) view.findViewById(e.g.card_frs_game_score_audience_num);
        this.cXe.setDefaultResource(17170445);
        this.cXe.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cXe.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cXe.setDrawBorder(true);
        this.cXe.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cXe.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cXe.setRadius(getContext().getResources().getDimensionPixelSize(e.C0210e.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.dividerLine, e.d.cp_bg_line_e);
            al.c(this.cXg, e.d.cp_cont_b, 1);
            al.c(this.cXh, e.d.cp_cont_j, 1);
            al.c(this.cXi, e.d.cp_cont_f, 1);
            al.c(this.cXp, e.d.cp_cont_j, 1);
            b(this.cXq);
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
        if (gVar != null && gVar.ava() != null) {
            this.cXq = gVar;
            this.cXe.startLoad(gVar.ava().avatar, 10, false);
            this.cXg.setText(gVar.ava().game_name);
            this.cXh.setText(gVar.ava().title_small);
            this.cXi.setText(String.valueOf(gVar.ava().game_score));
            b(gVar);
            this.cXp.setText(this.mContext.getResources().getString(e.j.frs_game_score_user_score_num, ao.S(gVar.ava().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.cXk, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cXl, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cXm, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cXn, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cXo, e.f.game_comment_score_btn_small_empty_bg);
            if (gVar.ava().game_score > 0.0d) {
                if (gVar.ava().game_score < 2.0d) {
                    al.c(this.cXk, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ava().game_score == 2.0d) {
                    al.c(this.cXk, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ava().game_score < 4.0d) {
                    al.c(this.cXk, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXl, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ava().game_score == 4.0d) {
                    al.c(this.cXk, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXl, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ava().game_score < 6.0d) {
                    al.c(this.cXk, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXl, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXm, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ava().game_score == 6.0d) {
                    al.c(this.cXk, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXl, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXm, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ava().game_score < 8.0d) {
                    al.c(this.cXk, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXl, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXm, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXn, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ava().game_score == 8.0d) {
                    al.c(this.cXk, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXl, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXm, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXn, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ava().game_score < 10.0d) {
                    al.c(this.cXk, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXl, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXm, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXn, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXo, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ava().game_score == 10.0d) {
                    al.c(this.cXk, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXl, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXm, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXn, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cXo, e.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aqp() != null) {
            aqp().a(getView(), this.cXq);
        }
    }
}
