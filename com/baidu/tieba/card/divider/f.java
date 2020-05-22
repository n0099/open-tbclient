package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f extends com.baidu.tieba.card.b<e> {
    private View gIA;
    private View gIz;
    private TextView mTitle;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.gIz = getView().findViewById(R.id.card_divider_top_margin);
        this.mTitle = (TextView) getView().findViewById(R.id.card_divider_tv);
        this.gIA = getView().findViewById(R.id.bottom_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.gIA, R.color.cp_bg_line_c);
            am.setBackgroundColor(this.gIz, R.color.cp_bg_line_c);
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
                this.gIz.setVisibility(0);
            } else {
                this.gIz.setVisibility(8);
            }
            this.mTitle.setText(eVar.title);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
