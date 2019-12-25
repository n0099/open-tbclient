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
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView fFY;
    private TbImageView gvx;
    private TextView gvy;
    private TextView gvz;
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
        this.gvx = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.gvx.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gvx.setDefaultResource(R.drawable.icon_morenpic);
        this.fFY = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.gvy = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.gvz = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gvy, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gvz, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.axx() != null) {
            bj axx = bVar.axx();
            this.mTitle.setText(axx.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.IR(axx.getId())) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = aq.numberUniformFormat(axx.azw());
            String formatTimeShort = aq.getFormatTimeShort(axx.azn());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.gvy.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (axx.getThreadType() == 40) {
                this.fFY.setVisibility(0);
                if (axx.azV() != null) {
                    str = axx.azV().thumbnail_url;
                }
            } else {
                this.fFY.setVisibility(8);
                if (axx.azO() != null && axx.azO().size() >= 1) {
                    str = axx.azO().get(0).getOriginalUrl();
                }
            }
            this.gvx.startLoad(str, 10, false);
            if (!StringUtils.isNull(axx.azt())) {
                this.gvz.setText(axx.azt());
                this.gvz.setVisibility(0);
                return;
            }
            this.gvz.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes6.dex */
    public static class a extends v.a {
        public d gvA;

        public a(d dVar) {
            super(dVar.getView());
            this.gvA = dVar;
        }
    }
}
