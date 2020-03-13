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
    private TbImageView eNf;
    private LinearLayout fHH;
    private RelativeLayout fHJ;
    private ImageView fHL;
    private ClickableHeaderImageView fHO;
    private View fHS;
    private TextView fHU;
    private TextView fHV;
    private TextView fHW;
    private TextView fHX;
    private com.baidu.tieba.e.b fHY;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fHH = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fHJ = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eNf = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.fHL = (ImageView) view.findViewById(R.id.img_play);
        this.fHU = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.fHV = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.fHO = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fHW = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.fHX = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.fHS = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eNf.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eNf.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fHJ.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.fHJ.setLayoutParams(layoutParams);
        this.fHO.setDefaultResource(17170445);
        this.fHO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fHO.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fHO.setIsRound(true);
        this.fHO.setDrawBorder(true);
        this.fHO.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fHO.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void rn(int i) {
        if (this.fHS != null) {
            this.fHS.setVisibility(i);
        }
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.fHH != null) {
            this.fHH.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fHS, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fHU, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jp(this.fHY.aAg().getId())) {
                am.setViewTextColor(this.fHV, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fHV, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.fHW, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fHX, R.color.cp_cont_d, 1);
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
            this.fHY = bVar;
            String str = null;
            if (bVar.aAg().aBb()) {
                this.fHL.setVisibility(0);
                this.fHU.setVisibility(0);
                if (bVar.aAg().aCF() != null) {
                    this.fHU.setText(aq.stringForVideoTime(bVar.aAg().aCF().video_duration.intValue() * 1000));
                    str = bVar.aAg().aCF().thumbnail_url;
                }
            } else {
                this.fHL.setVisibility(8);
                this.fHU.setVisibility(8);
                if (bVar.aAg().aCy() != null && bVar.aAg().aCy().size() >= 1) {
                    str = bVar.aAg().aCy().get(0).origin_pic;
                }
            }
            this.eNf.startLoad(str, 10, false);
            this.fHV.setText(bVar.aAg().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jp(bVar.aAg().getId())) {
                am.setViewTextColor(this.fHV, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fHV, (int) R.color.cp_cont_b);
            }
            this.fHO.setData(bVar.aAg(), false);
            this.fHX.setText(aq.getFormatTimeShort(bVar.aAg().aBX()));
            if ("news".equals(bVar.aAg().aCd())) {
                this.fHO.setVisibility(8);
                this.fHW.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.aAg().aCg())));
                return;
            }
            this.fHO.setVisibility(0);
            h(bVar.aAg());
        }
    }

    private void h(bj bjVar) {
        if (this.fHW != null && bjVar != null) {
            this.fHW.setVisibility(0);
            if (!StringUtils.isNull(bjVar.aCo().getName_show())) {
                this.fHW.setText(tZ(bjVar.aCo().getName_show()));
            }
        }
    }

    protected String tZ(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void ro(int i) {
        this.fHO.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buH() != null) {
            buH().a(getView(), this.fHY);
        }
    }
}
