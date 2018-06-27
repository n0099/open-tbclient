package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f extends a<com.baidu.tieba.e.b> {
    private LinearLayout ctY;
    private RelativeLayout cua;
    private ImageView cuc;
    private ClickableHeaderImageView cuf;
    private View cuj;
    private TextView cul;
    private TextView cum;
    private TextView cun;
    private TextView cuo;
    private com.baidu.tieba.e.b cup;
    private TbImageView imgThumbnail;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ctY = (LinearLayout) view.findViewById(d.g.card_frs_game_thread_layout);
        this.cua = (RelativeLayout) view.findViewById(d.g.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(d.g.img_thumbnail);
        this.cuc = (ImageView) view.findViewById(d.g.img_play);
        this.cul = (TextView) view.findViewById(d.g.card_frs_game_video_time);
        this.cum = (TextView) view.findViewById(d.g.card_frs_game_video_title);
        this.cuf = (ClickableHeaderImageView) view.findViewById(d.g.card_frs_game_user_icon);
        this.cun = (TextView) view.findViewById(d.g.card_frs_game_read_time_or_name);
        this.cuo = (TextView) view.findViewById(d.g.card_frs_game_publish_time);
        this.cuj = view.findViewById(d.g.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(d.f.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(d.f.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cua.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.cua.setLayoutParams(layoutParams);
        this.cuf.setDefaultResource(17170445);
        this.cuf.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.cuf.setDefaultBgResource(d.C0142d.cp_bg_line_e);
        this.cuf.setIsRound(true);
        this.cuf.setDrawBorder(true);
        this.cuf.setBorderColor(am.getColor(d.C0142d.common_color_10043));
        this.cuf.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        getView().setOnClickListener(this);
    }

    public void iG(int i) {
        if (this.cuj != null) {
            this.cuj.setVisibility(i);
        }
    }

    public void n(int i, int i2, int i3, int i4) {
        if (this.ctY != null) {
            this.ctY.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(getView(), d.C0142d.cp_bg_line_d);
            am.i(this.cuj, d.C0142d.cp_bg_line_c);
            am.c(this.cul, d.C0142d.cp_cont_i, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ua(this.cup.SV().getId())) {
                am.h(this.cum, d.C0142d.cp_cont_c);
            } else {
                am.h(this.cum, d.C0142d.cp_cont_b);
            }
            am.c(this.cun, d.C0142d.cp_cont_d, 1);
            am.c(this.cuo, d.C0142d.cp_cont_d, 1);
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
        if (bVar != null && bVar.SV() != null) {
            this.cup = bVar;
            String str = null;
            if (bVar.SV().wh()) {
                this.cuc.setVisibility(0);
                this.cul.setVisibility(0);
                if (bVar.SV().vN() != null) {
                    this.cul.setText(ap.cY(bVar.SV().vN().video_duration.intValue() * 1000));
                    str = bVar.SV().vN().thumbnail_url;
                }
            } else {
                this.cuc.setVisibility(8);
                this.cul.setVisibility(8);
                if (bVar.SV().vG() != null && bVar.SV().vG().size() >= 1) {
                    str = bVar.SV().vG().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.cum.setText(bVar.SV().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ua(bVar.SV().getId())) {
                am.h(this.cum, d.C0142d.cp_cont_c);
            } else {
                am.h(this.cum, d.C0142d.cp_cont_b);
            }
            this.cuf.setData(bVar.SV(), false);
            this.cuo.setText(ap.x(bVar.SV().vh()));
            if ("news".equals(bVar.SV().vm())) {
                this.cuf.setVisibility(8);
                this.cun.setText(this.mTbPageContext.getPageActivity().getResources().getString(d.k.person_view_num, ap.z(bVar.SV().vo())));
                return;
            }
            this.cuf.setVisibility(0);
            m(bVar.SV());
        }
    }

    private void m(bc bcVar) {
        if (this.cun != null && bcVar != null) {
            this.cun.setVisibility(0);
            if (!StringUtils.isNull(bcVar.vw().getName_show())) {
                this.cun.setText(fs(bcVar.vw().getName_show()));
            }
        }
    }

    protected String fs(String str) {
        return ap.e(str, 14, "...");
    }

    public void iH(int i) {
        this.cuf.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aia() != null) {
            aia().a(getView(), this.cup);
        }
    }
}
