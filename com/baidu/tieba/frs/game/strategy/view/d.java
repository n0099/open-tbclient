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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView ezJ;
    private TbImageView fBd;
    private TextView fBe;
    private TextView fBf;
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
        this.fBd = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.fBd.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fBd.setDefaultResource(R.drawable.icon_morenpic);
        this.ezJ = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.fBe = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.fBf = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        al.j(this.mTitle, R.color.cp_cont_b);
        al.j(this.fBe, R.color.cp_cont_d);
        al.j(this.fBf, R.color.cp_btn_a);
        al.k(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.abv() != null) {
            bg abv = bVar.abv();
            this.mTitle.setText(abv.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Ek(abv.getId())) {
                al.j(this.mTitle, R.color.cp_cont_c);
            } else {
                al.j(this.mTitle, R.color.cp_cont_b);
            }
            String aG = ap.aG(abv.adn());
            String aE = ap.aE(abv.adf());
            if (!StringUtils.isNull(aG) && !StringUtils.isNull(aE)) {
                this.fBe.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), aG, aE));
            }
            String str = null;
            if (abv.getThreadType() == 40) {
                this.ezJ.setVisibility(0);
                if (abv.adM() != null) {
                    str = abv.adM().thumbnail_url;
                }
            } else {
                this.ezJ.setVisibility(8);
                if (abv.adF() != null && abv.adF().size() >= 1) {
                    str = abv.adF().get(0).getOriginalUrl();
                }
            }
            this.fBd.startLoad(str, 10, false);
            if (!StringUtils.isNull(abv.adk())) {
                this.fBf.setText(abv.adk());
                this.fBf.setVisibility(0);
                return;
            }
            this.fBf.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public d fBg;

        public a(d dVar) {
            super(dVar.getView());
            this.fBg = dVar;
        }
    }
}
