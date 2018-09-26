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
    private TextView cCB;
    private TextView cCC;
    private TextView cCD;
    private TextView cCE;
    private com.baidu.tieba.e.b cCF;
    private LinearLayout cCo;
    private RelativeLayout cCq;
    private ImageView cCs;
    private ClickableHeaderImageView cCv;
    private View cCz;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cCo = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cCq = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(e.g.img_thumbnail);
        this.cCs = (ImageView) view.findViewById(e.g.img_play);
        this.cCB = (TextView) view.findViewById(e.g.card_frs_game_video_time);
        this.cCC = (TextView) view.findViewById(e.g.card_frs_game_video_title);
        this.cCv = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cCD = (TextView) view.findViewById(e.g.card_frs_game_read_time_or_name);
        this.cCE = (TextView) view.findViewById(e.g.card_frs_game_publish_time);
        this.cCz = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(e.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cCq.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cCq.setLayoutParams(layoutParams);
        this.cCv.setDefaultResource(17170445);
        this.cCv.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cCv.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cCv.setIsRound(true);
        this.cCv.setDrawBorder(true);
        this.cCv.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cCv.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0141e.tbds1));
        getView().setOnClickListener(this);
    }

    public void jp(int i) {
        if (this.cCz != null) {
            this.cCz.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cCo != null) {
            this.cCo.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cCz, e.d.cp_bg_line_c);
            al.c(this.cCB, e.d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.uJ(this.cCF.UT().getId())) {
                al.h(this.cCC, e.d.cp_cont_c);
            } else {
                al.h(this.cCC, e.d.cp_cont_b);
            }
            al.c(this.cCD, e.d.cp_cont_d, 1);
            al.c(this.cCE, e.d.cp_cont_d, 1);
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
        if (bVar != null && bVar.UT() != null) {
            this.cCF = bVar;
            String str = null;
            if (bVar.UT().xa()) {
                this.cCs.setVisibility(0);
                this.cCB.setVisibility(0);
                if (bVar.UT().wE() != null) {
                    this.cCB.setText(ao.dj(bVar.UT().wE().video_duration.intValue() * 1000));
                    str = bVar.UT().wE().thumbnail_url;
                }
            } else {
                this.cCs.setVisibility(8);
                this.cCB.setVisibility(8);
                if (bVar.UT().wx() != null && bVar.UT().wx().size() >= 1) {
                    str = bVar.UT().wx().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cCC.setText(bVar.UT().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.uJ(bVar.UT().getId())) {
                al.h(this.cCC, e.d.cp_cont_c);
            } else {
                al.h(this.cCC, e.d.cp_cont_b);
            }
            this.cCv.setData(bVar.UT(), false);
            this.cCE.setText(ao.C(bVar.UT().vX()));
            if ("news".equals(bVar.UT().wc())) {
                this.cCv.setVisibility(8);
                this.cCD.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.person_view_num, ao.E(bVar.UT().we())));
                return;
            }
            this.cCv.setVisibility(0);
            p(bVar.UT());
        }
    }

    private void p(bb bbVar) {
        if (this.cCD != null && bbVar != null) {
            this.cCD.setVisibility(0);
            if (!StringUtils.isNull(bbVar.wm().getName_show())) {
                this.cCD.setText(fK(bbVar.wm().getName_show()));
            }
        }
    }

    protected String fK(String str) {
        return ao.d(str, 14, "...");
    }

    public void jq(int i) {
        this.cCv.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (akm() != null) {
            akm().a(getView(), this.cCF);
        }
    }
}
