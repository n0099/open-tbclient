package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class i extends b<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView gQc;
    private LinearLayout gQd;
    private TextView gQe;
    private TextView gQf;
    private TextView gQg;
    private LinearLayout gQh;
    private ImageView gQi;
    private ImageView gQj;
    private ImageView gQk;
    private ImageView gQl;
    private ImageView gQm;
    private TextView gQn;
    private com.baidu.tieba.e.g gQo;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gQc = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.gQd = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.gQe = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.gQf = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.gQg = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.gQh = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.gQi = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.gQj = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.gQk = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.gQl = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.gQm = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.gQn = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.gQc.setDefaultResource(17170445);
        this.gQc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gQc.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gQc.setDrawBorder(true);
        this.gQc.setBorderColor(an.getColor(R.color.common_color_10043));
        this.gQc.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gQc.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            an.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            an.setViewTextColor(this.gQe, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.gQf, R.color.cp_cont_j, 1);
            an.setViewTextColor(this.gQg, R.color.cp_cont_f, 1);
            an.setViewTextColor(this.gQn, R.color.cp_cont_j, 1);
            b(this.gQo);
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
        if (gVar != null && gVar.bPX() != null) {
            this.gQo = gVar;
            this.gQc.startLoad(gVar.bPX().avatar, 10, false);
            this.gQe.setText(gVar.bPX().game_name);
            this.gQf.setText(gVar.bPX().title_small);
            this.gQg.setText(String.valueOf(gVar.bPX().game_score));
            b(gVar);
            this.gQn.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, ar.numberUniform(gVar.bPX().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_empty_bg);
            an.setImageResource(this.gQj, R.drawable.game_comment_score_btn_small_empty_bg);
            an.setImageResource(this.gQk, R.drawable.game_comment_score_btn_small_empty_bg);
            an.setImageResource(this.gQl, R.drawable.game_comment_score_btn_small_empty_bg);
            an.setImageResource(this.gQm, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bPX().game_score > 0.0d) {
                if (gVar.bPX().game_score < 2.0d) {
                    an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bPX().game_score == 2.0d) {
                    an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bPX().game_score < 4.0d) {
                    an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQj, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bPX().game_score == 4.0d) {
                    an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQj, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bPX().game_score < 6.0d) {
                    an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQj, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQk, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bPX().game_score == 6.0d) {
                    an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQj, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQk, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bPX().game_score < 8.0d) {
                    an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQj, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQk, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQl, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bPX().game_score == 8.0d) {
                    an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQj, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQk, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQl, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bPX().game_score < 10.0d) {
                    an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQj, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQk, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQl, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQm, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bPX().game_score == 10.0d) {
                    an.setImageResource(this.gQi, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQj, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQk, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQl, R.drawable.game_comment_score_btn_small_full_bg);
                    an.setImageResource(this.gQm, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bOd() != null) {
            bOd().a(getView(), this.gQo);
        }
    }
}
