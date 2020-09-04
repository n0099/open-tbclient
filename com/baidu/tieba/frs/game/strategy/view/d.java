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
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView hlK;
    private TbImageView iis;
    private TextView iit;
    private TextView iiu;
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
        this.iis = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.iis.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.iis.setDefaultResource(R.drawable.icon_morenpic);
        this.hlK = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.iit = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.iiu = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.iit, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.iiu, (int) R.color.cp_cont_a);
        ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.bce() != null) {
            bw bce = bVar.bce();
            this.mTitle.setText(bce.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.QX(bce.getId())) {
                ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = at.numberUniformFormat(bce.bew());
            String formatTimeShort = at.getFormatTimeShort(bce.ben());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.iit.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (bce.getThreadType() == 40) {
                this.hlK.setVisibility(0);
                if (bce.beW() != null) {
                    str = bce.beW().thumbnail_url;
                }
            } else {
                this.hlK.setVisibility(8);
                if (bce.beN() != null && bce.beN().size() >= 1) {
                    str = bce.beN().get(0).getOriginalUrl();
                }
            }
            this.iis.startLoad(str, 10, false);
            if (!StringUtils.isNull(bce.bet())) {
                this.iiu.setText(bce.bet());
                this.iiu.setVisibility(0);
                return;
            }
            this.iiu.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes16.dex */
    public static class a extends af.a {
        public d iiv;

        public a(d dVar) {
            super(dVar.getView());
            this.iiv = dVar;
        }
    }
}
