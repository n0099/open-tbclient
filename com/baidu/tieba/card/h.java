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
    private ImageView eBA;
    private ImageView eBB;
    private ImageView eBC;
    private ImageView eBD;
    private ImageView eBE;
    private TextView eBF;
    private com.baidu.tieba.e.g eBG;
    private TbImageView eBu;
    private LinearLayout eBv;
    private TextView eBw;
    private TextView eBx;
    private TextView eBy;
    private LinearLayout eBz;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eBu = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.eBv = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.eBw = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.eBx = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.eBy = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.eBz = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.eBA = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.eBB = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.eBC = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.eBD = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.eBE = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.eBF = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.eBu.setDefaultResource(17170445);
        this.eBu.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eBu.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eBu.setDrawBorder(true);
        this.eBu.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eBu.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.eBu.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.color.cp_bg_line_d);
            am.k(this.dividerLine, R.color.cp_bg_line_e);
            am.f(this.eBw, R.color.cp_cont_b, 1);
            am.f(this.eBx, R.color.cp_cont_j, 1);
            am.f(this.eBy, R.color.cp_cont_f, 1);
            am.f(this.eBF, R.color.cp_cont_j, 1);
            b(this.eBG);
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
        if (gVar != null && gVar.bed() != null) {
            this.eBG = gVar;
            this.eBu.startLoad(gVar.bed().avatar, 10, false);
            this.eBw.setText(gVar.bed().game_name);
            this.eBx.setText(gVar.bed().title_small);
            this.eBy.setText(String.valueOf(gVar.bed().game_score));
            b(gVar);
            this.eBF.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, aq.aI(gVar.bed().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eBB, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eBC, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eBD, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            am.c(this.eBE, (int) R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bed().game_score > 0.0d) {
                if (gVar.bed().game_score < 2.0d) {
                    am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bed().game_score == 2.0d) {
                    am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bed().game_score < 4.0d) {
                    am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBB, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bed().game_score == 4.0d) {
                    am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBB, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bed().game_score < 6.0d) {
                    am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBB, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBC, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bed().game_score == 6.0d) {
                    am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBB, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBC, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bed().game_score < 8.0d) {
                    am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBB, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBC, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBD, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bed().game_score == 8.0d) {
                    am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBB, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBC, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBD, (int) R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bed().game_score < 10.0d) {
                    am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBB, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBC, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBD, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBE, (int) R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bed().game_score == 10.0d) {
                    am.c(this.eBA, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBB, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBC, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBD, (int) R.drawable.game_comment_score_btn_small_full_bg);
                    am.c(this.eBE, (int) R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZq() != null) {
            aZq().a(getView(), this.eBG);
        }
    }
}
