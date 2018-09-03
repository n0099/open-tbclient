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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class f extends a<com.baidu.tieba.e.b> {
    private RelativeLayout cwA;
    private ImageView cwC;
    private ClickableHeaderImageView cwF;
    private View cwJ;
    private TextView cwL;
    private TextView cwM;
    private TextView cwN;
    private TextView cwO;
    private com.baidu.tieba.e.b cwP;
    private LinearLayout cwy;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cwy = (LinearLayout) view.findViewById(f.g.card_frs_game_thread_layout);
        this.cwA = (RelativeLayout) view.findViewById(f.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(f.g.img_thumbnail);
        this.cwC = (ImageView) view.findViewById(f.g.img_play);
        this.cwL = (TextView) view.findViewById(f.g.card_frs_game_video_time);
        this.cwM = (TextView) view.findViewById(f.g.card_frs_game_video_title);
        this.cwF = (ClickableHeaderImageView) view.findViewById(f.g.card_frs_game_user_icon);
        this.cwN = (TextView) view.findViewById(f.g.card_frs_game_read_time_or_name);
        this.cwO = (TextView) view.findViewById(f.g.card_frs_game_publish_time);
        this.cwJ = view.findViewById(f.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(f.C0146f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(f.C0146f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f.e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cwA.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cwA.setLayoutParams(layoutParams);
        this.cwF.setDefaultResource(17170445);
        this.cwF.setDefaultErrorResource(f.C0146f.icon_default_avatar100);
        this.cwF.setDefaultBgResource(f.d.cp_bg_line_e);
        this.cwF.setIsRound(true);
        this.cwF.setDrawBorder(true);
        this.cwF.setBorderColor(am.getColor(f.d.common_color_10043));
        this.cwF.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(f.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void iQ(int i) {
        if (this.cwJ != null) {
            this.cwJ.setVisibility(i);
        }
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cwy != null) {
            this.cwy.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), f.d.cp_bg_line_d);
            am.i(this.cwJ, f.d.cp_bg_line_c);
            am.c(this.cwL, f.d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.uc(this.cwP.Tg().getId())) {
                am.h(this.cwM, f.d.cp_cont_c);
            } else {
                am.h(this.cwM, f.d.cp_cont_b);
            }
            am.c(this.cwN, f.d.cp_cont_d, 1);
            am.c(this.cwO, f.d.cp_cont_d, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_frs_game_common_small_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.b bVar) {
        if (bVar != null && bVar.Tg() != null) {
            this.cwP = bVar;
            String str = null;
            if (bVar.Tg().vV()) {
                this.cwC.setVisibility(0);
                this.cwL.setVisibility(0);
                if (bVar.Tg().vB() != null) {
                    this.cwL.setText(ap.da(bVar.Tg().vB().video_duration.intValue() * 1000));
                    str = bVar.Tg().vB().thumbnail_url;
                }
            } else {
                this.cwC.setVisibility(8);
                this.cwL.setVisibility(8);
                if (bVar.Tg().vu() != null && bVar.Tg().vu().size() >= 1) {
                    str = bVar.Tg().vu().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cwM.setText(bVar.Tg().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.uc(bVar.Tg().getId())) {
                am.h(this.cwM, f.d.cp_cont_c);
            } else {
                am.h(this.cwM, f.d.cp_cont_b);
            }
            this.cwF.setData(bVar.Tg(), false);
            this.cwO.setText(ap.y(bVar.Tg().uU()));
            if ("news".equals(bVar.Tg().uZ())) {
                this.cwF.setVisibility(8);
                this.cwN.setText(this.mTbPageContext.getPageActivity().getResources().getString(f.j.person_view_num, ap.A(bVar.Tg().vb())));
                return;
            }
            this.cwF.setVisibility(0);
            o(bVar.Tg());
        }
    }

    private void o(bb bbVar) {
        if (this.cwN != null && bbVar != null) {
            this.cwN.setVisibility(0);
            if (!StringUtils.isNull(bbVar.vj().getName_show())) {
                this.cwN.setText(fp(bbVar.vj().getName_show()));
            }
        }
    }

    protected String fp(String str) {
        return ap.d(str, 14, "...");
    }

    public void iR(int i) {
        this.cwF.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiC() != null) {
            aiC().a(getView(), this.cwP);
        }
    }
}
