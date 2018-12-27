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
    private TextView cVA;
    private TextView cVB;
    private TextView cVC;
    private com.baidu.tieba.e.b cVD;
    private LinearLayout cVm;
    private RelativeLayout cVo;
    private ImageView cVq;
    private ClickableHeaderImageView cVt;
    private View cVx;
    private TextView cVz;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cVm = (LinearLayout) view.findViewById(e.g.card_frs_game_thread_layout);
        this.cVo = (RelativeLayout) view.findViewById(e.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(e.g.img_thumbnail);
        this.cVq = (ImageView) view.findViewById(e.g.img_play);
        this.cVz = (TextView) view.findViewById(e.g.card_frs_game_video_time);
        this.cVA = (TextView) view.findViewById(e.g.card_frs_game_video_title);
        this.cVt = (ClickableHeaderImageView) view.findViewById(e.g.card_frs_game_user_icon);
        this.cVB = (TextView) view.findViewById(e.g.card_frs_game_read_time_or_name);
        this.cVC = (TextView) view.findViewById(e.g.card_frs_game_publish_time);
        this.cVx = view.findViewById(e.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(e.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(e.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cVo.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cVo.setLayoutParams(layoutParams);
        this.cVt.setDefaultResource(17170445);
        this.cVt.setDefaultErrorResource(e.f.icon_default_avatar100);
        this.cVt.setDefaultBgResource(e.d.cp_bg_line_e);
        this.cVt.setIsRound(true);
        this.cVt.setDrawBorder(true);
        this.cVt.setBorderColor(al.getColor(e.d.common_color_10043));
        this.cVt.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(e.C0210e.tbds1));
        getView().setOnClickListener(this);
    }

    public void kJ(int i) {
        if (this.cVx != null) {
            this.cVx.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cVm != null) {
            this.cVm.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), e.d.cp_bg_line_d);
            al.i(this.cVx, e.d.cp_bg_line_c);
            al.c(this.cVz, e.d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vU(this.cVD.ZT().getId())) {
                al.h(this.cVA, e.d.cp_cont_c);
            } else {
                al.h(this.cVA, e.d.cp_cont_b);
            }
            al.c(this.cVB, e.d.cp_cont_d, 1);
            al.c(this.cVC, e.d.cp_cont_d, 1);
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
        if (bVar != null && bVar.ZT() != null) {
            this.cVD = bVar;
            String str = null;
            if (bVar.ZT().Au()) {
                this.cVq.setVisibility(0);
                this.cVz.setVisibility(0);
                if (bVar.ZT().zY() != null) {
                    this.cVz.setText(ao.dV(bVar.ZT().zY().video_duration.intValue() * 1000));
                    str = bVar.ZT().zY().thumbnail_url;
                }
            } else {
                this.cVq.setVisibility(8);
                this.cVz.setVisibility(8);
                if (bVar.ZT().zR() != null && bVar.ZT().zR().size() >= 1) {
                    str = bVar.ZT().zR().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cVA.setText(bVar.ZT().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vU(bVar.ZT().getId())) {
                al.h(this.cVA, e.d.cp_cont_c);
            } else {
                al.h(this.cVA, e.d.cp_cont_b);
            }
            this.cVt.setData(bVar.ZT(), false);
            this.cVC.setText(ao.O(bVar.ZT().zr()));
            if ("news".equals(bVar.ZT().zw())) {
                this.cVt.setVisibility(8);
                this.cVB.setText(this.mTbPageContext.getPageActivity().getResources().getString(e.j.person_view_num, ao.Q(bVar.ZT().zy())));
                return;
            }
            this.cVt.setVisibility(0);
            p(bVar.ZT());
        }
    }

    private void p(bb bbVar) {
        if (this.cVB != null && bbVar != null) {
            this.cVB.setVisibility(0);
            if (!StringUtils.isNull(bbVar.zG().getName_show())) {
                this.cVB.setText(gt(bbVar.zG().getName_show()));
            }
        }
    }

    protected String gt(String str) {
        return ao.d(str, 14, "...");
    }

    public void kK(int i) {
        this.cVt.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (apS() != null) {
            apS().a(getView(), this.cVD);
        }
    }
}
