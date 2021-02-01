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
    private TbImageView ivM;
    private LinearLayout ivN;
    private TextView ivO;
    private TextView ivP;
    private TextView ivQ;
    private LinearLayout ivR;
    private ImageView ivS;
    private ImageView ivT;
    private ImageView ivU;
    private ImageView ivV;
    private ImageView ivW;
    private TextView ivX;
    private com.baidu.tieba.e.g ivY;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ivM = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.ivN = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.ivO = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.ivP = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.ivQ = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.ivR = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.ivS = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.ivT = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.ivU = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.ivV = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.ivW = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.ivX = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.ivM.setDefaultResource(17170445);
        this.ivM.setDefaultBgResource(R.color.CAM_X0205);
        this.ivM.setDrawBorder(true);
        this.ivM.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ivM.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ivM.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.dividerLine, R.color.CAM_X0205);
            ap.setViewTextColor(this.ivO, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ivP, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.ivQ, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.ivX, R.color.CAM_X0107, 1);
            b(this.ivY);
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
        if (gVar != null && gVar.ctU() != null) {
            this.ivY = gVar;
            this.ivM.startLoad(gVar.ctU().avatar, 10, false);
            this.ivO.setText(gVar.ctU().game_name);
            this.ivP.setText(gVar.ctU().title_small);
            this.ivQ.setText(String.valueOf(gVar.ctU().game_score));
            b(gVar);
            this.ivX.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, au.numberUniform(gVar.ctU().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.ivT, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.ivU, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.ivV, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.ivW, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.ctU().game_score > 0.0d) {
                if (gVar.ctU().game_score < 2.0d) {
                    ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctU().game_score == 2.0d) {
                    ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctU().game_score < 4.0d) {
                    ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivT, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctU().game_score == 4.0d) {
                    ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivT, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctU().game_score < 6.0d) {
                    ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivT, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivU, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctU().game_score == 6.0d) {
                    ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivT, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivU, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctU().game_score < 8.0d) {
                    ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivT, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivU, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivV, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctU().game_score == 8.0d) {
                    ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivT, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivU, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivV, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctU().game_score < 10.0d) {
                    ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivT, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivU, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivV, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivW, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctU().game_score == 10.0d) {
                    ap.setImageResource(this.ivS, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivT, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivU, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivV, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ivW, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crV() != null) {
            crV().a(getView(), this.ivY);
        }
    }
}
