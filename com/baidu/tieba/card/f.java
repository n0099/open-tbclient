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
/* loaded from: classes21.dex */
public class f extends b<com.baidu.tieba.e.b> {
    private TbImageView glP;
    private LinearLayout hoC;
    private RelativeLayout hoE;
    private ImageView hoG;
    private ClickableHeaderImageView hoJ;
    private View hoN;
    private TextView hoP;
    private TextView hoQ;
    private TextView hoR;
    private TextView hoS;
    private com.baidu.tieba.e.b hoT;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hoC = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hoE = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.glP = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.hoG = (ImageView) view.findViewById(R.id.img_play);
        this.hoP = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.hoQ = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.hoJ = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hoR = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.hoS = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.hoN = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.glP.setDefaultBgResource(R.drawable.icon_morenpic);
        this.glP.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hoE.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.hoE.setLayoutParams(layoutParams);
        this.hoJ.setDefaultResource(17170445);
        this.hoJ.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hoJ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hoJ.setIsRound(true);
        this.hoJ.setDrawBorder(true);
        this.hoJ.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hoJ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void vR(int i) {
        if (this.hoN != null) {
            this.hoN.setVisibility(i);
        }
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.hoC != null) {
            this.hoC.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.hoN, R.color.cp_bg_line_c);
            ap.setViewTextColor(this.hoP, R.color.cp_cont_a, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Rx(this.hoT.bcY().getId())) {
                ap.setViewTextColor(this.hoQ, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hoQ, (int) R.color.cp_cont_b);
            }
            ap.setViewTextColor(this.hoR, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hoS, R.color.cp_cont_d, 1);
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
        if (bVar != null && bVar.bcY() != null) {
            this.hoT = bVar;
            String str = null;
            if (bVar.bcY().bee()) {
                this.hoG.setVisibility(0);
                this.hoP.setVisibility(0);
                if (bVar.bcY().bfQ() != null) {
                    this.hoP.setText(at.stringForVideoTime(bVar.bcY().bfQ().video_duration.intValue() * 1000));
                    str = bVar.bcY().bfQ().thumbnail_url;
                }
            } else {
                this.hoG.setVisibility(8);
                this.hoP.setVisibility(8);
                if (bVar.bcY().bfH() != null && bVar.bcY().bfH().size() >= 1) {
                    str = bVar.bcY().bfH().get(0).origin_pic;
                }
            }
            this.glP.startLoad(str, 10, false);
            this.hoQ.setText(bVar.bcY().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Rx(bVar.bcY().getId())) {
                ap.setViewTextColor(this.hoQ, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.hoQ, (int) R.color.cp_cont_b);
            }
            this.hoJ.setData(bVar.bcY(), false);
            this.hoS.setText(at.getFormatTimeShort(bVar.bcY().bfh()));
            if ("news".equals(bVar.bcY().bfn())) {
                this.hoJ.setVisibility(8);
                this.hoR.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, at.numberUniformFormat(bVar.bcY().bfq())));
                return;
            }
            this.hoJ.setVisibility(0);
            i(bVar.bcY());
        }
    }

    private void i(bw bwVar) {
        if (this.hoR != null && bwVar != null) {
            this.hoR.setVisibility(0);
            if (!StringUtils.isNull(bwVar.bfy().getName_show())) {
                this.hoR.setText(Bc(bwVar.bfy().getName_show()));
            }
        }
    }

    protected String Bc(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void vS(int i) {
        this.hoJ.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ceP() != null) {
            ceP().a(getView(), this.hoT);
        }
    }
}
