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
    private TbImageView eDd;
    private LinearLayout eDe;
    private TextView eDf;
    private TextView eDg;
    private TextView eDh;
    private LinearLayout eDi;
    private ImageView eDj;
    private ImageView eDk;
    private ImageView eDl;
    private ImageView eDm;
    private ImageView eDn;
    private TextView eDo;
    private com.baidu.tieba.e.g eDp;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eDd = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.eDe = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.eDf = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.eDg = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.eDh = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.eDi = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.eDj = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.eDk = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.eDl = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.eDm = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.eDn = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.eDo = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.eDd.setDefaultResource(17170445);
        this.eDd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eDd.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eDd.setDrawBorder(true);
        this.eDd.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eDd.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eDd.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.color.cp_bg_line_d);
            am.k(this.dividerLine, R.color.cp_bg_line_e);
            am.f(this.eDf, R.color.cp_cont_b, 1);
            am.f(this.eDg, R.color.cp_cont_j, 1);
            am.f(this.eDh, R.color.cp_cont_f, 1);
            am.f(this.eDo, R.color.cp_cont_j, 1);
            b(this.eDp);
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
        if (gVar != null && gVar.beH() != null) {
            this.eDp = gVar;
            this.eDd.startLoad(gVar.beH().avatar, 10, false);
            this.eDf.setText(gVar.beH().game_name);
            this.eDg.setText(gVar.beH().title_small);
            this.eDh.setText(String.valueOf(gVar.beH().game_score));
            b(gVar);
            this.eDo.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.aI(gVar.beH().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eDk, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eDl, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eDm, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eDn, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.beH().game_score > 0.0d) {
                if (gVar.beH().game_score < 2.0d) {
                    am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.beH().game_score == 2.0d) {
                    am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.beH().game_score < 4.0d) {
                    am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDk, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.beH().game_score == 4.0d) {
                    am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDk, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.beH().game_score < 6.0d) {
                    am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDk, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDl, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.beH().game_score == 6.0d) {
                    am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDk, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDl, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.beH().game_score < 8.0d) {
                    am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDk, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDl, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDm, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.beH().game_score == 8.0d) {
                    am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDk, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDl, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDm, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.beH().game_score < 10.0d) {
                    am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDk, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDl, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDm, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDn, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.beH().game_score == 10.0d) {
                    am.c(this.eDj, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDk, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDl, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDm, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eDn, (int) R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZU() != null) {
            aZU().a(getView(), this.eDp);
        }
    }
}
