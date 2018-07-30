package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView cAY;
    private TbImageView dxI;
    private TextView dxJ;
    private TextView dxK;
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
        this.dxI = (TbImageView) this.mRootView.findViewById(d.g.frs_game_left_image);
        this.dxI.setDefaultErrorResource(d.f.icon_morenpic);
        this.dxI.setDefaultResource(d.f.icon_morenpic);
        this.cAY = (ImageView) this.mRootView.findViewById(d.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_title);
        this.dxJ = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_scan_info);
        this.dxK = (TextView) this.mRootView.findViewById(d.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.h(this.mTitle, d.C0140d.cp_cont_b);
        am.h(this.dxJ, d.C0140d.cp_cont_d);
        am.h(this.dxK, d.C0140d.cp_cont_i);
        am.i(this.mRootView, d.f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.Td() != null) {
            bb Td = bVar.Td();
            this.mTitle.setText(Td.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.tY(Td.getId())) {
                am.h(this.mTitle, d.C0140d.cp_cont_c);
            } else {
                am.h(this.mTitle, d.C0140d.cp_cont_b);
            }
            String A = ap.A(Td.vc());
            String y = ap.y(Td.uV());
            if (!StringUtils.isNull(A) && !StringUtils.isNull(y)) {
                this.dxJ.setText(String.format(this.mContext.getString(d.j.frs_game_strategy_scan_info), A, y));
            }
            String str = null;
            if (Td.getThreadType() == 40) {
                this.cAY.setVisibility(0);
                if (Td.vC() != null) {
                    str = Td.vC().thumbnail_url;
                }
            } else {
                this.cAY.setVisibility(8);
                if (Td.vv() != null && Td.vv().size() >= 1) {
                    str = Td.vv().get(0).getOriginalUrl();
                }
            }
            this.dxI.startLoad(str, 10, false);
            if (!StringUtils.isNull(Td.va())) {
                this.dxK.setText(Td.va());
                this.dxK.setVisibility(0);
                return;
            }
            this.dxK.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d dxL;

        public a(d dVar) {
            super(dVar.getView());
            this.dxL = dVar;
        }
    }
}
