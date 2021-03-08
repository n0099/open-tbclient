package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsGameStrategyItemView extends com.baidu.tieba.card.b<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView iAV;
    private TbImageView jAp;
    private TextView jAq;
    private TextView jAr;
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
        this.jAp = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.jAp.setDefaultResource(R.drawable.icon_morenpic);
        this.iAV = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.jAq = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.jAr = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.jAq, R.color.CAM_X0109);
        ap.setViewTextColor(this.jAr, R.color.CAM_X0101);
        ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.blp() != null) {
            cb blp = bVar.blp();
            this.mTitle.setText(blp.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TT(blp.getId())) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            }
            String numberUniformFormat = au.numberUniformFormat(blp.bnK());
            String formatTimeShort = au.getFormatTimeShort(blp.bnB());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.jAq.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (blp.getThreadType() == 40) {
                this.iAV.setVisibility(0);
                if (blp.boj() != null) {
                    str = blp.boj().thumbnail_url;
                }
            } else {
                this.iAV.setVisibility(8);
                if (blp.bob() != null && blp.bob().size() >= 1) {
                    str = blp.bob().get(0).getOriginalUrl();
                }
            }
            this.jAp.startLoad(str, 10, false);
            if (!StringUtils.isNull(blp.bnH())) {
                this.jAr.setText(blp.bnH());
                this.jAr.setVisibility(0);
                return;
            }
            this.jAr.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes2.dex */
    public static class FrsGameStrategyItemViewHolder extends TypeAdapter.ViewHolder {
        public FrsGameStrategyItemView jAs;

        public FrsGameStrategyItemViewHolder(FrsGameStrategyItemView frsGameStrategyItemView) {
            super(frsGameStrategyItemView.getView());
            this.jAs = frsGameStrategyItemView;
        }
    }
}
