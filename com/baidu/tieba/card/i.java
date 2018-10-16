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
    private TbImageView cLQ;
    private LinearLayout cLR;
    private TextView cLS;
    private TextView cLT;
    private TextView cLU;
    private LinearLayout cLV;
    private ImageView cLW;
    private ImageView cLX;
    private ImageView cLY;
    private ImageView cLZ;
    private ImageView cMa;
    private TextView cMb;
    private com.baidu.tieba.e.g cMc;
    private View dividerLine;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cLQ = (TbImageView) view.findViewById(e.g.card_frs_game_score_img);
        this.cLR = (LinearLayout) view.findViewById(e.g.card_frs_game_score_info);
        this.cLS = (TextView) view.findViewById(e.g.card_frs_game_score_title);
        this.cLT = (TextView) view.findViewById(e.g.card_frs_game_score_info_dsc);
        this.cLU = (TextView) view.findViewById(e.g.card_frs_game_score_num);
        this.cLV = (LinearLayout) view.findViewById(e.g.card_frs_game_score_star_container);
        this.cLW = (ImageView) view.findViewById(e.g.card_frs_game_score_star1);
        this.cLX = (ImageView) view.findViewById(e.g.card_frs_game_score_star2);
        this.cLY = (ImageView) view.findViewById(e.g.card_frs_game_score_star3);
        this.cLZ = (ImageView) view.findViewById(e.g.card_frs_game_score_star4);
        this.cMa = (ImageView) view.findViewById(e.g.card_frs_game_score_star5);
        this.cMb = (TextView) view.findViewById(e.g.card_frs_game_score_audience_num);
        this.cLQ.setDefaultResource(17170445);
        this.cLQ.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cLQ.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cLQ.setDrawBorder(true);
        this.cLQ.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cLQ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds1));
        this.cLQ.setRadius(getContext().getResources().getDimensionPixelSize(e.C0175e.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.dividerLine, e.d.cp_bg_line_e);
            al.c(this.cLS, e.d.cp_cont_b, 1);
            al.c(this.cLT, e.d.cp_cont_j, 1);
            al.c(this.cLU, e.d.cp_cont_f, 1);
            al.c(this.cMb, e.d.cp_cont_j, 1);
            b(this.cMc);
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
        if (gVar != null && gVar.asB() != null) {
            this.cMc = gVar;
            this.cLQ.startLoad(gVar.asB().avatar, 10, false);
            this.cLS.setText(gVar.asB().game_name);
            this.cLT.setText(gVar.asB().title_small);
            this.cLU.setText(String.valueOf(gVar.asB().game_score));
            b(gVar);
            this.cMb.setText(this.mContext.getResources().getString(e.j.frs_game_score_user_score_num, ao.I(gVar.asB().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.cLW, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cLX, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cLY, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cLZ, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cMa, e.f.game_comment_score_btn_small_empty_bg);
            if (gVar.asB().game_score > 0.0d) {
                if (gVar.asB().game_score < 2.0d) {
                    al.c(this.cLW, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.asB().game_score == 2.0d) {
                    al.c(this.cLW, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.asB().game_score < 4.0d) {
                    al.c(this.cLW, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLX, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.asB().game_score == 4.0d) {
                    al.c(this.cLW, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLX, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.asB().game_score < 6.0d) {
                    al.c(this.cLW, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLX, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLY, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.asB().game_score == 6.0d) {
                    al.c(this.cLW, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLX, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLY, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.asB().game_score < 8.0d) {
                    al.c(this.cLW, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLX, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLY, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLZ, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.asB().game_score == 8.0d) {
                    al.c(this.cLW, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLX, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLY, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLZ, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.asB().game_score < 10.0d) {
                    al.c(this.cLW, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLX, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLY, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLZ, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cMa, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.asB().game_score == 10.0d) {
                    al.c(this.cLW, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLX, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLY, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cLZ, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cMa, e.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anO() != null) {
            anO().a(getView(), this.cMc);
        }
    }
}
