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
/* loaded from: classes2.dex */
public class h extends b<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView ixJ;
    private LinearLayout ixK;
    private TextView ixL;
    private TextView ixM;
    private TextView ixN;
    private LinearLayout ixO;
    private ImageView ixP;
    private ImageView ixQ;
    private ImageView ixR;
    private ImageView ixS;
    private ImageView ixT;
    private TextView ixU;
    private com.baidu.tieba.e.g ixV;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ixJ = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.ixK = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.ixL = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.ixM = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.ixN = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.ixO = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.ixP = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.ixQ = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.ixR = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.ixS = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.ixT = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.ixU = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.ixJ.setDefaultResource(17170445);
        this.ixJ.setDefaultBgResource(R.color.CAM_X0205);
        this.ixJ.setDrawBorder(true);
        this.ixJ.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ixJ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.ixJ.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.dividerLine, R.color.CAM_X0205);
            ap.setViewTextColor(this.ixL, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ixM, R.color.CAM_X0107, 1);
            ap.setViewTextColor(this.ixN, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.ixU, R.color.CAM_X0107, 1);
            b(this.ixV);
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
        if (gVar != null && gVar.cuh() != null) {
            this.ixV = gVar;
            this.ixJ.startLoad(gVar.cuh().avatar, 10, false);
            this.ixL.setText(gVar.cuh().game_name);
            this.ixM.setText(gVar.cuh().title_small);
            this.ixN.setText(String.valueOf(gVar.cuh().game_score));
            b(gVar);
            this.ixU.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, au.numberUniform(gVar.cuh().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.ixQ, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.ixR, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.ixS, R.drawable.game_comment_score_btn_small_empty_bg);
            ap.setImageResource(this.ixT, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.cuh().game_score > 0.0d) {
                if (gVar.cuh().game_score < 2.0d) {
                    ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cuh().game_score == 2.0d) {
                    ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cuh().game_score < 4.0d) {
                    ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixQ, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cuh().game_score == 4.0d) {
                    ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixQ, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cuh().game_score < 6.0d) {
                    ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixR, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cuh().game_score == 6.0d) {
                    ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixR, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cuh().game_score < 8.0d) {
                    ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixR, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixS, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cuh().game_score == 8.0d) {
                    ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixR, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixS, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.cuh().game_score < 10.0d) {
                    ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixR, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixS, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixT, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.cuh().game_score == 10.0d) {
                    ap.setImageResource(this.ixP, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixR, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixS, R.drawable.game_comment_score_btn_small_full_bg);
                    ap.setImageResource(this.ixT, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csi() != null) {
            csi().a(getView(), this.ixV);
        }
    }
}
