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
    private LinearLayout cme;
    private RelativeLayout cmg;
    private ImageView cmi;
    private ClickableHeaderImageView cml;
    private View cmp;
    private TextView cmr;
    private TextView cms;
    private TextView cmt;
    private TextView cmu;
    private com.baidu.tieba.e.b cmv;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view2) {
        this.cme = (LinearLayout) view2.findViewById(d.g.card_frs_game_thread_layout);
        this.cmg = (RelativeLayout) view2.findViewById(d.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view2.findViewById(d.g.img_thumbnail);
        this.cmi = (ImageView) view2.findViewById(d.g.img_play);
        this.cmr = (TextView) view2.findViewById(d.g.card_frs_game_video_time);
        this.cms = (TextView) view2.findViewById(d.g.card_frs_game_video_title);
        this.cml = (ClickableHeaderImageView) view2.findViewById(d.g.card_frs_game_user_icon);
        this.cmt = (TextView) view2.findViewById(d.g.card_frs_game_read_time_or_name);
        this.cmu = (TextView) view2.findViewById(d.g.card_frs_game_publish_time);
        this.cmp = view2.findViewById(d.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(d.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cmg.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cmg.setLayoutParams(layoutParams);
        this.cml.setDefaultResource(17170445);
        this.cml.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cml.setDefaultBgResource(d.C0126d.cp_bg_line_e);
        this.cml.setIsRound(true);
        this.cml.setDrawBorder(true);
        this.cml.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        this.cml.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void iJ(int i) {
        if (this.cmp != null) {
            this.cmp.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cme != null) {
            this.cme.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ak.i(getView(), d.C0126d.cp_bg_line_d);
            ak.i(this.cmp, d.C0126d.cp_bg_line_c);
            ak.c(this.cmr, d.C0126d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.td(this.cmv.Pe().getId())) {
                ak.h(this.cms, d.C0126d.cp_cont_c);
            } else {
                ak.h(this.cms, d.C0126d.cp_cont_b);
            }
            ak.c(this.cmt, d.C0126d.cp_cont_d, 1);
            ak.c(this.cmu, d.C0126d.cp_cont_d, 1);
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
            this.cmv = bVar;
            String str = null;
            if (bVar.Pe().sB()) {
                this.cmi.setVisibility(0);
                this.cmr.setVisibility(0);
                if (bVar.Pe().sh() != null) {
                    this.cmr.setText(an.cU(bVar.Pe().sh().video_duration.intValue() * 1000));
                    str = bVar.Pe().sh().thumbnail_url;
                }
            } else {
                this.cmi.setVisibility(8);
                this.cmr.setVisibility(8);
                if (bVar.Pe().sa() != null && bVar.Pe().sa().size() >= 1) {
                    str = bVar.Pe().sa().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cms.setText(bVar.Pe().getTitle());
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.td(bVar.Pe().getId())) {
                ak.h(this.cms, d.C0126d.cp_cont_c);
            } else {
                ak.h(this.cms, d.C0126d.cp_cont_b);
            }
            this.cml.setData(bVar.Pe(), false);
            this.cmu.setText(an.t(bVar.Pe().rD()));
            if ("news".equals(bVar.Pe().rH())) {
                this.cml.setVisibility(8);
                this.cmt.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.k.person_view_num, an.v(bVar.Pe().rJ())));
                return;
            }
            this.cml.setVisibility(0);
            k(bVar.Pe());
        }
    }

    private void k(bd bdVar) {
        if (this.cmt != null && bdVar != null) {
            this.cmt.setVisibility(0);
            if (!StringUtils.isNull(bdVar.rQ().getName_show())) {
                this.cmt.setText(eP(bdVar.rQ().getName_show()));
            }
        }
    }

    protected String eP(String str) {
        return an.e(str, 14, "...");
    }

    public void iK(int i) {
        this.cml.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (aeZ() != null) {
            aeZ().a(getView(), this.cmv);
        }
    }
}
