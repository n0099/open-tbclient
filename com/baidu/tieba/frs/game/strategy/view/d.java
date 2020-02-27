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
    private ImageView fLF;
    private TbImageView gAH;
    private TextView gAI;
    private TextView gAJ;
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
        this.gAH = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.gAH.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gAH.setDefaultResource(R.drawable.icon_morenpic);
        this.fLF = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.gAI = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.gAJ = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gAI, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gAJ, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.aAe() != null) {
            bj aAe = bVar.aAe();
            this.mTitle.setText(aAe.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jo(aAe.getId())) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = aq.numberUniformFormat(aAe.aCe());
            String formatTimeShort = aq.getFormatTimeShort(aAe.aBV());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.gAI.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (aAe.getThreadType() == 40) {
                this.fLF.setVisibility(0);
                if (aAe.aCD() != null) {
                    str = aAe.aCD().thumbnail_url;
                }
            } else {
                this.fLF.setVisibility(8);
                if (aAe.aCw() != null && aAe.aCw().size() >= 1) {
                    str = aAe.aCw().get(0).getOriginalUrl();
                }
            }
            this.gAH.startLoad(str, 10, false);
            if (!StringUtils.isNull(aAe.aCb())) {
                this.gAJ.setText(aAe.aCb());
                this.gAJ.setVisibility(0);
                return;
            }
            this.gAJ.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public d gAK;

        public a(d dVar) {
            super(dVar.getView());
            this.gAK = dVar;
        }
    }
}
