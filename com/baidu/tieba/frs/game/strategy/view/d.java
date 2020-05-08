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
    private ImageView grp;
    private TbImageView hlv;
    private TextView hlw;
    private TextView hlx;
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
        this.hlv = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.hlv.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hlv.setDefaultResource(R.drawable.icon_morenpic);
        this.grp = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.hlw = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.hlx = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hlw, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hlx, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.aIu() != null) {
            bj aIu = bVar.aIu();
            this.mTitle.setText(aIu.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Lb(aIu.getId())) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = aq.numberUniformFormat(aIu.aKu());
            String formatTimeShort = aq.getFormatTimeShort(aIu.aKl());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.hlw.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (aIu.getThreadType() == 40) {
                this.grp.setVisibility(0);
                if (aIu.aKT() != null) {
                    str = aIu.aKT().thumbnail_url;
                }
            } else {
                this.grp.setVisibility(8);
                if (aIu.aKM() != null && aIu.aKM().size() >= 1) {
                    str = aIu.aKM().get(0).getOriginalUrl();
                }
            }
            this.hlv.startLoad(str, 10, false);
            if (!StringUtils.isNull(aIu.aKr())) {
                this.hlx.setText(aIu.aKr());
                this.hlx.setVisibility(0);
                return;
            }
            this.hlx.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class a extends y.a {
        public d hly;

        public a(d dVar) {
            super(dVar.getView());
            this.hly = dVar;
        }
    }
}
