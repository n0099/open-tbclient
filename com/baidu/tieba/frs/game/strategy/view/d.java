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
    private ImageView crY;
    private TbImageView dix;
    private TextView diy;
    private TextView diz;
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
        this.dix = (TbImageView) this.mRootView.findViewById(d.g.frs_game_left_image);
        this.dix.setDefaultErrorResource(d.f.icon_morenpic);
        this.dix.setDefaultResource(d.f.icon_morenpic);
        this.crY = (ImageView) this.mRootView.findViewById(d.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_title);
        this.diy = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_scan_info);
        this.diz = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        ak.h(this.mTitle, d.C0126d.cp_cont_b);
        ak.h(this.diy, d.C0126d.cp_cont_d);
        ak.h(this.diz, d.C0126d.cp_cont_i);
        ak.i(this.mRootView, d.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.Pb() != null) {
            bd Pb = bVar.Pb();
            this.mTitle.setText(Pb.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tg(Pb.getId())) {
                ak.h(this.mTitle, d.C0126d.cp_cont_c);
            } else {
                ak.h(this.mTitle, d.C0126d.cp_cont_b);
            }
            String v = an.v(Pb.rI());
            String t = an.t(Pb.rC());
            if (!StringUtils.isNull(v) && !StringUtils.isNull(t)) {
                this.diy.setText(String.format(this.mContext.getString(d.k.frs_game_strategy_scan_info), v, t));
            }
            String str = null;
            if (Pb.getThreadType() == 40) {
                this.crY.setVisibility(0);
                if (Pb.sg() != null) {
                    str = Pb.sg().thumbnail_url;
                }
            } else {
                this.crY.setVisibility(8);
                if (Pb.rZ() != null && Pb.rZ().size() >= 1) {
                    str = Pb.rZ().get(0).getOriginalUrl();
                }
            }
            this.dix.startLoad(str, 10, false);
            if (!StringUtils.isNull(Pb.rG())) {
                this.diz.setText(Pb.rG());
                this.diz.setVisibility(0);
                return;
            }
            this.diz.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d diA;

        public a(d dVar) {
            super(dVar.getView());
            this.diA = dVar;
        }
    }
}
