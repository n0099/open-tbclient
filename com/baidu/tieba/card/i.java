package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class i extends a<com.baidu.tieba.e.g> {
    private TbImageView cxF;
    private LinearLayout cxG;
    private TextView cxH;
    private TextView cxI;
    private TextView cxJ;
    private LinearLayout cxK;
    private ImageView cxL;
    private ImageView cxM;
    private ImageView cxN;
    private ImageView cxO;
    private ImageView cxP;
    private TextView cxQ;
    private com.baidu.tieba.e.g cxR;
    private View dividerLine;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cxF = (TbImageView) view.findViewById(f.g.card_frs_game_score_img);
        this.cxG = (LinearLayout) view.findViewById(f.g.card_frs_game_score_info);
        this.cxH = (TextView) view.findViewById(f.g.card_frs_game_score_title);
        this.cxI = (TextView) view.findViewById(f.g.card_frs_game_score_info_dsc);
        this.cxJ = (TextView) view.findViewById(f.g.card_frs_game_score_num);
        this.cxK = (LinearLayout) view.findViewById(f.g.card_frs_game_score_star_container);
        this.cxL = (ImageView) view.findViewById(f.g.card_frs_game_score_star1);
        this.cxM = (ImageView) view.findViewById(f.g.card_frs_game_score_star2);
        this.cxN = (ImageView) view.findViewById(f.g.card_frs_game_score_star3);
        this.cxO = (ImageView) view.findViewById(f.g.card_frs_game_score_star4);
        this.cxP = (ImageView) view.findViewById(f.g.card_frs_game_score_star5);
        this.cxQ = (TextView) view.findViewById(f.g.card_frs_game_score_audience_num);
        this.cxF.setDefaultResource(17170445);
        this.cxF.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.cxF.setDefaultBgResource(f.d.cp_bg_line_e);
        this.cxF.setDrawBorder(true);
        this.cxF.setBorderColor(am.getColor(f.d.common_color_10043));
        this.cxF.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(f.e.tbds1));
        this.cxF.setRadius(getContext().getResources().getDimensionPixelSize(f.e.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(f.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.d.cp_bg_line_d);
            am.i(this.dividerLine, f.d.cp_bg_line_e);
            am.c(this.cxH, f.d.cp_cont_b, 1);
            am.c(this.cxI, f.d.cp_cont_j, 1);
            am.c(this.cxJ, f.d.cp_cont_f, 1);
            am.c(this.cxQ, f.d.cp_cont_j, 1);
            b(this.cxR);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_frs_game_score_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.g gVar) {
        if (gVar != null && gVar.anr() != null) {
            this.cxR = gVar;
            this.cxF.startLoad(gVar.anr().avatar, 10, false);
            this.cxH.setText(gVar.anr().game_name);
            this.cxI.setText(gVar.anr().title_small);
            this.cxJ.setText(String.valueOf(gVar.anr().game_score));
            b(gVar);
            this.cxQ.setText(this.mContext.getResources().getString(f.j.frs_game_score_user_score_num, ap.C(gVar.anr().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.c(this.cxL, f.C0146f.game_comment_score_btn_small_empty_bg);
            am.c(this.cxM, f.C0146f.game_comment_score_btn_small_empty_bg);
            am.c(this.cxN, f.C0146f.game_comment_score_btn_small_empty_bg);
            am.c(this.cxO, f.C0146f.game_comment_score_btn_small_empty_bg);
            am.c(this.cxP, f.C0146f.game_comment_score_btn_small_empty_bg);
            if (gVar.anr().game_score > 0.0d) {
                if (gVar.anr().game_score < 2.0d) {
                    am.c(this.cxL, f.C0146f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anr().game_score == 2.0d) {
                    am.c(this.cxL, f.C0146f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anr().game_score < 4.0d) {
                    am.c(this.cxL, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxM, f.C0146f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anr().game_score == 4.0d) {
                    am.c(this.cxL, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxM, f.C0146f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anr().game_score < 6.0d) {
                    am.c(this.cxL, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxM, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxN, f.C0146f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anr().game_score == 6.0d) {
                    am.c(this.cxL, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxM, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxN, f.C0146f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anr().game_score < 8.0d) {
                    am.c(this.cxL, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxM, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxN, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxO, f.C0146f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anr().game_score == 8.0d) {
                    am.c(this.cxL, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxM, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxN, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxO, f.C0146f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anr().game_score < 10.0d) {
                    am.c(this.cxL, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxM, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxN, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxO, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxP, f.C0146f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anr().game_score == 10.0d) {
                    am.c(this.cxL, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxM, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxN, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxO, f.C0146f.game_comment_score_btn_small_full_bg);
                    am.c(this.cxP, f.C0146f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiC() != null) {
            aiC().a(getView(), this.cxR);
        }
    }
}
