package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.ay;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.enterForum.square.a.a<com.baidu.tieba.card.a.e, a> {
    private ay aXF;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.card.a.e.aRS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public a b(ViewGroup viewGroup) {
        this.aXF = MD();
        this.aXF.setTag(getTag());
        this.aXE = true;
        this.aXF.gR("c10583");
        return new a(this.aXF);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.e eVar, a aVar) {
        if (aVar.aXG == null) {
            return null;
        }
        TiebaStatic.log("c10582");
        if (this.aXE) {
            aVar.aXG.a(eVar);
            this.aXE = false;
        }
        return aVar.getView();
    }

    private ay MD() {
        ay ayVar = new ay(this.Nw);
        ayVar.H(3000L);
        return ayVar;
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onStart() {
        if (this.aXF != null) {
            this.aXF.xo();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onPause() {
        if (this.aXF != null) {
            this.aXF.xp();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onDestroy() {
        if (this.aXF != null) {
            this.aXF.xp();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void db(int i) {
        if (this.aXF != null) {
            this.aXF.d(this.Nw, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public ay aXG;

        public a(ay ayVar) {
            super(ayVar.getView());
            this.aXG = ayVar;
        }
    }
}
