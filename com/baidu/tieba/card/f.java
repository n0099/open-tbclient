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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class f extends b<com.baidu.tieba.f.b> {
    private TbImageView gSc;
    private View hWA;
    private TextView hWC;
    private TextView hWD;
    private TextView hWE;
    private TextView hWF;
    private com.baidu.tieba.f.b hWG;
    private LinearLayout hWp;
    private RelativeLayout hWr;
    private ImageView hWt;
    private ClickableHeaderImageView hWw;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.hWp = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.hWr = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.gSc = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.hWt = (ImageView) view.findViewById(R.id.img_play);
        this.hWC = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.hWD = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.hWw = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.hWE = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.hWF = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.hWA = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.gSc.setDefaultBgResource(R.drawable.icon_morenpic);
        this.gSc.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hWr.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.hWr.setLayoutParams(layoutParams);
        this.hWw.setDefaultResource(17170445);
        this.hWw.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.hWw.setDefaultBgResource(R.color.CAM_X0205);
        this.hWw.setIsRound(true);
        this.hWw.setDrawBorder(true);
        this.hWw.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.hWw.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void xB(int i) {
        if (this.hWA != null) {
            this.hWA.setVisibility(i);
        }
    }

    public void A(int i, int i2, int i3, int i4) {
        if (this.hWp != null) {
            this.hWp.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.hWA, R.color.CAM_X0204);
            ap.setViewTextColor(this.hWC, R.color.CAM_X0101, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SM(this.hWG.bjd().getId())) {
                ap.setViewTextColor(this.hWD, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.hWD, (int) R.color.CAM_X0105);
            }
            ap.setViewTextColor(this.hWE, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.hWF, R.color.CAM_X0109, 1);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_frs_game_common_small_view_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.f.b bVar) {
        if (bVar != null && bVar.bjd() != null) {
            this.hWG = bVar;
            String str = null;
            if (bVar.bjd().bki()) {
                this.hWt.setVisibility(0);
                this.hWC.setVisibility(0);
                if (bVar.bjd().blU() != null) {
                    this.hWC.setText(au.stringForVideoTime(bVar.bjd().blU().video_duration.intValue() * 1000));
                    str = bVar.bjd().blU().thumbnail_url;
                }
            } else {
                this.hWt.setVisibility(8);
                this.hWC.setVisibility(8);
                if (bVar.bjd().blL() != null && bVar.bjd().blL().size() >= 1) {
                    str = bVar.bjd().blL().get(0).origin_pic;
                }
            }
            this.gSc.startLoad(str, 10, false);
            this.hWD.setText(bVar.bjd().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SM(bVar.bjd().getId())) {
                ap.setViewTextColor(this.hWD, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.hWD, (int) R.color.CAM_X0105);
            }
            this.hWw.setData(bVar.bjd(), false);
            this.hWF.setText(au.getFormatTimeShort(bVar.bjd().bll()));
            if ("news".equals(bVar.bjd().blr())) {
                this.hWw.setVisibility(8);
                this.hWE.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, au.numberUniformFormat(bVar.bjd().blu())));
                return;
            }
            this.hWw.setVisibility(0);
            i(bVar.bjd());
        }
    }

    private void i(bx bxVar) {
        if (this.hWE != null && bxVar != null) {
            this.hWE.setVisibility(0);
            if (!StringUtils.isNull(bxVar.blC().getName_show())) {
                this.hWE.setText(BU(bxVar.blC().getName_show()));
            }
        }
    }

    protected String BU(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void xC(int i) {
        this.hWw.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnv() != null) {
            cnv().a(getView(), this.hWG);
        }
    }
}
