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
    private ImageView fMC;
    private TbImageView gBT;
    private TextView gBU;
    private TextView gBV;
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
        this.gBT = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.gBT.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gBT.setDefaultResource(R.drawable.icon_morenpic);
        this.fMC = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.gBU = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.gBV = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gBU, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gBV, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.aAj() != null) {
            bj aAj = bVar.aAj();
            this.mTitle.setText(aAj.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jp(aAj.getId())) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = aq.numberUniformFormat(aAj.aCj());
            String formatTimeShort = aq.getFormatTimeShort(aAj.aCa());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.gBU.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (aAj.getThreadType() == 40) {
                this.fMC.setVisibility(0);
                if (aAj.aCI() != null) {
                    str = aAj.aCI().thumbnail_url;
                }
            } else {
                this.fMC.setVisibility(8);
                if (aAj.aCB() != null && aAj.aCB().size() >= 1) {
                    str = aAj.aCB().get(0).getOriginalUrl();
                }
            }
            this.gBT.startLoad(str, 10, false);
            if (!StringUtils.isNull(aAj.aCg())) {
                this.gBV.setText(aAj.aCg());
                this.gBV.setVisibility(0);
                return;
            }
            this.gBV.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class a extends v.a {
        public d gBW;

        public a(d dVar) {
            super(dVar.getView());
            this.gBW = dVar;
        }
    }
}
