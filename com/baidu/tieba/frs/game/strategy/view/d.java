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
    private ImageView cZK;
    private TbImageView dWM;
    private TextView dWN;
    private TextView dWO;
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
        this.dWM = (TbImageView) this.mRootView.findViewById(e.g.frs_game_left_image);
        this.dWM.setDefaultErrorResource(e.f.icon_morenpic);
        this.dWM.setDefaultResource(e.f.icon_morenpic);
        this.cZK = (ImageView) this.mRootView.findViewById(e.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_title);
        this.dWN = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_scan_info);
        this.dWO = (TextView) this.mRootView.findViewById(e.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.h(this.mTitle, e.d.cp_cont_b);
        al.h(this.dWN, e.d.cp_cont_d);
        al.h(this.dWO, e.d.cp_cont_i);
        al.i(this.mRootView, e.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.ZT() != null) {
            bb ZT = bVar.ZT();
            this.mTitle.setText(ZT.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.vU(ZT.getId())) {
                al.h(this.mTitle, e.d.cp_cont_c);
            } else {
                al.h(this.mTitle, e.d.cp_cont_b);
            }
            String Q = ao.Q(ZT.zy());
            String O = ao.O(ZT.zr());
            if (!StringUtils.isNull(Q) && !StringUtils.isNull(O)) {
                this.dWN.setText(String.format(this.mContext.getString(e.j.frs_game_strategy_scan_info), Q, O));
            }
            String str = null;
            if (ZT.getThreadType() == 40) {
                this.cZK.setVisibility(0);
                if (ZT.zY() != null) {
                    str = ZT.zY().thumbnail_url;
                }
            } else {
                this.cZK.setVisibility(8);
                if (ZT.zR() != null && ZT.zR().size() >= 1) {
                    str = ZT.zR().get(0).getOriginalUrl();
                }
            }
            this.dWM.startLoad(str, 10, false);
            if (!StringUtils.isNull(ZT.zw())) {
                this.dWO.setText(ZT.zw());
                this.dWO.setVisibility(0);
                return;
            }
            this.dWO.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d dWP;

        public a(d dVar) {
            super(dVar.getView());
            this.dWP = dVar;
        }
    }
}
