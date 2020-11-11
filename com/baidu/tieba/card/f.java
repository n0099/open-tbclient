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
    private TbImageView gSv;
    private LinearLayout hVP;
    private RelativeLayout hVR;
    private ImageView hVT;
    private ClickableHeaderImageView hVW;
    private View hWa;
    private TextView hWc;
    private TextView hWd;
    private TextView hWe;
    private TextView hWf;
    private com.baidu.tieba.e.b hWg;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hVP = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hVR = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.gSv = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.hVT = (ImageView) view.findViewById(R.id.img_play);
        this.hWc = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.hWd = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.hVW = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hWe = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.hWf = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.hWa = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.gSv.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gSv.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hVR.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.hVR.setLayoutParams(layoutParams);
        this.hVW.setDefaultResource(17170445);
        this.hVW.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hVW.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hVW.setIsRound(true);
        this.hVW.setDrawBorder(true);
        this.hVW.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hVW.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void xd(int i) {
        if (this.hWa != null) {
            this.hWa.setVisibility(i);
        }
    }

    public void z(int i, int i2, int i3, int i4) {
        if (this.hVP != null) {
            this.hVP.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hWa, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hWc, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Tb(this.hWg.bjZ().getId())) {
                ap.setViewTextColor(this.hWd, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hWd, (int) R.color.cp_cont_b);
            }
            ap.setViewTextColor(this.hWe, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hWf, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.bjZ() != null) {
            this.hWg = bVar;
            String str = null;
            if (bVar.bjZ().blg()) {
                this.hVT.setVisibility(0);
                this.hWc.setVisibility(0);
                if (bVar.bjZ().bmS() != null) {
                    this.hWc.setText(at.stringForVideoTime(bVar.bjZ().bmS().video_duration.intValue() * 1000));
                    str = bVar.bjZ().bmS().thumbnail_url;
                }
            } else {
                this.hVT.setVisibility(8);
                this.hWc.setVisibility(8);
                if (bVar.bjZ().bmJ() != null && bVar.bjZ().bmJ().size() >= 1) {
                    str = bVar.bjZ().bmJ().get(0).origin_pic;
                }
            }
            this.gSv.startLoad(str, 10, false);
            this.hWd.setText(bVar.bjZ().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Tb(bVar.bjZ().getId())) {
                ap.setViewTextColor(this.hWd, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hWd, (int) R.color.cp_cont_b);
            }
            this.hVW.setData(bVar.bjZ(), false);
            this.hWf.setText(at.getFormatTimeShort(bVar.bjZ().bmj()));
            if ("news".equals(bVar.bjZ().bmp())) {
                this.hVW.setVisibility(8);
                this.hWe.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, at.numberUniformFormat(bVar.bjZ().bms())));
                return;
            }
            this.hVW.setVisibility(0);
            i(bVar.bjZ());
        }
    }

    private void i(bw bwVar) {
        if (this.hWe != null && bwVar != null) {
            this.hWe.setVisibility(0);
            if (!StringUtils.isNull(bwVar.bmA().getName_show())) {
                this.hWe.setText(Cv(bwVar.bmA().getName_show()));
            }
        }
    }

    protected String Cv(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void xe(int i) {
        this.hVW.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnT() != null) {
            cnT().a(getView(), this.hWg);
        }
    }
}
