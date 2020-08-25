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
/* loaded from: classes16.dex */
public class i extends b<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView hiB;
    private LinearLayout hiC;
    private TextView hiD;
    private TextView hiE;
    private TextView hiF;
    private LinearLayout hiG;
    private ImageView hiH;
    private ImageView hiI;
    private ImageView hiJ;
    private ImageView hiK;
    private ImageView hiL;
    private TextView hiM;
    private com.baidu.tieba.e.g hiN;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hiB = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.hiC = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.hiD = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.hiE = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.hiF = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.hiG = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.hiH = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.hiI = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.hiJ = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.hiK = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.hiL = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.hiM = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.hiB.setDefaultResource(17170445);
        this.hiB.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hiB.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hiB.setDrawBorder(true);
        this.hiB.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hiB.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hiB.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hiD, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hiE, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.hiF, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.hiM, R.color.cp_cont_j, 1);
            b(this.hiN);
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
        if (gVar != null && gVar.cdu() != null) {
            this.hiN = gVar;
            this.hiB.startLoad(gVar.cdu().avatar, 10, false);
            this.hiD.setText(gVar.cdu().game_name);
            this.hiE.setText(gVar.cdu().title_small);
            this.hiF.setText(String.valueOf(gVar.cdu().game_score));
            b(gVar);
            this.hiM.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, at.numberUniform(gVar.cdu().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hiI, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hiJ, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hiK, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.cdu().game_score > 0.0d) {
                if (gVar.cdu().game_score < 2.0d) {
                    ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cdu().game_score == 2.0d) {
                    ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cdu().game_score < 4.0d) {
                    ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiI, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cdu().game_score == 4.0d) {
                    ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiI, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cdu().game_score < 6.0d) {
                    ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiJ, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cdu().game_score == 6.0d) {
                    ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiJ, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cdu().game_score < 8.0d) {
                    ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiJ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiK, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cdu().game_score == 8.0d) {
                    ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiJ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiK, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cdu().game_score < 10.0d) {
                    ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiJ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiK, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cdu().game_score == 10.0d) {
                    ap.setImageResource(this.hiH, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiI, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiJ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiK, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbz() != null) {
            cbz().a(getView(), this.hiN);
        }
    }
}
