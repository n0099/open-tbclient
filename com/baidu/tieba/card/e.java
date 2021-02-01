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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e extends b<com.baidu.tieba.e.b> {
    private TbImageView hmK;
    private LinearLayout iuG;
    private RelativeLayout iuI;
    private ImageView iuK;
    private ClickableHeaderImageView iuN;
    private View iuR;
    private TextView iuT;
    private TextView iuU;
    private TextView iuV;
    private TextView iuW;
    private com.baidu.tieba.e.b iuX;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iuG = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.iuI = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hmK = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.iuK = (ImageView) view.findViewById(R.id.img_play);
        this.iuT = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.iuU = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.iuN = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.iuV = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.iuW = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.iuR = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hmK.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iuI.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.iuI.setLayoutParams(layoutParams);
        this.iuN.setDefaultResource(17170445);
        this.iuN.setDefaultBgResource(R.color.CAM_X0205);
        this.iuN.setIsRound(true);
        this.iuN.setDrawBorder(true);
        this.iuN.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iuN.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void wY(int i) {
        if (this.iuR != null) {
            this.iuR.setVisibility(i);
        }
    }

    public void F(int i, int i2, int i3, int i4) {
        if (this.iuG != null) {
            this.iuG.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.iuR, R.color.CAM_X0204);
            ap.setViewTextColor(this.iuT, R.color.CAM_X0101, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TA(this.iuX.bln().getId())) {
                ap.setViewTextColor(this.iuU, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.iuU, R.color.CAM_X0105);
            }
            ap.setViewTextColor(this.iuV, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.iuW, R.color.CAM_X0109, 1);
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
        if (bVar != null && bVar.bln() != null) {
            this.iuX = bVar;
            String str = null;
            if (bVar.bln().bmv()) {
                this.iuK.setVisibility(0);
                this.iuT.setVisibility(0);
                if (bVar.bln().boh() != null) {
                    this.iuT.setText(au.stringForVideoTime(bVar.bln().boh().video_duration.intValue() * 1000));
                    str = bVar.bln().boh().thumbnail_url;
                }
            } else {
                this.iuK.setVisibility(8);
                this.iuT.setVisibility(8);
                if (bVar.bln().bnZ() != null && bVar.bln().bnZ().size() >= 1) {
                    str = bVar.bln().bnZ().get(0).origin_pic;
                }
            }
            this.hmK.startLoad(str, 10, false);
            this.iuU.setText(bVar.bln().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TA(bVar.bln().getId())) {
                ap.setViewTextColor(this.iuU, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.iuU, R.color.CAM_X0105);
            }
            this.iuN.setData(bVar.bln(), false);
            this.iuW.setText(au.getFormatTimeShort(bVar.bln().bnz()));
            if ("news".equals(bVar.bln().bnF())) {
                this.iuN.setVisibility(8);
                this.iuV.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, au.numberUniformFormat(bVar.bln().bnI())));
                return;
            }
            this.iuN.setVisibility(0);
            i(bVar.bln());
        }
    }

    private void i(cb cbVar) {
        if (this.iuV != null && cbVar != null) {
            this.iuV.setVisibility(0);
            if (!StringUtils.isNull(cbVar.bnQ().getName_show())) {
                this.iuV.setText(BF(cbVar.bnQ().getName_show()));
            }
        }
    }

    protected String BF(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void wZ(int i) {
        this.iuN.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crV() != null) {
            crV().a(getView(), this.iuX);
        }
    }
}
