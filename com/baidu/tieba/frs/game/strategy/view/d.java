package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView cAB;
    private TbImageView drM;
    private TextView drN;
    private TextView drO;
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
        this.drM = (TbImageView) this.mRootView.findViewById(d.g.frs_game_left_image);
        this.drM.setDefaultErrorResource(d.f.icon_morenpic);
        this.drM.setDefaultResource(d.f.icon_morenpic);
        this.cAB = (ImageView) this.mRootView.findViewById(d.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_title);
        this.drN = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_scan_info);
        this.drO = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        al.h(this.mTitle, d.C0141d.cp_cont_b);
        al.h(this.drN, d.C0141d.cp_cont_d);
        al.h(this.drO, d.C0141d.cp_cont_i);
        al.i(this.mRootView, d.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.Sz() != null) {
            bd Sz = bVar.Sz();
            this.mTitle.setText(Sz.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ua(Sz.getId())) {
                al.h(this.mTitle, d.C0141d.cp_cont_c);
            } else {
                al.h(this.mTitle, d.C0141d.cp_cont_b);
            }
            String y = ao.y(Sz.vf());
            String w = ao.w(Sz.uY());
            if (!StringUtils.isNull(y) && !StringUtils.isNull(w)) {
                this.drN.setText(String.format(this.mContext.getString(d.k.frs_game_strategy_scan_info), y, w));
            }
            String str = null;
            if (Sz.getThreadType() == 40) {
                this.cAB.setVisibility(0);
                if (Sz.vD() != null) {
                    str = Sz.vD().thumbnail_url;
                }
            } else {
                this.cAB.setVisibility(8);
                if (Sz.vw() != null && Sz.vw().size() >= 1) {
                    str = Sz.vw().get(0).getOriginalUrl();
                }
            }
            this.drM.startLoad(str, 10, false);
            if (!StringUtils.isNull(Sz.vd())) {
                this.drO.setText(Sz.vd());
                this.drO.setVisibility(0);
                return;
            }
            this.drO.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d drP;

        public a(d dVar) {
            super(dVar.getView());
            this.drP = dVar;
        }
    }
}
