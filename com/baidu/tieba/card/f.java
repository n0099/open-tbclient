package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends a<com.baidu.tieba.e.b> {
    private TextView cnB;
    private TextView cnC;
    private TextView cnD;
    private TextView cnE;
    private com.baidu.tieba.e.b cnF;
    private LinearLayout cnn;
    private RelativeLayout cnp;
    private ImageView cnr;
    private ClickableHeaderImageView cnv;
    private View cnz;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.cnn = (LinearLayout) view2.findViewById(d.g.card_frs_game_thread_layout);
        this.cnp = (RelativeLayout) view2.findViewById(d.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view2.findViewById(d.g.img_thumbnail);
        this.cnr = (ImageView) view2.findViewById(d.g.img_play);
        this.cnB = (TextView) view2.findViewById(d.g.card_frs_game_video_time);
        this.cnC = (TextView) view2.findViewById(d.g.card_frs_game_video_title);
        this.cnv = (ClickableHeaderImageView) view2.findViewById(d.g.card_frs_game_user_icon);
        this.cnD = (TextView) view2.findViewById(d.g.card_frs_game_read_time_or_name);
        this.cnE = (TextView) view2.findViewById(d.g.card_frs_game_publish_time);
        this.cnz = view2.findViewById(d.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(d.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cnp.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cnp.setLayoutParams(layoutParams);
        this.cnv.setDefaultResource(17170445);
        this.cnv.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cnv.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cnv.setIsRound(true);
        this.cnv.setDrawBorder(true);
        this.cnv.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cnv.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void iI(int i) {
        if (this.cnz != null) {
            this.cnz.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cnn != null) {
            this.cnn.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.C0126d.cp_bg_line_d);
            ak.i(this.cnz, d.C0126d.cp_bg_line_c);
            ak.c(this.cnB, d.C0126d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tg(this.cnF.Pb().getId())) {
                ak.h(this.cnC, d.C0126d.cp_cont_c);
            } else {
                ak.h(this.cnC, d.C0126d.cp_cont_b);
            }
            ak.c(this.cnD, d.C0126d.cp_cont_d, 1);
            ak.c(this.cnE, d.C0126d.cp_cont_d, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_frs_game_common_small_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.b bVar) {
        if (bVar != null && bVar.Pb() != null) {
            this.cnF = bVar;
            String str = null;
            if (bVar.Pb().sA()) {
                this.cnr.setVisibility(0);
                this.cnB.setVisibility(0);
                if (bVar.Pb().sg() != null) {
                    this.cnB.setText(an.cV(bVar.Pb().sg().video_duration.intValue() * 1000));
                    str = bVar.Pb().sg().thumbnail_url;
                }
            } else {
                this.cnr.setVisibility(8);
                this.cnB.setVisibility(8);
                if (bVar.Pb().rZ() != null && bVar.Pb().rZ().size() >= 1) {
                    str = bVar.Pb().rZ().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cnC.setText(bVar.Pb().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tg(bVar.Pb().getId())) {
                ak.h(this.cnC, d.C0126d.cp_cont_c);
            } else {
                ak.h(this.cnC, d.C0126d.cp_cont_b);
            }
            this.cnv.setData(bVar.Pb(), false);
            this.cnE.setText(an.t(bVar.Pb().rC()));
            if ("news".equals(bVar.Pb().rG())) {
                this.cnv.setVisibility(8);
                this.cnD.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.k.person_view_num, an.v(bVar.Pb().rI())));
                return;
            }
            this.cnv.setVisibility(0);
            k(bVar.Pb());
        }
    }

    private void k(bd bdVar) {
        if (this.cnD != null && bdVar != null) {
            this.cnD.setVisibility(0);
            if (!StringUtils.isNull(bdVar.rP().getName_show())) {
                this.cnD.setText(eP(bdVar.rP().getName_show()));
            }
        }
    }

    protected String eP(String str) {
        return an.e(str, 14, "...");
    }

    public void iJ(int i) {
        this.cnv.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(getView(), this.cnF);
        }
    }
}
