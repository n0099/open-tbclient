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
    private TbImageView hoI;
    private LinearLayout iwD;
    private RelativeLayout iwF;
    private ImageView iwH;
    private ClickableHeaderImageView iwK;
    private View iwO;
    private TextView iwQ;
    private TextView iwR;
    private TextView iwS;
    private TextView iwT;
    private com.baidu.tieba.e.b iwU;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iwD = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.iwF = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hoI = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.iwH = (ImageView) view.findViewById(R.id.img_play);
        this.iwQ = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.iwR = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.iwK = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.iwS = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.iwT = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.iwO = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hoI.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iwF.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.iwF.setLayoutParams(layoutParams);
        this.iwK.setDefaultResource(17170445);
        this.iwK.setDefaultBgResource(R.color.CAM_X0205);
        this.iwK.setIsRound(true);
        this.iwK.setDrawBorder(true);
        this.iwK.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.iwK.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void wZ(int i) {
        if (this.iwO != null) {
            this.iwO.setVisibility(i);
        }
    }

    public void F(int i, int i2, int i3, int i4) {
        if (this.iwD != null) {
            this.iwD.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.iwO, R.color.CAM_X0204);
            ap.setViewTextColor(this.iwQ, R.color.CAM_X0101, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TT(this.iwU.blp().getId())) {
                ap.setViewTextColor(this.iwR, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.iwR, R.color.CAM_X0105);
            }
            ap.setViewTextColor(this.iwS, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.iwT, R.color.CAM_X0109, 1);
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
        if (bVar != null && bVar.blp() != null) {
            this.iwU = bVar;
            String str = null;
            if (bVar.blp().bmx()) {
                this.iwH.setVisibility(0);
                this.iwQ.setVisibility(0);
                if (bVar.blp().boj() != null) {
                    this.iwQ.setText(au.stringForVideoTime(bVar.blp().boj().video_duration.intValue() * 1000));
                    str = bVar.blp().boj().thumbnail_url;
                }
            } else {
                this.iwH.setVisibility(8);
                this.iwQ.setVisibility(8);
                if (bVar.blp().bob() != null && bVar.blp().bob().size() >= 1) {
                    str = bVar.blp().bob().get(0).origin_pic;
                }
            }
            this.hoI.startLoad(str, 10, false);
            this.iwR.setText(bVar.blp().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TT(bVar.blp().getId())) {
                ap.setViewTextColor(this.iwR, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.iwR, R.color.CAM_X0105);
            }
            this.iwK.setData(bVar.blp(), false);
            this.iwT.setText(au.getFormatTimeShort(bVar.blp().bnB()));
            if ("news".equals(bVar.blp().bnH())) {
                this.iwK.setVisibility(8);
                this.iwS.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, au.numberUniformFormat(bVar.blp().bnK())));
                return;
            }
            this.iwK.setVisibility(0);
            i(bVar.blp());
        }
    }

    private void i(cb cbVar) {
        if (this.iwS != null && cbVar != null) {
            this.iwS.setVisibility(0);
            if (!StringUtils.isNull(cbVar.bnS().getName_show())) {
                this.iwS.setText(BM(cbVar.bnS().getName_show()));
            }
        }
    }

    protected String BM(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void xa(int i) {
        this.iwK.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csi() != null) {
            csi().a(getView(), this.iwU);
        }
    }
}
