package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.a.k;
/* loaded from: classes.dex */
public class c extends a<com.baidu.tieba.a.a.f, x.a> {
    private k aRD;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.a.a.f.aML);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected x.a a(ViewGroup viewGroup) {
        this.aRD = new k(this.mPageContext);
        this.aRB = true;
        this.aRD.ao("c10580", "c10581");
        return new x.a(this.aRD.getView());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.a.a.f fVar, x.a aVar) {
        if (this.aRD == null) {
            return null;
        }
        TiebaStatic.log("c10579");
        if (this.aRB) {
            this.aRD.a(fVar);
            this.aRB = false;
        }
        return aVar.getView();
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cZ(int i) {
        if (this.aRD != null) {
            this.aRD.onChangeSkinType(this.mPageContext, i);
        }
    }
}
