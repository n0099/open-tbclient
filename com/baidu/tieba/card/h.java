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
    private TbImageView ewn;
    private LinearLayout ewo;
    private TextView ewp;
    private TextView ewq;
    private TextView ewr;
    private LinearLayout ews;
    private ImageView ewt;
    private ImageView ewu;
    private ImageView ewv;
    private ImageView eww;
    private ImageView ewx;
    private TextView ewy;
    private com.baidu.tieba.e.g ewz;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ewn = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.ewo = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.ewp = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.ewq = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.ewr = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.ews = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.ewt = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.ewu = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.ewv = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.eww = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.ewx = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.ewy = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.ewn.setDefaultResource(17170445);
        this.ewn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ewn.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ewn.setDrawBorder(true);
        this.ewn.setBorderColor(al.getColor(R.color.common_color_10043));
        this.ewn.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ewn.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), R.color.cp_bg_line_d);
            al.k(this.dividerLine, R.color.cp_bg_line_e);
            al.f(this.ewp, R.color.cp_cont_b, 1);
            al.f(this.ewq, R.color.cp_cont_j, 1);
            al.f(this.ewr, R.color.cp_cont_f, 1);
            al.f(this.ewy, R.color.cp_cont_j, 1);
            b(this.ewz);
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
        if (gVar != null && gVar.bbX() != null) {
            this.ewz = gVar;
            this.ewn.startLoad(gVar.bbX().avatar, 10, false);
            this.ewp.setText(gVar.bbX().game_name);
            this.ewq.setText(gVar.bbX().title_small);
            this.ewr.setText(String.valueOf(gVar.bbX().game_score));
            b(gVar);
            this.ewy.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, ap.aH(gVar.bbX().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            al.c(this.ewx, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bbX().game_score > 0.0d) {
                if (gVar.bbX().game_score < 2.0d) {
                    al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bbX().game_score == 2.0d) {
                    al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bbX().game_score < 4.0d) {
                    al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bbX().game_score == 4.0d) {
                    al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bbX().game_score < 6.0d) {
                    al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bbX().game_score == 6.0d) {
                    al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bbX().game_score < 8.0d) {
                    al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bbX().game_score == 8.0d) {
                    al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bbX().game_score < 10.0d) {
                    al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewx, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bbX().game_score == 10.0d) {
                    al.c(this.ewt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.eww, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    al.c(this.ewx, (int) R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aXo() != null) {
            aXo().a(getView(), this.ewz);
        }
    }
}
