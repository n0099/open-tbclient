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
    private View efD;
    private TextView efF;
    private TextView efG;
    private TextView efH;
    private TextView efI;
    private com.baidu.tieba.e.b efJ;
    private LinearLayout efs;
    private RelativeLayout efu;
    private ImageView efw;
    private ClickableHeaderImageView efz;
    private TbImageView imgThumbnail;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.efs = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.efu = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(d.g.img_thumbnail);
        this.efw = (ImageView) view.findViewById(d.g.img_play);
        this.efF = (TextView) view.findViewById(d.g.card_frs_game_video_time);
        this.efG = (TextView) view.findViewById(d.g.card_frs_game_video_title);
        this.efz = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.efH = (TextView) view.findViewById(d.g.card_frs_game_read_time_or_name);
        this.efI = (TextView) view.findViewById(d.g.card_frs_game_publish_time);
        this.efD = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(d.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.efu.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.efu.setLayoutParams(layoutParams);
        this.efz.setDefaultResource(17170445);
        this.efz.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.efz.setDefaultBgResource(d.C0277d.cp_bg_line_e);
        this.efz.setIsRound(true);
        this.efz.setDrawBorder(true);
        this.efz.setBorderColor(al.getColor(d.C0277d.common_color_10043));
        this.efz.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void oi(int i) {
        if (this.efD != null) {
            this.efD.setVisibility(i);
        }
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.efs != null) {
            this.efs.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.k(getView(), d.C0277d.cp_bg_line_d);
            al.k(this.efD, d.C0277d.cp_bg_line_c);
            al.d(this.efF, d.C0277d.cp_btn_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CM(this.efJ.WO().getId())) {
                al.j(this.efG, d.C0277d.cp_cont_c);
            } else {
                al.j(this.efG, d.C0277d.cp_cont_b);
            }
            al.d(this.efH, d.C0277d.cp_cont_d, 1);
            al.d(this.efI, d.C0277d.cp_cont_d, 1);
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
            this.efJ = bVar;
            String str = null;
            if (bVar.WO().ZI()) {
                this.efw.setVisibility(0);
                this.efF.setVisibility(0);
                if (bVar.WO().Zf() != null) {
                    this.efF.setText(ap.hy(bVar.WO().Zf().video_duration.intValue() * 1000));
                    str = bVar.WO().Zf().thumbnail_url;
                }
            } else {
                this.efw.setVisibility(8);
                this.efF.setVisibility(8);
                if (bVar.WO().YY() != null && bVar.WO().YY().size() >= 1) {
                    str = bVar.WO().YY().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.efG.setText(bVar.WO().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CM(bVar.WO().getId())) {
                al.j(this.efG, d.C0277d.cp_cont_c);
            } else {
                al.j(this.efG, d.C0277d.cp_cont_b);
            }
            this.efz.setData(bVar.WO(), false);
            this.efI.setText(ap.aq(bVar.WO().Yy()));
            if ("news".equals(bVar.WO().YD())) {
                this.efz.setVisibility(8);
                this.efH.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.j.person_view_num, ap.as(bVar.WO().YG())));
                return;
            }
            this.efz.setVisibility(0);
            f(bVar.WO());
        }
    }

    private void f(bg bgVar) {
        if (this.efH != null && bgVar != null) {
            this.efH.setVisibility(0);
            if (!StringUtils.isNull(bgVar.YO().getName_show())) {
                this.efH.setText(nt(bgVar.YO().getName_show()));
            }
        }
    }

    protected String nt(String str) {
        return ap.g(str, 14, "...");
    }

    public void oj(int i) {
        this.efz.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aQf() != null) {
            aQf().a(getView(), this.efJ);
        }
    }
}
