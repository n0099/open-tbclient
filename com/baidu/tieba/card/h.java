package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class h extends a<com.baidu.tieba.e.g> {
    private View dividerLine;
    private com.baidu.tieba.e.g ewA;
    private TbImageView ewo;
    private LinearLayout ewp;
    private TextView ewq;
    private TextView ewr;
    private TextView ews;
    private LinearLayout ewt;
    private ImageView ewu;
    private ImageView ewv;
    private ImageView eww;
    private ImageView ewx;
    private ImageView ewy;
    private TextView ewz;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ewo = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.ewp = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.ewq = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.ewr = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.ews = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.ewt = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.ewu = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.ewv = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.eww = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.ewx = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.ewy = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.ewz = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.ewo.setDefaultResource(17170445);
        this.ewo.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ewo.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ewo.setDrawBorder(true);
        this.ewo.setBorderColor(al.getColor(R.color.common_color_10043));
        this.ewo.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ewo.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.color.cp_bg_line_d);
            al.k(this.dividerLine, R.color.cp_bg_line_e);
            al.f(this.ewq, R.color.cp_cont_b, 1);
            al.f(this.ewr, R.color.cp_cont_j, 1);
            al.f(this.ews, R.color.cp_cont_f, 1);
            al.f(this.ewz, R.color.cp_cont_j, 1);
            b(this.ewA);
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
        if (gVar != null && gVar.bca() != null) {
            this.ewA = gVar;
            this.ewo.startLoad(gVar.bca().avatar, 10, false);
            this.ewq.setText(gVar.bca().game_name);
            this.ewr.setText(gVar.bca().title_small);
            this.ews.setText(String.valueOf(gVar.bca().game_score));
            b(gVar);
            this.ewz.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, ap.aH(gVar.bca().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            al.c(this.ewx, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            al.c(this.ewy, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bca().game_score > 0.0d) {
                if (gVar.bca().game_score < 2.0d) {
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bca().game_score == 2.0d) {
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bca().game_score < 4.0d) {
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bca().game_score == 4.0d) {
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bca().game_score < 6.0d) {
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bca().game_score == 6.0d) {
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bca().game_score < 8.0d) {
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewx, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bca().game_score == 8.0d) {
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewx, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bca().game_score < 10.0d) {
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewx, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewy, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bca().game_score == 10.0d) {
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewx, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewy, (int) R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aXr() != null) {
            aXr().a(getView(), this.ewA);
        }
    }
}
