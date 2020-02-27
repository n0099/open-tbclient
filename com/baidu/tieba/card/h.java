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
    private TextView fIA;
    private TextView fIB;
    private TextView fIC;
    private LinearLayout fID;
    private ImageView fIE;
    private ImageView fIF;
    private ImageView fIG;
    private ImageView fIH;
    private ImageView fII;
    private TextView fIJ;
    private com.baidu.tieba.e.g fIK;
    private TbImageView fIy;
    private LinearLayout fIz;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fIy = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.fIz = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.fIA = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.fIB = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.fIC = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.fID = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.fIE = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.fIF = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.fIG = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.fIH = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.fII = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.fIJ = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.fIy.setDefaultResource(17170445);
        this.fIy.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIy.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fIy.setDrawBorder(true);
        this.fIy.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIy.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fIy.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fIA, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fIB, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.fIC, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.fIJ, R.color.cp_cont_j, 1);
            b(this.fIK);
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
        if (gVar != null && gVar.bwD() != null) {
            this.fIK = gVar;
            this.fIy.startLoad(gVar.bwD().avatar, 10, false);
            this.fIA.setText(gVar.bwD().game_name);
            this.fIB.setText(gVar.bwD().title_small);
            this.fIC.setText(String.valueOf(gVar.bwD().game_score));
            b(gVar);
            this.fIJ.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.bwD().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fIF, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fII, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bwD().game_score > 0.0d) {
                if (gVar.bwD().game_score < 2.0d) {
                    am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwD().game_score == 2.0d) {
                    am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwD().game_score < 4.0d) {
                    am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIF, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwD().game_score == 4.0d) {
                    am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIF, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwD().game_score < 6.0d) {
                    am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIF, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwD().game_score == 6.0d) {
                    am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIF, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwD().game_score < 8.0d) {
                    am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIF, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwD().game_score == 8.0d) {
                    am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIF, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwD().game_score < 10.0d) {
                    am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIF, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fII, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwD().game_score == 10.0d) {
                    am.setImageResource(this.fIE, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIF, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIG, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIH, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fII, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buE() != null) {
            buE().a(getView(), this.fIK);
        }
    }
}
