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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private LinearLayout eAg;
    private RelativeLayout eAi;
    private ImageView eAk;
    private ClickableHeaderImageView eAn;
    private View eAr;
    private TextView eAt;
    private TextView eAu;
    private TextView eAv;
    private TextView eAw;
    private com.baidu.tieba.e.b eAx;
    private TbImageView imgThumbnail;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eAg = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.eAi = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.eAk = (ImageView) view.findViewById(R.id.img_play);
        this.eAt = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.eAu = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.eAn = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.eAv = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.eAw = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.eAr = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(R.drawable.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eAi.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.eAi.setLayoutParams(layoutParams);
        this.eAn.setDefaultResource(17170445);
        this.eAn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eAn.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eAn.setIsRound(true);
        this.eAn.setDrawBorder(true);
        this.eAn.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eAn.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void pC(int i) {
        if (this.eAr != null) {
            this.eAr.setVisibility(i);
        }
    }

    public void s(int i, int i2, int i3, int i4) {
        if (this.eAg != null) {
            this.eAg.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.color.cp_bg_line_d);
            am.k(this.eAr, R.color.cp_bg_line_c);
            am.f(this.eAt, R.color.cp_btn_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.EX(this.eAx.acx().getId())) {
                am.j(this.eAu, R.color.cp_cont_c);
            } else {
                am.j(this.eAu, R.color.cp_cont_b);
            }
            am.f(this.eAv, R.color.cp_cont_d, 1);
            am.f(this.eAw, R.color.cp_cont_d, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_frs_game_common_small_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.e.b bVar) {
        if (bVar != null && bVar.acx() != null) {
            this.eAx = bVar;
            String str = null;
            if (bVar.acx().afr()) {
                this.eAk.setVisibility(0);
                this.eAt.setVisibility(0);
                if (bVar.acx().aeO() != null) {
                    this.eAt.setText(aq.is(bVar.acx().aeO().video_duration.intValue() * 1000));
                    str = bVar.acx().aeO().thumbnail_url;
                }
            } else {
                this.eAk.setVisibility(8);
                this.eAt.setVisibility(8);
                if (bVar.acx().aeH() != null && bVar.acx().aeH().size() >= 1) {
                    str = bVar.acx().aeH().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.eAu.setText(bVar.acx().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.EX(bVar.acx().getId())) {
                am.j(this.eAu, R.color.cp_cont_c);
            } else {
                am.j(this.eAu, R.color.cp_cont_b);
            }
            this.eAn.setData(bVar.acx(), false);
            this.eAw.setText(aq.aF(bVar.acx().aeh()));
            if ("news".equals(bVar.acx().aem())) {
                this.eAn.setVisibility(8);
                this.eAv.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.aH(bVar.acx().aep())));
                return;
            }
            this.eAn.setVisibility(0);
            f(bVar.acx());
        }
    }

    private void f(bg bgVar) {
        if (this.eAv != null && bgVar != null) {
            this.eAv.setVisibility(0);
            if (!StringUtils.isNull(bgVar.aex().getName_show())) {
                this.eAv.setText(oT(bgVar.aex().getName_show()));
            }
        }
    }

    protected String oT(String str) {
        return aq.j(str, 14, "...");
    }

    public void pD(int i) {
        this.eAn.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZo() != null) {
            aZo().a(getView(), this.eAx);
        }
    }
}
