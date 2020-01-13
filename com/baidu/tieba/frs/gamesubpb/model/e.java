package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class e extends PbListView {
    TbPageContext<?> context;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds74));
        setLineVisible();
        setLineNoMargin();
        setLightLine();
        setTextSize(R.dimen.ds30);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void endLoadData() {
        super.endLoadData();
        setText(this.context.getResources().getString(R.string.list_no_more));
        getView().setVisibility(0);
    }
}
