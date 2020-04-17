package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView grj;
    private TbImageView hlp;
    private TextView hlq;
    private TextView hlr;
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
        this.hlp = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.hlp.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hlp.setDefaultResource(R.drawable.icon_morenpic);
        this.grj = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.hlq = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.hlr = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hlq, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hlr, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.aIw() != null) {
            bj aIw = bVar.aIw();
            this.mTitle.setText(aIw.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.KY(aIw.getId())) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = aq.numberUniformFormat(aIw.aKw());
            String formatTimeShort = aq.getFormatTimeShort(aIw.aKn());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.hlq.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (aIw.getThreadType() == 40) {
                this.grj.setVisibility(0);
                if (aIw.aKV() != null) {
                    str = aIw.aKV().thumbnail_url;
                }
            } else {
                this.grj.setVisibility(8);
                if (aIw.aKO() != null && aIw.aKO().size() >= 1) {
                    str = aIw.aKO().get(0).getOriginalUrl();
                }
            }
            this.hlp.startLoad(str, 10, false);
            if (!StringUtils.isNull(aIw.aKt())) {
                this.hlr.setText(aIw.aKt());
                this.hlr.setVisibility(0);
                return;
            }
            this.hlr.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class a extends y.a {
        public d hls;

        public a(d dVar) {
            super(dVar.getView());
            this.hls = dVar;
        }
    }
}
