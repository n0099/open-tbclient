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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView cAV;
    private TbImageView dxF;
    private TextView dxG;
    private TextView dxH;
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
        this.dxF = (TbImageView) this.mRootView.findViewById(f.g.frs_game_left_image);
        this.dxF.setDefaultErrorResource(f.C0146f.icon_morenpic);
        this.dxF.setDefaultResource(f.C0146f.icon_morenpic);
        this.cAV = (ImageView) this.mRootView.findViewById(f.g.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(f.g.frs_game_strategy_title);
        this.dxG = (TextView) this.mRootView.findViewById(f.g.frs_game_strategy_scan_info);
        this.dxH = (TextView) this.mRootView.findViewById(f.g.frs_game_strategy_info_source);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        am.h(this.mTitle, f.d.cp_cont_b);
        am.h(this.dxG, f.d.cp_cont_d);
        am.h(this.dxH, f.d.cp_cont_i);
        am.i(this.mRootView, f.C0146f.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.Tg() != null) {
            bb Tg = bVar.Tg();
            this.mTitle.setText(Tg.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.uc(Tg.getId())) {
                am.h(this.mTitle, f.d.cp_cont_c);
            } else {
                am.h(this.mTitle, f.d.cp_cont_b);
            }
            String A = ap.A(Tg.vb());
            String y = ap.y(Tg.uU());
            if (!StringUtils.isNull(A) && !StringUtils.isNull(y)) {
                this.dxG.setText(String.format(this.mContext.getString(f.j.frs_game_strategy_scan_info), A, y));
            }
            String str = null;
            if (Tg.getThreadType() == 40) {
                this.cAV.setVisibility(0);
                if (Tg.vB() != null) {
                    str = Tg.vB().thumbnail_url;
                }
            } else {
                this.cAV.setVisibility(8);
                if (Tg.vu() != null && Tg.vu().size() >= 1) {
                    str = Tg.vu().get(0).getOriginalUrl();
                }
            }
            this.dxF.startLoad(str, 10, false);
            if (!StringUtils.isNull(Tg.uZ())) {
                this.dxH.setText(Tg.uZ());
                this.dxH.setVisibility(0);
                return;
            }
            this.dxH.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public d dxI;

        public a(d dVar) {
            super(dVar.getView());
            this.dxI = dVar;
        }
    }
}
