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
    private ImageView eOl;
    private TbImageView fHe;
    private TextView fHf;
    private TextView fHg;
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
        this.fHe = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.fHe.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fHe.setDefaultResource(R.drawable.icon_morenpic);
        this.eOl = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.fHf = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.fHg = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fHf, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.fHg, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.agG() != null) {
            bh agG = bVar.agG();
            this.mTitle.setText(agG.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ec(agG.getId())) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = aq.numberUniformFormat(agG.aiw());
            String formatTimeShort = aq.getFormatTimeShort(agG.aio());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.fHf.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (agG.getThreadType() == 40) {
                this.eOl.setVisibility(0);
                if (agG.aiV() != null) {
                    str = agG.aiV().thumbnail_url;
                }
            } else {
                this.eOl.setVisibility(8);
                if (agG.aiO() != null && agG.aiO().size() >= 1) {
                    str = agG.aiO().get(0).getOriginalUrl();
                }
            }
            this.fHe.startLoad(str, 10, false);
            if (!StringUtils.isNull(agG.ait())) {
                this.fHg.setText(agG.ait());
                this.fHg.setVisibility(0);
                return;
            }
            this.fHg.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public d fHh;

        public a(d dVar) {
            super(dVar.getView());
            this.fHh = dVar;
        }
    }
}
