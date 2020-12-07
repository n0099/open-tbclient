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
    private TextView iiD;
    private com.baidu.tieba.f.g iiE;
    private TbImageView iis;
    private LinearLayout iit;
    private TextView iiu;
    private TextView iiv;
    private TextView iiw;
    private LinearLayout iix;
    private ImageView iiy;
    private ImageView iiz;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iis = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.iit = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.iiu = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.iiv = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.iiw = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.iix = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.iiy = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.iiz = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.iiA = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.iiB = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.iiC = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.iiD = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.iis.setDefaultResource(17170445);
        this.iis.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iis.setDefaultBgResource(R.color.CAM_X0205);
        this.iis.setDrawBorder(true);
        this.iis.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iis.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iis.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.dividerLine, R.color.CAM_X0205);
            ap.setViewTextColor(this.iiu, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.iiv, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.iiw, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.iiD, R.color.CAM_X0107, 1);
            b(this.iiE);
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
        if (gVar != null && gVar.ctF() != null) {
            this.iiE = gVar;
            this.iis.startLoad(gVar.ctF().avatar, 10, false);
            this.iiu.setText(gVar.ctF().game_name);
            this.iiv.setText(gVar.ctF().title_small);
            this.iiw.setText(String.valueOf(gVar.ctF().game_score));
            b(gVar);
            this.iiD.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, au.numberUniform(gVar.ctF().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.f.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iiz, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.iiC, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.ctF().game_score > 0.0d) {
                if (gVar.ctF().game_score < 2.0d) {
                    ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctF().game_score == 2.0d) {
                    ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctF().game_score < 4.0d) {
                    ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiz, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctF().game_score == 4.0d) {
                    ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiz, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctF().game_score < 6.0d) {
                    ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiz, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctF().game_score == 6.0d) {
                    ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiz, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctF().game_score < 8.0d) {
                    ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiz, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctF().game_score == 8.0d) {
                    ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiz, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.ctF().game_score < 10.0d) {
                    ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiz, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiC, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.ctF().game_score == 10.0d) {
                    ap.setImageResource(this.iiy, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiz, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiA, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiB, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.iiC, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crI() != null) {
            crI().a(getView(), this.iiE);
        }
    }
}
