package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView eEM;
    private TbImageView fGP;
    private TextView fGQ;
    private TextView fGR;
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
        this.fGP = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.fGP.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fGP.setDefaultResource(R.drawable.icon_morenpic);
        this.eEM = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.fGQ = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.fGR = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.j(this.mTitle, R.color.cp_cont_b);
        am.j(this.fGQ, R.color.cp_cont_d);
        am.j(this.fGR, R.color.cp_btn_a);
        am.k(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.acy() != null) {
            bh acy = bVar.acy();
            this.mTitle.setText(acy.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.EY(acy.getId())) {
                am.j(this.mTitle, R.color.cp_cont_c);
            } else {
                am.j(this.mTitle, R.color.cp_cont_b);
            }
            String aH = aq.aH(acy.aeq());
            String aF = aq.aF(acy.aei());
            if (!StringUtils.isNull(aH) && !StringUtils.isNull(aF)) {
                this.fGQ.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), aH, aF));
            }
            String str = null;
            if (acy.getThreadType() == 40) {
                this.eEM.setVisibility(0);
                if (acy.aeP() != null) {
                    str = acy.aeP().thumbnail_url;
                }
            } else {
                this.eEM.setVisibility(8);
                if (acy.aeI() != null && acy.aeI().size() >= 1) {
                    str = acy.aeI().get(0).getOriginalUrl();
                }
            }
            this.fGP.startLoad(str, 10, false);
            if (!StringUtils.isNull(acy.aen())) {
                this.fGR.setText(acy.aen());
                this.fGR.setVisibility(0);
                return;
            }
            this.fGR.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public d fGS;

        public a(d dVar) {
            super(dVar.getView());
            this.fGS = dVar;
        }
    }
}
