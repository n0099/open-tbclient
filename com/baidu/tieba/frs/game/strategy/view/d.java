package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView ePc;
    private TbImageView fHV;
    private TextView fHW;
    private TextView fHX;
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
        this.fHV = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.fHV.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fHV.setDefaultResource(R.drawable.icon_morenpic);
        this.ePc = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.fHW = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.fHX = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fHW, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fHX, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.agI() != null) {
            bh agI = bVar.agI();
            this.mTitle.setText(agI.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(agI.getId())) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = aq.numberUniformFormat(agI.aiy());
            String formatTimeShort = aq.getFormatTimeShort(agI.aiq());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.fHW.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (agI.getThreadType() == 40) {
                this.ePc.setVisibility(0);
                if (agI.aiX() != null) {
                    str = agI.aiX().thumbnail_url;
                }
            } else {
                this.ePc.setVisibility(8);
                if (agI.aiQ() != null && agI.aiQ().size() >= 1) {
                    str = agI.aiQ().get(0).getOriginalUrl();
                }
            }
            this.fHV.startLoad(str, 10, false);
            if (!StringUtils.isNull(agI.aiv())) {
                this.fHX.setText(agI.aiv());
                this.fHX.setVisibility(0);
                return;
            }
            this.fHX.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public d fHY;

        public a(d dVar) {
            super(dVar.getView());
            this.fHY = dVar;
        }
    }
}
