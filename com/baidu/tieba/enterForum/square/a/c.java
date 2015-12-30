package com.baidu.tieba.enterForum.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.l;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.enterForum.square.a.a<com.baidu.tieba.card.a.h, a> {
    private l aVv;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext, com.baidu.tieba.card.a.h.aPP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: f */
    public a a(ViewGroup viewGroup) {
        this.aVv = new l(this.mPageContext);
        this.aVv.setTag(getTag());
        this.aVr = true;
        this.aVv.an("c10580", "c10581");
        return new a(this.aVv);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.h hVar, a aVar) {
        if (aVar.aVw == null) {
            return null;
        }
        TiebaStatic.log("c10579");
        if (this.aVr) {
            aVar.aVw.a(hVar);
            this.aVr = false;
            return view;
        }
        return view;
    }

    @Override // com.baidu.tieba.enterForum.square.a.a
    public void cK(int i) {
        if (this.aVv != null) {
            this.aVv.onChangeSkinType(this.mPageContext, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends x.a {
        public l aVw;

        public a(l lVar) {
            super(lVar.getView());
            this.aVw = lVar;
        }
    }
}
