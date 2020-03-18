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
    private LinearLayout fJA;
    private ImageView fJB;
    private ImageView fJC;
    private ImageView fJD;
    private ImageView fJE;
    private ImageView fJF;
    private TextView fJG;
    private com.baidu.tieba.e.g fJH;
    private TbImageView fJv;
    private LinearLayout fJw;
    private TextView fJx;
    private TextView fJy;
    private TextView fJz;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fJv = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.fJw = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.fJx = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.fJy = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.fJz = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.fJA = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.fJB = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.fJC = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.fJD = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.fJE = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.fJF = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.fJG = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.fJv.setDefaultResource(17170445);
        this.fJv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fJv.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fJv.setDrawBorder(true);
        this.fJv.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fJv.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fJv.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fJx, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fJy, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.fJz, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.fJG, R.color.cp_cont_j, 1);
            b(this.fJH);
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
        if (gVar != null && gVar.bwL() != null) {
            this.fJH = gVar;
            this.fJv.startLoad(gVar.bwL().avatar, 10, false);
            this.fJx.setText(gVar.bwL().game_name);
            this.fJy.setText(gVar.bwL().title_small);
            this.fJz.setText(String.valueOf(gVar.bwL().game_score));
            b(gVar);
            this.fJG.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.bwL().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fJC, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fJD, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fJE, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fJF, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bwL().game_score > 0.0d) {
                if (gVar.bwL().game_score < 2.0d) {
                    am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwL().game_score == 2.0d) {
                    am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwL().game_score < 4.0d) {
                    am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJC, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwL().game_score == 4.0d) {
                    am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJC, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwL().game_score < 6.0d) {
                    am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJC, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJD, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwL().game_score == 6.0d) {
                    am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJC, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJD, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwL().game_score < 8.0d) {
                    am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJC, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJD, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJE, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwL().game_score == 8.0d) {
                    am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJC, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJD, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJE, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwL().game_score < 10.0d) {
                    am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJC, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJD, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJE, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJF, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwL().game_score == 10.0d) {
                    am.setImageResource(this.fJB, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJC, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJD, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJE, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fJF, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buM() != null) {
            buM().a(getView(), this.fJH);
        }
    }
}
