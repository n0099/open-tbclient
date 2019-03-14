package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView ekh;
    private TbImageView fkV;
    private TextView fkW;
    private TextView fkX;
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
        this.fkV = (TbImageView) this.mRootView.findViewById(d.g.frs_game_left_image);
        this.fkV.setDefaultErrorResource(d.f.icon_morenpic);
        this.fkV.setDefaultResource(d.f.icon_morenpic);
        this.ekh = (ImageView) this.mRootView.findViewById(d.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_title);
        this.fkW = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_scan_info);
        this.fkX = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.j(this.mTitle, d.C0277d.cp_cont_b);
        al.j(this.fkW, d.C0277d.cp_cont_d);
        al.j(this.fkX, d.C0277d.cp_btn_a);
        al.k(this.mRootView, d.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.WR() != null) {
            bg WR = bVar.WR();
            this.mTitle.setText(WR.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CN(WR.getId())) {
                al.j(this.mTitle, d.C0277d.cp_cont_c);
            } else {
                al.j(this.mTitle, d.C0277d.cp_cont_b);
            }
            String as = ap.as(WR.YJ());
            String aq = ap.aq(WR.YB());
            if (!StringUtils.isNull(as) && !StringUtils.isNull(aq)) {
                this.fkW.setText(String.format(this.mContext.getString(d.j.frs_game_strategy_scan_info), as, aq));
            }
            String str = null;
            if (WR.getThreadType() == 40) {
                this.ekh.setVisibility(0);
                if (WR.Zi() != null) {
                    str = WR.Zi().thumbnail_url;
                }
            } else {
                this.ekh.setVisibility(8);
                if (WR.Zb() != null && WR.Zb().size() >= 1) {
                    str = WR.Zb().get(0).getOriginalUrl();
                }
            }
            this.fkV.startLoad(str, 10, false);
            if (!StringUtils.isNull(WR.YG())) {
                this.fkX.setText(WR.YG());
                this.fkX.setVisibility(0);
                return;
            }
            this.fkX.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public d fkY;

        public a(d dVar) {
            super(dVar.getView());
            this.fkY = dVar;
        }
    }
}
