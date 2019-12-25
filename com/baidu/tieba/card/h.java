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
/* loaded from: classes6.dex */
public class h extends a<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView fCQ;
    private LinearLayout fCR;
    private TextView fCS;
    private TextView fCT;
    private TextView fCU;
    private LinearLayout fCV;
    private ImageView fCW;
    private ImageView fCX;
    private ImageView fCY;
    private ImageView fCZ;
    private ImageView fDa;
    private TextView fDb;
    private com.baidu.tieba.e.g fDc;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fCQ = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.fCR = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.fCS = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.fCT = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.fCU = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.fCV = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.fCW = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.fCX = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.fCY = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.fCZ = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.fDa = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.fDb = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.fCQ.setDefaultResource(17170445);
        this.fCQ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fCQ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fCQ.setDrawBorder(true);
        this.fCQ.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fCQ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.fCQ.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            am.setViewTextColor(this.fCS, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.fCT, R.color.cp_cont_j, 1);
            am.setViewTextColor(this.fCU, R.color.cp_cont_f, 1);
            am.setViewTextColor(this.fDb, R.color.cp_cont_j, 1);
            b(this.fDc);
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
        if (gVar != null && gVar.btX() != null) {
            this.fDc = gVar;
            this.fCQ.startLoad(gVar.btX().avatar, 10, false);
            this.fCS.setText(gVar.btX().game_name);
            this.fCT.setText(gVar.btX().title_small);
            this.fCU.setText(String.valueOf(gVar.btX().game_score));
            b(gVar);
            this.fDb.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.numberUniform(gVar.btX().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fCX, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fCY, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fCZ, R.drawable.game_comment_score_btn_small_empty_bg);
            am.setImageResource(this.fDa, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.btX().game_score > 0.0d) {
                if (gVar.btX().game_score < 2.0d) {
                    am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.btX().game_score == 2.0d) {
                    am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.btX().game_score < 4.0d) {
                    am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCX, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.btX().game_score == 4.0d) {
                    am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCX, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.btX().game_score < 6.0d) {
                    am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCX, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCY, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.btX().game_score == 6.0d) {
                    am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCX, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCY, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.btX().game_score < 8.0d) {
                    am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCX, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCY, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCZ, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.btX().game_score == 8.0d) {
                    am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCX, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCY, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCZ, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.btX().game_score < 10.0d) {
                    am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCX, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCY, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCZ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fDa, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.btX().game_score == 10.0d) {
                    am.setImageResource(this.fCW, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCX, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCY, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fCZ, R.drawable.game_comment_score_btn_small_full_bg);
                    am.setImageResource(this.fDa, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (brY() != null) {
            brY().a(getView(), this.fDc);
        }
    }
}
