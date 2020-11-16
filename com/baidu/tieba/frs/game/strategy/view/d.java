package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.frs.game.strategy.data.b> {
    private TbImageView iXs;
    private TextView iXt;
    private TextView iXu;
    private ImageView iaC;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        initView();
    }

    private void initView() {
        this.iXs = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.iXs.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.iXs.setDefaultResource(R.drawable.icon_morenpic);
        this.iaC = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.iXt = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.iXu = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.iXt, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.iXu, (int) R.color.CAM_X0101);
        ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.bjd() != null) {
            bx bjd = bVar.bjd();
            this.mTitle.setText(bjd.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SM(bjd.getId())) {
                ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
            }
            String numberUniformFormat = au.numberUniformFormat(bjd.blu());
            String formatTimeShort = au.getFormatTimeShort(bjd.bll());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.iXt.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (bjd.getThreadType() == 40) {
                this.iaC.setVisibility(0);
                if (bjd.blU() != null) {
                    str = bjd.blU().thumbnail_url;
                }
            } else {
                this.iaC.setVisibility(8);
                if (bjd.blL() != null && bjd.blL().size() >= 1) {
                    str = bjd.blL().get(0).getOriginalUrl();
                }
            }
            this.iXs.startLoad(str, 10, false);
            if (!StringUtils.isNull(bjd.blr())) {
                this.iXu.setText(bjd.blr());
                this.iXu.setVisibility(0);
                return;
            }
            this.iXu.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        public d iXv;

        public a(d dVar) {
            super(dVar.getView());
            this.iXv = dVar;
        }
    }
}
