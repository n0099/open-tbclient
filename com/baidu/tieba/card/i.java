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
    private View bjR;
    private TbImageView cvg;
    private LinearLayout cvh;
    private TextView cvi;
    private TextView cvj;
    private TextView cvk;
    private LinearLayout cvl;
    private ImageView cvm;
    private ImageView cvn;
    private ImageView cvo;
    private ImageView cvp;
    private ImageView cvq;
    private TextView cvr;
    private com.baidu.tieba.e.g cvs;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cvg = (TbImageView) view.findViewById(d.g.card_frs_game_score_img);
        this.cvh = (LinearLayout) view.findViewById(d.g.card_frs_game_score_info);
        this.cvi = (TextView) view.findViewById(d.g.card_frs_game_score_title);
        this.cvj = (TextView) view.findViewById(d.g.card_frs_game_score_info_dsc);
        this.cvk = (TextView) view.findViewById(d.g.card_frs_game_score_num);
        this.cvl = (LinearLayout) view.findViewById(d.g.card_frs_game_score_star_container);
        this.cvm = (ImageView) view.findViewById(d.g.card_frs_game_score_star1);
        this.cvn = (ImageView) view.findViewById(d.g.card_frs_game_score_star2);
        this.cvo = (ImageView) view.findViewById(d.g.card_frs_game_score_star3);
        this.cvp = (ImageView) view.findViewById(d.g.card_frs_game_score_star4);
        this.cvq = (ImageView) view.findViewById(d.g.card_frs_game_score_star5);
        this.cvr = (TextView) view.findViewById(d.g.card_frs_game_score_audience_num);
        this.cvg.setDefaultResource(17170445);
        this.cvg.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cvg.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.cvg.setDrawBorder(true);
        this.cvg.setBorderColor(am.getColor(d.C0142d.common_color_10043));
        this.cvg.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cvg.setRadius(getContext().getResources().getDimensionPixelSize(d.e.tbds26));
        getView().setOnClickListener(this);
        this.bjR = view.findViewById(d.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.C0142d.cp_bg_line_d);
            am.i(this.bjR, d.C0142d.cp_bg_line_e);
            am.c(this.cvi, d.C0142d.cp_cont_b, 1);
            am.c(this.cvj, d.C0142d.cp_cont_j, 1);
            am.c(this.cvk, d.C0142d.cp_cont_f, 1);
            am.c(this.cvr, d.C0142d.cp_cont_j, 1);
            b(this.cvs);
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
        if (gVar != null && gVar.amQ() != null) {
            this.cvs = gVar;
            this.cvg.startLoad(gVar.amQ().avatar, 10, false);
            this.cvi.setText(gVar.amQ().game_name);
            this.cvj.setText(gVar.amQ().title_small);
            this.cvk.setText(String.valueOf(gVar.amQ().game_score));
            b(gVar);
            this.cvr.setText(this.mContext.getResources().getString(d.k.frs_game_score_user_score_num, ap.B(gVar.amQ().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.c(this.cvm, d.f.game_comment_score_btn_small_empty_bg);
            am.c(this.cvn, d.f.game_comment_score_btn_small_empty_bg);
            am.c(this.cvo, d.f.game_comment_score_btn_small_empty_bg);
            am.c(this.cvp, d.f.game_comment_score_btn_small_empty_bg);
            am.c(this.cvq, d.f.game_comment_score_btn_small_empty_bg);
            if (gVar.amQ().game_score > 0.0d) {
                if (gVar.amQ().game_score < 2.0d) {
                    am.c(this.cvm, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.amQ().game_score == 2.0d) {
                    am.c(this.cvm, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.amQ().game_score < 4.0d) {
                    am.c(this.cvm, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvn, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.amQ().game_score == 4.0d) {
                    am.c(this.cvm, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvn, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.amQ().game_score < 6.0d) {
                    am.c(this.cvm, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvn, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvo, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.amQ().game_score == 6.0d) {
                    am.c(this.cvm, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvn, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvo, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.amQ().game_score < 8.0d) {
                    am.c(this.cvm, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvn, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvo, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvp, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.amQ().game_score == 8.0d) {
                    am.c(this.cvm, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvn, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvo, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvp, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.amQ().game_score < 10.0d) {
                    am.c(this.cvm, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvn, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvo, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvp, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvq, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.amQ().game_score == 10.0d) {
                    am.c(this.cvm, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvn, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvo, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvp, d.f.game_comment_score_btn_small_full_bg);
                    am.c(this.cvq, d.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aia() != null) {
            aia().a(getView(), this.cvs);
        }
    }
}
