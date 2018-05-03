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
    private TbImageView cnl;
    private LinearLayout cnm;
    private TextView cnn;
    private TextView cno;
    private TextView cnp;
    private LinearLayout cnq;
    private ImageView cnr;
    private ImageView cns;
    private ImageView cnu;
    private ImageView cnv;
    private ImageView cnw;
    private TextView cnx;
    private com.baidu.tieba.e.g cny;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.cnl = (TbImageView) view2.findViewById(d.g.card_frs_game_score_img);
        this.cnm = (LinearLayout) view2.findViewById(d.g.card_frs_game_score_info);
        this.cnn = (TextView) view2.findViewById(d.g.card_frs_game_score_title);
        this.cno = (TextView) view2.findViewById(d.g.card_frs_game_score_info_dsc);
        this.cnp = (TextView) view2.findViewById(d.g.card_frs_game_score_num);
        this.cnq = (LinearLayout) view2.findViewById(d.g.card_frs_game_score_star_container);
        this.cnr = (ImageView) view2.findViewById(d.g.card_frs_game_score_star1);
        this.cns = (ImageView) view2.findViewById(d.g.card_frs_game_score_star2);
        this.cnu = (ImageView) view2.findViewById(d.g.card_frs_game_score_star3);
        this.cnv = (ImageView) view2.findViewById(d.g.card_frs_game_score_star4);
        this.cnw = (ImageView) view2.findViewById(d.g.card_frs_game_score_star5);
        this.cnx = (TextView) view2.findViewById(d.g.card_frs_game_score_audience_num);
        this.cnl.setDefaultResource(17170445);
        this.cnl.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cnl.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cnl.setDrawBorder(true);
        this.cnl.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cnl.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cnl.setRadius(getContext().getResources().getDimensionPixelSize(d.e.tbds26));
        getView().setOnClickListener(this);
        this.bae = view2.findViewById(d.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.C0126d.cp_bg_line_d);
            ak.i(this.bae, d.C0126d.cp_bg_line_e);
            ak.c(this.cnn, d.C0126d.cp_cont_b, 1);
            ak.c(this.cno, d.C0126d.cp_cont_j, 1);
            ak.c(this.cnp, d.C0126d.cp_cont_f, 1);
            ak.c(this.cnx, d.C0126d.cp_cont_j, 1);
            b(this.cny);
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
            this.cny = gVar;
            this.cnl.startLoad(gVar.ajz().avatar, 10, false);
            this.cnn.setText(gVar.ajz().game_name);
            this.cno.setText(gVar.ajz().title_small);
            this.cnp.setText(String.valueOf(gVar.ajz().game_score));
            b(gVar);
            this.cnx.setText(this.mContext.getResources().getString(d.k.frs_game_score_user_score_num, an.x(gVar.ajz().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ak.c(this.cnr, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.cns, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.cnu, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.cnv, d.f.game_comment_score_btn_small_empty_bg);
            ak.c(this.cnw, d.f.game_comment_score_btn_small_empty_bg);
            if (gVar.ajz().game_score > 0.0d) {
                if (gVar.ajz().game_score < 2.0d) {
                    ak.c(this.cnr, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 2.0d) {
                    ak.c(this.cnr, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 4.0d) {
                    ak.c(this.cnr, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cns, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 4.0d) {
                    ak.c(this.cnr, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cns, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 6.0d) {
                    ak.c(this.cnr, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cns, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnu, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 6.0d) {
                    ak.c(this.cnr, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cns, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnu, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 8.0d) {
                    ak.c(this.cnr, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cns, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnu, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 8.0d) {
                    ak.c(this.cnr, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cns, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnu, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.ajz().game_score < 10.0d) {
                    ak.c(this.cnr, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cns, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnu, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnw, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.ajz().game_score == 10.0d) {
                    ak.c(this.cnr, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cns, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnu, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnv, d.f.game_comment_score_btn_small_full_bg);
                    ak.c(this.cnw, d.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(getView(), this.cny);
        }
    }
}
