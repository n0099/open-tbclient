package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f extends a<com.baidu.tieba.e.b> {
    private LinearLayout cLP;
    private RelativeLayout cLR;
    private ImageView cLT;
    private ClickableHeaderImageView cLW;
    private View cMa;
    private TextView cMc;
    private TextView cMd;
    private TextView cMe;
    private TextView cMf;
    private com.baidu.tieba.e.b cMg;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cLP = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cLR = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(e.g.img_thumbnail);
        this.cLT = (ImageView) view.findViewById(e.g.img_play);
        this.cMc = (TextView) view.findViewById(e.g.card_frs_game_video_time);
        this.cMd = (TextView) view.findViewById(e.g.card_frs_game_video_title);
        this.cLW = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cMe = (TextView) view.findViewById(e.g.card_frs_game_read_time_or_name);
        this.cMf = (TextView) view.findViewById(e.g.card_frs_game_publish_time);
        this.cMa = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(e.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cLR.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cLR.setLayoutParams(layoutParams);
        this.cLW.setDefaultResource(17170445);
        this.cLW.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cLW.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cLW.setIsRound(true);
        this.cLW.setDrawBorder(true);
        this.cLW.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cLW.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0200e.tbds1));
        getView().setOnClickListener(this);
    }

    public void kh(int i) {
        if (this.cMa != null) {
            this.cMa.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cLP != null) {
            this.cLP.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cMa, e.d.cp_bg_line_c);
            al.c(this.cMc, e.d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vq(this.cMg.YL().getId())) {
                al.h(this.cMd, e.d.cp_cont_c);
            } else {
                al.h(this.cMd, e.d.cp_cont_b);
            }
            al.c(this.cMe, e.d.cp_cont_d, 1);
            al.c(this.cMf, e.d.cp_cont_d, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_frs_game_common_small_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.b bVar) {
        if (bVar != null && bVar.YL() != null) {
            this.cMg = bVar;
            String str = null;
            if (bVar.YL().zq()) {
                this.cLT.setVisibility(0);
                this.cMc.setVisibility(0);
                if (bVar.YL().yU() != null) {
                    this.cMc.setText(ao.dH(bVar.YL().yU().video_duration.intValue() * 1000));
                    str = bVar.YL().yU().thumbnail_url;
                }
            } else {
                this.cLT.setVisibility(8);
                this.cMc.setVisibility(8);
                if (bVar.YL().yN() != null && bVar.YL().yN().size() >= 1) {
                    str = bVar.YL().yN().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cMd.setText(bVar.YL().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vq(bVar.YL().getId())) {
                al.h(this.cMd, e.d.cp_cont_c);
            } else {
                al.h(this.cMd, e.d.cp_cont_b);
            }
            this.cLW.setData(bVar.YL(), false);
            this.cMf.setText(ao.G(bVar.YL().yn()));
            if ("news".equals(bVar.YL().ys())) {
                this.cLW.setVisibility(8);
                this.cMe.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.person_view_num, ao.I(bVar.YL().yu())));
                return;
            }
            this.cLW.setVisibility(0);
            p(bVar.YL());
        }
    }

    private void p(bb bbVar) {
        if (this.cMe != null && bbVar != null) {
            this.cMe.setVisibility(0);
            if (!StringUtils.isNull(bbVar.yC().getName_show())) {
                this.cMe.setText(fZ(bbVar.yC().getName_show()));
            }
        }
    }

    protected String fZ(String str) {
        return ao.d(str, 14, "...");
    }

    public void ki(int i) {
        this.cLW.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anq() != null) {
            anq().a(getView(), this.cMg);
        }
    }
}
