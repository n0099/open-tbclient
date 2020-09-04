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
    private TbImageView hiF;
    private LinearLayout hiG;
    private TextView hiH;
    private TextView hiI;
    private TextView hiJ;
    private LinearLayout hiK;
    private ImageView hiL;
    private ImageView hiM;
    private ImageView hiN;
    private ImageView hiO;
    private ImageView hiP;
    private TextView hiQ;
    private com.baidu.tieba.e.g hiR;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hiF = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.hiG = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.hiH = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.hiI = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.hiJ = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.hiK = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.hiL = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.hiM = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.hiN = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.hiO = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.hiP = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.hiQ = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.hiF.setDefaultResource(17170445);
        this.hiF.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hiF.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hiF.setDrawBorder(true);
        this.hiF.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hiF.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hiF.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hiH, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hiI, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.hiJ, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.hiQ, R.color.cp_cont_j, 1);
            b(this.hiR);
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
        if (gVar != null && gVar.cdv() != null) {
            this.hiR = gVar;
            this.hiF.startLoad(gVar.cdv().avatar, 10, false);
            this.hiH.setText(gVar.cdv().game_name);
            this.hiI.setText(gVar.cdv().title_small);
            this.hiJ.setText(String.valueOf(gVar.cdv().game_score));
            b(gVar);
            this.hiQ.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, at.numberUniform(gVar.cdv().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hiM, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hiN, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hiO, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hiP, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.cdv().game_score > 0.0d) {
                if (gVar.cdv().game_score < 2.0d) {
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cdv().game_score == 2.0d) {
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cdv().game_score < 4.0d) {
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiM, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cdv().game_score == 4.0d) {
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiM, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cdv().game_score < 6.0d) {
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiM, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiN, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cdv().game_score == 6.0d) {
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiM, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiN, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cdv().game_score < 8.0d) {
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiM, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiN, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiO, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cdv().game_score == 8.0d) {
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiM, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiN, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiO, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cdv().game_score < 10.0d) {
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiM, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiN, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiO, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiP, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cdv().game_score == 10.0d) {
                    ap.setImageResource(this.hiL, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiM, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiN, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiO, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hiP, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbA() != null) {
            cbA().a(getView(), this.hiR);
        }
    }
}
