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
    private TbImageView eKT;
    private LinearLayout eKU;
    private TextView eKV;
    private TextView eKW;
    private TextView eKX;
    private LinearLayout eKY;
    private ImageView eKZ;
    private ImageView eLa;
    private ImageView eLb;
    private ImageView eLc;
    private ImageView eLd;
    private TextView eLe;
    private com.baidu.tieba.e.g eLf;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eKT = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.eKU = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.eKV = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.eKW = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.eKX = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.eKY = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.eKZ = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.eLa = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.eLb = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.eLc = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.eLd = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.eLe = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.eKT.setDefaultResource(17170445);
        this.eKT.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eKT.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eKT.setDrawBorder(true);
        this.eKT.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eKT.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eKT.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.eKV, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eKW, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.eKX, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.eLe, R.color.cp_cont_j, 1);
            b(this.eLf);
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
        if (gVar != null && gVar.bcA() != null) {
            this.eLf = gVar;
            this.eKT.startLoad(gVar.bcA().avatar, 10, false);
            this.eKV.setText(gVar.bcA().game_name);
            this.eKW.setText(gVar.bcA().title_small);
            this.eKX.setText(String.valueOf(gVar.bcA().game_score));
            b(gVar);
            this.eLe.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.bcA().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.eLa, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.eLb, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.eLc, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.eLd, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bcA().game_score > 0.0d) {
                if (gVar.bcA().game_score < 2.0d) {
                    am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bcA().game_score == 2.0d) {
                    am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bcA().game_score < 4.0d) {
                    am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLa, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bcA().game_score == 4.0d) {
                    am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLa, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bcA().game_score < 6.0d) {
                    am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLa, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLb, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bcA().game_score == 6.0d) {
                    am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLa, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLb, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bcA().game_score < 8.0d) {
                    am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLa, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLb, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLc, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bcA().game_score == 8.0d) {
                    am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLa, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLb, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLc, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bcA().game_score < 10.0d) {
                    am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLa, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLb, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLc, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLd, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bcA().game_score == 10.0d) {
                    am.setImageResource(this.eKZ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLa, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLb, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLc, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.eLd, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZV() != null) {
            aZV().a(getView(), this.eLf);
        }
    }
}
