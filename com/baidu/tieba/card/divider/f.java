package com.baidu.tieba.card.divider;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f extends com.baidu.tieba.card.b<e> {
    private View iwd;
    private View iwe;
    private TextView mTitle;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
        getView().setOnClickListener(this);
        this.iwd = getView().findViewById(R.id.card_divider_top_margin);
        this.mTitle = (TextView) getView().findViewById(R.id.card_divider_tv);
        this.iwe = getView().findViewById(R.id.bottom_line);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0109);
            ao.setBackgroundColor(this.iwe, R.color.CAM_X0204);
            ao.setBackgroundColor(this.iwd, R.color.CAM_X0204);
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
                this.iwd.setVisibility(0);
            } else {
                this.iwd.setVisibility(8);
            }
            this.mTitle.setText(eVar.title);
            onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
