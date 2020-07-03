package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView gTi;
    private TbImageView hOe;
    private TextView hOf;
    private TextView hOg;
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
        this.hOe = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.hOe.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.hOe.setDefaultResource(R.drawable.icon_morenpic);
        this.gTi = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.hOf = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.hOg = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hOf, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.hOg, (int) R.color.cp_cont_a);
        an.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.aPS() != null) {
            bu aPS = bVar.aPS();
            this.mTitle.setText(aPS.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Nr(aPS.getId())) {
                an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = ar.numberUniformFormat(aPS.aSh());
            String formatTimeShort = ar.getFormatTimeShort(aPS.aRY());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.hOf.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (aPS.getThreadType() == 40) {
                this.gTi.setVisibility(0);
                if (aPS.aSH() != null) {
                    str = aPS.aSH().thumbnail_url;
                }
            } else {
                this.gTi.setVisibility(8);
                if (aPS.aSy() != null && aPS.aSy().size() >= 1) {
                    str = aPS.aSy().get(0).getOriginalUrl();
                }
            }
            this.hOe.startLoad(str, 10, false);
            if (!StringUtils.isNull(aPS.aSe())) {
                this.hOg.setText(aPS.aSe());
                this.hOg.setVisibility(0);
                return;
            }
            this.hOg.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class a extends ad.a {
        public d hOh;

        public a(d dVar) {
            super(dVar.getView());
            this.hOh = dVar;
        }
    }
}
