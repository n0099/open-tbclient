package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.a.a.j;
import com.baidu.tieba.a.q;
/* loaded from: classes.dex */
public class g extends a<j, x.a> {
    private q aRH;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext, j.aMX);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected x.a a(ViewGroup viewGroup) {
        this.aRH = new q(this.mPageContext);
        this.aRB = true;
        this.aRH.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_TOP);
        this.aRH.n("c10569", "c10568", "c10567");
        return new x.a(this.aRH.getView());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, j jVar, x.a aVar) {
        if (this.aRH == null) {
            return null;
        }
        TiebaStatic.log("c10570");
        if (this.aRB) {
            this.aRH.a(jVar);
            this.aRB = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cZ(int i) {
        if (this.aRH != null) {
            this.aRH.onChangeSkinType(this.mPageContext, i);
        }
    }
}
