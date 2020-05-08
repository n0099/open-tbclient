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
    private TbImageView fsa;
    private LinearLayout gnb;
    private RelativeLayout gnd;
    private ImageView gnf;
    private ClickableHeaderImageView gni;
    private View gnm;
    private TextView gno;
    private TextView gnp;
    private TextView gnq;
    private TextView gnr;
    private com.baidu.tieba.e.b gns;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.gnb = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.gnd = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.fsa = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.gnf = (ImageView) view.findViewById(R.id.img_play);
        this.gno = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.gnp = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.gni = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.gnq = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.gnr = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.gnm = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.fsa.setDefaultBgResource(R.drawable.icon_morenpic);
        this.fsa.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gnd.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.gnd.setLayoutParams(layoutParams);
        this.gni.setDefaultResource(17170445);
        this.gni.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.gni.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gni.setIsRound(true);
        this.gni.setDrawBorder(true);
        this.gni.setBorderColor(am.getColor(R.color.common_color_10043));
        this.gni.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void rH(int i) {
        if (this.gnm != null) {
            this.gnm.setVisibility(i);
        }
    }

    public void w(int i, int i2, int i3, int i4) {
        if (this.gnb != null) {
            this.gnb.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.gnm, R.color.cp_bg_line_c);
            am.setViewTextColor(this.gno, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Lb(this.gns.aIu().getId())) {
                am.setViewTextColor(this.gnp, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gnp, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.gnq, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gnr, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.aIu() != null) {
            this.gns = bVar;
            String str = null;
            if (bVar.aIu().aJp()) {
                this.gnf.setVisibility(0);
                this.gno.setVisibility(0);
                if (bVar.aIu().aKT() != null) {
                    this.gno.setText(aq.stringForVideoTime(bVar.aIu().aKT().video_duration.intValue() * 1000));
                    str = bVar.aIu().aKT().thumbnail_url;
                }
            } else {
                this.gnf.setVisibility(8);
                this.gno.setVisibility(8);
                if (bVar.aIu().aKM() != null && bVar.aIu().aKM().size() >= 1) {
                    str = bVar.aIu().aKM().get(0).origin_pic;
                }
            }
            this.fsa.startLoad(str, 10, false);
            this.gnp.setText(bVar.aIu().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Lb(bVar.aIu().getId())) {
                am.setViewTextColor(this.gnp, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.gnp, (int) R.color.cp_cont_b);
            }
            this.gni.setData(bVar.aIu(), false);
            this.gnr.setText(aq.getFormatTimeShort(bVar.aIu().aKl()));
            if ("news".equals(bVar.aIu().aKr())) {
                this.gni.setVisibility(8);
                this.gnq.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.aIu().aKu())));
                return;
            }
            this.gni.setVisibility(0);
            h(bVar.aIu());
        }
    }

    private void h(bj bjVar) {
        if (this.gnq != null && bjVar != null) {
            this.gnq.setVisibility(0);
            if (!StringUtils.isNull(bjVar.aKC().getName_show())) {
                this.gnq.setText(vp(bjVar.aKC().getName_show()));
            }
        }
    }

    protected String vp(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void rI(int i) {
        this.gni.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEw() != null) {
            bEw().a(getView(), this.gns);
        }
    }
}
