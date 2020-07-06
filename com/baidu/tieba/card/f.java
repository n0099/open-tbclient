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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f extends b<com.baidu.tieba.e.b> {
    private TbImageView fRm;
    private LinearLayout gOW;
    private RelativeLayout gOY;
    private ImageView gPa;
    private ClickableHeaderImageView gPd;
    private View gPh;
    private TextView gPj;
    private TextView gPk;
    private TextView gPl;
    private TextView gPm;
    private com.baidu.tieba.e.b gPn;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gOW = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gOY = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fRm = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.gPa = (ImageView) view.findViewById(R.id.img_play);
        this.gPj = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.gPk = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.gPd = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gPl = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.gPm = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.gPh = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fRm.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fRm.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gOY.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.gOY.setLayoutParams(layoutParams);
        this.gPd.setDefaultResource(17170445);
        this.gPd.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gPd.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gPd.setIsRound(true);
        this.gPd.setDrawBorder(true);
        this.gPd.setBorderColor(an.getColor(R.color.common_color_10043));
        this.gPd.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void sL(int i) {
        if (this.gPh != null) {
            this.gPh.setVisibility(i);
        }
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.gOW != null) {
            this.gOW.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            an.setBackgroundResource(this.gPh, R.color.cp_bg_line_c);
            an.setViewTextColor(this.gPj, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Nr(this.gPn.aPS().getId())) {
                an.setViewTextColor(this.gPk, (int) R.color.cp_cont_c);
            } else {
                an.setViewTextColor(this.gPk, (int) R.color.cp_cont_b);
            }
            an.setViewTextColor(this.gPl, R.color.cp_cont_d, 1);
            an.setViewTextColor(this.gPm, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.aPS() != null) {
            this.gPn = bVar;
            String str = null;
            if (bVar.aPS().aQV()) {
                this.gPa.setVisibility(0);
                this.gPj.setVisibility(0);
                if (bVar.aPS().aSH() != null) {
                    this.gPj.setText(ar.stringForVideoTime(bVar.aPS().aSH().video_duration.intValue() * 1000));
                    str = bVar.aPS().aSH().thumbnail_url;
                }
            } else {
                this.gPa.setVisibility(8);
                this.gPj.setVisibility(8);
                if (bVar.aPS().aSy() != null && bVar.aPS().aSy().size() >= 1) {
                    str = bVar.aPS().aSy().get(0).origin_pic;
                }
            }
            this.fRm.startLoad(str, 10, false);
            this.gPk.setText(bVar.aPS().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Nr(bVar.aPS().getId())) {
                an.setViewTextColor(this.gPk, (int) R.color.cp_cont_c);
            } else {
                an.setViewTextColor(this.gPk, (int) R.color.cp_cont_b);
            }
            this.gPd.setData(bVar.aPS(), false);
            this.gPm.setText(ar.getFormatTimeShort(bVar.aPS().aRY()));
            if ("news".equals(bVar.aPS().aSe())) {
                this.gPd.setVisibility(8);
                this.gPl.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, ar.numberUniformFormat(bVar.aPS().aSh())));
                return;
            }
            this.gPd.setVisibility(0);
            h(bVar.aPS());
        }
    }

    private void h(bu buVar) {
        if (this.gPl != null && buVar != null) {
            this.gPl.setVisibility(0);
            if (!StringUtils.isNull(buVar.aSp().getName_show())) {
                this.gPl.setText(xm(buVar.aSp().getName_show()));
            }
        }
    }

    protected String xm(String str) {
        return ar.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void sM(int i) {
        this.gPd.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bOd() != null) {
            bOd().a(getView(), this.gPn);
        }
    }
}
