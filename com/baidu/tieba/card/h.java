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
/* loaded from: classes4.dex */
public class h extends a<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView eLK;
    private LinearLayout eLL;
    private TextView eLM;
    private TextView eLN;
    private TextView eLO;
    private LinearLayout eLP;
    private ImageView eLQ;
    private ImageView eLR;
    private ImageView eLS;
    private ImageView eLT;
    private ImageView eLU;
    private TextView eLV;
    private com.baidu.tieba.e.g eLW;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eLK = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.eLL = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.eLM = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.eLN = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.eLO = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.eLP = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.eLQ = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.eLR = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.eLS = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.eLT = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.eLU = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.eLV = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.eLK.setDefaultResource(17170445);
        this.eLK.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eLK.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eLK.setDrawBorder(true);
        this.eLK.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eLK.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eLK.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.eLM, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eLN, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.eLO, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.eLV, R.color.cp_cont_j, 1);
            b(this.eLW);
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
        if (gVar != null && gVar.bcC() != null) {
            this.eLW = gVar;
            this.eLK.startLoad(gVar.bcC().avatar, 10, false);
            this.eLM.setText(gVar.bcC().game_name);
            this.eLN.setText(gVar.bcC().title_small);
            this.eLO.setText(String.valueOf(gVar.bcC().game_score));
            b(gVar);
            this.eLV.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.bcC().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.eLR, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.eLS, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.eLT, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.eLU, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bcC().game_score > 0.0d) {
                if (gVar.bcC().game_score < 2.0d) {
                    am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bcC().game_score == 2.0d) {
                    am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bcC().game_score < 4.0d) {
                    am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLR, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bcC().game_score == 4.0d) {
                    am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLR, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bcC().game_score < 6.0d) {
                    am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLR, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLS, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bcC().game_score == 6.0d) {
                    am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLR, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLS, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bcC().game_score < 8.0d) {
                    am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLR, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLS, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLT, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bcC().game_score == 8.0d) {
                    am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLR, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLS, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLT, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bcC().game_score < 10.0d) {
                    am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLR, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLS, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLT, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLU, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bcC().game_score == 10.0d) {
                    am.setImageResource(this.eLQ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLR, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLS, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLT, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLU, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZX() != null) {
            aZX().a(getView(), this.eLW);
        }
    }
}
