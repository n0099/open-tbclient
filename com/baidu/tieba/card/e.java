package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private LinearLayout efG;
    private RelativeLayout efI;
    private ImageView efK;
    private ClickableHeaderImageView efN;
    private View efR;
    private TextView efT;
    private TextView efU;
    private TextView efV;
    private TextView efW;
    private com.baidu.tieba.e.b efX;
    private TbImageView imgThumbnail;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.efG = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.efI = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(d.g.img_thumbnail);
        this.efK = (ImageView) view.findViewById(d.g.img_play);
        this.efT = (TextView) view.findViewById(d.g.card_frs_game_video_time);
        this.efU = (TextView) view.findViewById(d.g.card_frs_game_video_title);
        this.efN = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.efV = (TextView) view.findViewById(d.g.card_frs_game_read_time_or_name);
        this.efW = (TextView) view.findViewById(d.g.card_frs_game_publish_time);
        this.efR = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(d.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.efI.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.efI.setLayoutParams(layoutParams);
        this.efN.setDefaultResource(17170445);
        this.efN.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.efN.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.efN.setIsRound(true);
        this.efN.setDrawBorder(true);
        this.efN.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efN.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void om(int i) {
        if (this.efR != null) {
            this.efR.setVisibility(i);
        }
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.efG != null) {
            this.efG.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.C0277d.cp_bg_line_d);
            al.k(this.efR, d.C0277d.cp_bg_line_c);
            al.d(this.efT, d.C0277d.cp_btn_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CN(this.efX.WR().getId())) {
                al.j(this.efU, d.C0277d.cp_cont_c);
            } else {
                al.j(this.efU, d.C0277d.cp_cont_b);
            }
            al.d(this.efV, d.C0277d.cp_cont_d, 1);
            al.d(this.efW, d.C0277d.cp_cont_d, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_common_small_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.b bVar) {
        if (bVar != null && bVar.WR() != null) {
            this.efX = bVar;
            String str = null;
            if (bVar.WR().ZL()) {
                this.efK.setVisibility(0);
                this.efT.setVisibility(0);
                if (bVar.WR().Zi() != null) {
                    this.efT.setText(ap.hz(bVar.WR().Zi().video_duration.intValue() * 1000));
                    str = bVar.WR().Zi().thumbnail_url;
                }
            } else {
                this.efK.setVisibility(8);
                this.efT.setVisibility(8);
                if (bVar.WR().Zb() != null && bVar.WR().Zb().size() >= 1) {
                    str = bVar.WR().Zb().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.efU.setText(bVar.WR().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CN(bVar.WR().getId())) {
                al.j(this.efU, d.C0277d.cp_cont_c);
            } else {
                al.j(this.efU, d.C0277d.cp_cont_b);
            }
            this.efN.setData(bVar.WR(), false);
            this.efW.setText(ap.aq(bVar.WR().YB()));
            if ("news".equals(bVar.WR().YG())) {
                this.efN.setVisibility(8);
                this.efV.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.j.person_view_num, ap.as(bVar.WR().YJ())));
                return;
            }
            this.efN.setVisibility(0);
            f(bVar.WR());
        }
    }

    private void f(bg bgVar) {
        if (this.efV != null && bgVar != null) {
            this.efV.setVisibility(0);
            if (!StringUtils.isNull(bgVar.YR().getName_show())) {
                this.efV.setText(ns(bgVar.YR().getName_show()));
            }
        }
    }

    protected String ns(String str) {
        return ap.g(str, 14, "...");
    }

    public void on(int i) {
        this.efN.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQh() != null) {
            aQh().a(getView(), this.efX);
        }
    }
}
