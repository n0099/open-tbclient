package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private ClickableHeaderImageView efA;
    private View efE;
    private TextView efG;
    private TextView efH;
    private TextView efI;
    private TextView efJ;
    private com.baidu.tieba.e.b efK;
    private LinearLayout eft;
    private RelativeLayout efv;
    private ImageView efx;
    private TbImageView imgThumbnail;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eft = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.efv = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(d.g.img_thumbnail);
        this.efx = (ImageView) view.findViewById(d.g.img_play);
        this.efG = (TextView) view.findViewById(d.g.card_frs_game_video_time);
        this.efH = (TextView) view.findViewById(d.g.card_frs_game_video_title);
        this.efA = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.efI = (TextView) view.findViewById(d.g.card_frs_game_read_time_or_name);
        this.efJ = (TextView) view.findViewById(d.g.card_frs_game_publish_time);
        this.efE = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(d.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.efv.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.efv.setLayoutParams(layoutParams);
        this.efA.setDefaultResource(17170445);
        this.efA.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.efA.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.efA.setIsRound(true);
        this.efA.setDrawBorder(true);
        this.efA.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efA.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void oi(int i) {
        if (this.efE != null) {
            this.efE.setVisibility(i);
        }
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.eft != null) {
            this.eft.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.C0277d.cp_bg_line_d);
            al.k(this.efE, d.C0277d.cp_bg_line_c);
            al.d(this.efG, d.C0277d.cp_btn_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CM(this.efK.WO().getId())) {
                al.j(this.efH, d.C0277d.cp_cont_c);
            } else {
                al.j(this.efH, d.C0277d.cp_cont_b);
            }
            al.d(this.efI, d.C0277d.cp_cont_d, 1);
            al.d(this.efJ, d.C0277d.cp_cont_d, 1);
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
        if (bVar != null && bVar.WO() != null) {
            this.efK = bVar;
            String str = null;
            if (bVar.WO().ZI()) {
                this.efx.setVisibility(0);
                this.efG.setVisibility(0);
                if (bVar.WO().Zf() != null) {
                    this.efG.setText(ap.hy(bVar.WO().Zf().video_duration.intValue() * 1000));
                    str = bVar.WO().Zf().thumbnail_url;
                }
            } else {
                this.efx.setVisibility(8);
                this.efG.setVisibility(8);
                if (bVar.WO().YY() != null && bVar.WO().YY().size() >= 1) {
                    str = bVar.WO().YY().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.efH.setText(bVar.WO().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CM(bVar.WO().getId())) {
                al.j(this.efH, d.C0277d.cp_cont_c);
            } else {
                al.j(this.efH, d.C0277d.cp_cont_b);
            }
            this.efA.setData(bVar.WO(), false);
            this.efJ.setText(ap.aq(bVar.WO().Yy()));
            if ("news".equals(bVar.WO().YD())) {
                this.efA.setVisibility(8);
                this.efI.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.j.person_view_num, ap.as(bVar.WO().YG())));
                return;
            }
            this.efA.setVisibility(0);
            f(bVar.WO());
        }
    }

    private void f(bg bgVar) {
        if (this.efI != null && bgVar != null) {
            this.efI.setVisibility(0);
            if (!StringUtils.isNull(bgVar.YO().getName_show())) {
                this.efI.setText(nt(bgVar.YO().getName_show()));
            }
        }
    }

    protected String nt(String str) {
        return ap.g(str, 14, "...");
    }

    public void oj(int i) {
        this.efA.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQf() != null) {
            aQf().a(getView(), this.efK);
        }
    }
}
