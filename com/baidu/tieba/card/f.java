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
    private ImageView cSA;
    private ClickableHeaderImageView cSD;
    private View cSH;
    private TextView cSJ;
    private TextView cSK;
    private TextView cSL;
    private TextView cSM;
    private com.baidu.tieba.e.b cSN;
    private LinearLayout cSw;
    private RelativeLayout cSy;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cSw = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cSy = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(e.g.img_thumbnail);
        this.cSA = (ImageView) view.findViewById(e.g.img_play);
        this.cSJ = (TextView) view.findViewById(e.g.card_frs_game_video_time);
        this.cSK = (TextView) view.findViewById(e.g.card_frs_game_video_title);
        this.cSD = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cSL = (TextView) view.findViewById(e.g.card_frs_game_read_time_or_name);
        this.cSM = (TextView) view.findViewById(e.g.card_frs_game_publish_time);
        this.cSH = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(e.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cSy.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cSy.setLayoutParams(layoutParams);
        this.cSD.setDefaultResource(17170445);
        this.cSD.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cSD.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cSD.setIsRound(true);
        this.cSD.setDrawBorder(true);
        this.cSD.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cSD.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        getView().setOnClickListener(this);
    }

    public void kx(int i) {
        if (this.cSH != null) {
            this.cSH.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cSw != null) {
            this.cSw.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cSH, e.d.cp_bg_line_c);
            al.c(this.cSJ, e.d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vR(this.cSN.ZR().getId())) {
                al.h(this.cSK, e.d.cp_cont_c);
            } else {
                al.h(this.cSK, e.d.cp_cont_b);
            }
            al.c(this.cSL, e.d.cp_cont_d, 1);
            al.c(this.cSM, e.d.cp_cont_d, 1);
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
        if (bVar != null && bVar.ZR() != null) {
            this.cSN = bVar;
            String str = null;
            if (bVar.ZR().Au()) {
                this.cSA.setVisibility(0);
                this.cSJ.setVisibility(0);
                if (bVar.ZR().zY() != null) {
                    this.cSJ.setText(ao.dV(bVar.ZR().zY().video_duration.intValue() * 1000));
                    str = bVar.ZR().zY().thumbnail_url;
                }
            } else {
                this.cSA.setVisibility(8);
                this.cSJ.setVisibility(8);
                if (bVar.ZR().zR() != null && bVar.ZR().zR().size() >= 1) {
                    str = bVar.ZR().zR().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cSK.setText(bVar.ZR().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vR(bVar.ZR().getId())) {
                al.h(this.cSK, e.d.cp_cont_c);
            } else {
                al.h(this.cSK, e.d.cp_cont_b);
            }
            this.cSD.setData(bVar.ZR(), false);
            this.cSM.setText(ao.N(bVar.ZR().zr()));
            if ("news".equals(bVar.ZR().zw())) {
                this.cSD.setVisibility(8);
                this.cSL.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.person_view_num, ao.P(bVar.ZR().zy())));
                return;
            }
            this.cSD.setVisibility(0);
            p(bVar.ZR());
        }
    }

    private void p(bb bbVar) {
        if (this.cSL != null && bbVar != null) {
            this.cSL.setVisibility(0);
            if (!StringUtils.isNull(bbVar.zG().getName_show())) {
                this.cSL.setText(gr(bbVar.zG().getName_show()));
            }
        }
    }

    protected String gr(String str) {
        return ao.d(str, 14, "...");
    }

    public void ky(int i) {
        this.cSD.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apc() != null) {
            apc().a(getView(), this.cSN);
        }
    }
}
