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
    private TbImageView fGd;
    private LinearLayout gCg;
    private RelativeLayout gCi;
    private ImageView gCk;
    private ClickableHeaderImageView gCn;
    private View gCr;
    private TextView gCt;
    private TextView gCu;
    private TextView gCv;
    private TextView gCw;
    private com.baidu.tieba.e.b gCx;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gCg = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gCi = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fGd = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.gCk = (ImageView) view.findViewById(R.id.img_play);
        this.gCt = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.gCu = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.gCn = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gCv = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.gCw = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.gCr = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fGd.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fGd.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gCi.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.gCi.setLayoutParams(layoutParams);
        this.gCn.setDefaultResource(17170445);
        this.gCn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gCn.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gCn.setIsRound(true);
        this.gCn.setDrawBorder(true);
        this.gCn.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gCn.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void sn(int i) {
        if (this.gCr != null) {
            this.gCr.setVisibility(i);
        }
    }

    public void x(int i, int i2, int i3, int i4) {
        if (this.gCg != null) {
            this.gCg.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.gCr, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gCt, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.MP(this.gCx.aOi().getId())) {
                am.setViewTextColor(this.gCu, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gCu, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.gCv, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gCw, R.color.cp_cont_d, 1);
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
            this.gCx = bVar;
            String str = null;
            if (bVar.aOi().aPk()) {
                this.gCk.setVisibility(0);
                this.gCt.setVisibility(0);
                if (bVar.aOi().aQQ() != null) {
                    this.gCt.setText(aq.stringForVideoTime(bVar.aOi().aQQ().video_duration.intValue() * 1000));
                    str = bVar.aOi().aQQ().thumbnail_url;
                }
            } else {
                this.gCk.setVisibility(8);
                this.gCt.setVisibility(8);
                if (bVar.aOi().aQH() != null && bVar.aOi().aQH().size() >= 1) {
                    str = bVar.aOi().aQH().get(0).origin_pic;
                }
            }
            this.fGd.startLoad(str, 10, false);
            this.gCu.setText(bVar.aOi().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.MP(bVar.aOi().getId())) {
                am.setViewTextColor(this.gCu, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gCu, (int) R.color.cp_cont_b);
            }
            this.gCn.setData(bVar.aOi(), false);
            this.gCw.setText(aq.getFormatTimeShort(bVar.aOi().aQg()));
            if ("news".equals(bVar.aOi().aQm())) {
                this.gCn.setVisibility(8);
                this.gCv.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.aOi().aQp())));
                return;
            }
            this.gCn.setVisibility(0);
            h(bVar.aOi());
        }
    }

    private void h(bk bkVar) {
        if (this.gCv != null && bkVar != null) {
            this.gCv.setVisibility(0);
            if (!StringUtils.isNull(bkVar.aQx().getName_show())) {
                this.gCv.setText(wV(bkVar.aQx().getName_show()));
            }
        }
    }

    protected String wV(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void so(int i) {
        this.gCn.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKU() != null) {
            bKU().a(getView(), this.gCx);
        }
    }
}
