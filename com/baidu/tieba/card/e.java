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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends a<com.baidu.tieba.e.b> {
    private TbImageView dSX;
    private LinearLayout eKE;
    private RelativeLayout eKG;
    private ImageView eKI;
    private ClickableHeaderImageView eKL;
    private View eKP;
    private TextView eKR;
    private TextView eKS;
    private TextView eKT;
    private TextView eKU;
    private com.baidu.tieba.e.b eKV;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.eKE = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.eKG = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.dSX = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.eKI = (ImageView) view.findViewById(R.id.img_play);
        this.eKR = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.eKS = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.eKL = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.eKT = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.eKU = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.eKP = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.dSX.setDefaultBgResource(R.drawable.icon_morenpic);
        this.dSX.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eKG.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.eKG.setLayoutParams(layoutParams);
        this.eKL.setDefaultResource(17170445);
        this.eKL.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.eKL.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eKL.setIsRound(true);
        this.eKL.setDrawBorder(true);
        this.eKL.setBorderColor(am.getColor(R.color.common_color_10043));
        this.eKL.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void oJ(int i) {
        if (this.eKP != null) {
            this.eKP.setVisibility(i);
        }
    }

    public void s(int i, int i2, int i3, int i4) {
        if (this.eKE != null) {
            this.eKE.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            am.setBackgroundResource(this.eKP, R.color.cp_bg_line_c);
            am.setViewTextColor(this.eKR, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(this.eKV.agI().getId())) {
                am.setViewTextColor(this.eKS, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.eKS, (int) R.color.cp_cont_b);
            }
            am.setViewTextColor(this.eKT, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.eKU, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.agI() != null) {
            this.eKV = bVar;
            String str = null;
            if (bVar.agI().ajA()) {
                this.eKI.setVisibility(0);
                this.eKR.setVisibility(0);
                if (bVar.agI().aiX() != null) {
                    this.eKR.setText(aq.stringForVideoTime(bVar.agI().aiX().video_duration.intValue() * 1000));
                    str = bVar.agI().aiX().thumbnail_url;
                }
            } else {
                this.eKI.setVisibility(8);
                this.eKR.setVisibility(8);
                if (bVar.agI().aiQ() != null && bVar.agI().aiQ().size() >= 1) {
                    str = bVar.agI().aiQ().get(0).origin_pic;
                }
            }
            this.dSX.startLoad(str, 10, false);
            this.eKS.setText(bVar.agI().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(bVar.agI().getId())) {
                am.setViewTextColor(this.eKS, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.eKS, (int) R.color.cp_cont_b);
            }
            this.eKL.setData(bVar.agI(), false);
            this.eKU.setText(aq.getFormatTimeShort(bVar.agI().aiq()));
            if ("news".equals(bVar.agI().aiv())) {
                this.eKL.setVisibility(8);
                this.eKT.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, aq.numberUniformFormat(bVar.agI().aiy())));
                return;
            }
            this.eKL.setVisibility(0);
            g(bVar.agI());
        }
    }

    private void g(bh bhVar) {
        if (this.eKT != null && bhVar != null) {
            this.eKT.setVisibility(0);
            if (!StringUtils.isNull(bhVar.aiG().getName_show())) {
                this.eKT.setText(oA(bhVar.aiG().getName_show()));
            }
        }
    }

    protected String oA(String str) {
        return aq.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void oK(int i) {
        this.eKL.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZX() != null) {
            aZX().a(getView(), this.eKV);
        }
    }
}
