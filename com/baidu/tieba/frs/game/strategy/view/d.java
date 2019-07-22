package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView eEF;
    private TbImageView fGb;
    private TextView fGc;
    private TextView fGd;
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
        this.fGb = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.fGb.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fGb.setDefaultResource(R.drawable.icon_morenpic);
        this.eEF = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.fGc = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.fGd = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.j(this.mTitle, R.color.cp_cont_b);
        am.j(this.fGc, R.color.cp_cont_d);
        am.j(this.fGd, R.color.cp_btn_a);
        am.k(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.acx() != null) {
            bg acx = bVar.acx();
            this.mTitle.setText(acx.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.EX(acx.getId())) {
                am.j(this.mTitle, R.color.cp_cont_c);
            } else {
                am.j(this.mTitle, R.color.cp_cont_b);
            }
            String aH = aq.aH(acx.aep());
            String aF = aq.aF(acx.aeh());
            if (!StringUtils.isNull(aH) && !StringUtils.isNull(aF)) {
                this.fGc.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), aH, aF));
            }
            String str = null;
            if (acx.getThreadType() == 40) {
                this.eEF.setVisibility(0);
                if (acx.aeO() != null) {
                    str = acx.aeO().thumbnail_url;
                }
            } else {
                this.eEF.setVisibility(8);
                if (acx.aeH() != null && acx.aeH().size() >= 1) {
                    str = acx.aeH().get(0).getOriginalUrl();
                }
            }
            this.fGb.startLoad(str, 10, false);
            if (!StringUtils.isNull(acx.aem())) {
                this.fGd.setText(acx.aem());
                this.fGd.setVisibility(0);
                return;
            }
            this.fGd.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public d fGe;

        public a(d dVar) {
            super(dVar.getView());
            this.fGe = dVar;
        }
    }
}
