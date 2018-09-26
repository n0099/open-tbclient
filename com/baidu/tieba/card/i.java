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
    private LinearLayout cDA;
    private ImageView cDB;
    private ImageView cDC;
    private ImageView cDD;
    private ImageView cDE;
    private ImageView cDF;
    private TextView cDG;
    private com.baidu.tieba.e.g cDH;
    private TbImageView cDv;
    private LinearLayout cDw;
    private TextView cDx;
    private TextView cDy;
    private TextView cDz;
    private View dividerLine;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cDv = (TbImageView) view.findViewById(e.g.card_frs_game_score_img);
        this.cDw = (LinearLayout) view.findViewById(e.g.card_frs_game_score_info);
        this.cDx = (TextView) view.findViewById(e.g.card_frs_game_score_title);
        this.cDy = (TextView) view.findViewById(e.g.card_frs_game_score_info_dsc);
        this.cDz = (TextView) view.findViewById(e.g.card_frs_game_score_num);
        this.cDA = (LinearLayout) view.findViewById(e.g.card_frs_game_score_star_container);
        this.cDB = (ImageView) view.findViewById(e.g.card_frs_game_score_star1);
        this.cDC = (ImageView) view.findViewById(e.g.card_frs_game_score_star2);
        this.cDD = (ImageView) view.findViewById(e.g.card_frs_game_score_star3);
        this.cDE = (ImageView) view.findViewById(e.g.card_frs_game_score_star4);
        this.cDF = (ImageView) view.findViewById(e.g.card_frs_game_score_star5);
        this.cDG = (TextView) view.findViewById(e.g.card_frs_game_score_audience_num);
        this.cDv.setDefaultResource(17170445);
        this.cDv.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cDv.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cDv.setDrawBorder(true);
        this.cDv.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cDv.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds1));
        this.cDv.setRadius(getContext().getResources().getDimensionPixelSize(e.C0141e.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(e.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.dividerLine, e.d.cp_bg_line_e);
            al.c(this.cDx, e.d.cp_cont_b, 1);
            al.c(this.cDy, e.d.cp_cont_j, 1);
            al.c(this.cDz, e.d.cp_cont_f, 1);
            al.c(this.cDG, e.d.cp_cont_j, 1);
            b(this.cDH);
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
        if (gVar != null && gVar.apd() != null) {
            this.cDH = gVar;
            this.cDv.startLoad(gVar.apd().avatar, 10, false);
            this.cDx.setText(gVar.apd().game_name);
            this.cDy.setText(gVar.apd().title_small);
            this.cDz.setText(String.valueOf(gVar.apd().game_score));
            b(gVar);
            this.cDG.setText(this.mContext.getResources().getString(e.j.frs_game_score_user_score_num, ao.G(gVar.apd().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.cDB, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cDC, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cDD, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cDE, e.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cDF, e.f.game_comment_score_btn_small_empty_bg);
            if (gVar.apd().game_score > 0.0d) {
                if (gVar.apd().game_score < 2.0d) {
                    al.c(this.cDB, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.apd().game_score == 2.0d) {
                    al.c(this.cDB, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.apd().game_score < 4.0d) {
                    al.c(this.cDB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDC, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.apd().game_score == 4.0d) {
                    al.c(this.cDB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDC, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.apd().game_score < 6.0d) {
                    al.c(this.cDB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDC, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDD, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.apd().game_score == 6.0d) {
                    al.c(this.cDB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDC, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDD, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.apd().game_score < 8.0d) {
                    al.c(this.cDB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDC, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDD, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDE, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.apd().game_score == 8.0d) {
                    al.c(this.cDB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDC, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDD, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDE, e.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.apd().game_score < 10.0d) {
                    al.c(this.cDB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDC, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDD, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDE, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDF, e.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.apd().game_score == 10.0d) {
                    al.c(this.cDB, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDC, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDD, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDE, e.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cDF, e.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akm() != null) {
            akm().a(getView(), this.cDH);
        }
    }
}
