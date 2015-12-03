package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.a.o;
/* loaded from: classes.dex */
public class e extends a<com.baidu.tieba.a.a.h, x.a> {
    private o aRF;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.a.a.h.aML);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected x.a a(ViewGroup viewGroup) {
        this.aRF = new o(this.mPageContext);
        this.aRF.setFrom(FrsActivityConfig.FRS_FROM_SQUARE_HOT);
        this.aRF.n("c10590", "c10589", "c10588");
        this.aRB = true;
        return new x.a(this.aRF.getView());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.a.a.h hVar, x.a aVar) {
        if (this.aRF == null) {
            return null;
        }
        TiebaStatic.log("c10571");
        if (this.aRB) {
            this.aRF.a(hVar);
            this.aRB = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cZ(int i) {
        if (this.aRF != null) {
            this.aRF.onChangeSkinType(this.mPageContext, i);
        }
    }
}
