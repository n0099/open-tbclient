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
    private TbImageView gob;
    private LinearLayout goc;
    private TextView god;
    private TextView goe;
    private TextView gof;
    private LinearLayout gog;
    private ImageView goh;
    private ImageView goi;
    private ImageView goj;
    private ImageView gok;
    private ImageView gol;
    private TextView gom;
    private com.baidu.tieba.e.g gon;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gob = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.goc = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.god = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.goe = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.gof = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.gog = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.goh = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.goi = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.goj = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.gok = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.gol = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.gom = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.gob.setDefaultResource(17170445);
        this.gob.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gob.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gob.setDrawBorder(true);
        this.gob.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gob.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gob.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.god, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.goe, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gof, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.gom, R.color.cp_cont_j, 1);
            b(this.gon);
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
        if (gVar != null && gVar.bGx() != null) {
            this.gon = gVar;
            this.gob.startLoad(gVar.bGx().avatar, 10, false);
            this.god.setText(gVar.bGx().game_name);
            this.goe.setText(gVar.bGx().title_small);
            this.gof.setText(String.valueOf(gVar.bGx().game_score));
            b(gVar);
            this.gom.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.bGx().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.goi, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.goj, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gok, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gol, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bGx().game_score > 0.0d) {
                if (gVar.bGx().game_score < 2.0d) {
                    am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bGx().game_score == 2.0d) {
                    am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bGx().game_score < 4.0d) {
                    am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goi, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bGx().game_score == 4.0d) {
                    am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goi, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bGx().game_score < 6.0d) {
                    am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goj, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bGx().game_score == 6.0d) {
                    am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goj, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bGx().game_score < 8.0d) {
                    am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gok, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bGx().game_score == 8.0d) {
                    am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gok, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bGx().game_score < 10.0d) {
                    am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gok, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gol, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bGx().game_score == 10.0d) {
                    am.setImageResource(this.goh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.goj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gok, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gol, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEy() != null) {
            bEy().a(getView(), this.gon);
        }
    }
}
