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
/* loaded from: classes22.dex */
public class i extends b<com.baidu.tieba.f.g> {
    private View dividerLine;
    private ImageView iiA;
    private ImageView iiB;
    private ImageView iiC;
    private ImageView iiD;
    private ImageView iiE;
    private TextView iiF;
    private com.baidu.tieba.f.g iiG;
    private TbImageView iiu;
    private LinearLayout iiv;
    private TextView iiw;
    private TextView iix;
    private TextView iiy;
    private LinearLayout iiz;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iiu = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.iiv = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.iiw = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.iix = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.iiy = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.iiz = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.iiA = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.iiB = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.iiC = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.iiD = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.iiE = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.iiF = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.iiu.setDefaultResource(17170445);
        this.iiu.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iiu.setDefaultBgResource(R.color.CAM_X0205);
        this.iiu.setDrawBorder(true);
        this.iiu.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iiu.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iiu.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.dividerLine, R.color.CAM_X0205);
            ap.setViewTextColor(this.iiw, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.iix, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.iiy, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.iiF, R.color.CAM_X0107, 1);
            b(this.iiG);
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
        if (gVar != null && gVar.ctG() != null) {
            this.iiG = gVar;
            this.iiu.startLoad(gVar.ctG().avatar, 10, false);
            this.iiw.setText(gVar.ctG().game_name);
            this.iix.setText(gVar.ctG().title_small);
            this.iiy.setText(String.valueOf(gVar.ctG().game_score));
            b(gVar);
            this.iiF.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, au.numberUniform(gVar.ctG().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.f.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iiC, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iiD, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iiE, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.ctG().game_score > 0.0d) {
                if (gVar.ctG().game_score < 2.0d) {
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctG().game_score == 2.0d) {
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctG().game_score < 4.0d) {
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctG().game_score == 4.0d) {
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctG().game_score < 6.0d) {
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiC, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctG().game_score == 6.0d) {
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiC, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctG().game_score < 8.0d) {
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiC, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiD, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctG().game_score == 8.0d) {
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiC, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiD, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctG().game_score < 10.0d) {
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiC, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiD, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiE, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctG().game_score == 10.0d) {
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiC, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiD, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiE, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crJ() != null) {
            crJ().a(getView(), this.iiG);
        }
    }
}
