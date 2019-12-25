package com.baidu.tieba.card;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private TbImageView eHN;
    private LinearLayout fBK;
    private RelativeLayout fBM;
    private ImageView fBO;
    private ClickableHeaderImageView fBR;
    private View fBV;
    private TextView fBX;
    private TextView fBY;
    private TextView fBZ;
    private TextView fCa;
    private com.baidu.tieba.e.b fCb;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fBK = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fBM = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eHN = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.fBO = (ImageView) view.findViewById(R.id.img_play);
        this.fBX = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.fBY = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.fBR = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fBZ = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.fCa = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.fBV = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eHN.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eHN.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBM.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.fBM.setLayoutParams(layoutParams);
        this.fBR.setDefaultResource(17170445);
        this.fBR.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fBR.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fBR.setIsRound(true);
        this.fBR.setDrawBorder(true);
        this.fBR.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fBR.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void rb(int i) {
        if (this.fBV != null) {
            this.fBV.setVisibility(i);
        }
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.fBK != null) {
            this.fBK.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fBV, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fBX, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.IR(this.fCb.axx().getId())) {
                am.setViewTextColor(this.fBY, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fBY, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.fBZ, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fCa, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.axx() != null) {
            this.fCb = bVar;
            String str = null;
            if (bVar.axx().aAE()) {
                this.fBO.setVisibility(0);
                this.fBX.setVisibility(0);
                if (bVar.axx().azV() != null) {
                    this.fBX.setText(aq.stringForVideoTime(bVar.axx().azV().video_duration.intValue() * 1000));
                    str = bVar.axx().azV().thumbnail_url;
                }
            } else {
                this.fBO.setVisibility(8);
                this.fBX.setVisibility(8);
                if (bVar.axx().azO() != null && bVar.axx().azO().size() >= 1) {
                    str = bVar.axx().azO().get(0).origin_pic;
                }
            }
            this.eHN.startLoad(str, 10, false);
            this.fBY.setText(bVar.axx().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.IR(bVar.axx().getId())) {
                am.setViewTextColor(this.fBY, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fBY, (int) R.color.cp_cont_b);
            }
            this.fBR.setData(bVar.axx(), false);
            this.fCa.setText(aq.getFormatTimeShort(bVar.axx().azn()));
            if ("news".equals(bVar.axx().azt())) {
                this.fBR.setVisibility(8);
                this.fBZ.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.axx().azw())));
                return;
            }
            this.fBR.setVisibility(0);
            h(bVar.axx());
        }
    }

    private void h(bj bjVar) {
        if (this.fBZ != null && bjVar != null) {
            this.fBZ.setVisibility(0);
            if (!StringUtils.isNull(bjVar.azE().getName_show())) {
                this.fBZ.setText(tE(bjVar.azE().getName_show()));
            }
        }
    }

    protected String tE(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void rc(int i) {
        this.fBR.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (brY() != null) {
            brY().a(getView(), this.fCb);
        }
    }
}
