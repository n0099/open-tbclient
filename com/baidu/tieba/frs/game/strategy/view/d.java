package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView cqO;
    private TbImageView dhq;
    private TextView dhr;
    private TextView dhs;
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
        this.dhq = (TbImageView) this.mRootView.findViewById(d.g.frs_game_left_image);
        this.dhq.setDefaultErrorResource(d.f.icon_morenpic);
        this.dhq.setDefaultResource(d.f.icon_morenpic);
        this.cqO = (ImageView) this.mRootView.findViewById(d.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_title);
        this.dhr = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_scan_info);
        this.dhs = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ak.h(this.mTitle, d.C0126d.cp_cont_b);
        ak.h(this.dhr, d.C0126d.cp_cont_d);
        ak.h(this.dhs, d.C0126d.cp_cont_i);
        ak.i(this.mRootView, d.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.Pe() != null) {
            bd Pe = bVar.Pe();
            this.mTitle.setText(Pe.getTitle());
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.td(Pe.getId())) {
                ak.h(this.mTitle, d.C0126d.cp_cont_c);
            } else {
                ak.h(this.mTitle, d.C0126d.cp_cont_b);
            }
            String v = an.v(Pe.rJ());
            String t = an.t(Pe.rD());
            if (!StringUtils.isNull(v) && !StringUtils.isNull(t)) {
                this.dhr.setText(String.format(this.mContext.getString(d.k.frs_game_strategy_scan_info), v, t));
            }
            String str = null;
            if (Pe.getThreadType() == 40) {
                this.cqO.setVisibility(0);
                if (Pe.sh() != null) {
                    str = Pe.sh().thumbnail_url;
                }
            } else {
                this.cqO.setVisibility(8);
                if (Pe.sa() != null && Pe.sa().size() >= 1) {
                    str = Pe.sa().get(0).getOriginalUrl();
                }
            }
            this.dhq.startLoad(str, 10, false);
            if (!StringUtils.isNull(Pe.rH())) {
                this.dhs.setText(Pe.rH());
                this.dhs.setVisibility(0);
                return;
            }
            this.dhs.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d dht;

        public a(d dVar) {
            super(dVar.getView());
            this.dht = dVar;
        }
    }
}
