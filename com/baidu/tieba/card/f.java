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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f extends b<com.baidu.tieba.e.b> {
    private TbImageView gAi;
    private ImageView hDA;
    private ClickableHeaderImageView hDD;
    private View hDH;
    private TextView hDJ;
    private TextView hDK;
    private TextView hDL;
    private TextView hDM;
    private com.baidu.tieba.e.b hDN;
    private LinearLayout hDw;
    private RelativeLayout hDy;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hDw = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hDy = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.gAi = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.hDA = (ImageView) view.findViewById(R.id.img_play);
        this.hDJ = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.hDK = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.hDD = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hDL = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.hDM = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.hDH = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.gAi.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gAi.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hDy.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.hDy.setLayoutParams(layoutParams);
        this.hDD.setDefaultResource(17170445);
        this.hDD.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hDD.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hDD.setIsRound(true);
        this.hDD.setDrawBorder(true);
        this.hDD.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hDD.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void wx(int i) {
        if (this.hDH != null) {
            this.hDH.setVisibility(i);
        }
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.hDw != null) {
            this.hDw.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hDH, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hDJ, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Sl(this.hDN.bfG().getId())) {
                ap.setViewTextColor(this.hDK, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hDK, (int) R.color.cp_cont_b);
            }
            ap.setViewTextColor(this.hDL, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hDM, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.bfG() != null) {
            this.hDN = bVar;
            String str = null;
            if (bVar.bfG().bgN()) {
                this.hDA.setVisibility(0);
                this.hDJ.setVisibility(0);
                if (bVar.bfG().biz() != null) {
                    this.hDJ.setText(at.stringForVideoTime(bVar.bfG().biz().video_duration.intValue() * 1000));
                    str = bVar.bfG().biz().thumbnail_url;
                }
            } else {
                this.hDA.setVisibility(8);
                this.hDJ.setVisibility(8);
                if (bVar.bfG().biq() != null && bVar.bfG().biq().size() >= 1) {
                    str = bVar.bfG().biq().get(0).origin_pic;
                }
            }
            this.gAi.startLoad(str, 10, false);
            this.hDK.setText(bVar.bfG().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Sl(bVar.bfG().getId())) {
                ap.setViewTextColor(this.hDK, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hDK, (int) R.color.cp_cont_b);
            }
            this.hDD.setData(bVar.bfG(), false);
            this.hDM.setText(at.getFormatTimeShort(bVar.bfG().bhQ()));
            if ("news".equals(bVar.bfG().bhW())) {
                this.hDD.setVisibility(8);
                this.hDL.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, at.numberUniformFormat(bVar.bfG().bhZ())));
                return;
            }
            this.hDD.setVisibility(0);
            i(bVar.bfG());
        }
    }

    private void i(bw bwVar) {
        if (this.hDL != null && bwVar != null) {
            this.hDL.setVisibility(0);
            if (!StringUtils.isNull(bwVar.bih().getName_show())) {
                this.hDL.setText(BO(bwVar.bih().getName_show()));
            }
        }
    }

    protected String BO(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void wy(int i) {
        this.hDD.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cil() != null) {
            cil().a(getView(), this.hDN);
        }
    }
}
