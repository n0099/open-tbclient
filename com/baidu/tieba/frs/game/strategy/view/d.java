package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.a<com.baidu.tieba.frs.game.strategy.data.b> {
    private ImageView fJi;
    private TbImageView gyH;
    private TextView gyI;
    private TextView gyJ;
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
        this.gyH = (TbImageView) this.mRootView.findViewById(R.id.frs_game_left_image);
        this.gyH.setDefaultErrorResource(R.drawable.icon_morenpic);
        this.gyH.setDefaultResource(R.drawable.icon_morenpic);
        this.fJi = (ImageView) this.mRootView.findViewById(R.id.frs_game_video_icon);
        this.mTitle = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_title);
        this.gyI = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_scan_info);
        this.gyJ = (TextView) this.mRootView.findViewById(R.id.frs_game_strategy_info_source);
        onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gyI, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gyJ, (int) R.color.cp_cont_a);
        am.setBackgroundResource(this.mRootView, R.drawable.addresslist_item_bg);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_game_strategy_item_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.game.strategy.data.b bVar) {
        if (bVar != null && bVar.axQ() != null) {
            bj axQ = bVar.axQ();
            this.mTitle.setText(axQ.getTitle());
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            if (readThreadHistory != null && readThreadHistory.Jb(axQ.getId())) {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_c);
            } else {
                am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            }
            String numberUniformFormat = aq.numberUniformFormat(axQ.azP());
            String formatTimeShort = aq.getFormatTimeShort(axQ.azG());
            if (!StringUtils.isNull(numberUniformFormat) && !StringUtils.isNull(formatTimeShort)) {
                this.gyI.setText(String.format(this.mContext.getString(R.string.frs_game_strategy_scan_info), numberUniformFormat, formatTimeShort));
            }
            String str = null;
            if (axQ.getThreadType() == 40) {
                this.fJi.setVisibility(0);
                if (axQ.aAo() != null) {
                    str = axQ.aAo().thumbnail_url;
                }
            } else {
                this.fJi.setVisibility(8);
                if (axQ.aAh() != null && axQ.aAh().size() >= 1) {
                    str = axQ.aAh().get(0).getOriginalUrl();
                }
            }
            this.gyH.startLoad(str, 10, false);
            if (!StringUtils.isNull(axQ.azM())) {
                this.gyJ.setText(axQ.azM());
                this.gyJ.setVisibility(0);
                return;
            }
            this.gyJ.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes7.dex */
    public static class a extends v.a {
        public d gyK;

        public a(d dVar) {
            super(dVar.getView());
            this.gyK = dVar;
        }
    }
}
