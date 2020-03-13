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
    private TbImageView fIN;
    private LinearLayout fIO;
    private TextView fIP;
    private TextView fIQ;
    private TextView fIR;
    private LinearLayout fIS;
    private ImageView fIT;
    private ImageView fIU;
    private ImageView fIV;
    private ImageView fIW;
    private ImageView fIX;
    private TextView fIY;
    private com.baidu.tieba.e.g fIZ;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fIN = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.fIO = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.fIP = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.fIQ = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.fIR = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.fIS = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.fIT = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.fIU = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.fIV = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.fIW = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.fIX = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.fIY = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.fIN.setDefaultResource(17170445);
        this.fIN.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fIN.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fIN.setDrawBorder(true);
        this.fIN.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fIN.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fIN.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fIP, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fIQ, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.fIR, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.fIY, R.color.cp_cont_j, 1);
            b(this.fIZ);
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
        if (gVar != null && gVar.bwG() != null) {
            this.fIZ = gVar;
            this.fIN.startLoad(gVar.bwG().avatar, 10, false);
            this.fIP.setText(gVar.bwG().game_name);
            this.fIQ.setText(gVar.bwG().title_small);
            this.fIR.setText(String.valueOf(gVar.bwG().game_score));
            b(gVar);
            this.fIY.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.bwG().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fIU, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fIV, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fIW, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fIX, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bwG().game_score > 0.0d) {
                if (gVar.bwG().game_score < 2.0d) {
                    am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwG().game_score == 2.0d) {
                    am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwG().game_score < 4.0d) {
                    am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIU, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwG().game_score == 4.0d) {
                    am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIU, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwG().game_score < 6.0d) {
                    am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIU, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIV, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwG().game_score == 6.0d) {
                    am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIU, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIV, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwG().game_score < 8.0d) {
                    am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIU, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIV, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIW, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwG().game_score == 8.0d) {
                    am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIU, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIV, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIW, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bwG().game_score < 10.0d) {
                    am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIU, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIV, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIW, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIX, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bwG().game_score == 10.0d) {
                    am.setImageResource(this.fIT, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIU, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIV, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIW, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fIX, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buH() != null) {
            buH().a(getView(), this.fIZ);
        }
    }
}
