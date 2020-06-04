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
public class i extends b<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView gDm;
    private LinearLayout gDn;
    private TextView gDo;
    private TextView gDp;
    private TextView gDq;
    private LinearLayout gDr;
    private ImageView gDs;
    private ImageView gDt;
    private ImageView gDu;
    private ImageView gDv;
    private ImageView gDw;
    private TextView gDx;
    private com.baidu.tieba.e.g gDy;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gDm = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.gDn = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.gDo = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.gDp = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.gDq = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.gDr = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.gDs = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.gDt = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.gDu = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.gDv = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.gDw = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.gDx = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.gDm.setDefaultResource(17170445);
        this.gDm.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gDm.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gDm.setDrawBorder(true);
        this.gDm.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gDm.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gDm.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gDo, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gDp, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gDq, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.gDx, R.color.cp_cont_j, 1);
            b(this.gDy);
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
        if (gVar != null && gVar.bMR() != null) {
            this.gDy = gVar;
            this.gDm.startLoad(gVar.bMR().avatar, 10, false);
            this.gDo.setText(gVar.bMR().game_name);
            this.gDp.setText(gVar.bMR().title_small);
            this.gDq.setText(String.valueOf(gVar.bMR().game_score));
            b(gVar);
            this.gDx.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.bMR().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gDt, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gDu, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gDv, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gDw, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bMR().game_score > 0.0d) {
                if (gVar.bMR().game_score < 2.0d) {
                    am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bMR().game_score == 2.0d) {
                    am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bMR().game_score < 4.0d) {
                    am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDt, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bMR().game_score == 4.0d) {
                    am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDt, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bMR().game_score < 6.0d) {
                    am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDt, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDu, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bMR().game_score == 6.0d) {
                    am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDt, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDu, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bMR().game_score < 8.0d) {
                    am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDt, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDu, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDv, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bMR().game_score == 8.0d) {
                    am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDt, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDu, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDv, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bMR().game_score < 10.0d) {
                    am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDt, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDu, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDv, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDw, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bMR().game_score == 10.0d) {
                    am.setImageResource(this.gDs, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDt, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDu, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDv, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDw, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKU() != null) {
            bKU().a(getView(), this.gDy);
        }
    }
}
