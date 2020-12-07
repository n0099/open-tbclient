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
    private TbImageView hbp;
    private TextView ihA;
    private TextView ihB;
    private TextView ihC;
    private com.baidu.tieba.f.b ihD;
    private LinearLayout ihm;
    private RelativeLayout iho;
    private ImageView ihq;
    private ClickableHeaderImageView iht;
    private View ihx;
    private TextView ihz;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ihm = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.iho = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hbp = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.ihq = (ImageView) view.findViewById(R.id.img_play);
        this.ihz = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.ihA = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.iht = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.ihB = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.ihC = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.ihx = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hbp.setDefaultBgResource(R.drawable.icon_morenpic);
        this.hbp.setDefaultErrorResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iho.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.iho.setLayoutParams(layoutParams);
        this.iht.setDefaultResource(17170445);
        this.iht.setDefaultErrorResource(R.drawable.icon_default_avatar100);
        this.iht.setDefaultBgResource(R.color.CAM_X0205);
        this.iht.setIsRound(true);
        this.iht.setDrawBorder(true);
        this.iht.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iht.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void yh(int i) {
        if (this.ihx != null) {
            this.ihx.setVisibility(i);
        }
    }

    public void E(int i, int i2, int i3, int i4) {
        if (this.ihm != null) {
            this.ihm.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.ihx, R.color.CAM_X0204);
            ap.setViewTextColor(this.ihz, R.color.CAM_X0101, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ub(this.ihD.bmn().getId())) {
                ap.setViewTextColor(this.ihA, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.ihA, (int) R.color.CAM_X0105);
            }
            ap.setViewTextColor(this.ihB, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ihC, R.color.CAM_X0109, 1);
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
            this.ihD = bVar;
            String str = null;
            if (bVar.bmn().bnv()) {
                this.ihq.setVisibility(0);
                this.ihz.setVisibility(0);
                if (bVar.bmn().bph() != null) {
                    this.ihz.setText(au.stringForVideoTime(bVar.bmn().bph().video_duration.intValue() * 1000));
                    str = bVar.bmn().bph().thumbnail_url;
                }
            } else {
                this.ihq.setVisibility(8);
                this.ihz.setVisibility(8);
                if (bVar.bmn().boY() != null && bVar.bmn().boY().size() >= 1) {
                    str = bVar.bmn().boY().get(0).origin_pic;
                }
            }
            this.hbp.startLoad(str, 10, false);
            this.ihA.setText(bVar.bmn().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ub(bVar.bmn().getId())) {
                ap.setViewTextColor(this.ihA, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.ihA, (int) R.color.CAM_X0105);
            }
            this.iht.setData(bVar.bmn(), false);
            this.ihC.setText(au.getFormatTimeShort(bVar.bmn().boy()));
            if ("news".equals(bVar.bmn().boE())) {
                this.iht.setVisibility(8);
                this.ihB.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, au.numberUniformFormat(bVar.bmn().boH())));
                return;
            }
            this.iht.setVisibility(0);
            i(bVar.bmn());
        }
    }

    private void i(by byVar) {
        if (this.ihB != null && byVar != null) {
            this.ihB.setVisibility(0);
            if (!StringUtils.isNull(byVar.boP().getName_show())) {
                this.ihB.setText(CC(byVar.boP().getName_show()));
            }
        }
    }

    protected String CC(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void yi(int i) {
        this.iht.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crI() != null) {
            crI().a(getView(), this.ihD);
        }
    }
}
