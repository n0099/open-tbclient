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
    private ImageView ejU;
    private TbImageView fkH;
    private TextView fkI;
    private TextView fkJ;
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
        this.fkH = (TbImageView) this.mRootView.findViewById(d.g.frs_game_left_image);
        this.fkH.setDefaultErrorResource(d.f.icon_morenpic);
        this.fkH.setDefaultResource(d.f.icon_morenpic);
        this.ejU = (ImageView) this.mRootView.findViewById(d.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_title);
        this.fkI = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_scan_info);
        this.fkJ = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.j(this.mTitle, d.C0277d.cp_cont_b);
        al.j(this.fkI, d.C0277d.cp_cont_d);
        al.j(this.fkJ, d.C0277d.cp_btn_a);
        al.k(this.mRootView, d.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.WO() != null) {
            bg WO = bVar.WO();
            this.mTitle.setText(WO.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.CM(WO.getId())) {
                al.j(this.mTitle, d.C0277d.cp_cont_c);
            } else {
                al.j(this.mTitle, d.C0277d.cp_cont_b);
            }
            String as = ap.as(WO.YG());
            String aq = ap.aq(WO.Yy());
            if (!StringUtils.isNull(as) && !StringUtils.isNull(aq)) {
                this.fkI.setText(String.format(this.mContext.getString(d.j.frs_game_strategy_scan_info), as, aq));
            }
            String str = null;
            if (WO.getThreadType() == 40) {
                this.ejU.setVisibility(0);
                if (WO.Zf() != null) {
                    str = WO.Zf().thumbnail_url;
                }
            } else {
                this.ejU.setVisibility(8);
                if (WO.YY() != null && WO.YY().size() >= 1) {
                    str = WO.YY().get(0).getOriginalUrl();
                }
            }
            this.fkH.startLoad(str, 10, false);
            if (!StringUtils.isNull(WO.YD())) {
                this.fkJ.setText(WO.YD());
                this.fkJ.setVisibility(0);
                return;
            }
            this.fkJ.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public d fkK;

        public a(d dVar) {
            super(dVar.getView());
            this.fkK = dVar;
        }
    }
}
