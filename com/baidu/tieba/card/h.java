package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class h extends b<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView iqi;
    private LinearLayout iqj;
    private TextView iqk;
    private TextView iql;
    private TextView iqm;
    private LinearLayout iqn;
    private ImageView iqo;
    private ImageView iqp;
    private ImageView iqq;
    private ImageView iqr;
    private ImageView iqs;
    private TextView iqt;
    private com.baidu.tieba.e.g iqu;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iqi = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.iqj = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.iqk = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.iql = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.iqm = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.iqn = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.iqo = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.iqp = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.iqq = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.iqr = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.iqs = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.iqt = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.iqi.setDefaultResource(17170445);
        this.iqi.setDefaultBgResource(R.color.CAM_X0205);
        this.iqi.setDrawBorder(true);
        this.iqi.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.iqi.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iqi.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.CAM_X0201);
            ao.setBackgroundResource(this.dividerLine, R.color.CAM_X0205);
            ao.setViewTextColor(this.iqk, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.iql, R.color.CAM_X0107, 1);
            ao.setViewTextColor(this.iqm, R.color.CAM_X0106, 1);
            ao.setViewTextColor(this.iqt, R.color.CAM_X0107, 1);
            b(this.iqu);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_score_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.g gVar) {
        if (gVar != null && gVar.csI() != null) {
            this.iqu = gVar;
            this.iqi.startLoad(gVar.csI().avatar, 10, false);
            this.iqk.setText(gVar.csI().game_name);
            this.iql.setText(gVar.csI().title_small);
            this.iqm.setText(String.valueOf(gVar.csI().game_score));
            b(gVar);
            this.iqt.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, at.numberUniform(gVar.csI().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.iqp, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.iqq, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.iqr, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.iqs, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.csI().game_score > 0.0d) {
                if (gVar.csI().game_score < 2.0d) {
                    ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.csI().game_score == 2.0d) {
                    ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.csI().game_score < 4.0d) {
                    ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqp, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.csI().game_score == 4.0d) {
                    ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqp, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.csI().game_score < 6.0d) {
                    ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqp, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqq, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.csI().game_score == 6.0d) {
                    ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqp, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqq, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.csI().game_score < 8.0d) {
                    ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqp, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqq, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqr, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.csI().game_score == 8.0d) {
                    ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqp, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqq, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqr, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.csI().game_score < 10.0d) {
                    ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqp, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqq, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqr, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqs, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.csI().game_score == 10.0d) {
                    ao.setImageResource(this.iqo, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqp, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqq, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqr, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.iqs, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cqL() != null) {
            cqL().a(getView(), this.iqu);
        }
    }
}
