package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class i extends b<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView hEC;
    private LinearLayout hED;
    private TextView hEE;
    private TextView hEF;
    private TextView hEG;
    private LinearLayout hEH;
    private ImageView hEI;
    private ImageView hEJ;
    private ImageView hEK;
    private ImageView hEL;
    private ImageView hEM;
    private TextView hEN;
    private com.baidu.tieba.e.g hEO;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hEC = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.hED = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.hEE = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.hEF = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.hEG = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.hEH = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.hEI = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.hEJ = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.hEK = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.hEL = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.hEM = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.hEN = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.hEC.setDefaultResource(17170445);
        this.hEC.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hEC.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hEC.setDrawBorder(true);
        this.hEC.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hEC.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hEC.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hEE, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hEF, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.hEG, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.hEN, R.color.cp_cont_j, 1);
            b(this.hEO);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_score_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.g gVar) {
        if (gVar != null && gVar.ckg() != null) {
            this.hEO = gVar;
            this.hEC.startLoad(gVar.ckg().avatar, 10, false);
            this.hEE.setText(gVar.ckg().game_name);
            this.hEF.setText(gVar.ckg().title_small);
            this.hEG.setText(String.valueOf(gVar.ckg().game_score));
            b(gVar);
            this.hEN.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, at.numberUniform(gVar.ckg().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hEJ, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hEK, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hEL, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hEM, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.ckg().game_score > 0.0d) {
                if (gVar.ckg().game_score < 2.0d) {
                    ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ckg().game_score == 2.0d) {
                    ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ckg().game_score < 4.0d) {
                    ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEJ, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ckg().game_score == 4.0d) {
                    ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEJ, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ckg().game_score < 6.0d) {
                    ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEJ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEK, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ckg().game_score == 6.0d) {
                    ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEJ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEK, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ckg().game_score < 8.0d) {
                    ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEJ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEK, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEL, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ckg().game_score == 8.0d) {
                    ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEJ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEK, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEL, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ckg().game_score < 10.0d) {
                    ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEJ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEK, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEL, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEM, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ckg().game_score == 10.0d) {
                    ap.setImageResource(this.hEI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEJ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEK, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEL, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hEM, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cil() != null) {
            cil().a(getView(), this.hEO);
        }
    }
}
