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
    private TbImageView dXs;
    private TextView dXt;
    private TextView dXu;
    private ImageView daw;
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
        this.dXs = (TbImageView) this.mRootView.findViewById(e.g.frs_game_left_image);
        this.dXs.setDefaultErrorResource(e.f.icon_morenpic);
        this.dXs.setDefaultResource(e.f.icon_morenpic);
        this.daw = (ImageView) this.mRootView.findViewById(e.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_title);
        this.dXt = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_scan_info);
        this.dXu = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.h(this.mTitle, e.d.cp_cont_b);
        al.h(this.dXt, e.d.cp_cont_d);
        al.h(this.dXu, e.d.cp_cont_i);
        al.i(this.mRootView, e.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.aaq() != null) {
            bb aaq = bVar.aaq();
            this.mTitle.setText(aaq.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.wk(aaq.getId())) {
                al.h(this.mTitle, e.d.cp_cont_c);
            } else {
                al.h(this.mTitle, e.d.cp_cont_b);
            }
            String Q = ao.Q(aaq.zL());
            String O = ao.O(aaq.zE());
            if (!StringUtils.isNull(Q) && !StringUtils.isNull(O)) {
                this.dXt.setText(String.format(this.mContext.getString(e.j.frs_game_strategy_scan_info), Q, O));
            }
            String str = null;
            if (aaq.getThreadType() == 40) {
                this.daw.setVisibility(0);
                if (aaq.Al() != null) {
                    str = aaq.Al().thumbnail_url;
                }
            } else {
                this.daw.setVisibility(8);
                if (aaq.Ae() != null && aaq.Ae().size() >= 1) {
                    str = aaq.Ae().get(0).getOriginalUrl();
                }
            }
            this.dXs.startLoad(str, 10, false);
            if (!StringUtils.isNull(aaq.zJ())) {
                this.dXu.setText(aaq.zJ());
                this.dXu.setVisibility(0);
                return;
            }
            this.dXu.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d dXv;

        public a(d dVar) {
            super(dVar.getView());
            this.dXv = dVar;
        }
    }
}
