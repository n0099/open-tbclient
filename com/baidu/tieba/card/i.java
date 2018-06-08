package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class i extends a<com.baidu.tieba.e.g> {
    private View bir;
    private TbImageView cwZ;
    private LinearLayout cxa;
    private TextView cxb;
    private TextView cxc;
    private TextView cxd;
    private LinearLayout cxe;
    private ImageView cxf;
    private ImageView cxg;
    private ImageView cxh;
    private ImageView cxi;
    private ImageView cxj;
    private TextView cxk;
    private com.baidu.tieba.e.g cxl;

    public i(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cwZ = (TbImageView) view.findViewById(d.g.card_frs_game_score_img);
        this.cxa = (LinearLayout) view.findViewById(d.g.card_frs_game_score_info);
        this.cxb = (TextView) view.findViewById(d.g.card_frs_game_score_title);
        this.cxc = (TextView) view.findViewById(d.g.card_frs_game_score_info_dsc);
        this.cxd = (TextView) view.findViewById(d.g.card_frs_game_score_num);
        this.cxe = (LinearLayout) view.findViewById(d.g.card_frs_game_score_star_container);
        this.cxf = (ImageView) view.findViewById(d.g.card_frs_game_score_star1);
        this.cxg = (ImageView) view.findViewById(d.g.card_frs_game_score_star2);
        this.cxh = (ImageView) view.findViewById(d.g.card_frs_game_score_star3);
        this.cxi = (ImageView) view.findViewById(d.g.card_frs_game_score_star4);
        this.cxj = (ImageView) view.findViewById(d.g.card_frs_game_score_star5);
        this.cxk = (TextView) view.findViewById(d.g.card_frs_game_score_audience_num);
        this.cwZ.setDefaultResource(17170445);
        this.cwZ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cwZ.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cwZ.setDrawBorder(true);
        this.cwZ.setBorderColor(al.getColor(d.C0141d.common_color_10043));
        this.cwZ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.cwZ.setRadius(getContext().getResources().getDimensionPixelSize(d.e.tbds26));
        getView().setOnClickListener(this);
        this.bir = view.findViewById(d.g.divider_line);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.C0141d.cp_bg_line_d);
            al.i(this.bir, d.C0141d.cp_bg_line_e);
            al.c(this.cxb, d.C0141d.cp_cont_b, 1);
            al.c(this.cxc, d.C0141d.cp_cont_j, 1);
            al.c(this.cxd, d.C0141d.cp_cont_f, 1);
            al.c(this.cxk, d.C0141d.cp_cont_j, 1);
            b(this.cxl);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_game_score_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.g gVar) {
        if (gVar != null && gVar.anw() != null) {
            this.cxl = gVar;
            this.cwZ.startLoad(gVar.anw().avatar, 10, false);
            this.cxb.setText(gVar.anw().game_name);
            this.cxc.setText(gVar.anw().title_small);
            this.cxd.setText(String.valueOf(gVar.anw().game_score));
            b(gVar);
            this.cxk.setText(this.mContext.getResources().getString(d.k.frs_game_score_user_score_num, ao.A(gVar.anw().game_score_num)));
        }
    }

    private void b(com.baidu.tieba.e.g gVar) {
        if (gVar != null) {
            al.c(this.cxf, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cxg, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cxh, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cxi, d.f.game_comment_score_btn_small_empty_bg);
            al.c(this.cxj, d.f.game_comment_score_btn_small_empty_bg);
            if (gVar.anw().game_score > 0.0d) {
                if (gVar.anw().game_score < 2.0d) {
                    al.c(this.cxf, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anw().game_score == 2.0d) {
                    al.c(this.cxf, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anw().game_score < 4.0d) {
                    al.c(this.cxf, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxg, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anw().game_score == 4.0d) {
                    al.c(this.cxf, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxg, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anw().game_score < 6.0d) {
                    al.c(this.cxf, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxg, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxh, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anw().game_score == 6.0d) {
                    al.c(this.cxf, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxg, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxh, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anw().game_score < 8.0d) {
                    al.c(this.cxf, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxg, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxh, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxi, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anw().game_score == 8.0d) {
                    al.c(this.cxf, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxg, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxh, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxi, d.f.game_comment_score_btn_small_full_bg);
                } else if (gVar.anw().game_score < 10.0d) {
                    al.c(this.cxf, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxg, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxh, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxi, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxj, d.f.game_comment_score_btn_small_half_bg);
                } else if (gVar.anw().game_score == 10.0d) {
                    al.c(this.cxf, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxg, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxh, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxi, d.f.game_comment_score_btn_small_full_bg);
                    al.c(this.cxj, d.f.game_comment_score_btn_small_full_bg);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiI() != null) {
            aiI().a(getView(), this.cxl);
        }
    }
}
