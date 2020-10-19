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
    private ImageView hHH;
    private TbImageView iEn;
    private TextView iEo;
    private TextView iEp;
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
        this.iEn = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.iEn.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.iEn.setDefaultResource(R.drawable.icon_morenpic);
        this.hHH = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.iEo = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.iEp = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.iEo, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.iEp, (int) R.color.cp_cont_a);
        ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.bfG() != null) {
            bw bfG = bVar.bfG();
            this.mTitle.setText(bfG.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Sl(bfG.getId())) {
                ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = at.numberUniformFormat(bfG.bhZ());
            String formatTimeShort = at.getFormatTimeShort(bfG.bhQ());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.iEo.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (bfG.getThreadType() == 40) {
                this.hHH.setVisibility(0);
                if (bfG.biz() != null) {
                    str = bfG.biz().thumbnail_url;
                }
            } else {
                this.hHH.setVisibility(8);
                if (bfG.biq() != null && bfG.biq().size() >= 1) {
                    str = bfG.biq().get(0).getOriginalUrl();
                }
            }
            this.iEn.startLoad(str, 10, false);
            if (!StringUtils.isNull(bfG.bhW())) {
                this.iEp.setText(bfG.bhW());
                this.iEp.setVisibility(0);
                return;
            }
            this.iEp.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public d iEq;

        public a(d dVar) {
            super(dVar.getView());
            this.iEq = dVar;
        }
    }
}
