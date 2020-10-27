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
    private TbImageView gLW;
    private LinearLayout hPS;
    private RelativeLayout hPU;
    private ImageView hPW;
    private ClickableHeaderImageView hPZ;
    private View hQd;
    private TextView hQf;
    private TextView hQg;
    private TextView hQh;
    private TextView hQi;
    private com.baidu.tieba.e.b hQj;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hPS = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hPU = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.gLW = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.hPW = (ImageView) view.findViewById(R.id.img_play);
        this.hQf = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.hQg = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.hPZ = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hQh = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.hQi = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.hQd = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.gLW.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gLW.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hPU.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.hPU.setLayoutParams(layoutParams);
        this.hPZ.setDefaultResource(17170445);
        this.hPZ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hPZ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hPZ.setIsRound(true);
        this.hPZ.setDrawBorder(true);
        this.hPZ.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hPZ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void wQ(int i) {
        if (this.hQd != null) {
            this.hQd.setVisibility(i);
        }
    }

    public void z(int i, int i2, int i3, int i4) {
        if (this.hPS != null) {
            this.hPS.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hQd, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hQf, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SK(this.hQj.bhz().getId())) {
                ap.setViewTextColor(this.hQg, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hQg, (int) R.color.cp_cont_b);
            }
            ap.setViewTextColor(this.hQh, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hQi, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.bhz() != null) {
            this.hQj = bVar;
            String str = null;
            if (bVar.bhz().biG()) {
                this.hPW.setVisibility(0);
                this.hQf.setVisibility(0);
                if (bVar.bhz().bks() != null) {
                    this.hQf.setText(at.stringForVideoTime(bVar.bhz().bks().video_duration.intValue() * 1000));
                    str = bVar.bhz().bks().thumbnail_url;
                }
            } else {
                this.hPW.setVisibility(8);
                this.hQf.setVisibility(8);
                if (bVar.bhz().bkj() != null && bVar.bhz().bkj().size() >= 1) {
                    str = bVar.bhz().bkj().get(0).origin_pic;
                }
            }
            this.gLW.startLoad(str, 10, false);
            this.hQg.setText(bVar.bhz().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SK(bVar.bhz().getId())) {
                ap.setViewTextColor(this.hQg, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hQg, (int) R.color.cp_cont_b);
            }
            this.hPZ.setData(bVar.bhz(), false);
            this.hQi.setText(at.getFormatTimeShort(bVar.bhz().bjJ()));
            if ("news".equals(bVar.bhz().bjP())) {
                this.hPZ.setVisibility(8);
                this.hQh.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, at.numberUniformFormat(bVar.bhz().bjS())));
                return;
            }
            this.hPZ.setVisibility(0);
            i(bVar.bhz());
        }
    }

    private void i(bw bwVar) {
        if (this.hQh != null && bwVar != null) {
            this.hQh.setVisibility(0);
            if (!StringUtils.isNull(bwVar.bka().getName_show())) {
                this.hQh.setText(Ch(bwVar.bka().getName_show()));
            }
        }
    }

    protected String Ch(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void wR(int i) {
        this.hPZ.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cls() != null) {
            cls().a(getView(), this.hQj);
        }
    }
}
