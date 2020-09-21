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
/* loaded from: classes21.dex */
public class i extends b<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView hpI;
    private LinearLayout hpJ;
    private TextView hpK;
    private TextView hpL;
    private TextView hpM;
    private LinearLayout hpN;
    private ImageView hpO;
    private ImageView hpP;
    private ImageView hpQ;
    private ImageView hpR;
    private ImageView hpS;
    private TextView hpT;
    private com.baidu.tieba.e.g hpU;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hpI = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.hpJ = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.hpK = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.hpL = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.hpM = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.hpN = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.hpO = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.hpP = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.hpQ = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.hpR = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.hpS = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.hpT = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.hpI.setDefaultResource(17170445);
        this.hpI.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hpI.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hpI.setDrawBorder(true);
        this.hpI.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hpI.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hpI.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hpK, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hpL, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.hpM, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.hpT, R.color.cp_cont_j, 1);
            b(this.hpU);
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
        if (gVar != null && gVar.cgK() != null) {
            this.hpU = gVar;
            this.hpI.startLoad(gVar.cgK().avatar, 10, false);
            this.hpK.setText(gVar.cgK().game_name);
            this.hpL.setText(gVar.cgK().title_small);
            this.hpM.setText(String.valueOf(gVar.cgK().game_score));
            b(gVar);
            this.hpT.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, at.numberUniform(gVar.cgK().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hpP, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hpQ, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hpR, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hpS, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.cgK().game_score > 0.0d) {
                if (gVar.cgK().game_score < 2.0d) {
                    ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cgK().game_score == 2.0d) {
                    ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cgK().game_score < 4.0d) {
                    ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpP, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cgK().game_score == 4.0d) {
                    ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpP, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cgK().game_score < 6.0d) {
                    ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpQ, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cgK().game_score == 6.0d) {
                    ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpQ, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cgK().game_score < 8.0d) {
                    ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpR, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cgK().game_score == 8.0d) {
                    ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpR, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cgK().game_score < 10.0d) {
                    ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpR, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpS, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cgK().game_score == 10.0d) {
                    ap.setImageResource(this.hpO, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpR, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hpS, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ceP() != null) {
            ceP().a(getView(), this.hpU);
        }
    }
}
