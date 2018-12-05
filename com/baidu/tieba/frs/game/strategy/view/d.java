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
    private ImageView cWU;
    private TbImageView dTV;
    private TextView dTW;
    private TextView dTX;
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
        this.dTV = (TbImageView) this.mRootView.findViewById(e.g.frs_game_left_image);
        this.dTV.setDefaultErrorResource(e.f.icon_morenpic);
        this.dTV.setDefaultResource(e.f.icon_morenpic);
        this.cWU = (ImageView) this.mRootView.findViewById(e.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_title);
        this.dTW = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_scan_info);
        this.dTX = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.h(this.mTitle, e.d.cp_cont_b);
        al.h(this.dTW, e.d.cp_cont_d);
        al.h(this.dTX, e.d.cp_cont_i);
        al.i(this.mRootView, e.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.ZR() != null) {
            bb ZR = bVar.ZR();
            this.mTitle.setText(ZR.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vR(ZR.getId())) {
                al.h(this.mTitle, e.d.cp_cont_c);
            } else {
                al.h(this.mTitle, e.d.cp_cont_b);
            }
            String P = ao.P(ZR.zy());
            String N = ao.N(ZR.zr());
            if (!StringUtils.isNull(P) && !StringUtils.isNull(N)) {
                this.dTW.setText(String.format(this.mContext.getString(e.j.frs_game_strategy_scan_info), P, N));
            }
            String str = null;
            if (ZR.getThreadType() == 40) {
                this.cWU.setVisibility(0);
                if (ZR.zY() != null) {
                    str = ZR.zY().thumbnail_url;
                }
            } else {
                this.cWU.setVisibility(8);
                if (ZR.zR() != null && ZR.zR().size() >= 1) {
                    str = ZR.zR().get(0).getOriginalUrl();
                }
            }
            this.dTV.startLoad(str, 10, false);
            if (!StringUtils.isNull(ZR.zw())) {
                this.dTX.setText(ZR.zw());
                this.dTX.setVisibility(0);
                return;
            }
            this.dTX.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d dTY;

        public a(d dVar) {
            super(dVar.getView());
            this.dTY = dVar;
        }
    }
}
