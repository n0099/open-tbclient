package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class e extends PbListView {
    TbPageContext<?> context;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.context = tbPageContext;
        getView().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(f.e.ds16), 0, tbPageContext.getResources().getDimensionPixelSize(f.e.ds74));
        Ar();
        At();
        Au();
        setTextSize(f.e.ds30);
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void Aw() {
        super.Aw();
        setText(this.context.getResources().getString(f.j.list_no_more));
        getView().setVisibility(0);
    }
}
