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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f extends b<com.baidu.tieba.e.b> {
    private TbImageView fFS;
    private LinearLayout gBV;
    private RelativeLayout gBX;
    private ImageView gBZ;
    private ClickableHeaderImageView gCc;
    private View gCg;
    private TextView gCi;
    private TextView gCj;
    private TextView gCk;
    private TextView gCl;
    private com.baidu.tieba.e.b gCm;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gBV = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gBX = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fFS = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.gBZ = (ImageView) view.findViewById(R.id.img_play);
        this.gCi = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.gCj = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.gCc = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gCk = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.gCl = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.gCg = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fFS.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fFS.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gBX.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.gBX.setLayoutParams(layoutParams);
        this.gCc.setDefaultResource(17170445);
        this.gCc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gCc.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gCc.setIsRound(true);
        this.gCc.setDrawBorder(true);
        this.gCc.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCc.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void sl(int i) {
        if (this.gCg != null) {
            this.gCg.setVisibility(i);
        }
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.gBV != null) {
            this.gBV.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.gCg, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gCi, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.MO(this.gCm.aOi().getId())) {
                am.setViewTextColor(this.gCj, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gCj, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.gCk, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gCl, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.aOi() != null) {
            this.gCm = bVar;
            String str = null;
            if (bVar.aOi().aPk()) {
                this.gBZ.setVisibility(0);
                this.gCi.setVisibility(0);
                if (bVar.aOi().aQQ() != null) {
                    this.gCi.setText(aq.stringForVideoTime(bVar.aOi().aQQ().video_duration.intValue() * 1000));
                    str = bVar.aOi().aQQ().thumbnail_url;
                }
            } else {
                this.gBZ.setVisibility(8);
                this.gCi.setVisibility(8);
                if (bVar.aOi().aQH() != null && bVar.aOi().aQH().size() >= 1) {
                    str = bVar.aOi().aQH().get(0).origin_pic;
                }
            }
            this.fFS.startLoad(str, 10, false);
            this.gCj.setText(bVar.aOi().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.MO(bVar.aOi().getId())) {
                am.setViewTextColor(this.gCj, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gCj, (int) R.color.cp_cont_b);
            }
            this.gCc.setData(bVar.aOi(), false);
            this.gCl.setText(aq.getFormatTimeShort(bVar.aOi().aQg()));
            if ("news".equals(bVar.aOi().aQm())) {
                this.gCc.setVisibility(8);
                this.gCk.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.aOi().aQp())));
                return;
            }
            this.gCc.setVisibility(0);
            h(bVar.aOi());
        }
    }

    private void h(bk bkVar) {
        if (this.gCk != null && bkVar != null) {
            this.gCk.setVisibility(0);
            if (!StringUtils.isNull(bkVar.aQx().getName_show())) {
                this.gCk.setText(wV(bkVar.aQx().getName_show()));
            }
        }
    }

    protected String wV(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void sm(int i) {
        this.gCc.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKS() != null) {
            bKS().a(getView(), this.gCm);
        }
    }
}
