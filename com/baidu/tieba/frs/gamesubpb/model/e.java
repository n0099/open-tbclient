package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e extends PbListView {
    TbPageContext<?> context;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(d.e.ds74));
        Ec();
        Ee();
        Ef();
        setTextSize(d.e.ds30);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void Eh() {
        super.Eh();
        setText(this.context.getResources().getString(d.j.list_no_more));
        getView().setVisibility(0);
    }
}
