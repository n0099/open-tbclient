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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends a<com.baidu.tieba.e.b> {
    private LinearLayout cvS;
    private RelativeLayout cvU;
    private ImageView cvW;
    private ClickableHeaderImageView cvZ;
    private View cwd;
    private TextView cwf;
    private TextView cwg;
    private TextView cwh;
    private TextView cwi;
    private com.baidu.tieba.e.b cwj;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.cvS = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.cvU = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(d.g.img_thumbnail);
        this.cvW = (ImageView) view.findViewById(d.g.img_play);
        this.cwf = (TextView) view.findViewById(d.g.card_frs_game_video_time);
        this.cwg = (TextView) view.findViewById(d.g.card_frs_game_video_title);
        this.cvZ = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.cwh = (TextView) view.findViewById(d.g.card_frs_game_read_time_or_name);
        this.cwi = (TextView) view.findViewById(d.g.card_frs_game_publish_time);
        this.cwd = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(d.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cvU.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cvU.setLayoutParams(layoutParams);
        this.cvZ.setDefaultResource(17170445);
        this.cvZ.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cvZ.setDefaultBgResource(d.C0141d.cp_bg_line_e);
        this.cvZ.setIsRound(true);
        this.cvZ.setDrawBorder(true);
        this.cvZ.setBorderColor(al.getColor(d.C0141d.common_color_10043));
        this.cvZ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void iJ(int i) {
        if (this.cwd != null) {
            this.cwd.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.cvS != null) {
            this.cvS.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(getView(), d.C0141d.cp_bg_line_d);
            al.i(this.cwd, d.C0141d.cp_bg_line_c);
            al.c(this.cwf, d.C0141d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ua(this.cwj.Sz().getId())) {
                al.h(this.cwg, d.C0141d.cp_cont_c);
            } else {
                al.h(this.cwg, d.C0141d.cp_cont_b);
            }
            al.c(this.cwh, d.C0141d.cp_cont_d, 1);
            al.c(this.cwi, d.C0141d.cp_cont_d, 1);
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
        if (bVar != null && bVar.Sz() != null) {
            this.cwj = bVar;
            String str = null;
            if (bVar.Sz().vX()) {
                this.cvW.setVisibility(0);
                this.cwf.setVisibility(0);
                if (bVar.Sz().vD() != null) {
                    this.cwf.setText(ao.cX(bVar.Sz().vD().video_duration.intValue() * 1000));
                    str = bVar.Sz().vD().thumbnail_url;
                }
            } else {
                this.cvW.setVisibility(8);
                this.cwf.setVisibility(8);
                if (bVar.Sz().vw() != null && bVar.Sz().vw().size() >= 1) {
                    str = bVar.Sz().vw().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cwg.setText(bVar.Sz().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ua(bVar.Sz().getId())) {
                al.h(this.cwg, d.C0141d.cp_cont_c);
            } else {
                al.h(this.cwg, d.C0141d.cp_cont_b);
            }
            this.cvZ.setData(bVar.Sz(), false);
            this.cwi.setText(ao.w(bVar.Sz().uY()));
            if ("news".equals(bVar.Sz().vd())) {
                this.cvZ.setVisibility(8);
                this.cwh.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.k.person_view_num, ao.y(bVar.Sz().vf())));
                return;
            }
            this.cvZ.setVisibility(0);
            k(bVar.Sz());
        }
    }

    private void k(bd bdVar) {
        if (this.cwh != null && bdVar != null) {
            this.cwh.setVisibility(0);
            if (!StringUtils.isNull(bdVar.vm().getName_show())) {
                this.cwh.setText(fo(bdVar.vm().getName_show()));
            }
        }
    }

    protected String fo(String str) {
        return ao.e(str, 14, "...");
    }

    public void iK(int i) {
        this.cvZ.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aiI() != null) {
            aiI().a(getView(), this.cwj);
        }
    }
}
