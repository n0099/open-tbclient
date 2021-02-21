package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class h extends b<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView iwa;
    private LinearLayout iwb;
    private TextView iwc;
    private TextView iwd;
    private TextView iwe;
    private LinearLayout iwf;
    private ImageView iwg;
    private ImageView iwh;
    private ImageView iwi;
    private ImageView iwj;
    private ImageView iwk;
    private TextView iwl;
    private com.baidu.tieba.e.g iwm;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iwa = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.iwb = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.iwc = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.iwd = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.iwe = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.iwf = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.iwg = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.iwh = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.iwi = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.iwj = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.iwk = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.iwl = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.iwa.setDefaultResource(17170445);
        this.iwa.setDefaultBgResource(R.color.CAM_X0205);
        this.iwa.setDrawBorder(true);
        this.iwa.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iwa.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iwa.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.dividerLine, R.color.CAM_X0205);
            ap.setViewTextColor(this.iwc, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.iwd, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.iwe, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.iwl, R.color.CAM_X0107, 1);
            b(this.iwm);
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
        if (gVar != null && gVar.cub() != null) {
            this.iwm = gVar;
            this.iwa.startLoad(gVar.cub().avatar, 10, false);
            this.iwc.setText(gVar.cub().game_name);
            this.iwd.setText(gVar.cub().title_small);
            this.iwe.setText(String.valueOf(gVar.cub().game_score));
            b(gVar);
            this.iwl.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, au.numberUniform(gVar.cub().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iwh, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iwi, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iwj, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iwk, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.cub().game_score > 0.0d) {
                if (gVar.cub().game_score < 2.0d) {
                    ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cub().game_score == 2.0d) {
                    ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cub().game_score < 4.0d) {
                    ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwh, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cub().game_score == 4.0d) {
                    ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwh, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cub().game_score < 6.0d) {
                    ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwh, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwi, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cub().game_score == 6.0d) {
                    ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwh, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwi, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cub().game_score < 8.0d) {
                    ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwh, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwi, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwj, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cub().game_score == 8.0d) {
                    ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwh, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwi, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwj, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cub().game_score < 10.0d) {
                    ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwh, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwi, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwj, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwk, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cub().game_score == 10.0d) {
                    ap.setImageResource(this.iwg, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwh, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwi, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwj, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iwk, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csc() != null) {
            csc().a(getView(), this.iwm);
        }
    }
}
