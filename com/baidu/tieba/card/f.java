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
/* loaded from: classes16.dex */
public class f extends b<com.baidu.tieba.e.b> {
    private TbImageView giI;
    private RelativeLayout hhA;
    private ImageView hhC;
    private ClickableHeaderImageView hhF;
    private View hhJ;
    private TextView hhL;
    private TextView hhM;
    private TextView hhN;
    private TextView hhO;
    private com.baidu.tieba.e.b hhP;
    private LinearLayout hhy;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hhy = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hhA = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.giI = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.hhC = (ImageView) view.findViewById(R.id.img_play);
        this.hhL = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.hhM = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.hhF = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hhN = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.hhO = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.hhJ = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.giI.setDefaultBgResource(R.drawable.icon_morenpic);
        this.giI.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hhA.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.hhA.setLayoutParams(layoutParams);
        this.hhF.setDefaultResource(17170445);
        this.hhF.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hhF.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hhF.setIsRound(true);
        this.hhF.setDrawBorder(true);
        this.hhF.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hhF.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void vs(int i) {
        if (this.hhJ != null) {
            this.hhJ.setVisibility(i);
        }
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.hhy != null) {
            this.hhy.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hhJ, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hhL, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.QX(this.hhP.bce().getId())) {
                ap.setViewTextColor(this.hhM, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hhM, (int) R.color.cp_cont_b);
            }
            ap.setViewTextColor(this.hhN, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hhO, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.bce() != null) {
            this.hhP = bVar;
            String str = null;
            if (bVar.bce().bdk()) {
                this.hhC.setVisibility(0);
                this.hhL.setVisibility(0);
                if (bVar.bce().beW() != null) {
                    this.hhL.setText(at.stringForVideoTime(bVar.bce().beW().video_duration.intValue() * 1000));
                    str = bVar.bce().beW().thumbnail_url;
                }
            } else {
                this.hhC.setVisibility(8);
                this.hhL.setVisibility(8);
                if (bVar.bce().beN() != null && bVar.bce().beN().size() >= 1) {
                    str = bVar.bce().beN().get(0).origin_pic;
                }
            }
            this.giI.startLoad(str, 10, false);
            this.hhM.setText(bVar.bce().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.QX(bVar.bce().getId())) {
                ap.setViewTextColor(this.hhM, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hhM, (int) R.color.cp_cont_b);
            }
            this.hhF.setData(bVar.bce(), false);
            this.hhO.setText(at.getFormatTimeShort(bVar.bce().ben()));
            if ("news".equals(bVar.bce().bet())) {
                this.hhF.setVisibility(8);
                this.hhN.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, at.numberUniformFormat(bVar.bce().bew())));
                return;
            }
            this.hhF.setVisibility(0);
            h(bVar.bce());
        }
    }

    private void h(bw bwVar) {
        if (this.hhN != null && bwVar != null) {
            this.hhN.setVisibility(0);
            if (!StringUtils.isNull(bwVar.beE().getName_show())) {
                this.hhN.setText(AG(bwVar.beE().getName_show()));
            }
        }
    }

    protected String AG(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void vt(int i) {
        this.hhF.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbA() != null) {
            cbA().a(getView(), this.hhP);
        }
    }
}
