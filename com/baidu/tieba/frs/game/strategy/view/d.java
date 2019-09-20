package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView eGv;
    private TbImageView fIE;
    private TextView fIF;
    private TextView fIG;
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
        this.fIE = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.fIE.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.fIE.setDefaultResource(R.drawable.icon_morenpic);
        this.eGv = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.fIF = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.fIG = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.j(this.mTitle, R.color.cp_cont_b);
        am.j(this.fIF, R.color.cp_cont_d);
        am.j(this.fIG, R.color.cp_cont_a);
        am.k(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.acC() != null) {
            bh acC = bVar.acC();
            this.mTitle.setText(acC.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Fy(acC.getId())) {
                am.j(this.mTitle, R.color.cp_cont_c);
            } else {
                am.j(this.mTitle, R.color.cp_cont_b);
            }
            String aH = aq.aH(acC.aeu());
            String aF = aq.aF(acC.aem());
            if (!StringUtils.isNull(aH) && !StringUtils.isNull(aF)) {
                this.fIF.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), aH, aF));
            }
            String str = null;
            if (acC.getThreadType() == 40) {
                this.eGv.setVisibility(0);
                if (acC.aeT() != null) {
                    str = acC.aeT().thumbnail_url;
                }
            } else {
                this.eGv.setVisibility(8);
                if (acC.aeM() != null && acC.aeM().size() >= 1) {
                    str = acC.aeM().get(0).getOriginalUrl();
                }
            }
            this.fIE.startLoad(str, 10, false);
            if (!StringUtils.isNull(acC.aer())) {
                this.fIG.setText(acC.aer());
                this.fIG.setVisibility(0);
                return;
            }
            this.fIG.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes4.dex */
    public static class a extends v.a {
        public d fIH;

        public a(d dVar) {
            super(dVar.getView());
            this.fIH = dVar;
        }
    }
}
