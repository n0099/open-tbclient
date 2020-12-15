package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.b<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView ilA;
    private TbImageView jkT;
    private TextView jkU;
    private TextView jkV;
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
        this.jkT = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.jkT.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.jkT.setDefaultResource(R.drawable.icon_morenpic);
        this.ilA = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.jkU = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.jkV = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.jkU, (int) R.color.CAM_X0109);
        ap.setViewTextColor(this.jkV, (int) R.color.CAM_X0101);
        ap.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.bmn() != null) {
            by bmn = bVar.bmn();
            this.mTitle.setText(bmn.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ub(bmn.getId())) {
                ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0108);
            } else {
                ap.setViewTextColor(this.mTitle, (int) R.color.CAM_X0105);
            }
            String numberUniformFormat = au.numberUniformFormat(bmn.boH());
            String formatTimeShort = au.getFormatTimeShort(bmn.boy());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.jkU.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (bmn.getThreadType() == 40) {
                this.ilA.setVisibility(0);
                if (bmn.bph() != null) {
                    str = bmn.bph().thumbnail_url;
                }
            } else {
                this.ilA.setVisibility(8);
                if (bmn.boY() != null && bmn.boY().size() >= 1) {
                    str = bmn.boY().get(0).getOriginalUrl();
                }
            }
            this.jkT.startLoad(str, 10, false);
            if (!StringUtils.isNull(bmn.boE())) {
                this.jkV.setText(bmn.boE());
                this.jkV.setVisibility(0);
                return;
            }
            this.jkV.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes22.dex */
    public static class a extends af.a {
        public d jkW;

        public a(d dVar) {
            super(dVar.getView());
            this.jkW = dVar;
        }
    }
}
