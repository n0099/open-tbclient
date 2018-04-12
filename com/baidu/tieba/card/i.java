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
    private View bae;
    private TextView cnA;
    private com.baidu.tieba.e.g cnB;
    private TbImageView cno;
    private LinearLayout cnp;
    private TextView cnq;
    private TextView cnr;
    private TextView cns;
    private LinearLayout cnu;
    private ImageView cnv;
    private ImageView cnw;
    private ImageView cnx;
    private ImageView cny;
    private ImageView cnz;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.cno = (TbImageView) view2.findViewById(d.g.card_frs_game_score_img);
        this.cnp = (LinearLayout) view2.findViewById(d.g.card_frs_game_score_info);
        this.cnq = (TextView) view2.findViewById(d.g.card_frs_game_score_title);
        this.cnr = (TextView) view2.findViewById(d.g.card_frs_game_score_info_dsc);
        this.cns = (TextView) view2.findViewById(d.g.card_frs_game_score_num);
        this.cnu = (LinearLayout) view2.findViewById(d.g.card_frs_game_score_star_container);
        this.cnv = (ImageView) view2.findViewById(d.g.card_frs_game_score_star1);
        this.cnw = (ImageView) view2.findViewById(d.g.card_frs_game_score_star2);
        this.cnx = (ImageView) view2.findViewById(d.g.card_frs_game_score_star3);
        this.cny = (ImageView) view2.findViewById(d.g.card_frs_game_score_star4);
        this.cnz = (ImageView) view2.findViewById(d.g.card_frs_game_score_star5);
        this.cnA = (TextView) view2.findViewById(d.g.card_frs_game_score_audience_num);
        this.cno.setDefaultResource(17170445);
        this.cno.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cno.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cno.setDrawBorder(true);
        this.cno.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cno.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cno.setRadius(getContext().getResources().getDimensionPixelSize(d.e.tbds26));
        getView().setOnClickListener(this);
        this.bae = view2.findViewById(d.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.C0126d.cp_bg_line_d);
            ak.i(this.bae, d.C0126d.cp_bg_line_e);
            ak.c(this.cnq, d.C0126d.cp_cont_b, 1);
            ak.c(this.cnr, d.C0126d.cp_cont_j, 1);
            ak.c(this.cns, d.C0126d.cp_cont_f, 1);
            ak.c(this.cnA, d.C0126d.cp_cont_j, 1);
            b(this.cnB);
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
            this.cnB = gVar;
            this.cno.startLoad(gVar.ajz().avatar, 10, false);
            this.cnq.setText(gVar.ajz().game_name);
            this.cnr.setText(gVar.ajz().title_small);
            this.cns.setText(String.valueOf(gVar.ajz().game_score));
            b(gVar);
            this.cnA.setText(this.mContext.getResources().getString(d.k.frs_game_score_user_score_num, an.x(gVar.ajz().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ak.c(this.cnv, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.cnw, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.cnx, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.cny, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.cnz, d.f.game_comment_score_btn_small_empty_bg);
            if (gVar.ajz().game_score > 0.0d) {
                if (gVar.ajz().game_score < 2.0d) {
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 2.0d) {
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 4.0d) {
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnw, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 4.0d) {
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnw, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 6.0d) {
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnw, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnx, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 6.0d) {
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnw, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnx, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 8.0d) {
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnw, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnx, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cny, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 8.0d) {
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnw, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnx, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cny, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 10.0d) {
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnw, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnx, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cny, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnz, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 10.0d) {
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnw, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnx, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cny, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnz, d.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(getView(), this.cnB);
        }
    }
}
