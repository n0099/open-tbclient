package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView cYU;
    private TbImageView dON;
    private TextView dOO;
    private TextView dOP;
    private TbPageContext mPageContext;
    private View mRootView;
    private TextView mTitle;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        initView();
    }

    private void initView() {
        this.dON = (TbImageView) this.mRootView.findViewById(d.g.frs_game_left_image);
        this.dON.setDefaultErrorResource(d.f.icon_morenpic);
        this.dON.setDefaultResource(d.f.icon_morenpic);
        this.cYU = (ImageView) this.mRootView.findViewById(d.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_title);
        this.dOO = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_scan_info);
        this.dOP = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.r(this.mTitle, d.C0141d.cp_cont_b);
        aj.r(this.dOO, d.C0141d.cp_cont_d);
        aj.r(this.dOP, d.C0141d.cp_cont_i);
        aj.s(this.mRootView, d.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.WE() != null) {
            bd WE = bVar.WE();
            this.mTitle.setText(WE.getTitle());
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sW(WE.getId())) {
                aj.r(this.mTitle, d.C0141d.cp_cont_c);
            } else {
                aj.r(this.mTitle, d.C0141d.cp_cont_b);
            }
            String C = am.C(WE.zg());
            String A = am.A(WE.za());
            if (!StringUtils.isNull(C) && !StringUtils.isNull(A)) {
                this.dOO.setText(String.format(this.mContext.getString(d.j.frs_game_strategy_scan_info), C, A));
            }
            String str = null;
            if (WE.getThreadType() == 40) {
                this.cYU.setVisibility(0);
                if (WE.zF() != null) {
                    str = WE.zF().thumbnail_url;
                }
            } else {
                this.cYU.setVisibility(8);
                if (WE.zy() != null && WE.zy().size() >= 1) {
                    str = WE.zy().get(0).getOriginalUrl();
                }
            }
            this.dON.startLoad(str, 10, false);
            if (!StringUtils.isNull(WE.ze())) {
                this.dOP.setText(WE.ze());
                this.dOP.setVisibility(0);
                return;
            }
            this.dOP.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends r.a {
        public e dOQ;

        public a(e eVar) {
            super(eVar.getView());
            this.dOQ = eVar;
        }
    }
}
