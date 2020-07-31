package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView gYN;
    private TbImageView hUd;
    private TextView hUe;
    private TextView hUf;
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
        this.hUd = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.hUd.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hUd.setDefaultResource(R.drawable.icon_morenpic);
        this.gYN = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.hUe = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.hUf = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
        ao.setViewTextColor(this.hUe, R.color.cp_cont_d);
        ao.setViewTextColor(this.hUf, R.color.cp_cont_a);
        ao.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.aTN() != null) {
            bv aTN = bVar.aTN();
            this.mTitle.setText(aTN.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.NZ(aTN.getId())) {
                ao.setViewTextColor(this.mTitle, R.color.cp_cont_c);
            } else {
                ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            }
            String numberUniformFormat = as.numberUniformFormat(aTN.aWd());
            String formatTimeShort = as.getFormatTimeShort(aTN.aVU());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.hUe.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (aTN.getThreadType() == 40) {
                this.gYN.setVisibility(0);
                if (aTN.aWD() != null) {
                    str = aTN.aWD().thumbnail_url;
                }
            } else {
                this.gYN.setVisibility(8);
                if (aTN.aWu() != null && aTN.aWu().size() >= 1) {
                    str = aTN.aWu().get(0).getOriginalUrl();
                }
            }
            this.hUd.startLoad(str, 10, false);
            if (!StringUtils.isNull(aTN.aWa())) {
                this.hUf.setText(aTN.aWa());
                this.hUf.setVisibility(0);
                return;
            }
            this.hUf.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        public d hUg;

        public a(d dVar) {
            super(dVar.getView());
            this.hUg = dVar;
        }
    }
}
