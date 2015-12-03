package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.a.r;
/* loaded from: classes.dex */
public class b extends a<com.baidu.tieba.a.a.c, x.a> {
    private r aRC;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.a.a.c.aML);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected x.a a(ViewGroup viewGroup) {
        this.aRC = Kt();
        this.aRB = true;
        this.aRC.gC("c10583");
        return new x.a(this.aRC.getView());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.a.a.c cVar, x.a aVar) {
        if (this.aRC == null) {
            return null;
        }
        TiebaStatic.log("c10582");
        if (this.aRB) {
            this.aRC.a(cVar);
            this.aRB = false;
        }
        return aVar.getView();
    }

    private r Kt() {
        r rVar = new r(this.mPageContext);
        rVar.setAutoScrollIntervalTime(3000L);
        return rVar;
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onStart() {
        if (this.aRC != null) {
            this.aRC.wp();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onPause() {
        if (this.aRC != null) {
            this.aRC.wq();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onDestroy() {
        if (this.aRC != null) {
            this.aRC.wq();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cZ(int i) {
        if (this.aRC != null) {
            this.aRC.onChangeSkinType(this.mPageContext, i);
        }
    }
}
