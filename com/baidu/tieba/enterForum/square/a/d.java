package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.a.m;
/* loaded from: classes.dex */
public class d extends a<com.baidu.tieba.a.a.g, x.a> {
    private m aRE;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.a.a.g.aML);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected x.a a(ViewGroup viewGroup) {
        this.aRE = new m(this.mPageContext);
        this.aRB = true;
        this.aRE.ao("c10573", "c10574");
        return new x.a(this.aRE.getView());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.a.a.g gVar, x.a aVar) {
        if (this.aRE == null) {
            return null;
        }
        TiebaStatic.log("c10572");
        if (this.aRB) {
            this.aRE.a(gVar);
            this.aRB = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cZ(int i) {
        if (this.aRE != null) {
            this.aRE.onChangeSkinType(this.mPageContext, i);
        }
    }
}
