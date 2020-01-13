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
/* loaded from: classes7.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private TbImageView eIX;
    private LinearLayout fEV;
    private RelativeLayout fEX;
    private ImageView fEZ;
    private ClickableHeaderImageView fFc;
    private View fFg;
    private TextView fFi;
    private TextView fFj;
    private TextView fFk;
    private TextView fFl;
    private com.baidu.tieba.e.b fFm;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.fEV = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.fEX = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.eIX = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.fEZ = (ImageView) view.findViewById(R.id.img_play);
        this.fFi = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.fFj = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.fFc = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.fFk = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.fFl = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.fFg = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.eIX.setDefaultBgResource(R.drawable.icon_morenpic);
        this.eIX.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fEX.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.fEX.setLayoutParams(layoutParams);
        this.fFc.setDefaultResource(17170445);
        this.fFc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.fFc.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fFc.setIsRound(true);
        this.fFc.setDrawBorder(true);
        this.fFc.setBorderColor(am.getColor(R.color.common_color_10043));
        this.fFc.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void rg(int i) {
        if (this.fFg != null) {
            this.fFg.setVisibility(i);
        }
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.fEV != null) {
            this.fEV.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.fFg, R.color.cp_bg_line_c);
            am.setViewTextColor(this.fFi, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jb(this.fFm.axQ().getId())) {
                am.setViewTextColor(this.fFj, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fFj, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.fFk, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.fFl, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.axQ() != null) {
            this.fFm = bVar;
            String str = null;
            if (bVar.axQ().aAX()) {
                this.fEZ.setVisibility(0);
                this.fFi.setVisibility(0);
                if (bVar.axQ().aAo() != null) {
                    this.fFi.setText(aq.stringForVideoTime(bVar.axQ().aAo().video_duration.intValue() * 1000));
                    str = bVar.axQ().aAo().thumbnail_url;
                }
            } else {
                this.fEZ.setVisibility(8);
                this.fFi.setVisibility(8);
                if (bVar.axQ().aAh() != null && bVar.axQ().aAh().size() >= 1) {
                    str = bVar.axQ().aAh().get(0).origin_pic;
                }
            }
            this.eIX.startLoad(str, 10, false);
            this.fFj.setText(bVar.axQ().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jb(bVar.axQ().getId())) {
                am.setViewTextColor(this.fFj, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.fFj, (int) R.color.cp_cont_b);
            }
            this.fFc.setData(bVar.axQ(), false);
            this.fFl.setText(aq.getFormatTimeShort(bVar.axQ().azG()));
            if ("news".equals(bVar.axQ().azM())) {
                this.fFc.setVisibility(8);
                this.fFk.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.axQ().azP())));
                return;
            }
            this.fFc.setVisibility(0);
            h(bVar.axQ());
        }
    }

    private void h(bj bjVar) {
        if (this.fFk != null && bjVar != null) {
            this.fFk.setVisibility(0);
            if (!StringUtils.isNull(bjVar.azX().getName_show())) {
                this.fFk.setText(tI(bjVar.azX().getName_show()));
            }
        }
    }

    protected String tI(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void rh(int i) {
        this.fFc.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bta() != null) {
            bta().a(getView(), this.fFm);
        }
    }
}
