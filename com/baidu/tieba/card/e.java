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
/* loaded from: classes9.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private TbImageView frV;
    private LinearLayout gmV;
    private RelativeLayout gmX;
    private ImageView gmZ;
    private ClickableHeaderImageView gnc;
    private View gng;
    private TextView gni;
    private TextView gnj;
    private TextView gnk;
    private TextView gnl;
    private com.baidu.tieba.e.b gnm;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gmV = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gmX = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.frV = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.gmZ = (ImageView) view.findViewById(R.id.img_play);
        this.gni = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.gnj = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.gnc = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gnk = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.gnl = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.gng = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.frV.setDefaultBgResource(R.drawable.icon_morenpic);
        this.frV.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gmX.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.gmX.setLayoutParams(layoutParams);
        this.gnc.setDefaultResource(17170445);
        this.gnc.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gnc.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gnc.setIsRound(true);
        this.gnc.setDrawBorder(true);
        this.gnc.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gnc.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void rH(int i) {
        if (this.gng != null) {
            this.gng.setVisibility(i);
        }
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.gmV != null) {
            this.gmV.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.gng, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gni, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.KY(this.gnm.aIw().getId())) {
                am.setViewTextColor(this.gnj, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gnj, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.gnk, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gnl, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.aIw() != null) {
            this.gnm = bVar;
            String str = null;
            if (bVar.aIw().aJr()) {
                this.gmZ.setVisibility(0);
                this.gni.setVisibility(0);
                if (bVar.aIw().aKV() != null) {
                    this.gni.setText(aq.stringForVideoTime(bVar.aIw().aKV().video_duration.intValue() * 1000));
                    str = bVar.aIw().aKV().thumbnail_url;
                }
            } else {
                this.gmZ.setVisibility(8);
                this.gni.setVisibility(8);
                if (bVar.aIw().aKO() != null && bVar.aIw().aKO().size() >= 1) {
                    str = bVar.aIw().aKO().get(0).origin_pic;
                }
            }
            this.frV.startLoad(str, 10, false);
            this.gnj.setText(bVar.aIw().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.KY(bVar.aIw().getId())) {
                am.setViewTextColor(this.gnj, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gnj, (int) R.color.cp_cont_b);
            }
            this.gnc.setData(bVar.aIw(), false);
            this.gnl.setText(aq.getFormatTimeShort(bVar.aIw().aKn()));
            if ("news".equals(bVar.aIw().aKt())) {
                this.gnc.setVisibility(8);
                this.gnk.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.aIw().aKw())));
                return;
            }
            this.gnc.setVisibility(0);
            h(bVar.aIw());
        }
    }

    private void h(bj bjVar) {
        if (this.gnk != null && bjVar != null) {
            this.gnk.setVisibility(0);
            if (!StringUtils.isNull(bjVar.aKE().getName_show())) {
                this.gnk.setText(vm(bjVar.aKE().getName_show()));
            }
        }
    }

    protected String vm(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void rI(int i) {
        this.gnc.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEy() != null) {
            bEy().a(getView(), this.gnm);
        }
    }
}
