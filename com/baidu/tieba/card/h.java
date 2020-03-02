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
    private TbImageView fIA;
    private LinearLayout fIB;
    private TextView fIC;
    private TextView fID;
    private TextView fIE;
    private LinearLayout fIF;
    private ImageView fIG;
    private ImageView fIH;
    private ImageView fII;
    private ImageView fIJ;
    private ImageView fIK;
    private TextView fIL;
    private com.baidu.tieba.e.g fIM;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fIA = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.fIB = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.fIC = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.fID = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.fIE = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.fIF = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.fIG = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.fIH = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.fII = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.fIJ = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.fIK = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.fIL = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.fIA.setDefaultResource(17170445);
        this.fIA.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIA.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fIA.setDrawBorder(true);
        this.fIA.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIA.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fIA.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fIC, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fID, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.fIE, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.fIL, R.color.cp_cont_j, 1);
            b(this.fIM);
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
        if (gVar != null && gVar.bwF() != null) {
            this.fIM = gVar;
            this.fIA.startLoad(gVar.bwF().avatar, 10, false);
            this.fIC.setText(gVar.bwF().game_name);
            this.fID.setText(gVar.bwF().title_small);
            this.fIE.setText(String.valueOf(gVar.bwF().game_score));
            b(gVar);
            this.fIL.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.bwF().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fII, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fIJ, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fIK, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bwF().game_score > 0.0d) {
                if (gVar.bwF().game_score < 2.0d) {
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwF().game_score == 2.0d) {
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwF().game_score < 4.0d) {
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwF().game_score == 4.0d) {
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwF().game_score < 6.0d) {
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fII, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwF().game_score == 6.0d) {
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fII, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwF().game_score < 8.0d) {
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fII, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIJ, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwF().game_score == 8.0d) {
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fII, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIJ, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwF().game_score < 10.0d) {
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fII, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIJ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIK, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwF().game_score == 10.0d) {
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fII, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIJ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIK, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buG() != null) {
            buG().a(getView(), this.fIM);
        }
    }
}
