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
    private TbImageView eMS;
    private ClickableHeaderImageView fHB;
    private View fHF;
    private TextView fHH;
    private TextView fHI;
    private TextView fHJ;
    private TextView fHK;
    private com.baidu.tieba.e.b fHL;
    private LinearLayout fHu;
    private RelativeLayout fHw;
    private ImageView fHy;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fHu = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fHw = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eMS = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.fHy = (ImageView) view.findViewById(R.id.img_play);
        this.fHH = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.fHI = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.fHB = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fHJ = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.fHK = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.fHF = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eMS.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eMS.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHw.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.fHw.setLayoutParams(layoutParams);
        this.fHB.setDefaultResource(17170445);
        this.fHB.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fHB.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fHB.setIsRound(true);
        this.fHB.setDrawBorder(true);
        this.fHB.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHB.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void rn(int i) {
        if (this.fHF != null) {
            this.fHF.setVisibility(i);
        }
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.fHu != null) {
            this.fHu.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fHF, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fHH, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(this.fHL.aAg().getId())) {
                am.setViewTextColor(this.fHI, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fHI, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.fHJ, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHK, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.aAg() != null) {
            this.fHL = bVar;
            String str = null;
            if (bVar.aAg().aBb()) {
                this.fHy.setVisibility(0);
                this.fHH.setVisibility(0);
                if (bVar.aAg().aCF() != null) {
                    this.fHH.setText(aq.stringForVideoTime(bVar.aAg().aCF().video_duration.intValue() * 1000));
                    str = bVar.aAg().aCF().thumbnail_url;
                }
            } else {
                this.fHy.setVisibility(8);
                this.fHH.setVisibility(8);
                if (bVar.aAg().aCy() != null && bVar.aAg().aCy().size() >= 1) {
                    str = bVar.aAg().aCy().get(0).origin_pic;
                }
            }
            this.eMS.startLoad(str, 10, false);
            this.fHI.setText(bVar.aAg().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(bVar.aAg().getId())) {
                am.setViewTextColor(this.fHI, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fHI, (int) R.color.cp_cont_b);
            }
            this.fHB.setData(bVar.aAg(), false);
            this.fHK.setText(aq.getFormatTimeShort(bVar.aAg().aBX()));
            if ("news".equals(bVar.aAg().aCd())) {
                this.fHB.setVisibility(8);
                this.fHJ.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.aAg().aCg())));
                return;
            }
            this.fHB.setVisibility(0);
            h(bVar.aAg());
        }
    }

    private void h(bj bjVar) {
        if (this.fHJ != null && bjVar != null) {
            this.fHJ.setVisibility(0);
            if (!StringUtils.isNull(bjVar.aCo().getName_show())) {
                this.fHJ.setText(tY(bjVar.aCo().getName_show()));
            }
        }
    }

    protected String tY(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void ro(int i) {
        this.fHB.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buG() != null) {
            buG().a(getView(), this.fHL);
        }
    }
}
