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
/* loaded from: classes7.dex */
public class h extends a<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView fGb;
    private LinearLayout fGc;
    private TextView fGd;
    private TextView fGe;
    private TextView fGf;
    private LinearLayout fGg;
    private ImageView fGh;
    private ImageView fGi;
    private ImageView fGj;
    private ImageView fGk;
    private ImageView fGl;
    private TextView fGm;
    private com.baidu.tieba.e.g fGn;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fGb = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.fGc = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.fGd = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.fGe = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.fGf = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.fGg = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.fGh = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.fGi = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.fGj = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.fGk = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.fGl = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.fGm = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.fGb.setDefaultResource(17170445);
        this.fGb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fGb.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fGb.setDrawBorder(true);
        this.fGb.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fGb.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fGb.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fGd, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fGe, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.fGf, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.fGm, R.color.cp_cont_j, 1);
            b(this.fGn);
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
        if (gVar != null && gVar.buZ() != null) {
            this.fGn = gVar;
            this.fGb.startLoad(gVar.buZ().avatar, 10, false);
            this.fGd.setText(gVar.buZ().game_name);
            this.fGe.setText(gVar.buZ().title_small);
            this.fGf.setText(String.valueOf(gVar.buZ().game_score));
            b(gVar);
            this.fGm.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.buZ().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fGi, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fGj, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fGk, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fGl, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.buZ().game_score > 0.0d) {
                if (gVar.buZ().game_score < 2.0d) {
                    am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.buZ().game_score == 2.0d) {
                    am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.buZ().game_score < 4.0d) {
                    am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGi, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.buZ().game_score == 4.0d) {
                    am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGi, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.buZ().game_score < 6.0d) {
                    am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGj, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.buZ().game_score == 6.0d) {
                    am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGj, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.buZ().game_score < 8.0d) {
                    am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGk, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.buZ().game_score == 8.0d) {
                    am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGk, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.buZ().game_score < 10.0d) {
                    am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGk, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGl, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.buZ().game_score == 10.0d) {
                    am.setImageResource(this.fGh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGk, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fGl, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bta() != null) {
            bta().a(getView(), this.fGn);
        }
    }
}
