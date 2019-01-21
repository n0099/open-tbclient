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
    private LinearLayout cVY;
    private RelativeLayout cWa;
    private ImageView cWc;
    private ClickableHeaderImageView cWf;
    private View cWj;
    private TextView cWl;
    private TextView cWm;
    private TextView cWn;
    private TextView cWo;
    private com.baidu.tieba.e.b cWp;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cVY = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cWa = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(e.g.img_thumbnail);
        this.cWc = (ImageView) view.findViewById(e.g.img_play);
        this.cWl = (TextView) view.findViewById(e.g.card_frs_game_video_time);
        this.cWm = (TextView) view.findViewById(e.g.card_frs_game_video_title);
        this.cWf = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cWn = (TextView) view.findViewById(e.g.card_frs_game_read_time_or_name);
        this.cWo = (TextView) view.findViewById(e.g.card_frs_game_publish_time);
        this.cWj = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(e.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cWa.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cWa.setLayoutParams(layoutParams);
        this.cWf.setDefaultResource(17170445);
        this.cWf.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cWf.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cWf.setIsRound(true);
        this.cWf.setDrawBorder(true);
        this.cWf.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cWf.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        getView().setOnClickListener(this);
    }

    public void kJ(int i) {
        if (this.cWj != null) {
            this.cWj.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cVY != null) {
            this.cVY.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cWj, e.d.cp_bg_line_c);
            al.c(this.cWl, e.d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.wk(this.cWp.aaq().getId())) {
                al.h(this.cWm, e.d.cp_cont_c);
            } else {
                al.h(this.cWm, e.d.cp_cont_b);
            }
            al.c(this.cWn, e.d.cp_cont_d, 1);
            al.c(this.cWo, e.d.cp_cont_d, 1);
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
        if (bVar != null && bVar.aaq() != null) {
            this.cWp = bVar;
            String str = null;
            if (bVar.aaq().AH()) {
                this.cWc.setVisibility(0);
                this.cWl.setVisibility(0);
                if (bVar.aaq().Al() != null) {
                    this.cWl.setText(ao.dV(bVar.aaq().Al().video_duration.intValue() * 1000));
                    str = bVar.aaq().Al().thumbnail_url;
                }
            } else {
                this.cWc.setVisibility(8);
                this.cWl.setVisibility(8);
                if (bVar.aaq().Ae() != null && bVar.aaq().Ae().size() >= 1) {
                    str = bVar.aaq().Ae().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cWm.setText(bVar.aaq().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.wk(bVar.aaq().getId())) {
                al.h(this.cWm, e.d.cp_cont_c);
            } else {
                al.h(this.cWm, e.d.cp_cont_b);
            }
            this.cWf.setData(bVar.aaq(), false);
            this.cWo.setText(ao.O(bVar.aaq().zE()));
            if ("news".equals(bVar.aaq().zJ())) {
                this.cWf.setVisibility(8);
                this.cWn.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.person_view_num, ao.Q(bVar.aaq().zL())));
                return;
            }
            this.cWf.setVisibility(0);
            p(bVar.aaq());
        }
    }

    private void p(bb bbVar) {
        if (this.cWn != null && bbVar != null) {
            this.cWn.setVisibility(0);
            if (!StringUtils.isNull(bbVar.zT().getName_show())) {
                this.cWn.setText(gG(bbVar.zT().getName_show()));
            }
        }
    }

    protected String gG(String str) {
        return ao.d(str, 14, "...");
    }

    public void kK(int i) {
        this.cWf.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aqp() != null) {
            aqp().a(getView(), this.cWp);
        }
    }
}
