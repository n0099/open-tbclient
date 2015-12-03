package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.a.a.i;
import com.baidu.tieba.a.p;
/* loaded from: classes.dex */
public class f extends a<i, x.a> {
    private p aRG;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext, i.aMW);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected x.a a(ViewGroup viewGroup) {
        this.aRG = new p(this.mPageContext);
        this.aRB = true;
        this.aRG.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND);
        this.aRG.n("c10578", "c10577", "c10576");
        return new x.a(this.aRG.getView());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, i iVar, x.a aVar) {
        if (this.aRG == null) {
            return null;
        }
        TiebaStatic.log("c10575");
        if (this.aRB) {
            this.aRG.a(iVar);
            this.aRB = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cZ(int i) {
        if (this.aRG != null) {
            this.aRG.onChangeSkinType(this.mPageContext, i);
        }
    }
}
