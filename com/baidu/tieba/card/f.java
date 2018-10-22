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
    private LinearLayout cKJ;
    private RelativeLayout cKL;
    private ImageView cKN;
    private ClickableHeaderImageView cKQ;
    private View cKU;
    private TextView cKW;
    private TextView cKX;
    private TextView cKY;
    private TextView cKZ;
    private com.baidu.tieba.e.b cLa;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cKJ = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cKL = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(e.g.img_thumbnail);
        this.cKN = (ImageView) view.findViewById(e.g.img_play);
        this.cKW = (TextView) view.findViewById(e.g.card_frs_game_video_time);
        this.cKX = (TextView) view.findViewById(e.g.card_frs_game_video_title);
        this.cKQ = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cKY = (TextView) view.findViewById(e.g.card_frs_game_read_time_or_name);
        this.cKZ = (TextView) view.findViewById(e.g.card_frs_game_publish_time);
        this.cKU = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(e.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cKL.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cKL.setLayoutParams(layoutParams);
        this.cKQ.setDefaultResource(17170445);
        this.cKQ.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cKQ.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cKQ.setIsRound(true);
        this.cKQ.setDrawBorder(true);
        this.cKQ.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cKQ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0175e.tbds1));
        getView().setOnClickListener(this);
    }

    public void jO(int i) {
        if (this.cKU != null) {
            this.cKU.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cKJ != null) {
            this.cKJ.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cKU, e.d.cp_bg_line_c);
            al.c(this.cKW, e.d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vl(this.cLa.YB().getId())) {
                al.h(this.cKX, e.d.cp_cont_c);
            } else {
                al.h(this.cKX, e.d.cp_cont_b);
            }
            al.c(this.cKY, e.d.cp_cont_d, 1);
            al.c(this.cKZ, e.d.cp_cont_d, 1);
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
        if (bVar != null && bVar.YB() != null) {
            this.cLa = bVar;
            String str = null;
            if (bVar.YB().zj()) {
                this.cKN.setVisibility(0);
                this.cKW.setVisibility(0);
                if (bVar.YB().yN() != null) {
                    this.cKW.setText(ao.dt(bVar.YB().yN().video_duration.intValue() * 1000));
                    str = bVar.YB().yN().thumbnail_url;
                }
            } else {
                this.cKN.setVisibility(8);
                this.cKW.setVisibility(8);
                if (bVar.YB().yG() != null && bVar.YB().yG().size() >= 1) {
                    str = bVar.YB().yG().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cKX.setText(bVar.YB().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vl(bVar.YB().getId())) {
                al.h(this.cKX, e.d.cp_cont_c);
            } else {
                al.h(this.cKX, e.d.cp_cont_b);
            }
            this.cKQ.setData(bVar.YB(), false);
            this.cKZ.setText(ao.E(bVar.YB().yg()));
            if ("news".equals(bVar.YB().yl())) {
                this.cKQ.setVisibility(8);
                this.cKY.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.person_view_num, ao.G(bVar.YB().yn())));
                return;
            }
            this.cKQ.setVisibility(0);
            p(bVar.YB());
        }
    }

    private void p(bb bbVar) {
        if (this.cKY != null && bbVar != null) {
            this.cKY.setVisibility(0);
            if (!StringUtils.isNull(bbVar.yv().getName_show())) {
                this.cKY.setText(fY(bbVar.yv().getName_show()));
            }
        }
    }

    protected String fY(String str) {
        return ao.d(str, 14, "...");
    }

    public void jP(int i) {
        this.cKQ.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (anP() != null) {
            anP().a(getView(), this.cLa);
        }
    }
}
