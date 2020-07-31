package com.baidu.tieba.ala.alasquare.live_tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.h;
import com.baidu.tieba.ala.alasquare.live_tab.view.i;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.ala.alasquare.live_tab.b.e, i> {
    private boolean fsW;
    private h fsZ;
    private TbPageContext mPageContext;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.ala.alasquare.live_tab.b.e.fte);
        this.fsW = false;
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: I */
    public i b(ViewGroup viewGroup) {
        this.fsZ = new h(this.mPageContext, viewGroup);
        this.fsZ.kc(this.fsW);
        return new i(this.fsZ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.live_tab.b.e eVar, i iVar) {
        if (iVar == null || iVar.fsZ == null) {
            return null;
        }
        iVar.fsZ.a(eVar);
        iVar.fsZ.onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return iVar.getView();
    }

    public void kc(boolean z) {
        this.fsW = z;
    }
}
