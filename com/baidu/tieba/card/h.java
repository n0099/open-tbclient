package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class h extends a<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView goh;
    private LinearLayout goi;
    private TextView goj;
    private TextView gok;
    private TextView gol;
    private LinearLayout gom;
    private ImageView gon;
    private ImageView goo;
    private ImageView gop;
    private ImageView goq;
    private ImageView gor;
    private TextView gos;
    private com.baidu.tieba.e.g got;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.goh = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.goi = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.goj = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.gok = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.gol = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.gom = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.gon = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.goo = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.gop = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.goq = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.gor = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.gos = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.goh.setDefaultResource(17170445);
        this.goh.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.goh.setDefaultBgResource(R.color.cp_bg_line_e);
        this.goh.setDrawBorder(true);
        this.goh.setBorderColor(am.getColor(R.color.common_color_10043));
        this.goh.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.goh.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.goj, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gok, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gol, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.gos, R.color.cp_cont_j, 1);
            b(this.got);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_score_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.g gVar) {
        if (gVar != null && gVar.bGw() != null) {
            this.got = gVar;
            this.goh.startLoad(gVar.bGw().avatar, 10, false);
            this.goj.setText(gVar.bGw().game_name);
            this.gok.setText(gVar.bGw().title_small);
            this.gol.setText(String.valueOf(gVar.bGw().game_score));
            b(gVar);
            this.gos.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.bGw().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.goo, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gop, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.goq, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gor, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bGw().game_score > 0.0d) {
                if (gVar.bGw().game_score < 2.0d) {
                    am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bGw().game_score == 2.0d) {
                    am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bGw().game_score < 4.0d) {
                    am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goo, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bGw().game_score == 4.0d) {
                    am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goo, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bGw().game_score < 6.0d) {
                    am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goo, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gop, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bGw().game_score == 6.0d) {
                    am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goo, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gop, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bGw().game_score < 8.0d) {
                    am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goo, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gop, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goq, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bGw().game_score == 8.0d) {
                    am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goo, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gop, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goq, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bGw().game_score < 10.0d) {
                    am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goo, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gop, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goq, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gor, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bGw().game_score == 10.0d) {
                    am.setImageResource(this.gon, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goo, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gop, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goq, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gor, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEx() != null) {
            bEx().a(getView(), this.got);
        }
    }
}
