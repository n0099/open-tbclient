package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.frs.game.strategy.data.b> {
    private TbImageView iWG;
    private TextView iWH;
    private TextView iWI;
    private ImageView iab;
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
        this.iWG = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.iWG.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.iWG.setDefaultResource(R.drawable.icon_morenpic);
        this.iab = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.iWH = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.iWI = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.iWH, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.iWI, (int) R.color.cp_cont_a);
        ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.bjZ() != null) {
            bw bjZ = bVar.bjZ();
            this.mTitle.setText(bjZ.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Tb(bjZ.getId())) {
                ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = at.numberUniformFormat(bjZ.bms());
            String formatTimeShort = at.getFormatTimeShort(bjZ.bmj());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.iWH.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (bjZ.getThreadType() == 40) {
                this.iab.setVisibility(0);
                if (bjZ.bmS() != null) {
                    str = bjZ.bmS().thumbnail_url;
                }
            } else {
                this.iab.setVisibility(8);
                if (bjZ.bmJ() != null && bjZ.bmJ().size() >= 1) {
                    str = bjZ.bmJ().get(0).getOriginalUrl();
                }
            }
            this.iWG.startLoad(str, 10, false);
            if (!StringUtils.isNull(bjZ.bmp())) {
                this.iWI.setText(bjZ.bmp());
                this.iWI.setVisibility(0);
                return;
            }
            this.iWI.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public d iWJ;

        public a(d dVar) {
            super(dVar.getView());
            this.iWJ = dVar;
        }
    }
}
