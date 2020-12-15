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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f extends b<com.baidu.tieba.f.b> {
    private TbImageView hbr;
    private TextView ihB;
    private TextView ihC;
    private TextView ihD;
    private TextView ihE;
    private com.baidu.tieba.f.b ihF;
    private LinearLayout iho;
    private RelativeLayout ihq;
    private ImageView ihs;
    private ClickableHeaderImageView ihv;
    private View ihz;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iho = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.ihq = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hbr = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.ihs = (ImageView) view.findViewById(R.id.img_play);
        this.ihB = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.ihC = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.ihv = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.ihD = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.ihE = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.ihz = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hbr.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hbr.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ihq.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.ihq.setLayoutParams(layoutParams);
        this.ihv.setDefaultResource(17170445);
        this.ihv.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.ihv.setDefaultBgResource(R.color.CAM_X0205);
        this.ihv.setIsRound(true);
        this.ihv.setDrawBorder(true);
        this.ihv.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ihv.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void yh(int i) {
        if (this.ihz != null) {
            this.ihz.setVisibility(i);
        }
    }

    public void E(int i, int i2, int i3, int i4) {
        if (this.iho != null) {
            this.iho.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.ihz, R.color.CAM_X0204);
            ap.setViewTextColor(this.ihB, R.color.CAM_X0101, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ub(this.ihF.bmn().getId())) {
                ap.setViewTextColor(this.ihC, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.ihC, (int) R.color.CAM_X0105);
            }
            ap.setViewTextColor(this.ihD, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ihE, R.color.CAM_X0109, 1);
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
        if (bVar != null && bVar.bmn() != null) {
            this.ihF = bVar;
            String str = null;
            if (bVar.bmn().bnv()) {
                this.ihs.setVisibility(0);
                this.ihB.setVisibility(0);
                if (bVar.bmn().bph() != null) {
                    this.ihB.setText(au.stringForVideoTime(bVar.bmn().bph().video_duration.intValue() * 1000));
                    str = bVar.bmn().bph().thumbnail_url;
                }
            } else {
                this.ihs.setVisibility(8);
                this.ihB.setVisibility(8);
                if (bVar.bmn().boY() != null && bVar.bmn().boY().size() >= 1) {
                    str = bVar.bmn().boY().get(0).origin_pic;
                }
            }
            this.hbr.startLoad(str, 10, false);
            this.ihC.setText(bVar.bmn().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ub(bVar.bmn().getId())) {
                ap.setViewTextColor(this.ihC, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.ihC, (int) R.color.CAM_X0105);
            }
            this.ihv.setData(bVar.bmn(), false);
            this.ihE.setText(au.getFormatTimeShort(bVar.bmn().boy()));
            if ("news".equals(bVar.bmn().boE())) {
                this.ihv.setVisibility(8);
                this.ihD.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, au.numberUniformFormat(bVar.bmn().boH())));
                return;
            }
            this.ihv.setVisibility(0);
            i(bVar.bmn());
        }
    }

    private void i(by byVar) {
        if (this.ihD != null && byVar != null) {
            this.ihD.setVisibility(0);
            if (!StringUtils.isNull(byVar.boP().getName_show())) {
                this.ihD.setText(CC(byVar.boP().getName_show()));
            }
        }
    }

    protected String CC(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void yi(int i) {
        this.ihv.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crJ() != null) {
            crJ().a(getView(), this.ihF);
        }
    }
}
