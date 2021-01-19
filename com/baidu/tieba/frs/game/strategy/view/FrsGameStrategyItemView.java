package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsGameStrategyItemView extends com.baidu.tieba.card.b<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView ito;
    private TbImageView jsM;
    private TextView jsN;
    private TextView jsO;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public FrsGameStrategyItemView(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        initView();
    }

    private void initView() {
        this.jsM = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.jsM.setDefaultResource(R.drawable.icon_morenpic);
        this.ito = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.jsN = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.jsO = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ao.setViewTextColor(this.jsN, R.color.CAM_X0109);
        ao.setViewTextColor(this.jsO, R.color.CAM_X0101);
        ao.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.bkV() != null) {
            bz bkV = bVar.bkV();
            this.mTitle.setText(bkV.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SD(bkV.getId())) {
                ao.setViewTextColor(this.mTitle, R.color.CAM_X0108);
            } else {
                ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            }
            String numberUniformFormat = at.numberUniformFormat(bkV.bnp());
            String formatTimeShort = at.getFormatTimeShort(bkV.bng());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.jsN.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (bkV.getThreadType() == 40) {
                this.ito.setVisibility(0);
                if (bkV.bnO() != null) {
                    str = bkV.bnO().thumbnail_url;
                }
            } else {
                this.ito.setVisibility(8);
                if (bkV.bnG() != null && bkV.bnG().size() >= 1) {
                    str = bkV.bnG().get(0).getOriginalUrl();
                }
            }
            this.jsM.startLoad(str, 10, false);
            if (!StringUtils.isNull(bkV.bnm())) {
                this.jsO.setText(bkV.bnm());
                this.jsO.setVisibility(0);
                return;
            }
            this.jsO.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes2.dex */
    public static class FrsGameStrategyItemViewHolder extends TypeAdapter.ViewHolder {
        public FrsGameStrategyItemView jsP;

        public FrsGameStrategyItemViewHolder(FrsGameStrategyItemView frsGameStrategyItemView) {
            super(frsGameStrategyItemView.getView());
            this.jsP = frsGameStrategyItemView;
        }
    }
}
