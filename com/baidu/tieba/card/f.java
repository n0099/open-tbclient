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
    private TbImageView giE;
    private ClickableHeaderImageView hhB;
    private View hhF;
    private TextView hhH;
    private TextView hhI;
    private TextView hhJ;
    private TextView hhK;
    private com.baidu.tieba.e.b hhL;
    private LinearLayout hhu;
    private RelativeLayout hhw;
    private ImageView hhy;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hhu = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hhw = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.giE = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.hhy = (ImageView) view.findViewById(R.id.img_play);
        this.hhH = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.hhI = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.hhB = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hhJ = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.hhK = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.hhF = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.giE.setDefaultBgResource(R.drawable.icon_morenpic);
        this.giE.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hhw.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.hhw.setLayoutParams(layoutParams);
        this.hhB.setDefaultResource(17170445);
        this.hhB.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hhB.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hhB.setIsRound(true);
        this.hhB.setDrawBorder(true);
        this.hhB.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hhB.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void vs(int i) {
        if (this.hhF != null) {
            this.hhF.setVisibility(i);
        }
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.hhu != null) {
            this.hhu.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hhF, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hhH, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.QX(this.hhL.bce().getId())) {
                ap.setViewTextColor(this.hhI, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hhI, (int) R.color.cp_cont_b);
            }
            ap.setViewTextColor(this.hhJ, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hhK, R.color.cp_cont_d, 1);
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
            this.hhL = bVar;
            String str = null;
            if (bVar.bce().bdk()) {
                this.hhy.setVisibility(0);
                this.hhH.setVisibility(0);
                if (bVar.bce().beW() != null) {
                    this.hhH.setText(at.stringForVideoTime(bVar.bce().beW().video_duration.intValue() * 1000));
                    str = bVar.bce().beW().thumbnail_url;
                }
            } else {
                this.hhy.setVisibility(8);
                this.hhH.setVisibility(8);
                if (bVar.bce().beN() != null && bVar.bce().beN().size() >= 1) {
                    str = bVar.bce().beN().get(0).origin_pic;
                }
            }
            this.giE.startLoad(str, 10, false);
            this.hhI.setText(bVar.bce().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.QX(bVar.bce().getId())) {
                ap.setViewTextColor(this.hhI, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hhI, (int) R.color.cp_cont_b);
            }
            this.hhB.setData(bVar.bce(), false);
            this.hhK.setText(at.getFormatTimeShort(bVar.bce().ben()));
            if ("news".equals(bVar.bce().bet())) {
                this.hhB.setVisibility(8);
                this.hhJ.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, at.numberUniformFormat(bVar.bce().bew())));
                return;
            }
            this.hhB.setVisibility(0);
            h(bVar.bce());
        }
    }

    private void h(bw bwVar) {
        if (this.hhJ != null && bwVar != null) {
            this.hhJ.setVisibility(0);
            if (!StringUtils.isNull(bwVar.beE().getName_show())) {
                this.hhJ.setText(AF(bwVar.beE().getName_show()));
            }
        }
    }

    protected String AF(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void vt(int i) {
        this.hhB.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbz() != null) {
            cbz().a(getView(), this.hhL);
        }
    }
}
