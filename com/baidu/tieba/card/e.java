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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e extends b<com.baidu.tieba.e.b> {
    private TbImageView hnd;
    private LinearLayout itJ;
    private RelativeLayout itL;
    private ImageView itN;
    private ClickableHeaderImageView itQ;
    private View itU;
    private TextView itW;
    private TextView itX;
    private TextView itY;
    private TextView itZ;
    private com.baidu.tieba.e.b iua;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.itJ = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.itL = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hnd = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.itN = (ImageView) view.findViewById(R.id.img_play);
        this.itW = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.itX = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.itQ = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.itY = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.itZ = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.itU = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hnd.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.itL.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.itL.setLayoutParams(layoutParams);
        this.itQ.setDefaultResource(17170445);
        this.itQ.setDefaultBgResource(R.color.CAM_X0205);
        this.itQ.setIsRound(true);
        this.itQ.setDrawBorder(true);
        this.itQ.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.itQ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void yv(int i) {
        if (this.itU != null) {
            this.itU.setVisibility(i);
        }
    }

    public void F(int i, int i2, int i3, int i4) {
        if (this.itJ != null) {
            this.itJ.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.CAM_X0201);
            ao.setBackgroundResource(this.itU, R.color.CAM_X0204);
            ao.setViewTextColor(this.itW, R.color.CAM_X0101, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TL(this.iua.boO().getId())) {
                ao.setViewTextColor(this.itX, R.color.CAM_X0108);
            } else {
                ao.setViewTextColor(this.itX, R.color.CAM_X0105);
            }
            ao.setViewTextColor(this.itY, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.itZ, R.color.CAM_X0109, 1);
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
        if (bVar != null && bVar.boO() != null) {
            this.iua = bVar;
            String str = null;
            if (bVar.boO().bpV()) {
                this.itN.setVisibility(0);
                this.itW.setVisibility(0);
                if (bVar.boO().brH() != null) {
                    this.itW.setText(at.stringForVideoTime(bVar.boO().brH().video_duration.intValue() * 1000));
                    str = bVar.boO().brH().thumbnail_url;
                }
            } else {
                this.itN.setVisibility(8);
                this.itW.setVisibility(8);
                if (bVar.boO().brz() != null && bVar.boO().brz().size() >= 1) {
                    str = bVar.boO().brz().get(0).origin_pic;
                }
            }
            this.hnd.startLoad(str, 10, false);
            this.itX.setText(bVar.boO().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TL(bVar.boO().getId())) {
                ao.setViewTextColor(this.itX, R.color.CAM_X0108);
            } else {
                ao.setViewTextColor(this.itX, R.color.CAM_X0105);
            }
            this.itQ.setData(bVar.boO(), false);
            this.itZ.setText(at.getFormatTimeShort(bVar.boO().bqZ()));
            if ("news".equals(bVar.boO().brf())) {
                this.itQ.setVisibility(8);
                this.itY.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, at.numberUniformFormat(bVar.boO().bri())));
                return;
            }
            this.itQ.setVisibility(0);
            i(bVar.boO());
        }
    }

    private void i(bz bzVar) {
        if (this.itY != null && bzVar != null) {
            this.itY.setVisibility(0);
            if (!StringUtils.isNull(bzVar.brq().getName_show())) {
                this.itY.setText(CA(bzVar.brq().getName_show()));
            }
        }
    }

    protected String CA(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void yw(int i) {
        this.itQ.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cuC() != null) {
            cuC().a(getView(), this.iua);
        }
    }
}
