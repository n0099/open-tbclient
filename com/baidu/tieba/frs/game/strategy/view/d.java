package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView gGp;
    private TbImageView hAW;
    private TextView hAX;
    private TextView hAY;
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
        this.hAW = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.hAW.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hAW.setDefaultResource(R.drawable.icon_morenpic);
        this.gGp = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.hAX = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.hAY = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hAX, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hAY, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.aOi() != null) {
            bk aOi = bVar.aOi();
            this.mTitle.setText(aOi.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.MP(aOi.getId())) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = aq.numberUniformFormat(aOi.aQp());
            String formatTimeShort = aq.getFormatTimeShort(aOi.aQg());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.hAX.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (aOi.getThreadType() == 40) {
                this.gGp.setVisibility(0);
                if (aOi.aQQ() != null) {
                    str = aOi.aQQ().thumbnail_url;
                }
            } else {
                this.gGp.setVisibility(8);
                if (aOi.aQH() != null && aOi.aQH().size() >= 1) {
                    str = aOi.aQH().get(0).getOriginalUrl();
                }
            }
            this.hAW.startLoad(str, 10, false);
            if (!StringUtils.isNull(aOi.aQm())) {
                this.hAY.setText(aOi.aQm());
                this.hAY.setVisibility(0);
                return;
            }
            this.hAY.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        public d hAZ;

        public a(d dVar) {
            super(dVar.getView());
            this.hAZ = dVar;
        }
    }
}
