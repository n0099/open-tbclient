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
    private ImageView hUe;
    private TbImageView iQJ;
    private TextView iQK;
    private TextView iQL;
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
        this.iQJ = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.iQJ.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.iQJ.setDefaultResource(R.drawable.icon_morenpic);
        this.hUe = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.iQK = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.iQL = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.iQK, (int) R.color.cp_cont_d);
        ap.setViewTextColor(this.iQL, (int) R.color.cp_cont_a);
        ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.bhz() != null) {
            bw bhz = bVar.bhz();
            this.mTitle.setText(bhz.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.SK(bhz.getId())) {
                ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = at.numberUniformFormat(bhz.bjS());
            String formatTimeShort = at.getFormatTimeShort(bhz.bjJ());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.iQK.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (bhz.getThreadType() == 40) {
                this.hUe.setVisibility(0);
                if (bhz.bks() != null) {
                    str = bhz.bks().thumbnail_url;
                }
            } else {
                this.hUe.setVisibility(8);
                if (bhz.bkj() != null && bhz.bkj().size() >= 1) {
                    str = bhz.bkj().get(0).getOriginalUrl();
                }
            }
            this.iQJ.startLoad(str, 10, false);
            if (!StringUtils.isNull(bhz.bjP())) {
                this.iQL.setText(bhz.bjP());
                this.iQL.setVisibility(0);
                return;
            }
            this.iQL.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public d iQM;

        public a(d dVar) {
            super(dVar.getView());
            this.iQM = dVar;
        }
    }
}
