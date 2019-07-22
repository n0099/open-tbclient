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
    private TbImageView eBn;
    private LinearLayout eBo;
    private TextView eBp;
    private TextView eBq;
    private TextView eBr;
    private LinearLayout eBs;
    private ImageView eBt;
    private ImageView eBu;
    private ImageView eBv;
    private ImageView eBw;
    private ImageView eBx;
    private TextView eBy;
    private com.baidu.tieba.e.g eBz;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eBn = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.eBo = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.eBp = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.eBq = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.eBr = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.eBs = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.eBt = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.eBu = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.eBv = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.eBw = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.eBx = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.eBy = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.eBn.setDefaultResource(17170445);
        this.eBn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eBn.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eBn.setDrawBorder(true);
        this.eBn.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eBn.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eBn.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.color.cp_bg_line_d);
            am.k(this.dividerLine, R.color.cp_bg_line_e);
            am.f(this.eBp, R.color.cp_cont_b, 1);
            am.f(this.eBq, R.color.cp_cont_j, 1);
            am.f(this.eBr, R.color.cp_cont_f, 1);
            am.f(this.eBy, R.color.cp_cont_j, 1);
            b(this.eBz);
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
        if (gVar != null && gVar.beb() != null) {
            this.eBz = gVar;
            this.eBn.startLoad(gVar.beb().avatar, 10, false);
            this.eBp.setText(gVar.beb().game_name);
            this.eBq.setText(gVar.beb().title_small);
            this.eBr.setText(String.valueOf(gVar.beb().game_score));
            b(gVar);
            this.eBy.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.aI(gVar.beb().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eBu, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eBv, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eBw, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eBx, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.beb().game_score > 0.0d) {
                if (gVar.beb().game_score < 2.0d) {
                    am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.beb().game_score == 2.0d) {
                    am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.beb().game_score < 4.0d) {
                    am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBu, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.beb().game_score == 4.0d) {
                    am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.beb().game_score < 6.0d) {
                    am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBv, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.beb().game_score == 6.0d) {
                    am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.beb().game_score < 8.0d) {
                    am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBw, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.beb().game_score == 8.0d) {
                    am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBw, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.beb().game_score < 10.0d) {
                    am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBw, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBx, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.beb().game_score == 10.0d) {
                    am.c(this.eBt, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBu, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBv, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBw, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBx, (int) R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZo() != null) {
            aZo().a(getView(), this.eBz);
        }
    }
}
