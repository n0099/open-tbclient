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
    private TbImageView hix;
    private LinearLayout ipc;
    private RelativeLayout ipe;
    private ImageView ipg;
    private ClickableHeaderImageView ipj;
    private View ipn;
    private TextView ipp;
    private TextView ipq;
    private TextView ipr;
    private TextView ips;
    private com.baidu.tieba.e.b ipt;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.ipc = (LinearLayout) view.findViewById(R.id.card_frs_game_thread_layout);
        this.ipe = (RelativeLayout) view.findViewById(R.id.card_frs_game_thread_content);
        this.hix = (TbImageView) view.findViewById(R.id.img_thumbnail);
        this.ipg = (ImageView) view.findViewById(R.id.img_play);
        this.ipp = (TextView) view.findViewById(R.id.card_frs_game_video_time);
        this.ipq = (TextView) view.findViewById(R.id.card_frs_game_video_title);
        this.ipj = (ClickableHeaderImageView) view.findViewById(R.id.card_frs_game_user_icon);
        this.ipr = (TextView) view.findViewById(R.id.card_frs_game_read_time_or_name);
        this.ips = (TextView) view.findViewById(R.id.card_frs_game_publish_time);
        this.ipn = view.findViewById(R.id.card_frs_game_bottom_divider);
        this.hix.setDefaultBgResource(R.drawable.icon_morenpic);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds326);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ipe.getLayoutParams();
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = (dimensionPixelSize * 9) / 16;
        this.ipe.setLayoutParams(layoutParams);
        this.ipj.setDefaultResource(17170445);
        this.ipj.setDefaultBgResource(R.color.CAM_X0205);
        this.ipj.setIsRound(true);
        this.ipj.setDrawBorder(true);
        this.ipj.setBorderColor(ao.getColor(R.color.common_color_10043));
        this.ipj.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        getView().setOnClickListener(this);
    }

    public void wO(int i) {
        if (this.ipn != null) {
            this.ipn.setVisibility(i);
        }
    }

    public void F(int i, int i2, int i3, int i4) {
        if (this.ipc != null) {
            this.ipc.setPadding(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(getView(), R.color.CAM_X0201);
            ao.setBackgroundResource(this.ipn, R.color.CAM_X0204);
            ao.setViewTextColor(this.ipp, R.color.CAM_X0101, 1);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SC(this.ipt.bkV().getId())) {
                ao.setViewTextColor(this.ipq, R.color.CAM_X0108);
            } else {
                ao.setViewTextColor(this.ipq, R.color.CAM_X0105);
            }
            ao.setViewTextColor(this.ipr, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.ips, R.color.CAM_X0109, 1);
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
        if (bVar != null && bVar.bkV() != null) {
            this.ipt = bVar;
            String str = null;
            if (bVar.bkV().bmc()) {
                this.ipg.setVisibility(0);
                this.ipp.setVisibility(0);
                if (bVar.bkV().bnO() != null) {
                    this.ipp.setText(at.stringForVideoTime(bVar.bkV().bnO().video_duration.intValue() * 1000));
                    str = bVar.bkV().bnO().thumbnail_url;
                }
            } else {
                this.ipg.setVisibility(8);
                this.ipp.setVisibility(8);
                if (bVar.bkV().bnG() != null && bVar.bkV().bnG().size() >= 1) {
                    str = bVar.bkV().bnG().get(0).origin_pic;
                }
            }
            this.hix.startLoad(str, 10, false);
            this.ipq.setText(bVar.bkV().getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SC(bVar.bkV().getId())) {
                ao.setViewTextColor(this.ipq, R.color.CAM_X0108);
            } else {
                ao.setViewTextColor(this.ipq, R.color.CAM_X0105);
            }
            this.ipj.setData(bVar.bkV(), false);
            this.ips.setText(at.getFormatTimeShort(bVar.bkV().bng()));
            if ("news".equals(bVar.bkV().bnm())) {
                this.ipj.setVisibility(8);
                this.ipr.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.person_view_num, at.numberUniformFormat(bVar.bkV().bnp())));
                return;
            }
            this.ipj.setVisibility(0);
            i(bVar.bkV());
        }
    }

    private void i(bz bzVar) {
        if (this.ipr != null && bzVar != null) {
            this.ipr.setVisibility(0);
            if (!StringUtils.isNull(bzVar.bnx().getName_show())) {
                this.ipr.setText(Bo(bzVar.bnx().getName_show()));
            }
        }
    }

    protected String Bo(String str) {
        return at.cutChineseAndEnglishWithSuffix(str, 14, StringHelper.STRING_MORE);
    }

    public void wP(int i) {
        this.ipj.setVisibility(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cqL() != null) {
            cqL().a(getView(), this.ipt);
        }
    }
}
