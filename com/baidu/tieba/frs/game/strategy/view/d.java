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
    private ImageView cGN;
    private TbImageView dEp;
    private TextView dEq;
    private TextView dEr;
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
        this.dEp = (TbImageView) this.mRootView.findViewById(e.g.frs_game_left_image);
        this.dEp.setDefaultErrorResource(e.f.icon_morenpic);
        this.dEp.setDefaultResource(e.f.icon_morenpic);
        this.cGN = (ImageView) this.mRootView.findViewById(e.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_title);
        this.dEq = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_scan_info);
        this.dEr = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.h(this.mTitle, e.d.cp_cont_b);
        al.h(this.dEq, e.d.cp_cont_d);
        al.h(this.dEr, e.d.cp_cont_i);
        al.i(this.mRootView, e.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.UT() != null) {
            bb UT = bVar.UT();
            this.mTitle.setText(UT.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.uJ(UT.getId())) {
                al.h(this.mTitle, e.d.cp_cont_c);
            } else {
                al.h(this.mTitle, e.d.cp_cont_b);
            }
            String E = ao.E(UT.we());
            String C = ao.C(UT.vX());
            if (!StringUtils.isNull(E) && !StringUtils.isNull(C)) {
                this.dEq.setText(String.format(this.mContext.getString(e.j.frs_game_strategy_scan_info), E, C));
            }
            String str = null;
            if (UT.getThreadType() == 40) {
                this.cGN.setVisibility(0);
                if (UT.wE() != null) {
                    str = UT.wE().thumbnail_url;
                }
            } else {
                this.cGN.setVisibility(8);
                if (UT.wx() != null && UT.wx().size() >= 1) {
                    str = UT.wx().get(0).getOriginalUrl();
                }
            }
            this.dEp.startLoad(str, 10, false);
            if (!StringUtils.isNull(UT.wc())) {
                this.dEr.setText(UT.wc());
                this.dEr.setVisibility(0);
                return;
            }
            this.dEr.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d dEs;

        public a(d dVar) {
            super(dVar.getView());
            this.dEs = dVar;
        }
    }
}
