package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView cyv;
    private TbImageView duV;
    private TextView duW;
    private TextView duX;
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
        this.duV = (TbImageView) this.mRootView.findViewById(d.g.frs_game_left_image);
        this.duV.setDefaultErrorResource(d.f.icon_morenpic);
        this.duV.setDefaultResource(d.f.icon_morenpic);
        this.cyv = (ImageView) this.mRootView.findViewById(d.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_title);
        this.duW = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_scan_info);
        this.duX = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.h(this.mTitle, d.C0142d.cp_cont_b);
        am.h(this.duW, d.C0142d.cp_cont_d);
        am.h(this.duX, d.C0142d.cp_cont_i);
        am.i(this.mRootView, d.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.SV() != null) {
            bc SV = bVar.SV();
            this.mTitle.setText(SV.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.ua(SV.getId())) {
                am.h(this.mTitle, d.C0142d.cp_cont_c);
            } else {
                am.h(this.mTitle, d.C0142d.cp_cont_b);
            }
            String z = ap.z(SV.vo());
            String x = ap.x(SV.vh());
            if (!StringUtils.isNull(z) && !StringUtils.isNull(x)) {
                this.duW.setText(String.format(this.mContext.getString(d.k.frs_game_strategy_scan_info), z, x));
            }
            String str = null;
            if (SV.getThreadType() == 40) {
                this.cyv.setVisibility(0);
                if (SV.vN() != null) {
                    str = SV.vN().thumbnail_url;
                }
            } else {
                this.cyv.setVisibility(8);
                if (SV.vG() != null && SV.vG().size() >= 1) {
                    str = SV.vG().get(0).getOriginalUrl();
                }
            }
            this.duV.startLoad(str, 10, false);
            if (!StringUtils.isNull(SV.vm())) {
                this.duX.setText(SV.vm());
                this.duX.setVisibility(0);
                return;
            }
            this.duX.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d duY;

        public a(d dVar) {
            super(dVar.getView());
            this.duY = dVar;
        }
    }
}
