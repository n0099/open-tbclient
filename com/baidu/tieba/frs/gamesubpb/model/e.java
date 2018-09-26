package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e extends PbListView {
    TbPageContext<?> context;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(e.C0141e.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(e.C0141e.ds74));
        BE();
        BG();
        BH();
        setTextSize(e.C0141e.ds30);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void BJ() {
        super.BJ();
        setText(this.context.getResources().getString(e.j.list_no_more));
        getView().setVisibility(0);
    }
}
