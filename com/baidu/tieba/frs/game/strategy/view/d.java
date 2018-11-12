package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView cQn;
    private TbImageView dNs;
    private TextView dNt;
    private TextView dNu;
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
        this.dNs = (TbImageView) this.mRootView.findViewById(e.g.frs_game_left_image);
        this.dNs.setDefaultErrorResource(e.f.icon_morenpic);
        this.dNs.setDefaultResource(e.f.icon_morenpic);
        this.cQn = (ImageView) this.mRootView.findViewById(e.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_title);
        this.dNt = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_scan_info);
        this.dNu = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.h(this.mTitle, e.d.cp_cont_b);
        al.h(this.dNt, e.d.cp_cont_d);
        al.h(this.dNu, e.d.cp_cont_i);
        al.i(this.mRootView, e.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.YL() != null) {
            bb YL = bVar.YL();
            this.mTitle.setText(YL.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vq(YL.getId())) {
                al.h(this.mTitle, e.d.cp_cont_c);
            } else {
                al.h(this.mTitle, e.d.cp_cont_b);
            }
            String I = ao.I(YL.yu());
            String G = ao.G(YL.yn());
            if (!StringUtils.isNull(I) && !StringUtils.isNull(G)) {
                this.dNt.setText(String.format(this.mContext.getString(e.j.frs_game_strategy_scan_info), I, G));
            }
            String str = null;
            if (YL.getThreadType() == 40) {
                this.cQn.setVisibility(0);
                if (YL.yU() != null) {
                    str = YL.yU().thumbnail_url;
                }
            } else {
                this.cQn.setVisibility(8);
                if (YL.yN() != null && YL.yN().size() >= 1) {
                    str = YL.yN().get(0).getOriginalUrl();
                }
            }
            this.dNs.startLoad(str, 10, false);
            if (!StringUtils.isNull(YL.ys())) {
                this.dNu.setText(YL.ys());
                this.dNu.setVisibility(0);
                return;
            }
            this.dNu.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d dNv;

        public a(d dVar) {
            super(dVar.getView());
            this.dNv = dVar;
        }
    }
}
