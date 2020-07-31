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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class f extends b<com.baidu.tieba.e.b> {
    private TbImageView fWF;
    private LinearLayout gUC;
    private RelativeLayout gUE;
    private ImageView gUG;
    private ClickableHeaderImageView gUJ;
    private View gUN;
    private TextView gUP;
    private TextView gUQ;
    private TextView gUR;
    private TextView gUS;
    private com.baidu.tieba.e.b gUT;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gUC = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gUE = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fWF = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.gUG = (ImageView) view.findViewById(R.id.img_play);
        this.gUP = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.gUQ = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.gUJ = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gUR = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.gUS = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.gUN = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fWF.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fWF.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gUE.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.gUE.setLayoutParams(layoutParams);
        this.gUJ.setDefaultResource(17170445);
        this.gUJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gUJ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gUJ.setIsRound(true);
        this.gUJ.setDrawBorder(true);
        this.gUJ.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.gUJ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void td(int i) {
        if (this.gUN != null) {
            this.gUN.setVisibility(i);
        }
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.gUC != null) {
            this.gUC.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ao.setBackgroundResource(this.gUN, R.color.cp_bg_line_c);
            ao.setViewTextColor(this.gUP, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.NZ(this.gUT.aTN().getId())) {
                ao.setViewTextColor(this.gUQ, R.color.cp_cont_c);
            } else {
                ao.setViewTextColor(this.gUQ, R.color.cp_cont_b);
            }
            ao.setViewTextColor(this.gUR, R.color.cp_cont_d, 1);
            ao.setViewTextColor(this.gUS, R.color.cp_cont_d, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_common_small_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.e.b bVar) {
        if (bVar != null && bVar.aTN() != null) {
            this.gUT = bVar;
            String str = null;
            if (bVar.aTN().aUR()) {
                this.gUG.setVisibility(0);
                this.gUP.setVisibility(0);
                if (bVar.aTN().aWD() != null) {
                    this.gUP.setText(as.stringForVideoTime(bVar.aTN().aWD().video_duration.intValue() * 1000));
                    str = bVar.aTN().aWD().thumbnail_url;
                }
            } else {
                this.gUG.setVisibility(8);
                this.gUP.setVisibility(8);
                if (bVar.aTN().aWu() != null && bVar.aTN().aWu().size() >= 1) {
                    str = bVar.aTN().aWu().get(0).origin_pic;
                }
            }
            this.fWF.startLoad(str, 10, false);
            this.gUQ.setText(bVar.aTN().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.NZ(bVar.aTN().getId())) {
                ao.setViewTextColor(this.gUQ, R.color.cp_cont_c);
            } else {
                ao.setViewTextColor(this.gUQ, R.color.cp_cont_b);
            }
            this.gUJ.setData(bVar.aTN(), false);
            this.gUS.setText(as.getFormatTimeShort(bVar.aTN().aVU()));
            if ("news".equals(bVar.aTN().aWa())) {
                this.gUJ.setVisibility(8);
                this.gUR.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, as.numberUniformFormat(bVar.aTN().aWd())));
                return;
            }
            this.gUJ.setVisibility(0);
            h(bVar.aTN());
        }
    }

    private void h(bv bvVar) {
        if (this.gUR != null && bvVar != null) {
            this.gUR.setVisibility(0);
            if (!StringUtils.isNull(bvVar.aWl().getName_show())) {
                this.gUR.setText(yr(bvVar.aWl().getName_show()));
            }
        }
    }

    protected String yr(String str) {
        return as.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void te(int i) {
        this.gUJ.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bRn() != null) {
            bRn().a(getView(), this.gUT);
        }
    }
}
