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
    private TextView eAA;
    private TextView eAB;
    private TextView eAC;
    private TextView eAD;
    private com.baidu.tieba.e.b eAE;
    private LinearLayout eAn;
    private RelativeLayout eAp;
    private ImageView eAr;
    private ClickableHeaderImageView eAu;
    private View eAy;
    private TbImageView imgThumbnail;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eAn = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.eAp = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.imgThumbnail = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.eAr = (ImageView) view.findViewById(R.id.img_play);
        this.eAA = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.eAB = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.eAu = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.eAC = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.eAD = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.eAy = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.imgThumbnail.setDefaultBgResource(R.drawable.icon_morenpic);
        this.imgThumbnail.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eAp.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.eAp.setLayoutParams(layoutParams);
        this.eAu.setDefaultResource(17170445);
        this.eAu.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eAu.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eAu.setIsRound(true);
        this.eAu.setDrawBorder(true);
        this.eAu.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eAu.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void pD(int i) {
        if (this.eAy != null) {
            this.eAy.setVisibility(i);
        }
    }

    public void s(int i, int i2, int i3, int i4) {
        if (this.eAn != null) {
            this.eAn.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.k(getView(), R.color.cp_bg_line_d);
            am.k(this.eAy, R.color.cp_bg_line_c);
            am.f(this.eAA, R.color.cp_btn_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.EY(this.eAE.acy().getId())) {
                am.j(this.eAB, R.color.cp_cont_c);
            } else {
                am.j(this.eAB, R.color.cp_cont_b);
            }
            am.f(this.eAC, R.color.cp_cont_d, 1);
            am.f(this.eAD, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.acy() != null) {
            this.eAE = bVar;
            String str = null;
            if (bVar.acy().afs()) {
                this.eAr.setVisibility(0);
                this.eAA.setVisibility(0);
                if (bVar.acy().aeP() != null) {
                    this.eAA.setText(aq.is(bVar.acy().aeP().video_duration.intValue() * 1000));
                    str = bVar.acy().aeP().thumbnail_url;
                }
            } else {
                this.eAr.setVisibility(8);
                this.eAA.setVisibility(8);
                if (bVar.acy().aeI() != null && bVar.acy().aeI().size() >= 1) {
                    str = bVar.acy().aeI().get(0).origin_pic;
                }
            }
            this.imgThumbnail.startLoad(str, 10, false);
            this.eAB.setText(bVar.acy().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.EY(bVar.acy().getId())) {
                am.j(this.eAB, R.color.cp_cont_c);
            } else {
                am.j(this.eAB, R.color.cp_cont_b);
            }
            this.eAu.setData(bVar.acy(), false);
            this.eAD.setText(aq.aF(bVar.acy().aei()));
            if ("news".equals(bVar.acy().aen())) {
                this.eAu.setVisibility(8);
                this.eAC.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.aH(bVar.acy().aeq())));
                return;
            }
            this.eAu.setVisibility(0);
            f(bVar.acy());
        }
    }

    private void f(bh bhVar) {
        if (this.eAC != null && bhVar != null) {
            this.eAC.setVisibility(0);
            if (!StringUtils.isNull(bhVar.aey().getName_show())) {
                this.eAC.setText(oT(bhVar.aey().getName_show()));
            }
        }
    }

    protected String oT(String str) {
        return aq.j(str, 14, "...");
    }

    public void pE(int i) {
        this.eAu.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZq() != null) {
            aZq().a(getView(), this.eAE);
        }
    }
}
