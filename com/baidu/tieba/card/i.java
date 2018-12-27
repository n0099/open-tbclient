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
    private ImageView cWA;
    private ImageView cWB;
    private ImageView cWC;
    private ImageView cWD;
    private TextView cWE;
    private com.baidu.tieba.e.g cWF;
    private TbImageView cWt;
    private LinearLayout cWu;
    private TextView cWv;
    private TextView cWw;
    private TextView cWx;
    private LinearLayout cWy;
    private ImageView cWz;
    private View dividerLine;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cWt = (TbImageView) view.findViewById(e.g.card_frs_game_score_img);
        this.cWu = (LinearLayout) view.findViewById(e.g.card_frs_game_score_info);
        this.cWv = (TextView) view.findViewById(e.g.card_frs_game_score_title);
        this.cWw = (TextView) view.findViewById(e.g.card_frs_game_score_info_dsc);
        this.cWx = (TextView) view.findViewById(e.g.card_frs_game_score_num);
        this.cWy = (LinearLayout) view.findViewById(e.g.card_frs_game_score_star_container);
        this.cWz = (ImageView) view.findViewById(e.g.card_frs_game_score_star1);
        this.cWA = (ImageView) view.findViewById(e.g.card_frs_game_score_star2);
        this.cWB = (ImageView) view.findViewById(e.g.card_frs_game_score_star3);
        this.cWC = (ImageView) view.findViewById(e.g.card_frs_game_score_star4);
        this.cWD = (ImageView) view.findViewById(e.g.card_frs_game_score_star5);
        this.cWE = (TextView) view.findViewById(e.g.card_frs_game_score_audience_num);
        this.cWt.setDefaultResource(17170445);
        this.cWt.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWt.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWt.setDrawBorder(true);
        this.cWt.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWt.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cWt.setRadius(getContext().getResources().getDimensionPixelSize(e.C0210e.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.dividerLine, e.d.cp_bg_line_e);
            al.c(this.cWv, e.d.cp_cont_b, 1);
            al.c(this.cWw, e.d.cp_cont_j, 1);
            al.c(this.cWx, e.d.cp_cont_f, 1);
            al.c(this.cWE, e.d.cp_cont_j, 1);
            b(this.cWF);
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
        if (gVar != null && gVar.auC() != null) {
            this.cWF = gVar;
            this.cWt.startLoad(gVar.auC().avatar, 10, false);
            this.cWv.setText(gVar.auC().game_name);
            this.cWw.setText(gVar.auC().title_small);
            this.cWx.setText(String.valueOf(gVar.auC().game_score));
            b(gVar);
            this.cWE.setText(this.mContext.getResources().getString(e.j.frs_game_score_user_score_num, ao.S(gVar.auC().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.cWz, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cWA, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cWB, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cWC, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cWD, e.f.game_comment_score_btn_small_empty_bg);
            if (gVar.auC().game_score > 0.0d) {
                if (gVar.auC().game_score < 2.0d) {
                    al.c(this.cWz, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.auC().game_score == 2.0d) {
                    al.c(this.cWz, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.auC().game_score < 4.0d) {
                    al.c(this.cWz, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWA, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.auC().game_score == 4.0d) {
                    al.c(this.cWz, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWA, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.auC().game_score < 6.0d) {
                    al.c(this.cWz, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWA, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWB, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.auC().game_score == 6.0d) {
                    al.c(this.cWz, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWA, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWB, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.auC().game_score < 8.0d) {
                    al.c(this.cWz, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWA, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWC, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.auC().game_score == 8.0d) {
                    al.c(this.cWz, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWA, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWC, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.auC().game_score < 10.0d) {
                    al.c(this.cWz, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWA, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWC, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWD, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.auC().game_score == 10.0d) {
                    al.c(this.cWz, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWA, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWC, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cWD, e.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apS() != null) {
            apS().a(getView(), this.cWF);
        }
    }
}
