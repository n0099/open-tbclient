package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.an;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.enterForum.square.a.a<com.baidu.tieba.card.a.d, a> {
    private an aVs;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.card.a.d.aPP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: e */
    public a a(ViewGroup viewGroup) {
        this.aVs = KM();
        this.aVs.setTag(getTag());
        this.aVr = true;
        this.aVs.gK("c10583");
        return new a(this.aVs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.d dVar, a aVar) {
        if (aVar.aVt == null) {
            return null;
        }
        TiebaStatic.log("c10582");
        if (this.aVr) {
            aVar.aVt.a(dVar);
            this.aVr = false;
        }
        return aVar.getView();
    }

    private an KM() {
        an anVar = new an(this.mPageContext);
        anVar.setAutoScrollIntervalTime(3000L);
        return anVar;
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onStart() {
        if (this.aVs != null) {
            this.aVs.wa();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onPause() {
        if (this.aVs != null) {
            this.aVs.wb();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void onDestroy() {
        if (this.aVs != null) {
            this.aVs.wb();
        }
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cK(int i) {
        if (this.aVs != null) {
            this.aVs.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public an aVt;

        public a(an anVar) {
            super(anVar.getView());
            this.aVt = anVar;
        }
    }
}
