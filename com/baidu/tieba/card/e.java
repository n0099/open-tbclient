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
    private TbImageView hmY;
    private LinearLayout iuU;
    private RelativeLayout iuW;
    private ImageView iuY;
    private ClickableHeaderImageView ivb;
    private View ivf;
    private TextView ivh;
    private TextView ivi;
    private TextView ivj;
    private TextView ivk;
    private com.baidu.tieba.e.b ivl;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.iuU = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.iuW = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hmY = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.iuY = (ImageView) view.findViewById(R.id.img_play);
        this.ivh = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.ivi = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.ivb = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.ivj = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.ivk = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.ivf = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hmY.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iuW.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.iuW.setLayoutParams(layoutParams);
        this.ivb.setDefaultResource(17170445);
        this.ivb.setDefaultBgResource(R.color.CAM_X0205);
        this.ivb.setIsRound(true);
        this.ivb.setDrawBorder(true);
        this.ivb.setBorderColor(ap.getColor(R.color.common_color_10043));
        this.ivb.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void wY(int i) {
        if (this.ivf != null) {
            this.ivf.setVisibility(i);
        }
    }

    public void F(int i, int i2, int i3, int i4) {
        if (this.iuU != null) {
            this.iuU.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(getView(), R.color.CAM_X0201);
            ap.setBackgroundResource(this.ivf, R.color.CAM_X0204);
            ap.setViewTextColor(this.ivh, R.color.CAM_X0101, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TM(this.ivl.bln().getId())) {
                ap.setViewTextColor(this.ivi, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.ivi, R.color.CAM_X0105);
            }
            ap.setViewTextColor(this.ivj, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ivk, R.color.CAM_X0109, 1);
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
            this.ivl = bVar;
            String str = null;
            if (bVar.bln().bmv()) {
                this.iuY.setVisibility(0);
                this.ivh.setVisibility(0);
                if (bVar.bln().boh() != null) {
                    this.ivh.setText(au.stringForVideoTime(bVar.bln().boh().video_duration.intValue() * 1000));
                    str = bVar.bln().boh().thumbnail_url;
                }
            } else {
                this.iuY.setVisibility(8);
                this.ivh.setVisibility(8);
                if (bVar.bln().bnZ() != null && bVar.bln().bnZ().size() >= 1) {
                    str = bVar.bln().bnZ().get(0).origin_pic;
                }
            }
            this.hmY.startLoad(str, 10, false);
            this.ivi.setText(bVar.bln().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TM(bVar.bln().getId())) {
                ap.setViewTextColor(this.ivi, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.ivi, R.color.CAM_X0105);
            }
            this.ivb.setData(bVar.bln(), false);
            this.ivk.setText(au.getFormatTimeShort(bVar.bln().bnz()));
            if ("news".equals(bVar.bln().bnF())) {
                this.ivb.setVisibility(8);
                this.ivj.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, au.numberUniformFormat(bVar.bln().bnI())));
                return;
            }
            this.ivb.setVisibility(0);
            i(bVar.bln());
        }
    }

    private void i(cb cbVar) {
        if (this.ivj != null && cbVar != null) {
            this.ivj.setVisibility(0);
            if (!StringUtils.isNull(cbVar.bnQ().getName_show())) {
                this.ivj.setText(BF(cbVar.bnQ().getName_show()));
            }
        }
    }

    protected String BF(String str) {
        return au.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void wZ(int i) {
        this.ivb.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csc() != null) {
            csc().a(getView(), this.ivl);
        }
    }
}
