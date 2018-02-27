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
    private ImageView cYR;
    private TbImageView dOI;
    private TextView dOJ;
    private TextView dOK;
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
        this.dOI = (TbImageView) this.mRootView.findViewById(d.g.frs_game_left_image);
        this.dOI.setDefaultErrorResource(d.f.icon_morenpic);
        this.dOI.setDefaultResource(d.f.icon_morenpic);
        this.cYR = (ImageView) this.mRootView.findViewById(d.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_title);
        this.dOJ = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_scan_info);
        this.dOK = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.r(this.mTitle, d.C0141d.cp_cont_b);
        aj.r(this.dOJ, d.C0141d.cp_cont_d);
        aj.r(this.dOK, d.C0141d.cp_cont_i);
        aj.s(this.mRootView, d.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.WD() != null) {
            bd WD = bVar.WD();
            this.mTitle.setText(WD.getTitle());
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.sW(WD.getId())) {
                aj.r(this.mTitle, d.C0141d.cp_cont_c);
            } else {
                aj.r(this.mTitle, d.C0141d.cp_cont_b);
            }
            String C = am.C(WD.zg());
            String A = am.A(WD.za());
            if (!StringUtils.isNull(C) && !StringUtils.isNull(A)) {
                this.dOJ.setText(String.format(this.mContext.getString(d.j.frs_game_strategy_scan_info), C, A));
            }
            String str = null;
            if (WD.getThreadType() == 40) {
                this.cYR.setVisibility(0);
                if (WD.zF() != null) {
                    str = WD.zF().thumbnail_url;
                }
            } else {
                this.cYR.setVisibility(8);
                if (WD.zy() != null && WD.zy().size() >= 1) {
                    str = WD.zy().get(0).getOriginalUrl();
                }
            }
            this.dOI.startLoad(str, 10, false);
            if (!StringUtils.isNull(WD.ze())) {
                this.dOK.setText(WD.ze());
                this.dOK.setVisibility(0);
                return;
            }
            this.dOK.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends r.a {
        public e dOL;

        public a(e eVar) {
            super(eVar.getView());
            this.dOL = eVar;
        }
    }
}
