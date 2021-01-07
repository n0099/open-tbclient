package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class h extends b<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView iuP;
    private LinearLayout iuQ;
    private TextView iuR;
    private TextView iuS;
    private TextView iuT;
    private LinearLayout iuU;
    private ImageView iuV;
    private ImageView iuW;
    private ImageView iuX;
    private ImageView iuY;
    private ImageView iuZ;
    private TextView iva;
    private com.baidu.tieba.e.g ivb;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iuP = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.iuQ = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.iuR = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.iuS = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.iuT = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.iuU = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.iuV = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.iuW = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.iuX = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.iuY = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.iuZ = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.iva = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.iuP.setDefaultResource(17170445);
        this.iuP.setDefaultBgResource(R.color.CAM_X0205);
        this.iuP.setDrawBorder(true);
        this.iuP.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.iuP.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iuP.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.CAM_X0201);
            ao.setBackgroundResource(this.dividerLine, R.color.CAM_X0205);
            ao.setViewTextColor(this.iuR, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.iuS, R.color.CAM_X0107, 1);
            ao.setViewTextColor(this.iuT, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.iva, R.color.CAM_X0107, 1);
            b(this.ivb);
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
        if (gVar != null && gVar.cwA() != null) {
            this.ivb = gVar;
            this.iuP.startLoad(gVar.cwA().avatar, 10, false);
            this.iuR.setText(gVar.cwA().game_name);
            this.iuS.setText(gVar.cwA().title_small);
            this.iuT.setText(String.valueOf(gVar.cwA().game_score));
            b(gVar);
            this.iva.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, at.numberUniform(gVar.cwA().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.iuW, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.iuX, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.iuY, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.iuZ, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.cwA().game_score > 0.0d) {
                if (gVar.cwA().game_score < 2.0d) {
                    ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cwA().game_score == 2.0d) {
                    ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cwA().game_score < 4.0d) {
                    ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuW, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cwA().game_score == 4.0d) {
                    ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuW, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cwA().game_score < 6.0d) {
                    ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuW, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuX, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cwA().game_score == 6.0d) {
                    ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuW, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuX, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cwA().game_score < 8.0d) {
                    ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuW, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuX, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuY, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cwA().game_score == 8.0d) {
                    ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuW, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuX, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuY, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cwA().game_score < 10.0d) {
                    ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuW, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuX, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuY, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuZ, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cwA().game_score == 10.0d) {
                    ao.setImageResource(this.iuV, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuW, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuX, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuY, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iuZ, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cuD() != null) {
            cuD().a(getView(), this.ivb);
        }
    }
}
