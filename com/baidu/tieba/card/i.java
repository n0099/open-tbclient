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
    private TbImageView cTD;
    private LinearLayout cTE;
    private TextView cTF;
    private TextView cTG;
    private TextView cTH;
    private LinearLayout cTI;
    private ImageView cTJ;
    private ImageView cTK;
    private ImageView cTL;
    private ImageView cTM;
    private ImageView cTN;
    private TextView cTO;
    private com.baidu.tieba.e.g cTP;
    private View dividerLine;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cTD = (TbImageView) view.findViewById(e.g.card_frs_game_score_img);
        this.cTE = (LinearLayout) view.findViewById(e.g.card_frs_game_score_info);
        this.cTF = (TextView) view.findViewById(e.g.card_frs_game_score_title);
        this.cTG = (TextView) view.findViewById(e.g.card_frs_game_score_info_dsc);
        this.cTH = (TextView) view.findViewById(e.g.card_frs_game_score_num);
        this.cTI = (LinearLayout) view.findViewById(e.g.card_frs_game_score_star_container);
        this.cTJ = (ImageView) view.findViewById(e.g.card_frs_game_score_star1);
        this.cTK = (ImageView) view.findViewById(e.g.card_frs_game_score_star2);
        this.cTL = (ImageView) view.findViewById(e.g.card_frs_game_score_star3);
        this.cTM = (ImageView) view.findViewById(e.g.card_frs_game_score_star4);
        this.cTN = (ImageView) view.findViewById(e.g.card_frs_game_score_star5);
        this.cTO = (TextView) view.findViewById(e.g.card_frs_game_score_audience_num);
        this.cTD.setDefaultResource(17170445);
        this.cTD.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cTD.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cTD.setDrawBorder(true);
        this.cTD.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cTD.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        this.cTD.setRadius(getContext().getResources().getDimensionPixelSize(e.C0210e.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.dividerLine, e.d.cp_bg_line_e);
            al.c(this.cTF, e.d.cp_cont_b, 1);
            al.c(this.cTG, e.d.cp_cont_j, 1);
            al.c(this.cTH, e.d.cp_cont_f, 1);
            al.c(this.cTO, e.d.cp_cont_j, 1);
            b(this.cTP);
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
        if (gVar != null && gVar.atN() != null) {
            this.cTP = gVar;
            this.cTD.startLoad(gVar.atN().avatar, 10, false);
            this.cTF.setText(gVar.atN().game_name);
            this.cTG.setText(gVar.atN().title_small);
            this.cTH.setText(String.valueOf(gVar.atN().game_score));
            b(gVar);
            this.cTO.setText(this.mContext.getResources().getString(e.j.frs_game_score_user_score_num, ao.R(gVar.atN().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.cTJ, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cTK, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cTL, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cTM, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cTN, e.f.game_comment_score_btn_small_empty_bg);
            if (gVar.atN().game_score > 0.0d) {
                if (gVar.atN().game_score < 2.0d) {
                    al.c(this.cTJ, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.atN().game_score == 2.0d) {
                    al.c(this.cTJ, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.atN().game_score < 4.0d) {
                    al.c(this.cTJ, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTK, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.atN().game_score == 4.0d) {
                    al.c(this.cTJ, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTK, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.atN().game_score < 6.0d) {
                    al.c(this.cTJ, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTK, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTL, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.atN().game_score == 6.0d) {
                    al.c(this.cTJ, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTK, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTL, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.atN().game_score < 8.0d) {
                    al.c(this.cTJ, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTK, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTL, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTM, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.atN().game_score == 8.0d) {
                    al.c(this.cTJ, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTK, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTL, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTM, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.atN().game_score < 10.0d) {
                    al.c(this.cTJ, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTK, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTL, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTM, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTN, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.atN().game_score == 10.0d) {
                    al.c(this.cTJ, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTK, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTL, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTM, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cTN, e.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apc() != null) {
            apc().a(getView(), this.cTP);
        }
    }
}
