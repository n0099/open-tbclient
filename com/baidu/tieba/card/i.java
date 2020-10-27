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
    private TbImageView hQY;
    private LinearLayout hQZ;
    private TextView hRa;
    private TextView hRb;
    private TextView hRc;
    private LinearLayout hRd;
    private ImageView hRe;
    private ImageView hRf;
    private ImageView hRg;
    private ImageView hRh;
    private ImageView hRi;
    private TextView hRj;
    private com.baidu.tieba.e.g hRk;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hQY = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.hQZ = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.hRa = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.hRb = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.hRc = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.hRd = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.hRe = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.hRf = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.hRg = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.hRh = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.hRi = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.hRj = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.hQY.setDefaultResource(17170445);
        this.hQY.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hQY.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hQY.setDrawBorder(true);
        this.hQY.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hQY.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hQY.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hRa, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hRb, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.hRc, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.hRj, R.color.cp_cont_j, 1);
            b(this.hRk);
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
        if (gVar != null && gVar.cnn() != null) {
            this.hRk = gVar;
            this.hQY.startLoad(gVar.cnn().avatar, 10, false);
            this.hRa.setText(gVar.cnn().game_name);
            this.hRb.setText(gVar.cnn().title_small);
            this.hRc.setText(String.valueOf(gVar.cnn().game_score));
            b(gVar);
            this.hRj.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, at.numberUniform(gVar.cnn().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hRf, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hRg, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hRh, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hRi, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.cnn().game_score > 0.0d) {
                if (gVar.cnn().game_score < 2.0d) {
                    ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cnn().game_score == 2.0d) {
                    ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cnn().game_score < 4.0d) {
                    ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRf, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cnn().game_score == 4.0d) {
                    ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRf, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cnn().game_score < 6.0d) {
                    ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRf, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRg, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cnn().game_score == 6.0d) {
                    ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRf, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRg, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cnn().game_score < 8.0d) {
                    ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRf, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRh, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cnn().game_score == 8.0d) {
                    ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRf, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRh, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cnn().game_score < 10.0d) {
                    ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRf, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRh, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRi, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cnn().game_score == 10.0d) {
                    ap.setImageResource(this.hRe, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRf, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRh, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hRi, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cls() != null) {
            cls().a(getView(), this.hRk);
        }
    }
}
