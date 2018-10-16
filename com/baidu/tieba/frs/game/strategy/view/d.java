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
    private ImageView cPh;
    private TbImageView dMo;
    private TextView dMp;
    private TextView dMq;
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
        this.dMo = (TbImageView) this.mRootView.findViewById(e.g.frs_game_left_image);
        this.dMo.setDefaultErrorResource(e.f.icon_morenpic);
        this.dMo.setDefaultResource(e.f.icon_morenpic);
        this.cPh = (ImageView) this.mRootView.findViewById(e.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_title);
        this.dMp = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_scan_info);
        this.dMq = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.h(this.mTitle, e.d.cp_cont_b);
        al.h(this.dMp, e.d.cp_cont_d);
        al.h(this.dMq, e.d.cp_cont_i);
        al.i(this.mRootView, e.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.YA() != null) {
            bb YA = bVar.YA();
            this.mTitle.setText(YA.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vl(YA.getId())) {
                al.h(this.mTitle, e.d.cp_cont_c);
            } else {
                al.h(this.mTitle, e.d.cp_cont_b);
            }
            String G = ao.G(YA.yn());
            String E = ao.E(YA.yg());
            if (!StringUtils.isNull(G) && !StringUtils.isNull(E)) {
                this.dMp.setText(String.format(this.mContext.getString(e.j.frs_game_strategy_scan_info), G, E));
            }
            String str = null;
            if (YA.getThreadType() == 40) {
                this.cPh.setVisibility(0);
                if (YA.yN() != null) {
                    str = YA.yN().thumbnail_url;
                }
            } else {
                this.cPh.setVisibility(8);
                if (YA.yG() != null && YA.yG().size() >= 1) {
                    str = YA.yG().get(0).getOriginalUrl();
                }
            }
            this.dMo.startLoad(str, 10, false);
            if (!StringUtils.isNull(YA.yl())) {
                this.dMq.setText(YA.yl());
                this.dMq.setVisibility(0);
                return;
            }
            this.dMq.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d dMr;

        public a(d dVar) {
            super(dVar.getView());
            this.dMr = dVar;
        }
    }
}
