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
    private TbImageView hWV;
    private LinearLayout hWW;
    private TextView hWX;
    private TextView hWY;
    private TextView hWZ;
    private LinearLayout hXa;
    private ImageView hXb;
    private ImageView hXc;
    private ImageView hXd;
    private ImageView hXe;
    private ImageView hXf;
    private TextView hXg;
    private com.baidu.tieba.e.g hXh;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hWV = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.hWW = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.hWX = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.hWY = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.hWZ = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.hXa = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.hXb = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.hXc = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.hXd = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.hXe = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.hXf = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.hXg = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.hWV.setDefaultResource(17170445);
        this.hWV.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hWV.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hWV.setDrawBorder(true);
        this.hWV.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hWV.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hWV.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            ap.setViewTextColor(this.hWX, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hWY, R.color.cp_cont_j, 1);
            ap.setViewTextColor(this.hWZ, R.color.cp_cont_f, 1);
            ap.setViewTextColor(this.hXg, R.color.cp_cont_j, 1);
            b(this.hXh);
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
        if (gVar != null && gVar.cpO() != null) {
            this.hXh = gVar;
            this.hWV.startLoad(gVar.cpO().avatar, 10, false);
            this.hWX.setText(gVar.cpO().game_name);
            this.hWY.setText(gVar.cpO().title_small);
            this.hWZ.setText(String.valueOf(gVar.cpO().game_score));
            b(gVar);
            this.hXg.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, at.numberUniform(gVar.cpO().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hXc, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hXd, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hXe, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hXf, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.cpO().game_score > 0.0d) {
                if (gVar.cpO().game_score < 2.0d) {
                    ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cpO().game_score == 2.0d) {
                    ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cpO().game_score < 4.0d) {
                    ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXc, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cpO().game_score == 4.0d) {
                    ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXc, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cpO().game_score < 6.0d) {
                    ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXc, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXd, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cpO().game_score == 6.0d) {
                    ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXc, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXd, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cpO().game_score < 8.0d) {
                    ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXc, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXd, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXe, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cpO().game_score == 8.0d) {
                    ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXc, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXd, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXe, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cpO().game_score < 10.0d) {
                    ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXc, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXd, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXe, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXf, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cpO().game_score == 10.0d) {
                    ap.setImageResource(this.hXb, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXc, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXd, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXe, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXf, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnT() != null) {
            cnT().a(getView(), this.hXh);
        }
    }
}
