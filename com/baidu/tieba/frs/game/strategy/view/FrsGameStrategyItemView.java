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
    private ImageView iyY;
    private TbImageView jys;
    private TextView jyt;
    private TextView jyu;
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
        this.jys = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.jys.setDefaultResource(R.drawable.icon_morenpic);
        this.iyY = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.jyt = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.jyu = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
        ap.setViewTextColor(this.jyt, R.color.CAM_X0109);
        ap.setViewTextColor(this.jyu, R.color.CAM_X0101);
        ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.bln() != null) {
            cb bln = bVar.bln();
            this.mTitle.setText(bln.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.TA(bln.getId())) {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            }
            String numberUniformFormat = au.numberUniformFormat(bln.bnI());
            String formatTimeShort = au.getFormatTimeShort(bln.bnz());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.jyt.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (bln.getThreadType() == 40) {
                this.iyY.setVisibility(0);
                if (bln.boh() != null) {
                    str = bln.boh().thumbnail_url;
                }
            } else {
                this.iyY.setVisibility(8);
                if (bln.bnZ() != null && bln.bnZ().size() >= 1) {
                    str = bln.bnZ().get(0).getOriginalUrl();
                }
            }
            this.jys.startLoad(str, 10, false);
            if (!StringUtils.isNull(bln.bnF())) {
                this.jyu.setText(bln.bnF());
                this.jyu.setVisibility(0);
                return;
            }
            this.jyu.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes2.dex */
    public static class FrsGameStrategyItemViewHolder extends TypeAdapter.ViewHolder {
        public FrsGameStrategyItemView jyv;

        public FrsGameStrategyItemViewHolder(FrsGameStrategyItemView frsGameStrategyItemView) {
            super(frsGameStrategyItemView.getView());
            this.jyv = frsGameStrategyItemView;
        }
    }
}
