package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class f extends com.baidu.tieba.card.b<e> {
    private View hoe;
    private View hof;
    private TextView mTitle;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.hoe = getView().findViewById(R.id.card_divider_top_margin);
        this.mTitle = (TextView) getView().findViewById(R.id.card_divider_tv);
        this.hof = getView().findViewById(R.id.bottom_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_d);
            ap.setBackgroundColor(this.hof, R.color.cp_bg_line_c);
            ap.setBackgroundColor(this.hoe, R.color.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_divider_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(e eVar) {
        if (eVar != null) {
            if (eVar.needTopMargin) {
                this.hoe.setVisibility(0);
            } else {
                this.hoe.setVisibility(8);
            }
            this.mTitle.setText(eVar.title);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
