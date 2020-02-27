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
/* loaded from: classes9.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private TbImageView eMR;
    private View fHD;
    private TextView fHF;
    private TextView fHG;
    private TextView fHH;
    private TextView fHI;
    private com.baidu.tieba.e.b fHJ;
    private LinearLayout fHs;
    private RelativeLayout fHu;
    private ImageView fHw;
    private ClickableHeaderImageView fHz;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fHs = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fHu = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eMR = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.fHw = (ImageView) view.findViewById(R.id.img_play);
        this.fHF = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.fHG = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.fHz = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fHH = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.fHI = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.fHD = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eMR.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eMR.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHu.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.fHu.setLayoutParams(layoutParams);
        this.fHz.setDefaultResource(17170445);
        this.fHz.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fHz.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fHz.setIsRound(true);
        this.fHz.setDrawBorder(true);
        this.fHz.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHz.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void rn(int i) {
        if (this.fHD != null) {
            this.fHD.setVisibility(i);
        }
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.fHs != null) {
            this.fHs.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fHD, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fHF, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(this.fHJ.aAe().getId())) {
                am.setViewTextColor(this.fHG, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fHG, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.fHH, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHI, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.aAe() != null) {
            this.fHJ = bVar;
            String str = null;
            if (bVar.aAe().aAZ()) {
                this.fHw.setVisibility(0);
                this.fHF.setVisibility(0);
                if (bVar.aAe().aCD() != null) {
                    this.fHF.setText(aq.stringForVideoTime(bVar.aAe().aCD().video_duration.intValue() * 1000));
                    str = bVar.aAe().aCD().thumbnail_url;
                }
            } else {
                this.fHw.setVisibility(8);
                this.fHF.setVisibility(8);
                if (bVar.aAe().aCw() != null && bVar.aAe().aCw().size() >= 1) {
                    str = bVar.aAe().aCw().get(0).origin_pic;
                }
            }
            this.eMR.startLoad(str, 10, false);
            this.fHG.setText(bVar.aAe().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(bVar.aAe().getId())) {
                am.setViewTextColor(this.fHG, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fHG, (int) R.color.cp_cont_b);
            }
            this.fHz.setData(bVar.aAe(), false);
            this.fHI.setText(aq.getFormatTimeShort(bVar.aAe().aBV()));
            if ("news".equals(bVar.aAe().aCb())) {
                this.fHz.setVisibility(8);
                this.fHH.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.aAe().aCe())));
                return;
            }
            this.fHz.setVisibility(0);
            h(bVar.aAe());
        }
    }

    private void h(bj bjVar) {
        if (this.fHH != null && bjVar != null) {
            this.fHH.setVisibility(0);
            if (!StringUtils.isNull(bjVar.aCm().getName_show())) {
                this.fHH.setText(tY(bjVar.aCm().getName_show()));
            }
        }
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void ro(int i) {
        this.fHz.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buE() != null) {
            buE().a(getView(), this.fHJ);
        }
    }
}
