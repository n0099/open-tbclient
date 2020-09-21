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
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView hsN;
    private TbImageView ipu;
    private TextView ipv;
    private TextView ipw;
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
        this.ipu = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.ipu.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.ipu.setDefaultResource(R.drawable.icon_morenpic);
        this.hsN = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.ipv = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.ipw = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.ipv, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.ipw, (int) R.color.cp_cont_a);
        ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.bcY() != null) {
            bw bcY = bVar.bcY();
            this.mTitle.setText(bcY.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Rx(bcY.getId())) {
                ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = at.numberUniformFormat(bcY.bfq());
            String formatTimeShort = at.getFormatTimeShort(bcY.bfh());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.ipv.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (bcY.getThreadType() == 40) {
                this.hsN.setVisibility(0);
                if (bcY.bfQ() != null) {
                    str = bcY.bfQ().thumbnail_url;
                }
            } else {
                this.hsN.setVisibility(8);
                if (bcY.bfH() != null && bcY.bfH().size() >= 1) {
                    str = bcY.bfH().get(0).getOriginalUrl();
                }
            }
            this.ipu.startLoad(str, 10, false);
            if (!StringUtils.isNull(bcY.bfn())) {
                this.ipw.setText(bcY.bfn());
                this.ipw.setVisibility(0);
                return;
            }
            this.ipw.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes21.dex */
    public static class a extends af.a {
        public d ipx;

        public a(d dVar) {
            super(dVar.getView());
            this.ipx = dVar;
        }
    }
}
