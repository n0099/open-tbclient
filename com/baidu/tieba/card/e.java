package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private LinearLayout eBW;
    private RelativeLayout eBY;
    private ImageView eCa;
    private ClickableHeaderImageView eCd;
    private View eCh;
    private TextView eCj;
    private TextView eCk;
    private TextView eCl;
    private TextView eCm;
    private com.baidu.tieba.e.b eCn;
    private TbImageView imgThumbnail;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eBW = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.eBY = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.eCa = (ImageView) view.findViewById(R.id.img_play);
        this.eCj = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.eCk = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.eCd = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.eCl = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.eCm = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.eCh = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(R.drawable.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eBY.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.eBY.setLayoutParams(layoutParams);
        this.eCd.setDefaultResource(17170445);
        this.eCd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eCd.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eCd.setIsRound(true);
        this.eCd.setDrawBorder(true);
        this.eCd.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eCd.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void pH(int i) {
        if (this.eCh != null) {
            this.eCh.setVisibility(i);
        }
    }

    public void v(int i, int i2, int i3, int i4) {
        if (this.eBW != null) {
            this.eBW.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.color.cp_bg_line_d);
            am.k(this.eCh, R.color.cp_bg_line_c);
            am.f(this.eCj, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Fy(this.eCn.acC().getId())) {
                am.j(this.eCk, R.color.cp_cont_c);
            } else {
                am.j(this.eCk, R.color.cp_cont_b);
            }
            am.f(this.eCl, R.color.cp_cont_d, 1);
            am.f(this.eCm, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.acC() != null) {
            this.eCn = bVar;
            String str = null;
            if (bVar.acC().afw()) {
                this.eCa.setVisibility(0);
                this.eCj.setVisibility(0);
                if (bVar.acC().aeT() != null) {
                    this.eCj.setText(aq.it(bVar.acC().aeT().video_duration.intValue() * 1000));
                    str = bVar.acC().aeT().thumbnail_url;
                }
            } else {
                this.eCa.setVisibility(8);
                this.eCj.setVisibility(8);
                if (bVar.acC().aeM() != null && bVar.acC().aeM().size() >= 1) {
                    str = bVar.acC().aeM().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.eCk.setText(bVar.acC().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Fy(bVar.acC().getId())) {
                am.j(this.eCk, R.color.cp_cont_c);
            } else {
                am.j(this.eCk, R.color.cp_cont_b);
            }
            this.eCd.setData(bVar.acC(), false);
            this.eCm.setText(aq.aF(bVar.acC().aem()));
            if ("news".equals(bVar.acC().aer())) {
                this.eCd.setVisibility(8);
                this.eCl.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.aH(bVar.acC().aeu())));
                return;
            }
            this.eCd.setVisibility(0);
            g(bVar.acC());
        }
    }

    private void g(bh bhVar) {
        if (this.eCl != null && bhVar != null) {
            this.eCl.setVisibility(0);
            if (!StringUtils.isNull(bhVar.aeC().getName_show())) {
                this.eCl.setText(pb(bhVar.aeC().getName_show()));
            }
        }
    }

    protected String pb(String str) {
        return aq.j(str, 14, "...");
    }

    public void pI(int i) {
        this.eCd.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZU() != null) {
            aZU().a(getView(), this.eCn);
        }
    }
}
