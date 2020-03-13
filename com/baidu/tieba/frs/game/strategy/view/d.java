package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView fLU;
    private TbImageView gAV;
    private TextView gAW;
    private TextView gAX;
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
        this.gAV = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.gAV.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gAV.setDefaultResource(R.drawable.icon_morenpic);
        this.fLU = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.gAW = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.gAX = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gAW, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gAX, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.aAg() != null) {
            bj aAg = bVar.aAg();
            this.mTitle.setText(aAg.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jp(aAg.getId())) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = aq.numberUniformFormat(aAg.aCg());
            String formatTimeShort = aq.getFormatTimeShort(aAg.aBX());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.gAW.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (aAg.getThreadType() == 40) {
                this.fLU.setVisibility(0);
                if (aAg.aCF() != null) {
                    str = aAg.aCF().thumbnail_url;
                }
            } else {
                this.fLU.setVisibility(8);
                if (aAg.aCy() != null && aAg.aCy().size() >= 1) {
                    str = aAg.aCy().get(0).getOriginalUrl();
                }
            }
            this.gAV.startLoad(str, 10, false);
            if (!StringUtils.isNull(aAg.aCd())) {
                this.gAX.setText(aAg.aCd());
                this.gAX.setVisibility(0);
                return;
            }
            this.gAX.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public d gAY;

        public a(d dVar) {
            super(dVar.getView());
            this.gAY = dVar;
        }
    }
}
