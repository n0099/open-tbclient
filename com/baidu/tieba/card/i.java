package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class i extends b<com.baidu.tieba.e.g> {
    private View dividerLine;
    private TbImageView gVI;
    private LinearLayout gVJ;
    private TextView gVK;
    private TextView gVL;
    private TextView gVM;
    private LinearLayout gVN;
    private ImageView gVO;
    private ImageView gVP;
    private ImageView gVQ;
    private ImageView gVR;
    private ImageView gVS;
    private TextView gVT;
    private com.baidu.tieba.e.g gVU;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gVI = (TbImageView) view.findViewById(R.id.card_frs_game_score_img);
        this.gVJ = (LinearLayout) view.findViewById(R.id.card_frs_game_score_info);
        this.gVK = (TextView) view.findViewById(R.id.card_frs_game_score_title);
        this.gVL = (TextView) view.findViewById(R.id.card_frs_game_score_info_dsc);
        this.gVM = (TextView) view.findViewById(R.id.card_frs_game_score_num);
        this.gVN = (LinearLayout) view.findViewById(R.id.card_frs_game_score_star_container);
        this.gVO = (ImageView) view.findViewById(R.id.card_frs_game_score_star1);
        this.gVP = (ImageView) view.findViewById(R.id.card_frs_game_score_star2);
        this.gVQ = (ImageView) view.findViewById(R.id.card_frs_game_score_star3);
        this.gVR = (ImageView) view.findViewById(R.id.card_frs_game_score_star4);
        this.gVS = (ImageView) view.findViewById(R.id.card_frs_game_score_star5);
        this.gVT = (TextView) view.findViewById(R.id.card_frs_game_score_audience_num);
        this.gVI.setDefaultResource(17170445);
        this.gVI.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gVI.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gVI.setDrawBorder(true);
        this.gVI.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.gVI.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.gVI.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
        getView().setOnClickListener(this);
        this.dividerLine = view.findViewById(R.id.divider_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ao.setBackgroundResource(this.dividerLine, R.color.cp_bg_line_e);
            ao.setViewTextColor(this.gVK, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.gVL, R.color.cp_cont_j, 1);
            ao.setViewTextColor(this.gVM, R.color.cp_cont_f, 1);
            ao.setViewTextColor(this.gVT, R.color.cp_cont_j, 1);
            b(this.gVU);
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
        if (gVar != null && gVar.bTi() != null) {
            this.gVU = gVar;
            this.gVI.startLoad(gVar.bTi().avatar, 10, false);
            this.gVK.setText(gVar.bTi().game_name);
            this.gVL.setText(gVar.bTi().title_small);
            this.gVM.setText(String.valueOf(gVar.bTi().game_score));
            b(gVar);
            this.gVT.setText(this.mContext.getResources().getString(R.string.frs_game_score_user_score_num, as.numberUniform(gVar.bTi().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.gVP, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.gVQ, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.gVR, R.drawable.game_comment_score_btn_small_empty_bg);
            ao.setImageResource(this.gVS, R.drawable.game_comment_score_btn_small_empty_bg);
            if (gVar.bTi().game_score > 0.0d) {
                if (gVar.bTi().game_score < 2.0d) {
                    ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bTi().game_score == 2.0d) {
                    ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bTi().game_score < 4.0d) {
                    ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVP, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bTi().game_score == 4.0d) {
                    ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVP, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bTi().game_score < 6.0d) {
                    ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVP, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVQ, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bTi().game_score == 6.0d) {
                    ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVP, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVQ, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bTi().game_score < 8.0d) {
                    ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVP, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVR, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bTi().game_score == 8.0d) {
                    ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVP, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVR, R.drawable.game_comment_score_btn_small_full_bg);
                } else if (gVar.bTi().game_score < 10.0d) {
                    ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVP, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVR, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVS, R.drawable.game_comment_score_btn_small_half_bg);
                } else if (gVar.bTi().game_score == 10.0d) {
                    ao.setImageResource(this.gVO, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVP, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVQ, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVR, R.drawable.game_comment_score_btn_small_full_bg);
                    ao.setImageResource(this.gVS, R.drawable.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bRn() != null) {
            bRn().a(getView(), this.gVU);
        }
    }
}
