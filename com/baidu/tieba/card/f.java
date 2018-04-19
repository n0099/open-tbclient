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
    private LinearLayout cmh;
    private RelativeLayout cmj;
    private ImageView cml;
    private ClickableHeaderImageView cmo;
    private View cms;
    private TextView cmu;
    private TextView cmv;
    private TextView cmw;
    private TextView cmx;
    private com.baidu.tieba.e.b cmy;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.cmh = (LinearLayout) view2.findViewById(d.g.card_frs_game_thread_layout);
        this.cmj = (RelativeLayout) view2.findViewById(d.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view2.findViewById(d.g.img_thumbnail);
        this.cml = (ImageView) view2.findViewById(d.g.img_play);
        this.cmu = (TextView) view2.findViewById(d.g.card_frs_game_video_time);
        this.cmv = (TextView) view2.findViewById(d.g.card_frs_game_video_title);
        this.cmo = (ClickableHeaderImageView) view2.findViewById(d.g.card_frs_game_user_icon);
        this.cmw = (TextView) view2.findViewById(d.g.card_frs_game_read_time_or_name);
        this.cmx = (TextView) view2.findViewById(d.g.card_frs_game_publish_time);
        this.cms = view2.findViewById(d.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(d.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmj.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cmj.setLayoutParams(layoutParams);
        this.cmo.setDefaultResource(17170445);
        this.cmo.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cmo.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cmo.setIsRound(true);
        this.cmo.setDrawBorder(true);
        this.cmo.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cmo.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void iJ(int i) {
        if (this.cms != null) {
            this.cms.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cmh != null) {
            this.cmh.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.C0126d.cp_bg_line_d);
            ak.i(this.cms, d.C0126d.cp_bg_line_c);
            ak.c(this.cmu, d.C0126d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.td(this.cmy.Pe().getId())) {
                ak.h(this.cmv, d.C0126d.cp_cont_c);
            } else {
                ak.h(this.cmv, d.C0126d.cp_cont_b);
            }
            ak.c(this.cmw, d.C0126d.cp_cont_d, 1);
            ak.c(this.cmx, d.C0126d.cp_cont_d, 1);
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
        if (bVar != null && bVar.Pe() != null) {
            this.cmy = bVar;
            String str = null;
            if (bVar.Pe().sB()) {
                this.cml.setVisibility(0);
                this.cmu.setVisibility(0);
                if (bVar.Pe().sh() != null) {
                    this.cmu.setText(an.cU(bVar.Pe().sh().video_duration.intValue() * 1000));
                    str = bVar.Pe().sh().thumbnail_url;
                }
            } else {
                this.cml.setVisibility(8);
                this.cmu.setVisibility(8);
                if (bVar.Pe().sa() != null && bVar.Pe().sa().size() >= 1) {
                    str = bVar.Pe().sa().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cmv.setText(bVar.Pe().getTitle());
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.td(bVar.Pe().getId())) {
                ak.h(this.cmv, d.C0126d.cp_cont_c);
            } else {
                ak.h(this.cmv, d.C0126d.cp_cont_b);
            }
            this.cmo.setData(bVar.Pe(), false);
            this.cmx.setText(an.t(bVar.Pe().rD()));
            if ("news".equals(bVar.Pe().rH())) {
                this.cmo.setVisibility(8);
                this.cmw.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.k.person_view_num, an.v(bVar.Pe().rJ())));
                return;
            }
            this.cmo.setVisibility(0);
            k(bVar.Pe());
        }
    }

    private void k(bd bdVar) {
        if (this.cmw != null && bdVar != null) {
            this.cmw.setVisibility(0);
            if (!StringUtils.isNull(bdVar.rQ().getName_show())) {
                this.cmw.setText(eP(bdVar.rQ().getName_show()));
            }
        }
    }

    protected String eP(String str) {
        return an.e(str, 14, "...");
    }

    public void iK(int i) {
        this.cmo.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(getView(), this.cmy);
        }
    }
}
