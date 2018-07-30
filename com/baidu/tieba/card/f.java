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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends a<com.baidu.tieba.e.b> {
    private LinearLayout cwB;
    private RelativeLayout cwD;
    private ImageView cwF;
    private ClickableHeaderImageView cwI;
    private View cwM;
    private TextView cwO;
    private TextView cwP;
    private TextView cwQ;
    private TextView cwR;
    private com.baidu.tieba.e.b cwS;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cwB = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.cwD = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(d.g.img_thumbnail);
        this.cwF = (ImageView) view.findViewById(d.g.img_play);
        this.cwO = (TextView) view.findViewById(d.g.card_frs_game_video_time);
        this.cwP = (TextView) view.findViewById(d.g.card_frs_game_video_title);
        this.cwI = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.cwQ = (TextView) view.findViewById(d.g.card_frs_game_read_time_or_name);
        this.cwR = (TextView) view.findViewById(d.g.card_frs_game_publish_time);
        this.cwM = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(d.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cwD.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cwD.setLayoutParams(layoutParams);
        this.cwI.setDefaultResource(17170445);
        this.cwI.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cwI.setDefaultBgResource(d.C0140d.cp_bg_line_e);
        this.cwI.setIsRound(true);
        this.cwI.setDrawBorder(true);
        this.cwI.setBorderColor(am.getColor(d.C0140d.common_color_10043));
        this.cwI.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void iR(int i) {
        if (this.cwM != null) {
            this.cwM.setVisibility(i);
        }
    }

    public void m(int i, int i2, int i3, int i4) {
        if (this.cwB != null) {
            this.cwB.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.C0140d.cp_bg_line_d);
            am.i(this.cwM, d.C0140d.cp_bg_line_c);
            am.c(this.cwO, d.C0140d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tY(this.cwS.Td().getId())) {
                am.h(this.cwP, d.C0140d.cp_cont_c);
            } else {
                am.h(this.cwP, d.C0140d.cp_cont_b);
            }
            am.c(this.cwQ, d.C0140d.cp_cont_d, 1);
            am.c(this.cwR, d.C0140d.cp_cont_d, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_frs_game_common_small_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.b bVar) {
        if (bVar != null && bVar.Td() != null) {
            this.cwS = bVar;
            String str = null;
            if (bVar.Td().vW()) {
                this.cwF.setVisibility(0);
                this.cwO.setVisibility(0);
                if (bVar.Td().vC() != null) {
                    this.cwO.setText(ap.da(bVar.Td().vC().video_duration.intValue() * 1000));
                    str = bVar.Td().vC().thumbnail_url;
                }
            } else {
                this.cwF.setVisibility(8);
                this.cwO.setVisibility(8);
                if (bVar.Td().vv() != null && bVar.Td().vv().size() >= 1) {
                    str = bVar.Td().vv().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cwP.setText(bVar.Td().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tY(bVar.Td().getId())) {
                am.h(this.cwP, d.C0140d.cp_cont_c);
            } else {
                am.h(this.cwP, d.C0140d.cp_cont_b);
            }
            this.cwI.setData(bVar.Td(), false);
            this.cwR.setText(ap.y(bVar.Td().uV()));
            if ("news".equals(bVar.Td().va())) {
                this.cwI.setVisibility(8);
                this.cwQ.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.j.person_view_num, ap.A(bVar.Td().vc())));
                return;
            }
            this.cwI.setVisibility(0);
            o(bVar.Td());
        }
    }

    private void o(bb bbVar) {
        if (this.cwQ != null && bbVar != null) {
            this.cwQ.setVisibility(0);
            if (!StringUtils.isNull(bbVar.vk().getName_show())) {
                this.cwQ.setText(fp(bbVar.vk().getName_show()));
            }
        }
    }

    protected String fp(String str) {
        return ap.e(str, 14, "...");
    }

    public void iS(int i) {
        this.cwI.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiz() != null) {
            aiz().a(getView(), this.cwS);
        }
    }
}
