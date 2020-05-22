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
    private TbImageView gDb;
    private LinearLayout gDc;
    private TextView gDd;
    private TextView gDe;
    private TextView gDf;
    private LinearLayout gDg;
    private ImageView gDh;
    private ImageView gDi;
    private ImageView gDj;
    private ImageView gDk;
    private ImageView gDl;
    private TextView gDm;
    private com.baidu.tieba.e.g gDn;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gDb = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.gDc = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.gDd = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.gDe = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.gDf = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.gDg = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.gDh = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.gDi = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.gDj = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.gDk = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.gDl = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.gDm = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.gDb.setDefaultResource(17170445);
        this.gDb.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gDb.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gDb.setDrawBorder(true);
        this.gDb.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gDb.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gDb.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.gDd, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gDe, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.gDf, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.gDm, R.color.cp_cont_j, 1);
            b(this.gDn);
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
        if (gVar != null && gVar.bMP() != null) {
            this.gDn = gVar;
            this.gDb.startLoad(gVar.bMP().avatar, 10, false);
            this.gDd.setText(gVar.bMP().game_name);
            this.gDe.setText(gVar.bMP().title_small);
            this.gDf.setText(String.valueOf(gVar.bMP().game_score));
            b(gVar);
            this.gDm.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.bMP().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gDi, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gDj, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gDk, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.gDl, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bMP().game_score > 0.0d) {
                if (gVar.bMP().game_score < 2.0d) {
                    am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bMP().game_score == 2.0d) {
                    am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bMP().game_score < 4.0d) {
                    am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDi, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bMP().game_score == 4.0d) {
                    am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDi, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bMP().game_score < 6.0d) {
                    am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDj, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bMP().game_score == 6.0d) {
                    am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDj, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bMP().game_score < 8.0d) {
                    am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDk, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bMP().game_score == 8.0d) {
                    am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDk, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bMP().game_score < 10.0d) {
                    am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDk, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDl, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bMP().game_score == 10.0d) {
                    am.setImageResource(this.gDh, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDi, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDj, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDk, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.gDl, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKS() != null) {
            bKS().a(getView(), this.gDn);
        }
    }
}
