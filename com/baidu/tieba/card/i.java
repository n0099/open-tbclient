package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class i extends b<com.baidu.tieba.f.g> {
    private View dividerLine;
    private LinearLayout hXA;
    private ImageView hXB;
    private ImageView hXC;
    private ImageView hXD;
    private ImageView hXE;
    private ImageView hXF;
    private TextView hXG;
    private com.baidu.tieba.f.g hXH;
    private TbImageView hXv;
    private LinearLayout hXw;
    private TextView hXx;
    private TextView hXy;
    private TextView hXz;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hXv = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.hXw = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.hXx = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.hXy = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.hXz = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.hXA = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.hXB = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.hXC = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.hXD = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.hXE = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.hXF = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.hXG = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.hXv.setDefaultResource(17170445);
        this.hXv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hXv.setDefaultBgResource(R.color.CAM_X0205);
        this.hXv.setDrawBorder(true);
        this.hXv.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hXv.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.hXv.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.dividerLine, R.color.CAM_X0205);
            ap.setViewTextColor(this.hXx, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.hXy, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.hXz, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.hXG, R.color.CAM_X0107, 1);
            b(this.hXH);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_score_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.f.g gVar) {
        if (gVar != null && gVar.cpr() != null) {
            this.hXH = gVar;
            this.hXv.startLoad(gVar.cpr().avatar, 10, false);
            this.hXx.setText(gVar.cpr().game_name);
            this.hXy.setText(gVar.cpr().title_small);
            this.hXz.setText(String.valueOf(gVar.cpr().game_score));
            b(gVar);
            this.hXG.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, au.numberUniform(gVar.cpr().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.f.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hXC, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hXD, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hXE, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.hXF, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.cpr().game_score > 0.0d) {
                if (gVar.cpr().game_score < 2.0d) {
                    ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cpr().game_score == 2.0d) {
                    ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cpr().game_score < 4.0d) {
                    ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXC, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cpr().game_score == 4.0d) {
                    ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXC, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cpr().game_score < 6.0d) {
                    ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXC, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXD, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cpr().game_score == 6.0d) {
                    ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXC, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXD, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cpr().game_score < 8.0d) {
                    ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXC, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXD, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXE, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cpr().game_score == 8.0d) {
                    ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXC, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXD, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXE, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cpr().game_score < 10.0d) {
                    ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXC, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXD, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXE, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXF, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cpr().game_score == 10.0d) {
                    ap.setImageResource(this.hXB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXC, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXD, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXE, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.hXF, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnv() != null) {
            cnv().a(getView(), this.hXH);
        }
    }
}
